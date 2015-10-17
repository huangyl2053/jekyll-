/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.YokaigoJotai;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.YokaigoJotaiKubunCode;
import jp.co.ndensan.reams.db.dbz.business.core.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護状態区分を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
//TODO N3327 三浦凌 YokaigoJotaiKubun(extend Enum)がURDにある。見直しが必要。
public class YokaigoJotaiKubun extends KaigoCodeAssignedItem<YokaigoJotaiKubunCode> {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public YokaigoJotaiKubun(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new YokaigoJotaiKubunCode(code), code, codeMeisho, codeRyakusho);
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public YokaigoJotaiKubunCode getYokaigoJotaiKubunCode() {
        return getExtendedCode();
    }
}
