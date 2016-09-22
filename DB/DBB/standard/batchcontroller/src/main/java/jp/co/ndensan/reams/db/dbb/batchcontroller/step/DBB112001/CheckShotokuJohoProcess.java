/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB112001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.shutokujohoshuchutsurenkei.ShutokuJohoShuchutsuRenkeiProcessParameter;
import jp.co.ndensan.reams.db.dbb.entity.csv.ShotokuJohoTorokuErrCSVEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.kaigoshoto.KaigoShotoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.shotokujohotemp.DbTShotokuJohoTempTableEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.toushoshotokujohochushutsurenkei.DbTShotokuJohoToShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 所得情報抽出・連携バッチのファイルの登録Processです。
 *
 * @reamsid_L DBB-1690-060 gongliang
 */
public class CheckShotokuJohoProcess extends BatchProcessBase<DbTShotokuJohoToShotokuKanriEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbb.persistence.db.mapper.relate."
            + "toushoshotokujohochushutsurenkei.IToushoShotokuJohoChushutsuRenkeiMapper.get所得情報と介護所得管理");
    private static final RString 別年度の所得情報 = new RString("別年度の所得情報です。");
    private static final RString 当年度の所得情報が既に存在 = new RString("当年度の所得情報が既に存在します。");
    private static final RString 非課税区分が誤って = new RString("非課税区分が誤ってます。");
    private static final RString 調査中として登録されてい = new RString("調査中として登録されています。");
    private static final RString 介護優先として登録されて = new RString("介護優先として登録されています。");
    private static final RString 当初_広域_1 = new RString("1");
    private static final RString 異動_広域_2 = new RString("2");
    private static final RString 当初_単一_3 = new RString("3");
    private static final RString 異動_単一_4 = new RString("4");
    private static final RString 非課税区分_課税 = new RString("0");
    private static final RString 非課税区分_非課税 = new RString("1");
    private static final RString 非課税区分_課税取消 = new RString("2");
    private static final RString 非課税区分_未申告 = new RString("3");
    private static final RString 課税区分_課税 = new RString("1");
    private static final RString 課税区分_非課税 = new RString("2");
    private static final RString 課税区分_未申告 = new RString("3");
    private static final RString 課税区分_前_調査中 = new RString("4");
    private static final RString 優先区分_前_介護優先 = new RString("1");
    private static final int INT_0 = 0;
    private static final int INT_1 = 1;
    private static final RString TIME_FORMAT = new RString("HH:MM:SS");
    private static final RString RSTRING_0 = new RString("0");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString EUCエンティティID = new RString("DBB900001");
    private static final RString EUCファイル名 = new RString("ShotokuJohoTorokuErrList.csv");
    private static final RString 介護所得一時TABLE_NAME = new RString("DbT2008KaigoShoto");

    private ShutokuJohoShuchutsuRenkeiProcessParameter parameter;
    private FileSpoolManager manager;
    private RString eucFilePath;

    @BatchWriter
    CsvWriter<ShotokuJohoTorokuErrCSVEntity> eucCsvWriter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 介護所得一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        介護所得一時tableWriter
                = new BatchEntityCreatedTempTableWriter(介護所得一時TABLE_NAME, KaigoShotoTempTableEntity.class);
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUCエンティティID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        eucFilePath = Path.combinePath(spoolWorkPath, EUCファイル名);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(DbTShotokuJohoToShotokuKanriEntity entity) {
        RString 処理区分 = parameter.get処理区分();
        if (当初_広域_1.equals(処理区分) || 当初_単一_3.equals(処理区分)) {
            データの年度チェック(entity);
        } else if (異動_広域_2.equals(処理区分) || 異動_単一_4.equals(処理区分)) {
            非課税区分のチェック_異動(entity);
        }
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
    }

    private void 非課税区分のチェック_異動(DbTShotokuJohoToShotokuKanriEntity entity) {
        RString 非課税区分 = entity.get所得情報tempEntity().getHiKazeiKunbun();
        if (非課税区分_課税.equals(非課税区分) || 非課税区分_非課税.equals(非課税区分)
                || 非課税区分_課税取消.equals(非課税区分) || 非課税区分_未申告.equals(非課税区分)) {
            データが取得のチェック(entity);
        } else {
            ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
            csvEntity.setエラー内容(非課税区分が誤って);
            eucCsvWriter.writeLine(csvEntity);
        }
    }

    private void データが取得のチェック(DbTShotokuJohoToShotokuKanriEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理entity = entity.get介護所得管理entity();
        if (介護所得管理entity != null) {
            RString 課税区分_住民税減免前 = 介護所得管理entity.getKazeiKubun();
            if (課税区分_前_調査中.equals(課税区分_住民税減免前)) {
                ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
                csvEntity.setエラー内容(調査中として登録されてい);
                eucCsvWriter.writeLine(csvEntity);
            } else if (優先区分_前_介護優先.equals(介護所得管理entity.getYusenKubun())) {
                ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
                csvEntity.setエラー内容(介護優先として登録されて);
                eucCsvWriter.writeLine(csvEntity);
            } else {
                KaigoShotoTempTableEntity tempEntity = get介護所得一時Entity(entity.get所得情報tempEntity());
                tempEntity.setRirekiNo(介護所得管理entity.getRirekiNo() + INT_1);
                介護所得一時tableWriter.insert(tempEntity);
            }
        } else {
            KaigoShotoTempTableEntity tempEntity = get介護所得一時Entity(entity.get所得情報tempEntity());
            介護所得一時tableWriter.insert(tempEntity);
        }
    }

    private void データの年度チェック(DbTShotokuJohoToShotokuKanriEntity entity) {
        FlexibleYear 処理年度 = parameter.get処理年度();
        if (!処理年度.equals(entity.get所得情報tempEntity().getFukaNendo())) {
            ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
            csvEntity.setエラー内容(別年度の所得情報);
            eucCsvWriter.writeLine(csvEntity);
        } else {
            データの存在チェック(entity);
        }
    }

    private void データの存在チェック(DbTShotokuJohoToShotokuKanriEntity entity) {
        DbT2008ShotokuKanriEntity 介護所得管理entity = entity.get介護所得管理entity();
        if (介護所得管理entity != null) {
            ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
            csvEntity.setエラー内容(当年度の所得情報が既に存在);
            eucCsvWriter.writeLine(csvEntity);
        } else {
            非課税区分のチェック(entity);
        }
    }

    private void 非課税区分のチェック(DbTShotokuJohoToShotokuKanriEntity entity) {
        RString 非課税区分 = entity.get所得情報tempEntity().getHiKazeiKunbun();
        if (非課税区分_課税.equals(非課税区分) || 非課税区分_非課税.equals(非課税区分)
                || 非課税区分_課税取消.equals(非課税区分) || 非課税区分_未申告.equals(非課税区分)) {
            KaigoShotoTempTableEntity tempEntity = get介護所得一時Entity(entity.get所得情報tempEntity());
            介護所得一時tableWriter.insert(tempEntity);
        } else {
            ShotokuJohoTorokuErrCSVEntity csvEntity = get所得情報登録エラー(entity.get所得情報tempEntity());
            csvEntity.setエラー内容(非課税区分が誤って);
            eucCsvWriter.writeLine(csvEntity);
        }
    }

    private KaigoShotoTempTableEntity get介護所得一時Entity(DbTShotokuJohoTempTableEntity entity) {
        KaigoShotoTempTableEntity tempEntity = new KaigoShotoTempTableEntity();
        tempEntity.setShichosonCode(entity.getShichosonCode());
        tempEntity.setShichosonShikibetuId(entity.getShikibetuId());
        tempEntity.setShotoNendo(entity.getFukaNendo());
        tempEntity.setShikibetsuCode(entity.getJyuuminCode());
        tempEntity.setRirekiNo(INT_0);
        RString 非課税区分 = entity.getHiKazeiKunbun();
        RString 課税区分 = RString.EMPTY;
        if (非課税区分_課税.equals(非課税区分)) {
            課税区分 = 課税区分_課税;
        } else if (非課税区分_非課税.equals(非課税区分) || 非課税区分_課税取消.equals(非課税区分)) {
            課税区分 = 課税区分_非課税;
        } else if (非課税区分_未申告.equals(非課税区分)) {
            課税区分 = 課税区分_未申告;
        }
        tempEntity.setKazeiKubun(課税区分);
        tempEntity.setKazeiKubunGemmenGo(課税区分);
        tempEntity.setGokeiShotokuGaku(entity.getGokeiShotokuGaku());
        tempEntity.setNenkiniShunyuGaku(entity.getNenkiniShunyuGaku());
        tempEntity.setNenkiniShotokuGaku(entity.getNenkiniShotokuGaku());
        tempEntity.setKazeiShotoGaku(Decimal.ZERO);
        tempEntity.setGekihenkanwaKubun(entity.getGekihenkanwaKubun());
        tempEntity.setYuusenKunbun(RSTRING_0);
        tempEntity.setShoriTimeStamp(parameter.get処理日時());
        return tempEntity;
    }

    private ShotokuJohoTorokuErrCSVEntity get所得情報登録エラー(DbTShotokuJohoTempTableEntity entity) {
        YMDHMS 入力日時 = parameter.get処理日時();
        ShotokuJohoTorokuErrCSVEntity csvEntity = new ShotokuJohoTorokuErrCSVEntity();
        RString 作成年月日 = 入力日時.getDate().seireki().separator(Separator.SLASH).fillType(FillType.BLANK).toDateString();
        csvEntity.set作成年月日(作成年月日);
        RString 作成日時 = 入力日時.getRDateTime().format西暦(TIME_FORMAT.toString());
        csvEntity.set作成日時(作成日時);
        RString 賦課年度 = entity.getFukaNendo() == null || entity.getFukaNendo().isEmpty() ? RString.EMPTY : entity.getFukaNendo().toDateString();
        csvEntity.set賦課年度(賦課年度);
        RString 住民コード = entity.getJyuuminCode() == null
                || entity.getJyuuminCode().isEmpty() ? RString.EMPTY : entity.getJyuuminCode().getColumnValue();
        csvEntity.set住民コード(住民コード);
        RString 市町村コード = entity.getShichosonCode() == null
                || entity.getShichosonCode().isEmpty() ? RString.EMPTY : entity.getShichosonCode().getColumnValue();
        csvEntity.set市町村コード(市町村コード);
        csvEntity.set非課税区分(entity.getHiKazeiKunbun());
        return csvEntity;
    }
}
