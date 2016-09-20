/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkogakugassanshikyugakukettei;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.hanyolistkogakugassanshikyugakukettei.HanyoListKogakuGassanShikyugakuKetteiMybatisParameter;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.koza.IKozaSearchKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 汎用リスト出力(高額合算計算結果連絡票情報)ProcessParameterクラスです。
 *
 * @reamsid_L DBC-3101-020 jiangxiaolong
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListKogakuGassanShikyugakuKetteiProcessParameter implements IBatchProcessParameter {

    private RString 支給区分;
    private RString 支払方法区分;
    private KinyuKikanCode 金融機関コード;
    private RString 金融機関名称;
    private RString 対象年度;
    private FlexibleYearMonth 決定情報受取年月From;
    private FlexibleYearMonth 決定情報受取年月To;
    private boolean 項目名付加;
    private boolean 連番付加;
    private boolean 日付スラッシュ付加;
    private LasdecCode 保険者コード;
    private RString 出力順;
    private RString 出力項目;
    private RString reamsLoginId;
    private IKozaSearchKey searchkey;
    private List<KamokuCode> list;
    private ReportId 帳票ID;
    private SubGyomuCode サブ業務コード;
    private Long 出力順ID;

    /**
     * コンストラクタです
     */
    public HanyoListKogakuGassanShikyugakuKetteiProcessParameter() {
    }

    /**
     * コンストラクタです
     *
     * @param 支給区分 RString
     * @param 支払方法区分 RString
     * @param 金融機関コード KinyuKikanCode
     * @param 金融機関名称 RString
     * @param 対象年度 RString
     * @param 決定情報受取年月From FlexibleYearMonth
     * @param 決定情報受取年月To FlexibleYearMonth
     * @param 項目名付加 boolean
     * @param 連番付加 boolean
     * @param 日付スラッシュ付加 boolean
     * @param 保険者コード LasdecCode
     * @param 出力順 RString
     * @param 出力項目 RString
     * @param searchkey IKozaSearchKey
     * @param list List<KamokuCode>
     * @param reamsLoginId RString
     */
    public HanyoListKogakuGassanShikyugakuKetteiProcessParameter(
            RString 支給区分,
            RString 支払方法区分,
            KinyuKikanCode 金融機関コード,
            RString 金融機関名称,
            RString 対象年度,
            FlexibleYearMonth 決定情報受取年月From,
            FlexibleYearMonth 決定情報受取年月To,
            boolean 項目名付加,
            boolean 連番付加,
            boolean 日付スラッシュ付加,
            LasdecCode 保険者コード,
            RString 出力順,
            RString 出力項目,
            IKozaSearchKey searchkey,
            List<KamokuCode> list,
            RString reamsLoginId
    ) {
        this.支給区分 = 支給区分;
        this.支払方法区分 = 支払方法区分;
        this.金融機関コード = 金融機関コード;
        this.金融機関名称 = 金融機関名称;
        this.対象年度 = 対象年度;
        this.決定情報受取年月From = 決定情報受取年月From;
        this.決定情報受取年月To = 決定情報受取年月To;
        this.項目名付加 = 項目名付加;
        this.連番付加 = 連番付加;
        this.日付スラッシュ付加 = 日付スラッシュ付加;
        this.保険者コード = 保険者コード;
        this.出力順 = 出力順;
        this.出力項目 = 出力項目;
        this.searchkey = searchkey;
        this.list = list;
        this.reamsLoginId = reamsLoginId;
    }

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListKogakuGassanShikyugakuKetteiMybatisParameter toMybatisParam() {
        return new HanyoListKogakuGassanShikyugakuKetteiMybatisParameter(
                支給区分,
                支払方法区分,
                金融機関コード,
                金融機関名称,
                対象年度,
                決定情報受取年月From,
                決定情報受取年月To,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                保険者コード,
                出力順,
                出力項目,
                searchkey,
                list
        );
    }
}
