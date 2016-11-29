/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710090;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkagomoshitate.HanyoListKagoMoshitateCsvEntityEditor;
import jp.co.ndensan.reams.db.dbc.business.euc.hanyolistkagomoshitate.HanyoListKagoMoshitateOutputOrder;
import jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate.KagoMoshitateHokenshaKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc710090.HanyoListKagoMoshitateProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc710090.HanyoListKagoMoshitateCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc710090.HanyoListKagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.kanri.JushoHenshu;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
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
 * 汎用リスト(過誤申立情報)のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3095-020 pengxingyi
 */
public class HanyoListKagoMoshitateOutputProcess extends BatchProcessBase<HanyoListKagoMoshitateEntity> {

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc710090."
                    + "IHanyoListKagoMoshitateMapper.select過誤申立情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701009");
    private final RString csvFileName = new RString("HanyoList_KagoMoshitate.csv");
    private static final RString 日本語ファイル名 = new RString("汎用リスト　過誤申立情報CSV");
    private static final RString 定数_なし = new RString("なし");
    private static final RString 定数_あり = new RString("あり");
    private static final RString TITLE_抽出対象者 = new RString("【抽出対象者】");
    private static final RString TITLE_保険者 = new RString("　保険者：");
    private static final RString TITLE_国保連送付年月 = new RString("　国保連送付年月：");
    private static final RString TITLE_過誤申立給付区分 = new RString("　過誤申立給付区分：");
    private static final RString TITLE_サービス提供年月 = new RString("　サービス提供年月：");
    private static final RString TITLE_事業者 = new RString("　事業者：");
    private static final RString 括弧LEFT = new RString("（");
    private static final RString 括弧RIGHT = new RString("）");
    private static final RString TILDE = new RString("～");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final Code CODE_0003 = new Code("0003");
    private static final RString DATANAME_被保険者番号 = new RString("被保険者番号");
    private static final RString 定数_ORDERBY = new RString("order by");
    private static final RString コンマ = new RString(",");
    private static final RString 項目名_履歴番号 = new RString("\"dbT3059KagoMoshitate_rirekiNo\"");
    private IOutputOrder 出力順;
    private HanyoListKagoMoshitateProcessParameter parameter;
    private Association 地方公共団体情報;
    private Map<LasdecCode, KoseiShichosonMaster> 構成市町村マスタ;
    private List<PersonalData> personalDataList;
    private RString eucFilePath;
    private int 連番;
    private RString csv出力Flag;
    FileSpoolManager spoolManager;
    private ChohyoSeigyoKyotsu 帳票制御共通情報;

    @BatchWriter
    private CsvWriter<HanyoListKagoMoshitateCsvEntity> csvWriter;

    @Override
    protected void initialize() {
        if (!RString.isNullOrEmpty(parameter.get出力順())) {
            IChohyoShutsuryokujunFinder iChohyoShutsuryokujunFinder = ChohyoShutsuryokujunFinderFactory.createInstance();
            出力順 = iChohyoShutsuryokujunFinder.get出力順(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC701009.getReportId(), Long.valueOf(parameter.get出力順().toString()));
            if (出力順 != null) {
                parameter.set出力項目(MyBatisOrderByClauseCreator.create(HanyoListKagoMoshitateOutputOrder.class, 出力順).
                        concat(コンマ).concat(HanyoListKagoMoshitateOutputOrder.被保険者番号.getMyBatis項目名()).
                        concat(コンマ).concat(HanyoListKagoMoshitateOutputOrder.サービス年月.getMyBatis項目名()).
                        concat(コンマ).concat(項目名_履歴番号));
            }
        } else {
            parameter.set出力項目(定数_ORDERBY.concat(HanyoListKagoMoshitateOutputOrder.被保険者番号.getMyBatis項目名()).
                    concat(コンマ).concat(HanyoListKagoMoshitateOutputOrder.サービス年月.getMyBatis項目名()).
                    concat(コンマ).concat(項目名_履歴番号));
        }
        構成市町村マスタ = new HashMap<>();
        連番 = 0;
        csv出力Flag = 定数_なし;
        地方公共団体情報 = AssociationFinderFactory.createInstance().getAssociation();
        List<KoseiShichosonMaster> 現市町村情報 = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (int i = 0; i < 現市町村情報.size(); i++) {
            構成市町村マスタ.put(現市町村情報.get(i).get市町村コード(), 現市町村情報.get(i));
        }
        personalDataList = new ArrayList<>();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通情報 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701009.getReportId());
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
        csvWriter = BatchWriters.csvWriter(HanyoListKagoMoshitateCsvEntity.class).
                filePath(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
        if (parameter.is項目名付加()) {
            csvWriter.writeLine(HanyoListKagoMoshitateCsvEntityEditor.getHeader());
        }
    }

    @Override
    protected void process(HanyoListKagoMoshitateEntity entity) {
        Association 導入団体情報 = AssociationFinderFactory.createInstance().getAssociation(entity.get受給者台帳().getShichosonCode());
        IKojin 宛名 = ShikibetsuTaishoFactory.createKojin(entity.get宛名());
        RString 住所番地方書 = JushoHenshu.editJusho(帳票制御共通情報, 宛名, 導入団体情報);
        連番++;
        csv出力Flag = 定数_あり;
        HanyoListKagoMoshitateCsvEntityEditor edit = new HanyoListKagoMoshitateCsvEntityEditor(entity, parameter,
                地方公共団体情報, 構成市町村マスタ, parameter.getシステム日付(), 連番);
        csvWriter.writeLine(edit.edit(住所番地方書));
        ExpandedInformation expandedInformation = new ExpandedInformation(
                CODE_0003, DATANAME_被保険者番号, entity.get過誤申立().getHiHokenshaNo().getColumnValue());
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
        抽出条件.add(TITLE_抽出対象者);
        if (parameter.get保険者コード() != null && !LasdecCode.EMPTY.equals(parameter.get保険者コード())) {
            Association association = AssociationFinderFactory.
                    createInstance().getAssociation(parameter.get保険者コード());
            抽出条件.add(TITLE_保険者.concat(association.get市町村名()));
        }
        if ((parameter.get国保連送付年月From() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get国保連送付年月From()))
                || (parameter.get国保連送付年月To() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get国保連送付年月To()))) {
            RString temp = TITLE_国保連送付年月;
            if (parameter.get国保連送付年月From() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get国保連送付年月From())) {
                temp = temp.concat(dateFormat(parameter.get国保連送付年月From())).concat(RString.FULL_SPACE);
            }
            temp = temp.concat(TILDE);
            if (parameter.get国保連送付年月To() != null && !FlexibleYearMonth.EMPTY.equals(parameter.get国保連送付年月To())) {
                temp = temp.concat(RString.FULL_SPACE).concat(dateFormat(parameter.get国保連送付年月To()));
            }
            抽出条件.add(temp);
        }
        get抽出条件Part2(抽出条件);
        return 抽出条件;
    }

    private void get抽出条件Part2(List<RString> 抽出条件) {
        if (!RString.isNullOrEmpty(parameter.get過誤申立給付区分())) {
            抽出条件.add(TITLE_過誤申立給付区分.concat(KagoMoshitateHokenshaKubun.toValue(parameter.get過誤申立給付区分()).get名称()));
        }
        if ((parameter.getサービス提供年月From() != null && !FlexibleYearMonth.EMPTY.equals(parameter.getサービス提供年月From()))
                || (parameter.getサービス提供年月To() != null && !FlexibleYearMonth.EMPTY.equals(parameter.getサービス提供年月To()))) {
            RString temp = TITLE_サービス提供年月;
            if (parameter.getサービス提供年月From() != null && !FlexibleYearMonth.EMPTY.equals(parameter.getサービス提供年月From())) {
                temp = temp.concat(dateFormat(parameter.getサービス提供年月From())).concat(RString.FULL_SPACE);
            }
            temp = temp.concat(TILDE);
            if (parameter.getサービス提供年月To() != null && !FlexibleYearMonth.EMPTY.equals(parameter.getサービス提供年月To())) {
                temp = temp.concat(RString.FULL_SPACE).concat(dateFormat(parameter.getサービス提供年月To()));
            }
            抽出条件.add(temp);
        }
        if (!RString.isNullOrEmpty(parameter.get事業者コード())) {
            抽出条件.add(TITLE_事業者.concat(括弧LEFT).concat(parameter.get事業者コード()).
                    concat(括弧RIGHT).concat(parameter.get事業者名()));
        }
    }

    private RString dateFormat(FlexibleYearMonth date) {
        if (date == null) {
            return RString.EMPTY;
        }
        return date.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString();
    }
}
