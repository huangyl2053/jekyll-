/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KousinSinseiTaishougaishaJohoMyBatisParameter implements IMyBatisParameter {

    private final FlexibleDate 基準日;
    private final FlexibleDate 前年度の開始日;
    private final FlexibleDate 前年度の終了日;
    private final GemmenGengakuShurui 減免減額種類;
    private final UUID 把握処理ID;

    /**
     *
     * @param 把握処理ID UUID
     * @param 減免減額種類 GemmenGengakuShurui
     * @param 基準日 FlexibleDate
     * @param 前年度の開始日 FlexibleDate
     * @param 前年度の終了日 FlexibleDate
     */
    public KousinSinseiTaishougaishaJohoMyBatisParameter(UUID 把握処理ID, GemmenGengakuShurui 減免減額種類,
            FlexibleDate 基準日, FlexibleDate 前年度の開始日, FlexibleDate 前年度の終了日) {
        this.前年度の終了日 = 前年度の終了日;
        this.前年度の開始日 = 前年度の開始日;
        this.基準日 = 基準日;
        this.把握処理ID = 把握処理ID;
        this.減免減額種類 = 減免減額種類;
    }
}
