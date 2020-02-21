const layer = document.querySelector('.layer')
const box1 = document.querySelector('.box1')
const box2 = document.querySelector('.box2')
const boxContainer = document.querySelector('.box-container')
const name = document.querySelector('.name')
let flag = false
box1.onclick = function (evt) {
  if (flag) return
  flag = true
	//   显示蒙层
  layer.style.display = 'block'
  setTimeout(() => {
		// 蒙层不透明     
    layer.style.opacity = '1'
	// 缩小收藏按钮     
  	box1.style.transform = 'scale(0)'  
  }, 200)
  setTimeout(() => {
    // 隐藏蒙层
    layer.style.display = 'none'
    layer.style.opacity = '0'
		// 显示文字
    const innerText = name.innerHTML === '已收藏' ? '收藏' : '已收藏'
    name.innerHTML = innerText
		// 隐藏     
    box1.style.display = 'none'
    name.style.opacity = '0'
  }, 1000)
  setTimeout(() => {
		// 显示     
    box1.style = ''
    if (name.innerHTML === '已收藏') {
      boxContainer.style.opacity = '0.75'
    } else {
      boxContainer.style = ''
    }
    flag = false
  }, 1100)
  setTimeout(() => {
    name.style.opacity = '1'
  }, 1150)
}