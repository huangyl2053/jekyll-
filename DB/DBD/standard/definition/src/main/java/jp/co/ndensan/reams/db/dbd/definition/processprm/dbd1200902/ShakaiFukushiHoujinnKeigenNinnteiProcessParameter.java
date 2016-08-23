/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 社会福祉法人等軽減の認定証発行_processパラメタークラスです.
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShakaiFukushiHoujinnKeigenNinnteiProcessParameter implements IBatchProcessParameter {

    private TanpyoHakkoKubun 単票発行区分;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private FlexibleDate 決定日FROM;
    private FlexibleDate 決定日TO;
    private FlexibleDate 認定証の交付日;
    private Long 改頁出力順ID;

    /**
     * 社会福祉法人等軽減の認定証発行
     *
     * @param 単票発行区分 単票発行区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 決定日FROM 決定日FROM
     * @param 決定日TO 決定日TO
     * @param 認定証の交付日 認定証の交付日
     * @param 改頁出力順ID 改頁出力順ID
     */
    public ShakaiFukushiHoujinnKeigenNinnteiProcessParameter(TanpyoHakkoKubun 単票発行区分,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            FlexibleDate 決定日FROM,
            FlexibleDate 決定日TO,
            FlexibleDate 認定証の交付日,
            Long 改頁出力順ID) {
        this.単票発行区分 = 単票発行区分;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.決定日FROM = 決定日FROM;
        this.決定日TO = 決定日TO;
        this.認定証の交付日 = 認定証の交付日;
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * SQL用パラメターを取得します．
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 出力順 出力順
     * @param 帳票ID 帳票ID
     * @return SQL用パラメター
     */
    public ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter toShakaiFukushiHoujinnKeigenNinnteiMybatisParameter(RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順,
            RString 帳票ID) {
        return new ShakaiFukushiHoujinnKeigenNinnteiMybatisParameter(単票発行区分,
                年度開始日,
                年度終了日,
                決定日FROM,
                決定日TO,
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順,
                帳票ID);
    }
}
