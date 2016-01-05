package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 保険料段階パターンのテストクラスです。
 *
 * @author LDNS
 */
public class HokenryoDankaiPatternTest extends DbbTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        HokenryoDankaiPattern.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        HokenryoDankaiPattern.toValue(new RString("99999"));
    }

    @Test
    public void 引数に1を指定した場合_toValueは_パターン無しを返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("1")), is(HokenryoDankaiPattern.パターン無し));
    }

    @Test
    public void 引数に2を指定した場合_toValueは_2009_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("2")), is(HokenryoDankaiPattern._2009_本人非課税の軽減措置なし));
    }

    @Test
    public void 引数に3を指定した場合_toValueは_2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("3")), is(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階));
    }

    @Test
    public void 引数に4を指定した場合_toValueは_2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("4")), is(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階));
    }

    @Test
    public void 引数に5を指定した場合_toValueは_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("5")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なし));
    }

    @Test
    public void 引数に6を指定した場合_toValueは_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("6")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階));
    }

    @Test
    public void 引数に7を指定した場合_toValueは_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("7")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階));
    }

    @Test
    public void 引数に8を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("8")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なし));
    }

    @Test
    public void 引数に9を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("9")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("10")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("11")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なし));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("12")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern.toValue(new RString("13")), is(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階));
    }

    @Test
    public void パターン無しを指定した場合_getコードは_1を返す() {
        assertThat(HokenryoDankaiPattern.パターン無し.getコード(), is(new RString("1")));
    }

    @Test
    public void _2009_本人非課税の軽減措置なしを指定した場合_getコードは_2を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置なし.getコード(), is(new RString("2")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_getコードは_3を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.getコード(), is(new RString("3")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_getコードは_4を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.getコード(), is(new RString("4")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なしを指定した場合_getコードは_5を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なし.getコード(), is(new RString("5")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_getコードは_6を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.getコード(), is(new RString("6")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_getコードは_7を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.getコード(), is(new RString("7")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なしを指定した場合_getコードは_8を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なし.getコード(), is(new RString("8")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_getコードは_9を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.getコード(), is(new RString("9")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_getコードは_10を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.getコード(), is(new RString("10")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なしを指定した場合_getコードは_11を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なし.getコード(), is(new RString("11")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_getコードは_12を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.getコード(), is(new RString("12")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_getコードは_13を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.getコード(), is(new RString("13")));
    }

    @Test
    public void パターン無しを指定した場合_get名称は_パターン無しを返す() {
        assertThat(HokenryoDankaiPattern.パターン無し.get名称(), is(new RString("パターン無し")));
    }

    @Test
    public void _2009_本人非課税の軽減措置なしを指定した場合_get名称は__2009_パターン1を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置なし.get名称(), is(new RString("_2009_パターン1")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get名称は__2009_パターン2を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get名称(), is(new RString("_2009_パターン2")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get名称は__2009_パターン3を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get名称(), is(new RString("_2009_パターン3")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なしを指定した場合_get名称は__2012_パターン1を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なし.get名称(), is(new RString("_2012_パターン1")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get名称は__2012_パターン2を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get名称(), is(new RString("_2012_パターン2")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get名称は__2012_パターン3を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get名称(), is(new RString("_2012_パターン3")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なしを指定した場合_get名称は__2012_パターン4を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なし.get名称(), is(new RString("_2012_パターン4")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get名称は__2012_パターン5を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get名称(), is(new RString("_2012_パターン5")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get名称は__2012_パターン6を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get名称(), is(new RString("_2012_パターン6")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なしを指定した場合_get名称は__2012_パターン7を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なし.get名称(), is(new RString("_2012_パターン7")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get名称は__2012_パターン8を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get名称(), is(new RString("_2012_パターン8")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get名称は__2012_パターン9を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get名称(), is(new RString("_2012_パターン9")));
    }

    @Test
    public void パターン無しを指定した場合_get略称は_パターン無しを返す() {
        assertThat(HokenryoDankaiPattern.パターン無し.get略称(), is(new RString("パターン無し")));
    }

    @Test
    public void _2009_本人非課税の軽減措置なしを指定した場合_get略称は_2009_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置なし.get略称(), is(new RString("2009_本人非課税の軽減措置なし")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get略称は_2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get略称(), is(new RString("2009_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階")));
    }

    @Test
    public void _2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get略称は_2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern._2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get略称(), is(new RString("2009_本人非課税の軽減措置あり_本人非課税の段階表記が別段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なしを指定した場合_get略称は_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なし.get略称(), is(new RString("2012_世帯非課税の軽減措置なし_本人非課税の軽減措置なし")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get略称は_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get略称(), is(new RString("2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get略称は_2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get略称(), is(new RString("2012_世帯非課税の軽減措置なし_本人非課税の軽減措置あり_本人非課税の段階表記が別段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なしを指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なし.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置なし")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が同一段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なしを指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なしを返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なし.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置なし")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が同一段階")));
    }

    @Test
    public void _2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を指定した場合_get略称は_2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階を返す() {
        assertThat(HokenryoDankaiPattern._2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階.get略称(), is(new RString("2012_世帯非課税の軽減措置あり_世帯非課税の段階表記が別段階_本人非課税の軽減措置あり_本人非課税の段階表記が別段階")));
    }

}
