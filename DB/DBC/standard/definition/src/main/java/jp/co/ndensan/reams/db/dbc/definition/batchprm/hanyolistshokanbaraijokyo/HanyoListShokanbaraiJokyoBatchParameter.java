/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolistshokanbaraijokyo;

import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistshokanbaraijokyo.HanyoListShokanbaraiJokyoProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 汎用リスト出力(償還払い状況)BatchParameter
 *
 * @reamsid_L DBC-3093-020 chenaoqi
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HanyoListShokanbaraiJokyoBatchParameter extends BatchParameterBase {

    private static final String HOKENSHACODE = "保険者コード";
    private static final String HOKENSHANAME = "保険者名";
    private static final String SERVICETEIKYOYMFROM = "サービス提供年月From";
    private static final String SERVICETEIKYOYMTO = "サービス提供年月To";
    private static final String SOFUYMFROM = "国保連送付年月From";
    private static final String SOFUYMTO = "国保連送付年月To";
    private static final String SHINSEIDATEFROM = "申請日From";
    private static final String SHINSEIDATETO = "申請日To";
    private static final String UKETSUKEYMDFROM = "住宅改修支給届出日From";
    private static final String UKETSUKEYMDTO = "住宅改修支給届出日To";
    private static final String YOSHIKINOCH = "様式番号選択";
    private static final String YOSHIKINO = "様式番号";
    private static final String KETTEIDATEFROM = "決定日From";
    private static final String KETTEIDATETO = "決定日To";
    private static final String REPORTID = "帳票ID";
    private static final String INTPUT = "出力項目";
    private static final String OUTPUT = "出力順";
    private static final String DATE = "日付スラッシュ付加";
    private static final String SERINO = "連番付加";
    private static final String PROGRAMNAME = "項目名付加";
    private static final String TREATSTATUS = "処理状況";
    private static final String KETTEIINFO = "決定情報";
    private static final String KINYUKIKANCODE = "金融機関コード";
    private static final String KINYUKIKANNAME = "金融機関名称";
    private static final String SHIHARAIHOHO = "支払方法";
    private static final String KEY_REAMS_LOGIN_ID = "reamsLoginId";

    @BatchParameter(key = HOKENSHACODE, name = "保険者コード")
    private RString 保険者コード;
    @BatchParameter(key = HOKENSHANAME, name = "保険者名")
    private RString 保険者名;
    @BatchParameter(key = SERVICETEIKYOYMFROM, name = "サービス提供年月From")
    private FlexibleYearMonth サービス提供年月From;
    @BatchParameter(key = SERVICETEIKYOYMTO, name = "サービス提供年月To")
    private FlexibleYearMonth サービス提供年月To;
    @BatchParameter(key = TREATSTATUS, name = "処理状況")
    private RString 処理状況;
    @BatchParameter(key = KETTEIINFO, name = "決定情報")
    private RString 決定情報;
    @BatchParameter(key = SHIHARAIHOHO, name = "支払方法")
    private RString 支払方法;
    @BatchParameter(key = KINYUKIKANCODE, name = "金融機関コード")
    private RString 金融機関コード;
    @BatchParameter(key = KINYUKIKANNAME, name = "金融機関名称")
    private RString 金融機関名称;
    @BatchParameter(key = SHINSEIDATEFROM, name = "申請日From")
    private FlexibleDate 申請日From;
    @BatchParameter(key = SHINSEIDATETO, name = "申請日To")
    private FlexibleDate 申請日To;
    @BatchParameter(key = UKETSUKEYMDFROM, name = "住宅改修支給届出日From")
    private FlexibleDate 住宅改修支給届出日From;
    @BatchParameter(key = UKETSUKEYMDTO, name = "住宅改修支給届出日To")
    private FlexibleDate 住宅改修支給届出日To;
    @BatchParameter(key = KETTEIDATEFROM, name = "決定日From")
    private FlexibleDate 決定日From;
    @BatchParameter(key = KETTEIDATETO, name = "決定日To")
    private FlexibleDate 決定日To;
    @BatchParameter(key = SOFUYMFROM, name = "国保連送付年月From")
    private FlexibleYearMonth 国保連送付年月From;
    @BatchParameter(key = SOFUYMTO, name = "国保連送付年月To")
    private FlexibleYearMonth 国保連送付年月To;
    @BatchParameter(key = YOSHIKINOCH, name = "様式番号選択")
    private RString 様式番号選択;
    @BatchParameter(key = YOSHIKINO, name = "様式番号")
    private RString 様式番号;
    @BatchParameter(key = PROGRAMNAME, name = "項目名付加")
    private boolean 項目名付加;
    @BatchParameter(key = SERINO, name = "連番付加")
    private boolean 連番付加;
    @BatchParameter(key = DATE, name = "日付スラッシュ付加")
    private boolean 日付スラッシュ付加;
    @BatchParameter(key = OUTPUT, name = "出力順")
    private Long 出力順;
    @BatchParameter(key = INTPUT, name = "出力項目")
    private RString 出力項目;
    @BatchParameter(key = REPORTID, name = "帳票ID")
    private ReportId 帳票ID;
    @BatchParameter(key = KEY_REAMS_LOGIN_ID, name = "reamsLoginId")
    private RString reamsLoginId;

    /**
     * mybatisのパラメータを生成します。
     *
     * @return mybatisパラメータ
     */
    public HanyoListShokanbaraiJokyoProcessParameter toProcessParam() {
        return new HanyoListShokanbaraiJokyoProcessParameter(
                null,
                null,
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
                様式番号,
                項目名付加,
                連番付加,
                日付スラッシュ付加,
                出力順,
                出力項目,
                帳票ID,
                reamsLoginId);
    }

}
