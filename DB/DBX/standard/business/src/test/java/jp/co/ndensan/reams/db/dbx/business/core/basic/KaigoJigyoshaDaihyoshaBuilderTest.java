/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.helper.DbT7062KaigoJigyoshaDaihyoshaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaDaihyoshaBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaDaihyoshaBuilderTest extends DbxTestBase {

    private static DbT7062KaigoJigyoshaDaihyoshaEntity KaigoJigyoshaDaihyoshaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KaigoJigyoshaNo 主キー名1;
    private static FlexibleDate 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号;
        主キー名2 = DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日;
    }

    public static class getterSetterTest extends DbxTestBase {

        private static KaigoJigyoshaDaihyoshaBuilder sut;
        private static KaigoJigyoshaDaihyosha business;

        @Before
        public void setUp() {
            KaigoJigyoshaDaihyoshaEntity = new DbT7062KaigoJigyoshaDaihyoshaEntity();
            KaigoJigyoshaDaihyoshaEntity.setJigyoshaNo(主キー名1);
            KaigoJigyoshaDaihyoshaEntity.setYukoKaishiYMD(主キー名2);

            business = new KaigoJigyoshaDaihyosha(KaigoJigyoshaDaihyoshaEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の事業者番号は_設定した値と同じ事業者番号を返す() {
            business = sut.set事業者番号(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号).build();
            assertThat(business.get事業者番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_事業者番号));
        }

        @Test
        public void 戻り値の有効開始日は_設定した値と同じ有効開始日を返す() {
            business = sut.set有効開始日(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日).build();
            assertThat(business.get有効開始日(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_有効開始日));
        }

        @Test
        public void 戻り値の代表者名は_設定した値と同じ代表者名を返す() {
            business = sut.set代表者名(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名).build();
            assertThat(business.get代表者名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void 戻り値の代表者名カナは_設定した値と同じ代表者名カナを返す() {
            business = sut.set代表者名カナ(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名カナ).build();
            assertThat(business.get代表者名カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者名カナ));
        }

        @Test
        public void 戻り値の代表者郵便番号は_設定した値と同じ代表者郵便番号を返す() {
            business = sut.set代表者郵便番号(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者郵便番号).build();
            assertThat(business.get代表者郵便番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者郵便番号));
        }

        @Test
        public void 戻り値の代表者住所は_設定した値と同じ代表者住所を返す() {
            business = sut.set代表者住所(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所).build();
            assertThat(business.get代表者住所(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所));
        }

        @Test
        public void 戻り値の代表者住所カナは_設定した値と同じ代表者住所カナを返す() {
            business = sut.set代表者住所カナ(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所カナ).build();
            assertThat(business.get代表者住所カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者住所カナ));
        }

        @Test
        public void 戻り値の代表者役職名は_設定した値と同じ代表者役職名を返す() {
            business = sut.set代表者役職名(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者役職名).build();
            assertThat(business.get代表者役職名(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_代表者役職名));
        }

        @Test
        public void 戻り値の開設者名称は_設定した値と同じ開設者名称を返す() {
            business = sut.set開設者名称(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称).build();
            assertThat(business.get開設者名称(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称));
        }

        @Test
        public void 戻り値の開設者名称カナは_設定した値と同じ開設者名称カナを返す() {
            business = sut.set開設者名称カナ(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称カナ).build();
            assertThat(business.get開設者名称カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者名称カナ));
        }

        @Test
        public void 戻り値の開設者郵便番号は_設定した値と同じ開設者郵便番号を返す() {
            business = sut.set開設者郵便番号(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者郵便番号).build();
            assertThat(business.get開設者郵便番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者郵便番号));
        }

        @Test
        public void 戻り値の開設者住所は_設定した値と同じ開設者住所を返す() {
            business = sut.set開設者住所(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所).build();
            assertThat(business.get開設者住所(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所));
        }

        @Test
        public void 戻り値の開設者住所カナは_設定した値と同じ開設者住所カナを返す() {
            business = sut.set開設者住所カナ(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所カナ).build();
            assertThat(business.get開設者住所カナ(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者住所カナ));
        }

        @Test
        public void 戻り値の開設者電話番号は_設定した値と同じ開設者電話番号を返す() {
            business = sut.set開設者電話番号(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者電話番号).build();
            assertThat(business.get開設者電話番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者電話番号));
        }

        @Test
        public void 戻り値の開設者ＦＡＸ番号は_設定した値と同じ開設者ＦＡＸ番号を返す() {
            business = sut.set開設者ＦＡＸ番号(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者ＦＡＸ番号).build();
            assertThat(business.get開設者ＦＡＸ番号(), is(DbT7062KaigoJigyoshaDaihyoshaEntityGenerator.DEFAULT_開設者ＦＡＸ番号));
        }

    }
}
