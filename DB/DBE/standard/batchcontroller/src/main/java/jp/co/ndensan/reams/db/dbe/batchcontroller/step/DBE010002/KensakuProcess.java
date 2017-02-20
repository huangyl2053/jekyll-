/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE010002;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinseishadataout.ShinseishaDataOutProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseikensaku.ShinseiKensakuRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseishadataout.OutputTaishoTempEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 検索プロセスです。
 *
 * @author N3212 竹内 和紀
 */
public class KensakuProcess extends BatchProcessBase<ShinseiKensakuRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseikensaku."
            + "IShinseiKensakuMapper.selectShinseiJoho_noLimit");

    @BatchWriter
    private BatchEntityCreatedTempTableWriter<OutputTaishoTempEntity> tempTableWriter;
    private ShinseishaDataOutProcessParameter processParameter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParameter.get検索条件());
    }

    @Override
    protected void createWriter() {
        tempTableWriter = new BatchEntityCreatedTempTableWriter(OutputTaishoTempEntity.TABLE_NAME, OutputTaishoTempEntity.class);
    }

    @Override
    protected void process(ShinseiKensakuRelateEntity entity) {
        OutputTaishoTempEntity tempEntity = new OutputTaishoTempEntity();
        tempEntity.setShinseishoKanriNo(entity.getShinseishoKanriNo().value());
        tempTableWriter.insert(tempEntity);
    }
}
