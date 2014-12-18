/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3005KyotakuKeikakuTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuTodokedeModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KyotakuKeikakuTodokedeDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class KyotakuKeikakuTodokedeDacTest {

    private static KyotakuKeikakuTodokedeDac sut;
    private static DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac;
    private static final HihokenshaNo 被保険者番号1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("1234567890");
    private static final HokenshaNo 証記載保険者番号1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_証記載保険者番号;
    private static final HokenshaNo 証記載保険者番号2 = new HokenshaNo("123456");
    private static final ShikibetsuCode 識別コード1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_識別コード;
    private static final ShikibetsuCode 識別コード2 = new ShikibetsuCode("123456789012345");
    private static final FlexibleYearMonth 対象年月1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_対象年月;
    private static final FlexibleYearMonth 対象年月2 = FlexibleYearMonth.EMPTY;
    private static final YMDHMS 処理日時1 = DbT3005KyotakuKeikakuTodokedeEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS(new RString("20140101102030"));

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KyotakuKeikakuTodokedeDac.class);
        居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT3005(被保険者番号1, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の証記載保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(被保険者番号1, null, 識別コード1, 対象年月1, 処理日時1);
        }

        // TODO 見つかる場合、居宅給付計画届出モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_居宅給付計画届出モデル返す() {
            assertThat(sut.selectByKey(被保険者番号1, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1).get被保険者番号(), is(被保険者番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.selectByKey(被保険者番号2, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1), is(nullValue()));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT3005(被保険者番号1, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1);
            IItemList<KyotakuKeikakuTodokedeModel> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get証記載保険者番号(), is(証記載保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select居宅給付計画届出一覧By主キーTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT3005(被保険者番号1, 証記載保険者番号1, 識別コード1, 対象年月1, 処理日時1);
            TestSupport.insertDbT3005(被保険者番号1, 証記載保険者番号2, 識別コード1, 対象年月1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select居宅給付計画届出一覧By被保険者番号(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            IItemList<KyotakuKeikakuTodokedeModel> modelList = sut.select居宅給付計画届出一覧By被保険者番号(被保険者番号1);
            assertThat(modelList.size(), is(2));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get被保険者番号(), is(被保険者番号1));
            assertThat(modelList.toList().get(1).get被保険者番号(), is(被保険者番号1));
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
            KyotakuKeikakuTodokedeModel model = new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

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
            KyotakuKeikakuTodokedeModel model = new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.set暫定区分(new RString("9"));

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
            KyotakuKeikakuTodokedeModel model = new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

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
            KyotakuKeikakuTodokedeModel model = new KyotakuKeikakuTodokedeModel(DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT3005(
                HihokenshaNo 被保険者番号,
                HokenshaNo 証記載保険者番号,
                ShikibetsuCode 識別コード,
                FlexibleYearMonth 対象年月,
                YMDHMS 処理日時) {
            DbT3005KyotakuKeikakuTodokedeEntity entity = DbT3005KyotakuKeikakuTodokedeEntityGenerator.createDbT3005KyotakuKeikakuTodokedeEntity();
            entity.setHihokenshaNo(被保険者番号);
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setShikibetsuCode(識別コード);
            entity.setTaishoYM(対象年月);
            entity.setShoriTimestamp(処理日時);
            居宅給付計画届出Dac.insert(entity);
        }
    }

}
