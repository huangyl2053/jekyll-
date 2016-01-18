/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2013HokenryoDankaiEntityGenerator;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {@link HokenryoDankai}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class HokenryoDankaiTest extends DbbTestBase {

    private static DbT2013HokenryoDankaiEntity HokenryoDankaiEntity;  //TODO 変数名称の頭文字を小文字に変更して下さい。
//TODO 主キー型と変数名を置換してください
//TODO 主キーの数が足りない場合、追加してください。
    private static FlexibleYear 賦課年度;
    private static DankaiIndex 段階index;
    private static RankKubun ランク区分;

    private static final FlexibleYear 激変緩和開始年度 = new FlexibleYear("2006");
    private static final FlexibleYear 激変緩和終了年度 = new FlexibleYear("2007");
    private static final FukaNendo 賦課年度_第1期 = new FukaNendo("2000");
    private static final FukaNendo 賦課年度_第2期 = new FukaNendo("2003");
    private static final FukaNendo 賦課年度_第3期 = new FukaNendo("2006");
    private static final FukaNendo 賦課年度_第5期 = new FukaNendo("2012");
    private static final RString 段階区分_対象外 = new RString("000");
    private static final RString 段階区分_第1段階 = new RString("010");
    private static final RString 段階区分_第3段階1 = new RString("031");
    private static final RString 段階区分_第4段階2 = new RString("042");
    private static final RString 特例表記有り = new RString("(特例)");
    private static final RString 特例表記無し = RString.EMPTY;

    @BeforeClass
    public static void setUpClass() {
//TODO 主キー値を適切な値に置換してください
        賦課年度 = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_賦課年度;
        段階index = DbT2013HokenryoDankaiEntityGenerator.DEFAULT_段階インデックス;
    }

    public static class 主キーコンストラクタテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);
        }

//TODO 主キー名を置換してください
        @Test(expected = NullPointerException.class)
        public void 主キー名1がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoDankai(null, 段階index, ランク区分);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー名2がnullである場合に_NullPointerExceptionが発生する() {
            sut = new HokenryoDankai(賦課年度, null, ランク区分);
        }

        @Test
        public void 指定したキーが保持するDbT2013HokenryoDankaiEntityにセットされている() {
            sut = new HokenryoDankai(賦課年度, 段階index, ランク区分);
            assertThat(sut.get賦課年度(), is(賦課年度));
            assertThat(sut.get段階インデックス(), is(段階index));
        }

        @Test
        public void 指定したキーが保持するHokenryoDankaiIdentifierにセットされている() {
            sut = new HokenryoDankai(賦課年度, 段階index, ランク区分);
            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get段階インデックス(), is(段階index));
        }
    }

    public static class Entityコンストラクタテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);
        }

        @Test(expected = NullPointerException.class)
        public void 指定したEntityがnullである場合_NullPointerExceptionとなる() {
            sut = new HokenryoDankai(null);
        }

        @Test
        public void 指定したDbT2013HokenryoDankaiEntityのキー情報を識別子が持つ() {

            sut = new HokenryoDankai(HokenryoDankaiEntity);

            assertThat(sut.identifier().get賦課年度(), is(賦課年度));
            assertThat(sut.identifier().get段階インデックス(), is(段階index));
        }
    }

    public static class getterテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void get賦課年度は_entityが持つ賦課年度を返す() {
            assertThat(sut.get賦課年度(), is(HokenryoDankaiEntity.getFukaNendo()));
        }

        @Test
        public void get段階インデックスは_entityが持つ段階インデックスを返す() {
            assertThat(sut.get段階インデックス(), is(HokenryoDankaiEntity.getDankaiIndex()));
        }

        @Test
        public void getランク区分は_entityが持つランク区分を返す() {
            assertThat(sut.getランク区分(), is(HokenryoDankaiEntity.getRankuKubun()));
        }

        @Test
        public void get段階区分は_entityが持つ段階区分を返す() {
            assertThat(sut.get段階区分(), is(HokenryoDankaiEntity.getDankaiKubun()));
        }

        @Test
        public void get保険料率は_entityが持つ保険料率を返す() {
            assertThat(sut.get保険料率(), is(HokenryoDankaiEntity.getHokenryoRitsu()));
        }

        @Test
        public void get特例表記は_entityが持つ特例表記を返す() {
            assertThat(sut.get特例表記(), is(HokenryoDankaiEntity.getTokureiHyoki()));
        }
    }

    public static class toEntityテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void toEntityはコンストラクタで設定したentityと異なるインスタンスを返す() {
            assertThat(sut.toEntity(), not(HokenryoDankaiEntity));
        }
    }

    public static class SerializationProxyテスト extends DbbTestBase {

        private static HokenryoDankai sut;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);

            sut = new HokenryoDankai(HokenryoDankaiEntity);
        }

        @Test
        public void シリアライズできる() {
//            assertThat(sut, is(serializable()));
        }
    }

    public static class deletedテスト extends DbbTestBase {

        private static HokenryoDankai sut;
        private static HokenryoDankai result;

        @Before
        public void setUp() {
            HokenryoDankaiEntity = DbT2013HokenryoDankaiEntityGenerator.createDbT2013HokenryoDankaiEntity();
            HokenryoDankaiEntity.setFukaNendo(賦課年度);
            HokenryoDankaiEntity.setDankaiIndex(段階index);

        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがUnchangedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Unchanged);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがModifiedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Modified);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedである場合_deletedメソッド_によりHokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがDeletedに指定されたHokenryoDankaiが返る() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Deleted);
            result = sut.deleted();
            assertThat(result.toEntity().getState(), is(EntityDataState.Deleted));
        }

        @Test(expected = IllegalStateException.class)
        public void HokenryoDankaiが保持するDbT2013HokenryoDankaiEntityのEntityDataStateがAddedである場合_deletedメソッド_により_IllegalStateExceptionが発火する() {
            sut = TestSupport.setStateHokenryoDankai(EntityDataState.Added);
            result = sut.deleted();
        }
    }

    public static class コンストラクタ extends DbbTestBase {

        private static HokenryoDankai sut;

        @Test(expected = NullPointerException.class)
        public void 保険料段階がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new HokenryoDankai(null);
        }

//        @Test(expected = NullPointerException.class)
//        public void 保険料段階がnullの時_コンストラクタは_NullPointerExceptionを投げる2() {
//            sut = new HokenryoDankai(null, mock(FukaKeisanConfig.class));
//        }
//
//        @Test(expected = NullPointerException.class)
//        public void 賦課計算Configがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
//            FukaKeisanConfig config = null;
//            sut = new HokenryoDankai(mock(DbT2013HokenryoDankaiEntity.class), config);
//        }
    }

//    メソッドはHokenryoDankaiUtilに移管したので、そちらのクラスでテストを作ること。
//    public static class edit表示用保険料段階 extends DbbTestBase {
//
//        private static HokenryoDankai sut;
//
//        @Test
//        public void 基本表記の時_edit表示用保険料段階は_基本表記の保険料段階を返す() {
//            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第1期, 段階区分_第1段階, 特例表記無し), createFukaKeisanConfig());
//            assertThat(sut.edit表示用保険料段階(), is(new RString("第1段階")));
//        }
//
//        @Test
//        public void 対象外表記の時_edit表示用保険料段階は_対象外表記の保険料段階を返す() {
//            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第2期, 段階区分_対象外, 特例表記無し), createFukaKeisanConfig());
//            assertThat(sut.edit表示用保険料段階(), is(new RString("-")));
//        }
//
//        @Test
//        public void 改正前表記の時_edit表示用保険料段階は_改正前表記の保険料段階を返す() {
//            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第3期, 段階区分_第4段階2, 特例表記無し), createFukaKeisanConfig());
//            assertThat(sut.edit表示用保険料段階(), is(new RString("第4段階(改正前2)")));
//        }
//
//        @Test
//        public void 特例表記の時_edit表示用保険料段階は_特例表記の保険料段階を返す() {
//            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第5期, 段階区分_第3段階1, 特例表記有り), createFukaKeisanConfig());
//            assertThat(sut.edit表示用保険料段階(), is(new RString("第3段階(特例)")));
//        }
//    }
//
    private static DbT2013HokenryoDankaiEntity createHokenryoDankaiModel(FukaNendo 賦課年度, RString 段階区分, RString 特例表記) {
        DbT2013HokenryoDankaiEntity model = mock(DbT2013HokenryoDankaiEntity.class);
        when(model.getFukaNendo()).thenReturn(賦課年度.value());
        when(model.getDankaiKubun()).thenReturn(段階区分);
        when(model.getTokureiHyoki()).thenReturn(特例表記);
        return model;
    }

    private static FukaKeisanConfig createFukaKeisanConfig() {
        FukaKeisanConfig config = mock(FukaKeisanConfig.class);
        when(config.get激変緩和開始年度()).thenReturn(激変緩和開始年度);
        when(config.get激変緩和終了年度()).thenReturn(激変緩和終了年度);
        when(config.get激変緩和期間()).thenReturn(new Range(激変緩和開始年度, 激変緩和終了年度));
        return config;
    }

    private static class TestSupport {

        public static HokenryoDankai setStateHokenryoDankai(EntityDataState parentState) {
            HokenryoDankaiEntity.setState(parentState);
            return new HokenryoDankai(HokenryoDankaiEntity);
        }
    }
}
