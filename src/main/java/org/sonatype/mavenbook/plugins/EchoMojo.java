package org.sonatype.mavenbook.plugins;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;

/**
 * Echos an object string to the output screen.
 * @goal cccp
 * @requiresProject false
 */
public class EchoMojo extends AbstractMojo
{
    /**
     * 
     * @parameter expression="${os.nameVal}" default-value="Win"
     */
    private String osNameVal;
    
    /**
     * @parameter expression="${os.archVal}" default-value="amd64"
     */
    private String osArchVal;
    
    String osArch = System.getProperty("os.arch").toLowerCase();
    String osName = System.getProperty("os.name").toLowerCase();
    String name;
    String path;
    
    

    public void execute()
        throws MojoExecutionException, MojoFailureException
    {
    	getLog().info("Inputs are:"+osNameVal+", "+osArchVal);
    	getOsDetails();
        getLog().info("Platform " + System.getProperty("os.name") + ": " + osArch + " supported");
    }



	private void getOsDetails() {
		if (osName.startsWith(osNameVal.toLowerCase())) {
            if (osArch.equalsIgnoreCase(osArchVal.toLowerCase())) {
                path = "win-amd64/";
            } else {
                throw new UnsupportedOperationException("Platform " + osNameVal + ":" + osArchVal + " not supported");
            }
        }
    	else {
            throw new UnsupportedOperationException("Platform " + osNameVal + ":" + osNameVal + " not supported");
        }
	}
}