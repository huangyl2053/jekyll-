/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.shinsakaiiinjoho;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShinsakaiIinJohoMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class ShinsakaiIinJohoMapperParameterTest extends DbeTestBase {

    private static RString shinsakaiIinCode = new RString("301");

    public static class createSelectByKeyParamテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void shinsakaiIinCodeにNullを指定すると_NullPointerExceptionが発生する() {
            ShinsakaiIinJohoMapperParameter sut = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            ShinsakaiIinJohoMapperParameter sut = ShinsakaiIinJohoMapperParameter.createSelectByKeyParam(shinsakaiIinCode);

            assertThat(sut.getShinsakaiIinCode(), is(shinsakaiIinCode));
        }
    }

}
