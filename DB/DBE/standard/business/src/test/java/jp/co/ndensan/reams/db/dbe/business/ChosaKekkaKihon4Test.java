/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun4;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査第4群）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihon4Test {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 被害的がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    null,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 作話がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    null,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 感情が不安定がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    null,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 昼夜逆転がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    null,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 同じ話をするがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    null,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 大声を出すがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    null,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 介護に抵抗がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    null,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 落ち着きなしがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    null,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 一人で出たがるがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    null,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 収集癖がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    null,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 物や衣類を壊すがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    null,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void ひどい物忘れがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    null,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 独り言独り笑いがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    null,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 自分勝手に行動するがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    null,
                    ChosaKekkaKubun4.HanashiGaMatomaranai.ない);
        }

        @Test(expected = NullPointerException.class)
        public void 話がまとまらないがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihon4(
                    ChosaKekkaKubun4.Higaiteki.ない,
                    ChosaKekkaKubun4.Sakuwa.ある,
                    ChosaKekkaKubun4.KanjoHuantei.ない,
                    ChosaKekkaKubun4.ChuyaGyakuten.ある,
                    ChosaKekkaKubun4.OnajiHanashi.ない,
                    ChosaKekkaKubun4.Ogoe.ある,
                    ChosaKekkaKubun4.KaigoNiTeiko.ない,
                    ChosaKekkaKubun4.Ochitsuki.ある,
                    ChosaKekkaKubun4.HitoriDeDetagaru.ない,
                    ChosaKekkaKubun4.Shushuheki.ある,
                    ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない,
                    ChosaKekkaKubun4.HidoiMonowasure.ある,
                    ChosaKekkaKubun4.HitorigotoHitoriwarai.ない,
                    ChosaKekkaKubun4.JibunKatte.ある,
                    null);
        }
    }
}
