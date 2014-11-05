
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.code;

import jp.co.ndensan.reams.db.dba.business.codeassigneditem.*;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link DBACodeShubetsu}のテストクラスです。
 *
 * @author N9606 漢那 憲作
 */
public class DBACodeShubetsuTest extends DbaTestBase {

    private String name;

    @Test
    public void 取得事由_被保険者の場合_getCodeShubetsuは0001を返す() {
        assertThat(DBACodeShubetsu.取得事由_被保険者.getCodeShubetsu(), is(new CodeShubetsu("0001")));
    }

    @Test
    public void 取得事由_他特適用の場合_getCodeShubetsuは0002を返す() {
        assertThat(DBACodeShubetsu.取得事由_他特適用.getCodeShubetsu(), is(new CodeShubetsu("0002")));
    }

    @Test
    public void 取得事由_除外適用の場合_getCodeShubetsuは0003を返す() {
        assertThat(DBACodeShubetsu.取得事由_除外適用.getCodeShubetsu(), is(new CodeShubetsu("0003")));
    }

    @Test
    public void 取得事由_他特除外の場合_getCodeShubetsuは0004を返す() {
        assertThat(DBACodeShubetsu.取得事由_他特除外.getCodeShubetsu(), is(new CodeShubetsu("0004")));
    }

    @Test
    public void 喪失事由_被保険者の場合_getCodeShubetsuは0005を返す() {
        assertThat(DBACodeShubetsu.喪失事由_被保険者.getCodeShubetsu(), is(new CodeShubetsu("0005")));
    }

    @Test
    public void 喪失事由_他特適用の場合_getCodeShubetsuは0006を返す() {
        assertThat(DBACodeShubetsu.喪失事由_他特適用.getCodeShubetsu(), is(new CodeShubetsu("0006")));
    }

    @Test
    public void 喪失事由_除外適用の場合_getCodeShubetsuは0007を返す() {
        assertThat(DBACodeShubetsu.喪失事由_除外適用.getCodeShubetsu(), is(new CodeShubetsu("0007")));
    }

    @Test
    public void 喪失事由_他特除外の場合_getCodeShubetsuは0008を返す() {
        assertThat(DBACodeShubetsu.喪失事由_他特除外.getCodeShubetsu(), is(new CodeShubetsu("0008")));
    }

    @Test
    public void 医療保険種類の場合_getCodeShubetsuは0009を返す() {
        assertThat(DBACodeShubetsu.医療保険種類.getCodeShubetsu(), is(new CodeShubetsu("0009")));
    }

    /**
     * getReturnTypeteテスト
     */
    @Test
    public void 取得事由_被保険者_getReturnTypeはShutokuJiyuHihokenshaを返す() {
        name = ShutokuJiyuHihokensha.class.getName();
        assertThat(DBACodeShubetsu.取得事由_被保険者.getReturnType().getName(), is(name));

    }

    @Test
    public void 取得事由_他特適用_getReturnTypeはShutokuJiyuTatokuTekiyoを返す() {
        name = ShutokuJiyuTatokuTekiyo.class.getName();
        assertThat(DBACodeShubetsu.取得事由_他特適用.getReturnType().getName(), is(name));

    }

    @Test
    public void 取得事由_除外適用_getReturnTypeはShutokuJiyuJogaiTekiyoを返す() {
        name = ShutokuJiyuJogaiTekiyo.class.getName();
        assertThat(DBACodeShubetsu.取得事由_除外適用.getReturnType().getName(), is(name));

    }

    @Test
    public void 取得事由_他特除外_getReturnTypeはShutokuJiyuTatokuJogaiを返す() {
        name = ShutokuJiyuTatokuJogai.class.getName();
        assertThat(DBACodeShubetsu.取得事由_他特除外.getReturnType().getName(), is(name));

    }

    @Test
    public void 喪失事由_被保険者_getReturnTypeはSoshitsuJiyuHihokenshaを返す() {
        name = SoshitsuJiyuHihokensha.class.getName();
        assertThat(DBACodeShubetsu.喪失事由_被保険者.getReturnType().getName(), is(name));

    }

    @Test
    public void 喪失事由_他特適用_getReturnTypeはSoshitsuJiyuTatokuTekiyoを返す() {
        name = SoshitsuJiyuTatokuTekiyo.class.getName();
        assertThat(DBACodeShubetsu.喪失事由_他特適用.getReturnType().getName(), is(name));

    }

    @Test
    public void 喪失事由_除外適用_getReturnTypeはSoshitsuJiyuJogaiTekiyoを返す() {
        name = SoshitsuJiyuJogaiTekiyo.class.getName();
        assertThat(DBACodeShubetsu.喪失事由_除外適用.getReturnType().getName(), is(name));

    }

    @Test
    public void 喪失事由_他特除外_getReturnTypeはSoshitsuJiyuTatokuJogaiを返す() {
        name = SoshitsuJiyuTatokuJogai.class.getName();
        assertThat(DBACodeShubetsu.喪失事由_他特除外.getReturnType().getName(), is(name));

    }

    @Test
    public void 医療保険種類_getReturnTypeはIryoHokenShuruiを返す() {
        name = IryoHokenShurui.class.getName();
        assertThat(DBACodeShubetsu.医療保険種類.getReturnType().getName(), is(name));

    }

}
