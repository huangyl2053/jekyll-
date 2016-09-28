/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.batchcontroller.step.DBB002001;

import jp.co.ndensan.reams.db.dbz.definition.processprm.DBB002001.SetaiShotokuKazeiHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiHaakuResultEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.fuka.SetaiShotokuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員（住民）の把握_住所地特例該当が１以外クラスです。
 *
 * @reamsid_L DBB-0640-010 chenaoqi
 */
public class InsSetaiinHaakuTmp2Process extends BatchProcessBase<SetaiHaakuResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.fuka."
            + "ISetaiShotokuKazeiHanteiMapper.select世帯員把握入力");

    @BatchWriter
    BatchEntityCreatedTempTableWriter tableWriter;
    private SetaiShotokuKazeiHanteiProcessParameter parameter;

    private static final RString TABLE_NAME = new RString("TmpSetaiShotoku");

    @Override
    protected void createWriter() {
        tableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME,
                SetaiShotokuEntity.class);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, parameter.toSetaiShotokuKazeiHanteiMybatisParameter());
    }

    @Override
    protected void process(SetaiHaakuResultEntity entity) {
        tableWriter.insert(entity.to世帯員所得情報(entity));
    }

}
