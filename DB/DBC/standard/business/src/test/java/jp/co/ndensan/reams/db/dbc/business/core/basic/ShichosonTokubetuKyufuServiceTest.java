/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3066ShichosonTokubetuKyufuServiceEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShichosonTokubetuKyufuService}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShichosonTokubetuKyufuServiceTest extends DbcTestBase {

    private static DbT3066ShichosonTokubetuKyufuServiceEntity ShichosonTokubetuKyufuServiceEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static RString 主キー名1;
    private static FlexibleDate 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービスコード;
        主キー名2 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_市町村特別給付用サービス有効期間開始年月日;
        主キー名3 = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShichosonTokubetuKyufuService(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShichosonTokubetuKyufuService(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3066ShichosonTokubetuKyufuServiceEntityにセットされている() {
            sut = new ShichosonTokubetuKyufuService(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get市町村特別給付用サービスコード(), is(主キー名1));
            assertThat(sut.get市町村特別給付用サービス有効期間開始年月日(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShichosonTokubetuKyufuServiceIdentifierにセットされている() {
            sut = new ShichosonTokubetuKyufuService(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get市町村特別給付用サービスコード(), is(主キー名1));
            assertThat(sut.identifier().get市町村特別給付用サービス有効期間開始年月日(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShichosonTokubetuKyufuService(null);
        }

        @Test
        public void 指定したDbT3066ShichosonTokubetuKyufuServiceEntityのキー情報を識別子が持つ() {

            sut = new ShichosonTokubetuKyufuService(ShichosonTokubetuKyufuServiceEntity);

            assertThat(sut.identifier().get市町村特別給付用サービスコード(), is(主キー名1));
            assertThat(sut.identifier().get市町村特別給付用サービス有効期間開始年月日(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);

            sut = new ShichosonTokubetuKyufuService(ShichosonTokubetuKyufuServiceEntity);
        }

        @Test
        public void get市町村特別給付用サービスコードは_entityが持つ市町村特別給付用サービスコードを返す() {
            assertThat(sut.get市町村特別給付用サービスコード(), is(ShichosonTokubetuKyufuServiceEntity.getServiceCode()));
        }

        @Test
        public void get市町村特別給付用サービス有効期間開始年月日は_entityが持つ市町村特別給付用サービス有効期間開始年月日を返す() {
            assertThat(sut.get市町村特別給付用サービス有効期間開始年月日(), is(ShichosonTokubetuKyufuServiceEntity.getServiceYukoKikanKaishiYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShichosonTokubetuKyufuServiceEntity.getRirekiNo()));
        }

        @Test
        public void get市町村特別給付用サービス名_正式名称は_entityが持つ市町村特別給付用サービス名_正式名称を返す() {
            assertThat(sut.get市町村特別給付用サービス名_正式名称(), is(ShichosonTokubetuKyufuServiceEntity.getServiceSeishikiName()));
        }

        @Test
        public void get市町村特別給付用サービス名_略称は_entityが持つ市町村特別給付用サービス名_略称を返す() {
            assertThat(sut.get市町村特別給付用サービス名_略称(), is(ShichosonTokubetuKyufuServiceEntity.getServiceRyakushoName()));
        }

        @Test
        public void get市町村特別給付用サービス有効期間終了年月日は_entityが持つ市町村特別給付用サービス有効期間終了年月日を返す() {
            assertThat(sut.get市町村特別給付用サービス有効期間終了年月日(), is(ShichosonTokubetuKyufuServiceEntity.getServiceYukoKikanShuryoYMD()));
        }

        @Test
        public void get市町村特別給付用サービス区分は_entityが持つ市町村特別給付用サービス区分を返す() {
            assertThat(sut.get市町村特別給付用サービス区分(), is(ShichosonTokubetuKyufuServiceEntity.getServiceKubun()));
        }

        @Test
        public void get市町村特別給付用単位_日数は_entityが持つ市町村特別給付用単位_日数を返す() {
            assertThat(sut.get市町村特別給付用単位_日数(), is(ShichosonTokubetuKyufuServiceEntity.getTanisuNissu()));
        }

        @Test
        public void get市町村特別給付用支給限度基準額は_entityが持つ市町村特別給付用支給限度基準額を返す() {
            assertThat(sut.get市町村特別給付用支給限度基準額(), is(ShichosonTokubetuKyufuServiceEntity.getShikyuGendoKijungaku()));
        }

        @Test
        public void get市町村特別給付用給付率引下有フラグは_entityが持つ市町村特別給付用給付率引下有フラグを返す() {
            assertThat(sut.get市町村特別給付用給付率引下有フラグ(), is(ShichosonTokubetuKyufuServiceEntity.getKyufuritsuHikisageAriFlag()));
        }

        @Test
        public void get登録年月日は_entityが持つ登録年月日を返す() {
            assertThat(sut.get登録年月日(), is(ShichosonTokubetuKyufuServiceEntity.getTorokuYMD()));
        }

        @Test
        public void get変更年月日は_entityが持つ変更年月日を返す() {
            assertThat(sut.get変更年月日(), is(ShichosonTokubetuKyufuServiceEntity.getHenkoYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);

            sut = new ShichosonTokubetuKyufuService(ShichosonTokubetuKyufuServiceEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShichosonTokubetuKyufuServiceEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);

            sut = new ShichosonTokubetuKyufuService(ShichosonTokubetuKyufuServiceEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShichosonTokubetuKyufuService sut;
        private static ShichosonTokubetuKyufuService result;

        @Before
        public void setUp() {
            ShichosonTokubetuKyufuServiceEntity = DbT3066ShichosonTokubetuKyufuServiceEntityGenerator.createDbT3066ShichosonTokubetuKyufuServiceEntity();
            ShichosonTokubetuKyufuServiceEntity.setServiceCode(主キー名1);
            ShichosonTokubetuKyufuServiceEntity.setServiceYukoKikanKaishiYMD(主キー名2);

        }

        @Test
        public void ShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがDeletedに指定されたShichosonTokubetuKyufuServiceが返る() {
            sut = TestSupport.setStateShichosonTokubetuKyufuService(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがDeletedに指定されたShichosonTokubetuKyufuServiceが返る() {
            sut = TestSupport.setStateShichosonTokubetuKyufuService(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがDeletedに指定されたShichosonTokubetuKyufuServiceが返る() {
            sut = TestSupport.setStateShichosonTokubetuKyufuService(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShichosonTokubetuKyufuServiceが保持するDbT3066ShichosonTokubetuKyufuServiceEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShichosonTokubetuKyufuService(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShichosonTokubetuKyufuService setStateShichosonTokubetuKyufuService(EntityDataState parentState) {
            ShichosonTokubetuKyufuServiceEntity.setState(parentState);
            return new ShichosonTokubetuKyufuService(ShichosonTokubetuKyufuServiceEntity);
        }
    }
}
