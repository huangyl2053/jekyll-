/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteiYukoKikanTsukisu;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
//import static org.mockito.Mockito.*;

/**
 * NinteiResultSimpleのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class NinteiResultSimpleTest extends DbzTestBase {

    public static class getter extends DbzTestBase {

        private NinteiResultSimple sut;
        private YokaigoJotaiKubun yokaigoJotaiKubun;
        private NinteiYukoKikan ninteiYukoKikan;

        @Before
        public void setUp() {
            yokaigoJotaiKubun = new YokaigoJotaiKubun(new Code("a"), RString.EMPTY, RString.EMPTY);
            ninteiYukoKikan = new NinteiYukoKikan(
                    new FlexibleDate("20140401"),
                    new NinteiYukoKikanTsukisu(6),
                    new FlexibleDate("20140931"));
            sut = new NinteiResultSimple(yokaigoJotaiKubun, ninteiYukoKikan);
        }

        @Test
        public void get要介護度は_コンストラクタ引数の要介護度と_同じものを返す() {
            assertThat(sut.get要介護度(), is(yokaigoJotaiKubun));
        }

        @Test
        public void get認定有効期間は_コンストラクタ引数の認定有効期間と_同じものを返す() {
            assertThat(sut.get認定有効期間(), is(ninteiYukoKikan));
        }
    }
}
