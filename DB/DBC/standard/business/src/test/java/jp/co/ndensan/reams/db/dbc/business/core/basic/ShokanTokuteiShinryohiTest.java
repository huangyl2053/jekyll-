/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.entity.basic.helper.DbT3041ShokanTokuteiShinryohiEntityGenerator;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import static jp.co.ndensan.reams.db.dbx.testhelper.matcher.IsSerializable.serializable;
import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
//import static jp.co.ndensan.reams.db.dbc.testhelper.matcher.IsSerializable.serializable;
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
 * {@link ShokanTokuteiShinryohi}のテストクラスです。
 */
@RunWith(Enclosed.class)
@Ignore
public class ShokanTokuteiShinryohiTest extends DbcTestBase {

    private static DbT3041ShokanTokuteiShinryohiEntity ShokanTokuteiShinryohiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static HihokenshaNo 主キー名1;
    private static FlexibleYearMonth 主キー名2;
    private static RString 主キー名3;
    private static JigyoshaNo 主キー名4;
    private static RString 主キー名5;
    private static RString 主キー名6;
    private static Decimal 主キー名7;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        主キー名1 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_被保険者番号;
        主キー名2 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_サービス提供年月;
        主キー名3 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_整理番号;
        主キー名4 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_事業者番号;
        主キー名5 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_様式番号;
        主キー名6 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_順次番号;
        主キー名7 = DbT3041ShokanTokuteiShinryohiEntityGenerator.DEFAULT_履歴番号;
    }

    public static class 主キーコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiShinryohi(null, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new ShokanTokuteiShinryohi(主キー名1, null, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
        }

        @Test
        public void 指定したキーが保持するDbT3041ShokanTokuteiShinryohiEntityにセットされている() {
            sut = new ShokanTokuteiShinryohi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.get被保険者番号(), is(主キー名1));
            assertThat(sut.getサービス提供年月(), is(主キー名2));
        }

        @Test
        public void 指定したキーが保持するShokanTokuteiShinryohiIdentifierにセットされている() {
            sut = new ShokanTokuteiShinryohi(主キー名1, 主キー名2, 主キー名3, 主キー名4, 主キー名5, 主キー名6, 主キー名7);
            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class Entityコンストラクタテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new ShokanTokuteiShinryohi(null);
        }

        @Test
        public void 指定したDbT3041ShokanTokuteiShinryohiEntityのキー情報を識別子が持つ() {

            sut = new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);

            assertThat(sut.identifier().get被保険者番号(), is(主キー名1));
            assertThat(sut.identifier().getサービス提供年月(), is(主キー名2));
        }
    }

    public static class getterテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);
        }

        @Test
        public void get被保険者番号は_entityが持つ被保険者番号を返す() {
            assertThat(sut.get被保険者番号(), is(ShokanTokuteiShinryohiEntity.getHiHokenshaNo()));
        }

        @Test
        public void getサービス提供年月は_entityが持つサービス提供年月を返す() {
            assertThat(sut.getサービス提供年月(), is(ShokanTokuteiShinryohiEntity.getServiceTeikyoYM()));
        }

        @Test
        public void get整理番号は_entityが持つ整理番号を返す() {
            assertThat(sut.get整理番号(), is(ShokanTokuteiShinryohiEntity.getSeiriNo()));
        }

        @Test
        public void get事業者番号は_entityが持つ事業者番号を返す() {
            assertThat(sut.get事業者番号(), is(ShokanTokuteiShinryohiEntity.getJigyoshaNo()));
        }

        @Test
        public void get様式番号は_entityが持つ様式番号を返す() {
            assertThat(sut.get様式番号(), is(ShokanTokuteiShinryohiEntity.getYoshikiNo()));
        }

        @Test
        public void get順次番号は_entityが持つ順次番号を返す() {
            assertThat(sut.get順次番号(), is(ShokanTokuteiShinryohiEntity.getJunjiNo()));
        }

        @Test
        public void get履歴番号は_entityが持つ履歴番号を返す() {
            assertThat(sut.get履歴番号(), is(ShokanTokuteiShinryohiEntity.getRirekiNo()));
        }

        @Test
        public void get傷病名は_entityが持つ傷病名を返す() {
            assertThat(sut.get傷病名(), is(ShokanTokuteiShinryohiEntity.getShobyoName()));
        }

        @Test
        public void get指導管理料等単位数は_entityが持つ指導管理料等単位数を返す() {
            assertThat(sut.get指導管理料等単位数(), is(ShokanTokuteiShinryohiEntity.getShidoKanriryoTanisu()));
        }

        @Test
        public void get単純エックス線単位数は_entityが持つ単純エックス線単位数を返す() {
            assertThat(sut.get単純エックス線単位数(), is(ShokanTokuteiShinryohiEntity.getTanjunXsenTanisu()));
        }

        @Test
        public void getリハビリテーション単位数は_entityが持つリハビリテーション単位数を返す() {
            assertThat(sut.getリハビリテーション単位数(), is(ShokanTokuteiShinryohiEntity.getRehabilitationTanisu()));
        }

        @Test
        public void get精神科専門療法単位数は_entityが持つ精神科専門療法単位数を返す() {
            assertThat(sut.get精神科専門療法単位数(), is(ShokanTokuteiShinryohiEntity.getSeishinkaSemmonRyoyohouTanisu()));
        }

        @Test
        public void get合計単位数は_entityが持つ合計単位数を返す() {
            assertThat(sut.get合計単位数(), is(ShokanTokuteiShinryohiEntity.getTotalTanisu()));
        }

        @Test
        public void get摘要１は_entityが持つ摘要１を返す() {
            assertThat(sut.get摘要１(), is(ShokanTokuteiShinryohiEntity.getTekiyo1()));
        }

        @Test
        public void get摘要２は_entityが持つ摘要２を返す() {
            assertThat(sut.get摘要２(), is(ShokanTokuteiShinryohiEntity.getTekiyo2()));
        }

        @Test
        public void get摘要３は_entityが持つ摘要３を返す() {
            assertThat(sut.get摘要３(), is(ShokanTokuteiShinryohiEntity.getTekiyo3()));
        }

        @Test
        public void get摘要４は_entityが持つ摘要４を返す() {
            assertThat(sut.get摘要４(), is(ShokanTokuteiShinryohiEntity.getTekiyo4()));
        }

        @Test
        public void get摘要５は_entityが持つ摘要５を返す() {
            assertThat(sut.get摘要５(), is(ShokanTokuteiShinryohiEntity.getTekiyo5()));
        }

        @Test
        public void get摘要６は_entityが持つ摘要６を返す() {
            assertThat(sut.get摘要６(), is(ShokanTokuteiShinryohiEntity.getTekiyo6()));
        }

        @Test
        public void get摘要７は_entityが持つ摘要７を返す() {
            assertThat(sut.get摘要７(), is(ShokanTokuteiShinryohiEntity.getTekiyo7()));
        }

        @Test
        public void get摘要８は_entityが持つ摘要８を返す() {
            assertThat(sut.get摘要８(), is(ShokanTokuteiShinryohiEntity.getTekiyo8()));
        }

        @Test
        public void get摘要９は_entityが持つ摘要９を返す() {
            assertThat(sut.get摘要９(), is(ShokanTokuteiShinryohiEntity.getTekiyo9()));
        }

        @Test
        public void get摘要１０は_entityが持つ摘要１０を返す() {
            assertThat(sut.get摘要１０(), is(ShokanTokuteiShinryohiEntity.getTekiyo10()));
        }

        @Test
        public void get摘要１１は_entityが持つ摘要１１を返す() {
            assertThat(sut.get摘要１１(), is(ShokanTokuteiShinryohiEntity.getTekiyo11()));
        }

        @Test
        public void get摘要１２は_entityが持つ摘要１２を返す() {
            assertThat(sut.get摘要１２(), is(ShokanTokuteiShinryohiEntity.getTekiyo12()));
        }

        @Test
        public void get摘要１３は_entityが持つ摘要１３を返す() {
            assertThat(sut.get摘要１３(), is(ShokanTokuteiShinryohiEntity.getTekiyo13()));
        }

        @Test
        public void get摘要１４は_entityが持つ摘要１４を返す() {
            assertThat(sut.get摘要１４(), is(ShokanTokuteiShinryohiEntity.getTekiyo14()));
        }

        @Test
        public void get摘要１５は_entityが持つ摘要１５を返す() {
            assertThat(sut.get摘要１５(), is(ShokanTokuteiShinryohiEntity.getTekiyo15()));
        }

        @Test
        public void get摘要１６は_entityが持つ摘要１６を返す() {
            assertThat(sut.get摘要１６(), is(ShokanTokuteiShinryohiEntity.getTekiyo16()));
        }

        @Test
        public void get摘要１７は_entityが持つ摘要１７を返す() {
            assertThat(sut.get摘要１７(), is(ShokanTokuteiShinryohiEntity.getTekiyo17()));
        }

        @Test
        public void get摘要１８は_entityが持つ摘要１８を返す() {
            assertThat(sut.get摘要１８(), is(ShokanTokuteiShinryohiEntity.getTekiyo18()));
        }

        @Test
        public void get摘要１９は_entityが持つ摘要１９を返す() {
            assertThat(sut.get摘要１９(), is(ShokanTokuteiShinryohiEntity.getTekiyo19()));
        }

        @Test
        public void get摘要２０は_entityが持つ摘要２０を返す() {
            assertThat(sut.get摘要２０(), is(ShokanTokuteiShinryohiEntity.getTekiyo20()));
        }
    }

    public static class toEntityテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(ShokanTokuteiShinryohiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);

            sut = new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbcTestBase {

        private static ShokanTokuteiShinryohi sut;
        private static ShokanTokuteiShinryohi result;

        @Before
        public void setUp() {
            ShokanTokuteiShinryohiEntity = DbT3041ShokanTokuteiShinryohiEntityGenerator.createDbT3041ShokanTokuteiShinryohiEntity();
            ShokanTokuteiShinryohiEntity.setHiHokenshaNo(主キー名1);
            ShokanTokuteiShinryohiEntity.setServiceTeikyoYM(主キー名2);

        }

        @Test
        public void ShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryohiが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryohi(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryohiが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryohi(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void ShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがDeletedに指定されたShokanTokuteiShinryohiが返る() {
            sut = TestSupport.setStateShokanTokuteiShinryohi(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void ShokanTokuteiShinryohiが保持するDbT3041ShokanTokuteiShinryohiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateShokanTokuteiShinryohi(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    private static class TestSupport {

        public static ShokanTokuteiShinryohi setStateShokanTokuteiShinryohi(EntityDataState parentState) {
            ShokanTokuteiShinryohiEntity.setState(parentState);
            return new ShokanTokuteiShinryohi(ShokanTokuteiShinryohiEntity);
        }
    }
}
