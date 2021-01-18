package tv.codely.mooc.steps.domain.video;

import java.util.Objects;

import tv.codely.mooc.steps.domain.Step;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.shared.domain.VideoUrl;

public final class VideoStep extends Step {
	private final VideoUrl videoUrl;
	private final VideoStepText text;

	public VideoStep(StepId id, StepTitle title, VideoUrl videoUrl, VideoStepText text) {
		super(id, title);

		this.videoUrl = videoUrl;
		this.text = text;
	}

	private VideoStep() {
		super(null, null);

		this.videoUrl = null;
		this.text = null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(text, videoUrl);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (!(obj instanceof VideoStep)) {
			return false;
		}
		VideoStep other = (VideoStep) obj;
		return Objects.equals(text, other.text) && Objects.equals(videoUrl, other.videoUrl);
	}
}
