/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.realservice;

import jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator.DEFAULT_被保険者番号;
import static jp.co.ndensan.reams.db.dbb.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator.DEFAULT_賦課年度;
import jp.co.ndensan.reams.db.dbb.persistence.relate.ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.ChoshuHoho;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * {link ChoshuHohoFinder}のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ChoshuHohoFinderTest {

    private static ChoshuHohoDac dac;
    private static ChoshuHohoFinder sut;

    private static final FukaNendo notFound賦課年度 = new FukaNendo("2111");
    private static final FukaNendo 賦課年度 = new FukaNendo(DEFAULT_賦課年度);

    @BeforeClass
    public static void test() {
        dac = mock(ChoshuHohoDac.class);
        sut = new ChoshuHohoFinder(dac);
    }

    public static class find徴収方法 extends DbzTestBase {

        @Test
        public void find徴収方法は_該当の情報がない時_Optionalのemptyを返す() {
            Optional<ChoshuHoho> empty = Optional.empty();

            when(dac.select徴収方法Recently(any(FukaNendo.class), any(HihokenshaNo.class))).thenReturn(empty);
            Optional<ChoshuHoho> result = sut.find徴収方法(notFound賦課年度, DEFAULT_被保険者番号);

            assertThat(result, is(empty));
        }

        @Test
        public void find徴収方法は_該当の情報がある時_該当情報を返す() {
            Optional<ChoshuHoho> model = Optional.of(
                    new ChoshuHoho(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity()));

            when(dac.select徴収方法Recently(賦課年度, DEFAULT_被保険者番号)).thenReturn(model);
            Optional<ChoshuHoho> result = sut.find徴収方法(賦課年度, DEFAULT_被保険者番号);

            assertThat(result.get().get賦課年度(), is(賦課年度));
        }
    }
}
