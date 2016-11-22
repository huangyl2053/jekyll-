/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190030;

import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc190030.CreateShoriResultCsvFileProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc190030.ShoriResultCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * ビジネス設計_DBC110065_基準収入額適用申請書_異動分作成_対象世帯員するクラスです。
 *
 * @reamsid_L DBC-4640-080 xuzhao
 */
public class CreateShoriResultCsvFileProcess extends BatchProcessBase<DbT3116KijunShunyugakuTekiyoKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence"
            + ".db.mapper.relate.taishosetaiinido.ITaishoSetaiinIdoMapper.select基準収入額適用管理マスタ");
    private static final RString カンマ = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString 処理結果確認リスト = new RString("処理結果確認リスト.csv");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC900004");
    private static final RString DATA_世帯コード = new RString("世帯コード");
    private static final RString DATA_被保険者番号 = new RString("被保険者番号");
    private static final RString DATA_対象者判定 = new RString("対象者判定");
    private static final RString DATA_ENTITY_ID = new RString("DBC110065");
    private static final RString DATA_資格喪失 = new RString("資格喪失、認定期間切れ等によって対象外になりました。");

    private CreateShoriResultCsvFileProcessParameter parameter;
    private RString 処理結果確認リストＣＳＶFilePath;
    private FileSpoolManager manager;
    private RString 市町村コード;
    private RString 市町村名;

    @BatchWriter
    CsvWriter<ShoriResultCsvEntity> 処理結果確認リストＣＳＶ;

    @Override
    protected void initialize() {
        市町村コード = AssociationFinderFactory.createInstance().getAssociation()
                .get地方公共団体コード().code市町村RString();
        市町村名 = AssociationFinderFactory.createInstance().getAssociation().get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toTaishoSetaiinIdoMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther,
                EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        RString spoolWorkPath = manager.getEucOutputDirectry();
        処理結果確認リストＣＳＶFilePath = Path.combinePath(spoolWorkPath, 処理結果確認リスト);
        処理結果確認リストＣＳＶ = BatchWriters.csvWriter(ShoriResultCsvEntity.class)
                .filePath(処理結果確認リストＣＳＶFilePath)
                .setDelimiter(カンマ)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(DbT3116KijunShunyugakuTekiyoKanriEntity t) {
        ShoriResultCsvEntity csvEntity = new ShoriResultCsvEntity();
        csvEntity.set市町村コード(市町村コード);
        csvEntity.set市町村名(市町村名);
        csvEntity.set処理日時(RDate.getNowDate().toDateString());
        csvEntity.setキー項目1(DATA_世帯コード);
        csvEntity.setキー項目2(DATA_被保険者番号);
        csvEntity.setキー項目3(RString.EMPTY);
        csvEntity.setキー項目4(RString.EMPTY);
        csvEntity.setキー項目5(RString.EMPTY);
        csvEntity.setプログラム名_上(DATA_対象者判定);
        csvEntity.setプログラム名_下(DATA_ENTITY_ID);
        csvEntity.set項目1(t.getSetaiCode().getColumnValue());
        csvEntity.set項目2(t.getHihokenshaNo().getColumnValue());
        csvEntity.set項目3(RString.EMPTY);
        csvEntity.set項目4(RString.EMPTY);
        csvEntity.set項目5(RString.EMPTY);
        csvEntity.set内容_上(DATA_資格喪失);
        csvEntity.set内容_下(RString.EMPTY);
        処理結果確認リストＣＳＶ.writeLine(csvEntity);
    }

    @Override
    protected void afterExecute() {
        処理結果確認リストＣＳＶ.close();
        manager.spool(SubGyomuCode.DBC介護給付, 処理結果確認リストＣＳＶFilePath);
    }

}
