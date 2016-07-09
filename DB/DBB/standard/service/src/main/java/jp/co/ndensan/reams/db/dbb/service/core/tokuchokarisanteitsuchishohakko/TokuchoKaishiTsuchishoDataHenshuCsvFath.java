/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.TokuchoKaishiTsuhishoKariOutputJoken;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.BinaryCharacterConvertParameterBuilder;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterAttribute;
import jp.co.ndensan.reams.uz.uza.externalcharacter.CharacterConvertTable;
import jp.co.ndensan.reams.uz.uza.externalcharacter.ReamsUnicodeToBinaryConverter;
import jp.co.ndensan.reams.uz.uza.externalcharacter.RecordConvertMaterial;
import jp.co.ndensan.reams.uz.uza.io.ByteWriter;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.FileReader;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 特徴仮算定通知書一括CSV発行（バッチ）
 *
 * @reamsid_L DBB-0790-040 chenaoqi
 */
public class TokuchoKaishiTsuchishoDataHenshuCsvFath {

    private static final int INT_5 = 5;
    private static final RString タイトル_作成年月日 = new RString("作成年月日");
    private static final RString タイトル_作成時刻 = new RString("作成時刻");
    private static final RString タイトル_賦課年度 = new RString("賦課年度");
    private static final RString タイトル_郵便番号 = new RString("郵便番号");
    private static final RString タイトル_住所 = new RString("住所");
    private static final RString タイトル_町域_管内_管外住所 = new RString("町域（管内）・管外住所");
    private static final RString タイトル_番地 = new RString("番地");
    private static final RString タイトル_行政区コード = new RString("行政区コード");
    private static final RString タイトル_行政区 = new RString("行政区");
    private static final RString タイトル_生年月日 = new RString("生年月日");
    private static final RString タイトル_性別 = new RString("性別");
    private static final RString タイトル_世帯主名 = new RString("世帯主名");
    private static final RString タイトル_通知書番号 = new RString("通知書番号");
    private static final RString タイトル_世帯コード = new RString("世帯コード");
    private static final RString タイトル_被保険者氏名 = new RString("被保険者氏名");
    private static final RString タイトル_特別徴収業務者コード = new RString("特別徴収業務者コード");
    private static final RString タイトル_特別徴収業務者 = new RString("特別徴収業務者");
    private static final RString タイトル_特別徴収対象年金コード = new RString("特別徴収対象年金コード");
    private static final RString タイトル_特別徴収対象年金 = new RString("特別徴収対象年金");
    private static final RString タイトル_本徴収額_10月 = new RString("本徴収額（10月）");
    private static final RString タイトル_本徴収額_12月 = new RString("本徴収額（12月）");
    private static final RString タイトル_本徴収額_2月 = new RString("本徴収額（2月）");
    private static final RString 定数_抽出条件 = new RString("抽出条件");
    private static final RString 定数_発行日 = new RString("発行日");
    private static final RString 定数_帳票名 = new RString("特別徴収開始通知書（仮算定）");
    private static final RString 定数_処理名 = new RString("「特徴仮算定通知書一括発行」");
    private static final RString 定数_出力対象 = new RString("出力対象");
    private static final RString ジョブ番号 = new RString("【ジョブ番号】");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBB200001_TokubetsuChoshuKaishiTsuchishoKariHakkoIchiran");
    private static final RString 特別徴収_EUCファイル名 = new RString("TokubetsuChoshuKaishiTsuchishoKairiHakkoIchiranData.csv");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final ReportId 帳票分類ID = new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final ReportId 代行プリント送付票_帳票ID = new ReportId("URU000A10_DaikoPrintCheck");
    private static final RString 拡張子_TEMP = new RString("Temp");

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKaishiTsuchishoDataHenshuCsvFath}のインスタンスを返します。
     *
     * @return TokuchoKaishiTsuchishoDataHenshuCsvFath
     */
    public static TokuchoKaishiTsuchishoDataHenshuCsvFath createInstance() {
        return InstanceProvider.create(TokuchoKaishiTsuchishoDataHenshuCsvFath.class);
    }

    /**
     * 特別徴収開始通知書仮算定発行一覧表ＣＳＶの出力メソッドです。
     *
     * @param 調定年度 FlexibleYear
     * @param 帳票作成日時 YMDHMS
     * @param 編集後仮算定通知書共通情報List List<EditedKariSanteiTsuchiShoKyotsu>
     */
    public void publish特別徴収開始通知書仮算定発行一覧表(FlexibleYear 調定年度, YMDHMS 帳票作成日時,
            List<EditedKariSanteiTsuchiShoKyotsu> 編集後仮算定通知書共通情報List) {

        List<RString> headerList = new ArrayList<>();
        headerList.add(タイトル_作成年月日);
        headerList.add(タイトル_作成時刻);
        headerList.add(タイトル_賦課年度);
        headerList.add(タイトル_郵便番号);
        headerList.add(タイトル_住所);
        headerList.add(タイトル_町域_管内_管外住所);
        headerList.add(タイトル_番地);
        headerList.add(タイトル_行政区コード);
        headerList.add(タイトル_行政区);
        headerList.add(タイトル_生年月日);
        headerList.add(タイトル_性別);
        headerList.add(タイトル_世帯主名);
        headerList.add(タイトル_通知書番号);
        headerList.add(タイトル_世帯コード);
        headerList.add(タイトル_被保険者氏名);
        headerList.add(タイトル_特別徴収業務者コード);
        headerList.add(タイトル_特別徴収業務者);
        headerList.add(タイトル_特別徴収対象年金コード);
        headerList.add(タイトル_特別徴収対象年金);
        headerList.add(タイトル_本徴収額_10月);
        headerList.add(タイトル_本徴収額_12月);
        headerList.add(タイトル_本徴収額_2月);

        FileSpoolManager manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        //RString euc共通_文字コード = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        RString eucFilePath = Path.combinePath(spoolWorkPath, 特別徴収_EUCファイル名);
//        if (!new RString("1").equals(euc共通_文字コード)) {
//            文字コード変換(eucFilePath);
//        }

        try (CsvListWriter csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .hasHeader(true).setHeader(headerList)
                .build()) {
            for (EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報 : 編集後仮算定通知書共通情報List) {
                List<RString> bodyList = new ArrayList<>();
                bodyList.add(帳票作成日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString());
                bodyList.add(帳票作成日時.getRDateTime().getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss));
                bodyList.add(調定年度.toDateString());
                if (isNull(編集後仮算定通知書共通情報.get編集後宛先())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get郵便番号());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get編集後住所());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get町域());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get番地());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後宛先().get行政区コード())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後宛先().get行政区コード().getColumnValue());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後宛先().get行政区名());
                }
                if (isNull(編集後仮算定通知書共通情報.get編集後個人())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get編集後個人().get生年月日Csv());
                    bodyList.add(編集後仮算定通知書共通情報.get編集後個人().get性別());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯主名())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue());

                }
                bodyList.add(isNull(編集後仮算定通知書共通情報.get通知書番号())
                        ? RString.EMPTY : 編集後仮算定通知書共通情報.get通知書番号().getColumnValue());
                if (isNull(編集後仮算定通知書共通情報.get編集後個人())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get世帯コード())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue());
                    bodyList.add(isNull(編集後仮算定通知書共通情報.get編集後個人().get名称())
                            ? RString.EMPTY : 編集後仮算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue());
                }
                if (isNull(編集後仮算定通知書共通情報.get更正後())) {
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                    bodyList.add(RString.EMPTY);
                } else {
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収義務者コード());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収義務者());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収対象年金コード());
                    bodyList.add(編集後仮算定通知書共通情報.get更正後().get更正後特別徴収対象年金());
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額01() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額01(), 0));
                    }
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額02() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額02(), 0));
                    }
                    if (編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額03() != null) {
                        bodyList.add(DecimalFormatter.toコンマ区切りRString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額03(), 0));
                    }
                }
                csvListWriter.writeLine(bodyList);
            }
            manager.spool(SubGyomuCode.DBB介護賦課, 特別徴収_EUCファイル名);
        }
    }

    private void 文字コード変換(RString filePath) {

        try (FileReader reader = new FileReader(filePath, Encode.UTF_8);
                ByteWriter writer = new ByteWriter(filePath.replace(拡張子_TEMP, RString.EMPTY))) {
            for (RString record = reader.readLine(); record != null; record = reader.readLine()) {
                BinaryCharacterConvertParameter convertParameter = new BinaryCharacterConvertParameterBuilder(
                        new RecordConvertMaterial(getCharacterConvertTable(), CharacterAttribute.混在))
                        .enabledConvertError(true)
                        .build();
                ReamsUnicodeToBinaryConverter converter = new ReamsUnicodeToBinaryConverter(convertParameter);
                writer.write(converter.convert(record));
            }
            writer.close();
        }
        deleteFile(filePath);
    }

    private void deleteFile(RString filePath) {
        File file = new File(filePath.toString());
        if (file.exists()) {
            file.getAbsoluteFile().deleteOnExit();
        }
    }

    private CharacterConvertTable getCharacterConvertTable() {
        RString euc共通_文字コード = DbBusinessConfig.get(ConfigNameDBU.EUC共通_文字コード, RDate.getNowDate(), SubGyomuCode.DBB介護賦課);
        if (new RString("2").equals(euc共通_文字コード)) {
            return CharacterConvertTable.Sjis;
        } else if (new RString("3").equals(euc共通_文字コード)) {
            return CharacterConvertTable.SjisRuiji;
        }
        return null;
    }

    /**
     * バッチ出力条件リストの出力メソッドです。
     *
     * @param 出力条件リスト List<RString>
     * @param 帳票ID ReportId
     * @param 出力ページ数 RString
     * @param csv出力有無 RString
     * @param csvファイル名 RString
     * @param 帳票名 RString
     */
    public void loadバッチ出力条件リスト(List<RString> 出力条件リスト, ReportId 帳票ID, RString 出力ページ数,
            RString csv出力有無, RString csvファイル名, RString 帳票名) {

        Association 地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 地方公共団体.getLasdecCode_().value();
        RString 市町村名 = 地方公共団体.get市町村名();

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID.getColumnValue(),
                導入団体コード,
                市町村名,
                RString.FULL_SPACE.concat(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件リスト);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * 代行プリント送付票の出力
     *
     * @param 発行日 FlexibleDate
     * @param 出力対象区分 RString
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param 地方公共団体 Association
     * @param 出力順ID Long
     * @param ページ数 Decimal
     */
    public void load代行プリント送付票(FlexibleDate 発行日, RString 出力対象区分,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            Association 地方公共団体, Long 出力順ID, Decimal ページ数) {

        if (!帳票制御共通情報.is代行プリント有無()) {
            return;
        }

        List<RString> 出力順項目List = new ArrayList<>();
        List<RString> 改ページ項目List = new ArrayList<>();
        set出力順_改頁(出力順ID, 出力順項目List, 改ページ項目List);

        List<RString> 抽出条件List = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(定数_抽出条件);
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_発行日.concat(RString.FULL_SPACE).concat(発行日.wareki().toDateString()));
        抽出条件List.add(builder.toRString());
        builder = new RStringBuilder();
        builder.append(定数_出力対象
                .concat(TokuchoKaishiTsuhishoKariOutputJoken.valueOf(出力対象区分.toString()).get名称()));
        抽出条件List.add(builder.toRString());
        List<RString> 帳票名List = new ArrayList<>();
        帳票名List.add(定数_帳票名);
        List<Decimal> ページ数List = new ArrayList<>();
        ページ数List.add(ページ数);

        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBB介護賦課,
                地方公共団体.getLasdecCode_(), 地方公共団体.get市町村名(),
                ジョブ番号.concat(RString.FULL_SPACE).concat(new RString(String.valueOf(JobContextHolder.getJobId()))),
                定数_処理名, 代行プリント送付票_帳票ID.getColumnValue(), 帳票名List, ページ数List, 抽出条件List,
                出力順項目List, 改ページ項目List, null);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        daikoPrint.print();
    }

    private void set出力順_改頁(Long 出力順ID, List<RString> 出力順項目List, List<RString> 改ページ項目List) {
        IChohyoShutsuryokujunFinder fider = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = fider.get出力順(SubGyomuCode.DBB介護賦課, 帳票分類ID, 出力順ID);
        if (outputOrder == null || outputOrder.get設定項目リスト() == null) {
            return;
        }
        int i = 1;
        for (ISetSortItem setSortItem : outputOrder.get設定項目リスト()) {
            if (i <= INT_5) {
                出力順項目List.add(setSortItem.get項目名());
                if (setSortItem.is改頁項目()) {
                    改ページ項目List.add(setSortItem.get項目名());
                }
            }
            i = i + 1;
        }
    }

    /**
     * nullの判断するメソッドです。
     *
     * @param 項目 Object
     * @return boolean 項目がnullの場合、falseを返し
     */
    public boolean isNull(Object 項目) {
        return 項目 == null;
    }

}
