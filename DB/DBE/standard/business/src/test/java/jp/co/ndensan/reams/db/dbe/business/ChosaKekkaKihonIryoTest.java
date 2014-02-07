/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunIryo;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 要介護認定調査（基本調査特別医療）の情報を保持するクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ChosaKekkaKihonIryoTest {

    public static class コンストラクタ {

        @Test(expected = NullPointerException.class)
        public void 点滴の管理がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    null,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 中心静脈栄養がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    null,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 透析がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    null,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void ストーマの処置がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    null,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 酸素療法がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    null,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void レスピレーターがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    null,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 気管切開の処置がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    null,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 疼痛の看護がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    null,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void 経管栄養がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    null,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void モニター測定がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    null,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void じょくそうの処置がNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    null,
                    ChosaKekkaKubunIryo.Catheter.ある);
        }

        @Test(expected = NullPointerException.class)
        public void カテーテルがNULLの時_コンストラクタは_NullPointerExceptionを投げる() {
            new ChosaKekkaKihonIryo(
                    ChosaKekkaKubunIryo.Tenteki.ない,
                    ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある,
                    ChosaKekkaKubunIryo.Toseki.ない,
                    ChosaKekkaKubunIryo.StomaShochi.ある,
                    ChosaKekkaKubunIryo.SansoRyoho.ない,
                    ChosaKekkaKubunIryo.Respirator.ある,
                    ChosaKekkaKubunIryo.KikanSekkai.ない,
                    ChosaKekkaKubunIryo.TotsuKango.ある,
                    ChosaKekkaKubunIryo.KeikanEiyo.ない,
                    ChosaKekkaKubunIryo.MonitorSokutei.ある,
                    ChosaKekkaKubunIryo.JokusoShochi.ない,
                    null);
        }
    }
}
