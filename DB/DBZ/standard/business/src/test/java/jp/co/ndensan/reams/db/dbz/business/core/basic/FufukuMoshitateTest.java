/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import org.junit.Ignore;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link FufukuMoshitate}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class FufukuMoshitateTest extends DbzTestBase {
//
//    private static DbT7001FufukuMoshitateEntity FufukuMoshitateEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
////TODO 主キー型と変数名を置換してください
////TODO 主キーの数が足りない場合、追加してください。
//    private static ShoKisaiHokenshaNo 主キー名1;
//    private static ShikibetsuCode 主キー名2;
//    private static HihokenshaNo 主キー名3;
//    private static FlexibleDate 主キー名4;
//
//    @BeforeClass
//    public static void setUpClass() {
////TODO 主キー値を適切な値に置換してください
//        主キー名1 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_証記載保険者番号;
//        主キー名2 = DbT7001FufukuMoshitateEntityGenerator.DEFAULT_識別コード;
//    }
//
//    public static class 主キーコンストラクタテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//        }
//
////TODO 主キー名を置換してください
//        @Test(expected = NullPointerException.class)
//        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new FufukuMoshitate(null, 主キー名2, 主キー名3, 主キー名4);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new FufukuMoshitate(主キー名1, null, 主キー名3, 主キー名4);
//        }
//
//        @Test
//        public void 指定したキーが保持するDbT7001FufukuMoshitateEntityにセットされている() {
//            sut = new FufukuMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4);
//            assertThat(sut.get証記載保険者番号(), is(主キー名1));
//            assertThat(sut.get識別コード(), is(主キー名2));
//        }
//
//        @Test
//        public void 指定したキーが保持するFufukuMoshitateIdentifierにセットされている() {
//            sut = new FufukuMoshitate(主キー名1, 主キー名2, 主キー名3, 主キー名4);
//            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
//            assertThat(sut.identifier().get識別コード(), is(主キー名2));
//        }
//    }
//
//    public static class Entityコンストラクタテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
//            sut = new FufukuMoshitate(null);
//        }
//
//        @Test
//        public void 指定したDbT7001FufukuMoshitateEntityのキー情報を識別子が持つ() {
//
//            sut = new FufukuMoshitate(FufukuMoshitateEntity);
//
//            assertThat(sut.identifier().get証記載保険者番号(), is(主キー名1));
//            assertThat(sut.identifier().get識別コード(), is(主キー名2));
//        }
//    }
//
//    public static class getterテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//
//            sut = new FufukuMoshitate(FufukuMoshitateEntity);
//        }
//
//        @Test
//        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
//            assertThat(sut.get証記載保険者番号(), is(FufukuMoshitateEntity.getShoKisaiHokenshaNo()));
//        }
//
//        @Test
//        public void get識別コードは_entityが持つ識別コードを返す() {
//            assertThat(sut.get識別コード(), is(FufukuMoshitateEntity.getShikibetsuCode()));
//        }
//
//        @Test
//        public void get原処分被保険者番号は_entityが持つ原処分被保険者番号を返す() {
//            assertThat(sut.get原処分被保険者番号(), is(FufukuMoshitateEntity.getGenshobunsHihokennshaNo()));
//        }
//
//        @Test
//        public void get審査請求届出日は_entityが持つ審査請求届出日を返す() {
//            assertThat(sut.get審査請求届出日(), is(FufukuMoshitateEntity.getShinsaSeikyuTodokedeYMD()));
//        }
//
//        @Test
//        public void get原処分被保険者郵便番号は_entityが持つ原処分被保険者郵便番号を返す() {
//            assertThat(sut.get原処分被保険者郵便番号(), is(FufukuMoshitateEntity.getGenshobunHihokenshaYubinNo()));
//        }
//
//        @Test
//        public void get原処分被保険者住所は_entityが持つ原処分被保険者住所を返す() {
//            assertThat(sut.get原処分被保険者住所(), is(FufukuMoshitateEntity.getGenshobunHihokenshaJusho()));
//        }
//
//        @Test
//        public void get原処分被保険者氏名は_entityが持つ原処分被保険者氏名を返す() {
//            assertThat(sut.get原処分被保険者氏名(), is(FufukuMoshitateEntity.getGenshobunHihokenshaShimei()));
//        }
//
//        @Test
//        public void get原処分被保険者電話番号は_entityが持つ原処分被保険者電話番号を返す() {
//            assertThat(sut.get原処分被保険者電話番号(), is(FufukuMoshitateEntity.getGenshobunHihokenshaTelNo()));
//        }
//
//        @Test
//        public void get原処分被保険者生年月日は_entityが持つ原処分被保険者生年月日を返す() {
//            assertThat(sut.get原処分被保険者生年月日(), is(FufukuMoshitateEntity.getGenshobunHihokenshaBirthYMD()));
//        }
//
//        @Test
//        public void get審査請求人郵便番号は_entityが持つ審査請求人郵便番号を返す() {
//            assertThat(sut.get審査請求人郵便番号(), is(FufukuMoshitateEntity.getShinsaSeikyuninYubinNo()));
//        }
//
//        @Test
//        public void get審査請求人住所は_entityが持つ審査請求人住所を返す() {
//            assertThat(sut.get審査請求人住所(), is(FufukuMoshitateEntity.getShinsaSeikyuninJusho()));
//        }
//
//        @Test
//        public void get審査請求人氏名は_entityが持つ審査請求人氏名を返す() {
//            assertThat(sut.get審査請求人氏名(), is(FufukuMoshitateEntity.getShinsaSeikyuninShimei()));
//        }
//
//        @Test
//        public void get審査請求人電話番号は_entityが持つ審査請求人電話番号を返す() {
//            assertThat(sut.get審査請求人電話番号(), is(FufukuMoshitateEntity.getShinsaSeikyuninTelNo()));
//        }
//
//        @Test
//        public void get被保険者との関係コードは_entityが持つ被保険者との関係コードを返す() {
//            assertThat(sut.get被保険者との関係コード(), is(FufukuMoshitateEntity.getHihokenshaTonoKankeiCode()));
//        }
//
//        @Test
//        public void get代理人郵便番号は_entityが持つ代理人郵便番号を返す() {
//            assertThat(sut.get代理人郵便番号(), is(FufukuMoshitateEntity.getDairininYubinNo()));
//        }
//
//        @Test
//        public void get代理人住所は_entityが持つ代理人住所を返す() {
//            assertThat(sut.get代理人住所(), is(FufukuMoshitateEntity.getDairininJusho()));
//        }
//
//        @Test
//        public void get代理人氏名は_entityが持つ代理人氏名を返す() {
//            assertThat(sut.get代理人氏名(), is(FufukuMoshitateEntity.getDairininShimei()));
//        }
//
//        @Test
//        public void get代理人電話番号は_entityが持つ代理人電話番号を返す() {
//            assertThat(sut.get代理人電話番号(), is(FufukuMoshitateEntity.getDairininTelNo()));
//        }
//
//        @Test
//        public void get処分庁は_entityが持つ処分庁を返す() {
//            assertThat(sut.get処分庁(), is(FufukuMoshitateEntity.getShobunCho()));
//        }
//
//        @Test
//        public void get処分日は_entityが持つ処分日を返す() {
//            assertThat(sut.get処分日(), is(FufukuMoshitateEntity.getShobunYMD()));
//        }
//
//        @Test
//        public void get処分種類コードは_entityが持つ処分種類コードを返す() {
//            assertThat(sut.get処分種類コード(), is(FufukuMoshitateEntity.getShobunShuruiCode()));
//        }
//
//        @Test
//        public void get処分があったことを知った日は_entityが持つ処分があったことを知った日を返す() {
//            assertThat(sut.get処分があったことを知った日(), is(FufukuMoshitateEntity.getShobunKakuninYMD()));
//        }
//
//        @Test
//        public void get審査請求の理由は_entityが持つ審査請求の理由を返す() {
//            assertThat(sut.get審査請求の理由(), is(FufukuMoshitateEntity.getShinsaSeikyuRiyu()));
//        }
//
//        @Test
//        public void get処分庁教示の有無及び教示の内容は_entityが持つ処分庁教示の有無及び教示の内容を返す() {
//            assertThat(sut.get処分庁教示の有無及び教示の内容(), is(FufukuMoshitateEntity.getShobunChoKyojiNaiyo()));
//        }
//
//        @Test
//        public void is添付書類等は_entityが持つ添付書類等を返す() {
//            assertThat(sut.is添付書類等(), is(FufukuMoshitateEntity.getTempuShoruiTo()));
//        }
//
//        @Test
//        public void get審査請求取下日は_entityが持つ審査請求取下日を返す() {
//            assertThat(sut.get審査請求取下日(), is(FufukuMoshitateEntity.getShinsaSeikyuTorisageYMD()));
//        }
//
//        @Test
//        public void is弁明書登録フラグは_entityが持つ弁明書登録フラグを返す() {
//            assertThat(sut.is弁明書登録フラグ(), is(FufukuMoshitateEntity.getBemmeishoTorokuFlag()));
//        }
//
//        @Test
//        public void get弁明書作成日は_entityが持つ弁明書作成日を返す() {
//            assertThat(sut.get弁明書作成日(), is(FufukuMoshitateEntity.getBemmeishoSakuseiYMD()));
//        }
//
//        @Test
//        public void get裁決日は_entityが持つ裁決日を返す() {
//            assertThat(sut.get裁決日(), is(FufukuMoshitateEntity.getSaiketsuYMD()));
//        }
//
//        @Test
//        public void get裁決結果は_entityが持つ裁決結果を返す() {
//            assertThat(sut.get裁決結果(), is(FufukuMoshitateEntity.getSaiketsuKekka()));
//        }
//
//        @Test
//        public void get裁決理由は_entityが持つ裁決理由を返す() {
//            assertThat(sut.get裁決理由(), is(FufukuMoshitateEntity.getSaiketsuRiyu()));
//        }
//    }
//
//    public static class toEntityテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//
//            sut = new FufukuMoshitate(FufukuMoshitateEntity);
//        }
//
//        @Test
//        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
//            assertThat(sut.toEntity(), not(FufukuMoshitateEntity));
//        }
//    }
//
//    public static class SerializationProxyテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//
//            sut = new FufukuMoshitate(FufukuMoshitateEntity);
//        }
//
//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(IsSerializable.serializable()));
//        }
//    }
//
//    public static class deletedテスト extends DbzTestBase {
//
//        private static FufukuMoshitate sut;
//        private static FufukuMoshitate result;
//
//        @Before
//        public void setUp() {
//            FufukuMoshitateEntity = DbT7001FufukuMoshitateEntityGenerator.createDbT7001FufukuMoshitateEntity();
//            FufukuMoshitateEntity.setShoKisaiHokenshaNo(主キー名1);
//            FufukuMoshitateEntity.setShikibetsuCode(主キー名2);
//
//        }
//
//        @Test
//        public void FufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりFufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがDeletedに指定されたFufukuMoshitateが返る() {
//            sut = TestSupport.setStateFufukuMoshitate(EntityDataState.Unchanged);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void FufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりFufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがDeletedに指定されたFufukuMoshitateが返る() {
//            sut = TestSupport.setStateFufukuMoshitate(EntityDataState.Modified);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test
//        public void FufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりFufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがDeletedに指定されたFufukuMoshitateが返る() {
//            sut = TestSupport.setStateFufukuMoshitate(EntityDataState.Deleted);
//            result = sut.deleted();
//            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
//        }
//
//        @Test(expected = IllegalStateException.class)
//        public void FufukuMoshitateが保持するDbT7001FufukuMoshitateEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
//            sut = TestSupport.setStateFufukuMoshitate(EntityDataState.Added);
//            result = sut.deleted();
//        }
//    }
//
//    private static class TestSupport {
//
//        public static FufukuMoshitate setStateFufukuMoshitate(EntityDataState parentState) {
//            FufukuMoshitateEntity.setState(parentState);
//            return new FufukuMoshitate(FufukuMoshitateEntity);
//        }
//    }
}
