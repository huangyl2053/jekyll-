/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5912ShujiiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5912ShujiiJohoEntityGenerator;
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
 * {@link ShujiiJoho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiJohoTest extends DbzTestBase {

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

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiJoho(null, 主治医医療機関コード, 主治医コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiJoho(市町村コード, null, 主治医コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiJoho(市町村コード, 主治医医療機関コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5912ShujiiJohoEntityにセットされている() {
            sut = new ShujiiJoho(市町村コード, 主治医医療機関コード, 主治医コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get主治医医療機関コード(), is(主治医医療機関コード));
        }

        @Test
        public void 指定したキーが保持するShujiiJohoIdentifierにセットされている() {
            sut = new ShujiiJoho(市町村コード, 主治医医療機関コード, 主治医コード);
//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(主治医医療機関コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiJoho(null);
        }

        @Test
        public void 指定したDbT5912ShujiiJohoEntityのキー情報を識別子が持つ() {

            sut = new ShujiiJoho(ShujiiJohoEntity);

//            assertThat(sut.identifier().getXXX(), is(市町村コード));
//            assertThat(sut.identifier().getXXX(), is(主治医医療機関コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();

            sut = new ShujiiJoho(ShujiiJohoEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShujiiJohoEntity.getShichosonCode()));
        }

        @Test
        public void get主治医医療機関コードは_entityが持つ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(ShujiiJohoEntity.getShujiiIryokikanCode()));
        }

        @Test
        public void get主治医コードは_entityが持つ主治医コードを返す() {
            assertThat(sut.get主治医コード(), is(ShujiiJohoEntity.getShujiiCode()));
        }

        @Test
        public void get主治医氏名は_entityが持つ主治医氏名を返す() {
            assertThat(sut.get主治医氏名(), is(ShujiiJohoEntity.getShujiiName()));
        }

        @Test
        public void get主治医カナは_entityが持つ主治医カナを返す() {
            assertThat(sut.get主治医カナ(), is(ShujiiJohoEntity.getShujiiKana()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(ShujiiJohoEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(ShujiiJohoEntity.getJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(ShujiiJohoEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(ShujiiJohoEntity.getFaxNo()));
        }

        @Test
        public void get診療科名称は_entityが持つ診療科名称を返す() {
            assertThat(sut.get診療科名称(), is(ShujiiJohoEntity.getShinryokaName()));
        }

        @Test
        public void get指定医フラグは_entityが持つ指定医フラグを返す() {
            assertThat(sut.get指定医フラグ(), is(ShujiiJohoEntity.getShiteiiFlag()));
        }

        @Test
        public void get状況フラグは_entityが持つ状況フラグを返す() {
            assertThat(sut.get状況フラグ(), is(ShujiiJohoEntity.getJokyoFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();

            sut = new ShujiiJoho(ShujiiJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();

            sut = new ShujiiJoho(ShujiiJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiJoho sut;
        private static ShujiiJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiJohoEntity = DbT5912ShujiiJohoEntityGenerator.createDbT5912ShujiiJohoEntity();

        }

        @Test
        public void ShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがDeletedに指定されたShujiiJohoが返る() {
            sut = TestSupport.setStateShujiiJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがDeletedに指定されたShujiiJohoが返る() {
            sut = TestSupport.setStateShujiiJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがDeletedに指定されたShujiiJohoが返る() {
            sut = TestSupport.setStateShujiiJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiJohoが保持するDbT5912ShujiiJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiJoho setStateShujiiJoho(EntityDataState parentState) {
            ShujiiJohoEntity.setState(parentState);
            return new ShujiiJoho(ShujiiJohoEntity);
        }
    }
}
