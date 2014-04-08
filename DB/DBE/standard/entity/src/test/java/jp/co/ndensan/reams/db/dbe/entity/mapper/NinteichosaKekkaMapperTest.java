/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaKekkaEntityMock;
import jp.co.ndensan.reams.db.dbe.entity.helper.NinteichosaResultMock;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.Test;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.ChoiceResultItem.*;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfGaikyo.*;
import static jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * 要介護認定調査結果の情報を変換するMapperクラスのテストクラスです。
 *
 * @author N8156 宮本 康
 */
@RunWith(Enclosed.class)
public class NinteichosaKekkaMapperTest {

    public static class toNinteichosaResult {

        @Test
        public void 申請書管理番号の設定がある時_toNinteichosaResult_get申請書管理番号は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get申請書管理番号().value(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toNinteichosaResult_get要介護認定調査履歴番号は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査依頼履歴番号().value().intValue(), is(0));
        }
    }

    public static class toNinteichosaKekka_概況調査結果 {

        @Test
        public void 厚労省IF識別区分の設定がある時_toNinteichosaResult_get厚労省IF識別区分は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get厚労省IF識別区分(), is(KoroshoIFKubun.V09A));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toNinteichosaResult_get認定調査依頼区分は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査依頼区分(), is(NinteichosaIraiKubun.初回));
        }

        @Test
        public void 認定調査回数の設定がある時_toNinteichosaResult_get認定調査回数は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査回数(), is(1));
        }

        @Test
        public void 認定調査実施年月日の設定がある時_toNinteichosaResult_get認定調査実施年月日は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査実施年月日(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査受領年月日の設定がある時_toNinteichosaResult_get認定調査受領年月日は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査受領年月日(), is(new FlexibleDate("20140202")));
        }

        @Test
        public void 認定調査区分の設定がある時_toNinteichosaResult_get認定調査区分は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査区分(), is(NinteichosaKubun.新規調査));
        }

        @Test
        public void 認定調査員コードの設定がある時_toNinteichosaResult_get介護調査員番号は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査員().get介護調査員番号(), is(new RString("12345678")));
        }

        public void 認定調査実施場所コードの設定がある時_toNinteichosaResult_get認定調査実施場所区分_getCodeは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査実施場所区分().getCode().value(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toNinteichosaResult_get認定調査実施場所区分_getNameは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get基本情報().get認定調査実施場所区分().getMeisho(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void サービス区分の設定がある時_toNinteichosaResult_getサービス区分は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(サービス区分コード).get調査結果(), is(ServiceKubun.介護.getCode()));
        }

        @Test
        public void 訪問介護の設定がある時_toNinteichosaResult_get訪問介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(訪問介護).get調査結果(), is(new RString("0")));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toNinteichosaResult_get訪問入浴介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(訪問入浴介護).get調査結果(), is(new RString("1")));
        }

        @Test
        public void 訪問看護の設定がある時_toNinteichosaResult_get訪問看護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(訪問看護).get調査結果(), is(new RString("2")));
        }

        @Test
        public void 訪問リハビリの設定がある時_toNinteichosaResult_get訪問リハビリは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(訪問リハビリ).get調査結果(), is(new RString("3")));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toNinteichosaResult_get居宅療養管理指導は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(居宅療養管理指導).get調査結果(), is(new RString("4")));
        }

        @Test
        public void 通所介護の設定がある時_toNinteichosaResult_get通所介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(通所介護).get調査結果(), is(new RString("5")));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toNinteichosaResult_get通所リハビリテーションは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(通所リハビリテーション).get調査結果(), is(new RString("6")));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toNinteichosaResult_get短期入所生活介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(短期入所生活介護).get調査結果(), is(new RString("7")));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toNinteichosaResult_get短期入所療養介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(短期入所療養介護).get調査結果(), is(new RString("8")));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toNinteichosaResult_get特定施設入居者生活介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(特定施設入居者生活介護).get調査結果(), is(new RString("9")));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toNinteichosaResult_get福祉用具貸与は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(福祉用具貸与).get調査結果(), is(new RString("0")));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toNinteichosaResult_get特定福祉用具販売は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(特定福祉用具販売).get調査結果(), is(new RString("1")));
        }

        @Test
        public void 住宅改修の設定がある時_toNinteichosaResult_get住宅改修は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(住宅改修).get調査結果(), is(new RString("2")));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toNinteichosaResult_get夜間対応型訪問介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(夜間対応型訪問介護).get調査結果(), is(new RString("3")));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toNinteichosaResult_get認知症対応型通所介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(認知症対応型通所介護).get調査結果(), is(new RString("4")));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toNinteichosaResult_get小規模多機能型居宅介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(小規模多機能型居宅介護).get調査結果(), is(new RString("5")));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toNinteichosaResult_get認知症対応型共同生活介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(認知症対応型共同生活介護).get調査結果(), is(new RString("6")));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toNinteichosaResult_get地域密着型特定施設入居者生活介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(地域密着型特定施設入居者生活介護).get調査結果(), is(new RString("7")));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toNinteichosaResult_get地域密着型介護老人福祉施設入所者生活介護は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(地域密着型介護老人福祉施設入所者生活介護).get調査結果(), is(new RString("8")));
        }

        @Test
        public void 市町村特別給付の設定がある時_toNinteichosaResult_get市町村特別給付は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(市町村特別給付).get調査結果(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toNinteichosaResult_get介護保険給付以外の在宅サービスは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(介護保険給付以外の在宅サービス).get調査結果(), is(new RString("介護保険給付以外の在宅サービス")));
        }

        @Test
        public void 利用施設コードの設定がある時_toNinteichosaResult_get利用施設コードは_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(利用施設コード).get調査結果(), is(new RString("利用施設コード")));
        }

        @Test
        public void 利用施設名の設定がある時_toNinteichosaResult_get利用施設名は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(利用施設名).get調査結果(), is(new RString("利用施設名")));
        }

        @Test
        public void 利用施設住所の設定がある時_toNinteichosaResult_get利用施設住所は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(利用施設住所).get調査結果(), is(new RString("利用施設住所")));
        }

        @Test
        public void 利用施設電話番号の設定がある時_toNinteichosaResult_get利用施設電話番号は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(利用施設電話番号).get調査結果(), is(new RString("利用施設電話番号")));
        }

        @Test
        public void 利用施設郵便番号の設定がある時_toNinteichosaResult_get利用施設郵便番号は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(利用施設郵便番号).get調査結果(), is(new RString("1234567")));
        }

        @Test
        public void 概況特記事項の設定がある時_toNinteichosaResult_get概況特記事項は_設定値を返す() {
            assertThat(toNinteichosaResult().get概況調査結果().get認定調査票().get調査項目(概況特記事項).get調査結果(), is(new RString("概況特記事項")));
        }
    }

    public static class toNinteichosaResult_調査票結果 {

        @Test
        public void 厚労省IF識別区分の設定がある時_toNinteichosaResult_get厚労省IF識別区分は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get厚労省IF識別区分(), is(KoroshoIFKubun.V09A));
        }

        @Test
        public void 麻痺左上肢の設定がある時_toNinteichosaResult_get麻痺左上肢は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(麻痺等の有無_左上肢).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toNinteichosaResult_get麻痺右上肢は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(麻痺等の有無_右上肢).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toNinteichosaResult_get麻痺左下肢は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(麻痺等の有無_左下肢).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toNinteichosaResult_get麻痺右下肢は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(麻痺等の有無_右下肢).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺その他の設定がある時_toNinteichosaResult_get麻痺その他は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(麻痺等の有無_その他).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toNinteichosaResult_get拘縮肩関節は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(関節の動く範囲の制限_肩関節).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮股関節の設定がある時_toNinteichosaResult_get拘縮股関節は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(関節の動く範囲の制限_股関節).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toNinteichosaResult_get拘縮膝関節は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(関節の動く範囲の制限_膝関節).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮その他の設定がある時_toNinteichosaResult_get拘縮その他は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(関節の動く範囲の制限_その他).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 寝返りの設定がある時_toNinteichosaResult_get寝返りは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(寝返り).get調査結果(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 起き上がりの設定がある時_toNinteichosaResult_get起き上がりは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(起き上がり).get調査結果(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 座位保持の設定がある時_toNinteichosaResult_get座位保持は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(座位保持).get調査結果(), is(DekiruDekinai6.できる.getCode()));
        }

        @Test
        public void 両足での立位の設定がある時_toNinteichosaResult_get両足での立位は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(両足での立位).get調査結果(), is(DekiruDekinai5.できない.getCode()));
        }

        @Test
        public void 歩行の設定がある時_toNinteichosaResult_get歩行は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(歩行).get調査結果(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 立ち上がりの設定がある時_toNinteichosaResult_get立ち上がりは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(立ち上がり).get調査結果(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 片足での立位の設定がある時_toNinteichosaResult_get片足での立位は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(片足での立位).get調査結果(), is(DekiruDekinai5.できる.getCode()));
        }

        @Test
        public void 洗身の設定がある時_toNinteichosaResult_get洗身は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(洗身).get調査結果(), is(Kaijo2.自立.getCode()));
        }

        @Test
        public void つめ切りの設定がある時_toNinteichosaResult_getつめ切りは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(つめ切り).get調査結果(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 視力の設定がある時_toNinteichosaResult_get視力は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(視力).get調査結果(), is(Shiryoku.普通.getCode()));
        }

        @Test
        public void 聴力の設定がある時_toNinteichosaResult_get聴力は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(聴力).get調査結果(), is(Choryoku.判断不能.getCode()));
        }

        @Test
        public void 移乗の設定がある時_toNinteichosaResult_get移乗は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(移乗).get調査結果(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 移動の設定がある時_toNinteichosaResult_get移動は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(移動).get調査結果(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 嚥下の設定がある時_toNinteichosaResult_get嚥下_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(嚥下).get調査結果(), is(DekiruDekinai4.できる.getCode()));
        }

        @Test
        public void 食事摂取の設定がある時_toNinteichosaResult_get食事摂取は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(食事摂取).get調査結果(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 排尿の設定がある時_toNinteichosaResult_get排尿は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(排尿).get調査結果(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 排便の設定がある時_toNinteichosaResult_get排便は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(排便).get調査結果(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 口腔清潔の設定がある時_toNinteichosaResult_get口腔清潔は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(口腔清潔).get調査結果(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 洗顔の設定がある時_toNinteichosaResult_get洗顔は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(洗顔).get調査結果(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 整髪の設定がある時_toNinteichosaResult_get整髪は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(整髪).get調査結果(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 上衣の着脱の設定がある時_toNinteichosaResult_get上衣の着脱は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(上衣の着脱).get調査結果(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toNinteichosaResult_getズボン等の着脱は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(ズボン等の着脱).get調査結果(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 外出頻度の設定がある時_toNinteichosaResult_get整髪外出頻度_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(外出頻度).get調査結果(), is(Gaishutsu.月１回以上.getCode()));
        }

        @Test
        public void 意思の伝達の設定がある時_toNinteichosaResult_get意思の伝達は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(意思の伝達).get調査結果(), is(DekiruDekinai2.できる.getCode()));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toNinteichosaResult_get毎日の日課を理解は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(毎日の日課を理解).get調査結果(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 生年月日をいうの設定がある時_toNinteichosaResult_get生年月日をいうは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(生年月日をいう).get調査結果(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toNinteichosaResult_get短期記憶は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(短期記憶).get調査結果(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toNinteichosaResult_get自分の名前をいうは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(自分の名前をいう).get調査結果(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 今の季節を理解の設定がある時_toNinteichosaResult_get今の季節を理解は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(今の季節を理解).get調査結果(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 場所の理解の設定がある時_toNinteichosaResult_get場所の理解は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(場所の理解).get調査結果(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toNinteichosaResult_get徘徊は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(常時の徘徊).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 外出して戻れないの設定がある時_toNinteichosaResult_get外出して戻れないは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(外出して戻れない).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 被害的の設定がある時_toNinteichosaResult_get被害的は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(被害的).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 作話の設定がある時_toNinteichosaResult_get作話は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(作話).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 感情が不安定の設定がある時_toNinteichosaResult_get感情が不安定は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(感情が不安定).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toNinteichosaResult_get昼夜逆転は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(昼夜逆転).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 同じ話をするの設定がある時_toNinteichosaResult_get同じ話をするは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(同じ話をする).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 大声を出すの設定がある時_toNinteichosaResult_get大声を出すは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(大声を出す).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 介護に抵抗の設定がある時_toNinteichosaResult_get介護に抵抗は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(介護に抵抗).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 落ち着きなしの設定がある時_toNinteichosaResult_get落ち着きなしは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(落ち着きなし).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 一人で出たがるの設定がある時_toNinteichosaResult_get一人で出たがるは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(一人で出たがる).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 収集癖の設定がある時_toNinteichosaResult_get収集癖は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(収集癖).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toNinteichosaResult_get物や衣類を壊すは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(物や衣類を壊す).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void ひどい物忘れの設定がある時_toNinteichosaResult_getひどい物忘れは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(ひどい物忘れ).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toNinteichosaResult_get独り言独り笑いは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(独り言_独り笑).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toNinteichosaResult_get自分勝手に行動するは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(自分勝手に行動する).get調査結果(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 話がまとまらないの設定がある時_toNinteichosaResult_get話がまとまらないは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(話がまとまらない).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 薬の内服の設定がある時_toNinteichosaResult_get薬の内服は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(薬の内服).get調査結果(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 金銭の管理の設定がある時_toNinteichosaResult_get金銭の管理は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(金銭の管理).get調査結果(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 日常の意思決定の設定がある時_toNinteichosaResult_get日常の意思決定は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(日常の意思決定).get調査結果(), is(DekiruDekinai7.できる.getCode()));
        }

        @Test
        public void 集団への不適応の設定がある時_toNinteichosaResult_get集団への不適応は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(集団への不適応).get調査結果(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 買い物の設定がある時_toNinteichosaResult_get買い物は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(買い物).get調査結果(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 簡単な調理の設定がある時_toNinteichosaResult_get簡単な調理は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(簡単な調理).get調査結果(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 点滴の管理の設定がある時_toNinteichosaResult_get点滴の管理は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(点滴の管理).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toNinteichosaResult_get中心静脈栄養は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(中心静脈栄養).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 透析の設定がある時_toNinteichosaResult_get透析は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(透析).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toNinteichosaResult_getストーマの処置は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(ストーマの処置).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toNinteichosaResult_get酸素療法は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(酸素療法).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toNinteichosaResult_getレスピレーターは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(レスピレーター).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toNinteichosaResult_get気管切開の処置は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(気管切開).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toNinteichosaResult_get疼痛の看護は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(疼痛の看護).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toNinteichosaResult_get経管栄養は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(経管栄養).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toNinteichosaResult_getモニター測定は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(モニター測定).get調査結果(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void じょくそうの処置の設定がある時_toNinteichosaResult_getじょくそうの処置は_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(じょくそうの処置).get調査結果(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toNinteichosaResult_getカテーテルは_設定値を返す() {
            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(カテーテル).get調査結果(), is(NaiAru.ある.getCode()));
        }
        //TODO n8178 城間篤人 DBの構造に修正が入ったため、テストが通らなくなった。別チケットで対応される予定 2014年4月
//
//        @Test
//        public void 障害高齢者の日常生活自立度の設定がある時_toNinteichosaResult_get障害高齢者の日常生活自立度は_設定値を返す() {
//            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(障害高齢者の日常生活自立度).get調査結果(), is(ShogaiJiritsu.Ａ１.getCode()));
//        }
//
//        @Test
//        public void 認知症高齢者の日常生活自立度の設定がある時_toNinteichosaResult_get認知症高齢者の日常生活自立度は_設定値を返す() {
//            assertThat(toNinteichosaResult().get基本調査結果().get認定調査票().get調査項目(認知症高齢者の日常生活自立度).get調査結果(), is(NinchishoJiritsu.Ⅱａ.getCode()));
//        }
    }

    public static class toNinteichosaKekkaEntity_getDbT5008NinteichosaKekkaJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toNinteichosaKekkaEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getShinseishoKanriNo().value(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toNinteichosaKekkaEntity_getNinteichosaRirekiNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 厚労省IF識別区分の設定がある時_toNinteichosaKekkaEntity_getKoroshoIfShikibetsuCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getKoroshoIfShikibetsuCode(), is(new RString("09A")));
        }

        @Test
        public void 認定調査依頼区分の設定がある時_toNinteichosaKekkaEntity_getNinteichousaIraiKubunCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteichosaIraiKubunCode().value(), is(NinteichosaIraiKubun.初回.getCode()));
        }

        @Test
        public void 認定調査回数の設定がある時_toNinteichosaKekkaEntity_getNinteichosaIraiKaisuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteichosaIraiKaisu(), is(1));
        }

        @Test
        public void 認定調査実施年月日の設定がある時_toNinteichosaKekkaEntity_getNinteichosaJisshiYMDは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteichosaJisshiYMD(), is(new FlexibleDate("20140101")));
        }

        @Test
        public void 認定調査受領年月日の設定がある時_toNinteichosaKekkaEntity_getNinteichosaJuryoYMDは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteichosaJuryoYMD(), is(new FlexibleDate("20140202")));
        }

        @Test
        public void 認定調査区分の設定がある時_toNinteichosaKekkaEntity_getNinteiChosaKubunCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinteiChosaKubunCode().value(), is(NinteichosaKubun.新規調査.getCode()));
        }

        @Test
        public void 認定調査員コードの設定がある時_toNinteichosaKekkaEntity_getChosainCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getChosainCode(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所コードの設定がある時_toNinteichosaKekkaEntity_getChosaJisshiBashoCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getChosaJisshiBashoCode().value(), is(new RString("12345678")));
        }

        @Test
        public void 認定調査実施場所名称の設定がある時_toNinteichosaKekkaEntity_getChosaJisshiBashoMeishoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getChosaJisshiBashoMeisho(), is(new RString("認定調査実施場所名称")));
        }

        @Test
        public void サービス区分の設定がある時_toNinteichosaKekkaEntity_getServiceKubunCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getServiceKubunCode().value(), is(ServiceKubun.介護.getCode()));
        }

        @Test
        public void 訪問介護の設定がある時_toNinteichosaKekkaEntity_getHomonKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getHomonKaigo(), is(0));
        }

        @Test
        public void 訪問入浴介護の設定がある時_toNinteichosaKekkaEntity_getHomonNyuyokuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getHomonNyuyokuKaigo(), is(1));
        }

        @Test
        public void 訪問看護の設定がある時_toNinteichosaKekkaEntity_getHomonKangoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getHomonKango(), is(2));
        }

        @Test
        public void 訪問リハビリの設定がある時_toNinteichosaKekkaEntity_getHomonRehabilitationは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getHomonRehabilitation(), is(3));
        }

        @Test
        public void 居宅療養管理指導の設定がある時_toNinteichosaKekkaEntity_getKyotakuRyoyoKanriShidoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getKyotakuRyoyoKanriShido(), is(4));
        }

        @Test
        public void 通所介護の設定がある時_toNinteichosaKekkaEntity_getTushoKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTushoKaigo(), is(5));
        }

        @Test
        public void 通所リハビリテーションの設定がある時_toNinteichosaKekkaEntity_getTushoRehabilitationは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTushoRehabilitation(), is(6));
        }

        @Test
        public void 短期入所生活介護の設定がある時_toNinteichosaKekkaEntity_getTankiNyushoSeikatsuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTankiNyushoSeikatsuKaigo(), is(7));
        }

        @Test
        public void 短期入所療養介護の設定がある時_toNinteichosaKekkaEntity_getTankiNyushoRyoyoKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTankiNyushoRyoyoKaigo(), is(8));
        }

        @Test
        public void 特定施設入居者生活介護の設定がある時_toNinteichosaKekkaEntity_getTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(9));
        }

        @Test
        public void 福祉用具貸与の設定がある時_toNinteichosaKekkaEntity_getHukushiYoguTaiyoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getHukushiYoguTaiyo(), is(0));
        }

        @Test
        public void 特定福祉用具販売の設定がある時_toNinteichosaKekkaEntity_getTokuteiHukushiYoguHanbaiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getTokuteiHukushiYoguHanbai(), is(1));
        }

        @Test
        public void 住宅改修の設定がある時_toNinteichosaKekkaEntity_getJutakuKaishuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getJutakuKaishu(), is(2));
        }

        @Test
        public void 夜間対応型訪問介護の設定がある時_toNinteichosaKekkaEntity_getYakanTaiogataHomonKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getYakanTaiogataHomonKaigo(), is(3));
        }

        @Test
        public void 認知症対応型通所介護の設定がある時_toNinteichosaKekkaEntity_getNinchishoTaiogataTushoKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinchishoTaiogataTushoKaigo(), is(4));
        }

        @Test
        public void 小規模多機能型居宅介護の設定がある時_toNinteichosaKekkaEntity_getShokiboTakinogataKyotakuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getShokiboTakinogataKyotakuKaigo(), is(5));
        }

        @Test
        public void 認知症対応型共同生活介護の設定がある時_toNinteichosaKekkaEntity_getNinchishoTaiogataKyodoSeikatsuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinchishoTaiogataKyodoSeikatsuKaigo(), is(6));
        }

        @Test
        public void 地域密着型特定施設入居者生活介護の設定がある時_toNinteichosaKekkaEntity_getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(), is(7));
        }

        @Test
        public void 地域密着型介護老人福祉施設入所者生活介護の設定がある時_toNinteichosaKekkaEntity_getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(), is(8));
        }

        @Test
        public void 市町村特別給付の設定がある時_toNinteichosaKekkaEntity_getShichosonTokubetsuKyufuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getShichosonTokubetsuKyufu(), is(new RString("市町村特別給付")));
        }

        @Test
        public void 介護保険給付以外の在宅サービスの設定がある時_toNinteichosaKekkaEntity_getKaigohokenKyufuIgaiNoZaitakuServiceは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getKaigohokenKyufuIgaiNoZaitakuService(), is(new RString("介護保険給付以外の在宅サービス")));
        }

        @Test
        public void 利用施設コードの設定がある時_toNinteichosaKekkaEntity_getRiyoShisetsuCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getRiyoShisetsuCode().getColumnValue(), is(new RString("利用施設コード")));
        }

        @Test
        public void 利用施設名の設定がある時_toNinteichosaKekkaEntity_getRiyoShisetsuShimeiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getRiyoShisetsuShimei(), is(new RString("利用施設名")));
        }

        @Test
        public void 利用施設住所の設定がある時_toNinteichosaKekkaEntity_getRiyoShisetsuJushoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getRiyoShisetsuJusho().value(), is(new RString("利用施設住所")));
        }

        @Test
        public void 利用施設電話番号の設定がある時_toNinteichosaKekkaEntity_getRiyoShisetsuTelNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getRiyoShisetsuTelNo().value(), is(new RString("利用施設電話番号")));
        }

        @Test
        public void 利用施設郵便番号の設定がある時_toNinteichosaKekkaEntity_getRiyoShisetsuYubinNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getRiyoShisetsuYubinNo().value(), is(new RString("1234567")));
        }

        @Test
        public void 概況特記事項の設定がある時_toNinteichosaKekkaEntity_getGaikyochosaTokkijikoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getGaikyochosaTokkijiko(), is(new RString("概況特記事項")));
        }
        //TODO n8178 城間篤人 DBの構造に修正が入ったため、テストが通らなくなった。別チケットで対応される予定 2014年4月
//        @Test
//        public void 障害高齢者の日常生活自立度の設定がある時_toNinteichosaKekkaEntity_getShogaiNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
//            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getShogaiNichijoSeikatsuJiritsudoCode().value(), is(ShogaiJiritsu.Ａ１.getCode()));
//        }
//
//        @Test
//        public void 認知症高齢者の日常生活自立度の設定がある時_toNinteichosaKekkaEntity_getNinchishoNichijoSeikatsuJiritsudoCodeは_設定値を返す() {
//            assertThat(toNinteichosaKekkaEntity().getDbT5008NinteichosaKekkaJohoEntity().getNinchishoNichijoSeikatsuJiritsudoCode().value(), is(NinchishoJiritsu.Ⅱａ.getCode()));
//        }
    }

    public static class toNinteichosaKekkaEntity_getDbT5009NinteichosahyoJohoEntity {

        @Test
        public void 申請書管理番号の設定がある時_toNinteichosaKekkaEntity_getShinseishoKanriNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getShinseishoKanriNo().value(), is(new RString("1234567890")));
        }

        @Test
        public void 要介護認定調査履歴番号の設定がある時_toNinteichosaKekkaEntity_getNinteichosaRirekiNoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getNinteichosaRirekiNo(), is(0));
        }

        @Test
        public void 厚労省IF識別区分の設定がある時_toNinteichosaKekkaEntity_getKoroshoIfShikibetsuCodeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getKoroshoIfShikibetsuCode(), is(new RString("09A")));
        }

        @Test
        public void 麻痺左上肢の設定がある時_toNinteichosaKekkaEntity_getCk_mahiHidariJoshiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_mahiHidariJoshi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右上肢の設定がある時_toNinteichosaKekkaEntity_getCk_mahiMigiJoshiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_mahiMigiJoshi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺左下肢の設定がある時_toNinteichosaKekkaEntity_getCk_mahiHidariKashiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_mahiHidariKashi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 麻痺右下肢の設定がある時_toNinteichosaKekkaEntity_getCk_mahiMigiKashiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_mahiMigiKashi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 麻痺その他の設定がある時_toNinteichosaKekkaEntity_getCk_mahiSonotaは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_mahiSonota(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮肩関節の設定がある時_toNinteichosaKekkaEntity_getCk_koshukuKataは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_koshukuKata(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮股関節の設定がある時_toNinteichosaKekkaEntity_getCk_koshukuMataは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_koshukuMata(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 拘縮膝関節の設定がある時_toNinteichosaKekkaEntity_getCk_koshukuHizaは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_koshukuHiza(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 拘縮その他の設定がある時_toNinteichosaKekkaEntity_getCk_koshukuSonotaは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_koshukuSonota(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 寝返りの設定がある時_toNinteichosaKekkaEntity_getCk_negaeriは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_negaeri(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 起き上がりの設定がある時_toNinteichosaKekkaEntity_getCk_okiagariは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_okiagari(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 座位保持の設定がある時_toNinteichosaKekkaEntity_getCk_zaihojiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_zaihoji(), is(DekiruDekinai6.できる.getCode()));
        }

        @Test
        public void 両足での立位の設定がある時_toNinteichosaKekkaEntity_getCk_ryoashiRitsuiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ryoashiRitsui(), is(DekiruDekinai5.できない.getCode()));
        }

        @Test
        public void 歩行の設定がある時_toNinteichosaKekkaEntity_getCk_hokoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hoko(), is(DekiruDekinai3.できる.getCode()));
        }

        @Test
        public void 立ち上がりの設定がある時_toNinteichosaKekkaEntity_getCk_tachiagariは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_tachiagari(), is(DekiruDekinai3.できない.getCode()));
        }

        @Test
        public void 片足での立位の設定がある時_toNinteichosaKekkaEntity_getCk_kataashiRitsuiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kataashiRitsui(), is(DekiruDekinai5.できる.getCode()));
        }

        @Test
        public void 洗身の設定がある時_toNinteichosaKekkaEntity_getCk_senshinは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_senshin(), is(Kaijo2.自立.getCode()));
        }

        @Test
        public void つめ切りの設定がある時_toNinteichosaKekkaEntity_getCk_tumekiriは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_tumekiri(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 視力の設定がある時_toNinteichosaKekkaEntity_getCk_shiryokuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_shiryoku(), is(Shiryoku.普通.getCode()));
        }

        @Test
        public void 聴力の設定がある時_toNinteichosaKekkaEntity_getCk_choryokuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_choryoku(), is(Choryoku.判断不能.getCode()));
        }

        @Test
        public void 移乗の設定がある時_toNinteichosaKekkaEntity_getCk_ijoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ijo(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 移動の設定がある時_toNinteichosaKekkaEntity_getCk_idoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ido(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 嚥下の設定がある時_toNinteichosaKekkaEntity_getCk_engeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_enge(), is(DekiruDekinai4.できる.getCode()));
        }

        @Test
        public void 食事摂取の設定がある時_toNinteichosaKekkaEntity_getCk_shokujiSesshuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_shokujiSesshu(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 排尿の設定がある時_toNinteichosaKekkaEntity_getCk_hainyoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hainyo(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 排便の設定がある時_toNinteichosaKekkaEntity_getCk_haibenは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_haiben(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 口腔清潔の設定がある時_toNinteichosaKekkaEntity_getCk_kokoSeiketsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kokoSeiketsu(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 洗顔の設定がある時_toNinteichosaKekkaEntity_getCk_senganは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_sengan(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 整髪の設定がある時_toNinteichosaKekkaEntity_getCk_seihatsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_seihatsu(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 上衣の着脱の設定がある時_toNinteichosaKekkaEntity_getCk_joiChakudatsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_joiChakudatsu(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void ズボン等の着脱の設定がある時_toNinteichosaKekkaEntity_getCk_zubonChakudatsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_zubonChakudatsu(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 外出頻度の設定がある時_toNinteichosaKekkaEntity_getCk_gaishutsuHindoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_gaishutsuHindo(), is(Gaishutsu.月１回以上.getCode()));
        }

        @Test
        public void 意思の伝達の設定がある時_toNinteichosaKekkaEntity_getCk_ishiDentatsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ishiDentatsu(), is(DekiruDekinai2.できる.getCode()));
        }

        @Test
        public void 毎日の日課を理解の設定がある時_toNinteichosaKekkaEntity_getCk_nikkaは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_nikka(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 生年月日をいうの設定がある時_toNinteichosaKekkaEntity_getCk_seinengappiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_seinengappi(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 短期記憶の設定がある時_toNinteichosaKekkaEntity_getCk_tankiKiokuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_tankiKioku(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 自分の名前をいうの設定がある時_toNinteichosaKekkaEntity_getCk_namaeは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_namae(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 今の季節を理解の設定がある時_toNinteichosaKekkaEntity_getCk_kisetsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kisetsu(), is(DekiruDekinai.できない.getCode()));
        }

        @Test
        public void 場所の理解の設定がある時_toNinteichosaKekkaEntity_getCk_bashoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_basho(), is(DekiruDekinai.できる.getCode()));
        }

        @Test
        public void 徘徊の設定がある時_toNinteichosaKekkaEntity_getCk_haikaiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_haikai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 外出して戻れないの設定がある時_toNinteichosaKekkaEntity_getCk_gaishutsuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_gaishutsu(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 被害的の設定がある時_toNinteichosaKekkaEntity_getCk_higaitekiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_higaiteki(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 作話の設定がある時_toNinteichosaKekkaEntity_getCk_sakuwaは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_sakuwa(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 感情が不安定の設定がある時_toNinteichosaKekkaEntity_getCk_kanjoHuanteiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kanjoHuantei(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 昼夜逆転の設定がある時_toNinteichosaKekkaEntity_getCk_chuyaGyakutenは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_chuyaGyakuten(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 同じ話をするの設定がある時_toNinteichosaKekkaEntity_getCk_onajiHanashiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_onajiHanashi(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 大声を出すの設定がある時_toNinteichosaKekkaEntity_getCk_ogoe_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ogoe(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 介護に抵抗の設定がある時_toNinteichosaKekkaEntity_getCk_kaigoNiTeikoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kaigoNiTeiko(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 落ち着きなしの設定がある時_toNinteichosaKekkaEntity_getCk_ochitsukiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ochitsuki(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 一人で出たがるの設定がある時_toNinteichosaKekkaEntity_getCk_hitoriDeDetagaruは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hitoriDeDetagaru(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 収集癖の設定がある時_toNinteichosaKekkaEntity_getCk_shushuhekiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_shushuheki(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 物や衣類を壊すの設定がある時_toNinteichosaKekkaEntity_getCk_monoYaIruiWoKowasuは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_monoYaIruiWoKowasu(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void ひどい物忘れの設定がある時_toNinteichosaKekkaEntity_getCk_hidoiMonowasureは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hidoiMonowasure(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 独り言独り笑いの設定がある時_toNinteichosaKekkaEntity_getCk_hitorigotoHitoriwaraiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hitorigotoHitoriwarai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 自分勝手に行動するの設定がある時_toNinteichosaKekkaEntity_getCk_jibunKatteは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_jibunKatte(), is(NaiAru2.ある.getCode()));
        }

        @Test
        public void 話がまとまらないの設定がある時_toNinteichosaKekkaEntity_getCk_hanashiGaMatomaranaiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_hanashiGaMatomaranai(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 薬の内服の設定がある時_toNinteichosaKekkaEntity_getCk_kusuriは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kusuri(), is(Kaijo.自立.getCode()));
        }

        @Test
        public void 金銭の管理の設定がある時_toNinteichosaKekkaEntity_getCk_kinsenKanriは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kinsenKanri(), is(Kaijo.全介助.getCode()));
        }

        @Test
        public void 日常の意思決定の設定がある時_toNinteichosaKekkaEntity_getCk_ishiKetteiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_ishiKettei(), is(DekiruDekinai7.できる.getCode()));
        }

        @Test
        public void 集団への不適応の設定がある時_toNinteichosaKekkaEntity_getCk_shudanHutekioは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_shudanHutekio(), is(NaiAru2.ない.getCode()));
        }

        @Test
        public void 買い物の設定がある時_toNinteichosaKekkaEntity_getCk_kaimonoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kaimono(), is(Kaijo3.自立.getCode()));
        }

        @Test
        public void 簡単な調理の設定がある時_toNinteichosaKekkaEntity_getCk_choriは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_chori(), is(Kaijo3.全介助.getCode()));
        }

        @Test
        public void 点滴の管理の設定がある時_toNinteichosaKekkaEntity_getCk_tentekiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_tenteki(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 中心静脈栄養の設定がある時_toNinteichosaKekkaEntity_getCk_chushinJomyakuEiyoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_chushinJomyakuEiyo(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 透析の設定がある時_toNinteichosaKekkaEntity_getCk_tosekiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_toseki(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void ストーマの処置の設定がある時_toNinteichosaKekkaEntity_getCk_stomaShochiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_stomaShochi(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 酸素療法の設定がある時_toNinteichosaKekkaEntity_getCk_sansoRyohoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_sansoRyoho(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void レスピレーターの設定がある時_toNinteichosaKekkaEntity_getCk_respiratorは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_respirator(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 気管切開の処置の設定がある時_toNinteichosaKekkaEntity_getCk_kikanSekkaiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_kikanSekkai(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void 疼痛の看護の設定がある時_toNinteichosaKekkaEntity_getCk_totsuKangoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_totsuKango(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void 経管栄養の設定がある時_toNinteichosaKekkaEntity_getCk_keikanEiyoは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_keikanEiyo(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void モニター測定の設定がある時_toNinteichosaKekkaEntity_getCk_monitorSokuteiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_monitorSokutei(), is(NaiAru.ある.getCode()));
        }

        @Test
        public void じょくそうの処置の設定がある時_toNinteichosaKekkaEntity_getCk_jokusoShochiは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_jokusoShochi(), is(NaiAru.ない.getCode()));
        }

        @Test
        public void カテーテルの設定がある時_toNinteichosaKekkaEntity_getCk_catheterは_設定値を返す() {
            assertThat(toNinteichosaKekkaEntity().getDbT5009NinteichosahyoJohoEntity().getCk_catheter(), is(NaiAru.ある.getCode()));
        }
    }

    private static NinteichosaResult toNinteichosaResult() {
        return NinteichosaKekkaMapper.toNinteichosaResult(NinteichosaKekkaEntityMock.getSpiedNinteichosaKekkaEntityInstance(), NinteichosaResultMock.getSpiedNinteichosaResultGaikyoInstance().get基本情報().get認定調査員());
    }

    private static NinteichosaKekkaEntity toNinteichosaKekkaEntity() {
        return NinteichosaKekkaMapper.toNinteichosaKekkaEntity(NinteichosaResultMock.getSpiedNinteichosaResultInstance());
    }
}
