/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
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
 * {@link JutakuKaishuRiyushoTesuryoMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class JutakuKaishuRiyushoTesuryoMeisaiTest extends DbcTestBase {

    private static DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity JutakuKaishuRiyushoTesuryoMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HokenshaNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static int 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_証記載保険者番号;
        主キー名2 = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoMeisai(null, 主キー名2, new Decimal(主キー名3));
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new JutakuKaishuRiyushoTesuryoMeisai(主キー名1, null, new Decimal(主キー名3));
        }

        @Test
        public void 指定したキーが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoMeisai(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.get証記載保険者番号(), is(主キー名1));
            assertThat(sut.get被保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するJutakuKaishuRiyushoTesuryoMeisaiIdentifierにセットされている() {
            sut = new JutakuKaishuRiyushoTesuryoMeisai(主キー名1, 主キー名2, new Decimal(主キー名3));
            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new JutakuKaishuRiyushoTesuryoMeisai(null);
        }

        @Test
        public void 指定したDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのキー情報を識別子が持つ() {

            sut = new JutakuKaishuRiyushoTesuryoMeisai(JutakuKaishuRiyushoTesuryoMeisaiEntity);

            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoMeisai(JutakuKaishuRiyushoTesuryoMeisaiEntity);
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(new Decimal(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRirekiNo())));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getShikibetsuCode()));
        }

        @Test
        public void getサービスコードは_entityが持つサービスコードを返す() {
            assertThat(sut.getサービスコード(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getServiceCode()));
        }

        @Test
        public void get介護住宅改修事業者名称は_entityが持つ介護住宅改修事業者名称を返す() {
            assertThat(sut.get介護住宅改修事業者名称(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getJutakuKaishuJigyoshaMeisho()));
        }

        @Test
        public void get介護住宅改修着工年月日は_entityが持つ介護住宅改修着工年月日を返す() {
            assertThat(sut.get介護住宅改修着工年月日(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getJutakuKaishuChakkoYMD()));
        }

        @Test
        public void get介護住宅改修住宅所有者は_entityが持つ介護住宅改修住宅所有者を返す() {
            assertThat(sut.get介護住宅改修住宅所有者(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getJutakuKaishuJushoShozaisha()));
        }

        @Test
        public void get改修対象住宅住所は_entityが持つ改修対象住宅住所を返す() {
            assertThat(sut.get改修対象住宅住所(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getKaishuTaishoJutakuJusho()));
        }

        @Test
        public void get改修内容_箇所及び規模は_entityが持つ改修内容_箇所及び規模を返す() {
            assertThat(sut.get改修内容_箇所及び規模(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getKaishuNaiyo_kasho_Kibo()));
        }

        @Test
        public void get介護住宅改修理由書作成年月日は_entityが持つ介護住宅改修理由書作成年月日を返す() {
            assertThat(sut.get介護住宅改修理由書作成年月日(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseiYMD()));
        }

        @Test
        public void get介護住宅改修理由書作成事業者番号は_entityが持つ介護住宅改修理由書作成事業者番号を返す() {
            assertThat(sut.get介護住宅改修理由書作成事業者番号(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseiJigyoshaNo()));
        }

        @Test
        public void get介護住宅改修理由書作成者名は_entityが持つ介護住宅改修理由書作成者名を返す() {
            assertThat(sut.get介護住宅改修理由書作成者名(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseishaMei()));
        }

//        @Test
//        public void get介護住宅改修理由書作成者資格は_entityが持つ介護住宅改修理由書作成者資格を返す() {
//            assertThat(sut.get介護住宅改修理由書作成者資格(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseishaShikaku()));
//        }

        @Test
        public void get介護住宅改修理由書作成申請年月日は_entityが持つ介護住宅改修理由書作成申請年月日を返す() {
            assertThat(sut.get介護住宅改修理由書作成申請年月日(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseiShinseiYMD()));
        }

        @Test
        public void get介護住宅改修理由書作成受付年月日は_entityが持つ介護住宅改修理由書作成受付年月日を返す() {
            assertThat(sut.get介護住宅改修理由書作成受付年月日(), is(JutakuKaishuRiyushoTesuryoMeisaiEntity.getRiyushoSakuseiUketsukeYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoMeisai(JutakuKaishuRiyushoTesuryoMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(JutakuKaishuRiyushoTesuryoMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);

            sut = new JutakuKaishuRiyushoTesuryoMeisai(JutakuKaishuRiyushoTesuryoMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static JutakuKaishuRiyushoTesuryoMeisai sut;
        private static JutakuKaishuRiyushoTesuryoMeisai result;

        @Before
        public void setUp() {
            JutakuKaishuRiyushoTesuryoMeisaiEntity = DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityGenerator.createDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity();
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setShoKisaiHokenshaNo(主キー名1);
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setHihokenshaNo(主キー名2);

        }

        @Test
        public void JutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoMeisaiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoMeisaiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void JutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりJutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがDeletedに指定されたJutakuKaishuRiyushoTesuryoMeisaiが返る() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void JutakuKaishuRiyushoTesuryoMeisaiが保持するDbT3095JutakuKaishuRiyushoTesuryoMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateJutakuKaishuRiyushoTesuryoMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static JutakuKaishuRiyushoTesuryoMeisai setStateJutakuKaishuRiyushoTesuryoMeisai(EntityDataState parentState) {
            JutakuKaishuRiyushoTesuryoMeisaiEntity.setState(parentState);
            return new JutakuKaishuRiyushoTesuryoMeisai(JutakuKaishuRiyushoTesuryoMeisaiEntity);
        }
    }
}
