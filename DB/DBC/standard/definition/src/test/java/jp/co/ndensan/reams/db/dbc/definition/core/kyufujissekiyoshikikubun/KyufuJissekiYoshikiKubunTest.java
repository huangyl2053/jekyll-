package jp.co.ndensan.reams.db.dbc.definition.core.kyufujissekiyoshikikubun;

import jp.co.ndensan.reams.db.dbz.testhelper.DbcTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 給付実績の様式区分のテストクラスです。
 *
 * @author LDNS
 */
public class KyufuJissekiYoshikiKubunTest extends DbcTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        KyufuJissekiYoshikiKubun.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        KyufuJissekiYoshikiKubun.toValue(new RString("99999"));
    }

    @Test
    public void 引数に無しを指定した場合_toValueは_現物_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("無し")), is(KyufuJissekiYoshikiKubun.現物_高額介護給付費));
    }

    @Test
    public void 引数に2131を指定した場合_toValueは_償還_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2131")), is(KyufuJissekiYoshikiKubun.償還_様式第二));
    }

    @Test
    public void 引数に2132を指定した場合_toValueは_償還_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2132")), is(KyufuJissekiYoshikiKubun.償還_様式第二の二));
    }

    @Test
    public void 引数に2141を指定した場合_toValueは_21償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2141")), is(KyufuJissekiYoshikiKubun._21償還_様式第三));
    }

    @Test
    public void 引数に2142を指定した場合_toValueは_21償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2142")), is(KyufuJissekiYoshikiKubun._21償還_様式第三));
    }

    @Test
    public void 引数に2143を指定した場合_toValueは_21償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2143")), is(KyufuJissekiYoshikiKubun._21償還_様式第三));
    }

    @Test
    public void 引数に2144を指定した場合_toValueは_償還_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2144")), is(KyufuJissekiYoshikiKubun.償還_様式第三の二));
    }

    @Test
    public void 引数に2151を指定した場合_toValueは_21償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2151")), is(KyufuJissekiYoshikiKubun._21償還_様式第四));
    }

    @Test
    public void 引数に2152を指定した場合_toValueは_21償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2152")), is(KyufuJissekiYoshikiKubun._21償還_様式第四));
    }

    @Test
    public void 引数に2153を指定した場合_toValueは_21償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2153")), is(KyufuJissekiYoshikiKubun._21償還_様式第四));
    }

    @Test
    public void 引数に2154を指定した場合_toValueは_21償還_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2154")), is(KyufuJissekiYoshikiKubun._21償還_様式第四の二));
    }

    @Test
    public void 引数に2155を指定した場合_toValueは_21償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2155")), is(KyufuJissekiYoshikiKubun._21償還_様式第四));
    }

    @Test
    public void 引数に2156を指定した場合_toValueは_21償還_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2156")), is(KyufuJissekiYoshikiKubun._21償還_様式第四の二));
    }

    @Test
    public void 引数に2161を指定した場合_toValueは_21償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2161")), is(KyufuJissekiYoshikiKubun._21償還_様式第五));
    }

    @Test
    public void 引数に2162を指定した場合_toValueは_21償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2162")), is(KyufuJissekiYoshikiKubun._21償還_様式第五));
    }

    @Test
    public void 引数に2163を指定した場合_toValueは_21償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2163")), is(KyufuJissekiYoshikiKubun._21償還_様式第五));
    }

    @Test
    public void 引数に2164を指定した場合_toValueは_21償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2164")), is(KyufuJissekiYoshikiKubun._21償還_様式第五));
    }

    @Test
    public void 引数に2165を指定した場合_toValueは_償還_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2165")), is(KyufuJissekiYoshikiKubun.償還_様式第五の二));
    }

    @Test
    public void 引数に2171を指定した場合_toValueは_償還_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2171")), is(KyufuJissekiYoshikiKubun.償還_様式第六));
    }

    @Test
    public void 引数に2172を指定した場合_toValueは_償還_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2172")), is(KyufuJissekiYoshikiKubun.償還_様式第六の二));
    }

    @Test
    public void 引数に2173を指定した場合_toValueは_償還_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2173")), is(KyufuJissekiYoshikiKubun.償還_様式第六の三));
    }

    @Test
    public void 引数に2174を指定した場合_toValueは_償還_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2174")), is(KyufuJissekiYoshikiKubun.償還_様式第六の四));
    }

    @Test
    public void 引数に2175を指定した場合_toValueは_償還_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2175")), is(KyufuJissekiYoshikiKubun.償還_様式第六の五));
    }

    @Test
    public void 引数に2176を指定した場合_toValueは_償還_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2176")), is(KyufuJissekiYoshikiKubun.償還_様式第六の六));
    }

    @Test
    public void 引数に2177を指定した場合_toValueは_償還_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2177")), is(KyufuJissekiYoshikiKubun.償還_様式第六の七));
    }

    @Test
    public void 引数に2181を指定した場合_toValueは_21償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2181")), is(KyufuJissekiYoshikiKubun._21償還_様式第八));
    }

    @Test
    public void 引数に2182を指定した場合_toValueは_21償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2182")), is(KyufuJissekiYoshikiKubun._21償還_様式第八));
    }

    @Test
    public void 引数に2183を指定した場合_toValueは_21償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2183")), is(KyufuJissekiYoshikiKubun._21償還_様式第八));
    }

    @Test
    public void 引数に2191を指定した場合_toValueは_21償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2191")), is(KyufuJissekiYoshikiKubun._21償還_様式第九));
    }

    @Test
    public void 引数に2192を指定した場合_toValueは_21償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2192")), is(KyufuJissekiYoshikiKubun._21償還_様式第九));
    }

    @Test
    public void 引数に2193を指定した場合_toValueは_21償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2193")), is(KyufuJissekiYoshikiKubun._21償還_様式第九));
    }

    @Test
    public void 引数に2194を指定した場合_toValueは_21償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2194")), is(KyufuJissekiYoshikiKubun._21償還_様式第九));
    }

    @Test
    public void 引数に2195を指定した場合_toValueは_21償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2195")), is(KyufuJissekiYoshikiKubun._21償還_様式第九));
    }

    @Test
    public void 引数に21A1を指定した場合_toValueは_21償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A1")), is(KyufuJissekiYoshikiKubun._21償還_様式第十));
    }

    @Test
    public void 引数に21A2を指定した場合_toValueは_21償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A2")), is(KyufuJissekiYoshikiKubun._21償還_様式第十));
    }

    @Test
    public void 引数に21A3を指定した場合_toValueは_21償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A3")), is(KyufuJissekiYoshikiKubun._21償還_様式第十));
    }

    @Test
    public void 引数に21B1を指定した場合_toValueは_21償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B1")), is(KyufuJissekiYoshikiKubun._21償還_様式第七));
    }

    @Test
    public void 引数に21B2を指定した場合_toValueは_21償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B2")), is(KyufuJissekiYoshikiKubun._21償還_様式第七));
    }

    @Test
    public void 引数に21B3を指定した場合_toValueは_21償還_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B3")), is(KyufuJissekiYoshikiKubun._21償還_様式第七の二));
    }

    @Test
    public void 引数に21B4を指定した場合_toValueは_21償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B4")), is(KyufuJissekiYoshikiKubun._21償還_様式第七));
    }

    @Test
    public void 引数に21B5を指定した場合_toValueは_21償還_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B5")), is(KyufuJissekiYoshikiKubun._21償還_様式第七の二));
    }

    @Test
    public void 引数に21C1を指定した場合_toValueは_償還_福祉用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21C1")), is(KyufuJissekiYoshikiKubun.償還_福祉用具販売費));
    }

    @Test
    public void 引数に21C2を指定した場合_toValueは_償還_予防用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21C2")), is(KyufuJissekiYoshikiKubun.償還_予防用具販売費));
    }

    @Test
    public void 引数に21D1を指定した場合_toValueは_償還_住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21D1")), is(KyufuJissekiYoshikiKubun.償還_住宅改修費));
    }

    @Test
    public void 引数に21D2を指定した場合_toValueは_償還_予防住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21D2")), is(KyufuJissekiYoshikiKubun.償還_予防住宅改修費));
    }

    @Test
    public void 引数に7131を指定した場合_toValueは_現物_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7131")), is(KyufuJissekiYoshikiKubun.現物_様式第二));
    }

    @Test
    public void 引数に7132を指定した場合_toValueは_現物_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7132")), is(KyufuJissekiYoshikiKubun.現物_様式第二の二));
    }

    @Test
    public void 引数に7141を指定した場合_toValueは_71現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7141")), is(KyufuJissekiYoshikiKubun._71現物_様式第三));
    }

    @Test
    public void 引数に7142を指定した場合_toValueは_71現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7142")), is(KyufuJissekiYoshikiKubun._71現物_様式第三));
    }

    @Test
    public void 引数に7143を指定した場合_toValueは_71現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7143")), is(KyufuJissekiYoshikiKubun._71現物_様式第三));
    }

    @Test
    public void 引数に7144を指定した場合_toValueは_現物_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7144")), is(KyufuJissekiYoshikiKubun.現物_様式第三の二));
    }

    @Test
    public void 引数に7151を指定した場合_toValueは_71現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7151")), is(KyufuJissekiYoshikiKubun._71現物_様式第四));
    }

    @Test
    public void 引数に7152を指定した場合_toValueは_71現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7152")), is(KyufuJissekiYoshikiKubun._71現物_様式第四));
    }

    @Test
    public void 引数に7153を指定した場合_toValueは_71現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7153")), is(KyufuJissekiYoshikiKubun._71現物_様式第四));
    }

    @Test
    public void 引数に7154を指定した場合_toValueは_71現物_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7154")), is(KyufuJissekiYoshikiKubun._71現物_様式第四の二));
    }

    @Test
    public void 引数に7155を指定した場合_toValueは_71現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7155")), is(KyufuJissekiYoshikiKubun._71現物_様式第四));
    }

    @Test
    public void 引数に7156を指定した場合_toValueは_71現物_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7156")), is(KyufuJissekiYoshikiKubun._71現物_様式第四の二));
    }

    @Test
    public void 引数に7161を指定した場合_toValueは_71現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7161")), is(KyufuJissekiYoshikiKubun._71現物_様式第五));
    }

    @Test
    public void 引数に7162を指定した場合_toValueは_71現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7162")), is(KyufuJissekiYoshikiKubun._71現物_様式第五));
    }

    @Test
    public void 引数に7163を指定した場合_toValueは_71現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7163")), is(KyufuJissekiYoshikiKubun._71現物_様式第五));
    }

    @Test
    public void 引数に7164を指定した場合_toValueは_71現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7164")), is(KyufuJissekiYoshikiKubun._71現物_様式第五));
    }

    @Test
    public void 引数に7165を指定した場合_toValueは_現物_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7165")), is(KyufuJissekiYoshikiKubun.現物_様式第五の二));
    }

    @Test
    public void 引数に7171を指定した場合_toValueは_現物_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7171")), is(KyufuJissekiYoshikiKubun.現物_様式第六));
    }

    @Test
    public void 引数に7172を指定した場合_toValueは_現物_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7172")), is(KyufuJissekiYoshikiKubun.現物_様式第六の二));
    }

    @Test
    public void 引数に7173を指定した場合_toValueは_現物_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7173")), is(KyufuJissekiYoshikiKubun.現物_様式第六の三));
    }

    @Test
    public void 引数に7174を指定した場合_toValueは_現物_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7174")), is(KyufuJissekiYoshikiKubun.現物_様式第六の四));
    }

    @Test
    public void 引数に7175を指定した場合_toValueは_現物_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7175")), is(KyufuJissekiYoshikiKubun.現物_様式第六の五));
    }

    @Test
    public void 引数に7176を指定した場合_toValueは_現物_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7176")), is(KyufuJissekiYoshikiKubun.現物_様式第六の六));
    }

    @Test
    public void 引数に7177を指定した場合_toValueは_現物_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7177")), is(KyufuJissekiYoshikiKubun.現物_様式第六の七));
    }

    @Test
    public void 引数に7181を指定した場合_toValueは_71現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7181")), is(KyufuJissekiYoshikiKubun._71現物_様式第八));
    }

    @Test
    public void 引数に7182を指定した場合_toValueは_71現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7182")), is(KyufuJissekiYoshikiKubun._71現物_様式第八));
    }

    @Test
    public void 引数に7183を指定した場合_toValueは_71現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7183")), is(KyufuJissekiYoshikiKubun._71現物_様式第八));
    }

    @Test
    public void 引数に7191を指定した場合_toValueは_71現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7191")), is(KyufuJissekiYoshikiKubun._71現物_様式第九));
    }

    @Test
    public void 引数に7192を指定した場合_toValueは_71現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7192")), is(KyufuJissekiYoshikiKubun._71現物_様式第九));
    }

    @Test
    public void 引数に7193を指定した場合_toValueは_71現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7193")), is(KyufuJissekiYoshikiKubun._71現物_様式第九));
    }

    @Test
    public void 引数に7194を指定した場合_toValueは_71現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7194")), is(KyufuJissekiYoshikiKubun._71現物_様式第九));
    }

    @Test
    public void 引数に7195を指定した場合_toValueは_71現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7195")), is(KyufuJissekiYoshikiKubun._71現物_様式第九));
    }

    @Test
    public void 引数に71A1を指定した場合_toValueは_71現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A1")), is(KyufuJissekiYoshikiKubun._71現物_様式第十));
    }

    @Test
    public void 引数に71A2を指定した場合_toValueは_71現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A2")), is(KyufuJissekiYoshikiKubun._71現物_様式第十));
    }

    @Test
    public void 引数に71A3を指定した場合_toValueは_71現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A3")), is(KyufuJissekiYoshikiKubun._71現物_様式第十));
    }

    @Test
    public void 引数に71P1を指定した場合_toValueは_現物_予防サービス_生活支援サービスを返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71P1")), is(KyufuJissekiYoshikiKubun.現物_予防サービス_生活支援サービス));
    }

    @Test
    public void 引数に71R1を指定した場合_toValueは_現物_様式第二の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71R1")), is(KyufuJissekiYoshikiKubun.現物_様式第二の三));
    }

    @Test
    public void 引数に8121を指定した場合_toValueは_81現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8121")), is(KyufuJissekiYoshikiKubun._81現物_様式第七));
    }

    @Test
    public void 引数に8122を指定した場合_toValueは_81現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8122")), is(KyufuJissekiYoshikiKubun._81現物_様式第七));
    }

    @Test
    public void 引数に8123を指定した場合_toValueは_81現物_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8123")), is(KyufuJissekiYoshikiKubun._81現物_様式第七の二));
    }

    @Test
    public void 引数に8124を指定した場合_toValueは_81現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8124")), is(KyufuJissekiYoshikiKubun._81現物_様式第七));
    }

    @Test
    public void 引数に8125を指定した場合_toValueは_81現物_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8125")), is(KyufuJissekiYoshikiKubun._81現物_様式第七の二));
    }

    @Test
    public void 引数に8161を指定した場合_toValueは_現物_ケアマネジメントを返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8161")), is(KyufuJissekiYoshikiKubun.現物_ケアマネジメント));
    }

    @Test
    public void 引数に8171を指定した場合_toValueは_現物_様式第七の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8171")), is(KyufuJissekiYoshikiKubun.現物_様式第七の三));
    }

    @Test
    public void 引数に3411を指定した場合_toValueは_償還_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("3411")), is(KyufuJissekiYoshikiKubun.償還_高額介護給付費));
    }

    @Test
    public void 現物_高額介護給付費を指定した場合_getコードは_無しを返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_高額介護給付費.getコード(), is(new RString("無し")));
    }

    @Test
    public void 償還_様式第二を指定した場合_getコードは_2131を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第二.getコード(), is(new RString("2131")));
    }

    @Test
    public void 償還_様式第二の二を指定した場合_getコードは_2132を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第二の二.getコード(), is(new RString("2132")));
    }

    @Test
    public void _21償還_様式第三を指定した場合_getコードは_2141を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第三.getコード(), is(new RString("2141")));
    }

    @Test
    public void _21償還_様式第三を指定した場合_getコードは_2142を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第三.getコード(), is(new RString("2142")));
    }

    @Test
    public void _21償還_様式第三を指定した場合_getコードは_2143を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第三.getコード(), is(new RString("2143")));
    }

    @Test
    public void 償還_様式第三の二を指定した場合_getコードは_2144を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第三の二.getコード(), is(new RString("2144")));
    }

    @Test
    public void _21償還_様式第四を指定した場合_getコードは_2151を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四.getコード(), is(new RString("2151")));
    }

    @Test
    public void _21償還_様式第四を指定した場合_getコードは_2152を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四.getコード(), is(new RString("2152")));
    }

    @Test
    public void _21償還_様式第四を指定した場合_getコードは_2153を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四.getコード(), is(new RString("2153")));
    }

    @Test
    public void _21償還_様式第四の二を指定した場合_getコードは_2154を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四の二.getコード(), is(new RString("2154")));
    }

    @Test
    public void _21償還_様式第四を指定した場合_getコードは_2155を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四.getコード(), is(new RString("2155")));
    }

    @Test
    public void _21償還_様式第四の二を指定した場合_getコードは_2156を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四の二.getコード(), is(new RString("2156")));
    }

    @Test
    public void _21償還_様式第五を指定した場合_getコードは_2161を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第五.getコード(), is(new RString("2161")));
    }

    @Test
    public void _21償還_様式第五を指定した場合_getコードは_2162を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第五.getコード(), is(new RString("2162")));
    }

    @Test
    public void _21償還_様式第五を指定した場合_getコードは_2163を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第五.getコード(), is(new RString("2163")));
    }

    @Test
    public void _21償還_様式第五を指定した場合_getコードは_2164を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第五.getコード(), is(new RString("2164")));
    }

    @Test
    public void 償還_様式第五の二を指定した場合_getコードは_2165を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第五の二.getコード(), is(new RString("2165")));
    }

    @Test
    public void 償還_様式第六を指定した場合_getコードは_2171を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六.getコード(), is(new RString("2171")));
    }

    @Test
    public void 償還_様式第六の二を指定した場合_getコードは_2172を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の二.getコード(), is(new RString("2172")));
    }

    @Test
    public void 償還_様式第六の三を指定した場合_getコードは_2173を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の三.getコード(), is(new RString("2173")));
    }

    @Test
    public void 償還_様式第六の四を指定した場合_getコードは_2174を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の四.getコード(), is(new RString("2174")));
    }

    @Test
    public void 償還_様式第六の五を指定した場合_getコードは_2175を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の五.getコード(), is(new RString("2175")));
    }

    @Test
    public void 償還_様式第六の六を指定した場合_getコードは_2176を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の六.getコード(), is(new RString("2176")));
    }

    @Test
    public void 償還_様式第六の七を指定した場合_getコードは_2177を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の七.getコード(), is(new RString("2177")));
    }

    @Test
    public void _21償還_様式第八を指定した場合_getコードは_2181を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第八.getコード(), is(new RString("2181")));
    }

    @Test
    public void _21償還_様式第八を指定した場合_getコードは_2182を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第八.getコード(), is(new RString("2182")));
    }

    @Test
    public void _21償還_様式第八を指定した場合_getコードは_2183を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第八.getコード(), is(new RString("2183")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_getコードは_2191を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.getコード(), is(new RString("2191")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_getコードは_2192を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.getコード(), is(new RString("2192")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_getコードは_2193を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.getコード(), is(new RString("2193")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_getコードは_2194を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.getコード(), is(new RString("2194")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_getコードは_2195を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.getコード(), is(new RString("2195")));
    }

    @Test
    public void _21償還_様式第十を指定した場合_getコードは_21A1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第十.getコード(), is(new RString("21A1")));
    }

    @Test
    public void _21償還_様式第十を指定した場合_getコードは_21A2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第十.getコード(), is(new RString("21A2")));
    }

    @Test
    public void _21償還_様式第十を指定した場合_getコードは_21A3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第十.getコード(), is(new RString("21A3")));
    }

    @Test
    public void _21償還_様式第七を指定した場合_getコードは_21B1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七.getコード(), is(new RString("21B1")));
    }

    @Test
    public void _21償還_様式第七を指定した場合_getコードは_21B2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七.getコード(), is(new RString("21B2")));
    }

    @Test
    public void _21償還_様式第七の二を指定した場合_getコードは_21B3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七の二.getコード(), is(new RString("21B3")));
    }

    @Test
    public void _21償還_様式第七を指定した場合_getコードは_21B4を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七.getコード(), is(new RString("21B4")));
    }

    @Test
    public void _21償還_様式第七の二を指定した場合_getコードは_21B5を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七の二.getコード(), is(new RString("21B5")));
    }

    @Test
    public void 償還_福祉用具販売費を指定した場合_getコードは_21C1を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_福祉用具販売費.getコード(), is(new RString("21C1")));
    }

    @Test
    public void 償還_予防用具販売費を指定した場合_getコードは_21C2を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_予防用具販売費.getコード(), is(new RString("21C2")));
    }

    @Test
    public void 償還_住宅改修費を指定した場合_getコードは_21D1を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_住宅改修費.getコード(), is(new RString("21D1")));
    }

    @Test
    public void 償還_予防住宅改修費を指定した場合_getコードは_21D2を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_予防住宅改修費.getコード(), is(new RString("21D2")));
    }

    @Test
    public void 現物_様式第二を指定した場合_getコードは_7131を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二.getコード(), is(new RString("7131")));
    }

    @Test
    public void 現物_様式第二の二を指定した場合_getコードは_7132を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二の二.getコード(), is(new RString("7132")));
    }

    @Test
    public void _71現物_様式第三を指定した場合_getコードは_7141を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第三.getコード(), is(new RString("7141")));
    }

    @Test
    public void _71現物_様式第三を指定した場合_getコードは_7142を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第三.getコード(), is(new RString("7142")));
    }

    @Test
    public void _71現物_様式第三を指定した場合_getコードは_7143を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第三.getコード(), is(new RString("7143")));
    }

    @Test
    public void 現物_様式第三の二を指定した場合_getコードは_7144を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第三の二.getコード(), is(new RString("7144")));
    }

    @Test
    public void _71現物_様式第四を指定した場合_getコードは_7151を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四.getコード(), is(new RString("7151")));
    }

    @Test
    public void _71現物_様式第四を指定した場合_getコードは_7152を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四.getコード(), is(new RString("7152")));
    }

    @Test
    public void _71現物_様式第四を指定した場合_getコードは_7153を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四.getコード(), is(new RString("7153")));
    }

    @Test
    public void _71現物_様式第四の二を指定した場合_getコードは_7154を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四の二.getコード(), is(new RString("7154")));
    }

    @Test
    public void _71現物_様式第四を指定した場合_getコードは_7155を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四.getコード(), is(new RString("7155")));
    }

    @Test
    public void _71現物_様式第四の二を指定した場合_getコードは_7156を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四の二.getコード(), is(new RString("7156")));
    }

    @Test
    public void _71現物_様式第五を指定した場合_getコードは_7161を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第五.getコード(), is(new RString("7161")));
    }

    @Test
    public void _71現物_様式第五を指定した場合_getコードは_7162を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第五.getコード(), is(new RString("7162")));
    }

    @Test
    public void _71現物_様式第五を指定した場合_getコードは_7163を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第五.getコード(), is(new RString("7163")));
    }

    @Test
    public void _71現物_様式第五を指定した場合_getコードは_7164を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第五.getコード(), is(new RString("7164")));
    }

    @Test
    public void 現物_様式第五の二を指定した場合_getコードは_7165を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第五の二.getコード(), is(new RString("7165")));
    }

    @Test
    public void 現物_様式第六を指定した場合_getコードは_7171を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六.getコード(), is(new RString("7171")));
    }

    @Test
    public void 現物_様式第六の二を指定した場合_getコードは_7172を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の二.getコード(), is(new RString("7172")));
    }

    @Test
    public void 現物_様式第六の三を指定した場合_getコードは_7173を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の三.getコード(), is(new RString("7173")));
    }

    @Test
    public void 現物_様式第六の四を指定した場合_getコードは_7174を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の四.getコード(), is(new RString("7174")));
    }

    @Test
    public void 現物_様式第六の五を指定した場合_getコードは_7175を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の五.getコード(), is(new RString("7175")));
    }

    @Test
    public void 現物_様式第六の六を指定した場合_getコードは_7176を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の六.getコード(), is(new RString("7176")));
    }

    @Test
    public void 現物_様式第六の七を指定した場合_getコードは_7177を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の七.getコード(), is(new RString("7177")));
    }

    @Test
    public void _71現物_様式第八を指定した場合_getコードは_7181を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第八.getコード(), is(new RString("7181")));
    }

    @Test
    public void _71現物_様式第八を指定した場合_getコードは_7182を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第八.getコード(), is(new RString("7182")));
    }

    @Test
    public void _71現物_様式第八を指定した場合_getコードは_7183を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第八.getコード(), is(new RString("7183")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_getコードは_7191を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.getコード(), is(new RString("7191")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_getコードは_7192を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.getコード(), is(new RString("7192")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_getコードは_7193を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.getコード(), is(new RString("7193")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_getコードは_7194を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.getコード(), is(new RString("7194")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_getコードは_7195を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.getコード(), is(new RString("7195")));
    }

    @Test
    public void _71現物_様式第十を指定した場合_getコードは_71A1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第十.getコード(), is(new RString("71A1")));
    }

    @Test
    public void _71現物_様式第十を指定した場合_getコードは_71A2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第十.getコード(), is(new RString("71A2")));
    }

    @Test
    public void _71現物_様式第十を指定した場合_getコードは_71A3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第十.getコード(), is(new RString("71A3")));
    }

    @Test
    public void 現物_予防サービス_生活支援サービスを指定した場合_getコードは_71P1を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_予防サービス_生活支援サービス.getコード(), is(new RString("71P1")));
    }

    @Test
    public void 現物_様式第二の三を指定した場合_getコードは_71R1を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二の三.getコード(), is(new RString("71R1")));
    }

    @Test
    public void _81現物_様式第七を指定した場合_getコードは_8121を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七.getコード(), is(new RString("8121")));
    }

    @Test
    public void _81現物_様式第七を指定した場合_getコードは_8122を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七.getコード(), is(new RString("8122")));
    }

    @Test
    public void _81現物_様式第七の二を指定した場合_getコードは_8123を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七の二.getコード(), is(new RString("8123")));
    }

    @Test
    public void _81現物_様式第七を指定した場合_getコードは_8124を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七.getコード(), is(new RString("8124")));
    }

    @Test
    public void _81現物_様式第七の二を指定した場合_getコードは_8125を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七の二.getコード(), is(new RString("8125")));
    }

    @Test
    public void 現物_ケアマネジメントを指定した場合_getコードは_8161を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_ケアマネジメント.getコード(), is(new RString("8161")));
    }

    @Test
    public void 現物_様式第七の三を指定した場合_getコードは_8171を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第七の三.getコード(), is(new RString("8171")));
    }

    @Test
    public void 償還_高額介護給付費を指定した場合_getコードは_3411を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_高額介護給付費.getコード(), is(new RString("3411")));
    }

    @Test
    public void 現物_高額介護給付費を指定した場合_get名称は_現物_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_高額介護給付費.get名称(), is(new RString("現物_高額介護給付費")));
    }

    @Test
    public void 償還_様式第二を指定した場合_get名称は_償還_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第二.get名称(), is(new RString("償還_様式第二")));
    }

    @Test
    public void 償還_様式第二の二を指定した場合_get名称は_償還_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第二の二.get名称(), is(new RString("償還_様式第二の二")));
    }

    @Test
    public void _21償還_様式第三を指定した場合_get名称は_償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第三.get名称(), is(new RString("償還_様式第三")));
    }

    @Test
    public void 償還_様式第三の二を指定した場合_get名称は_償還_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第三の二.get名称(), is(new RString("償還_様式第三の二")));
    }

    @Test
    public void _21償還_様式第四を指定した場合_get名称は_償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四.get名称(), is(new RString("償還_様式第四")));
    }

    @Test
    public void _21償還_様式第四の二を指定した場合_get名称は_償還_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第四の二.get名称(), is(new RString("償還_様式第四の二")));
    }

    @Test
    public void _21償還_様式第五を指定した場合_get名称は_償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第五.get名称(), is(new RString("償還_様式第五")));
    }

    @Test
    public void 償還_様式第五の二を指定した場合_get名称は_償還_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第五の二.get名称(), is(new RString("償還_様式第五の二")));
    }

    @Test
    public void 償還_様式第六を指定した場合_get名称は_償還_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六.get名称(), is(new RString("償還_様式第六")));
    }

    @Test
    public void 償還_様式第六の二を指定した場合_get名称は_償還_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の二.get名称(), is(new RString("償還_様式第六の二")));
    }

    @Test
    public void 償還_様式第六の三を指定した場合_get名称は_償還_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の三.get名称(), is(new RString("償還_様式第六の三")));
    }

    @Test
    public void 償還_様式第六の四を指定した場合_get名称は_償還_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の四.get名称(), is(new RString("償還_様式第六の四")));
    }

    @Test
    public void 償還_様式第六の五を指定した場合_get名称は_償還_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の五.get名称(), is(new RString("償還_様式第六の五")));
    }

    @Test
    public void 償還_様式第六の六を指定した場合_get名称は_償還_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の六.get名称(), is(new RString("償還_様式第六の六")));
    }

    @Test
    public void 償還_様式第六の七を指定した場合_get名称は_償還_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_様式第六の七.get名称(), is(new RString("償還_様式第六の七")));
    }

    @Test
    public void _21償還_様式第八を指定した場合_get名称は_償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第八.get名称(), is(new RString("償還_様式第八")));
    }

    @Test
    public void _21償還_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _21償還_様式第十を指定した場合_get名称は_償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第十.get名称(), is(new RString("償還_様式第十")));
    }

    @Test
    public void _21償還_様式第七を指定した場合_get名称は_償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七.get名称(), is(new RString("償還_様式第七")));
    }

    @Test
    public void _21償還_様式第七の二を指定した場合_get名称は_償還_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21償還_様式第七の二.get名称(), is(new RString("償還_様式第七の二")));
    }

    @Test
    public void 償還_福祉用具販売費を指定した場合_get名称は_償還_福祉用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_福祉用具販売費.get名称(), is(new RString("償還_福祉用具販売費")));
    }

    @Test
    public void 償還_予防用具販売費を指定した場合_get名称は_償還_予防用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_予防用具販売費.get名称(), is(new RString("償還_予防用具販売費")));
    }

    @Test
    public void 償還_住宅改修費を指定した場合_get名称は_償還_住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_住宅改修費.get名称(), is(new RString("償還_住宅改修費")));
    }

    @Test
    public void 償還_予防住宅改修費を指定した場合_get名称は_償還_予防住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_予防住宅改修費.get名称(), is(new RString("償還_予防住宅改修費")));
    }

    @Test
    public void 現物_様式第二を指定した場合_get名称は_現物_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二.get名称(), is(new RString("現物_様式第二")));
    }

    @Test
    public void 現物_様式第二の二を指定した場合_get名称は_現物_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二の二.get名称(), is(new RString("現物_様式第二の二")));
    }

    @Test
    public void _71現物_様式第三を指定した場合_get名称は_現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第三.get名称(), is(new RString("現物_様式第三")));
    }

    @Test
    public void 現物_様式第三の二を指定した場合_get名称は_現物_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第三の二.get名称(), is(new RString("現物_様式第三の二")));
    }

    @Test
    public void _71現物_様式第四を指定した場合_get名称は_現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四.get名称(), is(new RString("現物_様式第四")));
    }

    @Test
    public void _71現物_様式第四の二を指定した場合_get名称は_現物_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第四の二.get名称(), is(new RString("現物_様式第四の二")));
    }

    @Test
    public void _71現物_様式第五を指定した場合_get名称は_現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第五.get名称(), is(new RString("現物_様式第五")));
    }

    @Test
    public void 現物_様式第五の二を指定した場合_get名称は_現物_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第五の二.get名称(), is(new RString("現物_様式第五の二")));
    }

    @Test
    public void 現物_様式第六を指定した場合_get名称は_現物_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六.get名称(), is(new RString("現物_様式第六")));
    }

    @Test
    public void 現物_様式第六の二を指定した場合_get名称は_現物_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の二.get名称(), is(new RString("現物_様式第六の二")));
    }

    @Test
    public void 現物_様式第六の三を指定した場合_get名称は_現物_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の三.get名称(), is(new RString("現物_様式第六の三")));
    }

    @Test
    public void 現物_様式第六の四を指定した場合_get名称は_現物_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の四.get名称(), is(new RString("現物_様式第六の四")));
    }

    @Test
    public void 現物_様式第六の五を指定した場合_get名称は_現物_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の五.get名称(), is(new RString("現物_様式第六の五")));
    }

    @Test
    public void 現物_様式第六の六を指定した場合_get名称は_現物_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の六.get名称(), is(new RString("現物_様式第六の六")));
    }

    @Test
    public void 現物_様式第六の七を指定した場合_get名称は_現物_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第六の七.get名称(), is(new RString("現物_様式第六の七")));
    }

    @Test
    public void _71現物_様式第八を指定した場合_get名称は_現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第八.get名称(), is(new RString("現物_様式第八")));
    }

    @Test
    public void _71現物_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _71現物_様式第十を指定した場合_get名称は_現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71現物_様式第十.get名称(), is(new RString("現物_様式第十")));
    }

    @Test
    public void 現物_予防サービス_生活支援サービスを指定した場合_get名称は_現物_予防サービス_生活支援サービスを返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_予防サービス_生活支援サービス.get名称(), is(new RString("現物_予防サービス・生活支援サービス")));
    }

    @Test
    public void 現物_様式第二の三を指定した場合_get名称は_現物_様式第二の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第二の三.get名称(), is(new RString("現物_様式第二の三")));
    }

    @Test
    public void _81現物_様式第七を指定した場合_get名称は_現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七.get名称(), is(new RString("現物_様式第七")));
    }

    @Test
    public void _81現物_様式第七の二を指定した場合_get名称は_現物_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._81現物_様式第七の二.get名称(), is(new RString("現物_様式第七の二")));
    }

    @Test
    public void 現物_ケアマネジメントを指定した場合_get名称は_現物_ケアマネジメントを返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_ケアマネジメント.get名称(), is(new RString("現物_ケアマネジメント")));
    }

    @Test
    public void 現物_様式第七の三を指定した場合_get名称は_現物_様式第七の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_様式第七の三.get名称(), is(new RString("現物_様式第七の三")));
    }

    @Test
    public void 償還_高額介護給付費を指定した場合_get名称は_償還_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.償還_高額介護給付費.get名称(), is(new RString("償還_高額介護給付費")));
    }

}
