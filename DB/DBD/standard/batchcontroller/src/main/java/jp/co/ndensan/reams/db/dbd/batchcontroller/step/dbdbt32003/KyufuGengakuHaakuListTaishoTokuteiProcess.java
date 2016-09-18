/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.KyufuGengakuHaakuListTaishoTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListTaishoTokuteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.DuixiangZheTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者把握情報の取得_Process処理クラスです．
 *
 * @author x_miaocl
 */
public class KyufuGengakuHaakuListTaishoTokuteiProcess extends BatchProcessBase<KyufuGengakuHaakuListTaishoTokuteiEntity> {

    private KyufuGengakuHaakuListTaishoTokuteiProcessParameter parameter;
    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugengakulist."
                    + "IKyufuGengakuHaakuListTaishoTokuteiMapper.get対象者把握情報");

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toKyufuGengakuHaakuListTaishoTokuteiMybatisParameter(
                parameter.get基準日(),
                parameter.get時効起算日登録者の選択(),
                parameter.get被保険者選択(),
                parameter.get受給者全員(),
                parameter.get受給認定申請中者(),
                parameter.get受給認定日抽出(),
                parameter.get受給認定日抽出の開始(),
                parameter.get受給認定日抽出の終了(),
                parameter.get認定有効終日抽出(),
                parameter.get認定有効終日抽出の開始(),
                parameter.get認定有効終日抽出の終了(),
                parameter.get保険料完納者も出力()));
    }
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(DuixiangZheTempTableEntity.class)
                .tempTableName(DuixiangZheTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(KyufuGengakuHaakuListTaishoTokuteiEntity t) {
        tmpTableWriter.insert(create重複処理(t));
    }

    private DuixiangZheTempTableEntity create重複処理(KyufuGengakuHaakuListTaishoTokuteiEntity entity) {
        DuixiangZheTempTableEntity daTableEntity = new DuixiangZheTempTableEntity();
        daTableEntity.setHihokenshaNo2(entity.getHihokenshaNo());
        return daTableEntity;
    }
}
