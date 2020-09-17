/**
 * 动态设置html字体大小
 */
//var clientWidth = document.documentElement.clientWidth;
//clientWidth > 750 ? 750 : clientWidth;
//document.documentElement.style.fontSize = 100 * clientWidth / 750 + "px";


(function (doc, win) {
  var docEl = doc.documentElement
  var resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize'
  var recalc = function () {
      var clientWidth = docEl.clientWidth
      if (!clientWidth) return
      if (clientWidth >= 750) {
        docEl.style.fontSize = '100px'
      } else {
        docEl.style.fontSize = 100 * (clientWidth / 750) + 'px'
      }
  }
  if (!doc.addEventListener) return
  win.addEventListener(resizeEvt, recalc, false)
  doc.addEventListener('DOMContentLoaded', recalc, false)
  })(document, window)