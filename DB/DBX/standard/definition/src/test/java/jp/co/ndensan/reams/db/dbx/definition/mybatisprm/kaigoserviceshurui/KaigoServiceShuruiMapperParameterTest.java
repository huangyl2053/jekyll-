/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigoserviceshurui.KaigoServiceShuruiMapperParameter;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KaigoServiceShuruiMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KaigoServiceShuruiMapperParameterTest extends DbxTestBase {

    private static final KaigoServiceShuruiCode serviceShuruiCd = new KaigoServiceShuruiCode(new RString("113"));
    private static final FlexibleYearMonth teikyoKaishiYM = new FlexibleYearMonth(new RString("11"));

    @Ignore
    public static class createSelectByKeyParamテスト extends DbxTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            KaigoServiceShuruiMapperParameter sut = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(null, teikyoKaishiYM);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー2にNullを指定すると_NullPointerExceptionが発生する() {
            KaigoServiceShuruiMapperParameter sut = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(serviceShuruiCd, null);

        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            KaigoServiceShuruiMapperParameter sut = KaigoServiceShuruiMapperParameter.createSelectByKeyParam(serviceShuruiCd, teikyoKaishiYM);

            assertThat(sut.getServiceShuruiCd(), is(serviceShuruiCd));
            assertThat(sut.getTeikyoKaishiYM(), is(teikyoKaishiYM));
        }
    }

}
