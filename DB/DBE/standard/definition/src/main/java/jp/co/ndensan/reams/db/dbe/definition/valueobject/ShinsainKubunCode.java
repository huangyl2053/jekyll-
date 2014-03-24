/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.ur.urz.definition.lib.util.IRStringConvertable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 介護認定審査会での、委員としての役割コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsainKubunCode extends Code implements IRStringConvertable {

    /**
     * 引数からコードを表す文字列を受け取り、インスタンスを生成します。
     *
     * @param code コードを表す文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsainKubunCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }

    /**
     * 引数からコードを受け取り、インスタンスを生成します。
     *
     * @param code コード
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsainKubunCode(Code code) throws NullPointerException, IllegalArgumentException {
        this(code.value());
    }

    @Override
    public RString toRString() {
        return super.value();
    }
}
