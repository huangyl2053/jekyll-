/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link JutakuKaishuRiyushoTesuryoShukei}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JutakuKaishuRiyushoTesuryoShukeiTest extends DbcTestBase {

    private static DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity JutakuKaishuRiyushoTesuryoShukeiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_集計開始年月;
        主キー名3 = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoShukei(null, 主キー名2, new Decimal(主キー名3));
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoShukei(主キー名1, null, new Decimal(主キー名3));
        }

        @Test
        public void 指定したキーが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoShukei(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.get証記載保険者番号(), is(主キー名1));
            assertThat(sut.get集計開始年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJutakuKaishuRiyushoTesuryoShukeiIdentifierにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoShukei(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get集計開始年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JutakuKaishuRiyushoTesuryoShukei(null);
        }

        @Test
        public void 指定したDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのキー情報を識別子が持つ() {

            sut = new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get集計開始年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get集計開始年月は_entityが持つ集計開始年月を返す() {
            assertThat(sut.get集計開始年月(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getShukeiKaishiYM()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(new Decimal(JutakuKaishuRiyushoTesuryoShukeiEntity.getRirekiNo())));
        }

        @Test
        public void get集計終了年月は_entityが持つ集計終了年月を返す() {
            assertThat(sut.get集計終了年月(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getShukeiShuryoYM()));
        }

        @Test
        public void get介護住宅改修理由書作成事業者番号は_entityが持つ介護住宅改修理由書作成事業者番号を返す() {
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiJigyoshaNo()));
        }

        @Test
        public void get介護住宅改修理由書作成件数は_entityが持つ介護住宅改修理由書作成件数を返す() {
            assertThat(sut.get介護住宅改修理由書作成件数(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiKensu()));
        }

        @Test
        public void get介護住宅改修理由書作成単価は_entityが持つ介護住宅改修理由書作成単価を返す() {
            assertThat(sut.get介護住宅改修理由書作成単価(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiTanka()));
        }

        @Test
        public void get介護住宅改修理由書作成請求金額は_entityが持つ介護住宅改修理由書作成請求金額を返す() {
            assertThat(sut.get介護住宅改修理由書作成請求金額(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiSeikyuKingaku()));
        }

//        @Test
//        public void get介護住宅改修理由書作成申請年月日は_entityが持つ介護住宅改修理由書作成申請年月日を返す() {
//            assertThat(sut.get介護住宅改修理由書作成申請年月日(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiShinseiYMD()));
//        }
//
//        @Test
//        public void get介護住宅改修理由書作成受付年月日は_entityが持つ介護住宅改修理由書作成受付年月日を返す() {
//            assertThat(sut.get介護住宅改修理由書作成受付年月日(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getRiyushoSakuseiUketsukeYMD()));
//        }

        @Test
        public void get介護支払方法区分は_entityが持つ介護支払方法区分を返す() {
            assertThat(sut.get介護支払方法区分(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getShiharaiHohoKubun()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(JutakuKaishuRiyushoTesuryoShukeiEntity.getShikibetsuNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JutakuKaishuRiyushoTesuryoShukeiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoShukei sut;
        private static JutakuKaishuRiyushoTesuryoShukei result;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoShukeiEntity = DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityGenerator.createDbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoShukeiEntity.setShukeiKaishiYM(主キー名2);

        }

        @Test
        public void JutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoShukeiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoShukei(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoShukeiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoShukei(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoShukeiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoShukei(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JutakuKaishuRiyushoTesuryoShukeiが保持するDbT3096JutakuKaishuRiyushoTesuryoShukeiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoShukei(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JutakuKaishuRiyushoTesuryoShukei setStateJutakuKaishuRiyushoTesuryoShukei(EntityDataState parentState) {
            JutakuKaishuRiyushoTesuryoShukeiEntity.setState(parentState);
            return new JutakuKaishuRiyushoTesuryoShukei(JutakuKaishuRiyushoTesuryoShukeiEntity);
        }
    }
}
