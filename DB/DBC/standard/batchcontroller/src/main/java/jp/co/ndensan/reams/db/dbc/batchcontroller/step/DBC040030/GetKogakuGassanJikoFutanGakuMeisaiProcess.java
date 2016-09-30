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
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額情報補正（一括）のprocessクラスです。
 *
 * @reamsid_L DBC-2320-060 chenyadong
 */
public class GetKogakuGassanJikoFutanGakuMeisaiProcess extends BatchProcessBase<KogakugassanJikofutangakuInfoHoseiEntity> {

    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc040030."
            + "IKogakugassanJikofutangakuInfoHoseiMapper.get高額合算自己負担額明細データ");

    private static final RString TABLE_NAME = new RString("KogakugassanJikofutangakuInfoHoseiTemp");
    private KogakugassanJikofutangakuInfoHoseiProcessParameter processParameter;
    private IKogakugassanJikofutangakuInfoHoseiMapper mapper;
    private static final RString 当年04月 = new RString("004");
    private static final RString 当年05月 = new RString("005");
    private static final RString 当年06月 = new RString("006");
    private static final RString 当年07月 = new RString("007");
    private static final RString 当年08月 = new RString("008");
    private static final RString 当年09月 = new RString("009");
    private static final RString 当年10月 = new RString("010");
    private static final RString 当年11月 = new RString("011");
    private static final RString 当年12月 = new RString("012");
    private static final RString 翌年01月 = new RString("101");
    private static final RString 翌年02月 = new RString("102");
    private static final RString 翌年03月 = new RString("103");
    private static final RString 翌年04月 = new RString("104");
    private static final RString 翌年05月 = new RString("105");
    private static final RString 翌年06月 = new RString("106");
    private static final RString 翌年07月 = new RString("107");

    @BatchWriter
    private IBatchTableWriter tempDbWriter;

    @Override
    protected void initialize() {
        mapper = getMapper(IKogakugassanJikofutangakuInfoHoseiMapper.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
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
        if (当年04月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_04_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_04_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_04_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_04_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_04_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_04_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_04_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_04_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_04_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_04_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年05月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_05_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_05_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_05_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_05_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_05_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_05_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_05_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_05_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_05_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_05_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年06月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_06_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_06_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_06_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_06_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_06_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_06_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_06_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_06_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_06_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_06_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年07月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_07_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_07_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_07_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_07_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_07_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_07_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_07_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_07_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_07_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_07_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年08月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_08_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_08_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_08_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_08_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_08_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_08_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_08_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_08_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_08_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_08_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年09月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_09_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_09_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_09_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_09_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_09_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_09_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_09_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_09_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_09_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_09_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年10月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_10_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_10_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_10_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_10_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_10_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_10_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_10_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_10_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_10_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_10_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年11月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_11_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_11_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_11_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_11_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_11_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_11_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_11_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_11_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_11_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_11_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (当年12月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setTounen_12_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setTounen_12_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_12_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_12_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_12_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setTounen_12_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setTounen_12_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setTounen_12_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_12_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setTounen_12_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        }
        edit中間DB(entity);
        entity.get中間DBEntity().setJikoFutan_KeisanYM(processParameter.getHandleTimestamp());
        tempDbWriter.insert(entity.get中間DBEntity());
    }

    private void edit中間DB(KogakugassanJikofutangakuInfoHoseiEntity entity) {
        if (翌年01月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_01_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_01_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_01_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_01_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_01_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_01_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_01_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_01_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_01_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_01_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年02月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_02_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_02_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_02_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_02_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_02_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_02_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_02_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_02_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_02_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_02_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年03月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_03_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_03_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_03_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_03_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_03_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_03_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_03_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_03_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_03_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_03_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年04月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_04_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_04_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_04_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_04_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_04_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_04_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_04_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_04_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_04_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_04_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年05月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_05_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_05_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_05_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_05_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_05_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_05_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_05_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_05_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_05_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_05_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年06月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_06_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_06_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_06_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_06_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_06_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_06_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_06_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_06_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_06_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_06_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        } else if (翌年07月.equals(entity.getDbt3071Entity().getTaishoM())) {
            entity.get中間DBEntity().setYokunen_07_JikoFutanGaku(entity.getDbt3071Entity().getJikoFutanGaku());
            entity.get中間DBEntity().setYokunen_07_Uchisu_70_74JikoFutanGaku(entity.getDbt3071Entity().getUchisu_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_07_Under_70KogakuShikyuGaku(entity.getDbt3071Entity().getUnder_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_07_Over_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getOver_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_07_Tekiyo(entity.getDbt3071Entity().getTekiyo());
            entity.get中間DBEntity().setYokunen_07_sumi_JikoFutanGaku(entity.getDbt3071Entity().getSumi_JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_07_sumi_70_74JikoFutanGaku(entity.getDbt3071Entity().getSumi_70_74JikoFutanGaku());
            entity.get中間DBEntity().setYokunen_07_sumi_under_70KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_under_70KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_07_sumi_70_74KogakuShikyuGaku(entity.getDbt3071Entity().getSumi_70_74KogakuShikyuGaku());
            entity.get中間DBEntity().setYokunen_07_sumi_Tekiyo(entity.getDbt3071Entity().getSumi_Tekiyo());
        }
    }
}
