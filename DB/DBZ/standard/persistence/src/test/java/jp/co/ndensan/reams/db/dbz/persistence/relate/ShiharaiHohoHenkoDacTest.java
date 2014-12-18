/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT4021ShiharaiHohoHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.ShiharaiHohoHenkoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
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
 * {@link ShiharaiHohoHenkoDac}のテストクラスです。
 *
 * @author n8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShiharaiHohoHenkoDacTest {

    private static ShiharaiHohoHenkoDac sut;
    private static DbT4021ShiharaiHohoHenkoDac 支払方法変更Dac;
    private static final ShoKisaiHokenshaNo 証記載保険者番号1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_証記載保険者番号;
    private static final ShoKisaiHokenshaNo 証記載保険者番号2 = new ShoKisaiHokenshaNo("124562");
    private static final HihokenshaNo 被保険者番号1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_被保険者番号;
    private static final HihokenshaNo 被保険者番号2 = new HihokenshaNo("987654");
    private static final RString 管理区分1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分;
    private static final RString 管理区分2 = new RString("2");
    private static final RString 登録区分1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_登録区分;
    private static final RString 登録区分2 = new RString("02");
    private static final YMDHMS 処理日時1 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_処理日時;
    private static final YMDHMS 処理日時2 = new YMDHMS("20140101102040");

    private static final RString _2号差止管理区分 = new RString("1");
    private static final RString _2号差止登録区分 = new RString("02");
    private static final RString _1号償還払化管理区分 = new RString("2");
    private static final RString _1号償還払化登録区分 = new RString("12");
    private static final RString _1号減額管理区分 = new RString("3");
    private static final RString _1号減額登録区分 = new RString("21");

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShiharaiHohoHenkoDac.class);
        支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の証記載保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 被保険者番号1, 管理区分1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, null, 管理区分1, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の管理区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, 被保険者番号1, null, 処理日時1);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, 被保険者番号1, 管理区分1, null);
        }

        // TODO 見つかる場合、支払方法変更モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_支払方法変更モデル返す() {
            assertThat(sut.selectByKey(証記載保険者番号1, 被保険者番号1, 管理区分1, 処理日時1).get証記載保険者番号(), is(証記載保険者番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_nullを返す() {
            assertThat(sut.selectByKey(証記載保険者番号2, 被保険者番号1, 管理区分1, 処理日時1), is(nullValue()));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 処理日時1);
            IItemList<ShiharaiHohoHenkoModel> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get証記載保険者番号(), is(証記載保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと_空のリストを返す() {
            assertThat(sut.selectAll().isEmpty(), is(true));
        }
    }

    public static class select2号差止履歴Test extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select2号差止履歴(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _2号差止管理区分, _2号差止登録区分, 処理日時1);
            IItemList<ShiharaiHohoHenkoModel> modelList = sut.select2号差止履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get被保険者番号(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 処理日時1);
            assertThat(sut.select2号差止履歴(被保険者番号1).isEmpty(), is(true));
        }
    }

    public static class select1号償還払化履歴Test extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select2号差止履歴(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _1号償還払化管理区分, _1号償還払化登録区分, 処理日時1);
            IItemList<ShiharaiHohoHenkoModel> modelList = sut.select1号償還払化履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get被保険者番号(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 処理日時1);
            assertThat(sut.select1号償還払化履歴(被保険者番号1).isEmpty(), is(true));
        }
    }

    public static class select1号減額登録履歴Test extends DbzTestDacBase {

        @Test(expected = NullPointerException.class)
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select2号差止履歴(null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _1号減額管理区分, _1号減額登録区分, 処理日時1);
            IItemList<ShiharaiHohoHenkoModel> modelList = sut.select1号減額履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).get被保険者番号(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 処理日時1);
            assertThat(sut.select1号減額履歴(被保険者番号1).isEmpty(), is(true));
        }
    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO ShiharaiHohoHenkoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つShiharaiHohoHenkoRelateモデルを渡した時_insertは_1を返す() {
            ShiharaiHohoHenkoModel model = new ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            assertThat(sut.insert(model), is(1));
        }
    }

    public static class updateTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO ShiharaiHohoHenkoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            ShiharaiHohoHenkoModel model = new ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.insert(model);

            model.getEntity().initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.set差止対象フラグ(false);

            assertThat(sut.update(model), is(1));
        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO ShiharaiHohoHenkoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つShiharaiHohoHenkoRelateモデルを渡した時_deleteは_1を返す() {
            ShiharaiHohoHenkoModel model = new ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    public static class deletePhysicalTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deletePhysicalは_0を返す() {
            assertThat(sut.deletePhysical(null), is(0));
        }

        // TODO ShiharaiHohoHenkoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void 全ての有効なモデルを持つShiharaiHohoHenkoRelateモデルを渡した時_deletePhysicalは_1を返す() {
            ShiharaiHohoHenkoModel model = new ShiharaiHohoHenkoModel(DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity());

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT4021(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                RString 管理区分,
                RString 登録区分,
                YMDHMS 処理日時) {
            DbT4021ShiharaiHohoHenkoEntity entity = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriKubun(管理区分);
            entity.setTorokuKubun(登録区分);
            entity.setShoriTimestamp(処理日時);
            支払方法変更Dac.insert(entity);
        }
    }

}
