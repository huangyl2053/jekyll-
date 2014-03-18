/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員資格コードを表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class ShinsakaiIinShikakuCode extends Code {

    /**
     * 引数からコードを表す文字列を受け取り、インスタンスを生成します。
     *
     * @param code コードを表す文字列
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsakaiIinShikakuCode(RString code) throws NullPointerException, IllegalArgumentException {
        super(code);
    }

    /**
     * 引数からコードを受け取り、インスタンスを生成します。
     *
     * @param code コード
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public ShinsakaiIinShikakuCode(Code code) throws NullPointerException, IllegalArgumentException {
        this(code.value());
    }

    /**
     * 審査会委員資格のコードを表す文字列を返します。
     *
     * @return コードを表す文字列
     */
    public RString getCode() {
        return super.value();
    }
}
