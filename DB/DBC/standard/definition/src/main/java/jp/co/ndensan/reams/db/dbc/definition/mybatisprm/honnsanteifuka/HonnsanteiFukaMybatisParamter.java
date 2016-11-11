/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.honnsanteifuka;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 共同処理用受給者異動のMybatisParameterです。
 *
 * @reamsid_L DBC-2770-060 zhangzhiming
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HonnsanteiFukaMybatisParamter implements IMyBatisParameter {

    private final RString 処理対象年月;
    private final RString 再処理区分;
    private final boolean 処理区分フラグ;
    private final RString psmShikibetsuTaisho;
    private final FlexibleDate 異動年月日;
    private final HihokenshaNo 被保険者番号;
    private static final RString 処理区分 = new RString("1");

    private HonnsanteiFukaMybatisParamter(RString 処理対象年月, RString 再処理区分, boolean 処理区分フラグ, RString psmShikibetsuTaisho,
            FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        this.処理対象年月 = 処理対象年月;
        this.再処理区分 = 再処理区分;
        this.処理区分フラグ = 処理区分フラグ;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.異動年月日 = 異動年月日;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * 共同処理用受給者異動データ作成のパラメータを生成します。
     *
     * @param 処理対象年月 処理対象年月
     * @param 再処理区分 再処理区分
     * @return HonnsanteiFukaMybatisParamter
     */
    public static HonnsanteiFukaMybatisParamter createSofuDataParam(RString 処理対象年月, RString 再処理区分) {
        boolean 処理区分フラグ = false;
        if (処理区分.equals(再処理区分)) {
            処理区分フラグ = true;
        }
        return new HonnsanteiFukaMybatisParamter(処理対象年月, 再処理区分, 処理区分フラグ, RString.EMPTY,
                FlexibleDate.EMPTY, HihokenshaNo.EMPTY);
    }

    /**
     * 共同処理用受給者異動データ作成のパラメータを生成します。
     *
     * @param 処理対象年月 処理対象年月
     * @param psmShikibetsuTaisho 宛名情報
     * @return HonnsanteiFukaMybatisParamter
     */
    public static HonnsanteiFukaMybatisParamter createParam(RString 処理対象年月, RString psmShikibetsuTaisho) {
        return new HonnsanteiFukaMybatisParamter(処理対象年月, RString.EMPTY, false, psmShikibetsuTaisho,
                FlexibleDate.EMPTY, HihokenshaNo.EMPTY);
    }

    /**
     * 共同処理用受給者異動データ作成のパラメータを生成します。
     *
     * @param 異動年月日 異動年月日
     * @param 被保険者番号 被保険者番号
     * @return HonnsanteiFukaMybatisParamter
     */
    public static HonnsanteiFukaMybatisParamter createIdouDateParam(FlexibleDate 異動年月日, HihokenshaNo 被保険者番号) {
        return new HonnsanteiFukaMybatisParamter(RString.EMPTY, RString.EMPTY, false, RString.EMPTY,
                異動年月日, 被保険者番号);
    }
}
