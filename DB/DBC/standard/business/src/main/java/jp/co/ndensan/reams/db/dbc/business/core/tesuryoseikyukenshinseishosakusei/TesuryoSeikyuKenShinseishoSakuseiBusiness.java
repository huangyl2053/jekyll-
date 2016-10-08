/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.tesuryoseikyukenshinseishosakusei;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のコントローラです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TesuryoSeikyuKenShinseishoSakuseiBusiness {

    private final TesuryoSeikyuKenShinseishoSakuseiRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity TesuryoSeikyuKenShinseishoSakuseiRelateEntity
     */
    public TesuryoSeikyuKenShinseishoSakuseiBusiness(TesuryoSeikyuKenShinseishoSakuseiRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 対象開始日時を取得します。
     *
     * @return 対象開始日時
     */
    public RString get対象開始日時() {
        return entity.get対象開始日時();
    }

    /**
     * 対象終了日時を取得します。
     *
     * @return 対象終了日時
     */
    public RString get対象終了日時() {
        return entity.get対象終了日時();
    }
}
