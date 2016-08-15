/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 徴収猶予の情報を特定するためのMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ChoshuYuyoJohoRelateMapperParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 賦課年度;
    private final TsuchishoNo 通知書番号;
    private final int 履歴番号;

    private final boolean uses調定年度;
    private final boolean uses賦課年度;
    private final boolean uses通知書番号;
    private final boolean uses履歴番号;

    private ChoshuYuyoJohoRelateMapperParameter(
            @lombok.NonNull FlexibleYear 調定年度,
            @lombok.NonNull FlexibleYear 賦課年度,
            @lombok.NonNull TsuchishoNo 通知書番号,
            int 履歴番号,
            boolean uses調定年度,
            boolean uses賦課年度,
            boolean uses通知書番号,
            boolean uses履歴番号) {

        this.調定年度 = 調定年度;
        this.賦課年度 = 賦課年度;
        this.通知書番号 = 通知書番号;
        this.履歴番号 = 履歴番号;

        this.uses調定年度 = uses調定年度;
        this.uses賦課年度 = uses賦課年度;
        this.uses通知書番号 = uses通知書番号;
        this.uses履歴番号 = uses履歴番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 int
     * @return 身体手帳検索パラメータ
     */
    public static ChoshuYuyoJohoRelateMapperParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) {
        return new ChoshuYuyoJohoRelateMapperParameter(調定年度, 賦課年度, 通知書番号, 履歴番号, true, true, true, true);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @return 身体手帳検索パラメータ
     */
    public static ChoshuYuyoJohoRelateMapperParameter createSelectByKeyParam(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号) {
        return new ChoshuYuyoJohoRelateMapperParameter(調定年度, 賦課年度, 通知書番号, 0, true, true, true, false);
    }
}
