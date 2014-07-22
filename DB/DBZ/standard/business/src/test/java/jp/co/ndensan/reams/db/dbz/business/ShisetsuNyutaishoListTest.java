/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.helper.ShisetsuNyutaishoMock;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 複数の施設入退所情報を表すクラスのテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class ShisetsuNyutaishoListTest extends DbzTestBase {

    private static ShisetsuNyutaishoList sut;

    public static class constructor {

        @Test(expected = NullPointerException.class)
        public void 施設入退所Listにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new ShisetsuNyutaishoList(null);
        }
    }

    public static class get施設入退所 {

        @Test(expected = IllegalArgumentException.class)
        public void 該当の施設入退所情報がない時_get施設入退所は_IllegalArgumentExceptionを投げる() {
            sut = new ShisetsuNyutaishoList(createMockList(1));
            FlexibleDate notFound入所年月日 = new FlexibleDate("20110701");
            sut.get施設入退所(notFound入所年月日);
        }

        @Test
        public void 該当の施設入退所情報がある時_get施設入退所は_該当する情報を返す() {
            sut = new ShisetsuNyutaishoList(createMockList(1));
            FlexibleDate found入所年月日 = new FlexibleDate("20110703");
            ShisetsuNyutaisho result = sut.get施設入退所(found入所年月日);
            assertThat(result, instanceOf(ShisetsuNyutaisho.class));
        }
    }

    public static class isEmpty {

        @Test
        public void 施設入退所ListがEmptyの時_trueが返る() {
            sut = new ShisetsuNyutaishoList(Collections.EMPTY_LIST);
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 施設入退所ListがEmptyでない時_falseが返る() {
            sut = new ShisetsuNyutaishoList(createMockList(3));
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class size extends DbeTestBase {

        @Test
        public void 施設入退所Listが3件の情報を持っている時_3が返る() {
            sut = new ShisetsuNyutaishoList(createMockList(3));
            assertThat(sut.size(), is(3));
        }
    }

    private static List<ShisetsuNyutaisho> createMockList(int 件数) {
        List<ShisetsuNyutaisho> list = new ArrayList<>();
        for (int i = 0; i < 件数; i++) {
            list.add(ShisetsuNyutaishoMock.create施設入退所());
        }
        return list;
    }
}
