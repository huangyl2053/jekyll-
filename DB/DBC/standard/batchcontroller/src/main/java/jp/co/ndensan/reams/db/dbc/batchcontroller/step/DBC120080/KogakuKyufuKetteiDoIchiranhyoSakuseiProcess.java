/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120080;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran.KogakuShikyuFushikyuKetteishaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukyufuketteiin.KogakuKyufuKetteiDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT3058KogakuShikyuShinsaKetteiTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufukettei.KogakuKyufuKetteiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufukettei.KogakuKyufuKetteiChohyoDataEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufukettei.KogakuKyufuKetteiJohoManager;
import jp.co.ndensan.reams.db.dbc.service.report.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額サービス費決定情報取込み・高額サービス費支給（不支給）決定者一覧表を作成する。
 *
 * @reamsid_L DBC-0980-390 lijunjun
 */
public class KogakuKyufuKetteiDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private static final RString 帳票分類ID = new RString("DBC200015_KogakuShikyuFushikyuKetteishaIchiran");
    private KogakuKyufuKetteiDoIchiranhyoSakuseiProcessParameter parameter;
    private static final RString 支給区分コード_可 = new RString("1");
    private static final RString 支給区分_可 = new RString("可");
    private static final RString 支給区分_不可 = new RString("不可");
    private static final RString 支払方法区分コード_窓口 = new RString("1");
    private static final RString 支払方法区分_窓口 = new RString("窓口");
    private static final RString 支払方法区分_口座 = new RString("口座");

    private static final CodeShubetsu 介護資格喪失事由_被保険者 = new CodeShubetsu("0010");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY SHINSAKETTEITEMP.\"shokisaiHokenshaNo\" ASC ");
    private static final RString 漢字_分 = new RString("分");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200015_KogakuShikyuFushikyuKetteishaIchiran.csv");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200015");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter eucCsvWriter;

    @Override
    protected void process() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder order = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == order) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        Map<String, Object> mybatisParameter = new HashMap<>();
        RString 出力順 = MyBatisOrderByClauseCreator.create(
                KogakuShikyuFushikyuKetteishaIchiranProperty.KogakuShikyuFushikyuKetteishaIchiranBreakerFieldsEnum.class, order);
        if (RString.isNullOrEmpty(出力順)) {
            出力順 = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = 出力順.split(コンマ.toString());
            出力順 = デフォルト出力順;
            if (出力順BODY.size() > 1) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    出力順 = 出力順.concat(コンマ).concat(出力順BODY.get(i));
                }
            }
        }
        mybatisParameter.put(キー_出力順.toString(), 出力順);
        KogakuKyufuKetteiJohoManager johoManager = KogakuKyufuKetteiJohoManager.createInstance();
        List<KogakuKyufuKetteiChohyoDataEntity> list = johoManager.get帳票出力対象データ(mybatisParameter);
        KogakuShikyuFushikyuKetteishaIchiranPrintService printService = new KogakuShikyuFushikyuKetteishaIchiranPrintService();
        printService.printTaitsu(list, order, parameter.getシステム日付());

        do帳票のCSVファイル作成(list, parameter.get処理年月(), parameter.getシステム日付());

    }

    private void do帳票のCSVファイル作成(List<KogakuKyufuKetteiChohyoDataEntity> list,
            FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
        for (int index = 0; index < list.size(); index++) {
            KogakuKyufuKetteiIchiranCSVEntity output = createOutput(list.get(index));
            if (index == 0) {
                output.set処理年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(漢字_分));
                RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                RString 作成時 = 作成日時.getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
                output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
                output.set国保連合会名(list.get(index).getKetteiTemp().get国保連合会名());
            } else {
                output.set処理年月(RString.EMPTY);
                output.set作成日時(RString.EMPTY);
                output.set国保連合会名(RString.EMPTY);
            }
            eucCsvWriter.writeLine(output);
        }

        Set<RString> 識別コードset = new HashSet<>();
        for (KogakuKyufuKetteiChohyoDataEntity chohyoEntity : list) {
            DbWT0001HihokenshaTempEntity 被保険者 = chohyoEntity.getHihokenshaTemp();
            if (null == 被保険者.get識別コード() || 被保険者.get識別コード().isEmpty()) {
                continue;
            }
            if (識別コードset.contains(被保険者.get識別コード())) {
                continue;
            }
            識別コードset.add(被保険者.get識別コード());
            PersonalData personalData = getPersonalData(被保険者);
            personalDataList.add(personalData);
        }

        eucCsvWriter.close();

        AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
        manager.spool(eucFilePath, accessLogUUID);
    }

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                entity.get登録被保険者番号().getColumnValue());
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private KogakuKyufuKetteiIchiranCSVEntity createOutput(KogakuKyufuKetteiChohyoDataEntity entity) {
        KogakuKyufuKetteiIchiranCSVEntity csvEntity = new KogakuKyufuKetteiIchiranCSVEntity();
        DbWT0001HihokenshaTempEntity 被保険者 = entity.getHihokenshaTemp();
        DbWT3058KogakuShikyuShinsaKetteiTempEntity 審査決定 = entity.getKetteiTemp();
        csvEntity.set証記載保険者番号(審査決定.get証記載保険者番号().getColumnValue());
        csvEntity.set証記載保険者名(審査決定.get証記載保険者名());
        csvEntity.set通知書番号(審査決定.getNo());
        if (null != 被保険者.get登録被保険者番号()) {
            csvEntity.set被保険者番号(被保険者.get登録被保険者番号().getColumnValue());
        }
        csvEntity.set被保険者氏名カナ(被保険者.get宛名カナ名称());
        csvEntity.set被保険者氏名(被保険者.get宛名名称());
        csvEntity.setサービス提供年月(trans年月(審査決定.getサービス提供年月()));
        csvEntity.set決定年月(trans年月(審査決定.get決定年月()));
        if (支給区分コード_可.equals(審査決定.get支給区分コード())) {
            csvEntity.set支払可否(支給区分_可);
        } else {
            csvEntity.set支払可否(支給区分_不可);
        }
        if (支払方法区分コード_窓口.equals(審査決定.get支払方法区分コード())) {
            csvEntity.set支払方法(支払方法区分_窓口);
        } else {
            csvEntity.set支払方法(支払方法区分_口座);
        }
        csvEntity.set利用者負担額(doカンマ編集(審査決定.get利用者負担額()));
        csvEntity.set決定支給額(doカンマ編集(審査決定.get高額支給額()));
        if (null != 被保険者.get資格喪失事由コード()) {
            csvEntity.set資格喪失事由(CodeMaster.getCodeMeisho(介護資格喪失事由_被保険者,
                    new Code(被保険者.get資格喪失事由コード())));
        }
        if (null != 被保険者.get資格喪失日()) {
            csvEntity.set資格喪失日(被保険者.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        csvEntity.set町域コード(被保険者.get町域コード());
        csvEntity.set行政区コード(被保険者.get行政区コード());
        csvEntity.set行政区名(被保険者.get行政区名());
        csvEntity.set郵便番号(被保険者.get郵便番号());
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        RString 管内管外区分 = 被保険者.get管内管外区分();
        RString 住所 = 被保険者.get住所();
        RString 番地 = 被保険者.get番地();
        RString 方書 = 被保険者.get方書();
        RString 行政区名 = 被保険者.get行政区名();
        LasdecCode 市町村コード = 被保険者.get市町村コード();
        RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);
        csvEntity.set住所(編集住所);
        csvEntity.set備考(RString.EMPTY);
        return csvEntity;
    }

    private RString trans年月(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
