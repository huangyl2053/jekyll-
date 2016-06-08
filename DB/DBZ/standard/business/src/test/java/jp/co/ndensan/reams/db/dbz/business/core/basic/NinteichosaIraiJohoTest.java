/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5201NinteichosaIraiJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteichosaIraiJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class NinteichosaIraiJohoTest extends DbzTestBase {

    private static DbT5201NinteichosaIraiJohoEntity NinteichosaIraiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 認定調査依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
        認定調査依頼履歴番号 = DbT5201NinteichosaIraiJohoEntityGenerator.DEFAULT_認定調査依頼履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new NinteichosaIraiJoho(null, 認定調査依頼履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5201NinteichosaIraiJohoEntityにセットされている() {
            sut = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するNinteichosaIraiJohoIdentifierにセットされている() {
            sut = new NinteichosaIraiJoho(申請書管理番号, 認定調査依頼履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new NinteichosaIraiJoho(null);
        }

        @Test
        public void 指定したDbT5201NinteichosaIraiJohoEntityのキー情報を識別子が持つ() {

            sut = new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get認定調査依頼履歴番号(), is(認定調査依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();

            sut = new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(NinteichosaIraiJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get認定調査依頼履歴番号は_entityが持つ認定調査依頼履歴番号を返す() {
            assertThat(sut.get認定調査依頼履歴番号(), is(NinteichosaIraiJohoEntity.getNinteichosaIraiRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(NinteichosaIraiJohoEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(NinteichosaIraiJohoEntity.getNinteichosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(NinteichosaIraiJohoEntity.getNinteiChosainCode()));
        }

        @Test
        public void get認定調査依頼区分コードは_entityが持つ認定調査依頼区分コードを返す() {
            assertThat(sut.get認定調査依頼区分コード(), is(NinteichosaIraiJohoEntity.getNinteichosaIraiKubunCode()));
        }

        @Test
        public void get認定調査回数は_entityが持つ認定調査回数を返す() {
            assertThat(sut.get認定調査回数(), is(NinteichosaIraiJohoEntity.getNinteichosaIraiKaisu()));
        }

        @Test
        public void get認定調査依頼年月日は_entityが持つ認定調査依頼年月日を返す() {
            assertThat(sut.get認定調査依頼年月日(), is(NinteichosaIraiJohoEntity.getNinteichosaIraiYMD()));
        }

        @Test
        public void get認定調査期限年月日は_entityが持つ認定調査期限年月日を返す() {
            assertThat(sut.get認定調査期限年月日(), is(NinteichosaIraiJohoEntity.getNinteichosaKigenYMD()));
        }

        @Test
        public void get依頼書出力年月日は_entityが持つ依頼書出力年月日を返す() {
            assertThat(sut.get依頼書出力年月日(), is(NinteichosaIraiJohoEntity.getIraishoShutsuryokuYMD()));
        }

        @Test
        public void get調査票等出力年月日は_entityが持つ調査票等出力年月日を返す() {
            assertThat(sut.get調査票等出力年月日(), is(NinteichosaIraiJohoEntity.getChosahyoTouShutsuryokuYMD()));
        }

        @Test
        public void isモバイルデータ出力済フラグは_entityが持つモバイルデータ出力済フラグを返す() {
            assertThat(sut.isモバイルデータ出力済フラグ(), is(NinteichosaIraiJohoEntity.getMobileDataShutsuryokuZumiFlag()));
        }

        @Test
        public void is事前調査フラグは_entityが持つ事前調査フラグを返す() {
            assertThat(sut.is事前調査フラグ(), is(NinteichosaIraiJohoEntity.getJizenChosaFlag()));
        }

        @Test
        public void get認定調査督促年月日は_entityが持つ認定調査督促年月日を返す() {
            assertThat(sut.get認定調査督促年月日(), is(NinteichosaIraiJohoEntity.getNinteichosaTokusokuYMD()));
        }

        @Test
        public void get認定調査督促方法は_entityが持つ認定調査督促方法を返す() {
            assertThat(sut.get認定調査督促方法(), is(NinteichosaIraiJohoEntity.getNinteichosaTokusokuHoho()));
        }

        @Test
        public void get認定調査督促回数は_entityが持つ認定調査督促回数を返す() {
            assertThat(sut.get認定調査督促回数(), is(NinteichosaIraiJohoEntity.getNinteichosaTokusokuKaisu()));
        }

        @Test
        public void get認定調査督促メモは_entityが持つ認定調査督促メモを返す() {
            assertThat(sut.get認定調査督促メモ(), is(NinteichosaIraiJohoEntity.getNinteichosaTokusokuMemo()));
        }

        @Test
        public void is論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.is論理削除フラグ(), is(NinteichosaIraiJohoEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();

            sut = new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(NinteichosaIraiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();

            sut = new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static NinteichosaIraiJoho sut;
        private static NinteichosaIraiJoho result;

        @BeforeClass
        public static void setUpClass() {
            NinteichosaIraiJohoEntity = DbT5201NinteichosaIraiJohoEntityGenerator.createDbT5201NinteichosaIraiJohoEntity();

        }

        @Test
        public void NinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりNinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaIraiJohoが返る() {
            sut = TestSupport.setStateNinteichosaIraiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりNinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaIraiJohoが返る() {
            sut = TestSupport.setStateNinteichosaIraiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void NinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりNinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがDeletedに指定されたNinteichosaIraiJohoが返る() {
            sut = TestSupport.setStateNinteichosaIraiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void NinteichosaIraiJohoが保持するDbT5201NinteichosaIraiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateNinteichosaIraiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static NinteichosaIraiJoho setStateNinteichosaIraiJoho(EntityDataState parentState) {
            NinteichosaIraiJohoEntity.setState(parentState);
            return new NinteichosaIraiJoho(NinteichosaIraiJohoEntity);
        }
    }
}
