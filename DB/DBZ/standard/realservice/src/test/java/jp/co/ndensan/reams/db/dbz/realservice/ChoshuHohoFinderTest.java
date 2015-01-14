/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import jp.co.ndensan.reams.db.dbz.definition.util.optional.DbOptional;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator;
import static jp.co.ndensan.reams.db.dbz.entity.basic.helper.DbT2001ChoshuHohoEntityGenerator.*;
import jp.co.ndensan.reams.db.dbz.model.fuka.ChoshuHohoModel;
import jp.co.ndensan.reams.db.dbz.persistence.relate.ChoshuHohoDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
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
        public void find徴収方法は_該当の情報がない時_IOptionalのemptyを返す() {
            IOptional<ChoshuHohoModel> empty = DbOptional.empty();

            when(dac.select徴収方法Recently(any(FukaNendo.class), any(HihokenshaNo.class))).thenReturn(empty);
            IOptional<ChoshuHohoModel> result = sut.find徴収方法(notFound賦課年度, DEFAULT_被保険者番号);

            assertThat(result, is(empty));
        }

        @Test
        public void find徴収方法は_該当の情報がある時_該当情報を返す() {
            IOptional<ChoshuHohoModel> model = DbOptional.of(
                    new ChoshuHohoModel(DbT2001ChoshuHohoEntityGenerator.createDbT2001ChoshuHohoEntity()));

            when(dac.select徴収方法Recently(賦課年度, DEFAULT_被保険者番号)).thenReturn(model);
            IOptional<ChoshuHohoModel> result = sut.find徴収方法(賦課年度, DEFAULT_被保険者番号);

            assertThat(result.get().get賦課年度(), is(賦課年度));
        }
    }
}
