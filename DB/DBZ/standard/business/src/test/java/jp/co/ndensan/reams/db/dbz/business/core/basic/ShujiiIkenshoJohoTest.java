/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5302ShujiiIkenshoJohoEntityGenerator;
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
 * {@link ShujiiIkenshoJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoJohoTest extends DbzTestBase {

    private static DbT5302ShujiiIkenshoJohoEntity ShujiiIkenshoJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static 主キー型1 主キー名1;
    private static 主キー型2 主キー名2;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主キー名1;
        主キー名2 = DbT5302ShujiiIkenshoJohoEntityGenerator.DEFAULT_主キー名2;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoJoho(null, 主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoJoho(主キー名1, null);
        }

        @Test
        public void 指定したキーが保持するDbT5302ShujiiIkenshoJohoEntityにセットされている() {
            sut = new ShujiiIkenshoJoho(主キー名1, 主キー名2);
            assertThat(sut.get主キー名1(), is(主キー名1));
            assertThat(sut.get主キー名2(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShujiiIkenshoJohoIdentifierにセットされている() {
            sut = new ShujiiIkenshoJoho(主キー名1, 主キー名2);
            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIkenshoJoho(null);
        }

        @Test
        public void 指定したDbT5302ShujiiIkenshoJohoEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);

            assertThat(sut.identifier().getXXX(), is(主キー名1));
            assertThat(sut.identifier().getXXX(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();

            sut = new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(ShujiiIkenshoJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(ShujiiIkenshoJohoEntity.getIkenshoIraiRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(ShujiiIkenshoJohoEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get主治医意見書依頼区分は_entityが持つ主治医意見書依頼区分を返す() {
            assertThat(sut.get主治医意見書依頼区分(), is(ShujiiIkenshoJohoEntity.getIkenshoIraiKubun()));
        }

        @Test
        public void get主治医医療機関コードは_entityが持つ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(ShujiiIkenshoJohoEntity.getShujiiIryoKikanCode()));
        }

        @Test
        public void get主治医コードは_entityが持つ主治医コードを返す() {
            assertThat(sut.get主治医コード(), is(ShujiiIkenshoJohoEntity.getShujiiCode()));
        }

        @Test
        public void get主治医意見書受領年月日は_entityが持つ主治医意見書受領年月日を返す() {
            assertThat(sut.get主治医意見書受領年月日(), is(ShujiiIkenshoJohoEntity.getIkenshoJuryoYMD()));
        }

        @Test
        public void get主治医意見書記入年月日は_entityが持つ主治医意見書記入年月日を返す() {
            assertThat(sut.get主治医意見書記入年月日(), is(ShujiiIkenshoJohoEntity.getIkenshoKinyuYMD()));
        }

        @Test
        public void get意見書作成回数区分は_entityが持つ意見書作成回数区分を返す() {
            assertThat(sut.get意見書作成回数区分(), is(ShujiiIkenshoJohoEntity.getIkenshoSakuseiKaisuKubun()));
        }

        @Test
        public void get在宅／施設区分は_entityが持つ在宅

        ／施設区分を返す() {
            assertThat(sut.get在宅
            ／施設区分()
            , is(ShujiiIkenshoJohoEntity.getZaitakuShisetsuKubun())


        );
        }

        @Test
        public void get意見書同意フラグは_entityが持つ意見書同意フラグを返す() {
            assertThat(sut.get意見書同意フラグ(), is(ShujiiIkenshoJohoEntity.getIkenshoDoiFlag()));
        }

        @Test
        public void get最終診療日は_entityが持つ最終診療日を返す() {
            assertThat(sut.get最終診療日(), is(ShujiiIkenshoJohoEntity.getSaishuShinryoYMD()));
        }

        @Test
        public void get他科受診の有無は_entityが持つ他科受診の有無を返す() {
            assertThat(sut.get他科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistTakaJushinFlag()));
        }

        @Test
        public void get内科受診の有無は_entityが持つ内科受診の有無を返す() {
            assertThat(sut.get内科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistNaikaJushinFlag()));
        }

        @Test
        public void get精神科受診の有無は_entityが持つ精神科受診の有無を返す() {
            assertThat(sut.get精神科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistSeishinkaJushinFlag()));
        }

        @Test
        public void get外科受診の有無は_entityが持つ外科受診の有無を返す() {
            assertThat(sut.get外科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistGekaJushinFlag()));
        }

        @Test
        public void get整形外科受診の有無は_entityが持つ整形外科受診の有無を返す() {
            assertThat(sut.get整形外科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistSeikeigekaJushinFlag()));
        }

        @Test
        public void get脳神経外科の有無は_entityが持つ脳神経外科の有無を返す() {
            assertThat(sut.get脳神経外科の有無(), is(ShujiiIkenshoJohoEntity.getExistNoshinkeigekaJushinFlag()));
        }

        @Test
        public void get皮膚科受診の有無は_entityが持つ皮膚科受診の有無を返す() {
            assertThat(sut.get皮膚科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistHifukaJushinFlag()));
        }

        @Test
        public void get泌尿器科受診の有無は_entityが持つ泌尿器科受診の有無を返す() {
            assertThat(sut.get泌尿器科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistHinyokikaJushinFlag()));
        }

        @Test
        public void get婦人科受診の有無は_entityが持つ婦人科受診の有無を返す() {
            assertThat(sut.get婦人科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistFujinkaJushinFlag()));
        }

        @Test
        public void get耳鼻咽喉科受診の有無は_entityが持つ耳鼻咽喉科受診の有無を返す() {
            assertThat(sut.get耳鼻咽喉科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistJibiinkokaJushinFlag()));
        }

        @Test
        public void getリハビリテーション科受診の有無は_entityが持つリハビリテーション科受診の有無を返す() {
            assertThat(sut.getリハビリテーション科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistRehabilitationkaJushinFlag()));
        }

        @Test
        public void get歯科受診の有無は_entityが持つ歯科受診の有無を返す() {
            assertThat(sut.get歯科受診の有無(), is(ShujiiIkenshoJohoEntity.getExistShikaJushinFlag()));
        }

        @Test
        public void get眼科の有無は_entityが持つ眼科の有無を返す() {
            assertThat(sut.get眼科の有無(), is(ShujiiIkenshoJohoEntity.getExistGankaJushinFlag()));
        }

        @Test
        public void getその他受診科の有無は_entityが持つその他受診科の有無を返す() {
            assertThat(sut.getその他受診科の有無(), is(ShujiiIkenshoJohoEntity.getExistSonotaJushinkaFlag()));
        }

        @Test
        public void getその他受診科名は_entityが持つその他受診科名を返す() {
            assertThat(sut.getその他受診科名(), is(ShujiiIkenshoJohoEntity.getSonotaJushinKaShimei()));
        }

        @Test
        public void get意見書メモは_entityが持つ意見書メモを返す() {
            assertThat(sut.get意見書メモ(), is(ShujiiIkenshoJohoEntity.getIkenshoMemo()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();

            sut = new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIkenshoJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();

            sut = new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiIkenshoJoho sut;
        private static ShujiiIkenshoJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoJohoEntity = DbT5302ShujiiIkenshoJohoEntityGenerator.createDbT5302ShujiiIkenshoJohoEntity();

        }

        @Test
        public void ShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIkenshoJohoが保持するDbT5302ShujiiIkenshoJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIkenshoJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIkenshoJoho setStateShujiiIkenshoJoho(EntityDataState parentState) {
            ShujiiIkenshoJohoEntity.setState(parentState);
            return new ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity);
        }
    }
}
