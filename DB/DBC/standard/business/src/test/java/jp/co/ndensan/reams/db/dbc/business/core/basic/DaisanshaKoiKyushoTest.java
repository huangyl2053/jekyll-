/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3082DaisanshaKoiKyushoEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3082DaisanshaKoiKyushoEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
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
 * {@link DaisanshaKoiKyusho}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiKyushoTest extends DbcTestBase {

    private static DbT3082DaisanshaKoiKyushoEntity DaisanshaKoiKyushoEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static RString 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_第三者行為求償請求番号;
        主キー名4 = DbT3082DaisanshaKoiKyushoEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyusho(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiKyusho(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3082DaisanshaKoiKyushoEntityにセットされている() {
            sut = new DaisanshaKoiKyusho(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get第三者行為届出管理番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiKyushoIdentifierにセットされている() {
            sut = new DaisanshaKoiKyusho(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiKyusho(null);
        }

        @Test
        public void 指定したDbT3082DaisanshaKoiKyushoEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiKyushoEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiKyushoEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get第三者行為求償請求番号は_entityが持つ第三者行為求償請求番号を返す() {
            assertThat(sut.get第三者行為求償請求番号(), is(DaisanshaKoiKyushoEntity.getKyushoSeikyuNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiKyushoEntity.getRirekiNo()));
        }

        @Test
        public void get給付額合計は_entityが持つ給付額合計を返す() {
            assertThat(sut.get給付額合計(), is(DaisanshaKoiKyushoEntity.getKyufuGakuGokei()));
        }

        @Test
        public void get過失相殺額は_entityが持つ過失相殺額を返す() {
            assertThat(sut.get過失相殺額(), is(DaisanshaKoiKyushoEntity.getKashitsuSosatsuGaku()));
        }

        @Test
        public void get保険給付請求額は_entityが持つ保険給付請求額を返す() {
            assertThat(sut.get保険給付請求額(), is(DaisanshaKoiKyushoEntity.getHokenKyufuSeikyuGaku()));
        }

        @Test
        public void get損害賠償金納入期限は_entityが持つ損害賠償金納入期限を返す() {
            assertThat(sut.get損害賠償金納入期限(), is(DaisanshaKoiKyushoEntity.getSongaiBaishoKinNonyuYMD()));
        }

        @Test
        public void get請求先郵便番号は_entityが持つ請求先郵便番号を返す() {
            assertThat(sut.get請求先郵便番号(), is(DaisanshaKoiKyushoEntity.getSeikyusakiYubinNo()));
        }

        @Test
        public void get請求先住所は_entityが持つ請求先住所を返す() {
            assertThat(sut.get請求先住所(), is(DaisanshaKoiKyushoEntity.getSeikyusakiJusho()));
        }

        @Test
        public void get請求先名称は_entityが持つ請求先名称を返す() {
            assertThat(sut.get請求先名称(), is(DaisanshaKoiKyushoEntity.getSeikyusakiMeisho()));
        }

        @Test
        public void get請求先部署は_entityが持つ請求先部署を返す() {
            assertThat(sut.get請求先部署(), is(DaisanshaKoiKyushoEntity.getSeikyusakiBusho()));
        }

        @Test
        public void get請求先担当者は_entityが持つ請求先担当者を返す() {
            assertThat(sut.get請求先担当者(), is(DaisanshaKoiKyushoEntity.getSeikyusakiTantosha()));
        }

        @Test
        public void get請求先電話番号は_entityが持つ請求先電話番号を返す() {
            assertThat(sut.get請求先電話番号(), is(DaisanshaKoiKyushoEntity.getSeikyusakiTelNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiKyushoEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiKyusho sut;
        private static DaisanshaKoiKyusho result;

        @Before
        public void setUp() {
            DaisanshaKoiKyushoEntity = DbT3082DaisanshaKoiKyushoEntityGenerator.createDbT3082DaisanshaKoiKyushoEntity();
            DaisanshaKoiKyushoEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiKyushoEntity.setTodokedeKanriNo(主キー名2);

        }

        @Test
        public void DaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyusho(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyusho(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiKyushoが返る() {
            sut = TestSupport.setStateDaisanshaKoiKyusho(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiKyushoが保持するDbT3082DaisanshaKoiKyushoEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiKyusho(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiKyusho setStateDaisanshaKoiKyusho(EntityDataState parentState) {
            DaisanshaKoiKyushoEntity.setState(parentState);
            return new DaisanshaKoiKyusho(DaisanshaKoiKyushoEntity);
        }
    }
}
