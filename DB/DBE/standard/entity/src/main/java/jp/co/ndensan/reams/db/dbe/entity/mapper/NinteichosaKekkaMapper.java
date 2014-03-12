/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
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
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.INinteichosaItem;
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
        Ninteichosahyo<NinteichosaItemForResult> rsltGaikyoService = ninteichosaKekka.get概況調査結果().getサービス状況();

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
        entity.setGenzainoJokyoCode(getCode(rsltGaikyoService, NinteichosaItemKubun.現在の状況コード));
        entity.setServiceKubunCode(getCode(rsltGaikyoService, NinteichosaItemKubun.サービス区分コード));
        entity.setHomonKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.訪問介護));
        entity.setHomonNyuyokuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.訪問入浴介護));
        entity.setHomonKango(getInt(rsltGaikyoService, NinteichosaItemKubun.訪問看護));
        entity.setHomonRehabilitation(getInt(rsltGaikyoService, NinteichosaItemKubun.訪問リハビリ));
        entity.setKyotakuRyoyoKanriShido(getInt(rsltGaikyoService, NinteichosaItemKubun.居宅療養管理指導));
        entity.setTushoKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.通所介護));
        entity.setTushoRehabilitation(getInt(rsltGaikyoService, NinteichosaItemKubun.通所リハビリテーション));
        entity.setTankiNyushoSeikatsuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.短期入所生活介護));
        entity.setTankiNyushoRyoyoKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.短期入所療養介護));
        entity.setTokuteiShisetsuNyushoshaSeikatsuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.特定施設入居者生活介護));
        entity.setHukushiYoguTaiyo(getInt(rsltGaikyoService, NinteichosaItemKubun.福祉用具貸与));
        entity.setTokuteiHukushiYoguHanbai(getInt(rsltGaikyoService, NinteichosaItemKubun.特定福祉用具販売));
        entity.setJutakuKaishu(getInt(rsltGaikyoService, NinteichosaItemKubun.住宅改修));
        entity.setYakanTaiogataHomonKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.夜間対応型訪問介護));
        entity.setNinchishoTaiogataTushoKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.認知症対応型通所介護));
        entity.setShokiboTakinogataKyotakuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.小規模多機能型居宅介護));
        entity.setNinchishoTaiogataKyodoSeikatsuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.認知症対応型共同生活介護));
        entity.setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.地域密着型特定施設入居者生活介護));
        entity.setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(getInt(rsltGaikyoService, NinteichosaItemKubun.地域密着型介護老人福祉施設入所者生活介護));
        entity.setTeikijunkaiZuijiTaiogataHomonKaigoKango(getInt(rsltGaikyoService, NinteichosaItemKubun.定期巡回_随時対応型訪問介護看護));
        entity.setHukugogataService(getInt(rsltGaikyoService, NinteichosaItemKubun.複合型サービス));
        entity.setShichosonTokubetsuKyufu(getString(rsltGaikyoService, NinteichosaItemKubun.市町村特別給付));
        entity.setKaigohokenKyufuIgaiNoZaitakuService(getString(rsltGaikyoService, NinteichosaItemKubun.介護保険給付以外の在宅サービス));
        entity.setRiyoShisetsuCode(new JigyoshaNo(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設コード)));
        entity.setRiyoShisetsuShimei(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設名));
        entity.setRiyoShisetsuJusho(new AtenaJusho(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設住所)));
        entity.setRiyoShisetsuTelNo(new TelNo(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設電話番号)));
        entity.setRiyoShisetsuYubinNo(new YubinNo(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設郵便番号)));
        entity.setGaikyochosaTokkijiko(getString(rsltGaikyoService, NinteichosaItemKubun.概況特記事項));

        return entity;
    }

    private static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        Ninteichosahyo<NinteichosaItemForResult> rsltKihon = ninteichosaKekka.get基本調査結果().get基本情報();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get基本調査結果().get申請書管理番号());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get基本調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setKoroshoIfShikibetsuCode(ninteichosaKekka.get基本調査結果().get厚労省IF識別区分().getCode());
        entity.setCk_mahiHidariJoshi(getString(rsltKihon, NinteichosaItemKubun.麻痺等の有無_左上肢));
        entity.setCk_mahiMigiJoshi(getString(rsltKihon, NinteichosaItemKubun.麻痺等の有無_右上肢));
        entity.setCk_mahiHidariKashi(getString(rsltKihon, NinteichosaItemKubun.麻痺等の有無_左下肢));
        entity.setCk_mahiMigiKashi(getString(rsltKihon, NinteichosaItemKubun.麻痺等の有無_右下肢));
        entity.setCk_mahiSonota(getString(rsltKihon, NinteichosaItemKubun.麻痺等の有無_その他));
        entity.setCk_koshukuKata(getString(rsltKihon, NinteichosaItemKubun.関節の動く範囲の制限_肩関節));
        entity.setCk_koshukuMata(getString(rsltKihon, NinteichosaItemKubun.関節の動く範囲の制限_股関節));
        entity.setCk_koshukuHiza(getString(rsltKihon, NinteichosaItemKubun.関節の動く範囲の制限_膝関節));
        entity.setCk_koshukuSonota(getString(rsltKihon, NinteichosaItemKubun.関節の動く範囲の制限_その他));
        entity.setCk_negaeri(getString(rsltKihon, NinteichosaItemKubun.寝返り));
        entity.setCk_okiagari(getString(rsltKihon, NinteichosaItemKubun.起き上がり));
        entity.setCk_zaihoji(getString(rsltKihon, NinteichosaItemKubun.座位保持));
        entity.setCk_ryoashiRitsui(getString(rsltKihon, NinteichosaItemKubun.両足での立位));
        entity.setCk_hoko(getString(rsltKihon, NinteichosaItemKubun.歩行));
        entity.setCk_tachiagari(getString(rsltKihon, NinteichosaItemKubun.立ち上がり));
        entity.setCk_kataashiRitsui(getString(rsltKihon, NinteichosaItemKubun.片足での立位));
        entity.setCk_senshin(getString(rsltKihon, NinteichosaItemKubun.洗身));
        entity.setCk_tumekiri(getString(rsltKihon, NinteichosaItemKubun.つめ切り));
        entity.setCk_shiryoku(getString(rsltKihon, NinteichosaItemKubun.視力));
        entity.setCk_choryoku(getString(rsltKihon, NinteichosaItemKubun.聴力));
        entity.setCk_ijo(getString(rsltKihon, NinteichosaItemKubun.移乗));
        entity.setCk_ido(getString(rsltKihon, NinteichosaItemKubun.移動));
        entity.setCk_enge(getString(rsltKihon, NinteichosaItemKubun.嚥下));
        entity.setCk_shokujiSesshu(getString(rsltKihon, NinteichosaItemKubun.食事摂取));
        entity.setCk_hainyo(getString(rsltKihon, NinteichosaItemKubun.排尿));
        entity.setCk_haiben(getString(rsltKihon, NinteichosaItemKubun.排便));
        entity.setCk_kokoSeiketsu(getString(rsltKihon, NinteichosaItemKubun.口腔清潔));
        entity.setCk_sengan(getString(rsltKihon, NinteichosaItemKubun.洗顔));
        entity.setCk_seihatsu(getString(rsltKihon, NinteichosaItemKubun.整髪));
        entity.setCk_joiChakudatsu(getString(rsltKihon, NinteichosaItemKubun.上衣の着脱));
        entity.setCk_zubonChakudatsu(getString(rsltKihon, NinteichosaItemKubun.ズボン等の着脱));
        entity.setCk_gaishutsuHindo(getString(rsltKihon, NinteichosaItemKubun.外出頻度));
        entity.setCk_ishiDentatsu(getString(rsltKihon, NinteichosaItemKubun.意思の伝達));
        entity.setCk_nikka(getString(rsltKihon, NinteichosaItemKubun.毎日の日課を理解));
        entity.setCk_seinengappi(getString(rsltKihon, NinteichosaItemKubun.生年月日をいう));
        entity.setCk_tankiKioku(getString(rsltKihon, NinteichosaItemKubun.短期記憶));
        entity.setCk_namae(getString(rsltKihon, NinteichosaItemKubun.自分の名前をいう));
        entity.setCk_kisetsu(getString(rsltKihon, NinteichosaItemKubun.今の季節を理解));
        entity.setCk_basho(getString(rsltKihon, NinteichosaItemKubun.場所の理解));
        entity.setCk_haikai(getString(rsltKihon, NinteichosaItemKubun.常時の徘徊));
        entity.setCk_gaishutsu(getString(rsltKihon, NinteichosaItemKubun.外出して戻れない));
        entity.setCk_higaiteki(getString(rsltKihon, NinteichosaItemKubun.被害的));
        entity.setCk_sakuwa(getString(rsltKihon, NinteichosaItemKubun.作話));
        entity.setCk_kanjoHuantei(getString(rsltKihon, NinteichosaItemKubun.感情が不安定));
        entity.setCk_chuyaGyakuten(getString(rsltKihon, NinteichosaItemKubun.昼夜逆転));
        entity.setCk_onajiHanashi(getString(rsltKihon, NinteichosaItemKubun.同じ話をする));
        entity.setCk_ogoe(getString(rsltKihon, NinteichosaItemKubun.大声を出す));
        entity.setCk_kaigoNiTeiko(getString(rsltKihon, NinteichosaItemKubun.介護に抵抗));
        entity.setCk_ochitsuki(getString(rsltKihon, NinteichosaItemKubun.落ち着きなし));
        entity.setCk_hitoriDeDetagaru(getString(rsltKihon, NinteichosaItemKubun.一人で出たがる));
        entity.setCk_shushuheki(getString(rsltKihon, NinteichosaItemKubun.収集癖));
        entity.setCk_monoYaIruiWoKowasu(getString(rsltKihon, NinteichosaItemKubun.物や衣類を壊す));
        entity.setCk_hidoiMonowasure(getString(rsltKihon, NinteichosaItemKubun.ひどい物忘れ));
        entity.setCk_hitorigotoHitoriwarai(getString(rsltKihon, NinteichosaItemKubun.独り言_独り笑));
        entity.setCk_jibunKatte(getString(rsltKihon, NinteichosaItemKubun.自分勝手に行動する));
        entity.setCk_hanashiGaMatomaranai(getString(rsltKihon, NinteichosaItemKubun.話がまとまらない));
        entity.setCk_kusuri(getString(rsltKihon, NinteichosaItemKubun.薬の内服));
        entity.setCk_kinsenKanri(getString(rsltKihon, NinteichosaItemKubun.金銭の管理));
        entity.setCk_ishiKettei(getString(rsltKihon, NinteichosaItemKubun.日常の意思決定));
        entity.setCk_shudanHutekio(getString(rsltKihon, NinteichosaItemKubun.集団への不適応));
        entity.setCk_kaimono(getString(rsltKihon, NinteichosaItemKubun.買い物));
        entity.setCk_chori(getString(rsltKihon, NinteichosaItemKubun.簡単な調理));
        entity.setCk_tenteki(getString(rsltKihon, NinteichosaItemKubun.点滴の管理));
        entity.setCk_chushinJomyakuEiyo(getString(rsltKihon, NinteichosaItemKubun.中心静脈栄養));
        entity.setCk_toseki(getString(rsltKihon, NinteichosaItemKubun.透析));
        entity.setCk_stomaShochi(getString(rsltKihon, NinteichosaItemKubun.ストーマの処置));
        entity.setCk_sansoRyoho(getString(rsltKihon, NinteichosaItemKubun.酸素療法));
        entity.setCk_respirator(getString(rsltKihon, NinteichosaItemKubun.レスピレーター));
        entity.setCk_kikanSekkai(getString(rsltKihon, NinteichosaItemKubun.気管切開));
        entity.setCk_totsuKango(getString(rsltKihon, NinteichosaItemKubun.疼痛の看護));
        entity.setCk_keikanEiyo(getString(rsltKihon, NinteichosaItemKubun.経管栄養));
        entity.setCk_monitorSokutei(getString(rsltKihon, NinteichosaItemKubun.モニター測定));
        entity.setCk_jokusoShochi(getString(rsltKihon, NinteichosaItemKubun.じょくそうの処置));
        entity.setCk_catheter(getString(rsltKihon, NinteichosaItemKubun.カテーテル));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(getCode(rsltKihon, NinteichosaItemKubun.障害高齢者の日常生活自立度));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(getCode(rsltKihon, NinteichosaItemKubun.認知症高齢者の日常生活自立度));

        return entity;
    }

    private static NinteichosaResultOfGaikyo toNinteichosaResultGaikyo(NinteichosaKekkaEntity ninteichosaKekkaEntity, INinteiChosain chosain) {
        DbT5008NinteichosaKekkaJohoEntity entity = ninteichosaKekkaEntity.getDbT5008NinteichosaKekkaJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createサービス状況Instance(koroshoIFKubun);

        List<NinteichosaItemForResult> list = new ArrayList<>();
        list.add(createResult(chosahyo, NinteichosaItemKubun.現在の状況コード, entity.getGenzainoJokyoCode().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.サービス区分コード, entity.getServiceKubunCode().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問介護, entity.getHomonKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問入浴介護, entity.getHomonNyuyokuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問看護, entity.getHomonKango()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.訪問リハビリ, entity.getHomonRehabilitation()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.居宅療養管理指導, entity.getKyotakuRyoyoKanriShido()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.通所介護, entity.getTushoKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.通所リハビリテーション, entity.getTushoRehabilitation()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.短期入所生活介護, entity.getTankiNyushoSeikatsuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.短期入所療養介護, entity.getTankiNyushoRyoyoKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.特定施設入居者生活介護, entity.getTokuteiShisetsuNyushoshaSeikatsuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.福祉用具貸与, entity.getHukushiYoguTaiyo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.特定福祉用具販売, entity.getTokuteiHukushiYoguHanbai()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.住宅改修, entity.getJutakuKaishu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.夜間対応型訪問介護, entity.getYakanTaiogataHomonKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.認知症対応型通所介護, entity.getNinchishoTaiogataTushoKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.小規模多機能型居宅介護, entity.getShokiboTakinogataKyotakuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.認知症対応型共同生活介護, entity.getNinchishoTaiogataKyodoSeikatsuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.地域密着型特定施設入居者生活介護,
                entity.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.地域密着型介護老人福祉施設入所者生活介護,
                entity.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.定期巡回_随時対応型訪問介護看護, entity.getTeikijunkaiZuijiTaiogataHomonKaigoKango()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.複合型サービス, entity.getHukugogataService()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.市町村特別給付, entity.getShichosonTokubetsuKyufu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.介護保険給付以外の在宅サービス, entity.getKaigohokenKyufuIgaiNoZaitakuService()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設コード, entity.getRiyoShisetsuCode().getColumnValue()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設名, entity.getRiyoShisetsuShimei()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設住所, entity.getRiyoShisetsuJusho().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設電話番号, entity.getRiyoShisetsuTelNo().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.利用施設郵便番号, entity.getRiyoShisetsuYubinNo().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.概況特記事項, entity.getGaikyochosaTokkijiko()));

        Map<NinteichosaItemKubun, NinteichosaItemForResult> map = new EnumMap<>(NinteichosaItemKubun.class);
        for (NinteichosaItemForResult data : list) {
            if (data != null) {
                map.put(data.get調査項目区分(), data);
            }
        }

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
                new Ninteichosahyo(map, getNinteichosaItemGroup(koroshoIFKubun)));
    }

    private static NinteichosaResultOfKihon toNinteichosaResultKihon(NinteichosaKekkaEntity ninteichosaKekkaEntity) {
        DbT5009NinteichosahyoJohoEntity entity = ninteichosaKekkaEntity.getDbT5009NinteichosahyoJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        Ninteichosahyo chosahyo = NinteichosahyoFactory.create基本情報Instance(koroshoIFKubun);

        List<NinteichosaItemForResult> list = new ArrayList<>();
        list.add(createResult(chosahyo, NinteichosaItemKubun.麻痺等の有無_左上肢, entity.getCk_mahiHidariJoshi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.麻痺等の有無_右上肢, entity.getCk_mahiMigiJoshi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.麻痺等の有無_左下肢, entity.getCk_mahiHidariKashi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.麻痺等の有無_右下肢, entity.getCk_mahiMigiKashi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.麻痺等の有無_その他, entity.getCk_mahiSonota()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_肩関節, entity.getCk_koshukuKata()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_股関節, entity.getCk_koshukuMata()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_膝関節, entity.getCk_koshukuHiza()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_その他, entity.getCk_koshukuSonota()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.寝返り, entity.getCk_negaeri()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.起き上がり, entity.getCk_okiagari()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.座位保持, entity.getCk_zaihoji()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.両足での立位, entity.getCk_ryoashiRitsui()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.歩行, entity.getCk_hoko()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.立ち上がり, entity.getCk_tachiagari()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.片足での立位, entity.getCk_kataashiRitsui()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.洗身, entity.getCk_senshin()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.つめ切り, entity.getCk_tumekiri()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.視力, entity.getCk_shiryoku()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.聴力, entity.getCk_choryoku()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.移乗, entity.getCk_ijo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.移動, entity.getCk_ido()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.嚥下, entity.getCk_enge()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.食事摂取, entity.getCk_shokujiSesshu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.排尿, entity.getCk_hainyo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.排便, entity.getCk_haiben()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.口腔清潔, entity.getCk_kokoSeiketsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.洗顔, entity.getCk_sengan()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.整髪, entity.getCk_seihatsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.上衣の着脱, entity.getCk_joiChakudatsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.ズボン等の着脱, entity.getCk_zubonChakudatsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.外出頻度, entity.getCk_gaishutsuHindo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.意思の伝達, entity.getCk_ishiDentatsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.毎日の日課を理解, entity.getCk_nikka()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.生年月日をいう, entity.getCk_seinengappi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.短期記憶, entity.getCk_tankiKioku()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.自分の名前をいう, entity.getCk_namae()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.今の季節を理解, entity.getCk_kisetsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.場所の理解, entity.getCk_basho()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.常時の徘徊, entity.getCk_haikai()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.外出して戻れない, entity.getCk_gaishutsu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.被害的, entity.getCk_higaiteki()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.作話, entity.getCk_sakuwa()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.感情が不安定, entity.getCk_kanjoHuantei()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.昼夜逆転, entity.getCk_chuyaGyakuten()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.同じ話をする, entity.getCk_onajiHanashi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.大声を出す, entity.getCk_ogoe()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.介護に抵抗, entity.getCk_kaigoNiTeiko()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.落ち着きなし, entity.getCk_ochitsuki()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.一人で出たがる, entity.getCk_hitoriDeDetagaru()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.収集癖, entity.getCk_shushuheki()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.物や衣類を壊す, entity.getCk_monoYaIruiWoKowasu()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.ひどい物忘れ, entity.getCk_hidoiMonowasure()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.独り言_独り笑, entity.getCk_hitorigotoHitoriwarai()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.自分勝手に行動する, entity.getCk_jibunKatte()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.話がまとまらない, entity.getCk_hanashiGaMatomaranai()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.薬の内服, entity.getCk_kusuri()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.金銭の管理, entity.getCk_kinsenKanri()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.日常の意思決定, entity.getCk_ishiKettei()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.集団への不適応, entity.getCk_shudanHutekio()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.買い物, entity.getCk_kaimono()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.簡単な調理, entity.getCk_chori()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.点滴の管理, entity.getCk_tenteki()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.中心静脈栄養, entity.getCk_chushinJomyakuEiyo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.透析, entity.getCk_toseki()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.ストーマの処置, entity.getCk_stomaShochi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.酸素療法, entity.getCk_sansoRyoho()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.レスピレーター, entity.getCk_respirator()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.気管切開, entity.getCk_kikanSekkai()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.疼痛の看護, entity.getCk_totsuKango()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.経管栄養, entity.getCk_keikanEiyo()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.モニター測定, entity.getCk_monitorSokutei()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.じょくそうの処置, entity.getCk_jokusoShochi()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.カテーテル, entity.getCk_catheter()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.障害高齢者の日常生活自立度, entity.getShogaiNichijoSeikatsuJiritsudoCode().value()));
        list.add(createResult(chosahyo, NinteichosaItemKubun.認知症高齢者の日常生活自立度, entity.getNinchishoNichijoSeikatsuJiritsudoCode().value()));

        Map<NinteichosaItemKubun, NinteichosaItemForResult> map = new EnumMap<>(NinteichosaItemKubun.class);
        for (NinteichosaItemForResult data : list) {
            if (data != null) {
                map.put(data.get調査項目区分(), data);
            }
        }

        return new NinteichosaResultOfKihon(
                entity.getShinseishoKanriNo(), new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                koroshoIFKubun, new Ninteichosahyo(map, getNinteichosaItemGroup(koroshoIFKubun)));
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

    private static RString getString(Ninteichosahyo<NinteichosaItemForResult> chosahyo, NinteichosaItemKubun key) {
        NinteichosaItemForResult rslt = chosahyo.get調査項目(key);
        return rslt == null ? null : rslt.get調査結果();
    }

    private static int getInt(Ninteichosahyo<NinteichosaItemForResult> chosahyo, NinteichosaItemKubun key) {
        NinteichosaItemForResult rslt = chosahyo.get調査項目(key);
        return rslt == null ? 0 : Integer.parseInt(rslt.get調査結果().toString());
    }

    private static Code getCode(Ninteichosahyo<NinteichosaItemForResult> chosahyo, NinteichosaItemKubun key) {
        NinteichosaItemForResult rslt = chosahyo.get調査項目(key);
        return rslt == null ? null : new Code(rslt.get調査結果());
    }

    private static NinteichosaItemForResult createResult(Ninteichosahyo 調査票, NinteichosaItemKubun 調査項目区分, RString 調査結果) {
        INinteichosaItem item = 調査票.get調査項目(調査項目区分);
        return item == null ? null : new NinteichosaItemForResult(item, 調査結果);
    }

    private static NinteichosaItemForResult createResult(Ninteichosahyo 調査票, NinteichosaItemKubun 調査項目区分, int 調査結果) {
        return createResult(調査票, 調査項目区分, new RString(String.valueOf(調査結果)));
    }
}
