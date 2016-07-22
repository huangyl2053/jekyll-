/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120070;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranProperty;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.DbWT3054KogakuKyufuTaishoshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kogakukyufutaishosha.KogakuKyufuTaishoshaIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukyufutaishosha.KyuufuTaishoshaHihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishosha.KogakuKyufuTaishoshaInManager;
import jp.co.ndensan.reams.db.dbc.service.report.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranPrintService;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 高額介護サービス費給付対象者取込のCSVファイル読取
 *
 * @reamsid_L DBC-0980-360 chenaoqi
 */
public class KogakuKyufuTaishoshaInDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200014");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter eucCsvWriter;

    private static final RString 出力ファイル名
            = new RString("DBC200014_KogakuKyufuTaishoshaIchiran.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY 対象者TBL.\"renban\",対象者TBL.\"shokisaiHokenshaNo\","
            + "DbWT0001.\"hihokenshaNo\" ASC, 対象者TBL.\"serviceTeikyoYm\" ASC,  対象者TBL.\"recordShubetsu\" ASC");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 漢字_分 = new RString("分");
    private final RString 帳票レコード種別_T1 = new RString("T1");

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
        RString 出力順 = MyBatisOrderByClauseCreator.create(KogakuKyufuTaishoshaIchiranProperty//
                .DBC200014ShutsuryokujunEnum.class, order);
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
        KogakuKyufuTaishoshaInManager chohyoManager = KogakuKyufuTaishoshaInManager.createInstance();
        List<KyuufuTaishoshaHihokenshaEntity> list = chohyoManager.get帳票出力対象データ(mybatisParameter);

        KogakuKyufuTaishoshaIchiranPrintService printService
                = new KogakuKyufuTaishoshaIchiranPrintService();
        printService.printTaitsu(list, order, parameter.get処理年月(), parameter.getシステム日付());
        do帳票のCSVファイル作成(list, parameter.get処理年月(), parameter.getシステム日付());

    }

    private void do帳票のCSVファイル作成(List<KyuufuTaishoshaHihokenshaEntity> list,
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

        Set<ShikibetsuCode> 識別コードset = new HashSet<>();
        for (int index = 0; index < list.size(); index++) {
            boolean 集計Flag = false;
            if (帳票レコード種別_T1.equals(list.get(index).get対象者().get帳票レコード種別())) {
                集計Flag = true;
            }
            KogakuKyufuTaishoshaIchiranCsvEntity output = new KogakuKyufuTaishoshaIchiranCsvEntity();
            KyuufuTaishoshaHihokenshaEntity 出力対象 = list.get(index);
            DbWT3054KogakuKyufuTaishoshaTempEntity 対象者 = 出力対象.get対象者();
            DbWT0001HihokenshaTempEntity 被保険者 = 出力対象.get被保険者一時();
            if (index == 0) {
                output.set処理年月(処理年月.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.GAN_NEN)
                        .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString().concat(漢字_分));
                RString 作成日 = 作成日時.getDate().wareki().eraType(EraType.KANJI)
                        .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                        .fillType(FillType.BLANK).toDateString();
                RString 作成時 = 作成日時.getTime()
                        .toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒).concat(RString.HALF_SPACE);
                output.set作成日時(作成日.concat(RString.HALF_SPACE).concat(作成時));
            } else {
                output.set処理年月(RString.EMPTY);
                output.set作成日時(RString.EMPTY);
            }
            output.set証記載保険者番号(getColumnValue(対象者.get証記載保険者番号()));
            output.set証記載保険者名(対象者.get証記載保険者名());
            output.set通知書番号(対象者.getNo());
            output.set被保険者番号(getColumnValue(被保険者.get登録被保険者番号()));
            output.set被保険者氏名(被保険者.get宛名名称());
            output.setサービス提供年月(doパターン54(対象者.getサービス提供年月()));

            if (集計Flag) {
                output.setサービス費用合計額合計(doカンマ編集(対象者.getサービス費用合計額合計()));
                output.set利用者負担額合計(doカンマ編集(対象者.get利用者負担額合計()));
                output.set算定基準額(doカンマ編集(対象者.get算定基準額()));
                output.set支払済金額合計(doカンマ編集(対象者.get支払済金額合計()));
                output.set高額支給額(doカンマ編集(対象者.get高額支給額()));
            } else {
                output.set事業者番号(getColumnValue(対象者.get事業所番号()));
                output.set事業者名(対象者.get事業所名());
                output.setサービス種類コード(getColumnValue(対象者.getサービス種類コード()));
                output.setサービス種類名(対象者.getサービス種類名());
                output.setサービス費用合計額(doカンマ編集(対象者.getサービス費用合計額()));
                output.set利用者負担額(doカンマ編集(対象者.get利用者負担額()));
                output.set資格喪失日(doパターン4(被保険者.get資格喪失日()));
                output.set備考(対象者.get備考());
            }
            eucCsvWriter.writeLine(output);
            if (null == 被保険者.get識別コード() || 被保険者.get識別コード().isEmpty()) {
                continue;
            }
            ShikibetsuCode 識別コード = new ShikibetsuCode(被保険者.get識別コード());
            if (識別コードset.contains(識別コード)) {
                continue;
            }
            識別コードset.add(識別コード);
            PersonalData personalData = getPersonalData(被保険者);
            personalDataList.add(personalData);
        }
        eucCsvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(entity.get識別コード()), expandedInformations);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString doパターン4(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI_RYAKU).firstYear(FirstYear.ICHI_NEN).separator(Separator.PERIOD)
                .fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
