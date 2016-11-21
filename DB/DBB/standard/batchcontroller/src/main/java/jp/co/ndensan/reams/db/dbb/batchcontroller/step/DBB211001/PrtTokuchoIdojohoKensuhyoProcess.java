/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB211001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoPageBreak;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoParameter;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoReport;
import jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshuiraijohokensuhyo.TokubetsuChoshuIraiJohoKensuhyoPageBreak;
import jp.co.ndensan.reams.db.dbb.definition.processprm.dbb211001.PrtTokuchoIdojohoKensuhyoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.tokuchosoufujohosakuseibatch.TokubetsuChoshuIdojohoKensuhyoDataCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokubetsuchoshuidojohokensuhyo.TokuChoYidoKensuEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchosoufujohosakuseibatch.TokuChoYidoKensu;
import jp.co.ndensan.reams.db.dbb.entity.report.tokubetsuchoshuidojohokensuhyo.TokubetsuChoshuIdojohoKensuhyoSource;
import jp.co.ndensan.reams.db.dbb.service.core.kanri.NenkinHokenshaHantei;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ue.uex.definition.core.UEXCodeShubetsu;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * 特徴異動情報件数表の発行します。
 *
 * @reamsid_L DBB-1840-040 xuzhao
 */
public class PrtTokuchoIdojohoKensuhyoProcess extends BatchKeyBreakBase<TokuChoYidoKensu> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence"
            + ".db.mapper.relate.tokuchosoufujohosakuseibatch.ITokuChoSoufuJohoSakuseiBatchMapper.get異動情報件数表出力対象データ");
    private static final RString 出力ファイル名 = new RString("TokubetsuChoshuIdojohoKensuhyoData.csv");
    private static final RString 出力ファイル名_出力条件 = new RString("特別徴収異動情報件数表");
    private static final RString 出力ファイル名_NO_DATA = new RString("-");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200022");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 年金保険者名称_厚労省 = new RString("厚労省");
    private static final RString 年金保険者名称_地共済 = new RString("地共済");
    private static final RString CSV出力有無_無り = new RString("なし");
    private static final RString CSV出力有無_有り = new RString("あり");
    private static final RString 年金保険者名称 = new RString("年金保険者名称");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final int HALF_PAGE_COUNT = 10;
    private static final int ONE_PAGE_COUNT = 20;

    private PrtTokuchoIdojohoKensuhyoProcessParameter parameter;
    private RString 特徴異動情報件数表ＣＳＶFilePath;
    private FileSpoolManager manager;
    private List<RString> 改頁List;
    private int csv件数の合計;
    private int csv喪失件数の合計;
    private int csv仮徴収額変更件数の合計;
    private int csv住所地特例件数の合計;
    private int csv追加依頼件数の合計;
    private int report件数の合計;
    private int report喪失件数の合計;
    private int report仮徴収額変更件数の合計;
    private int report住所地特例件数の合計;
    private int report追加依頼件数の合計;
    private int count;
    private int 出力ページ数;
    private RString 保険者情報_保険者番号;
    private RString 保険者情報_保険者名称;
    private List<TokuChoYidoKensuEntity> reportEntityList;
    private List<TokubetsuChoshuIdojohoKensuhyoDataCSVEntity> csvEntityList;
    private boolean isHasData;

    @BatchWriter
    private BatchReportWriter<TokubetsuChoshuIdojohoKensuhyoSource> batchReportWriter;
    private ReportSourceWriter<TokubetsuChoshuIdojohoKensuhyoSource> reportSourceWriter;

    @BatchWriter
    CsvWriter<TokubetsuChoshuIdojohoKensuhyoDataCSVEntity> 特徴異動情報件数表ＣＳＶ;

    @Override
    protected void initialize() {
        count = 0;
        isHasData = false;
        csv件数の合計 = 0;
        report件数の合計 = 0;
        改頁List = new ArrayList<>();
        get改頁List();
        csvEntityList = new ArrayList<>();
        reportEntityList = new ArrayList<>();
        出力ページ数 = 0;
        保険者情報_保険者番号 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                parameter.getシステム日時().getDate(), SubGyomuCode.DBU介護統計報告);
        保険者情報_保険者名称 = DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者名称,
                parameter.getシステム日時().getDate(), SubGyomuCode.DBU介護統計報告);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        PageBreaker<TokubetsuChoshuIdojohoKensuhyoSource> breaker
                = new TokubetsuChoshuIdojohoKensuhyoPageBreak(改頁List);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200022.getReportId().value(), SubGyomuCode.DBB介護賦課).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        特徴異動情報件数表ＣＳＶFilePath = Path.combinePath(manager.getEucOutputDirectry(),
                出力ファイル名);
        特徴異動情報件数表ＣＳＶ = BatchWriters.csvWriter(TokubetsuChoshuIdojohoKensuhyoDataCSVEntity.class).
                filePath(特徴異動情報件数表ＣＳＶFilePath).
                setDelimiter(コンマ).
                setEnclosure(ダブル引用符).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(TokuChoYidoKensu entity) {
    }

    @Override
    protected void usualProcess(TokuChoYidoKensu t) {
        count++;
        isHasData = true;
        csv件数の合計 = t.get件数() + csv件数の合計;
        report件数の合計 = t.get件数() + report件数の合計;
        csv喪失件数の合計 = t.get資格件数() + csv喪失件数の合計;
        report喪失件数の合計 = t.get資格件数() + report喪失件数の合計;
        csv住所地特例件数の合計 = t.get住所地特例件数() + csv住所地特例件数の合計;
        report住所地特例件数の合計 = t.get住所地特例件数() + report住所地特例件数の合計;
        csv仮徴収額変更件数の合計 = t.get仮徴収額変更件数() + csv仮徴収額変更件数の合計;
        report仮徴収額変更件数の合計 = t.get仮徴収額変更件数() + report仮徴収額変更件数の合計;
        csv追加依頼件数の合計 = t.get追加依頼件数() + csv追加依頼件数の合計;
        report追加依頼件数の合計 = t.get追加依頼件数() + report追加依頼件数の合計;

        if (count <= HALF_PAGE_COUNT) {
            TokuChoYidoKensuEntity reportEntity = new TokuChoYidoKensuEntity();
            reportEntity.set市町村名称(t.get市町村名称());
            reportEntity.set年金保険者名称(年金保険者名称の編集(new Code(t.getDT特別徴収義務者コード())));
            reportEntity.set構成市町村コード(t.get構成市町村コード());
            reportEntity.set件数Left(new RString(t.get件数()));
            reportEntity.set特別徴収義務者コードLeft(t.getDT特別徴収義務者コード());
            reportEntity.set資格件数Left(new RString(t.get資格件数()));
            reportEntity.set住所地特例件数Left(new RString(t.get住所地特例件数()));
            reportEntity.set追加依頼件数Left(new RString(t.get追加依頼件数()));
            reportEntity.set仮徴収額変更件数Left(new RString(t.get仮徴収額変更件数()));
            reportEntityList.add(reportEntity);
        } else {
            TokuChoYidoKensuEntity reportEntity = reportEntityList.get(count - HALF_PAGE_COUNT);
            reportEntity.set市町村名称(t.get市町村名称());
            reportEntity.set年金保険者名称(年金保険者名称の編集(new Code(t.getDT特別徴収義務者コード())));
            reportEntity.set構成市町村コード(t.get構成市町村コード());
            reportEntity.set件数Right(new RString(t.get件数()));
            reportEntity.set特別徴収義務者コードRight(t.getDT特別徴収義務者コード());
            reportEntity.set資格件数Right(new RString(t.get資格件数()));
            reportEntity.set住所地特例件数Right(new RString(t.get住所地特例件数()));
            reportEntity.set追加依頼件数Right(new RString(t.get追加依頼件数()));
            reportEntity.set仮徴収額変更件数Right(new RString(t.get仮徴収額変更件数()));

        }
        if (getBefore() != null && (count == ONE_PAGE_COUNT
                || new TokubetsuChoshuIraiJohoKensuhyoPageBreak(改頁List)
                .is年金保険者名称改頁(年金保険者名称の編集(new Code(t.getDT特別徴収義務者コード())),
                        年金保険者名称の編集(new Code(getBefore().getDT特別徴収義務者コード())))
                || new TokubetsuChoshuIraiJohoKensuhyoPageBreak(改頁List)
                .is年金保険者名称改頁(t.get構成市町村コード(),
                        getBefore().get構成市町村コード()))) {
            特徴異動情報件数表の発行();
        }
        TokubetsuChoshuIdojohoKensuhyoDataCSVEntity cSVEntity = csvEntityの編集(t,
                年金保険者名称の編集(new Code(t.getDT特別徴収義務者コード())));
        csvEntityList.add(cSVEntity);
    }

    @Override
    protected void afterExecute() {
        List<RString> 出力条件リスト = parameter.get出力条件リスト();
        RString 帳票名 = ReportIdDBB.DBB200022.getReportName();
        RString csv出力有無 = CSV出力有無_無り;
        RString csvファイル名 = 出力ファイル名_NO_DATA;
        if (isHasData) {
            ファイル出力();
            特徴異動情報件数表ＣＳＶ.close();
            csv出力有無 = CSV出力有無_有り;
            csvファイル名 = 出力ファイル名_出力条件;
            manager.spool(特徴異動情報件数表ＣＳＶFilePath);
        }
        if (!reportEntityList.isEmpty()) {
            特徴異動情報件数表の発行();
        }
        loadバッチ出力条件リスト(出力条件リスト, new ReportId(parameter.get件数表帳票ID()),
                出力ページ数, csv出力有無, csvファイル名, 帳票名);

    }

    private void get改頁List() {
        改頁List.add(年金保険者名称);
        改頁List.add(市町村コード);
    }

    private void ファイル出力() {
        for (TokubetsuChoshuIdojohoKensuhyoDataCSVEntity csvEntity : csvEntityList) {
            csvEntity.set合計件数(new RString(csv件数の合計));
            csvEntity.set合計仮徴収額変更件数(new RString(csv仮徴収額変更件数の合計));
            csvEntity.set合計喪失件数(new RString(csv喪失件数の合計));
            csvEntity.set合計住所地特例件数(new RString(csv住所地特例件数の合計));
            csvEntity.set合計追加依頼件数(new RString(csv追加依頼件数の合計));
            特徴異動情報件数表ＣＳＶ.writeLine(csvEntity);
        }
        csvEntityList.clear();
    }

    private void 特徴異動情報件数表の発行() {
        for (TokuChoYidoKensuEntity reportEntity : reportEntityList) {
            TokubetsuChoshuIdojohoKensuhyoParameter reportParameter = new TokubetsuChoshuIdojohoKensuhyoParameter();
            reportParameter.set特徴異動件数Entity(reportEntity);
            reportParameter.set作成日時(parameter.getシステム日時());
            reportParameter.set処理対象月(parameter.get処理対象月());
            reportParameter.set賦課年度(new FlexibleYear(parameter.get賦課年度().toDateString()));
            reportParameter.set該当件数の件数の合計(new RString(report件数の合計));
            reportParameter.set資格喪失の件数の合計(new RString(report喪失件数の合計));
            reportParameter.set住所地特例の件数の合計(new RString(report住所地特例件数の合計));
            reportParameter.set仮徴収額変更の件数の合計(new RString(report仮徴収額変更件数の合計));
            reportParameter.set特徴追加依頼の件数の合計(new RString(report追加依頼件数の合計));
            TokubetsuChoshuIdojohoKensuhyoReport 特徴異動情報件数表report
                    = new TokubetsuChoshuIdojohoKensuhyoReport(reportParameter);
            特徴異動情報件数表report.writeBy(reportSourceWriter);
        }
        report件数の合計 = 0;
        report喪失件数の合計 = 0;
        report住所地特例件数の合計 = 0;
        report仮徴収額変更件数の合計 = 0;
        report追加依頼件数の合計 = 0;
        count = 0;
        reportEntityList.clear();
        出力ページ数++;
    }

    private RString 年金保険者名称の編集(Code dT特徴義務者コード) {
        NenkinHokenshaHantei 年金保険者判定クラス = new NenkinHokenshaHantei();
        if (isNotNull(dT特徴義務者コード)
                && 年金保険者判定クラス.is厚労省(dT特徴義務者コード.value())) {
            return 年金保険者名称_厚労省;
        } else {
            return 年金保険者名称_地共済;
        }
    }

    private FlexibleYearMonth get処理対象年月() {
        return new FlexibleYearMonth(parameter.get賦課年度().toDateString().concat(parameter.get処理対象月()));
    }

    private TokubetsuChoshuIdojohoKensuhyoDataCSVEntity csvEntityの編集(
            TokuChoYidoKensu 特徴異動件数Entity, RString 年金保険者名称) {
        RString 作成日 = parameter.getシステム日時().getRDateTime().getDate().wareki().eraType(EraType.KANJI)
                .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        RString 作成時 = parameter.getシステム日時().getRDateTime().getTime()
                .toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
        RString 年月 = get処理対象年月().toDateString();
        RString 組合名称 = CodeMaster.getCodeMeisho(SubGyomuCode.UEX分配集約公開,
                UEXCodeShubetsu.特別徴収義務者コード.getCodeShubetsu(),
                new Code(特徴異動件数Entity.getDT特別徴収義務者コード()));
        TokubetsuChoshuIdojohoKensuhyoDataCSVEntity csvEntity = new TokubetsuChoshuIdojohoKensuhyoDataCSVEntity();
        csvEntity.set作成日時(作成日);
        csvEntity.set作成時刻(作成時);
        csvEntity.setテスト処理(RString.EMPTY);
        csvEntity.set年金保険者名称(年金保険者名称);
        csvEntity.set年月(年月);
        csvEntity.set市町村コード(特徴異動件数Entity.get構成市町村コード());
        csvEntity.set市町村名称(特徴異動件数Entity.get市町村名称());
        csvEntity.set保険者番号(保険者情報_保険者番号);
        csvEntity.set保険者名称(保険者情報_保険者名称);

        csvEntity.set義務者コード(特徴異動件数Entity.getDT特別徴収義務者コード());
        csvEntity.set組合名称(組合名称);
        csvEntity.set該当件数(new RString(特徴異動件数Entity.get件数()));
        csvEntity.set資格喪失(new RString(特徴異動件数Entity.get資格件数()));
        csvEntity.set住所地特例(new RString(特徴異動件数Entity.get住所地特例件数()));
        csvEntity.set仮徴収額変更(new RString(特徴異動件数Entity.get仮徴収額変更件数()));
        csvEntity.set特徴追加依頼(new RString(特徴異動件数Entity.get追加依頼件数()));

        csvEntity.set媒体番号(RString.EMPTY);
        csvEntity.set収録件数(RString.EMPTY);

        return csvEntity;
    }

    private void loadバッチ出力条件リスト(List<RString> 出力条件リスト,
            ReportId 帳票ID, int 出力ページ数, RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                new RString(String.valueOf(出力ページ数)),
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private boolean isNotNull(Object o) {
        return o != null;
    }
}
