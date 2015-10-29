/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator;
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
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Ignore;

/**
 * {@link RiyoshaFutanWariaiMeisai}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class RiyoshaFutanWariaiMeisaiTest extends DbcTestBase {

    private static DbT3114RiyoshaFutanWariaiMeisaiEntity RiyoshaFutanWariaiMeisaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 年度;
    private static HihokenshaNo 被保険者番号;
    private static Decimal 履歴番号;
    private static Decimal 枝番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        年度 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_年度;
        被保険者番号 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_被保険者番号;
        履歴番号 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_履歴番号;
        枝番号 = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.DEFAULT_枝番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 年度がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariaiMeisai(null, 被保険者番号, 履歴番号, 枝番号);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者番号がnullである場合に_NullPointerExceptionが発生する() {
            sut = new RiyoshaFutanWariaiMeisai(年度, null, 履歴番号, 枝番号);
        }

        @Test
        public void 指定したキーが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityにセットされている() {
            sut = new RiyoshaFutanWariaiMeisai(年度, 被保険者番号, 履歴番号, 枝番号);
            assertThat(sut.get年度(), is(年度));
            assertThat(sut.get被保険者番号(), is(被保険者番号));
            assertThat(sut.get履歴番号(), is(履歴番号));
            assertThat(sut.get枝番号(), is(枝番号));
        }

        @Test
        public void 指定したキーが保持するRiyoshaFutanWariaiMeisaiIdentifierにセットされている() {
            sut = new RiyoshaFutanWariaiMeisai(年度, 被保険者番号, 履歴番号, 枝番号);
            assertThat(sut.identifier().get年度(), is(年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get枝番号(), is(枝番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new RiyoshaFutanWariaiMeisai(null);
        }

        @Test
        public void 指定したDbT3114RiyoshaFutanWariaiMeisaiEntityのキー情報を識別子が持つ() {

            sut = new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);

            assertThat(sut.identifier().get年度(), is(年度));
            assertThat(sut.identifier().get被保険者番号(), is(被保険者番号));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
            assertThat(sut.identifier().get枝番号(), is(枝番号));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);

            sut = new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);
        }

        @Test
        public void get年度は_entityが持つ年度を返す() {
            assertThat(sut.get年度(), is(RiyoshaFutanWariaiMeisaiEntity.getNendo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(RiyoshaFutanWariaiMeisaiEntity.getHihokenshaNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(RiyoshaFutanWariaiMeisaiEntity.getRirekiNo()));
        }

        @Test
        public void get枝番号は_entityが持つ枝番号を返す() {
            assertThat(sut.get枝番号(), is(RiyoshaFutanWariaiMeisaiEntity.getEdaNo()));
        }

        @Test
        public void get資格区分は_entityが持つ資格区分を返す() {
            assertThat(sut.get資格区分(), is(RiyoshaFutanWariaiMeisaiEntity.getShikakuKubun()));
        }

        @Test
        public void get負担割合区分は_entityが持つ負担割合区分を返す() {
            assertThat(sut.get負担割合区分(), is(RiyoshaFutanWariaiMeisaiEntity.getFutanWariaiKubun()));
        }

        @Test
        public void get有効開始日は_entityが持つ有効開始日を返す() {
            assertThat(sut.get有効開始日(), is(RiyoshaFutanWariaiMeisaiEntity.getYukoKaishiYMD()));
        }

        @Test
        public void get有効終了日は_entityが持つ有効終了日を返す() {
            assertThat(sut.get有効終了日(), is(RiyoshaFutanWariaiMeisaiEntity.getYukoShuryoYMD()));
        }

        @Test
        public void get本人合計所得金額は_entityが持つ本人合計所得金額を返す() {
            assertThat(sut.get本人合計所得金額(), is(RiyoshaFutanWariaiMeisaiEntity.getHonninGoukeiShotokuGaku()));
        }

        @Test
        public void get世帯１号被保険者数は_entityが持つ世帯１号被保険者数を返す() {
            assertThat(sut.get世帯１号被保険者数(), is(RiyoshaFutanWariaiMeisaiEntity.getSetaiIchigouHihoknehsaSu()));
        }

        @Test
        public void get年金収入合計は_entityが持つ年金収入合計を返す() {
            assertThat(sut.get年金収入合計(), is(RiyoshaFutanWariaiMeisaiEntity.getNenkinShunyuGoukei()));
        }

        @Test
        public void getその他の合計所得金額合計は_entityが持つその他の合計所得金額合計を返す() {
            assertThat(sut.getその他の合計所得金額合計(), is(RiyoshaFutanWariaiMeisaiEntity.getSonotanoGoukeiShotokuKingakuGoukei()));
        }

        @Test
        public void get更正理由は_entityが持つ更正理由を返す() {
            assertThat(sut.get更正理由(), is(RiyoshaFutanWariaiMeisaiEntity.getKoseiRiyu()));
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(RiyoshaFutanWariaiMeisaiEntity.getSetaiCd()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);

            sut = new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(RiyoshaFutanWariaiMeisaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);

            sut = new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static RiyoshaFutanWariaiMeisai sut;
        private static RiyoshaFutanWariaiMeisai result;

        @Before
        public void setUp() {
            RiyoshaFutanWariaiMeisaiEntity = DbT3114RiyoshaFutanWariaiMeisaiEntityGenerator.createDbT3114RiyoshaFutanWariaiMeisaiEntity();
            RiyoshaFutanWariaiMeisaiEntity.setNendo(年度);
            RiyoshaFutanWariaiMeisaiEntity.setHihokenshaNo(被保険者番号);
            RiyoshaFutanWariaiMeisaiEntity.setRirekiNo(履歴番号);
            RiyoshaFutanWariaiMeisaiEntity.setEdaNo(枝番号);

        }

        @Test
        public void RiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりRiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiMeisaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiMeisai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりRiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiMeisaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiMeisai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void RiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりRiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがDeletedに指定されたRiyoshaFutanWariaiMeisaiが返る() {
            sut = TestSupport.setStateRiyoshaFutanWariaiMeisai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void RiyoshaFutanWariaiMeisaiが保持するDbT3114RiyoshaFutanWariaiMeisaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateRiyoshaFutanWariaiMeisai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static RiyoshaFutanWariaiMeisai setStateRiyoshaFutanWariaiMeisai(EntityDataState parentState) {
            RiyoshaFutanWariaiMeisaiEntity.setState(parentState);
            return new RiyoshaFutanWariaiMeisai(RiyoshaFutanWariaiMeisaiEntity);
        }
    }
}
