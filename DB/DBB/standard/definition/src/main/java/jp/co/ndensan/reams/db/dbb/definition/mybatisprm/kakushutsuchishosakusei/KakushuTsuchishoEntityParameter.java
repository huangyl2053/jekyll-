/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.kakushutsuchishosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更正後賦課の情報を取得のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-0740-020 xicongwang
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KakushuTsuchishoEntityParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final int 履歴番号;
    private final YMDHMS 調定日時;
    private final RString 調定日;

    /**
     * コンストラクタです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 調定日時 調定日時
     * @param 調定日 調定日
     */
    private KakushuTsuchishoEntityParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            YMDHMS 調定日時,
            RString 調定日) {
        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;
        this.調定日時 = 調定日時;
        this.調定日 = 調定日;
    }

    /**
     * パラメータメソッドです。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @param 調定日時 調定日時
     * @param 調定日 調定日
     * @return パラメータ
     */
    public static KakushuTsuchishoEntityParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            YMDHMS 調定日時,
            RString 調定日) {
        return new KakushuTsuchishoEntityParameter(調定年度, 賦課年度, 通知書番号, 履歴番号, 調定日時, 調定日);
    }
}
