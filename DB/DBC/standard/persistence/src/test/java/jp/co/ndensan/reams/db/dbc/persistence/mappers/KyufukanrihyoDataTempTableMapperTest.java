/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.mappers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
    private static final RString 一時テーブル = new RString("DbTKyufukanrihyoInData_TempTable");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyufukanrihyoDataTempTableMapper.class);
    }

    public static class update extends DbcTestDacBase {

        @Test
        public void 一時データのupdateが正常終了すること() {
            createTempTable();
            Map<String, Object> param = new HashMap<>();
            sut.updateHihoNoHenkanShichosonCode1(param);
            sut.updateHihoNoHenkanShichosonCode2(param);
            sut.updateHihoNoHenkanShichosonCode3(param);
            sut.updateHihoNoHenkanShichosonCode4(param);
            sut.updateShinHihokenshaNo1(param);
            sut.updateShinHihokenshaNo2(param);
            sut.updateJigyoshoMeisho1(param);
            sut.updateJigyoshoMeisho2(param);
            sut.updateShikibetsuCode1(param);
            sut.updateShikibetsuCode2(param);
            sut.updateKanjiMeisho(param);
            sut.updateShichosonCode1(param);
            sut.updateShichosonCode2(param);
        }
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
