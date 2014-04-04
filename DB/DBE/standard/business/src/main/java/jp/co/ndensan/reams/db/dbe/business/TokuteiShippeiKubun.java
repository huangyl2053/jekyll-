/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.TokuteiShippeiKubunCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定疾病区分を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class TokuteiShippeiKubun extends KaigoCodeAssignedItem<TokuteiShippeiKubunCode> {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public TokuteiShippeiKubun(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new TokuteiShippeiKubunCode(code), code, codeMeisho, codeRyakusho);
    }

    /**
     * 特定疾病区分コードを返します。
     *
     * @return 特定疾病区分コード
     */
    public TokuteiShippeiKubunCode getTokuteiShippeiKubunCode() {
        return getExtendedCode();
    }
}
