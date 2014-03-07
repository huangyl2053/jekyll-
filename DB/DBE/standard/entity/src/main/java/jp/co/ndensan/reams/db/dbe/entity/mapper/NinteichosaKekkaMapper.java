/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfItem;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.NinteichosaItemKubun;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査の調査結果情報を変換するMapperクラスです。
 *
 * @author N8156 宮本 康
 */
public final class NinteichosaKekkaMapper {

    // TODO N8156 宮本 康 テーブルから取得する
    private static final int NENDO_2009 = 2009;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private NinteichosaKekkaMapper() {
    }

    /**
     * 引数のエンティティ情報から認定調査結果情報を作成して返します。
     *
     * @param chosaKekkaEntity 認定調査結果情報エンティティ
     * @param chosahyoEntity 認定調査票情報エンティティ
     * @return 認定調査結果情報
     */
    public static NinteichosaResult toNinteichosaResult(
            DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity, DbT5009NinteichosahyoJohoEntity chosahyoEntity) {
        return chosaKekkaEntity != null && chosahyoEntity != null
                ? new NinteichosaResult(
                toNinteichosaResultGaikyo(chosaKekkaEntity), toNinteichosaResultKihon(chosaKekkaEntity, chosahyoEntity)) : null;
    }

    /**
     * 引数の認定調査結果情報から認定調査結果情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査結果情報エンティティ
     */
    public static DbT5008NinteichosaKekkaJohoEntity toDbT5008NinteichosaKekkaJohoEntity(NinteichosaResult ninteichosaKekka) {

        NinteichosaResultOfGaikyoKihon rsltKihon = ninteichosaKekka.get概況調査結果().get基本情報();
        Ninteichosahyo<NinteichosaResultOfItem> rsltGaikyoService = ninteichosaKekka.get概況調査結果().getサービス状況();
        Ninteichosahyo<NinteichosaResultOfItem> rsltGaikyoKihon = ninteichosaKekka.get基本調査結果().get基本情報();

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get概況調査結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get概況調査結果().get認定調査依頼履歴番号().value().intValue());
        entity.setNinteichousaIraiKubunCode(rsltKihon.get認定調査依頼区分().getCode());
        entity.setNinteichosaJisshiYMD(rsltKihon.get認定調査実施年月日());
        entity.setNinteiChosaKubunCode(rsltKihon.get認定調査区分().getCode());
        entity.setChosaJisshiBashoCode(rsltKihon.get認定調査実施場所コード());
        entity.setChosaJisshiBashoMeisho(rsltKihon.get認定調査実施場所名称());
        entity.setGenzainoJokyoCode(getString(rsltGaikyoService, NinteichosaItemKubun.現在の状況コード));
        entity.setServiceKubunCode(getString(rsltGaikyoService, NinteichosaItemKubun.サービス区分コード));
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
        entity.setRiyoShisetsuCode(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設コード));
        entity.setRiyoShisetsuShimei(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設名));
        entity.setRiyoShisetsuJusho(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設住所));
        entity.setRiyoShisetsuTelNo(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設電話番号));
        entity.setRiyoShisetsuYubinNo(getString(rsltGaikyoService, NinteichosaItemKubun.利用施設郵便番号));
        entity.setGaikyochosaTokkijiko(getString(rsltGaikyoService, NinteichosaItemKubun.概況特記事項));
        entity.setShinsakaiYusenWaritsukeKubunCode(rsltKihon.get審査会優先振分区分().getCode());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(getString(rsltGaikyoKihon, NinteichosaItemKubun.障害高齢者の日常生活自立度));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(getString(rsltGaikyoKihon, NinteichosaItemKubun.認知症高齢者の日常生活自立度));

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査票情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査票情報エンティティ
     */
    public static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        Ninteichosahyo<NinteichosaResultOfItem> rsltKihon = ninteichosaKekka.get基本調査結果().get基本情報();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get基本調査結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get基本調査結果().get認定調査依頼履歴番号().value().intValue());
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

        return entity;
    }

    private static NinteichosaResultOfGaikyo toNinteichosaResultGaikyo(DbT5008NinteichosaKekkaJohoEntity entity) {
        Map<NinteichosaItemKubun, NinteichosaResultOfItem> map = new EnumMap<>(NinteichosaItemKubun.class);
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createサービス状況Instance(NENDO_2009);
        setMap(map, chosahyo, NinteichosaItemKubun.現在の状況コード, entity.getGenzainoJokyoCode());
        setMap(map, chosahyo, NinteichosaItemKubun.サービス区分コード, entity.getServiceKubunCode());
        setMap(map, chosahyo, NinteichosaItemKubun.訪問介護, entity.getHomonKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.訪問入浴介護, entity.getHomonNyuyokuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.訪問看護, entity.getHomonKango());
        setMap(map, chosahyo, NinteichosaItemKubun.訪問リハビリ, entity.getHomonRehabilitation());
        setMap(map, chosahyo, NinteichosaItemKubun.居宅療養管理指導, entity.getKyotakuRyoyoKanriShido());
        setMap(map, chosahyo, NinteichosaItemKubun.通所介護, entity.getTushoKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.通所リハビリテーション, entity.getTushoRehabilitation());
        setMap(map, chosahyo, NinteichosaItemKubun.短期入所生活介護, entity.getTankiNyushoSeikatsuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.短期入所療養介護, entity.getTankiNyushoRyoyoKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.特定施設入居者生活介護, entity.getTokuteiShisetsuNyushoshaSeikatsuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.福祉用具貸与, entity.getHukushiYoguTaiyo());
        setMap(map, chosahyo, NinteichosaItemKubun.特定福祉用具販売, entity.getTokuteiHukushiYoguHanbai());
        setMap(map, chosahyo, NinteichosaItemKubun.住宅改修, entity.getJutakuKaishu());
        setMap(map, chosahyo, NinteichosaItemKubun.夜間対応型訪問介護, entity.getYakanTaiogataHomonKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.認知症対応型通所介護, entity.getNinchishoTaiogataTushoKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.小規模多機能型居宅介護, entity.getShokiboTakinogataKyotakuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.認知症対応型共同生活介護, entity.getNinchishoTaiogataKyodoSeikatsuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.地域密着型特定施設入居者生活介護, entity.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.地域密着型介護老人福祉施設入所者生活介護, entity.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo());
        setMap(map, chosahyo, NinteichosaItemKubun.定期巡回_随時対応型訪問介護看護, entity.getTeikijunkaiZuijiTaiogataHomonKaigoKango());
        setMap(map, chosahyo, NinteichosaItemKubun.複合型サービス, entity.getHukugogataService());
        setMap(map, chosahyo, NinteichosaItemKubun.市町村特別給付, entity.getShichosonTokubetsuKyufu());
        setMap(map, chosahyo, NinteichosaItemKubun.介護保険給付以外の在宅サービス, entity.getKaigohokenKyufuIgaiNoZaitakuService());
        setMap(map, chosahyo, NinteichosaItemKubun.利用施設コード, entity.getRiyoShisetsuCode());
        setMap(map, chosahyo, NinteichosaItemKubun.利用施設名, entity.getRiyoShisetsuShimei());
        setMap(map, chosahyo, NinteichosaItemKubun.利用施設住所, entity.getRiyoShisetsuJusho());
        setMap(map, chosahyo, NinteichosaItemKubun.利用施設電話番号, entity.getRiyoShisetsuTelNo());
        setMap(map, chosahyo, NinteichosaItemKubun.利用施設郵便番号, entity.getRiyoShisetsuYubinNo());
        setMap(map, chosahyo, NinteichosaItemKubun.概況特記事項, entity.getGaikyochosaTokkijiko());
        return new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                NENDO_2009,
                new NinteichosaResultOfGaikyoKihon(
                entity.getNinteichosaJisshiYMD(),
                ChosaIraiKubun.toValue(entity.getNinteichousaIraiKubunCode()),
                entity.getChosaJisshiBashoCode(),
                entity.getChosaJisshiBashoMeisho(),
                ChosaKubun.toValue(entity.getNinteiChosaKubunCode()),
                ShinsakaiFuriwakeKubun.toValue(entity.getShinsakaiYusenWaritsukeKubunCode())),
                new Ninteichosahyo(map, NinteichosaItemGroup.Of2009.values()));
    }

    private static NinteichosaResultOfKihon toNinteichosaResultKihon(
            DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity, DbT5009NinteichosahyoJohoEntity chosahyoEntity) {
        Map<NinteichosaItemKubun, NinteichosaResultOfItem> map = new EnumMap<>(NinteichosaItemKubun.class);
        Ninteichosahyo chosahyo = NinteichosahyoFactory.create基本情報Instance(NENDO_2009);
        setMap(map, chosahyo, NinteichosaItemKubun.麻痺等の有無_左上肢, chosahyoEntity.getCk_mahiHidariJoshi());
        setMap(map, chosahyo, NinteichosaItemKubun.麻痺等の有無_右上肢, chosahyoEntity.getCk_mahiMigiJoshi());
        setMap(map, chosahyo, NinteichosaItemKubun.麻痺等の有無_左下肢, chosahyoEntity.getCk_mahiHidariKashi());
        setMap(map, chosahyo, NinteichosaItemKubun.麻痺等の有無_右下肢, chosahyoEntity.getCk_mahiMigiKashi());
        setMap(map, chosahyo, NinteichosaItemKubun.麻痺等の有無_その他, chosahyoEntity.getCk_mahiSonota());
        setMap(map, chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_肩関節, chosahyoEntity.getCk_koshukuKata());
        setMap(map, chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_股関節, chosahyoEntity.getCk_koshukuMata());
        setMap(map, chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_膝関節, chosahyoEntity.getCk_koshukuHiza());
        setMap(map, chosahyo, NinteichosaItemKubun.関節の動く範囲の制限_その他, chosahyoEntity.getCk_koshukuSonota());
        setMap(map, chosahyo, NinteichosaItemKubun.寝返り, chosahyoEntity.getCk_negaeri());
        setMap(map, chosahyo, NinteichosaItemKubun.起き上がり, chosahyoEntity.getCk_okiagari());
        setMap(map, chosahyo, NinteichosaItemKubun.座位保持, chosahyoEntity.getCk_zaihoji());
        setMap(map, chosahyo, NinteichosaItemKubun.両足での立位, chosahyoEntity.getCk_ryoashiRitsui());
        setMap(map, chosahyo, NinteichosaItemKubun.歩行, chosahyoEntity.getCk_hoko());
        setMap(map, chosahyo, NinteichosaItemKubun.立ち上がり, chosahyoEntity.getCk_tachiagari());
        setMap(map, chosahyo, NinteichosaItemKubun.片足での立位, chosahyoEntity.getCk_kataashiRitsui());
        setMap(map, chosahyo, NinteichosaItemKubun.洗身, chosahyoEntity.getCk_senshin());
        setMap(map, chosahyo, NinteichosaItemKubun.つめ切り, chosahyoEntity.getCk_tumekiri());
        setMap(map, chosahyo, NinteichosaItemKubun.視力, chosahyoEntity.getCk_shiryoku());
        setMap(map, chosahyo, NinteichosaItemKubun.聴力, chosahyoEntity.getCk_choryoku());
        setMap(map, chosahyo, NinteichosaItemKubun.移乗, chosahyoEntity.getCk_ijo());
        setMap(map, chosahyo, NinteichosaItemKubun.移動, chosahyoEntity.getCk_ido());
        setMap(map, chosahyo, NinteichosaItemKubun.嚥下, chosahyoEntity.getCk_enge());
        setMap(map, chosahyo, NinteichosaItemKubun.食事摂取, chosahyoEntity.getCk_shokujiSesshu());
        setMap(map, chosahyo, NinteichosaItemKubun.排尿, chosahyoEntity.getCk_hainyo());
        setMap(map, chosahyo, NinteichosaItemKubun.排便, chosahyoEntity.getCk_haiben());
        setMap(map, chosahyo, NinteichosaItemKubun.口腔清潔, chosahyoEntity.getCk_kokoSeiketsu());
        setMap(map, chosahyo, NinteichosaItemKubun.洗顔, chosahyoEntity.getCk_sengan());
        setMap(map, chosahyo, NinteichosaItemKubun.整髪, chosahyoEntity.getCk_seihatsu());
        setMap(map, chosahyo, NinteichosaItemKubun.上衣の着脱, chosahyoEntity.getCk_joiChakudatsu());
        setMap(map, chosahyo, NinteichosaItemKubun.ズボン等の着脱, chosahyoEntity.getCk_zubonChakudatsu());
        setMap(map, chosahyo, NinteichosaItemKubun.外出頻度, chosahyoEntity.getCk_gaishutsuHindo());
        setMap(map, chosahyo, NinteichosaItemKubun.意思の伝達, chosahyoEntity.getCk_ishiDentatsu());
        setMap(map, chosahyo, NinteichosaItemKubun.毎日の日課を理解, chosahyoEntity.getCk_nikka());
        setMap(map, chosahyo, NinteichosaItemKubun.生年月日をいう, chosahyoEntity.getCk_seinengappi());
        setMap(map, chosahyo, NinteichosaItemKubun.短期記憶, chosahyoEntity.getCk_tankiKioku());
        setMap(map, chosahyo, NinteichosaItemKubun.自分の名前をいう, chosahyoEntity.getCk_namae());
        setMap(map, chosahyo, NinteichosaItemKubun.今の季節を理解, chosahyoEntity.getCk_kisetsu());
        setMap(map, chosahyo, NinteichosaItemKubun.場所の理解, chosahyoEntity.getCk_basho());
        setMap(map, chosahyo, NinteichosaItemKubun.常時の徘徊, chosahyoEntity.getCk_haikai());
        setMap(map, chosahyo, NinteichosaItemKubun.外出して戻れない, chosahyoEntity.getCk_gaishutsu());
        setMap(map, chosahyo, NinteichosaItemKubun.被害的, chosahyoEntity.getCk_higaiteki());
        setMap(map, chosahyo, NinteichosaItemKubun.作話, chosahyoEntity.getCk_sakuwa());
        setMap(map, chosahyo, NinteichosaItemKubun.感情が不安定, chosahyoEntity.getCk_kanjoHuantei());
        setMap(map, chosahyo, NinteichosaItemKubun.昼夜逆転, chosahyoEntity.getCk_chuyaGyakuten());
        setMap(map, chosahyo, NinteichosaItemKubun.同じ話をする, chosahyoEntity.getCk_onajiHanashi());
        setMap(map, chosahyo, NinteichosaItemKubun.大声を出す, chosahyoEntity.getCk_ogoe());
        setMap(map, chosahyo, NinteichosaItemKubun.介護に抵抗, chosahyoEntity.getCk_kaigoNiTeiko());
        setMap(map, chosahyo, NinteichosaItemKubun.落ち着きなし, chosahyoEntity.getCk_ochitsuki());
        setMap(map, chosahyo, NinteichosaItemKubun.一人で出たがる, chosahyoEntity.getCk_hitoriDeDetagaru());
        setMap(map, chosahyo, NinteichosaItemKubun.収集癖, chosahyoEntity.getCk_shushuheki());
        setMap(map, chosahyo, NinteichosaItemKubun.物や衣類を壊す, chosahyoEntity.getCk_monoYaIruiWoKowasu());
        setMap(map, chosahyo, NinteichosaItemKubun.ひどい物忘れ, chosahyoEntity.getCk_hidoiMonowasure());
        setMap(map, chosahyo, NinteichosaItemKubun.独り言_独り笑, chosahyoEntity.getCk_hitorigotoHitoriwarai());
        setMap(map, chosahyo, NinteichosaItemKubun.自分勝手に行動する, chosahyoEntity.getCk_jibunKatte());
        setMap(map, chosahyo, NinteichosaItemKubun.話がまとまらない, chosahyoEntity.getCk_hanashiGaMatomaranai());
        setMap(map, chosahyo, NinteichosaItemKubun.薬の内服, chosahyoEntity.getCk_kusuri());
        setMap(map, chosahyo, NinteichosaItemKubun.金銭の管理, chosahyoEntity.getCk_kinsenKanri());
        setMap(map, chosahyo, NinteichosaItemKubun.日常の意思決定, chosahyoEntity.getCk_ishiKettei());
        setMap(map, chosahyo, NinteichosaItemKubun.集団への不適応, chosahyoEntity.getCk_shudanHutekio());
        setMap(map, chosahyo, NinteichosaItemKubun.買い物, chosahyoEntity.getCk_kaimono());
        setMap(map, chosahyo, NinteichosaItemKubun.簡単な調理, chosahyoEntity.getCk_chori());
        setMap(map, chosahyo, NinteichosaItemKubun.点滴の管理, chosahyoEntity.getCk_tenteki());
        setMap(map, chosahyo, NinteichosaItemKubun.中心静脈栄養, chosahyoEntity.getCk_chushinJomyakuEiyo());
        setMap(map, chosahyo, NinteichosaItemKubun.透析, chosahyoEntity.getCk_toseki());
        setMap(map, chosahyo, NinteichosaItemKubun.ストーマの処置, chosahyoEntity.getCk_stomaShochi());
        setMap(map, chosahyo, NinteichosaItemKubun.酸素療法, chosahyoEntity.getCk_sansoRyoho());
        setMap(map, chosahyo, NinteichosaItemKubun.レスピレーター, chosahyoEntity.getCk_respirator());
        setMap(map, chosahyo, NinteichosaItemKubun.気管切開, chosahyoEntity.getCk_kikanSekkai());
        setMap(map, chosahyo, NinteichosaItemKubun.疼痛の看護, chosahyoEntity.getCk_totsuKango());
        setMap(map, chosahyo, NinteichosaItemKubun.経管栄養, chosahyoEntity.getCk_keikanEiyo());
        setMap(map, chosahyo, NinteichosaItemKubun.モニター測定, chosahyoEntity.getCk_monitorSokutei());
        setMap(map, chosahyo, NinteichosaItemKubun.じょくそうの処置, chosahyoEntity.getCk_jokusoShochi());
        setMap(map, chosahyo, NinteichosaItemKubun.カテーテル, chosahyoEntity.getCk_catheter());
        setMap(map, chosahyo, NinteichosaItemKubun.障害高齢者の日常生活自立度, chosaKekkaEntity.getShogaiNichijoSeikatsuJiritsudoCode());
        setMap(map, chosahyo, NinteichosaItemKubun.認知症高齢者の日常生活自立度, chosaKekkaEntity.getNinchishoNichijoSeikatsuJiritsudoCode());
        return new NinteichosaResultOfKihon(
                new ShinseishoKanriNo(chosahyoEntity.getShinseishoKanriNo()), new NinteichosaIraiRirekiNo(chosahyoEntity.getNinteichosaRirekiNo()),
                NENDO_2009, new Ninteichosahyo(map, NinteichosaItemGroup.Of2009.values()));
    }

    private static RString getString(Ninteichosahyo<NinteichosaResultOfItem> chosahyo, NinteichosaItemKubun key) {
        NinteichosaResultOfItem rslt = chosahyo.get調査項目(key);
        return rslt == null ? null : rslt.get調査結果();
    }

    private static int getInt(Ninteichosahyo<NinteichosaResultOfItem> chosahyo, NinteichosaItemKubun key) {
        NinteichosaResultOfItem rslt = chosahyo.get調査項目(key);
        return rslt == null ? 0 : Integer.parseInt(rslt.get調査結果().toString());
    }

    private static void setMap(Map<NinteichosaItemKubun, NinteichosaResultOfItem> map, Ninteichosahyo 調査票,
            NinteichosaItemKubun 調査項目区分, RString 調査結果) {
        NinteichosaItem item = (NinteichosaItem) 調査票.get調査項目(調査項目区分);
        if (item != null) {
            map.put(調査項目区分, new NinteichosaResultOfItem(item, 調査結果));
        }
    }

    private static void setMap(Map<NinteichosaItemKubun, NinteichosaResultOfItem> map, Ninteichosahyo 調査票,
            NinteichosaItemKubun 調査項目区分, int 調査結果) {
        setMap(map, 調査票, 調査項目区分, new RString(String.valueOf(調査結果)));
    }
}
