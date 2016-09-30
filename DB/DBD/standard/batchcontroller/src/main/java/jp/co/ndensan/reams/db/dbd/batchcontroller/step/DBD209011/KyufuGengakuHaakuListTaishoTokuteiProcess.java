/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.KyufuGengakuHaakuListTaishoTokuteiProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.KyufuGengakuHaakuListTaishoTokuteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;
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
 * @reamsid_L DBD-3610-030 x_miaocl
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
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TaishoshaJohoTempTableEntity.class)
                .tempTableName(TaishoshaJohoTempTableEntity.TABLE_NAME).build();
    }

    @Override
    protected void process(KyufuGengakuHaakuListTaishoTokuteiEntity tmpTblEntity) {
        tmpTableWriter.insert(edit対象者(tmpTblEntity));
    }

    private TaishoshaJohoTempTableEntity edit対象者(KyufuGengakuHaakuListTaishoTokuteiEntity tmpTblEntity) {
        TaishoshaJohoTempTableEntity insertEntity = new TaishoshaJohoTempTableEntity();
        insertEntity.setHihokenshaNo2(tmpTblEntity.getHihokenshaNo());
        return insertEntity;
    }
}
