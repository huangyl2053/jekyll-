/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbV7901ShikakuSearchEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShikakuSearchAliveBuilder}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShikakuSearchAliveBuilderTest extends DbzTestBase {

    private static DbV7901ShikakuSearchEntity ShikakuSearchAliveEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static ShikakuSearchAliveBuilder sut;
        private static ShikakuSearchAlive business;

        @Before
        public void setUp() {
            ShikakuSearchAliveEntity = new DbV7901ShikakuSearchEntity();

            business = new ShikakuSearchAlive(ShikakuSearchAliveEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の資格取得事由コードは_設定した値と同じ資格取得事由コードを返す() {
            business = sut.set資格取得事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格取得事由コード).build();
            assertThat(business.get資格取得事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格取得事由コード));
        }

        @Test
        public void 戻り値の資格取得年月日は_設定した値と同じ資格取得年月日を返す() {
            business = sut.set資格取得年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格取得年月日).build();
            assertThat(business.get資格取得年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格取得年月日));
        }

        @Test
        public void 戻り値の被保険者区分コードは_設定した値と同じ被保険者区分コードを返す() {
            business = sut.set被保険者区分コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者区分コード).build();
            assertThat(business.get被保険者区分コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void 戻り値の資格喪失事由コードは_設定した値と同じ資格喪失事由コードを返す() {
            business = sut.set資格喪失事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格喪失事由コード).build();
            assertThat(business.get資格喪失事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格喪失事由コード));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            business = sut.set資格喪失年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格喪失年月日).build();
            assertThat(business.get資格喪失年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の住所地特例フラグは_設定した値と同じ住所地特例フラグを返す() {
            business = sut.set住所地特例フラグ(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例フラグ).build();
            assertThat(business.get住所地特例フラグ(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例フラグ));
        }

        @Test
        public void 戻り値の資格変更事由コードは_設定した値と同じ資格変更事由コードを返す() {
            business = sut.set資格変更事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格変更事由コード).build();
            assertThat(business.get資格変更事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格変更事由コード));
        }

        @Test
        public void 戻り値の資格変更年月日は_設定した値と同じ資格変更年月日を返す() {
            business = sut.set資格変更年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格変更年月日).build();
            assertThat(business.get資格変更年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_資格変更年月日));
        }

        @Test
        public void 戻り値の住所地特例適用事由コードは_設定した値と同じ住所地特例適用事由コードを返す() {
            business = sut.set住所地特例適用事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例適用事由コード).build();
            assertThat(business.get住所地特例適用事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例適用事由コード));
        }

        @Test
        public void 戻り値の住所地特例適用年月日は_設定した値と同じ住所地特例適用年月日を返す() {
            business = sut.set住所地特例適用年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例適用年月日).build();
            assertThat(business.get住所地特例適用年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例適用年月日));
        }

        @Test
        public void 戻り値の住所地特例解除事由コードは_設定した値と同じ住所地特例解除事由コードを返す() {
            business = sut.set住所地特例解除事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例解除事由コード).build();
            assertThat(business.get住所地特例解除事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例解除事由コード));
        }

        @Test
        public void 戻り値の住所地特例解除年月日は_設定した値と住所地特例同じ解除年月日を返す() {
            business = sut.set住所地特例解除年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例解除年月日).build();
            assertThat(business.get住所地特例解除年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_住所地特例解除年月日));
        }

        @Test
        public void 戻り値の広域内住所地特例フラグは_設定した値と同じ広域内住所地特例フラグを返す() {
            business = sut.set広域内住所地特例フラグ(DbV7901ShikakuSearchEntityGenerator.DEFAULT_広域内住所地特例フラグ).build();
            assertThat(business.get広域内住所地特例フラグ(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_広域内住所地特例フラグ));
        }

        @Test
        public void 戻り値の広住特措置元市町村コードは_設定した値と同じ広住特措置元市町村コードを返す() {
            business = sut.set広住特措置元市町村コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_広住特措置元市町村コード).build();
            assertThat(business.get広住特措置元市町村コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_広住特措置元市町村コード));
        }

        @Test
        public void 戻り値の適用除外適用事由コードは_設定した値と同じ適用除外適用事由コードを返す() {
            business = sut.set適用除外適用事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外適用事由コード).build();
            assertThat(business.get適用除外適用事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外適用事由コード));
        }

        @Test
        public void 戻り値の適用除外適用年月日は_設定した値と同じ適用除外適用年月日を返す() {
            business = sut.set適用除外適用年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外適用年月日).build();
            assertThat(business.get適用除外適用年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外適用年月日));
        }

        @Test
        public void 戻り値の適用除外解除事由コードは_設定した値と同じ適用除外解除事由コードを返す() {
            business = sut.set適用除外解除事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外解除事由コード).build();
            assertThat(business.get適用除外解除事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外解除事由コード));
        }

        @Test
        public void 戻り値の適用除外適用除外除年月日は_設定した値と適用除外同じ解除年月日を返す() {
            business = sut.set適用除外解除年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外解除年月日).build();
            assertThat(business.get適用除外解除年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_適用除外解除年月日));
        }

        @Test
        public void 戻り値の他市町村住所地特例適用事由コードは_設定した値と同じ他市町村住所地特例適用事由コードを返す() {
            business = sut.set他市町村住所地特例適用事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例適用事由コード).build();
            assertThat(business.get他市町村住所地特例適用事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例適用事由コード));
        }

        @Test
        public void 戻り値の他市町村住所地特例適用年月日は_設定した値と同じ他市町村住所地特例適用年月日を返す() {
            business = sut.set他市町村住所地特例適用年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例適用年月日).build();
            assertThat(business.get他市町村住所地特例適用年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例適用年月日));
        }

        @Test
        public void 戻り値の他市町村住所地特例解除事由コードは_設定した値と同じ他市町村住所地特例解除事由コードを返す() {
            business = sut.set他市町村住所地特例解除事由コード(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例解除事由コード).build();
            assertThat(business.get他市町村住所地特例解除事由コード(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例解除事由コード));
        }

        @Test
        public void 戻り値の他市町村住所地特例解除年月日は_設定した値と同じ他市町村住所地特例解除年月日を返す() {
            business = sut.set他市町村住所地特例解除年月日(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例解除年月日).build();
            assertThat(business.get他市町村住所地特例解除年月日(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_他市町村住所地特例解除年月日));
        }

        @Test
        public void 戻り値の受給者台帳被保険者番号は_設定した値と同じ受給者台帳被保険者番号を返す() {
            business = sut.set受給者台帳被保険者番号(DbV7901ShikakuSearchEntityGenerator.DEFAULT_受給者台帳被保険者番号).build();
            assertThat(business.get受給者台帳被保険者番号(), is(DbV7901ShikakuSearchEntityGenerator.DEFAULT_受給者台帳被保険者番号));
        }

    }
}
