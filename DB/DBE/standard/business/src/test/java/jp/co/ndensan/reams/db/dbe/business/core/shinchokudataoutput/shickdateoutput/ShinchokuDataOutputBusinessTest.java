/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shinchokudataoutput.shickdateoutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinchokudataoutput.ShinchokuDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link ShinchokuDataOutputBusiness}のテストです。
 */
public class ShinchokuDataOutputBusinessTest extends DbeTestBase {

    public ShinchokuDataOutputBusinessTest() {
    }

    @Test
    public void get出力条件_被保険者番号リストのsizeが_0() {
        ShinchokuDataOutputBusiness sut = new ShinchokuDataOutputBusiness();
        ShinchokuDataOutputProcessParamter param = new ShinchokuDataOutputProcessParamter(
                Arrays.asList(new RString("20211820170301068"), new RString(" 20211820170301065")),
                new RString("0"),
                new RString("平29.03.01"),
                new RString("平29.04.13"),
                RString.EMPTY,
                new RString("中野市"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        List<RString> list = sut.get出力条件(param, new ArrayList<RString>());
        assertThat(list.get(list.size() - 1).endsWith(","), is(false));
    }

    @Test
    public void get出力条件_被保険者番号リストのsizeが_1以上_15以下() {
        ShinchokuDataOutputBusiness sut = new ShinchokuDataOutputBusiness();
        ShinchokuDataOutputProcessParamter param = new ShinchokuDataOutputProcessParamter(
                Arrays.asList(new RString("20211820170301068"), new RString(" 20211820170301065")),
                new RString("0"),
                new RString("平29.03.01"),
                new RString("平29.04.13"),
                RString.EMPTY,
                new RString("中野市"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        List<RString> list = sut.get出力条件(param, Arrays.asList(
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007")
        ));
        assertThat(list.get(list.size() - 1).endsWith(","), is(false));
    }

    @Test
    public void get出力条件_被保険者番号リストのsizeが_16() {
        ShinchokuDataOutputBusiness sut = new ShinchokuDataOutputBusiness();
        ShinchokuDataOutputProcessParamter param = new ShinchokuDataOutputProcessParamter(
                Arrays.asList(new RString("20211820170301068"), new RString(" 20211820170301065")),
                new RString("0"),
                new RString("平29.03.01"),
                new RString("平29.04.13"),
                RString.EMPTY,
                new RString("中野市"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        List<RString> list = sut.get出力条件(param, Arrays.asList(
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007")
        ));
        assertThat(list.get(list.size() - 1).endsWith(","), is(false));
    }

    @Test
    public void get出力条件_被保険者番号リストのsizeが_20() {
        ShinchokuDataOutputBusiness sut = new ShinchokuDataOutputBusiness();
        ShinchokuDataOutputProcessParamter param = new ShinchokuDataOutputProcessParamter(
                Arrays.asList(new RString("20211820170301068"), new RString(" 20211820170301065")),
                new RString("0"),
                new RString("平29.03.01"),
                new RString("平29.04.13"),
                RString.EMPTY,
                new RString("中野市"),
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
        List<RString> list = sut.get出力条件(param, Arrays.asList(
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007"),
                new RString("3000000007"), new RString("3000000010"), new RString("3000000007"), new RString("3000000007")
        ));
        assertThat(list.get(list.size() - 2).endsWith(","), is(true));
        assertThat(list.get(list.size() - 1).endsWith(","), is(false));
    }
}
