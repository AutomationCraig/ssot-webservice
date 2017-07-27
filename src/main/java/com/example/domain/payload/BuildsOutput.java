package com.example.domain.payload;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Build;
import com.example.domain.TestCase;
import com.example.domain.prettyOutputs.PrettyBuild;

public class BuildsOutput {
	
	private List<PrettyBuild> builds;
	
	public BuildsOutput(List<Build> builds) {
		super();
		List<PrettyBuild> allPrettyBuilds = new ArrayList<PrettyBuild>();
		for (Build build : builds) {
			PrettyBuild prettyBuild = new PrettyBuild(build);
			allPrettyBuilds.add(prettyBuild);
		}
		this.builds = allPrettyBuilds;
	}


	public List<PrettyBuild> getProjects() {
		return builds;
	}

	
}
