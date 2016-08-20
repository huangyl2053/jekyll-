/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.gemmenshinseishotaishohaaku;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.RiyoshaFutanDankaiHanni;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbz.definition.core.shotoku.SetaiKazeiKubun;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DBDBZ12021_2_減免減額申請書発行用対象者把握（バッチ）のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-3530-040 liuwei2
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter implements IMyBatisParameter {

    private boolean is利用者負担段階_利用者負担1至3段階;
    private boolean is利用者負担段階_利用者負担1段階;
    private boolean is利用者負担段階_利用者負担2段階;
    private boolean is利用者負担段階_利用者負担3段階;
    private boolean is利用者負担段階_利用者負担4段階;

    private FlexibleDate 基準日;
    private RString 利用者負担段階;
    private boolean 課税世帯の被保険者を含む;
    private boolean 市町村民税非課税世帯;
    private boolean 市町村民税本人非課税者;
    private boolean 老齢福祉年金受給者;
    private boolean 生活保護受給者;
    private GemmenGengakuShurui 減免減額種類;
    private FlexibleDate 前年度の開始日;
    private FlexibleDate 前年度の終了日;

    private RString CODE_利用者負担1至3段階 = RiyoshaFutanDankaiHanni.利用者負担1から3段階.get名称();
    private RString CODE_利用者負担1段階 = RiyoshaFutanDankaiHanni.利用者負担1段階.get名称();
    private RString CODE_利用者負担2段階 = RiyoshaFutanDankaiHanni.利用者負担2段階.get名称();
    private RString CODE_利用者負担3段階 = RiyoshaFutanDankaiHanni.利用者負担3段階.get名称();
    private RString CODE_利用者負担4段階 = RiyoshaFutanDankaiHanni.利用者負担4段階_高齢者複数世帯.get名称();

    private RString CODE_世帯課税区分_課税 = SetaiKazeiKubun.課税.getコード();
    private RString CODE_世帯課税区分_非課税 = SetaiKazeiKubun.非課税.getコード();

    /**
     *
     * @param 基準日 FlexibleDate
     * @param 利用者負担段階 RString
     * @param 課税世帯の被保険者を含む boolean
     * @param 市町村民税非課税世帯 boolean
     * @param 市町村民税本人非課税者 boolean
     * @param 老齢福祉年金受給者 boolean
     * @param 生活保護受給者 boolean
     * @param 減免減額種類 GemmenGengakuShurui
     * @param 前年度の開始日 FlexibleDate
     * @param 前年度の終了日 FlexibleDate
     */
    public ShinseishoHakkoTaishoJohoSakuseiMyBatisParameter(boolean 課税世帯の被保険者を含む,
            GemmenGengakuShurui 減免減額種類, RString 利用者負担段階, boolean 市町村民税非課税世帯, boolean 市町村民税本人非課税者, boolean 老齢福祉年金受給者, boolean 生活保護受給者,
            FlexibleDate 基準日, FlexibleDate 前年度の開始日, FlexibleDate 前年度の終了日) {
        this.市町村民税本人非課税者 = 市町村民税本人非課税者;
        this.市町村民税非課税世帯 = 市町村民税非課税世帯;
        this.生活保護受給者 = 生活保護受給者;
        this.老齢福祉年金受給者 = 老齢福祉年金受給者;
        this.課税世帯の被保険者を含む = 課税世帯の被保険者を含む;
        this.基準日 = 基準日;
        set利用者負担段階について(利用者負担段階);
        this.減免減額種類 = 減免減額種類;
        this.前年度の開始日 = 前年度の開始日;
        this.前年度の終了日 = 前年度の終了日;
    }

    private void set利用者負担段階について(RString 利用者負担段階) {
        is利用者負担段階_利用者負担1至3段階 = false;
        is利用者負担段階_利用者負担1段階 = false;
        is利用者負担段階_利用者負担2段階 = false;
        is利用者負担段階_利用者負担3段階 = false;
        is利用者負担段階_利用者負担4段階 = false;
        if (CODE_利用者負担1至3段階.equals(利用者負担段階)) {
            is利用者負担段階_利用者負担1至3段階 = true;
        }
        if (CODE_利用者負担1段階.equals(利用者負担段階)) {
            is利用者負担段階_利用者負担1段階 = true;
        }
        if (CODE_利用者負担2段階.equals(利用者負担段階)) {
            is利用者負担段階_利用者負担2段階 = true;
        }
        if (CODE_利用者負担3段階.equals(利用者負担段階)) {
            is利用者負担段階_利用者負担3段階 = true;
        }
        if (CODE_利用者負担4段階.equals(利用者負担段階)) {
            is利用者負担段階_利用者負担4段階 = true;
        }
    }
}
