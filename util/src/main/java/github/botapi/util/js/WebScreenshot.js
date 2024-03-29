/**
 * 网页截图js脚本
 * https://phantomjs.org/
 * js 文件参考写法 https://zhuanlan.zhihu.com/p/264921381
 * */
var page = require('webpage').create(), system = require('system'), address, output, size;
if (system.args.length < 3 || system.args.length > 5) {
    phantom.exit(1);
} else {
    address = system.args[1];
    output = system.args[2];
    //定义宽高
    page.open(address, function (status) {
        var bb = page.evaluate(function () {
            return document.getElementsByTagName('html')[0].getBoundingClientRect();
        });
        page.clipRect = {top: bb.top, left: bb.left, width: bb.width, height: bb.height};
        window.setTimeout(function () {
            page.render(output);
            page.close();
        }, 1000);
    });
    address = system.args[1];//传入的URL地址
    output = system.args[2];//保存的图片路径
}