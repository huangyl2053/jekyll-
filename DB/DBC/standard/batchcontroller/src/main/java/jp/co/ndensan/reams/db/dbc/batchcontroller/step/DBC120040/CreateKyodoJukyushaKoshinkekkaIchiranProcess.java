/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120040;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReport;
import jp.co.ndensan.reams.db.dbc.definition.core.chohyoseigyohanyo.ChohyoSeigyoHanyoKomokuMei;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_IdoKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_JukyushaIdoJiyu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuSetaiShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoKogakuShotokuKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_KyodoShokanIchijiSashitomeKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.core.jukyushaido.JukyushaIF_TeiseiKubunCode;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.kyodojukyushakoshinkekkain.KyodoJukyushaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportData;
import jp.co.ndensan.reams.db.dbc.entity.report.kyodojukyushakoshinkekkaichiran.KyodoJukyushaKoshinkekkaIchiranReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 共同処理用受給者情報一覧表Processクラスです。
 *
 * @reamsid_L DBC-2780-010 lishengli
 */
public class CreateKyodoJukyushaKoshinkekkaIchiranProcess extends BatchKeyBreakBase<KyodoJukyushaKoshinkekkaIchiranReportData> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kyodojukyushakoshinkekkain.IKyodoJukyushaKoshinKekkaInMapper.帳票出力対象データ取得");
    private static final ReportId REPORT_DBC200057 = ReportIdDBC.DBC200057.getReportId();
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBC200057"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString DATE_時 = new RString("時");
    private static final RString DATE_分 = new RString("分");
    private static final RString DATE_秒 = new RString("秒");
    private static final RString SAKUSEI = new RString("作成");
    private static final RString SANKAKU = new RString("△");
    private RString eucFilename;
    private RString spoolWorkPath;
    private FileSpoolManager manager;
    private List<PersonalData> personalDataList;
    private Map<RString, RString> 識別コードと被保険者番号;
    private RDateTime 作成日時;
    private boolean is1行目;
    @BatchWriter
    private BatchReportWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> batchWrite;
    private ReportSourceWriter<KyodoJukyushaKoshinkekkaIchiranReportSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter<KyodoJukyushaIchiranCSVEntity> eucCsvWriterJunitoJugo;

    @Override
    protected void initialize() {
        //TODO 出力順情報取得　関連展開待ち
        作成日時 = RDate.getNowDateTime();
        is1行目 = true;
        personalDataList = new ArrayList<>();
        識別コードと被保険者番号 = new HashMap<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.Euc, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolWorkPath = manager.getEucOutputDirectry();
        eucFilename = Path.combinePath(spoolWorkPath, new RString("DBC200057_KyodoJukyushaIchiran.csv"));
        eucCsvWriterJunitoJugo = new CsvWriter.InstanceBuilder(eucFilename).
                setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true).
                build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        batchWrite = BatchReportFactory.createBatchReportWriter(REPORT_DBC200057.value()).create();
        reportSourceWriter = new ReportSourceWriter(batchWrite);
    }

    @Override
    protected void usualProcess(KyodoJukyushaKoshinkekkaIchiranReportData data) {
        KyodoJukyushaKoshinkekkaIchiranReport report = new KyodoJukyushaKoshinkekkaIchiranReport(data,
                ChohyoSeigyoHanyoKomokuMei.帳票タイトル_定期.get名称(),
                作成日時, null);
        report.writeBy(reportSourceWriter);
        KyodoJukyushaIchiranCSVEntity entity = getCSVEntity(data);
        eucCsvWriterJunitoJugo.writeLine(entity);
        RString key = getKey(data.get被保険者一時TBL().get識別コード(), data.get被保険者一時TBL().get被保険者番号());
        if (data.get被保険者一時TBL().get識別コード() != null && !data.get被保険者一時TBL().get識別コード().isEmpty()
                && 識別コードと被保険者番号.containsKey(key)) {
            ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                    data.get被保険者一時TBL().get被保険者番号().value());
            PersonalData personalData = PersonalData.of(data.get被保険者一時TBL().get識別コード(), expandedInformations);
            personalDataList.add(personalData);
            識別コードと被保険者番号.put(key, key);
        }
        is1行目 = false;
    }

    @Override
    protected void keyBreakProcess(KyodoJukyushaKoshinkekkaIchiranReportData current) {
        hasBreak(getBefore(), current);
    }

    private boolean hasBreak(KyodoJukyushaKoshinkekkaIchiranReportData before, KyodoJukyushaKoshinkekkaIchiranReportData current) {
        return before.get共同処理一時TBL().get保険者番号() != current.get共同処理一時TBL().get保険者番号();
    }

    @Override
    protected void afterExecute() {
        eucCsvWriterJunitoJugo.close();
        AccessLogUUID id = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
        manager.spool(eucFilename, id);
    }

    private RString getKey(ShikibetsuCode 識別コード, HihokenshaNo 被保険者番号) {
        RStringBuilder key = new RStringBuilder();
        if (識別コード != null && !識別コード.isEmpty()) {
            key.append(識別コード);
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            key.append(被保険者番号);
        }
        return key.toRString();
    }

    private KyodoJukyushaIchiranCSVEntity getCSVEntity(KyodoJukyushaKoshinkekkaIchiranReportData data) {
        KyodoJukyushaIchiranCSVEntity csvEntity = new KyodoJukyushaIchiranCSVEntity();
        if (is1行目) {
            csvEntity.set作成日時(get作成日時());
        }
        csvEntity.set保険者番号(data.get共同処理一時TBL().get保険者番号());
        csvEntity.set保険者名(data.get共同処理一時TBL().get保険者名());
        if (data.get被保険者一時TBL().get登録被保険者番号() != null && !data.get被保険者一時TBL().get登録被保険者番号().isEmpty()) {
            csvEntity.set基_被保険者番号(data.get被保険者一時TBL().get登録被保険者番号().value());
        }
        csvEntity.set基_行政区コード(data.get被保険者一時TBL().get行政区コード());
        csvEntity.set基_行政区(data.get被保険者一時TBL().get行政区名());
        csvEntity.set基_被保険者カナ氏名(data.get被保険者一時TBL().get宛名カナ名称());
        csvEntity.set基_町域コード(data.get被保険者一時TBL().get町域コード());
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get基_交換情報識別番号())) {
            csvEntity.set基_異動年月日(getパターン4(data.get共同処理一時TBL().get基_異動年月日()));
            csvEntity.set基_異動区分(data.get共同処理一時TBL().get基_異動区分コード());
            csvEntity.set基_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get基_異動区分コード()));
            csvEntity.set基_異動事由(data.get共同処理一時TBL().get基_異動事由());
            csvEntity.set基_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get基_異動事由()));
            csvEntity.set基_訂正年月日(getパターン4(data.get共同処理一時TBL().get基_訂正年月日()));
            csvEntity.set基_訂正区分(data.get共同処理一時TBL().get基_訂正区分コード());
            csvEntity.set基_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get基_訂正区分コード()));
            csvEntity.set基_順序(data.get共同処理一時TBL().get基_帳票出力順序コード());
            csvEntity.set基_証記載保険者番号(data.get共同処理一時TBL().get基_証記載保険者番号());
            csvEntity.set基_被保険者氏名(data.get共同処理一時TBL().get基_被保険者番号());
            csvEntity.set基_電話番号(data.get共同処理一時TBL().get基_電話番号());
            csvEntity.set基_郵便番号(data.get共同処理一時TBL().get基_郵便番号());
            csvEntity.set基_住所カナ(data.get共同処理一時TBL().get基_住所カナ());
            csvEntity.set基_住所(data.get共同処理一時TBL().get基_住所());
        } else {
            csvEntity.set基_異動年月日(getパターン4(data.get共同処理用受給者異動基本送付TBL().getIdoYMD()));
            csvEntity.set基_異動区分(data.get共同処理用受給者異動基本送付TBL().getIdoKubunCode());
            csvEntity.set基_異動区分名称(get異動区分名称(data.get共同処理用受給者異動基本送付TBL().getIdoKubunCode()));
            csvEntity.set基_異動事由(data.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu());
            csvEntity.set基_異動事由名称(get異動事由名称(data.get共同処理用受給者異動基本送付TBL().getJukyushaIdoJiyu()));
            csvEntity.set基_訂正年月日(getパターン4(data.get共同処理用受給者異動基本送付TBL().getTeiseiYMD()));
            csvEntity.set基_訂正区分(data.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode());
            csvEntity.set基_訂正区分名称(get訂正区分名称(data.get共同処理用受給者異動基本送付TBL().getTeiseiKubunCode()));
            csvEntity.set基_順序(data.get共同処理用受給者異動基本送付TBL().getChohyoOutputJunjyoCode());
            csvEntity.set基_証記載保険者番号(get証記載保険者番号(data.get共同処理用受給者異動基本送付TBL().getShoKisaiHokenshaNo()));
            csvEntity.set基_被保険者氏名(data.get共同処理用受給者異動基本送付TBL().getHiHokenshaName());
            csvEntity.set基_電話番号(get電話番号(data.get共同処理用受給者異動基本送付TBL().getTelNo()));
            csvEntity.set基_郵便番号(get郵便番号(data.get共同処理用受給者異動基本送付TBL().getYubinNo()));
            csvEntity.set基_住所カナ(data.get共同処理用受給者異動基本送付TBL().getDdressKana());
            csvEntity.set基_住所(data.get共同処理用受給者異動基本送付TBL().getAddress());
        }
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get償_交換情報識別番号())) {
            csvEntity.set償_異動年月日(getパターン4(data.get共同処理一時TBL().get償_異動年月日()));
            csvEntity.set償_異動区分(data.get共同処理一時TBL().get償_異動区分コード());
            csvEntity.set償_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get償_異動区分コード()));
            csvEntity.set償_異動事由(data.get共同処理一時TBL().get償_異動事由());
            csvEntity.set償_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get償_異動事由()));
            csvEntity.set償_訂正年月日(getパターン4(data.get共同処理一時TBL().get償_訂正年月日()));
            csvEntity.set償_訂正区分(data.get共同処理一時TBL().get償_訂正区分コード());
            csvEntity.set償_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get償_訂正区分コード()));
            csvEntity.set償_差止開始日(getパターン4(data.get共同処理一時TBL().get償_保険給付支払の一時差止の開始年月日()));
            csvEntity.set償_差止終了日(getパターン4(data.get共同処理一時TBL().get償_保険給付支払の一時差止の終了年月日()));
            csvEntity.set償_差止区分(data.get共同処理一時TBL().get償_保険給付支払の一時差止区分());
            csvEntity.set償_差止区分名称(get差止区分名称(data.get共同処理一時TBL().get償_保険給付支払の一時差止区分()));
            csvEntity.set償_差止金額(get一時差止金額(data.get共同処理一時TBL().get償_保険給付支払の一時差止金額()));
        }
        if (!RString.isNullOrEmpty(data.get共同処理一時TBL().get高_交換情報識別番号())) {
            csvEntity.set高_異動年月日(getパターン4(data.get共同処理一時TBL().get高_異動年月日()));
            csvEntity.set高_異動区分(data.get共同処理一時TBL().get高_異動区分コード());
            csvEntity.set高_異動区分名称(get異動区分名称(data.get共同処理一時TBL().get高_異動区分コード()));
            csvEntity.set高_異動事由(data.get共同処理一時TBL().get高_異動事由());
            csvEntity.set高_異動事由名称(get異動事由名称(data.get共同処理一時TBL().get高_異動事由()));
            csvEntity.set高_訂正年月日(getパターン4(data.get共同処理一時TBL().get償_訂正年月日()));
            csvEntity.set高_訂正区分(data.get共同処理一時TBL().get高_訂正区分コード());
            csvEntity.set高_訂正区分名称(get訂正区分名称(data.get共同処理一時TBL().get高_訂正区分コード()));
            csvEntity.set高_世帯主被保番号(data.get共同処理一時TBL().get高_世帯主被保険者番号());
            csvEntity.set高_世帯所得区分(data.get共同処理一時TBL().get高_世帯所得区分コード());
            csvEntity.set高_世帯所得区分名称(get世帯所得区分名称(data.get共同処理一時TBL().get高_世帯所得区分コード()));
            csvEntity.set高_所得区分(data.get共同処理一時TBL().get高_所得区分コード());
            csvEntity.set高_所得区分名称(get所得区分名称(data.get共同処理一時TBL().get高_所得区分コード()));
            csvEntity.set高_第２段階(data.get共同処理一時TBL().get高_利用者負担第２段階());
            csvEntity.set高_第２段階名称(get第２段階名称(data.get共同処理一時TBL().get高_利用者負担第２段階()));
            csvEntity.set高_支給申請書(data.get共同処理一時TBL().get高_利用者負担第２段階());
            csvEntity.set高_支給申請書名称(get支給申請書名称(data.get共同処理一時TBL().get高_利用者負担第２段階()));
            csvEntity.set高_年金受給有無(data.get共同処理一時TBL().get高_老齢福祉年金受給の有無());
            csvEntity.set高_年金受給有無名称(get年金受給有無名称(data.get共同処理一時TBL().get高_老齢福祉年金受給の有無()));
        }
        return csvEntity;
    }

    private RString get作成日時() {
        RStringBuilder printTimeStampSb = new RStringBuilder();
        printTimeStampSb.append(作成日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        printTimeStampSb.append(SANKAKU);
        printTimeStampSb.append(String.format("%02d", 作成日時.getHour()));
        printTimeStampSb.append(DATE_時);
        printTimeStampSb.append(String.format("%02d", 作成日時.getMinute()));
        printTimeStampSb.append(DATE_分);
        printTimeStampSb.append(String.format("%02d", 作成日時.getSecond()));
        printTimeStampSb.append(DATE_秒);
        printTimeStampSb.append(SANKAKU);
        printTimeStampSb.append(SAKUSEI);
        return printTimeStampSb.toRString();
    }

    private RString getパターン4(RString 年月日) {
        if (!RString.isNullOrEmpty(年月日)) {
            return new FlexibleDate(年月日).wareki().eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン4(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString get異動区分名称(RString 異動区分コード) {
        if (!RString.isNullOrEmpty(異動区分コード)) {
            return JukyushaIF_IdoKubunCode.toValue(異動区分コード).get名称();
        }
        return RString.EMPTY;
    }

    private RString get異動事由名称(RString 異動事由) {
        if (!RString.isNullOrEmpty(異動事由)) {
            return JukyushaIF_JukyushaIdoJiyu.toValue(異動事由).get名称();
        }
        return RString.EMPTY;
    }

    private RString get訂正区分名称(RString 訂正区分) {
        if (!RString.isNullOrEmpty(訂正区分)) {
            return JukyushaIF_TeiseiKubunCode.toValue(訂正区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get差止区分名称(RString 差止区分) {
        if (!RString.isNullOrEmpty(差止区分)) {
            return JukyushaIF_KyodoShokanIchijiSashitomeKubunCode.toValue(差止区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get世帯所得区分名称(RString 世帯所得区分) {
        if (!RString.isNullOrEmpty(世帯所得区分)) {
            return JukyushaIF_KyodoKogakuSetaiShotokuKubunCode.toValue(世帯所得区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get所得区分名称(RString 所得区分) {
        if (!RString.isNullOrEmpty(所得区分)) {
            return JukyushaIF_KyodoKogakuShotokuKubunCode.toValue(所得区分).get名称();
        }
        return RString.EMPTY;
    }

    private RString get第２段階名称(RString 第２段階) {
        if (!RString.isNullOrEmpty(第２段階)) {
            return JukyushaIF_KyodoKogakuRiyoshafutanDai2dankai.toValue(第２段階).get名称();
        }
        return RString.EMPTY;
    }

    private RString get支給申請書名称(RString 支給申請書) {
        if (!RString.isNullOrEmpty(支給申請書)) {
            return JukyushaIF_KyodoKogakuShikyuShinseishoShutsuryokuUmu.toValue(支給申請書).get名称();
        }
        return RString.EMPTY;
    }

    private RString get年金受給有無名称(RString 年金受給有無) {
        if (!RString.isNullOrEmpty(年金受給有無)) {
            return JukyushaIF_KyodoKogakuRoreifukushinenkinJukyuUmu.toValue(年金受給有無).get名称();
        }
        return RString.EMPTY;
    }

    private RString get一時差止金額(RString 金額) {
        if (RString.isNullOrEmpty(金額)) {
            return RString.EMPTY;
        }
        if (金額.contains(",")) {
            金額 = 金額転換(金額.split(","));
        }
        return DecimalFormatter.toRString(new Decimal(金額.toString()), 0);
    }

    private RString 金額転換(List<RString> 金額) {
        RStringBuilder builder = new RStringBuilder();
        for (RString kinkaku : 金額) {
            builder.append(kinkaku);
        }
        return builder.toRString();
    }

    private RString get証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        if (証記載保険者番号 != null && !証記載保険者番号.isEmpty()) {
            return 証記載保険者番号.value();
        }
        return RString.EMPTY;
    }

    private RString get郵便番号(YubinNo 郵便番号) {
        if (郵便番号 != null && !郵便番号.isEmpty()) {
            return 郵便番号.getEditedYubinNo();
        }
        return RString.EMPTY;
    }

    private RString get電話番号(TelNo 電話番号) {
        if (電話番号 != null && !電話番号.isEmpty()) {
            return 電話番号.value();
        }
        return RString.EMPTY;
    }
}
