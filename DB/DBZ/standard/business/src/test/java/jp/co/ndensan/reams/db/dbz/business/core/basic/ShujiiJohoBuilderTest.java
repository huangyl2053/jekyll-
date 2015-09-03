/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5912ShujiiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiJohoBuilderTest extends DbzTestBase {

    private static DbT5912ShujiiJohoEntity ShujiiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static ShujiiIryokikanCode 主治医医療機関コード;
    private static ShujiiCode 主治医コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT5912ShujiiJohoEntityGenerator.DEFAULT_市町村コード;
        主治医医療機関コード = DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医医療機関コード;
        主治医コード = DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医コード;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShujiiJohoBuilder sut;
        private static ShujiiJoho business;

        @Before
        public void setUp() {
            ShujiiJohoEntity = new DbT5912ShujiiJohoEntity();

            business = new ShujiiJoho(ShujiiJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT5912ShujiiJohoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の主治医医療機関コードは_設定した値と同じ主治医医療機関コードを返す() {
            business = sut.set主治医医療機関コード(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医医療機関コード).build();
            assertThat(business.get主治医医療機関コード(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医医療機関コード));
        }

        @Test
        public void 戻り値の主治医コードは_設定した値と同じ主治医コードを返す() {
            business = sut.set主治医コード(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医コード).build();
            assertThat(business.get主治医コード(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医コード));
        }

        @Test
        public void 戻り値の主治医氏名は_設定した値と同じ主治医氏名を返す() {
            business = sut.set主治医氏名(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医氏名).build();
            assertThat(business.get主治医氏名(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医氏名));
        }

        @Test
        public void 戻り値の主治医カナは_設定した値と同じ主治医カナを返す() {
            business = sut.set主治医カナ(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医カナ).build();
            assertThat(business.get主治医カナ(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_主治医カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT5912ShujiiJohoEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT5912ShujiiJohoEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT5912ShujiiJohoEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値のFAX番号は_設定した値と同じFAX番号を返す() {
            business = sut.setFAX番号(DbT5912ShujiiJohoEntityGenerator.DEFAULT_FAX番号).build();
            assertThat(business.getFAX番号(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_FAX番号));
        }

        @Test
        public void 戻り値の診療科名称は_設定した値と同じ診療科名称を返す() {
            business = sut.set診療科名称(DbT5912ShujiiJohoEntityGenerator.DEFAULT_診療科名称).build();
            assertThat(business.get診療科名称(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_診療科名称));
        }

        @Test
        public void 戻り値の指定医フラグは_設定した値と同じ指定医フラグを返す() {
            business = sut.set指定医フラグ(DbT5912ShujiiJohoEntityGenerator.DEFAULT_指定医フラグ).build();
            assertThat(business.get指定医フラグ(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_指定医フラグ));
        }

        @Test
        public void 戻り値の状況フラグは_設定した値と同じ状況フラグを返す() {
            business = sut.set状況フラグ(DbT5912ShujiiJohoEntityGenerator.DEFAULT_状況フラグ).build();
            assertThat(business.get状況フラグ(), is(DbT5912ShujiiJohoEntityGenerator.DEFAULT_状況フラグ));
        }

    }
}
