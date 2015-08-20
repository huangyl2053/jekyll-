/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3080DaisanshaKoiJidanEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3080DaisanshaKoiJidanEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
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
 * {@link DaisanshaKoiJidan}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class DaisanshaKoiJidanTest extends DbcTestBase {

    private static DbT3080DaisanshaKoiJidanEntity DaisanshaKoiJidanEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static RString 主キー名2;
    private static FlexibleDate 主キー名3;
    private static Decimal 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_第三者行為届出管理番号;
        主キー名3 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_示談報告書受付年月日;
        主キー名4 = DbT3080DaisanshaKoiJidanEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiJidan(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new DaisanshaKoiJidan(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3080DaisanshaKoiJidanEntityにセットされている() {
            sut = new DaisanshaKoiJidan(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get第三者行為届出管理番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するDaisanshaKoiJidanIdentifierにセットされている() {
            sut = new DaisanshaKoiJidan(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new DaisanshaKoiJidan(null);
        }

        @Test
        public void 指定したDbT3080DaisanshaKoiJidanEntityのキー情報を識別子が持つ() {

            sut = new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);

            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get第三者行為届出管理番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(DaisanshaKoiJidanEntity.getHihokenshaNo()));
        }

        @Test
        public void get第三者行為届出管理番号は_entityが持つ第三者行為届出管理番号を返す() {
            assertThat(sut.get第三者行為届出管理番号(), is(DaisanshaKoiJidanEntity.getTodokedeKanriNo()));
        }

        @Test
        public void get示談報告書受付年月日は_entityが持つ示談報告書受付年月日を返す() {
            assertThat(sut.get示談報告書受付年月日(), is(DaisanshaKoiJidanEntity.getJidanHokokushoUketukeYMD()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(DaisanshaKoiJidanEntity.getRirekiNo()));
        }

        @Test
        public void get第三者行為求償協議区分は_entityが持つ第三者行為求償協議区分を返す() {
            assertThat(sut.get第三者行為求償協議区分(), is(DaisanshaKoiJidanEntity.getKyushoKyogiKubun()));
        }

        @Test
        public void get示談報告書提出年月日は_entityが持つ示談報告書提出年月日を返す() {
            assertThat(sut.get示談報告書提出年月日(), is(DaisanshaKoiJidanEntity.getJidanHokokushoTeishutsuYMD()));
        }

        @Test
        public void get示談成立年月日は_entityが持つ示談成立年月日を返す() {
            assertThat(sut.get示談成立年月日(), is(DaisanshaKoiJidanEntity.getJidanSeiritsuYMD()));
        }

        @Test
        public void get給付期間開始年月は_entityが持つ給付期間開始年月を返す() {
            assertThat(sut.get給付期間開始年月(), is(DaisanshaKoiJidanEntity.getKyufuKaishiYMD()));
        }

        @Test
        public void get給付期間終了年月は_entityが持つ給付期間終了年月を返す() {
            assertThat(sut.get給付期間終了年月(), is(DaisanshaKoiJidanEntity.getKyufuShuryoYMD()));
        }

        @Test
        public void get過失割合_加害者は_entityが持つ過失割合_加害者を返す() {
            assertThat(sut.get過失割合_加害者(), is(DaisanshaKoiJidanEntity.getKashitsuWariai_Kagaisha()));
        }

        @Test
        public void get過失割合_被害者は_entityが持つ過失割合_被害者を返す() {
            assertThat(sut.get過失割合_被害者(), is(DaisanshaKoiJidanEntity.getKashitsuWariai_Higaisha()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(DaisanshaKoiJidanEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);

            sut = new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static DaisanshaKoiJidan sut;
        private static DaisanshaKoiJidan result;

        @Before
        public void setUp() {
            DaisanshaKoiJidanEntity = DbT3080DaisanshaKoiJidanEntityGenerator.createDbT3080DaisanshaKoiJidanEntity();
            DaisanshaKoiJidanEntity.setHihokenshaNo(主キー名1);
            DaisanshaKoiJidanEntity.setTodokedeKanriNo(主キー名2);

        }

        @Test
        public void DaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりDaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiJidanが返る() {
            sut = TestSupport.setStateDaisanshaKoiJidan(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりDaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiJidanが返る() {
            sut = TestSupport.setStateDaisanshaKoiJidan(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void DaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりDaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがDeletedに指定されたDaisanshaKoiJidanが返る() {
            sut = TestSupport.setStateDaisanshaKoiJidan(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void DaisanshaKoiJidanが保持するDbT3080DaisanshaKoiJidanEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateDaisanshaKoiJidan(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static DaisanshaKoiJidan setStateDaisanshaKoiJidan(EntityDataState parentState) {
            DaisanshaKoiJidanEntity.setState(parentState);
            return new DaisanshaKoiJidan(DaisanshaKoiJidanEntity);
        }
    }
}
