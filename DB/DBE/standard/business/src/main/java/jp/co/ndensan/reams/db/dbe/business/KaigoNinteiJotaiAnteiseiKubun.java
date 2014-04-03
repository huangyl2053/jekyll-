/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.KaigoNinteiJotaiAnteiseiCode;
import jp.co.ndensan.reams.db.dbz.business.KaigoCodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定状態の安定性を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class KaigoNinteiJotaiAnteiseiKubun extends KaigoCodeAssignedItem<KaigoNinteiJotaiAnteiseiCode> {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 介護認定状態安定性コード 介護認定状態安定性コード
     * @param 名称 名称
     * @param 略称 略称
     */
    public KaigoNinteiJotaiAnteiseiKubun(Code 介護認定状態安定性コード, RString 名称, RString 略称) {
        super(new KaigoNinteiJotaiAnteiseiCode(介護認定状態安定性コード), 介護認定状態安定性コード, 名称, 略称);
    }

    /**
     * 介護認定状態安定性コードを返します。
     *
     * @return 介護認定状態安定性コード
     */
    public KaigoNinteiJotaiAnteiseiCode get介護認定状態安定性コード() {
        return getExtendedCode();
    }
}
