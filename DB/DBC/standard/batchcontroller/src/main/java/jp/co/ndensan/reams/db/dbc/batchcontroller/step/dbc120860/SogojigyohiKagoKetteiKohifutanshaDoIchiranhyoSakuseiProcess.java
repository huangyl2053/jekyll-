/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc120860;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder;
import jp.co.ndensan.reams.db.dbc.business.report.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiPageBreak;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kagoketteikohifutanshain.KohifutanshaDoIchiranhyoSakuseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.csv.jukyushakoshinkekka.JukyushaKoshinKekkaIchiranCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.DbWT0001HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.sogojigyohikagoketteikohifutansha.SogoKohifutanshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohikagoketteikohifutansha.SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.PageBreaker;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 総合事業費過誤決定通知書情報取込（公費負担者分）一覧表作成。
 *
 * @reamsid_L DBC-2810-030 chenjie
 */
public class SogojigyohiKagoKetteiKohifutanshaDoIchiranhyoSakuseiProcess extends BatchKeyBreakBase<SogoKohifutanshaEntity> {

    private KohifutanshaDoIchiranhyoSakuseiProcessParameter parameter;
    private final List<PersonalData> personalDataList = new ArrayList<>();
    private Set<ShikibetsuCode> 識別コードset;
    private RString 一覧ファイルパス;
    private IOutputOrder 出力順情報;
    private Map<RString, RString> 出力順Map;
    private Map<String, Object> mybatisParameter;
    private List<RString> pageBreakKeys;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;

    private static final RString KEY_並び順の２件目 = new RString("KEY_並び順の２件目");
    private static final RString KEY_並び順の３件目 = new RString("KEY_並び順の３件目");
    private static final RString KEY_並び順の４件目 = new RString("KEY_並び順の４件目");
    private static final RString KEY_並び順の５件目 = new RString("KEY_並び順の５件目");
    private static final RString KEY_並び順の６件目 = new RString("KEY_並び順の６件目");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 出力ファイル名
            = new RString("DBC200086_SogojigyohiKagoKetteitsuchishoTorikomiIchiranKohi.csv");
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.sogojigyohikagoketteikohifutansha."
                    + "ISogoKohifutanshaChohyoMapper.get帳票出力対象データ");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200086");
    private static final RString 実行不可MESSAGE = new RString("帳票出力順の取得");
    private static final RString キー_出力順 = new RString("出力順");
    private static final RString デフォルト出力順 = new RString(" ORDER BY DbWT3061.\"kohiFutanshaNo\" ASC");
    private static final RString コンマ = new RString(",");
    private static final RString 帳票分類ID = new RString("DBC200086_SogojigyohiKagoKetteitsuchishoTorikomiIchiranKohi");

    private FileSpoolManager manager;
    @BatchWriter
    private BatchReportWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> batchReportWriter;
    private ReportSourceWriter<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> reportSourceWriter;
    @BatchWriter
    private CsvWriter csvWriter;

    @Override
    protected void initialize() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        this.出力順情報 = finder.get出力順(parameter.getサブ業務コード(), parameter.get帳票ID(),
                parameter.get出力順ID());
        if (null == this.出力順情報) {
            throw new BatchInterruptedException(UrErrorMessages.実行不可.getMessage()
                    .replace(実行不可MESSAGE.toString()).toString());
        }
        this.mybatisParameter = new HashMap<>();
        this.pageBreakKeys = new ArrayList<>();
        RString orderByStr = MyBatisOrderByClauseCreator.create(SogojigyohiKagoKetteitsuchishoTorikomiOutPutOrder.class, this.出力順情報);
        if (this.出力順情報 != null) {
            int i = 0;
            for (ISetSortItem item : 出力順情報.get設定項目リスト()) {
                if (i == INDEX_1) {
                    出力順Map.put(KEY_並び順の２件目, item.get項目名());
                } else if (i == INDEX_2) {
                    出力順Map.put(KEY_並び順の３件目, item.get項目名());
                } else if (i == INDEX_3) {
                    出力順Map.put(KEY_並び順の４件目, item.get項目名());
                } else if (i == INDEX_4) {
                    出力順Map.put(KEY_並び順の５件目, item.get項目名());
                } else if (i == INDEX_5) {
                    出力順Map.put(KEY_並び順の６件目, item.get項目名());
                }
                i = i + 1;
            }
        }
        if (RString.isNullOrEmpty(orderByStr)) {
            orderByStr = デフォルト出力順;
        } else {
            List<RString> 出力順BODY = orderByStr.split(コンマ.toString());
            orderByStr = デフォルト出力順;
            if (1 < 出力順BODY.size()) {
                for (int i = 1; i < 出力順BODY.size(); i++) {
                    orderByStr = orderByStr.concat(コンマ).concat(出力順BODY.get(i));
                }
            }
        }
        this.mybatisParameter.put(キー_出力順.toString(), orderByStr);
        this.識別コードset = new HashSet();
        pageBreakKeys.add(new RString(SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource.ReportSourceFields.kohiFutanshaNo.name()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, this.mybatisParameter);
    }

    @Override
    protected void createWriter() {
        PageBreaker<SogojigyohiKagoKetteitsuchishoTorikomiIchiranSource> breaker = new SogojigyohiKagoKetteitsuchishoTorikomiPageBreak(pageBreakKeys);
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBC.DBC200086.getReportId().value()).addBreak(breaker).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        一覧ファイルパス = Path.combinePath(spoolWorkPath, 出力ファイル名);
        csvWriter = new CsvWriter.InstanceBuilder(一覧ファイルパス)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();

    }

    @Override
    protected void keyBreakProcess(SogoKohifutanshaEntity t) {
    }

    @Override
    protected void usualProcess(SogoKohifutanshaEntity 帳票出力対象データ) {
    }

    @Override
    protected void afterExecute() {
        this.csvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(一覧ファイルパス, accessLogUUID);
        }
    }

    /**
     * CSV書き込むデータを作成する。
     *
     * @param 出力データ SogoKohifutanshaEntity
     * @param 作成日時 RDateTime
     * @return　CSV書き込むデータ
     */
    private JukyushaKoshinKekkaIchiranCsvEntity 書き込むデータ作成(SogoKohifutanshaEntity 出力データ, RDateTime 作成日時) {
        JukyushaKoshinKekkaIchiranCsvEntity output = new JukyushaKoshinKekkaIchiranCsvEntity();
        return output;
    }

    /**
     *
     * @param entity 被保険者情報
     * @return
     */
    private PersonalData getPersonalData(DbWT0001HihokenshaTempEntity entity) {
        ExpandedInformation expandedInformations = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                getColumnValue(entity.get登録被保険者番号()));
        return PersonalData.of(new ShikibetsuCode(RString.EMPTY), expandedInformations);
    }

    /**
     * 日付からstringに転換する。
     *
     * @param 年月日 日付
     * @return stringで表示する日付
     */
    private static RString date_to_string(FlexibleDate 年月日) {
        if (null == 年月日) {
            return RString.EMPTY;
        }
        return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
    }

    /**
     * 数値からstringに転換する。
     *
     * @param number 数値
     * @return カンマで編集した値
     */
    private static RString decimal_to_string(Decimal number) {
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
