/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.ur.urf.business.IKaigoJigyosha;
import jp.co.ndensan.reams.ur.urz.business.shikibetsutaisho.IKojin;
import jp.co.ndensan.reams.uz.uza.testhelper.TestBase;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 認定調査結果取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaTorikomiTaishoshaTest extends TestBase {

    public static class コンストラクタ extends TestBase {

        private NinteichosaKekkaTorikomiTaishosha sut;
        private YokaigoninteiProgress 要介護認定進捗情報;
        private NinteiShinseiJoho 認定申請情報;
        private NinteichosaIrai 認定調査依頼情報;
        private KaigoNinteichosainCollection 介護認定調査員Collection;
        private IKaigoJigyosha 介護事業者情報;
        private IKojin 個人;

        @Override
        public void setUp() {
            要介護認定進捗情報 = mock(YokaigoninteiProgress.class);
            認定申請情報 = mock(NinteiShinseiJoho.class);
            認定調査依頼情報 = mock(NinteichosaIrai.class);
            介護認定調査員Collection = mock(KaigoNinteichosainCollection.class);
            介護事業者情報 = mock(IKaigoJigyosha.class);
            個人 = mock(IKojin.class);
        }

        @Test(expected = NullPointerException.class)
        public void 要介護認定進捗情報にnullが渡されたとき_NullPointerException発生() {
            要介護認定進捗情報 = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請情報にnullが渡されたとき_NullPointerException発生() {
            認定申請情報 = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 認定調査依頼情報にnullが渡されたとき_NullPointerException発生() {
            認定調査依頼情報 = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 介護認定調査員Collectionにnullが渡されたとき_NullPointerException発生() {
            介護認定調査員Collection = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 介護事業者情報にnullが渡されたとき_NullPointerException発生() {
            介護事業者情報 = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 個人にnullが渡されたとき_NullPointerException発生() {
            個人 = null;
            sut = new NinteichosaKekkaTorikomiTaishosha(要介護認定進捗情報, 認定申請情報, 認定調査依頼情報, 介護認定調査員Collection, 介護事業者情報, 個人);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }
    }
}
