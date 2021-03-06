/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package javaappsoundtest;

import java.io.*;
import javax.sound.sampled.*;

/**
 *
 * @author imdc
 */
public class WAVFileReader {
    private AudioInputStream audioInputStream;
    private AudioFormat format;
    
    public WAVFileReader ( File file ) throws UnsupportedAudioFileException, IOException {
        audioInputStream = AudioSystem.getAudioInputStream(file);
        format = audioInputStream.getFormat();
    }
    
    public AudioFormat getFormat() {
        return format;
    }
    
    public long getSampleCount() {
        long total = ( audioInputStream.getFrameLength() * format.getFrameSize() * 8 ) / format.getSampleSizeInBits();
        return total / format.getChannels();
    }
    
    public void getInterleavedSamples ( long begin, long end, double[] samples ) throws IOException, IllegalArgumentException {
        long nbSamples = end - begin;
        // nbBytes = nbSamples * sampleSizeinByte * nbChannels
        long nbBytes = nbSamples * ( format.getSampleSizeInBits() / 8 ) * format.getChannels();
        if ( nbBytes > Integer.MAX_VALUE )
            throw new IllegalArgumentException("too many samples");
        // allocate a byte buffer
        byte[] inBuffer = new byte[(int) nbBytes];
        // read bytes from audio file
        audioInputStream.read ( inBuffer, 0, inBuffer.length );
        // decode bytes into samples. Supported encodings are:
        // PCM-SIGNED, PCM-UNSIGNED, A-LAW, U-LAW
        decodeBytes(inBuffer, samples);
    }
    
    // Extract samples of a particular channel from interleavedSamples and
    // copy them into channelSamples
    public void getChannelSamples ( int channel, double[] interleavedSamples, double[] channelSamples ) {
        int nbChannels = format.getChannels();
        for ( int i = 0; i < channelSamples.length; i++ ) {
            channelSamples[i] = interleavedSamples[nbChannels * i + channel];
        }
    }
    
    // Convenience method. Extract left and right channels for common stereo
    // files. leftSamples and rightSamples must be of size getSampleCount()
    public void getStereoSamples ( double[] leftSamples, double[] rightSamples ) throws IOException {
        long sampleCount = getSampleCount();
        double[] interleavedSamples = new double[(int) sampleCount * 2];
        getInterleavedSamples ( 0, sampleCount, interleavedSamples );
        for ( int i = 0; i < leftSamples.length; i++ ) {
            leftSamples[i] = interleavedSamples[2 * i];
            rightSamples[i] = interleavedSamples[2 * i + 1];
        }        
    }
    
    // Private. Decode bytes of audioBytes into audioSamples
    private void decodeBytes ( byte[] audioBytes, double[] audioSamples ) {
        int sampleSizeInBytes = format.getSampleSizeInBits() / 8;
        int[] sampleBytes = new int[sampleSizeInBytes];
        int k = 0; // index in audioBytes
        for ( int i = 0; i < audioSamples.length; i++ ) {
            // collect sample byte in big-endian order
            if ( format.isBigEndian() ) {
                // bytes start with MSB
                for ( int j = 0; j < sampleSizeInBytes; j++ ) {
                    sampleBytes[j] = audioBytes[k++];
                }
            } else {
                // bytes start with LSB
                for ( int j = sampleSizeInBytes - 1; j >= 0; j-- ) {
                    sampleBytes[j] = audioBytes[k++];
                    if ( sampleBytes[j] != 0 )
                        j = j + 0;
                }
            }
            // get integer value from bytes
            int ival = 0;
            for ( int j = 0; j < sampleSizeInBytes; j++ ) {
                ival += sampleBytes[j];
                if ( j < sampleSizeInBytes - 1 ) ival <<= 8;
            }
            // decode value
            double ratio = Math.pow ( 2., format.getSampleSizeInBits() - 1 );
            double val = ( (double) ival ) / ratio;
            audioSamples[i] = val;
        }
    }
}
