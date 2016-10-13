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
    public void 引数に2131を指定した場合_toValueは_2131_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2131")), is(KyufuJissekiYoshikiKubun._2131_様式第二));
    }

    @Test
    public void 引数に2132を指定した場合_toValueは_2132_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2132")), is(KyufuJissekiYoshikiKubun._2132_様式第二の二));
    }

    @Test
    public void 引数に2141を指定した場合_toValueは_2141_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2141")), is(KyufuJissekiYoshikiKubun._2141_様式第三));
    }

    @Test
    public void 引数に2142を指定した場合_toValueは_2142_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2142")), is(KyufuJissekiYoshikiKubun._2142_様式第三));
    }

    @Test
    public void 引数に2143を指定した場合_toValueは_2143_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2143")), is(KyufuJissekiYoshikiKubun._2143_様式第三));
    }

    @Test
    public void 引数に2144を指定した場合_toValueは_2144_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2144")), is(KyufuJissekiYoshikiKubun._2144_様式第三の二));
    }

    @Test
    public void 引数に2151を指定した場合_toValueは_2151_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2151")), is(KyufuJissekiYoshikiKubun._2151_様式第四));
    }

    @Test
    public void 引数に2152を指定した場合_toValueは_2152_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2152")), is(KyufuJissekiYoshikiKubun._2152_様式第四));
    }

    @Test
    public void 引数に2153を指定した場合_toValueは_2153_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2153")), is(KyufuJissekiYoshikiKubun._2153_様式第四));
    }

    @Test
    public void 引数に2154を指定した場合_toValueは_2154_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2154")), is(KyufuJissekiYoshikiKubun._2154_様式第四の二));
    }

    @Test
    public void 引数に2155を指定した場合_toValueは_2155_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2155")), is(KyufuJissekiYoshikiKubun._2155_様式第四));
    }

    @Test
    public void 引数に2156を指定した場合_toValueは_2156_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2156")), is(KyufuJissekiYoshikiKubun._2156_様式第四の二));
    }

    @Test
    public void 引数に2161を指定した場合_toValueは_2161_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2161")), is(KyufuJissekiYoshikiKubun._2161_様式第五));
    }

    @Test
    public void 引数に2162を指定した場合_toValueは_2162_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2162")), is(KyufuJissekiYoshikiKubun._2162_様式第五));
    }

    @Test
    public void 引数に2163を指定した場合_toValueは_2163_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2163")), is(KyufuJissekiYoshikiKubun._2163_様式第五));
    }

    @Test
    public void 引数に2164を指定した場合_toValueは_2164_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2164")), is(KyufuJissekiYoshikiKubun._2164_様式第五));
    }

    @Test
    public void 引数に2165を指定した場合_toValueは_2165_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2165")), is(KyufuJissekiYoshikiKubun._2165_様式第五の二));
    }

    @Test
    public void 引数に2171を指定した場合_toValueは_2171_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2171")), is(KyufuJissekiYoshikiKubun._2171_様式第六));
    }

    @Test
    public void 引数に2172を指定した場合_toValueは_2172_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2172")), is(KyufuJissekiYoshikiKubun._2172_様式第六の二));
    }

    @Test
    public void 引数に2173を指定した場合_toValueは_2173_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2173")), is(KyufuJissekiYoshikiKubun._2173_様式第六の三));
    }

    @Test
    public void 引数に2174を指定した場合_toValueは_2174_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2174")), is(KyufuJissekiYoshikiKubun._2174_様式第六の四));
    }

    @Test
    public void 引数に2175を指定した場合_toValueは_2175_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2175")), is(KyufuJissekiYoshikiKubun._2175_様式第六の五));
    }

    @Test
    public void 引数に2176を指定した場合_toValueは_2176_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2176")), is(KyufuJissekiYoshikiKubun._2176_様式第六の六));
    }

    @Test
    public void 引数に2177を指定した場合_toValueは_2177_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2177")), is(KyufuJissekiYoshikiKubun._2177_様式第六の七));
    }

    @Test
    public void 引数に2181を指定した場合_toValueは_2181_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2181")), is(KyufuJissekiYoshikiKubun._2181_様式第八));
    }

    @Test
    public void 引数に2182を指定した場合_toValueは_2182_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2182")), is(KyufuJissekiYoshikiKubun._2182_様式第八));
    }

    @Test
    public void 引数に2183を指定した場合_toValueは_2183_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2183")), is(KyufuJissekiYoshikiKubun._2183_様式第八));
    }

    @Test
    public void 引数に2191を指定した場合_toValueは_2191_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2191")), is(KyufuJissekiYoshikiKubun._2191_様式第九));
    }

    @Test
    public void 引数に2192を指定した場合_toValueは_2192_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2192")), is(KyufuJissekiYoshikiKubun._2192_様式第九));
    }

    @Test
    public void 引数に2193を指定した場合_toValueは_2193_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2193")), is(KyufuJissekiYoshikiKubun._2193_様式第九));
    }

    @Test
    public void 引数に2194を指定した場合_toValueは_2194_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2194")), is(KyufuJissekiYoshikiKubun._2194_様式第九));
    }

    @Test
    public void 引数に2195を指定した場合_toValueは_2195_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("2195")), is(KyufuJissekiYoshikiKubun._2195_様式第九));
    }

    @Test
    public void 引数に21A1を指定した場合_toValueは_21A1_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A1")), is(KyufuJissekiYoshikiKubun._21A1_様式第十));
    }

    @Test
    public void 引数に21A2を指定した場合_toValueは_21A2_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A2")), is(KyufuJissekiYoshikiKubun._21A2_様式第十));
    }

    @Test
    public void 引数に21A3を指定した場合_toValueは_21A3_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21A3")), is(KyufuJissekiYoshikiKubun._21A3_様式第十));
    }

    @Test
    public void 引数に21B1を指定した場合_toValueは_21B1_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B1")), is(KyufuJissekiYoshikiKubun._21B1_様式第七));
    }

    @Test
    public void 引数に21B2を指定した場合_toValueは_21B2_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B2")), is(KyufuJissekiYoshikiKubun._21B2_様式第七));
    }

    @Test
    public void 引数に21B3を指定した場合_toValueは_21B3_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B3")), is(KyufuJissekiYoshikiKubun._21B3_様式第七の二));
    }

    @Test
    public void 引数に21B4を指定した場合_toValueは_21B4_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B4")), is(KyufuJissekiYoshikiKubun._21B4_様式第七));
    }

    @Test
    public void 引数に21B5を指定した場合_toValueは_21B5_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21B5")), is(KyufuJissekiYoshikiKubun._21B5_様式第七の二));
    }

    @Test
    public void 引数に21C1を指定した場合_toValueは_21C1_福祉用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21C1")), is(KyufuJissekiYoshikiKubun._21C1_福祉用具販売費));
    }

    @Test
    public void 引数に21C2を指定した場合_toValueは_21C2_予防用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21C2")), is(KyufuJissekiYoshikiKubun._21C2_予防用具販売費));
    }

    @Test
    public void 引数に21D1を指定した場合_toValueは_21D1_住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21D1")), is(KyufuJissekiYoshikiKubun._21D1_住宅改修費));
    }

    @Test
    public void 引数に21D2を指定した場合_toValueは_21D2_予防住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("21D2")), is(KyufuJissekiYoshikiKubun._21D2_予防住宅改修費));
    }

    @Test
    public void 引数に7131を指定した場合_toValueは_7131_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7131")), is(KyufuJissekiYoshikiKubun._7131_様式第二));
    }

    @Test
    public void 引数に7132を指定した場合_toValueは_7132_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7132")), is(KyufuJissekiYoshikiKubun._7132_様式第二の二));
    }

    @Test
    public void 引数に7141を指定した場合_toValueは_7141_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7141")), is(KyufuJissekiYoshikiKubun._7141_様式第三));
    }

    @Test
    public void 引数に7142を指定した場合_toValueは_7142_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7142")), is(KyufuJissekiYoshikiKubun._7142_様式第三));
    }

    @Test
    public void 引数に7143を指定した場合_toValueは_7143_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7143")), is(KyufuJissekiYoshikiKubun._7143_様式第三));
    }

    @Test
    public void 引数に7144を指定した場合_toValueは_7144_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7144")), is(KyufuJissekiYoshikiKubun._7144_様式第三の二));
    }

    @Test
    public void 引数に7151を指定した場合_toValueは_7151_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7151")), is(KyufuJissekiYoshikiKubun._7151_様式第四));
    }

    @Test
    public void 引数に7152を指定した場合_toValueは_7152_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7152")), is(KyufuJissekiYoshikiKubun._7152_様式第四));
    }

    @Test
    public void 引数に7153を指定した場合_toValueは_7153_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7153")), is(KyufuJissekiYoshikiKubun._7153_様式第四));
    }

    @Test
    public void 引数に7154を指定した場合_toValueは_7154_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7154")), is(KyufuJissekiYoshikiKubun._7154_様式第四の二));
    }

    @Test
    public void 引数に7155を指定した場合_toValueは_7155_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7155")), is(KyufuJissekiYoshikiKubun._7155_様式第四));
    }

    @Test
    public void 引数に7156を指定した場合_toValueは_7156_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7156")), is(KyufuJissekiYoshikiKubun._7156_様式第四の二));
    }

    @Test
    public void 引数に7161を指定した場合_toValueは_7161_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7161")), is(KyufuJissekiYoshikiKubun._7161_様式第五));
    }

    @Test
    public void 引数に7162を指定した場合_toValueは_7162_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7162")), is(KyufuJissekiYoshikiKubun._7162_様式第五));
    }

    @Test
    public void 引数に7163を指定した場合_toValueは_7163_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7163")), is(KyufuJissekiYoshikiKubun._7163_様式第五));
    }

    @Test
    public void 引数に7164を指定した場合_toValueは_7164_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7164")), is(KyufuJissekiYoshikiKubun._7164_様式第五));
    }

    @Test
    public void 引数に7165を指定した場合_toValueは_7165_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7165")), is(KyufuJissekiYoshikiKubun._7165_様式第五の二));
    }

    @Test
    public void 引数に7171を指定した場合_toValueは_7171_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7171")), is(KyufuJissekiYoshikiKubun._7171_様式第六));
    }

    @Test
    public void 引数に7172を指定した場合_toValueは_7172_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7172")), is(KyufuJissekiYoshikiKubun._7172_様式第六の二));
    }

    @Test
    public void 引数に7173を指定した場合_toValueは_7173_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7173")), is(KyufuJissekiYoshikiKubun._7173_様式第六の三));
    }

    @Test
    public void 引数に7174を指定した場合_toValueは_7174_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7174")), is(KyufuJissekiYoshikiKubun._7174_様式第六の四));
    }

    @Test
    public void 引数に7175を指定した場合_toValueは_7175_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7175")), is(KyufuJissekiYoshikiKubun._7175_様式第六の五));
    }

    @Test
    public void 引数に7176を指定した場合_toValueは_7176_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7176")), is(KyufuJissekiYoshikiKubun._7176_様式第六の六));
    }

    @Test
    public void 引数に7177を指定した場合_toValueは_7177_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7177")), is(KyufuJissekiYoshikiKubun._7177_様式第六の七));
    }

    @Test
    public void 引数に7181を指定した場合_toValueは_7181_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7181")), is(KyufuJissekiYoshikiKubun._7181_様式第八));
    }

    @Test
    public void 引数に7182を指定した場合_toValueは_7182_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7182")), is(KyufuJissekiYoshikiKubun._7182_様式第八));
    }

    @Test
    public void 引数に7183を指定した場合_toValueは_7183_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7183")), is(KyufuJissekiYoshikiKubun._7183_様式第八));
    }

    @Test
    public void 引数に7191を指定した場合_toValueは_7191_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7191")), is(KyufuJissekiYoshikiKubun._7191_様式第九));
    }

    @Test
    public void 引数に7192を指定した場合_toValueは_7192_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7192")), is(KyufuJissekiYoshikiKubun._7192_様式第九));
    }

    @Test
    public void 引数に7193を指定した場合_toValueは_7193_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7193")), is(KyufuJissekiYoshikiKubun._7193_様式第九));
    }

    @Test
    public void 引数に7194を指定した場合_toValueは_7194_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7194")), is(KyufuJissekiYoshikiKubun._7194_様式第九));
    }

    @Test
    public void 引数に7195を指定した場合_toValueは_7195_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("7195")), is(KyufuJissekiYoshikiKubun._7195_様式第九));
    }

    @Test
    public void 引数に71A1を指定した場合_toValueは_71A1_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A1")), is(KyufuJissekiYoshikiKubun._71A1_様式第十));
    }

    @Test
    public void 引数に71A2を指定した場合_toValueは_71A2_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A2")), is(KyufuJissekiYoshikiKubun._71A2_様式第十));
    }

    @Test
    public void 引数に71A3を指定した場合_toValueは_71A3_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71A3")), is(KyufuJissekiYoshikiKubun._71A3_様式第十));
    }

    @Test
    public void 引数に71P1を指定した場合_toValueは_71P1_予防サービス_生活支援サービスを返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71P1")), is(KyufuJissekiYoshikiKubun._71P1_予防サービス_生活支援サービス));
    }

    @Test
    public void 引数に71R1を指定した場合_toValueは_71R1_様式第二の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("71R1")), is(KyufuJissekiYoshikiKubun._71R1_様式第二の三));
    }

    @Test
    public void 引数に8121を指定した場合_toValueは_8121_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8121")), is(KyufuJissekiYoshikiKubun._8121_様式第七));
    }

    @Test
    public void 引数に8122を指定した場合_toValueは_8122_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8122")), is(KyufuJissekiYoshikiKubun._8122_様式第七));
    }

    @Test
    public void 引数に8123を指定した場合_toValueは_8123_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8123")), is(KyufuJissekiYoshikiKubun._8123_様式第七の二));
    }

    @Test
    public void 引数に8124を指定した場合_toValueは_8124_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8124")), is(KyufuJissekiYoshikiKubun._8124_様式第七));
    }

    @Test
    public void 引数に8125を指定した場合_toValueは_8125_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8125")), is(KyufuJissekiYoshikiKubun._8125_様式第七の二));
    }

    @Test
    public void 引数に8161を指定した場合_toValueは_8161_ケアマネジメントを返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8161")), is(KyufuJissekiYoshikiKubun._8161_ケアマネジメント));
    }

    @Test
    public void 引数に8171を指定した場合_toValueは_8171_様式第七の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("8171")), is(KyufuJissekiYoshikiKubun._8171_様式第七の三));
    }

    @Test
    public void 引数に3411を指定した場合_toValueは_3411_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.toValue(new RString("3411")), is(KyufuJissekiYoshikiKubun._3411_高額介護給付費));
    }

    @Test
    public void 現物_高額介護給付費を指定した場合_getコードは_無しを返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_高額介護給付費.getコード(), is(new RString("無し")));
    }

    @Test
    public void _2131_様式第二を指定した場合_getコードは_2131を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2131_様式第二.getコード(), is(new RString("2131")));
    }

    @Test
    public void _2132_様式第二の二を指定した場合_getコードは_2132を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2132_様式第二の二.getコード(), is(new RString("2132")));
    }

    @Test
    public void _2141_様式第三を指定した場合_getコードは_2141を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2141_様式第三.getコード(), is(new RString("2141")));
    }

    @Test
    public void _2142_様式第三を指定した場合_getコードは_2142を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2142_様式第三.getコード(), is(new RString("2142")));
    }

    @Test
    public void _2143_様式第三を指定した場合_getコードは_2143を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2143_様式第三.getコード(), is(new RString("2143")));
    }

    @Test
    public void _2144_様式第三の二を指定した場合_getコードは_2144を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2144_様式第三の二.getコード(), is(new RString("2144")));
    }

    @Test
    public void _2151_様式第四を指定した場合_getコードは_2151を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2151_様式第四.getコード(), is(new RString("2151")));
    }

    @Test
    public void _2152_様式第四を指定した場合_getコードは_2152を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2152_様式第四.getコード(), is(new RString("2152")));
    }

    @Test
    public void _2153_様式第四を指定した場合_getコードは_2153を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2153_様式第四.getコード(), is(new RString("2153")));
    }

    @Test
    public void _2154_様式第四の二を指定した場合_getコードは_2154を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2154_様式第四の二.getコード(), is(new RString("2154")));
    }

    @Test
    public void _2155_様式第四を指定した場合_getコードは_2155を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2155_様式第四.getコード(), is(new RString("2155")));
    }

    @Test
    public void _2156_様式第四の二を指定した場合_getコードは_2156を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2156_様式第四の二.getコード(), is(new RString("2156")));
    }

    @Test
    public void _2161_様式第五を指定した場合_getコードは_2161を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2161_様式第五.getコード(), is(new RString("2161")));
    }

    @Test
    public void _2162_様式第五を指定した場合_getコードは_2162を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2162_様式第五.getコード(), is(new RString("2162")));
    }

    @Test
    public void _2163_様式第五を指定した場合_getコードは_2163を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2163_様式第五.getコード(), is(new RString("2163")));
    }

    @Test
    public void _2164_様式第五を指定した場合_getコードは_2164を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2164_様式第五.getコード(), is(new RString("2164")));
    }

    @Test
    public void _2165_様式第五の二を指定した場合_getコードは_2165を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2165_様式第五の二.getコード(), is(new RString("2165")));
    }

    @Test
    public void _2171_様式第六を指定した場合_getコードは_2171を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2171_様式第六.getコード(), is(new RString("2171")));
    }

    @Test
    public void _2172_様式第六の二を指定した場合_getコードは_2172を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2172_様式第六の二.getコード(), is(new RString("2172")));
    }

    @Test
    public void _2173_様式第六の三を指定した場合_getコードは_2173を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2173_様式第六の三.getコード(), is(new RString("2173")));
    }

    @Test
    public void _2174_様式第六の四を指定した場合_getコードは_2174を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2174_様式第六の四.getコード(), is(new RString("2174")));
    }

    @Test
    public void _2175_様式第六の五を指定した場合_getコードは_2175を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2175_様式第六の五.getコード(), is(new RString("2175")));
    }

    @Test
    public void _2176_様式第六の六を指定した場合_getコードは_2176を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2176_様式第六の六.getコード(), is(new RString("2176")));
    }

    @Test
    public void _2177_様式第六の七を指定した場合_getコードは_2177を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2177_様式第六の七.getコード(), is(new RString("2177")));
    }

    @Test
    public void _2181_様式第八を指定した場合_getコードは_2181を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2181_様式第八.getコード(), is(new RString("2181")));
    }

    @Test
    public void _2182_様式第八を指定した場合_getコードは_2182を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2182_様式第八.getコード(), is(new RString("2182")));
    }

    @Test
    public void _2183_様式第八を指定した場合_getコードは_2183を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2183_様式第八.getコード(), is(new RString("2183")));
    }

    @Test
    public void _2191_様式第九を指定した場合_getコードは_2191を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2191_様式第九.getコード(), is(new RString("2191")));
    }

    @Test
    public void _2192_様式第九を指定した場合_getコードは_2192を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2192_様式第九.getコード(), is(new RString("2192")));
    }

    @Test
    public void _2193_様式第九を指定した場合_getコードは_2193を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2193_様式第九.getコード(), is(new RString("2193")));
    }

    @Test
    public void _2194_様式第九を指定した場合_getコードは_2194を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2194_様式第九.getコード(), is(new RString("2194")));
    }

    @Test
    public void _2195_様式第九を指定した場合_getコードは_2195を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2195_様式第九.getコード(), is(new RString("2195")));
    }

    @Test
    public void _21A1_様式第十を指定した場合_getコードは_21A1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A1_様式第十.getコード(), is(new RString("21A1")));
    }

    @Test
    public void _21A2_様式第十を指定した場合_getコードは_21A2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A2_様式第十.getコード(), is(new RString("21A2")));
    }

    @Test
    public void _21A3_様式第十を指定した場合_getコードは_21A3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A3_様式第十.getコード(), is(new RString("21A3")));
    }

    @Test
    public void _21B1_様式第七を指定した場合_getコードは_21B1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B1_様式第七.getコード(), is(new RString("21B1")));
    }

    @Test
    public void _21B2_様式第七を指定した場合_getコードは_21B2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B2_様式第七.getコード(), is(new RString("21B2")));
    }

    @Test
    public void _21B3_様式第七の二を指定した場合_getコードは_21B3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B3_様式第七の二.getコード(), is(new RString("21B3")));
    }

    @Test
    public void _21B4_様式第七を指定した場合_getコードは_21B4を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B4_様式第七.getコード(), is(new RString("21B4")));
    }

    @Test
    public void _21B5_様式第七の二を指定した場合_getコードは_21B5を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B5_様式第七の二.getコード(), is(new RString("21B5")));
    }

    @Test
    public void _21C1_福祉用具販売費を指定した場合_getコードは_21C1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.getコード(), is(new RString("21C1")));
    }

    @Test
    public void _21C2_予防用具販売費を指定した場合_getコードは_21C2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21C2_予防用具販売費.getコード(), is(new RString("21C2")));
    }

    @Test
    public void _21D1_住宅改修費を指定した場合_getコードは_21D1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21D1_住宅改修費.getコード(), is(new RString("21D1")));
    }

    @Test
    public void _21D2_予防住宅改修費を指定した場合_getコードは_21D2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.getコード(), is(new RString("21D2")));
    }

    @Test
    public void _7131_様式第二を指定した場合_getコードは_7131を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7131_様式第二.getコード(), is(new RString("7131")));
    }

    @Test
    public void _7132_様式第二の二を指定した場合_getコードは_7132を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7132_様式第二の二.getコード(), is(new RString("7132")));
    }

    @Test
    public void _7141_様式第三を指定した場合_getコードは_7141を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7141_様式第三.getコード(), is(new RString("7141")));
    }

    @Test
    public void _7142_様式第三を指定した場合_getコードは_7142を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7142_様式第三.getコード(), is(new RString("7142")));
    }

    @Test
    public void _7143_様式第三を指定した場合_getコードは_7143を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7143_様式第三.getコード(), is(new RString("7143")));
    }

    @Test
    public void _7144_様式第三の二を指定した場合_getコードは_7144を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7144_様式第三の二.getコード(), is(new RString("7144")));
    }

    @Test
    public void _7151_様式第四を指定した場合_getコードは_7151を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7151_様式第四.getコード(), is(new RString("7151")));
    }

    @Test
    public void _7152_様式第四を指定した場合_getコードは_7152を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7152_様式第四.getコード(), is(new RString("7152")));
    }

    @Test
    public void _7153_様式第四を指定した場合_getコードは_7153を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7153_様式第四.getコード(), is(new RString("7153")));
    }

    @Test
    public void _7154_様式第四の二を指定した場合_getコードは_7154を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7154_様式第四の二.getコード(), is(new RString("7154")));
    }

    @Test
    public void _7155_様式第四を指定した場合_getコードは_7155を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7155_様式第四.getコード(), is(new RString("7155")));
    }

    @Test
    public void _7156_様式第四の二を指定した場合_getコードは_7156を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7156_様式第四の二.getコード(), is(new RString("7156")));
    }

    @Test
    public void _7161_様式第五を指定した場合_getコードは_7161を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7161_様式第五.getコード(), is(new RString("7161")));
    }

    @Test
    public void _7162_様式第五を指定した場合_getコードは_7162を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7162_様式第五.getコード(), is(new RString("7162")));
    }

    @Test
    public void _7163_様式第五を指定した場合_getコードは_7163を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7163_様式第五.getコード(), is(new RString("7163")));
    }

    @Test
    public void _7164_様式第五を指定した場合_getコードは_7164を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7164_様式第五.getコード(), is(new RString("7164")));
    }

    @Test
    public void _7165_様式第五の二を指定した場合_getコードは_7165を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7165_様式第五の二.getコード(), is(new RString("7165")));
    }

    @Test
    public void _7171_様式第六を指定した場合_getコードは_7171を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7171_様式第六.getコード(), is(new RString("7171")));
    }

    @Test
    public void _7172_様式第六の二を指定した場合_getコードは_7172を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7172_様式第六の二.getコード(), is(new RString("7172")));
    }

    @Test
    public void _7173_様式第六の三を指定した場合_getコードは_7173を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7173_様式第六の三.getコード(), is(new RString("7173")));
    }

    @Test
    public void _7174_様式第六の四を指定した場合_getコードは_7174を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7174_様式第六の四.getコード(), is(new RString("7174")));
    }

    @Test
    public void _7175_様式第六の五を指定した場合_getコードは_7175を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7175_様式第六の五.getコード(), is(new RString("7175")));
    }

    @Test
    public void _7176_様式第六の六を指定した場合_getコードは_7176を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7176_様式第六の六.getコード(), is(new RString("7176")));
    }

    @Test
    public void _7177_様式第六の七を指定した場合_getコードは_7177を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7177_様式第六の七.getコード(), is(new RString("7177")));
    }

    @Test
    public void _7181_様式第八を指定した場合_getコードは_7181を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7181_様式第八.getコード(), is(new RString("7181")));
    }

    @Test
    public void _7182_様式第八を指定した場合_getコードは_7182を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7182_様式第八.getコード(), is(new RString("7182")));
    }

    @Test
    public void _7183_様式第八を指定した場合_getコードは_7183を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7183_様式第八.getコード(), is(new RString("7183")));
    }

    @Test
    public void _7191_様式第九を指定した場合_getコードは_7191を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7191_様式第九.getコード(), is(new RString("7191")));
    }

    @Test
    public void _7192_様式第九を指定した場合_getコードは_7192を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7192_様式第九.getコード(), is(new RString("7192")));
    }

    @Test
    public void _7193_様式第九を指定した場合_getコードは_7193を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7193_様式第九.getコード(), is(new RString("7193")));
    }

    @Test
    public void _7194_様式第九を指定した場合_getコードは_7194を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7194_様式第九.getコード(), is(new RString("7194")));
    }

    @Test
    public void _7195_様式第九を指定した場合_getコードは_7195を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7195_様式第九.getコード(), is(new RString("7195")));
    }

    @Test
    public void _71A1_様式第十を指定した場合_getコードは_71A1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A1_様式第十.getコード(), is(new RString("71A1")));
    }

    @Test
    public void _71A2_様式第十を指定した場合_getコードは_71A2を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A2_様式第十.getコード(), is(new RString("71A2")));
    }

    @Test
    public void _71A3_様式第十を指定した場合_getコードは_71A3を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A3_様式第十.getコード(), is(new RString("71A3")));
    }

    @Test
    public void _71P1_予防サービス_生活支援サービスを指定した場合_getコードは_71P1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71P1_予防サービス_生活支援サービス.getコード(), is(new RString("71P1")));
    }

    @Test
    public void _71R1_様式第二の三を指定した場合_getコードは_71R1を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71R1_様式第二の三.getコード(), is(new RString("71R1")));
    }

    @Test
    public void _8121_様式第七を指定した場合_getコードは_8121を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8121_様式第七.getコード(), is(new RString("8121")));
    }

    @Test
    public void _8122_様式第七を指定した場合_getコードは_8122を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8122_様式第七.getコード(), is(new RString("8122")));
    }

    @Test
    public void _8123_様式第七の二を指定した場合_getコードは_8123を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8123_様式第七の二.getコード(), is(new RString("8123")));
    }

    @Test
    public void _8124_様式第七を指定した場合_getコードは_8124を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8124_様式第七.getコード(), is(new RString("8124")));
    }

    @Test
    public void _8125_様式第七の二を指定した場合_getコードは_8125を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8125_様式第七の二.getコード(), is(new RString("8125")));
    }

    @Test
    public void _8161_ケアマネジメントを指定した場合_getコードは_8161を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8161_ケアマネジメント.getコード(), is(new RString("8161")));
    }

    @Test
    public void _8171_様式第七の三を指定した場合_getコードは_8171を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8171_様式第七の三.getコード(), is(new RString("8171")));
    }

    @Test
    public void _3411_高額介護給付費を指定した場合_getコードは_3411を返す() {
        assertThat(KyufuJissekiYoshikiKubun._3411_高額介護給付費.getコード(), is(new RString("3411")));
    }

    @Test
    public void 現物_高額介護給付費を指定した場合_get名称は_現物_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun.現物_高額介護給付費.get名称(), is(new RString("現物_高額介護給付費")));
    }

    @Test
    public void _2131_様式第二を指定した場合_get名称は_償還_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2131_様式第二.get名称(), is(new RString("償還_様式第二")));
    }

    @Test
    public void _2132_様式第二の二を指定した場合_get名称は_償還_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2132_様式第二の二.get名称(), is(new RString("償還_様式第二の二")));
    }

    @Test
    public void _2141_様式第三を指定した場合_get名称は_償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2141_様式第三.get名称(), is(new RString("償還_様式第三")));
    }

    @Test
    public void _2142_様式第三を指定した場合_get名称は_償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2142_様式第三.get名称(), is(new RString("償還_様式第三")));
    }

    @Test
    public void _2143_様式第三を指定した場合_get名称は_償還_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2143_様式第三.get名称(), is(new RString("償還_様式第三")));
    }

    @Test
    public void _2144_様式第三の二を指定した場合_get名称は_償還_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2144_様式第三の二.get名称(), is(new RString("償還_様式第三の二")));
    }

    @Test
    public void _2151_様式第四を指定した場合_get名称は_償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2151_様式第四.get名称(), is(new RString("償還_様式第四")));
    }

    @Test
    public void _2152_様式第四を指定した場合_get名称は_償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2152_様式第四.get名称(), is(new RString("償還_様式第四")));
    }

    @Test
    public void _2153_様式第四を指定した場合_get名称は_償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2153_様式第四.get名称(), is(new RString("償還_様式第四")));
    }

    @Test
    public void _2154_様式第四の二を指定した場合_get名称は_償還_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2154_様式第四の二.get名称(), is(new RString("償還_様式第四の二")));
    }

    @Test
    public void _2155_様式第四を指定した場合_get名称は_償還_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2155_様式第四.get名称(), is(new RString("償還_様式第四")));
    }

    @Test
    public void _2156_様式第四の二を指定した場合_get名称は_償還_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2156_様式第四の二.get名称(), is(new RString("償還_様式第四の二")));
    }

    @Test
    public void _2161_様式第五を指定した場合_get名称は_償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2161_様式第五.get名称(), is(new RString("償還_様式第五")));
    }

    @Test
    public void _2162_様式第五を指定した場合_get名称は_償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2162_様式第五.get名称(), is(new RString("償還_様式第五")));
    }

    @Test
    public void _2163_様式第五を指定した場合_get名称は_償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2163_様式第五.get名称(), is(new RString("償還_様式第五")));
    }

    @Test
    public void _2164_様式第五を指定した場合_get名称は_償還_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2164_様式第五.get名称(), is(new RString("償還_様式第五")));
    }

    @Test
    public void _2165_様式第五の二を指定した場合_get名称は_償還_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2165_様式第五の二.get名称(), is(new RString("償還_様式第五の二")));
    }

    @Test
    public void _2171_様式第六を指定した場合_get名称は_償還_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2171_様式第六.get名称(), is(new RString("償還_様式第六")));
    }

    @Test
    public void _2172_様式第六の二を指定した場合_get名称は_償還_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2172_様式第六の二.get名称(), is(new RString("償還_様式第六の二")));
    }

    @Test
    public void _2173_様式第六の三を指定した場合_get名称は_償還_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2173_様式第六の三.get名称(), is(new RString("償還_様式第六の三")));
    }

    @Test
    public void _2174_様式第六の四を指定した場合_get名称は_償還_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2174_様式第六の四.get名称(), is(new RString("償還_様式第六の四")));
    }

    @Test
    public void _2175_様式第六の五を指定した場合_get名称は_償還_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2175_様式第六の五.get名称(), is(new RString("償還_様式第六の五")));
    }

    @Test
    public void _2176_様式第六の六を指定した場合_get名称は_償還_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2176_様式第六の六.get名称(), is(new RString("償還_様式第六の六")));
    }

    @Test
    public void _2177_様式第六の七を指定した場合_get名称は_償還_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2177_様式第六の七.get名称(), is(new RString("償還_様式第六の七")));
    }

    @Test
    public void _2181_様式第八を指定した場合_get名称は_償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2181_様式第八.get名称(), is(new RString("償還_様式第八")));
    }

    @Test
    public void _2182_様式第八を指定した場合_get名称は_償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2182_様式第八.get名称(), is(new RString("償還_様式第八")));
    }

    @Test
    public void _2183_様式第八を指定した場合_get名称は_償還_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2183_様式第八.get名称(), is(new RString("償還_様式第八")));
    }

    @Test
    public void _2191_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2191_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _2192_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2192_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _2193_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2193_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _2194_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2194_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _2195_様式第九を指定した場合_get名称は_償還_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._2195_様式第九.get名称(), is(new RString("償還_様式第九")));
    }

    @Test
    public void _21A1_様式第十を指定した場合_get名称は_償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A1_様式第十.get名称(), is(new RString("償還_様式第十")));
    }

    @Test
    public void _21A2_様式第十を指定した場合_get名称は_償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A2_様式第十.get名称(), is(new RString("償還_様式第十")));
    }

    @Test
    public void _21A3_様式第十を指定した場合_get名称は_償還_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21A3_様式第十.get名称(), is(new RString("償還_様式第十")));
    }

    @Test
    public void _21B1_様式第七を指定した場合_get名称は_償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B1_様式第七.get名称(), is(new RString("償還_様式第七")));
    }

    @Test
    public void _21B2_様式第七を指定した場合_get名称は_償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B2_様式第七.get名称(), is(new RString("償還_様式第七")));
    }

    @Test
    public void _21B3_様式第七の二を指定した場合_get名称は_償還_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B3_様式第七の二.get名称(), is(new RString("償還_様式第七の二")));
    }

    @Test
    public void _21B4_様式第七を指定した場合_get名称は_償還_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B4_様式第七.get名称(), is(new RString("償還_様式第七")));
    }

    @Test
    public void _21B5_様式第七の二を指定した場合_get名称は_償還_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21B5_様式第七の二.get名称(), is(new RString("償還_様式第七の二")));
    }

    @Test
    public void _21C1_福祉用具販売費を指定した場合_get名称は_償還_福祉用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21C1_福祉用具販売費.get名称(), is(new RString("償還_福祉用具販売費")));
    }

    @Test
    public void _21C2_予防用具販売費を指定した場合_get名称は_償還_予防用具販売費を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21C2_予防用具販売費.get名称(), is(new RString("償還_予防用具販売費")));
    }

    @Test
    public void _21D1_住宅改修費を指定した場合_get名称は_償還_住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21D1_住宅改修費.get名称(), is(new RString("償還_住宅改修費")));
    }

    @Test
    public void _21D2_予防住宅改修費を指定した場合_get名称は_償還_予防住宅改修費を返す() {
        assertThat(KyufuJissekiYoshikiKubun._21D2_予防住宅改修費.get名称(), is(new RString("償還_予防住宅改修費")));
    }

    @Test
    public void _7131_様式第二を指定した場合_get名称は_現物_様式第二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7131_様式第二.get名称(), is(new RString("現物_様式第二")));
    }

    @Test
    public void _7132_様式第二の二を指定した場合_get名称は_現物_様式第二の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7132_様式第二の二.get名称(), is(new RString("現物_様式第二の二")));
    }

    @Test
    public void _7141_様式第三を指定した場合_get名称は_現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7141_様式第三.get名称(), is(new RString("現物_様式第三")));
    }

    @Test
    public void _7142_様式第三を指定した場合_get名称は_現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7142_様式第三.get名称(), is(new RString("現物_様式第三")));
    }

    @Test
    public void _7143_様式第三を指定した場合_get名称は_現物_様式第三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7143_様式第三.get名称(), is(new RString("現物_様式第三")));
    }

    @Test
    public void _7144_様式第三の二を指定した場合_get名称は_現物_様式第三の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7144_様式第三の二.get名称(), is(new RString("現物_様式第三の二")));
    }

    @Test
    public void _7151_様式第四を指定した場合_get名称は_現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7151_様式第四.get名称(), is(new RString("現物_様式第四")));
    }

    @Test
    public void _7152_様式第四を指定した場合_get名称は_現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7152_様式第四.get名称(), is(new RString("現物_様式第四")));
    }

    @Test
    public void _7153_様式第四を指定した場合_get名称は_現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7153_様式第四.get名称(), is(new RString("現物_様式第四")));
    }

    @Test
    public void _7154_様式第四の二を指定した場合_get名称は_現物_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7154_様式第四の二.get名称(), is(new RString("現物_様式第四の二")));
    }

    @Test
    public void _7155_様式第四を指定した場合_get名称は_現物_様式第四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7155_様式第四.get名称(), is(new RString("現物_様式第四")));
    }

    @Test
    public void _7156_様式第四の二を指定した場合_get名称は_現物_様式第四の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7156_様式第四の二.get名称(), is(new RString("現物_様式第四の二")));
    }

    @Test
    public void _7161_様式第五を指定した場合_get名称は_現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7161_様式第五.get名称(), is(new RString("現物_様式第五")));
    }

    @Test
    public void _7162_様式第五を指定した場合_get名称は_現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7162_様式第五.get名称(), is(new RString("現物_様式第五")));
    }

    @Test
    public void _7163_様式第五を指定した場合_get名称は_現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7163_様式第五.get名称(), is(new RString("現物_様式第五")));
    }

    @Test
    public void _7164_様式第五を指定した場合_get名称は_現物_様式第五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7164_様式第五.get名称(), is(new RString("現物_様式第五")));
    }

    @Test
    public void _7165_様式第五の二を指定した場合_get名称は_現物_様式第五の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7165_様式第五の二.get名称(), is(new RString("現物_様式第五の二")));
    }

    @Test
    public void _7171_様式第六を指定した場合_get名称は_現物_様式第六を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7171_様式第六.get名称(), is(new RString("現物_様式第六")));
    }

    @Test
    public void _7172_様式第六の二を指定した場合_get名称は_現物_様式第六の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7172_様式第六の二.get名称(), is(new RString("現物_様式第六の二")));
    }

    @Test
    public void _7173_様式第六の三を指定した場合_get名称は_現物_様式第六の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7173_様式第六の三.get名称(), is(new RString("現物_様式第六の三")));
    }

    @Test
    public void _7174_様式第六の四を指定した場合_get名称は_現物_様式第六の四を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7174_様式第六の四.get名称(), is(new RString("現物_様式第六の四")));
    }

    @Test
    public void _7175_様式第六の五を指定した場合_get名称は_現物_様式第六の五を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7175_様式第六の五.get名称(), is(new RString("現物_様式第六の五")));
    }

    @Test
    public void _7176_様式第六の六を指定した場合_get名称は_現物_様式第六の六を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7176_様式第六の六.get名称(), is(new RString("現物_様式第六の六")));
    }

    @Test
    public void _7177_様式第六の七を指定した場合_get名称は_現物_様式第六の七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7177_様式第六の七.get名称(), is(new RString("現物_様式第六の七")));
    }

    @Test
    public void _7181_様式第八を指定した場合_get名称は_現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7181_様式第八.get名称(), is(new RString("現物_様式第八")));
    }

    @Test
    public void _7182_様式第八を指定した場合_get名称は_現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7182_様式第八.get名称(), is(new RString("現物_様式第八")));
    }

    @Test
    public void _7183_様式第八を指定した場合_get名称は_現物_様式第八を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7183_様式第八.get名称(), is(new RString("現物_様式第八")));
    }

    @Test
    public void _7191_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7191_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _7192_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7192_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _7193_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7193_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _7194_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7194_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _7195_様式第九を指定した場合_get名称は_現物_様式第九を返す() {
        assertThat(KyufuJissekiYoshikiKubun._7195_様式第九.get名称(), is(new RString("現物_様式第九")));
    }

    @Test
    public void _71A1_様式第十を指定した場合_get名称は_現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A1_様式第十.get名称(), is(new RString("現物_様式第十")));
    }

    @Test
    public void _71A2_様式第十を指定した場合_get名称は_現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A2_様式第十.get名称(), is(new RString("現物_様式第十")));
    }

    @Test
    public void _71A3_様式第十を指定した場合_get名称は_現物_様式第十を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71A3_様式第十.get名称(), is(new RString("現物_様式第十")));
    }

    @Test
    public void _71P1_予防サービス_生活支援サービスを指定した場合_get名称は_現物_予防サービス_生活支援サービスを返す() {
        assertThat(KyufuJissekiYoshikiKubun._71P1_予防サービス_生活支援サービス.get名称(), is(new RString("現物_予防サービス・生活支援サービス")));
    }

    @Test
    public void _71R1_様式第二の三を指定した場合_get名称は_現物_様式第二の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._71R1_様式第二の三.get名称(), is(new RString("現物_様式第二の三")));
    }

    @Test
    public void _8121_様式第七を指定した場合_get名称は_現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8121_様式第七.get名称(), is(new RString("現物_様式第七")));
    }

    @Test
    public void _8122_様式第七を指定した場合_get名称は_現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8122_様式第七.get名称(), is(new RString("現物_様式第七")));
    }

    @Test
    public void _8123_様式第七の二を指定した場合_get名称は_現物_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8123_様式第七の二.get名称(), is(new RString("現物_様式第七の二")));
    }

    @Test
    public void _8124_様式第七を指定した場合_get名称は_現物_様式第七を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8124_様式第七.get名称(), is(new RString("現物_様式第七")));
    }

    @Test
    public void _8125_様式第七の二を指定した場合_get名称は_現物_様式第七の二を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8125_様式第七の二.get名称(), is(new RString("現物_様式第七の二")));
    }

    @Test
    public void _8161_ケアマネジメントを指定した場合_get名称は_現物_ケアマネジメントを返す() {
        assertThat(KyufuJissekiYoshikiKubun._8161_ケアマネジメント.get名称(), is(new RString("現物_ケアマネジメント")));
    }

    @Test
    public void _8171_様式第七の三を指定した場合_get名称は_現物_様式第七の三を返す() {
        assertThat(KyufuJissekiYoshikiKubun._8171_様式第七の三.get名称(), is(new RString("現物_様式第七の三")));
    }

    @Test
    public void _3411_高額介護給付費を指定した場合_get名称は_償還_高額介護給付費を返す() {
        assertThat(KyufuJissekiYoshikiKubun._3411_高額介護給付費.get名称(), is(new RString("償還_高額介護給付費")));
    }

}
