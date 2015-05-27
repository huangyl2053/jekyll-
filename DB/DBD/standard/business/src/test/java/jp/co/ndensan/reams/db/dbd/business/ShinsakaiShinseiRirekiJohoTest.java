/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business;

import jp.co.ndensan.reams.db.dbd.entity.basic.helper.DbT5121ShinseiRirekiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbdTestBase;
import jp.co.ndensan.reams.uz.uza.util.serialization._Base64Serializer;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiShinseiRirekiJoho}のテストクラスです。
 *
 * @author n8223 朴義一
 */
@RunWith(Enclosed.class)
public class ShinsakaiShinseiRirekiJohoTest extends DbdTestBase {

    private static ShinsakaiShinseiRirekiJoho sut;

    public static class getterSetterTest extends DbdTestBase {

        @BeforeClass
        public static void setUp() {
            sut = new ShinsakaiShinseiRirekiJoho(DbT5121ShinseiRirekiJohoEntityGenerator.createDbT5121ShinseiRirekiJohoEntity());
        }

        @Test
        public void 引数に申請管理番号を設定した場合_get申請管理番号は_申請管理番号と同じ申請管理番号を返す() {
            assertThat(sut.get申請管理番号(), is(DbT5121ShinseiRirekiJohoEntityGenerator.DEFAULT_申請管理番号));
        }

        @Test
        public void 引数に前回申請管理番号を設定した場合_get前回申請管理番号は_前回申請管理番号と同じ前回申請管理番号を返す() {
            assertThat(sut.get前回申請管理番号(), is(DbT5121ShinseiRirekiJohoEntityGenerator.DEFAULT_前回申請管理番号));
        }
    }

    public static class BuilderTest extends DbdTestBase {

        @Test
        public void setShinseishoKanriNoで設定した値を_生成されたHokenshaShinseiRirekiJohoも保持する() {
            HokenshaShinseiRirekiJoho result = HokenshaShinseiRirekiJoho.newBuilder().setShinseishoKanriNo(new ShinseishoKanriNo("12345678901234567")).build();
            assertThat(result.get申請管理番号(), is(DbT5121ShinseiRirekiJohoEntityGenerator.DEFAULT_申請管理番号));
        }

        @Test
        public void setZenkaiShinseishoKanriNoで設定した値を_生成されたHokenshaShinseiRirekiJohoも保持する() {
            HokenshaShinseiRirekiJoho result = HokenshaShinseiRirekiJoho.newBuilder().setZenkaiShinseishoKanriNo(new ShinseishoKanriNo("12345678901234567")).build();
            assertThat(result.get前回申請管理番号(), is(DbT5121ShinseiRirekiJohoEntityGenerator.DEFAULT_前回申請管理番号));
        }
    }

    public static class SerializationProxyTest {

        private ShinsakaiShinseiRirekiJoho sut;

        @Before
        public void setUp() {
            sut = ShinsakaiShinseiRirekiJoho.newBuilder().build();
        }

        @Test
        public void serializeの戻り値は_デシリアライズすると_このクラスのインスタンスを生成する() {
            sut.createBuilderForEdit().setShinseishoKanriNo(new ShinseishoKanriNo("12345678901234567"));
            String b64 = _Base64Serializer.serialize(sut.serialize());
            ShinsakaiShinseiRirekiJoho desirialized = _Base64Serializer.deSerialize(b64, ShinsakaiShinseiRirekiJoho.class);
            assertThat(desirialized.get申請管理番号(), is(sut.get申請管理番号()));
        }
    }
}
