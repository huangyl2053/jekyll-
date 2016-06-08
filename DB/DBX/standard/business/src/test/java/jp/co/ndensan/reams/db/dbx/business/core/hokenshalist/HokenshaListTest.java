/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.hokenshalist;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import jp.co.ndensan.reams.db.dbx.definition.core.hokensha.TokeiTaishoKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link HokenshaList}のテストです。
 */
@RunWith(Enclosed.class)
public class HokenshaListTest {

    public HokenshaListTest() {
    }

    public static class createFor広域 extends DbxTestBase {

        private HokenshaList sut;
        private List<HokenshaSummary> list;

        @Before
        public void setUp() {
            list = new ArrayList<>();
        }

        @Test
        public void createFor広域から生成したinstanceは_is広域で_trueを返却する() {
            sut = HokenshaList.createFor広域(list);
            assertThat(sut.is広域(), is(true));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数のlistに市町村コードの重複がある場合_IllegalArgumentExceptionがスローされる() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010101"));
            HokenshaList.createFor広域(list);
        }

        @Test
        public void sizeは_引数のlistのsizeと一致する() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010201"));
            sut = HokenshaList.createFor広域(list);
            assertThat(sut.size(), is(list.size()));
        }

        @Test
        public void getは_引数の市町村コードに該当する要素を返却する() {
            String code = "010101";
            HokenshaSummary hs = createHokenshaSummary(code);
            list.add(hs);
            sut = HokenshaList.createFor広域(list);
            assertThat(sut.get(new LasdecCode(code)), is(hs));
        }

        @Test(expected = NoSuchElementException.class)
        public void getは_引数の市町村コードに該当する要素が存在しない場合_NoSuchElementExceptionをスローする() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010201"));
            sut = HokenshaList.createFor広域(list);
            sut.get(new LasdecCode("010301"));
        }
    }

    public static class createFor単一 extends DbxTestBase {

        private HokenshaList sut;
        private List<HokenshaSummary> list;

        @Before
        public void setUp() {
            list = new ArrayList<>();
        }

        @Test
        public void createFor単一から生成したinstanceは_is広域で_falseを返却する() {
            sut = HokenshaList.createFor単一(list);
            assertThat(sut.is広域(), is(false));
        }

        @Test(expected = IllegalArgumentException.class)
        public void 引数のlistに市町村コードの重複がある場合_IllegalArgumentExceptionがスローされる() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010101"));
            HokenshaList.createFor単一(list);
        }

        @Test
        public void sizeは_引数のlistのsizeと一致する() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010201"));
            sut = HokenshaList.createFor単一(list);
            assertThat(sut.size(), is(list.size()));
        }

        @Test
        public void getは_引数の市町村コードに該当する要素を返却する() {
            String code = "010101";
            HokenshaSummary hs = createHokenshaSummary(code);
            list.add(hs);
            sut = HokenshaList.createFor単一(list);
            assertThat(sut.get(new LasdecCode(code)), is(hs));
        }

        @Test(expected = NoSuchElementException.class)
        public void getは_引数の市町村コードに該当する要素が存在しない場合_NoSuchElementExceptionをスローする() {
            list.add(createHokenshaSummary("010101"));
            list.add(createHokenshaSummary("010201"));
            sut = HokenshaList.createFor単一(list);
            sut.get(new LasdecCode("010301"));
        }
    }

    private static HokenshaSummary createHokenshaSummary(String code) {
        return new HokenshaSummary(new LasdecCode(code), RString.EMPTY, new ShoKisaiHokenshaNo(code), TokeiTaishoKubun.保険者分);
    }
}
