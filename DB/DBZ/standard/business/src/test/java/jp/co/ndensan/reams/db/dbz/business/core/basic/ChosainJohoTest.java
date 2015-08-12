/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5913ChosainJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
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

    private static DbT5913ChosainJohoEntity ChosainJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5913ChosainJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5913ChosainJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosainJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ChosainJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5913ChosainJohoEntityにセットされている() {
            sut = new ChosainJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するChosainJohoIdentifierにセットされている() {
            sut = new ChosainJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ChosainJoho(null);
        }

        @Test
        public void 指定したDbT5913ChosainJohoEntityのキー情報を識別子が持つ() {

            sut = new ChosainJoho(ChosainJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(ChosainJohoEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ChosainJohoEntity.getShichosonCode()));
        }

        @Test
        public void get認定調査委託先コードは_entityが持つ認定調査委託先コードを返す() {
            assertThat(sut.get認定調査委託先コード(), is(ChosainJohoEntity.getNinteichosaItakusakiCode()));
        }

        @Test
        public void get認定調査員コードは_entityが持つ認定調査員コードを返す() {
            assertThat(sut.get認定調査員コード(), is(ChosainJohoEntity.getNinteiChosainNo()));
        }

        @Test
        public void get調査員氏名は_entityが持つ調査員氏名を返す() {
            assertThat(sut.get調査員氏名(), is(ChosainJohoEntity.getChosainShimei()));
        }

        @Test
        public void get調査員氏名カナは_entityが持つ調査員氏名カナを返す() {
            assertThat(sut.get調査員氏名カナ(), is(ChosainJohoEntity.getChosainKanaShimei()));
        }

        @Test
        public void get性別は_entityが持つ性別を返す() {
            assertThat(sut.get性別(), is(ChosainJohoEntity.getSeibetsu()));
        }

        @Test
        public void get調査員資格は_entityが持つ調査員資格を返す() {
            assertThat(sut.get調査員資格(), is(ChosainJohoEntity.getChosainShikaku()));
        }

        @Test
        public void get地区コードは_entityが持つ地区コードを返す() {
            assertThat(sut.get地区コード(), is(ChosainJohoEntity.getChikuCode()));
        }

        @Test
        public void get調査可能人数_月は_entityが持つ調査可能人数_月を返す() {
            assertThat(sut.get調査可能人数_月(), is(ChosainJohoEntity.getChosaKanoNinzuPerMonth()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(ChosainJohoEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(ChosainJohoEntity.getJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(ChosainJohoEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(ChosainJohoEntity.getFaxNo()));
        }

        @Test
        public void get状況フラグは_entityが持つ状況フラグを返す() {
            assertThat(sut.get状況フラグ(), is(ChosainJohoEntity.getJokyoFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(ChosainJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ChosainJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ChosainJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

            sut = new ChosainJoho(ChosainJohoEntity);
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
            ChosainJohoEntity = DbT5913ChosainJohoEntityGenerator.createDbT5913ChosainJohoEntity();

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
            ChosainJohoEntity.setState(parentState);
            return new ChosainJoho(ChosainJohoEntity);
        }
    }
}
