/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB271003;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranOutputOrder;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran.TokushoTaishioIchiranEntity;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.TokubetsuChoshuDoteiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshudoteimidoteiichiran.TokubetsuChoshuDoteiIchiranEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshudoteiichiran.TokubetsuChoshuDoteiIchiranSource;
import jp.co.ndensan.reams.db.dbx.business.util.DateConverter;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.ue.uex.definition.core.TsuchiNaiyoCodeType;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 特別徴収同定一覧表バッチフロークラスです。
 *
 * @reamsid_L DBB-1860-040 pengxingyi
 */
public class PrtTokuchoDoteiIchiranhyoProcess extends BatchProcessBase<TokubetsuChoshuDoteiIchiranEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate.tokubetsuchoshudoteimidoteiichiran."
                    + "ITokubetsuChoshuDoteiMiDoteiIchiranMapper.get特別徴収同定一覧情報");
    private TokubetsuChoshuDoteiMiDoteiIchiranProcessParameter parameter;
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBB200031"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private RString eucFilePath;
    private FileSpoolManager manager;
    private final RString csvファイル名 = new RString("TokubetsuChoshuDoteiIchiran.csv");
    private final RString csvOutFlag = new RString("有り");
    private static final RString TITLE_処理年度 = new RString("【処理年度】");
    private static final RString TITLE_捕捉月 = new RString("【捕捉月】");
    private static final RString TITLE_特別徴収開始月 = new RString("【特別徴収開始月】");
    private static final RString TITLE_出力対象 = new RString("【出力対象】");
    private static final RString STOP = new RString("、");
    private static final RString 定数_0 = new RString("0");
    private static final RString 定数_1 = new RString("1");
    private static final RString 定数_2 = new RString("2");
    private static final RString 定数_10 = new RString("10");
    private static final RString 定数_すべて選択 = new RString("すべて選択");
    private static final RString 定数_同定済一覧 = new RString("同定済一覧");
    private static final RString 定数_未同定一覧 = new RString("未同定一覧");
    private static final RString 町域コード = new RString("町域コード");
    private static final RString 行政区コード = new RString("行政区コード");
    private static final RString 地区１ = new RString("地区１");
    private static final RString 地区２ = new RString("地区２");
    private static final RString 地区３ = new RString("地区３");
    private static final RString 世帯コード = new RString("世帯コード");
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 氏名５０音カナ = new RString("氏名５０音カナ");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 性別 = new RString("性別");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString 年金コード = new RString("年金コード");
    private static final RString 年金番号 = new RString("年金番号");
    private static final int 郵便番号桁数 = 7;
    private static final int 郵便番号区切り文字桁 = 3;
    private static final RString 郵便番号区切り文字 = new RString("-");
    private Association 導入団体クラス;
    private RString 通知内容コード;
    private IOutputOrder 出力順;
    private List<RString> pageBreakKeys;
    private List<RString> 出力順項目リスト;
    private Map<RString, RString> 改頁項目Map;
    private List<RString> 改ページ項目リスト;
    @BatchWriter
    private CsvWriter<TokubetsuChoshuDoteiIchiranCSVEntity> eucCsvWriter;

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuDoteiIchiranSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuDoteiIchiranSource> reportSourceWriter;

    @Override
    protected void initialize() {
        pageBreakKeys = new ArrayList<>();
        出力順項目リスト = new ArrayList<>();
        改頁項目Map = new HashMap<>();
        改ページ項目リスト = new ArrayList<>();
        導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        if (定数_10.equals(parameter.get特別徴収開始月())) {
            通知内容コード = TsuchiNaiyoCodeType.特別徴収対象者情報.get通知内容コード();
        } else {
            通知内容コード = TsuchiNaiyoCodeType.特別徴収追加候補者情報.get通知内容コード();
        }
        parameter.set通知内容コード(通知内容コード);

        if (!RString.isNullOrEmpty(parameter.get同定出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBB介護賦課,
                    ReportIdDBB.DBB200031.getReportId(), Long.valueOf(parameter.get同定出力順().toString()));
            if (出力順 != null) {
                parameter.set同定出力順(MyBatisOrderByClauseCreator.create(TokubetsuChoshuDoteiIchiranOutputOrder.class, 出力順));
                setPageBreakKeys();
            }
        }
    }

    private void setPageBreakKeys() {
        for (ISetSortItem item : 出力順.get設定項目リスト()) {
            出力順項目リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                pageBreakKeys.add(item.get項目ID());
                改ページ項目リスト.add(item.get項目名());
            }
        }
    }

    @Override
    protected void createWriter() {
        PageBreaker<TokubetsuChoshuDoteiIchiranSource> breaker = new TokubetsuChoshuDoteiIchiranPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBB.DBB200031.getReportId().value()).
                addBreak(breaker).
                create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), csvファイル名);
        eucCsvWriter = BatchWriters.csvWriter(TokubetsuChoshuDoteiIchiranCSVEntity.class).
                filePath(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.getMybatisParameter());
    }

    @Override
    protected void process(TokubetsuChoshuDoteiIchiranEntity entity) {
        change改頁項目コード(entity);
        outputCsv(entity);
        outputTyouhyou(entity);
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        ReportOutputJokenhyoItem item = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200018.getReportId().value(),
                導入団体クラス.getLasdecCode_().value(),
                導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200018.getReportName(),
                reportSourceWriter.pageCount().value() == 0 ? 定数_1 : new RString(reportSourceWriter.pageCount().value()),
                csvOutFlag,
                csvファイル名,
                getOutputJokenhyoParam()
        );
        OutputJokenhyoFactory.createInstance(item)
                .print();
    }

    private List<RString> getOutputJokenhyoParam() {
        List<RString> outputJokenhyo = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(TITLE_処理年度.concat(parameter.get処理年度().wareki().toDateString()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TITLE_捕捉月);
        for (RString tar : parameter.get捕捉月()) {
            if (!TITLE_捕捉月.equals(builder.toRString())) {
                builder.append(STOP);
            }
            builder.append(tar);
        }
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(TITLE_特別徴収開始月.concat(parameter.get特別徴収開始月()));
        outputJokenhyo.add(builder.toRString());
        builder = new RStringBuilder();
        if (定数_0.equals(parameter.get出力対象())) {
            builder.append(TITLE_出力対象.concat(定数_すべて選択));
        } else if (定数_1.equals(parameter.get出力対象())) {
            builder.append(TITLE_出力対象.concat(定数_同定済一覧));
        } else if (定数_2.equals(parameter.get出力対象())) {
            builder.append(TITLE_出力対象.concat(定数_未同定一覧));
        }
        outputJokenhyo.add(builder.toRString());
        return outputJokenhyo;
    }

    private void outputTyouhyou(TokubetsuChoshuDoteiIchiranEntity entity) {
        TokushoTaishioIchiranEntity target = new TokushoTaishioIchiranEntity(
                entity.getHihokenshaNo(),
                entity.getKisoNenkinNo(),
                entity.getNenkinCode(),
                entity.getShikibetsuCode(),
                entity.getSetaiCode() == null ? RString.EMPTY : entity.getSetaiCode().getColumnValue(),
                entity.getGyoseikuCode() == null ? RString.EMPTY : entity.getGyoseikuCode().getColumnValue(),
                getDate(entity.getBirthDay()),
                entity.getJuminShubetsuCode(),
                get性別コード(entity.getSeibetsu()),
                entity.getKanaMeisho() == null ? RString.EMPTY : entity.getKanaMeisho().getColumnValue(),
                entity.getKanaShimei(),
                entity.getKanjiShimei(),
                entity.getYubinNo(),
                entity.getKanjiJusho()
        );
        target.setChokiCode(entity.getChoikiCode().getColumnValue());
        target.setChiku1(entity.getChikuCode1() == null ? RString.EMPTY : entity.getChikuCode1().getColumnValue());
        target.setChiku2(entity.getChikuCode2() == null ? RString.EMPTY : entity.getChikuCode2().getColumnValue());
        target.setChiku3(entity.getChikuCode3() == null ? RString.EMPTY : entity.getChikuCode3().getColumnValue());
        target.setShichosonCode(entity.getGenLasdecCode());
        TokubetsuChoshuDoteiIchiranReport report = new TokubetsuChoshuDoteiIchiranReport(
                導入団体クラス, 出力順項目リスト, 改頁項目Map, 改ページ項目リスト, target, parameter.get特別徴収開始月());
        report.writeBy(reportSourceWriter);
    }

    private void change改頁項目コード(TokubetsuChoshuDoteiIchiranEntity entity) {
        RString choikiCode = entity.getChoikiCode() == null ? RString.EMPTY : entity.getChoikiCode().getColumnValue();
        改頁項目Map.put(町域コード, choikiCode);
        RString gyoseikuCode = entity.getGyoseikuCode() == null ? RString.EMPTY : entity.getGyoseikuCode().getColumnValue();
        改頁項目Map.put(行政区コード, gyoseikuCode);
        RString chikuCode1 = entity.getChikuCode1() == null ? RString.EMPTY : entity.getChikuCode1().getColumnValue();
        改頁項目Map.put(地区１, chikuCode1);
        RString chikuCode2 = entity.getChikuCode1() == null ? RString.EMPTY : entity.getChikuCode1().getColumnValue();
        改頁項目Map.put(地区２, chikuCode2);
        RString chikuCode3 = entity.getChikuCode1() == null ? RString.EMPTY : entity.getChikuCode1().getColumnValue();
        改頁項目Map.put(地区３, chikuCode3);
        RString setaiCode = entity.getSetaiCode() == null ? RString.EMPTY : entity.getSetaiCode().getColumnValue();
        改頁項目Map.put(世帯コード, setaiCode);
        RString shikibetsuCode = entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().getColumnValue();
        改頁項目Map.put(識別コード, shikibetsuCode);
        RString kanaShimei = entity.getKanaShimei() == null ? RString.EMPTY : entity.getKanaShimei();
        改頁項目Map.put(氏名５０音カナ, kanaShimei);
        RString seinengappiYMD = entity.getBirthDay() == null ? RString.EMPTY : new RString(entity.getBirthDay().toString());
        改頁項目Map.put(生年月日, seinengappiYMD);
        RString seibetsu = entity.getSeibetsu() == null ? RString.EMPTY : new RString(entity.getSeibetsu().toString());
        改頁項目Map.put(性別, seibetsu);
        RString genLasdecCode = entity.getGenLasdecCode() == null ? RString.EMPTY : new RString(entity.getGenLasdecCode().toString());
        改頁項目Map.put(市町村コード, genLasdecCode);
        RString hihokenshaNo = entity.getHihokenshaNo() == null ? RString.EMPTY : new RString(entity.getHihokenshaNo().toString());
        改頁項目Map.put(被保険者番号, hihokenshaNo);
        RString nenkinCode = entity.getNenkinCode() == null ? RString.EMPTY : new RString(entity.getNenkinCode().toString());
        改頁項目Map.put(年金コード, nenkinCode);
        RString kisoNenkinNo = entity.getKisoNenkinNo() == null ? RString.EMPTY : new RString(entity.getKisoNenkinNo().toString());
        改頁項目Map.put(年金番号, kisoNenkinNo);
    }

    private RString get性別コード(SeibetsuCodeNenkinTokucho seibetsu) {
        if (seibetsu == null) {
            return RString.EMPTY;
        }
        return seibetsu.value().get性別コード();
    }

    private RString get性別名称(SeibetsuCodeNenkinTokucho seibetsu) {
        if (seibetsu == null) {
            return RString.EMPTY;
        }
        return seibetsu.value().get性別名称();
    }

    private RDate getDate(RString str) {
        if (RString.isNullOrEmpty(str)) {
            return null;
        }
        return new RDate(str.toString());
    }

    private void outputCsv(TokubetsuChoshuDoteiIchiranEntity entity) {
        eucCsvWriter.writeLine(new TokubetsuChoshuDoteiIchiranCSVEntity(
                entity.getHihokenshaNo(),
                entity.getKisoNenkinNo(),
                entity.getNenkinCode(),
                entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().getColumnValue(),
                entity.getSetaiCode() == null ? RString.EMPTY : entity.getSetaiCode().getColumnValue(),
                entity.getGyoseikuCode() == null ? RString.EMPTY : entity.getGyoseikuCode().getColumnValue(),
                get生年月日(entity.getBirthDay()),
                get性別名称(entity.getSeibetsu()),
                entity.getKanaMeisho() == null ? RString.EMPTY : entity.getKanaMeisho().getColumnValue(),
                entity.getKanaShimei(),
                entity.getKanjiShimei(),
                get郵便番号(entity.getYubinNo()),
                entity.getKanjiJusho()
        ));
    }

    private RString get生年月日(RString umareYMD) {
        if (RDate.canConvert(umareYMD)) {
            return DateConverter.getDate32(new RDate(umareYMD.toString()));
        }
        return umareYMD;
    }

    private RString get郵便番号(RString 郵便番号) {
        if (郵便番号桁数 == 郵便番号.length()) {
            return 郵便番号.insert(郵便番号区切り文字桁, 郵便番号区切り文字.toString());
        }
        return 郵便番号;
    }
}
