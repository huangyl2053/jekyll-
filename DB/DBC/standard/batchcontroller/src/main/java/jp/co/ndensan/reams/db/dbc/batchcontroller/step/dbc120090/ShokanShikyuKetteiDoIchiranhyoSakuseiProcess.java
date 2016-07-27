/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120090;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.shokanbaraishikyukettei.ShokanbaraiShikyuKetteishaIchiranProperty.DBC200021ShutsuryokujunEnum;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shokanshikyukettei.ShokanShikyuKetteiIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT3036ShokanHanteiKekkaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.ShokanShikyuKetteiChohyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.shokanshikyuketteiin.ShokanShikyuKetteiJohoManager;
import jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyuketteishaichiran.ShokanbaraiShikyuKetteishaIchiranPrintService;
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
 * 還払支給決定者一覧表を作成する。
 *
 * @reamsid_L DBC-0980-330 gongliang
 */
public class ShokanShikyuKetteiDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200021");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter eucCsvWriter;

    private static final CodeShubetsu 介護資格喪失事由_被保険者 = new CodeShubetsu("0010");
    private static final RString 出力ファイル名
            = new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran.csv");
    private static final RString 帳票分類ID = new RString("DBC200021_ShokanbaraiShikyuKetteishaIchiran");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY DbWT3036.\"shokisaiHokenshaNo\" ASC ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 漢字_分 = new RString("分");
    private static final RString アスタリスク = new RString("*");
    private static final RString 更新DB有無_有 = new RString("1");

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
        RString 出力順 = MyBatisOrderByClauseCreator.create(DBC200021ShutsuryokujunEnum.class, order);
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
        ShokanShikyuKetteiJohoManager chohyoManager = ShokanShikyuKetteiJohoManager.createInstance();
        List<ShokanShikyuKetteiChohyoEntity> list = chohyoManager.get帳票出力対象データ(mybatisParameter);
        ShokanbaraiShikyuKetteishaIchiranPrintService printService = new ShokanbaraiShikyuKetteishaIchiranPrintService();
        printService.printTaitsu(list, order, parameter.getシステム日付());

        do帳票のCSVファイル作成(list, parameter.get処理年月(), parameter.getシステム日付());

    }

    private void do帳票のCSVファイル作成(List<ShokanShikyuKetteiChohyoEntity> list,
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
            ShokanShikyuKetteiIchiranCSVEntity output = createOutput(list.get(index));
            if (index == 0) {
                output.set処理年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(漢字_分));
                RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                RString 作成時 = 作成日時.getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
                output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
                output.set国保連合会名(list.get(index).get判定結果().get国保連合会名());
            } else {
                output.set処理年月(RString.EMPTY);
                output.set作成日時(RString.EMPTY);
                output.set国保連合会名(RString.EMPTY);
            }
            eucCsvWriter.writeLine(output);
        }

        Set<RString> 識別コードset = new HashSet<>();
        for (ShokanShikyuKetteiChohyoEntity chohyoEntity : list) {
            DbWT0001HihokenshaTempEntity 被保険者 = chohyoEntity.get被保険者();
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

    private ShokanShikyuKetteiIchiranCSVEntity createOutput(ShokanShikyuKetteiChohyoEntity entity) {
        ShokanShikyuKetteiIchiranCSVEntity csvEntity = new ShokanShikyuKetteiIchiranCSVEntity();
        DbWT0001HihokenshaTempEntity 被保険者 = entity.get被保険者();
        DbWT3036ShokanHanteiKekkaTempEntity 判定結果 = entity.get判定結果();
        if (null != 判定結果.get証記載保険者番号()) {
            csvEntity.set証記載保険者番号(判定結果.get証記載保険者番号().getColumnValue());
        }
        csvEntity.set証記載保険者名(判定結果.get証記載保険者名());
        csvEntity.set通知書番号(判定結果.getNo());
        csvEntity.set整理番号(判定結果.get整理番号());
        if (null != 被保険者.get登録被保険者番号()) {
            csvEntity.set被保険者番号(被保険者.get登録被保険者番号().getColumnValue());
        }
        csvEntity.set被保険者氏名(被保険者.get宛名名称());
        csvEntity.set町域コード(被保険者.get町域コード());
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        RString 管内管外区分 = 被保険者.get管内管外区分();
        RString 住所 = 被保険者.get住所();
        RString 番地 = 被保険者.get番地();
        RString 方書 = 被保険者.get方書();
        RString 行政区名 = 被保険者.get行政区名();
        LasdecCode 市町村コード = 被保険者.get市町村コード();
        RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);
        csvEntity.set住所(編集住所);
        csvEntity.set行政区コード(被保険者.get行政区コード());
        csvEntity.set行政区名(被保険者.get行政区名());
        if (null != 判定結果.get事業所番号()) {
            csvEntity.set事業者番号(判定結果.get事業所番号().getColumnValue());
        }
        csvEntity.set事業者名(判定結果.get事業所名());
        csvEntity.setサービス提供年月(trans年月(判定結果.getサービス提供年月()));
        if (null != 判定結果.getサービス種類コード()) {
            csvEntity.setサービス種類コード(判定結果.getサービス種類コード().getColumnValue());
        }
        csvEntity.setサービス種類(判定結果.getサービス種類名());
        csvEntity.set単位数_金額(doカンマ編集(判定結果.get単位数_金額()));
        csvEntity.set増減点(doカンマ編集(判定結果.get増減単位数()));
        csvEntity.set支払金額(doカンマ編集(判定結果.get支払金額()));
        if (!RString.isNullOrEmpty(判定結果.get支払方法区分コード())) {
            ShiharaiHohoKubun 支払方法区分 = ShiharaiHohoKubun.toValue(判定結果.get支払方法区分コード());
            csvEntity.set支払方法区分(判定結果.get支払方法区分コード());
            csvEntity.set支払方法(支払方法区分.get名称());
        }
        if (null != 被保険者.get資格喪失事由コード()) {
            csvEntity.set資格喪失事由コード(被保険者.get資格喪失事由コード());
            csvEntity.set資格喪失事由(CodeMaster.getCodeMeisho(介護資格喪失事由_被保険者,
                    new Code(被保険者.get資格喪失事由コード())));
        }
        if (null != 被保険者.get資格喪失日()) {
            csvEntity.set資格喪失日(被保険者.get資格喪失日().wareki().eraType(EraType.KANJI_RYAKU)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString());
        }
        csvEntity.set備考(判定結果.get備考1());
        if (更新DB有無_有.equals(判定結果.get更新DB有無())) {
            csvEntity.set更新DB無(アスタリスク);
        } else {
            csvEntity.set更新DB無(RString.EMPTY);
        }
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
