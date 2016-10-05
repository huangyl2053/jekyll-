/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanjikofutangaku;

import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算自己負担額情報)のMybatisパラメータです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanJikoFutangakuMybatisParameter extends UaFt200FindShikibetsuTaishoParam
        implements IMyBatisParameter {

    private final RString 抽出区分;
    private final RString データ作成区分;
    private final RString データ種類;
    private final RString 補正状況;
    private final RString 対象年度;
    private final FlexibleDate 申請年月日From;
    private final FlexibleDate 申請年月日To;
    private final RString 支給申請書整理番号From;
    private final RString 支給申請書整理番号To;
    private final boolean 送付対象外;
    private final FlexibleYearMonth 自己負担額確認情報受取年月From;
    private final FlexibleYearMonth 自己負担額確認情報受取年月To;
    private final FlexibleYearMonth 補正済自己負担額情報送付年月From;
    private final FlexibleYearMonth 補正済自己負担額情報送付年月To;
    private final FlexibleYearMonth 自己負担額証明書情報受取年月From;
    private final FlexibleYearMonth 自己負担額証明書情報受取年月To;
    private final boolean 項目名付加;
    private final boolean 連番付加;
    private final boolean 日付スラッシュ付加;
    private final RString 保険者コード;
    private final Long 出力順;
    private final RString 出力項目;

    /**
     * コンストラクタです。
     *
     * @param searchKey IShikibetsuTaishoPSMSearchKey
     * @param 抽出区分 RString
     * @param データ作成区分 RString
     * @param データ種類 RString
     * @param 補正状況 RString
     * @param 対象年度 RString
     * @param 申請年月日From FlexibleYearMonth
     * @param 申請年月日To FlexibleYearMonth
     * @param 支給申請書整理番号From RString
     * @param 支給申請書整理番号To RString
     * @param 送付対象外 RString
     * @param 自己負担額確認情報受取年月From FlexibleDate
     * @param 自己負担額確認情報受取年月To FlexibleDate
     * @param 補正済自己負担額情報送付年月From FlexibleDate
     * @param 補正済自己負担額情報送付年月To FlexibleDate
     * @param 自己負担額証明書情報受取年月From FlexibleDate
     * @param 自己負担額証明書情報受取年月To FlexibleDate
     * @param 項目名付加 RString
     * @param 連番付加 RString
     * @param 日付スラッシュ付加 RString
     * @param 保険者コード RString
     * @param 出力順 RString
     * @param 出力項目 RString
     *
     */
    public HanyoListKogakuGassanJikoFutangakuMybatisParameter(
            IShikibetsuTaishoPSMSearchKey searchKey,
            RString 抽出区分,
            RString データ作成区分,
            RString データ種類,
            RString 補正状況,
            RString 対象年度,
            FlexibleDate 申請年月日From,
            FlexibleDate 申請年月日To,
            RString 支給申請書整理番号From,
            RString 支給申請書整理番号To,
            boolean 送付対象外,
            FlexibleYearMonth 自己負担額確認情報受取年月From,
            FlexibleYearMonth 自己負担額確認情報受取年月To,
            FlexibleYearMonth 補正済自己負担額情報送付年月From,
            FlexibleYearMonth 補正済自己負担額情報送付年月To,
            FlexibleYearMonth 自己負担額証明書情報受取年月From,
            FlexibleYearMonth 自己負担額証明書情報受取年月To,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            RString 保険者コード,
            Long 出力順,
            RString 出力項目
    ) {
        super(searchKey);
        this.抽出区分 = 抽出区分;
        this.データ作成区分 = データ作成区分;
        this.データ種類 = データ種類;
        this.補正状況 = 補正状況;
        this.対象年度 = 対象年度;
        this.申請年月日From = 申請年月日From;
        this.申請年月日To = 申請年月日To;
        this.支給申請書整理番号From = 支給申請書整理番号From;
        this.支給申請書整理番号To = 支給申請書整理番号To;
        this.送付対象外 = 送付対象外;
        this.自己負担額確認情報受取年月From = 自己負担額確認情報受取年月From;
        this.自己負担額確認情報受取年月To = 自己負担額確認情報受取年月To;
        this.補正済自己負担額情報送付年月From = 補正済自己負担額情報送付年月From;
        this.補正済自己負担額情報送付年月To = 補正済自己負担額情報送付年月To;
        this.自己負担額証明書情報受取年月From = 自己負担額証明書情報受取年月From;
        this.自己負担額証明書情報受取年月To = 自己負担額証明書情報受取年月To;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.保険者コード = 保険者コード;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
    }

}
