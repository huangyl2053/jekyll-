/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.model.relate.shikakuido;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.model.shisetsunyutaisho.ShisetsuNyutaishoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * {@link jp.co.ndensan.reams.db.dba.model.relate.shikakuido.JushochiTokureiModel}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class JushochiTokureiModelTest {

    private static JushochiTokureiModel sut;
    private static List<HihokenshaDaichoModel> hihoDaichoData;
    private static List<ShisetsuNyutaishoModel> shisetsuNyutaishoData;

    public static class constructor extends DbaTestBase {

        @Test(expected = NullPointerException.class)
        public void 被保険者台帳ModelListにnullが渡された場合_NullPointerExceptionが発生する() {
            hihoDaichoData = null;
            shisetsuNyutaishoData = Collections.emptyList();
            sut = new JushochiTokureiModel(hihoDaichoData, shisetsuNyutaishoData);
            fail();
        }

        @Test(expected = NullPointerException.class)
        public void 施設入退所ModelListにnullが渡された場合_NullPointerExceptionが発生する() {
            hihoDaichoData = Collections.emptyList();
            shisetsuNyutaishoData = null;
            sut = new JushochiTokureiModel(hihoDaichoData, shisetsuNyutaishoData);
            fail();
        }
    }

}
