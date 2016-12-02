/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710060;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyushakogaku.HanyoListKyodoJukyushaKogakuCsvEditor;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyodoshoriyojukyushajoho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710060.HanyoListKyodoJukyushaKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710060.HanyoListKyodoJukyushaKogakuEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト 共同処理用受給者情報（高額）のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3098-020 xushouyue
 */
public class HanyoListKyodoJukyushaKogakuProcess extends BatchProcessBase<HanyoListKyodoJukyushaKogakuEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710060."
                    + "IHanyoListKyodoJukyushaKogakuMapper.select共同受給者高額情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701006");
    private final RString csvFileName = new RString("HanyoList_KyodoJukyushaKogaku.csv");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　共同受給者高額情報CSV");
    private static final RString 定数_なし = new RString("なし");
    private static final RString 定数_あり = new RString("あり");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString DATANAME_被保険者番号 = new RString("被保険者番号");
    private static final RString TITLE_抽出条件 = new RString("【抽出条件】");
    private static final RString TITLE_保険者 = new RString("　　　保険者：");
    private static final RString TITLE_日付抽出区分 = new RString("　　　日付抽出区分：");
    private static final RString TITLE_処理対象年月 = new RString("　　　　　処理対象年月：");
    private static final RString TITLE_異動年月 = new RString("　　　　　異動年月　　：");
    private static final RString TITLE_異動区分 = new RString("　　　　　異動区分：");
    private static final RString TITLE_世帯所得区分 = new RString("　　　　　世帯所得区分：");
    private static final RString TITLE_所得区分 = new RString("　　　　　所得区分：");
    private static final RString TITLE_老齢年金受給区分 = new RString("　　　　　齢年金受給区分：");
    private static final RString TITLE_利用者負担第２段階 = new RString("　　　　　利用者負担第２段階：");
    private static final RString RSTRING_0 = new RString("000000");
    private static final RString 全市町村 = new RString("全市町村");
    private static final RString すべて = new RString("すべて");
    private static final RString 受給なし = new RString("受給なし");
    private static final RString 受給あり = new RString("受給あり");
    private static final RString 該当なし = new RString("該当なし");
    private static final RString 該当あり = new RString("該当あり");
    private static final RString TILDE = new RString("～");
    private static final RString 各異動月の最新情報のみ = new RString("　　　　　■各異動月の最新情報のみ抽出する");
    private static final RString 削除含める = new RString("　　　　■削除された情報を含める");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");
    private static final RString FOUR = new RString("4");
    private static final RString 新規_FALSE = new RString("□新規　　");
    private static final RString 新規_TRUE = new RString("■新規　　");
    private static final RString 変更_FALSE = new RString("□変更　　");
    private static final RString 変更_TRUE = new RString("■変更　　");
    private static final RString 終了_FALSE = new RString("□終了");
    private static final RString 終了_TRUE = new RString("■終了");
    private static final RString 一般_FALSE = new RString("□一般（低所得者等以外）　");
    private static final RString 一般_TRUE = new RString("■一般（低所得者等以外）　");
    private static final RString 世帯非課税等_FALSE = new RString("□世帯非課税等　　");
    private static final RString 世帯非課税等_TRUE = new RString("■世帯非課税等　　");
    private static final RString 生活保護_FALSE = new RString("□生活保護　　");
    private static final RString 生活保護_TRUE = new RString("■生活保護　　");
    private static final RString 現役並み所得相当_FALSE = new RString("□現役並み所得相当");
    private static final RString 現役並み所得相当_TRUE = new RString("■現役並み所得相当");
    private static final RString 非課税等_FALSE = new RString("□非課税等　　　　");
    private static final RString 非課税等_TRUE = new RString("■非課税等　　　　");
    private HanyoListKyodoJukyushaKogakuProcessParameter parameter;
    private HanyoListKyodoJukyushaKogakuCsvEditor edit;
    private Association 地方公共団体情報;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;
    private int 連番;
    private RString csv出力Flag;
    private FileSpoolManager spoolManager;
    private CsvListWriter csvListWriter;
    private ChohyoSeigyoKyotsu 帳票制御共通;

    @Override
    protected void initialize() {
        edit = new HanyoListKyodoJukyushaKogakuCsvEditor();
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        構成市町村マスタ = new HashMap<>();
        List<KoseiShichosonMaster> 現市町村情報 = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (int i = 0; i < 現市町村情報.size(); i++) {
            構成市町村マスタ.put(現市町村情報.get(i).get市町村コード(), 現市町村情報.get(i));
        }
        personalDataList = new ArrayList<>();
        csv出力Flag = 定数_なし;
        連番 = 0;
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, new ReportId(parameter.get帳票ID()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(spoolManager.getEucOutputDirectry(),
                csvFileName);
        if (!parameter.is項目名付加()) {
            csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setEncode(Encode.UTF_8withBOM)
                    .hasHeader(false)
                    .build();
        } else {
            csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath).setNewLine(NewLine.CRLF)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setEncode(Encode.UTF_8withBOM)
                    .hasHeader(true)
                    .setHeader(edit.setHeaderList(parameter))
                    .build();
        }
    }

    @Override
    protected void process(HanyoListKyodoJukyushaKogakuEntity entity) {
        連番++;
        csv出力Flag = 定数_あり;
        Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(entity.get被保険者台帳管理().getShichosonCode());
        csvListWriter.writeLine(edit.setBodyList(entity, parameter, 構成市町村マスタ, 導入団体情報, 連番, 帳票制御共通));
        ExpandedInformation expandedInformation = new ExpandedInformation(
                CODE_0003, DATANAME_被保険者番号, entity.get受給者異動高額().getHiHokenshaNo().getColumnValue());
        personalDataList.add(PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInformation));
    }

    @Override
    protected void afterExecute() {
        long count;
        if (定数_なし.equals(csv出力Flag) && parameter.is項目名付加()) {
            List<RString> bodyList = new ArrayList<>();
            for (int i = 0; i < edit.setHeaderList(parameter).size(); i++) {
                bodyList.add(RString.EMPTY);
            }
            csvListWriter.writeLine(bodyList);
        }
        csvListWriter.close();
        if (定数_なし.equals(csv出力Flag)) {
            count = 0;
        } else {
            count = csvListWriter.getCount();
        }
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            spoolManager.spool(eucFilePath, accessLogUUID);
        } else {
            spoolManager.spool(eucFilePath);
        }
        RString csvCount = new RString(count);
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                地方公共団体情報.getLasdecCode_().value(),
                地方公共団体情報.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                csvCount,
                csv出力Flag,
                csvFileName,
                get抽出条件()
        );
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem)
                .print();
    }

    private List<RString> get抽出条件() {
        List<RString> 抽出条件 = new ArrayList<>();
        抽出条件.add(TITLE_抽出条件);
        RString empty = RString.EMPTY;
        RString temp = RString.EMPTY;

        if (parameter.get保険者コード() != null && !parameter.get保険者コード().isEmpty()) {
            if (RSTRING_0.equals(parameter.get保険者コード())) {
                temp = TITLE_保険者;
                temp = temp.concat(RSTRING_0).concat(全市町村);
            } else {
                Association association = AssociationFinderFactory.
                        createInstance().getAssociation(new LasdecCode(parameter.get保険者コード()));
                temp = temp.concat(parameter.get保険者コード()).concat(RString.HALF_SPACE).concat(association.get市町村名());
            }
        }
        抽出条件.add(temp);
        抽出条件.add(empty);
        if (parameter.get日付抽出区分() != null && !RString.EMPTY.equals(parameter.get日付抽出区分())) {
            temp = TITLE_日付抽出区分;
            if (HizukeChushutsuKubun.すべて.getコード().equals(parameter.get日付抽出区分())) {
                temp = temp.concat(HizukeChushutsuKubun.すべて.get名称());
            }
            if (HizukeChushutsuKubun.直近のみ.getコード().equals(parameter.get日付抽出区分())) {
                temp = temp.concat(HizukeChushutsuKubun.直近のみ.get名称());
            }
            if (HizukeChushutsuKubun.範囲指定.getコード().equals(parameter.get日付抽出区分())) {
                temp = temp.concat(HizukeChushutsuKubun.範囲指定.get名称());
            }
            抽出条件.add(temp);
        }

        if (!RString.isNullOrEmpty(parameter.get日付抽出区分()) && HizukeChushutsuKubun.範囲指定.getコード().equals(parameter.get日付抽出区分())) {
            FlexibleYearMonth 処理対象年月From = null;
            FlexibleYearMonth 処理対象年月To = null;
            FlexibleYearMonth 異動年月From = null;
            FlexibleYearMonth 異動年月To = null;
            if (!RString.isNullOrEmpty(parameter.get処理対象年月From())) {
                処理対象年月From = new FlexibleYearMonth(parameter.get処理対象年月From());
            }
            if (!RString.isNullOrEmpty(parameter.get処理対象年月To())) {
                処理対象年月To = new FlexibleYearMonth(parameter.get処理対象年月To());
            }
            if (!RString.isNullOrEmpty(parameter.get異動年月From())) {
                異動年月From = new FlexibleYearMonth(parameter.get異動年月From());
            }
            if (!RString.isNullOrEmpty(parameter.get異動年月To())) {
                異動年月To = new FlexibleYearMonth(parameter.get異動年月To());
            }
            temp = TITLE_処理対象年月;
            temp = temp.concat(do日付編集(処理対象年月From).concat(RString.FULL_SPACE).concat(TILDE)
                    .concat(RString.FULL_SPACE).concat(do日付編集(処理対象年月To)));
            抽出条件.add(temp);
            temp = TITLE_異動年月;
            temp = temp.concat(do日付編集(異動年月From)).concat(RString.FULL_SPACE).concat(TILDE)
                    .concat(RString.FULL_SPACE).concat(do日付編集(異動年月To));
            抽出条件.add(temp);
            if (parameter.is各異動月の最新のみ()) {
                抽出条件.add(各異動月の最新情報のみ);
            } else {
                抽出条件.add(empty);
            }
        }
        抽出条件.add(empty);

        get抽出条件Part2(empty, temp, 抽出条件);
        return 抽出条件;
    }

    private void get抽出条件Part2(RString empty, RString temp, List<RString> 抽出条件) {
        get抽出条件Part2_1(temp, 抽出条件);
        if (parameter.get老齢年金受給区分s() != null && !parameter.get老齢年金受給区分s().isEmpty()) {
            temp = TITLE_老齢年金受給区分;
            if (parameter.get老齢年金受給区分s().contains(true) && parameter.get老齢年金受給区分s().contains(false)) {
                temp = temp.concat(すべて);
            } else if (parameter.get老齢年金受給区分s().contains(true)) {
                temp = temp.concat(受給あり);
            } else if (parameter.get老齢年金受給区分s().contains(false)) {
                temp = temp.concat(受給なし);
            }
            抽出条件.add(temp);
        }

        if (parameter.get利用者負担第２段階s() != null && !parameter.get利用者負担第２段階s().isEmpty()) {
            temp = TITLE_利用者負担第２段階;
            if (parameter.get利用者負担第２段階s().contains(true) && parameter.get利用者負担第２段階s().contains(false)) {
                temp = temp.concat(すべて);
            } else if (parameter.get利用者負担第２段階s().contains(true)) {
                temp = temp.concat(該当あり);
            } else if (parameter.get利用者負担第２段階s().contains(false)) {
                temp = temp.concat(該当なし);
            }
            抽出条件.add(temp);
        }

        抽出条件.add(empty);
        if (parameter.is削除含める()) {
            抽出条件.add(削除含める);
        } else {
            抽出条件.add(empty);
        }
    }

    private void get抽出条件Part2_1(RString temp, List<RString> 抽出条件) {
        if (parameter.get異動区分s() != null && !parameter.get異動区分s().isEmpty()) {
            temp = TITLE_異動区分;
            if (parameter.get異動区分s().contains(ONE)) {
                temp = temp.concat(新規_TRUE);
            } else {
                temp = temp.concat(新規_FALSE);
            }
            if (parameter.get異動区分s().contains(TWO)) {
                temp = temp.concat(変更_TRUE);
            } else {
                temp = temp.concat(変更_FALSE);
            }
            if (parameter.get異動区分s().contains(THREE)) {
                temp = temp.concat(終了_TRUE);
            } else {
                temp = temp.concat(終了_FALSE);
            }
            抽出条件.add(temp);
        }

        if (parameter.get世帯所得区分s() != null && !parameter.get世帯所得区分s().isEmpty()) {
            temp = TITLE_世帯所得区分;
            if (parameter.get世帯所得区分s().contains(ONE)) {
                temp = temp.concat(一般_TRUE);
            } else {
                temp = temp.concat(一般_FALSE);
            }
            if (parameter.get世帯所得区分s().contains(TWO)) {
                temp = temp.concat(世帯非課税等_TRUE);
            } else {
                temp = temp.concat(世帯非課税等_FALSE);
            }
            if (parameter.get世帯所得区分s().contains(THREE)) {
                temp = temp.concat(生活保護_TRUE);
            } else {
                temp = temp.concat(生活保護_FALSE);
            }
            if (parameter.get世帯所得区分s().contains(FOUR)) {
                temp = temp.concat(現役並み所得相当_TRUE);
            } else {
                temp = temp.concat(現役並み所得相当_FALSE);
            }
            抽出条件.add(temp);
        }

        if (parameter.get所得区分s() != null && !parameter.get所得区分s().isEmpty()) {
            temp = TITLE_所得区分;
            if (parameter.get所得区分s().contains(ONE)) {
                temp = temp.concat(一般_TRUE);
            } else {
                temp = temp.concat(一般_FALSE);
            }
            if (parameter.get所得区分s().contains(TWO)) {
                temp = temp.concat(非課税等_TRUE);
            } else {
                temp = temp.concat(非課税等_FALSE);
            }
            if (parameter.get所得区分s().contains(THREE)) {
                temp = temp.concat(生活保護_TRUE);
            } else {
                temp = temp.concat(生活保護_FALSE);
            }
            if (parameter.get所得区分s().contains(FOUR)) {
                temp = temp.concat(現役並み所得相当_TRUE);
            } else {
                temp = temp.concat(現役並み所得相当_FALSE);
            }
            抽出条件.add(temp);
        }
    }

    private RString do日付編集(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }
}
