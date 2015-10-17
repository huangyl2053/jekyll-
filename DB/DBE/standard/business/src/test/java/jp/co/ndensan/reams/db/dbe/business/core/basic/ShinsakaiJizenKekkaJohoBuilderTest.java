/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5508ShinsakaiJizenKekkaJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiJizenKekkaJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiJizenKekkaJohoBuilderTest extends DbeTestBase {

    private static DbT5508ShinsakaiJizenKekkaJohoEntity ShinsakaiJizenKekkaJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 介護認定審査会開催番号;
    private static RString 介護認定審査会委員コード;
    private static int 介護認定審査会審査順;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        介護認定審査会開催番号 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号;
        介護認定審査会委員コード = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード;
        介護認定審査会審査順 = DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static ShinsakaiJizenKekkaJohoBuilder sut;
        private static ShinsakaiJizenKekkaJoho business;

        @Before
        public void setUp() {
            ShinsakaiJizenKekkaJohoEntity = new DbT5508ShinsakaiJizenKekkaJohoEntity();

            business = new ShinsakaiJizenKekkaJoho(ShinsakaiJizenKekkaJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の介護認定審査会開催番号は_設定した値と同じ介護認定審査会開催番号を返す() {
            business = sut.set介護認定審査会開催番号(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号).build();
            assertThat(business.get介護認定審査会開催番号(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会開催番号));
        }

        @Test
        public void 戻り値の介護認定審査会委員コードは_設定した値と同じ介護認定審査会委員コードを返す() {
            business = sut.set介護認定審査会委員コード(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード).build();
            assertThat(business.get介護認定審査会委員コード(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会委員コード));
        }

        @Test
        public void 戻り値の介護認定審査会審査順は_設定した値と同じ介護認定審査会審査順を返す() {
            business = sut.set介護認定審査会審査順(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順).build();
            assertThat(business.get介護認定審査会審査順(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_介護認定審査会審査順));
        }

        @Test
        public void 戻り値の一次判定結果変更理由は_設定した値と同じ一次判定結果変更理由を返す() {
            business = sut.set一次判定結果変更理由(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由).build();
            assertThat(business.get一次判定結果変更理由(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_一次判定結果変更理由));
        }

        @Test
        public void 戻り値の二次判定結果コードは_設定した値と同じ二次判定結果コードを返す() {
            business = sut.set二次判定結果コード(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_二次判定結果コード).build();
            assertThat(business.get二次判定結果コード(), is(DbT5508ShinsakaiJizenKekkaJohoEntityGenerator.DEFAULT_二次判定結果コード));
        }

    }
}
