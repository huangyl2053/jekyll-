/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.HanteiTaishoshaTokuteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
public class GemmenShinseishoTaishohaakuProcessParameter implements IBatchProcessParameter {

    private RString 新規更新区分;
    private GemmenGengakuShurui 減免減額種類;
    private RString 旧措置区分;
    private RString 施設入所区分;
    private FlexibleDate 基準日;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    /**
     * MybatisParameterを取得する。
     *
     * @param 開始日 FlexibleDate
     * @param 終了日 FlexibleDate
     * @return MybatisParameter
     */
    public HanteiTaishoshaTokuteiMyBatisParameter toGemmenShinseishoTaishohaakuMybatisParameter(FlexibleDate 開始日, FlexibleDate 終了日) {
        this.前年度の開始日 = 開始日;
        this.前年度の終了日 = 終了日;
        return new HanteiTaishoshaTokuteiMyBatisParameter(新規更新区分, 減免減額種類, 旧措置区分, 施設入所区分, 基準日, 前年度の開始日, 前年度の終了日);
    }
}
