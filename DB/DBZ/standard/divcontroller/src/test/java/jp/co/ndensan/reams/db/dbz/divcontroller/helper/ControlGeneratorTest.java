/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.helper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
//import static org.mockito.Mockito.*;

/**
 * ControlGeneratorのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class ControlGeneratorTest extends DbzTestBase {

    public static class getAsRString extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsRStringは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成した_RStringを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "testtest");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsRString(key), is(new RString(map.get(key).toString())));
        }

        @Test
        public void getAsRStringは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_RString_EMPTYを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsRString(""), is(RString.EMPTY));
        }
    }

    public static class getAsBooleanValue extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsBooleanValueは_コンストラクタ引数のMapから引数のkeyにより取得できる値が_Boolean_valueOf_によりtrueを返すとき_tureを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "true");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsBooleanValue(key), is(true));
        }

        @Test
        public void getAsBooleanValueは_コンストラクタ引数のMapから引数のkeyにより取得できる値が_Boolean_valueOf_によりfalseを返すとき_falseを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "False");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsBooleanValue(key), is(false));
        }

        @Test
        public void getAsBooleanValueは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_falseを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsBooleanValue(""), is(false));
        }
    }

    public static class getAsRDate extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsRDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成される_RDateを返す() {
            Map map = new HashMap();
            String key = "test";
            String date = "20140606";
            map.put(key, date);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsRDate(key), is(new RDate(date)));
        }

        @Test
        public void getAsRDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値からRDateが生成できないとき_nullを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "日付じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsRDate(key), is(nullValue()));
        }

        @Test
        public void getAsRDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_nullを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsRDate(""), is(nullValue()));
        }
    }

    public static class getAsFlexibleDate extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成される_FlexibleDateを返す() {
            Map map = new HashMap();
            String key = "test";
            String date = "20140606";
            map.put(key, date);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsFlexibleDate(key), is(new FlexibleDate(date)));
        }

        @Test
        public void getAsFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値からRDateが生成できないとき_FlexibleDate_EMPTYを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "日付じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsFlexibleDate(key), is(FlexibleDate.EMPTY));
        }

        @Test
        public void getAsFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_FlexibleDate_EMPTYを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsFlexibleDate(""), is(FlexibleDate.EMPTY));
        }
    }

    public static class getAsDecimal extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsDecimalは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成される_Decimalを返す() {
            Map map = new HashMap();
            String key = "test";
            String num = "3333";
            map.put(key, num);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsDecimal(key), is(new Decimal(num)));
        }

        @Test
        public void getAsDecimalは_コンストラクタ引数のMapから引数のkeyにより取得できる値からDecimalが生成できないとき_nullを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "数じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsDecimal(key), is(nullValue()));
        }

        @Test
        public void getAsDecimalは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueをもった_nullを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsDecimal(""), is(nullValue()));
        }
    }

    public static class getAsYubinNo extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成される_YubinNoを返す() {
            Map map = new HashMap();
            String key = "test";
            String value = "333-3333";
            map.put(key, value);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsYubinNo(key), is(new YubinNo(value)));
        }

        @Test
        public void getAsYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値からYubinNoが生成できないとき_nullを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "お手紙届かない…");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsYubinNo(key), is(nullValue()));
        }

        @Test
        public void getAsYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_nullを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsYubinNo(""), is(nullValue()));
        }
    }

    public static class getAsTextBoxFlexibleDate extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるFlexibleDateを持った_TextBoxFlexibleDateを返す() {
            Map map = new HashMap();
            String key = "test";
            String date = "20140606";
            map.put(key, date);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxFlexibleDate(key).getValue(), is(new FlexibleDate(date)));
        }

        @Test
        public void getAsTextBoxFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値が_FlexibleDateへ変換できないとき_clearValueをもった_TextBoxFlexibleDateを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "日付じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxFlexibleDate(key).getValue(), is(clearedTextBoxFlexibleDate().getValue()));
        }

        @Test
        public void getAsTextBoxFlexibleDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueをもった_TextBoxFlexibleDateを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxFlexibleDate("").getValue(), is(clearedTextBoxFlexibleDate().getValue()));
        }

        private TextBoxFlexibleDate clearedTextBoxFlexibleDate() {
            TextBoxFlexibleDate txtBox = new TextBoxFlexibleDate();
            txtBox.clearValue();
            return txtBox;
        }
    }

    public static class getAsTextBoxDate extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるRDateを持った_TextBoxDateを返す() {
            Map map = new HashMap();
            String key = "test";
            String date = "20140606";
            map.put(key, date);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxDate(key).getValue(), is(new RDate(date)));
        }

        @Test
        public void getAsTextBoxDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値からRDateが生成できないとき_clearValueを持った_TextBoxDateを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "日付じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxDate(key).getValue(), is(clearedTextBoxDate().getValue()));
        }

        @Test
        public void getAsTextBoxDateは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueをもった_TextBoxDateを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxDate("").getValue(), is(clearedTextBoxDate().getValue()));
        }

        private TextBoxDate clearedTextBoxDate() {
            TextBoxDate txtBox = new TextBoxDate();
            txtBox.clearValue();
            return txtBox;
        }
    }

    public static class getAsTextBoxNum extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxNumは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるDecimalを持った_TextBoxNumを返す() {
            Map map = new HashMap();
            String key = "test";
            String num = "3333";
            map.put(key, num);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxNum(key).getValue(), is(new Decimal(num)));
        }

        @Test
        public void getAsTextBoxNumは_コンストラクタ引数のMapから引数のkeyにより取得できる値からDecimalが生成できないとき_clearValueを持った_TextBoxNumを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "数じゃない");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxNum(key).getValue(), is(clearedTextBoxNum().getValue()));
        }

        @Test
        public void getAsTextBoxNumは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueをもった_TextBoxNumを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxNum("").getValue(), is(clearedTextBoxNum().getValue()));
        }

        private TextBoxNum clearedTextBoxNum() {
            TextBoxNum txtBox = new TextBoxNum();
            txtBox.clearValue();
            return txtBox;
        }
    }

    public static class getAsTextBoxYubinNo extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるYubinNoを持った_TextBoxYubinNoを返す() {
            Map map = new HashMap();
            String key = "test";
            String value = "333-3333";
            map.put(key, value);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxYubinNo(key).getValue(), is(new YubinNo(value)));
        }

        @Test
        public void getAsTextBoxYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値からYubinNoが生成できないとき_clearValueを持った_TextBoxYubinNoを返す() {
            Map map = new HashMap();
            String key = "test";
            map.put(key, "お手紙届かない…");
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxYubinNo(key).getValue(), is(clearedTextBoxYubinNo().getValue()));
        }

        @Test
        public void getAsTextBoxYubinNoは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueを持った_TextBoxYubinNoを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxYubinNo("").getValue(), is(clearedTextBoxYubinNo().getValue()));
        }

        private TextBoxYubinNo clearedTextBoxYubinNo() {
            TextBoxYubinNo txtBox = new TextBoxYubinNo();
            txtBox.clearValue();
            return txtBox;
        }
    }

    public static class getAsTextBox extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるRStringを持った_TextBoxを返す() {
            Map map = new HashMap();
            String key = "test";
            String value = "テキストボックス";
            map.put(key, value);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBox(key).getValue(), is(new RString(value)));
        }

        @Test
        public void getAsTextBoxは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_RString_EMPTYをもった_TextBoxを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBox("").getValue(), is(RString.EMPTY));
        }
    }

    public static class getAsTextBoxCode extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getAsTextBoxCodeは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるRStringを持った_TextBoxCodeを返す() {
            Map map = new HashMap();
            String key = "test";
            String code = "0000000001";
            map.put(key, code);
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxCode(key).getValue(), is(new RString(code)));
        }

        @Test
        public void getAsTextBoxCodeは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_clearValueをもった_TextBoxCodeを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getAsTextBoxCode("").getValue(), is(clearedTextBoxCode().getValue()));
        }

        private TextBoxCode clearedTextBoxCode() {
            TextBoxCode txtBox = new TextBoxCode();
            txtBox.clearValue();
            return txtBox;
        }
    }

    public static class getTextBoxMultiLine extends DbzTestBase {

        private ControlGenerator sut;

        @Test
        public void getTextBoxMultiLineは_コンストラクタ引数のMapから引数のkeyにより取得できる値から生成されるRStringを持った_TextBoxMultiLineを返す() {
            Map map = new HashMap();
            String key = "test";
            String value = "マルチラインテキスト";
            map.put(key, value);
            sut = new ControlGenerator(map);
            assertThat(sut.getTextBoxMultiLine(key).getValue(), is(new RString(value)));
        }

        @Test
        public void getTextBoxMultiLineは_コンストラクタ引数のMapから引数のkeyにより取得できる値がないとき_RString_EMPTYをもった_TextBoxMultiLineを返す() {
            Map map = new HashMap();
            sut = new ControlGenerator(map);
            assertThat(sut.getTextBoxMultiLine("").getValue(), is(RString.EMPTY));
        }
    }
}
