/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoBuilder;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT1001HihokenshaDaichoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HihokenshaDaichoBuilder}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HihokenshaDaichoBuilderTest extends DbzTestBase {

    private static DbT1001HihokenshaDaichoEntity HihokenshaDaichoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 被保険者番号;
    private static FlexibleDate 異動日;
    private static RString 枝番;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        被保険者番号 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号;
        異動日 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日;
        枝番 = DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番;
    }

    public static class getterSetterTest extends DbzTestBase {

        private static HihokenshaDaichoBuilder sut;
        private static HihokenshaDaicho business;

        @Before
        public void setUp() {
            HihokenshaDaichoEntity = new DbT1001HihokenshaDaichoEntity();
            HihokenshaDaichoEntity.setHihokenshaNo(被保険者番号);
            HihokenshaDaichoEntity.setIdoYMD(異動日);
            HihokenshaDaichoEntity.setEdaNo(枝番);

            business = new HihokenshaDaicho(HihokenshaDaichoEntity);

            sut = business.createBuilderForEdit();
        }
//TODO Key項目のテストメソッドは削除して下さい。

        @Test
        public void 戻り値の被保険者番号は_設定した値と同じ被保険者番号を返す() {
            business = sut.set被保険者番号(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号).build();
            assertThat(business.get被保険者番号(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者番号));
        }

        @Test
        public void 戻り値の異動日は_設定した値と同じ異動日を返す() {
            business = sut.set異動日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日).build();
            assertThat(business.get異動日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動日));
        }

        @Test
        public void 戻り値の枝番は_設定した値と同じ枝番を返す() {
            business = sut.set枝番(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番).build();
            assertThat(business.get枝番(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_枝番));
        }

        @Test
        public void 戻り値の異動事由コードは_設定した値と同じ異動事由コードを返す() {
            business = sut.set異動事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動事由コード).build();
            assertThat(business.get異動事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_異動事由コード));
        }

        @Test
        public void 戻り値の市町村コードは_設定した値と同じ市町村コードを返す() {
            business = sut.set市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード).build();
            assertThat(business.get市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_市町村コード));
        }

        @Test
        public void 戻り値の識別コードは_設定した値と同じ識別コードを返す() {
            business = sut.set識別コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード).build();
            assertThat(business.get識別コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_識別コード));
        }

        @Test
        public void 戻り値の資格取得事由コードは_設定した値と同じ資格取得事由コードを返す() {
            business = sut.set資格取得事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得事由コード).build();
            assertThat(business.get資格取得事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得事由コード));
        }

        @Test
        public void 戻り値の資格取得年月日は_設定した値と同じ資格取得年月日を返す() {
            business = sut.set資格取得年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得年月日).build();
            assertThat(business.get資格取得年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得年月日));
        }

        @Test
        public void 戻り値の資格取得届出年月日は_設定した値と同じ資格取得届出年月日を返す() {
            business = sut.set資格取得届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得届出年月日).build();
            assertThat(business.get資格取得届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格取得届出年月日));
        }

        @Test
        public void 戻り値の第1号資格取得年月日は_設定した値と同じ第1号資格取得年月日を返す() {
            business = sut.set第1号資格取得年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_第1号資格取得年月日).build();
            assertThat(business.get第1号資格取得年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_第1号資格取得年月日));
        }

        @Test
        public void 戻り値の被保険者区分コードは_設定した値と同じ被保険者区分コードを返す() {
            business = sut.set被保険者区分コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者区分コード).build();
            assertThat(business.get被保険者区分コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_被保険者区分コード));
        }

        @Test
        public void 戻り値の資格喪失事由コードは_設定した値と同じ資格喪失事由コードを返す() {
            business = sut.set資格喪失事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失事由コード).build();
            assertThat(business.get資格喪失事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失事由コード));
        }

        @Test
        public void 戻り値の資格喪失年月日は_設定した値と同じ資格喪失年月日を返す() {
            business = sut.set資格喪失年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失年月日).build();
            assertThat(business.get資格喪失年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失年月日));
        }

        @Test
        public void 戻り値の資格喪失届出年月日は_設定した値と同じ資格喪失届出年月日を返す() {
            business = sut.set資格喪失届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失届出年月日).build();
            assertThat(business.get資格喪失届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格喪失届出年月日));
        }

        @Test
        public void 戻り値の資格変更事由コードは_設定した値と同じ資格変更事由コードを返す() {
            business = sut.set資格変更事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更事由コード).build();
            assertThat(business.get資格変更事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更事由コード));
        }

        @Test
        public void 戻り値の資格変更年月日は_設定した値と同じ資格変更年月日を返す() {
            business = sut.set資格変更年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更年月日).build();
            assertThat(business.get資格変更年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更年月日));
        }

        @Test
        public void 戻り値の資格変更届出年月日は_設定した値と同じ資格変更届出年月日を返す() {
            business = sut.set資格変更届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更届出年月日).build();
            assertThat(business.get資格変更届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_資格変更届出年月日));
        }

        @Test
        public void 戻り値の住所地特例適用事由コードは_設定した値と同じ住所地特例適用事由コードを返す() {
            business = sut.set住所地特例適用事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例適用事由コード).build();
            assertThat(business.get住所地特例適用事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例適用事由コード));
        }

        @Test
        public void 戻り値の適用年月日は_設定した値と同じ適用年月日を返す() {
            business = sut.set適用年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用年月日).build();
            assertThat(business.get適用年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用年月日));
        }

        @Test
        public void 戻り値の適用届出年月日は_設定した値と同じ適用届出年月日を返す() {
            business = sut.set適用届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用届出年月日).build();
            assertThat(business.get適用届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_適用届出年月日));
        }

        @Test
        public void 戻り値の住所地特例解除事由コードは_設定した値と同じ住所地特例解除事由コードを返す() {
            business = sut.set住所地特例解除事由コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例解除事由コード).build();
            assertThat(business.get住所地特例解除事由コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例解除事由コード));
        }

        @Test
        public void 戻り値の解除年月日は_設定した値と同じ解除年月日を返す() {
            business = sut.set解除年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除年月日).build();
            assertThat(business.get解除年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除年月日));
        }

        @Test
        public void 戻り値の解除届出年月日は_設定した値と同じ解除届出年月日を返す() {
            business = sut.set解除届出年月日(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除届出年月日).build();
            assertThat(business.get解除届出年月日(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_解除届出年月日));
        }

        @Test
        public void 戻り値の住所地特例フラグは_設定した値と同じ住所地特例フラグを返す() {
            business = sut.set住所地特例フラグ(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例フラグ).build();
            assertThat(business.get住所地特例フラグ(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_住所地特例フラグ));
        }

        @Test
        public void 戻り値の広域内住所地特例フラグは_設定した値と同じ広域内住所地特例フラグを返す() {
            business = sut.set広域内住所地特例フラグ(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広域内住所地特例フラグ).build();
            assertThat(business.get広域内住所地特例フラグ(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広域内住所地特例フラグ));
        }

        @Test
        public void 戻り値の広住特措置元市町村コードは_設定した値と同じ広住特措置元市町村コードを返す() {
            business = sut.set広住特措置元市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広住特措置元市町村コード).build();
            assertThat(business.get広住特措置元市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_広住特措置元市町村コード));
        }

        @Test
        public void 戻り値の旧市町村コードは_設定した値と同じ旧市町村コードを返す() {
            business = sut.set旧市町村コード(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_旧市町村コード).build();
            assertThat(business.get旧市町村コード(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_旧市町村コード));
        }

        @Test
        public void 戻り値の論理削除フラグは_設定した値と同じ論理削除フラグを返す() {
            business = sut.set論理削除フラグ(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_論理削除フラグ).build();
            assertThat(business.get論理削除フラグ(), is(DbT1001HihokenshaDaichoEntityGenerator.DEFAULT_論理削除フラグ));
        }

    }
}
