/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.business.helper.NinteichosaKekkaMock;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査の結果情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaKekka(
                    null, 0,
                    NinteichosaKekkaMock.getSpiedChosaKekkaGaikyoInstance(),
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 概況情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaKekka(
                    new ShinseishoKanriNo(new RString("1234567890")), 0,
                    null,
                    NinteichosaKekkaMock.getSpiedChosaKekkaKihonInstance());
        }

        @Test(expected = NullPointerException.class)
        public void 基本情報がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new NinteichosaKekka(
                    new ShinseishoKanriNo(new RString("1234567890")), 0,
                    NinteichosaKekkaMock.getSpiedChosaKekkaGaikyoInstance(),
                    null);
        }
    }
}
