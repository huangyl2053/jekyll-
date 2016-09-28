/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho.KaishuriyushoShikyuKetteitsuchishoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成の前回実行情報です。
 *
 * @reamsid_L DBC-2850-010 chenxiangyu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KetteiTimestampBusiness {

    private final KaishuriyushoShikyuKetteitsuchishoRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 住宅改修理由書作成手数料支給（不支給）決定通知書作成のRelateEntity
     */
    public KetteiTimestampBusiness(KaishuriyushoShikyuKetteitsuchishoRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * temp_前回決定日_開始日を取得します。
     *
     * @return temp_前回決定日_開始日
     */
    public RString getTemp_前回決定日_開始日() {
        return entity.getTemp_前回決定日_開始日();
    }

    /**
     * temp_前回決定日_終了日を取得します。
     *
     * @return temp_前回決定日_終了日
     */
    public RString getTemp_前回決定日_終了日() {
        return entity.getTemp_前回決定日_終了日();
    }
}
