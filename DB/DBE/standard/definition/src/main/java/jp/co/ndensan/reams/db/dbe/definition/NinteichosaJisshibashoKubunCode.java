/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の実施場所区分コードを扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaJisshibashoKubunCode extends Code {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     */
    public NinteichosaJisshibashoKubunCode(Code code) {
        this(code.value());
    }

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     */
    public NinteichosaJisshibashoKubunCode(RString code) {
        super(code);
    }
}
