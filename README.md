
# 此项目提供防重点击效果

# 如何使用
###AspectJX是基于 gradle android插件1.5及以上版本设计使用的，如果你还在用1.3或者更低版本，请把版本升上去。
###本使用说明是基于重构后的2.0.0版本编写的，如需要查阅旧版本的README，请切换到对应的Tag。

# 插件引用
###在项目根目录的build.gradle里依赖AspectJX
###dependencies {
###      classpath 'com.github.MachineHou:AspectPlugin:1.0.4'
###    }
    
# 在app项目的build.gradle里应用插件
###   apply plugin: 'AspectPlugin'

###  如果是多个组件化开发的话，就在你base基础lib库中添加
###   api 'com.github.MachineHou:Aspectjrt:1.0.8'

###   在我们的点击实践中添加   @SingleClick/方法名(/防重点击时长)
###      @SingleClick(1000)
###   @Override
###    public void onClick(View view) {}

###    另外一种方法，就是我们自定义的一些控件如果出现冲突的问题我们可以丢弃以上用发，（用以下方法可处理问题）
###         if (!FastClick.getmInstance().isFastClick(1000)) {
###                   Log.e("aaaaa", "发生快速点击");
###//                ToastUtils.showLong("请不要重复点击");
###                    return;
###        }

# 开发AspectJX的初衷
###1.目前的开源库中还没有发现可应用于Android平台的比较好的AOP框架或者工具，虽然xposed，dexposed非常强大，但基于严重的碎片化现状，兼容问题永远是一座无法逾越的大山。
###2.目前其他的AspectJ相关插件和框架都不支持AAR或者JAR切入的，对于目前在Android圈很火爆的Kotlin更加无能为力。