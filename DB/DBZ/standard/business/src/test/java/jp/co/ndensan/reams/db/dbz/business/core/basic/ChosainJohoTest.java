/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChosainJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChosainJohoTest extends DbzTestBase {

    private static DbT5913ChosainJohoEntity chosainJohoEntity;
    private static LasdecCode 市町村コード;
    private static ChosaItakusakiCode 認定調査委託先コード;
    private static ChosainCode 認定調査員コード;

    @BeforeClass
    public static void setUpClass() {
        市町村コード = DbT5913ChosainJohoEntityGenerator.DEFAULT_市町村コード;
        認定調査委託先コード = DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査委託先コード;
        認定調査員コード = DbT5913ChosainJohoEntityGenerator.DEFAULT_認定調査員コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosainJoho(null, 認定調査委託先コード, 認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査委託先コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosainJoho(市町村コード, null, 認定調査員コード);
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査員コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosainJoho(市町村コード, 認定調査委託先コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5913ChosainJohoEntityにセットされている() {
            sut = new ChosainJoho(市町村コード, 認定調査委託先コード, 認定調査員コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.get認定調査員コード(), is(認定調査員コード));
        }

        @Test
        public void 指定したキーが保持するChosainJohoIdentifierにセットされている() {
            sut = new ChosainJoho(市町村コード, 認定調査委託先コード, 認定調査員コード);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.identifier().get認定調査員コード(), is(認定調査員コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChosainJoho(null);
        }

        @Test
        public void 指定したDbT5913ChosainJohoEntityのキー情報を識別子が持つ() {

            sut = new ChosainJoho(chosainJohoEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get認定調査委託先コード(), is(認定調査委託先コード));
            assertThat(sut.identifier().get認定調査員コード(), is(認定調査員コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(chosainJohoEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(chosainJohoEntity.getShichosonCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(chosainJohoEntity.getNinteichosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(chosainJohoEntity.getNinteiChosainNo()));
        }

        @Test
        public void get調査員氏名は_entityが持つ調査員氏名を返す() {
            assertThat(sut.get調査員氏名(), is(chosainJohoEntity.getChosainShimei()));
        }

        @Test
        public void get調査員氏名カナは_entityが持つ調査員氏名カナを返す() {
            assertThat(sut.get調査員氏名カナ(), is(chosainJohoEntity.getChosainKanaShimei()));
        }

        @Test
        public void get性別は_entityが持つ性別を返す() {
            assertThat(sut.get性別(), is(chosainJohoEntity.getSeibetsu()));
        }

        @Test
        public void get調査員資格は_entityが持つ調査員資格を返す() {
            assertThat(sut.get調査員資格(), is(chosainJohoEntity.getChosainShikaku()));
        }

        @Test
        public void get地区コードは_entityが持つ地区コードを返す() {
            assertThat(sut.get地区コード(), is(chosainJohoEntity.getChikuCode()));
        }

        @Test
        public void get調査可能人数_月は_entityが持つ調査可能人数_月を返す() {
            assertThat(sut.get調査可能人数_月(), is(chosainJohoEntity.getChosaKanoNinzuPerMonth()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(chosainJohoEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(chosainJohoEntity.getJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(chosainJohoEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(chosainJohoEntity.getFaxNo()));
        }

        @Test
        public void get状況フラグは_entityが持つ状況フラグを返す() {
            assertThat(sut.get状況フラグ(), is(chosainJohoEntity.getJokyoFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(chosainJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(chosainJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(chosainJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ChosainJoho sut;
        private static ChosainJoho result;

        @BeforeClass
        public static void setUpClass() {
            chosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

        }

        @Test
        public void ChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがDeletedに指定されたChosainJohoが返る() {
            sut = TestSupport.setStateChosainJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがDeletedに指定されたChosainJohoが返る() {
            sut = TestSupport.setStateChosainJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがDeletedに指定されたChosainJohoが返る() {
            sut = TestSupport.setStateChosainJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ChosainJohoが保持するDbT5913ChosainJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateChosainJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ChosainJoho setStateChosainJoho(EntityDataState parentState) {
            chosainJohoEntity.setState(parentState);
            return new ChosainJoho(chosainJohoEntity);
        }
    }
}
