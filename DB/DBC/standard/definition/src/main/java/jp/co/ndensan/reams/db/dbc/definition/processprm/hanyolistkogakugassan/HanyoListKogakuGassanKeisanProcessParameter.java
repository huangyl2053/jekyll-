/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassan;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassan.HanyoListKogakuGassanKeisanMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3100-020 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanKeisanProcessParameter implements IBatchProcessParameter {

    private RString 抽出区分;
    private RString データ区分;
    private RString データ種類;
    private FlexibleYear 対象年度;
    private FlexibleYearMonth 受取年月From;
    private FlexibleYearMonth 受取年月To;
    private FlexibleYearMonth 送付年月From;
    private FlexibleYearMonth 送付年月To;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private LasdecCode 保険者コード;
    private Long 出力順;
    private RString 出力項目;
    private RString 介護合算_仮算定データ;
    private IShikibetsuTaishoPSMSearchKey searchKey;
    private ReportId 帳票ID;
    private SubGyomuCode サブ業務コード;

    /**
     * コンストラクタです
     */
    public HanyoListKogakuGassanKeisanProcessParameter() {
    }

    /**
     *
     * コンストラクタです
     *
     * @param 抽出区分 RString
     * @param データ区分 RString
     * @param データ種類 RString
     * @param 対象年度 FlexibleYear
     * @param 受取年月From FlexibleYearMonth
     * @param 受取年月To FlexibleYearMonth
     * @param 送付年月From FlexibleYearMonth
     * @param 送付年月To FlexibleYearMonth
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付スラッシュ付加 boolean
     * @param 保険者コード LasdecCode
     * @param 出力順 Long
     * @param 出力項目 RString
     */
    public HanyoListKogakuGassanKeisanProcessParameter(
            RString 抽出区分,
            RString データ区分,
            RString データ種類,
            FlexibleYear 対象年度,
            FlexibleYearMonth 受取年月From,
            FlexibleYearMonth 受取年月To,
            FlexibleYearMonth 送付年月From,
            FlexibleYearMonth 送付年月To,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            LasdecCode 保険者コード,
            Long 出力順,
            RString 出力項目
    ) {
        this.抽出区分 = 抽出区分;
        this.データ区分 = データ区分;
        this.データ種類 = データ種類;
        this.対象年度 = 対象年度;
        this.受取年月From = 受取年月From;
        this.受取年月To = 受取年月To;
        this.送付年月From = 送付年月From;
        this.送付年月To = 送付年月To;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.保険者コード = 保険者コード;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListKogakuGassanKeisanMybatisParameter toMybatisParam() {
        return new HanyoListKogakuGassanKeisanMybatisParameter(
                searchKey,
                抽出区分,
                データ区分,
                データ種類,
                対象年度,
                受取年月From,
                受取年月To,
                送付年月From,
                送付年月To,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                保険者コード,
                出力順,
                出力項目,
                介護合算_仮算定データ);
    }
}
