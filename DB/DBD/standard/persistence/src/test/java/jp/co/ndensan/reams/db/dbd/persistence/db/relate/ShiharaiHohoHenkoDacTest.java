/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.relate;

import jp.co.ndensan.reams.db.dbd.persistence.db.relate.ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.jukyu.shiharaihohohenko.TorokuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
//import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4021ShiharaiHohoHenkoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
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
    private static final KanriKubun 管理区分1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_管理区分;
    private static final TorokuKubun 登録区分1 = DbT4021ShiharaiHohoHenkoEntityGenerator.DEFAULT_登録区分;
    private static final int 履歴番号 = 1;
//    private static final YMDHMS 履歴番号 = DbT3007KyotakuKeikakuJikoSakuseiEntityGenerator.DEFAULT_処理日時;

    private static final KanriKubun _2号差止管理区分 = KanriKubun.ニ号差止;
    private static final TorokuKubun _2号差止登録区分 = TorokuKubun.二号差止登録;
    private static final KanriKubun _1号償還払化管理区分 = KanriKubun.一号償還払い化;
    private static final TorokuKubun _1号償還払化登録区分 = TorokuKubun.一号償還払い化登録;
    private static final KanriKubun _1号減額管理区分 = KanriKubun.一号給付額減額;
    private static final TorokuKubun _1号減額登録区分 = TorokuKubun.一号給付額減額登録;

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(ShiharaiHohoHenkoDac.class);
        支払方法変更Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    }

    public static class selectByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の証記載保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(null, 被保険者番号1, 管理区分1, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の被保険者番号にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, null, 管理区分1, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の管理区分にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.selectByKey(証記載保険者番号1, 被保険者番号1, null, 履歴番号);
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の処理日時にnullを指定した場合_NullPointerExceptionが発生する() {
//            sut.selectByKey(証記載保険者番号1, 被保険者番号1, 管理区分1, null);
//        }
//
        // TODO 見つかる場合、支払方法変更モデルを構成している全てのモデルクラスについて特定項目を選択し、一致していることを確認するテストケースを記述して下さい。
        // TODO 個別のMapperのテストクラスで項目単位の転記処理を確認しているため、全項目について確認する必要はありません。
        @Test
        public void データが見つかる検索条件を渡すと_支払方法変更モデル返す() {
            assertThat(sut.selectByKey(証記載保険者番号1, 被保険者番号1, 管理区分1, 履歴番号).get().getShoKisaiHokenshaNo(), is(証記載保険者番号1));
        }

        // データが見つからない値を指定するように修正してください。
        @Test
        public void データが見つかない検索条件を渡すと_データ無しを返す() {
            assertThat(sut.selectByKey(証記載保険者番号2, 被保険者番号1, 管理区分1, 履歴番号).isPresent(), is(false));
        }
    }

    public static class selectAll extends DbzTestDacBase {

        @Test
        public void データが見つかる検索条件を渡すと_モデルリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 履歴番号);
            IItemList<DbT4021ShiharaiHohoHenkoEntity> modelList = sut.selectAll();
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getShoKisaiHokenshaNo(), is(証記載保険者番号1));
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
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _2号差止管理区分, _2号差止登録区分, 履歴番号);
            IItemList<DbT4021ShiharaiHohoHenkoEntity> modelList = sut.select2号差止履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 履歴番号);
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
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _1号償還払化管理区分, _1号償還払化登録区分, 履歴番号);
            IItemList<DbT4021ShiharaiHohoHenkoEntity> modelList = sut.select1号償還払化履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 履歴番号);
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
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, _1号減額管理区分, _1号減額登録区分, 履歴番号);
            IItemList<DbT4021ShiharaiHohoHenkoEntity> modelList = sut.select1号減額履歴(被保険者番号1);
            assertThat(modelList.size(), is(1));
            // 任意の項目が一致するテストケースを記述してください。
            assertThat(modelList.toList().get(0).getHihokenshaNo(), is(被保険者番号1));
        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            TestSupport.insertDbT4021(証記載保険者番号1, 被保険者番号1, 管理区分1, 登録区分1, 履歴番号);
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
            DbT4021ShiharaiHohoHenkoEntity model = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();

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
            DbT4021ShiharaiHohoHenkoEntity model = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();

            sut.insert(model);

            model.initializeMd5();
            // 状態をModifiedにするために任意の項目をinsert時と変更してください。
            model.setSashitome_Flag(false);

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
            DbT4021ShiharaiHohoHenkoEntity model = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();

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
            DbT4021ShiharaiHohoHenkoEntity model = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();

            sut.insert(model);
            assertThat(sut.deletePhysical(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT4021(
                ShoKisaiHokenshaNo 証記載保険者番号,
                HihokenshaNo 被保険者番号,
                KanriKubun 管理区分,
                TorokuKubun 登録区分,
                int 履歴番号) {
            DbT4021ShiharaiHohoHenkoEntity entity = DbT4021ShiharaiHohoHenkoEntityGenerator.createDbT4021ShiharaiHohoHenkoEntity();
            entity.setShoKisaiHokenshaNo(証記載保険者番号);
            entity.setHihokenshaNo(被保険者番号);
            entity.setKanriKubun(管理区分);
            entity.setTorokuKubun(登録区分.code());
            entity.setRirekiNo(履歴番号);
            支払方法変更Dac.save(entity);
        }
    }

}
