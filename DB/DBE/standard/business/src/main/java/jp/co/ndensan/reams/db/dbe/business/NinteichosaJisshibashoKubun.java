/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の実施場所区分を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaJisshibashoKubun extends KaigoCodeAssignedItem<NinteichosaJisshibashoKubunCode> {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public NinteichosaJisshibashoKubun(Code code, RString codeMeisho, RString codeRyakusho) {

        super(new NinteichosaJisshibashoKubunCode(code), code, codeMeisho, codeRyakusho, null, null, null);
    }

    /**
     * 実施場所区分コードを返します。
     *
     * @return 実施場所区分コード
     */
    public NinteichosaJisshibashoKubunCode getNinteichosaJisshibashoKubunCode() {
        return getExtendedCode();
    }
}
