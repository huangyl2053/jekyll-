/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsakaitaishosha;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会個人別状況照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1380-010 jinjue
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsakaiTaishoshaMapperParameter {

    private final RString 審査会開催番号;
    private final FlexibleDate 時間 = FlexibleDate.getNowDate();

    private ShinsakaiTaishoshaMapperParameter(RString 審査会開催番号) {
        this.審査会開催番号 = 審査会開催番号;
    }

    /**
     * 予定情報と結果情報のパラメータを生成します。
     *
     * @param 審査会開催番号 RString
     * @return ShinsakaiTaishoshaMapperParameter
     */
    public static ShinsakaiTaishoshaMapperParameter createSelectBy情報(RString 審査会開催番号) {
        return new ShinsakaiTaishoshaMapperParameter(審査会開催番号);
    }
}
