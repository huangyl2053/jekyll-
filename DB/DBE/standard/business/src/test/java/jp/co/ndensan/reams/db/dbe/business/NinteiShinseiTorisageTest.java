/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定申請取下げクラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteiShinseiTorisageTest extends TestBase {

    public static class コンストラクタのテスト {

        @Test
        public void インスタンスの生成() {
            NinteiShinseiTorisage sut = new NinteiShinseiTorisage(null, TorisageRiyu.EMPTY, FlexibleDate.MAX, null);
            assertThat(sut, instanceOf(NinteiShinseiTorisage.class));
        }
    }
}
