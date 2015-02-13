/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.step;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbc.persistence.mappers.KyufukanrihyoDataTempTableMapper;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.ur.urz.batchservice.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process._BatchProcessChunkQueryExecutor;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.BatchProcessTestHelper;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 給付管理票取込の編集用情報取得処理クラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufuKanrihyoInBatchRegistGetEditInfoProcessTest extends DbcTestDacBase {

    private static final RString 一時テーブル = new RString("DbTKyufukanrihyoDataTempTable");

    public static class ProcessTest extends DbcTestDacBase {

        @Test
        public void 編集用情報の取得処理が正常終了すること() {

            createTempTable();
            BatchProcessTestHelper.execute(KyufuKanrihyoInBatchRegistGetEditInfoProcess.class, new HashMap<RString, Object>(), sqlSession);

            KyufukanrihyoDataTempTableMapper sut = InstanceProvider.create(KyufukanrihyoDataTempTableMapper.class);
            List<DbTKyufukanrihyoDataTempTableEntity> entityList = sut.getTempData(new HashMap<String, Object>());

            assertThat(entityList.size(), is(2));
        }
    }

    private static void createTempTable() {
        IBatchTableWriter<DbTKyufukanrihyoDataTempTableEntity> writer
                = BatchWriters.batchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.class)
                .tempTableName(一時テーブル)
                .build();
        _BatchProcessChunkQueryExecutor chunkQueryExecutor = new _BatchProcessChunkQueryExecutor(sqlSession);
        //UZのインターフェースからメソッドが消えている模様。
//        writer.setChunkQueryExecuter(sqlSession, chunkQueryExecutor);
        for (DbTKyufukanrihyoDataTempTableEntity entity : createTempDataList()) {
            writer.insert(entity);
        }
        chunkQueryExecutor.close();
    }

    private static List<DbTKyufukanrihyoDataTempTableEntity> createTempDataList() {
        List<DbTKyufukanrihyoDataTempTableEntity> entityList = new ArrayList<>();
        entityList.add(createTempData("1"));
        entityList.add(createTempData("2"));
        return entityList;
    }

    private static DbTKyufukanrihyoDataTempTableEntity createTempData(String 連番) {
        DbTKyufukanrihyoDataTempTableEntity entity = new DbTKyufukanrihyoDataTempTableEntity();
        entity.setRecordShubetsu(new RString("2"));
        entity.setRenban(new RString(連番));
        entity.setKyufukanrihyoMeisaigyoNo(new RString("99"));
        return entity;
    }
}
