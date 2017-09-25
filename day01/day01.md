0904板书
 * UML统一建模语言
   * UMl事物：构建事物，行为事物，分组事物，注释事物
     * 构建事物：UML模型中静态的部分，描述概念和物理元素，包括类，接口，协作，用例。构建以及节点
     * 行为事物：动态部分，描述跨越空间和时间的行为，包括交互（消息集合）/状态（消息传递状态序列）
     * 分组事物：组织部分，事物组织结构，例如包
     * 注释事物：解释部分，注释
   * UML中的关系：
     * 依赖：一事物发生变化会影响到另一事物
     * 关联：事物对象之间的联系，如乘车人和车票
     * 泛化：类的继承
     * 实现：接口实现
   * UML中的9种图形
     * 用例图(Use Case Diagram)：用例图是从用户角度描述系统功能， 是用户所能观察到的系统功能的模型图，用例是系统中的一个功能单元
     * 类图(Class Diagram)：类图描述系统中类的静态结构。不仅定义系统中的类，表示类之间的联系如关联、依赖、聚合等，也包括类的内部结构(类的属性和操作)
     * 对象图( Object Diagram )：类图的实例，显示类的多个对象实例，而不是实际的类
     * 顺序图(Sequence Diagram)：顺序图显示对象之间的动态合作关系，它强调对象之间消息发送的顺序，同时显示对象之间的交互
     * 协作图(Collaboration Diagram)：对象间的协作关系
     * 状态图(State Chart Diagram)
     * 活动图(Activity Diagram)
     * 构件图(Component Diagram)
     * 部署图(Deployment Diagram)
     
 * 软件工程各阶段简称:
     * AN-要求分析
     * BD-基本设计
     * FD-结构设计
     * DD-详细设计
     * CD -编码
     * UT-单体测试
     * CT-组件测试
     * TT-结合测试
     * IT-集成测试
     * ST-系统测试
     * UAT-验收测试
     * OP-发布
     * 软件工程三大阶段中主要使用用例图，类图，顺序图：即×AN:用例图，顺序图× *BD:用例图，顺序图，类图* *FD/DD:顺序图，类图*
 * 用例图：
     * 为什么要使用用例图： 定义统一的规范来描述系统的功能需求
     * 用例图的主要作用：
        1.用例图的主要作用
        2.作为开发过程的基础，驱动各阶段的开发工作
        3.用于验证与确认系统需求
     * 用例图概要：
        1.用例图是被称为参与者的外部用户所能观察到的系统功能模型图
        2.用例图列出了系统中的用例和系统外的参与者，以及用例执行
        3.用例图多用于静态建模阶段（业务建模和需求建模）
     * 用例图中的事物及解释：
        1.参与者(Actor)：在系统外部与系统直接交互的人或事物
        2.用例(Use Case)：系统外部可见的一个系统功能单元。
     * 用例图中的关系及解释:
        1.参与者与用例之间的关系:关联
        2.用例之间的关系:包含 扩展
        3.参与者之间的关系:泛化
     * 参与者的识别:
     * 用例识别:对一组动作序列的描述:特征：
        1.系统具有的一种行为模式 
        2.一个参与者与系统执行的一个相关的事务序列
        3.一种获取系统需求的方法 
        4.种与最终的用户和领域专家进行沟通的方法 
        5.一种测试系统的方法
     * 关系：
        1.关联关系
     	2.依赖关系
     	3.泛化关系
     	4.扩展关系
     	5.包含关系

     

     