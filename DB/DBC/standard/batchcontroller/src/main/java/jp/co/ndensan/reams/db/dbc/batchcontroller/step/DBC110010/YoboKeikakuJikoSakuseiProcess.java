/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC110010;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeikakujikosakuseikanri.KyotakuKeikakuJikosakuseiKanriResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kyufukanrihyoout.KyufukanrihyoOutProcessParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.HihokenshaTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KokuhorenSakuseiErrorTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.KyotakuKeikakuJikosakuseiKanriTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyufukanrihyoout.YoboKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票作成.予防給付計画自己作成情報の取得のクラスです。
 *
 * @reamsid_L DBC-2840-030 yaoyahui
 */
public class YoboKeikakuJikoSakuseiProcess extends BatchProcessBase<YoboKeikakuJikoSakuseiEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc110010.IKyufukanrihyoOutMapper.get予防給付計画自己作成情報の取得");
    private static final RString 自己作成管理一時_NAME = new RString("DbWT8211KyotakuKeikakuJikosakuseiKanri");
    private static final RString 被保険者一時TBL_NAME = new RString("DbWT1001Hihokensha");
    private static final RString 処理結果リスト一時TBL_NAME = new RString("DbWT1002KokuhorenSakuseiError");
    private KyufukanrihyoOutProcessParameter paramter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 自己作成管理一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 被保険者一時TBL;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 処理結果リスト一時TBL;
    private int 連番;
    private long 登録件数;
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
        登録件数 = 0;
        連番 = paramter.get連番() + 1;
        outCount = new OutputParameter<>();

    }

    @Override
    protected IBatchReader createReader() {

        return new BatchDbReader(MYBATIS_SELECT_ID, paramter.toKyufukanrihyoOutMybatisParameter(RString.EMPTY,
                RString.EMPTY, RString.EMPTY));

    }

    @Override
    protected void createWriter() {
        自己作成管理一時TBL = new BatchEntityCreatedTempTableWriter(自己作成管理一時_NAME,
                KyotakuKeikakuJikosakuseiKanriTempEntity.class);
        被保険者一時TBL = new BatchEntityCreatedTempTableWriter(被保険者一時TBL_NAME,
                HihokenshaTempEntity.class);
        処理結果リスト一時TBL = new BatchEntityCreatedTempTableWriter(処理結果リスト一時TBL_NAME,
                KokuhorenSakuseiErrorTempEntity.class);
    }

    @Override
    protected void process(YoboKeikakuJikoSakuseiEntity entity) {
        KyotakuKeikakuJikosakuseiKanriResult kyotakuKeikakuResult = new KyotakuKeikakuJikosakuseiKanriResult();

        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity 予防給付計画自己作成短期利用日数entity = entity.get予防給付計画自己作成短期利用日数entity();
        List<DbT3120YoboKeikakuJikoSakuseiKanriEntity> 予防給付計画自己作成管理entity = entity.get予防給付計画自己作成管理entity();
        for (DbT3120YoboKeikakuJikoSakuseiKanriEntity yoboKeikakuEntity : 予防給付計画自己作成管理entity) {
            自己作成管理一時TBL.insert(kyotakuKeikakuResult.edit居宅給付計画自己作成Entity2(予防給付計画自己作成短期利用日数entity,
                    yoboKeikakuEntity, 連番));
            被保険者一時TBL.insert(kyotakuKeikakuResult.edit被保険entity2(予防給付計画自己作成短期利用日数entity, yoboKeikakuEntity, 連番));
            連番++;
        }
    }

    @Override
    protected void afterExecute() {
        KyotakuKeikakuJikosakuseiKanriResult kyotakuKeikakuResult = new KyotakuKeikakuJikosakuseiKanriResult();
        if (連番 == 1) {

            登録件数 = 自己作成管理一時TBL.getInsertCount();
            if (登録件数 < 1) {
                処理結果リスト一時TBL.insert(kyotakuKeikakuResult.edit処理結果リスト一時TBL());
            }
        }
        outCount.setValue(連番);
    }
}
