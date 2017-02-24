/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE561001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.report.centersoshintaishoshaichiran.CenterSoshinTaishoshaIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission.CenterTransmissionMybitisParamter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.centertransmission.CenterTransmissionProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterSoshinTaishoshaIchiranEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionEditEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.centertransmission.CenterTransmissionEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.centersoshintaishoshaichiran.CenterSoshinTaishoshaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.date.DateEditor;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * センター送信データ作成のProcessクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
public class CenterTransmissionProcess extends BatchProcessBase<CenterTransmissionEntity> {

    private static final RString SELECT_SHUJIIIKENSHOIKENITEM = new RString("jp.co.ndensan.reams.db.dbe"
            + ".persistence.db.mapper.relate.centertransmission.ICenterTransmissionMapper.getCenterTransmissionData");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE561001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = RString.EMPTY;

    private CenterTransmissionProcessParameter parameter;
    private CenterTransmissionMybitisParamter mybitisParamter;
    private CenterTransmissionEntity beforeEntity;
    private FileSpoolManager manager;
    private RString filename;
    private RString ファイル名;
    private int シーケンシャル番号;
    private int 出力データ件数;
    @BatchWriter
    private BatchReportWriter<CenterSoshinTaishoshaIchiranReportSource> batchWrite;
    private ReportSourceWriter<CenterSoshinTaishoshaIchiranReportSource> reportSourceWriter;
    private static final RString 出力する = new RString("出力する");
    private static final RString 出力しない = new RString("出力しない");
    private static final RString 未出力のみ = new RString("未出力のみ");
    private static final RString 出力済みも含む = new RString("出力済みも含む");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString DATE_作成 = new RString("作成");
    private static final RString DATE_ヶ月 = new RString("ヶ月");
    private CenterSoshinTaishoshaIchiranEntity centerSoshinTaishoshaIchiranEntity;
    private RString printTimeStamp;

    /**
     * データ有無の判定です。
     */
    public static final RString OUTPUTSHINSEISHOKANRINO;

    static {
        OUTPUTSHINSEISHOKANRINO = new RString("outputShinseishoKanriNo");
    }
    private OutputParameter<List<RString>> outputShinseishoKanriNo;
    private List<RString> 出力された申請書管理番号;

    @BatchWriter
    private CsvWriter<CenterTransmissionCsvEntity> csvWriterCenterTransmission;

    @Override
    protected void initialize() {
        outputShinseishoKanriNo = new OutputParameter<>();
        printTimeStamp = get印刷日時();
        centerSoshinTaishoshaIchiranEntity = new CenterSoshinTaishoshaIchiranEntity();
        シーケンシャル番号 = 0;
        出力データ件数 = 0;
        出力された申請書管理番号 = new ArrayList<>();
        mybitisParamter = parameter.toCenterTransmissionMybitisParamter();
        if (parameter.is転入死亡情報出力()) {
            List<RString> shinseijiKubunCodeList = new ArrayList<>();
            shinseijiKubunCodeList.add(NinteiShinseiShinseijiKubunCode.転入申請.getコード());
            shinseijiKubunCodeList.add(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード());
            mybitisParamter.setShinseijiKubunCodeList(shinseijiKubunCodeList);
        }
        mybitisParamter.setGaikyoChosaTextImageKubun(DbBusinessConfig.get(ConfigNameDBE.概況調査テキストイメージ区分, RDate.getNowDate(), SubGyomuCode.DBE認定支援));
        ファイル名 = EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString());
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        filename = Path.combinePath(spoolWorkPath, ファイル名);
        csvWriterCenterTransmission = new CsvWriter.InstanceBuilder(filename).
                setEncode(Encode.SJIS)
                .canAppend(true)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(SELECT_SHUJIIIKENSHOIKENITEM, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(ReportIdDBE.DBE561001.getReportId().value()).create();
        reportSourceWriter = new ReportSourceWriter<>(batchWrite);
    }

    @Override
    protected void process(CenterTransmissionEntity currentEntity) {
        int 連番 = 0;
        シーケンシャル番号 = シーケンシャル番号 + 1;
        出力データ件数 = 出力データ件数 + 1;
        if (is死亡データ(beforeEntity, currentEntity)) {
            連番 = 1;
        }
        csvWriterCenterTransmission.writeLine(new CenterTransmissionEditEntity(currentEntity, シーケンシャル番号, 連番).getファイル出力項目());
        beforeEntity = currentEntity;
        RString 申請書管理番号 = currentEntity.getShinseishoKanriNo().value();
        if (!出力された申請書管理番号.contains(申請書管理番号)) {
            出力された申請書管理番号.add(申請書管理番号);
            AccessLogger.log(AccessLogType.照会, toPersonalData(申請書管理番号));
        }
        printReport(currentEntity);
    }

    private boolean is死亡データ(CenterTransmissionEntity before, CenterTransmissionEntity current) {

        if (before == null) {
            return false;
        } else {
            return before.getNinteiShinseiYMD().equals(current.getNinteiShinseiYMD())
                    && before.getShoKisaiHokenshaNo().equals(current.getShoKisaiHokenshaNo())
                    && before.getHihokenshaNo().equals(current.getHihokenshaNo());
        }
    }

    @Override
    protected void afterExecute() {
        outputShinseishoKanriNo.setValue(出力された申請書管理番号);
        outputJokenhyoFactory();
        csvWriterCenterTransmission.close();
        if (出力データ件数 != 0) {
            manager.spool(filename);
        }
    }

    private PersonalData toPersonalData(RString 申請書管理番号) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0001"), new RString("申請書管理番号"), 申請書管理番号);
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("認定支援センター送信ファイル"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(JobContextHolder.getJobId()),
                ファイル名,
                EUC_ENTITY_ID.toRString(),
                new RString(出力データ件数),
                contribute());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private List<RString> contribute() {
        List<RString> 出力条件 = new ArrayList<>();
        出力条件.add(条件(new RString("【データ出力区分】"), getデータ出力区分For出力条件(parameter.is未出力のみ())));
        if (FlexibleDate.canConvert(parameter.get二次判定開始日())) {
            出力条件.add(条件(new RString("【二次判定日(開始)】"), DateEditor.to和暦(new FlexibleDate(parameter.get二次判定開始日().toString()))));
        } else {
            出力条件.add(条件(new RString("【二次判定日(開始)】"), RString.EMPTY));
        }
        if (FlexibleDate.canConvert(parameter.get二次判定終了日())) {
            出力条件.add(条件(new RString("【二次判定日(終了)】"), DateEditor.to和暦(new FlexibleDate(parameter.get二次判定終了日().toString()))));
        } else {
            出力条件.add(条件(new RString("【二次判定日(終了)】"), RString.EMPTY));
        }
        出力条件.add(条件(new RString("【転入/死亡情報出力区分】"), get情報出力区分For出力条件(parameter.is転入死亡情報出力())));
        return 出力条件;
    }

    private RString 条件(RString バッチパラメータ名, RString 値) {
        RStringBuilder 条件 = new RStringBuilder();
        条件.append(バッチパラメータ名);
        条件.append(値);
        return 条件.toRString();
    }

    private RString getデータ出力区分For出力条件(boolean is未出力のみ) {
        if (is未出力のみ) {
            return 未出力のみ;
        }
        return 出力済みも含む;
    }

    private RString get情報出力区分For出力条件(boolean is情報出力) {
        if (is情報出力) {
            return 出力する;
        }
        return 出力しない;
    }

    private void printReport(CenterTransmissionEntity currentEntity) {
        centerSoshinTaishoshaIchiranEntity = new CenterSoshinTaishoshaIchiranEntity();
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_1(currentEntity.getShoKisaiHokenshaNo());
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_2(currentEntity.getShichosonMeisho());
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_3(currentEntity.getHihokenshaNo());
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_4(get被保険者氏名(currentEntity.getHihokenshaName()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_5(get認定申請日_共通ポリシーパターン1(currentEntity.getNinteiShinseiYMD()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_6(get認定申請区分_申請時_コード(currentEntity.getNinteiShinseiShinseijiKubunCode()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_7(get認定申請区分_法令_コード(currentEntity.getNinteiShinseiHoreiKubunCode()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_8(get二次判定結果(currentEntity.getKoroshoIfShikibetsuCode().value(), currentEntity.getNijiHanteiYokaigoJotaiKubunCode().value()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_9(get認定有効期間(currentEntity.getNijiHanteiNinteiYukoKikan()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_10(get開始日(currentEntity.getNijiHanteiNinteiYukoKaishiYMD()));
        centerSoshinTaishoshaIchiranEntity.setListTaishoshaIchiran_11(get終了日(currentEntity.getNijiHanteiNinteiYukoShuryoYMD()));
        CenterSoshinTaishoshaIchiranReport report = new CenterSoshinTaishoshaIchiranReport(printTimeStamp, centerSoshinTaishoshaIchiranEntity);
        report.writeBy(reportSourceWriter);
    }

    private RString get印刷日時() {
        RDateTime printdate = RDateTime.now();
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(printdate.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString());
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(String.format("%02d", printdate.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", printdate.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", printdate.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(RString.HALF_SPACE);
        printTimeStampSb.append(DATE_作成);
        return printTimeStampSb.toRString();
    }

    private RString get認定申請日_共通ポリシーパターン1(FlexibleDate ninteiShinseiYMD) {
        if (ninteiShinseiYMD == null || ninteiShinseiYMD.isEmpty()) {
            return RString.EMPTY;
        }
        return ninteiShinseiYMD.wareki().toDateString();
    }

    private RString get被保険者氏名(AtenaMeisho hihokenshaName) {
        return hihokenshaName == null ? RString.EMPTY : hihokenshaName.value();
    }

    private RString get認定申請区分_法令_コード(Code 法令code) {
        return 法令code == null ? RString.EMPTY
                : NinteiShinseiHoreiCode.toValue(法令code.value()) == null ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(法令code.value()).get名称();
    }

    private RString get認定申請区分_申請時_コード(Code 申請時code) {
        return NinteiShinseiShinseijiKubunCode.toValue(申請時code.value()).get名称();
    }

    private RString get二次判定結果(RString 厚労省IF識別コード, RString 二次判定要介護状態区分コード) {
        RString 二次判定結果;
        if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ99.getコード().equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2002.getコード().equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun02.toValue(二次判定要介護状態区分コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2006_新要介護認定適用区分が未適用.getコード().equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun06.toValue(二次判定要介護状態区分コード).get名称();
        } else if (KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009.getコード().equals(厚労省IF識別コード)
                || KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3.getコード().equals(厚労省IF識別コード)) {
            二次判定結果 = YokaigoJotaiKubun09.toValue(二次判定要介護状態区分コード).get名称();
        } else {
            二次判定結果 = YokaigoJotaiKubun99.toValue(二次判定要介護状態区分コード).get名称();
        }
        return 二次判定結果;
    }

    private RString get開始日(FlexibleDate 二次判定認定有効開始年月日) {
        if (二次判定認定有効開始年月日 == null || 二次判定認定有効開始年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 二次判定認定有効開始年月日.wareki().toDateString();
    }

    private RString get終了日(FlexibleDate 二次判定認定有効終了年月日) {
        if (二次判定認定有効終了年月日 == null || 二次判定認定有効終了年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 二次判定認定有効終了年月日.wareki().toDateString();
    }

    private RString get認定有効期間(int 二次判定認定有効期間) {
        return new RString(二次判定認定有効期間).concat(DATE_ヶ月);
    }
}
