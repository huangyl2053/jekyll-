/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.valueobject;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 合議体（介護認定審査会）の長や長代理、委員などの区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class GogitaichoKubun extends Code {

    private RString name;

    /**
     * 引数からコードを表す文字列と名称を受け取り、インスタンスを生成します。
     *
     * @param code コードを表す文字列
     * @param name 名称
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public GogitaichoKubun(RString code, RString name) throws NullPointerException, IllegalArgumentException {
        super(code);
        this.name = requireNonNull(name, Messages.E00003.replace("名称", getClass().getName()).getMessage());
    }

    /**
     * 引数からコードと名称を受け取り、インスタンスを生成します。
     *
     * @param code コード
     * @param name 名称
     * @throws NullPointerException 引数にnullが渡されたとき
     * @throws IllegalArgumentException コードが20桁以内で無い場合
     */
    public GogitaichoKubun(Code code, RString name) throws NullPointerException, IllegalArgumentException {
        this(code.value(), name);
    }

    /**
     * 合議体長区分のコードを表す文字列を返します。
     *
     * @return コードを表す文字列
     */
    public RString getCode() {
        return super.value();
    }

    /**
     * 合議体長区分の名称を返します。
     *
     * @return 名称
     */
    public RString getName() {
        return name;
    }
}
