package jp.co.ndensan.reams.db.dbx.business.core;

import java.lang.reflect.Constructor;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1004HihokenshaShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7060KaigoJigyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NyushoJyokyo}のテストです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NyushoJyokyoTest extends DbxTestBase {

    public static class コンストラクタTest extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void コンストラクタの介護事業者エンティティに_Null_を指定した時_NullPointerExceptionが発生する() {
            NyushoJyokyo sut = new NyushoJyokyo(null, DbV1004HihokenshaShisetsuNyutaishoEntityGenerator.createDbV1004HihokenshaShisetsuNyutaishoEntity());
        }

        @Test(expected = NullPointerException.class)
        public void コンストラクタの施設入退所エンティティに_Null_を指定した時_NullPointerExceptionが発生する() {
            NyushoJyokyo sut = new NyushoJyokyo(DbT7060KaigoJigyoshaEntityGenerator.createDbT7060KaigoJigyoshaEntity(), null);
        }
    }

    public static class get事業者Test extends DbxTestBase {

        private static NyushoJyokyo sut;

        @Before
        public void setUp() {
            DbT7060KaigoJigyoshaEntity entityDbT7060 = new DbT7060KaigoJigyoshaEntity();
            DbV1004HihokenshaShisetsuNyutaishoEntity entityDv1004 = new DbV1004HihokenshaShisetsuNyutaishoEntity();
            sut = new NyushoJyokyo(entityDbT7060, entityDv1004);
        }

        @Test
        public void LDNS_メソッドget事業者が呼び出される場合_get事業者は_nullを返す() {
            assertThat(sut.get事業者(), is(nullValue()));
        }

    }

    public static class LDNS_コンストラクタTEST extends DbxTestBase {

        @Test
        public void LDNS_privateConstructor() throws Exception {
            Constructor<NyushoJyokyo> constructor = NyushoJyokyo.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            constructor.newInstance();
        }

    }
}
