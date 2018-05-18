package music;

public class Synchronizer {
	public Synchronizer(boolean firstVoiceFlag) {
		super();
		this.firstVoiceFlag = firstVoiceFlag;
	}

	private boolean firstVoiceFlag;

	public synchronized void singFirstVoice(String lyrics, int delay) {
		while (!firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	public synchronized void singSecondVoice(String lyrics, int delay) {
		while (firstVoiceFlag) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		sing(lyrics, delay);
	}

	private synchronized void sing(String lyrics, int delay) {
		System.out.println(lyrics);
		try {
			wait(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		firstVoiceFlag = !firstVoiceFlag;
		notifyAll();
	}
}
