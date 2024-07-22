log.info('Evaluating my custom Groovy script')

buildScan.tag("TAGGED")

buildScan.buildScanPublished { published ->
    log.info("Build scan published at ${published.buildScanUri}")
}
