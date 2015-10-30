/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJogaiTokureiTaishoShisetsuDac}のテストクラスです。
 *
 * @author n8223　朴義一
 */
@Ignore
@RunWith(Enclosed.class)
public class KaigoJogaiTokureiTaishoShisetsuDacTest {

    private static KaigoJogaiTokureiTaishoShisetsuDac sut;
    private static DbT1005KaigoJogaiTokureiTaishoShisetsuDac 介護除外住所地特例対象施設Dac;

    private static final RString 事業者種別 = new RString("1");
    private static final RString 事業者番号 = new RString("45");
    private static final FlexibleDate 有効開始年月日 = new FlexibleDate("20141203");
    private static final RString 事業者種別Null = new RString("");

    public KaigoJogaiTokureiTaishoShisetsuDacTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        sut = InstanceProvider.create(KaigoJogaiTokureiTaishoShisetsuDac.class);
        介護除外住所地特例対象施設Dac = InstanceProvider.create(DbT1005KaigoJogaiTokureiTaishoShisetsuDac.class);
    }

    public static class select介護除外住所地特例対象施設ByKeyTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1005(事業者種別, 事業者番号, 有効開始年月日);
        }

        @Test
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護除外住所地特例対象施設一覧By事業者種別(事業者種別Null);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルを返す() {
            Optional<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> model = sut.select介護除外住所地特例対象施設ByKey(事業者種別, 事業者番号, 有効開始年月日);
            assertThat(model.get().getJigyoshaShubetsu(), is(事業者種別));
        }
    }

    public static class select介護除外住所地特例対象施設一覧By事業者種別Test extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1005(事業者種別, 事業者番号, 有効開始年月日);
        }

        @Test
        public void 引数の主キー値にnullを指定した場合_NullPointerExceptionが発生する() {
            sut.select介護除外住所地特例対象施設一覧By事業者種別(事業者種別);
        }

        @Test
        public void データが見つかる検索条件を渡すと_台帳モデルリストを返す() {
            IItemList<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> modelList = sut.select介護除外住所地特例対象施設一覧By事業者種別(事業者種別);
            assertThat(modelList.size(), is(1));
            assertThat(modelList.toList().get(0).getJigyoshaShubetsu(), is(事業者種別));

        }

        @Test
        public void データが見つかない検索条件を渡すと__空のリストを返す() {
            assertThat(sut.select介護除外住所地特例対象施設一覧By事業者種別(事業者種別Null).isEmpty(), is(true));
        }

    }

    public static class insertTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_insertは_0を返す() {
            assertThat(sut.insert(null), is(0));
        }

        // TODO ShisetsuNyutaishoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void KaigoJogaiTokureiTaishoShisetsuModelを渡した時_insertは_1を返す() {

            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity model = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();

            assertThat(sut.insert(model), is(notNullValue()));
        }

    }

    public static class updateTest extends DbzTestDacBase {

        @Before
        public void setUp() {
            TestSupport.insertDbT1005(事業者種別, 事業者番号, 有効開始年月日);
        }

        @Test
        public void nullを渡した時_updateは_0を返す() {
            assertThat(sut.update(null), is(0));
        }

        // TODO ShisetsuNyutaishoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。異なる状態を指定する。
        @Test
        public void モデルの状態がModifiedの時_updateは_1を返す() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity model = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();

            sut.insert(model);
            model.initializeMd5();
            model.setJigyoshaShubetsu(事業者種別);

        }

    }

    public static class deleteTest extends DbzTestDacBase {

        @Test
        public void nullを渡した時_deleteは_0を返す() {
            assertThat(sut.delete(null), is(0));
        }

        // TODO ShisetsuNyutaishoModelの生成パターンによるテストを追加してください。nullや空のリストを指定する。
        @Test
        public void KaigoJogaiTokureiTaishoShisetsuModelを渡した時_deleteは_1を返す() {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity model = new DbT1005KaigoJogaiTokureiTaishoShisetsuEntity();

            sut.insert(model);
            assertThat(sut.delete(model), is(1));
        }
    }

    private static class TestSupport {

        public static void insertDbT1005(
                RString 事業者種別,
                RString 事業者番号,
                FlexibleDate 有効開始年月日) {
            DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity = DbT1005KaigoJogaiTokureiTaishoShisetsuEntityGenerator.createDbT1005KaigoJogaiTokureiTaishoShisetsuEntity();
            entity.setJigyoshaShubetsu(事業者種別);
            entity.setJigyoshaNo(事業者番号);
            entity.setYukoKaishiYMD(有効開始年月日);
            介護除外住所地特例対象施設Dac.save(entity);
        }
    }

}
