/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hokenshakyufujisseki;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hokenshakyufujisseki.HokenshaKyufujissekiMybatisParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 保険者保有給付実績情報作成のProcessパラメータです。
 *
 * @reamsid_L DBC-2460-010 gongliang
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HokenshaKyufujissekiProcessParameter implements IBatchProcessParameter {

    private FlexibleYearMonth shoriYM;
    private RString saishoriKubun;
    private RString shutsuryokujunId;
    private RString 国保連共同処理受託区分_償還;
    private RString 国保連共同処理受託区分_高額;
    private int 基本件数;
    private YMDHMS now;
    private HokenshaNo 保険者番号;

    /**
     * コンストラクタです。
     *
     * @param shoriYM 処理年月
     * @param saishoriKubun 再処理区分
     * @param shutsuryokujunId 出力順ID
     * @param now YMDHMS
     */
    public HokenshaKyufujissekiProcessParameter(FlexibleYearMonth shoriYM,
            RString saishoriKubun,
            RString shutsuryokujunId,
            YMDHMS now) {
        this.shoriYM = shoriYM;
        this.saishoriKubun = saishoriKubun;
        this.shutsuryokujunId = shutsuryokujunId;
        this.now = now;
    }

    /**
     * MybatisParameterを作成する。
     *
     * @return HokenshaKyufujissekiMybatisParameter
     */
    public HokenshaKyufujissekiMybatisParameter toHokenshaKyufujissekiMybatisParameter() {
        return new HokenshaKyufujissekiMybatisParameter(
                shoriYM, saishoriKubun, shutsuryokujunId, 国保連共同処理受託区分_償還, 国保連共同処理受託区分_高額, 保険者番号);
    }
}
