/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import static jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT5911ShujiiIryoKikanJohoEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
 * {@link ShujiiIryoKikanJoho}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShujiiIryoKikanJohoTest extends DbzTestBase {

    private static DbT5911ShujiiIryoKikanJohoEntity ShujiiIryoKikanJohoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static LasdecCode 市町村コード;
    private static ShujiiIryokikanCode 主治医医療機関コード;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        市町村コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_市町村コード;
        主治医医療機関コード = DbT5911ShujiiIryoKikanJohoEntityGenerator.DEFAULT_主治医医療機関コード;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 市町村コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIryoKikanJoho(null, 主治医医療機関コード);
        }

        @Test(expected = NullPointerException.class)
        public void 主治医医療機関コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIryoKikanJoho(市町村コード, null);
        }

        @Test
        public void 指定したキーが保持するDbT5911ShujiiIryoKikanJohoEntityにセットされている() {
            sut = new ShujiiIryoKikanJoho(市町村コード, 主治医医療機関コード);
            assertThat(sut.get市町村コード(), is(市町村コード));
            assertThat(sut.get主治医医療機関コード(), is(主治医医療機関コード));
        }

        @Test
        public void 指定したキーが保持するShujiiIryoKikanJohoIdentifierにセットされている() {
            sut = new ShujiiIryoKikanJoho(市町村コード, 主治医医療機関コード);
            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get主治医医療機関コード(), is(主治医医療機関コード));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIryoKikanJoho(null);
        }

        @Test
        public void 指定したDbT5911ShujiiIryoKikanJohoEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);

            assertThat(sut.identifier().get市町村コード(), is(市町村コード));
            assertThat(sut.identifier().get主治医医療機関コード(), is(主治医医療機関コード));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();

            sut = new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);
        }

        @Test
        public void get市町村コードは_entityが持つ市町村コードを返す() {
            assertThat(sut.get市町村コード(), is(ShujiiIryoKikanJohoEntity.getShichosonCode()));
        }

        @Test
        public void get主治医医療機関コードは_entityが持つ主治医医療機関コードを返す() {
            assertThat(sut.get主治医医療機関コード(), is(ShujiiIryoKikanJohoEntity.getShujiiIryokikanCode()));
        }

        @Test
        public void get医療機関コードは_entityが持つ医療機関コードを返す() {
            assertThat(sut.get医療機関コード(), is(ShujiiIryoKikanJohoEntity.getIryokikanCode()));
        }

        @Test
        public void get医療機関名称は_entityが持つ医療機関名称を返す() {
            assertThat(sut.get医療機関名称(), is(ShujiiIryoKikanJohoEntity.getIryoKikanMeisho()));
        }

        @Test
        public void get医療機関名称カナは_entityが持つ医療機関名称カナを返す() {
            assertThat(sut.get医療機関名称カナ(), is(ShujiiIryoKikanJohoEntity.getIryoKikanMeishoKana()));
        }

        @Test
        public void get郵便番号は_entityが持つ郵便番号を返す() {
            assertThat(sut.get郵便番号(), is(ShujiiIryoKikanJohoEntity.getYubinNo()));
        }

        @Test
        public void get住所は_entityが持つ住所を返す() {
            assertThat(sut.get住所(), is(ShujiiIryoKikanJohoEntity.getJusho()));
        }

        @Test
        public void get電話番号は_entityが持つ電話番号を返す() {
            assertThat(sut.get電話番号(), is(ShujiiIryoKikanJohoEntity.getTelNo()));
        }

        @Test
        public void getFAX番号は_entityが持つFAX番号を返す() {
            assertThat(sut.getFAX番号(), is(ShujiiIryoKikanJohoEntity.getFaxNo()));
        }

        @Test
        public void get代表者名は_entityが持つ代表者名を返す() {
            assertThat(sut.get代表者名().getColumnValue(), is(ShujiiIryoKikanJohoEntity.getDaihyoshaName()));
        }

        @Test
        public void is状況フラグは_entityが持つ状況フラグを返す() {
            assertThat(sut.is状況フラグ(), is(ShujiiIryoKikanJohoEntity.getJokyoFlag()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();

            sut = new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIryoKikanJohoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();

            sut = new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static ShujiiIryoKikanJoho sut;
        private static ShujiiIryoKikanJoho result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIryoKikanJohoEntity = DbT5911ShujiiIryoKikanJohoEntityGenerator.createDbT5911ShujiiIryoKikanJohoEntity();

        }

        @Test
        public void ShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがDeletedに指定されたShujiiIryoKikanJohoが返る() {
            sut = TestSupport.setStateShujiiIryoKikanJoho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがDeletedに指定されたShujiiIryoKikanJohoが返る() {
            sut = TestSupport.setStateShujiiIryoKikanJoho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがDeletedに指定されたShujiiIryoKikanJohoが返る() {
            sut = TestSupport.setStateShujiiIryoKikanJoho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIryoKikanJohoが保持するDbT5911ShujiiIryoKikanJohoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIryoKikanJoho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIryoKikanJoho setStateShujiiIryoKikanJoho(EntityDataState parentState) {
            ShujiiIryoKikanJohoEntity.setState(parentState);
            return new ShujiiIryoKikanJoho(ShujiiIryoKikanJohoEntity);
        }
    }
}
