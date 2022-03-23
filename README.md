# Summer of Jake adventure map back-end server
# Project currently offline due to high infra costs, will come back later to refactor infrastructure when I have more time :)

This repo hosts the back-end server used to host summerofjake.com. It essentially serves as the DAO for the MySQL database, which
contains the references to all data needed to display on the interactive map. The front-end calls this server to retrieve all data
when rendering the page, and the nightly database-fill job calls it to upload new Strava activity data to the database
.
As of now, this is a personal project so I will not include detailed instructions on how to contribute to future development.

## Website infrastructure
* EC2 server (runs ‘server’ spring application and database-job as scheduled cron): https://console.aws.amazon.com/ec2/v2/home?region=us-east-1#InstanceDetails:instanceId=i-064f11c98fabf4bac
* MySQL database: https://console.aws.amazon.com/rds/home?region=us-east-1#database:id=summer-of-jake-db-2;is-cluster=false
* Cloud bucket (strava kmls, pictures, uploaded geojsons): https://console.cloud.google.com/storage/browser?referrer=search&project=summer-of-jake-adventure-map&prefix=
* Code pipeline: https://console.aws.amazon.com/codesuite/codepipeline/pipelines/summer-of-jake-backend-pipeline/view?region=us-east-1
  -> synced to updates on: https://github.com/jakestrauss/summer-of-jake-backend-server
* Code deploy: https://console.aws.amazon.com/codesuite/codedeploy/applications/summer-of-jake-website?region=us-east-1
* AWS Amplify: https://console.aws.amazon.com/amplify/home?region=us-east-1#/d36vgv5ul1f93o
  -> synced to updates on: https://github.com/jakestrauss/summer-of-jake-react

* Google Maps Javascript API: https://developers.google.com/maps/documentation/javascript/datalayerogle.com/maps/documentation/javascript/datalayer
