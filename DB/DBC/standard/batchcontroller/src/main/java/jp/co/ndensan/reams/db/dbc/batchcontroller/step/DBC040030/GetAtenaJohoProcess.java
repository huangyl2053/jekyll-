/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC040030;

import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc040030.KogakugassanJikofutangakuMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.dbc040030.KogakugassanJikofutangakuInfoHoseiProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc040030.KogakugassanJikofutangakuInfoHoseiTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030.IKogakugassanJikofutangakuInfoHoseiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のprocessクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public class GetAtenaJohoProcess extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get被保険者情報と宛名情報付加");

    private static final RString TABLE_NAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private IKogakugassanJikofutangakuInfoHoseiMapper mapper;

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakugassanJikofutangakuInfoHoseiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {

        KogakugassanJikofutangakuMybatisParameter param = new KogakugassanJikofutangakuMybatisParameter();
        param.set基準年月日(new FlexibleDate(processParameter.getHandleTimestamp().getDate().toDateString()));
        return new BatchDbReader(READ_DATA_ID, param);
    }

    @Override
    protected void createWriter() {

        tempDbWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, KogakugassanJikofutangakuInfoHoseiTempEntity.class);
    }

    @Override
    protected void process(KogakugassanJikofutangakuInfoHoseiEntity entity) {
        KogakugassanJikofutangakuMybatisParameter parameter = new KogakugassanJikofutangakuMybatisParameter();
        parameter.setHihokenshaNo(entity.get中間DBEntity().getHihokenshaNo());
        parameter.setHokenshaNo(entity.get中間DBEntity().getHokenshaNo());
        parameter.setRirekiNo(entity.get中間DBEntity().getRirekiNo2());
        parameter.setShikyuShinseishoSeiriNo(entity.get中間DBEntity().getShikyuShinseishoSeiriNo());
        parameter.setTaishoNendo(entity.get中間DBEntity().getTaishoNendo());
        KogakugassanJikofutangakuInfoHoseiTempEntity tmpEntity = mapper.select中間DB(parameter);
        if (tmpEntity != null) {
            tempDbWriter.delete(tmpEntity);
        }
        entity.get中間DBEntity().setJuminShubetsuCode(entity.getJuminShubetsuCode());
        entity.get中間DBEntity().setShichosonCode(entity.getShichosonCode());
        entity.get中間DBEntity().setYubinNo(entity.getYubinNo());
        entity.get中間DBEntity().setZenkokuJushoCode(entity.getZenkokuJushoCode());
        entity.get中間DBEntity().setGyoseikuCode(entity.getGyoseikuCode());
        tempDbWriter.insert(entity.get中間DBEntity());

    }

}
