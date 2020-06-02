package com.microsoft.azure.cosmosdb.kafka.connect.config

import java.util

import org.apache.kafka.common.config.ConfigDef.{Importance, Type, Width}
import org.apache.kafka.common.config.{AbstractConfig, ConfigDef}

object ConnectorConfig {
  lazy val baseConfigDef: ConfigDef = new ConfigDef()
    .define(CosmosDBConfigConstants.CONNECTION_ENDPOINT_CONFIG, Type.STRING, Importance.HIGH,
      CosmosDBConfigConstants.CONNECTION_ENDPOINT_DOC, "Connection", 1,  Width.LONG,
      CosmosDBConfigConstants.CONNECTION_ENDPOINT_DISPLAY)

    .define(CosmosDBConfigConstants.CONNECTION_MASTERKEY_CONFIG, Type.PASSWORD, Importance.HIGH,
      CosmosDBConfigConstants.CONNECTION_MASTERKEY_DOC, "Connection", 2, Width.LONG,
      CosmosDBConfigConstants.CONNECTION_MASTERKEY_DISPLAY)

    .define(CosmosDBConfigConstants.DATABASE_CONFIG, Type.STRING, Importance.HIGH,
      CosmosDBConfigConstants.DATABASE_CONFIG_DOC, "Database", 1, Width.MEDIUM,
      CosmosDBConfigConstants.DATABASE_CONFIG_DISPLAY)

    .define(CosmosDBConfigConstants.COLLECTION_CONFIG, Type.STRING, Importance.HIGH,
      CosmosDBConfigConstants.COLLECTION_CONFIG_DOC, "Collection", 1, Width.MEDIUM,
      CosmosDBConfigConstants.COLLECTION_CONFIG_DISPLAY)

    .define(CosmosDBConfigConstants.TOPIC_CONFIG, Type.STRING, Importance.HIGH,
      CosmosDBConfigConstants.TOPIC_CONFIG_DOC, "Topic", 1, Width.MEDIUM,
      CosmosDBConfigConstants.TOPIC_CONFIG_DISPLAY)

    .define(CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_CONFIG, Type.INT, CosmosDBConfigConstants.ERROR_MAX_RETRIES_DEFAULT, Importance.MEDIUM,
      CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_DOC, "Common", 1,
      Width.MEDIUM , CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_DISPLAY)


  /**
    * Holds the extra configurations for the source on top of
    * the base.
    **/
  lazy val sourceConfigDef: ConfigDef = ConnectorConfig.baseConfigDef
          .define(CosmosDBConfigConstants.ASSIGNED_PARTITIONS, Type.STRING, "", Importance.HIGH,
            CosmosDBConfigConstants.ASSIGNED_PARTITIONS_DOC, "Source", 1, Width.MEDIUM,
            CosmosDBConfigConstants.ASSIGNED_PARTITIONS_DISPLAY)
          .define(CosmosDBConfigConstants.READER_BUFFER_SIZE, Type.INT, CosmosDBConfigConstants.READER_BUFFER_SIZE_DEFAULT, Importance.MEDIUM,
            CosmosDBConfigConstants.READER_BUFFER_SIZE_DOC, "Source", 2, Width.LONG,
            CosmosDBConfigConstants.READER_BUFFER_SIZE_DISPLAY)
          .define(CosmosDBConfigConstants.BATCH_SIZE, Type.INT, CosmosDBConfigConstants.BATCH_SIZE_DEFAULT, Importance.MEDIUM,
            CosmosDBConfigConstants.BATCH_SIZE_DOC, "Source", 3, Width.LONG,
            CosmosDBConfigConstants.BATCH_SIZE_DISPLAY)
          .define(CosmosDBConfigConstants.SOURCE_POST_PROCESSOR, Type.STRING, CosmosDBConfigConstants.SOURCE_POST_PROCESSOR_DEFAULT, Importance.MEDIUM,
            CosmosDBConfigConstants.SOURCE_POST_PROCESSOR_DOC, "Source", 4, Width.LONG,
            CosmosDBConfigConstants.SOURCE_POST_PROCESSOR_DISPLAY)
          .define(CosmosDBConfigConstants.TIMEOUT, Type.INT, CosmosDBConfigConstants.TIMEOUT_DEFAULT, Importance.MEDIUM,
            CosmosDBConfigConstants.TIMEOUT_DOC, "Source", 4, Width.LONG,
            CosmosDBConfigConstants.TIMEOUT_DISPLAY)

  /**
    * Holds the extra configurations for the sink on top of
    * the base.
    **/

  lazy val sinkConfigDef: ConfigDef = ConnectorConfig.baseConfigDef
          .define(CosmosDBConfigConstants.COLLECTION_TOPIC_MAP_CONFIG, Type.STRING, Importance.HIGH,
            CosmosDBConfigConstants.COLLECTION_TOPIC_MAP_CONFIG_DOC, "Map", 1, Width.MEDIUM,
            CosmosDBConfigConstants.COLLECTION_TOPIC_MAP_CONFIG_DISPLAY)
          .define(CosmosDBConfigConstants.SINK_POST_PROCESSOR, Type.STRING, CosmosDBConfigConstants.SINK_POST_PROCESSOR_DEFAULT, Importance.MEDIUM,
            CosmosDBConfigConstants.SINK_POST_PROCESSOR_DOC, "Sink", 1, Width.LONG,
            CosmosDBConfigConstants.SINK_POST_PROCESSOR_DISPLAY)
  //        .define(CosmosDBConfigConstants.EXTRA_SINK_CONFIG_01, Type.STRING, Importance.HIGH,
  //          CosmosDBConfigConstants.EXTRA_SINK_CONFIG_01_DOC, "Sink", 1, Width.MEDIUM,
  //          CosmosDBConfigConstants.EXTRA_SINK_CONFIG_01_DISPLAY)
  //        .define(CosmosDBConfigConstants.EXTRA_SINK_CONFIG_02, Type.STRING, Importance.HIGH,
  //          CosmosDBConfigConstants.EXTRA_SINK_CONFIG_02_DOC, "Sink", 2, Width.MEDIUM,
  //          CosmosDBConfigConstants.EXTRA_SINK_CONFIG_02_DISPLAY)

  lazy val commonConfigDef: ConfigDef = ConnectorConfig.baseConfigDef
    .define(CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_CONFIG, Type.INT, CosmosDBConfigConstants.ERROR_MAX_RETRIES_DEFAULT, Importance.MEDIUM,
      CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_DOC, "Common", 1,
      Width.MEDIUM , CosmosDBConfigConstants.ERRORS_RETRY_TIMEOUT_DISPLAY)

}

case class CosmosDBConfig(config: ConfigDef, props: util.Map[String, String])
  extends AbstractConfig(config, props)