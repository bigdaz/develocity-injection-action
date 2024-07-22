buildScan.buildScanPublished { published ->
    def buildScanUri = published.buildScanUri
    log.info("Build scan published at ${buildScanUri}")

    def jobSummaryFile = System.getenv("GITHUB_STEP_SUMMARY")
    if (jobSummaryFile) {
        new File(jobSummaryFile) << "Develocity Build Scan: ${buildScanUri}"
    } else {
        log.warn("Could not find environment variable GITHUB_STEP_SUMMARY to write build scan URI to.")
    }
}
