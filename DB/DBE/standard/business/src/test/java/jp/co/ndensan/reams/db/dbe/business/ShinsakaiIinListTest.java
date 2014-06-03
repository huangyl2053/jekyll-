/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.ShinsakaiTestBusinessCreator;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinsakaiIinCode;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 審査会委員リストのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinListTest {

    private static ShinsakaiIinList sut;

    public static class get審査会委員のテスト extends DbeTestBase {

        @Test
        public void 指定した審査会委員コードに対応した委員が取得できる() {
            ShinsakaiIinCode code = new ShinsakaiIinCode(new RString("test01"));
            sut = ShinsakaiTestBusinessCreator.create審査会委員List(code.value().toString(), "iin02", "iin03");
            ShinsakaiIin result = sut.get審査会委員(code);
            assertThat(result.get審査会委員コード(), is(code));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応した委員が存在しない場合_IllegalArgumentExceptionが発生する() {
            ShinsakaiIinCode code = new ShinsakaiIinCode(new RString("test01"));
            sut = ShinsakaiTestBusinessCreator.create審査会委員List("iin01", "iin02", "iin03");
            sut.get審査会委員(code);
        }
    }

    public static class isEmptyのテスト extends DbeTestBase {

        @Test
        public void 空のリストのとき_trueが返る() {
            sut = ShinsakaiTestBusinessCreator.create審査会委員List();
            assertThat(sut.isEmpty(), is(true));
        }

        @Test
        public void 空でないリストのとき_falseが返る() {
            sut = ShinsakaiTestBusinessCreator.create審査会委員List("iin01", "iin02", "iin03");
            assertThat(sut.isEmpty(), is(false));
        }
    }

    public static class sizeのテスト extends DbeTestBase {

        @Test
        public void リストが3件の要素を持つ場合_3が返る() {
            sut = ShinsakaiTestBusinessCreator.create審査会委員List("iin01", "iin02", "iin03");
            assertThat(sut.size(), is(3));
        }
    }
}
