/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc020010;

import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakukaigoservicehikyufutaishoshatoroku.KyufuJissekiKihonKogakuProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3Entity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakukaigokyufuhitaishoshatoroku.TempSetaiinShotokuHanteiEntity;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員所得判定明細高額一時の作成３プロセスのクラスです。
 *
 * @reamsid_L DBC-2010-040 zhouchuanlin
 */
public class InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3 extends BatchProcessBase<InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3Entity> {

    private static final RString MYBATIS_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "kogakukaigoservicehikyufutaishoshatoroku.IKogakuKaigoServicehiKyufugakuSanshutsuMapper."
            + "select世帯員所得判定明細高額一時２と宛名情報");
    private static final RString TABLE_世帯員所得判定明細高額一時3 = new RString("TempSetaiinShotokuHantei3");
    private KyufuJissekiKihonKogakuProcessParameter processParameter;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter setaiinShotokuHantei3Writer;

    @Override
    protected void initialize() {
    }

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_ID, processParameter.toMybatisParameter());
    }

    @Override
    protected void createWriter() {
        setaiinShotokuHantei3Writer = new BatchEntityCreatedTempTableWriter(
                TABLE_世帯員所得判定明細高額一時3, TempSetaiinShotokuHanteiEntity.class);
    }

    @Override
    protected void process(InsSetaiinShotokuHanteiMeisaiKogakuTmpProcess3Entity entity) {
        TempSetaiinShotokuHanteiEntity 世帯員所得判定明細高額一時Entity = entity.get世帯員所得判定明細高額一時Entity();
        UaFt200FindShikibetsuTaishoEntity 宛名 = entity.get宛名();
        世帯員所得判定明細高額一時Entity.setAtena_tsuzukigaraCode(宛名.getTsuzukigaraCode());
        世帯員所得判定明細高額一時Entity.setAtena_juminShubetsuCode(宛名.getJuminShubetsuCode());
        世帯員所得判定明細高額一時Entity.setAtena_seinengappiYMD(宛名.getSeinengappiYMD());
        setaiinShotokuHantei3Writer.insert(世帯員所得判定明細高額一時Entity);
    }
}
