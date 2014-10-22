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
    public static class Builder extends DbzTestBase {

        public static class nullCheck extends DbzTestBase {

            private ValueObjectInfo.Builder sut;

            @Test(expected = NullPointerException.class)
            public void Builderは_コンストラクタ引数にnullのStringを受け取ったとき_NullPointerExceptionをスローする() {
                sut = new ValueObjectInfo.Builder((String) null);
            }

            @Test(expected = NullPointerException.class)
            public void Builderは_コンストラクタ引数にnullのRStringを受け取ったとき_NullPointerExceptionをスローする() {
                sut = new ValueObjectInfo.Builder((RString) null);
            }

            @Test(expected = NullPointerException.class)
            public void setUnitは_引数にnullを受け取ったとき_NullPointerExceptionをスローする() {
                sut = new ValueObjectInfo.Builder(RString.EMPTY).setUnit(null);
            }

            @Test
            public void testGetUnit() {
            }
        }

        public static class build_setUnitを呼ばない extends DbzTestBase {

            private IValueObjectInfo created;
            private RString name;

            @Before
            public void setUp() {
                name = new RString("被保番号");
                created = new ValueObjectInfo.Builder(name).build();
            }

            @Test
            public void setUnitを呼んでいないとき_buildは_getNameでコンストラクタ引数と同じ値を返す_IValueObjectInfoを生成する() {
                assertThat(created.getName(), is(name));
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
                created = new ValueObjectInfo.Builder(name).setUnit(unit).build();
            }

            @Test
            public void setUnitを呼んだとき_buildは_getNameでコンストラクタ引数と同じ値を返す_IValueObjectInfoを生成する() {
                assertThat(created.getName(), is(name));
            }

            @Test
            public void setUnitを呼んだとき_buildは_getUnitでsetUnitの引数を返す_IValueObjectInfoを生成する() {
                assertThat(created.getUnit(), is(unit));
            }
        }
    }
}
