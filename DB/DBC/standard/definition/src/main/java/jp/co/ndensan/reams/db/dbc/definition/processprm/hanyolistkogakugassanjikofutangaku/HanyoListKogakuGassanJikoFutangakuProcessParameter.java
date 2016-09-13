/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanjikofutangaku;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanjikofutangaku.HanyoListKogakuGassanJikoFutangakuMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(高額合算自己負担額情報)のProcessパラメータです。
 *
 * @reamsid_L DBC-3102-020 sunqingzhu
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanJikoFutangakuProcessParameter implements IBatchProcessParameter {

    private RString 抽出区分;
    private RString データ作成区分;
    private RString データ種類;
    private RString 補正状況;
    private RString 対象年度;
    private FlexibleDate 申請年月日From;
    private FlexibleDate 申請年月日To;
    private RString 支給申請書整理番号From;
    private RString 支給申請書整理番号To;
    private boolean 送付対象外;
    private FlexibleYearMonth 自己負担額確認情報受取年月From;
    private FlexibleYearMonth 自己負担額確認情報受取年月To;
    private FlexibleYearMonth 補正済自己負担額情報送付年月From;
    private FlexibleYearMonth 補正済自己負担額情報送付年月To;
    private FlexibleYearMonth 自己負担額証明書情報受取年月From;
    private FlexibleYearMonth 自己負担額証明書情報受取年月To;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private RString 保険者コード;
    private Long 出力順;
    private RString 出力項目;
    private IShikibetsuTaishoPSMSearchKey searchKey;

    /**
     * コンストラクタです。
     *
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
    public HanyoListKogakuGassanJikoFutangakuProcessParameter(
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
            RString 出力項目) {

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

    /**
     * 汎用リスト出力(高額合算自己負担額情報)のMyBatisパラメータ作成です。
     *
     * @return 汎用リスト出力(高額合算自己負担額情報)のMyBatisパラメータ
     */
    public HanyoListKogakuGassanJikoFutangakuMybatisParameter toMybatisParamter() {

        return new HanyoListKogakuGassanJikoFutangakuMybatisParameter(
                searchKey,
                抽出区分,
                データ作成区分,
                データ種類,
                補正状況,
                対象年度,
                申請年月日From,
                申請年月日To,
                支給申請書整理番号From,
                支給申請書整理番号To,
                送付対象外,
                自己負担額確認情報受取年月From,
                自己負担額確認情報受取年月To,
                補正済自己負担額情報送付年月From,
                補正済自己負担額情報送付年月To,
                自己負担額証明書情報受取年月From,
                自己負担額証明書情報受取年月To,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                保険者コード,
                出力順,
                出力項目);
    }
}
