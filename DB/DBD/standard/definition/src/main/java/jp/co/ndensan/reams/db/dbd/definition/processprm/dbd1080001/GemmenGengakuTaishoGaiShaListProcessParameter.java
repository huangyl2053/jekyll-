/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.GemmenGengakuTaishoGaiShaListMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import lombok.Getter;
import lombok.Setter;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のProcessのパラメータクラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GemmenGengakuTaishoGaiShaListProcessParameter implements IBatchProcessParameter {

    private GemmenGengakuShurui 減免減額種類;
    private FlexibleDate 基準日;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    /**
     *
     * @param 減免減額種類 GemmenGengakuShurui
     * @param 基準日 FlexibleDate
     */
    public GemmenGengakuTaishoGaiShaListProcessParameter(GemmenGengakuShurui 減免減額種類, FlexibleDate 基準日) {
        this.基準日 = 基準日;
        this.減免減額種類 = 減免減額種類;
    }

    /**
     * MybatisParameterを取得する。
     *
     * @param 開始日 FlexibleDate
     * @param 終了日 FlexibleDate
     * @return MybatisParameter
     */
    public GemmenGengakuTaishoGaiShaListMyBatisParameter toGemmenGengakuTaishoGaiShaListMyBatisParameter(FlexibleDate 開始日, FlexibleDate 終了日) {
        this.前年度の開始日 = 開始日;
        this.前年度の終了日 = 終了日;
        return new GemmenGengakuTaishoGaiShaListMyBatisParameter(基準日, 減免減額種類, 前年度の開始日, 前年度の終了日);
    }
}
