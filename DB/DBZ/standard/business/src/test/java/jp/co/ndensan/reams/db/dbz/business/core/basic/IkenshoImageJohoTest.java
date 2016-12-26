/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5305IkenshoImageJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link IkenshoImageJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class IkenshoImageJohoTest extends DbzTestBase {

    private static DbT5305IkenshoImageJohoEntity IkenshoImageJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static ShinseishoKanriNo 申請書管理番号;
    private static int 主治医意見書作成依頼履歴番号;
    private static Code 帳票ID;
    private static RString マスキングデータ区分;
    private static int 取込みページ番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        申請書管理番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_申請書管理番号;
        主治医意見書作成依頼履歴番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_主治医意見書作成依頼履歴番号;
        帳票ID = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_帳票ID;
        マスキングデータ区分 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_マスキングデータ区分;
        取込みページ番号 = DbT5305IkenshoImageJohoEntityGenerator.DEFAULT_取込みページ番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new IkenshoImageJoho(null, 主治医意見書作成依頼履歴番号, 帳票ID, マスキングデータ区分, 取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void 帳票IDがnullである場合に_NullPointerExceptionが発生する() {
            sut = new IkenshoImageJoho(申請書管理番号, 主治医意見書作成依頼履歴番号, null, マスキングデータ区分, 取込みページ番号);
        }

        @Test(expected = NullPointerException.class)
        public void マスキングデータ区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new IkenshoImageJoho(申請書管理番号, 主治医意見書作成依頼履歴番号, 帳票ID, null, 取込みページ番号);
        }

        @Test
        public void 指定したキーが保持するDbT5305IkenshoImageJohoEntityにセットされている() {
            sut = new IkenshoImageJoho(申請書管理番号, 主治医意見書作成依頼履歴番号, 帳票ID, マスキングデータ区分, 取込みページ番号);
            assertThat(sut.get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(主治医意見書作成依頼履歴番号));
            assertThat(sut.getマスキングデータ区分(), is(マスキングデータ区分));
            assertThat(sut.get帳票ID(), is(帳票ID));
//            assertThat(sut.get取込みページ番号(), is(取込みページ番号));
        }

        @Test
        public void 指定したキーが保持するIkenshoImageJohoIdentifierにセットされている() {
            sut = new IkenshoImageJoho(申請書管理番号, 主治医意見書作成依頼履歴番号, 帳票ID, マスキングデータ区分, 取込みページ番号);
            assertThat(sut.identifier().get申請書管理番号(), is(申請書管理番号));
            assertThat(sut.identifier().get主治医意見書作成依頼履歴番号(), is(主治医意見書作成依頼履歴番号));
            assertThat(sut.identifier().getマスキングデータ区分(), is(マスキングデータ区分));
            assertThat(sut.identifier().get帳票ID(), is(帳票ID));
//            assertThat(sut.identifier().get取込みページ番号(), is(取込みページ番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new IkenshoImageJoho(null);
        }

        @Test
        public void 指定したDbT5305IkenshoImageJohoEntityのキー情報を識別子が持つ() {

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);

//            assertThat(sut.identifier().getXXX(), is(申請書管理番号));
//            assertThat(sut.identifier().getXXX(), is(帳票ID));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void get申請書管理番号は_entityが持つ申請書管理番号を返す() {
            assertThat(sut.get申請書管理番号(), is(IkenshoImageJohoEntity.getShinseishoKanriNo()));
        }

        @Test
        public void get主治医意見書作成依頼履歴番号は_entityが持つ主治医意見書作成依頼履歴番号を返す() {
            assertThat(sut.get主治医意見書作成依頼履歴番号(), is(IkenshoImageJohoEntity.getIraiRirekiNo()));
        }

        @Test
        public void get帳票IDは_entityが持つ帳票IDを返す() {
            assertThat(sut.get帳票ID(), is(IkenshoImageJohoEntity.getChoyoID()));
        }

        @Test
        public void getマスキングデータ区分は_entityが持つマスキングデータ区分を返す() {
            assertThat(sut.getマスキングデータ区分(), is(IkenshoImageJohoEntity.getGenponMaskKubun()));
        }

//        @Test
//        public void get取込みページ番号は_entityが持つ取込みページ番号を返す() {
//            assertThat(sut.get取込みページ番号(), is(IkenshoImageJohoEntity.getTorikomiPageNo()));
//        }
//
//        @Test
//        public void get認定申請年は_entityが持つ認定申請年を返す() {
//            assertThat(sut.get認定申請年(), is(IkenshoImageJohoEntity.getNinteiShinseiNen()));
//        }
//
//        @Test
//        public void get共有ファイルIDは_entityが持つ共有ファイルIDを返す() {
//            assertThat(sut.get共有ファイルID(), is(IkenshoImageJohoEntity.getSharedFileId()));
//        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(IkenshoImageJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

            sut = new IkenshoImageJoho(IkenshoImageJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static IkenshoImageJoho sut;
        private static IkenshoImageJoho result;

        @BeforeClass
        public static void setUpClass() {
            IkenshoImageJohoEntity = DbT5305IkenshoImageJohoEntityGenerator.createDbT5305IkenshoImageJohoEntity();

        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりIkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがDeletedに指定されたIkenshoImageJohoが返る() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void IkenshoImageJohoが保持するDbT5305IkenshoImageJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateIkenshoImageJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static IkenshoImageJoho setStateIkenshoImageJoho(EntityDataState parentState) {
            IkenshoImageJohoEntity.setState(parentState);
            return new IkenshoImageJoho(IkenshoImageJohoEntity);
        }
    }
}
