/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.processprm.dbd1200902;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.dbd1200902.FutanGenndoGakuNinnteiShouMybatisParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 負担限度額認定の認定証発行_processパラメタークラスです.
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class FutanGenndoGakuNinnteiShouProcessParameter implements IBatchProcessParameter {

    private TanpyoHakkoKubun 単票発行区分;
    private KyusochishaKubun 旧措置者区分;
    private FlexibleDate 年度開始日;
    private FlexibleDate 年度終了日;
    private TaishoKubun 対象区分;
    private FlexibleDate 対象日FROM;
    private FlexibleDate 対象日TO;
    private FlexibleDate 認定証の交付日;
    private Long 改頁出力順ID;

    /**
     * 負担限度額認定の認定証発行
     *
     * @param 単票発行区分 単票発行区分
     * @param 旧措置者区分 旧措置者区分
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 対象区分 対象区分
     * @param 対象日FROM 対象日FROM
     * @param 対象日TO 対象日TO
     * @param 認定証の交付日 認定証の交付日
     * @param 改頁出力順ID 改頁出力順ID
     */
    public FutanGenndoGakuNinnteiShouProcessParameter(TanpyoHakkoKubun 単票発行区分,
            KyusochishaKubun 旧措置者区分,
            FlexibleDate 年度開始日,
            FlexibleDate 年度終了日,
            TaishoKubun 対象区分,
            FlexibleDate 対象日FROM,
            FlexibleDate 対象日TO,
            FlexibleDate 認定証の交付日,
            Long 改頁出力順ID) {
        this.単票発行区分 = 単票発行区分;
        this.旧措置者区分 = 旧措置者区分;
        this.年度開始日 = 年度開始日;
        this.年度終了日 = 年度終了日;
        this.対象区分 = 対象区分;
        this.対象日FROM = 対象日FROM;
        this.対象日TO = 対象日TO;
        this.認定証の交付日 = 認定証の交付日;
        this.改頁出力順ID = 改頁出力順ID;
    }

    /**
     * SQL使用されたパラメターを取得します．
     *
     * @param psmShikibetsuTaisho psmShikibetsuTaisho
     * @param psmAtesaki psmAtesaki
     * @param 出力順 出力順
     * @param 帳票ID 帳票ID
     * @param 発行履歴固有情報_減免適用開始日 発行履歴固有情報_減免適用開始日
     * @param 発行履歴固有情報_被保番号 発行履歴固有情報_被保番号
     * @return SQL使用されたパラメター
     */
    public FutanGenndoGakuNinnteiShouMybatisParameter toFutanGenndoGakuNinnteiShouMybatisParameter(
            RString psmShikibetsuTaisho,
            RString psmAtesaki,
            RString 出力順,
            RString 帳票ID,
            RString 発行履歴固有情報_減免適用開始日,
            RString 発行履歴固有情報_被保番号) {
        return new FutanGenndoGakuNinnteiShouMybatisParameter(
                単票発行区分,
                旧措置者区分,
                年度開始日,
                年度終了日,
                対象区分,
                対象日FROM,
                対象日TO,
                psmShikibetsuTaisho,
                psmAtesaki,
                出力順,
                帳票ID,
                発行履歴固有情報_被保番号,
                発行履歴固有情報_減免適用開始日
        );
    }
}
