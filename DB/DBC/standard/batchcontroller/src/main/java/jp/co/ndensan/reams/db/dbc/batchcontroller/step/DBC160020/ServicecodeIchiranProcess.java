/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC160020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200061.ServiceCodeIchiranPageBreak;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200061.ServiceCodeIchiranParameter;
import jp.co.ndensan.reams.db.dbc.business.report.dbc200061.ServiceCodeIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.processprm.servicecodeichiran.ServicecodeIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServiceBunruiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.ServicecodeIchiranEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.servicecodeichiran.TaniSuShikibetsuEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.dbc200061.ServiceCodeIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBCCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * サービスコード一覧表のprocessクラスです。
 *
 * @reamsid_L DBC-3310-030 chenyadong
 */
public class ServicecodeIchiranProcess extends BatchKeyBreakBase<ServicecodeIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc160022."
                    + "IServicecodeIchiranMapper.select介護サービス内容");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200061");
    private final RString csvFileName = new RString("ServiceCodeIchiran.csv");
    private ServicecodeIchiranProcessParameter parameter;
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;
    private Association 地方公共団体情報;
    private List<RString> headerList;
    private List<TaniSuShikibetsuEntity> taniList;
    private List<ServiceBunruiEntity> serviceList;
    private List<RString> 改頁リスト;
    private int 連番数;
    FileSpoolManager spoolManager;
    private RString eucFilePath;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final FlexibleYearMonth 終了年月 = new FlexibleYearMonth("999999");
    private static final Code CODE_05 = new Code("05");
    private static final RString HOSHI = new RString("※");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString RSTRING_05 = new RString("05");
    private static final RString 定率 = new RString("定率");
    private static final RString 定額 = new RString("定額");
    private static final RString 連番 = new RString("連番");
    private static final RString サービス種類コード = new RString("サービス種類コード");
    private static final RString サービス項目コード = new RString("サービス項目コード");
    private static final RString サービス名称 = new RString("サービス名称");
    private static final RString 適用開始年月 = new RString("適用開始年月");
    private static final RString 適用終了年月 = new RString("適用終了年月");
    private static final RString 単位数 = new RString("単位数");
    private static final RString 単位数単位 = new RString("単位数単位");
    private static final RString 限度額対象外 = new RString("限度額対象外");
    private static final RString 元単位数 = new RString("元単位数");
    private static final RString 元単位数単位 = new RString("元単位数単位");
    private static final RString 元限度額対象外 = new RString("元限度額対象外");
    private static final RString 利用者負担定率定額 = new RString("利用者負担　定率/定額");
    private static final RString 給付率 = new RString("給付率");
    private static final RString 利用者負担単位金額 = new RString("利用者負担　単位金額");
    private static final RString 対象事業者実施区分 = new RString("総合事業実施区分(事業対象者)");
    private static final RString 要支援１受給者実施区分 = new RString("総合事業実施区分(要支援1)");
    private static final RString 要支援２受給者実施区分 = new RString("総合事業実施区分(要支援2)");
    private static final RString 二次予防事業対象者実施区分 = new RString("総合事業実施区分(二次予防)");
    private static final RString 特別地域加算 = new RString("特別地域加算");
    private static final RString 独自更新 = new RString("独自更新");

    private CsvListWriter csvListWriter;
    private BatchReportWriter<ServiceCodeIchiranSource> batchReportWriter;
    private ReportSourceWriter<ServiceCodeIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        連番数 = INT_0;
        setHeadList();
        parameter.setサービス項目コード桁目(INT_0);
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        if (!RString.isNullOrEmpty(parameter.getサービス項目コード())) {
            parameter.setサービス項目コード桁目(parameter.getサービス項目コード().length());
            parameter.setサービス項目コード(parameter.getサービス項目コード().trimStart().trimEnd());
        }

        List<UzT0007CodeEntity> 単位数識別コードリスト = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.単位数識別コード.getコード(), FlexibleDate.getNowDate());
        taniList = new ArrayList<>();
        for (UzT0007CodeEntity 単位数識別コード : 単位数識別コードリスト) {
            TaniSuShikibetsuEntity taniEntity = new TaniSuShikibetsuEntity();
            taniEntity.setコード(単位数識別コード.getコード());
            taniEntity.set名称(単位数識別コード.getコード名称());
            taniList.add(taniEntity);
        }
        if (!taniList.isEmpty()) {
            Comparator<TaniSuShikibetsuEntity> comparator = new Comparator<TaniSuShikibetsuEntity>() {
                @Override
                public int compare(TaniSuShikibetsuEntity s1, TaniSuShikibetsuEntity s2) {
                    return s1.getコード().compareTo(s2.getコード());
                }
            };
            Collections.sort(taniList, comparator);
        }
        List<UzT0007CodeEntity> サービス分類略称Entity = CodeMaster.getCode(SubGyomuCode.DBC介護給付,
                DBCCodeShubetsu.サービス分類.getコード(), FlexibleDate.getNowDate());
        serviceList = new ArrayList<>();
        for (UzT0007CodeEntity サービス分類略称 : サービス分類略称Entity) {
            ServiceBunruiEntity serviceEntity = new ServiceBunruiEntity();
            serviceEntity.setコード(new Code(サービス分類略称.getコード().getColumnValue().padZeroToLeft(INT_2)));
            serviceEntity.set略称(サービス分類略称.getコード略称());
            serviceList.add(serviceEntity);
        }
        if (!serviceList.isEmpty()) {
            Comparator<ServiceBunruiEntity> comparator = new Comparator<ServiceBunruiEntity>() {
                @Override
                public int compare(ServiceBunruiEntity s1, ServiceBunruiEntity s2) {
                    return s1.getコード().compareTo(s2.getコード());
                }
            };
            Collections.sort(serviceList, comparator);
        }
        改頁リスト = new ArrayList<>();
        改頁リスト.add(new RString(ServiceCodeIchiranSource.ReportSourceFields.List1_1.name()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        PageBreaker<ServiceCodeIchiranSource> breaker = new ServiceCodeIchiranPageBreak(改頁リスト);
        if (parameter.is帳票で出力()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdDBC.DBC200061.getReportId().value()).addBreak(breaker).create();
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        }
        if (parameter.isＣＳＶファイルで出力()) {
            spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                    UzUDE0831EucAccesslogFileType.Csv);
            eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                    csvFileName);
            csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEnclosure(EUC_WRITER_ENCLOSURE).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(false).
                    build();
        }
    }

    @Override
    protected void beforeExecute() {
        if (parameter.is項目名付加()) {
            csvListWriter.writeLine(headerList);
        }
    }

    @Override
    protected void usualProcess(ServicecodeIchiranEntity entity) {
        if (parameter.is帳票で出力()) {
            ServiceCodeIchiranParameter param = new ServiceCodeIchiranParameter();
            param.setサービスコード一覧表(entity);
            param.setバッチパラメータ(parameter);
            param.set単位数識別(taniList);
            param.set導入団体(地方公共団体情報);
            param.set作成日時(parameter.get処理日時());
            param.setサービス分類略称(serviceList);
            ServiceCodeIchiranReport report = new ServiceCodeIchiranReport(param);
            report.writeBy(reportSourceWriter);
        }
        if (parameter.isＣＳＶファイルで出力()) {
            List<RString> outputList = editorCsv(entity);
            csvListWriter.writeLine(this.toBodyList(outputList));
        }
    }

    @Override
    protected void keyBreakProcess(ServicecodeIchiranEntity entity) {
    }

    @Override
    protected void afterExecute() {
        if (parameter.is帳票で出力()) {
            batchReportWriter.close();
        }
        if (parameter.isＣＳＶファイルで出力()) {
            csvListWriter.close();
            spoolManager.spool(eucFilePath);
        }
    }

    private void setHeadList() {
        this.headerList = new ArrayList<>();
        if (parameter.is連番付加()) {
            headerList.add(連番);
        }
        headerList.add(サービス種類コード);
        headerList.add(サービス項目コード);
        headerList.add(サービス名称);
        headerList.add(適用開始年月);
        headerList.add(適用終了年月);
        headerList.add(単位数);
        headerList.add(単位数単位);
        headerList.add(限度額対象外);
        headerList.add(元単位数);
        headerList.add(元単位数単位);
        headerList.add(元限度額対象外);
        headerList.add(利用者負担定率定額);
        headerList.add(給付率);
        headerList.add(利用者負担単位金額);
        headerList.add(対象事業者実施区分);
        headerList.add(要支援１受給者実施区分);
        headerList.add(要支援２受給者実施区分);
        headerList.add(二次予防事業対象者実施区分);
        headerList.add(特別地域加算);
        headerList.add(独自更新);
    }

    private List<RString> editorCsv(ServicecodeIchiranEntity entity) {
        List<RString> rStringList = new ArrayList<>();
        if (entity.get介護サービス内容() == null) {
            return rStringList;
        }
        連番数 = 連番数 + 1;
        if (parameter.is連番付加()) {
            rStringList.add(new RString(連番数));
        }
        if (entity.get介護サービス内容().getServiceShuruiCd() != null && !entity.get介護サービス内容().getServiceShuruiCd().isEmpty()) {
            rStringList.add(entity.get介護サービス内容().getServiceShuruiCd().getColumnValue());
        } else {
            rStringList.add(RString.EMPTY);
        }
        rStringList.add(entity.get介護サービス内容().getServiceKoumokuCd());
        rStringList.add(entity.get介護サービス内容().getServiceName());
        FlexibleYearMonth 提供開始年月 = entity.get介護サービス内容().getTeikyoKaishiYM();
        FlexibleYearMonth 提供終了年月 = entity.get介護サービス内容().getTeikyoShuryoYM();
        if (parameter.is日付編集()) {
            if (提供開始年月 != null && !提供開始年月.isEmpty()) {
                rStringList.add(DateConverter.getDate82(new RYearMonth(提供開始年月.toDateString())));
            }
            if (提供終了年月 != null && !提供終了年月.isEmpty() && !提供終了年月.equals(終了年月)) {
                rStringList.add(DateConverter.getDate82(new RYearMonth(提供終了年月.toDateString())));
            } else {
                rStringList.add(RString.EMPTY);
            }
        } else {
            if (提供開始年月 != null && !提供開始年月.isEmpty()) {
                rStringList.add(DateConverter.getDate84(new RYearMonth(提供開始年月.toDateString())));
            }
            if (提供終了年月 != null && !提供終了年月.isEmpty() && !提供終了年月.equals(終了年月)) {
                rStringList.add(DateConverter.getDate84(new RYearMonth(提供終了年月.toDateString())));
            } else {
                rStringList.add(RString.EMPTY);
            }
        }
        if (entity.get介護サービス内容().getTanisuShikibetsuCode() != null && !entity.get介護サービス内容()
                .getTanisuShikibetsuCode().isEmpty()) {            
            if (!CODE_05.equals(entity.get介護サービス内容().getTanisuShikibetsuCode())) {
                rStringList.add(new RString(entity.get介護サービス内容().getTaniSu()));    
            } else {
                rStringList.add(RString.EMPTY);
            }
            set単位(rStringList, entity.get介護サービス内容().getTanisuShikibetsuCode().getColumnValue());
        } else {
            rStringList.add(RString.EMPTY);
        }
        editorCsvPart2(entity, rStringList);
        editorCsvPart3(entity, rStringList);
        return rStringList;
    }

    private void editorCsvPart2(ServicecodeIchiranEntity entity, List<RString> rStringList) {
        if (isRstring_1(entity.get介護サービス内容().getGendogakuTaishogaiFlag())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (RSTRING_1.equals(entity.get介護サービス内容().getKoshinUmuFoag())
                && !RString.isNullOrEmpty(entity.get介護サービス内容().getMotoTaniShikibetsuCd())) {            
            if (!RSTRING_05.equals(entity.get介護サービス内容().getMotoTaniShikibetsuCd())) {
                rStringList.add(entity.get介護サービス内容().getMotoTensu());    
            } else {
                rStringList.add(RString.EMPTY);
            }
            set単位(rStringList, entity.get介護サービス内容().getMotoTaniShikibetsuCd());
        } else {
            rStringList.add(RString.EMPTY);
            rStringList.add(RString.EMPTY);
        }
        if (isRstring_1(entity.get介護サービス内容().getMotoGendogakuTaishogaiFlag())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_1(entity.get介護サービス内容().getRiyosyaFutanTeiritsuTeigakuKubun())) {
            rStringList.add(定率);
        } else if (isRstring_2(entity.get介護サービス内容().getRiyosyaFutanTeiritsuTeigakuKubun())) {
            rStringList.add(定額);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_2(entity.get介護サービス内容().getRiyosyaFutanTeiritsuTeigakuKubun())) {
            rStringList.add(RString.EMPTY);
        } else {
            rStringList.add(entity.get介護サービス内容().getKyufuRitsu());
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_1(entity.get介護サービス内容().getRiyosyaFutanTeiritsuTeigakuKubun())) {
            rStringList.add(RString.EMPTY);
        } else {
            rStringList.add(entity.get介護サービス内容().getRiyoshaFutanGaku());
        }        
    }
    
    private void editorCsvPart3(ServicecodeIchiranEntity entity, List<RString> rStringList) {
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_2(entity.get介護サービス内容().getTaishoJigyoJishiKubun())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_2(entity.get介護サービス内容().getYoshien1JukyushaJishiKubun())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_2(entity.get介護サービス内容().getYoshien2JukyushaJishiKubun())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (!isRstring_1(entity.get介護サービス内容().getSogoJigyoServiceKubun())) {
            rStringList.add(RString.EMPTY);
        } else if (isRstring_2(entity.get介護サービス内容().getNijiyoboJigyoTaishaJishiKubunHigaito())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (isRstring_1(entity.get介護サービス内容().getTokubetsuChiikiKasanFlag())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
        if (isRstring_1(entity.get介護サービス内容().getKoshinUmuFoag())) {
            rStringList.add(HOSHI);
        } else {
            rStringList.add(RString.EMPTY);
        }
    }
    
    private void set単位(List<RString> rStringList, RString code) {
        if (!getCodeNameByCode(DBCCodeShubetsu.単位数識別コード.getコード(), code).isEmpty()) {
            rStringList.add(getCodeNameByCode(DBCCodeShubetsu.単位数識別コード.getコード(), code));
        } else {
            rStringList.add(code);
        }
    }
    
    private RString getCodeNameByCode(CodeShubetsu codeShubetsu, RString code) {
        if (code == null || code.isEmpty()) {
            return RString.EMPTY;
        }
        return CodeMaster.getCodeRyakusho(
                SubGyomuCode.DBC介護給付,
                codeShubetsu,
                new Code(code),
                FlexibleDate.getNowDate());
    }

    private List<RString> toBodyList(List<RString> bodyList) {
        for (int i = INT_0; i < bodyList.size(); i++) {
            if (bodyList.get(i) == null) {
                bodyList.remove(bodyList.get(i));
                bodyList.add(i, RString.EMPTY);
            }
        }
        return bodyList;
    }

    private boolean isRstring_1(RString rString) {
        return !RString.isNullOrEmpty(rString) && RSTRING_1.equals(rString);
    }

    private boolean isRstring_2(RString rString) {
        return !RString.isNullOrEmpty(rString) && RSTRING_2.equals(rString);
    }

}
