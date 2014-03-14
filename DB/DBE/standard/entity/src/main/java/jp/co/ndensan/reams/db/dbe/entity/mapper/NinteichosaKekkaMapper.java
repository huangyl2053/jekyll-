/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemForResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.INinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.ur.urf.business.INinteiChosain;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査結果情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosaKekkaMapper {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaMapper() {
    }

    /**
     * 引数の認定調査結果エンティティから認定調査結果情報を作成して返します。
     *
     * @param ninteichosaKekkaEntity 認定調査結果エンティティ
     * @param chosain 認定調査員情報
     * @return 認定調査結果情報
     */
    public static NinteichosaResult toNinteichosaResult(NinteichosaKekkaEntity ninteichosaKekkaEntity, INinteiChosain chosain) {
        return new NinteichosaResult(toNinteichosaResultGaikyo(ninteichosaKekkaEntity, chosain), toNinteichosaResultKihon(ninteichosaKekkaEntity));
    }

    /**
     * 引数の認定調査結果情報から認定調査結果エンティティを作成して返します。
     *
     * @param ninteichosaResult 認定調査結果情報
     * @return 認定調査結果エンティティ
     */
    public static NinteichosaKekkaEntity toNinteichosaKekkaEntity(NinteichosaResult ninteichosaResult) {
        NinteichosaKekkaEntity ninteichosaKekkaEntity = new NinteichosaKekkaEntity();
        ninteichosaKekkaEntity.setDbT5008NinteichosaKekkaJohoEntity(toDbT5008NinteichosaKekkaJohoEntity(ninteichosaResult));
        ninteichosaKekkaEntity.setDbT5009NinteichosahyoJohoEntity(toDbT5009NinteichosahyoJohoEntity(ninteichosaResult));
        return ninteichosaKekkaEntity;
    }

    private static DbT5008NinteichosaKekkaJohoEntity toDbT5008NinteichosaKekkaJohoEntity(NinteichosaResult ninteichosaKekka) {

        NinteichosaResultOfGaikyoKihon rsltKihon = ninteichosaKekka.get概況調査結果().get基本情報();
        Ninteichosahyo<NinteichosaItemKubunOfGaikyo, NinteichosaItemForResult> rsltGaikyoService = ninteichosaKekka.get概況調査結果().getサービス状況();

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get概況調査結果().get申請書管理番号());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get概況調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setKoroshoIfShikibetsuCode(ninteichosaKekka.get概況調査結果().get厚労省IF識別区分().getCode());
        entity.setNinteichousaIraiKubunCode(new Code(rsltKihon.get認定調査依頼区分().getCode()));
        entity.setNinteichosaIraiKaisu(rsltKihon.get認定調査回数());
        entity.setNinteichosaJisshiYMD(rsltKihon.get認定調査実施年月日());
        entity.setNinteichosaJuryoYMD(rsltKihon.get認定調査受領年月日());
        entity.setNinteiChosaKubunCode(new Code(rsltKihon.get認定調査区分().getCode()));
        entity.setChosainCode(rsltKihon.get認定調査員().get介護調査員番号());
        entity.setChosaJisshiBashoCode(new Code(rsltKihon.get認定調査実施場所区分().getCode().value()));
        entity.setChosaJisshiBashoMeisho(rsltKihon.get認定調査実施場所区分().getName());
        entity.setGenzainoJokyoCode(rsltGaikyoService.get調査結果ByCodeValue(NinteichosaItemKubunOfGaikyo.現在の状況コード));
        entity.setServiceKubunCode(rsltGaikyoService.get調査結果ByCodeValue(NinteichosaItemKubunOfGaikyo.サービス区分コード));
        entity.setHomonKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.訪問介護));
        entity.setHomonNyuyokuKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.訪問入浴介護));
        entity.setHomonKango(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.訪問看護));
        entity.setHomonRehabilitation(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.訪問リハビリ));
        entity.setKyotakuRyoyoKanriShido(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.居宅療養管理指導));
        entity.setTushoKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.通所介護));
        entity.setTushoRehabilitation(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.通所リハビリテーション));
        entity.setTankiNyushoSeikatsuKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.短期入所生活介護));
        entity.setTankiNyushoRyoyoKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.短期入所療養介護));
        entity.setTokuteiShisetsuNyushoshaSeikatsuKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護));
        entity.setHukushiYoguTaiyo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.福祉用具貸与));
        entity.setTokuteiHukushiYoguHanbai(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.特定福祉用具販売));
        entity.setJutakuKaishu(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.住宅改修));
        entity.setYakanTaiogataHomonKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護));
        entity.setNinchishoTaiogataTushoKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.認知症対応型通所介護));
        entity.setShokiboTakinogataKyotakuKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護));
        entity.setNinchishoTaiogataKyodoSeikatsuKaigo(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護));
        entity.setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(
                rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護));
        entity.setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(
                rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護));
        entity.setTeikijunkaiZuijiTaiogataHomonKaigoKango(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.定期巡回_随時対応型訪問介護看護));
        entity.setHukugogataService(rsltGaikyoService.get調査結果ByIntValue(NinteichosaItemKubunOfGaikyo.複合型サービス));
        entity.setShichosonTokubetsuKyufu(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.市町村特別給付));
        entity.setKaigohokenKyufuIgaiNoZaitakuService(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.介護保険給付以外の在宅サービス));
        entity.setRiyoShisetsuCode(new JigyoshaNo(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.利用施設コード)));
        entity.setRiyoShisetsuShimei(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.利用施設名));
        entity.setRiyoShisetsuJusho(new AtenaJusho(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.利用施設住所)));
        entity.setRiyoShisetsuTelNo(new TelNo(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.利用施設電話番号)));
        entity.setRiyoShisetsuYubinNo(new YubinNo(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.利用施設郵便番号)));
        entity.setGaikyochosaTokkijiko(rsltGaikyoService.get調査結果ByStringValue(NinteichosaItemKubunOfGaikyo.概況特記事項));

        return entity;
    }

    private static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        Ninteichosahyo<NinteichosaItemKubunOfKihon, NinteichosaItemForResult> rsltKihon = ninteichosaKekka.get基本調査結果().get基本情報();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get基本調査結果().get申請書管理番号());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get基本調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setKoroshoIfShikibetsuCode(ninteichosaKekka.get基本調査結果().get厚労省IF識別区分().getCode());
        entity.setCk_mahiHidariJoshi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢));
        entity.setCk_mahiMigiJoshi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢));
        entity.setCk_mahiHidariKashi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢));
        entity.setCk_mahiMigiKashi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢));
        entity.setCk_mahiSonota(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.麻痺等の有無_その他));
        entity.setCk_koshukuKata(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節));
        entity.setCk_koshukuMata(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節));
        entity.setCk_koshukuHiza(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節));
        entity.setCk_koshukuSonota(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他));
        entity.setCk_negaeri(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.寝返り));
        entity.setCk_okiagari(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.起き上がり));
        entity.setCk_zaihoji(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.座位保持));
        entity.setCk_ryoashiRitsui(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.両足での立位));
        entity.setCk_hoko(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.歩行));
        entity.setCk_tachiagari(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.立ち上がり));
        entity.setCk_kataashiRitsui(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.片足での立位));
        entity.setCk_senshin(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.洗身));
        entity.setCk_tumekiri(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.つめ切り));
        entity.setCk_shiryoku(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.視力));
        entity.setCk_choryoku(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.聴力));
        entity.setCk_ijo(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.移乗));
        entity.setCk_ido(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.移動));
        entity.setCk_enge(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.嚥下));
        entity.setCk_shokujiSesshu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.食事摂取));
        entity.setCk_hainyo(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.排尿));
        entity.setCk_haiben(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.排便));
        entity.setCk_kokoSeiketsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.口腔清潔));
        entity.setCk_sengan(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.洗顔));
        entity.setCk_seihatsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.整髪));
        entity.setCk_joiChakudatsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.上衣の着脱));
        entity.setCk_zubonChakudatsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.ズボン等の着脱));
        entity.setCk_gaishutsuHindo(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.外出頻度));
        entity.setCk_ishiDentatsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.意思の伝達));
        entity.setCk_nikka(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.毎日の日課を理解));
        entity.setCk_seinengappi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.生年月日をいう));
        entity.setCk_tankiKioku(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.短期記憶));
        entity.setCk_namae(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.自分の名前をいう));
        entity.setCk_kisetsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.今の季節を理解));
        entity.setCk_basho(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.場所の理解));
        entity.setCk_haikai(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.常時の徘徊));
        entity.setCk_gaishutsu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.外出して戻れない));
        entity.setCk_higaiteki(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.被害的));
        entity.setCk_sakuwa(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.作話));
        entity.setCk_kanjoHuantei(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.感情が不安定));
        entity.setCk_chuyaGyakuten(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.昼夜逆転));
        entity.setCk_onajiHanashi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.同じ話をする));
        entity.setCk_ogoe(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.大声を出す));
        entity.setCk_kaigoNiTeiko(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.介護に抵抗));
        entity.setCk_ochitsuki(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.落ち着きなし));
        entity.setCk_hitoriDeDetagaru(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.一人で出たがる));
        entity.setCk_shushuheki(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.収集癖));
        entity.setCk_monoYaIruiWoKowasu(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.物や衣類を壊す));
        entity.setCk_hidoiMonowasure(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.ひどい物忘れ));
        entity.setCk_hitorigotoHitoriwarai(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.独り言_独り笑));
        entity.setCk_jibunKatte(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.自分勝手に行動する));
        entity.setCk_hanashiGaMatomaranai(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.話がまとまらない));
        entity.setCk_kusuri(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.薬の内服));
        entity.setCk_kinsenKanri(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.金銭の管理));
        entity.setCk_ishiKettei(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.日常の意思決定));
        entity.setCk_shudanHutekio(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.集団への不適応));
        entity.setCk_kaimono(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.買い物));
        entity.setCk_chori(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.簡単な調理));
        entity.setCk_tenteki(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.点滴の管理));
        entity.setCk_chushinJomyakuEiyo(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.中心静脈栄養));
        entity.setCk_toseki(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.透析));
        entity.setCk_stomaShochi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.ストーマの処置));
        entity.setCk_sansoRyoho(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.酸素療法));
        entity.setCk_respirator(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.レスピレーター));
        entity.setCk_kikanSekkai(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.気管切開));
        entity.setCk_totsuKango(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.疼痛の看護));
        entity.setCk_keikanEiyo(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.経管栄養));
        entity.setCk_monitorSokutei(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.モニター測定));
        entity.setCk_jokusoShochi(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.じょくそうの処置));
        entity.setCk_catheter(rsltKihon.get調査結果ByStringValue(NinteichosaItemKubunOfKihon.カテーテル));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(rsltKihon.get調査結果ByCodeValue(NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(rsltKihon.get調査結果ByCodeValue(NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度));

        return entity;
    }

    private static NinteichosaResultOfGaikyo toNinteichosaResultGaikyo(NinteichosaKekkaEntity ninteichosaKekkaEntity, INinteiChosain chosain) {
        DbT5008NinteichosaKekkaJohoEntity entity = ninteichosaKekkaEntity.getDbT5008NinteichosaKekkaJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createサービス状況Instance(koroshoIFKubun);

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfGaikyo.class), getNinteichosaItemGroup(koroshoIFKubun));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.現在の状況コード, entity.getGenzainoJokyoCode().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.サービス区分コード, entity.getServiceKubunCode().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.訪問介護, entity.getHomonKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.訪問入浴介護, entity.getHomonNyuyokuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.訪問看護, entity.getHomonKango()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.訪問リハビリ, entity.getHomonRehabilitation()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.居宅療養管理指導, entity.getKyotakuRyoyoKanriShido()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.通所介護, entity.getTushoKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.通所リハビリテーション, entity.getTushoRehabilitation()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.短期入所生活介護, entity.getTankiNyushoSeikatsuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.短期入所療養介護, entity.getTankiNyushoRyoyoKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護, entity.getTokuteiShisetsuNyushoshaSeikatsuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.福祉用具貸与, entity.getHukushiYoguTaiyo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.特定福祉用具販売, entity.getTokuteiHukushiYoguHanbai()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.住宅改修, entity.getJutakuKaishu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護, entity.getYakanTaiogataHomonKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.認知症対応型通所介護, entity.getNinchishoTaiogataTushoKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護, entity.getShokiboTakinogataKyotakuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護, entity.getNinchishoTaiogataKyodoSeikatsuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護,
                entity.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護,
                entity.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.定期巡回_随時対応型訪問介護看護, entity.getTeikijunkaiZuijiTaiogataHomonKaigoKango()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.複合型サービス, entity.getHukugogataService()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.市町村特別給付, entity.getShichosonTokubetsuKyufu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.介護保険給付以外の在宅サービス, entity.getKaigohokenKyufuIgaiNoZaitakuService()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.利用施設コード, entity.getRiyoShisetsuCode().getColumnValue()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.利用施設名, entity.getRiyoShisetsuShimei()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.利用施設住所, entity.getRiyoShisetsuJusho().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.利用施設電話番号, entity.getRiyoShisetsuTelNo().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.利用施設郵便番号, entity.getRiyoShisetsuYubinNo().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfGaikyo.概況特記事項, entity.getGaikyochosaTokkijiko()));

        return new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo().value()),
                new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                koroshoIFKubun,
                new NinteichosaResultOfGaikyoKihon(
                NinteichosaIraiKubunCode.toValue(entity.getNinteichousaIraiKubunCode().value()),
                entity.getNinteichosaIraiKaisu(),
                entity.getNinteichosaJisshiYMD(),
                entity.getNinteichosaJuryoYMD(),
                NinteichosaKubun.toValue(entity.getNinteiChosaKubunCode().value()),
                chosain,
                new NinteichosaJisshibashoKubun(
                new NinteichosaJisshibashoKubunCode(entity.getChosaJisshiBashoCode()), entity.getChosaJisshiBashoMeisho(), RString.EMPTY)),
                result);
    }

    private static NinteichosaResultOfKihon toNinteichosaResultKihon(NinteichosaKekkaEntity ninteichosaKekkaEntity) {
        DbT5009NinteichosahyoJohoEntity entity = ninteichosaKekkaEntity.getDbT5009NinteichosahyoJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        Ninteichosahyo chosahyo = NinteichosahyoFactory.create基本情報Instance(koroshoIFKubun);

        Ninteichosahyo result = new Ninteichosahyo(new EnumMap<>(NinteichosaItemKubunOfKihon.class), getNinteichosaItemGroup(koroshoIFKubun));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢, entity.getCk_mahiHidariJoshi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, entity.getCk_mahiMigiJoshi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢, entity.getCk_mahiHidariKashi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢, entity.getCk_mahiMigiKashi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.麻痺等の有無_その他, entity.getCk_mahiSonota()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節, entity.getCk_koshukuKata()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節, entity.getCk_koshukuMata()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節, entity.getCk_koshukuHiza()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他, entity.getCk_koshukuSonota()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.寝返り, entity.getCk_negaeri()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.起き上がり, entity.getCk_okiagari()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.座位保持, entity.getCk_zaihoji()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.両足での立位, entity.getCk_ryoashiRitsui()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.歩行, entity.getCk_hoko()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.立ち上がり, entity.getCk_tachiagari()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.片足での立位, entity.getCk_kataashiRitsui()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.洗身, entity.getCk_senshin()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.つめ切り, entity.getCk_tumekiri()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.視力, entity.getCk_shiryoku()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.聴力, entity.getCk_choryoku()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.移乗, entity.getCk_ijo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.移動, entity.getCk_ido()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.嚥下, entity.getCk_enge()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.食事摂取, entity.getCk_shokujiSesshu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.排尿, entity.getCk_hainyo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.排便, entity.getCk_haiben()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.口腔清潔, entity.getCk_kokoSeiketsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.洗顔, entity.getCk_sengan()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.整髪, entity.getCk_seihatsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.上衣の着脱, entity.getCk_joiChakudatsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.ズボン等の着脱, entity.getCk_zubonChakudatsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.外出頻度, entity.getCk_gaishutsuHindo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.意思の伝達, entity.getCk_ishiDentatsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.毎日の日課を理解, entity.getCk_nikka()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.生年月日をいう, entity.getCk_seinengappi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.短期記憶, entity.getCk_tankiKioku()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.自分の名前をいう, entity.getCk_namae()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.今の季節を理解, entity.getCk_kisetsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.場所の理解, entity.getCk_basho()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.常時の徘徊, entity.getCk_haikai()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.外出して戻れない, entity.getCk_gaishutsu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.被害的, entity.getCk_higaiteki()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.作話, entity.getCk_sakuwa()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.感情が不安定, entity.getCk_kanjoHuantei()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.昼夜逆転, entity.getCk_chuyaGyakuten()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.同じ話をする, entity.getCk_onajiHanashi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.大声を出す, entity.getCk_ogoe()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.介護に抵抗, entity.getCk_kaigoNiTeiko()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.落ち着きなし, entity.getCk_ochitsuki()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.一人で出たがる, entity.getCk_hitoriDeDetagaru()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.収集癖, entity.getCk_shushuheki()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.物や衣類を壊す, entity.getCk_monoYaIruiWoKowasu()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.ひどい物忘れ, entity.getCk_hidoiMonowasure()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.独り言_独り笑, entity.getCk_hitorigotoHitoriwarai()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.自分勝手に行動する, entity.getCk_jibunKatte()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.話がまとまらない, entity.getCk_hanashiGaMatomaranai()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.薬の内服, entity.getCk_kusuri()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.金銭の管理, entity.getCk_kinsenKanri()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.日常の意思決定, entity.getCk_ishiKettei()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.集団への不適応, entity.getCk_shudanHutekio()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.買い物, entity.getCk_kaimono()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.簡単な調理, entity.getCk_chori()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.点滴の管理, entity.getCk_tenteki()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.中心静脈栄養, entity.getCk_chushinJomyakuEiyo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.透析, entity.getCk_toseki()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.ストーマの処置, entity.getCk_stomaShochi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.酸素療法, entity.getCk_sansoRyoho()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.レスピレーター, entity.getCk_respirator()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.気管切開, entity.getCk_kikanSekkai()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.疼痛の看護, entity.getCk_totsuKango()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.経管栄養, entity.getCk_keikanEiyo()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.モニター測定, entity.getCk_monitorSokutei()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.じょくそうの処置, entity.getCk_jokusoShochi()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.カテーテル, entity.getCk_catheter()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度, entity.getShogaiNichijoSeikatsuJiritsudoCode().value()));
        result.set調査項目(chosahyo.create調査結果(NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度, entity.getNinchishoNichijoSeikatsuJiritsudoCode().value()));

        return new NinteichosaResultOfKihon(entity.getShinseishoKanriNo(), new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                koroshoIFKubun, result);
    }

    private static INinteichosaItemGroup[] getNinteichosaItemGroup(KoroshoIFKubun koroshoIFKubun) {
        switch (koroshoIFKubun) {
            case V06A:
                return NinteichosaItemGroup.Of2006.values();
            case V09A:
                return NinteichosaItemGroup.Of2009.values();
            default:
                return null;
        }
    }
}
