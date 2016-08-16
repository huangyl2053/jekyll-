/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1080001;

import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku.ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
public class ShinseishoHakkoTaishoJohoSakuseiProcessParameter implements IBatchProcessParameter {

    private boolean 課税世帯の被保険者を含む;
    private GemmenGengakuShurui 減免減額種類;
    private RString 利用者負担段階;
    private boolean 市町村民税非課税世帯;
    private boolean 市町村民税本人非課税者;
    private boolean 老齢福祉年金受給者;
    private boolean 生活保護受給者;
    private FlexibleYear 所得年度;
    private FlexibleDate 基準日;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    public ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter ShinseishoHakkoTaishoJohoSakuseiMybatisParameter(FlexibleDate 開始日, FlexibleDate 終了日) {
        this.前年度の開始日 = 開始日;
        this.前年度の終了日 = 終了日;
        return new ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter(課税世帯の被保険者を含む, 減免減額種類, 利用者負担段階, 市町村民税非課税世帯, 市町村民税本人非課税者, 老齢福祉年金受給者, 生活保護受給者,
                基準日, 前年度の開始日, 前年度の終了日);
    }
}
