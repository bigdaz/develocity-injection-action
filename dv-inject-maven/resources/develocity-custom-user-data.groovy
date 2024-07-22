log.info('Evaluating my custom Groovy script')

buildScan.tag("TAGGED")

buildScan.buildScanPublished {
    log.info("Build scan published at ${buildScan.url}")
}
