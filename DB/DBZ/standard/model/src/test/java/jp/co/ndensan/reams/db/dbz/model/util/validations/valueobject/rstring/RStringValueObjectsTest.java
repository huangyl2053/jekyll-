/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.rstring;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.IValueObjectValidatable;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValidationMessages;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.ValueObjectValidations;
import jp.co.ndensan.reams.db.dbz.model.util.validations.valueobject.rstring.RStringValueObjects.ValidationSpec;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * RStringValueObjectsのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class RStringValueObjectsTest {

    public RStringValueObjectsTest() {
    }

    /**
     * Definitions.被保番号_半角数 への設定内容から動作を確認します。
     */
    @RunWith(Enclosed.class)
    public static class hihokenshaNo extends DbzTestBase {

        private static IValueObjectValidatable<HihokenshaNo> validation;

        @BeforeClass
        public static void setUp() {
            validation = ValueObjectValidations.createValidationFor(HihokenshaNo.class, ValidationSpec.被保番号_半角数);
        }

        public static class NullCheck extends DbzTestBase {

            @Test
            public void validateは_引数のHihokenshaNo$valueがnullを返す時_戻り値に_ValidationMessages$必須入力項目_を含む() {
                HihokenshaNo no = new HihokenshaNo((RString) null);
                assertThat(validation.validate(no).contains(ValidationMessages.必須入力項目), is(true));
            }

            @Test
            public void validateは_引数のHihokenshaNo$valueがnullを返す時_戻り値に_ValidationMessages$半角数のみ_を含まない() {
                HihokenshaNo no = new HihokenshaNo((RString) null);
                assertThat(validation.validate(no).contains(ValidationMessages.半角数のみ), is(false));
            }

            @Test
            public void validateは_引数のHihokenshaNo$valueがnullを返す時_戻り値に_ValidationMessages$指定文字数と一致_を含まない() {
                HihokenshaNo no = new HihokenshaNo((RString) null);
                assertThat(validation.validate(no).contains(ValidationMessages.指定文字数と一致), is(false));
            }
        }

        public static class HalfSizeNumberOnlyCheck extends DbzTestBase {

            @Test
            public void valiateは_引数のHihokenshaNo$valueに半角の数字以外を含む時_戻り値に_ValidationMessages$半角数のみ_を含む() {
                HihokenshaNo no = new HihokenshaNo("a");
                assertThat(validation.validate(no).contains(ValidationMessages.半角数のみ), is(true));
            }
        }

        public static class LengthCheck extends DbzTestBase {

            @Test
            public void validateは_引数のHihokenshaNo$valueの長さが定義した値と一致しない時_戻り値に_ValidationMessages$指定文字数と一致_を含む() {
                HihokenshaNo no = new HihokenshaNo("1");
                assertThat(validation.validate(no).contains(ValidationMessages.指定文字数と一致), is(true));
            }
        }

        public static class allGreenCase extends DbzTestBase {

            private final HihokenshaNo HIHOKENSHA_NO = new HihokenshaNo("1234567890");

            @Test
            public void validateは_引数のHihokenshaNo$valueがnullでないとき_戻り値に_ValidationMessages$必須入力項目_を含まない() {
                assertThat(validation.validate(HIHOKENSHA_NO).contains(ValidationMessages.必須入力項目), is(false));
            }

            @Test
            public void validateは_引数のHihokenshaNo$valueが半角数のみのとき_戻り値に_ValidationMessages$半角数のみ_を含まない() {
                assertThat(validation.validate(HIHOKENSHA_NO).contains(ValidationMessages.半角数のみ), is(false));
            }

            @Test
            public void validateは_引数のHihokenshaNo$valueの長さが定義した値と一致する時_戻り値に_ValidationMessages$指定文字数と一致_を含まない() {
                assertThat(validation.validate(HIHOKENSHA_NO).contains(ValidationMessages.指定文字数と一致), is(false));
            }
        }
    }
}
