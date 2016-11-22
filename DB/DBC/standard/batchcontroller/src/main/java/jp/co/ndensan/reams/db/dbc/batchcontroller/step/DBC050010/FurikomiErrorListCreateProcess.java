/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.Furikomi_MeisaiDataKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiDetailTempTableEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050010.FurikomiErrorListCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.uuid.AccessLogUUID;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 振込エラーリスト作成_Process処理クラスです．
 *
 * @reamsid_L DBC-2180-030 x_lilh
 */
public class FurikomiErrorListCreateProcess extends BatchProcessBase<FurikomiDetailTempTableEntity> {

    private static final int 先頭_作成日時_アカウント = 1;
    private static final RString 作成 = new RString("作成");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC200099");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.dbc050010.IFurikomiErrorListCreateMapper.select振込エラーリスト情報");

    private CsvWriter<FurikomiErrorListCsvEntity> eucCsvWriter;

    private FileSpoolManager manager;
    private RString eucFilePath;
    private List<PersonalData> personalDataList;

    private int count = 0;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void initialize() {
        personalDataList = new ArrayList<>();
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("DBC200099_FurikomiErrorList.csv"));
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .alwaysWriteHeader(FurikomiErrorListCsvEntity.class)
                .setEncode(Encode.SJIS)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(FurikomiDetailTempTableEntity t) {
        count++;
        FurikomiErrorListCsvEntity eucCsvEntity = new FurikomiErrorListCsvEntity();
        edit振込エラーリスト(eucCsvEntity, t, count);
        eucCsvWriter.writeLine(eucCsvEntity);

        personalDataList.add(toPersonalData(t));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        if (!personalDataList.isEmpty()) {
            AccessLogUUID accessLogUUID = AccessLogger.logEUC(UzUDE0835SpoolOutputType.Euc, personalDataList);
            manager.spool(eucFilePath, accessLogUUID);
        }
    }

    private PersonalData toPersonalData(FurikomiDetailTempTableEntity entity) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code(new RString("0003")), new RString("被保険者番号"),
                entity.getHihokenshaNo().value());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);
    }

    private void edit振込エラーリスト(FurikomiErrorListCsvEntity eucCsvEntity, FurikomiDetailTempTableEntity t, int count) {
        if (先頭_作成日時_アカウント == count) {
            eucCsvEntity.set作成日時(editシステム作成日時());
        } else {
            eucCsvEntity.set作成日時(RString.EMPTY);
        }

        eucCsvEntity.set証記載保険者番号(t.getShoKisaiHokenshaNo().value());
        eucCsvEntity.set被保険者番号(t.getHihokenshaNo().value());
        eucCsvEntity.set被保険者氏名(t.getShimeiKana().value());
        eucCsvEntity.set郵便番号(t.getYubinNo().getYubinNo());
        eucCsvEntity.set住所(t.getJusho());
        eucCsvEntity.set識別コード(t.getShikibetsuCode().value());
        eucCsvEntity.set口座ID(new RString(t.getKozaID()));
        eucCsvEntity.set決定通知番号(t.getKetteiTsuchiNo());
        eucCsvEntity.set振込金額(new RString(t.getFurikomiKingaku().toString()));

        if (t.getDataKubun() != null && !t.getDataKubun().isEmpty()) {
            eucCsvEntity.setデータ区分(Furikomi_MeisaiDataKubun.toValue(t.getDataKubun()).get名称());
        }
    }

    private RString editシステム作成日時() {
        StringBuilder builder = new StringBuilder();

        RDateTime システム日時 = RDateTime.now();
        RString 編集後日付 = システム日時.getDate().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                .fillType(FillType.BLANK).toDateString();
        RString 作成時 = システム日時.getTime().toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);

        builder.append(編集後日付);
        builder.append(作成時);
        builder.append(RString.FULL_SPACE);
        builder.append(作成);
        return new RString(builder.toString());
    }
}
