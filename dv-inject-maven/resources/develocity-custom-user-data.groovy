// Write build scan links to GitHub Actions job summary
buildScan.buildScanPublished { published ->
    def buildScanUri = published.buildScanUri
    log.info("Captured build scan link: ${buildScanUri}")

    def jobSummaryFile = System.getenv("GITHUB_STEP_SUMMARY")
    if (jobSummaryFile) {
        new File(jobSummaryFile) << "Develocity Build Scan: ${buildScanUri}"
    }
}
