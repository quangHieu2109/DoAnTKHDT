package models;

public interface TypeGame {
	void run(Game game);

	void danBai();

	void chiaBai();

	void registerObs(ObseverGame obs);

	void notifyObsGame();

	void rutBai();

	void choiLai();

	String gameOver();
}
