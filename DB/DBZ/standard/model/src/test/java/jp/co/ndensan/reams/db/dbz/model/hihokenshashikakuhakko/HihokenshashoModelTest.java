/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.hihokenshashikakuhakko;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshashoPrintPosition;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.testhelper.DbzTestBase;
import jp.co.ndensan.reams.ur.urz.model.shikibetsutaisho.kojin.jukikojin.IJukiKojin;
import org.junit.Test;
import org.junit.Before;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * {@link jp.co.ndensan.reams.db.dba.model.hihokenshashikakuhakko.HihokenshashoModel}のテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class HihokenshashoModelTest {

    private static HihokenshashoModel sut;

    public static class constructor extends DbzTestBase {

        private HihokenshaDaichoModel hihoDaicho;
        private IJukiKojin kojin;
        private HihokenshaShikakuHakkoModel shikakuHakko;

        @Before
        public void setUp() {
            hihoDaicho = mock(HihokenshaDaichoModel.class);
            kojin = mock(IJukiKojin.class);
            shikakuHakko = mock(HihokenshaShikakuHakkoModel.class);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者台帳Modelにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new HihokenshashoModel(null, kojin, shikakuHakko, HihokenshashoPrintPosition.上部);
        }

        @Test(expected = NullPointerException.class)
        public void 個人Modelにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new HihokenshashoModel(hihoDaicho, null, shikakuHakko, HihokenshashoPrintPosition.上部);
        }

        @Test(expected = NullPointerException.class)
        public void 被保険者資格発行Modelにnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new HihokenshashoModel(hihoDaicho, kojin, null, HihokenshashoPrintPosition.上部);
        }

        @Test(expected = NullPointerException.class)
        public void 印字位置にnullが渡されたとき_NullPointerExceptionが発生する() {
            sut = new HihokenshashoModel(hihoDaicho, kojin, shikakuHakko, null);
        }
    }

}
