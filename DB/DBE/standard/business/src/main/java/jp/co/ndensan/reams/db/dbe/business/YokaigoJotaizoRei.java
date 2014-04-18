/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.YokaigoJotaizoReiCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態像例を保持するクラスです。<br />
 * 要介護度別に設定された「状態像の例」の中から対象者の状態像に近い例を選び、その例が属する区分に応じて要介護度を決定します。
 *
 * @author N8156 宮本 康
 */
public class YokaigoJotaizoRei extends KaigoCodeAssignedItem<YokaigoJotaizoReiCode> {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public YokaigoJotaizoRei(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new YokaigoJotaizoReiCode(code), code, codeMeisho, codeRyakusho);
    }

    /**
     * 要介護状態像例コードを返します。
     *
     * @return 要介護状態像例コード
     */
    public YokaigoJotaizoReiCode getYokaigoJotaizoReiCode() {
        return getExtendedCode();
    }
}
