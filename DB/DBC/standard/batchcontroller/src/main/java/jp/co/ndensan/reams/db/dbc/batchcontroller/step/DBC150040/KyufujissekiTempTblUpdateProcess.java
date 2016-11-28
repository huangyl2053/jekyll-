/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.SyorikekkatempTblEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付実績データ一時TBL更新
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
public class KyufujissekiTempTblUpdateProcess extends BatchProcessBase<KyufujissekiTempTblEntity> {

    private static final RString 給付実績データ取得SQL = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper.get給付実績データ一時に更新");
    private static final RString 給付実績データ一時TBL_NAME = new RString("DbWTkyufujisTempTbl");
    private static final RString 出力用一時TBL_NAME = new RString("DbWShikakutempTbl");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績データ一時TBL;
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1504ShoriKekkaKakuninList");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 出力用一時TBL;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(給付実績データ取得SQL);
    }

    @Override
    protected void createWriter() {
        給付実績データ一時TBL = new BatchEntityCreatedTempTableWriter(給付実績データ一時TBL_NAME,
                KyufujissekiTempTblEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                SyorikekkatempTblEntity.class);
        出力用一時TBL = new BatchEntityCreatedTempTableWriter(出力用一時TBL_NAME,
                ShikakutempTblEntity.class);
    }

    @Override
    protected void process(KyufujissekiTempTblEntity entity) {
        if (!RString.isNullOrEmpty(entity.getHokenryoDankai2())) {
            entity.setShotoku(entity.getHokenryoDankai2().substring(0, 2));
        } else if (RString.isNullOrEmpty(entity.getHokenryoDankai2()) && !RString.isNullOrEmpty(entity.getHokenryoDankai1())) {
            entity.setShotoku(entity.getHokenryoDankai1().substring(0, 2));
        } else if (RString.isNullOrEmpty(entity.getHokenryoDankai2()) && RString.isNullOrEmpty(entity.getHokenryoDankai1())) {
            entity.setShotoku(RString.EMPTY);
        }
        給付実績データ一時TBL.update(entity);
    }
}
