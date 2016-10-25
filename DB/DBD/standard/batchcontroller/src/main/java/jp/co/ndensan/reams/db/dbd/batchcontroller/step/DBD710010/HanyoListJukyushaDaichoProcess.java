/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.dbd710010.HanyoListJukyushaDaichoBusiness;
import jp.co.ndensan.reams.db.dbd.business.report.HanyoListJukyusha;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.ChushutsuHohoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.hanyolist.jukyusha2.SoshitsuKubun;
import jp.co.ndensan.reams.db.dbd.definition.processprm.hanyorisutojyukyusya.HanyoRisutoJyukyusyaProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaCsv2Entity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaCsvEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyorisutojyukyusya.HanyoRisutoJyukyusyaEntity;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaList;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.hokenshalist.HokenshaListLoader;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.Chiku;
import jp.co.ndensan.reams.db.dbz.definition.batchprm.hanyolist.atena.NenreiSoChushutsuHoho;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt250FindAtesakiFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtenaSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.UaFt200FindShikibetsuTaishoParam;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder._SetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.PageBreakType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportoutputorder.SortOrder;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.NewpageType;
import jp.co.ndensan.reams.ur.urz.definition.core.reportyamawake.YamawakeType;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 汎用リスト受給者台帳_processクラスです。
 *
 * @reamsid_L DBD-1800-020 x_youyj
 */
public class HanyoListJukyushaDaichoProcess extends BatchProcessBase<HanyoRisutoJyukyusyaEntity> {

    HanyoRisutoJyukyusyaProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBD701001");
    private Association 地方公共団体;
    private HokenshaList 保険者リスト;
    private List<PersonalData> personalDataList;
    private FileSpoolManager manager;
    private CsvWriter<HanyoRisutoJyukyusyaCsvEntity> csvWriter;
    private CsvWriter<HanyoRisutoJyukyusyaCsv2Entity> csv2Writer;
    private RString 出力順;
    private final ReportId reportId = new ReportId("DBD701001_HanyoListJukyushaDaicho");
    private static final RString HIHOKENSHANO = new RString("被保険者台帳管理_被保険者番号");
    private static final RString SHICHOSONCODE = new RString("被保険者台帳管理_市町村コード");
    private RString eucFilePath;
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private RString ファイル名;
    private static final RString 抽出対象者 = new RString("【抽出対象者】");
    private static final RString 対象データ最新 = new RString("対象データ：直近（有効データ内で最新）");
    private static final RString 対象データ直近 = new RString("対象データ：直近");
    private static final RString 基準日 = new RString("基準日：");
    private static final RString 認定日 = new RString("認定日：");
    private static final RString 喪失区分 = new RString("喪失区分：");
    private static final RString 旧措置者 = new RString("旧措置者：旧措置者のみ");
    private static final RString 被保険者情報 = new RString("被保険者情報：");
    private static final RString 年齢 = new RString("年齢：");
    private static final RString 歳 = new RString("歳");
    private static final RString 指定サービス = new RString("指定サービス：サービス指定者のみ");
    private static final RString 要介護１ = new RString("要介護１");
    private static final RString 要介護２ = new RString("要介護２");
    private static final RString 要介護３ = new RString("要介護３");
    private static final RString 要介護４ = new RString("要介護４");
    private static final RString 要介護５ = new RString("要介護５");
    private static final RString 要支援１ = new RString("要支援１");
    private static final RString 要支援２ = new RString("要支援２");
    private static final RString 経過的要介護要支援 = new RString("経過的要介護(要支援)");
    private static final RString 自立 = new RString("自立");
    private static final RString 申請取消 = new RString("申請取消");
    private static final RString 却下職権取消他 = new RString("却下・職権取消・他");
    private static final RString DELIMITER = new RString("、");
    private static final RString 一号と二号 = new RString("１号・２号");
    private static final RString 一号 = new RString("１号");
    private static final RString 二号 = new RString("２号");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.hanyorisutojyukyusya."
            + "IHanyoRisutoJyukyusyaMapper.get汎用リスト");
    private HanyoListJukyushaDaichoBusiness hanyoBusiness;

    private static final RString 波線 = new RString(" ～ ");

    @Override
    protected void initialize() {
        地方公共団体 = AssociationFinderFactory.createInstance().getAssociation();
        保険者リスト = HokenshaListLoader.createInstance().getShichosonCodeNameList(GyomuBunrui.介護事務);
        personalDataList = new ArrayList<>();
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        出力順 = get出力順();
        ファイル名 = new RString("HanyoList_JukyushaDaicho.csv");
        hanyoBusiness = new HanyoListJukyushaDaichoBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder shikibetsuTaishoPSMKey
                = new ShikibetsuTaishoPSMSearchKeyBuilder(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        shikibetsuTaishoPSMKey.setデータ取得区分(DataShutokuKubun.直近レコード);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = shikibetsuTaishoPSMKey.build();
        UaFt200FindShikibetsuTaishoParam shikibetsutaishoParam = new UaFt200FindShikibetsuTaishoParam(shikibetsuTaishoPSMSearchKey);
        AtenaSearchKeyBuilder atenaSearchKeyBuilder = new AtenaSearchKeyBuilder(
                KensakuYusenKubun.未定義, AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBA介護資格));
        UaFt250FindAtesakiFunction uaFt250Psm = new UaFt250FindAtesakiFunction(atenaSearchKeyBuilder.build().get宛先検索キー());
        RString psmAtesaki = new RString(uaFt250Psm.getParameterMap().get("psmAtesaki").toString());
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toHanyoRisutoJyukyusyaMybatisParameter(shikibetsutaishoParam, psmAtesaki, 出力順));
    }

    @Override
    protected void createWriter() {

        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), ファイル名);
        if (parameter.is連番付加()) {
            csvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(parameter.is項目名付加()).
                    build();
        } else {
            csv2Writer = new CsvWriter.InstanceBuilder(eucFilePath).
                    setDelimiter(EUC_WRITER_DELIMITER).
                    setEncode(Encode.UTF_8withBOM).
                    setNewLine(NewLine.CRLF).
                    hasHeader(parameter.is項目名付加()).
                    build();
        }
    }

    @Override
    protected void process(HanyoRisutoJyukyusyaEntity entity) {
        if (parameter.is連番付加()) {
            csvWriter.writeLine(hanyoBusiness.set連番あり(
                    parameter.is日付スラッシュ付加(), entity, 地方公共団体, 保険者リスト));
            personalDataList.add(toPersonalData(entity));
        } else {
            csv2Writer.writeLine(hanyoBusiness.set連番なし(
                    parameter.is日付スラッシュ付加(), entity, 地方公共団体, 保険者リスト));
            personalDataList.add(toPersonalData(entity));
        }
    }

    @Override
    protected void afterExecute() {
        if (parameter.is連番付加()) {
            csvWriter.close();
        } else {
            csv2Writer.close();
        }
        バッチ出力条件リストの出力();
        AccessLogUUID log = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, log);
    }

    private PersonalData toPersonalData(HanyoRisutoJyukyusyaEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.get受給者台帳_被保険者番号());
        return PersonalData.of(entity.getPsmEntity() == null ? ShikibetsuCode.EMPTY : entity.getPsmEntity().getShikibetsuCode(), expandedInfo);
    }

    private RString get出力順() {
        List<RString> 出力DB項目名 = new ArrayList();
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(SubGyomuCode.DBD介護受給, reportId,
                parameter.get出力順Id());
        List<ISetSortItem> 設定項目リスト = order.get設定項目リスト();
        for (ISetSortItem item : 設定項目リスト) {
            出力DB項目名.add(item.getDB項目名());
        }
        if (!出力DB項目名.contains(SHICHOSONCODE)) {
            order.get設定項目リスト().add(new _SetSortItem(GyomuCode.DB介護保険, new RString("0016"), SHICHOSONCODE, NewpageType.選択不可,
                    0, YamawakeType.設定不可, SubGyomuCode.DBD介護受給, CodeShubetsu.EMPTY, 0, SortOrder.ASCENDING,
                    true, true, PageBreakType.設定なし, 0, 0));
        }
        if (!出力DB項目名.contains(HIHOKENSHANO)) {
            order.get設定項目リスト().add(new _SetSortItem(GyomuCode.DB介護保険, new RString("0104"), HIHOKENSHANO, NewpageType.選択不可,
                    0, YamawakeType.設定不可, SubGyomuCode.DBD介護受給, CodeShubetsu.EMPTY, 0, SortOrder.ASCENDING,
                    true, true, PageBreakType.設定なし, 0, 0));
        }
        return MyBatisOrderByClauseCreator.create(HanyoListJukyusha.class, order);
    }

    private void バッチ出力条件リストの出力() {
        RString 導入団体コード = 地方公共団体.getLasdecCode_().getColumnValue();
        RString 市町村名 = 地方公共団体.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString 日本語ファイル名 = new RString("汎用リスト　受給者台帳CSV");
        RString 英数字ファイル名 = ファイル名;
        RString 出力ページ数;
        if ((csvWriter == null || csvWriter.getCount() == 0) && (csv2Writer == null || csv2Writer.getCount() == 0)) {
            出力ページ数 = new RString("0");
        } else if ((csvWriter == null || csvWriter.getCount() == 0) && (csv2Writer != null && csv2Writer.getCount() != 0)) {
            出力ページ数 = new RString(String.valueOf(csv2Writer.getCount()));
        } else {
            出力ページ数 = new RString(String.valueOf(csvWriter.getCount()));
        }
        RString csv出力有無 = new RString("あり");
        List<RString> 出力条件 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(抽出対象者);
        if (ChushutsuHohoKubun.直近.equals(parameter.get抽出方法区分())) {
            if (parameter.is有効データ内最新()) {
                builder.append(対象データ最新);
            } else {
                builder.append(対象データ直近);
            }
        }

        if (parameter.getKijunYMD() != null && !parameter.getKijunYMD().isEmpty()) {
            builder.append(基準日.concat(parameter.getKijunYMD().wareki()
                    .eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO)
                    .toDateString()));
        }
        if (parameter.is一号被保険者() && parameter.is二号被保険者()) {
            builder.append(被保険者情報.concat(一号と二号));
        } else if (parameter.is一号被保険者() && !parameter.is二号被保険者()) {
            builder.append(被保険者情報.concat(一号));
        } else if (!parameter.is一号被保険者() && parameter.is二号被保険者()) {
            builder.append(被保険者情報.concat(二号));
        }
        if (parameter.isサービス指定者()) {
            builder.append(指定サービス);
        }
        builder = set出力条件1(builder);
        builder = set出力条件2(builder);
        builder = set出力条件3(builder);
        builder = set出力条件4(builder);
        builder = set出力条件5(builder);
        builder = set出力条件6(builder);
        出力条件.add(builder.toRString());
        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                導入団体コード,
                市町村名,
                ジョブ番号,
                日本語ファイル名,
                英数字ファイル名,
                出力ページ数,
                csv出力有無,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    private RStringBuilder set出力条件1(RStringBuilder builder) {
        RString 日付範囲From = new RString("");
        RString 日付範囲To = new RString("");
        if (parameter.getStartYMD() != null && !parameter.getStartYMD().isEmpty()
                && parameter.getEndYMD() != null && !parameter.getEndYMD().isEmpty()) {
            日付範囲From = parameter.getStartYMD()
                    .wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO)
                    .toDateString();
            日付範囲To = parameter.getEndYMD()
                    .wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO)
                    .toDateString();
            builder.append(認定日.concat(日付範囲From).concat(波線).concat(日付範囲To));
        } else if (parameter.getStartYMD() != null && !parameter.getStartYMD().isEmpty()
                && (parameter.getEndYMD() == null || parameter.getEndYMD().isEmpty())) {
            日付範囲From = parameter.getStartYMD()
                    .wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO)
                    .toDateString();
            builder.append(認定日.concat(日付範囲From).concat(波線).concat(日付範囲To));
        } else if ((parameter.getStartYMD() == null || parameter.getStartYMD().isEmpty())
                && parameter.getEndYMD() != null && !parameter.getEndYMD().isEmpty()) {
            日付範囲To = parameter.getEndYMD()
                    .wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE)
                    .fillType(FillType.ZERO)
                    .toDateString();
            builder.append(認定日.concat(日付範囲From).concat(波線).concat(日付範囲To));
        }
        if (parameter.is旧措置者()) {
            builder.append(旧措置者);
        }
        return builder;
    }

    private RStringBuilder set出力条件2(RStringBuilder builder) {
        int count = 0;
        RString 調査結果 = new RString("調査結果：");
        if (parameter.is認定結果_0()) {
            調査結果 = 調査結果.concat(要介護１).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_1()) {
            調査結果 = 調査結果.concat(要介護２).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_2()) {
            調査結果 = 調査結果.concat(要介護３).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_3()) {
            調査結果 = 調査結果.concat(要介護４).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_4()) {
            調査結果 = 調査結果.concat(要介護５).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_5()) {
            調査結果 = 調査結果.concat(要支援１).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_6()) {
            調査結果 = 調査結果.concat(要支援２).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_7()) {
            調査結果 = 調査結果.concat(経過的要介護要支援).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_8()) {
            調査結果 = 調査結果.concat(自立).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_9()) {
            調査結果 = 調査結果.concat(申請取消).concat(DELIMITER);
            count++;
        }
        if (parameter.is認定結果_10()) {
            調査結果 = 調査結果.concat(却下職権取消他).concat(DELIMITER);
            count++;
        }
        if (count != 0) {
            調査結果 = 調査結果.substring(0, 調査結果.length() - 1);
        }
        builder.append(調査結果);
        if (parameter.get喪失区分() != null && !SoshitsuKubun.資格判定なし.equals(parameter.get喪失区分())) {
            builder.append(喪失区分.concat(SoshitsuKubun.資格取得者のみ.get名称()));
        }

        return builder;
    }

    private RStringBuilder set出力条件3(RStringBuilder builder) {
        RString 年齢基準日 = new RString("　　（年齢基準日：");
        if (NenreiSoChushutsuHoho.年齢範囲.equals(parameter.get宛名抽出条件().getAgeSelectKijun())) {
            if (parameter.get宛名抽出条件().getNenreiRange().getFrom() != null && parameter.get宛名抽出条件().getNenreiRange().getTo() != null) {
                builder.append(年齢.concat(new RString(parameter.get宛名抽出条件().getNenreiRange().getFrom().intValue()))
                        .concat(歳).concat(波線).concat(歳).concat(new RString(parameter.get宛名抽出条件().getNenreiRange().getTo().intValue()))
                        .concat(年齢基準日).concat(parameter.get宛名抽出条件().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                                .firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE)
                                .fillType(FillType.ZERO)
                                .toDateString()));
            }
            if (parameter.get宛名抽出条件().getNenreiRange().getFrom() != null && parameter.get宛名抽出条件().getNenreiRange().getTo() == null) {
                builder.append(年齢.concat(new RString(parameter.get宛名抽出条件().getNenreiRange().getFrom().intValue()))
                        .concat(歳).concat(波線)
                        .concat(年齢基準日).concat(parameter.get宛名抽出条件().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                                .firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE)
                                .fillType(FillType.ZERO)
                                .toDateString()));
            }
            if (parameter.get宛名抽出条件().getNenreiRange().getFrom() == null && parameter.get宛名抽出条件().getNenreiRange().getTo() != null) {
                builder.append(年齢.concat(波線).concat(歳).concat(new RString(parameter.get宛名抽出条件().getNenreiRange().getTo().intValue()))
                        .concat(年齢基準日).concat(parameter.get宛名抽出条件().getNenreiKijunbi().wareki().eraType(EraType.KANJI)
                                .firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE)
                                .fillType(FillType.ZERO)
                                .toDateString()));
            }
        }
        return builder;
    }

    private RStringBuilder set出力条件4(RStringBuilder builder) {
        RString 生年月日 = new RString("生年月日：");
        if (NenreiSoChushutsuHoho.生年月日範囲.equals(parameter.get宛名抽出条件().getAgeSelectKijun())) {
            if (parameter.get宛名抽出条件().getSeinengappiRange().getFrom() != null
                    && parameter.get宛名抽出条件().getSeinengappiRange().getTo() != null) {
                builder.append(生年月日.concat(parameter.get宛名抽出条件().getSeinengappiRange().getFrom().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO)
                        .toDateString()).concat(波線).concat(parameter.get宛名抽出条件().getSeinengappiRange().getTo().wareki()
                                .eraType(EraType.KANJI)
                                .firstYear(FirstYear.GAN_NEN)
                                .separator(Separator.JAPANESE)
                                .fillType(FillType.ZERO)
                                .toDateString()));
            }
            if (parameter.get宛名抽出条件().getSeinengappiRange().getFrom() != null
                    && parameter.get宛名抽出条件().getSeinengappiRange().getTo() == null) {
                builder.append(生年月日.concat(parameter.get宛名抽出条件().getSeinengappiRange().getFrom().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO)
                        .toDateString()).concat(波線));
            }
            if (parameter.get宛名抽出条件().getSeinengappiRange().getFrom() != null
                    && parameter.get宛名抽出条件().getSeinengappiRange().getTo() != null) {
                builder.append(生年月日.concat(波線).concat(parameter.get宛名抽出条件().getSeinengappiRange().getTo().wareki()
                        .eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE)
                        .fillType(FillType.ZERO)
                        .toDateString()));
            }
        }
        return builder;
    }

    private RStringBuilder set出力条件5(RStringBuilder builder) {
        if (Chiku.行政区.equals(parameter.get宛名抽出条件().getChiku_Kubun())) {
            if (parameter.get宛名抽出条件().getGyoseiku_From() != null && parameter.get宛名抽出条件().getGyoseiku_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_FromMesho()).concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_ToMesho()));
            }
            if (parameter.get宛名抽出条件().getGyoseiku_From() != null && parameter.get宛名抽出条件().getGyoseiku_To() == null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_FromMesho()).concat(波線));
            }
            if (parameter.get宛名抽出条件().getGyoseiku_From() == null && parameter.get宛名抽出条件().getGyoseiku_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getGyoseiku_ToMesho()));
            }
        }
        if (Chiku.住所.equals(parameter.get宛名抽出条件().getChiku_Kubun())) {
            if (parameter.get宛名抽出条件().getJusho_From() != null && parameter.get宛名抽出条件().getJusho_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getJusho_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getJusho_FromMesho()).concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getJusho_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getJusho_ToMesho()));
            }
            if (parameter.get宛名抽出条件().getJusho_From() != null && parameter.get宛名抽出条件().getJusho_To() == null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getJusho_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getJusho_FromMesho()).concat(波線));
            }
            if (parameter.get宛名抽出条件().getJusho_From() == null && parameter.get宛名抽出条件().getJusho_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getJusho_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getJusho_ToMesho()));
            }
        }
        return builder;
    }

    private RStringBuilder set出力条件6(RStringBuilder builder) {
        if (Chiku.地区.equals(parameter.get宛名抽出条件().getChiku_Kubun())) {
            if (parameter.get宛名抽出条件().getChiku1_From() != null && parameter.get宛名抽出条件().getChiku1_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getChiku1_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku1_FromMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku1_FromMesho()).concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getChiku1_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku1_ToMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku1_ToMesho()));
            } else if (parameter.get宛名抽出条件().getChiku1_From() != null && parameter.get宛名抽出条件().getChiku1_To() == null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getChiku1_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku1_FromMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku1_FromMesho()).concat(波線));
            } else if (parameter.get宛名抽出条件().getChiku1_From() == null && parameter.get宛名抽出条件().getChiku1_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getChiku1_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku1_ToMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku1_ToMesho()));
            }
            if (parameter.get宛名抽出条件().getChiku2_From() != null && parameter.get宛名抽出条件().getChiku2_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getChiku2_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku2_FromMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku2_FromMesho()).concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getChiku2_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku2_ToMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku2_ToMesho()));
            } else if (parameter.get宛名抽出条件().getChiku2_From() != null && parameter.get宛名抽出条件().getChiku2_To() == null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                        .concat(parameter.get宛名抽出条件().getChiku2_From()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku2_FromMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku2_FromMesho()).concat(波線));
            } else if (parameter.get宛名抽出条件().getChiku2_From() == null && parameter.get宛名抽出条件().getChiku2_To() != null) {
                builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(波線).concat(new RString(" ("))
                        .concat(parameter.get宛名抽出条件().getChiku2_To()).concat(new RString(") "))
                        .concat(parameter.get宛名抽出条件().getChiku2_ToMesho() == null ? RString.EMPTY
                                : parameter.get宛名抽出条件().getChiku2_ToMesho()));
            }
            builder = set出力条件7(builder);
        }
        return builder;
    }

    private RStringBuilder set出力条件7(RStringBuilder builder) {
        if (parameter.get宛名抽出条件().getChiku3_From() != null && parameter.get宛名抽出条件().getChiku3_To() != null) {
            builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                    .concat(parameter.get宛名抽出条件().getChiku3_From()).concat(new RString(") "))
                    .concat(parameter.get宛名抽出条件().getChiku3_FromMesho() == null ? RString.EMPTY
                            : parameter.get宛名抽出条件().getChiku3_FromMesho()).concat(波線).concat(new RString(" ("))
                    .concat(parameter.get宛名抽出条件().getChiku3_To()).concat(new RString(") "))
                    .concat(parameter.get宛名抽出条件().getChiku3_ToMesho() == null ? RString.EMPTY
                            : parameter.get宛名抽出条件().getChiku3_ToMesho()));
        } else if (parameter.get宛名抽出条件().getChiku3_From() != null && parameter.get宛名抽出条件().getChiku3_To() == null) {
            builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(new RString("： ("))
                    .concat(parameter.get宛名抽出条件().getChiku3_From()).concat(new RString(") "))
                    .concat(parameter.get宛名抽出条件().getChiku3_FromMesho() == null ? RString.EMPTY
                            : parameter.get宛名抽出条件().getChiku3_FromMesho()).concat(波線));
        } else if (parameter.get宛名抽出条件().getChiku3_From() == null && parameter.get宛名抽出条件().getChiku3_To() != null) {
            builder.append(parameter.get宛名抽出条件().getChiku_Kubun().get名称().concat(波線).concat(new RString(" ("))
                    .concat(parameter.get宛名抽出条件().getChiku3_To()).concat(new RString(") "))
                    .concat(parameter.get宛名抽出条件().getChiku3_ToMesho() == null ? RString.EMPTY
                            : parameter.get宛名抽出条件().getChiku3_ToMesho()));
        }
        return builder;
    }
}
