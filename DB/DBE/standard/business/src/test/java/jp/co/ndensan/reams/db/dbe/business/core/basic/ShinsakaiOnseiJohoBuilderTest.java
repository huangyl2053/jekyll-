/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5512ShinsakaiOnseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5512ShinsakaiOnseiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiOnseiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShinsakaiOnseiJohoBuilderTest extends DbeTestBase {

    private static DbT5512ShinsakaiOnseiJohoEntity ShinsakaiOnseiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 介護認定審査会開催番号;
    private static int 連番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        介護認定審査会開催番号 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
        連番 = DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_連番;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static ShinsakaiOnseiJohoBuilder sut;
        private static ShinsakaiOnseiJoho business;

        @Before
        public void setUp() {
            ShinsakaiOnseiJohoEntity = new DbT5512ShinsakaiOnseiJohoEntity();

            business = new ShinsakaiOnseiJoho(ShinsakaiOnseiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の介護認定審査会開催番号は_設定した値と同じ介護認定審査会開催番号を返す() {
            business = sut.set介護認定審査会開催番号(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_介護認定審査会開催番号).build();
            assertThat(business.get介護認定審査会開催番号(), is(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }

        @Test
        public void 戻り値の連番は_設定した値と同じ連番を返す() {
            business = sut.set連番(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_連番).build();
            assertThat(business.get連番(), is(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_連番));
        }

        @Test
        public void 戻り値の審査会音声ファイルは_設定した値と同じ審査会音声ファイルを返す() {
            business = sut.set審査会音声ファイル(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_審査会音声ファイル).build();
            assertThat(business.get審査会音声ファイル(), is(DbT5512ShinsakaiOnseiJohoEntityGenerator.DEFAULT_審査会音声ファイル));
        }

    }
}
