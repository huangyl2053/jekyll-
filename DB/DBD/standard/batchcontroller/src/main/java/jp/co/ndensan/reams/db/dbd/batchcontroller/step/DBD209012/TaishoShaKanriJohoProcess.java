/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209012;

import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32004.TaishoShaKanriJohoProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbdbt32004.TaishoShaKanriJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.kyufugengakulist.temptable.TaishoshaJohoTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriterBuilders;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象者管理情報の取得_process処理クラスです。
 *
 * @reamsid_L DBD-3800-050 x_xuliang
 */
public class TaishoShaKanriJohoProcess extends BatchProcessBase<TaishoShaKanriJohoEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.kyufugakugengakukanririsutosakusei"
            + ".IKyufuGakuGengakuKanriRisutoSakuseiMapper.get対象者管理情報の取得");
    @BatchWriter
    private BatchEntityCreatedTempTableWriter tmpTableWriter;
    private TaishoShaKanriJohoProcessParameter processParameter;
    private RDate システム日付;

    @Override
    protected void initialize() {
        システム日付 = RDate.getNowDate();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH, processParameter.toTaishoShaKanriJohoProcessParameter(システム日付));
    }

    @Override
    protected void createWriter() {
        tmpTableWriter = BatchEntityCreatedTempTableWriterBuilders.createBuilder(TaishoshaJohoTempTableEntity.class)
                .tempTableName(TaishoshaJohoTempTableEntity.TABLE_NAME)
                .build();
    }

    @Override
    protected void process(TaishoShaKanriJohoEntity t) {
        TaishoshaJohoTempTableEntity insertEntity = create対象者情報一時テーブルを登録Entity(t);
        tmpTableWriter.insert(insertEntity);
    }

    private TaishoshaJohoTempTableEntity create対象者情報一時テーブルを登録Entity(TaishoShaKanriJohoEntity t) {
        TaishoshaJohoTempTableEntity data = new TaishoshaJohoTempTableEntity();
        data.setHihokenshaNo2(t.getHihokenshaNo());
        return data;

    }

}
