/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc180040;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.processprm.futanwariaishohakko.FutanwariaishoHakkoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.futanwariaishohakko.FutanWariKikanTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担割合UPDATEのProcessクラスです。
 *
 * @reamsid_L DBC-4990-030 pengxingyi
 */
public class FutanWariaiInsertProcess extends BatchProcessBase<DbT3114RiyoshaFutanWariaiMeisaiEntity> {

    private IFutanwariaishoHakkoMapper mapper;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.futanwariaishohakko.IFutanwariaishoHakkoMapper.select利用者負担割合明細");
    private FutanwariaishoHakkoProcessParameter parameter;
    private FutanWariKikanTempEntity temp;
    private List<DbT3114RiyoshaFutanWariaiMeisaiEntity> list;
    private static final RString TABLE_NAME = new RString("FutanWariKikanTemp");
    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;

    @Override
    protected void initialize() {
        list = new ArrayList<>();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, FutanWariKikanTempEntity.class);
    }

    @Override
    protected void process(DbT3114RiyoshaFutanWariaiMeisaiEntity entity) {
        list.add(entity);
    }

    @Override
    protected void afterExecute() {
        if (list.isEmpty()) {
            return;
        }
        FutanWariKikanTempEntity entity = new FutanWariKikanTempEntity();
        entity.setNendo(list.get(0).getNendo());
        entity.setHihokenshaNo(list.get(0).getHihokenshaNo());
        int size = list.size();
        if (size <= 1) {
            entity.setFutanWariaiKubun1(list.get(0).getFutanWariaiKubun());
            entity.setYukoKaishiYMD1(list.get(0).getYukoKaishiYMD());
            entity.setYukoShuryoYMD1(list.get(0).getYukoShuryoYMD());
            entity.setShikakuKubun1(list.get(0).getShikakuKubun());
        } else {
            entity.setFutanWariaiKubun1(list.get(size - 2).getFutanWariaiKubun());
            entity.setYukoKaishiYMD1(list.get(size - 2).getYukoKaishiYMD());
            entity.setYukoShuryoYMD1(list.get(size - 2).getYukoShuryoYMD());
            entity.setShikakuKubun1(list.get(size - 2).getShikakuKubun());
            entity.setFutanWariaiKubun2(list.get(size - 1).getFutanWariaiKubun());
            entity.setYukoKaishiYMD2(list.get(size - 1).getYukoKaishiYMD());
            entity.setYukoShuryoYMD2(list.get(size - 1).getYukoShuryoYMD());
            entity.setShikakuKubun2(list.get(size - 1).getShikakuKubun());
        }
        tableWriter.insert(entity);
    }
}
