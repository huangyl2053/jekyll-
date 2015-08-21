/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3084DaisanshaKoiTodokedeEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3084DaisanshaKoiTodokedeEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
 * {@link DaisanshaKoiTodokede}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiTodokedeTest extends DbcTestBase {

    private static DbT3084DaisanshaKoiTodokedeEntity DaisanshaKoiTodokedeEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static Decimal 主キー名3;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3084DaisanshaKoiTodokedeEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiTodokede(null, 主キー名2, 主キー名3);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiTodokede(主キー名1, null, 主キー名3);
        }

        @Test
        public void 指定したキーが保持するDbT3084DaisanshaKoiTodokedeEntityにセットされている() {
            sut = new DaisanshaKoiTodokede(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get第三者行為届出管理番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiTodokedeIdentifierにセットされている() {
            sut = new DaisanshaKoiTodokede(主キー名1, 主キー名2, 主キー名3);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiTodokede(null);
        }

        @Test
        public void 指定したDbT3084DaisanshaKoiTodokedeEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiTodokede(DaisanshaKoiTodokedeEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiTodokede(DaisanshaKoiTodokedeEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiTodokedeEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiTodokedeEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiTodokedeEntity.getRirekiNo()));
        }

        @Test
        public void get届出年月日は_entityが持つ届出年月日を返す() {
            assertThat(sut.get届出年月日(), is(DaisanshaKoiTodokedeEntity.getTodokedeYMD()));
        }

        @Test
        public void get届出人郵便番号は_entityが持つ届出人郵便番号を返す() {
            assertThat(sut.get届出人郵便番号(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_YubinNo()));
        }

        @Test
        public void get届出人住所は_entityが持つ届出人住所を返す() {
            assertThat(sut.get届出人住所(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_Jusho()));
        }

        @Test
        public void get届出人氏名カナは_entityが持つ届出人氏名カナを返す() {
            assertThat(sut.get届出人氏名カナ(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_ShimeiKana()));
        }

        @Test
        public void get届出人氏名は_entityが持つ届出人氏名を返す() {
            assertThat(sut.get届出人氏名(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_Shimei()));
        }

        @Test
        public void get届出人電話番号は_entityが持つ届出人電話番号を返す() {
            assertThat(sut.get届出人電話番号(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_TelNo()));
        }

        @Test
        public void get届出人との続柄は_entityが持つ届出人との続柄を返す() {
            assertThat(sut.get届出人との続柄(), is(DaisanshaKoiTodokedeEntity.getTodokedenin_Zokugara()));
        }

        @Test
        public void get要介護状態区分は_entityが持つ要介護状態区分を返す() {
            assertThat(sut.get要介護状態区分(), is(DaisanshaKoiTodokedeEntity.getYokaigoJotaiKubun()));
        }

        @Test
        public void get認定有効期間開始年月日は_entityが持つ認定有効期間開始年月日を返す() {
            assertThat(sut.get認定有効期間開始年月日(), is(DaisanshaKoiTodokedeEntity.getNinteiYukoKaishiYMD()));
        }

        @Test
        public void get認定有効期間終了年月日は_entityが持つ認定有効期間終了年月日を返す() {
            assertThat(sut.get認定有効期間終了年月日(), is(DaisanshaKoiTodokedeEntity.getNinteiYukoShuryoYMD()));
        }

        @Test
        public void get加害者郵便番号は_entityが持つ加害者郵便番号を返す() {
            assertThat(sut.get加害者郵便番号(), is(DaisanshaKoiTodokedeEntity.getKagaisha_YubinNo()));
        }

        @Test
        public void get加害者住所は_entityが持つ加害者住所を返す() {
            assertThat(sut.get加害者住所(), is(DaisanshaKoiTodokedeEntity.getKagaisha_Jusho()));
        }

        @Test
        public void get加害者氏名カナは_entityが持つ加害者氏名カナを返す() {
            assertThat(sut.get加害者氏名カナ(), is(DaisanshaKoiTodokedeEntity.getKagaisha_ShimeiKana()));
        }

        @Test
        public void get加害者氏名は_entityが持つ加害者氏名を返す() {
            assertThat(sut.get加害者氏名(), is(DaisanshaKoiTodokedeEntity.getKagansha_Shimei()));
        }

        @Test
        public void get加害者生年月日は_entityが持つ加害者生年月日を返す() {
            assertThat(sut.get加害者生年月日(), is(DaisanshaKoiTodokedeEntity.getKagaisha_UmareYMD()));
        }

        @Test
        public void get加害者電話番号は_entityが持つ加害者電話番号を返す() {
            assertThat(sut.get加害者電話番号(), is(DaisanshaKoiTodokedeEntity.getKagaisha_TelNo()));
        }

        @Test
        public void get加害者職業は_entityが持つ加害者職業を返す() {
            assertThat(sut.get加害者職業(), is(DaisanshaKoiTodokedeEntity.getKagaisha_Shokugyo()));
        }

        @Test
        public void get使用者郵便番号は_entityが持つ使用者郵便番号を返す() {
            assertThat(sut.get使用者郵便番号(), is(DaisanshaKoiTodokedeEntity.getShiyosha_YubinNo()));
        }

        @Test
        public void get使用者住所は_entityが持つ使用者住所を返す() {
            assertThat(sut.get使用者住所(), is(DaisanshaKoiTodokedeEntity.getShiyosha_Jusho()));
        }

        @Test
        public void get使用者氏名カナは_entityが持つ使用者氏名カナを返す() {
            assertThat(sut.get使用者氏名カナ(), is(DaisanshaKoiTodokedeEntity.getShiyosha_ShimeiKana()));
        }

        @Test
        public void get使用者氏名は_entityが持つ使用者氏名を返す() {
            assertThat(sut.get使用者氏名(), is(DaisanshaKoiTodokedeEntity.getShiyosha_Shimei()));
        }

        @Test
        public void get使用者生年月日は_entityが持つ使用者生年月日を返す() {
            assertThat(sut.get使用者生年月日(), is(DaisanshaKoiTodokedeEntity.getShiyosha_UmareYMD()));
        }

        @Test
        public void get使用者電話番号は_entityが持つ使用者電話番号を返す() {
            assertThat(sut.get使用者電話番号(), is(DaisanshaKoiTodokedeEntity.getShiyosha_TelNo()));
        }

        @Test
        public void get使用者職業は_entityが持つ使用者職業を返す() {
            assertThat(sut.get使用者職業(), is(DaisanshaKoiTodokedeEntity.getShiyosha_Shokugyo()));
        }

        @Test
        public void get負傷年月日は_entityが持つ負傷年月日を返す() {
            assertThat(sut.get負傷年月日(), is(DaisanshaKoiTodokedeEntity.getFushoYMD()));
        }

        @Test
        public void get負傷時間は_entityが持つ負傷時間を返す() {
            assertThat(sut.get負傷時間(), is(DaisanshaKoiTodokedeEntity.getFushoTime()));
        }

        @Test
        public void get負傷時の場所は_entityが持つ負傷時の場所を返す() {
            assertThat(sut.get負傷時の場所(), is(DaisanshaKoiTodokedeEntity.getFushoJi_Basho()));
        }

        @Test
        public void get発病原因_負傷時状況は_entityが持つ発病原因_負傷時状況を返す() {
            assertThat(sut.get発病原因_負傷時状況(), is(DaisanshaKoiTodokedeEntity.getHasshoGeiin_FushoJiJokyo()));
        }

        @Test
        public void get自賠責保険契約会社名は_entityが持つ自賠責保険契約会社名を返す() {
            assertThat(sut.get自賠責保険契約会社名(), is(DaisanshaKoiTodokedeEntity.getJibaisekiHoken_KeiyakuKaishaMei()));
        }

        @Test
        public void get自賠責保険証明書番号は_entityが持つ自賠責保険証明書番号を返す() {
            assertThat(sut.get自賠責保険証明書番号(), is(DaisanshaKoiTodokedeEntity.getJibaisekiHoken_ShomeishoNo()));
        }

        @Test
        public void get自賠責保険契約者住所は_entityが持つ自賠責保険契約者住所を返す() {
            assertThat(sut.get自賠責保険契約者住所(), is(DaisanshaKoiTodokedeEntity.getJibaisekiHoken_KeiyakushaJusho()));
        }

        @Test
        public void get所有者住所は_entityが持つ所有者住所を返す() {
            assertThat(sut.get所有者住所(), is(DaisanshaKoiTodokedeEntity.getShoyushaJusho()));
        }

        @Test
        public void get所有者氏名は_entityが持つ所有者氏名を返す() {
            assertThat(sut.get所有者氏名(), is(DaisanshaKoiTodokedeEntity.getShoyushaShimei()));
        }

        @Test
        public void get登録番号は_entityが持つ登録番号を返す() {
            assertThat(sut.get登録番号(), is(DaisanshaKoiTodokedeEntity.getTorokuNo()));
        }

        @Test
        public void get車台番号は_entityが持つ車台番号を返す() {
            assertThat(sut.get車台番号(), is(DaisanshaKoiTodokedeEntity.getShadaiNo()));
        }

        @Test
        public void get任意保険対人保障有無は_entityが持つ任意保険対人保障有無を返す() {
            assertThat(sut.get任意保険対人保障有無(), is(DaisanshaKoiTodokedeEntity.getNiniHoken_TaijinHoshoUmu()));
        }

        @Test
        public void get任意保険対人保障保険契約会社名は_entityが持つ任意保険対人保障保険契約会社名を返す() {
            assertThat(sut.get任意保険対人保障保険契約会社名(), is(DaisanshaKoiTodokedeEntity.getNiniHoken_TaijinHoshoKaishaMei()));
        }

        @Test
        public void get任意保険対人保障保険契約会社連絡先は_entityが持つ任意保険対人保障保険契約会社連絡先を返す() {
            assertThat(sut.get任意保険対人保障保険契約会社連絡先(), is(DaisanshaKoiTodokedeEntity.getNiniHoken_TaijinHoshoKaishaTelNo()));
        }

        @Test
        public void get任意保険対人保障保険契約会社担当者は_entityが持つ任意保険対人保障保険契約会社担当者を返す() {
            assertThat(sut.get任意保険対人保障保険契約会社担当者(), is(DaisanshaKoiTodokedeEntity.getNiniHoken_TaijinHoshoKaishaTantosha()));
        }

        @Test
        public void get示談成立有無は_entityが持つ示談成立有無を返す() {
            assertThat(sut.get示談成立有無(), is(DaisanshaKoiTodokedeEntity.getJidan_SeiritsuUmu()));
        }

        @Test
        public void get示談成立年月日は_entityが持つ示談成立年月日を返す() {
            assertThat(sut.get示談成立年月日(), is(DaisanshaKoiTodokedeEntity.getJidan_SeiritsuYMD()));
        }

        @Test
        public void get損害賠償交渉経過は_entityが持つ損害賠償交渉経過を返す() {
            assertThat(sut.get損害賠償交渉経過(), is(DaisanshaKoiTodokedeEntity.getSongaiBaishoKoshoKeika()));
        }

        @Test
        public void get事故発生状況報告書有無は_entityが持つ事故発生状況報告書有無を返す() {
            assertThat(sut.get事故発生状況報告書有無(), is(DaisanshaKoiTodokedeEntity.getJikoHasseiJokyoHokokushoUmu()));
        }

        @Test
        public void get念書兼同意書有無は_entityが持つ念書兼同意書有無を返す() {
            assertThat(sut.get念書兼同意書有無(), is(DaisanshaKoiTodokedeEntity.getNensho_DoishoUmu()));
        }

        @Test
        public void get誓約書有無は_entityが持つ誓約書有無を返す() {
            assertThat(sut.get誓約書有無(), is(DaisanshaKoiTodokedeEntity.getSeiyakushoUmu()));
        }

        @Test
        public void get交通事故証明書有無は_entityが持つ交通事故証明書有無を返す() {
            assertThat(sut.get交通事故証明書有無(), is(DaisanshaKoiTodokedeEntity.getKotsuJikoShomeishoUmu()));
        }

        @Test
        public void get人身事故証明書入手不能理由書有無は_entityが持つ人身事故証明書入手不能理由書有無を返す() {
            assertThat(sut.get人身事故証明書入手不能理由書有無(), is(DaisanshaKoiTodokedeEntity.getJinshinJikoShomeisho_NyushuFunoRiyushoUmu()));
        }

        @Test
        public void get示談書写し有無は_entityが持つ示談書写し有無を返す() {
            assertThat(sut.get示談書写し有無(), is(DaisanshaKoiTodokedeEntity.getJidanshoUtsushiUmu()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiTodokede(DaisanshaKoiTodokedeEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiTodokedeEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiTodokede(DaisanshaKoiTodokedeEntity);
        }

//        @Test
//        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
//        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiTodokede sut;
        private static DaisanshaKoiTodokede result;

        @Before
        public void setUp() {
            DaisanshaKoiTodokedeEntity = DbT3084DaisanshaKoiTodokedeEntityGenerator.createDbT3084DaisanshaKoiTodokedeEntity();
            DaisanshaKoiTodokedeEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiTodokedeEntity.setTodokedeKanriNo(主キー名2);

        }

        @Test
        public void DaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiTodokedeが返る() {
            sut = TestSupport.setStateDaisanshaKoiTodokede(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiTodokedeが返る() {
            sut = TestSupport.setStateDaisanshaKoiTodokede(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiTodokedeが返る() {
            sut = TestSupport.setStateDaisanshaKoiTodokede(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiTodokedeが保持するDbT3084DaisanshaKoiTodokedeEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiTodokede(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiTodokede setStateDaisanshaKoiTodokede(EntityDataState parentState) {
            DaisanshaKoiTodokedeEntity.setState(parentState);
            return new DaisanshaKoiTodokede(DaisanshaKoiTodokedeEntity);
        }
    }
}
