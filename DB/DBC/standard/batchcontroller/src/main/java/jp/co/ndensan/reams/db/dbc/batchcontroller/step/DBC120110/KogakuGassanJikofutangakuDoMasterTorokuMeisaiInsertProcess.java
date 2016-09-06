/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC120110;

import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120110.DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 37J_高額合算自己負担額確認情報取込のマスタ登録(マスタ更新2:明細のマスタ追加)。
 *
 * @reamsid_L DBC-2650-010 chenjie
 */
public class KogakuGassanJikofutangakuDoMasterTorokuMeisaiInsertProcess
        extends BatchProcessBase<DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "dbc120110.IKogakuGassanJikofutangakuMapper.select高額合算自己負担額一時と明細データ");

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
        this.do明細マスタ追加(entity);

    }

    private void do明細マスタ追加(DbT3071KogakuGassanJikoFutanGakuMeisaiCsvEntity entity) {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity insertEntity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        insertEntity.setHihokenshaNo(entity.get被保険者番号());
        insertEntity.setTaishoNendo(entity.get対象年度());
        insertEntity.setHokenshaNo(new HokenshaNo(getColumnValue(entity.get保険者番号())));
        insertEntity.setShikyuShinseishoSeiriNo(entity.get支給申請書整理番号());
        insertEntity.setRirekiNo(entity.get履歴番号());
        insertEntity.setTaishoM(entity.get対象月());
        insertEntity.setJikoFutanGaku(entity.get自己負担額());
        insertEntity.setUchisu_70_74JikoFutanGaku(entity.get自己負担額_内数70_74());
        insertEntity.setUnder_70KogakuShikyuGaku(entity.get未満70高額支給額());
        insertEntity.setOver_70_74KogakuShikyuGaku(entity.get高額支給額70_74());
        insertEntity.setTekiyo(entity.get摘要());
        insertEntity.setSumi_JikoFutanGaku(entity.get補正済_自己負担額());
        insertEntity.setSumi_70_74JikoFutanGaku(entity.get補正済_70_74自己負担額_内数_());
        insertEntity.setSumi_under_70KogakuShikyuGaku(entity.get補正済_70未満高額支給額());
        insertEntity.setSumi_70_74KogakuShikyuGaku(entity.get補正済_70_74高額支給額());
        insertEntity.setSumi_Tekiyo(entity.get補正済_摘要());
        高額合算自己負担額明細TBLWriter.insert(insertEntity);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }
}
