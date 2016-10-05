/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等軽減の認定証発行_SQL使用パラメタークラスです.
 *
 * @reamsid_L DBD-3981-050 x_xuliang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter implements IMyBatisParameter {

    private boolean is年度開始日_非空白 = false;
    private boolean is年度終了日_非空白 = false;
    private boolean is単票発行区分_出力しない = false;
    private RString 決定区分_承認する;
    private RString 社会福祉法人等利用者負担軽減;
    private FlexibleDate 決定日FROM;
    private FlexibleDate 決定日TO;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private ReportId 帳票ID;
    private RString 出力順;
    private RString 被保番号;
    private RString 介護受給;
    private RString 減免適用開始日;

    /**
     * 社会福祉法人等軽減の認定証発行
     *
     * @param 単票発行区分 単票発行区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 決定日FROM 決定日FROM
     * @param 決定日TO 決定日TO
     * @param 出力順 出力順
     * @param 帳票ID 帳票ID
     * @param 被保番号 RString
     * @param 減免適用開始日 RString
     */
    public ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter(TanpyoHakkoKubun 単票発行区分,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            FlexibleDate 決定日FROM,
            FlexibleDate 決定日TO,
            RString 出力順,
            ReportId 帳票ID,
            RString 被保番号,
            RString 減免適用開始日) {
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.決定区分_承認する = KetteiKubun.承認する.getコード();
        this.介護受給 = SubGyomuCode.DBD介護受給.value();
        this.被保番号 = 被保番号;
        this.出力順 = 出力順;
        this.帳票ID = 帳票ID;
        this.減免適用開始日 = 減免適用開始日;
        this.社会福祉法人等利用者負担軽減 = GemmenGengakuShurui.社会福祉法人等利用者負担軽減.getコード();
        if (年度開始日 != null && !年度開始日.isEmpty()) {
            is年度開始日_非空白 = true;
        }
        if (年度終了日 != null && !年度開始日.isEmpty()) {
            is年度終了日_非空白 = true;
        }
        if (TanpyoHakkoKubun.出力しない.getコード().equals(単票発行区分.getコード())) {
            is単票発行区分_出力しない = true;
        }
    }

}
