/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のMybatisパラメータです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiMybatisParameter implements IMyBatisParameter {

    private FlexibleYearMonth shoriYM;
    private RString saishoriKubun;
    private RString shutsuryokujunId;
    private RString 出力順;
    private RString 国保連共同処理受託区分_償還;
    private RString 国保連共同処理受託区分_高額;
    private HokenshaNo 保険者番号;

    private NyuryokuShikibetsuNo inputShikibetsuNo;
    private HihokenshaNo hiHokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private JigyoshaNo jigyoshoNo;
    private RString toshiNo;
    private RString kyufuSakuseiKubunCode;

    /**
     * コンストラクタです。
     */
    public HokenshaKyufujissekiMybatisParameter() {
    }

    /**
     * コンストラクタです。
     *
     * @param shoriYM 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryokujunId 出力順ID
     * @param 国保連共同処理受託区分_償還 RString
     * @param 国保連共同処理受託区分_高額 RString
     * @param 保険者番号 HokenshaNo
     */
    public HokenshaKyufujissekiMybatisParameter(FlexibleYearMonth shoriYM,
            RString saishoriKubun,
            RString shutsuryokujunId,
            RString 国保連共同処理受託区分_償還,
            RString 国保連共同処理受託区分_高額,
            HokenshaNo 保険者番号) {
        this.shoriYM = shoriYM;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryokujunId = shutsuryokujunId;
        this.国保連共同処理受託区分_償還 = 国保連共同処理受託区分_償還;
        this.国保連共同処理受託区分_高額 = 国保連共同処理受託区分_高額;
        this.保険者番号 = 保険者番号;
    }
}
