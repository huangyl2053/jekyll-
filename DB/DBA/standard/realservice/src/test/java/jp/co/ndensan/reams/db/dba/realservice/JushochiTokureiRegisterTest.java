/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.realservice;

import jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel;
import jp.co.ndensan.reams.db.dba.persistence.relate.JushochiTokureiRirekiRelateDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

/**
 * {@link jp.co.ndensan.reams.db.dba.realservice.JushochiTokureiRegister}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiRegisterTest {

    private static JushochiTokureiRegister sut;

    public static class save extends DbaTestBase {

        @Test
        public void 住所地特例Modelの情報を_1件以上更新できた場合_trueが返る() {
            sut = new JushochiTokureiRegister(createMockDac(1));
            assertThat(sut.save(mock(JushochiTokureiModel.class)), is(true));
        }

        @Test
        public void 住所地特例Modelの情報を_1件も更新できなかった場合_falseが返る() {
            sut = new JushochiTokureiRegister(createMockDac(0));
            assertThat(sut.save(mock(JushochiTokureiModel.class)), is(false));
        }
    }

    private static JushochiTokureiRirekiRelateDac createMockDac(int updateNum) {
        JushochiTokureiRirekiRelateDac mockDac = mock(JushochiTokureiRirekiRelateDac.class);
        when(mockDac.update(any(JushochiTokureiModel.class))).thenReturn(updateNum);
        return mockDac;
    }

}
