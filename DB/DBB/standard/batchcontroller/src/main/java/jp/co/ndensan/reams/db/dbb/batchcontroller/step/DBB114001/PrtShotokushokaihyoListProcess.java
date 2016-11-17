/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB114001;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranBatchReport;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranBreakKey;
import jp.co.ndensan.reams.db.dbb.business.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.KoikiZenShichosonJohoParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.shotokushokaihyohakko.SaiHakkoParameter;
import jp.co.ndensan.reams.db.dbb.definition.core.shotokushokaihyo.PrtShotokushokaihyoListParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.shotokushokaihyohakko.ShotokuShokaihyoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokushokaihyo.ShotokuShoukaiDataTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.shotokushokaihyohakkoichiran.ShotokushokaihyoHakkoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7051KoseiShichosonMasterEntity;
import jp.co.ndensan.reams.db.dbz.business.core.koikizenshichosonjoho.KoikiZenShichosonJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 所得照会票一覧の出力のクラスです。
 *
 * @reamsid_L DBB-1720-040 lijunjun
 */
public class PrtShotokushokaihyoListProcess extends BatchKeyBreakBase<ShotokuShoukaiDataTempEntity> {

    private static final int NUM_0 = 0;
    private static final int NUM_5 = 5;
    private static final int NUM_6 = 6;
    private static final RString 町域コード = new RString("町域コード");
    private static final RString 行政区コード = new RString("行政区コード");
    private static final RString 世帯コード = new RString("世帯コード");
    private static final RString 識別コード = new RString("識別コード");
    private static final RString 氏名５０音カナ = new RString("氏名５０音カナ");
    private static final RString 生年月日 = new RString("生年月日");
    private static final RString 市町村コード = new RString("市町村コード");
    private static final RString 異動年月日 = new RString("異動年月日");
    private static final RString 前住所コード = new RString("前住所コード");
    private static final RString 被保険者区分コード_EMPTY = new RString("");
    private static final RString 被保険者区分コード_NUM1 = new RString("1");
    private static final RString 被保険者区分コード_NUM2 = new RString("2");
    private static final RString 本人 = new RString("1");
    private static final RString 世帯員 = new RString("2");
    private static final RString 候補者区分_転入者 = new RString("1");
    private static final RString 候補者区分_住特者 = new RString("2");
    private static final RString 印字_１号 = new RString("１号");
    private static final RString 印字_１号予 = new RString("１号（予）");
    private static final RString 印字_２号 = new RString("２号");
    private static final RString 印字_世帯員 = new RString("世帯員");
    private static final RString 印字_世帯員予 = new RString("世帯員（予）");
    private static final RString 印字_１号住特 = new RString("１号住特");
    private static final RString 印字_２号住特 = new RString("２号住特");
    private static final RString 印字_広域 = new RString("広域");
    private static final RString カンマ = new RString(",");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200024");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 所得照会票一覧_EUCファイル名 = new RString("ShotokushokaihyoHakkoIchiran.csv");
    private static final RString 定数_処理年度 = new RString("処理年度");
    private static final RString 定数_照会年月日 = new RString("照会年月日");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString 定数_テストプリント = new RString("テストプリント");
    private static final RString 定数_有り = new RString("有り");
    private static final RString 定数_無し = new RString("無し");
    private static final RString 定数_出力順ID = new RString("出力順ID");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 定数_再発行対象リスト = new RString("再発行対象リスト");
    private static final RString CSV出力有無_有り = new RString("あり");
    private static final RString CSVファイル名_一覧表 = new RString("所得照会票発行一覧表");
    private static final RString SELECTPATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db"
            + ".mapper.relate.shotokushokaihyo.IShotokushokaihyoMapper.selectAll所得照会票2");

    @BatchWriter
    private BatchReportWriter<ShotokushokaihyoHakkoIchiranSource> reportWriter;
    private ReportSourceWriter<ShotokushokaihyoHakkoIchiranSource> sourceWriter;
    private ShotokuShokaihyoHakkoProcessParameter processParameter;
    private PrtShotokushokaihyoListParameter myBatisParameter;
    @BatchWriter
    private CsvWriter<ShotokuShoukaiDataCSVEntity> eucCsvWriter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private IOutputOrder 出力順情報;
    private List<RString> pageBreakKeys;
    private Association association;
    private List<RString> 出力順項目リスト;
    private Map<RString, RString> 改頁項目Map;
    private List<RString> 改頁項目リスト;
    private RString 出力順;

    @Override
    public void initialize() {
        改頁項目Map = new HashMap<>();
        get出力順();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        association = finder.getAssociation();
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (processParameter.get出力順ID() == null) {
            return;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200024.getReportId(),
                    processParameter.get出力順ID());
            出力順 = MyBatisOrderByClauseCreator.create(ShotokushokaihyoHakkoIchiranOutPutOrder.class, 出力順情報);
        }
        if (出力順情報 == null) {
            return;
        }
        出力順項目リスト = new ArrayList<>();
        改頁項目リスト = new ArrayList();
        pageBreakKeys = new ArrayList<>();
        for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
            出力順項目リスト.add(item.get項目名());
            if (item.is改頁項目()) {
                改頁項目リスト.add(item.get項目名());
                pageBreakKeys.add(item.get項目ID());
            }
        }
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new PrtShotokushokaihyoListParameter();
        myBatisParameter.set出力順(出力順);
        return new BatchDbReader(SELECTPATH, myBatisParameter);
    }

    @Override
    protected void createWriter() {

        if (pageBreakKeys == null || pageBreakKeys.isEmpty()) {
            reportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdDBB.DBB200024.getReportId().value(), SubGyomuCode.DBB介護賦課).create();
        } else {
            PageBreaker<ShotokushokaihyoHakkoIchiranSource> breakPage
                    = new ShotokushokaihyoHakkoIchiranBreakKey(pageBreakKeys);
            reportWriter = BatchReportFactory.createBatchReportWriter(
                    ReportIdDBB.DBB200024.getReportId().value(), SubGyomuCode.DBB介護賦課).addBreak(breakPage).create();
        }
        sourceWriter = new ReportSourceWriter<>(reportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 所得照会票一覧_EUCファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(カンマ).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void keyBreakProcess(ShotokuShoukaiDataTempEntity t) {
    }

    @Override
    protected void usualProcess(ShotokuShoukaiDataTempEntity t) {
        change改頁項目コード(t);
        new ShotokushokaihyoHakkoIchiranBatchReport(t, creat構成市町村情報リスト(), 出力順項目リスト, 改頁項目Map, 改頁項目リスト,
                processParameter.get照会年月日(), processParameter.get処理年度(), processParameter.isテストプリント(), association)
                .writeBy(sourceWriter);
        publish所得情報一覧表(t);
    }

    private void change改頁項目コード(ShotokuShoukaiDataTempEntity entity) {
        改頁項目Map.put(町域コード, entity.getChoikiCode());
        改頁項目Map.put(行政区コード, entity.getGyoseikuCode());
        RString setaiCode = entity.getSetaiCode() == null ? RString.EMPTY : entity.getSetaiCode().getColumnValue();
        改頁項目Map.put(世帯コード, setaiCode);
        RString shikibetsuCode = entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().getColumnValue();
        改頁項目Map.put(識別コード, shikibetsuCode);
        RString kanaMeisho = entity.getKanaMeisho() == null ? RString.EMPTY : entity.getKanaMeisho().getColumnValue();
        改頁項目Map.put(氏名５０音カナ, kanaMeisho);
        RString seinengappiYMD = entity.getSeinengappiYMD() == null ? RString.EMPTY : new RString(entity.getSeinengappiYMD().toString());
        改頁項目Map.put(生年月日, seinengappiYMD);
        改頁項目Map.put(市町村コード, entity.getShichosonCode());
        RString idoYMD = entity.getIdoYMD() == null ? RString.EMPTY : new RString(entity.getIdoYMD().toString());
        改頁項目Map.put(異動年月日, idoYMD);
        改頁項目Map.put(前住所コード, entity.getZenjushoCode());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        int 出力ページ数 = sourceWriter.pageCount().value();
        loadバッチ出力条件リスト(出力ページ数, CSV出力有無_有り, CSVファイル名_一覧表);
        manager.spool(eucFilePath);
    }

    private void loadバッチ出力条件リスト(int 出力ページ数,
            RString csv出力有無, RString 帳票名) {

        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_処理年度).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get処理年度().wareki().toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_照会年月日).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get照会年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_出力対象).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(processParameter.get出力対象()));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        RString 有無し;
        if (processParameter.isテストプリント()) {
            有無し = 定数_有り;
        } else {
            有無し = 定数_無し;
        }
        builder.append((FORMAT_LEFT).concat(定数_テストプリント).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(有無し));
        出力条件リスト.add(builder.toRString());
        List<SaiHakkoParameter> 再発行対象リスト = processParameter.get再発行対象リスト();
        if (再発行対象リスト != null) {
            for (SaiHakkoParameter param : 再発行対象リスト) {
                builder = new RStringBuilder();
                RString 発行件数 = new RString(String.valueOf(param.get発行件数()));
                RString 処理年度 = new RString(param.get処理年度().toString());
                RString ユーザ = param.getユーザ();
                RString 処理日時 = new RString(param.get処理日時().toString());
                builder.append((FORMAT_LEFT).concat(定数_再発行対象リスト).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                        .concat(発行件数).concat(カンマ).concat(RString.FULL_SPACE)
                        .concat(処理年度).concat(カンマ).concat(RString.FULL_SPACE)
                        .concat(ユーザ).concat(カンマ).concat(RString.FULL_SPACE).concat(処理日時));
                出力条件リスト.add(builder.toRString());
            }
        } else {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(定数_再発行対象リスト).concat(FORMAT_RIGHT));
            出力条件リスト.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(定数_出力順ID).concat(FORMAT_RIGHT).concat(RString.FULL_SPACE)
                .concat(new RString(String.valueOf(processParameter.get出力順ID()))));
        出力条件リスト.add(builder.toRString());

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                ReportIdDBB.DBB200024.getReportId().getColumnValue(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                new RString(String.valueOf(出力ページ数)),
                csv出力有無,
                所得照会票一覧_EUCファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private void publish所得情報一覧表(ShotokuShoukaiDataTempEntity tempEntity) {
        ShotokuShoukaiDataCSVEntity entity = new ShotokuShoukaiDataCSVEntity();
        entity.set世帯コード(tempEntity.getSetaiCode());
        entity.setカナ氏名(tempEntity.getKanaMeisho());
        entity.set前住所(tempEntity.getZenjusho());
        entity.set生年月日(tempEntity.getSeinengappiYMD());
        entity.set照会日(processParameter.get照会年月日());
        entity.set転入日(tempEntity.getIdoYMD());
        entity.set種別(editor種別(tempEntity));
        entity.set識別コード(tempEntity.getShikibetsuCode());
        entity.set氏名(tempEntity.getMeisho());
        entity.set現住所(tempEntity.getGenjusho());
        RString 性別 = set性別コード(tempEntity);
        entity.set性別(性別);
        entity.set転出日(tempEntity.getIdoYMD());
        entity.set被保険者番号(tempEntity.getHihokenshaNo().getColumnValue());
        eucCsvWriter.writeLine(entity);
    }

    private RString set性別コード(ShotokuShoukaiDataTempEntity tempEntity) {
        if (Seibetsu.男.getコード().equals(tempEntity.getSeibetsuCode())) {
            return Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(tempEntity.getSeibetsuCode())) {
            return Seibetsu.女.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString editor種別(ShotokuShoukaiDataTempEntity tempEntity) {
        RString 種別 = RString.EMPTY;
        RString 候補者区分 = tempEntity.getKouhoshakubun();
        RString 被保険者区分コード = tempEntity.getHihokennshaKubunCode();
        RString 本人区分 = tempEntity.getHonninKubun();
        if (is１号(候補者区分, 本人区分, 被保険者区分コード)) {
            種別 = 印字_１号;
        } else if (is１号予(候補者区分, 本人区分, 被保険者区分コード)) {
            種別 = 印字_１号予;
        } else if (is２号(候補者区分, 本人区分, 被保険者区分コード)) {
            種別 = 印字_２号;
        } else if (is世帯員(候補者区分, 本人区分, 被保険者区分コード)) {
            種別 = 印字_世帯員;
        } else if (is世帯員予(候補者区分, 本人区分, 被保険者区分コード)) {
            種別 = 印字_世帯員予;
        } else if (is１号住特(候補者区分, 被保険者区分コード)) {
            種別 = 印字_１号住特;
        } else if (is２号住特(候補者区分, 被保険者区分コード)) {
            種別 = 印字_２号住特;
        } else if (is広域(creat構成市町村情報リスト(), tempEntity)) {
            種別 = 印字_広域;
        }
        return 種別;
    }

    private boolean is広域(List<KoikiZenShichosonJoho> 構成市町村情報リスト,
            ShotokuShoukaiDataTempEntity tempEntity) {
        RString 市町村コード = RString.EMPTY;
        RString 構成市町村情報_市町村コード = RString.EMPTY;
        if (tempEntity.getZenkokuJushoCode() != null && !tempEntity.getZenkokuJushoCode().isEmpty()) {
            if (NUM_6 <= tempEntity.getZenkokuJushoCode().toString().length()) {
                市町村コード = new RString(tempEntity.getZenkokuJushoCode().toString().substring(NUM_0, NUM_5));
            } else {
                市町村コード = new RString(tempEntity.getZenkokuJushoCode().toString());
            }
        }
        List<RString> 市町村コードリスト = new ArrayList<>();
        for (KoikiZenShichosonJoho 構成市町村情報 : 構成市町村情報リスト) {
            if (構成市町村情報.get市町村コード() != null) {
                構成市町村情報_市町村コード = new RString(構成市町村情報.get市町村コード()
                        .toString().substring(NUM_0, NUM_5));
            }
            市町村コードリスト.add(構成市町村情報_市町村コード);
        }
        return 市町村コードリスト.contains(市町村コード);
    }

    private boolean is２号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分_住特者.equals(候補者区分) && 被保険者区分コード_NUM2.equals(被保険者区分コード);
    }

    private boolean is１号住特(RString 候補者区分, RString 被保険者区分コード) {
        return 候補者区分_住特者.equals(候補者区分) && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

    private boolean is世帯員予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 世帯員.equals(本人区分)
                && 被保険者区分コード_EMPTY.equals(被保険者区分コード);
    }

    private boolean is世帯員(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 世帯員.equals(本人区分)
                && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

    private boolean is２号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_NUM2.equals(被保険者区分コード);
    }

    private boolean is１号予(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_EMPTY.equals(被保険者区分コード);
    }

    private boolean is１号(RString 候補者区分,
            RString 本人区分, RString 被保険者区分コード) {
        return 候補者区分_転入者.equals(候補者区分) && 本人.equals(本人区分)
                && 被保険者区分コード_NUM1.equals(被保険者区分コード);
    }

    private List<KoikiZenShichosonJoho> creat構成市町村情報リスト() {
        List<KoikiZenShichosonJoho> 構成市町村情報リスト = new ArrayList<>();
        List<KoikiZenShichosonJohoParameter> 構成市町村情報List = processParameter.get構成市町村情報リスト();
        if (構成市町村情報List != null) {
            for (KoikiZenShichosonJohoParameter param : 構成市町村情報List) {
                DbT7051KoseiShichosonMasterEntity entity = new DbT7051KoseiShichosonMasterEntity();
                entity.setShichosonShokibetsuID(param.getShichosonShokibetsuID());
                entity.setShichosonCode(param.getShichosonCode());
                entity.setShoKisaiHokenshaNo(new ShoKisaiHokenshaNo(param.getShoKisaiHokenshaNo()));
                entity.setKokuhorenKoikiShichosonNo(param.getKokuhorenKoikiShichosonNo());
                entity.setShichosonMeisho(param.getShichosonMeisho());
                entity.setTodofukenMeisho(param.getTodofukenMeisho());
                entity.setGunMeisho(param.getGunMeisho());
                entity.setYubinNo(param.getYubinNo());
                entity.setJusho(param.getJusho());
                entity.setTelNo(param.getTelNo());
                entity.setYusenChikuCode(param.getYusenChikuCode());
                entity.setTyohyoTodoufukenHyojiUmu(param.getTyohyoTodoufukenHyojiUmu());
                entity.setTyohyoGunHyojiUmu(param.getTyohyoGunHyojiUmu());
                entity.setTyohyoShichosonHyojiUmu(param.getTyohyoShichosonHyojiUmu());
                entity.setTyohyoJushoHenshuHouhou(param.getTyohyoJushoHenshuHouhou());
                entity.setTyohyoKatagakiHyojiUmu(param.getTyohyoKatagakiHyojiUmu());
                entity.setGaikokujinHyojiHouhou(param.getGaikokujinHyojiHouhou());
                entity.setRojinhokenShichosonNo(param.getRojinhokenShichosonNo());
                entity.setRokenJukyushaNoTaikei(param.getRokenJukyushaNoTaikei());
                entity.setShotokuHikidashiHoho(param.getShotokuHikidashiHoho());
                entity.setNofugakuDataRenkeiHoho(param.getNofugakuDataRenkeiHoho());
                entity.setTokuchoBunpaishuyaku(param.getTokuchoBunpaishuyaku());
                entity.setIkoYMD(param.getIkoYMD());
                entity.setKanyuYMD(param.getKanyuYMD());
                entity.setRidatsuYMD(param.getRidatsuYMD());
                entity.setGappeiKyuShichosonKubun(param.getGappeiKyuShichosonKubun());
                entity.setGappeiKyuShichosonHyojiUmu(param.getGappeiKyuShichosonHyojiUmu());
                entity.setGappeiChiikiNo(param.getGappeiChiikiNo());
                entity.setUnyoHokenshaNo(new ShoKisaiHokenshaNo(param.getUnyoHokenshaNo()));
                entity.setUnyoKaishiYMD(param.getUnyoKaishiYMD());
                entity.setUnyoShuryoYMD(param.getUnyoShuryoYMD());
                entity.setUnyoKeitaiKubun(param.getUnyoKeitaiKubun());
                KoikiZenShichosonJoho 構成市町村情報 = new KoikiZenShichosonJoho(entity);
                構成市町村情報リスト.add(構成市町村情報);
            }
        }
        return 構成市町村情報リスト;
    }

}
