/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import jp.co.ndensan.reams.db.dbb.business.core.HokenryoDankai;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.hokenryorank.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Range;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 保険料段階を扱うクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
@Ignore
public class HokenryoDankaiTest {

    private static HokenryoDankai sut;

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

    public static class コンストラクタ extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 保険料段階がnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new HokenryoDankai(null);
        }

        @Test(expected = NullPointerException.class)
        public void 保険料段階がnullの時_コンストラクタは_NullPointerExceptionを投げる2() {
            sut = new HokenryoDankai(null, mock(FukaKeisanConfig.class));
        }

        @Test(expected = NullPointerException.class)
        public void 賦課計算Configがnullの時_コンストラクタは_NullPointerExceptionを投げる() {
            sut = new HokenryoDankai(mock(DbT2013HokenryoDankaiEntity.class), null);
        }
    }

    public static class edit表示用保険料段階 extends DbzTestBase {

        @Test
        public void 基本表記の時_edit表示用保険料段階は_基本表記の保険料段階を返す() {
            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第1期, 段階区分_第1段階, 特例表記無し), createFukaKeisanConfig());
            assertThat(sut.edit表示用保険料段階(), is(new RString("第1段階")));
        }

        @Test
        public void 対象外表記の時_edit表示用保険料段階は_対象外表記の保険料段階を返す() {
            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第2期, 段階区分_対象外, 特例表記無し), createFukaKeisanConfig());
            assertThat(sut.edit表示用保険料段階(), is(new RString("-")));
        }

        @Test
        public void 改正前表記の時_edit表示用保険料段階は_改正前表記の保険料段階を返す() {
            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第3期, 段階区分_第4段階2, 特例表記無し), createFukaKeisanConfig());
            assertThat(sut.edit表示用保険料段階(), is(new RString("第4段階(改正前2)")));
        }

        @Test
        public void 特例表記の時_edit表示用保険料段階は_特例表記の保険料段階を返す() {
            sut = new HokenryoDankai(createHokenryoDankaiModel(賦課年度_第5期, 段階区分_第3段階1, 特例表記有り), createFukaKeisanConfig());
            assertThat(sut.edit表示用保険料段階(), is(new RString("第3段階(特例)")));
        }
    }

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
}
