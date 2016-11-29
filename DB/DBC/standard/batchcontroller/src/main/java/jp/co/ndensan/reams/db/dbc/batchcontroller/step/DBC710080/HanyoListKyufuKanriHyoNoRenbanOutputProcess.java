/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710080;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyufukanrihyo.HanyoListKyufuKanriHyoCsvEntityEditor;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkyufukanrihyo.HanyoListKyufuKanriHyoOutputOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kyufukanrihyo.KyufuKanrihyo_MeisaigyoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710080.HanyoListKyufuKanriHyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710080.HanyoListKyufuKanriHyoNoRenbanCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710080.HanyoListKyufuKanriHyoEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * 汎用リスト(給付管理票)連番出力しないのバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3096-020 pengxingyi
 */
public class HanyoListKyufuKanriHyoNoRenbanOutputProcess extends BatchProcessBase<HanyoListKyufuKanriHyoEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710080."
                    + "IHanyoListKyufuKanriHyoMapper.select給付管理票");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701008");
    private final RString csvFileName = new RString("HanyoList_KyufuKanriHyo.csv");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　給付管理票");
    private static final RString 定数_なし = new RString("なし");
    private static final RString 定数_あり = new RString("あり");
    private static final RString TITLE_抽出対象者 = new RString("【抽出対象者】");
    private static final RString TITLE_保険者 = new RString("　保険者：");
    private static final RString TITLE_給付対象年月 = new RString("　給付対象年月：");
    private static final RString TITLE_明細行出力有無 = new RString("　明細行出力有無：");
    private static final RString TITLE_居宅支援事業者 = new RString("　居宅支援事業者：");
    private static final RString TITLE_委託先支援事業者 = new RString("　委託先支援事業者：");
    private static final RString 括弧LEFT = new RString("（");
    private static final RString 括弧RIGHT = new RString("）");
    private static final RString TILDE = new RString("～");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString DATANAME_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_ORDERBY = new RString("order by");
    private static final RString コンマ = new RString(",");
    private static final RString 項目名_給付管理票明細行番号 = new RString("\"kyufuKanrihyo_kyufuKanrihyoMeisaiLineNo\"");
    private static final RString 項目名_被保険者番号 = new RString("\"kyufuKanrihyo_hiHokenshaNo\"");
    private static final RString 項目名_サービス年月 = new RString("\"kyufuKanrihyo_serviceTeikyoYM\"");
    private HanyoListKyufuKanriHyoProcessParameter parameter;
    private Association 地方公共団体情報;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;
    private int 連番;
    private IOutputOrder 出力順;
    private RString csv出力Flag;
    FileSpoolManager spoolManager;
    private ChohyoSeigyoKyotsu 帳票制御共通;

    @BatchWriter
    private CsvWriter<HanyoListKyufuKanriHyoNoRenbanCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        if (parameter.get出力順() != 0L) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC701008.getReportId(), parameter.get出力順());
            if (出力順 != null) {
                parameter.set出力項目(MyBatisOrderByClauseCreator.create(HanyoListKyufuKanriHyoOutputOrder.class, 出力順).
                        concat(コンマ).concat(項目名_被保険者番号).
                        concat(コンマ).concat(項目名_サービス年月).
                        concat(コンマ).concat(項目名_給付管理票明細行番号));
            }
        } else {
            parameter.set出力項目(定数_ORDERBY.concat(項目名_被保険者番号).
                    concat(コンマ).concat(項目名_サービス年月).
                    concat(コンマ).concat(項目名_給付管理票明細行番号));
        }
        構成市町村マスタ = new HashMap<>();
        連番 = 0;
        csv出力Flag = 定数_なし;
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        List<KoseiShichosonMaster> 現市町村情報 = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (int i = 0; i < 現市町村情報.size(); i++) {
            構成市町村マスタ.put(現市町村情報.get(i).get市町村コード(), 現市町村情報.get(i));
        }
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701008.getReportId());
        personalDataList = new ArrayList<>();
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
        csvWriter = BatchWriters.csvWriter(HanyoListKyufuKanriHyoNoRenbanCsvEntity.class).
                filePath(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        if (parameter.is項目名付加()) {
            csvWriter.writeLine(HanyoListKyufuKanriHyoCsvEntityEditor.getHeaderNoRenban());
        }
    }

    @Override
    protected void process(HanyoListKyufuKanriHyoEntity entity) {
        Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(entity.get受給者台帳().getShichosonCode());
        連番++;
        csv出力Flag = 定数_あり;
        HanyoListKyufuKanriHyoCsvEntityEditor editor = new HanyoListKyufuKanriHyoCsvEntityEditor(entity, parameter,
                導入団体情報, 構成市町村マスタ, parameter.getシステム日付(), 連番);
        csvWriter.writeLine(editor.noRenbanEdit(帳票制御共通));
        ExpandedInformation expandedInformation = new ExpandedInformation(
                CODE_0003, DATANAME_被保険者番号, entity.getHiHokenshaNo().getColumnValue());
        personalDataList.add(PersonalData.of(entity.get宛名().getShikibetsuCode(), expandedInformation));
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            spoolManager.spool(SubGyomuCode.DBC介護給付, eucFilePath, accessLogUUID);
        } else {
            spoolManager.spool(SubGyomuCode.DBC介護給付, eucFilePath);
        }
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                地方公共団体情報.getLasdecCode_().value(),
                地方公共団体情報.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                日本語ファイル名,
                new RString(csvWriter.getCount()),
                csv出力Flag,
                csvFileName,
                get抽出条件()
        );
        OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem)
                .print();
    }

    private List<RString> get抽出条件() {
        List<RString> 抽出条件 = new ArrayList<>();
        RString temp;
        抽出条件.add(TITLE_抽出対象者);
        if (parameter.get保険者コード() != null && !LasdecCode.EMPTY.equals(parameter.get保険者コード())) {
            Association association = AssociationFinderFactory.
                    createInstance().getAssociation(parameter.get保険者コード());
            抽出条件.add(TITLE_保険者.concat(association.get市町村名()));
        }
        if ((parameter.get給付対象年月From() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get給付対象年月From()))
                || (parameter.get給付対象年月To() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get給付対象年月To()))) {
            temp = TITLE_給付対象年月;
            if (parameter.get給付対象年月From() != null) {
                temp = temp.concat(dateFormat(parameter.get給付対象年月From())).concat(RString.FULL_SPACE);
            }
            temp = temp.concat(TILDE);
            if (parameter.get給付対象年月To() != null) {
                temp = temp.concat(RString.FULL_SPACE).concat(dateFormat(parameter.get給付対象年月To()));
            }
            抽出条件.add(temp);
        }
        if (!RString.isNullOrEmpty(parameter.get居宅支援事業者コード())) {
            抽出条件.add(TITLE_居宅支援事業者.concat(括弧LEFT).concat(parameter.get居宅支援事業者コード()).
                    concat(括弧RIGHT).concat(parameter.get居宅支援事業者名()));
        }
        if (!RString.isNullOrEmpty(parameter.get委託先支援事業者コード())) {
            抽出条件.add(TITLE_委託先支援事業者.concat(括弧LEFT).concat(parameter.get委託先支援事業者コード()).
                    concat(括弧RIGHT).concat(parameter.get委託先支援事業者名()));
        }
        if (!RString.isNullOrEmpty(parameter.get明細行出力有無())) {
            抽出条件.add(TITLE_明細行出力有無.concat(KyufuKanrihyo_MeisaigyoKubun.toValue(parameter.get明細行出力有無()).get名称()));
        } else {
            抽出条件.add(TITLE_明細行出力有無.concat(KyufuKanrihyo_MeisaigyoKubun.明細行含む.get名称()));
        }
        return 抽出条件;
    }

    private RString dateFormat(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }
}
