/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1004ShisetsuNyutaishoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.model.relate.ShisetsuNyutaishoRelateModel;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.persistence.relate.ShisetsuNyutaishoDac}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoDacTest {

    private static ShisetsuNyutaishoDac sut;
    private static final DbT1004ShisetsuNyutaishoDac insertor = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);

    @BeforeClass
    public static void setUp() {
        sut = InstanceProvider.create(ShisetsuNyutaishoDac.class);
    }

    public static class select介護保険施設入退所ByKey extends DbzTestDacBase {

        private ShikibetsuCode shikibetsuCode;
        private LasdecCode lasdecCode;
        private YMDHMS ymdhms;

        @Before
        public void setUp() {
            shikibetsuCode = new ShikibetsuCode("012345678900001");
            lasdecCode = new LasdecCode("000001");
            ymdhms = new YMDHMS("20140101000000");

            TestSupport.insertDbT1004(lasdecCode, shikibetsuCode, DaichoType.被保険者, ymdhms);
        }

        @Test(expected = NullPointerException.class)
        public void 引数の市町村コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            lasdecCode = null;
            sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 引数の識別コードにnullが渡されたとき_NullPointerExceptionが発生する() {
            shikibetsuCode = null;
            sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 引数の処理日時にnullが渡されたとき_NullPointerExceptionが発生する() {
            ymdhms = null;
            sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            fail();
        }

        @Test
        public void 引数に指定した識別コードと_同一の値を持つModelが取得できる() {
            Optional<ShisetsuNyutaishoRelateModel> result = sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            assertThat(result.get().get介護保険施設入退所モデル().get識別コード(), is(shikibetsuCode));
        }

        @Test
        public void 引数に指定した市町村コードと_同一の値を持つModelが取得できる() {
            Optional<ShisetsuNyutaishoRelateModel> result = sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            assertThat(result.get().get介護保険施設入退所モデル().get市町村コード(), is(lasdecCode));
        }

        @Test
        public void 引数に指定した処理日時と_同一の値を持つModelが取得できる() {
            Optional<ShisetsuNyutaishoRelateModel> result = sut.select介護保険施設入退所ByKey(lasdecCode, shikibetsuCode, ymdhms);
            assertThat(result.get().get介護保険施設入退所モデル().get処理日時(), is(ymdhms));
        }
    }

    public static class select介護保険施設入退所一覧By識別コード extends DbzTestDacBase {

        private ShikibetsuCode shikibetsuCode_012345678900001;
        private ShikibetsuCode shikibetsuCode_012345678900002;

        @Before
        public void setUp() {
            shikibetsuCode_012345678900001 = new ShikibetsuCode("012345678900001");
            shikibetsuCode_012345678900002 = new ShikibetsuCode("012345678900002");

            TestSupport.insertDbT1004(new LasdecCode("000001"), shikibetsuCode_012345678900001, DaichoType.被保険者, new YMDHMS("20140101000000"));
            TestSupport.insertDbT1004(new LasdecCode("000002"), shikibetsuCode_012345678900001, DaichoType.被保険者, new YMDHMS("20140101000001"));
            TestSupport.insertDbT1004(new LasdecCode("000003"), shikibetsuCode_012345678900002, DaichoType.被保険者, new YMDHMS("20140101000002"));
            TestSupport.insertDbT1004(new LasdecCode("000004"), shikibetsuCode_012345678900002, DaichoType.被保険者, new YMDHMS("20140101000003"));
            TestSupport.insertDbT1004(new LasdecCode("000005"), shikibetsuCode_012345678900002, DaichoType.被保険者, new YMDHMS("20140101000004"));
        }

        @Test
        public void 識別コードに012345678900001を指定して_2件のデータを取得できる() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select介護保険施設入退所一覧By識別コード(shikibetsuCode_012345678900001);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 識別コードに012345678900002を指定して_3件のデータを取得できる() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select介護保険施設入退所一覧By識別コード(shikibetsuCode_012345678900002);
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

            TestSupport.insertDbT1004(new LasdecCode("000001"), shikibetsuCode_012345678900001, typeHihokensha, new YMDHMS("20140101000000"));
            TestSupport.insertDbT1004(new LasdecCode("000002"), shikibetsuCode_012345678900001, typeHihokensha, new YMDHMS("20140101000001"));
            TestSupport.insertDbT1004(new LasdecCode("000003"), shikibetsuCode_012345678900002, typeTatoku, new YMDHMS("20140101000002"));
            TestSupport.insertDbT1004(new LasdecCode("000004"), shikibetsuCode_012345678900002, typeTatoku, new YMDHMS("20140101000003"));
            TestSupport.insertDbT1004(new LasdecCode("000005"), shikibetsuCode_012345678900002, typeHihokensha, new YMDHMS("20140101000004"));
            TestSupport.insertDbT1004(new LasdecCode("000006"), shikibetsuCode_012345678900002, typeTatoku, new YMDHMS("20140101000005"));
        }

        @Test
        public void 識別コードに012345678900001_台帳種別に被保険者を指定して_2件のデータを取得できる() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900001, typeHihokensha);
            assertThat(result.size(), is(2));
        }

        @Test
        public void 識別コードに012345678900001_台帳種別に他市町村住所地特例者を指定した場合_空のListが返る() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900001, typeTatoku);
            assertThat(result.isEmpty(), is(true));
        }

        @Test
        public void 識別コードに012345678900002_台帳種別に被保険者を指定して_1件のデータを取得できる() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900002, typeHihokensha);
            assertThat(result.size(), is(1));
        }

        @Test
        public void 識別コードに012345678900002_台帳種別に他市町村住所地特例者を指定して_3件のデータを取得できる() {
            IItemList<ShisetsuNyutaishoRelateModel> result = sut.select台帳別施設入退所一覧(shikibetsuCode_012345678900002, typeTatoku);
            assertThat(result.size(), is(3));
        }
    }

    private static class TestSupport {

        public static void insertDbT1004(LasdecCode 市町村コード, ShikibetsuCode 識別コード,
                DaichoType 台帳種別, YMDHMS shoriTimestamp) {
            DbT1004ShisetsuNyutaishoEntity entity = DbT1004ShisetsuNyutaishoEntityGenerator.createDbT1004ShisetsuNyutaishoEntity();
            entity.setShichosonCode(市町村コード);
            entity.setShikibetsuCode(識別コード);
            entity.setDaichoShubetsu(台帳種別.getCode());
            entity.setShoriTimestamp(shoriTimestamp);
            insertor.insert(entity);
        }

    }
}
