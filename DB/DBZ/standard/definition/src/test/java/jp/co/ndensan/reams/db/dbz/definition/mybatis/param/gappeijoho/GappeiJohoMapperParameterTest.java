/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.gappeijoho;

import jp.co.ndensan.reams.db.dbx.definition.mybatisprm.gappeijoho.GappeiJohoMapperParameter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link GappeiJohoMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class GappeiJohoMapperParameterTest extends DbzTestBase {

    private static FlexibleDate gappeiYMD = new FlexibleDate(new RString("20151030"));
    private static RString chiikiNo = new RString("1001");

    public static class createSelectByKeyParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            GappeiJohoMapperParameter sut = GappeiJohoMapperParameter.createSelectByKeyParam(null, chiikiNo);
        }

        @Test(expected = NullPointerException.class)
        public void 主キー2にNullを指定すると_NullPointerExceptionが発生する() {
            GappeiJohoMapperParameter sut = GappeiJohoMapperParameter.createSelectByKeyParam(gappeiYMD, null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            GappeiJohoMapperParameter sut = GappeiJohoMapperParameter.createSelectByKeyParam(gappeiYMD, chiikiNo);

            assertThat(sut.getgappeiYMD(), is(gappeiYMD));
            assertThat(sut.getchiikiNo(), is(chiikiNo));
        }
    }

}
