/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100202;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.ShimeiKanaTotsugoKensuJohoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100202.temptable.ShimeiKanaTotsugoKensuTempTableEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 氏名カナ突合結果件数一時_process処理クラスです。
 *
 * @reamsid_L DBD-4910-040 x_lilh
 */
public class ShimeiKanaTotsugoKensuProcess extends BatchProcessBase<ShimeiKanaTotsugoKensuJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper."
            + "relate.hikazenenkintaishoshadoutei.IShimeiKanaTotsugoMapper.get氏名カナ突合結果件数一時");

    @BatchWriter
    BatchEntityCreatedTempTableWriter shimeiKanaTotsugoKensuTemp;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID);
    }

    @Override
    protected void createWriter() {
        shimeiKanaTotsugoKensuTemp = new BatchEntityCreatedTempTableWriter(ShimeiKanaTotsugoKensuTempTableEntity.TABLE_NAME,
                ShimeiKanaTotsugoKensuTempTableEntity.class);
    }

    @Override
    protected void process(ShimeiKanaTotsugoKensuJohoEntity entity) {
        ShimeiKanaTotsugoKensuTempTableEntity items = setShimeiKanaTotsugoKensuTempTableEntity(entity);

        shimeiKanaTotsugoKensuTemp.insert(items);
    }

    private ShimeiKanaTotsugoKensuTempTableEntity setShimeiKanaTotsugoKensuTempTableEntity(ShimeiKanaTotsugoKensuJohoEntity entity) {
        ShimeiKanaTotsugoKensuTempTableEntity tempTable = new ShimeiKanaTotsugoKensuTempTableEntity();
        if (entity.getDt年金保険者コード() == null || entity.getDt年金保険者コード().isEmpty()) {
            tempTable.setDtNennkinnHokenshaCode(RString.EMPTY);
        } else {
            tempTable.setDtNennkinnHokenshaCode(entity.getDt年金保険者コード());
        }
        if (entity.getDt年金コード() == null || entity.getDt年金コード().isEmpty()) {
            tempTable.setDtNennkinnCode(RString.EMPTY);
        } else {
            tempTable.setDtNennkinnCode(entity.getDt年金コード());
        }
        if (entity.getDt基礎年金番号() == null || entity.getDt基礎年金番号().isEmpty()) {
            tempTable.setDtKisoNennkinnNo(RString.EMPTY);
        } else {
            tempTable.setDtKisoNennkinnNo(entity.getDt基礎年金番号());
        }
        if (entity.getDt対象年() == null || entity.getDt対象年().isEmpty()) {
            tempTable.setDtTaisyoYear(RString.EMPTY);
        } else {
            tempTable.setDtTaisyoYear(entity.getDt対象年());
        }
        if (entity.getDt作成年月日() == null || entity.getDt作成年月日().isEmpty()) {
            tempTable.setDtCreateYMD(FlexibleDate.EMPTY);
        } else {
            tempTable.setDtCreateYMD(entity.getDt作成年月日());
        }
        if (entity.get件数() == 0) {
            tempTable.setCount(0);
        } else {
            tempTable.setCount(entity.get件数());
        }
        return tempTable;
    }
}
