/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
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
import org.junit.Ignore;

/**
 * {@link KogakuGassanShinseishoKanyureki}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class KogakuGassanShinseishoKanyurekiTest extends DbcTestBase {

    private static DbT3069KogakuGassanShinseishoKanyurekiEntity KogakuGassanShinseishoKanyurekiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYear 主キー名2;
    private static HokenshaNo 主キー名3;
    private static RString 主キー名4;
    private static RString 主キー名5;
    private static int 主キー名6;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_対象年度;
        主キー名3 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_保険者番号;
        主キー名4 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_整理番号;
        主キー名5 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_加入歴番号;
        主キー名6 = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseishoKanyureki(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
        }

        @Test
        public void 指定したキーが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityにセットされている() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.get対象年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanShinseishoKanyurekiIdentifierにセットされている() {
            sut = new KogakuGassanShinseishoKanyureki(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanShinseishoKanyureki(null);
        }

        @Test
        public void 指定したDbT3069KogakuGassanShinseishoKanyurekiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().get対象年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanShinseishoKanyurekiEntity.getHihokenshaNo()));
        }

        @Test
        public void get対象年度は_entityが持つ対象年度を返す() {
            assertThat(sut.get対象年度(), is(KogakuGassanShinseishoKanyurekiEntity.getTaishoNendo()));
        }

        @Test
        public void get保険者番号は_entityが持つ保険者番号を返す() {
            assertThat(sut.get保険者番号(), is(KogakuGassanShinseishoKanyurekiEntity.getHokenshaNo()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KogakuGassanShinseishoKanyurekiEntity.getSeiriNo()));
        }

        @Test
        public void get加入歴番号は_entityが持つ加入歴番号を返す() {
            assertThat(sut.get加入歴番号(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyurekiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanShinseishoKanyurekiEntity.getRirekiNo()));
        }

        @Test
        public void get保険者名は_entityが持つ保険者名を返す() {
            assertThat(sut.get保険者名(), is(KogakuGassanShinseishoKanyurekiEntity.getHokenshaMei()));
        }

        @Test
        public void get加入期間開始年月日は_entityが持つ加入期間開始年月日を返す() {
            assertThat(sut.get加入期間開始年月日(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyuKaishiYMD()));
        }

        @Test
        public void get加入期間終了年月日は_entityが持つ加入期間終了年月日を返す() {
            assertThat(sut.get加入期間終了年月日(), is(KogakuGassanShinseishoKanyurekiEntity.getKanyuShuryoYMD()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanShinseishoKanyurekiEntity.getJikoFutanShomeisho_SeiriNo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanShinseishoKanyurekiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);

            sut = new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanShinseishoKanyureki sut;
        private static KogakuGassanShinseishoKanyureki result;

        @Before
        public void setUp() {
            KogakuGassanShinseishoKanyurekiEntity = DbT3069KogakuGassanShinseishoKanyurekiEntityGenerator.createDbT3069KogakuGassanShinseishoKanyurekiEntity();
            KogakuGassanShinseishoKanyurekiEntity.setHihokenshaNo(主キー名1);
            KogakuGassanShinseishoKanyurekiEntity.setTaishoNendo(主キー名2);

        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanShinseishoKanyurekiが返る() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanShinseishoKanyurekiが保持するDbT3069KogakuGassanShinseishoKanyurekiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanShinseishoKanyureki(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanShinseishoKanyureki setStateKogakuGassanShinseishoKanyureki(EntityDataState parentState) {
            KogakuGassanShinseishoKanyurekiEntity.setState(parentState);
            return new KogakuGassanShinseishoKanyureki(KogakuGassanShinseishoKanyurekiEntity);
        }
    }
}
