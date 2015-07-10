/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.IryoKikanAndJigyoshaKubun}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class IryoKikanAndJigyoshaKubunTest {

    private static IryoKikanAndJigyoshaKubun sut;
    private static JigyoshaNo jigyoshaNo;

    public static class toValue extends DbzTestBase {

        @Test
        public void aaa() {
            RString a = new RString("aaa");
            aaaaa(a);
            assertThat(a, is(new RString("aaa")));
        }

        private void aaaaa(RString a) {
            a = new RString("bbb");
        }

        @Test
        public void 事業者番号の3桁目が1のとき_医科を返す() {
            jigyoshaNo = new JigyoshaNo("0010000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.医科));
        }

        @Test
        public void 事業者番号の3桁目が3のとき_歯科を返す() {
            jigyoshaNo = new JigyoshaNo("0030000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.歯科));
        }

        @Test
        public void 事業者番号の3桁目が4のとき_薬局を返す() {
            jigyoshaNo = new JigyoshaNo("0040000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.薬局));
        }

        @Test
        public void 事業者番号の3桁目が5のとき_老人保健施設を返す() {
            jigyoshaNo = new JigyoshaNo("0050000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.老人保健施設));
        }

        @Test
        public void 事業者番号の3桁目が6のとき_訪問看護ステーションを返す() {
            jigyoshaNo = new JigyoshaNo("0060000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.訪問看護ステーション));
        }

        @Test
        public void 事業者番号の3桁目が0のとき_かつ6桁目から9桁目が0001である場合_地域包括支援センターを返す() {
            jigyoshaNo = new JigyoshaNo("0000000010");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.地域包括支援センター));
        }

        @Test
        public void 事業者番号の3桁目が0のとき_かつ6桁目から9桁目が5000である場合_地域包括支援センターを返す() {
            jigyoshaNo = new JigyoshaNo("0000050000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.地域包括支援センター));
        }

        @Test
        public void 事業者番号の3桁目が0のとき_かつ6桁目から9桁目が5001である場合_介護予防_日常生活支援総合事業事業所を返す() {
            jigyoshaNo = new JigyoshaNo("0000050010");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.介護予防_日常生活支援総合事業事業所));
        }

        @Test
        public void 事業者番号の3桁目が0のとき_かつ6桁目から9桁目が9999である場合_介護予防_日常生活支援総合事業事業所を返す() {
            jigyoshaNo = new JigyoshaNo("0000099990");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.介護予防_日常生活支援総合事業事業所));
        }

        @Test
        public void 事業者番号の3桁目が7のとき_指定事業所を返す() {
            jigyoshaNo = new JigyoshaNo("0070000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.指定事業所));
        }

        @Test
        public void 事業者番号の3桁目が8のとき_基準該当事業所を返す() {
            jigyoshaNo = new JigyoshaNo("0080000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.基準該当事業所));
        }

        @Test
        public void 事業者番号の3桁目が9のとき_地域密着型サービス事業所を返す() {
            jigyoshaNo = new JigyoshaNo("0090000000");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            assertThat(sut, is(IryoKikanAndJigyoshaKubun.地域密着型サービス事業所));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 対応する区分が存在しない場合_IllegalArgumentExceptionが発生する() {
            jigyoshaNo = new JigyoshaNo("2222222222");
            sut = IryoKikanAndJigyoshaKubun.toValue(jigyoshaNo);
            fail();
        }
    }
}
