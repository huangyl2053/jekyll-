/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun1;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun2;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun3;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun4;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubun5;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunIryo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKekkaKubunJiritsu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaKekkaMock;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査結果の情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaMapperTest {

    public static class toNinteichosaKekka {

        @Test
        public void 申請書管理番号の設定がある時_toNinteichosaKekka_get申請書管理番号は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get申請書管理番号().getValue(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toNinteichosaKekka_get要介護認定調査履歴番号は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get要介護認定調査履歴番号(), is(0));
        }
    }

    public static class toNinteichosaKekka_概況調査基本 {

        @Test
        public void 認定調査実施年月日の設定がある時_toNinteichosaKekka_get認定調査実施年月日は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get認定調査実施年月日(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toNinteichosaKekka_get認定調査依頼区分は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get認定調査依頼区分(), is(ChosaIraiKubun.初回));
        }

        @Test
        public void 認定調査実施場所コードの設定がある時_toNinteichosaKekka_get認定調査実施場所コードは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get認定調査実施場所コード(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toNinteichosaKekka_get認定調査実施場所名称は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get認定調査実施場所名称(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void 認定調査区分の設定がある時_toNinteichosaKekka_get認定調査区分は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get認定調査区分(), is(ChosaKubun.新規調査));
        }

        @Test
        public void 概況特記事項の設定がある時_toNinteichosaKekka_get概況特記事項は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get概況特記事項(), is(new RString("概況特記事項")));
        }

        @Test
        public void 審査会優先振分区分の設定がある時_toNinteichosaKekka_get審査会優先振分区分は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().get基本情報().get審査会優先振分区分(), is(ShinsakaiFuriwakeKubun.希望無し));
        }
    }

    public static class toNinteichosaKekka_概況調査サービス状況 {

        @Test
        public void サービス区分の設定がある時_toNinteichosaKekka_getサービス区分は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().getサービス区分(), is(ServiceKubun.介護給付サービス));
        }

        @Test
        public void 訪問介護の設定がある時_toNinteichosaKekka_get訪問介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get訪問介護(), is(0));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toNinteichosaKekka_get訪問入浴介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get訪問入浴介護(), is(1));
        }

        @Test
        public void 訪問看護の設定がある時_toNinteichosaKekka_get訪問看護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get訪問看護(), is(2));
        }

        @Test
        public void 訪問リハビリの設定がある時_toNinteichosaKekka_get訪問リハビリは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get訪問リハビリ(), is(3));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toNinteichosaKekka_get居宅療養管理指導は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get居宅療養管理指導(), is(4));
        }

        @Test
        public void 通所介護の設定がある時_toNinteichosaKekka_get通所介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get通所介護(), is(5));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toNinteichosaKekka_get通所リハビリテーションは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get通所リハビリテーション(), is(6));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toNinteichosaKekka_get短期入所生活介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get短期入所生活介護(), is(7));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toNinteichosaKekka_get短期入所療養介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get短期入所療養介護(), is(8));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toNinteichosaKekka_get特定施設入居者生活介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get特定施設入居者生活介護(), is(9));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toNinteichosaKekka_get福祉用具貸与は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get福祉用具貸与(), is(0));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toNinteichosaKekka_get特定福祉用具販売は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get特定福祉用具販売(), is(1));
        }

        @Test
        public void 住宅改修の設定がある時_toNinteichosaKekka_get住宅改修は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get住宅改修(), is(2));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toNinteichosaKekka_get夜間対応型訪問介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get夜間対応型訪問介護(), is(3));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toNinteichosaKekka_get認知症対応型通所介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get認知症対応型通所介護(), is(4));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toNinteichosaKekka_get小規模多機能型居宅介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get小規模多機能型居宅介護(), is(5));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toNinteichosaKekka_get認知症対応型共同生活介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get認知症対応型共同生活介護(), is(6));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toNinteichosaKekka_get地域密着型特定施設入居者生活介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get地域密着型特定施設入居者生活介護(), is(7));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toNinteichosaKekka_get地域密着型介護老人福祉施設入所者生活介護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get地域密着型介護老人福祉施設入所者生活介護(), is(8));
        }

        @Test
        public void 定期巡回随時対応型訪問介護看護の設定がある時_toNinteichosaKekka_get定期巡回随時対応型訪問介護看護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get定期巡回随時対応型訪問介護看護(), is(9));
        }

        @Test
        public void 複合型サービスの設定がある時_toNinteichosaKekka_get複合型サービスは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get複合型サービス(), is(0));
        }

        @Test
        public void 現在の状況の設定がある時_toNinteichosaKekka_get現在の状況は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get現在の状況(), is(GenzaiJokyoKubun.指定介護療養型医療施設));
        }

        @Test
        public void 市町村特別給付の設定がある時_toNinteichosaKekka_get市町村特別給付は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get市町村特別給付(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toNinteichosaKekka_get介護保険給付以外の在宅サービスは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get概況情報().getサービス状況().get介護保険給付以外の在宅サービス(), is(new RString("介護保険給付以外の在宅サービス")));
        }
    }

    public static class toNinteichosaKekka_基本調査第1群 {

        @Test
        public void 麻痺左上肢の設定がある時_toNinteichosaKekka_get麻痺左上肢は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get麻痺左上肢(), is(ChosaKekkaKubun1.MahiHidariJoshi.ない));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toNinteichosaKekka_get麻痺右上肢は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get麻痺右上肢(), is(ChosaKekkaKubun1.MahiMigiJoshi.ある));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toNinteichosaKekka_get麻痺左下肢は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get麻痺左下肢(), is(ChosaKekkaKubun1.MahiHidariKashi.ない));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toNinteichosaKekka_get麻痺右下肢は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get麻痺右下肢(), is(ChosaKekkaKubun1.MahiMigiKashi.ある));
        }

        @Test
        public void 麻痺その他の設定がある時_toNinteichosaKekka_get麻痺その他は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get麻痺その他(), is(ChosaKekkaKubun1.MahiSonota.ない));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toNinteichosaKekka_get拘縮肩関節は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get拘縮肩関節(), is(ChosaKekkaKubun1.KoshukuKata.ある));
        }

        @Test
        public void 拘縮股関節の設定がある時_toNinteichosaKekka_get拘縮股関節は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get拘縮股関節(), is(ChosaKekkaKubun1.KoshukuMata.ない));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toNinteichosaKekka_get拘縮膝関節は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get拘縮膝関節(), is(ChosaKekkaKubun1.KoshukuHiza.ある));
        }

        @Test
        public void 拘縮その他の設定がある時_toNinteichosaKekka_get拘縮その他は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get拘縮その他(), is(ChosaKekkaKubun1.KoshukuSonota.ない));
        }

        @Test
        public void 寝返りの設定がある時_toNinteichosaKekka_get寝返りは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get寝返り(), is(ChosaKekkaKubun1.Negaeri.できる));
        }

        @Test
        public void 起き上がりの設定がある時_toNinteichosaKekka_get起き上がりは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get起き上がり(), is(ChosaKekkaKubun1.Okiagari.できない));
        }

        @Test
        public void 座位保持の設定がある時_toNinteichosaKekka_get座位保持は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get座位保持(), is(ChosaKekkaKubun1.Zaihoji.できる));
        }

        @Test
        public void 両足での立位の設定がある時_toNinteichosaKekka_get両足での立位は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get両足での立位(), is(ChosaKekkaKubun1.RyoashiRitsui.できない));
        }

        @Test
        public void 歩行の設定がある時_toNinteichosaKekka_get歩行は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get歩行(), is(ChosaKekkaKubun1.Hoko.できる));
        }

        @Test
        public void 立ち上がりの設定がある時_toNinteichosaKekka_get立ち上がりは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get立ち上がり(), is(ChosaKekkaKubun1.Tachiagari.できない));
        }

        @Test
        public void 片足での立位の設定がある時_toNinteichosaKekka_get片足での立位は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get片足での立位(), is(ChosaKekkaKubun1.KataashiRitsui.できる));
        }

        @Test
        public void 洗身の設定がある時_toNinteichosaKekka_get洗身は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get洗身(), is(ChosaKekkaKubun1.Senshin.自立));
        }

        @Test
        public void つめ切りの設定がある時_toNinteichosaKekka_getつめ切りは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().getつめ切り(), is(ChosaKekkaKubun1.Tsumekiri.全介助));
        }

        @Test
        public void 視力の設定がある時_toNinteichosaKekka_get視力は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get視力(), is(ChosaKekkaKubun1.Shiryoku.普通));
        }

        @Test
        public void 聴力の設定がある時_toNinteichosaKekka_get聴力は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報1().get聴力(), is(ChosaKekkaKubun1.Choryoku.判断不能));
        }
    }

    public static class toNinteichosaKekka_基本調査第2群 {

        @Test
        public void 移乗の設定がある時_toNinteichosaKekka_get移乗は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get移乗(), is(ChosaKekkaKubun2.Ijo.自立));
        }

        @Test
        public void 移動の設定がある時_toNinteichosaKekka_get移動は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get移動(), is(ChosaKekkaKubun2.Ido.全介助));
        }

        @Test
        public void 嚥下の設定がある時_toNinteichosaKekka_get嚥下_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get嚥下(), is(ChosaKekkaKubun2.Enge.できる));
        }

        @Test
        public void 食事摂取の設定がある時_toNinteichosaKekka_get食事摂取は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get食事摂取(), is(ChosaKekkaKubun2.ShokujiSesshu.自立));
        }

        @Test
        public void 排尿の設定がある時_toNinteichosaKekka_get排尿は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get排尿(), is(ChosaKekkaKubun2.Hainyo.一部介助));
        }

        @Test
        public void 排便の設定がある時_toNinteichosaKekka_get排便は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get排便(), is(ChosaKekkaKubun2.Haiben.見守り等));
        }

        @Test
        public void 口腔清潔の設定がある時_toNinteichosaKekka_get口腔清潔は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get口腔清潔(), is(ChosaKekkaKubun2.KokoSeiketsu.全介助));
        }

        @Test
        public void 洗顔の設定がある時_toNinteichosaKekka_get洗顔は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get洗顔(), is(ChosaKekkaKubun2.Sengan.自立));
        }

        @Test
        public void 整髪の設定がある時_toNinteichosaKekka_get整髪は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get整髪(), is(ChosaKekkaKubun2.Seihatsu.一部介助));
        }

        @Test
        public void 上衣の着脱の設定がある時_toNinteichosaKekka_get上衣の着脱は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get上衣の着脱(), is(ChosaKekkaKubun2.JoiChakudatsu.見守り等));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toNinteichosaKekka_getズボン等の着脱は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().getズボン等の着脱(), is(ChosaKekkaKubun2.ZubonChakudatsu.全介助));
        }

        @Test
        public void 外出頻度の設定がある時_toNinteichosaKekka_get整髪外出頻度_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報2().get外出頻度(), is(ChosaKekkaKubun2.GaishutsuHindo.週１回以上));
        }
    }

    public static class toNinteichosaKekka_基本調査第3群 {

        @Test
        public void 意思の伝達の設定がある時_toNinteichosaKekka_get意思の伝達は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get意思の伝達(), is(ChosaKekkaKubun3.IshiDentatsu.できる));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toNinteichosaKekka_get毎日の日課を理解は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get毎日の日課を理解(), is(ChosaKekkaKubun3.Nikka.できない));
        }

        @Test
        public void 生年月日をいうの設定がある時_toNinteichosaKekka_get生年月日をいうは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get生年月日をいう(), is(ChosaKekkaKubun3.Seinengappi.できる));
        }

        @Test
        public void 短期記憶の設定がある時_toNinteichosaKekka_get短期記憶は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get短期記憶(), is(ChosaKekkaKubun3.TankiKioku.できない));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toNinteichosaKekka_get自分の名前をいうは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get自分の名前をいう(), is(ChosaKekkaKubun3.Namae.できる));
        }

        @Test
        public void 今の季節を理解の設定がある時_toNinteichosaKekka_get今の季節を理解は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get今の季節を理解(), is(ChosaKekkaKubun3.Kisetsu.できない));
        }

        @Test
        public void 場所の理解の設定がある時_toNinteichosaKekka_get場所の理解は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get場所の理解(), is(ChosaKekkaKubun3.Basho.できる));
        }

        @Test
        public void 徘徊の設定がある時_toNinteichosaKekka_get徘徊は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get徘徊(), is(ChosaKekkaKubun3.Haikai.ない));
        }

        @Test
        public void 外出して戻れないの設定がある時_toNinteichosaKekka_get外出して戻れないは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報3().get外出して戻れない(), is(ChosaKekkaKubun3.Gaishutsu.ある));
        }
    }

    public static class toNinteichosaKekka_基本調査第4群 {

        @Test
        public void 被害的の設定がある時_toNinteichosaKekka_get被害的は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get被害的(), is(ChosaKekkaKubun4.Higaiteki.ない));
        }

        @Test
        public void 作話の設定がある時_toNinteichosaKekka_get作話は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get作話(), is(ChosaKekkaKubun4.Sakuwa.ある));
        }

        @Test
        public void 感情が不安定の設定がある時_toNinteichosaKekka_get感情が不安定は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get感情が不安定(), is(ChosaKekkaKubun4.KanjoHuantei.ない));
        }

        @Test
        public void 昼夜逆転の設定がある時_toNinteichosaKekka_get昼夜逆転は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get昼夜逆転(), is(ChosaKekkaKubun4.ChuyaGyakuten.ある));
        }

        @Test
        public void 同じ話をするの設定がある時_toNinteichosaKekka_get同じ話をするは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get同じ話をする(), is(ChosaKekkaKubun4.OnajiHanashi.ない));
        }

        @Test
        public void 大声を出すの設定がある時_toNinteichosaKekka_get大声を出すは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get大声を出す(), is(ChosaKekkaKubun4.Ogoe.ある));
        }

        @Test
        public void 介護に抵抗の設定がある時_toNinteichosaKekka_get介護に抵抗は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get介護に抵抗(), is(ChosaKekkaKubun4.KaigoNiTeiko.ない));
        }

        @Test
        public void 落ち着きなしの設定がある時_toNinteichosaKekka_get落ち着きなしは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get落ち着きなし(), is(ChosaKekkaKubun4.Ochitsuki.ある));
        }

        @Test
        public void 一人で出たがるの設定がある時_toNinteichosaKekka_get一人で出たがるは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get一人で出たがる(), is(ChosaKekkaKubun4.HitoriDeDetagaru.ない));
        }

        @Test
        public void 収集癖の設定がある時_toNinteichosaKekka_get収集癖は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get収集癖(), is(ChosaKekkaKubun4.Shushuheki.ある));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toNinteichosaKekka_get物や衣類を壊すは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get物や衣類を壊す(), is(ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない));
        }

        @Test
        public void ひどい物忘れの設定がある時_toNinteichosaKekka_getひどい物忘れは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().getひどい物忘れ(), is(ChosaKekkaKubun4.HidoiMonowasure.ある));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toNinteichosaKekka_get独り言独り笑いは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get独り言独り笑い(), is(ChosaKekkaKubun4.HitorigotoHitoriwarai.ない));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toNinteichosaKekka_get自分勝手に行動するは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get自分勝手に行動する(), is(ChosaKekkaKubun4.JibunKatte.ある));
        }

        @Test
        public void 話がまとまらないの設定がある時_toNinteichosaKekka_get話がまとまらないは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報4().get話がまとまらない(), is(ChosaKekkaKubun4.HanashiGaMatomaranai.ない));
        }
    }

    public static class toNinteichosaKekka_基本調査第5群 {

        @Test
        public void 薬の内服の設定がある時_toNinteichosaKekka_get薬の内服は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get薬の内服(), is(ChosaKekkaKubun5.Kusuri.自立));
        }

        @Test
        public void 金銭の管理の設定がある時_toNinteichosaKekka_get金銭の管理は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get金銭の管理(), is(ChosaKekkaKubun5.KinsenKanri.全介助));
        }

        @Test
        public void 日常の意思決定の設定がある時_toNinteichosaKekka_get日常の意思決定は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get日常の意思決定(), is(ChosaKekkaKubun5.IshiKettei.できる));
        }

        @Test
        public void 集団への不適応の設定がある時_toNinteichosaKekka_get集団への不適応は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get集団への不適応(), is(ChosaKekkaKubun5.ShudanFutekio.ない));
        }

        @Test
        public void 買い物の設定がある時_toNinteichosaKekka_get買い物は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get買い物(), is(ChosaKekkaKubun5.Kaimono.自立));
        }

        @Test
        public void 簡単な調理の設定がある時_toNinteichosaKekka_get簡単な調理は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get基本情報5().get簡単な調理(), is(ChosaKekkaKubun5.Chori.全介助));
        }
    }

    public static class toNinteichosaKekka_基本調査特別医療 {

        @Test
        public void 点滴の管理の設定がある時_toNinteichosaKekka_get点滴の管理は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get点滴の管理(), is(ChosaKekkaKubunIryo.Tenteki.ない));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toNinteichosaKekka_get中心静脈栄養は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get中心静脈栄養(), is(ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある));
        }

        @Test
        public void 透析の設定がある時_toNinteichosaKekka_get透析は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get透析(), is(ChosaKekkaKubunIryo.Toseki.ない));
        }

        @Test
        public void ストーマの処置の設定がある時_toNinteichosaKekka_getストーマの処置は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().getストーマの処置(), is(ChosaKekkaKubunIryo.StomaShochi.ある));
        }

        @Test
        public void 酸素療法の設定がある時_toNinteichosaKekka_get酸素療法は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get酸素療法(), is(ChosaKekkaKubunIryo.SansoRyoho.ない));
        }

        @Test
        public void レスピレーターの設定がある時_toNinteichosaKekka_getレスピレーターは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().getレスピレーター(), is(ChosaKekkaKubunIryo.Respirator.ある));
        }

        @Test
        public void 気管切開の処置の設定がある時_toNinteichosaKekka_get気管切開の処置は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get気管切開の処置(), is(ChosaKekkaKubunIryo.KikanSekkai.ない));
        }

        @Test
        public void 疼痛の看護の設定がある時_toNinteichosaKekka_get疼痛の看護は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get疼痛の看護(), is(ChosaKekkaKubunIryo.TotsuKango.ある));
        }

        @Test
        public void 経管栄養の設定がある時_toNinteichosaKekka_get経管栄養は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().get経管栄養(), is(ChosaKekkaKubunIryo.KeikanEiyo.ない));
        }

        @Test
        public void モニター測定の設定がある時_toNinteichosaKekka_getモニター測定は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().getモニター測定(), is(ChosaKekkaKubunIryo.MonitorSokutei.ある));
        }

        @Test
        public void じょくそうの処置の設定がある時_toNinteichosaKekka_getじょくそうの処置は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().getじょくそうの処置(), is(ChosaKekkaKubunIryo.JokusoShochi.ない));
        }

        @Test
        public void カテーテルの設定がある時_toNinteichosaKekka_getカテーテルは_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get特別医療情報().getカテーテル(), is(ChosaKekkaKubunIryo.Catheter.ある));
        }
    }

    public static class toNinteichosaKekka_基本調査自立度 {

        @Test
        public void 認知症高齢者の日常生活自立度の設定がある時_toNinteichosaKekka_get認知症高齢者の日常生活自立度は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get自立度情報().get認知症高齢者の日常生活自立度(), is(ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.自立));
        }

        @Test
        public void 障害高齢者の日常生活自立度の設定がある時_toNinteichosaKekka_get障害高齢者の日常生活自立度は_設定値を返す() {
            NinteichosaKekka sut = createNinteichosaKekka();
            assertThat(sut.get基本情報().get自立度情報().get障害高齢者の日常生活自立度(), is(ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.自立));
        }
    }

    public static class toDbT5008NinteichosaKekkaJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getShinseishoKanriNo(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteichosaRirekiNoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteichousaIraiKubunCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinteichousaIraiKubunCode(), is(ChosaIraiKubun.初回.getCode()));
        }

        @Test
        public void 認定調査実施年月日の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_get認定調査実施年月日は_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinteichosaJisshiYMD(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteiChosaKubunCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinteiChosaKubunCode(), is(ChosaKubun.新規調査.getCode()));
        }

        @Test
        public void 認定調査実施場所コードの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChosaJisshiBashoCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getChosaJisshiBashoCode(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChosaJisshiBashoMeishoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getChosaJisshiBashoMeisho(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void 現在の状況の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getGenzainoJokyoCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getGenzainoJokyoCode(), is(GenzaiJokyoKubun.指定介護療養型医療施設.getCode()));
        }

        @Test
        public void サービス区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getServiceKubunCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getServiceKubunCode(), is(ServiceKubun.介護給付サービス.getCode()));
        }

        @Test
        public void 訪問介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHomonKaigo(), is(0));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonNyuyokuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHomonNyuyokuKaigo(), is(1));
        }

        @Test
        public void 訪問看護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonKangoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHomonKango(), is(2));
        }

        @Test
        public void 訪問リハビリの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonRehabilitationは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHomonRehabilitation(), is(3));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getKyotakuRyoyoKanriShidoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getKyotakuRyoyoKanriShido(), is(4));
        }

        @Test
        public void 通所介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTushoKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTushoKaigo(), is(5));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTushoRehabilitationは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTushoRehabilitation(), is(6));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTankiNyushoSeikatsuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTankiNyushoSeikatsuKaigo(), is(7));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTankiNyushoRyoyoKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTankiNyushoRyoyoKaigo(), is(8));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(9));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHukushiYoguTaiyoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHukushiYoguTaiyo(), is(0));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTokuteiHukushiYoguHanbaiは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTokuteiHukushiYoguHanbai(), is(1));
        }

        @Test
        public void 住宅改修の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getJutakuKaishuは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getJutakuKaishu(), is(2));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getYakanTaiogataHomonKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getYakanTaiogataHomonKaigo(), is(3));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoTaiogataTushoKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinchishoTaiogataTushoKaigo(), is(4));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShokiboTakinogataKyotakuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getShokiboTakinogataKyotakuKaigo(), is(5));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoTaiogataKyodoSeikatsuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinchishoTaiogataKyodoSeikatsuKaigo(), is(6));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(7));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(), is(8));
        }

        @Test
        public void 定期巡回随時対応型訪問介護看護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTeikijunkaiZuijiTaiogataHomonKaigoKangoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getTeikijunkaiZuijiTaiogataHomonKaigoKango(), is(9));
        }

        @Test
        public void 複合型サービスの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHukugogataServiceは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getHukugogataService(), is(0));
        }

        @Test
        public void 市町村特別給付の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShichosonTokubetsuKyufuは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getShichosonTokubetsuKyufu(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getKaigohokenKyufuIgaiNoZaitakuServiceは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getKaigohokenKyufuIgaiNoZaitakuService(), is(new RString("介護保険給付以外の在宅サービス")));
        }

        @Test
        public void 概況特記事項の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getGaikyochosaTokkijikoは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getGaikyochosaTokkijiko(), is(new RString("概況特記事項")));
        }

        @Test
        public void 認知症高齢者の日常生活自立度の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getNinchishoNichijoSeikatsuJiritsudoCode(), is(ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.自立.getCode()));
        }

        @Test
        public void 障害高齢者の日常生活自立度の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShogaiNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getShogaiNichijoSeikatsuJiritsudoCode(), is(ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.自立.getCode()));
        }

        @Test
        public void 審査会優先振分区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShinsakaiYusenWaritsukeKubunCodeは_設定値を返す() {
            DbT5008NinteichosaKekkaJohoEntity sut = createDbT5008NinteichosaKekkaJohoEntity();
            assertThat(sut.getShinsakaiYusenWaritsukeKubunCode(), is(ShinsakaiFuriwakeKubun.希望無し.getCode()));
        }
    }

    public static class toDbT5009NinteichosahyoJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5009NinteichosahyoJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getShinseishoKanriNo(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toDbT5009NinteichosahyoJohoEntity_getNinteichosaRirekiNoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 麻痺左上肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiHidariJoshiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_mahiHidariJoshi(), is(ChosaKekkaKubun1.MahiHidariJoshi.ない.getCode()));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiMigiJoshiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_mahiMigiJoshi(), is(ChosaKekkaKubun1.MahiMigiJoshi.ある.getCode()));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiHidariKashiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_mahiHidariKashi(), is(ChosaKekkaKubun1.MahiHidariKashi.ない.getCode()));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiMigiKashiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_mahiMigiKashi(), is(ChosaKekkaKubun1.MahiMigiKashi.ある.getCode()));
        }

        @Test
        public void 麻痺その他の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiSonotaは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_mahiSonota(), is(ChosaKekkaKubun1.MahiSonota.ない.getCode()));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuKataは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_koshukuKata(), is(ChosaKekkaKubun1.KoshukuKata.ある.getCode()));
        }

        @Test
        public void 拘縮股関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuMataは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_koshukuMata(), is(ChosaKekkaKubun1.KoshukuMata.ない.getCode()));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuHizaは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_koshukuHiza(), is(ChosaKekkaKubun1.KoshukuHiza.ある.getCode()));
        }

        @Test
        public void 拘縮その他の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuSonotaは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_koshukuSonota(), is(ChosaKekkaKubun1.KoshukuSonota.ない.getCode()));
        }

        @Test
        public void 寝返りの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_negaeriは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_negaeri(), is(ChosaKekkaKubun1.Negaeri.できる.getCode()));
        }

        @Test
        public void 起き上がりの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_okiagariは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_okiagari(), is(ChosaKekkaKubun1.Okiagari.できない.getCode()));
        }

        @Test
        public void 座位保持の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_zaihojiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_zaihoji(), is(ChosaKekkaKubun1.Zaihoji.できる.getCode()));
        }

        @Test
        public void 両足での立位の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ryoashiRitsuiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ryoashiRitsui(), is(ChosaKekkaKubun1.RyoashiRitsui.できない.getCode()));
        }

        @Test
        public void 歩行の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hokoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hoko(), is(ChosaKekkaKubun1.Hoko.できる.getCode()));
        }

        @Test
        public void 立ち上がりの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tachiagariは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_tachiagari(), is(ChosaKekkaKubun1.Tachiagari.できない.getCode()));
        }

        @Test
        public void 片足での立位の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kataashiRitsuiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kataashiRitsui(), is(ChosaKekkaKubun1.KataashiRitsui.できる.getCode()));
        }

        @Test
        public void 洗身の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_senshinは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_senshin(), is(ChosaKekkaKubun1.Senshin.自立.getCode()));
        }

        @Test
        public void つめ切りの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tumekiriは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_tumekiri(), is(ChosaKekkaKubun1.Tsumekiri.全介助.getCode()));
        }

        @Test
        public void 視力の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shiryokuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_shiryoku(), is(ChosaKekkaKubun1.Shiryoku.普通.getCode()));
        }

        @Test
        public void 聴力の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_choryokuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_choryoku(), is(ChosaKekkaKubun1.Choryoku.判断不能.getCode()));
        }

        @Test
        public void 移乗の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ijoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ijo(), is(ChosaKekkaKubun2.Ijo.自立.getCode()));
        }

        @Test
        public void 移動の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_idoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ido(), is(ChosaKekkaKubun2.Ido.全介助.getCode()));
        }

        @Test
        public void 嚥下の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_engeは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_enge(), is(ChosaKekkaKubun2.Enge.できる.getCode()));
        }

        @Test
        public void 食事摂取の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shokujiSesshuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_shokujiSesshu(), is(ChosaKekkaKubun2.ShokujiSesshu.自立.getCode()));
        }

        @Test
        public void 排尿の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hainyoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hainyo(), is(ChosaKekkaKubun2.Hainyo.一部介助.getCode()));
        }

        @Test
        public void 排便の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_haibenは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_haiben(), is(ChosaKekkaKubun2.Haiben.見守り等.getCode()));
        }

        @Test
        public void 口腔清潔の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kokoSeiketsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kokoSeiketsu(), is(ChosaKekkaKubun2.KokoSeiketsu.全介助.getCode()));
        }

        @Test
        public void 洗顔の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_senganは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_sengan(), is(ChosaKekkaKubun2.Sengan.自立.getCode()));
        }

        @Test
        public void 整髪の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_seihatsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_seihatsu(), is(ChosaKekkaKubun2.Seihatsu.一部介助.getCode()));
        }

        @Test
        public void 上衣の着脱の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_joiChakudatsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_joiChakudatsu(), is(ChosaKekkaKubun2.JoiChakudatsu.見守り等.getCode()));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_zubonChakudatsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_zubonChakudatsu(), is(ChosaKekkaKubun2.ZubonChakudatsu.全介助.getCode()));
        }

        @Test
        public void 外出頻度の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_gaishutsuHindoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_gaishutsuHindo(), is(ChosaKekkaKubun2.GaishutsuHindo.週１回以上.getCode()));
        }

        @Test
        public void 意思の伝達の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ishiDentatsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ishiDentatsu(), is(ChosaKekkaKubun3.IshiDentatsu.できる.getCode()));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_nikkaは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_nikka(), is(ChosaKekkaKubun3.Nikka.できない.getCode()));
        }

        @Test
        public void 生年月日をいうの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_seinengappiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_seinengappi(), is(ChosaKekkaKubun3.Seinengappi.できる.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tankiKiokuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_tankiKioku(), is(ChosaKekkaKubun3.TankiKioku.できない.getCode()));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_namaeは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_namae(), is(ChosaKekkaKubun3.Namae.できる.getCode()));
        }

        @Test
        public void 今の季節を理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kisetsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kisetsu(), is(ChosaKekkaKubun3.Kisetsu.できない.getCode()));
        }

        @Test
        public void 場所の理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_bashoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_basho(), is(ChosaKekkaKubun3.Basho.できる.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_haikaiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_haikai(), is(ChosaKekkaKubun3.Haikai.ない.getCode()));
        }

        @Test
        public void 外出して戻れないの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_gaishutsuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_gaishutsu(), is(ChosaKekkaKubun3.Gaishutsu.ある.getCode()));
        }

        @Test
        public void 被害的の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_higaitekiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_higaiteki(), is(ChosaKekkaKubun4.Higaiteki.ない.getCode()));
        }

        @Test
        public void 作話の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_sakuwaは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_sakuwa(), is(ChosaKekkaKubun4.Sakuwa.ある.getCode()));
        }

        @Test
        public void 感情が不安定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kanjoHuanteiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kanjoHuantei(), is(ChosaKekkaKubun4.KanjoHuantei.ない.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_chuyaGyakutenは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_chuyaGyakuten(), is(ChosaKekkaKubun4.ChuyaGyakuten.ある.getCode()));
        }

        @Test
        public void 同じ話をするの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_onajiHanashiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_onajiHanashi(), is(ChosaKekkaKubun4.OnajiHanashi.ない.getCode()));
        }

        @Test
        public void 大声を出すの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ogoe_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ogoe(), is(ChosaKekkaKubun4.Ogoe.ある.getCode()));
        }

        @Test
        public void 介護に抵抗の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kaigoNiTeikoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kaigoNiTeiko(), is(ChosaKekkaKubun4.KaigoNiTeiko.ない.getCode()));
        }

        @Test
        public void 落ち着きなしの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ochitsukiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ochitsuki(), is(ChosaKekkaKubun4.Ochitsuki.ある.getCode()));
        }

        @Test
        public void 一人で出たがるの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hitoriDeDetagaruは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hitoriDeDetagaru(), is(ChosaKekkaKubun4.HitoriDeDetagaru.ない.getCode()));
        }

        @Test
        public void 収集癖の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shushuhekiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_shushuheki(), is(ChosaKekkaKubun4.Shushuheki.ある.getCode()));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_monoYaIruiWoKowasuは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_monoYaIruiWoKowasu(), is(ChosaKekkaKubun4.MonoYaIruiWoKowasu.ない.getCode()));
        }

        @Test
        public void ひどい物忘れの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hidoiMonowasureは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hidoiMonowasure(), is(ChosaKekkaKubun4.HidoiMonowasure.ある.getCode()));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hitorigotoHitoriwaraiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hitorigotoHitoriwarai(), is(ChosaKekkaKubun4.HitorigotoHitoriwarai.ない.getCode()));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_jibunKatteは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_jibunKatte(), is(ChosaKekkaKubun4.JibunKatte.ある.getCode()));
        }

        @Test
        public void 話がまとまらないの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hanashiGaMatomaranaiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_hanashiGaMatomaranai(), is(ChosaKekkaKubun4.HanashiGaMatomaranai.ない.getCode()));
        }

        @Test
        public void 薬の内服の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kusuriは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kusuri(), is(ChosaKekkaKubun5.Kusuri.自立.getCode()));
        }

        @Test
        public void 金銭の管理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kinsenKanriは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kinsenKanri(), is(ChosaKekkaKubun5.KinsenKanri.全介助.getCode()));
        }

        @Test
        public void 日常の意思決定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ishiKetteiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_ishiKettei(), is(ChosaKekkaKubun5.IshiKettei.できる.getCode()));
        }

        @Test
        public void 集団への不適応の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shudanHutekioは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_shudanHutekio(), is(ChosaKekkaKubun5.ShudanFutekio.ない.getCode()));
        }

        @Test
        public void 買い物の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kaimonoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kaimono(), is(ChosaKekkaKubun5.Kaimono.自立.getCode()));
        }

        @Test
        public void 簡単な調理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_choriは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_chori(), is(ChosaKekkaKubun5.Chori.全介助.getCode()));
        }

        @Test
        public void 点滴の管理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tentekiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_tenteki(), is(ChosaKekkaKubunIryo.Tenteki.ない.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_chushinJomyakuEiyoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_chushinJomyakuEiyo(), is(ChosaKekkaKubunIryo.ChushinJomyakuEiyo.ある.getCode()));
        }

        @Test
        public void 透析の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tosekiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_toseki(), is(ChosaKekkaKubunIryo.Toseki.ない.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_stomaShochiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_stomaShochi(), is(ChosaKekkaKubunIryo.StomaShochi.ある.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_sansoRyohoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_sansoRyoho(), is(ChosaKekkaKubunIryo.SansoRyoho.ない.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_respiratorは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_respirator(), is(ChosaKekkaKubunIryo.Respirator.ある.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kikanSekkaiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_kikanSekkai(), is(ChosaKekkaKubunIryo.KikanSekkai.ない.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_totsuKangoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_totsuKango(), is(ChosaKekkaKubunIryo.TotsuKango.ある.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_keikanEiyoは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_keikanEiyo(), is(ChosaKekkaKubunIryo.KeikanEiyo.ない.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_monitorSokuteiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_monitorSokutei(), is(ChosaKekkaKubunIryo.MonitorSokutei.ある.getCode()));
        }

        @Test
        public void じょくそうの処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_jokusoShochiは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_jokusoShochi(), is(ChosaKekkaKubunIryo.JokusoShochi.ない.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_catheterは_設定値を返す() {
            DbT5009NinteichosahyoJohoEntity sut = createDbT5009NinteichosahyoJohoEntity();
            assertThat(sut.getCk_catheter(), is(ChosaKekkaKubunIryo.Catheter.ある.getCode()));
        }
    }

    private static NinteichosaKekka createNinteichosaKekka() {
        return NinteichosaKekkaMapper.toNinteichosaKekka(
                NinteichosaKekkaEntityMock.getSpiedDbT5008NinteichosaKekkaJohoEntityInstance(),
                NinteichosaKekkaEntityMock.getSpiedDbT5009NinteichosahyoJohoEntityInstance(),
                NinteichosaKekkaEntityMock.getSpiedDbT5010NinteiChosaTokkijikoEntityInstance());
    }

    private static DbT5008NinteichosaKekkaJohoEntity createDbT5008NinteichosaKekkaJohoEntity() {
        return NinteichosaKekkaMapper.toDbT5008NinteichosaKekkaJohoEntity(NinteichosaKekkaMock.getSpiedNinteichosaKekkaInstance());
    }

    private static DbT5009NinteichosahyoJohoEntity createDbT5009NinteichosahyoJohoEntity() {
        return NinteichosaKekkaMapper.toDbT5009NinteichosahyoJohoEntity(NinteichosaKekkaMock.getSpiedNinteichosaKekkaInstance());
    }
}
