/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU040010;

import java.util.List;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dba.service.core.juminidorendoshikakutoroku.JuminIdoRendoShikakuToroku;
import jp.co.ndensan.reams.db.dbu.business.core.kaigojuminhyotruku.KaigojuminHyotrukuProcess;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kaigojuminhyotruku.KaigojuminHyotrukuProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoJoho;
import jp.co.ndensan.reams.ua.uax.business.core.idoruiseki.ShikibetsuTaishoIdoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.service.core.idoruiseki.ShikibetsuTaishoIdoFinder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * バッチ設計_DBUMN81001_住民異動連携情報登録【他社住基用】クラスです。
 *
 * @reamsid_L DBA-1400-020 wanghui
 */
public class KaigojuminHyotrukuDBUpdateProcess extends BatchProcessBase<DbT7022ShoriDateKanriEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kaigojuminhyotruku.IKaigojuminHyotrukuMapper"
            + ".get宛名連動介護保険更新");
    private KaigojuminHyotrukuProcessParameter processParameter;
    @BatchWriter
    private BatchPermanentTableWriter<DbT7022ShoriDateKanriEntity> tableWrite;
    private static final RString 異動後 = new RString("2");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBA050010");
    private FileSpoolManager manager;
    private RString 市町村コード;
    private RString filePath;
    private RDateTime 抽出開始日時;
    private RDateTime 処理日時;
    private KaigojuminHyotrukuProcess kaigojum;
    private static final RString FILENAME = new RString("fuseigoList.csv");
    private DbT7022ShoriDateKanriEntity 処理日付情報;
    @BatchWriter
    private CsvWriter<FuseigoListCsvEntity> csvWriter;

    @Override
    protected void beforeExecute() {
        処理日時 = RDate.getNowDateTime();
        kaigojum = new KaigojuminHyotrukuProcess();
    }

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        filePath = Path.combinePath(manager.getEucOutputDirectry(), FILENAME);
        csvWriter = new CsvWriter.InstanceBuilder(filePath).build();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.toKaigojuminHyotrukuMapperParameter());
    }

    @Override
    protected void createWriter() {
        tableWrite = new BatchPermanentTableWriter<>(DbT7022ShoriDateKanriEntity.class);
    }

    @Override
    protected void process(DbT7022ShoriDateKanriEntity item) {
        if (item.getKijunTimestamp() != null) {
            抽出開始日時 = item.getKijunTimestamp().getRDateTime();
        }
        市町村コード = item.getShichosonCode().value();
        処理日付情報 = item;
        宛名識別対象異動分取得PSM(抽出開始日時);
    }

    private void 宛名識別対象異動分取得PSM(RDateTime 抽出開始日時) {
        ShikibetsuTaishoIdoSearchKeyBuilder keyBuilder = kaigojum.宛名識別対象異動分取得PSM(抽出開始日時);
        ShikibetsuTaishoIdoFinder finder = ShikibetsuTaishoIdoFinder.createInstance();
        List<ShikibetsuTaishoIdoJoho> 宛名識別対象list = finder.get宛名識別対象異動(keyBuilder.build());
        JuminIdoRendoShikakuToroku juminidorendoshikakutoroku = new JuminIdoRendoShikakuToroku();
        for (ShikibetsuTaishoIdoJoho 宛名識別対象 : 宛名識別対象list) {
            if ((異動後.equals(宛名識別対象.get異動前後区分())
                    && (processParameter.getShichosonCode().contains(宛名識別対象.get現地方公共団体コード().value())))) {
                juminidorendoshikakutoroku.to住民異動情報((宛名識別対象), csvWriter);
            }
        }
    }

    @Override
    protected void afterExecute() {
        if (市町村コード == null) {
            tableWrite.insert(kaigojum.データ編集(processParameter, 処理日時, 処理日付情報));
        } else {
            tableWrite.update(kaigojum.データ更新(processParameter, 処理日時, 処理日付情報));
        }
        宛名識別対象異動分取得PSM(抽出開始日時);
    }
}
