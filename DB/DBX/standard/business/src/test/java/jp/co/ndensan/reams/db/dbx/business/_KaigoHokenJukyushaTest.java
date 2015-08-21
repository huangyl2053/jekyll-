/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.testhelper.DbxTestBase;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * 介護保険受給者のテストクラスです。
 *
 * @author n3310 酒井 裕亮
 */
public class _KaigoHokenJukyushaTest extends DbxTestBase {

    private static List<IYoKaigoNintei> 要介護認定リスト;
    private static RDate 直近異動年月日;
    private static IKojin 個人;
    private static RDate 喪失年月日;

    @BeforeClass
    public static void setUpClass() {
        要介護認定リスト = mock(List.class);
        直近異動年月日 = mock(RDate.class);
        個人 = mock(IKojin.class);
        喪失年月日 = mock(RDate.class);
    }

    @Test(expected = NullPointerException.class)
    public void 要介護認定リストがnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _KaigoHokenJukyusha(null, 直近異動年月日, 個人, 喪失年月日);
    }

    @Test(expected = NullPointerException.class)
    public void 直近異動年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _KaigoHokenJukyusha(要介護認定リスト, null, 個人, 喪失年月日);
    }

    @Test(expected = NullPointerException.class)
    public void 個人がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _KaigoHokenJukyusha(要介護認定リスト, 直近異動年月日, null, 喪失年月日);
    }

    @Test(expected = NullPointerException.class)
    public void 喪失年月日がnullである場合_コンストラクタは_NullPointerExceptionを返す() {
        new _KaigoHokenJukyusha(要介護認定リスト, 直近異動年月日, 個人, null);
    }

    @Test
    public void LDNS_要介護認定リストはmockの場合_get要介護認定は_NOTNULLを返す() {
        _KaigoHokenJukyusha sut = new _KaigoHokenJukyusha(要介護認定リスト, 直近異動年月日, 個人, 喪失年月日);
        assertThat(sut.get要介護認定(), is(notNullValue()));
    }

    @Test
    public void LDNS_直近異動年月日は20140101の場合_get直近異動年月日は_20140101を返す() {
        _KaigoHokenJukyusha sut = new _KaigoHokenJukyusha(要介護認定リスト, new RDate("20140101"), 個人, 喪失年月日);
        assertThat(sut.get直近異動年月日(), is(new RDate("20140101")));
    }

    @Test
    public void LDNS_個人はmockの場合_get個人は_NOTNULLを返す() {
        _KaigoHokenJukyusha sut = new _KaigoHokenJukyusha(要介護認定リスト, new RDate("20140101"), 個人, 喪失年月日);
        assertThat(sut.get個人(), is(notNullValue()));
    }

    @Test
    public void LDNS_喪失年月日は20080808の場合_get喪失年月日は_20080808を返す() {
        _KaigoHokenJukyusha sut = new _KaigoHokenJukyusha(要介護認定リスト, new RDate("20140101"), 個人, new RDate("20080808"));
        assertThat(sut.get喪失年月日(), is(new RDate("20080808")));
    }
}
