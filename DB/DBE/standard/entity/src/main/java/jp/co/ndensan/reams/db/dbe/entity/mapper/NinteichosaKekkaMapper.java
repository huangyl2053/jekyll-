/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.core.chosahyo.NinteichosahyoEditor;
import jp.co.ndensan.reams.db.dbe.business.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaJisshibashoKubun;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinteichosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfGaikyo;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.core.chosahyo.NinteichosaItemKubunOfKihon;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaJisshibashoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.NinteichosaKekkaEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
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
        NinteichosahyoEditor editor = new NinteichosahyoEditor(ninteichosaKekka.get概況調査結果().get認定調査票());

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get概況調査結果().get申請書管理番号());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get概況調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setKoroshoIfShikibetsuCode(ninteichosaKekka.get概況調査結果().get厚労省IF識別区分().getCode());
        entity.setNinteichosaIraiKubunCode(new Code(rsltKihon.get認定調査依頼区分().getCode()));
        entity.setNinteichosaIraiKaisu(rsltKihon.get認定調査回数());
        entity.setNinteichosaJisshiYMD(rsltKihon.get認定調査実施年月日());
        entity.setNinteichosaJuryoYMD(rsltKihon.get認定調査受領年月日());
        entity.setNinteiChosaKubunCode(new Code(rsltKihon.get認定調査区分().getCode()));
        entity.setChosainCode(rsltKihon.get認定調査員().get介護調査員番号());
        entity.setChosaJisshiBashoCode(new Code(rsltKihon.get認定調査実施場所区分().getCode().value()));
        entity.setChosaJisshiBashoMeisho(rsltKihon.get認定調査実施場所区分().getMeisho());
        entity.setGenzainoJokyoCode(editor.getResultByCode(NinteichosaItemKubunOfGaikyo.現在の状況コード));
        entity.setServiceKubunCode(editor.getResultByCode(NinteichosaItemKubunOfGaikyo.サービス区分コード));
        entity.setHomonKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.訪問介護));
        entity.setHomonNyuyokuKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.訪問入浴介護));
        entity.setHomonKango(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.訪問看護));
        entity.setHomonRehabilitation(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.訪問リハビリ));
        entity.setKyotakuRyoyoKanriShido(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.居宅療養管理指導));
        entity.setTushoKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.通所介護));
        entity.setTushoRehabilitation(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.通所リハビリテーション));
        entity.setTankiNyushoSeikatsuKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.短期入所生活介護));
        entity.setTankiNyushoRyoyoKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.短期入所療養介護));
        entity.setTokuteiShisetsuNyushoshaSeikatsuKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護));
        entity.setHukushiYoguTaiyo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.福祉用具貸与));
        entity.setTokuteiHukushiYoguHanbai(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.特定福祉用具販売));
        entity.setJutakuKaishu(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.住宅改修));
        entity.setYakanTaiogataHomonKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護));
        entity.setNinchishoTaiogataTushoKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.認知症対応型通所介護));
        entity.setShokiboTakinogataKyotakuKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護));
        entity.setNinchishoTaiogataKyodoSeikatsuKaigo(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護));
        entity.setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(
                editor.getResultByInt(NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護));
        entity.setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(
                editor.getResultByInt(NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護));
        entity.setTeikijunkaiZuijiTaiogataHomonKaigoKango(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.定期巡回_随時対応型訪問介護看護));
        entity.setHukugogataService(editor.getResultByInt(NinteichosaItemKubunOfGaikyo.複合型サービス));
        entity.setShichosonTokubetsuKyufu(editor.getResultByString(NinteichosaItemKubunOfGaikyo.市町村特別給付));
        entity.setKaigohokenKyufuIgaiNoZaitakuService(editor.getResultByString(NinteichosaItemKubunOfGaikyo.介護保険給付以外の在宅サービス));
        entity.setRiyoShisetsuCode(new JigyoshaNo(editor.getResultByString(NinteichosaItemKubunOfGaikyo.利用施設コード)));
        entity.setRiyoShisetsuShimei(editor.getResultByString(NinteichosaItemKubunOfGaikyo.利用施設名));
        entity.setRiyoShisetsuJusho(new AtenaJusho(editor.getResultByString(NinteichosaItemKubunOfGaikyo.利用施設住所)));
        entity.setRiyoShisetsuTelNo(new TelNo(editor.getResultByString(NinteichosaItemKubunOfGaikyo.利用施設電話番号)));
        entity.setRiyoShisetsuYubinNo(new YubinNo(editor.getResultByString(NinteichosaItemKubunOfGaikyo.利用施設郵便番号)));
        entity.setGaikyochosaTokkijiko(editor.getResultByString(NinteichosaItemKubunOfGaikyo.概況特記事項));
        entity.setShogaiNichijoSeikatsuJiritsudoCode(editor.getResultByCode(NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(editor.getResultByCode(NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度));

        return entity;
    }

    private static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        NinteichosahyoEditor editor = new NinteichosahyoEditor(ninteichosaKekka.get基本調査結果().get認定調査票());

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get基本調査結果().get申請書管理番号());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get基本調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setKoroshoIfShikibetsuCode(ninteichosaKekka.get基本調査結果().get厚労省IF識別区分().getCode());
        entity.setCk_mahiHidariJoshi(editor.getResultByString(NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢));
        entity.setCk_mahiMigiJoshi(editor.getResultByString(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢));
        entity.setCk_mahiHidariKashi(editor.getResultByString(NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢));
        entity.setCk_mahiMigiKashi(editor.getResultByString(NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢));
        entity.setCk_mahiSonota(editor.getResultByString(NinteichosaItemKubunOfKihon.麻痺等の有無_その他));
        entity.setCk_koshukuKata(editor.getResultByString(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節));
        entity.setCk_koshukuMata(editor.getResultByString(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節));
        entity.setCk_koshukuHiza(editor.getResultByString(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節));
        entity.setCk_koshukuSonota(editor.getResultByString(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他));
        entity.setCk_negaeri(editor.getResultByString(NinteichosaItemKubunOfKihon.寝返り));
        entity.setCk_okiagari(editor.getResultByString(NinteichosaItemKubunOfKihon.起き上がり));
        entity.setCk_zaihoji(editor.getResultByString(NinteichosaItemKubunOfKihon.座位保持));
        entity.setCk_ryoashiRitsui(editor.getResultByString(NinteichosaItemKubunOfKihon.両足での立位));
        entity.setCk_hoko(editor.getResultByString(NinteichosaItemKubunOfKihon.歩行));
        entity.setCk_tachiagari(editor.getResultByString(NinteichosaItemKubunOfKihon.立ち上がり));
        entity.setCk_kataashiRitsui(editor.getResultByString(NinteichosaItemKubunOfKihon.片足での立位));
        entity.setCk_senshin(editor.getResultByString(NinteichosaItemKubunOfKihon.洗身));
        entity.setCk_tumekiri(editor.getResultByString(NinteichosaItemKubunOfKihon.つめ切り));
        entity.setCk_shiryoku(editor.getResultByString(NinteichosaItemKubunOfKihon.視力));
        entity.setCk_choryoku(editor.getResultByString(NinteichosaItemKubunOfKihon.聴力));
        entity.setCk_ijo(editor.getResultByString(NinteichosaItemKubunOfKihon.移乗));
        entity.setCk_ido(editor.getResultByString(NinteichosaItemKubunOfKihon.移動));
        entity.setCk_enge(editor.getResultByString(NinteichosaItemKubunOfKihon.嚥下));
        entity.setCk_shokujiSesshu(editor.getResultByString(NinteichosaItemKubunOfKihon.食事摂取));
        entity.setCk_hainyo(editor.getResultByString(NinteichosaItemKubunOfKihon.排尿));
        entity.setCk_haiben(editor.getResultByString(NinteichosaItemKubunOfKihon.排便));
        entity.setCk_kokoSeiketsu(editor.getResultByString(NinteichosaItemKubunOfKihon.口腔清潔));
        entity.setCk_sengan(editor.getResultByString(NinteichosaItemKubunOfKihon.洗顔));
        entity.setCk_seihatsu(editor.getResultByString(NinteichosaItemKubunOfKihon.整髪));
        entity.setCk_joiChakudatsu(editor.getResultByString(NinteichosaItemKubunOfKihon.上衣の着脱));
        entity.setCk_zubonChakudatsu(editor.getResultByString(NinteichosaItemKubunOfKihon.ズボン等の着脱));
        entity.setCk_gaishutsuHindo(editor.getResultByString(NinteichosaItemKubunOfKihon.外出頻度));
        entity.setCk_ishiDentatsu(editor.getResultByString(NinteichosaItemKubunOfKihon.意思の伝達));
        entity.setCk_nikka(editor.getResultByString(NinteichosaItemKubunOfKihon.毎日の日課を理解));
        entity.setCk_seinengappi(editor.getResultByString(NinteichosaItemKubunOfKihon.生年月日をいう));
        entity.setCk_tankiKioku(editor.getResultByString(NinteichosaItemKubunOfKihon.短期記憶));
        entity.setCk_namae(editor.getResultByString(NinteichosaItemKubunOfKihon.自分の名前をいう));
        entity.setCk_kisetsu(editor.getResultByString(NinteichosaItemKubunOfKihon.今の季節を理解));
        entity.setCk_basho(editor.getResultByString(NinteichosaItemKubunOfKihon.場所の理解));
        entity.setCk_haikai(editor.getResultByString(NinteichosaItemKubunOfKihon.常時の徘徊));
        entity.setCk_gaishutsu(editor.getResultByString(NinteichosaItemKubunOfKihon.外出して戻れない));
        entity.setCk_higaiteki(editor.getResultByString(NinteichosaItemKubunOfKihon.被害的));
        entity.setCk_sakuwa(editor.getResultByString(NinteichosaItemKubunOfKihon.作話));
        entity.setCk_kanjoHuantei(editor.getResultByString(NinteichosaItemKubunOfKihon.感情が不安定));
        entity.setCk_chuyaGyakuten(editor.getResultByString(NinteichosaItemKubunOfKihon.昼夜逆転));
        entity.setCk_onajiHanashi(editor.getResultByString(NinteichosaItemKubunOfKihon.同じ話をする));
        entity.setCk_ogoe(editor.getResultByString(NinteichosaItemKubunOfKihon.大声を出す));
        entity.setCk_kaigoNiTeiko(editor.getResultByString(NinteichosaItemKubunOfKihon.介護に抵抗));
        entity.setCk_ochitsuki(editor.getResultByString(NinteichosaItemKubunOfKihon.落ち着きなし));
        entity.setCk_hitoriDeDetagaru(editor.getResultByString(NinteichosaItemKubunOfKihon.一人で出たがる));
        entity.setCk_shushuheki(editor.getResultByString(NinteichosaItemKubunOfKihon.収集癖));
        entity.setCk_monoYaIruiWoKowasu(editor.getResultByString(NinteichosaItemKubunOfKihon.物や衣類を壊す));
        entity.setCk_hidoiMonowasure(editor.getResultByString(NinteichosaItemKubunOfKihon.ひどい物忘れ));
        entity.setCk_hitorigotoHitoriwarai(editor.getResultByString(NinteichosaItemKubunOfKihon.独り言_独り笑));
        entity.setCk_jibunKatte(editor.getResultByString(NinteichosaItemKubunOfKihon.自分勝手に行動する));
        entity.setCk_hanashiGaMatomaranai(editor.getResultByString(NinteichosaItemKubunOfKihon.話がまとまらない));
        entity.setCk_kusuri(editor.getResultByString(NinteichosaItemKubunOfKihon.薬の内服));
        entity.setCk_kinsenKanri(editor.getResultByString(NinteichosaItemKubunOfKihon.金銭の管理));
        entity.setCk_ishiKettei(editor.getResultByString(NinteichosaItemKubunOfKihon.日常の意思決定));
        entity.setCk_shudanHutekio(editor.getResultByString(NinteichosaItemKubunOfKihon.集団への不適応));
        entity.setCk_kaimono(editor.getResultByString(NinteichosaItemKubunOfKihon.買い物));
        entity.setCk_chori(editor.getResultByString(NinteichosaItemKubunOfKihon.簡単な調理));
        entity.setCk_tenteki(editor.getResultByString(NinteichosaItemKubunOfKihon.点滴の管理));
        entity.setCk_chushinJomyakuEiyo(editor.getResultByString(NinteichosaItemKubunOfKihon.中心静脈栄養));
        entity.setCk_toseki(editor.getResultByString(NinteichosaItemKubunOfKihon.透析));
        entity.setCk_stomaShochi(editor.getResultByString(NinteichosaItemKubunOfKihon.ストーマの処置));
        entity.setCk_sansoRyoho(editor.getResultByString(NinteichosaItemKubunOfKihon.酸素療法));
        entity.setCk_respirator(editor.getResultByString(NinteichosaItemKubunOfKihon.レスピレーター));
        entity.setCk_kikanSekkai(editor.getResultByString(NinteichosaItemKubunOfKihon.気管切開));
        entity.setCk_totsuKango(editor.getResultByString(NinteichosaItemKubunOfKihon.疼痛の看護));
        entity.setCk_keikanEiyo(editor.getResultByString(NinteichosaItemKubunOfKihon.経管栄養));
        entity.setCk_monitorSokutei(editor.getResultByString(NinteichosaItemKubunOfKihon.モニター測定));
        entity.setCk_jokusoShochi(editor.getResultByString(NinteichosaItemKubunOfKihon.じょくそうの処置));
        entity.setCk_catheter(editor.getResultByString(NinteichosaItemKubunOfKihon.カテーテル));

        return entity;
    }

    private static NinteichosaResultOfGaikyo toNinteichosaResultGaikyo(NinteichosaKekkaEntity ninteichosaKekkaEntity, INinteiChosain chosain) {

        DbT5008NinteichosaKekkaJohoEntity entity = ninteichosaKekkaEntity.getDbT5008NinteichosaKekkaJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        NinteichosahyoEditor editor = new NinteichosahyoEditor(NinteichosahyoFactory.createサービス状況Instance(koroshoIFKubun));

        editor.setResult(NinteichosaItemKubunOfGaikyo.現在の状況コード, entity.getGenzainoJokyoCode().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.現在の状況コード, entity.getGenzainoJokyoCode().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.サービス区分コード, entity.getServiceKubunCode().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.訪問介護, entity.getHomonKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.訪問入浴介護, entity.getHomonNyuyokuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.訪問看護, entity.getHomonKango());
        editor.setResult(NinteichosaItemKubunOfGaikyo.訪問リハビリ, entity.getHomonRehabilitation());
        editor.setResult(NinteichosaItemKubunOfGaikyo.居宅療養管理指導, entity.getKyotakuRyoyoKanriShido());
        editor.setResult(NinteichosaItemKubunOfGaikyo.通所介護, entity.getTushoKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.通所リハビリテーション, entity.getTushoRehabilitation());
        editor.setResult(NinteichosaItemKubunOfGaikyo.短期入所生活介護, entity.getTankiNyushoSeikatsuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.短期入所療養介護, entity.getTankiNyushoRyoyoKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.特定施設入居者生活介護, entity.getTokuteiShisetsuNyushoshaSeikatsuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.福祉用具貸与, entity.getHukushiYoguTaiyo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.特定福祉用具販売, entity.getTokuteiHukushiYoguHanbai());
        editor.setResult(NinteichosaItemKubunOfGaikyo.住宅改修, entity.getJutakuKaishu());
        editor.setResult(NinteichosaItemKubunOfGaikyo.夜間対応型訪問介護, entity.getYakanTaiogataHomonKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.認知症対応型通所介護, entity.getNinchishoTaiogataTushoKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.小規模多機能型居宅介護, entity.getShokiboTakinogataKyotakuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.認知症対応型共同生活介護, entity.getNinchishoTaiogataKyodoSeikatsuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.地域密着型特定施設入居者生活介護,
                entity.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.地域密着型介護老人福祉施設入所者生活介護,
                entity.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo());
        editor.setResult(NinteichosaItemKubunOfGaikyo.定期巡回_随時対応型訪問介護看護, entity.getTeikijunkaiZuijiTaiogataHomonKaigoKango());
        editor.setResult(NinteichosaItemKubunOfGaikyo.複合型サービス, entity.getHukugogataService());
        editor.setResult(NinteichosaItemKubunOfGaikyo.市町村特別給付, entity.getShichosonTokubetsuKyufu());
        editor.setResult(NinteichosaItemKubunOfGaikyo.介護保険給付以外の在宅サービス, entity.getKaigohokenKyufuIgaiNoZaitakuService());
        editor.setResult(NinteichosaItemKubunOfGaikyo.利用施設コード, entity.getRiyoShisetsuCode().getColumnValue());
        editor.setResult(NinteichosaItemKubunOfGaikyo.利用施設名, entity.getRiyoShisetsuShimei());
        editor.setResult(NinteichosaItemKubunOfGaikyo.利用施設住所, entity.getRiyoShisetsuJusho().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.利用施設電話番号, entity.getRiyoShisetsuTelNo().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.利用施設郵便番号, entity.getRiyoShisetsuYubinNo().value());
        editor.setResult(NinteichosaItemKubunOfGaikyo.概況特記事項, entity.getGaikyochosaTokkijiko());
        editor.setResult(NinteichosaItemKubunOfKihon.障害高齢者の日常生活自立度, entity.getShogaiNichijoSeikatsuJiritsudoCode().value());
        editor.setResult(NinteichosaItemKubunOfKihon.認知症高齢者の日常生活自立度, entity.getNinchishoNichijoSeikatsuJiritsudoCode().value());

        return new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo().value()),
                new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                koroshoIFKubun,
                new NinteichosaResultOfGaikyoKihon(
                NinteichosaIraiKubun.toValue(entity.getNinteichosaIraiKubunCode().value()),
                entity.getNinteichosaIraiKaisu(),
                entity.getNinteichosaJisshiYMD(),
                entity.getNinteichosaJuryoYMD(),
                NinteichosaKubun.toValue(entity.getNinteiChosaKubunCode().value()),
                chosain,
                new NinteichosaJisshibashoKubun(
                new NinteichosaJisshibashoKubunCode(entity.getChosaJisshiBashoCode()).asCode(), entity.getChosaJisshiBashoMeisho(), RString.EMPTY)),
                editor.getNinteichosahyo());
    }

    private static NinteichosaResultOfKihon toNinteichosaResultKihon(NinteichosaKekkaEntity ninteichosaKekkaEntity) {

        DbT5009NinteichosahyoJohoEntity entity = ninteichosaKekkaEntity.getDbT5009NinteichosahyoJohoEntity();
        KoroshoIFKubun koroshoIFKubun = KoroshoIFKubun.toValue(entity.getKoroshoIfShikibetsuCode());
        NinteichosahyoEditor editor = new NinteichosahyoEditor(NinteichosahyoFactory.create基本情報Instance(koroshoIFKubun));

        editor.setResult(NinteichosaItemKubunOfKihon.麻痺等の有無_左上肢, entity.getCk_mahiHidariJoshi());
        editor.setResult(NinteichosaItemKubunOfKihon.麻痺等の有無_右上肢, entity.getCk_mahiMigiJoshi());
        editor.setResult(NinteichosaItemKubunOfKihon.麻痺等の有無_左下肢, entity.getCk_mahiHidariKashi());
        editor.setResult(NinteichosaItemKubunOfKihon.麻痺等の有無_右下肢, entity.getCk_mahiMigiKashi());
        editor.setResult(NinteichosaItemKubunOfKihon.麻痺等の有無_その他, entity.getCk_mahiSonota());
        editor.setResult(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_肩関節, entity.getCk_koshukuKata());
        editor.setResult(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_股関節, entity.getCk_koshukuMata());
        editor.setResult(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_膝関節, entity.getCk_koshukuHiza());
        editor.setResult(NinteichosaItemKubunOfKihon.関節の動く範囲の制限_その他, entity.getCk_koshukuSonota());
        editor.setResult(NinteichosaItemKubunOfKihon.寝返り, entity.getCk_negaeri());
        editor.setResult(NinteichosaItemKubunOfKihon.起き上がり, entity.getCk_okiagari());
        editor.setResult(NinteichosaItemKubunOfKihon.座位保持, entity.getCk_zaihoji());
        editor.setResult(NinteichosaItemKubunOfKihon.両足での立位, entity.getCk_ryoashiRitsui());
        editor.setResult(NinteichosaItemKubunOfKihon.歩行, entity.getCk_hoko());
        editor.setResult(NinteichosaItemKubunOfKihon.立ち上がり, entity.getCk_tachiagari());
        editor.setResult(NinteichosaItemKubunOfKihon.片足での立位, entity.getCk_kataashiRitsui());
        editor.setResult(NinteichosaItemKubunOfKihon.洗身, entity.getCk_senshin());
        editor.setResult(NinteichosaItemKubunOfKihon.つめ切り, entity.getCk_tumekiri());
        editor.setResult(NinteichosaItemKubunOfKihon.視力, entity.getCk_shiryoku());
        editor.setResult(NinteichosaItemKubunOfKihon.聴力, entity.getCk_choryoku());
        editor.setResult(NinteichosaItemKubunOfKihon.移乗, entity.getCk_ijo());
        editor.setResult(NinteichosaItemKubunOfKihon.移動, entity.getCk_ido());
        editor.setResult(NinteichosaItemKubunOfKihon.嚥下, entity.getCk_enge());
        editor.setResult(NinteichosaItemKubunOfKihon.食事摂取, entity.getCk_shokujiSesshu());
        editor.setResult(NinteichosaItemKubunOfKihon.排尿, entity.getCk_hainyo());
        editor.setResult(NinteichosaItemKubunOfKihon.排便, entity.getCk_haiben());
        editor.setResult(NinteichosaItemKubunOfKihon.口腔清潔, entity.getCk_kokoSeiketsu());
        editor.setResult(NinteichosaItemKubunOfKihon.洗顔, entity.getCk_sengan());
        editor.setResult(NinteichosaItemKubunOfKihon.整髪, entity.getCk_seihatsu());
        editor.setResult(NinteichosaItemKubunOfKihon.上衣の着脱, entity.getCk_joiChakudatsu());
        editor.setResult(NinteichosaItemKubunOfKihon.ズボン等の着脱, entity.getCk_zubonChakudatsu());
        editor.setResult(NinteichosaItemKubunOfKihon.外出頻度, entity.getCk_gaishutsuHindo());
        editor.setResult(NinteichosaItemKubunOfKihon.意思の伝達, entity.getCk_ishiDentatsu());
        editor.setResult(NinteichosaItemKubunOfKihon.毎日の日課を理解, entity.getCk_nikka());
        editor.setResult(NinteichosaItemKubunOfKihon.生年月日をいう, entity.getCk_seinengappi());
        editor.setResult(NinteichosaItemKubunOfKihon.短期記憶, entity.getCk_tankiKioku());
        editor.setResult(NinteichosaItemKubunOfKihon.自分の名前をいう, entity.getCk_namae());
        editor.setResult(NinteichosaItemKubunOfKihon.今の季節を理解, entity.getCk_kisetsu());
        editor.setResult(NinteichosaItemKubunOfKihon.場所の理解, entity.getCk_basho());
        editor.setResult(NinteichosaItemKubunOfKihon.常時の徘徊, entity.getCk_haikai());
        editor.setResult(NinteichosaItemKubunOfKihon.外出して戻れない, entity.getCk_gaishutsu());
        editor.setResult(NinteichosaItemKubunOfKihon.被害的, entity.getCk_higaiteki());
        editor.setResult(NinteichosaItemKubunOfKihon.作話, entity.getCk_sakuwa());
        editor.setResult(NinteichosaItemKubunOfKihon.感情が不安定, entity.getCk_kanjoHuantei());
        editor.setResult(NinteichosaItemKubunOfKihon.昼夜逆転, entity.getCk_chuyaGyakuten());
        editor.setResult(NinteichosaItemKubunOfKihon.同じ話をする, entity.getCk_onajiHanashi());
        editor.setResult(NinteichosaItemKubunOfKihon.大声を出す, entity.getCk_ogoe());
        editor.setResult(NinteichosaItemKubunOfKihon.介護に抵抗, entity.getCk_kaigoNiTeiko());
        editor.setResult(NinteichosaItemKubunOfKihon.落ち着きなし, entity.getCk_ochitsuki());
        editor.setResult(NinteichosaItemKubunOfKihon.一人で出たがる, entity.getCk_hitoriDeDetagaru());
        editor.setResult(NinteichosaItemKubunOfKihon.収集癖, entity.getCk_shushuheki());
        editor.setResult(NinteichosaItemKubunOfKihon.物や衣類を壊す, entity.getCk_monoYaIruiWoKowasu());
        editor.setResult(NinteichosaItemKubunOfKihon.ひどい物忘れ, entity.getCk_hidoiMonowasure());
        editor.setResult(NinteichosaItemKubunOfKihon.独り言_独り笑, entity.getCk_hitorigotoHitoriwarai());
        editor.setResult(NinteichosaItemKubunOfKihon.自分勝手に行動する, entity.getCk_jibunKatte());
        editor.setResult(NinteichosaItemKubunOfKihon.話がまとまらない, entity.getCk_hanashiGaMatomaranai());
        editor.setResult(NinteichosaItemKubunOfKihon.薬の内服, entity.getCk_kusuri());
        editor.setResult(NinteichosaItemKubunOfKihon.金銭の管理, entity.getCk_kinsenKanri());
        editor.setResult(NinteichosaItemKubunOfKihon.日常の意思決定, entity.getCk_ishiKettei());
        editor.setResult(NinteichosaItemKubunOfKihon.集団への不適応, entity.getCk_shudanHutekio());
        editor.setResult(NinteichosaItemKubunOfKihon.買い物, entity.getCk_kaimono());
        editor.setResult(NinteichosaItemKubunOfKihon.簡単な調理, entity.getCk_chori());
        editor.setResult(NinteichosaItemKubunOfKihon.点滴の管理, entity.getCk_tenteki());
        editor.setResult(NinteichosaItemKubunOfKihon.中心静脈栄養, entity.getCk_chushinJomyakuEiyo());
        editor.setResult(NinteichosaItemKubunOfKihon.透析, entity.getCk_toseki());
        editor.setResult(NinteichosaItemKubunOfKihon.ストーマの処置, entity.getCk_stomaShochi());
        editor.setResult(NinteichosaItemKubunOfKihon.酸素療法, entity.getCk_sansoRyoho());
        editor.setResult(NinteichosaItemKubunOfKihon.レスピレーター, entity.getCk_respirator());
        editor.setResult(NinteichosaItemKubunOfKihon.気管切開, entity.getCk_kikanSekkai());
        editor.setResult(NinteichosaItemKubunOfKihon.疼痛の看護, entity.getCk_totsuKango());
        editor.setResult(NinteichosaItemKubunOfKihon.経管栄養, entity.getCk_keikanEiyo());
        editor.setResult(NinteichosaItemKubunOfKihon.モニター測定, entity.getCk_monitorSokutei());
        editor.setResult(NinteichosaItemKubunOfKihon.じょくそうの処置, entity.getCk_jokusoShochi());
        editor.setResult(NinteichosaItemKubunOfKihon.カテーテル, entity.getCk_catheter());

        return new NinteichosaResultOfKihon(entity.getShinseishoKanriNo(), new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                koroshoIFKubun, editor.getNinteichosahyo());
    }
}
