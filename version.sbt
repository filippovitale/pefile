version in ThisBuild := "0.0.1-" + Process("git rev-parse --short HEAD").lines.head
