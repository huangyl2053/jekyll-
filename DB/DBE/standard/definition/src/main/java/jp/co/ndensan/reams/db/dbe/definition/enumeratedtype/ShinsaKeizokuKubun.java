/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * 審査の継続を表す区分です。
 *
 * @author n8178 城間篤人
 */
public enum ShinsaKeizokuKubun {

    /**
     * 継続する
     */
    継続する(true),
    /**
     * 継続しない
     */
    継続しない(false);
    private final boolean is継続;

    private ShinsaKeizokuKubun(boolean is継続) {
        this.is継続 = is継続;
    }

    /**
     * 継続するかしないかをbool値で返します。
     *
     * @return 継続ならture、しないならfalse
     */
    public boolean is継続() {
        return is継続;
    }

    /**
     * 渡されたbool値を元に、審査継続区分を返します。
     *
     * @param is継続 継続ならture、しないならfalse
     * @return bool値に対応した審査継続区分
     */
    public static ShinsaKeizokuKubun toValue(boolean is継続) {
        if (is継続) {
            return 継続する;
        }
        return 継続しない;
    }
}
