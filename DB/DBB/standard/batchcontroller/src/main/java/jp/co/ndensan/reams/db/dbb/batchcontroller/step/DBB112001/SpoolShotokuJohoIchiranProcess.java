/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranReport;
import jp.co.ndensan.reams.db.dbb.business.report.toushoshotokujohochushutsurenkei.ShotokuJohoIchiranOrder;
import jp.co.ndensan.reams.db.dbb.business.report.toushoshotokujohochushutsurenkei.ShotokuJohoIchiranPageBreak;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB112003.SichousonEntity;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shutokujohochushutsurenkei.ShutokuJohoChushutsuRenkeiMybatisParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.csv.ShotokuJohoIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.ShotokuJohoIchiranKozaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 所得情報抽出・連携バッチの帳票の発行Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class SpoolShotokuJohoIchiranProcess extends BatchKeyBreakBase<ShotokuJohoIchiranKozaEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "toushoshotokujohochushutsurenkei.IToushoShotokuJohoChushutsuRenkeiMapper.get出力対象データ");
    private static final ReportId 帳票ID = ReportIdDBB.DBB200008.getReportId();
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString EUC_ENTITY_ID = new RString("DBB200008");
    private static final RString 出力ファイル名 = new RString("KaigoHokenShotokuJohoIchiranData.csv");
    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 異動_広域_2 = new RString("2");
    private static final RString 当初_単一_3 = new RString("3");
    private static final RString 異動_単一_4 = new RString("4");
    private static final RString TIME_FORMAT = new RString("HH:MM:SS");
    private static final RString 導入形態コード_111 = new RString("111");
    private static final RString 導入形態コード_120 = new RString("120");
    private static final RString INDEX_22 = new RString("22");
    private static final int INT_1 = 1;
    private static final RString 出力_市町村情報リスト = new RString("【市町村情報リスト】");
    private static final RString 出力_出力順 = new RString("【出力順】");
    private static final RString だいなり = new RString(">");
    private static final RString CSV出力有無_あり = new RString("あり");
    private static final RString CSV出力有無_なし = new RString("なし");
    private static final RString CSVファイル名_なし = new RString("-");
    private static final RString CSVファイル名_あり = new RString("介護保険所得情報一覧表");
    private static final RString 市町村コードRSTRING = new RString("市町村コード:");
    private static final RString 市町村名RSTRING = new RString("市町村名:");
    private static final RString 処理状態 = new RString("処理状態:");
    private static final RString 表示用処理状態 = new RString("表示用処理状態:");
    private static final RString 最新処理日時 = new RString("最新処理日時:");
    private static final RString 処理区分RSTRING = new RString("処理区分:");

    private ShutokuJohoShuchutsuRenkeiProcessParameter processParameter;
    private IOutputOrder 出力順情報;
    private List<RString> 改頁リスト;
    private List<RString> 並び順リスト;
    private List<RString> pageBreakKeys;
    private FileSpoolManager eucManager;
    private RString eucFilePath;
    private RString spoolWorkPath;
    private RString 市町村名称;
    private LasdecCode 市町村コード;
    private RString 導入形態コード;
    private Association association;
    private int 連番;

    @BatchWriter
    private BatchReportWriter<KaigoHokenShotokuJohoIchiranSource> batchReportWriter;
    private ReportSourceWriter<KaigoHokenShotokuJohoIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<ShotokuJohoIchiranCSVEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        RString 処理区分 = processParameter.get処理区分();
        if (当初_広域_1.equals(処理区分) || 異動_広域_2.equals(処理区分)) {
            導入形態コード = 導入形態コード_111;
        } else if (当初_単一_3.equals(処理区分) || 異動_単一_4.equals(処理区分)) {
            導入形態コード = 導入形態コード_120;
        }
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        association = finder.getAssociation();
        連番 = INT_1;
        get出力順();
    }

    @Override
    protected IBatchReader createReader() {
        RString 出力順 = MyBatisOrderByClauseCreator.create(ShotokuJohoIchiranOrder.class, 出力順情報);
        return new BatchDbReader(READ_DATA_ID, new ShutokuJohoChushutsuRenkeiMybatisParameter(出力順));
    }

    @Override
    protected void createWriter() {
        PageBreaker<KaigoHokenShotokuJohoIchiranSource> breakPage
                = new ShotokuJohoIchiranPageBreak(pageBreakKeys);
        batchReportWriter
                = BatchReportFactory.createBatchReportWriter(帳票ID.getColumnValue(), SubGyomuCode.DBB介護賦課).addBreak(breakPage).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        eucManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = eucManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void usualProcess(ShotokuJohoIchiranKozaEntity entity) {
        set市町村Joho(entity);
        KaigoHokenShotokuTempEntity item = getItem(entity);
        KaigoHokenShotokuJohoIchiranReport report = new KaigoHokenShotokuJohoIchiranReport(item, 導入形態コード, 市町村コード, 市町村名称,
                並び順リスト, 改頁リスト, association, 連番);
        report.writeBy(reportSourceWriter);
        連番 += 1;
        ShotokuJohoIchiranCSVEntity csvEntity = getCsvEntity(entity);
        eucCsvWriter.writeLine(csvEntity);
    }

    @Override
    protected void keyBreakProcess(ShotokuJohoIchiranKozaEntity t) {
    }

    @Override
    protected void afterExecute() {
        int 出力ページ数 = 0;
        RString csv出力有無;
        RString csvファイル名;
        if (連番 != INT_1) {
            出力ページ数 = reportSourceWriter.pageCount().value();
            csv出力有無 = CSV出力有無_あり;
            csvファイル名 = CSVファイル名_あり;
        } else {
            csvファイル名 = CSVファイル名_なし;
            csv出力有無 = CSV出力有無_なし;
        }
        load出力条件リスト(出力ページ数, csv出力有無, csvファイル名);
        eucCsvWriter.close();
        eucManager.spool(eucFilePath);
    }

    private void load出力条件リスト(int 出力ページ数, RString csv出力有無, RString csvファイル名) {
        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();
        List<RString> 出力条件リスト = set出力条件リスト();
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBB.DBB200008.getReportName(),
                new RString(String.valueOf(出力ページ数)),
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private List<RString> set出力条件リスト() {
        List<RString> 出力条件リスト = new ArrayList<>();
        List<SichousonEntity> 市町村情報List = processParameter.get市町村情報List();
        if (市町村情報List != null) {
            for (SichousonEntity 市町村情報 : 市町村情報List) {
                RString 市町村コードR = 市町村情報.get市町村コード() == null
                        || 市町村情報.get市町村コード().isEmpty() ? RString.EMPTY : 市町村情報.get市町村コード().getColumnValue();
                YMDHMS 処理日時 = 市町村情報.get処理日時();
                RString 処理日時R = 処理日時 == null || 処理日時.isEmpty() ? RString.EMPTY
                        : 処理日時.getDate().toDateString().concat(RString.FULL_SPACE)
                        .concat(処理日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                RString 出力条件 = 出力_市町村情報リスト.concat(市町村コードRSTRING).concat(市町村コードR);
                if (市町村情報.get市町村名() != null) {
                    出力条件 = 出力条件.concat(コンマ).concat(市町村名RSTRING).concat(市町村情報.get市町村名());
                }
                if (市町村情報.get処理状態() != null) {
                    出力条件 = 出力条件.concat(コンマ).concat(処理状態).concat(市町村情報.get処理状態());
                }
                if (市町村情報.get処理区分() != null) {
                    出力条件 = 出力条件.concat(コンマ).concat(処理区分RSTRING).concat(市町村情報.get処理区分());
                }
                if (市町村情報.get表示用処理状態() != null) {
                    出力条件 = 出力条件.concat(コンマ).concat(表示用処理状態).concat(市町村情報.get表示用処理状態());
                }
                if (処理日時R != null) {
                    出力条件 = 出力条件.concat(コンマ).concat(最新処理日時).concat(処理日時R);
                }
                出力条件リスト.add(出力条件);
            }
        }
        RString 出力条件_出力順 = 出力_出力順.concat(RString.FULL_SPACE);
        for (RString 出力順 : 並び順リスト) {
            出力条件_出力順 = 出力条件_出力順.concat(出力順).concat(だいなり);
        }
        出力条件_出力順 = 出力条件_出力順.substring(0, 出力条件_出力順.length() - INT_1);
        出力条件リスト.add(出力条件_出力順);
        return 出力条件リスト;
    }

    private ShotokuJohoIchiranCSVEntity getCsvEntity(ShotokuJohoIchiranKozaEntity entity) {
        KaigoShotoTempTableEntity 介護所得TempEntity = entity.get介護所得TempEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名entity = entity.get宛名();
        ShotokuJohoIchiranCSVEntity csvEntity = new ShotokuJohoIchiranCSVEntity();
        YMDHMS 入力日時 = processParameter.get処理日時();
        RString 作成年月日 = 入力日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        csvEntity.set作成年月日(作成年月日);
        RString 作成日時 = 入力日時.getRDateTime().format西暦(TIME_FORMAT.toString());
        csvEntity.set作成日時(作成日時);
        RString 市町村コードR = 市町村コード == null || 市町村コード.isEmpty() ? RString.EMPTY : 市町村コード.getColumnValue();
        csvEntity.set市町村コード(市町村コードR);
        csvEntity.set市町村名(市町村名称);
        RString 識別コードR = 介護所得TempEntity.getShikibetsuCode() == null
                || 介護所得TempEntity.getShikibetsuCode().isEmpty() ? RString.EMPTY : 介護所得TempEntity.getShikibetsuCode().getColumnValue();
        csvEntity.set識別コード(識別コードR);
        csvEntity = getCSVEntity(宛名entity, csvEntity);
        RString 所得年度 = 介護所得TempEntity.getShotoNendo() == null
                || 介護所得TempEntity.getShotoNendo().isEmpty() ? RString.EMPTY : 介護所得TempEntity.getShotoNendo().toDateString();
        csvEntity.set所得年度(所得年度);
        RString 性別code = 宛名entity == null ? RString.EMPTY : 宛名entity.getSeibetsuCode();
        RString 性別 = 性別code == null || 性別code.isEmpty() ? RString.EMPTY : Seibetsu.toValue(性別code).get名称();
        csvEntity.set性別(性別);
        RString 住民税課税区分_減免前 = 介護所得TempEntity.getKazeiKubun();
        RString 住民税課税区分_減免前R = 住民税課税区分_減免前 == null
                || 住民税課税区分_減免前.isEmpty() ? RString.EMPTY : KazeiKubun.toValue(住民税課税区分_減免前).get名称();
        csvEntity.set住民税課税区分_減免前(住民税課税区分_減免前R);
        HihokenshaNo 被保険者番号 = entity.get被保険者台帳管理entity() == null
                ? HihokenshaNo.EMPTY : entity.get被保険者台帳管理entity().getHihokenshaNo();
        RString 被保険者番号R = 被保険者番号 == null || 被保険者番号.isEmpty() ? RString.EMPTY : 被保険者番号.getColumnValue();
        csvEntity.set被保険者番号(被保険者番号R);
        csvEntity = getCsvEntity(介護所得TempEntity, 宛名entity, csvEntity);
        return csvEntity;
    }

    private ShotokuJohoIchiranCSVEntity getCsvEntity(KaigoShotoTempTableEntity 介護所得TempEntity,
            UaFt200FindShikibetsuTaishoEntity 宛名entity, ShotokuJohoIchiranCSVEntity csvEntity) {
        RString 住民税課税区分_減免後 = 介護所得TempEntity.getKazeiKubunGemmenGo();
        RString 住民税課税区分_減免後R = 住民税課税区分_減免後 == null
                || 住民税課税区分_減免後.isEmpty() ? RString.EMPTY : KazeiKubun.toValue(住民税課税区分_減免後).get名称();
        csvEntity.set住民税課税区分_減免後(住民税課税区分_減免後R);
        RString 合計所得金額 = 介護所得TempEntity.getGokeiShotokuGaku() == null
                ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(介護所得TempEntity.getGokeiShotokuGaku(), 0);
        csvEntity.set合計所得金額(合計所得金額);
        RString 課税標準額 = 介護所得TempEntity.getKazeiShotoGaku() == null
                ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(介護所得TempEntity.getKazeiShotoGaku(), 0);
        csvEntity.set課税標準額(課税標準額);
        csvEntity.set登録業務(RString.EMPTY);
        RString 消除事由コード = 宛名entity == null ? RString.EMPTY : 宛名entity.getShojoJiyuCode();
        FlexibleDate 生年月日 = 宛名entity == null ? FlexibleDate.EMPTY : 宛名entity.getSeinengappiYMD();
        RString 年齢 = RString.EMPTY;
        if (生年月日 != null && !生年月日.isEmpty()) {
            int システム年 = FlexibleDate.getNowDate().getYearValue();
            if (INDEX_22.equals(消除事由コード)) {
                FlexibleDate 消除異動年月日 = 宛名entity == null ? FlexibleDate.EMPTY : 宛名entity.getShojoIdoYMD();
                int 消除異動年 = 消除異動年月日 == null || 消除異動年月日.isEmpty() ? システム年 : 消除異動年月日.getYearValue();
                年齢 = new RString(消除異動年 - 生年月日.getYearValue());
            } else {
                年齢 = new RString(システム年 - 生年月日.getYearValue());
            }
        }
        csvEntity.set年齢(年齢);
        RString 住民種別コード = 宛名entity == null ? RString.EMPTY : 宛名entity.getJuminShubetsuCode();
        RString 種別 = 住民種別コード == null || 住民種別コード.isEmpty() ? RString.EMPTY : JuminShubetsu.toValue(住民種別コード).toRString();
        csvEntity.set種別(種別);
        RString 年金収入額 = 介護所得TempEntity.getNenkiniShunyuGaku() == null
                ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(介護所得TempEntity.getNenkiniShunyuGaku(), 0);
        csvEntity.set年金収入額(年金収入額);
        return csvEntity;
    }

    private ShotokuJohoIchiranCSVEntity getCSVEntity(UaFt200FindShikibetsuTaishoEntity 宛名entity, ShotokuJohoIchiranCSVEntity csvEntity) {
        RString 氏名_カナR = RString.EMPTY;
        RString 生年月日R = RString.EMPTY;
        RString 氏名R = RString.EMPTY;
        if (宛名entity != null) {
            AtenaKanaMeisho 氏名_カナ = 宛名entity.getKanaMeisho();
            氏名_カナR = 氏名_カナ == null || 氏名_カナ.isEmpty() ? RString.EMPTY : 氏名_カナ.getColumnValue();
            FlexibleDate 生年月日 = 宛名entity.getSeinengappiYMD();
            生年月日R = 生年月日 == null || 生年月日.isEmpty() ? RString.EMPTY : 生年月日.seireki().toDateString();
            AtenaMeisho 氏名 = 宛名entity.getMeisho();
            氏名R = 氏名 == null || 氏名.isEmpty() ? RString.EMPTY : 氏名.getColumnValue();
        }
        csvEntity.set氏名_カナ(氏名_カナR);
        csvEntity.set生年月日(生年月日R);
        csvEntity.set氏名(氏名R);
        return csvEntity;
    }

    private KaigoHokenShotokuTempEntity getItem(ShotokuJohoIchiranKozaEntity entity) {
        KaigoShotoTempTableEntity 介護所得TempEntity = entity.get介護所得TempEntity();
        UaFt200FindShikibetsuTaishoEntity 宛名entity = entity.get宛名();
        KaigoHokenShotokuTempEntity item = new KaigoHokenShotokuTempEntity();
        item.setShikibetsuCode(介護所得TempEntity.getShikibetsuCode());
        item.setHihokenshaNo(entity.get被保険者台帳管理entity() == null
                ? HihokenshaNo.EMPTY : entity.get被保険者台帳管理entity().getHihokenshaNo());
        if (宛名entity != null) {
            item.setKanaMeisho(宛名entity.getKanaMeisho());
            item.setMeisho(宛名entity.getMeisho());
            item.setSeinengappiYMD(宛名entity.getSeinengappiYMD());
            item.setShojoJiyuCode(宛名entity.getShojoJiyuCode());
            item.setShojoIdoYMD(宛名entity.getShojoIdoYMD());
            item.setSeibetsuCode(宛名entity.getSeibetsuCode());
            item.setJuminShubetsuCode(宛名entity.getJuminShubetsuCode());
            item.setTorokuGyomu(宛名entity.getTorokuJiyuCode());
        } else {
            item.setKanaMeisho(AtenaKanaMeisho.EMPTY);
            item.setMeisho(AtenaMeisho.EMPTY);
            item.setSeinengappiYMD(FlexibleDate.EMPTY);
            item.setShojoJiyuCode(RString.EMPTY);
            item.setShojoIdoYMD(FlexibleDate.EMPTY);
            item.setSeibetsuCode(RString.EMPTY);
            item.setJuminShubetsuCode(RString.EMPTY);
            item.setTorokuGyomu(RString.EMPTY);
        }
        item.setShotokuNendo(介護所得TempEntity.getShotoNendo());
        item.setKazeiKubun(介護所得TempEntity.getKazeiKubun());
        item.setKazeiKubunGemmenGo(介護所得TempEntity.getKazeiKubunGemmenGo());
        item.setGokeiShotokuGaku(介護所得TempEntity.getGokeiShotokuGaku());
        item.setNenkiniShunyuGaku(介護所得TempEntity.getNenkiniShunyuGaku());
        item.setNenkiniShotokuGaku(介護所得TempEntity.getNenkiniShotokuGaku());
        item.setKazeiShotokuGaku(介護所得TempEntity.getKazeiShotoGaku());
        return item.toKaigoHokenShotokuTempEntity(item);
    }

    private void set市町村Joho(ShotokuJohoIchiranKozaEntity entity) {
        市町村名称 = RString.EMPTY;
        if (導入形態コード_111.equals(導入形態コード)) {
            市町村コード = entity.get介護所得TempEntity().getShichosonCode();
            List<SichousonEntity> 市町村情報List = processParameter.get市町村情報List();
            for (SichousonEntity 市町村情報 : 市町村情報List) {
                if (市町村コード != null && !市町村コード.isEmpty() && 市町村コード.equals(市町村情報.get市町村コード())) {
                    市町村名称 = 市町村情報.get市町村名();
                }
            }
        } else {
            市町村コード = association.get地方公共団体コード();
            市町村名称 = association.get市町村名();
        }
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (RString.isNullOrEmpty(processParameter.get出力順ID())) {
            出力順情報 = null;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBB介護賦課, 帳票ID, Long.parseLong(processParameter.get出力順ID().toString()));
        }
        if (出力順情報 == null) {
            return;
        }
        並び順リスト = new ArrayList<>();
        改頁リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            並び順リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                改頁リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }
}
