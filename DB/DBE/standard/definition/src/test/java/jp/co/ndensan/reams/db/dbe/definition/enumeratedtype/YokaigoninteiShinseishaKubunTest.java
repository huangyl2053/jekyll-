/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 * YokaigoninteiShinseishaKubunのテストです。
 *
 * @author N3327 三浦 凌
 */
@RunWith(Enclosed.class)
public class YokaigoninteiShinseishaKubunTest extends DbzTestBase {

    public static class toRString extends DbzTestBase {

        @Test
        public void YokaigoninteiShinseishaKubun$本人_のtoRStringは_RStringの本人_を返す() {
            YokaigoninteiShinseishaKubun sut = YokaigoninteiShinseishaKubun.本人;
            assertThat(sut.toRString(), is(new RString("本人")));
        }
    }

}
