/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5914SonotaKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
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
 * {@link SonotaKikanJohoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class SonotaKikanJohoBuilderTest extends DbeTestBase {

    private static DbT5914SonotaKikanJohoEntity SonotaKikanJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShoKisaiHokenshaNo 証記載保険者番号;
    private static RString その他機関コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        証記載保険者番号 = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号;
        その他機関コード = DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード;
    }

    public static class getterSetterTest extends DbeTestBase {

        private static SonotaKikanJohoBuilder sut;
        private static SonotaKikanJoho business;

        @Before
        public void setUp() {
            SonotaKikanJohoEntity = new DbT5914SonotaKikanJohoEntity();

            business = new SonotaKikanJoho(SonotaKikanJohoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の証記載保険者番号は_設定した値と同じ証記載保険者番号を返す() {
            business = sut.set証記載保険者番号(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号).build();
            assertThat(business.get証記載保険者番号(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_証記載保険者番号));
        }

        @Test
        public void 戻り値のその他機関コードは_設定した値と同じその他機関コードを返す() {
            business = sut.setその他機関コード(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード).build();
            assertThat(business.getその他機関コード(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_その他機関コード));
        }

        @Test
        public void 戻り値の機関名称は_設定した値と同じ機関名称を返す() {
            business = sut.set機関名称(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関名称).build();
            assertThat(business.get機関名称(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関名称));
        }

        @Test
        public void 戻り値の機関名称カナは_設定した値と同じ機関名称カナを返す() {
            business = sut.set機関名称カナ(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関名称カナ).build();
            assertThat(business.get機関名称カナ(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関名称カナ));
        }

        @Test
        public void 戻り値の郵便番号は_設定した値と同じ郵便番号を返す() {
            business = sut.set郵便番号(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_郵便番号).build();
            assertThat(business.get郵便番号(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_郵便番号));
        }

        @Test
        public void 戻り値の住所は_設定した値と同じ住所を返す() {
            business = sut.set住所(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_住所).build();
            assertThat(business.get住所(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_住所));
        }

        @Test
        public void 戻り値の住所カナは_設定した値と同じ住所カナを返す() {
            business = sut.set住所カナ(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_住所カナ).build();
            assertThat(business.get住所カナ(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_住所カナ));
        }

        @Test
        public void 戻り値の電話番号は_設定した値と同じ電話番号を返す() {
            business = sut.set電話番号(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_電話番号).build();
            assertThat(business.get電話番号(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_電話番号));
        }

        @Test
        public void 戻り値の調査委託区分は_設定した値と同じ調査委託区分を返す() {
            business = sut.set調査委託区分(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_調査委託区分).build();
            assertThat(business.get調査委託区分(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_調査委託区分));
        }

        @Test
        public void 戻り値の割付定員は_設定した値と同じ割付定員を返す() {
            business = sut.set割付定員(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_割付定員).build();
            assertThat(business.get割付定員(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_割付定員));
        }

        @Test
        public void 戻り値の割付地区は_設定した値と同じ割付地区を返す() {
            business = sut.set割付地区(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_割付地区).build();
            assertThat(business.get割付地区(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_割付地区));
        }

        @Test
        public void 戻り値の機関の区分は_設定した値と同じ機関の区分を返す() {
            business = sut.set機関の区分(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関の区分).build();
            assertThat(business.get機関の区分(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_機関の区分));
        }

        @Test
        public void 戻り値の廃止フラグは_設定した値と同じ廃止フラグを返す() {
            business = sut.set廃止フラグ(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_廃止フラグ).build();
            assertThat(business.is廃止フラグ(), is(DbT5914SonotaKikanJohoEntityGenerator.DEFAULT_廃止フラグ));
        }

    }
}
