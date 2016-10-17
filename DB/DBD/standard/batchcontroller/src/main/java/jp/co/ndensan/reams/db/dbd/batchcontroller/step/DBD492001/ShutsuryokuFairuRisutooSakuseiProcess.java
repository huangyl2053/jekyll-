/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbd.service.core.dbd492001.NinteiKekkaRenkeiDataTorikomiManager;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力ファイルリストを作成_process処理クラスです。
 *
 * @reamsid_L DBD-1510-020 x_xuliang
 */
public class ShutsuryokuFairuRisutooSakuseiProcess extends BatchProcessBase<FairudetaIchijiTeburuEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "yokaigoninteikekkarenkeidetatorikomi.IFairudetaIchijiTeburuMapper.getファイルデータ一時テーブル");
    @BatchWriter
    private BatchPermanentTableWriter<DbT4003YokaigoNinteiInterfaceEntity> dbt4003tableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected void createWriter() {
        dbt4003tableWriter = new BatchPermanentTableWriter<>(DbT4003YokaigoNinteiInterfaceEntity.class);
    }

    @Override
    protected void process(FairudetaIchijiTeburuEntity entity) {
        DbT4003YokaigoNinteiInterfaceEntity dbt4003entity = new DbT4003YokaigoNinteiInterfaceEntity();
        NinteiKekkaRenkeiDataTorikomiManager.createInstance().create要介護認定インターフェースマスタル(entity, dbt4003entity);
        dbt4003tableWriter.insert(dbt4003entity);
    }

    @Override
    protected void afterExecute() {
    }
}
