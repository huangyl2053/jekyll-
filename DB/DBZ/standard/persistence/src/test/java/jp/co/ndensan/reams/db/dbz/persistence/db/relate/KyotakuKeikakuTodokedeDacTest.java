/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuTodokedeDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@Ignore
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeDacTest {

    private static KyotakuKeikakuTodokedeDac sut;
    private static DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac;
    private static final HihokenshaNo 被保険者番号1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("987654");
    private static final FlexibleYearMonth 対象年月1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
    private static final FlexibleYearMonth 対象年月2 = new FlexibleDate("20141201").getYearMonth();
    private static final Decimal 履歴番号1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_履歴番号;
    private static final Decimal 履歴番号2 = new Decimal(2);

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyotakuKeikakuTodokedeDac.class);
        居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT3005(被保険者番号1, 対象年月1, 履歴番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 対象年月1, 履歴番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の対象年月にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(被保険者番号1, null, 履歴番号1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の履歴番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(被保険者番号1, 対象年月1, null);
        }

        // TODO 見つかる場合、居宅給付計画届出モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画届出モデル返す() {
            assertThat(sut.selectByKey(被保険者番号1, 対象年月1, 履歴番号1).get().getHihokenshaNo(), is(被保険者番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.selectByKey(被保険者番号1, 対象年月1, 履歴番号1).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT3005(被保険者番号1, 対象年月1, 履歴番号1);
            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select居宅給付計画届出一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT3005(被保険者番号1, 対象年月1, 履歴番号1);
            TestSupport.insertDbT3005(被保険者番号2, 対象年月2, 履歴番号2);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select居宅給付計画届出一覧By被保険者番号(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            IItemList<DbT3005KyotakuKeikakuTodokedeEntity> modelList = sut.select居宅給付計画届出一覧By被保険者番号(被保険者番号1);
            assertThat(modelList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(被保険者番号1));
            assertThat(modelList.toList().get(1).getHihokenshaNo(), is(被保険者番号2));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select居宅給付計画届出一覧By被保険者番号(被保険者番号2).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO KyotakuKeikakuTodokedeModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つKyotakuKeikakuTodokedeRelateモデルを渡した時_insertは_1を返す() {
            DbT3005KyotakuKeikakuTodokedeEntity model = new DbT3005KyotakuKeikakuTodokedeEntity();

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO KyotakuKeikakuTodokedeModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            DbT3005KyotakuKeikakuTodokedeEntity model = new DbT3005KyotakuKeikakuTodokedeEntity();

            sut.insert(model);

            model.initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.setIsDeleted(false);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO KyotakuKeikakuTodokedeModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つKyotakuKeikakuTodokedeRelateモデルを渡した時_deleteは_1を返す() {
            DbT3005KyotakuKeikakuTodokedeEntity model = new DbT3005KyotakuKeikakuTodokedeEntity();

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO KyotakuKeikakuTodokedeModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つKyotakuKeikakuTodokedeRelateモデルを渡した時_deletePhysicalは_1を返す() {
            DbT3005KyotakuKeikakuTodokedeEntity model = new DbT3005KyotakuKeikakuTodokedeEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT3005(HihokenshaNo 被保険者番号,
                FlexibleYearMonth 対象年月,
                Decimal 履歴番号) {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setTaishoYM(対象年月);
            entity.setRirekiNo(履歴番号);
            居宅給付計画届出Dac.save(entity);
        }
    }

}
