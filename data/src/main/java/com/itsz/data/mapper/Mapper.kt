package com.itsz.data.mapper


/**
 * @param Model UI 层需要使用的数据对象
 * @param Dto 数据传输对象(json)
 * @param Entity 数据库对象
 */
interface Mapper<Model, Dto, Entity> {

    fun jsonToDomainModel(json: Dto): Model

    fun jsonToEntity(json: Dto): Entity

    fun entityToDomainModel(entity: Entity): Model

    fun modelToEntity(model: Model): Entity
}