/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeikakujikosakuseikanri.KyotakuKeikakuJikosakuseiKanriResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3119KyotakuKeikakuJikosakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成.送付対象データ取得のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class KyotakuKeikakuJikosakuseiKanriProcess extends BatchProcessBase<KyotakuKeikakuJikosakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper.get居宅給付計画自己作成情報の取得");
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");

    private KyufukanrihyoOutProcessParameter paramter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;

    private int count = 0;
    private OutputParameter<Integer> outCount;
    /**
     * 送付対象データ取得件数合計です。
     */
    public static final RString PARAMETER_OUT_OUTCOUNT;

    static {
        PARAMETER_OUT_OUTCOUNT = new RString("outCount");
    }

    @Override
    protected void initialize() {

        outCount = new OutputParameter<>();

    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toKyufukanrihyoOutMybatisParameter(RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY));

    }

    @Override
    protected void createWriter() {
        自己作成管理一時TBL = new BatchEntityCreatedTempTableWriter(自己作成管理一時_NAME,
                KyotakuKeikakuJikosakuseiKanriTempEntity.class);
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
    }

    @Override
    protected void process(KyotakuKeikakuJikosakuseiEntity entity) {
        KyotakuKeikakuJikosakuseiKanriResult result = new KyotakuKeikakuJikosakuseiKanriResult();
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity 居宅給付計利用日数entity = entity.get居宅給付計画自己作成短期入所利用日数entity();
        List<DbT3119KyotakuKeikakuJikosakuseiKanriEntity> 居宅給付計画自己作成管理entity = entity.get居宅給付計画自己作成管理entity();
        for (DbT3119KyotakuKeikakuJikosakuseiKanriEntity kyotakuKeikakuTempEntity : 居宅給付計画自己作成管理entity) {
            自己作成管理一時TBL.insert(result.edit居宅給付計画自己作成管理Entity1(
                    居宅給付計利用日数entity, kyotakuKeikakuTempEntity, count));
            被保険者一時TBL.insert(result.edit被保険者entity1(居宅給付計利用日数entity,
                    kyotakuKeikakuTempEntity, count));
            count++;
        }
    }

    @Override
    protected void afterExecute() {
        outCount.setValue(count);
    }
}
