# deep-qcg-client

This project is a Java library for communicating with QCG API. 

## Using deep-qcg-client in your maven project

Add deep-qcg-client as a dependency:

```
<dependency>
  <groupId>xxxx</groupId>
  <artifactId>deep.qcg-client</artifactId>
  <version>1.0.1</version>
</dependency>
```


## Usage

### Initialization

The following piece of code initializes the client. ```QcgClient.getInstance()``` method expects the endpoint for qcg:

```
String endpoint = "<endpoint>";
Qcg qcg = QcgClient.getInstance(endpoint);
```

for Basic Auth

```
String endpoint = "<endpoint>";
String username = "<username>";
String password = "<password>";
Qcg qcg = QcgClient.getInstanceWithBasicAuth(endpoint,username,password);
```

### Getting all jobs

The following will return all the jobs that have been created:

```
JobCollection jobs  = qcg.getJobs();
```

### Getting paginated list of jobs

The following will return a paginated list of jobs that have been created:

```
JobCollection jobs  = qcg.getJobs(pagenumber, pagesize);
```

### Create a new job

The following example demonstrates how a new job can be created:

```
JobDescription jd = new JobDescription();
jd.setNote("test job");
JobDescriptionExecution execution = new JobDescriptionExecution();
execution.setExecutable("/usr/bin/printf");
execution.setArgs(Arrays.asList(new String[]{"qgc_test"}));
JobWorkingDirectoryPolicy directory_policy = new JobWorkingDirectoryPolicy();
directory_policy.setCreate(RemoveConditionCreateMode.OVERWRITE);
directory_policy.setRemove(RemoveConditionWhen.NEVER);	
execution.setDirectory_policy(directory_policy);
jd.setExecution(execution);

qcg.createJob(jd);
```

### Get details about an existing job

The following example demonstrates how to get details about an already created job:

```
Job job = qcg.getJob("id");
```

### Delete a job

The following example demonstrates how one can delete an existing application:

```
qcg.deleteJob("id");
```


### Get list of resources

The following example demonstrates how one can retrieve the list of system resources:

```
Resources resources = qcg.getResources();
```

## Building

This project is built using [Apache Maven](http://maven.apache.org/).

Run the following command from the root of repository, to build the client JAR:

```
$ mvn clean install
```

## Bugs

Bugs can be reported using Github issues.
