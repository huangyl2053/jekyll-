/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.TokuteiShippeiCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特定疾病を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class TokuteiShippei extends KaigoCodeAssignedItem<TokuteiShippeiCode> {

    /**
     * インスタンスを生成します。
     *
     * @param code コード
     * @param codeMeisho 名称
     * @param codeRyakusho 略称
     */
    public TokuteiShippei(Code code, RString codeMeisho, RString codeRyakusho) {
        super(new TokuteiShippeiCode(code), code, codeMeisho, codeRyakusho);
    }

    /**
     * 特定疾病コードを返します。
     *
     * @return 特定疾病コード
     */
    public TokuteiShippeiCode getTokuteiShippeiKubunCode() {
        return getExtendedCode();
    }
}
