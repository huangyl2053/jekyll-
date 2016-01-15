/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import jp.co.ndensan.reams.db.dbz.business.core.Shotoku;
import jp.co.ndensan.reams.db.dbz.business.helper.IsSerializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2008ShotokuKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
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
 * {@link Shotoku}のテストクラスです。
 */
@Ignore
@RunWith(Enclosed.class)
public class ShotokuTest extends DbzTestBase {

    private static DbT2008ShotokuKanriEntity ShotokuEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 所得年度;
    private static ShikibetsuCode 識別コード;
    private static int 履歴番号;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        所得年度 = DbT2008ShotokuKanriEntityGenerator.DEFAULT_所得年度;
        識別コード = DbT2008ShotokuKanriEntityGenerator.DEFAULT_識別コード;
        履歴番号 = DbT2008ShotokuKanriEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 所得年度がnullである場合に_NullPointerExceptionが発生する() {
            sut = new Shotoku(null, 識別コード, 履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 識別コードがnullである場合に_NullPointerExceptionが発生する() {
            sut = new Shotoku(所得年度, null, 履歴番号);
        }

//        @Test(expected = NullPointerException.class)
//        public void 履歴番号がnullである場合に_NullPointerExceptionが発生する() {
//            sut = new Shotoku(所得年度, 識別コード, null);
//        }

        @Test
        public void 指定したキーが保持するDbT2008ShotokuKanriEntityにセットされている() {
            sut = new Shotoku(所得年度, 識別コード, 履歴番号);
            assertThat(sut.get所得年度(), is(所得年度));
            assertThat(sut.get識別コード(), is(識別コード));
            assertThat(sut.get履歴番号(), is(履歴番号));
        }

        @Test
        public void 指定したキーが保持するShotokuIdentifierにセットされている() {
            sut = new Shotoku(所得年度, 識別コード, 履歴番号);
            assertThat(sut.identifier().get所得年度(), is(所得年度));
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class Entityコンストラクタテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new Shotoku(null);
        }

        @Test
        public void 指定したDbT2008ShotokuKanriEntityのキー情報を識別子が持つ() {

            sut = new Shotoku(ShotokuEntity);

            assertThat(sut.identifier().get所得年度(), is(所得年度));
            assertThat(sut.identifier().get識別コード(), is(識別コード));
            assertThat(sut.identifier().get履歴番号(), is(履歴番号));
        }
    }

    public static class getterテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void get所得年度は_entityが持つ所得年度を返す() {
            assertThat(sut.get所得年度(), is(ShotokuEntity.getShotokuNendo()));
        }

        @Test
        public void get識別コードは_entityが持つ識別コードを返す() {
            assertThat(sut.get識別コード(), is(ShotokuEntity.getShikibetsuCode()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShotokuEntity.getRirekiNo()));
        }

        @Test
        public void get非課税区分_住民税減免前はentityが持つ非課税区分_住民税減免前を返す() {
            assertThat(sut.get課税区分_住民税減免前(), is(ShotokuEntity.getKazeiKubun()));
        }

        @Test
        public void get非課税区分_住民税減免後は_entityが持つ非課税区分_住民税減免後を返す() {
            assertThat(sut.get課税区分_住民税減免後(), is(ShotokuEntity.getKazeiKubunGemmenGo()));
        }

        @Test
        public void get合計所得金額は_entityが持つ合計所得金額を返す() {
            assertThat(sut.get合計所得金額(), is(ShotokuEntity.getGokeiShotokuGaku()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(ShotokuEntity.getNenkiniShunyuGaku()));
        }

        @Test
        public void get激変緩和措置区分は_entityが持つ激変緩和措置区分を返す() {
            assertThat(sut.get激変緩和措置区分(), is(ShotokuEntity.getGekihenKanwaKubun()));
        }
    }

    public static class toEntityテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShotokuEntity));
        }
    }

    public static class SerializationProxyテスト extends DbzTestBase {

        private static Shotoku sut;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);

            sut = new Shotoku(ShotokuEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(IsSerializable.serializable()));
        }
    }

    public static class deletedテスト extends DbzTestBase {

        private static Shotoku sut;
        private static Shotoku result;

        @Before
        public void setUp() {
            ShotokuEntity = DbT2008ShotokuKanriEntityGenerator.createDbT2008ShotokuKanriEntity();
            ShotokuEntity.setShotokuNendo(所得年度);
            ShotokuEntity.setShikibetsuCode(識別コード);
            ShotokuEntity.setRirekiNo(履歴番号);

        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void Shotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがDeletedに指定されたShotokuが返る() {
            sut = TestSupport.setStateShotoku(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void Shotokuが保持するDbT2008ShotokuKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShotoku(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static Shotoku setStateShotoku(EntityDataState parentState) {
            ShotokuEntity.setState(parentState);
            return new Shotoku(ShotokuEntity);
        }
    }
}
