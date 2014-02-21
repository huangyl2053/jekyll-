/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosaKomoku;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定調査結果の情報を変換するMapperクラスです。
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
     * 引数のエンティティ情報から認定調査結果情報を作成して返します。
     *
     * @param chosaKekkaEntity 認定調査結果情報エンティティ
     * @param chosahyoEntity 認定調査票情報エンティティ
     * @param tokkijikoEntity 認定調査特記情報エンティティ
     * @return 認定調査結果情報
     */
    public static NinteichosaKekka toNinteichosaKekka(DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity,
            DbT5009NinteichosahyoJohoEntity chosahyoEntity, DbT5010NinteiChosaTokkijikoEntity tokkijikoEntity) {
        return chosaKekkaEntity != null && chosahyoEntity != null && tokkijikoEntity != null
                ? new NinteichosaKekka(
                new ShinseishoKanriNo(chosaKekkaEntity.getShinseishoKanriNo()), chosaKekkaEntity.getNinteichosaRirekiNo(),
                toChosaKekkaGaikyo(chosaKekkaEntity), toChosaKekkaKihon(chosaKekkaEntity, chosahyoEntity)) : null;
    }

    /**
     * 引数の認定調査結果情報から認定調査結果情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査結果情報エンティティ
     */
    public static DbT5008NinteichosaKekkaJohoEntity toDbT5008NinteichosaKekkaJohoEntity(NinteichosaKekka ninteichosaKekka) {

        ChosaKekkaGaikyoKihon kihon = ninteichosaKekka.get概況情報().get基本情報();
        ChosaKekkaGaikyoService service = ninteichosaKekka.get概況情報().getサービス状況();
        Map<ChosaKomoku, RString> map = ninteichosaKekka.get基本情報();

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get申請書管理番号().getValue());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get要介護認定調査履歴番号());
        entity.setNinteichousaIraiKubunCode(kihon.get認定調査依頼区分().getCode());
        entity.setNinteichosaJisshiYMD(kihon.get認定調査実施年月日());
        entity.setNinteiChosaKubunCode(kihon.get認定調査区分().getCode());
        entity.setChosaJisshiBashoCode(kihon.get認定調査実施場所コード());
        entity.setChosaJisshiBashoMeisho(kihon.get認定調査実施場所名称());
        entity.setGenzainoJokyoCode(service.get現在の状況().getCode());
        entity.setServiceKubunCode(service.getサービス区分().getCode());
        entity.setHomonKaigo(service.get訪問介護());
        entity.setHomonNyuyokuKaigo(service.get訪問入浴介護());
        entity.setHomonKango(service.get訪問看護());
        entity.setHomonRehabilitation(service.get訪問リハビリ());
        entity.setKyotakuRyoyoKanriShido(service.get居宅療養管理指導());
        entity.setTushoKaigo(service.get通所介護());
        entity.setTushoRehabilitation(service.get通所リハビリテーション());
        entity.setTankiNyushoSeikatsuKaigo(service.get短期入所生活介護());
        entity.setTankiNyushoRyoyoKaigo(service.get短期入所療養介護());
        entity.setTokuteiShisetsuNyushoshaSeikatsuKaigo(service.get特定施設入居者生活介護());
        entity.setHukushiYoguTaiyo(service.get福祉用具貸与());
        entity.setTokuteiHukushiYoguHanbai(service.get特定福祉用具販売());
        entity.setJutakuKaishu(service.get住宅改修());
        entity.setYakanTaiogataHomonKaigo(service.get夜間対応型訪問介護());
        entity.setNinchishoTaiogataTushoKaigo(service.get認知症対応型通所介護());
        entity.setShokiboTakinogataKyotakuKaigo(service.get小規模多機能型居宅介護());
        entity.setNinchishoTaiogataKyodoSeikatsuKaigo(service.get認知症対応型共同生活介護());
        entity.setChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(service.get地域密着型特定施設入居者生活介護());
        entity.setChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(service.get地域密着型介護老人福祉施設入所者生活介護());
        entity.setTeikijunkaiZuijiTaiogataHomonKaigoKango(service.get定期巡回随時対応型訪問介護看護());
        entity.setHukugogataService(service.get複合型サービス());
        entity.setShichosonTokubetsuKyufu(service.get市町村特別給付());
        entity.setKaigohokenKyufuIgaiNoZaitakuService(service.get介護保険給付以外の在宅サービス());
        entity.setGaikyochosaTokkijiko(kihon.get概況特記事項());
        entity.setShinsakaiYusenWaritsukeKubunCode(kihon.get審査会優先振分区分().getCode());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(map.get(ChosaKomoku.障害高齢者の日常生活自立度));
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(map.get(ChosaKomoku.認知症高齢者の日常生活自立度));

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査票情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査票情報エンティティ
     */
    public static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaKekka ninteichosaKekka) {

        Map<ChosaKomoku, RString> map = ninteichosaKekka.get基本情報();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get申請書管理番号().getValue());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get要介護認定調査履歴番号());
        entity.setCk_mahiHidariJoshi(map.get(ChosaKomoku.麻痺等の有無_左上肢));
        entity.setCk_mahiMigiJoshi(map.get(ChosaKomoku.麻痺等の有無_右上肢));
        entity.setCk_mahiHidariKashi(map.get(ChosaKomoku.麻痺等の有無_左下肢));
        entity.setCk_mahiMigiKashi(map.get(ChosaKomoku.麻痺等の有無_右下肢));
        entity.setCk_mahiSonota(map.get(ChosaKomoku.麻痺等の有無_その他));
        entity.setCk_koshukuKata(map.get(ChosaKomoku.関節の動く範囲の制限_肩関節));
        entity.setCk_koshukuMata(map.get(ChosaKomoku.関節の動く範囲の制限_股関節));
        entity.setCk_koshukuHiza(map.get(ChosaKomoku.関節の動く範囲の制限_膝関節));
        entity.setCk_koshukuSonota(map.get(ChosaKomoku.関節の動く範囲の制限_その他));
        entity.setCk_negaeri(map.get(ChosaKomoku.寝返り));
        entity.setCk_okiagari(map.get(ChosaKomoku.起き上がり));
        entity.setCk_zaihoji(map.get(ChosaKomoku.座位保持));
        entity.setCk_ryoashiRitsui(map.get(ChosaKomoku.両足での立位));
        entity.setCk_hoko(map.get(ChosaKomoku.歩行));
        entity.setCk_tachiagari(map.get(ChosaKomoku.立ち上がり));
        entity.setCk_kataashiRitsui(map.get(ChosaKomoku.片足での立位));
        entity.setCk_senshin(map.get(ChosaKomoku.洗身));
        entity.setCk_tumekiri(map.get(ChosaKomoku.つめ切り));
        entity.setCk_shiryoku(map.get(ChosaKomoku.視力));
        entity.setCk_choryoku(map.get(ChosaKomoku.聴力));
        entity.setCk_ijo(map.get(ChosaKomoku.移乗));
        entity.setCk_ido(map.get(ChosaKomoku.移動));
        entity.setCk_enge(map.get(ChosaKomoku.嚥下));
        entity.setCk_shokujiSesshu(map.get(ChosaKomoku.食事摂取));
        entity.setCk_hainyo(map.get(ChosaKomoku.排尿));
        entity.setCk_haiben(map.get(ChosaKomoku.排便));
        entity.setCk_kokoSeiketsu(map.get(ChosaKomoku.口腔清潔));
        entity.setCk_sengan(map.get(ChosaKomoku.洗顔));
        entity.setCk_seihatsu(map.get(ChosaKomoku.整髪));
        entity.setCk_joiChakudatsu(map.get(ChosaKomoku.上衣の着脱));
        entity.setCk_zubonChakudatsu(map.get(ChosaKomoku.ズボン等の着脱));
        entity.setCk_gaishutsuHindo(map.get(ChosaKomoku.外出頻度));
        entity.setCk_ishiDentatsu(map.get(ChosaKomoku.意思の伝達));
        entity.setCk_nikka(map.get(ChosaKomoku.毎日の日課を理解));
        entity.setCk_seinengappi(map.get(ChosaKomoku.生年月日をいう));
        entity.setCk_tankiKioku(map.get(ChosaKomoku.短期記憶));
        entity.setCk_namae(map.get(ChosaKomoku.自分の名前をいう));
        entity.setCk_kisetsu(map.get(ChosaKomoku.今の季節を理解));
        entity.setCk_basho(map.get(ChosaKomoku.場所の理解));
        entity.setCk_haikai(map.get(ChosaKomoku.常時の徘徊));
        entity.setCk_gaishutsu(map.get(ChosaKomoku.外出して戻れない));
        entity.setCk_higaiteki(map.get(ChosaKomoku.被害的));
        entity.setCk_sakuwa(map.get(ChosaKomoku.作話));
        entity.setCk_kanjoHuantei(map.get(ChosaKomoku.感情が不安定));
        entity.setCk_chuyaGyakuten(map.get(ChosaKomoku.昼夜逆転));
        entity.setCk_onajiHanashi(map.get(ChosaKomoku.同じ話をする));
        entity.setCk_ogoe(map.get(ChosaKomoku.大声を出す));
        entity.setCk_kaigoNiTeiko(map.get(ChosaKomoku.介護に抵抗));
        entity.setCk_ochitsuki(map.get(ChosaKomoku.落ち着きなし));
        entity.setCk_hitoriDeDetagaru(map.get(ChosaKomoku.一人で出たがる));
        entity.setCk_shushuheki(map.get(ChosaKomoku.収集癖));
        entity.setCk_monoYaIruiWoKowasu(map.get(ChosaKomoku.物や衣類を壊す));
        entity.setCk_hidoiMonowasure(map.get(ChosaKomoku.ひどい物忘れ));
        entity.setCk_hitorigotoHitoriwarai(map.get(ChosaKomoku.独り言_独り笑));
        entity.setCk_jibunKatte(map.get(ChosaKomoku.自分勝手に行動する));
        entity.setCk_hanashiGaMatomaranai(map.get(ChosaKomoku.話がまとまらない));
        entity.setCk_kusuri(map.get(ChosaKomoku.薬の内服));
        entity.setCk_kinsenKanri(map.get(ChosaKomoku.金銭の管理));
        entity.setCk_ishiKettei(map.get(ChosaKomoku.日常の意思決定));
        entity.setCk_shudanHutekio(map.get(ChosaKomoku.集団への不適応));
        entity.setCk_kaimono(map.get(ChosaKomoku.買い物));
        entity.setCk_chori(map.get(ChosaKomoku.簡単な調理));
        entity.setCk_tenteki(map.get(ChosaKomoku.点滴の管理));
        entity.setCk_chushinJomyakuEiyo(map.get(ChosaKomoku.中心静脈栄養));
        entity.setCk_toseki(map.get(ChosaKomoku.透析));
        entity.setCk_stomaShochi(map.get(ChosaKomoku.ストーマの処置));
        entity.setCk_sansoRyoho(map.get(ChosaKomoku.酸素療法));
        entity.setCk_respirator(map.get(ChosaKomoku.レスピレーター));
        entity.setCk_kikanSekkai(map.get(ChosaKomoku.気管切開));
        entity.setCk_totsuKango(map.get(ChosaKomoku.疼痛の看護));
        entity.setCk_keikanEiyo(map.get(ChosaKomoku.経管栄養));
        entity.setCk_monitorSokutei(map.get(ChosaKomoku.モニター測定));
        entity.setCk_jokusoShochi(map.get(ChosaKomoku.じょくそうの処置));
        entity.setCk_catheter(map.get(ChosaKomoku.カテーテル));

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査特記情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査特記情報エンティティ
     */
    public static DbT5010NinteiChosaTokkijikoEntity toDbT5010NinteiChosaTokkijikoEntity(NinteichosaKekka ninteichosaKekka) {
        // TODO N8156 宮本 康 認定調査特記事項のチケット完了後に対応
        return null;
    }

    private static ChosaKekkaGaikyo toChosaKekkaGaikyo(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new ChosaKekkaGaikyo(
                toChosaKekkaGaikyoKihon(entity),
                toChosaKekkaGaikyoService(entity));
    }

    private static ChosaKekkaGaikyoKihon toChosaKekkaGaikyoKihon(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new ChosaKekkaGaikyoKihon(
                entity.getNinteichosaJisshiYMD(),
                ChosaIraiKubun.toValue(entity.getNinteichousaIraiKubunCode()),
                entity.getChosaJisshiBashoCode(),
                entity.getChosaJisshiBashoMeisho(),
                ChosaKubun.toValue(entity.getNinteiChosaKubunCode()),
                entity.getGaikyochosaTokkijiko(),
                ShinsakaiFuriwakeKubun.toValue(entity.getShinsakaiYusenWaritsukeKubunCode()));
    }

    private static ChosaKekkaGaikyoService toChosaKekkaGaikyoService(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new ChosaKekkaGaikyoService(
                ServiceKubun.toValue(entity.getServiceKubunCode()),
                entity.getHomonKaigo(),
                entity.getHomonNyuyokuKaigo(),
                entity.getHomonKango(),
                entity.getHomonRehabilitation(),
                entity.getKyotakuRyoyoKanriShido(),
                entity.getTushoKaigo(),
                entity.getTushoRehabilitation(),
                entity.getTankiNyushoSeikatsuKaigo(),
                entity.getTankiNyushoRyoyoKaigo(),
                entity.getTokuteiShisetsuNyushoshaSeikatsuKaigo(),
                entity.getHukushiYoguTaiyo(),
                entity.getTokuteiHukushiYoguHanbai(),
                entity.getJutakuKaishu(),
                entity.getYakanTaiogataHomonKaigo(),
                entity.getNinchishoTaiogataTushoKaigo(),
                entity.getShokiboTakinogataKyotakuKaigo(),
                entity.getNinchishoTaiogataKyodoSeikatsuKaigo(),
                entity.getChiikiMitchakugataTokuteiShisetsuNyushoshaSeikatsuKaigo(),
                entity.getChiikiMitchakugataKaigoRojinHukushiNyushoshaSeikatsuKaigo(),
                entity.getTeikijunkaiZuijiTaiogataHomonKaigoKango(),
                entity.getHukugogataService(),
                GenzaiJokyoKubun.toValue(entity.getGenzainoJokyoCode()),
                entity.getShichosonTokubetsuKyufu(),
                entity.getKaigohokenKyufuIgaiNoZaitakuService());
    }

    private static Map<ChosaKomoku, RString> toChosaKekkaKihon(
            DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity, DbT5009NinteichosahyoJohoEntity chosahyoEntity) {

        Map<ChosaKomoku, RString> map = new HashMap<>();
        map.put(ChosaKomoku.麻痺等の有無_左上肢, chosahyoEntity.getCk_mahiHidariJoshi());
        map.put(ChosaKomoku.麻痺等の有無_右上肢, chosahyoEntity.getCk_mahiMigiJoshi());
        map.put(ChosaKomoku.麻痺等の有無_左下肢, chosahyoEntity.getCk_mahiHidariKashi());
        map.put(ChosaKomoku.麻痺等の有無_右下肢, chosahyoEntity.getCk_mahiMigiKashi());
        map.put(ChosaKomoku.麻痺等の有無_その他, chosahyoEntity.getCk_mahiSonota());
        map.put(ChosaKomoku.関節の動く範囲の制限_肩関節, chosahyoEntity.getCk_koshukuKata());
        map.put(ChosaKomoku.関節の動く範囲の制限_股関節, chosahyoEntity.getCk_koshukuMata());
        map.put(ChosaKomoku.関節の動く範囲の制限_膝関節, chosahyoEntity.getCk_koshukuHiza());
        map.put(ChosaKomoku.関節の動く範囲の制限_その他, chosahyoEntity.getCk_koshukuSonota());
        map.put(ChosaKomoku.寝返り, chosahyoEntity.getCk_negaeri());
        map.put(ChosaKomoku.起き上がり, chosahyoEntity.getCk_okiagari());
        map.put(ChosaKomoku.座位保持, chosahyoEntity.getCk_zaihoji());
        map.put(ChosaKomoku.両足での立位, chosahyoEntity.getCk_ryoashiRitsui());
        map.put(ChosaKomoku.歩行, chosahyoEntity.getCk_hoko());
        map.put(ChosaKomoku.立ち上がり, chosahyoEntity.getCk_tachiagari());
        map.put(ChosaKomoku.片足での立位, chosahyoEntity.getCk_kataashiRitsui());
        map.put(ChosaKomoku.洗身, chosahyoEntity.getCk_senshin());
        map.put(ChosaKomoku.つめ切り, chosahyoEntity.getCk_tumekiri());
        map.put(ChosaKomoku.視力, chosahyoEntity.getCk_shiryoku());
        map.put(ChosaKomoku.聴力, chosahyoEntity.getCk_choryoku());
        map.put(ChosaKomoku.移乗, chosahyoEntity.getCk_ijo());
        map.put(ChosaKomoku.移動, chosahyoEntity.getCk_ido());
        map.put(ChosaKomoku.嚥下, chosahyoEntity.getCk_enge());
        map.put(ChosaKomoku.食事摂取, chosahyoEntity.getCk_shokujiSesshu());
        map.put(ChosaKomoku.排尿, chosahyoEntity.getCk_hainyo());
        map.put(ChosaKomoku.排便, chosahyoEntity.getCk_haiben());
        map.put(ChosaKomoku.口腔清潔, chosahyoEntity.getCk_kokoSeiketsu());
        map.put(ChosaKomoku.洗顔, chosahyoEntity.getCk_sengan());
        map.put(ChosaKomoku.整髪, chosahyoEntity.getCk_seihatsu());
        map.put(ChosaKomoku.上衣の着脱, chosahyoEntity.getCk_joiChakudatsu());
        map.put(ChosaKomoku.ズボン等の着脱, chosahyoEntity.getCk_zubonChakudatsu());
        map.put(ChosaKomoku.外出頻度, chosahyoEntity.getCk_gaishutsuHindo());
        map.put(ChosaKomoku.意思の伝達, chosahyoEntity.getCk_ishiDentatsu());
        map.put(ChosaKomoku.毎日の日課を理解, chosahyoEntity.getCk_nikka());
        map.put(ChosaKomoku.生年月日をいう, chosahyoEntity.getCk_seinengappi());
        map.put(ChosaKomoku.短期記憶, chosahyoEntity.getCk_tankiKioku());
        map.put(ChosaKomoku.自分の名前をいう, chosahyoEntity.getCk_namae());
        map.put(ChosaKomoku.今の季節を理解, chosahyoEntity.getCk_kisetsu());
        map.put(ChosaKomoku.場所の理解, chosahyoEntity.getCk_basho());
        map.put(ChosaKomoku.常時の徘徊, chosahyoEntity.getCk_haikai());
        map.put(ChosaKomoku.外出して戻れない, chosahyoEntity.getCk_gaishutsu());
        map.put(ChosaKomoku.被害的, chosahyoEntity.getCk_higaiteki());
        map.put(ChosaKomoku.作話, chosahyoEntity.getCk_sakuwa());
        map.put(ChosaKomoku.感情が不安定, chosahyoEntity.getCk_kanjoHuantei());
        map.put(ChosaKomoku.昼夜逆転, chosahyoEntity.getCk_chuyaGyakuten());
        map.put(ChosaKomoku.同じ話をする, chosahyoEntity.getCk_onajiHanashi());
        map.put(ChosaKomoku.大声を出す, chosahyoEntity.getCk_ogoe());
        map.put(ChosaKomoku.介護に抵抗, chosahyoEntity.getCk_kaigoNiTeiko());
        map.put(ChosaKomoku.落ち着きなし, chosahyoEntity.getCk_ochitsuki());
        map.put(ChosaKomoku.一人で出たがる, chosahyoEntity.getCk_hitoriDeDetagaru());
        map.put(ChosaKomoku.収集癖, chosahyoEntity.getCk_shushuheki());
        map.put(ChosaKomoku.物や衣類を壊す, chosahyoEntity.getCk_monoYaIruiWoKowasu());
        map.put(ChosaKomoku.ひどい物忘れ, chosahyoEntity.getCk_hidoiMonowasure());
        map.put(ChosaKomoku.独り言_独り笑, chosahyoEntity.getCk_hitorigotoHitoriwarai());
        map.put(ChosaKomoku.自分勝手に行動する, chosahyoEntity.getCk_jibunKatte());
        map.put(ChosaKomoku.話がまとまらない, chosahyoEntity.getCk_hanashiGaMatomaranai());
        map.put(ChosaKomoku.薬の内服, chosahyoEntity.getCk_kusuri());
        map.put(ChosaKomoku.金銭の管理, chosahyoEntity.getCk_kinsenKanri());
        map.put(ChosaKomoku.日常の意思決定, chosahyoEntity.getCk_ishiKettei());
        map.put(ChosaKomoku.集団への不適応, chosahyoEntity.getCk_shudanHutekio());
        map.put(ChosaKomoku.買い物, chosahyoEntity.getCk_kaimono());
        map.put(ChosaKomoku.簡単な調理, chosahyoEntity.getCk_chori());
        map.put(ChosaKomoku.点滴の管理, chosahyoEntity.getCk_tenteki());
        map.put(ChosaKomoku.中心静脈栄養, chosahyoEntity.getCk_chushinJomyakuEiyo());
        map.put(ChosaKomoku.透析, chosahyoEntity.getCk_toseki());
        map.put(ChosaKomoku.ストーマの処置, chosahyoEntity.getCk_stomaShochi());
        map.put(ChosaKomoku.酸素療法, chosahyoEntity.getCk_sansoRyoho());
        map.put(ChosaKomoku.レスピレーター, chosahyoEntity.getCk_respirator());
        map.put(ChosaKomoku.気管切開, chosahyoEntity.getCk_kikanSekkai());
        map.put(ChosaKomoku.疼痛の看護, chosahyoEntity.getCk_totsuKango());
        map.put(ChosaKomoku.経管栄養, chosahyoEntity.getCk_keikanEiyo());
        map.put(ChosaKomoku.モニター測定, chosahyoEntity.getCk_monitorSokutei());
        map.put(ChosaKomoku.じょくそうの処置, chosahyoEntity.getCk_jokusoShochi());
        map.put(ChosaKomoku.カテーテル, chosahyoEntity.getCk_catheter());
        map.put(ChosaKomoku.障害高齢者の日常生活自立度, chosaKekkaEntity.getShogaiNichijoSeikatsuJiritsudoCode());
        map.put(ChosaKomoku.認知症高齢者の日常生活自立度, chosaKekkaEntity.getNinchishoNichijoSeikatsuJiritsudoCode());

        return map;
    }
}
