/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatis.param.ninteishinseijoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link NinteiShinseiJohoMapperParameter}のテストクラスです。
 */
@RunWith(Enclosed.class)
public class NinteiShinseiJohoMapperParameterTest extends DbeTestBase {

    private static final ShinseishoKanriNo shinseishoKanriNo = new ShinseishoKanriNo("20151020");

    public static class createParamテスト extends DbeTestBase {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にNullを指定すると_NullPointerExceptionが発生する() {
            NinteiShinseiJohoMapperParameter sut = NinteiShinseiJohoMapperParameter.createParam(null);
        }

        @Test
        public void 引数にNull以外を指定すると_パラメータが生成できる() {
            NinteiShinseiJohoMapperParameter sut = NinteiShinseiJohoMapperParameter.createParam(shinseishoKanriNo);

            assertThat(sut.getShinseishoKanriNo(), is(shinseishoKanriNo));
        }
    }

}
