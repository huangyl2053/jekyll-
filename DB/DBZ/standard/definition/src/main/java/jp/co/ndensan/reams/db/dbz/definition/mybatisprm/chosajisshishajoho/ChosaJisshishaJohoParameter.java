/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.chosajisshishajoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 *
 * @author n3423
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaJisshishaJohoParameter {
    
    private final ShinseishoKanriNo 申請書管理番号;
    private final int 認定調査依頼履歴番号;

    private ChosaJisshishaJohoParameter(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
    }

    /**
     * 検索処理取得パラメータ設定
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @param 認定調査依頼履歴番号 int
     * 
     * @return ChosaJisshishaJohoParameter
     */
    public static ChosaJisshishaJohoParameter createParameter(ShinseishoKanriNo 申請書管理番号, int 認定調査依頼履歴番号) {
        return new ChosaJisshishaJohoParameter(申請書管理番号, 認定調査依頼履歴番号);
    }
}
