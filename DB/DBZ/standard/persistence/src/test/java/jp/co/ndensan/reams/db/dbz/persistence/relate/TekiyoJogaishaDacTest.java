/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1002TekiyoJogaishaEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1002TekiyoJogaishaDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link DbT1002TekiyoJogaishaEntityDac}のテストクラスです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class TekiyoJogaishaDacTest {

    private static TekiyoJogaishaDac sut;
    private static DbT1002TekiyoJogaishaDac 適用除外者Dac;
    private static final LasdecCode 市町村コード1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_市町村コード;
    private static final ShikibetsuCode 識別コード1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("012012012012012");
    private static final FlexibleDate 異動日1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_異動日;
    private static final FlexibleDate 異動日2 = new FlexibleDate("20150808");
    private static final RString 枝番1 = DbT1002TekiyoJogaishaEntityGenerator.DEFAULT_枝番;
    private static final RString 枝番2 = new RString("002");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(TekiyoJogaishaDac.class);
        適用除外者Dac = InstanceProvider.create(DbT1002TekiyoJogaishaDac.class);
    }

    public static class select適用除外者ModelByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1002(識別コード1, 異動日1, 枝番1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select適用除外者ModelByKey(null, 異動日1, 枝番1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select適用除外者ModelByKey(識別コード1, null, 枝番1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の異動日にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select適用除外者ModelByKey(識別コード1, 異動日1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_適用除外者Modelモデル返す() {
            DbT1002TekiyoJogaishaEntity result = sut.select適用除外者ModelByKey(識別コード1, 異動日1, 枝番1);
            assertThat(result.getShikibetsuCode(), is(識別コード1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            DbT1002TekiyoJogaishaEntity result = sut.select適用除外者ModelByKey(識別コード2, 異動日2, 枝番2);
            assertThat(result, is(nullValue()));
        }
    }

    public static class select適用除外者List extends DbzTestDacBase {

        private FlexibleDate 適用日20141231;
        private FlexibleDate 適用日20140612;
        private FlexibleDate 適用日20131109;

        @Before
        public void setUp() {
            適用日20141231 = new FlexibleDate("20141231");
            適用日20140612 = new FlexibleDate("20140612");
            適用日20131109 = new FlexibleDate("20131109");

            TestSupport.insertDbT1002(識別コード1, 異動日1, 枝番1);
            TestSupport.insertDbT1002(識別コード2, 異動日2, 枝番2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select適用除外者List(null, 識別コード1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select適用除外者List(市町村コード1, null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            List<DbT1002TekiyoJogaishaEntity> result = sut.select適用除外者List(市町村コード1, 識別コード1);
            assertThat(result.size(), is(3));
            assertThat(result.get(0).getShichosonCode(), is(市町村コード1));
            assertThat(result.get(0).getShikibetsuCode(), is(識別コード1));
            assertThat(result.get(1).getShichosonCode(), is(市町村コード1));
            assertThat(result.get(1).getShikibetsuCode(), is(識別コード1));
            assertThat(result.get(2).getShichosonCode(), is(市町村コード1));
            assertThat(result.get(2).getShikibetsuCode(), is(識別コード1));
        }

        @Test
        public void 検索結果は適用日の降順によってソートされ_順番は2番目_1番目_3番目の順になる() {
            List<DbT1002TekiyoJogaishaEntity> result = sut.select適用除外者List(市町村コード1, 識別コード1);
            assertThat(result.get(0).getTekiyoYMD(), is(適用日20141231));
            assertThat(result.get(1).getTekiyoYMD(), is(適用日20140612));
            assertThat(result.get(2).getTekiyoYMD(), is(適用日20131109));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            List<DbT1002TekiyoJogaishaEntity> result = sut.select適用除外者List(市町村コード1, 識別コード2);
            assertThat(result.isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つDbT1002TekiyoJogaishaEntityモデルを渡した時_insertは_1を返す() {
            DbT1002TekiyoJogaishaEntity model = new DbT1002TekiyoJogaishaEntity();

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            DbT1002TekiyoJogaishaEntity model = new DbT1002TekiyoJogaishaEntity();

            sut.insert(model);

            model.getOriginMd5();
            model.setIsDeleted(false);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つDbT1002TekiyoJogaishaEntityモデルを渡した時_deleteは_1を返す() {
            DbT1002TekiyoJogaishaEntity model = new DbT1002TekiyoJogaishaEntity();

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        @Test
        public void 全ての有効なモデルを持つDbT1002TekiyoJogaishaEntityモデルを渡した時_deletePhysicalは_1を返す() {
            DbT1002TekiyoJogaishaEntity model = new DbT1002TekiyoJogaishaEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    // TODO 主キー型と変数名を適切な値に置換してください
    // TODO 主キーの数が足りない場合、追加してください。
    private static class TestSupport {

        public static void insertDbT1002(
                ShikibetsuCode 識別コード,
                FlexibleDate 異動日,
                RString 枝番) {
            DbT1002TekiyoJogaishaEntity entity = DbT1002TekiyoJogaishaEntityGenerator.createDbT1002TekiyoJogaishaEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setIdoYMD(異動日);
            entity.setEdaNo(枝番);
            適用除外者Dac.save(entity);
        }
    }

}
