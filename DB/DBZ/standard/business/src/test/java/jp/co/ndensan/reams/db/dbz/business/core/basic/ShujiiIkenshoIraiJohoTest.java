/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5301ShujiiIkenshoIraiJohoEntityGenerator;
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
 * {@link ShujiiIkenshoIraiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoIraiJohoTest extends DbzTestBase {

    private static DbT5301ShujiiIkenshoIraiJohoEntity ShujiiIkenshoIraiJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoIraiJoho(null, 主治医意見書作成依頼履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT5301ShujiiIkenshoIraiJohoEntityにセットされている() {
            sut = new ShujiiIkenshoIraiJoho(申請書管理番号, 主治医意見書作成依頼履歴番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(主治医意見書作成依頼履歴番号));
        }

        @Test
        public void 指定したキーが保持するShujiiIkenshoIraiJohoIdentifierにセットされている() {
            sut = new ShujiiIkenshoIraiJoho(申請書管理番号, 主治医意見書作成依頼履歴番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get主治医意見書作成依頼履歴番号(), is(主治医意見書作成依頼履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIkenshoIraiJoho(null);
        }

        @Test
        public void 指定したDbT5301ShujiiIkenshoIraiJohoEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);

            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get主治医意見書作成依頼履歴番号(), is(主治医意見書作成依頼履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();

            sut = new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(ShujiiIkenshoIraiJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoIraiRirekiNo()));
        }

        @Test
        public void get厚労省IF識別コードは_entityが持つ厚労省IF識別コードを返す() {
            assertThat(sut.get厚労省IF識別コード(), is(ShujiiIkenshoIraiJohoEntity.getKoroshoIfShikibetsuCode()));
        }

        @Test
        public void get主治医医療機関コードは_entityが持つ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(ShujiiIkenshoIraiJohoEntity.getShujiiIryokikanCode()));
        }

        @Test
        public void get主治医コードは_entityが持つ主治医コードを返す() {
            assertThat(sut.get主治医コード(), is(ShujiiIkenshoIraiJohoEntity.getShujiiCode()));
        }

        @Test
        public void get主治医意見書依頼区分は_entityが持つ主治医意見書依頼区分を返す() {
            assertThat(sut.get主治医意見書依頼区分(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoIraiKubun()));
        }

        @Test
        public void get主治医意見書作成回数は_entityが持つ主治医意見書作成回数を返す() {
            assertThat(sut.get主治医意見書作成回数(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoIraiKaisu()));
        }

        @Test
        public void get医師区分コードは_entityが持つ医師区分コードを返す() {
            assertThat(sut.get医師区分コード(), is(ShujiiIkenshoIraiJohoEntity.getIshiKubunCode()));
        }

        @Test
        public void get主治医意見書作成依頼年月日は_entityが持つ主治医意見書作成依頼年月日を返す() {
            assertThat(sut.get主治医意見書作成依頼年月日(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoSakuseiIraiYMD()));
        }

        @Test
        public void get主治医意見書作成期限年月日は_entityが持つ主治医意見書作成期限年月日を返す() {
            assertThat(sut.get主治医意見書作成期限年月日(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoSakuseiKigenYMD()));
        }

        @Test
        public void get依頼書出力年月日は_entityが持つ依頼書出力年月日を返す() {
            assertThat(sut.get依頼書出力年月日(), is(ShujiiIkenshoIraiJohoEntity.getIraishoShutsuryokuYMD()));
        }

        @Test
        public void get意見書出力年月日は_entityが持つ意見書出力年月日を返す() {
            assertThat(sut.get意見書出力年月日(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoShutsuryokuYMD()));
        }

        @Test
        public void get請求書出力年月日は_entityが持つ請求書出力年月日を返す() {
            assertThat(sut.get請求書出力年月日(), is(ShujiiIkenshoIraiJohoEntity.getSeikyushoShutsuryokuYMD()));
        }

        @Test
        public void get作成料請求区分は_entityが持つ作成料請求区分を返す() {
            assertThat(sut.get作成料請求区分(), is(ShujiiIkenshoIraiJohoEntity.getSakuseiryoSeikyuKubun()));
        }

        @Test
        public void get主治医意見書作成督促年月日は_entityが持つ主治医意見書作成督促年月日を返す() {
            assertThat(sut.get主治医意見書作成督促年月日(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoSakuseiTokusokuYMD()));
        }

        @Test
        public void get主治医意見書作成督促方法は_entityが持つ主治医意見書作成督促方法を返す() {
            assertThat(sut.get主治医意見書作成督促方法(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoSakuseiTokusokuHoho()));
        }

        @Test
        public void get主治医意見書作成督促回数は_entityが持つ主治医意見書作成督促回数を返す() {
            assertThat(sut.get主治医意見書作成督促回数(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoTokusokuKaisu()));
        }

        @Test
        public void get主治医意見書作成督促メモは_entityが持つ主治医意見書作成督促メモを返す() {
            assertThat(sut.get主治医意見書作成督促メモ(), is(ShujiiIkenshoIraiJohoEntity.getIkenshoTokusokuMemo()));
        }

        @Test
        public void get認定情報提供希望フラグは_entityが持つ認定情報提供希望フラグを返す() {
            assertThat(sut.get認定情報提供希望フラグ(), is(ShujiiIkenshoIraiJohoEntity.getNinteiJohoTeikyoKiboFlag()));
        }

        @Test
        public void get認定状況提供年月日は_entityが持つ認定状況提供年月日を返す() {
            assertThat(sut.get認定状況提供年月日(), is(ShujiiIkenshoIraiJohoEntity.getNinteiJohoTeikyoYMD()));
        }

        @Test
        public void get論理削除フラグは_entityが持つ論理削除フラグを返す() {
            assertThat(sut.get論理削除フラグ(), is(ShujiiIkenshoIraiJohoEntity.getLogicalDeletedFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();

            sut = new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIkenshoIraiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();

            sut = new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiIkenshoIraiJoho sut;
        private static ShujiiIkenshoIraiJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoIraiJohoEntity = DbT5301ShujiiIkenshoIraiJohoEntityGenerator.createDbT5301ShujiiIkenshoIraiJohoEntity();

        }

        @Test
        public void ShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIraiJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoIraiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIraiJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoIraiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoIraiJohoが返る() {
            sut = TestSupport.setStateShujiiIkenshoIraiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIkenshoIraiJohoが保持するDbT5301ShujiiIkenshoIraiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIkenshoIraiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIkenshoIraiJoho setStateShujiiIkenshoIraiJoho(EntityDataState parentState) {
            ShujiiIkenshoIraiJohoEntity.setState(parentState);
            return new ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity);
        }
    }
}
