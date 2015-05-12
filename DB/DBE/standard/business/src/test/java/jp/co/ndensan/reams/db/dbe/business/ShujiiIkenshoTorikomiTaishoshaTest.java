/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestBase;
import jp.co.ndensan.reams.ua.uax.business.shikibetsutaisho.kojin.IKojin;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.mockito.Mockito.mock;

/**
 * 主治医意見書取込対象者を扱うクラスのテストです。
 *
 * @author N8187 久保田 英男
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoTorikomiTaishoshaTest extends DbeTestBase {

    public static class コンストラクタ extends DbeTestBase {

        private ShujiiIkenshoTorikomiTaishosha sut;
        private YokaigoNinteiProgress 認定進捗情報;
        private YokaigoNinteiShinsei 認定申請情報;
        private ShujiiIkenshoSakuseiIrai 主治医意見書作成依頼情報;
        private IKojin 個人;
        private KaigoDoctor 介護主治医;

        @Before
        public void setUp() {
            認定進捗情報 = mock(YokaigoNinteiProgress.class);
            認定申請情報 = mock(YokaigoNinteiShinsei.class);
            主治医意見書作成依頼情報 = mock(ShujiiIkenshoSakuseiIrai.class);
            個人 = mock(IKojin.class);
            介護主治医 = mock(KaigoDoctor.class);
        }

        @Test(expected = NullPointerException.class)
        public void 認定進捗情報にnullが渡されたとき_NullPointerException発生() {
            認定進捗情報 = null;
            sut = new ShujiiIkenshoTorikomiTaishosha(認定進捗情報, 認定申請情報, 主治医意見書作成依頼情報, 個人, 介護主治医);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 認定申請情報にnullが渡されたとき_NullPointerException発生() {
            認定申請情報 = null;
            sut = new ShujiiIkenshoTorikomiTaishosha(認定進捗情報, 認定申請情報, 主治医意見書作成依頼情報, 個人, 介護主治医);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 主治医意見書作成依頼情報にnullが渡されたとき_NullPointerException発生() {
            主治医意見書作成依頼情報 = null;
            sut = new ShujiiIkenshoTorikomiTaishosha(認定進捗情報, 認定申請情報, 主治医意見書作成依頼情報, 個人, 介護主治医);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 個人にnullが渡されたとき_NullPointerException発生() {
            個人 = null;
            sut = new ShujiiIkenshoTorikomiTaishosha(認定進捗情報, 認定申請情報, 主治医意見書作成依頼情報, 個人, 介護主治医);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }

        @Test(expected = NullPointerException.class)
        public void 介護主治医にnullが渡されたとき_NullPointerException発生() {
            介護主治医 = null;
            sut = new ShujiiIkenshoTorikomiTaishosha(認定進捗情報, 認定申請情報, 主治医意見書作成依頼情報, 個人, 介護主治医);
            assertThat(sut, is(instanceOf(NinteichosaKekkaTorikomiTaishosha.class)));
        }
    }
}
