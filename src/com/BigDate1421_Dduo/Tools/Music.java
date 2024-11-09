package com.BigDate1421_Dduo.Tools;

import javax.sound.midi.*;

public class Music {
    public static void music()
    {
        //异常 处理
        try {
            //音乐接口
            //用open方法打开对象
            //准备接收音乐序列数据准备进行播放
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            //表示音乐序列中的时序信息
            Sequence sequence = new Sequence(Sequence.PPQ, 4);

            //表示不同乐器或声部的音轨
            Track track = sequence.createTrack();

            // 定义音符和节奏
            int[] notes = {60, 62, 64,
                    60, 60, 62,
                    64, 60, 64,
                    65, 67, 64,
                    65, 67, 67,
                    69, 67, 65,
                    64, 60, 67,
                    69, 67, 65,
                    64, 60, 60,
                    67, 60, 60,
                    67, 60};
            int[] durations = {
                    4, 4, 4,
                    4, 4, 4,
                    4, 4, 4,
                    4, 8, 4,
                    4, 8, 3,
                    1, 3, 1,
                    4, 4, 3,1, 3,1, 4, 4, 4, 4, 8, 4, 4, 8,
            };


            for (int i = 0; i < notes.length; i++) {
                ShortMessage noteOn = new ShortMessage(ShortMessage.NOTE_ON, 0, notes[i], 127);
                MidiEvent noteOnEvent = new MidiEvent(noteOn, i * 4);
                track.add(noteOnEvent);

                ShortMessage noteOff = new ShortMessage(ShortMessage.NOTE_OFF, 0, notes[i], 127);
                MidiEvent noteOffEvent = new MidiEvent(noteOff, (i + 1) * 4);
                track.add(noteOffEvent);

                //添加节奏延迟
                Thread.sleep(durations[i] * 1);
            }

            sequencer.setSequence(sequence);

            //开始播放
            sequencer.start();

            //播放完成
            //sequencer.close();

            //退出程序
            //System.exit(0);

        }
        //异常处理机制
        //当try代码出现异常时,即音乐无法播放,打印异常信息
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            System.out.println("音乐开始播放");
        }
    }
}
