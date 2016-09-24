/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.hekinriyogakutokehyo.HekinRiyoGakuTokehyoResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.heikinriyogakuyokeihyo.HeikinriyogakuTokeihyoProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.KyufujissekiTempTblEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufujissekidatatemptbl.ShikakutempTblEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 平均利用額統計表一時TBL作成のProcessフロークラスです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
public class HeikinriyogakuTokeihyoProcess extends BatchProcessBase<KyufujissekiTempTblEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.hekinriyogakutokehyo.IHekinRiyoGakuTokehyoMapper.get給付実績データ一時");
    private static final RString 給付実績データ一時TBL_NAME = new RString("DbWTkyufujisTempTbl");
    private static final RString 出力用一時TBL_NAME = new RString("DbWShikakutempTbl");

    private HeikinriyogakuTokeihyoProcessParameter paramter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 給付実績データ一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 出力用一時TBL;

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toHeikinriyogakuTokeihyoMybatisParameter());

    }

    @Override
    protected void createWriter() {
        給付実績データ一時TBL = new BatchEntityCreatedTempTableWriter(給付実績データ一時TBL_NAME,
                KyufujissekiTempTblEntity.class);
        出力用一時TBL = new BatchEntityCreatedTempTableWriter(出力用一時TBL_NAME,
                ShikakutempTblEntity.class);
    }

    @Override
    protected void process(KyufujissekiTempTblEntity entity) {
        HekinRiyoGakuTokehyoResult hekinRiyoGakuTokehyoResult = new HekinRiyoGakuTokehyoResult();
        給付実績データ一時TBL.insert(hekinRiyoGakuTokehyoResult.set給付実績データ一時TBL(entity));
    }

    @Override
    protected void afterExecute() {
        HekinRiyoGakuTokehyoResult hekinRiyoGakuTokehyoResult = new HekinRiyoGakuTokehyoResult();
        if (給付実績データ一時TBL.getInsertCount() > 0) {
            List<ShikakutempTblEntity> 一時EntityList = hekinRiyoGakuTokehyoResult.set総合計();
            for (ShikakutempTblEntity shikakutempTblEntity : 一時EntityList) {
                出力用一時TBL.insert(shikakutempTblEntity);
            }

        }
        List<ShikakutempTblEntity> 一時EntityList = hekinRiyoGakuTokehyoResult.set出力用一時TBL();
        for (ShikakutempTblEntity shikakutempTblEntity : 一時EntityList) {
            出力用一時TBL.insert(shikakutempTblEntity);
        }
    }
}
