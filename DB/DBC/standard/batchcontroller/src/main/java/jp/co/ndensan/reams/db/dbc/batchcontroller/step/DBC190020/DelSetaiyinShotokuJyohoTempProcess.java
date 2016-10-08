/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyoshafutanwariaihantei.temptables.SetaiShotokuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji.IKijunsyunyunenjiMapper;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 基準収入額適用申請書_年次分作成の世帯員所得情報一時テーブルに登録 クラスです
 *
 * @reamsid_L DBC-4630-060 jiangwenkai
 */
public class DelSetaiyinShotokuJyohoTempProcess extends BatchProcessBase<SetaiShotokuEntity> {

    private static final RString TABLE_NAME = new RString("TmpSetaiShotoku");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.delete世帯員所得情報一時テーブル");
    private static final int INT_0 = 0;
    private int i = 0;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter setaiShotokuTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);
    }

    @Override
    protected void createWriter() {
        this.setaiShotokuTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, SetaiShotokuEntity.class);
    }

    @Override
    protected void process(SetaiShotokuEntity entity) {
        if (INT_0 == i) {
            getMapper(IKijunsyunyunenjiMapper.class).deleteAll世帯員所得情報一時テーブル();
        }
        setaiShotokuTableWriter.insert(entity);
        i++;
    }

    @Override
    protected void afterExecute() {

    }

}
