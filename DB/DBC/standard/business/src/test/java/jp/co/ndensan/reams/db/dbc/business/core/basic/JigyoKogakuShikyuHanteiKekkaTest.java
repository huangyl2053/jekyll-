/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
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

/**
 * {@link JigyoKogakuShikyuHanteiKekka}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class JigyoKogakuShikyuHanteiKekkaTest extends DbcTestBase {

    private static DbT3111JigyoKogakuShikyuHanteiKekkaEntity JigyoKogakuShikyuHanteiKekkaEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static HokenshaNo 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名4 = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuShikyuHanteiKekka(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JigyoKogakuShikyuHanteiKekka(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityにセットされている() {
            sut = new JigyoKogakuShikyuHanteiKekka(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJigyoKogakuShikyuHanteiKekkaIdentifierにセットされている() {
            sut = new JigyoKogakuShikyuHanteiKekka(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JigyoKogakuShikyuHanteiKekka(null);
        }

        @Test
        public void 指定したDbT3111JigyoKogakuShikyuHanteiKekkaEntityのキー情報を識別子が持つ() {

            sut = new JigyoKogakuShikyuHanteiKekka(JigyoKogakuShikyuHanteiKekkaEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuHanteiKekka(JigyoKogakuShikyuHanteiKekkaEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JigyoKogakuShikyuHanteiKekkaEntity.getHihokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(JigyoKogakuShikyuHanteiKekkaEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(JigyoKogakuShikyuHanteiKekkaEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(JigyoKogakuShikyuHanteiKekkaEntity.getRirekiNo()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(JigyoKogakuShikyuHanteiKekkaEntity.getKetteiYMD()));
        }

        @Test
        public void get本人支払額は_entityが持つ本人支払額を返す() {
            assertThat(sut.get本人支払額(), is(JigyoKogakuShikyuHanteiKekkaEntity.getHonninShiharaiGaku()));
        }

        @Test
        public void get支給区分コードは_entityが持つ支給区分コードを返す() {
            assertThat(sut.get支給区分コード(), is(JigyoKogakuShikyuHanteiKekkaEntity.getShiharaiKubunCode()));
        }

        @Test
        public void get支給金額は_entityが持つ支給金額を返す() {
            assertThat(sut.get支給金額(), is(JigyoKogakuShikyuHanteiKekkaEntity.getShiharaiKingaku()));
        }

        @Test
        public void get不支給理由は_entityが持つ不支給理由を返す() {
            assertThat(sut.get不支給理由(), is(JigyoKogakuShikyuHanteiKekkaEntity.getFushikyuRiyu()));
        }

        @Test
        public void get審査方法区分は_entityが持つ審査方法区分を返す() {
            assertThat(sut.get審査方法区分(), is(JigyoKogakuShikyuHanteiKekkaEntity.getShinsaHohoKubun()));
        }

        @Test
        public void get判定結果送付年月は_entityが持つ判定結果送付年月を返す() {
            assertThat(sut.get判定結果送付年月(), is(JigyoKogakuShikyuHanteiKekkaEntity.getHanteiKekkaSofuYM()));
        }

        @Test
        public void get再送付フラグは_entityが持つ再送付フラグを返す() {
            assertThat(sut.is再送付フラグ(), is(JigyoKogakuShikyuHanteiKekkaEntity.getSaiSofuFlag()));
        }

        @Test
        public void get判定結果送付不要フラグは_entityが持つ判定結果送付不要フラグを返す() {
            assertThat(sut.is判定結果送付不要フラグ(), is(JigyoKogakuShikyuHanteiKekkaEntity.getHanteiKekkaSofuFuyoFlag()));
        }

        @Test
        public void get審査結果反映区分は_entityが持つ審査結果反映区分を返す() {
            assertThat(sut.get審査結果反映区分(), is(JigyoKogakuShikyuHanteiKekkaEntity.getShinsaKekkaHaneiKubun()));
        }

        @Test
        public void get決定通知書作成年月日は_entityが持つ決定通知書作成年月日を返す() {
            assertThat(sut.get決定通知書作成年月日(), is(JigyoKogakuShikyuHanteiKekkaEntity.getKetteiTsuchishoSakuseiYMD()));
        }

        @Test
        public void get振込明細書作成年月日は_entityが持つ振込明細書作成年月日を返す() {
            assertThat(sut.get振込明細書作成年月日(), is(JigyoKogakuShikyuHanteiKekkaEntity.getFurikomiMeisaishoSakuseiYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuHanteiKekka(JigyoKogakuShikyuHanteiKekkaEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JigyoKogakuShikyuHanteiKekkaEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

            sut = new JigyoKogakuShikyuHanteiKekka(JigyoKogakuShikyuHanteiKekkaEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JigyoKogakuShikyuHanteiKekka sut;
        private static JigyoKogakuShikyuHanteiKekka result;

        @Before
        public void setUp() {
            JigyoKogakuShikyuHanteiKekkaEntity = DbT3111JigyoKogakuShikyuHanteiKekkaEntityGenerator.createDbT3111JigyoKogakuShikyuHanteiKekkaEntity();
            JigyoKogakuShikyuHanteiKekkaEntity.setHihokenshaNo(主キー名1);
            JigyoKogakuShikyuHanteiKekkaEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void JigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuHanteiKekkaが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuHanteiKekka(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuHanteiKekkaが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuHanteiKekka(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがDeletedに指定されたJigyoKogakuShikyuHanteiKekkaが返る() {
            sut = TestSupport.setStateJigyoKogakuShikyuHanteiKekka(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JigyoKogakuShikyuHanteiKekkaが保持するDbT3111JigyoKogakuShikyuHanteiKekkaEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJigyoKogakuShikyuHanteiKekka(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JigyoKogakuShikyuHanteiKekka setStateJigyoKogakuShikyuHanteiKekka(EntityDataState parentState) {
            JigyoKogakuShikyuHanteiKekkaEntity.setState(parentState);
            return new JigyoKogakuShikyuHanteiKekka(JigyoKogakuShikyuHanteiKekkaEntity);
        }
    }
}
