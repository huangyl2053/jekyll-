/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.SuiteiKyuhuKubunCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 推定給付区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class SuiteiKyuhuKubun extends KaigoCodeAssignedItem<SuiteiKyuhuKubunCode> {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 推定給付区分コード 介護認定状態安定性コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public SuiteiKyuhuKubun(Code 推定給付区分コード, RString 名称, RString 略称) {
        super(new SuiteiKyuhuKubunCode(推定給付区分コード), 推定給付区分コード, 名称, 略称);
    }

    /**
     * 推定給付区分コードを返します。
     *
     * @return 推定給付区分コード
     */
    public SuiteiKyuhuKubunCode get推定給付区分コード() {
        return getExtendedCode();
    }
}
