package jp.co.ndensan.reams.db.dbz.definition.core.fuseigoriyu;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * 不整合理由のテストクラスです。
 * 
 * @author LDNS 
 */
public class FuseigoRiyuTest extends DbzTestBase {

    @Test(expected = NullPointerException.class)
    public void 引数がNullである場合_toValueは_NullPointerExceptionが発生する() {
        FuseigoRiyu.toValue(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 引数に想定外の99999を指定した場合_toValueは_IllegalArgumentExceptionが発生する() {
        FuseigoRiyu.toValue(new RString("99999"));
    }

    @Test
    public void 引数に01を指定した場合_toValueは_西暦生年月日未登録を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("01")), is(FuseigoRiyu.西暦生年月日未登録));
    }

    @Test
    public void 引数に02を指定した場合_toValueは_住民記録情報が未登録を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("02")), is(FuseigoRiyu.住民記録情報が未登録));
    }

    @Test
    public void 引数に03を指定した場合_toValueは_年齢適用外登録者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("03")), is(FuseigoRiyu.年齢適用外登録者));
    }

    @Test
    public void 引数に04を指定した場合_toValueは_住民記録除票情報エラーを返す() {
        assertThat(FuseigoRiyu.toValue(new RString("04")), is(FuseigoRiyu.住民記録除票情報エラー));
    }

    @Test
    public void 引数に11を指定した場合_toValueは_資格管理情報未登録者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("11")), is(FuseigoRiyu.資格管理情報未登録者));
    }

    @Test
    public void 引数に12を指定した場合_toValueは_資格取得日_転入者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("12")), is(FuseigoRiyu.資格取得日_転入者));
    }

    @Test
    public void 引数に13を指定した場合_toValueは_資格取得日_年齢到達者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("13")), is(FuseigoRiyu.資格取得日_年齢到達者));
    }

    @Test
    public void 引数に21を指定した場合_toValueは_資格取得者_消除者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("21")), is(FuseigoRiyu.資格取得者_消除者));
    }

    @Test
    public void 引数に22を指定した場合_toValueは_資格取得者_転出者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("22")), is(FuseigoRiyu.資格取得者_転出者));
    }

    @Test
    public void 引数に23を指定した場合_toValueは_資格取得者_死亡者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("23")), is(FuseigoRiyu.資格取得者_死亡者));
    }

    @Test
    public void 引数に31を指定した場合_toValueは_資格喪失日_住基不一致を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("31")), is(FuseigoRiyu.資格喪失日_住基不一致));
    }

    @Test
    public void 引数に32を指定した場合_toValueは_資格喪失日_転出予定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("32")), is(FuseigoRiyu.資格喪失日_転出予定者));
    }

    @Test
    public void 引数に33を指定した場合_toValueは_資格喪失日_転出確定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("33")), is(FuseigoRiyu.資格喪失日_転出確定者));
    }

    @Test
    public void 引数に41を指定した場合_toValueは_資格変更日_転居を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("41")), is(FuseigoRiyu.資格変更日_転居));
    }

    @Test
    public void 引数に42を指定した場合_toValueは_資格変更者_１号被保険者到達を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("42")), is(FuseigoRiyu.資格変更者_１号被保険者到達));
    }

    @Test
    public void 引数に51を指定した場合_toValueは_他住所地特例適用日_転入者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("51")), is(FuseigoRiyu.他住所地特例適用日_転入者));
    }

    @Test
    public void 引数に52を指定した場合_toValueは_他住所地特例解除日_住基不一致を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("52")), is(FuseigoRiyu.他住所地特例解除日_住基不一致));
    }

    @Test
    public void 引数に53を指定した場合_toValueは_他住所地特例解除日_転出予定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("53")), is(FuseigoRiyu.他住所地特例解除日_転出予定者));
    }

    @Test
    public void 引数に54を指定した場合_toValueは_他住所地特例解除日_転出確定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("54")), is(FuseigoRiyu.他住所地特例解除日_転出確定者));
    }

    @Test
    public void 引数に61を指定した場合_toValueは_除外適用日_転入者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("61")), is(FuseigoRiyu.除外適用日_転入者));
    }

    @Test
    public void 引数に62を指定した場合_toValueは_除外解除日_住基不一致を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("62")), is(FuseigoRiyu.除外解除日_住基不一致));
    }

    @Test
    public void 引数に63を指定した場合_toValueは_除外解除日_転出予定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("63")), is(FuseigoRiyu.除外解除日_転出予定者));
    }

    @Test
    public void 引数に64を指定した場合_toValueは_除外解除日_転出確定者を返す() {
        assertThat(FuseigoRiyu.toValue(new RString("64")), is(FuseigoRiyu.除外解除日_転出確定者));
    }

    @Test
    public void 西暦生年月日未登録を指定した場合_getコードは_01を返す() {
        assertThat(FuseigoRiyu.西暦生年月日未登録.getコード(), is(new RString("01")));
    }

    @Test
    public void 住民記録情報が未登録を指定した場合_getコードは_02を返す() {
        assertThat(FuseigoRiyu.住民記録情報が未登録.getコード(), is(new RString("02")));
    }

    @Test
    public void 年齢適用外登録者を指定した場合_getコードは_03を返す() {
        assertThat(FuseigoRiyu.年齢適用外登録者.getコード(), is(new RString("03")));
    }

    @Test
    public void 住民記録除票情報エラーを指定した場合_getコードは_04を返す() {
        assertThat(FuseigoRiyu.住民記録除票情報エラー.getコード(), is(new RString("04")));
    }

    @Test
    public void 資格管理情報未登録者を指定した場合_getコードは_11を返す() {
        assertThat(FuseigoRiyu.資格管理情報未登録者.getコード(), is(new RString("11")));
    }

    @Test
    public void 資格取得日_転入者を指定した場合_getコードは_12を返す() {
        assertThat(FuseigoRiyu.資格取得日_転入者.getコード(), is(new RString("12")));
    }

    @Test
    public void 資格取得日_年齢到達者を指定した場合_getコードは_13を返す() {
        assertThat(FuseigoRiyu.資格取得日_年齢到達者.getコード(), is(new RString("13")));
    }

    @Test
    public void 資格取得者_消除者を指定した場合_getコードは_21を返す() {
        assertThat(FuseigoRiyu.資格取得者_消除者.getコード(), is(new RString("21")));
    }

    @Test
    public void 資格取得者_転出者を指定した場合_getコードは_22を返す() {
        assertThat(FuseigoRiyu.資格取得者_転出者.getコード(), is(new RString("22")));
    }

    @Test
    public void 資格取得者_死亡者を指定した場合_getコードは_23を返す() {
        assertThat(FuseigoRiyu.資格取得者_死亡者.getコード(), is(new RString("23")));
    }

    @Test
    public void 資格喪失日_住基不一致を指定した場合_getコードは_31を返す() {
        assertThat(FuseigoRiyu.資格喪失日_住基不一致.getコード(), is(new RString("31")));
    }

    @Test
    public void 資格喪失日_転出予定者を指定した場合_getコードは_32を返す() {
        assertThat(FuseigoRiyu.資格喪失日_転出予定者.getコード(), is(new RString("32")));
    }

    @Test
    public void 資格喪失日_転出確定者を指定した場合_getコードは_33を返す() {
        assertThat(FuseigoRiyu.資格喪失日_転出確定者.getコード(), is(new RString("33")));
    }

    @Test
    public void 資格変更日_転居を指定した場合_getコードは_41を返す() {
        assertThat(FuseigoRiyu.資格変更日_転居.getコード(), is(new RString("41")));
    }

    @Test
    public void 資格変更者_１号被保険者到達を指定した場合_getコードは_42を返す() {
        assertThat(FuseigoRiyu.資格変更者_１号被保険者到達.getコード(), is(new RString("42")));
    }

    @Test
    public void 他住所地特例適用日_転入者を指定した場合_getコードは_51を返す() {
        assertThat(FuseigoRiyu.他住所地特例適用日_転入者.getコード(), is(new RString("51")));
    }

    @Test
    public void 他住所地特例解除日_住基不一致を指定した場合_getコードは_52を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_住基不一致.getコード(), is(new RString("52")));
    }

    @Test
    public void 他住所地特例解除日_転出予定者を指定した場合_getコードは_53を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_転出予定者.getコード(), is(new RString("53")));
    }

    @Test
    public void 他住所地特例解除日_転出確定者を指定した場合_getコードは_54を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_転出確定者.getコード(), is(new RString("54")));
    }

    @Test
    public void 除外適用日_転入者を指定した場合_getコードは_61を返す() {
        assertThat(FuseigoRiyu.除外適用日_転入者.getコード(), is(new RString("61")));
    }

    @Test
    public void 除外解除日_住基不一致を指定した場合_getコードは_62を返す() {
        assertThat(FuseigoRiyu.除外解除日_住基不一致.getコード(), is(new RString("62")));
    }

    @Test
    public void 除外解除日_転出予定者を指定した場合_getコードは_63を返す() {
        assertThat(FuseigoRiyu.除外解除日_転出予定者.getコード(), is(new RString("63")));
    }

    @Test
    public void 除外解除日_転出確定者を指定した場合_getコードは_64を返す() {
        assertThat(FuseigoRiyu.除外解除日_転出確定者.getコード(), is(new RString("64")));
    }

    @Test
    public void 西暦生年月日未登録を指定した場合_get名称は_西暦生年月日未登録を返す() {
        assertThat(FuseigoRiyu.西暦生年月日未登録.get名称(), is(new RString("西暦生年月日未登録")));
    }

    @Test
    public void 住民記録情報が未登録を指定した場合_get名称は_住民記録情報が未登録を返す() {
        assertThat(FuseigoRiyu.住民記録情報が未登録.get名称(), is(new RString("住民記録情報が未登録")));
    }

    @Test
    public void 年齢適用外登録者を指定した場合_get名称は_年齢適用外登録者を返す() {
        assertThat(FuseigoRiyu.年齢適用外登録者.get名称(), is(new RString("年齢適用外登録者")));
    }

    @Test
    public void 住民記録除票情報エラーを指定した場合_get名称は_住民記録除票情報エラーを返す() {
        assertThat(FuseigoRiyu.住民記録除票情報エラー.get名称(), is(new RString("住民記録除票情報エラー")));
    }

    @Test
    public void 資格管理情報未登録者を指定した場合_get名称は_資格管理情報未登録者を返す() {
        assertThat(FuseigoRiyu.資格管理情報未登録者.get名称(), is(new RString("資格管理情報未登録者")));
    }

    @Test
    public void 資格取得日_転入者を指定した場合_get名称は_資格取得日_転入者を返す() {
        assertThat(FuseigoRiyu.資格取得日_転入者.get名称(), is(new RString("資格取得日（転入者）")));
    }

    @Test
    public void 資格取得日_年齢到達者を指定した場合_get名称は_資格取得日_年齢到達者を返す() {
        assertThat(FuseigoRiyu.資格取得日_年齢到達者.get名称(), is(new RString("資格取得日（年齢到達者）")));
    }

    @Test
    public void 資格取得者_消除者を指定した場合_get名称は_資格取得者_消除者を返す() {
        assertThat(FuseigoRiyu.資格取得者_消除者.get名称(), is(new RString("資格取得者（消除者）")));
    }

    @Test
    public void 資格取得者_転出者を指定した場合_get名称は_資格取得者_転出者を返す() {
        assertThat(FuseigoRiyu.資格取得者_転出者.get名称(), is(new RString("資格取得者（転出者）")));
    }

    @Test
    public void 資格取得者_死亡者を指定した場合_get名称は_資格取得者_死亡者を返す() {
        assertThat(FuseigoRiyu.資格取得者_死亡者.get名称(), is(new RString("資格取得者（死亡者）")));
    }

    @Test
    public void 資格喪失日_住基不一致を指定した場合_get名称は_資格喪失日_住基不一致を返す() {
        assertThat(FuseigoRiyu.資格喪失日_住基不一致.get名称(), is(new RString("資格喪失日（住基不一致）")));
    }

    @Test
    public void 資格喪失日_転出予定者を指定した場合_get名称は_資格喪失日_転出予定者を返す() {
        assertThat(FuseigoRiyu.資格喪失日_転出予定者.get名称(), is(new RString("資格喪失日（転出予定者）")));
    }

    @Test
    public void 資格喪失日_転出確定者を指定した場合_get名称は_資格喪失日_転出確定者を返す() {
        assertThat(FuseigoRiyu.資格喪失日_転出確定者.get名称(), is(new RString("資格喪失日（転出確定者）")));
    }

    @Test
    public void 資格変更日_転居を指定した場合_get名称は_資格変更日_転居を返す() {
        assertThat(FuseigoRiyu.資格変更日_転居.get名称(), is(new RString("資格変更日（転居）")));
    }

    @Test
    public void 資格変更者_１号被保険者到達を指定した場合_get名称は_資格変更者_１号被保険者到達を返す() {
        assertThat(FuseigoRiyu.資格変更者_１号被保険者到達.get名称(), is(new RString("資格変更者（１号被保険者到達）")));
    }

    @Test
    public void 他住所地特例適用日_転入者を指定した場合_get名称は_他住所地特例適用日_転入者を返す() {
        assertThat(FuseigoRiyu.他住所地特例適用日_転入者.get名称(), is(new RString("他住所地特例適用日（転入者）")));
    }

    @Test
    public void 他住所地特例解除日_住基不一致を指定した場合_get名称は_他住所地特例解除日_住基不一致を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_住基不一致.get名称(), is(new RString("他住所地特例解除日（住基不一致）")));
    }

    @Test
    public void 他住所地特例解除日_転出予定者を指定した場合_get名称は_他住所地特例解除日_転出予定者を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_転出予定者.get名称(), is(new RString("他住所地特例解除日（転出予定者）")));
    }

    @Test
    public void 他住所地特例解除日_転出確定者を指定した場合_get名称は_他住所地特例解除日_転出確定者を返す() {
        assertThat(FuseigoRiyu.他住所地特例解除日_転出確定者.get名称(), is(new RString("他住所地特例解除日（転出確定者）")));
    }

    @Test
    public void 除外適用日_転入者を指定した場合_get名称は_除外適用日_転入者を返す() {
        assertThat(FuseigoRiyu.除外適用日_転入者.get名称(), is(new RString("除外適用日（転入者）")));
    }

    @Test
    public void 除外解除日_住基不一致を指定した場合_get名称は_除外解除日_住基不一致を返す() {
        assertThat(FuseigoRiyu.除外解除日_住基不一致.get名称(), is(new RString("除外解除日（住基不一致）")));
    }

    @Test
    public void 除外解除日_転出予定者を指定した場合_get名称は_除外解除日_転出予定者を返す() {
        assertThat(FuseigoRiyu.除外解除日_転出予定者.get名称(), is(new RString("除外解除日（転出予定者）")));
    }

    @Test
    public void 除外解除日_転出確定者を指定した場合_get名称は_除外解除日_転出確定者を返す() {
        assertThat(FuseigoRiyu.除外解除日_転出確定者.get名称(), is(new RString("除外解除日（転出確定者）")));
    }

}
