/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120170;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInProperty.KagoKetteiKohifutanshaInBreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteikohifutanshain.KohifutanshaIchiranCSVEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kagoketteikohifutanshain.KagoKetteiKohifutanshaChohyoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kagoketteihokenshainkouhifutann.KagoKetteiKohifutanshaChohyoManager;
import jp.co.ndensan.reams.db.dbc.service.report.kagoketteikohifutanshain.KagoKetteiKohifutanshaInPrintService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 一覧表作成。
 *
 * @reamsid_L DBC-0980-420 zhangrui
 */
public class KohifutanshaDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200051");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter eucCsvWriter;

    private static final RString 出力ファイル名
            = new RString("DBC200051_KagoKetteitsuchishoTorikomiIchiranKohifutanshaBun.csv");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY DbWT3060.\"hdrShoHokenshaNo\" ASC ");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 漢字_分 = new RString("分");

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
        RString 出力順 = MyBatisOrderByClauseCreator.create(KagoKetteiKohifutanshaInBreakerFieldsEnum.class, order);
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
        KagoKetteiKohifutanshaChohyoManager chohyoManager = KagoKetteiKohifutanshaChohyoManager.createInstance();
        List<KagoKetteiKohifutanshaChohyoEntity> list = chohyoManager.get帳票出力対象データ(mybatisParameter);
        KagoKetteiKohifutanshaInPrintService printService = new KagoKetteiKohifutanshaInPrintService();
        printService.printTaitsu(list, order, parameter.get処理年月(), parameter.getシステム日付());

        do帳票のCSVファイル作成(list, parameter.get処理年月(), parameter.getシステム日付());

    }

    private void do帳票のCSVファイル作成(List<KagoKetteiKohifutanshaChohyoEntity> list,
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
            boolean 集計Flag = false;
            if (list.size() <= (index + 1)) {
                集計Flag = true;
            } else {
                ShoKisaiHokenshaNo 公費負担者番号 = list.get(index).get公費負担者番号();
                ShoKisaiHokenshaNo 公費負担者番号Next = list.get(index + 1).get公費負担者番号();
                if (!公費負担者番号.equals(公費負担者番号Next)) {
                    集計Flag = true;
                }
            }
            KohifutanshaIchiranCSVEntity output = createOutput(list.get(index));
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
            if (集計Flag) {
                KohifutanshaIchiranCSVEntity totalRecord = new KohifutanshaIchiranCSVEntity();
                totalRecord.set公費負担者番号(output.get公費負担者番号());
                totalRecord.set公費負担者名(output.get公費負担者名());
                totalRecord.set介護給付費_件数(output.get介護給付費_件数());
                totalRecord.set介護給付費_単位数(output.get介護給付費_単位数());
                totalRecord.set介護給付費_負担額(output.get介護給付費_負担額());
                totalRecord.set高額介護サービス費_件数(output.get高額介護サービス費_件数());
                totalRecord.set高額介護サービス費_単位数(output.get高額介護サービス費_単位数());
                totalRecord.set高額介護サービス費_負担額(output.get高額介護サービス費_負担額());
                totalRecord.set特定入所者介護サービス費等_件数(output.get特定入所者介護サービス費等_件数());
                totalRecord.set特定入所者介護サービス費等_単位数(output.get特定入所者介護サービス費等_単位数());
                totalRecord.set特定入所者介護サービス費等_負担額(output.get特定入所者介護サービス費等_負担額());
                clear集計(output);
                eucCsvWriter.writeLine(output);
                eucCsvWriter.writeLine(totalRecord);
            } else {
                clear集計(output);
                eucCsvWriter.writeLine(output);
            }
        }

        Set<ShikibetsuCode> 識別コードset = new HashSet<>();
        for (KagoKetteiKohifutanshaChohyoEntity chohyoEntity : list) {
            if (null == chohyoEntity.get識別コード() || chohyoEntity.get識別コード().isEmpty()) {
                continue;
            }
            if (識別コードset.contains(chohyoEntity.get識別コード())) {
                continue;
            }
            識別コードset.add(chohyoEntity.get識別コード());
            PersonalData personalData = getPersonalData(chohyoEntity);
            personalDataList.add(personalData);
        }

        eucCsvWriter.close();

        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.EucOther, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private void clear集計(KohifutanshaIchiranCSVEntity output) {
        output.set介護給付費_件数(RString.EMPTY);
        output.set介護給付費_単位数(RString.EMPTY);
        output.set介護給付費_負担額(RString.EMPTY);
        output.set高額介護サービス費_件数(RString.EMPTY);
        output.set高額介護サービス費_単位数(RString.EMPTY);
        output.set高額介護サービス費_負担額(RString.EMPTY);
        output.set特定入所者介護サービス費等_件数(RString.EMPTY);
        output.set特定入所者介護サービス費等_単位数(RString.EMPTY);
        output.set特定入所者介護サービス費等_負担額(RString.EMPTY);
    }

    private PersonalData getPersonalData(KagoKetteiKohifutanshaChohyoEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private KohifutanshaIchiranCSVEntity createOutput(KagoKetteiKohifutanshaChohyoEntity entity) {
        KohifutanshaIchiranCSVEntity csvEntity = new KohifutanshaIchiranCSVEntity();
        if (null != entity.get公費負担者番号()) {
            csvEntity.set公費負担者番号(entity.get公費負担者番号().getColumnValue());
        }
        csvEntity.set公費負担者名(entity.get公費負担者名());
        if (null != entity.get取扱年月()) {
            csvEntity.set取扱年月(entity.get取扱年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.get事業者番号()) {
            csvEntity.set事業者番号(entity.get事業者番号().getColumnValue());
        }
        csvEntity.set事業者名(entity.get事業者名());
        csvEntity.set公費受給者番号(entity.get公費受給者番号());
        csvEntity.set公費受給者名(entity.get公費受給者名());
        csvEntity.set証記載保険者番号(entity.get公費証記載保険者番号());
        if (null != entity.get被保険者番号()) {
            csvEntity.set被保険者番号(entity.get被保険者番号().getColumnValue());
        }
        if (null != entity.getサービ提供年月()) {
            csvEntity.setサービス提供年月(entity.getサービ提供年月().wareki().separator(Separator.PERIOD)
                    .fillType(FillType.BLANK).toDateString());
        }
        if (null != entity.getサービス種類コード()) {
            csvEntity.setサービス種類コード(entity.getサービス種類コード().getColumnValue());
        }
        csvEntity.setサービス種類名(entity.getサービス種類名());
        if (null != entity.get過誤申立事由コード()) {
            csvEntity.set過誤申立事由コード(entity.get過誤申立事由コード().getColumnValue());
        }
        csvEntity.set過誤申立事由(entity.get過誤申立事由());
        csvEntity.set単位数(doカンマ編集(entity.get単位数()));
        csvEntity.set負担額(doカンマ編集(entity.get公費負担額()));
        csvEntity.set介護給付費_件数(doカンマ編集(new Decimal(entity.get介護給付費の件数())));
        csvEntity.set介護給付費_単位数(doカンマ編集(entity.get介護給付費の単位数()));
        csvEntity.set介護給付費_負担額(doカンマ編集(entity.get介護給付費の負担額()));
        csvEntity.set高額介護サービス費_件数(doカンマ編集(new Decimal(entity.get高額介護サービス費の件数())));
        csvEntity.set高額介護サービス費_単位数(doカンマ編集(entity.get高額介護サービス費の単位数()));
        csvEntity.set高額介護サービス費_負担額(doカンマ編集(entity.get高額介護サービス費の負担額()));
        csvEntity.set特定入所者介護サービス費等_件数(doカンマ編集(new Decimal(entity.get特定入所者介護費等の件数())));
        csvEntity.set特定入所者介護サービス費等_単位数(doカンマ編集(entity.get特定入所者介護費等の単位数()));
        csvEntity.set特定入所者介護サービス費等_負担額(doカンマ編集(entity.get特定入所者介護費等の負担額()));
        return csvEntity;
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

}
