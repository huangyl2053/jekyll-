/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIryoKikanJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIryoKikanJohoBuilderTest extends DbzTestBase {

    private static DbT5911ShujiiIryoKikanJohoEntity ShujiiIryoKikanJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static ShujiiIryokikanCode 主治医医療機関コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
        主治医医療機関コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiIryoKikanJohoBuilder sut;
        private static ShujiiIryoKikanJoho business;

        @Before
        public void setUp() {
            ShujiiIryoKikanJohoEntity = new DbT5911ShujiiIryoKikanJohoEntity();

            business = new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            business = sut.set主治医医療機関コード(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード).build();
            assertThat(business.get主治医医療機関コード(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード));
        }

        @Test
        public void 戻り値の医療機関コードは_設定した値と同じ医療機関コードを返す() {
            business = sut.set医療機関コード(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関コード).build();
            assertThat(business.get医療機関コード(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関コード));
        }

        @Test
        public void 戻り値の医療機関名称は_設定した値と同じ医療機関名称を返す() {
            business = sut.set医療機関名称(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称).build();
            assertThat(business.get医療機関名称(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称));
        }

        @Test
        public void 戻り値の医療機関名称カナは_設定した値と同じ医療機関名称カナを返す() {
            business = sut.set医療機関名称カナ(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称カナ).build();
            assertThat(business.get医療機関名称カナ(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_医療機関名称カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            business = sut.setFax番号(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_FAX番号).build();
            assertThat(business.getFAX番号(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 戻り値の代表者名は_設定した値と同じ代表者名を返す() {
            business = sut.set代表者名(new AtenaMeisho(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_代表者名)).build();
            assertThat(business.get代表者名().getColumnValue(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_代表者名));
        }

        @Test
        public void 戻り値の状況フラグは_設定した値と同じ状況フラグを返す() {
            business = sut.set状況フラグ(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_状況フラグ).build();
            assertThat(business.is状況フラグ(), is(DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_状況フラグ));
        }

    }
}
