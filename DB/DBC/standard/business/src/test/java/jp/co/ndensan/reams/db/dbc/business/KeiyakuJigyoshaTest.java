/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.EigyoKeitai;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.business.IKoza;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IHojin;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 契約事業者のテストクラスです。
 *
 * @author N3317 塚田 萌
 */
@RunWith(Enclosed.class)
public class KeiyakuJigyoshaTest extends TestBase {

    private static KeiyakuJigyosha sut;

    private static JigyoshaNo 事業者番号;
    private static IHojin 法人;
    private static TelNo 事業者FAX番号;
    private static EigyoKeitai 営業形態;
    private static RString 送付先部署;
    private static IKoza 口座;
    //TODO n3317塚田萌　ISofusakiは本実装の時に対応する。期限　本実装完了まで
    //private static ISofusaki 送付先;

    @Override
    public void setUp() {
        事業者番号 = mock(JigyoshaNo.class);
        法人 = mock(IHojin.class);
        事業者FAX番号 = mock(TelNo.class);
        営業形態 = mock(EigyoKeitai.class);
        送付先部署 = mock(RString.class);
        口座 = mock(IKoza.class);
    }

    public static class ConstructorTest {

        @Test(expected = NullPointerException.class)
        public void 法人がnullの時_NullPointerExceptionが発生する() {
            sut = new KeiyakuJigyosha(事業者番号, null, 事業者FAX番号, 営業形態, 送付先部署, 口座);
        }

        @Test(expected = NullPointerException.class)
        public void 口座がnullの時_NullPointerExceptionが発生する() {
            sut = new KeiyakuJigyosha(事業者番号, 法人, 事業者FAX番号, 営業形態, 送付先部署, null);
        }
    }
}
