package task_4.oop2;

public class MusicPlayer implements Playable {
    private boolean isPlaying;
    private String currentTrack;
    private int volume;

    public MusicPlayer() {
        this.isPlaying = false;
        this.currentTrack = null;
        this. volume = 10;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public int getVolume() {
        return volume;
    }

    public String getCurrentTrack() {
        return currentTrack;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setCurrentTrack(String currentTrack) {
        this.currentTrack = currentTrack;
    }

    public void stop() {
        if (!isPlaying) {
            System.out.println("Nothing is playing");
            return;
        }
        isPlaying = false;
        System.out.println("Stopped");
    }

    @Override
    public void play() {
        if (currentTrack == null) {
            System.out.println("Cannot play");
            return;
        }

        if (isPlaying) {
            System.out.println("Already playing: " + currentTrack);
            return;
        }

        isPlaying = true;
        System.out.println("Playing music: " + currentTrack + " (volume=" + volume + ")");
    }

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        player.play();

        player.setCurrentTrack("Em cua ngay hom qua");
        player.setVolume(70);
        player.play();
        player.play();
        player.stop();
    }
}
