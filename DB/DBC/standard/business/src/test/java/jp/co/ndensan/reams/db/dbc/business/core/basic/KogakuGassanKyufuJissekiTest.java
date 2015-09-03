/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3075KogakuGassanKyufuJissekiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
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
 * {@link KogakuGassanKyufuJisseki}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KogakuGassanKyufuJissekiTest extends DbcTestBase {

    private static DbT3075KogakuGassanKyufuJissekiEntity KogakuGassanKyufuJissekiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static KokanShikibetsuNo 主キー名1;
    private static HihokenshaNo 主キー名2;
    private static RString 主キー名3;
    private static RString 主キー名4;
    private static Decimal 主キー名5;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_交換情報識別番号;
        主キー名2 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_被保険者番号;
        主キー名3 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_支給申請書整理番号;
        主キー名4 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_整理番号;
        主キー名5 = DbT3075KogakuGassanKyufuJissekiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanKyufuJisseki(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KogakuGassanKyufuJisseki(主キー名1, null, 主キー名3, 主キー名4, 主キー名5);
        }

        @Test
        public void 指定したキーが保持するDbT3075KogakuGassanKyufuJissekiEntityにセットされている() {
            sut = new KogakuGassanKyufuJisseki(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.get交換情報識別番号(), is(主キー名1));
            assertThat(sut.get被保険者番号(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKogakuGassanKyufuJissekiIdentifierにセットされている() {
            sut = new KogakuGassanKyufuJisseki(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5);
            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KogakuGassanKyufuJisseki(null);
        }

        @Test
        public void 指定したDbT3075KogakuGassanKyufuJissekiEntityのキー情報を識別子が持つ() {

            sut = new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);

            assertThat(sut.identifier().get交換情報識別番号(), is(主キー名1));
            assertThat(sut.identifier().get被保険者番号(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);

            sut = new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);
        }

        @Test
        public void get交換情報識別番号は_entityが持つ交換情報識別番号を返す() {
            assertThat(sut.get交換情報識別番号(), is(KogakuGassanKyufuJissekiEntity.getKokanJohoShikibetsuNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KogakuGassanKyufuJissekiEntity.getHihokenshaNo()));
        }

        @Test
        public void get支給申請書整理番号は_entityが持つ支給申請書整理番号を返す() {
            assertThat(sut.get支給申請書整理番号(), is(KogakuGassanKyufuJissekiEntity.getShikyuShinseiSeiriNo()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(KogakuGassanKyufuJissekiEntity.getSeiriNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KogakuGassanKyufuJissekiEntity.getRirekiNo()));
        }

        @Test
        public void get自己負担額証明書整理番号は_entityが持つ自己負担額証明書整理番号を返す() {
            assertThat(sut.get自己負担額証明書整理番号(), is(KogakuGassanKyufuJissekiEntity.getJikoFutanSeiriNo()));
        }

        @Test
        public void get保険制度コードは_entityが持つ保険制度コードを返す() {
            assertThat(sut.get保険制度コード(), is(KogakuGassanKyufuJissekiEntity.getHokenSeidoCode()));
        }

        @Test
        public void get給付実績作成区分コードは_entityが持つ給付実績作成区分コードを返す() {
            assertThat(sut.get給付実績作成区分コード(), is(KogakuGassanKyufuJissekiEntity.getKyufuJissekiSakuseiKubunCode()));
        }

        @Test
        public void get証記載保険者番号は_entityが持つ証記載保険者番号を返す() {
            assertThat(sut.get証記載保険者番号(), is(KogakuGassanKyufuJissekiEntity.getShoKisaiHokenshaNo()));
        }

        @Test
        public void get国保_被保険者証記号は_entityが持つ国保_被保険者証記号を返す() {
            assertThat(sut.get国保_被保険者証記号(), is(KogakuGassanKyufuJissekiEntity.getKokuho_HihokenshaShoKigo()));
        }

        @Test
        public void get申請年月日は_entityが持つ申請年月日を返す() {
            assertThat(sut.get申請年月日(), is(KogakuGassanKyufuJissekiEntity.getShinseiYMD()));
        }

        @Test
        public void get決定年月日は_entityが持つ決定年月日を返す() {
            assertThat(sut.get決定年月日(), is(KogakuGassanKyufuJissekiEntity.getKetteiYMD()));
        }

        @Test
        public void get自己負担総額は_entityが持つ自己負担総額を返す() {
            assertThat(sut.get自己負担総額(), is(KogakuGassanKyufuJissekiEntity.getJikoFutanSogaku()));
        }

        @Test
        public void get支給額は_entityが持つ支給額を返す() {
            assertThat(sut.get支給額(), is(KogakuGassanKyufuJissekiEntity.getShikyuGaku()));
        }

        @Test
        public void get処理年月は_entityが持つ処理年月を返す() {
            assertThat(sut.get処理年月(), is(KogakuGassanKyufuJissekiEntity.getShoriYM()));
        }

        @Test
        public void get受取年月は_entityが持つ受取年月を返す() {
            assertThat(sut.get受取年月(), is(KogakuGassanKyufuJissekiEntity.getUketoriYM()));
        }

        @Test
        public void get送付年月は_entityが持つ送付年月を返す() {
            assertThat(sut.get送付年月(), is(KogakuGassanKyufuJissekiEntity.getSofuYM()));
        }

        @Test
        public void getデータ区分は_entityが持つデータ区分を返す() {
            assertThat(sut.getデータ区分(), is(KogakuGassanKyufuJissekiEntity.getDataKubun()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);

            sut = new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KogakuGassanKyufuJissekiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);

            sut = new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KogakuGassanKyufuJisseki sut;
        private static KogakuGassanKyufuJisseki result;

        @Before
        public void setUp() {
            KogakuGassanKyufuJissekiEntity = DbT3075KogakuGassanKyufuJissekiEntityGenerator.createDbT3075KogakuGassanKyufuJissekiEntity();
            KogakuGassanKyufuJissekiEntity.setKokanJohoShikibetsuNo(主キー名1);
            KogakuGassanKyufuJissekiEntity.setHihokenshaNo(主キー名2);

        }

        @Test
        public void KogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanKyufuJissekiが返る() {
            sut = TestSupport.setStateKogakuGassanKyufuJisseki(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanKyufuJissekiが返る() {
            sut = TestSupport.setStateKogakuGassanKyufuJisseki(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがDeletedに指定されたKogakuGassanKyufuJissekiが返る() {
            sut = TestSupport.setStateKogakuGassanKyufuJisseki(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KogakuGassanKyufuJissekiが保持するDbT3075KogakuGassanKyufuJissekiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKogakuGassanKyufuJisseki(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KogakuGassanKyufuJisseki setStateKogakuGassanKyufuJisseki(EntityDataState parentState) {
            KogakuGassanKyufuJissekiEntity.setState(parentState);
            return new KogakuGassanKyufuJisseki(KogakuGassanKyufuJissekiEntity);
        }
    }
}
