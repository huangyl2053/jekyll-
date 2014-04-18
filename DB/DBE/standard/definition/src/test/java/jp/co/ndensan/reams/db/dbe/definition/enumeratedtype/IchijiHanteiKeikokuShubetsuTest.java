/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 一次判定警告種別のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IchijiHanteiKeikokuShubetsuTest {

    public static class toValueのテスト extends DbeTestBase {

        @Test
        public void 一次判定年月日に20101102を指定すると_介護保険制度2009年度版が返る() {
            assertThat(IchijiHanteiKeikokuShubetsu.toValue(new FlexibleDate("20101102")),
                    is(IchijiHanteiKeikokuShubetsu.介護保険制度2009年度版));
        }

        @Test
        public void 一次判定年月日に20090401を指定すると_介護保険制度2009年度版が返る() {
            assertThat(IchijiHanteiKeikokuShubetsu.toValue(new FlexibleDate("20090401")),
                    is(IchijiHanteiKeikokuShubetsu.介護保険制度2009年度版));
        }

        @Test
        public void 一次判定年月日に20090331を指定すると_介護保険制度2006年度版が返る() {
            assertThat(IchijiHanteiKeikokuShubetsu.toValue(new FlexibleDate("20090331")),
                    is(IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版));
        }

        @Test
        public void 一次判定年月日に20060401を指定すると_介護保険制度2006年度版が返る() {
            assertThat(IchijiHanteiKeikokuShubetsu.toValue(new FlexibleDate("20060401")),
                    is(IchijiHanteiKeikokuShubetsu.介護保険制度2006年度版));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 一次判定年月日に項目に該当しない年月日を指定すると_IllegalArgumentExceptionが発生する() {
            IchijiHanteiKeikokuShubetsu.toValue(new FlexibleDate("20060331"));
        }
    }
}
