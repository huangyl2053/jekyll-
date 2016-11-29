/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710070;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyodojukyushashokan.HanyoListKyodoJukyushaShokanCsvEditor;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kyodoshoriyojukyushajoho.HizukeChushutsuKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710070.HanyoListKyodoJukyushaShokanProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710070.KyodoJukyushaShokanEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト_共同処理用受給者情報（償還）のプロセスラスです。
 *
 * @reamsid_L DBC-3099-020 zhouchuanlin
 */
public class HanyoListKyodoJukyushaShokanProcess extends BatchProcessBase<KyodoJukyushaShokanEntity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710070."
            + "IHanyoListKyodoJukyushaShokanMapper.select共同処理用受給者異動償還情報");
    private static final RString CSVファイル名 = new RString("HanyoList_KyodoJukyushaShokan.csv");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　共同受給者償還情報CSV");
    private static final RString DATANAME_被保険者番号 = new RString("被保険者番号");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701007");
    private static final RString TITLE_抽出条件 = new RString("【抽出条件】");
    private static final RString TITLE_保険者 = new RString("　保険者：");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString なし = new RString("なし");
    private static final RString あり = new RString("あり");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString INDEX_1 = new RString("1");
    private static final RString INDEX_2 = new RString("2");
    private static final RString INDEX_3 = new RString("3");
    private static final RString 波線 = new RString("～");
    private static final RString TITLE_日付抽出区分 = new RString("　日付抽出区分：");
    private static final RString TITLE_異動区分 = new RString("　異動区分：");
    private static final RString TITLE_処理対象年月 = new RString("　　　処理対象年月：");
    private static final RString TITLE_異動年月 = new RString("　　　異動年月　　：");
    private static final RString 各異動月の最新のみ = new RString("■各異動月の最新情報のみ抽出する");
    private static final RString 全市町村_CODE = new RString("000000");
    private static final RString 全市町村 = new RString("00000 全市町村");
    private static final RString 新規_黒 = new RString("■新規");
    private static final RString 新規_白 = new RString("□新規");
    private static final RString 変更_黒 = new RString("■変更");
    private static final RString 変更_白 = new RString("□変更");
    private static final RString 終了_黒 = new RString("■終了");
    private static final RString 終了_白 = new RString("□終了");
    private static final RString スペース = new RString("   ");
    private static final RString 削除された情報を含める_黒 = new RString("■削除された情報を含める");
    private Association 地方公共団体情報;
    private HanyoListKyodoJukyushaShokanCsvEditor editor;
    private CsvListWriter csvListWriter;
    private RString spoolWorkPath;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private int 連番;
    private HanyoListKyodoJukyushaShokanProcessParameter processParameter;
    private FileSpoolManager spoolManager;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private RString csv出力Flag;
    private ChohyoSeigyoKyotsu 帳票制御共通;

    @Override
    protected void initialize() {
        連番 = 0;
        csv出力Flag = なし;
        構成市町村マスタ = new HashMap<>();
        personalDataList = new ArrayList<>();
        editor = new HanyoListKyodoJukyushaShokanCsvEditor();
        RDateTime システム日時 = RDateTime.now();
        processParameter.setシステム日時(システム日時);
        processParameter.setシステム日付(new FlexibleDate(システム日時.getDate().toDateString()));
        IShikibetsuTaishoPSMSearchKey searchKey = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先).setデータ取得区分(DataShutokuKubun.直近レコード).build();
        processParameter.setSearchKey(searchKey);

        spoolManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID,
                UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = spoolManager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, CSVファイル名);

        List<KoseiShichosonMaster> 現市町村情報 = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (int i = 0; i < 現市町村情報.size(); i++) {
            構成市町村マスタ.put(現市町村情報.get(i).get市町村コード(), 現市町村情報.get(i));
        }
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, new ReportId(processParameter.get帳票ID()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, processParameter.tomMybatisParameter());
    }

    @Override
    protected void createWriter() {
        if (!processParameter.is項目名付加()) {
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
                    .setHeader(editor.setHeaderList(processParameter))
                    .build();
        }
    }

    @Override
    protected void process(KyodoJukyushaShokanEntity entity) {
        連番++;
        csv出力Flag = あり;
        csvListWriter.writeLine(editor.setBodyList(entity, processParameter, 地方公共団体情報, 構成市町村マスタ, 連番, 帳票制御共通));
        ExpandedInformation expandedInformation = new ExpandedInformation(
                CODE_0003, DATANAME_被保険者番号, entity.get共同処理用受給者異動償還送付().getHiHokenshaNo().getColumnValue());
        personalDataList.add(PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInformation));
    }

    @Override
    protected void afterExecute() {
        long count;
        if (なし.equals(csv出力Flag) && processParameter.is項目名付加()) {
            List<RString> bodyList = new ArrayList<>();
            for (int i = 0; i < editor.setHeaderList(processParameter).size(); i++) {
                bodyList.add(RString.EMPTY);
            }
            csvListWriter.writeLine(bodyList);
        }
        if (なし.equals(csv出力Flag)) {
            count = 0;
        } else {
            count = csvListWriter.getCount();
        }
        csvListWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            spoolManager.spool(eucFilePath, accessLogUUID);
        } else {
            spoolManager.spool(eucFilePath);
        }

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                地方公共団体情報.getLasdecCode_().value(),
                地方公共団体情報.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                new RString(count),
                csv出力Flag,
                CSVファイル名,
                get抽出条件()
        );
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem)
                .print();
    }

    private List<RString> get抽出条件() {
        List<RString> 抽出条件 = new ArrayList<>();
        抽出条件.add(TITLE_抽出条件);
        if (RString.isNullOrEmpty(processParameter.get保険者コード())) {
            抽出条件.add(RString.EMPTY);
        } else if (!RString.isNullOrEmpty(processParameter.get保険者コード()) && 全市町村_CODE.equals(processParameter.get保険者コード())) {
            抽出条件.add(TITLE_保険者.concat(全市町村));
        } else {
            Association association = AssociationFinderFactory.
                    createInstance().getAssociation(new LasdecCode(processParameter.get保険者コード()));
            抽出条件.add(TITLE_保険者.concat(processParameter.get保険者コード().concat(association.get市町村名())));
        }
        抽出条件.add(RString.EMPTY);
        if (!processParameter.get日付抽出区分().isEmpty() && HizukeChushutsuKubun.すべて.getコード().equals(processParameter.get日付抽出区分())) {
            抽出条件.add(TITLE_日付抽出区分.concat(HizukeChushutsuKubun.すべて.get名称()));
        }
        if (!processParameter.get日付抽出区分().isEmpty() && HizukeChushutsuKubun.直近のみ.getコード().equals(processParameter.get日付抽出区分())) {
            抽出条件.add(TITLE_日付抽出区分.concat(HizukeChushutsuKubun.直近のみ.get名称()));
        }
        get抽出条件Part2(抽出条件);
        return 抽出条件;
    }

    private void get抽出条件Part2(List<RString> 抽出条件) {
        if (!processParameter.get日付抽出区分().isEmpty() && HizukeChushutsuKubun.範囲指定.getコード().equals(processParameter.get日付抽出区分())) {
            抽出条件.add(TITLE_日付抽出区分.concat(HizukeChushutsuKubun.範囲指定.get名称()));
            RString temp = TITLE_処理対象年月;
            if (processParameter.get処理対象年月FROM() != null && !FlexibleYearMonth.EMPTY.equals(processParameter.get処理対象年月FROM())) {
                temp = temp.concat(do日付編集(processParameter.get処理対象年月FROM())).concat(RString.FULL_SPACE);
            }
            temp = temp.concat(波線);
            if (processParameter.get処理対象年月TO() != null && !FlexibleYearMonth.EMPTY.equals(processParameter.get処理対象年月TO())) {
                temp = temp.concat(RString.FULL_SPACE).concat(do日付編集(processParameter.get処理対象年月TO()));
            }
            抽出条件.add(temp);
            RString tem = TITLE_異動年月;
            if (processParameter.get異動年月FROM() != null && !FlexibleYearMonth.EMPTY.equals(processParameter.get異動年月FROM())) {
                tem = tem.concat(do日付編集(processParameter.get異動年月FROM())).concat(RString.FULL_SPACE);
            }
            tem = tem.concat(波線);
            if (processParameter.get異動年月TO() != null && !FlexibleYearMonth.EMPTY.equals(processParameter.get異動年月TO())) {
                tem = tem.concat(RString.FULL_SPACE).concat(do日付編集(processParameter.get異動年月TO()));
            }
            抽出条件.add(tem);
            if (processParameter.is各異動月の最新のみ()) {
                抽出条件.add(各異動月の最新のみ);
            } else {
                抽出条件.add(RString.EMPTY);
            }
        }
        抽出条件.add(RString.EMPTY);
        RString 新規;
        if (processParameter.get異動区分S() != null && !processParameter.get異動区分S().isEmpty()) {
            if (processParameter.get異動区分S().contains(INDEX_1)) {
                新規 = 新規_黒.concat(スペース);
            } else {
                新規 = 新規_白.concat(スペース);
            }
            RString 変更;
            if (processParameter.get異動区分S().contains(INDEX_2)) {
                変更 = 変更_黒.concat(スペース);
            } else {
                変更 = 変更_白.concat(スペース);
            }
            RString 終了;
            if (processParameter.get異動区分S().contains(INDEX_3)) {
                終了 = 終了_黒;
            } else {
                終了 = 終了_白;
            }
            抽出条件.add(TITLE_異動区分.concat(新規).concat(変更).concat(終了));
        }
        RString 削除された情報を含める;
        if (processParameter.is削除含める()) {
            削除された情報を含める = 削除された情報を含める_黒;
        } else {
            削除された情報を含める = RString.EMPTY;
        }
        抽出条件.add(削除された情報を含める);
    }

    private RString do日付編集(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }

}
