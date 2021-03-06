package pers.hai.sample.dp.visitor;

/**
 * TODO
 * <p>
 * Create Time: 2019-06-14 11:17
 * Last Modify: 2019-06-14
 *
 * @author Q-WHai
 * @see <a href="https://github.com/qwhai">https://github.com/qwhai</a>
 */
public class FloatElement implements Visitable {

    private Float value;
    public FloatElement(Float value) {
        this.value = value;
    }

    Float getValue(){
        return value;
    }

    //定义 accept 的具体内容 这里是很简单的一句调用
    public void accept(Visitor visitor) {
        visitor.visitFloat(this);
    }
}
