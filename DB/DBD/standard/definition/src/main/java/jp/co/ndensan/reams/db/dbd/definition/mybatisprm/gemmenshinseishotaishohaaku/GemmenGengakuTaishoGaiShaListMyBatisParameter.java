/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoGaiShaListMyBatisParameter implements IMyBatisParameter {

    private FlexibleDate 基準日;
    private GemmenGengakuShurui 減免減額種類;
    private FlexibleDate システム日付;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    /**
     *
     * @param 基準日 FlexibleDate
     * @param 減免減額種類 GemmenGengakuShurui
     * @param 前年度の開始日 FlexibleDate
     * @param 前年度の終了日 FlexibleDate
     */
    public GemmenGengakuTaishoGaiShaListMyBatisParameter(FlexibleDate 基準日, GemmenGengakuShurui 減免減額種類, FlexibleDate 前年度の開始日, FlexibleDate 前年度の終了日) {
        this.基準日 = 基準日;
        this.減免減額種類 = 減免減額種類;
        this.前年度の開始日 = 前年度の開始日;
        this.前年度の終了日 = 前年度の終了日;
        this.システム日付 = new FlexibleDate(RDate.getNowDate().toString());
    }

}
