/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.tekiyojogaisha.tekiyojogaisha;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.tekiyojogaisha.tekiyojogaisha.TekiyoJogaishaMapperParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dba.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
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
 * {@link ITekiyoJogaishaMapper}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ITekiyoJogaishaMapperTest {

    private static ITekiyoJogaishaMapper sut;
    private static DbT1002TekiyoJogaishaDac 適用除外者Dac;
    private static DbT1004ShisetsuNyutaishoDac 介護保険施設入退所Dac;
//    private static final 主キー型1 主キー11 = XXXEntityGenerator.DEFAULT_主キー1;
//    private static final 主キー型1 主キー12 = new 主キー型1();
//    private static final 主キー型2 主キー21 = XXXEntityGenerator.DEFAULT_主キー2;
//    private static final 主キー型2 主キー22 = new 主キー型2();

    @BeforeClass
    public static void setUpClass() {
        適用除外者Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
        介護保険施設入退所Dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

// TODO 検索条件に合わせてのテストケースを追記して下さい。
    public static class select適用除外者ByKeyTest extends DbaTestDacBase {

        @Before
        public void setUp() {
            sut = sqlSession.getMapper(ITekiyoJogaishaMapper.class);
//            TestSupport.insertDbT1002(主キー11, 主キー21);
//            TestSupport.insertDbT1002(主キー11, 主キー22);
//            TestSupport.insertDbT1002(主キー12, 主キー21);
//            TestSupport.insertDbT1002(主キー12, 主キー22);
//
//            TestSupport.insertDbT1004(主キー11, 主キー21);
//            TestSupport.insertDbT1004(主キー11, 主キー22);
//            TestSupport.insertDbT1004(主キー12, 主キー21);
//            TestSupport.insertDbT1004(主キー12, 主キー22);
        }

        // TODO 見つかる場合、適用除外者Entityを構成している全てのEntityクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_適用除外者Entity返す() {
            TekiyoJogaishaMapperParameter 適用除外者検索条件 = TekiyoJogaishaMapperParameter.createSelectByKeyParam(ShikibetsuCode.EMPTY, FlexibleDate.MAX, RString.EMPTY);
            assertThat(sut.select適用除外者ByKey(適用除外者検索条件), is(nullValue()));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            TekiyoJogaishaMapperParameter 適用除外者検索条件 = TekiyoJogaishaMapperParameter.createSelectByKeyParam(ShikibetsuCode.EMPTY, FlexibleDate.MAX, RString.EMPTY);
            assertThat(sut.select適用除外者ByKey(適用除外者検索条件), is(nullValue()));
        }
    }

//    private static class TestSupport {
//
//        public static void insertDbT1002(
//                主キー型1 主キー1,
//                主キー型2 主キー2) {
//            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
//            entity.set主キー型1(主キー1);
//            entity.set主キー型2(主キー2);
//            entity.setState(EntityDataState.Added);
//            適用除外者Dac.save(entity);
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
