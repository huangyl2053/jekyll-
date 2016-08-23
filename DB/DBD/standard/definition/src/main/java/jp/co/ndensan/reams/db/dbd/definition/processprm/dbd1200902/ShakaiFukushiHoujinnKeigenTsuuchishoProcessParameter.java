/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等軽減の通知書発行_processパラメタークラスです.
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter implements IBatchProcessParameter {

    private TanpyoHakkoKubun 単票発行区分;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private FlexibleDate 決定日FROM;
    private FlexibleDate 決定日TO;
    private FlexibleDate 通知書の発行日;
    private RString 通知書の文書番号;
    private Long 改頁出力順ID;

    /**
     * コンストラクタです。
     *
     * @param 単票発行区分 単票発行区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 決定日FROM 決定日FROM
     * @param 決定日TO 決定日TO
     * @param 通知書の発行日 通知書の発行日
     * @param 通知書の文書番号 通知書の文書番号
     * @param 改頁出力順ID 改頁出力順ID
     */
    public ShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter(TanpyoHakkoKubun 単票発行区分,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            FlexibleDate 決定日FROM,
            FlexibleDate 決定日TO,
            FlexibleDate 通知書の発行日,
            RString 通知書の文書番号,
            Long 改頁出力順ID) {
        this.単票発行区分 = 単票発行区分;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.通知書の発行日 = 通知書の発行日;
        this.通知書の文書番号 = 通知書の文書番号;
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * 負担限度額認定の認定証発行SQLを取得します．
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 被保番号 被保番号
     * @param 減免適用開始日 減免適用開始日
     * @param 帳票ID 帳票ID
     * @param 出力順 出力順
     * @return 負担限度額認定の認定証発行SQL用パラメター
     */
    public ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter toShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 被保番号,
            RString 減免適用開始日,
            ReportId 帳票ID,
            RString 出力順) {
        return new ShakaiFukushiHoujinnKeigenTsuuchishoMybatisParameter(単票発行区分,
                決定日FROM,
                決定日TO,
                年度開始日,
                年度終了日,
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順,
                被保番号,
                減免適用開始日,
                帳票ID
        );
    }
}
