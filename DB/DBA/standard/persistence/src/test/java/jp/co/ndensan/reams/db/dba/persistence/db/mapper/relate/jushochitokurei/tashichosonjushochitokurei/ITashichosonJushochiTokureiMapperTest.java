/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.jushochitokurei.tashichosonjushochitokurei;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.jushochitokurei.tashichosonjushochitokurei.TashichosonJushochiTokureiMapperParameter;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1003TashichosonJushochiTokureiDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ITashichosonJushochiTokureiMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ITashichosonJushochiTokureiMapperTest {
    
    private static ITashichosonJushochiTokureiMapper sut;
    private static DbT1003TashichosonJushochiTokureiDac 他市町村住所地特例Dac;
    private static DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Dac;
    // TODO 主キー型と変数名と主キー値を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
//    private static final 主キー型1 主キー11 = XXXEntityGenerator.DEFAULT_主キー1;
//    private static final 主キー型1 主キー12 = new 主キー型1();
//    private static final 主キー型2 主キー21 = XXXEntityGenerator.DEFAULT_主キー2;
//    private static final 主キー型2 主キー22 = new 主キー型2();

    @BeforeClass
    public static void setUpClass() {
        他市町村住所地特例Dac = InstanceProvider.create(DbT1003TashichosonJushochiTokureiDac.class);
        介護保険施設入退所Dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select他市町村住所地特例ByKeyTest extends DbaTestDacBase {
        
        @Before
        public void setUp() {
            sut = sqlSession.getMapper(ITashichosonJushochiTokureiMapper.class);
//            TestSupport.insertDbT1003(主キー11, 主キー21);
//            TestSupport.insertDbT1003(主キー11, 主キー22);
//            TestSupport.insertDbT1003(主キー12, 主キー21);
//            TestSupport.insertDbT1003(主キー12, 主キー22);
//
//            TestSupport.insertDbT1004(主キー11, 主キー21);
//            TestSupport.insertDbT1004(主キー11, 主キー22);
//            TestSupport.insertDbT1004(主キー12, 主キー21);
//            TestSupport.insertDbT1004(主キー12, 主キー22);
        }

        // TODO 見つかる場合、他市町村住所地特例Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_他市町村住所地特例Entity返す() {
            TashichosonJushochiTokureiMapperParameter 他市町村住所地特例検索条件 = TashichosonJushochiTokureiMapperParameter.createSelectByKeyParam(ShikibetsuCode.EMPTY, FlexibleDate.MAX, RString.EMPTY);
            assertThat(sut.select他市町村住所地特例ByKey(他市町村住所地特例検索条件), is(nullValue()));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            TashichosonJushochiTokureiMapperParameter 他市町村住所地特例検索条件 = TashichosonJushochiTokureiMapperParameter.createSelectByKeyParam(ShikibetsuCode.EMPTY, FlexibleDate.MAX, RString.EMPTY);
            assertThat(sut.select他市町村住所地特例ByKey(他市町村住所地特例検索条件), is(nullValue()));
        }
    }

//    private static class TestSupport {
//        public static void insertDbT1003(
//                主キー型1 主キー1,
//                主キー型2 主キー2) {
//            DbT1003TashichosonJushochiTokureiEntity entity = DbT1003TashichosonJushochiTokureiEntityGenerator.createDbT1003TashichosonJushochiTokureiEntity();
//            entity.set主キー型1(主キー1);
//            entity.set主キー型2(主キー2);
//            entity.setState(EntityDataState.Added);
//            他市町村住所地特例Dac.save(entity);
//        }
//
//        public static void insertDbT1004(
//                主キー型1 主キー1,
//                主キー型2 主キー2) {
//            DbT1004ShisetsuNyutaishoEntity entity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
//            entity.set主キー型1(主キー1);
//            entity.set主キー型2(主キー2);
//            entity.setState(EntityDataState.Added);
//            介護保険施設入退所Dac.save(entity);
//        }
//    }
}
