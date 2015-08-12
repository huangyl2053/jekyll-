/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7025KoikiNoHatsubanEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT7025KoikiNoHatsubanEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.fd.fdz.testhelper.FdaTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoikiNoHatsubanBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoikiNoHatsubanBuilderTest extends DbzTestBase {

    private static DbT7025KoikiNoHatsubanEntity KoikiNoHatsubanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static KoikiNoHatsubanBuilder sut;
        private static KoikiNoHatsuban business;

        @Before
        public void setUp() {
            KoikiNoHatsubanEntity = new DbT7025KoikiNoHatsubanEntity();
            KoikiNoHatsubanEntity.setXXX(主キー名1);
            KoikiNoHatsubanEntity.setXXX(主キー名2);

            business = new KoikiNoHatsuban(KoikiNoHatsubanEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値のコード区分は_設定した値と同じコード区分を返す() {
            business = sut.setコード区分(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分).build();
            assertThat(business.getコード区分(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_コード区分));
        }

        @Test
        public void 戻り値の番号は_設定した値と同じ番号を返す() {
            business = sut.set番号(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_番号).build();
            assertThat(business.get番号(), is(DbT7025KoikiNoHatsubanEntityGenerator.DEFAULT_番号));
        }

    }
}
