/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog;

import java.util.Arrays;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;

/**
 * {@link ExpandedInformations}のテストです。
 */
public class ExpandedInformationsTest {

    public ExpandedInformationsTest() {
    }

    @Test
    public void fromValue() {
        RString value = new RString("100");
        ExpandedInformation[] result = ExpandedInformations.fromValue(value);
        assertThat(result[0].getCode(), is(new Code("0001")));
        assertThat(result[0].getName(), is(new RString("申請書管理番号")));
        assertThat(result[0].getValue(), is(value));
    }

    @Test
    public void fromValues_Iterable() {
        List<RString> list = Arrays.asList(
                new RString("100"), new RString("100"), new RString("100"), new RString("100"), new RString("100")
        );
        ExpandedInformation[] result = ExpandedInformations.fromValues(list);
        assertThat(result[0].getCode(), is(new Code("0001")));
        assertThat(result[1].getCode(), is(new Code("0002")));
        assertThat(result[2].getCode(), is(new Code("0003")));
        assertThat(result[3].getCode(), is(new Code("0004")));
        assertThat(result[4].getCode(), is(new Code("0005")));
    }

    @Test
    public void fromShinseishoKanriNo() {
        ExpandedInformation[] result = ExpandedInformations.fromShinseishoKanriNo(new ShinseishoKanriNo("100"));
        assertThat(result[0].getCode(), is(new Code("0001")));
    }

    @Test
    public void fromShinseishoKanriNos_Iterable() {
        List<ShinseishoKanriNo> list = Arrays.asList(
                new ShinseishoKanriNo("100"), new ShinseishoKanriNo("100"), new ShinseishoKanriNo("100"),
                new ShinseishoKanriNo("100"), new ShinseishoKanriNo("100")
        );
        ExpandedInformation[] result = ExpandedInformations.fromShinseishoKanriNos(list);
        assertThat(result[0].getCode(), is(new Code("0001")));
        assertThat(result[1].getCode(), is(new Code("0002")));
        assertThat(result[2].getCode(), is(new Code("0003")));
        assertThat(result[3].getCode(), is(new Code("0004")));
        assertThat(result[4].getCode(), is(new Code("0005")));
    }
}
