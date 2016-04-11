/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.karisanteiidotsuchisho;

import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.NonNull;

/**
 * 異動賦課情報一時テーブルに登録するパラメータです。
 *
 * @reamsid_L DBB-0890-040 zhangrui
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class IdofukaJohoTempParameter {

    private final FlexibleYear 調定年度;
    private final FlexibleYear 調定年度前年;
    private final FlexibleYear 賦課年度;
    private final RString 更正前後区分;
    private final RString 作成処理名;
    private final YMDHMS 調定日時;
    private final RString 特別徴収対象者情報;
    private final RString 特別徴収追加候補者情報;

    private IdofukaJohoTempParameter(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            RString 更正前後区分,
            RString 作成処理名,
            YMDHMS 調定日時) {
        this.調定年度 = 調定年度;
        this.調定年度前年 = 調定年度.minusYear(1);
        this.賦課年度 = 賦課年度;
        this.更正前後区分 = 更正前後区分;
        this.作成処理名 = 作成処理名;
        this.調定日時 = 調定日時;
        // TODO UE特徴分配.Enum.通知内容コード.特別徴収対象者情報
        this.特別徴収対象者情報 = RString.EMPTY;
        // TODO UE特徴分配.Enum.通知内容コード.特別徴収追加候補者情報
        this.特別徴収追加候補者情報 = RString.EMPTY;
    }

    /**
     * パラメータを作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 更正前後区分 更正前後区分
     * @param 作成処理名 作成処理名
     * @param 調定日時 調定日時
     * @return 作成されたパラメータ
     */
    public static IdofukaJohoTempParameter createParameter(
            @NonNull FlexibleYear 調定年度,
            @NonNull FlexibleYear 賦課年度,
            @NonNull RString 更正前後区分,
            @NonNull RString 作成処理名,
            @NonNull YMDHMS 調定日時) {
        return new IdofukaJohoTempParameter(調定年度, 賦課年度, 更正前後区分, 作成処理名, 調定日時);
    }

    /**
     * パラメータを作成する。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 更正前後区分 更正前後区分
     * @return 作成されたパラメータ
     */
    public static IdofukaJohoTempParameter createParameter(
            @NonNull FlexibleYear 調定年度,
            @NonNull FlexibleYear 賦課年度,
            @NonNull RString 更正前後区分) {
        return new IdofukaJohoTempParameter(調定年度, 賦課年度, 更正前後区分, null, null);
    }

    /**
     * パラメータを作成する。
     *
     * @param 調定年度 調定年度
     * @return 作成されたパラメータ
     */
    public static IdofukaJohoTempParameter createParameter(
            @NonNull FlexibleYear 調定年度) {
        return new IdofukaJohoTempParameter(調定年度, null, null, null, null);
    }
}
