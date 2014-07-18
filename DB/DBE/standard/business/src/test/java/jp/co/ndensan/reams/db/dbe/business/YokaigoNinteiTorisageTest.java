/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

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
 * YokaigoNinteiTorisageのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class YokaigoNinteiTorisageTest extends DbzTestBase {

    public static class getter extends DbzTestBase {

        private YokaigoNinteiTorisage sut;
        private final Code code = new Code("0001");
        private final TorisageRiyu torisageRiyu = new TorisageRiyu(new RString("torisage"));
        private final FlexibleDate torisageDate = new FlexibleDate("20140707");

        @Before
        public void setUp() {
            sut = new YokaigoNinteiTorisage(code, torisageRiyu, torisageDate);
        }

        @Test
        public void get取下げ区分コードは_コンストラクタ引数の取下げ区分コードと_同じ値を返す() {
            assertThat(sut.get取下げ区分コード(), is(code));
        }

        @Test
        public void get取下げ理由は_コンストラクタ引数の取下げ理由と_同じ値を返す() {
            assertThat(sut.get取下げ理由(), is(torisageRiyu));
        }

        @Test
        public void get取下げ年月日は_コンストラクタ引数の取下げ年月日と_同じ値を返す() {
            assertThat(sut.get取下げ年月日(), is(torisageDate));
        }
    }
}
