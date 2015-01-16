/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbTKyufukanrihyoDataTempTableEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestDacBase;
import jp.co.ndensan.reams.ur.urz.batchservice.step.writer.BatchWriters;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process._BatchProcessChunkQueryExecutor;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * 給付管理票取込一時データエンティティのマッパークラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class KyufukanrihyoDataTempTableMapperTest extends DbcTestDacBase {

    private static KyufukanrihyoDataTempTableMapper sut;
    private static final RString 一時テーブル = new RString("KyufuKanrihyoTorikomiTemp");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyufukanrihyoDataTempTableMapper.class);
    }

    public static class getTempData extends DbcTestDacBase {

        @Test
        public void 一時データが2件のとき_getTempDataは2件のデータを返す() {
            createTempTable();
            List<DbTKyufukanrihyoDataTempTableEntity> result = sut.getTempData(new HashMap<String, Object>());
            assertThat(result.size(), is(2));
            assertThat(result.get(0).getRenban(), is(new RString("1")));
            assertThat(result.get(1).getRenban(), is(new RString("2")));
        }
    }

    private static void createTempTable() {
        IBatchTableWriter<DbTKyufukanrihyoDataTempTableEntity> writer
                = BatchWriters.batchEntityCreatedTempTableWriter(DbTKyufukanrihyoDataTempTableEntity.class)
                .tempTableName(一時テーブル)
                .build();
        _BatchProcessChunkQueryExecutor chunkQueryExecutor = new _BatchProcessChunkQueryExecutor(sqlSession);
        writer.setChunkQueryExecuter(sqlSession, chunkQueryExecutor);
        for (DbTKyufukanrihyoDataTempTableEntity entity : createTempDataList()) {
            writer.insert(entity);
        }
        chunkQueryExecutor.close();
    }

    private static List<DbTKyufukanrihyoDataTempTableEntity> createTempDataList() {
        List<DbTKyufukanrihyoDataTempTableEntity> entityList = new ArrayList<>();
        entityList.add(createTempData("2", "1"));
        entityList.add(createTempData("2", "2"));
        return entityList;
    }

    private static DbTKyufukanrihyoDataTempTableEntity createTempData(String レコード種別, String 連番) {
        DbTKyufukanrihyoDataTempTableEntity entity = new DbTKyufukanrihyoDataTempTableEntity();
        entity.setRecordShubetsu(new RString(レコード種別));
        entity.setRenban(new RString(連番));
        return entity;
    }
}
