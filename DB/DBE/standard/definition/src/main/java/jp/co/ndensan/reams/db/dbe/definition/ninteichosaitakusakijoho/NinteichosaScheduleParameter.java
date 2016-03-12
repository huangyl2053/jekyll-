/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調査員の場合で認定調査スケジュール情報パラメータクラス。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class NinteichosaScheduleParameter {

    private final RString 調査地区コード;
    private final RString 市町村コード;
    private final RString 認定調査委託先コード;
    private final RString 認定調査員コード;
    private final RString 予約状況;
    private final RString 認定調査予定日_開始;
    private final RString 認定調査予定日_終了;
    private final boolean uses認定調査委託先コード;
    private final boolean uses認定調査員コード;
    private final boolean uses予約状況_仮予約;
    private final boolean uses予約状況_確定;

    private NinteichosaScheduleParameter(
            RString 調査地区コード,
            RString 市町村コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 予約状況,
            RString 認定調査予定日_開始,
            RString 認定調査予定日_終了,
            boolean uses認定調査委託先コード,
            boolean uses認定調査員コード,
            boolean uses予約状況_仮予約,
            boolean uses予約状況_確定) {
        this.調査地区コード = 調査地区コード;
        this.市町村コード = 市町村コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.予約状況 = 予約状況;
        this.認定調査予定日_開始 = 認定調査予定日_開始;
        this.認定調査予定日_終了 = 認定調査予定日_終了;
        this.uses認定調査委託先コード = uses認定調査委託先コード;
        this.uses認定調査員コード = uses認定調査員コード;
        this.uses予約状況_仮予約 = uses予約状況_仮予約;
        this.uses予約状況_確定 = uses予約状況_確定;
    }

    /**
     * 共通パラメータ設定。
     *
     * @param 調査地区コード 調査地区コード
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param 予約状況 予約状況
     * @param 認定調査予定日_開始 認定調査予定日_開始
     * @param 認定調査予定日_終了 認定調査予定日_終了
     * @param uses認定調査委託先コード uses認定調査委託先コード
     * @param uses認定調査員コード uses認定調査員コード
     * @param uses予約状況_仮予約 uses予約状況_仮予約
     * @param uses予約状況_確定 uses予約状況_確定
     * @return NinteichosaScheduleParameter
     */
    public static NinteichosaScheduleParameter createParam_common(
            RString 調査地区コード,
            RString 市町村コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 予約状況,
            RString 認定調査予定日_開始,
            RString 認定調査予定日_終了,
            boolean uses認定調査委託先コード,
            boolean uses認定調査員コード,
            boolean uses予約状況_仮予約,
            boolean uses予約状況_確定) {

        if (認定調査委託先コード != null && !認定調査委託先コード.isEmpty()) {
            uses認定調査委託先コード = true;
        }
        if (認定調査員コード != null && !認定調査員コード.isEmpty()) {
            uses認定調査員コード = true;
        }
        if (予約状況 != null && 予約状況.equals(new RString("1"))) {
            uses予約状況_仮予約 = true;
        }
        if (予約状況 != null && 予約状況.equals(new RString("2"))) {
            uses予約状況_確定 = true;
        }

        return new NinteichosaScheduleParameter(
                調査地区コード,
                市町村コード,
                認定調査委託先コード,
                認定調査員コード,
                予約状況,
                認定調査予定日_開始,
                認定調査予定日_終了,
                uses認定調査委託先コード,
                uses認定調査員コード,
                uses予約状況_仮予約,
                uses予約状況_確定);
    }
}
