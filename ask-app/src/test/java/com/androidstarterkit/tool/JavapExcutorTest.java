package com.androidstarterkit.tool;


import com.androidstarterkit.directory.RemoteDirectory;
import com.androidstarterkit.util.FileUtils;

import org.junit.Assert;
import org.junit.Test;

public class JavapExcutorTest {
  @Test
  public void javapSampleActivityTest() throws Exception {
    ClassDisassembler javap = new ClassDisassembler(FileUtils.getRootPath() + "/ask-remote-module/build/intermediates/classes/debug"
        , RemoteDirectory.PACKAGE_NAME);
    javap.extractClasses("com/androidstarterkit/module/" + FileUtils.removeExtension(RemoteDirectory.SAMPLE_ACTIVITY_NAME));

    Assert.assertEquals(1, javap.getInternalClassInfos().size());
    Assert.assertEquals(0, javap.getExternalClassInfos().size());
  }

  @Test
  public void javapSlidingTabFragmentTest() throws Exception {
    ClassDisassembler javap = new ClassDisassembler(FileUtils.getRootPath() + "/ask-remote-module/build/intermediates/classes/debug"
        , RemoteDirectory.PACKAGE_NAME);
    javap.extractClasses("com/androidstarterkit/module/ui/view/SlidingTabFragment");

    Assert.assertEquals(5, javap.getInternalClassInfos().size());
    Assert.assertEquals(true, javap.getInternalClassInfos().contains(new ClassInfo("data/FragmentInfo")));
    Assert.assertEquals(true, javap.getInternalClassInfos().contains(new ClassInfo("ui/adapter/SlidingTabAdapter")));
    Assert.assertEquals(true, javap.getInternalClassInfos().contains(new ClassInfo("ui/view/ScrollViewFragment")));
    Assert.assertEquals(true, javap.getInternalClassInfos().contains(new ClassInfo("widget/SlidingTabLayout")));
    Assert.assertEquals(true, javap.getInternalClassInfos().contains(new ClassInfo("widget/SlidingTabLayout$TabColorizer")));
    Assert.assertEquals(0, javap.getExternalClassInfos().size());
  }
}
