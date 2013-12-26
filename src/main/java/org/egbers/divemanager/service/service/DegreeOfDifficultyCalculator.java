package org.egbers.divemanager.service.service;

import static org.egbers.divemanager.service.domain.Approach.BACKWARD;
import static org.egbers.divemanager.service.domain.Approach.FORWARD;
import static org.egbers.divemanager.service.domain.Approach.INWARD;
import static org.egbers.divemanager.service.domain.Approach.REVERSE;
import static org.egbers.divemanager.service.domain.Board.FIVE;
import static org.egbers.divemanager.service.domain.Board.ONE;
import static org.egbers.divemanager.service.domain.Board.SEVEN;
import static org.egbers.divemanager.service.domain.Board.TEN;
import static org.egbers.divemanager.service.domain.Board.THREE;
import static org.egbers.divemanager.service.domain.Position.FREE;
import static org.egbers.divemanager.service.domain.Position.PIKE;
import static org.egbers.divemanager.service.domain.Position.STRAIGHT;
import static org.egbers.divemanager.service.domain.Position.TUCK;

import org.egbers.divemanager.service.domain.Dive;

public class DegreeOfDifficultyCalculator {
	public Float calculate(final Dive dive) {
		Float dd = calculateA(dive) + calculateB(dive) + calculateC(dive) + calculateD(dive) + calculateE(dive);
		return (float) Math.round(dd * 10) / 10;
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
			} else if (dive.getSomersaults() == 4.0F) {
				return 3.3F;
			} else if (dive.getSomersaults() == 4.5F) {
				return 3.8F;
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

	// TODO Add FLY Position and ARM Approach
	Float calculateB(final Dive dive) {
		if (dive.getApproach() == FORWARD) {
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
			} else if (dive.getSomersaults() == 4.0F || dive.getSomersaults() == 4.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.4F;
				}
			}
		} else if (dive.getApproach() == BACKWARD) {
			if (dive.getSomersaults() == 0F || dive.getSomersaults() == 0.5F || dive.getSomersaults() == 1F) {
				if (dive.getPosition() == TUCK) {
					return 0.1F;
				} else if (dive.getPosition() == PIKE) {
					return 0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.1F;
				}
			} else if (dive.getSomersaults() == 1.5F || dive.getSomersaults() == 2F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.5F;
				} else if (dive.getPosition() == FREE) {
					return -0.1F;
				}
			} else if (dive.getSomersaults() == 2.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.1F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.7F;
				} else if (dive.getPosition() == FREE) {
					return -0.1F;
				}
			} else if (dive.getSomersaults() == 3F || dive.getSomersaults() == 3.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.0F;
				}
			}
		} else if (dive.getApproach() == REVERSE) {
			if (dive.getSomersaults() == 0F || dive.getSomersaults() == 0.5F || dive.getSomersaults() == 1F) {
				if (dive.getPosition() == TUCK) {
					return 0.1F;
				} else if (dive.getPosition() == PIKE) {
					return 0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.1F;
				}
			} else if (dive.getSomersaults() == 1.5F || dive.getSomersaults() == 2F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.6F;
				} else if (dive.getPosition() == FREE) {
					return -0.1F;
				}
			} else if (dive.getSomersaults() == 2.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.6F;
				} else if (dive.getPosition() == FREE) {
					return -0.2F;
				}
			} else if (dive.getSomersaults() == 3F || dive.getSomersaults() == 3.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.0F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == FREE) {
					return 0.0F;
				}
			}
		} else if (dive.getApproach() == INWARD) {
			if (dive.getSomersaults() == 0 || dive.getSomersaults() == 0.5F || dive.getSomersaults() == 1F) {
				if (dive.getPosition() == TUCK) {
					return -0.3F;
				} else if (dive.getPosition() == PIKE) {
					return -0.2F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.1F;
				} else if (dive.getPosition() == FREE) {
					return -0.1F;
				}
			} else if (dive.getSomersaults() == 1.5F || dive.getSomersaults() == 2F) {
				if (dive.getPosition() == TUCK) {
					return 0.1F;
				} else if (dive.getPosition() == PIKE) {
					return 0.3F;
				} else if (dive.getPosition() == STRAIGHT) {
					return 0.8F;
				} else if (dive.getPosition() == FREE) {
					return 0.2F;
				}
			} else if (dive.getSomersaults() == 2.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.2F;
				} else if (dive.getPosition() == PIKE) {
					return 0.5F;
				} else if (dive.getPosition() == FREE) {
					return 0.4F;
				}
			} else if (dive.getSomersaults() == 3F || dive.getSomersaults() == 3.5F) {
				if (dive.getPosition() == TUCK) {
					return 0.3F;
				} else if (dive.getPosition() == PIKE) {
					return 0.6F;
				}
			}
		}
		return null;
	}

	// TODO Add ARM
	Float calculateC(final Dive dive) {
		if (dive.getTwists() == 0.0F) {
			return 0.0F;
		}

		if (dive.getTwists() == 0.5F) {
			if (dive.getApproach() == FORWARD) {
				return 0.4F;
			} else if (dive.getApproach() == BACKWARD || dive.getApproach() == REVERSE) {
				if (dive.getSomersaults() <= 1F) {
					return 0.2F;
				} else if (dive.getSomersaults() <= 2F) {
					return 0.4F;
				} else {
					return 0.0F;
				}
			} else if (dive.getApproach() == INWARD) {
				if (dive.getSomersaults() <= 1F) {
					return 0.2F;
				} else if (dive.getSomersaults() <= 2F) {
					return 0.4F;
				} else if (dive.getSomersaults() == 2.5F) {
					return 0.2F;
				} else if (dive.getSomersaults() <= 3.5F) {
					return 0.4F;
				}
			}
		} else if (dive.getTwists() == 1.0F) {
			if (dive.getApproach() == FORWARD) {
				return 0.6F;
			} else {
				return 0.4F;
			}
		} else if (dive.getTwists() == 1.5F) {
			return 0.8F;
		} else if (dive.getTwists() == 2.0F) {
			if (dive.getApproach() == FORWARD) {
				return 1.0F;
			} else {
				return 0.8F;
			}
		} else if (dive.getTwists() == 2.5F) {
			return 1.2F;
		} else if (dive.getTwists() == 3.0F) {
			if (dive.getApproach() == INWARD || dive.getApproach() == FORWARD) {
				return 1.5F;
			} else {
				return 1.4F;
			}
		} else if (dive.getTwists() == 3.5F) {
			return 1.6F;
		} else if (dive.getTwists() == 4.0F) {
			return 1.8F;
		} else if (dive.getTwists() == 4.5F) {
			return 2.0F;
		}

		return null;
	}

	Float calculateD(final Dive dive) {
		if (dive.getApproach() == FORWARD) {
			if (dive.getSomersaults() >= 4.0F) {
				return 0.5F;
			} else {
				return 0.0F;
			}
		} else if (dive.getApproach() == BACKWARD) {
			return 0.2F;
		} else if (dive.getApproach() == REVERSE) {
			return 0.3F;
		} else if (dive.getApproach() == INWARD) {
			if (dive.getSomersaults() <= 1.0F) {
				if (dive.getHeight() == ONE || dive.getHeight() == FIVE) {
					return 0.6F;
				} else if (dive.getHeight() == THREE || dive.getHeight() == SEVEN) {
					return 0.3F;
				} else if (dive.getHeight() == TEN) {
					return 0.3F;
				}
			} else {
				if (dive.getHeight() == ONE || dive.getHeight() == FIVE) {
					return 0.5F;
				} else if (dive.getHeight() == THREE || dive.getHeight() == SEVEN) {
					return 0.3F;
				} else if (dive.getHeight() == TEN) {
					return 0.2F;
				}
			}
		}

		return null;
	}

	Float calculateE(final Dive dive) {
		if (dive.getTwists() > 0) {
			return 0.0F;
		}

		if (dive.getApproach() == FORWARD || dive.getApproach() == INWARD) {
			if (dive.getSomersaults() == 1.0F) {
				return 0.1F;
			} else if (dive.getSomersaults() == 2.0F || dive.getSomersaults() == 3 || dive.getSomersaults() == 4) {
				return 0.2F;
			} else {
				return 0.0F;
			}
		} else if (dive.getApproach() == BACKWARD || dive.getApproach() == REVERSE) {
			if (dive.getSomersaults() == 0.5F) {
				return 0.1F;
			} else if (dive.getSomersaults() == 1.5F) {
				return 0.2F;
			} else if (dive.getSomersaults() == 2.5F) {
				return 0.3F;
			} else if (dive.getSomersaults() == 3.5F) {
				return 0.4F;
			} else {
				return 0.0F;
			}
		}

		return null;
	}
}
