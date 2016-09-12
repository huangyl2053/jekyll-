/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 37J_高額合算自己負担額確認情報取込のマスタ登録(マスタ更新2:明細のマスタ更新)。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class KogakuGassanJikofutangakuDoMasterTorokuMeisaiUpdateProcess
        extends BatchProcessBase<DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc120110.IKogakuGassanJikofutangakuMapper.select高額合算自己負担額明細と一時データ");

    @BatchWriter
    BatchPermanentTableWriter 高額合算自己負担額明細TBLWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        高額合算自己負担額明細TBLWriter = new BatchPermanentTableWriter(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity.class);
    }

    @Override
    protected void process(DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity entity) {
        this.do明細データ更新(entity);
    }

    private void do明細データ更新(DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity 明細entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity updateEntity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        updateEntity.setHihokenshaNo(明細entity.get被保険者番号());
        updateEntity.setTaishoNendo(明細entity.get対象年度());
        updateEntity.setHokenshaNo(明細entity.get保険者番号());
        updateEntity.setShikyuShinseishoSeiriNo(明細entity.get支給申請書整理番号());
        updateEntity.setRirekiNo(明細entity.get履歴番号());
        updateEntity.setTaishoM(明細entity.get対象月());
        updateEntity.setJikoFutanGaku(明細entity.get自己負担額());
        updateEntity.setUchisu_70_74JikoFutanGaku(明細entity.get自己負担額_内数70_74());
        updateEntity.setUnder_70KogakuShikyuGaku(明細entity.get未満70高額支給額());
        updateEntity.setOver_70_74KogakuShikyuGaku(明細entity.get高額支給額70_74());
        updateEntity.setTekiyo(明細entity.get摘要());
        updateEntity.setSumi_JikoFutanGaku(明細entity.get補正済_自己負担額());
        updateEntity.setSumi_70_74JikoFutanGaku(明細entity.get補正済_70_74自己負担額_内数_());
        updateEntity.setSumi_under_70KogakuShikyuGaku(明細entity.get補正済_70未満高額支給額());
        updateEntity.setSumi_70_74KogakuShikyuGaku(明細entity.get補正済_70_74高額支給額());
        updateEntity.setSumi_Tekiyo(明細entity.get補正済_摘要());
        高額合算自己負担額明細TBLWriter.update(updateEntity);
    }
}
