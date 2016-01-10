/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3113RiyoshaFutanWariaiEntityGenerator;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
 * {@link RiyoshaFutanWariai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class RiyoshaFutanWariaiTest extends DbcTestBase {

    private static DbT3113RiyoshaFutanWariaiEntity RiyoshaFutanWariaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 年度;
    private static HihokenshaNo 被保険者番号;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        年度 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_年度;
        被保険者番号 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT3113RiyoshaFutanWariaiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 年度がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariai(null, 被保険者番号, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariai(年度, null, 履歴番号);
        }

        @Test
        public void 指定したキーが保持するDbT3113RiyoshaFutanWariaiEntityにセットされている() {
            sut = new RiyoshaFutanWariai(年度, 被保険者番号, 履歴番号);
            assertThat(sut.get年度(), is(年度));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
        }

        @Test
        public void 指定したキーが保持するRiyoshaFutanWariaiIdentifierにセットされている() {
            sut = new RiyoshaFutanWariai(年度, 被保険者番号, 履歴番号);
            assertThat(sut.identifier().get年度(), is(年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RiyoshaFutanWariai(null);
        }

        @Test
        public void 指定したDbT3113RiyoshaFutanWariaiEntityのキー情報を識別子が持つ() {

            sut = new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);

            assertThat(sut.identifier().get年度(), is(年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);

            sut = new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);
        }

        @Test
        public void get年度は_entityが持つ年度を返す() {
            assertThat(sut.get年度(), is(RiyoshaFutanWariaiEntity.getNendo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(RiyoshaFutanWariaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(RiyoshaFutanWariaiEntity.getRirekiNo()));
        }

        @Test
        public void get発行不要フラグは_entityが持つ発行不要フラグを返す() {
            assertThat(sut.is発行不要フラグ(), is(RiyoshaFutanWariaiEntity.getHakoFuyoFlag()));
        }

        @Test
        public void get職権変更フラグは_entityが持つ職権変更フラグを返す() {
            assertThat(sut.is職権変更フラグ(), is(RiyoshaFutanWariaiEntity.getShokenFlag()));
        }

        @Test
        public void get判定日は_entityが持つ判定日を返す() {
            assertThat(sut.get判定日(), is(RiyoshaFutanWariaiEntity.getHanteiYMD()));
        }

        @Test
        public void get判定区分は_entityが持つ判定区分を返す() {
            assertThat(sut.get判定区分(), is(RiyoshaFutanWariaiEntity.getHanteiKubun()));
        }

        @Test
        public void get更正事由は_entityが持つ更正事由を返す() {
            assertThat(sut.get更正事由(), is(RiyoshaFutanWariaiEntity.getKoseiJiyu()));
        }

        @Test
        public void get発行区分は_entityが持つ発行区分を返す() {
            assertThat(sut.get発行区分(), is(RiyoshaFutanWariaiEntity.getHakoKubun()));
        }

        @Test
        public void get発行日は_entityが持つ発行日を返す() {
            assertThat(sut.get発行日(), is(RiyoshaFutanWariaiEntity.getHakoYMD()));
        }

        @Test
        public void get交付日は_entityが持つ交付日を返す() {
            assertThat(sut.get交付日(), is(RiyoshaFutanWariaiEntity.getKofuYMD()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);

            sut = new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RiyoshaFutanWariaiEntity));
        }
    }

    @Ignore
    public static class SerializationProxyテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);

            sut = new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static RiyoshaFutanWariai sut;
        private static RiyoshaFutanWariai result;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiEntity = DbT3113RiyoshaFutanWariaiEntityGenerator.createDbT3113RiyoshaFutanWariaiEntity();
            RiyoshaFutanWariaiEntity.setNendo(年度);
            RiyoshaFutanWariaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void RiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RiyoshaFutanWariaiが保持するDbT3113RiyoshaFutanWariaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRiyoshaFutanWariai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RiyoshaFutanWariai setStateRiyoshaFutanWariai(EntityDataState parentState) {
            RiyoshaFutanWariaiEntity.setState(parentState);
            return new RiyoshaFutanWariai(RiyoshaFutanWariaiEntity);
        }
    }
}
