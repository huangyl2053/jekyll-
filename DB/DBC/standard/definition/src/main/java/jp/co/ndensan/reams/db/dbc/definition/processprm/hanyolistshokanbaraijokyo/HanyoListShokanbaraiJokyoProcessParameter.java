/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(償還払い状況)ProcessParameter
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShokanbaraiJokyoProcessParameter implements IBatchProcessParameter {

    private static final RString 区切り文字 = new RString(",");
    private RString 保険者コード;
    private RString 保険者名;
    private FlexibleYearMonth サービス提供年月From;
    private FlexibleYearMonth サービス提供年月To;
    private RString 処理状況;
    private RString 決定情報;
    private RString 支払方法;
    private RString 金融機関コード;
    private RString 金融機関名称;
    private FlexibleDate 申請日From;
    private FlexibleDate 申請日To;
    private FlexibleDate 住宅改修支給届出日From;
    private FlexibleDate 住宅改修支給届出日To;
    private FlexibleDate 決定日From;
    private FlexibleDate 決定日To;
    private FlexibleYearMonth 国保連送付年月From;
    private FlexibleYearMonth 国保連送付年月To;
    private RString 様式番号選択;
    private RString 様式番号;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private Long 出力順;
    private RString 出力項目;
    private ReportId 帳票ID;
    private IKozaSearchKey searchkey;
    private List<KamokuCode> list;
    private RString reamsLoginId;

    /**
     * コンストラクタです
     */
    public HanyoListShokanbaraiJokyoProcessParameter() {
    }

    /**
     * コンストラクタです
     *
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param 保険者コード RString
     * @param 保険者名 RString
     * @param サービス提供年月From FlexibleYearMonth
     * @param サービス提供年月To FlexibleYearMonth
     * @param 処理状況 RString
     * @param 決定情報 RString
     * @param 支払方法 RString
     * @param 金融機関コード RString
     * @param 金融機関名称 RString
     * @param 申請日From FlexibleDate
     * @param 申請日To FlexibleDate
     * @param 住宅改修支給届出日From FlexibleDate
     * @param 住宅改修支給届出日To FlexibleDate
     * @param 決定日From FlexibleDate
     * @param 決定日To FlexibleDate
     * @param 国保連送付年月From FlexibleDate
     * @param 国保連送付年月To FlexibleDate
     * @param 様式番号選択 RString
     * @param 様式番号 RString
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付スラッシュ付加 boolean
     * @param 出力順 Long
     * @param 出力項目 RString
     * @param 帳票ID ReportId
     * @param reamsLoginId RString
     */
    public HanyoListShokanbaraiJokyoProcessParameter(
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString 保険者コード,
            RString 保険者名,
            FlexibleYearMonth サービス提供年月From,
            FlexibleYearMonth サービス提供年月To,
            RString 処理状況,
            RString 決定情報,
            RString 支払方法,
            RString 金融機関コード,
            RString 金融機関名称,
            FlexibleDate 申請日From,
            FlexibleDate 申請日To,
            FlexibleDate 住宅改修支給届出日From,
            FlexibleDate 住宅改修支給届出日To,
            FlexibleDate 決定日From,
            FlexibleDate 決定日To,
            FlexibleYearMonth 国保連送付年月From,
            FlexibleYearMonth 国保連送付年月To,
            RString 様式番号選択,
            RString 様式番号,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            Long 出力順,
            RString 出力項目,
            ReportId 帳票ID,
            RString reamsLoginId
    ) {
        this.searchkey = searchkey;
        this.list = list;
        this.保険者コード = 保険者コード;
        this.保険者名 = 保険者名;
        this.サービス提供年月From = サービス提供年月From;
        this.サービス提供年月To = サービス提供年月To;
        this.処理状況 = 処理状況;
        this.決定情報 = 決定情報;
        this.支払方法 = 支払方法;
        this.金融機関コード = 金融機関コード;
        this.金融機関名称 = 金融機関名称;
        this.申請日From = 申請日From;
        this.申請日To = 申請日To;
        this.住宅改修支給届出日From = 住宅改修支給届出日From;
        this.住宅改修支給届出日To = 住宅改修支給届出日To;
        this.決定日From = 決定日From;
        this.決定日To = 決定日To;
        this.国保連送付年月From = 国保連送付年月From;
        this.国保連送付年月To = 国保連送付年月To;
        this.様式番号選択 = 様式番号選択;
        this.様式番号 = 様式番号;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
        this.帳票ID = 帳票ID;
        this.reamsLoginId = reamsLoginId;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListShokanbaraiJokyoMybatisParameter toMybatisParam() {
        return new HanyoListShokanbaraiJokyoMybatisParameter(
                searchkey,
                list,
                保険者コード,
                保険者名,
                サービス提供年月From,
                サービス提供年月To,
                処理状況,
                決定情報,
                支払方法,
                金融機関コード,
                金融機関名称,
                申請日From,
                申請日To,
                住宅改修支給届出日From,
                住宅改修支給届出日To,
                決定日From,
                決定日To,
                国保連送付年月From,
                国保連送付年月To,
                様式番号選択,
                様式番号 != null ? 様式番号.split(区切り文字.toString()) : null,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                出力順,
                出力項目,
                帳票ID);
    }

}
