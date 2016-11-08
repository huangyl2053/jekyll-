/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc050021.FurikomimeisaiFurikomiDataProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiErrorListCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvListWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.lang.Width;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 振込明細・振込みデータ作成 振込エラーリスト作成です。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class FurikomiDataErrorListProcess extends BatchProcessBase<DbWT0510FurikomiMeisaiTempEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.select振込エラーリスト情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200099");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 出力ファイル名 = new RString("DBC200099_FurikomiErrorList.csv");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final Code コード = new Code("0003");
    private static final RString 被保険者番号R = new RString("被保険者番号");
    private static final RString 項目名_作成日時 = new RString("作成日時");
    private static final RString 項目名_証記載保険者番号 = new RString("証記載保険者番号");
    private static final RString 項目名_被保険者番号 = new RString("被保険者番号");
    private static final RString 項目名_被保険者氏名 = new RString("被保険者氏名");
    private static final RString 項目名_郵便番号 = new RString("郵便番号");
    private static final RString 項目名_住所 = new RString("住所");
    private static final RString 項目名_識別コード = new RString("識別コード");
    private static final RString 項目名_口座ID = new RString("口座ID");
    private static final RString 項目名_決定通知番号 = new RString("決定通知番号");
    private static final RString 項目名_支給申請書整理番号 = new RString("支給申請書整理番号");
    private static final RString 項目名_振込金額 = new RString("振込金額");
    private static final RString 高額合算KUNBUN = new RString("高額合算");
    private static final RString 事業高額KUNBUN = new RString("事業高額");
    private static final RString 事業高額合算KUNBUN = new RString("事業高額合算");
    private static final RString 作成R = new RString("作成");

    private FurikomimeisaiFurikomiDataProcessParameter parameter;
    private CsvListWriter csvListWriter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;
    private Set<ShikibetsuCode> 識別コードset;

    private int count;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void initialize() {
        count = INT_0;
        personalDataList = new ArrayList<>();
        識別コードset = new HashSet<>();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), 出力ファイル名);
    }

    @Override
    protected void process(DbWT0510FurikomiMeisaiTempEntity t) {
        if (count == INT_0) {
            List<RString> headList = getHeader();
            csvListWriter = new CsvListWriter.InstanceBuilder(eucFilePath)
                    .alwaysWriteHeader(FurikomiErrorListCsvEntity.class)
                    .setEncode(Encode.UTF_8withBOM)
                    .setDelimiter(EUC_WRITER_DELIMITER)
                    .setEnclosure(EUC_WRITER_ENCLOSURE)
                    .setNewLine(NewLine.CRLF)
                    .setHeader(headList)
                    .hasHeader(true)
                    .build();
        }
        count++;
        List<RString> bodyList = getBody(t);
        csvListWriter.writeLine(bodyList);
        ShikibetsuCode 識別コード = t.getShikibetsuCode();
        if (識別コード != null && !識別コード.isEmpty() && !識別コードset.contains(識別コード)) {
            識別コードset.add(識別コード);
            personalDataList.add(toPersonalData(t));
        }
    }

    @Override
    protected void afterExecute() {
        if (count != 0) {
            csvListWriter.close();
            if (!personalDataList.isEmpty()) {
                AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
                manager.spool(eucFilePath, accessLogUUID);
            } else {
                manager.spool(eucFilePath);
            }
        }
    }

    private PersonalData toPersonalData(DbWT0510FurikomiMeisaiTempEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(コード, 被保険者番号R, entity.getHihokenshaNo().getColumnValue());
        return PersonalData.of(entity.getShikibetsuCode(), expandedInfo);
    }

    private List<RString> getHeader() {
        List<RString> list = new ArrayList<>();
        list.add(項目名_作成日時);
        list.add(項目名_証記載保険者番号);
        list.add(項目名_被保険者番号);
        list.add(項目名_被保険者氏名);
        list.add(項目名_郵便番号);
        list.add(項目名_住所);
        list.add(項目名_識別コード);
        list.add(項目名_口座ID);
        RString batchKunbun = parameter.getBatchKunbun();
        if (事業高額KUNBUN.equals(batchKunbun)) {
            list.add(項目名_決定通知番号);
        } else if (高額合算KUNBUN.equals(batchKunbun) || 事業高額合算KUNBUN.equals(batchKunbun)) {
            list.add(項目名_支給申請書整理番号);
        }
        list.add(項目名_振込金額);
        return list;
    }

    private List<RString> getBody(DbWT0510FurikomiMeisaiTempEntity entity) {
        List<RString> list = new ArrayList<>();
        if (count == INT_1) {
            list.add(getSakuseiYmhm());
        } else {
            list.add(RString.EMPTY);
        }
        list.add(entity.getShoKisaiHokenshaNo() == null ? RString.EMPTY : entity.getShoKisaiHokenshaNo().getColumnValue());
        list.add(entity.getHihokenshaNo() == null ? RString.EMPTY : entity.getHihokenshaNo().getColumnValue());
        list.add(entity.getShimei() == null ? RString.EMPTY : entity.getShimei().getColumnValue());
        list.add(entity.getYubinNo() == null ? RString.EMPTY : entity.getYubinNo().getEditedYubinNo());
        list.add(entity.getJusho() == null ? RString.EMPTY : entity.getJusho().getColumnValue());
        list.add(entity.getShikibetsuCode() == null ? RString.EMPTY : entity.getShikibetsuCode().getColumnValue());
        list.add(new RString(entity.getKozaID()));
        RString batchKunbun = parameter.getBatchKunbun();
        if (事業高額KUNBUN.equals(batchKunbun)) {
            list.add(entity.getKetteiTsuchiNo() == null ? RString.EMPTY : entity.getKetteiTsuchiNo());
        } else if (高額合算KUNBUN.equals(batchKunbun) || 事業高額合算KUNBUN.equals(batchKunbun)) {
            list.add(entity.getShikyuShinseishoSeiriNo() == null ? RString.EMPTY : entity.getShikyuShinseishoSeiriNo());
        }
        list.add(entity.getFurikomiKingaku() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(entity.getFurikomiKingaku(), INT_0));
        return list;
    }

    private RString getSakuseiYmhm() {
        RDateTime datetime = parameter.getシステム日時().getRDateTime();
        RStringBuilder sakuseiYMD = new RStringBuilder();
        sakuseiYMD.append(datetime.getDate().wareki().
                eraType(EraType.KANJI).firstYear(FirstYear.ICHI_NEN).
                separator(Separator.JAPANESE).
                fillType(FillType.NONE).
                width(Width.HALF).toDateString());
        sakuseiYMD.append(datetime.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒));
        sakuseiYMD.append(RString.HALF_SPACE);
        sakuseiYMD.append(作成R);
        return sakuseiYMD.toRString();
    }

}
