/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 認定調査特記事項クラスのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class NinteichosaTokkijikoTest extends TestBase {

    public static class コンストラクタのテスト extends TestBase {

        private NinteichosaTokkijiko sut;
        private ShinseishoKanriNo 申請書管理番号;
        private NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
        private RString 認定調査特記事項番号;
        private RString 特記事項;

        @Override
        public void setUp() {
            申請書管理番号 = new ShinseishoKanriNo(new RString("A001"));
            認定調査依頼履歴番号 = new NinteichosaIraiRirekiNo(1);
            認定調査特記事項番号 = new RString("B001");
            特記事項 = new RString("特記するぜ");
        }

        @Test
        public void 引数に必要な値が渡されたとき_インスタンスが生成される() {
            sut = new NinteichosaTokkijiko(申請書管理番号, 認定調査依頼履歴番号, 認定調査特記事項番号, null);
            assertThat(sut, is(instanceOf(NinteichosaTokkijiko.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 申請書管理番号にnullが渡されたとき_NullPointerException発生() {
            sut = new NinteichosaTokkijiko(null, 認定調査依頼履歴番号, 認定調査特記事項番号, 特記事項);
            assertThat(sut, is(instanceOf(NinteichosaTokkijiko.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼履歴番号にnullが渡されたとき_NullPointerException発生() {
            sut = new NinteichosaTokkijiko(申請書管理番号, null, 認定調査特記事項番号, 特記事項);
            assertThat(sut, is(instanceOf(NinteichosaTokkijiko.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査特記事項番号にnullが渡されたとき_NullPointerException発生() {
            sut = new NinteichosaTokkijiko(申請書管理番号, 認定調査依頼履歴番号, null, 特記事項);
            assertThat(sut, is(instanceOf(NinteichosaTokkijiko.class)));
        }
    }
}
