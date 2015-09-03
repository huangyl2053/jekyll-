/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3116KijunShunyugakuTekiyoKanriEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3116KijunShunyugakuTekiyoKanriEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
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

/**
 * {@link KijunShunyugakuTekiyoKanri}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KijunShunyugakuTekiyoKanriTest extends DbcTestBase {

    private static DbT3116KijunShunyugakuTekiyoKanriEntity KijunShunyugakuTekiyoKanriEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static SetaiCode 主キー名1;
    private static FlexibleYear 主キー名2;
    private static Decimal 主キー名3;
    private static HokenshaNo 主キー名4;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_世帯コード;
        主キー名2 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_年度;
        主キー名3 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_履歴番号;
        主キー名4 = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.DEFAULT_被保険者番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KijunShunyugakuTekiyoKanri(null, 主キー名2, 主キー名3, 主キー名4);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new KijunShunyugakuTekiyoKanri(主キー名1, null, 主キー名3, 主キー名4);
        }

        @Test
        public void 指定したキーが保持するDbT3116KijunShunyugakuTekiyoKanriEntityにセットされている() {
            sut = new KijunShunyugakuTekiyoKanri(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.get世帯コード(), is(主キー名1));
            assertThat(sut.get年度(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するKijunShunyugakuTekiyoKanriIdentifierにセットされている() {
            sut = new KijunShunyugakuTekiyoKanri(主キー名1, 主キー名2, 主キー名3, 主キー名4);
            assertThat(sut.identifier().get世帯コード(), is(主キー名1));
            assertThat(sut.identifier().get年度(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new KijunShunyugakuTekiyoKanri(null);
        }

        @Test
        public void 指定したDbT3116KijunShunyugakuTekiyoKanriEntityのキー情報を識別子が持つ() {

            sut = new KijunShunyugakuTekiyoKanri(KijunShunyugakuTekiyoKanriEntity);

            assertThat(sut.identifier().get世帯コード(), is(主キー名1));
            assertThat(sut.identifier().get年度(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);

            sut = new KijunShunyugakuTekiyoKanri(KijunShunyugakuTekiyoKanriEntity);
        }

        @Test
        public void get世帯コードは_entityが持つ世帯コードを返す() {
            assertThat(sut.get世帯コード(), is(KijunShunyugakuTekiyoKanriEntity.getSetaiCode()));
        }

        @Test
        public void get年度は_entityが持つ年度を返す() {
            assertThat(sut.get年度(), is(KijunShunyugakuTekiyoKanriEntity.getNendo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(KijunShunyugakuTekiyoKanriEntity.getRirekiNo()));
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(KijunShunyugakuTekiyoKanriEntity.getHihokenshaNo()));
        }

        @Test
        public void get公的年金収入額は_entityが持つ公的年金収入額を返す() {
            assertThat(sut.get公的年金収入額(), is(KijunShunyugakuTekiyoKanriEntity.getKotekiNenkinShunyugaku()));
        }

        @Test
        public void get給与収入額は_entityが持つ給与収入額を返す() {
            assertThat(sut.get給与収入額(), is(KijunShunyugakuTekiyoKanriEntity.getKyuyoShunyugaku()));
        }

        @Test
        public void getその他の収入額は_entityが持つその他の収入額を返す() {
            assertThat(sut.getその他の収入額(), is(KijunShunyugakuTekiyoKanriEntity.getSonotaShunyugaku()));
        }

        @Test
        public void get算定基準額は_entityが持つ算定基準額を返す() {
            assertThat(sut.get算定基準額(), is(KijunShunyugakuTekiyoKanriEntity.getSanteiKijungaku()));
        }

        @Test
        public void get適用開始年月は_entityが持つ適用開始年月を返す() {
            assertThat(sut.get適用開始年月(), is(KijunShunyugakuTekiyoKanriEntity.getTekiyoKaishiYMD()));
        }

        @Test
        public void get申請日は_entityが持つ申請日を返す() {
            assertThat(sut.get申請日(), is(KijunShunyugakuTekiyoKanriEntity.getShinseiYMD()));
        }

        @Test
        public void get決定日は_entityが持つ決定日を返す() {
            assertThat(sut.get決定日(), is(KijunShunyugakuTekiyoKanriEntity.getKetteiYMD()));
        }

        @Test
        public void get申請書作成日は_entityが持つ申請書作成日を返す() {
            assertThat(sut.get申請書作成日(), is(KijunShunyugakuTekiyoKanriEntity.getShinseishoSakuseiYMD()));
        }

        @Test
        public void get申請書作成の世帯基準日は_entityが持つ申請書作成の世帯基準日を返す() {
            assertThat(sut.get申請書作成の世帯基準日(), is(KijunShunyugakuTekiyoKanriEntity.getShinseishoSakuseiSetaiKijunYMD()));
        }

        @Test
        public void get決定通知書発行日は_entityが持つ決定通知書発行日を返す() {
            assertThat(sut.get決定通知書発行日(), is(KijunShunyugakuTekiyoKanriEntity.getKetteiTsuchishoHakkoYMD()));
        }

        @Test
        public void get宛先印字対象者フラグは_entityが持つ宛先印字対象者フラグを返す() {
            assertThat(sut.get宛先印字対象者フラグ(), is(KijunShunyugakuTekiyoKanriEntity.getAtesakiInjiTaishoshaFlag()));
        }

        @Test
        public void get年少扶養控除_16歳未満人数は_entityが持つ年少扶養控除_16歳未満人数を返す() {
            assertThat(sut.get年少扶養控除_16歳未満人数(), is(KijunShunyugakuTekiyoKanriEntity.getNenshoFuyokojoUnder16Ninzu()));
        }

        @Test
        public void get年少扶養控除_16_18歳未満人数は_entityが持つ年少扶養控除_16_18歳未満人数を返す() {
            assertThat(sut.get年少扶養控除_16から18歳未満人数(), is(KijunShunyugakuTekiyoKanriEntity.getNenshoFuyokojoOver16Ninzu()));
        }

        @Test
        public void get世帯員の総収入額は_entityが持つ世帯員の総収入額を返す() {
            assertThat(sut.get世帯員の総収入額(), is(KijunShunyugakuTekiyoKanriEntity.getSetaiinSoShunyugaku()));
        }

        @Test
        public void get世帯主フラグは_entityが持つ世帯主フラグを返す() {
            assertThat(sut.get世帯主フラグ(), is(KijunShunyugakuTekiyoKanriEntity.getSetainushiFlag()));
        }

        @Test
        public void get課税所得額は_entityが持つ課税所得額を返す() {
            assertThat(sut.get課税所得額(), is(KijunShunyugakuTekiyoKanriEntity.getKazeiShotokugaku()));
        }

        @Test
        public void get課税所得額_控除後は_entityが持つ課税所得額_控除後を返す() {
            assertThat(sut.get課税所得額_控除後(), is(KijunShunyugakuTekiyoKanriEntity.getKazeiShotokugakuKojogo()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);

            sut = new KijunShunyugakuTekiyoKanri(KijunShunyugakuTekiyoKanriEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(KijunShunyugakuTekiyoKanriEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);

            sut = new KijunShunyugakuTekiyoKanri(KijunShunyugakuTekiyoKanriEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static KijunShunyugakuTekiyoKanri sut;
        private static KijunShunyugakuTekiyoKanri result;

        @Before
        public void setUp() {
            KijunShunyugakuTekiyoKanriEntity = DbT3116KijunShunyugakuTekiyoKanriEntityGenerator.createDbT3116KijunShunyugakuTekiyoKanriEntity();
            KijunShunyugakuTekiyoKanriEntity.setSetaiCode(主キー名1);
            KijunShunyugakuTekiyoKanriEntity.setNendo(主キー名2);

        }

        @Test
        public void KijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりKijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがDeletedに指定されたKijunShunyugakuTekiyoKanriが返る() {
            sut = TestSupport.setStateKijunShunyugakuTekiyoKanri(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりKijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがDeletedに指定されたKijunShunyugakuTekiyoKanriが返る() {
            sut = TestSupport.setStateKijunShunyugakuTekiyoKanri(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void KijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりKijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがDeletedに指定されたKijunShunyugakuTekiyoKanriが返る() {
            sut = TestSupport.setStateKijunShunyugakuTekiyoKanri(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void KijunShunyugakuTekiyoKanriが保持するDbT3116KijunShunyugakuTekiyoKanriEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateKijunShunyugakuTekiyoKanri(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static KijunShunyugakuTekiyoKanri setStateKijunShunyugakuTekiyoKanri(EntityDataState parentState) {
            KijunShunyugakuTekiyoKanriEntity.setState(parentState);
            return new KijunShunyugakuTekiyoKanri(KijunShunyugakuTekiyoKanriEntity);
        }
    }
}
