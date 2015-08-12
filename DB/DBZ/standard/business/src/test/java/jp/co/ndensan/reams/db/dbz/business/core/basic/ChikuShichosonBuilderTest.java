/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5224ChikuShichosonEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5224ChikuShichosonEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChikuShichosonBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChikuShichosonBuilderTest extends DbzTestBase {

    private static DbT5224ChikuShichosonEntity ChikuShichosonEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5224ChikuShichosonEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5224ChikuShichosonEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ChikuShichosonBuilder sut;
        private static ChikuShichoson business;

        @Before
        public void setUp() {
            ChikuShichosonEntity = new DbT5224ChikuShichosonEntity();

            business = new ChikuShichoson(ChikuShichosonEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の優先番号は_設定した値と同じ優先番号を返す() {
            business = sut.set優先番号(DbT5224ChikuShichosonEntityGenerator.DEFAULT_優先番号).build();
            assertThat(business.get優先番号(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_優先番号));
        }

        @Test
        public void 戻り値の自地区フラグは_設定した値と同じ自地区フラグを返す() {
            business = sut.set自地区フラグ(DbT5224ChikuShichosonEntityGenerator.DEFAULT_自地区フラグ).build();
            assertThat(business.get自地区フラグ(), is(DbT5224ChikuShichosonEntityGenerator.DEFAULT_自地区フラグ));
        }

    }
}
