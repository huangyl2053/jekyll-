/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ShujiiIkenshoResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.IkenshosakuseiIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.ShujiiIkenshoResultMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoDoctorCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoItemKubun.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * 主治医意見書情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class ShujiiIkenshoMapperTest {

    public static class toShujiiIkenshoResult_基本情報 {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoResult_get申請書管理番号は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get申請書管理番号(), is(new ShinseishoKanriNo(new RString("1234567890"))));
        }

        @Test
        public void 意見書履歴番号の設定がある時_toShujiiIkenshoResult_get意見書履歴番号は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書履歴番号(), is(new IkenshosakuseiIraiRirekiNo(0)));
        }

        @Test
        public void 意見書依頼区分の設定がある時_toShujiiIkenshoResult_get意見書依頼区分は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書依頼区分(), is(ShujiiIkenshoIraiKubun.初回));
        }

        @Test
        public void 主治医の設定がある時_toShujiiIkenshoResult_get主治医は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get主治医().get介護医師コード(), is(new KaigoDoctorCode(new RString("介護医師コード"))));
        }

        @Test
        public void 意見書受領年月日の設定がある時_toShujiiIkenshoResult_get意見書受領年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書受領年月日(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 意見書記入年月日の設定がある時_toShujiiIkenshoResult_get意見書記入年月日は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書記入年月日(), is(new FlexibleDate("20140202")));
        }

        @Test
        public void 意見書作成回数の設定がある時_toShujiiIkenshoResult_get意見書作成回数は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書作成回数(), is(ShujiiIkenshoSakuseiKaisu.二回目以上));
        }

        @Test
        public void 意見書作成料種別の設定がある時_toShujiiIkenshoResult_get意見書作成料種別は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().get意見書作成料種別(), is(ShujiiIkenshoSakuseiryoShubetsu.施設));
        }

        @Test
        public void 認定情報提供希望の設定がある時_toShujiiIkenshoResult_is認定情報提供希望は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().is認定情報提供希望(), is(true));
        }

        @Test
        public void 意見書同意の設定がある時_toShujiiIkenshoResult_is意見書同意は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get基本情報().is意見書同意(), is(false));
        }
    }

    public static class toShujiiIkenshoResult_詳細情報 {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoResult_get申請書管理番号は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get申請書管理番号(), is(new ShinseishoKanriNo(new RString("1234567890"))));
        }

        @Test
        public void 意見書履歴番号の設定がある時_toShujiiIkenshoResult_get意見書履歴番号は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get意見書履歴番号(), is(new IkenshosakuseiIraiRirekiNo(0)));
        }

        @Test
        public void 厚労省IF識別区分の設定がある時_toNinteichosaResult_get厚労省IF識別区分は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get厚労省IF識別区分(), is(KoroshoIFKubun.V09A));
        }

        @Test
        public void 診断名1の設定がある時_toNinteichosaResult_get診断名1は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(診断名1).get意見書結果(), is(new RString("診断名1")));
        }

        @Test
        public void 発症年月日1の設定がある時_toNinteichosaResult_get発症年月日1は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(発症年月日1).get意見書結果(), is(new RString("20140101")));
        }

        @Test
        public void 診断名2の設定がある時_toNinteichosaResult_get診断名2は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(診断名2).get意見書結果(), is(new RString("診断名2")));
        }

        @Test
        public void 発症年月日2の設定がある時_toNinteichosaResult_get発症年月日2は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(発症年月日2).get意見書結果(), is(new RString("20140202")));
        }

        @Test
        public void 診断名3の設定がある時_toNinteichosaResult_get診断名3は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(診断名3).get意見書結果(), is(new RString("診断名3")));
        }

        @Test
        public void 発症年月日3の設定がある時_toNinteichosaResult_get発症年月日3は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(発症年月日3).get意見書結果(), is(new RString("20140303")));
        }

        @Test
        public void 症状の安定性の設定がある時_toNinteichosaResult_get症状の安定性は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(症状の安定性).get意見書結果(), is(Antei.安定.getCode()));
        }

        @Test
        public void 具体的な状況の設定がある時_toNinteichosaResult_get具体的な状況は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(具体的な状況).get意見書結果(), is(new RString("具体的な状況")));
        }

        @Test
        public void 治療内容の設定がある時_toNinteichosaResult_get治療内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(治療内容).get意見書結果(), is(new RString("治療内容")));
        }

        @Test
        public void 点滴の管理の設定がある時_toNinteichosaResult_get点滴の管理は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(点滴の管理).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toNinteichosaResult_get中心静脈栄養は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(中心静脈栄養).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 透析の設定がある時_toNinteichosaResult_get透析は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(透析).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toNinteichosaResult_getストーマの処置は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(ストーマの処置).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toNinteichosaResult_get酸素療法は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(酸素療法).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toNinteichosaResult_getレスピレーターは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(レスピレーター).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toNinteichosaResult_get気管切開の処置は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(気管切開の処置).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toNinteichosaResult_get疼痛の看護は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(疼痛の看護).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toNinteichosaResult_get経管栄養は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(経管栄養).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toNinteichosaResult_getモニター測定は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(モニター測定).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 褥瘡の処置の設定がある時_toNinteichosaResult_get褥瘡の処置は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(褥瘡の処置).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toNinteichosaResult_getカテーテルは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(カテーテル).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 障害高齢者日常生活自立度の設定がある時_toNinteichosaResult_get障害高齢者日常生活自立度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(障害高齢者日常生活自立度).get意見書結果(), is(ShogaiJiritsu.Ａ１.getCode()));
        }

        @Test
        public void 認知症高齢者日常生活自立度の設定がある時_toNinteichosaResult_get認知症高齢者日常生活自立度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知症高齢者日常生活自立度).get意見書結果(), is(NinchishoJiritsu.Ⅱａ.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toNinteichosaResult_get短期記憶は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(短期記憶).get意見書結果(), is(MondaiNashiAri.問題なし.getCode()));
        }

        @Test
        public void 認知能力の設定がある時_toNinteichosaResult_get認知能力は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知能力).get意見書結果(), is(Ninchi.見守りが必要.getCode()));
        }

        @Test
        public void 伝達能力の設定がある時_toNinteichosaResult_get伝達能力は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(伝達能力).get意見書結果(), is(Dentatsu.いくらか困難.getCode()));
        }

        @Test
        public void 認知症の周辺症状の設定がある時_toNinteichosaResult_get認知症の周辺症状は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知症の周辺症状).get意見書結果(), is(NashiAri.無.getCode()));
        }

        @Test
        public void 幻視幻聴の設定がある時_toNinteichosaResult_get幻視幻聴は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(幻視幻聴).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 妄想の設定がある時_toNinteichosaResult_get妄想は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(妄想).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toNinteichosaResult_get昼夜逆転は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(昼夜逆転).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 暴言の設定がある時_toNinteichosaResult_get暴言は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(暴言).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 暴行の設定がある時_toNinteichosaResult_get暴行は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(暴行).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 介護への抵抗の設定がある時_toNinteichosaResult_get介護への抵抗は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(介護への抵抗).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 認知症_徘徊の設定がある時_toNinteichosaResult_get認知症_徘徊は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知症_徘徊).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 火の不始末の設定がある時_toNinteichosaResult_get火の不始末は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(火の不始末).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 不潔行為の設定がある時_toNinteichosaResult_get不潔行為は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(不潔行為).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 異食行動の設定がある時_toNinteichosaResult_get異食行動は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(異食行動).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 性的問題行動の設定がある時_toNinteichosaResult_get性的問題行動は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(性的問題行動).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 認知症_その他の設定がある時_toNinteichosaResult_get認知症_その他は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知症_その他).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 認知症_その他内容の設定がある時_toNinteichosaResult_get認知症_その他内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(認知症_その他内容).get意見書結果(), is(new RString("認知症_その他内容")));
        }

        @Test
        public void 精神_神経症状の設定がある時_toNinteichosaResult_get精神_神経症状は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(精神_神経症状).get意見書結果(), is(NashiAri.有.getCode()));
        }

        @Test
        public void 精神_神経症状名の設定がある時_toNinteichosaResult_get精神_神経症状名は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(精神_神経症状名).get意見書結果(), is(new RString("精神_神経症状名")));
        }

        @Test
        public void 専門科医受診の設定がある時_toNinteichosaResult_get専門科医受診は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(専門科医受診).get意見書結果(), is(AriNashi.無.getCode()));
        }

        @Test
        public void 専門科医受診内容の設定がある時_toNinteichosaResult_get専門科医受診内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(専門科医受診内容).get意見書結果(), is(new RString("専門科医受診内容")));
        }

        @Test
        public void 利き腕の設定がある時_toNinteichosaResult_get利き腕は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(利き腕).get意見書結果(), is(MigiHidari.右.getCode()));
        }

        @Test
        public void 身長の設定がある時_toNinteichosaResult_get身長は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(身長).get意見書結果(), is(new RString("160")));
        }

        @Test
        public void 体重の設定がある時_toNinteichosaResult_get体重は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(体重).get意見書結果(), is(new RString("50")));
        }

        @Test
        public void 体重の変化の設定がある時_toNinteichosaResult_get体重の変化は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(体重の変化).get意見書結果(), is(ZokaGensho.維持.getCode()));
        }

        @Test
        public void 四肢欠損の設定がある時_toNinteichosaResult_get四肢欠損は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(四肢欠損).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 四肢欠損部位の設定がある時_toNinteichosaResult_get四肢欠損部位は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(四肢欠損部位).get意見書結果(), is(new RString("四肢欠損部位")));
        }

        @Test
        public void 四肢欠損程度の設定がある時_toNinteichosaResult_get四肢欠損程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(四肢欠損程度).get意見書結果(), is(Teido.中.getCode()));
        }

        @Test
        public void 麻痺の設定がある時_toNinteichosaResult_get麻痺は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 麻痺程度の設定がある時_toNinteichosaResult_get麻痺程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺程度).get意見書結果(), is(Teido.重.getCode()));
        }

        @Test
        public void 麻痺_左上肢の設定がある時_toNinteichosaResult_get麻痺_左上肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺_左上肢).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 麻痺_右上肢の設定がある時_toNinteichosaResult_get麻痺_右上肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺_右上肢).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 麻痺_左下肢の設定がある時_toNinteichosaResult_get麻痺_左下肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺_左下肢).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 麻痺_右下肢の設定がある時_toNinteichosaResult_get麻痺_右下肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺_右下肢).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 麻痺_その他の設定がある時_toNinteichosaResult_get麻痺_その他は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(麻痺_その他).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 筋力低下の設定がある時_toNinteichosaResult_get筋力低下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(筋力低下).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 筋力低下部位の設定がある時_toNinteichosaResult_get筋力低下部位は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(筋力低下部位).get意見書結果(), is(new RString("筋力低下部位")));
        }

        @Test
        public void 筋力低下程度の設定がある時_toNinteichosaResult_get筋力低下程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(筋力低下程度).get意見書結果(), is(Teido.軽.getCode()));
        }

        @Test
        public void 関節の拘縮_右肩の設定がある時_toNinteichosaResult_get関節の拘縮_右肩は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_右肩).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 関節の拘縮_左肩の設定がある時_toNinteichosaResult_get関節の拘縮_左肩は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_左肩).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 関節の拘縮_右肘の設定がある時_toNinteichosaResult_get関節の拘縮_右肘は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_右肘).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 関節の拘縮_左肘の設定がある時_toNinteichosaResult_get関節の拘縮_左肘は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_左肘).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 関節の拘縮_右股の設定がある時_toNinteichosaResult_get関節の拘縮_右股は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_右股).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 関節の拘縮_左股の設定がある時_toNinteichosaResult_get関節の拘縮_左股は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_左股).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 関節の拘縮_右膝の設定がある時_toNinteichosaResult_get関節の拘縮_右膝は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_右膝).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 関節の拘縮_左膝の設定がある時_toNinteichosaResult_get関節の拘縮_左膝は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮_左膝).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 関節の拘縮程度の設定がある時_toNinteichosaResult_get関節の拘縮程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の拘縮程度).get意見書結果(), is(Teido.重.getCode()));
        }

        @Test
        public void 関節の痛みの設定がある時_toNinteichosaResult_get関節の痛みは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の痛み).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 関節の痛み部位の設定がある時_toNinteichosaResult_get関節の痛み部位は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の痛み部位).get意見書結果(), is(new RString("関節の痛み部位")));
        }

        @Test
        public void 関節の痛み程度の設定がある時_toNinteichosaResult_get関節の痛み程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(関節の痛み程度).get意見書結果(), is(Teido.中.getCode()));
        }

        @Test
        public void 失調不随意の設定がある時_toNinteichosaResult_get失調不随意は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 失調不随意_右上肢の設定がある時_toNinteichosaResult_get失調不随意_右上肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_右上肢).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 失調不随意_左上肢の設定がある時_toNinteichosaResult_get失調不随意_左上肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_左上肢).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 失調不随意_右体幹の設定がある時_toNinteichosaResult_get失調不随意_右体幹は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_右体幹).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 失調不随意_左体幹の設定がある時_toNinteichosaResult_get失調不随意_左体幹は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_左体幹).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 失調不随意_右下肢の設定がある時_toNinteichosaResult_get失調不随意_右下肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_右下肢).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 失調不随意_左下肢の設定がある時_toNinteichosaResult_get失調不随意_左下肢は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(失調不随意_左下肢).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void じょくそうの設定がある時_toNinteichosaResult_getじょくそうは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(じょくそう).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void じょくそう部位の設定がある時_toNinteichosaResult_getじょくそう部位は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(じょくそう部位).get意見書結果(), is(new RString("じょくそう部位")));
        }

        @Test
        public void じょくそう程度の設定がある時_toNinteichosaResult_getじょくそう程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(じょくそう程度).get意見書結果(), is(Teido.軽.getCode()));
        }

        @Test
        public void その他皮膚疾患の設定がある時_toNinteichosaResult_getその他皮膚疾患は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他皮膚疾患).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void その他皮膚疾患部位の設定がある時_toNinteichosaResult_getその他皮膚疾患部位は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他皮膚疾患部位).get意見書結果(), is(new RString("その他皮膚疾患部位")));
        }

        @Test
        public void その他皮膚疾患程度の設定がある時_toNinteichosaResult_getその他皮膚疾患程度は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他皮膚疾患程度).get意見書結果(), is(Teido.重.getCode()));
        }

        @Test
        public void 屋外歩行の設定がある時_toNinteichosaResult_get屋外歩行は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(屋外歩行).get意見書結果(), is(Kaijo4.自立.getCode()));
        }

        @Test
        public void 車椅子の使用の設定がある時_toNinteichosaResult_get車椅子の使用は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(車椅子の使用).get意見書結果(), is(Kurumaisu.用いていない.getCode()));
        }

        @Test
        public void 歩行補助具_装具未使用の設定がある時_toNinteichosaResult_get歩行補助具_装具未使用は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(歩行補助具_装具未使用).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 歩行補助具_装具屋外使用の設定がある時_toNinteichosaResult_get歩行補助具_装具屋外使用は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(歩行補助具_装具屋外使用).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 歩行補助具_装具屋内使用の設定がある時_toNinteichosaResult_get歩行補助具_装具屋内使用は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(歩行補助具_装具屋内使用).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 食事行為の設定がある時_toNinteichosaResult_get食事行為は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(食事行為).get意見書結果(), is(Shokuji.自立ないし何とか自分で食べられる.getCode()));
        }

        @Test
        public void 現在の栄養状態の設定がある時_toNinteichosaResult_get現在の栄養状態は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(現在の栄養状態).get意見書結果(), is(Jotai.良好.getCode()));
        }

        @Test
        public void 栄養_食生活留意点の設定がある時_toNinteichosaResult_get栄養_食生活留意点は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(栄養_食生活留意点).get意見書結果(), is(new RString("栄養_食生活留意点")));
        }

        @Test
        public void 尿失禁の設定がある時_toNinteichosaResult_get尿失禁は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(尿失禁).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 転倒_骨折の設定がある時_toNinteichosaResult_get転倒_骨折は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(転倒_骨折).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 移動能力の低下の設定がある時_toNinteichosaResult_get移動能力の低下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(移動能力の低下).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 褥瘡の設定がある時_toNinteichosaResult_get褥瘡は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(褥瘡).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 心肺機能の低下の設定がある時_toNinteichosaResult_get心肺機能の低下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(心肺機能の低下).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 閉じこもりの設定がある時_toNinteichosaResult_get閉じこもりは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(閉じこもり).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 意欲低下の設定がある時_toNinteichosaResult_get意欲低下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(意欲低下).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toNinteichosaResult_get徘徊は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(徘徊).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 低栄養の設定がある時_toNinteichosaResult_get低栄養_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(低栄養).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 摂食_嚥下機能低下の設定がある時_toNinteichosaResult_get摂食_嚥下機能低下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(摂食_嚥下機能低下).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 脱水の設定がある時_toNinteichosaResult_get脱水は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(脱水).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 易感染症の設定がある時_toNinteichosaResult_get易感染症は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(易感染症).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void がん等による疼痛の設定がある時_toNinteichosaResult_getがん等による疼痛は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(がん等による疼痛).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void その他状態の設定がある時_toNinteichosaResult_getその他状態は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他状態).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void その他状態内容の設定がある時_toNinteichosaResult_getその他状態内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他状態内容).get意見書結果(), is(new RString("その他状態内容")));
        }

        @Test
        public void 状態対処方針の設定がある時_toNinteichosaResult_get状態対処方針は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(状態対処方針).get意見書結果(), is(new RString("状態対処方針")));
        }

        @Test
        public void 介護の必要な程度に関する予後の見直しの設定がある時_toNinteichosaResult_get介護の必要な程度に関する予後の見直しは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(介護の必要な程度に関する予後の見直し).get意見書結果(), is(Kitai.期待できる.getCode()));
        }

        @Test
        public void 訪問診療の設定がある時_toNinteichosaResult_get訪問診療は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問診療).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 訪問看護の設定がある時_toNinteichosaResult_get訪問看護は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問看護).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 看護職員の訪問による相談_支援の設定がある時_toNinteichosaResult_get看護職員の訪問による相談_支援は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(看護職員の訪問による相談_支援).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 訪問歯科診療の設定がある時_toNinteichosaResult_get訪問歯科診療は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問歯科診療).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 訪問薬剤管理指導の設定がある時_toNinteichosaResult_get訪問薬剤管理指導は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問薬剤管理指導).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 訪問リハビリテーションの設定がある時_toNinteichosaResult_get訪問リハビリテーションは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問リハビリテーション).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toNinteichosaResult_get短期入所療養介護は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(短期入所療養介護).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 訪問歯科衛生指導の設定がある時_toNinteichosaResult_get訪問歯科衛生指導は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問歯科衛生指導).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void 訪問栄養食事指導の設定がある時_toNinteichosaResult_get訪問栄養食事指導は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(訪問栄養食事指導).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toNinteichosaResult_get通所リハビリテーションは_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(通所リハビリテーション).get意見書結果(), is(Checked.無し.getCode()));
        }

        @Test
        public void その他医学的管理の設定がある時_toNinteichosaResult_getその他医学的管理は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他医学的管理).get意見書結果(), is(Checked.有り.getCode()));
        }

        @Test
        public void 血圧の設定がある時_toNinteichosaResult_get血圧は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(血圧).get意見書結果(), is(NashiAri3.あり.getCode()));
        }

        @Test
        public void 血圧内容の設定がある時_toNinteichosaResult_get血圧内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(血圧内容).get意見書結果(), is(new RString("血圧内容")));
        }

        @Test
        public void 移動の設定がある時_toNinteichosaResult_get移動は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(移動).get意見書結果(), is(NashiAri3.特になし.getCode()));
        }

        @Test
        public void 移動内容の設定がある時_toNinteichosaResult_get移動内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(移動内容).get意見書結果(), is(new RString("移動内容")));
        }

        @Test
        public void 摂食の設定がある時_toNinteichosaResult_get摂食は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(摂食).get意見書結果(), is(NashiAri3.あり.getCode()));
        }

        @Test
        public void 摂食内容の設定がある時_toNinteichosaResult_get摂食内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(摂食内容).get意見書結果(), is(new RString("摂食内容")));
        }

        @Test
        public void 運動の設定がある時_toNinteichosaResult_get運動は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(運動).get意見書結果(), is(NashiAri3.特になし.getCode()));
        }

        @Test
        public void 運動内容の設定がある時_toNinteichosaResult_get運動内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(運動内容).get意見書結果(), is(new RString("運動内容")));
        }

        @Test
        public void 嚥下の設定がある時_toNinteichosaResult_get嚥下は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(嚥下).get意見書結果(), is(NashiAri3.あり.getCode()));
        }

        @Test
        public void 嚥下内容の設定がある時_toNinteichosaResult_get嚥下内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(嚥下内容).get意見書結果(), is(new RString("嚥下内容")));
        }

        @Test
        public void その他留意事項の設定がある時_toNinteichosaResult_getその他留意事項は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(その他留意事項).get意見書結果(), is(new RString("その他留意事項")));
        }

        @Test
        public void 感染症の設定がある時_toNinteichosaResult_get感染症は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(感染症).get意見書結果(), is(NashiAri2.無.getCode()));
        }

        @Test
        public void 感染症内容の設定がある時_toNinteichosaResult_get感染症内容は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(感染症内容).get意見書結果(), is(new RString("感染症内容")));
        }

        @Test
        public void 特記事項の設定がある時_toNinteichosaResult_get特記事項は_設定値を返す() {
            assertThat(toShujiiIkenshoResult().get詳細情報().get主治医意見書().get意見書項目(特記事項).get意見書結果(), is(new RString("特記事項")));
        }
    }

    public static class toShujiiIkenshoEntity_getDbT5012ShujiiIkenshoJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("1234567890"))));
        }

        @Test
        public void 主治医意見書依頼区分の設定がある時_toShujiiIkenshoEntity_getIkenshoIraiKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoIraiKubun(), is(ShujiiIkenshoIraiKubun.初回.getCode()));
        }

        @Test
        public void 要介護認定主治医意見書履歴番号の設定がある時_toShujiiIkenshoEntity_getIkenshoIraiRirekiNoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoIraiRirekiNo(), is(0));
        }

        @Test
        public void 主治医医療機関コードの設定がある時_toShujiiIkenshoEntity_getShujiiIryoKikanCodeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getShujiiIryoKikanCode(), is(new RString("介護医療機関コード")));
        }

        @Test
        public void 主治医コードの設定がある時_toShujiiIkenshoEntity_getShujiiCodeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getShujiiCode(), is(new RString("介護医師コード")));
        }

        @Test
        public void 主治医意見書受領年月日の設定がある時_toShujiiIkenshoEntity_getIkenshoJuryoYMDは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoJuryoYMD(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 主治医意見書記入年月日の設定がある時_toShujiiIkenshoEntity_getIkenshoKinyuYMDは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoKinyuYMD(), is(new FlexibleDate("20140202")));
        }

        @Test
        public void 意見書作成回数の設定がある時_toShujiiIkenshoEntity_getIkenshoSakuseiKaisuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoSakuseiKaisu(), is(ShujiiIkenshoSakuseiKaisu.二回目以上.getCode()));
        }

        @Test
        public void 意見書作成料種別の設定がある時_toShujiiIkenshoEntity_getIkenshoSakuseiryoShubetsuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoSakuseiryoShubetsu(), is(ShujiiIkenshoSakuseiryoShubetsu.施設.getCode()));
        }

        @Test
        public void 認定情報提希望有フラグの設定がある時_toShujiiIkenshoEntity_getNinteiJohoTeikyoKiboFlagは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getNinteiJohoTeikyoKiboFlag(), is(true));
        }

        @Test
        public void 意見書同意有無フラグの設定がある時_toShujiiIkenshoEntity_getIkenshoDoiUmuFlagは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5012ShujiiIkenshoJohoEntity().getIkenshoDoiUmuFlag(), is(false));
        }
    }

    public static class toShujiiIkenshoEntity_getDbT5013ShujiiIkenshoShosaiJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toShujiiIkenshoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getShinseishoKanriNo(), is(new ShinseishoKanriNo(new RString("1234567890"))));
        }

        @Test
        public void 要介護認定主治医意見書履歴番号の設定がある時_toShujiiIkenshoEntity_getIkenshoIraiRirekiNoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIkenshoIraiRirekiNo(), is(0));
        }

        @Test
        public void 厚労省IF識別コードの設定がある時_toShujiiIkenshoEntity_getKoroshoIfShikibetsuCodeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getKoroshoIfShikibetsuCode(), is(KoroshoIFKubun.V09A.getCode()));
        }

        @Test
        public void 診断名1の設定がある時_toShujiiIkenshoEntity_getIk_shindamMei1は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shindamMei1(), is(new RString("診断名1")));
        }

        @Test
        public void 発症年月日1の設定がある時_toShujiiIkenshoEntity_getIk_hasshoYMD1は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_hasshoYMD1(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 診断名2の設定がある時_toShujiiIkenshoEntity_getIk_shindamMei2は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shindamMei2(), is(new RString("診断名2")));
        }

        @Test
        public void 発症年月日2の設定がある時_toShujiiIkenshoEntity_getIk_hasshoYMD2は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_hasshoYMD2(), is(new FlexibleDate("20140202")));
        }

        @Test
        public void 診断名3の設定がある時_toShujiiIkenshoEntity_getIk_shindamMei3は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shindamMei3(), is(new RString("診断名3")));
        }

        @Test
        public void 発症年月日3の設定がある時_toShujiiIkenshoEntity_getIk_hasshoYMD3は_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_hasshoYMD3(), is(new FlexibleDate("20140303")));
        }

        @Test
        public void 症状の安定性の設定がある時_toShujiiIkenshoEntity_getIk_anteiseiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_anteisei(), is(Antei.安定.getCode()));
        }

        @Test
        public void 具体的な状況の設定がある時_toShujiiIkenshoEntity_getIk_anteiseiHuanteiJokyoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_anteiseiHuanteiJokyo(), is(new RString("具体的な状況")));
        }

        @Test
        public void 治療内容の設定がある時_toShujiiIkenshoEntity_getIk_chiryoNaiyoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_chiryoNaiyo(), is(new RString("治療内容")));
        }

        @Test
        public void 点滴の管理の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoTentekiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoTentekiUmuKubun(), is(true));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun(), is(false));
        }

        @Test
        public void 透析の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoTosekiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoTosekiUmuKubun(), is(true));
        }

        @Test
        public void ストーマの処置の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoStomaShochiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoStomaShochiUmuKubun(), is(false));
        }

        @Test
        public void 酸素療法の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoSansoRyohoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoSansoRyohoUmuKubun(), is(true));
        }

        @Test
        public void レスピレーターの設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoRespiratorUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoRespiratorUmuKubun(), is(false));
        }

        @Test
        public void 気管切開の処置の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoKikanSekkaiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoKikanSekkaiUmuKubun(), is(true));
        }

        @Test
        public void 疼痛の看護の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoTotsuKangoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoTotsuKangoUmuKubun(), is(false));
        }

        @Test
        public void 経管栄養の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoKeikanEiyoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoKeikanEiyoUmuKubun(), is(true));
        }

        @Test
        public void モニター測定の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoMonitorSokuteiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoMonitorSokuteiUmuKubun(), is(false));
        }

        @Test
        public void 褥瘡の処置の設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoJokusoShochiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoJokusoShochiUmuKubun(), is(true));
        }

        @Test
        public void カテーテルの設定がある時_toShujiiIkenshoEntity_getIk_tokubetsuIryoCatheterUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokubetsuIryoCatheterUmuKubun(), is(false));
        }

        @Test
        public void 障害高齢者日常生活自立度の設定がある時_toShujiiIkenshoEntity_getIk_seikatsuJiritsudoShyogaiCodeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_seikatsuJiritsudoShyogaiCode(), is(new Code(ShogaiJiritsu.Ａ１.getCode())));
        }

        @Test
        public void 認知症高齢者日常生活自立度の設定がある時_toShujiiIkenshoEntity_getIk_seikatsuJiritsudoNinchshoCodeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_seikatsuJiritsudoNinchshoCode(), is(new Code(NinchishoJiritsu.Ⅱａ.getCode())));
        }

        @Test
        public void 短期記憶の設定がある時_toShujiiIkenshoEntity_getIk_chukakuShojoTankiKiokuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_chukakuShojoTankiKioku(), is(MondaiNashiAri.問題なし.getCode()));
        }

        @Test
        public void 認知能力の設定がある時_toShujiiIkenshoEntity_getIk_chukakuShojoNinchiNoryokuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_chukakuShojoNinchiNoryoku(), is(Ninchi.見守りが必要.getCode()));
        }

        @Test
        public void 伝達能力の設定がある時_toShujiiIkenshoEntity_getIk_chukakuShojoDentatsuNoryokuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_chukakuShojoDentatsuNoryoku(), is(Dentatsu.いくらか困難.getCode()));
        }

        @Test
        public void 認知症の周辺症状の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoUmuKubun(), is(false));
        }

        @Test
        public void 幻視幻聴の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoGenshiGenchoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoGenshiGenchoUmuKubun(), is(true));
        }

        @Test
        public void 妄想の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoMosoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoMosoUmuKubun(), is(false));
        }

        @Test
        public void 昼夜逆転の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoChuyaGakutenUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoChuyaGakutenUmuKubun(), is(true));
        }

        @Test
        public void 暴言の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoBogenUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoBogenUmuKubun(), is(false));
        }

        @Test
        public void 暴行の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoBokoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoBokoUmuKubun(), is(true));
        }

        @Test
        public void 介護への抵抗の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoKaigoHenoTeikoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoKaigoHenoTeikoUmuKubun(), is(false));
        }

        @Test
        public void 認知症_徘徊の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoHaikaiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoHaikaiUmuKubun(), is(true));
        }

        @Test
        public void 火の不始末の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoHiNoFushimatsuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoHiNoFushimatsuUmuKubun(), is(false));
        }

        @Test
        public void 不潔行為の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoFuketsuKoiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoFuketsuKoiUmuKubun(), is(true));
        }

        @Test
        public void 異食行動の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoIshokuKodoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoIshokuKodoUmuKubun(), is(false));
        }

        @Test
        public void 性的問題行動の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoSeitekiMondaiKodoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoSeitekiMondaiKodoUmuKubun(), is(true));
        }

        @Test
        public void 認知症_その他の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoSonotaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoSonotaUmuKubun(), is(false));
        }

        @Test
        public void 認知症_その他内容の設定がある時_toShujiiIkenshoEntity_getIk_shuhenShojoSonotaNaiyoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shuhenShojoSonotaNaiyo(), is(new RString("認知症_その他内容")));
        }

        @Test
        public void 精神_神経症状の設定がある時_toShujiiIkenshoEntity_getIk_seishinOrShinkeiShojoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_seishinOrShinkeiShojoUmuKubun(), is(true));
        }

        @Test
        public void 精神_神経症状名の設定がある時_toShujiiIkenshoEntity_getIk_seishinOrShinkeiShojoShimeiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_seishinOrShinkeiShojoShimei(), is(new RString("精神_神経症状名")));
        }

        @Test
        public void 専門科医受診の設定がある時_toShujiiIkenshoEntity_getIk_semmonkaiJushinUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_semmonkaiJushinUmuKubun(), is(false));
        }

        @Test
        public void 専門科医受診内容の設定がある時_toShujiiIkenshoEntity_getIk_semmonkaiJushinは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_semmonkaiJushin(), is(new RString("専門科医受診内容")));
        }

        @Test
        public void 利き腕の設定がある時_toShujiiIkenshoEntity_getIk_kikiudeKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kikiudeKubun(), is(MigiHidari.右.getCode()));
        }

        @Test
        public void 身長の設定がある時_toShujiiIkenshoEntity_getIk_shinchoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shincho(), is(160));
        }

        @Test
        public void 体重の設定がある時_toShujiiIkenshoEntity_getIk_taijuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_taiju(), is(50));
        }

        @Test
        public void 体重の変化の設定がある時_toShujiiIkenshoEntity_getIk_taijuHenkaは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_taijuHenka(), is(ZokaGensho.維持.getCode()));
        }

        @Test
        public void 四肢欠損の設定がある時_toShujiiIkenshoEntity_getIk_shishiKessonUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shishiKessonUmuKubun(), is(true));
        }

        @Test
        public void 四肢欠損部位の設定がある時_toShujiiIkenshoEntity_getIk_shishiKessonBuiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shishiKessonBui(), is(new RString("四肢欠損部位")));
        }

        @Test
        public void 四肢欠損程度の設定がある時_toShujiiIkenshoEntity_getIk_shishiKessonTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shishiKessonTeido(), is(Teido.中.getCode()));
        }

        @Test
        public void 麻痺の設定がある時_toShujiiIkenshoEntity_getIk_mahiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiUmuKubun(), is(true));
        }

        @Test
        public void 麻痺程度の設定がある時_toShujiiIkenshoEntity_getIk_mahiTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiTeido(), is(Teido.重.getCode()));
        }

        @Test
        public void 麻痺_左上肢の設定がある時_toShujiiIkenshoEntity_getIk_mahiHidariJoshiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiHidariJoshi(), is(Checked.有り.getCode()));
        }

        @Test
        public void 麻痺_右上肢の設定がある時_toShujiiIkenshoEntity_getIk_mahiMigiJoshiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiMigiJoshi(), is(Checked.無し.getCode()));
        }

        @Test
        public void 麻痺_左下肢の設定がある時_toShujiiIkenshoEntity_getIk_mahiHidariKashiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiHidariKashi(), is(Checked.有り.getCode()));
        }

        @Test
        public void 麻痺_右下肢の設定がある時_toShujiiIkenshoEntity_getIk_mahiMigiKashiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiMigiKashi(), is(Checked.無し.getCode()));
        }

        @Test
        public void 麻痺_その他の設定がある時_toShujiiIkenshoEntity_getIk_mahiSonotaは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_mahiSonota(), is(Checked.有り.getCode()));
        }

        @Test
        public void 筋力低下の設定がある時_toShujiiIkenshoEntity_getIk_kinryokuTeikaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kinryokuTeikaUmuKubun(), is(true));
        }

        @Test
        public void 筋力低下部位の設定がある時_toShujiiIkenshoEntity_getIk_kinryokuTeikaBuiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kinryokuTeikaBui(), is(new RString("筋力低下部位")));
        }

        @Test
        public void 筋力低下程度の設定がある時_toShujiiIkenshoEntity_getIk_kinryokuTeikaTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kinryokuTeikaTeido(), is(Teido.軽.getCode()));
        }

        @Test
        public void 関節の拘縮_右肩の設定がある時_toShujiiIkenshoEntity_getIk_koshukuMigiKataUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuMigiKataUmuKubun(), is(true));
        }

        @Test
        public void 関節の拘縮_左肩の設定がある時_toShujiiIkenshoEntity_getIk_koshukuHidariKataUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuHidariKataUmuKubun(), is(false));
        }

        @Test
        public void 関節の拘縮_右肘の設定がある時_toShujiiIkenshoEntity_getIk_koshukuMigiHijiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuMigiHijiUmuKubun(), is(true));
        }

        @Test
        public void 関節の拘縮_左肘の設定がある時_toShujiiIkenshoEntity_getIk_koshukuHidariHijiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuHidariHijiUmuKubun(), is(false));
        }

        @Test
        public void 関節の拘縮_右股の設定がある時_toShujiiIkenshoEntity_getIk_koshukuMigiMataUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuMigiMataUmuKubun(), is(true));
        }

        @Test
        public void 関節の拘縮_左股の設定がある時_toShujiiIkenshoEntity_getIk_koshukuHidariMataUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuHidariMataUmuKubun(), is(false));
        }

        @Test
        public void 関節の拘縮_右膝の設定がある時_toShujiiIkenshoEntity_getIk_koshukuMigiHizaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuMigiHizaUmuKubun(), is(true));
        }

        @Test
        public void 関節の拘縮_左膝の設定がある時_toShujiiIkenshoEntity_getIk_koshukuHidariHizaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_koshukuHidariHizaUmuKubun(), is(false));
        }

        @Test
        public void 関節の拘縮程度の設定がある時_toShujiiIkenshoEntity_getIk_kansetsuKoshukuTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansetsuKoshukuTeido(), is(Teido.重.getCode()));
        }

        @Test
        public void 関節の痛みの設定がある時_toShujiiIkenshoEntity_getIk_kansetsuItamiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansetsuItamiUmuKubun(), is(true));
        }

        @Test
        public void 関節の痛み部位の設定がある時_toShujiiIkenshoEntity_getIk_kansetsuItamiBuiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansetsuItamiBui(), is(new RString("関節の痛み部位")));
        }

        @Test
        public void 関節の痛み程度の設定がある時_toShujiiIkenshoEntity_getIk_kansatsuItamiTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansatsuItamiTeido(), is(Teido.中.getCode()));
        }

        @Test
        public void 失調不随意の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiUmuKubun(), is(true));
        }

        @Test
        public void 失調不随意_右上肢の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiMigiJoshiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiMigiJoshiUmuKubun(), is(false));
        }

        @Test
        public void 失調不随意_左上肢の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiHidariJoshiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiHidariJoshiUmuKubun(), is(true));
        }

        @Test
        public void 失調不随意_右体幹の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiMigiTaikanUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiMigiTaikanUmuKubun(), is(false));
        }

        @Test
        public void 失調不随意_左体幹の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiHidariTaikanUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiHidariTaikanUmuKubun(), is(true));
        }

        @Test
        public void 失調不随意_右下肢の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiMigiKashiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiMigiKashiUmuKubun(), is(false));
        }

        @Test
        public void 失調不随意_左下肢の設定がある時_toShujiiIkenshoEntity_getIk_huzuiiHidariKashiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_huzuiiHidariKashiUmuKubun(), is(true));
        }

        @Test
        public void じょくそうの設定がある時_toShujiiIkenshoEntity_getIk_jokusoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_jokusoUmuKubun(), is(false));
        }

        @Test
        public void じょくそう部位の設定がある時_toShujiiIkenshoEntity_getIk_jokusoBuiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_jokusoBui(), is(new RString("じょくそう部位")));
        }

        @Test
        public void じょくそう程度の設定がある時_toShujiiIkenshoEntity_getIk_jokusoTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_jokusoTeido(), is(Teido.軽.getCode()));
        }

        @Test
        public void その他皮膚疾患の設定がある時_toShujiiIkenshoEntity_getIk_sonotaHifuShikkanUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_sonotaHifuShikkanUmuKubun(), is(true));
        }

        @Test
        public void その他皮膚疾患部位の設定がある時_toShujiiIkenshoEntity_getIk_sonotaHifuShikkkanBuiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_sonotaHifuShikkkanBui(), is(new RString("その他皮膚疾患部位")));
        }

        @Test
        public void その他皮膚疾患程度の設定がある時_toShujiiIkenshoEntity_getIk_sonotaHifushikkanTeidoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_sonotaHifushikkanTeido(), is(Teido.重.getCode()));
        }

        @Test
        public void 屋外歩行の設定がある時_toShujiiIkenshoEntity_getIk_idoOkugaiHokoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_idoOkugaiHoko(), is(Kaijo4.自立.getCode()));
        }

        @Test
        public void 車椅子の使用の設定がある時_toShujiiIkenshoEntity_getIk_idoKurumaisuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_idoKurumaisu(), is(Kurumaisu.用いていない.getCode()));
        }

        @Test
        public void 歩行補助具_装具未使用の設定がある時_toShujiiIkenshoEntity_getIk_idoHokohojoguMishiyoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_idoHokohojoguMishiyo(), is(Checked.有り.getCode()));
        }

        @Test
        public void 歩行補助具_装具屋外使用の設定がある時_toShujiiIkenshoEntity_getIk_idoHokohojoguOkugaiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_idoHokohojoguOkugai(), is(Checked.無し.getCode()));
        }

        @Test
        public void 歩行補助具_装具屋内使用の設定がある時_toShujiiIkenshoEntity_getIk_idoHokohojoguOkunaiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_idoHokohojoguOkunai(), is(Checked.有り.getCode()));
        }

        @Test
        public void 食事行為の設定がある時_toShujiiIkenshoEntity_getIk_shokuseikatsuShokujiKoiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shokuseikatsuShokujiKoi(), is(Shokuji.自立ないし何とか自分で食べられる.getCode()));
        }

        @Test
        public void 現在の栄養状態の設定がある時_toShujiiIkenshoEntity_getIk_shokuseikatsuEiyoJotaiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shokuseikatsuEiyoJotai(), is(Jotai.良好.getCode()));
        }

        @Test
        public void 栄養_食生活留意点の設定がある時_toShujiiIkenshoEntity_getIk_shokuseikatsuRyuitenは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_shokuseikatsuRyuiten(), is(new RString("栄養_食生活留意点")));
        }

        @Test
        public void 尿失禁の設定がある時_toShujiiIkenshoEntity_getIk_probabilityNyoShikkinUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityNyoShikkinUmuKubun(), is(true));
        }

        @Test
        public void 転倒_骨折の設定がある時_toShujiiIkenshoEntity_getIk_probabilityTentoOrKossetsuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityTentoOrKossetsuUmuKubun(), is(false));
        }

        @Test
        public void 移動能力の低下の設定がある時_toShujiiIkenshoEntity_getIk_probabilityIdoNoryokuTeikaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityIdoNoryokuTeikaUmuKubun(), is(true));
        }

        @Test
        public void 褥瘡の設定がある時_toShujiiIkenshoEntity_getIk_probabilityJokusoUmuKubungetYYYYは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityJokusoUmuKubun(), is(false));
        }

        @Test
        public void 閉じこもりの設定がある時_toShujiiIkenshoEntity_getIk_probabilityTojikomoriUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityTojikomoriUmuKubun(), is(false));
        }

        @Test
        public void 意欲低下の設定がある時_toShujiiIkenshoEntity_getIk_probabilitiyIyokuTeikaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilitiyIyokuTeikaUmuKubun(), is(true));
        }

        @Test
        public void 徘徊の設定がある時_toShujiiIkenshoEntity_getIk_probabilityHaikaiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityHaikaiUmuKubun(), is(false));
        }

        @Test
        public void 低栄養の設定がある時_toShujiiIkenshoEntity_getIk_probabilityTeiEiyoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityTeiEiyoUmuKubun(), is(true));
        }

        @Test
        public void 摂食_嚥下機能低下の設定がある時_toShujiiIkenshoEntity_getIk_probabilitySesshokuEngiKinoTeikaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilitySesshokuEngiKinoTeikaUmuKubun(), is(false));
        }

        @Test
        public void 脱水の設定がある時_toShujiiIkenshoEntity_getIk_probabilityDassuiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityDassuiUmuKubun(), is(true));
        }

        @Test
        public void 易感染症の設定がある時_toShujiiIkenshoEntity_getIk_probabilityIkansenshoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityIkansenshoUmuKubun(), is(false));
        }

        @Test
        public void がん等による疼痛の設定がある時_toShujiiIkenshoEntity_getIk_probabilityTotsuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityTotsuUmuKubun(), is(true));
        }

        @Test
        public void その他状態の設定がある時_toShujiiIkenshoEntity_getIk_probabilitySonotaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilitySonotaUmuKubun(), is(false));
        }

        @Test
        public void その他状態内容の設定がある時_toShujiiIkenshoEntity_getIk_probabilitySonotaNaiyoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilitySonotaNaiyo(), is(new RString("その他状態内容")));
        }

        @Test
        public void 嚥下性肺炎の設定がある時_toShujiiIkenshoEntity_getIk_probabilityEngeseiHaienUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityEngeseiHaienUmuKubun(), is(false));
        }

        @Test
        public void 腸閉塞の設定がある時_toShujiiIkenshoEntity_getIk_probabilityChoHeisokuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityChoHeisokuUmuKubun(), is(false));
        }

        @Test
        public void 心肺機能の低下の設定がある時_toShujiiIkenshoEntity_getIk_probabilityShinpaiKinoTeikaUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityShinpaiKinoTeikaUmuKubun(), is(true));
        }

        @Test
        public void 痛みの設定がある時_toShujiiIkenshoEntity_getIk_probabilityItamiUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityItamiUmuKubun(), is(false));
        }

        @Test
        public void 状態対処方針の設定がある時_toShujiiIkenshoEntity_getIk_probabilityTaishoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_probabilityTaisho(), is(new RString("状態対処方針")));
        }

        @Test
        public void 介護の必要な程度に関する予後の見直しの設定がある時_toShujiiIkenshoEntity_getIk_yogoMitoshiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_yogoMitoshi(), is(Kitai.期待できる.getCode()));
        }

        @Test
        public void サービス利用による生活機能の維持_改善の見通しの設定がある時_toShujiiIkenshoEntity_getIk_ijiKaizenMitoshiは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ijiKaizenMitoshi(), nullValue());
        }

        @Test
        public void 訪問診療の設定がある時_toShujiiIkenshoEntity_getIk_homonShinryoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonShinryoUmuKubun(), is(true));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toShujiiIkenshoEntity_getIk_tankiNyushoRyoyoKaigoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tankiNyushoRyoyoKaigoUmuKubun(), is(true));
        }

        @Test
        public void 訪問栄養食事指導の設定がある時_toShujiiIkenshoEntity_getIk_homonEiyoShokujiShidoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonEiyoShokujiShidoUmuKubun(), is(true));
        }

        @Test
        public void 訪問看護の設定がある時_toShujiiIkenshoEntity_getIk_homonKangoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonKangoUmuKubun(), is(false));
        }

        @Test
        public void 訪問歯科診療の設定がある時_toShujiiIkenshoEntity_getIk_homonShikaShinryoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonShikaShinryoUmuKubun(), is(false));
        }

        @Test
        public void 訪問リハビリテーションの設定がある時_toShujiiIkenshoEntity_getIk_homonRihabilitationUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonRihabilitationUmuKubun(), is(false));
        }

        @Test
        public void 訪問歯科衛生指導の設定がある時_toShujiiIkenshoEntity_getIk_homonShikaEiseiShidoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonShikaEiseiShidoUmuKubun(), is(false));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toShujiiIkenshoEntity_getIk_tushoRihabilitationUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tushoRihabilitationUmuKubun(), is(false));
        }

        @Test
        public void 訪問薬剤管理指導の設定がある時_toShujiiIkenshoEntity_getIk_homonYakuzaiKanriShidoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_homonYakuzaiKanriShidoUmuKubun(), is(true));
        }

        @Test
        public void その他医学的管理の設定がある時_toShujiiIkenshoEntity_getIk_sonotaIgakutekiKanriUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_sonotaIgakutekiKanriUmuKubun(), is(true));
        }

        @Test
        public void 血圧の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoKetsuatsuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoKetsuatsuUmuKubun(), is(true));
        }

        @Test
        public void 血圧内容の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoKetsuatsuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoKetsuatsu(), is(new RString("血圧内容")));
        }

        @Test
        public void 摂食の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoSesshokuUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoSesshokuUmuKubun(), is(true));
        }

        @Test
        public void 摂食内容の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoSesshokuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoSesshoku(), is(new RString("摂食内容")));
        }

        @Test
        public void 嚥下の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoEngeUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoEngeUmuKubun(), is(true));
        }

        @Test
        public void 嚥下内容の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoEngeは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoEnge(), is(new RString("嚥下内容")));
        }

        @Test
        public void 移動の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoIdoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoIdoUmuKubun(), is(false));
        }

        @Test
        public void 移動内容の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoIdoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoIdo(), is(new RString("移動内容")));
        }

        @Test
        public void 運動の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoUndoUmuKubunは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoUndoUmuKubun(), is(false));
        }

        @Test
        public void 運動内容の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoUndoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoUndo(), is(new RString("運動内容")));
        }

        @Test
        public void その他留意事項の設定がある時_toShujiiIkenshoEntity_getIk_ryuiJikoSonotaは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_ryuiJikoSonota(), is(new RString("その他留意事項")));
        }

        @Test
        public void 感染症の設定がある時_toShujiiIkenshoEntity_getIk_kansenshoUmuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansenshoUmu(), is(NashiAri2.無.getCode()));
        }

        @Test
        public void 感染症内容の設定がある時_toShujiiIkenshoEntity_getIk_kansenshoShojoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kansenshoShojo(), is(new RString("感染症内容")));
        }

        @Test
        public void 特記事項の設定がある時_toShujiiIkenshoEntity_getIk_tokkiJikoは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_tokkiJiko(), is(new RString("特記事項")));
        }

        @Test
        public void 看護職員の訪問による相談_支援の設定がある時_toShujiiIkenshoEntity_getIk_kangoShokuiHomonUmuは_設定値を返す() {
            assertThat(toShujiiIkenshoEntity().getDbT5013ShujiiIkenshoShosaiJohoEntity().getIk_kangoShokuiHomonUmu(), is(Checked.有り.getCode()));
        }
    }

    private static ShujiiIkenshoResult toShujiiIkenshoResult() {
        return ShujiiIkenshoMapper.toShujiiIkenshoResult(ShujiiIkenshoEntityMock.getSpiedShujiiIkenshoEntityInstance(), ShujiiIkenshoResultMock.getSpiedShujiiIkenshoBaseInstance().get主治医());
    }

    private static ShujiiIkenshoEntity toShujiiIkenshoEntity() {
        return ShujiiIkenshoMapper.toShujiiIkenshoEntity(ShujiiIkenshoResultMock.getSpiedShujiiIkenshoResultInstance());
    }
}
