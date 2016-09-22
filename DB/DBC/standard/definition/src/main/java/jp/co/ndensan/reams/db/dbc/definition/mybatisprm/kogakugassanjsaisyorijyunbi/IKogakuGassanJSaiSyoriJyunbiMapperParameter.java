/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.kogakugassanjsaisyorijyunbi;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 高額合算自己負担額証明書情報取込のparameterです。<br>
 *
 * @reamsid_L DBC-2640-010 zhengshenlei
 */
@Getter
public class IKogakuGassanJSaiSyoriJyunbiMapperParameter {

    private final RString データ作成区分;
    private final FlexibleYearMonth 処理年月;
    private final HihokenshaNo 被保険者番号;
    private final FlexibleYear 対象年度;
    private final ShoKisaiHokenshaNo 保険者番号;
    private final RString 支給申請書整理番号;
    private final RString 自己負担額証明書整理番号;

    /**
     * コンストラクタです。
     *
     * @param データ作成区分 RString
     * @param 処理年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 RString
     * @param 自己負担額証明書整理番号 RString
     */
    public IKogakuGassanJSaiSyoriJyunbiMapperParameter(
            RString データ作成区分,
            FlexibleYearMonth 処理年月,
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            ShoKisaiHokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            RString 自己負担額証明書整理番号) {
        this.データ作成区分 = データ作成区分;
        this.処理年月 = 処理年月;
        this.被保険者番号 = 被保険者番号;
        this.対象年度 = 対象年度;
        this.保険者番号 = 保険者番号;
        this.支給申請書整理番号 = 支給申請書整理番号;
        this.自己負担額証明書整理番号 = 自己負担額証明書整理番号;
    }

    /**
     * 再処理準備のparameter
     *
     * @param データ作成区分 RString
     * @param 処理年月 RString
     * @return IKogakuGassanJSaiSyoriJyunbiMapperParameter
     */
    public static IKogakuGassanJSaiSyoriJyunbiMapperParameter create再処理準備Param(RString データ作成区分, FlexibleYearMonth 処理年月) {
        return new IKogakuGassanJSaiSyoriJyunbiMapperParameter(
                データ作成区分, 処理年月, HihokenshaNo.EMPTY, FlexibleYear.EMPTY, ShoKisaiHokenshaNo.EMPTY, RString.EMPTY, RString.EMPTY);
    }

    /**
     * マスタ更新のparameter
     *
     * @param データ作成区分 RString
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 FlexibleYear
     * @param 保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 RString
     * @return IKogakuGassanJSaiSyoriJyunbiMapperParameter
     */
    public static IKogakuGassanJSaiSyoriJyunbiMapperParameter createBeforeマスタ更新Param(
            RString データ作成区分, HihokenshaNo 被保険者番号, FlexibleYear 対象年度, ShoKisaiHokenshaNo 保険者番号, RString 支給申請書整理番号) {
        return new IKogakuGassanJSaiSyoriJyunbiMapperParameter(
                データ作成区分, FlexibleYearMonth.EMPTY, 被保険者番号, 対象年度, 保険者番号, 支給申請書整理番号, RString.EMPTY);
    }

    /**
     * マスタ更新のparameter
     *
     * @param 自己負担額証明書整理番号
     * @param 処理年月
     * @return IKogakuGassanJSaiSyoriJyunbiMapperParameter
     */
    public static IKogakuGassanJSaiSyoriJyunbiMapperParameter createマスタ更新Param(RString 自己負担額証明書整理番号, FlexibleYearMonth 処理年月) {
        return new IKogakuGassanJSaiSyoriJyunbiMapperParameter(
                RString.EMPTY, 処理年月, HihokenshaNo.EMPTY, FlexibleYear.EMPTY,
                ShoKisaiHokenshaNo.EMPTY, RString.EMPTY, 自己負担額証明書整理番号);
    }
}
