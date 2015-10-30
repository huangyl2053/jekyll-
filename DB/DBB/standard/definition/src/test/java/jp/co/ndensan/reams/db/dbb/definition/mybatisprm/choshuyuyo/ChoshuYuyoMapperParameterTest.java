/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.mybatisprm.choshuyuyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ChoshuYuyoMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ChoshuYuyoMapperParameterTest extends DbbTestBase {

    private static final FlexibleYear choteiNendo = new FlexibleYear("2015");
    private static final FlexibleYear fukaNendo = new FlexibleYear("2015");
    private static final TsuchishoNo tsuchishoNo = new TsuchishoNo("1");
    private static final Decimal rirekiNo = Decimal.TEN;

    /**
     * createParamテストメソッドです。
     */
    public static class createParamテスト extends DbbTestBase {

        @Test(expected = NullPointerException.class)
        public void 調定年度にNullを指定すると_NullPointerExceptionが発生する() {
            ChoshuYuyoMapperParameter sut = ChoshuYuyoMapperParameter.createParam(null, fukaNendo, tsuchishoNo, rirekiNo);
        }

        @Test(expected = NullPointerException.class)
        public void 賦課年度にNullを指定すると_NullPointerExceptionが発生する() {
            ChoshuYuyoMapperParameter sut = ChoshuYuyoMapperParameter.createParam(choteiNendo, null, tsuchishoNo, rirekiNo);
        }

        @Test(expected = NullPointerException.class)
        public void 通知書番号にNullを指定すると_NullPointerExceptionが発生する() {
            ChoshuYuyoMapperParameter sut = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, null, rirekiNo);
        }

        @Test(expected = NullPointerException.class)
        public void 履歴番号にNullを指定すると_NullPointerExceptionが発生する() {
            ChoshuYuyoMapperParameter sut = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            ChoshuYuyoMapperParameter sut = ChoshuYuyoMapperParameter.createParam(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo);

            assertThat(sut.getChoteiNendo(), is(choteiNendo));
            assertThat(sut.getFukaNendo(), is(fukaNendo));
            assertThat(sut.getTsuchishoNo(), is(tsuchishoNo));
            assertThat(sut.getRirekiNo(), is(rirekiNo));
        }
    }

}
