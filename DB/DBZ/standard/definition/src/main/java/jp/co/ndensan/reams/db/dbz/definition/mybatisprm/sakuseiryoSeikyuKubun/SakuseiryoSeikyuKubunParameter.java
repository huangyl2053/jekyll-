/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.sakuseiryoSeikyuKubun;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 作成料請求区分取得のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class SakuseiryoSeikyuKubunParameter {

    private final ShinseishoKanriNo 申請書管理番号;

    private SakuseiryoSeikyuKubunParameter(ShinseishoKanriNo 申請書管理番号) {
        this.申請書管理番号 = 申請書管理番号;
    }

    /**
     * 検索用のパラメータを生成します。
     *
     * @param 申請書管理番号 ShinseishoKanriNo
     * @return 作成料請求区分取得パラメータ
     */
    public static SakuseiryoSeikyuKubunParameter createParameter(ShinseishoKanriNo 申請書管理番号) {
        return new SakuseiryoSeikyuKubunParameter(申請書管理番号);
    }
}
