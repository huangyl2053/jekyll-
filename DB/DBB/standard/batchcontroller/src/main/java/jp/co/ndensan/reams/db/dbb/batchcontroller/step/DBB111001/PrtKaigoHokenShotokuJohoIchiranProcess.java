/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB111001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranBreakKeys;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranOutPutOrder;
import jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranReport;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchoheinjunkakakutei.ShichosonJouhouResult;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.shotokujohoichiranhyosakusei.PrtKaigoHokenShotokuJohoIchiranParameter;
import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchoheinjunkakakutei.ShotokujohoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbb.definition.reportid.ReportIdDBB;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohoichiranhyosakusei.KaigoHokenShotokuTempEntity;
import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.fuka.KazeiKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
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
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護保険所得情報一覧表出力です。
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class PrtKaigoHokenShotokuJohoIchiranProcess extends BatchProcessBase<KaigoHokenShotokuTempEntity> {

    /**
     * OutputParameter用キー REPORT_FLAG
     */
    public static final RString REPORT_FLAG;
    private static final RString 表示する = new RString("1");
    private static final RString 表示しない = new RString("0");
    private static final int INDEX_1 = 1;
    private static final RString INDEX_111 = new RString("111");
    private static final RString INDEX_112 = new RString("112");
    private static final RString INDEX_120 = new RString("120");
    private static final RString EUCファイル名 = new RString("KaigoHokenShotokuJohoIchiran.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200008");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final ReportId 帳票ID = new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran");
    private static final RString 出力_出力条件 = new RString("出力条件");
    private static final RString 出力_導入形態コード = new RString("導入形態コード");
    private static final RString 出力_市町村コード = new RString("市町村コード");
    private static final RString 出力_市町村名称 = new RString("市町村名称");
    private static final RString 出力_処理年度 = new RString("処理年度");
    private static final RString 出力_抽出対象チェックボックス = new RString("抽出対象チェックボックス");
    private static final RString 出力_抽出対象ラジオボタン = new RString("抽出対象ラジオボタン");
    private static final RString 出力_抽出期間開始日時 = new RString("抽出期間開始日時");
    private static final RString 出力_抽出期間終了日時 = new RString("抽出期間終了日時");
    private static final RString 出力_市町村情報リスト = new RString("市町村情報リスト");
    private static final RString 出力_出力順ＩＤ = new RString("出力順ＩＤ");
    private static final RString FORMAT_LEFT = new RString("【");
    private static final RString FORMAT_RIGHT = new RString("】");
    private static final RString 出力_コンマ = new RString(",");
    private static final RString CSV出力有無_有り = new RString("あり");
    private static final RString CSVファイル名 = new RString("介護保険所得情報一覧表");
    private static final RString MAPPER_PATH = new RString("jp.co.ndensan.reams.db.dbb.persistence.db."
            + "mapper.relate.shotokujohoichiranhyosakusei.IShotokuJohoIchiranhyoSakuseiMapper");
    private static final RString SELECTALL = new RString(MAPPER_PATH + ".selectTempAll");
    @BatchWriter
    private BatchReportWriter<KaigoHokenShotokuJohoIchiranSource> reportWriter;
    private ReportSourceWriter<KaigoHokenShotokuJohoIchiranSource> hokenShotokuJohoIchiranSourceWriter;
    @BatchWriter
    private CsvWriter<KaigoHokenShotokuCSVEntity> eucCsvWriter;
    private PrtKaigoHokenShotokuJohoIchiranParameter myBatisParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Association association;
    private List<RString> 出力順項目リスト;
    private List<RString> 改頁項目リスト;
    private LasdecCode 市町村コード;
    private RString 導入形態コード;
    private RString 市町村名称;
    private IOutputOrder 出力順情報;
    private List<RString> pageBreakKeys;
    private RString 出力順;
    private Long 出力順ID;
    private RString チェックボックス;
    private RString ラジオボタン;
    private YMDHMS 開始日時;
    private YMDHMS 終了日時;
    private FlexibleYear 処理年度;
    private int 連番;
    private RString 表示場合;

    @BatchParameter
    ShotokujohoIchiranhyoSakuseiProcessParameter parameter;

    static {
        REPORT_FLAG = new RString("reportFlag");
    }

    private OutputParameter<RString> reportFlag;

    @Override
    public void initialize() {
        導入形態コード = parameter.get導入形態コード();
        if (INDEX_111.equals(導入形態コード)) {
            市町村コード = parameter.get市町村コード();
            市町村名称 = parameter.get市町村名称();
        }
        出力順ID = parameter.get出力順ID();
        チェックボックス = parameter.getチェックボックス();
        ラジオボタン = parameter.getラジオボタン();
        開始日時 = parameter.get開始日時();
        終了日時 = parameter.get終了日時();
        処理年度 = parameter.get処理年度();
        連番 = INDEX_1;
        get出力順();
        IAssociationFinder finder = AssociationFinderFactory.createInstance();
        association = finder.getAssociation();
        表示場合 = DbBusinessConfig.get(ConfigNameDBB.所得引出_住民税減免前後表示区分,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
    }

    private void get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        if (出力順ID == null) {
            return;
        } else {
            出力順情報 = finder.get出力順(SubGyomuCode.DBB介護賦課, ReportIdDBB.DBB200008.getReportId(),
                    出力順ID);
            出力順 = MyBatisOrderByClauseCreator.create(KaigoHokenShotokuJohoIchiranOutPutOrder.class, 出力順情報);
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
    protected void beforeExecute() {
        reportFlag = new OutputParameter<>();
    }

    @Override
    protected IBatchReader createReader() {
        myBatisParameter = new PrtKaigoHokenShotokuJohoIchiranParameter();
        myBatisParameter.set出力順(出力順);
        return new BatchDbReader(SELECTALL, myBatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<KaigoHokenShotokuJohoIchiranSource> breakPage
                = new KaigoHokenShotokuJohoIchiranBreakKeys(pageBreakKeys);
        reportWriter = BatchReportFactory.createBatchReportWriter(
                ReportIdDBB.DBB200008.getReportId().value(), SubGyomuCode.DBB介護賦課).addBreak(breakPage).create();
        hokenShotokuJohoIchiranSourceWriter = new ReportSourceWriter<>(reportWriter);

        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(カンマ).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(KaigoHokenShotokuTempEntity item) {
        new KaigoHokenShotokuJohoIchiranReport(item, 導入形態コード, 市町村コード, 市町村名称,
                出力順項目リスト, 改頁項目リスト, association, 連番).writeBy(hokenShotokuJohoIchiranSourceWriter);
        publish所得情報一覧表(item);
        連番++;
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        List<RString> 出力条件リスト = set出力条件リスト(導入形態コード, 処理年度,
                チェックボックス, ラジオボタン, 開始日時, 終了日時, parameter.get市町村情報リスト(), 出力順ID);
        int 出力ページ数 = hokenShotokuJohoIchiranSourceWriter.getPageGroupCount();
        RString 帳票名 = ReportIdDBB.DBB200008.getReportName();
        loadバッチ出力条件リスト(出力条件リスト, 帳票ID, 出力ページ数, CSV出力有無_有り, CSVファイル名, 帳票名);
        reportFlag.setValue(new RString(出力ページ数));
    }

    private List<RString> set出力条件リスト(RString 導入形態コード,
            FlexibleYear 処理年度, RString チェックボックス, RString ラジオボタン,
            YMDHMS 開始日時, YMDHMS 終了日時, List<ShichosonJouhouResult> 市町村情報リスト, Long 出力順ID) {
        List<RString> 出力条件リスト = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(出力_出力条件);
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(出力_導入形態コード).concat(FORMAT_RIGHT).concat(導入形態コード));
        出力条件リスト.add(builder.toRString());
        市町村コード = parameter.get市町村コード();
        if (市町村コード != null) {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(出力_市町村コード).concat(FORMAT_RIGHT).concat(市町村コード.getColumnValue()));
            出力条件リスト.add(builder.toRString());
        }
        市町村名称 = parameter.get市町村名称();
        if (市町村名称 != null) {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(出力_市町村名称).concat(FORMAT_RIGHT).concat(市町村名称));
            出力条件リスト.add(builder.toRString());
        }
        if (処理年度 != null) {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(出力_処理年度).concat(FORMAT_RIGHT).concat(処理年度.wareki().toDateString()));
            出力条件リスト.add(builder.toRString());
        }
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(出力_抽出対象チェックボックス).concat(FORMAT_RIGHT).concat(チェックボックス));
        出力条件リスト.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append((FORMAT_LEFT).concat(出力_抽出対象ラジオボタン).concat(FORMAT_RIGHT).concat(ラジオボタン));
        出力条件リスト.add(builder.toRString());
        if (INDEX_112.equals(導入形態コード) || INDEX_120.equals(導入形態コード)) {
            if (開始日時 != null) {
                builder = new RStringBuilder();
                builder.append((FORMAT_LEFT).concat(出力_抽出期間開始日時).concat(FORMAT_RIGHT)
                        .concat(new RString(開始日時.toString())));
                出力条件リスト.add(builder.toRString());
            }
            if (終了日時 != null) {
                builder = new RStringBuilder();
                builder.append((FORMAT_LEFT).concat(出力_抽出期間終了日時).concat(FORMAT_RIGHT)
                        .concat(new RString(終了日時.toString())));
                出力条件リスト.add(builder.toRString());
            }
        } else if (INDEX_111.equals(導入形態コード)) {
            for (ShichosonJouhouResult result : 市町村情報リスト) {
                if (result != null && result.get市町村コード() != null && result.get開始年月日() != null
                        && result.get終了年月日() != null && result.get市町村識別ID() != null
                        && result.get開始時刻() != null && result.get終了時刻() != null) {
                    builder = new RStringBuilder();
                    builder.append((FORMAT_LEFT).concat(出力_市町村情報リスト).concat(FORMAT_RIGHT)
                            .concat(result.get市町村コード().value())
                            .concat(出力_コンマ).concat(result.get市町村識別ID()).concat(出力_コンマ)
                            .concat(new RString(result.get開始年月日().toString()))
                            .concat(出力_コンマ).concat(result.get開始時刻()).concat(出力_コンマ)
                            .concat(new RString(result.get終了年月日().toString()))
                            .concat(出力_コンマ).concat(result.get終了時刻()));
                    出力条件リスト.add(builder.toRString());
                }
            }
        }
        if (出力順ID != null) {
            builder = new RStringBuilder();
            builder.append((FORMAT_LEFT).concat(出力_出力順ＩＤ).concat(FORMAT_RIGHT).concat(String.valueOf(出力順ID)));
            出力条件リスト.add(builder.toRString());
        }
        return 出力条件リスト;
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

    private void publish所得情報一覧表(KaigoHokenShotokuTempEntity item) {
        KaigoHokenShotokuCSVEntity entity = new KaigoHokenShotokuCSVEntity();
        entity.set識別コード(item.getShikibetsuCode());
        entity.set氏名カナ(item.getKanaMeisho());
        entity.set所得年度(item.getShotokuNendo());
        entity.set生年月日(item.getSeinengappiYMD());
        RString 性別コード = set性別コード(item.getSeibetsuCode());
        entity.set性別(性別コード);
        if (表示する.equals(表示場合)) {
            RString 課税区分減免前 = set課税区分減免前(item.getKazeiKubun());
            entity.set住民税課税区分減免前(課税区分減免前);
            RString 課税区分減免後 = set課税区分減免後(item.getKazeiKubunGemmenGo());
            entity.set住民税課税区分減免後(課税区分減免後);
            entity.set住民税(RString.EMPTY);
        } else if (表示しない.equals(表示場合)) {
            entity.set住民税課税区分減免前(RString.EMPTY);
            entity.set住民税課税区分減免後(RString.EMPTY);
            RString 住民税 = set課税区分減免前(item.getKazeiKubun());
            entity.set住民税(住民税);
        }
        entity.set住民税(item.getKazeiKubun());
        entity.set合計所得金額(item.getGokeiShotokuGaku());
        entity.set課税標準額(item.getKazeiShotokuGaku());
        entity.set登録業務(item.getTorokuGyomu());
        entity.set被保険者番号(item.getHihokenshaNo());
        entity.set氏名(item.getMeisho());
        entity.set年齢(item.getAge());
        RString 住民種別 = set住民種別(item.getJuminShubetsuCode());
        entity.set種別(住民種別);
        entity.set年金収入額(item.getNenkiniShunyuGaku());
        entity.set年金所得額(item.getNenkiniShotokuGaku());
        eucCsvWriter.writeLine(entity);
    }

    private RString set性別コード(RString 性別コード) {
        if (Seibetsu.男.getコード().equals(性別コード)) {
            return Seibetsu.男.get名称();
        } else if (Seibetsu.女.getコード().equals(性別コード)) {
            return Seibetsu.女.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString set住民種別(RString juminShubetsuCode) {
        if (JuminShubetsu.住登外個人_外国人.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.住登外個人_外国人.toRString();
        } else if (JuminShubetsu.住登外個人_日本人.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.住登外個人_日本人.toRString();
        } else if (JuminShubetsu.共有者.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.共有者.toRString();
        } else if (JuminShubetsu.外国人.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.外国人.toRString();
        } else if (JuminShubetsu.日本人.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.日本人.toRString();
        } else if (JuminShubetsu.法人.getCode().equals(juminShubetsuCode)) {
            return JuminShubetsu.法人.toRString();
        } else {
            return RString.EMPTY;
        }
    }

    private RString set課税区分減免後(RString 課税区分減免後) {
        if (KazeiKubun.課税.getコード().equals(課税区分減免後)) {
            return KazeiKubun.課税.get名称();
        } else if (KazeiKubun.所得調査中.getコード().equals(課税区分減免後)) {
            return KazeiKubun.所得調査中.get名称();
        } else if (KazeiKubun.未申告.getコード().equals(課税区分減免後)) {
            return KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(課税区分減免後)) {
            return KazeiKubun.課税取消.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(課税区分減免後)) {
            return KazeiKubun.非課税.get名称();
        } else {
            return RString.EMPTY;
        }
    }

    private RString set課税区分減免前(RString 課税区分減免前) {
        if (KazeiKubun.課税.getコード().equals(課税区分減免前)) {
            return KazeiKubun.課税.get名称();
        } else if (KazeiKubun.所得調査中.getコード().equals(課税区分減免前)) {
            return KazeiKubun.所得調査中.get名称();
        } else if (KazeiKubun.未申告.getコード().equals(課税区分減免前)) {
            return KazeiKubun.未申告.get名称();
        } else if (KazeiKubun.課税取消.getコード().equals(課税区分減免前)) {
            return KazeiKubun.課税取消.get名称();
        } else if (KazeiKubun.非課税.getコード().equals(課税区分減免前)) {
            return KazeiKubun.非課税.get名称();
        } else {
            return RString.EMPTY;
        }
    }

}
