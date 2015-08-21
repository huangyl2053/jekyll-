/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.DbT5032ShujiiIkenshoHoshuTankaEntityGenerator;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShujiiIkenshoHoshuTanka}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoHoshuTankaTest extends DbeTestBase {

    private static DbT5032ShujiiIkenshoHoshuTankaEntity ShujiiIkenshoHoshuTankaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static Code 在宅施設区分;
    private static Code 意見書作成回数区分;
    private static FlexibleYearMonth 開始年月;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        在宅施設区分 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_在宅施設区分;
        意見書作成回数区分 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_意見書作成回数区分;
        開始年月 = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.DEFAULT_開始年月;
    }

    public static class 主キーコンストラクタテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 在宅施設区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoHoshuTanka(null, 意見書作成回数区分, 開始年月);
        }

        @Test(expected = NullPointerException.class)
        public void 意見書作成回数区分がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShujiiIkenshoHoshuTanka(在宅施設区分, null, 開始年月);
        }

        @Test
        public void 指定したキーが保持するDbT5032ShujiiIkenshoHoshuTankaEntityにセットされている() {
            sut = new ShujiiIkenshoHoshuTanka(在宅施設区分, 意見書作成回数区分, 開始年月);
            assertThat(sut.get在宅施設区分(), is(在宅施設区分));
            assertThat(sut.get意見書作成回数区分(), is(意見書作成回数区分));
            assertThat(sut.get開始年月(), is(開始年月));
        }

        @Test
        public void 指定したキーが保持するShujiiIkenshoHoshuTankaIdentifierにセットされている() {
            sut = new ShujiiIkenshoHoshuTanka(在宅施設区分, 意見書作成回数区分, 開始年月);
            assertThat(sut.identifier().get在宅施設区分(), is(在宅施設区分));
            assertThat(sut.identifier().get意見書作成回数区分(), is(意見書作成回数区分));
            assertThat(sut.identifier().get開始年月(), is(開始年月));
        }
    }

    public static class Entityコンストラクタテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShujiiIkenshoHoshuTanka(null);
        }

        @Test
        public void 指定したDbT5032ShujiiIkenshoHoshuTankaEntityのキー情報を識別子が持つ() {

            sut = new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);

            assertThat(sut.identifier().get在宅施設区分(), is(在宅施設区分));
            assertThat(sut.identifier().get意見書作成回数区分(), is(意見書作成回数区分));
            assertThat(sut.identifier().get開始年月(), is(開始年月));
        }
    }

    public static class getterテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();

            sut = new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);
        }

        @Test
        public void get在宅施設区分は_entityが持つ在宅施設区分を返す() {
            assertThat(sut.get在宅施設区分(), is(ShujiiIkenshoHoshuTankaEntity.getZaitakuShisetsuKubun()));
        }

        @Test
        public void get意見書作成回数区分は_entityが持つ意見書作成回数区分を返す() {
            assertThat(sut.get意見書作成回数区分(), is(ShujiiIkenshoHoshuTankaEntity.getIkenshoSakuseiKaisuKubun()));
        }

        @Test
        public void get開始年月は_entityが持つ開始年月を返す() {
            assertThat(sut.get開始年月(), is(ShujiiIkenshoHoshuTankaEntity.getKaishiYM()));
        }

        @Test
        public void get終了年月は_entityが持つ終了年月を返す() {
            assertThat(sut.get終了年月(), is(ShujiiIkenshoHoshuTankaEntity.getShuryoYM()));
        }

        @Test
        public void get単価は_entityが持つ単価を返す() {
            assertThat(sut.get単価(), is(ShujiiIkenshoHoshuTankaEntity.getTanka()));
        }
    }

    public static class toEntityテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();

            sut = new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShujiiIkenshoHoshuTankaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();

            sut = new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbeTestBase {

        private static ShujiiIkenshoHoshuTanka sut;
        private static ShujiiIkenshoHoshuTanka result;

        @BeforeClass
        public static void setUpClass() {
            ShujiiIkenshoHoshuTankaEntity = DbT5032ShujiiIkenshoHoshuTankaEntityGenerator.createDbT5032ShujiiIkenshoHoshuTankaEntity();

        }

        @Test
        public void ShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoHoshuTankaが返る() {
            sut = TestSupport.setStateShujiiIkenshoHoshuTanka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoHoshuTankaが返る() {
            sut = TestSupport.setStateShujiiIkenshoHoshuTanka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがDeletedに指定されたShujiiIkenshoHoshuTankaが返る() {
            sut = TestSupport.setStateShujiiIkenshoHoshuTanka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShujiiIkenshoHoshuTankaが保持するDbT5032ShujiiIkenshoHoshuTankaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShujiiIkenshoHoshuTanka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShujiiIkenshoHoshuTanka setStateShujiiIkenshoHoshuTanka(EntityDataState parentState) {
            ShujiiIkenshoHoshuTankaEntity.setState(parentState);
            return new ShujiiIkenshoHoshuTanka(ShujiiIkenshoHoshuTankaEntity);
        }
    }
}
