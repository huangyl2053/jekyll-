/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5225ChosaChikuGroupEntity;
import jp.co.ndensan.reams.db.dbz.entity.dbasic.helper.DbT5225ChosaChikuGroupEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosaChikuGroupBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosaChikuGroupBuilderTest extends DbzTestBase {

    private static DbT5225ChosaChikuGroupEntity ChosaChikuGroupEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_主キー名2;
    }

    public static class getterSetterTest extends FdaTestBase {

        private static ChosaChikuGroupBuilder sut;
        private static ChosaChikuGroup business;

        @Before
        public void setUp() {
            ChosaChikuGroupEntity = new DbT5225ChosaChikuGroupEntity();

            business = new ChosaChikuGroup(ChosaChikuGroupEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の調査地区グループコードは_設定した値と同じ調査地区グループコードを返す() {
            business = sut.set調査地区グループコード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード).build();
            assertThat(business.get調査地区グループコード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループコード));
        }

        @Test
        public void 戻り値の調査地区コードは_設定した値と同じ調査地区コードを返す() {
            business = sut.set調査地区コード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区コード).build();
            assertThat(business.get調査地区コード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の調査地区グループ名称は_設定した値と同じ調査地区グループ名称を返す() {
            business = sut.set調査地区グループ名称(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループ名称).build();
            assertThat(business.get調査地区グループ名称(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_調査地区グループ名称));
        }

        @Test
        public void 戻り値の優先番号は_設定した値と同じ優先番号を返す() {
            business = sut.set優先番号(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_優先番号).build();
            assertThat(business.get優先番号(), is(DbT5225ChosaChikuGroupEntityGenerator.DEFAULT_優先番号));
        }

    }
}
