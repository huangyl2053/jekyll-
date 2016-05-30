/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.core.viewstate;

/**
 * 介護ののViewStateKeys
 *
 * @reamsid_L DBX-9999-023 wangchao
 */
public enum ViewStateKeys {

    /**
     * キーが「識別コード」であることを表します
     */
    識別コード,
    /**
     * キーが「被保険者番号」であることを表します
     */
    被保険者番号,
    /**
     * キーが「広域内市町村情報」であることを表します
     */
    広域内市町村情報,
    /**
     * キーが「資格対象者」であることを表します
     */
    資格対象者,
    /**
     * 負担限度額認定申請の情報
     */
    負担限度額認定申請の情報,
    /**
     * new負担限度額認定申請の情報
     */
    new負担限度額認定申請の情報,
    /**
     * isReRequest
     */
    isReRequest,
    /**
     * 申請書管理番号
     */
    申請書管理番号,
    /**
     * 認定調査依頼情報
     */
    認定調査依頼情報,
    /**
     * 主治医意見書依頼情報
     */
    主治医意見書依頼情報,
    /**
     * タスク一覧_要介護認定完了情報
     */
    タスク一覧_要介護認定完了情報;
}
