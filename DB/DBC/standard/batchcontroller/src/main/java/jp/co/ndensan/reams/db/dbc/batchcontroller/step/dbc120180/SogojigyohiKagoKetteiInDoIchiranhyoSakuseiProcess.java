/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120180;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInProperty.SogojigyohiKagoKetteiInBreakerFieldsEnum;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInEntity;
import jp.co.ndensan.reams.db.dbc.service.core.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInManager;
import jp.co.ndensan.reams.db.dbc.service.report.sogojigyohikagoketteiin.SogojigyohiKagoKetteiInPrintService;
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
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
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
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 一覧表作成。
 *
 * @reamsid_L DBC-2550-010 fzou
 */
public class SogojigyohiKagoKetteiInDoIchiranhyoSakuseiProcess extends SimpleBatchProcessBase {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200075");
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter eucCsvWriter;

    private static final RString 出力ファイル名
            = new RString("DBC200075_SogojigyohiKagoKetteiTsuchishoTorikomiIchiran.csv");

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
        RString 出力順 = MyBatisOrderByClauseCreator.create(SogojigyohiKagoKetteiInBreakerFieldsEnum.class, order);

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
        SogojigyohiKagoKetteiInManager chohyoManager = SogojigyohiKagoKetteiInManager.createInstance();
        List<SogojigyohiKagoKetteiInEntity> list = chohyoManager.get帳票出力対象データ(mybatisParameter);
        if (null == list || list.isEmpty()) {
            return;
        }
        SogojigyohiKagoKetteiInPrintService printService = new SogojigyohiKagoKetteiInPrintService();
        printService.printTaitsu(list, order, parameter.get処理年月(), parameter.getシステム日付());
        do帳票のCSVファイル作成(list, parameter.get処理年月(), parameter.getシステム日付());
    }

    private void do帳票のCSVファイル作成(List<SogojigyohiKagoKetteiInEntity> list,
            FlexibleYearMonth 処理年月, RDateTime 作成日時) {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, 出力ファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.SJIS)
                .setNewLine(NewLine.CRLF)
                .hasHeader(false)
                .build();

        Set<ShikibetsuCode> 識別コードset = new HashSet<>();
        for (int index = 0; index < list.size(); index++) {
            boolean 集計Flag = false;

            if (list.size() <= (index + 1)) {
                集計Flag = true;
            } else {
                ShoKisaiHokenshaNo 証記載保険者番号 = list.get(index).get証記載保険者番号();
                ShoKisaiHokenshaNo 証記載保険者番号Next = list.get(index + 1).get証記載保険者番号();
                if (!証記載保険者番号.equals(証記載保険者番号Next)) {
                    集計Flag = true;
                }
            }
            SogojigyohiKagoKetteiInCsvEntity output = new SogojigyohiKagoKetteiInCsvEntity();
            SogojigyohiKagoKetteiInEntity 出力対象 = list.get(index);
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
                output.set総合事業費_件数(new RString(出力対象.get介護給付費件数()));
                output.set総合事業費_単位数(doカンマ編集(出力対象.get介護給付費単位数()));
                output.set総合事業費_負担額(doカンマ編集(出力対象.get介護給付費保険者負担額()));
            } else {
                output.set証記載保険者番号(getColumnValue(出力対象.get証記載保険者番号()));
                output.set証記載保険者名(出力対象.get証記載保険者名());
                output.set取扱年月(doパターン54(出力対象.get取扱年月()));
                output.set事業者番号(getColumnValue(出力対象.get事業者番号()));
                output.set事業者名(出力対象.get事業者名());
                output.set被保険者番号(getColumnValue(出力対象.get被保険者番号()));
                output.set被保険者名(出力対象.get被保険者名());
                output.setサービス提供年月(doパターン54(出力対象.getサービ提供年月()));
                output.setサービス種類コード(getColumnValue(出力対象.getサービス種類コード()));
                output.setサービス種類名(出力対象.getサービス種類名());
                output.set過誤申立事由コード(getColumnValue(出力対象.get過誤申立事由コード()));
                output.set過誤申立事由(出力対象.get過誤申立事由());
                output.set単位数(doカンマ編集(出力対象.get単位数()));
                output.set負担額(doカンマ編集(出力対象.get保険者負担額()));

            }
            eucCsvWriter.writeLine(output);
        }
        for (SogojigyohiKagoKetteiInEntity chohyoEntity : list) {
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

    private PersonalData getPersonalData(SogojigyohiKagoKetteiInEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                entity.get被保険者番号().getColumnValue());
        return PersonalData.of(entity.get識別コード(), expandedInformations);
    }

    private RString doカンマ編集(Decimal number) {
        if (null == number) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(number, 0);
    }

    private RString doパターン54(FlexibleYearMonth 年月) {
        if (null == 年月) {
            return RString.EMPTY;
        }
        return 年月.wareki().separator(Separator.PERIOD).fillType(FillType.BLANK).toDateString();
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
