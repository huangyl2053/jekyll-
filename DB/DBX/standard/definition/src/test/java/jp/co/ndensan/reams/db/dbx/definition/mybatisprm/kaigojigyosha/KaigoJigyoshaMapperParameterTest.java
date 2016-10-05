/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha;

import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoJigyoshaMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoJigyoshaMapperParameterTest extends DbxTestBase {

    private final static JigyoshaNo jigyoshaNo = new JigyoshaNo(new RString("12"));
    private final static FlexibleDate yukoKaishiYMD = new FlexibleDate(new RString("23"));

    @Ignore
    public static class createSelectByKeyParamテスト extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void jigyoshaNoにNullを指定すると_NullPointerExceptionが発生する() {
            KaigoJigyoshaMapperParameter sut = KaigoJigyoshaMapperParameter.createSelectByKeyParam((JigyoshaNo) null, yukoKaishiYMD);
        }

        @Test(expected = NullPointerException.class)
        public void yukoKaishiYMDにNullを指定すると_NullPointerExceptionが発生する() {
            KaigoJigyoshaMapperParameter sut = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            KaigoJigyoshaMapperParameter sut = KaigoJigyoshaMapperParameter.createSelectByKeyParam(jigyoshaNo, yukoKaishiYMD);

            assertThat(sut.getJigyoshaNo(), is(jigyoshaNo));
            assertThat(sut.getYukoKaishiYMD(), is(yukoKaishiYMD));
        }
    }

}
