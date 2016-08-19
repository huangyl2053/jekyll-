/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokeijoho;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計情報照会のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBU-4120-030 sunhaidi
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class TokeiJohoResearcherMybatisParameter {

    private final FlexibleDate 基準日;
    private final RString 被保険者区分コード;
    private final RString 住所地特例フラグ;
    private final boolean uses市町村コード;
    private final RString 市町村コード;
    private final FlexibleYear 賦課年度;
    private final int 徴収方法月;
    private final RString 徴収方法;
    private final RString 要介護認定状態区分コード;

    private TokeiJohoResearcherMybatisParameter(FlexibleDate 基準日,
            RString 被保険者区分コード,
            RString 住所地特例フラグ,
            boolean uses市町村コード,
            RString 市町村コード,
            FlexibleYear 賦課年度,
            int 徴収方法月,
            RString 徴収方法,
            RString 要介護認定状態区分コード) {
        this.基準日 = 基準日;
        this.被保険者区分コード = 被保険者区分コード;
        this.住所地特例フラグ = 住所地特例フラグ;
        this.uses市町村コード = uses市町村コード;
        this.市町村コード = 市町村コード;
        this.賦課年度 = 賦課年度;
        this.徴収方法月 = 徴収方法月;
        this.徴収方法 = 徴収方法;
        this.要介護認定状態区分コード = 要介護認定状態区分コード;
    }

    /**
     * 資格人数取得用パラメータを作成します。
     *
     * @param 基準日 FlexibleDate
     * @param 被保険者区分コード RString
     * @param 住所地特例フラグ boolean
     * @param 市町村コード RString
     * @return TokeiJohoResearcherMybatisParameter
     */
    public static TokeiJohoResearcherMybatisParameter createParam全市町村なし(FlexibleDate 基準日,
            RString 被保険者区分コード,
            boolean 住所地特例フラグ,
            RString 市町村コード) {
        return new TokeiJohoResearcherMybatisParameter(基準日,
                被保険者区分コード,
                new RString(Boolean.toString(住所地特例フラグ)),
                !RString.isNullOrEmpty(市町村コード) && !new RString("000000").equals(市町村コード),
                市町村コード,
                FlexibleYear.EMPTY, 0, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 資格人数取得用パラメータを作成します。
     *
     * @param 基準日 FlexibleDate
     * @param 被保険者区分コード RString
     * @param 住所地特例フラグ boolean
     * @param 市町村コード RString
     * @return TokeiJohoResearcherMybatisParameter
     */
    public static TokeiJohoResearcherMybatisParameter createParam全市町村あり(FlexibleDate 基準日,
            RString 被保険者区分コード,
            boolean 住所地特例フラグ,
            RString 市町村コード) {
        return new TokeiJohoResearcherMybatisParameter(基準日,
                被保険者区分コード,
                new RString(Boolean.toString(住所地特例フラグ)),
                !RString.isNullOrEmpty(市町村コード),
                市町村コード,
                FlexibleYear.EMPTY, 0, RString.EMPTY, RString.EMPTY);
    }

    /**
     * 賦課人数取得用パラメータを作成します。
     *
     * @param 基準日 FlexibleDate
     * @param 被保険者区分コード RString
     * @param 住所地特例フラグ boolean
     * @param 市町村コード RString
     * @param 徴収方法 RString
     *
     * @return TokeiJohoResearcherMybatisParameter
     */
    public static TokeiJohoResearcherMybatisParameter createParamFor賦課人数(FlexibleDate 基準日,
            RString 被保険者区分コード,
            boolean 住所地特例フラグ,
            RString 市町村コード,
            RString 徴収方法) {
        return new TokeiJohoResearcherMybatisParameter(基準日,
                被保険者区分コード,
                new RString(Boolean.toString(住所地特例フラグ)),
                !RString.isNullOrEmpty(市町村コード) && !new RString("000000").equals(市町村コード),
                市町村コード,
                基準日.getNendo(), 基準日.getMonthValue(), 徴収方法, RString.EMPTY);
    }

    /**
     * 要介護人数取得用パラメータを作成します。
     *
     * @param 基準日 FlexibleDate
     * @param 要介護認定状態区分コード RString
     * @param 市町村コード RString
     * @return TokeiJohoResearcherMybatisParameter
     */
    public static TokeiJohoResearcherMybatisParameter createParamFor要介護人数(FlexibleDate 基準日,
            RString 要介護認定状態区分コード,
            RString 市町村コード) {
        return new TokeiJohoResearcherMybatisParameter(基準日,
                RString.EMPTY,
                new RString(Boolean.FALSE.toString()),
                !RString.isNullOrEmpty(市町村コード) && !new RString("000000").equals(市町村コード),
                市町村コード,
                FlexibleYear.EMPTY,
                0,
                RString.EMPTY,
                要介護認定状態区分コード);
    }
}
