/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.tesuryoseikyukenshinseishosakusei;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.tesuryoseikyukenshinseishosakusei.TesuryoSeikyuKenShinseishoSakuseiRelateEntity;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のDB操作です。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
public interface ITesuryoSeikyuKenShinseishoSakuseiMapper {

    /**
     * 開始日時・終了日時の取得します。
     *
     * @param parameter TesuryoSeikyuKenShinseishoSakuseiMybatisParameter
     * @return TesuryoSeikyuKenShinseishoSakuseiRelateEntity
     */
    TesuryoSeikyuKenShinseishoSakuseiRelateEntity select日時(TesuryoSeikyuKenShinseishoSakuseiMybatisParameter parameter);

}
