/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validation.valueobject;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * ValueObjectInfoのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ValueObjectInfoTest extends DbzTestBase {

    public ValueObjectInfoTest() {
    }

    @RunWith(Enclosed.class)
    public static class staticMethods extends DbzTestBase {

        public static class nullCheck extends DbzTestBase {

            private ValueObjectInfo sut;

            @Test(expected = NullPointerException.class)
            public void nameは_コンストラクタ引数にnullのStringを受け取ったとき_NullPointerExceptionをスローする() {
                sut.displayName((String) null);
            }
        }
    }

    @RunWith(Enclosed.class)
    public static class Builder extends DbzTestBase {

        private static ValueObjectInfo sut;

        public static class build_setUnitを呼ばない extends DbzTestBase {

            private IValueObjectInfo created;
            private RString name;

            @Before
            public void setUp() {
                name = new RString("被保番号");
                created = sut.displayName(name).build();
            }

            @Test
            public void setUnitを呼んでいないとき_buildは_getNameでコンストラクタ引数と同じ値を返す_IValueObjectInfoを生成する() {
                assertThat(created.getDisplayName(), is(name));
            }

            @Test
            public void setUnitを呼んでいないとき_buildは_getUnitでUnit$桁を返す_IValueObjectInfoを生成する() {
                assertThat(created.getUnit(), is(Unit.桁));
            }
        }

        public static class build_setUnitを呼ぶ extends DbzTestBase {

            private IValueObjectInfo created;
            private RString name;
            private Unit unit;

            @Before
            public void setUp() {
                name = new RString("被保番号");
                unit = Unit.文字;
                created = sut.displayName(name).unit(unit).build();
            }

            @Test
            public void setUnitを呼んだとき_buildは_getNameでコンストラクタ引数と同じ値を返す_IValueObjectInfoを生成する() {
                assertThat(created.getDisplayName(), is(name));
            }

            @Test
            public void setUnitを呼んだとき_buildは_getUnitでsetUnitの引数を返す_IValueObjectInfoを生成する() {
                assertThat(created.getUnit(), is(unit));
            }
        }
    }
}
