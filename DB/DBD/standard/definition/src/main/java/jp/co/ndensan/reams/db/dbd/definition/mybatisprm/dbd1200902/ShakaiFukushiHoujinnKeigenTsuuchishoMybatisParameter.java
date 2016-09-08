/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等軽減の通知書発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter implements IMyBatisParameter {

    private RString 社会福祉法人等利用者負担軽減;
    private FlexibleDate 決定日FROM;
    private FlexibleDate 決定日TO;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private boolean is年度開始日_不空白;
    private boolean is年度終了日_不空白;
    private boolean is単票発行区分_出力しない;
    private RString psmShikibetsuTaisho;
    private RString psmAtesaki;
    private RString 出力順;
    private RString 被保番号;
    private RString 減免適用開始日;
    private ReportId 帳票ID;
    private RString 介護受給;

    /**
     * コンストラクタです。
     *
     * @param 単票発行区分 TanpyoHakkoKubun
     * @param 決定日FROM FlexibleDate
     * @param 決定日TO FlexibleDate
     * @param 年度開始日 FlexibleDate
     * @param 年度終了日 FlexibleDate
     * @param psmShikibetsuTaisho RString
     * @param psmAtesaki RString
     * @param 出力順 RString
     * @param 被保番号 RString
     * @param 減免適用開始日 RString
     * @param 帳票ID ReportId
     */
    public ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter(TanpyoHakkoKubun 単票発行区分,
            FlexibleDate 決定日FROM,
            FlexibleDate 決定日TO,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順,
            RString 被保番号,
            RString 減免適用開始日,
            ReportId 帳票ID) {
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.psmAtesaki = psmAtesaki;
        this.出力順 = 出力順;
        this.被保番号 = 被保番号;
        this.減免適用開始日 = 減免適用開始日;
        this.帳票ID = 帳票ID;
        this.介護受給 = SubGyomuCode.DBD介護受給.value();
        edit年度開始日(年度開始日);
        edit年度終了日(年度終了日);
        edit減免減額種類();
        editis単票発行区分_出力しない(単票発行区分);
    }

    private void edit年度開始日(FlexibleDate 年度開始日) {
        if (年度開始日 != null && !年度開始日.isEmpty()) {
            is年度開始日_不空白 = true;
            this.年度開始日 = 年度開始日;
        }
    }

    private void edit年度終了日(FlexibleDate 年度終了日) {
        if (年度終了日 != null && !年度終了日.isEmpty()) {
            is年度終了日_不空白 = true;
            this.年度終了日 = 年度終了日;
        }
    }

    private void edit減免減額種類() {
        社会福祉法人等利用者負担軽減 = GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード();
    }

    private void editis単票発行区分_出力しない(TanpyoHakkoKubun 単票発行区分) {
        if (TanpyoHakkoKubun.出力しない.getコード().equals(単票発行区分.getコード())) {
            is単票発行区分_出力しない = true;
        }
    }
}
