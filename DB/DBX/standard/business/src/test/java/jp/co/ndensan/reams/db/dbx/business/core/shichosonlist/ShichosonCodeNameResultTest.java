/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.shichosonlist;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.uz.uza.testhelper.ByteArraySerializations.canBeCopiedBySerialization;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link ShichosonCodeNameResult}のテストです。
 */
@RunWith(Enclosed.class)
public class ShichosonCodeNameResultTest {

    public ShichosonCodeNameResultTest() {
    }

    public static class Getters {

        private ShichosonCodeNameResult sut;
        private LasdecCode shichosonoCode;
        private RString shichosonName;
        private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
        private TokeiTaishoKubun hokenshaKubun;

        @Before
        public void setUp() {
            shichosonoCode = new LasdecCode("000001");
            shichosonName = new RString("電算市");
            shoKisaiHokenshaNo = new ShoKisaiHokenshaNo("000001");
            hokenshaKubun = TokeiTaishoKubun.保険者分;
            sut = new ShichosonCodeNameResult(shichosonoCode, shichosonName, shoKisaiHokenshaNo, hokenshaKubun);
        }

        @Test
        public void testGet市町村コード() {
            assertThat(sut.get市町村コード(), is(shichosonoCode));
        }

        @Test
        public void testGet市町村名称() {
            assertThat(sut.get市町村名称(), is(shichosonName));

        }

        @Test
        public void testGet保険者番号() {
            assertThat(sut.get証記載保険者番号(), is(shoKisaiHokenshaNo));
        }

        @Test
        public void testGet保険者区分() {
            assertThat(sut.get保険者区分(), is(hokenshaKubun));
        }
    }

    public static class Serialization {

        private Serializable sut;

        @Before
        public void setUp() {
            sut = new ShichosonCodeNameResult(LasdecCode.EMPTY, RString.EMPTY, ShoKisaiHokenshaNo.EMPTY, TokeiTaishoKubun.保険者分);
        }

        @Test
        public void シリアライズできる() {
            assertThat(sut, canBeCopiedBySerialization());
        }
    }

}
