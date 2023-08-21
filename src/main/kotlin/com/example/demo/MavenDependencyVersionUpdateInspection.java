package com.example.demo;

import com.intellij.util.xml.DomFileElement;
import com.intellij.util.xml.highlighting.DomElementAnnotationHolder;
import com.intellij.util.xml.highlighting.DomElementsInspection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.idea.maven.dom.DependencyConflictId;
import org.jetbrains.idea.maven.dom.MavenDomProjectProcessorUtils;
import org.jetbrains.idea.maven.dom.generate.GenerateManagedDependencyAction;
import org.jetbrains.idea.maven.dom.model.MavenDomDependency;
import org.jetbrains.idea.maven.dom.model.MavenDomProjectModel;
import org.jetbrains.idea.maven.indices.MavenArtifactSearchResult;
import org.jetbrains.idea.maven.indices.MavenArtifactSearcher;
import org.jetbrains.idea.maven.model.MavenArtifactInfo;

import java.util.List;
import java.util.Map;

public class MavenDependencyVersionUpdateInspection extends DomElementsInspection<MavenDomProjectModel> {
//    public MavenDependencyVersionUpdateInspection (
//            Class<? extends MavenDomProjectModel> domClass,
//            @NotNull Class<? extends MavenDomProjectModel>... additionalClasses
//    ) {
//        super(domClass, additionalClasses);
//    }
    public MavenDependencyVersionUpdateInspection() {
        super(MavenDomProjectModel.class);
    }

    @Override
    public void checkFileElement(DomFileElement<MavenDomProjectModel> domFileElement, DomElementAnnotationHolder holder) {

        //final Map<DependencyConflictId, MavenDomDependency> dependencyMap =GenerateManagedDependencyAction.collectManagingDependencies(domFileElement.getRootElement());

        MavenDomProjectModel pomModel = domFileElement.getRootElement();
        List<MavenDomDependency> dependencyList = pomModel.getDependencies().getDependencies();

        MavenArtifactSearcher searcher = new MavenArtifactSearcher();

        for (MavenDomDependency dependency : dependencyList) {
            String groupId = dependency.getGroupId().getStringValue();
            String artifactId = dependency.getArtifactId().getStringValue();
            //searcher.search(domFileElement.getModule().getProject(), "groupId:artifactId:version",)
            List<MavenArtifactSearchResult> results = searcher.search(domFileElement.getModule().getProject(), groupId +":" + artifactId + ":",1000);
            for (MavenArtifactSearchResult result: results) {
//                MavenArtifactInfo mavenArtifactInfo  = result.versions.get(0);
//                if (mavenArtifactInfo.getGroupId().equals(groupId) && mavenArtifactInfo.getArtifactId().equals(artifactId)) {
//                    String latestVersion = mavenArtifactInfo.getVersion();
//                    System.out.println("latest version of the "+ groupId + ":" + artifactId + " is " + latestVersion);
//                }
            }
        }

        //MavenDomProjectProcessorUtils

        //final String message = MavenVersionInspectionBundle.message("MavenVersionInspection.has.version.update","1.21");

        //avenVersionInspectionBundle.message("MavenVersionInspection.has.version.update");


        //super.checkFileElement(domFileElement, holder);
    }


}