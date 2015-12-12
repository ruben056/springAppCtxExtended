==application context==
* support for i18n
* event publishing : 
Important is that the eventlistener is configured in the appctx as a bean.
This way spring automatically registers is as a listener for the eventType.
* accessing resources : 
using appCtx.getResource() you can retrieve all sorts of resources (files, classpath resources, urls etc...)
