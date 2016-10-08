/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.DbT3100Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp2Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象世帯員クラスTempに更新2のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
public class UpdTaishoSeitaiyinTemp2Process extends BatchProcessBase<UpdTaishoSeitaiyinTemp2Entity> {

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString RSTRING_2 = new RString("2");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに更新2");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter taiShoTableWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(READ_DATA_ID);

    }

    @Override
    protected void createWriter() {
        this.taiShoTableWriter = new BatchEntityCreatedTempTableWriter(TABLE_NAME, TaishoSetaiinEntity.class);

    }

    @Override
    protected void process(UpdTaishoSeitaiyinTemp2Entity entity) {
        TaishoSetaiinEntity 対象世帯員 = entity.get対象世帯員();
        DbT3100Entity 事業対象者 = entity.get事業対象者();
        対象世帯員.setJukyuKubun(RSTRING_2);
        対象世帯員.setTekiyoKaishiYMD(事業対象者.get適用開始年月日());
        対象世帯員.setTekiyoShuryoYMD(事業対象者.get適用終了年月日());
        this.taiShoTableWriter.update(対象世帯員);
    }

    @Override
    protected void afterExecute() {

    }

}
