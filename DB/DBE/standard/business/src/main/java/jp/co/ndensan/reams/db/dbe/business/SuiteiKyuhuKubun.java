/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.SuiteiKyuhuKubunCode;
import jp.co.ndensan.reams.ur.urz.business.CodeAssignedItem;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 推定給付区分を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class SuiteiKyuhuKubun extends CodeAssignedItem {

    /**
     * コードと名称を受け取り、インスタンスを生成します。
     *
     * @param 推定給付区分コード 介護認定状態安定性コード
     * @param 名称 名称
     */
    public SuiteiKyuhuKubun(SuiteiKyuhuKubunCode 推定給付区分コード, RString 名称) {
        super(推定給付区分コード, 名称, null, null, null, null);
    }

    /**
     * 推定給付区分コードを返します。
     *
     * @return 推定給付区分コード
     */
    public SuiteiKyuhuKubunCode get推定給付区分コード() {
        return (SuiteiKyuhuKubunCode) getCode();
    }
}
