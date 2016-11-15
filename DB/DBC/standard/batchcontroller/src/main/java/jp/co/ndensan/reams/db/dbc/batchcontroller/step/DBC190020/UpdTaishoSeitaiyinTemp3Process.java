/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC190020;

import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.DbT4001Entity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.TaishoSetaiinEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.kijunsyunyunenji.UpdTaishoSeitaiyinTemp3Entity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbColumnMappable;

/**
 * 対象世帯員クラスTempに更新3のバッチ処理フロークラスです
 *
 * @reamsid_L DBC-4630-050 jiangwenkai
 */
public class UpdTaishoSeitaiyinTemp3Process extends BatchProcessBase<UpdTaishoSeitaiyinTemp3Entity> {

    private static final RString TABLE_NAME = new RString("TaishoSetaiin");
    private static final RString RSTRING_1 = new RString("1");
    private static final RString READ_DATA_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.kijunsyunyunenji."
            + "IKijunsyunyunenjiMapper.対象世帯員クラスTempに更新3");
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
    protected void process(UpdTaishoSeitaiyinTemp3Entity entity) {
        TaishoSetaiinEntity 対象世帯員 = entity.get対象世帯員();
        DbT4001Entity 受給者台帳 = entity.get受給者台帳();
        対象世帯員.setJukyuKubun(RSTRING_1);
        対象世帯員.setNijiHanteiYokaigoJotaiKubunCode(getColumnValue(受給者台帳.get要介護認定状態区分コード()));
        対象世帯員.setNinteiYukoKikanKaishiYMD(受給者台帳.get認定有効期間開始年月日());
        対象世帯員.setNinteiYukoKikanShuryoYMD(受給者台帳.get認定有効期間終了年月日());
        this.taiShoTableWriter.update(対象世帯員);
    }

    private RString getColumnValue(IDbColumnMappable entity) {
        if (null != entity) {
            return entity.getColumnValue();
        }
        return RString.EMPTY;
    }

}
