/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.ninteichosaitakusakijoho;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 時間管理の場合で認定調査スケジュール情報パラメータクラス。
 *
 * @reamsid_L DBE-0020-050 houtp
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class JiKanKanRiParameter {

    private final RString 認定調査予定日_開始;
    private final RString 認定調査予定日_終了;
    private final RString 調査地区コード;
    private final RString 認定調査委託先コード;
    private final RString 市町村コード;
    private final RString 認定調査員コード;
    private final boolean uses認定調査委託先コード;
    private final boolean uses認定調査員コード;
    private final boolean uses予約状況_仮予約;
    private final boolean uses予約状況_確定;

    private JiKanKanRiParameter(
            RString 認定調査予定日_開始,
            RString 認定調査予定日_終了,
            RString 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
            boolean uses認定調査委託先コード,
            boolean uses認定調査員コード,
            boolean uses予約状況_仮予約,
            boolean uses予約状況_確定) {
        this.認定調査予定日_開始 = 認定調査予定日_開始;
        this.認定調査予定日_終了 = 認定調査予定日_終了;
        this.調査地区コード = 調査地区コード;
        this.認定調査委託先コード = 認定調査委託先コード;
        this.認定調査員コード = 認定調査員コード;
        this.uses認定調査委託先コード = uses認定調査委託先コード;
        this.uses認定調査員コード = uses認定調査員コード;
        this.市町村コード = 市町村コード;
        this.uses予約状況_仮予約 = uses予約状況_仮予約;
        this.uses予約状況_確定 = uses予約状況_確定;
    }

    /**
     * 共通パラメータ設定。
     *
     * @param 認定調査予定日_開始 認定調査予定日_開始
     * @param 認定調査予定日_終了 認定調査予定日_終了
     * @param 調査地区コード 調査地区コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @param uses認定調査委託先コード uses認定調査委託先コード
     * @param uses認定調査員コード uses認定調査員コード
     * @param 市町村コード 市町村コード
     * @param uses予約状況_仮予約 uses予約状況_仮予約
     * @param uses予約状況_確定 uses予約状況_確定
     * @return NinteichosaScheduleParameter
     */
    public static JiKanKanRiParameter createParam_common(
            RString 認定調査予定日_開始,
            RString 認定調査予定日_終了,
            RString 調査地区コード,
            RString 認定調査委託先コード,
            RString 認定調査員コード,
            RString 市町村コード,
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

        return new JiKanKanRiParameter(
                認定調査予定日_開始,
                認定調査予定日_終了,
                調査地区コード,
                認定調査委託先コード,
                認定調査員コード,
                市町村コード,
                uses認定調査委託先コード,
                uses認定調査員コード,
                uses予約状況_仮予約,
                uses予約状況_確定);
    }
}
