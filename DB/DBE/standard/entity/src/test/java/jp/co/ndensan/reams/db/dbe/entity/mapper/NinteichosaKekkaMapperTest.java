/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
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
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku.*;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Sentakushi.*;
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
            assertThat(toNinteichosaKekka().get申請書管理番号().getValue(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toNinteichosaKekka_get要介護認定調査履歴番号は_設定値を返す() {
            assertThat(toNinteichosaKekka().get要介護認定調査履歴番号(), is(0));
        }
    }

    public static class toNinteichosaKekka_概況調査基本 {

        @Test
        public void 認定調査実施年月日の設定がある時_toNinteichosaKekka_get認定調査実施年月日は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get認定調査実施年月日(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toNinteichosaKekka_get認定調査依頼区分は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get認定調査依頼区分(), is(ChosaIraiKubun.初回));
        }

        @Test
        public void 認定調査実施場所コードの設定がある時_toNinteichosaKekka_get認定調査実施場所コードは_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get認定調査実施場所コード(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toNinteichosaKekka_get認定調査実施場所名称は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get認定調査実施場所名称(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void 認定調査区分の設定がある時_toNinteichosaKekka_get認定調査区分は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get認定調査区分(), is(ChosaKubun.新規調査));
        }

        @Test
        public void 概況特記事項の設定がある時_toNinteichosaKekka_get概況特記事項は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get概況特記事項(), is(new RString("概況特記事項")));
        }

        @Test
        public void 審査会優先振分区分の設定がある時_toNinteichosaKekka_get審査会優先振分区分は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().get基本情報().get審査会優先振分区分(), is(ShinsakaiFuriwakeKubun.希望無し));
        }
    }

    public static class toNinteichosaKekka_概況調査サービス状況 {

        @Test
        public void サービス区分の設定がある時_toNinteichosaKekka_getサービス区分は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().getサービス区分(), is(ServiceKubun.介護給付サービス));
        }

        @Test
        public void 訪問介護の設定がある時_toNinteichosaKekka_get訪問介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get訪問介護(), is(0));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toNinteichosaKekka_get訪問入浴介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get訪問入浴介護(), is(1));
        }

        @Test
        public void 訪問看護の設定がある時_toNinteichosaKekka_get訪問看護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get訪問看護(), is(2));
        }

        @Test
        public void 訪問リハビリの設定がある時_toNinteichosaKekka_get訪問リハビリは_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get訪問リハビリ(), is(3));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toNinteichosaKekka_get居宅療養管理指導は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get居宅療養管理指導(), is(4));
        }

        @Test
        public void 通所介護の設定がある時_toNinteichosaKekka_get通所介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get通所介護(), is(5));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toNinteichosaKekka_get通所リハビリテーションは_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get通所リハビリテーション(), is(6));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toNinteichosaKekka_get短期入所生活介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get短期入所生活介護(), is(7));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toNinteichosaKekka_get短期入所療養介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get短期入所療養介護(), is(8));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toNinteichosaKekka_get特定施設入居者生活介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get特定施設入居者生活介護(), is(9));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toNinteichosaKekka_get福祉用具貸与は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get福祉用具貸与(), is(0));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toNinteichosaKekka_get特定福祉用具販売は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get特定福祉用具販売(), is(1));
        }

        @Test
        public void 住宅改修の設定がある時_toNinteichosaKekka_get住宅改修は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get住宅改修(), is(2));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toNinteichosaKekka_get夜間対応型訪問介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get夜間対応型訪問介護(), is(3));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toNinteichosaKekka_get認知症対応型通所介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get認知症対応型通所介護(), is(4));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toNinteichosaKekka_get小規模多機能型居宅介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get小規模多機能型居宅介護(), is(5));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toNinteichosaKekka_get認知症対応型共同生活介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get認知症対応型共同生活介護(), is(6));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toNinteichosaKekka_get地域密着型特定施設入居者生活介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get地域密着型特定施設入居者生活介護(), is(7));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toNinteichosaKekka_get地域密着型介護老人福祉施設入所者生活介護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get地域密着型介護老人福祉施設入所者生活介護(), is(8));
        }

        @Test
        public void 定期巡回随時対応型訪問介護看護の設定がある時_toNinteichosaKekka_get定期巡回随時対応型訪問介護看護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get定期巡回随時対応型訪問介護看護(), is(9));
        }

        @Test
        public void 複合型サービスの設定がある時_toNinteichosaKekka_get複合型サービスは_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get複合型サービス(), is(0));
        }

        @Test
        public void 現在の状況の設定がある時_toNinteichosaKekka_get現在の状況は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get現在の状況(), is(GenzaiJokyoKubun.指定介護療養型医療施設));
        }

        @Test
        public void 市町村特別給付の設定がある時_toNinteichosaKekka_get市町村特別給付は_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get市町村特別給付(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toNinteichosaKekka_get介護保険給付以外の在宅サービスは_設定値を返す() {
            assertThat(toNinteichosaKekka().get概況情報().getサービス状況().get介護保険給付以外の在宅サービス(), is(new RString("介護保険給付以外の在宅サービス")));
        }
    }

    public static class toNinteichosaKekka_基本調査 {

        @Test
        public void 麻痺左上肢の設定がある時_toNinteichosaKekka_get麻痺左上肢は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(麻痺等の有無_左上肢), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toNinteichosaKekka_get麻痺右上肢は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(麻痺等の有無_右上肢), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toNinteichosaKekka_get麻痺左下肢は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(麻痺等の有無_左下肢), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toNinteichosaKekka_get麻痺右下肢は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(麻痺等の有無_右下肢), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺その他の設定がある時_toNinteichosaKekka_get麻痺その他は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(麻痺等の有無_その他), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toNinteichosaKekka_get拘縮肩関節は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(関節の動く範囲の制限_肩関節), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮股関節の設定がある時_toNinteichosaKekka_get拘縮股関節は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(関節の動く範囲の制限_股関節), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toNinteichosaKekka_get拘縮膝関節は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(関節の動く範囲の制限_膝関節), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮その他の設定がある時_toNinteichosaKekka_get拘縮その他は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(関節の動く範囲の制限_その他), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 寝返りの設定がある時_toNinteichosaKekka_get寝返りは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(寝返り), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 起き上がりの設定がある時_toNinteichosaKekka_get起き上がりは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(起き上がり), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 座位保持の設定がある時_toNinteichosaKekka_get座位保持は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(座位保持), is(DekiruDekinai6.できる.getCode()));
        }

        @Test
        public void 両足での立位の設定がある時_toNinteichosaKekka_get両足での立位は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(両足での立位), is(DekiruDekinai5.できない.getCode()));
        }

        @Test
        public void 歩行の設定がある時_toNinteichosaKekka_get歩行は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(歩行), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 立ち上がりの設定がある時_toNinteichosaKekka_get立ち上がりは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(立ち上がり), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 片足での立位の設定がある時_toNinteichosaKekka_get片足での立位は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(片足での立位), is(DekiruDekinai5.できる.getCode()));
        }

        @Test
        public void 洗身の設定がある時_toNinteichosaKekka_get洗身は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(洗身), is(Kaijo2.自立.getCode()));
        }

        @Test
        public void つめ切りの設定がある時_toNinteichosaKekka_getつめ切りは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(つめ切り), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 視力の設定がある時_toNinteichosaKekka_get視力は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(視力), is(Shiryoku.普通.getCode()));
        }

        @Test
        public void 聴力の設定がある時_toNinteichosaKekka_get聴力は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(聴力), is(Choryoku.判断不能.getCode()));
        }

        @Test
        public void 移乗の設定がある時_toNinteichosaKekka_get移乗は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(移乗), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 移動の設定がある時_toNinteichosaKekka_get移動は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(移動), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 嚥下の設定がある時_toNinteichosaKekka_get嚥下_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(嚥下), is(DekiruDekinai4.できる.getCode()));
        }

        @Test
        public void 食事摂取の設定がある時_toNinteichosaKekka_get食事摂取は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(食事摂取), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 排尿の設定がある時_toNinteichosaKekka_get排尿は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(排尿), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 排便の設定がある時_toNinteichosaKekka_get排便は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(排便), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 口腔清潔の設定がある時_toNinteichosaKekka_get口腔清潔は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(口腔清潔), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 洗顔の設定がある時_toNinteichosaKekka_get洗顔は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(洗顔), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 整髪の設定がある時_toNinteichosaKekka_get整髪は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(整髪), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 上衣の着脱の設定がある時_toNinteichosaKekka_get上衣の着脱は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(上衣の着脱), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toNinteichosaKekka_getズボン等の着脱は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(ズボン等の着脱), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 外出頻度の設定がある時_toNinteichosaKekka_get整髪外出頻度_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(外出頻度), is(Gaishutsu.月１回以上.getCode()));
        }

        @Test
        public void 意思の伝達の設定がある時_toNinteichosaKekka_get意思の伝達は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(意思の伝達), is(DekiruDekinai2.できる.getCode()));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toNinteichosaKekka_get毎日の日課を理解は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(毎日の日課を理解), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 生年月日をいうの設定がある時_toNinteichosaKekka_get生年月日をいうは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(生年月日をいう), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toNinteichosaKekka_get短期記憶は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(短期記憶), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toNinteichosaKekka_get自分の名前をいうは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(自分の名前をいう), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 今の季節を理解の設定がある時_toNinteichosaKekka_get今の季節を理解は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(今の季節を理解), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 場所の理解の設定がある時_toNinteichosaKekka_get場所の理解は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(場所の理解), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toNinteichosaKekka_get徘徊は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(常時の徘徊), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 外出して戻れないの設定がある時_toNinteichosaKekka_get外出して戻れないは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(外出して戻れない), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 被害的の設定がある時_toNinteichosaKekka_get被害的は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(被害的), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 作話の設定がある時_toNinteichosaKekka_get作話は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(作話), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 感情が不安定の設定がある時_toNinteichosaKekka_get感情が不安定は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(感情が不安定), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toNinteichosaKekka_get昼夜逆転は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(昼夜逆転), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 同じ話をするの設定がある時_toNinteichosaKekka_get同じ話をするは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(同じ話をする), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 大声を出すの設定がある時_toNinteichosaKekka_get大声を出すは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(大声を出す), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 介護に抵抗の設定がある時_toNinteichosaKekka_get介護に抵抗は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(介護に抵抗), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 落ち着きなしの設定がある時_toNinteichosaKekka_get落ち着きなしは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(落ち着きなし), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 一人で出たがるの設定がある時_toNinteichosaKekka_get一人で出たがるは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(一人で出たがる), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 収集癖の設定がある時_toNinteichosaKekka_get収集癖は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(収集癖), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toNinteichosaKekka_get物や衣類を壊すは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(物や衣類を壊す), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void ひどい物忘れの設定がある時_toNinteichosaKekka_getひどい物忘れは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(ひどい物忘れ), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toNinteichosaKekka_get独り言独り笑いは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(独り言_独り笑), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toNinteichosaKekka_get自分勝手に行動するは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(自分勝手に行動する), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 話がまとまらないの設定がある時_toNinteichosaKekka_get話がまとまらないは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(話がまとまらない), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 薬の内服の設定がある時_toNinteichosaKekka_get薬の内服は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(薬の内服), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 金銭の管理の設定がある時_toNinteichosaKekka_get金銭の管理は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(金銭の管理), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 日常の意思決定の設定がある時_toNinteichosaKekka_get日常の意思決定は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(日常の意思決定), is(DekiruDekinai7.できる.getCode()));
        }

        @Test
        public void 集団への不適応の設定がある時_toNinteichosaKekka_get集団への不適応は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(集団への不適応), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 買い物の設定がある時_toNinteichosaKekka_get買い物は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(買い物), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 簡単な調理の設定がある時_toNinteichosaKekka_get簡単な調理は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(簡単な調理), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 点滴の管理の設定がある時_toNinteichosaKekka_get点滴の管理は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(点滴の管理), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toNinteichosaKekka_get中心静脈栄養は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(中心静脈栄養), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 透析の設定がある時_toNinteichosaKekka_get透析は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(透析), is(NaiAru.ない.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toNinteichosaKekka_getストーマの処置は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(ストーマの処置), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toNinteichosaKekka_get酸素療法は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(酸素療法), is(NaiAru.ない.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toNinteichosaKekka_getレスピレーターは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(レスピレーター), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toNinteichosaKekka_get気管切開の処置は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(気管切開), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toNinteichosaKekka_get疼痛の看護は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(疼痛の看護), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toNinteichosaKekka_get経管栄養は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(経管栄養), is(NaiAru.ない.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toNinteichosaKekka_getモニター測定は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(モニター測定), is(NaiAru.ある.getCode()));
        }

        @Test
        public void じょくそうの処置の設定がある時_toNinteichosaKekka_getじょくそうの処置は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(じょくそうの処置), is(NaiAru.ない.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toNinteichosaKekka_getカテーテルは_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(カテーテル), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 障害高齢者の日常生活自立度の設定がある時_toNinteichosaKekka_get障害高齢者の日常生活自立度は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(障害高齢者の日常生活自立度), is(ShogaiKoreishaJiritsu.Ａ１.getCode()));
        }

        @Test
        public void 認知症高齢者の日常生活自立度の設定がある時_toNinteichosaKekka_get認知症高齢者の日常生活自立度は_設定値を返す() {
            assertThat(toNinteichosaKekka().get基本情報().get(認知症高齢者の日常生活自立度), is(NinchishoKoreishaJiritsu.Ⅱａ.getCode()));
        }
    }

    public static class toDbT5008NinteichosaKekkaJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getShinseishoKanriNo(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteichosaRirekiNoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteichousaIraiKubunCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinteichousaIraiKubunCode(), is(ChosaIraiKubun.初回.getCode()));
        }

        @Test
        public void 認定調査実施年月日の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_get認定調査実施年月日は_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinteichosaJisshiYMD(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinteiChosaKubunCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinteiChosaKubunCode(), is(ChosaKubun.新規調査.getCode()));
        }

        @Test
        public void 認定調査実施場所コードの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChosaJisshiBashoCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getChosaJisshiBashoCode(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChosaJisshiBashoMeishoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getChosaJisshiBashoMeisho(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void 現在の状況の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getGenzainoJokyoCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getGenzainoJokyoCode(), is(GenzaiJokyoKubun.指定介護療養型医療施設.getCode()));
        }

        @Test
        public void サービス区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getServiceKubunCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getServiceKubunCode(), is(ServiceKubun.介護給付サービス.getCode()));
        }

        @Test
        public void 訪問介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHomonKaigo(), is(0));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonNyuyokuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHomonNyuyokuKaigo(), is(1));
        }

        @Test
        public void 訪問看護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonKangoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHomonKango(), is(2));
        }

        @Test
        public void 訪問リハビリの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHomonRehabilitationは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHomonRehabilitation(), is(3));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getKyotakuRyoyoKanriShidoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getKyotakuRyoyoKanriShido(), is(4));
        }

        @Test
        public void 通所介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTushoKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTushoKaigo(), is(5));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTushoRehabilitationは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTushoRehabilitation(), is(6));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTankiNyushoSeikatsuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTankiNyushoSeikatsuKaigo(), is(7));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTankiNyushoRyoyoKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTankiNyushoRyoyoKaigo(), is(8));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(9));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHukushiYoguTaiyoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHukushiYoguTaiyo(), is(0));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTokuteiHukushiYoguHanbaiは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTokuteiHukushiYoguHanbai(), is(1));
        }

        @Test
        public void 住宅改修の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getJutakuKaishuは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getJutakuKaishu(), is(2));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getYakanTaiogataHomonKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getYakanTaiogataHomonKaigo(), is(3));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoTaiogataTushoKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinchishoTaiogataTushoKaigo(), is(4));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShokiboTakinogataKyotakuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getShokiboTakinogataKyotakuKaigo(), is(5));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoTaiogataKyodoSeikatsuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinchishoTaiogataKyodoSeikatsuKaigo(), is(6));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(7));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(), is(8));
        }

        @Test
        public void 定期巡回随時対応型訪問介護看護の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getTeikijunkaiZuijiTaiogataHomonKaigoKangoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getTeikijunkaiZuijiTaiogataHomonKaigoKango(), is(9));
        }

        @Test
        public void 複合型サービスの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getHukugogataServiceは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getHukugogataService(), is(0));
        }

        @Test
        public void 市町村特別給付の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShichosonTokubetsuKyufuは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getShichosonTokubetsuKyufu(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getKaigohokenKyufuIgaiNoZaitakuServiceは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getKaigohokenKyufuIgaiNoZaitakuService(), is(new RString("介護保険給付以外の在宅サービス")));
        }

        @Test
        public void 概況特記事項の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getGaikyochosaTokkijikoは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getGaikyochosaTokkijiko(), is(new RString("概況特記事項")));
        }

        @Test
        public void 障害高齢者の日常生活自立度の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShogaiNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getShogaiNichijoSeikatsuJiritsudoCode(), is(ShogaiKoreishaJiritsu.Ａ１.getCode()));
        }

        @Test
        public void 認知症高齢者の日常生活自立度の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getNinchishoNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getNinchishoNichijoSeikatsuJiritsudoCode(), is(NinchishoKoreishaJiritsu.Ⅱａ.getCode()));
        }

        @Test
        public void 審査会優先振分区分の設定がある時_toDbT5008NinteichosaKekkaJohoEntity_getShinsakaiYusenWaritsukeKubunCodeは_設定値を返す() {
            assertThat(toDbT5008NinteichosaKekkaJohoEntity().getShinsakaiYusenWaritsukeKubunCode(), is(ShinsakaiFuriwakeKubun.希望無し.getCode()));
        }
    }

    public static class toDbT5009NinteichosahyoJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toDbT5009NinteichosahyoJohoEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getShinseishoKanriNo(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toDbT5009NinteichosahyoJohoEntity_getNinteichosaRirekiNoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 麻痺左上肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiHidariJoshiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_mahiHidariJoshi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiMigiJoshiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_mahiMigiJoshi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiHidariKashiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_mahiHidariKashi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiMigiKashiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_mahiMigiKashi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺その他の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_mahiSonotaは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_mahiSonota(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuKataは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_koshukuKata(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮股関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuMataは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_koshukuMata(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuHizaは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_koshukuHiza(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮その他の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_koshukuSonotaは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_koshukuSonota(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 寝返りの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_negaeriは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_negaeri(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 起き上がりの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_okiagariは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_okiagari(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 座位保持の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_zaihojiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_zaihoji(), is(DekiruDekinai6.できる.getCode()));
        }

        @Test
        public void 両足での立位の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ryoashiRitsuiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ryoashiRitsui(), is(DekiruDekinai5.できない.getCode()));
        }

        @Test
        public void 歩行の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hokoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hoko(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 立ち上がりの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tachiagariは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_tachiagari(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 片足での立位の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kataashiRitsuiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kataashiRitsui(), is(DekiruDekinai5.できる.getCode()));
        }

        @Test
        public void 洗身の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_senshinは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_senshin(), is(Kaijo2.自立.getCode()));
        }

        @Test
        public void つめ切りの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tumekiriは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_tumekiri(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 視力の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shiryokuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_shiryoku(), is(Shiryoku.普通.getCode()));
        }

        @Test
        public void 聴力の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_choryokuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_choryoku(), is(Choryoku.判断不能.getCode()));
        }

        @Test
        public void 移乗の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ijoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ijo(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 移動の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_idoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ido(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 嚥下の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_engeは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_enge(), is(DekiruDekinai4.できる.getCode()));
        }

        @Test
        public void 食事摂取の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shokujiSesshuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_shokujiSesshu(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 排尿の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hainyoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hainyo(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 排便の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_haibenは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_haiben(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 口腔清潔の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kokoSeiketsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kokoSeiketsu(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 洗顔の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_senganは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_sengan(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 整髪の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_seihatsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_seihatsu(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 上衣の着脱の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_joiChakudatsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_joiChakudatsu(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_zubonChakudatsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_zubonChakudatsu(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 外出頻度の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_gaishutsuHindoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_gaishutsuHindo(), is(Gaishutsu.月１回以上.getCode()));
        }

        @Test
        public void 意思の伝達の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ishiDentatsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ishiDentatsu(), is(DekiruDekinai2.できる.getCode()));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_nikkaは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_nikka(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 生年月日をいうの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_seinengappiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_seinengappi(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tankiKiokuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_tankiKioku(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_namaeは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_namae(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 今の季節を理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kisetsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kisetsu(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 場所の理解の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_bashoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_basho(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_haikaiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_haikai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 外出して戻れないの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_gaishutsuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_gaishutsu(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 被害的の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_higaitekiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_higaiteki(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 作話の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_sakuwaは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_sakuwa(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 感情が不安定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kanjoHuanteiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kanjoHuantei(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_chuyaGyakutenは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_chuyaGyakuten(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 同じ話をするの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_onajiHanashiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_onajiHanashi(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 大声を出すの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ogoe_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ogoe(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 介護に抵抗の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kaigoNiTeikoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kaigoNiTeiko(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 落ち着きなしの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ochitsukiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ochitsuki(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 一人で出たがるの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hitoriDeDetagaruは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hitoriDeDetagaru(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 収集癖の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shushuhekiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_shushuheki(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_monoYaIruiWoKowasuは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_monoYaIruiWoKowasu(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void ひどい物忘れの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hidoiMonowasureは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hidoiMonowasure(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hitorigotoHitoriwaraiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hitorigotoHitoriwarai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_jibunKatteは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_jibunKatte(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 話がまとまらないの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_hanashiGaMatomaranaiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_hanashiGaMatomaranai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 薬の内服の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kusuriは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kusuri(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 金銭の管理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kinsenKanriは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kinsenKanri(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 日常の意思決定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_ishiKetteiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_ishiKettei(), is(DekiruDekinai7.できる.getCode()));
        }

        @Test
        public void 集団への不適応の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_shudanHutekioは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_shudanHutekio(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 買い物の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kaimonoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kaimono(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 簡単な調理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_choriは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_chori(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 点滴の管理の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tentekiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_tenteki(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_chushinJomyakuEiyoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_chushinJomyakuEiyo(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 透析の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_tosekiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_toseki(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_stomaShochiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_stomaShochi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_sansoRyohoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_sansoRyoho(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_respiratorは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_respirator(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_kikanSekkaiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_kikanSekkai(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_totsuKangoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_totsuKango(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_keikanEiyoは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_keikanEiyo(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_monitorSokuteiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_monitorSokutei(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void じょくそうの処置の設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_jokusoShochiは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_jokusoShochi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toDbT5009NinteichosahyoJohoEntity_getCk_catheterは_設定値を返す() {
            assertThat(toDbT5009NinteichosahyoJohoEntity().getCk_catheter(), is(NaiAru.ある.getCode()));
        }
    }

    private static NinteichosaKekka toNinteichosaKekka() {
        return NinteichosaKekkaMapper.toNinteichosaKekka(
                NinteichosaKekkaEntityMock.getSpiedDbT5008NinteichosaKekkaJohoEntityInstance(),
                NinteichosaKekkaEntityMock.getSpiedDbT5009NinteichosahyoJohoEntityInstance(),
                NinteichosaKekkaEntityMock.getSpiedDbT5010NinteiChosaTokkijikoEntityInstance());
    }

    private static DbT5008NinteichosaKekkaJohoEntity toDbT5008NinteichosaKekkaJohoEntity() {
        return NinteichosaKekkaMapper.toDbT5008NinteichosaKekkaJohoEntity(NinteichosaKekkaMock.getSpiedNinteichosaKekkaInstance());
    }

    private static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity() {
        return NinteichosaKekkaMapper.toDbT5009NinteichosahyoJohoEntity(NinteichosaKekkaMock.getSpiedNinteichosaKekkaInstance());
    }
}
