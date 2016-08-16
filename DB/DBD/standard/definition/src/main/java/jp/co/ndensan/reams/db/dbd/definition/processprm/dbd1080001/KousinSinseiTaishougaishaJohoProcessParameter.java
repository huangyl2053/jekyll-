/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001;

import java.util.UUID;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.KousinSinseiTaishougaishaJohoMyBatisParameter;
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
public class KousinSinseiTaishougaishaJohoProcessParameter implements IBatchProcessParameter {

    private FlexibleDate 基準日;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;
    private GemmenGengakuShurui 減免減額種類;
    private UUID 把握処理ID;

    public KousinSinseiTaishougaishaJohoMyBatisParameter ShinseishoHakkoTaishoJohoSakuseiMybatisParameter(FlexibleDate 開始日, FlexibleDate 終了日, UUID 把握処理ID) {
        this.前年度の開始日 = 開始日;
        this.前年度の終了日 = 終了日;
        this.把握処理ID = 把握処理ID;
        return new KousinSinseiTaishougaishaJohoMyBatisParameter(把握処理ID, 減免減額種類,
                基準日, 前年度の開始日, 前年度の終了日);
    }
}
