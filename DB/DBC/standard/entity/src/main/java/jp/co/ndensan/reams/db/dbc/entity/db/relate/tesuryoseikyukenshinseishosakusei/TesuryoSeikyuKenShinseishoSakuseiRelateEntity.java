/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.tesuryoseikyukenshinseishosakusei;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料請求書兼申請書作成 のRelateEntityです。
 *
 * @reamsid_L DBC-2860-010 dangjingjing
 */
@lombok.Getter
@lombok.Setter
public class TesuryoSeikyuKenShinseishoSakuseiRelateEntity {

    private RString 対象開始日時;
    private RString 対象終了日時;
}
