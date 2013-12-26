package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.THREE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;

import org.egbers.divemanager.service.domain.Approach;
import org.egbers.divemanager.service.domain.Dive;

public class DegreeOfDifficultyCalculator {
	public Float calculate(final Dive dive) {

		return null;
	}

	// TODO Add 10 Meter
	Float calculateA(final Dive dive) {
		if (dive.getHeight() == ONE || dive.getHeight() == FIVE) {
			if (dive.getSomersaults() == 0) {
				return .9F;
			} else if (dive.getSomersaults() == .5F) {
				return 1.1F;
			} else if (dive.getSomersaults() == 1.0F) {
				return 1.2F;
			} else if (dive.getSomersaults() == 1.5F) {
				return 1.6F;
			} else if (dive.getSomersaults() == 2.0F) {
				return 2.0F;
			} else if (dive.getSomersaults() == 2.5F) {
				return 2.4F;
			} else if (dive.getSomersaults() == 3.0F) {
				return 2.7F;
			} else if (dive.getSomersaults() == 3.5F) {
				return 3.0F;
			}
		} else if (dive.getHeight() == THREE || dive.getHeight() == SEVEN) {
			if (dive.getSomersaults() == 0) {
				return 1.0F;
			} else if (dive.getSomersaults() == .5F) {
				return 1.3F;
			} else if (dive.getSomersaults() == 1.0F) {
				return 1.3F;
			} else if (dive.getSomersaults() == 1.5F) {
				return 1.5F;
			} else if (dive.getSomersaults() == 2.0F) {
				return 1.8F;
			} else if (dive.getSomersaults() == 2.5F) {
				return 2.2F;
			} else if (dive.getSomersaults() == 3.0F) {
				return 2.3F;
			} else if (dive.getSomersaults() == 3.5F) {
				return 2.8F;
			} else if (dive.getSomersaults() == 4.5F) {
				return 3.5F;
			}
		}
		return null;
	}

	// TODO Add FLY Position
	Float calculateB(final Dive dive) {
		if (dive.getApproach() == Approach.FORWARD) {
			if (dive.getSomersaults() == 0F || dive.getSomersaults() == .5F || dive.getSomersaults() == 1F) {
				if (dive.getPosition() == TUCK) {
					return 0.1F;
				} else if (dive.getPosition() == PIKE) {
					return 0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.1F;
				}
			} else if (dive.getSomersaults() == 1.5F || dive.getSomersaults() == 2.0F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.1F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.4F;
				} else if (dive.getPosition() == FREE) {
					return 0.0F;
				}
			} else if (dive.getSomersaults() == 2.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.6F;
				} else if (dive.getPosition() == FREE) {
					return 0.0F;
				}
			} else if (dive.getSomersaults() == 3.0F || dive.getSomersaults() == 3.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.0F;
				}
			} else if (dive.getSomersaults() == 4.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.4F;
				}
			}
		}
		return null;
	}
}
