# java-json-demo
 
 
 - gson 对null处理 ,不太友好。包装类，默认都是null。
 
 - Jackson 都null处理，全局只可以配置空转 '' ,包装类都为一个值，不友好。
 
 - jsonlib  处理比较友好，但是效率低，接口使用不太方便。
 
 - fastjson 常见包装类有自己的默认值，空值处理友好，效率高。
 
 - 无特殊要求，fastjson
 - 对效率不要求：jsonlib
 - 由于框架的集成，只能使用jackson
 - gson 一般不作选用，感觉不太好
