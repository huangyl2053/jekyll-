/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatis.param.koseishichosonmaster;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link KoseiShichosonMasterMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class KoseiShichosonMasterMapperParameterTest extends DbzTestBase {

    private static final LasdecCode shichonCode = new LasdecCode(new RString("302302"));
    private static final boolean usesshichonCode = true;

// テストクラス名は適切に変更してください
    public static class createSelectByKeyParamテスト extends DbzTestBase {

        @Test(expected = NullPointerException.class)
        public void 主キー1にNullを指定すると_NullPointerExceptionが発生する() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(null, usesshichonCode);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            KoseiShichosonMasterMapperParameter sut = KoseiShichosonMasterMapperParameter.createSelectByKeyParam(shichonCode, usesshichonCode);

            assertThat(sut.getshichonCode(), is(shichonCode));
            assertThat(sut.isusesshichonCode(), is(true));
        }
    }

}
