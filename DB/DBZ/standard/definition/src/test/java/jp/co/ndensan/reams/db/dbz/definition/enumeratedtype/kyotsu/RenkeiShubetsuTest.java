package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 連携種別のテストクラスです。
 * 
 * @author LDNS 
 */
public class RenkeiShubetsuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        RenkeiShubetsu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        RenkeiShubetsu.toValue(new RString("99999"));
    }

    @Test
    public void 引数にA1を指定した場合_toValueは_住民情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("A1")), is(RenkeiShubetsu.住民情報連動));
    }

    @Test
    public void 引数にB1を指定した場合_toValueは_介護情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("B1")), is(RenkeiShubetsu.介護情報連動));
    }

    @Test
    public void 引数にC1を指定した場合_toValueは_所得情報連動_当初を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("C1")), is(RenkeiShubetsu.所得情報連動_当初));
    }

    @Test
    public void 引数にC2を指定した場合_toValueは_所得情報連動_更正を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("C2")), is(RenkeiShubetsu.所得情報連動_更正));
    }

    @Test
    public void 引数にD1を指定した場合_toValueは_納付情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("D1")), is(RenkeiShubetsu.納付情報連動));
    }

    @Test
    public void 引数にE1を指定した場合_toValueは_特別徴収対象者情報を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("E1")), is(RenkeiShubetsu.特別徴収対象者情報));
    }

    @Test
    public void 引数にE2を指定した場合_toValueは_特別徴収依頼処理結果情報を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("E2")), is(RenkeiShubetsu.特別徴収依頼処理結果情報));
    }

    @Test
    public void 引数にE3を指定した場合_toValueは_特別徴収結果情報を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("E3")), is(RenkeiShubetsu.特別徴収結果情報));
    }

    @Test
    public void 引数にF1を指定した場合_toValueは_特別徴収依頼情報を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("F1")), is(RenkeiShubetsu.特別徴収依頼情報));
    }

    @Test
    public void 引数にF2を指定した場合_toValueは_特別徴収各種異動情報を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("F2")), is(RenkeiShubetsu.特別徴収各種異動情報));
    }

    @Test
    public void 引数にF3を指定した場合_toValueは_特徴依頼データを返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("F3")), is(RenkeiShubetsu.特徴依頼データ));
    }

    @Test
    public void 引数にG1を指定した場合_toValueは_後期高齢者情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("G1")), is(RenkeiShubetsu.後期高齢者情報連動));
    }

    @Test
    public void 引数にH1を指定した場合_toValueは_国保情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("H1")), is(RenkeiShubetsu.国保情報連動));
    }

    @Test
    public void 引数にI1を指定した場合_toValueは_介護資格情報連動を返す() {
        assertThat(RenkeiShubetsu.toValue(new RString("I1")), is(RenkeiShubetsu.介護資格情報連動));
    }

    @Test
    public void 住民情報連動を指定した場合_getコードは_A1を返す() {
        assertThat(RenkeiShubetsu.住民情報連動.getコード(), is(new RString("A1")));
    }

    @Test
    public void 介護情報連動を指定した場合_getコードは_B1を返す() {
        assertThat(RenkeiShubetsu.介護情報連動.getコード(), is(new RString("B1")));
    }

    @Test
    public void 所得情報連動_当初を指定した場合_getコードは_C1を返す() {
        assertThat(RenkeiShubetsu.所得情報連動_当初.getコード(), is(new RString("C1")));
    }

    @Test
    public void 所得情報連動_更正を指定した場合_getコードは_C2を返す() {
        assertThat(RenkeiShubetsu.所得情報連動_更正.getコード(), is(new RString("C2")));
    }

    @Test
    public void 納付情報連動を指定した場合_getコードは_D1を返す() {
        assertThat(RenkeiShubetsu.納付情報連動.getコード(), is(new RString("D1")));
    }

    @Test
    public void 特別徴収対象者情報を指定した場合_getコードは_E1を返す() {
        assertThat(RenkeiShubetsu.特別徴収対象者情報.getコード(), is(new RString("E1")));
    }

    @Test
    public void 特別徴収依頼処理結果情報を指定した場合_getコードは_E2を返す() {
        assertThat(RenkeiShubetsu.特別徴収依頼処理結果情報.getコード(), is(new RString("E2")));
    }

    @Test
    public void 特別徴収結果情報を指定した場合_getコードは_E3を返す() {
        assertThat(RenkeiShubetsu.特別徴収結果情報.getコード(), is(new RString("E3")));
    }

    @Test
    public void 特別徴収依頼情報を指定した場合_getコードは_F1を返す() {
        assertThat(RenkeiShubetsu.特別徴収依頼情報.getコード(), is(new RString("F1")));
    }

    @Test
    public void 特別徴収各種異動情報を指定した場合_getコードは_F2を返す() {
        assertThat(RenkeiShubetsu.特別徴収各種異動情報.getコード(), is(new RString("F2")));
    }

    @Test
    public void 特徴依頼データを指定した場合_getコードは_F3を返す() {
        assertThat(RenkeiShubetsu.特徴依頼データ.getコード(), is(new RString("F3")));
    }

    @Test
    public void 後期高齢者情報連動を指定した場合_getコードは_G1を返す() {
        assertThat(RenkeiShubetsu.後期高齢者情報連動.getコード(), is(new RString("G1")));
    }

    @Test
    public void 国保情報連動を指定した場合_getコードは_H1を返す() {
        assertThat(RenkeiShubetsu.国保情報連動.getコード(), is(new RString("H1")));
    }

    @Test
    public void 介護資格情報連動を指定した場合_getコードは_I1を返す() {
        assertThat(RenkeiShubetsu.介護資格情報連動.getコード(), is(new RString("I1")));
    }

    @Test
    public void 住民情報連動を指定した場合_get名称は_住民情報連動を返す() {
        assertThat(RenkeiShubetsu.住民情報連動.get名称(), is(new RString("住民情報連動")));
    }

    @Test
    public void 介護情報連動を指定した場合_get名称は_介護情報連動を返す() {
        assertThat(RenkeiShubetsu.介護情報連動.get名称(), is(new RString("介護情報連動")));
    }

    @Test
    public void 所得情報連動_当初を指定した場合_get名称は_所得情報連動_当初を返す() {
        assertThat(RenkeiShubetsu.所得情報連動_当初.get名称(), is(new RString("所得情報連動（当初）")));
    }

    @Test
    public void 所得情報連動_更正を指定した場合_get名称は_所得情報連動_更正を返す() {
        assertThat(RenkeiShubetsu.所得情報連動_更正.get名称(), is(new RString("所得情報連動（更正）")));
    }

    @Test
    public void 納付情報連動を指定した場合_get名称は_納付情報連動を返す() {
        assertThat(RenkeiShubetsu.納付情報連動.get名称(), is(new RString("納付情報連動")));
    }

    @Test
    public void 特別徴収対象者情報を指定した場合_get名称は_特別徴収対象者情報を返す() {
        assertThat(RenkeiShubetsu.特別徴収対象者情報.get名称(), is(new RString("特別徴収対象者情報")));
    }

    @Test
    public void 特別徴収依頼処理結果情報を指定した場合_get名称は_特別徴収依頼処理結果情報を返す() {
        assertThat(RenkeiShubetsu.特別徴収依頼処理結果情報.get名称(), is(new RString("特別徴収依頼処理結果情報")));
    }

    @Test
    public void 特別徴収結果情報を指定した場合_get名称は_特別徴収結果情報を返す() {
        assertThat(RenkeiShubetsu.特別徴収結果情報.get名称(), is(new RString("特別徴収結果情報")));
    }

    @Test
    public void 特別徴収依頼情報を指定した場合_get名称は_特別徴収依頼情報を返す() {
        assertThat(RenkeiShubetsu.特別徴収依頼情報.get名称(), is(new RString("特別徴収依頼情報")));
    }

    @Test
    public void 特別徴収各種異動情報を指定した場合_get名称は_特別徴収各種異動情報を返す() {
        assertThat(RenkeiShubetsu.特別徴収各種異動情報.get名称(), is(new RString("特別徴収各種異動情報")));
    }

    @Test
    public void 特徴依頼データを指定した場合_get名称は_特徴依頼データを返す() {
        assertThat(RenkeiShubetsu.特徴依頼データ.get名称(), is(new RString("特徴依頼データ")));
    }

    @Test
    public void 後期高齢者情報連動を指定した場合_get名称は_後期高齢者情報連動を返す() {
        assertThat(RenkeiShubetsu.後期高齢者情報連動.get名称(), is(new RString("後期高齢者情報連動")));
    }

    @Test
    public void 国保情報連動を指定した場合_get名称は_国保情報連動を返す() {
        assertThat(RenkeiShubetsu.国保情報連動.get名称(), is(new RString("国保情報連動")));
    }

    @Test
    public void 介護資格情報連動を指定した場合_get名称は_介護資格情報連動を返す() {
        assertThat(RenkeiShubetsu.介護資格情報連動.get名称(), is(new RString("介護資格情報連動")));
    }

}
