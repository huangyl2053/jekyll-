package jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 特定疾病コードのテストクラスです。
 *
 * @author LDNS
 */
public class TokuteiShippeiTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        TokuteiShippei.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        TokuteiShippei.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_筋萎縮性側索硬化症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("01")), is(TokuteiShippei.筋萎縮性側索硬化症));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_後縦靭帯骨化症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("02")), is(TokuteiShippei.後縦靭帯骨化症));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_骨折を伴う骨粗鬆症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("03")), is(TokuteiShippei.骨折を伴う骨粗鬆症));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_多系統萎縮症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("04")), is(TokuteiShippei.多系統萎縮症));
    }

    @Test
    public void 引数に05を指定した場合_toValueは_初老期における認知症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("05")), is(TokuteiShippei.初老期における認知症));
    }

    @Test
    public void 引数に06を指定した場合_toValueは_脊髄小脳変性症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("06")), is(TokuteiShippei.脊髄小脳変性症));
    }

    @Test
    public void 引数に07を指定した場合_toValueは_脊柱管狭窄症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("07")), is(TokuteiShippei.脊柱管狭窄症));
    }

    @Test
    public void 引数に08を指定した場合_toValueは_早老症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("08")), is(TokuteiShippei.早老症));
    }

    @Test
    public void 引数に09を指定した場合_toValueは_糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("09")), is(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症));
    }

    @Test
    public void 引数に10を指定した場合_toValueは_脳血管疾患を返す() {
        assertThat(TokuteiShippei.toValue(new RString("10")), is(TokuteiShippei.脳血管疾患));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_パーキンソン病関連疾患を返す() {
        assertThat(TokuteiShippei.toValue(new RString("11")), is(TokuteiShippei.パーキンソン病関連疾患));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_閉塞性動脈硬化症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("12")), is(TokuteiShippei.閉塞性動脈硬化症));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_関節リウマチを返す() {
        assertThat(TokuteiShippei.toValue(new RString("13")), is(TokuteiShippei.関節リウマチ));
    }

    @Test
    public void 引数に14を指定した場合_toValueは_慢性閉塞性肺疾患を返す() {
        assertThat(TokuteiShippei.toValue(new RString("14")), is(TokuteiShippei.慢性閉塞性肺疾患));
    }

    @Test
    public void 引数に15を指定した場合_toValueは_両側の膝関節又は股関節に著しい変形を伴う変形性関節症を返す() {
        assertThat(TokuteiShippei.toValue(new RString("15")), is(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症));
    }

    @Test
    public void 引数に16を指定した場合_toValueは_がん_末期を返す() {
        assertThat(TokuteiShippei.toValue(new RString("16")), is(TokuteiShippei.がん_末期));
    }

    @Test
    public void 引数に99を指定した場合_toValueは_特定疾病以外を返す() {
        assertThat(TokuteiShippei.toValue(new RString("99")), is(TokuteiShippei.特定疾病以外));
    }

    @Test
    public void 筋萎縮性側索硬化症を指定した場合_getコードは_01を返す() {
        assertThat(TokuteiShippei.筋萎縮性側索硬化症.getコード(), is(new RString("01")));
    }

    @Test
    public void 後縦靭帯骨化症を指定した場合_getコードは_02を返す() {
        assertThat(TokuteiShippei.後縦靭帯骨化症.getコード(), is(new RString("02")));
    }

    @Test
    public void 骨折を伴う骨粗鬆症を指定した場合_getコードは_03を返す() {
        assertThat(TokuteiShippei.骨折を伴う骨粗鬆症.getコード(), is(new RString("03")));
    }

    @Test
    public void 多系統萎縮症を指定した場合_getコードは_04を返す() {
        assertThat(TokuteiShippei.多系統萎縮症.getコード(), is(new RString("04")));
    }

    @Test
    public void 初老期における認知症を指定した場合_getコードは_05を返す() {
        assertThat(TokuteiShippei.初老期における認知症.getコード(), is(new RString("05")));
    }

    @Test
    public void 脊髄小脳変性症を指定した場合_getコードは_06を返す() {
        assertThat(TokuteiShippei.脊髄小脳変性症.getコード(), is(new RString("06")));
    }

    @Test
    public void 脊柱管狭窄症を指定した場合_getコードは_07を返す() {
        assertThat(TokuteiShippei.脊柱管狭窄症.getコード(), is(new RString("07")));
    }

    @Test
    public void 早老症を指定した場合_getコードは_08を返す() {
        assertThat(TokuteiShippei.早老症.getコード(), is(new RString("08")));
    }

    @Test
    public void 糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症を指定した場合_getコードは_09を返す() {
        assertThat(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.getコード(), is(new RString("09")));
    }

    @Test
    public void 脳血管疾患を指定した場合_getコードは_10を返す() {
        assertThat(TokuteiShippei.脳血管疾患.getコード(), is(new RString("10")));
    }

    @Test
    public void パーキンソン病関連疾患を指定した場合_getコードは_11を返す() {
        assertThat(TokuteiShippei.パーキンソン病関連疾患.getコード(), is(new RString("11")));
    }

    @Test
    public void 閉塞性動脈硬化症を指定した場合_getコードは_12を返す() {
        assertThat(TokuteiShippei.閉塞性動脈硬化症.getコード(), is(new RString("12")));
    }

    @Test
    public void 関節リウマチを指定した場合_getコードは_13を返す() {
        assertThat(TokuteiShippei.関節リウマチ.getコード(), is(new RString("13")));
    }

    @Test
    public void 慢性閉塞性肺疾患を指定した場合_getコードは_14を返す() {
        assertThat(TokuteiShippei.慢性閉塞性肺疾患.getコード(), is(new RString("14")));
    }

    @Test
    public void 両側の膝関節又は股関節に著しい変形を伴う変形性関節症を指定した場合_getコードは_15を返す() {
        assertThat(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.getコード(), is(new RString("15")));
    }

    @Test
    public void がん_末期を指定した場合_getコードは_16を返す() {
        assertThat(TokuteiShippei.がん_末期.getコード(), is(new RString("16")));
    }

    @Test
    public void 特定疾病以外を指定した場合_getコードは_99を返す() {
        assertThat(TokuteiShippei.特定疾病以外.getコード(), is(new RString("99")));
    }

    @Test
    public void 筋萎縮性側索硬化症を指定した場合_get名称は_筋萎縮性側索硬化症を返す() {
        assertThat(TokuteiShippei.筋萎縮性側索硬化症.get名称(), is(new RString("筋萎縮性側索硬化症")));
    }

    @Test
    public void 後縦靭帯骨化症を指定した場合_get名称は_後縦靭帯骨化症を返す() {
        assertThat(TokuteiShippei.後縦靭帯骨化症.get名称(), is(new RString("後縦靭帯骨化症")));
    }

    @Test
    public void 骨折を伴う骨粗鬆症を指定した場合_get名称は_骨折を伴う骨粗鬆症を返す() {
        assertThat(TokuteiShippei.骨折を伴う骨粗鬆症.get名称(), is(new RString("骨折を伴う骨粗鬆症")));
    }

    @Test
    public void 多系統萎縮症を指定した場合_get名称は_多系統萎縮症を返す() {
        assertThat(TokuteiShippei.多系統萎縮症.get名称(), is(new RString("多系統萎縮症")));
    }

    @Test
    public void 初老期における認知症を指定した場合_get名称は_初老期における認知症を返す() {
        assertThat(TokuteiShippei.初老期における認知症.get名称(), is(new RString("初老期における認知症")));
    }

    @Test
    public void 脊髄小脳変性症を指定した場合_get名称は_脊髄小脳変性症を返す() {
        assertThat(TokuteiShippei.脊髄小脳変性症.get名称(), is(new RString("脊髄小脳変性症")));
    }

    @Test
    public void 脊柱管狭窄症を指定した場合_get名称は_脊柱管狭窄症を返す() {
        assertThat(TokuteiShippei.脊柱管狭窄症.get名称(), is(new RString("脊柱管狭窄症")));
    }

    @Test
    public void 早老症を指定した場合_get名称は_早老症を返す() {
        assertThat(TokuteiShippei.早老症.get名称(), is(new RString("早老症")));
    }

    @Test
    public void 糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症を指定した場合_get名称は_糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症を返す() {
        assertThat(TokuteiShippei.糖尿病性神経障害_糖尿病性腎症及び糖尿病性網膜症.get名称(), is(new RString("糖尿病性神経障害、糖尿病性腎症及び糖尿病性網膜症")));
    }

    @Test
    public void 脳血管疾患を指定した場合_get名称は_脳血管疾患を返す() {
        assertThat(TokuteiShippei.脳血管疾患.get名称(), is(new RString("脳血管疾患")));
    }

    @Test
    public void パーキンソン病関連疾患を指定した場合_get名称は_パーキンソン病関連疾患を返す() {
        assertThat(TokuteiShippei.パーキンソン病関連疾患.get名称(), is(new RString("パーキンソン病関連疾患")));
    }

    @Test
    public void 閉塞性動脈硬化症を指定した場合_get名称は_閉塞性動脈硬化症を返す() {
        assertThat(TokuteiShippei.閉塞性動脈硬化症.get名称(), is(new RString("閉塞性動脈硬化症")));
    }

    @Test
    public void 関節リウマチを指定した場合_get名称は_関節リウマチを返す() {
        assertThat(TokuteiShippei.関節リウマチ.get名称(), is(new RString("関節リウマチ")));
    }

    @Test
    public void 慢性閉塞性肺疾患を指定した場合_get名称は_慢性閉塞性肺疾患を返す() {
        assertThat(TokuteiShippei.慢性閉塞性肺疾患.get名称(), is(new RString("慢性閉塞性肺疾患")));
    }

    @Test
    public void 両側の膝関節又は股関節に著しい変形を伴う変形性関節症を指定した場合_get名称は_両側の膝関節又は股関節に著しい変形を伴う変形性関節症を返す() {
        assertThat(TokuteiShippei.両側の膝関節又は股関節に著しい変形を伴う変形性関節症.get名称(), is(new RString("両側の膝関節又は股関節に著しい変形を伴う変形性関節症")));
    }

    @Test
    public void がん_末期を指定した場合_get名称は_がん_末期を返す() {
        assertThat(TokuteiShippei.がん_末期.get名称(), is(new RString("がん（末期）")));
    }

    @Test
    public void 特定疾病以外を指定した場合_get名称は_特定疾病以外を返す() {
        assertThat(TokuteiShippei.特定疾病以外.get名称(), is(new RString("特定疾病以外")));
    }

}
