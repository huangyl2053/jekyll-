/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import jp.co.ndensan.reams.db.dbz.persistence.db.relate.ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.persistence.relate.ShisetsuNyutaishoDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@Ignore
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoDacTest {

    private static ShisetsuNyutaishoDac sut;
    private static final DbT1004ShisetsuNyutaishoDac insertor = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    private static final ShikibetsuCode shikibetsuCode = new ShikibetsuCode("012345678900001");
    private static final int rirekiNo = 111;

    @BeforeClass
    public static void setUp() {
        sut = InstanceProvider.create(ShisetsuNyutaishoDac.class);
    }

    public static class select介護保険施設入退所ByKey extends DbzTestDacBase {

        @Before
        public void setUp() {

            TestSupport.insertDbT1004(shikibetsuCode, rirekiNo);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut.select介護保険施設入退所ByKey(null, rirekiNo);
            fail();
        }

//        @Test(expected = NullPointerException.class)
//        public void 引数の履歴番号にnullが渡されたとき_NullPointerExceptionが発生する() {
//            sut.select介護保険施設入退所ByKey(shikibetsuCode, null);
//            fail();
//        }
        @Test
        public void 引数に指定した識別コードと_同一の値を持つModelが取得できる() {
            Optional<DbT1004ShisetsuNyutaishoEntity> result = sut.select介護保険施設入退所ByKey(shikibetsuCode, rirekiNo);
            assertThat(result.get().getShikibetsuCode(), is(shikibetsuCode));
        }

        @Test
        public void 引数に指定した処理日時と_同一の値を持つModelが取得できる() {
            Optional<DbT1004ShisetsuNyutaishoEntity> result = sut.select介護保険施設入退所ByKey(shikibetsuCode, rirekiNo);
            assertThat(result.get().getRirekiNo(), is(rirekiNo));
        }
    }

    public static class select介護保険施設入退所一覧By識別コード extends DbzTestDacBase {

        private ShikibetsuCode shikibetsuCode_012345678900001;
        private ShikibetsuCode shikibetsuCode_012345678900002;

        @Before
        public void setUp() {
            shikibetsuCode_012345678900001 = new ShikibetsuCode("012345678900001");
            shikibetsuCode_012345678900002 = new ShikibetsuCode("012345678900002");

            TestSupport.insertDbT1004(shikibetsuCode_012345678900001, rirekiNo);
        }

        @Test
        public void 識別コードに012345678900001を指定して_2件のデータを取得できる() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select介護保険施設入退所一覧By識別コード(shikibetsuCode_012345678900001);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 識別コードに012345678900002を指定して_3件のデータを取得できる() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select介護保険施設入退所一覧By識別コード(shikibetsuCode_012345678900002);
            assertThat(result.size(), is(3));
        }
    }

    public static class select台帳別施設入退所一覧 extends DbzTestDacBase {

        private ShikibetsuCode shikibetsuCode_012345678900001;
        private ShikibetsuCode shikibetsuCode_012345678900002;
        private DaichoType typeHihokensha;
        private DaichoType typeTatoku;

        @Before
        public void setUp() {
            shikibetsuCode_012345678900001 = new ShikibetsuCode("012345678900001");
            shikibetsuCode_012345678900002 = new ShikibetsuCode("012345678900002");
            typeHihokensha = DaichoType.被保険者;
            typeTatoku = DaichoType.他市町村住所地特例者;

            TestSupport.insertDbT1004(shikibetsuCode_012345678900001, rirekiNo);
        }

        @Test
        public void 識別コードに012345678900001_台帳種別に被保険者を指定して_2件のデータを取得できる() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900001, typeHihokensha);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 識別コードに012345678900001_台帳種別に他市町村住所地特例者を指定した場合_空のListが返る() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900001, typeTatoku);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 識別コードに012345678900002_台帳種別に被保険者を指定して_1件のデータを取得できる() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900002, typeHihokensha);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 識別コードに012345678900002_台帳種別に他市町村住所地特例者を指定して_3件のデータを取得できる() {
            IItemList<DbT1004ShisetsuNyutaishoEntity> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900002, typeTatoku);
            assertThat(result.size(), is(3));
        }
    }

    private static class TestSupport {

        public static void insertDbT1004(ShikibetsuCode 識別コード,
                int 履歴番号) {
            DbT1004ShisetsuNyutaishoEntity entity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            entity.setShikibetsuCode(識別コード);
            entity.setRirekiNo(履歴番号);
            insertor.save(entity);
        }

    }
}
