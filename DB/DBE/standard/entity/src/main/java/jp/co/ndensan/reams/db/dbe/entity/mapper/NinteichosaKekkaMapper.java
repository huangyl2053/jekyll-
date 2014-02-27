/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultChosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
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

    private static final int NENDO_2006 = 2006;

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
                toNinteichosaResultChosahyo(chosaKekkaEntity, chosahyoEntity), toNinteichosaResultGaikyo(chosaKekkaEntity)) : null;
    }

    /**
     * 引数の認定調査結果情報から認定調査結果情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査結果情報エンティティ
     */
    public static DbT5008NinteichosaKekkaJohoEntity toDbT5008NinteichosaKekkaJohoEntity(NinteichosaResult ninteichosaKekka) {

        NinteichosaResultGaikyoKihon kihon = ninteichosaKekka.get概況調査結果().get基本情報();
        NinteichosaResultGaikyoService service = ninteichosaKekka.get概況調査結果().getサービス状況();
        Map<ChosahyoItems, NinteichosaItemResult> map = ninteichosaKekka.get調査票結果().get調査票結果();

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get概況調査結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get概況調査結果().get要介護認定調査履歴番号());
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
        entity.setShogaiNichijoSeikatsuJiritsudoCode(map.get(ChosahyoItems.障害高齢者の日常生活自立度).get調査結果コード());
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(map.get(ChosahyoItems.認知症高齢者の日常生活自立度).get調査結果コード());

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査票情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査票情報エンティティ
     */
    public static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        Map<ChosahyoItems, NinteichosaItemResult> map = ninteichosaKekka.get調査票結果().get調査票結果();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get調査票結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get調査票結果().get要介護認定調査履歴番号());
        entity.setCk_mahiHidariJoshi(map.get(ChosahyoItems.麻痺等の有無_左上肢).get調査結果コード());
        entity.setCk_mahiMigiJoshi(map.get(ChosahyoItems.麻痺等の有無_右上肢).get調査結果コード());
        entity.setCk_mahiHidariKashi(map.get(ChosahyoItems.麻痺等の有無_左下肢).get調査結果コード());
        entity.setCk_mahiMigiKashi(map.get(ChosahyoItems.麻痺等の有無_右下肢).get調査結果コード());
        entity.setCk_mahiSonota(map.get(ChosahyoItems.麻痺等の有無_その他).get調査結果コード());
        entity.setCk_koshukuKata(map.get(ChosahyoItems.関節の動く範囲の制限_肩関節).get調査結果コード());
        entity.setCk_koshukuMata(map.get(ChosahyoItems.関節の動く範囲の制限_股関節).get調査結果コード());
        entity.setCk_koshukuHiza(map.get(ChosahyoItems.関節の動く範囲の制限_膝関節).get調査結果コード());
        entity.setCk_koshukuSonota(map.get(ChosahyoItems.関節の動く範囲の制限_その他).get調査結果コード());
        entity.setCk_negaeri(map.get(ChosahyoItems.寝返り).get調査結果コード());
        entity.setCk_okiagari(map.get(ChosahyoItems.起き上がり).get調査結果コード());
        entity.setCk_zaihoji(map.get(ChosahyoItems.座位保持).get調査結果コード());
        entity.setCk_ryoashiRitsui(map.get(ChosahyoItems.両足での立位).get調査結果コード());
        entity.setCk_hoko(map.get(ChosahyoItems.歩行).get調査結果コード());
        entity.setCk_tachiagari(map.get(ChosahyoItems.立ち上がり).get調査結果コード());
        entity.setCk_kataashiRitsui(map.get(ChosahyoItems.片足での立位).get調査結果コード());
        entity.setCk_senshin(map.get(ChosahyoItems.洗身).get調査結果コード());
        entity.setCk_tumekiri(map.get(ChosahyoItems.つめ切り).get調査結果コード());
        entity.setCk_shiryoku(map.get(ChosahyoItems.視力).get調査結果コード());
        entity.setCk_choryoku(map.get(ChosahyoItems.聴力).get調査結果コード());
        entity.setCk_ijo(map.get(ChosahyoItems.移乗).get調査結果コード());
        entity.setCk_ido(map.get(ChosahyoItems.移動).get調査結果コード());
        entity.setCk_enge(map.get(ChosahyoItems.嚥下).get調査結果コード());
        entity.setCk_shokujiSesshu(map.get(ChosahyoItems.食事摂取).get調査結果コード());
        entity.setCk_hainyo(map.get(ChosahyoItems.排尿).get調査結果コード());
        entity.setCk_haiben(map.get(ChosahyoItems.排便).get調査結果コード());
        entity.setCk_kokoSeiketsu(map.get(ChosahyoItems.口腔清潔).get調査結果コード());
        entity.setCk_sengan(map.get(ChosahyoItems.洗顔).get調査結果コード());
        entity.setCk_seihatsu(map.get(ChosahyoItems.整髪).get調査結果コード());
        entity.setCk_joiChakudatsu(map.get(ChosahyoItems.上衣の着脱).get調査結果コード());
        entity.setCk_zubonChakudatsu(map.get(ChosahyoItems.ズボン等の着脱).get調査結果コード());
        entity.setCk_gaishutsuHindo(map.get(ChosahyoItems.外出頻度).get調査結果コード());
        entity.setCk_ishiDentatsu(map.get(ChosahyoItems.意思の伝達).get調査結果コード());
        entity.setCk_nikka(map.get(ChosahyoItems.毎日の日課を理解).get調査結果コード());
        entity.setCk_seinengappi(map.get(ChosahyoItems.生年月日をいう).get調査結果コード());
        entity.setCk_tankiKioku(map.get(ChosahyoItems.短期記憶).get調査結果コード());
        entity.setCk_namae(map.get(ChosahyoItems.自分の名前をいう).get調査結果コード());
        entity.setCk_kisetsu(map.get(ChosahyoItems.今の季節を理解).get調査結果コード());
        entity.setCk_basho(map.get(ChosahyoItems.場所の理解).get調査結果コード());
        entity.setCk_haikai(map.get(ChosahyoItems.常時の徘徊).get調査結果コード());
        entity.setCk_gaishutsu(map.get(ChosahyoItems.外出して戻れない).get調査結果コード());
        entity.setCk_higaiteki(map.get(ChosahyoItems.被害的).get調査結果コード());
        entity.setCk_sakuwa(map.get(ChosahyoItems.作話).get調査結果コード());
        entity.setCk_kanjoHuantei(map.get(ChosahyoItems.感情が不安定).get調査結果コード());
        entity.setCk_chuyaGyakuten(map.get(ChosahyoItems.昼夜逆転).get調査結果コード());
        entity.setCk_onajiHanashi(map.get(ChosahyoItems.同じ話をする).get調査結果コード());
        entity.setCk_ogoe(map.get(ChosahyoItems.大声を出す).get調査結果コード());
        entity.setCk_kaigoNiTeiko(map.get(ChosahyoItems.介護に抵抗).get調査結果コード());
        entity.setCk_ochitsuki(map.get(ChosahyoItems.落ち着きなし).get調査結果コード());
        entity.setCk_hitoriDeDetagaru(map.get(ChosahyoItems.一人で出たがる).get調査結果コード());
        entity.setCk_shushuheki(map.get(ChosahyoItems.収集癖).get調査結果コード());
        entity.setCk_monoYaIruiWoKowasu(map.get(ChosahyoItems.物や衣類を壊す).get調査結果コード());
        entity.setCk_hidoiMonowasure(map.get(ChosahyoItems.ひどい物忘れ).get調査結果コード());
        entity.setCk_hitorigotoHitoriwarai(map.get(ChosahyoItems.独り言_独り笑).get調査結果コード());
        entity.setCk_jibunKatte(map.get(ChosahyoItems.自分勝手に行動する).get調査結果コード());
        entity.setCk_hanashiGaMatomaranai(map.get(ChosahyoItems.話がまとまらない).get調査結果コード());
        entity.setCk_kusuri(map.get(ChosahyoItems.薬の内服).get調査結果コード());
        entity.setCk_kinsenKanri(map.get(ChosahyoItems.金銭の管理).get調査結果コード());
        entity.setCk_ishiKettei(map.get(ChosahyoItems.日常の意思決定).get調査結果コード());
        entity.setCk_shudanHutekio(map.get(ChosahyoItems.集団への不適応).get調査結果コード());
        entity.setCk_kaimono(map.get(ChosahyoItems.買い物).get調査結果コード());
        entity.setCk_chori(map.get(ChosahyoItems.簡単な調理).get調査結果コード());
        entity.setCk_tenteki(map.get(ChosahyoItems.点滴の管理).get調査結果コード());
        entity.setCk_chushinJomyakuEiyo(map.get(ChosahyoItems.中心静脈栄養).get調査結果コード());
        entity.setCk_toseki(map.get(ChosahyoItems.透析).get調査結果コード());
        entity.setCk_stomaShochi(map.get(ChosahyoItems.ストーマの処置).get調査結果コード());
        entity.setCk_sansoRyoho(map.get(ChosahyoItems.酸素療法).get調査結果コード());
        entity.setCk_respirator(map.get(ChosahyoItems.レスピレーター).get調査結果コード());
        entity.setCk_kikanSekkai(map.get(ChosahyoItems.気管切開).get調査結果コード());
        entity.setCk_totsuKango(map.get(ChosahyoItems.疼痛の看護).get調査結果コード());
        entity.setCk_keikanEiyo(map.get(ChosahyoItems.経管栄養).get調査結果コード());
        entity.setCk_monitorSokutei(map.get(ChosahyoItems.モニター測定).get調査結果コード());
        entity.setCk_jokusoShochi(map.get(ChosahyoItems.じょくそうの処置).get調査結果コード());
        entity.setCk_catheter(map.get(ChosahyoItems.カテーテル).get調査結果コード());

        return entity;
    }

    private static NinteichosaResultChosahyo toNinteichosaResultChosahyo(
            DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity, DbT5009NinteichosahyoJohoEntity chosahyoEntity) {
        Map<ChosahyoItems, NinteichosaItemResult> resultMap = new EnumMap<>(ChosahyoItems.class);
        Ninteichosahyo chosahyo = NinteichosahyoFactory.createInstance(NENDO_2006);
        setResultMap(resultMap, chosahyo, ChosahyoItems.麻痺等の有無_左上肢, chosahyoEntity.getCk_mahiHidariJoshi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.麻痺等の有無_右上肢, chosahyoEntity.getCk_mahiMigiJoshi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.麻痺等の有無_左下肢, chosahyoEntity.getCk_mahiHidariKashi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.麻痺等の有無_右下肢, chosahyoEntity.getCk_mahiMigiKashi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.麻痺等の有無_その他, chosahyoEntity.getCk_mahiSonota());
        setResultMap(resultMap, chosahyo, ChosahyoItems.関節の動く範囲の制限_肩関節, chosahyoEntity.getCk_koshukuKata());
        setResultMap(resultMap, chosahyo, ChosahyoItems.関節の動く範囲の制限_股関節, chosahyoEntity.getCk_koshukuMata());
        setResultMap(resultMap, chosahyo, ChosahyoItems.関節の動く範囲の制限_膝関節, chosahyoEntity.getCk_koshukuHiza());
        setResultMap(resultMap, chosahyo, ChosahyoItems.関節の動く範囲の制限_その他, chosahyoEntity.getCk_koshukuSonota());
        setResultMap(resultMap, chosahyo, ChosahyoItems.寝返り, chosahyoEntity.getCk_negaeri());
        setResultMap(resultMap, chosahyo, ChosahyoItems.起き上がり, chosahyoEntity.getCk_okiagari());
        setResultMap(resultMap, chosahyo, ChosahyoItems.座位保持, chosahyoEntity.getCk_zaihoji());
        setResultMap(resultMap, chosahyo, ChosahyoItems.両足での立位, chosahyoEntity.getCk_ryoashiRitsui());
        setResultMap(resultMap, chosahyo, ChosahyoItems.歩行, chosahyoEntity.getCk_hoko());
        setResultMap(resultMap, chosahyo, ChosahyoItems.立ち上がり, chosahyoEntity.getCk_tachiagari());
        setResultMap(resultMap, chosahyo, ChosahyoItems.片足での立位, chosahyoEntity.getCk_kataashiRitsui());
        setResultMap(resultMap, chosahyo, ChosahyoItems.洗身, chosahyoEntity.getCk_senshin());
        setResultMap(resultMap, chosahyo, ChosahyoItems.つめ切り, chosahyoEntity.getCk_tumekiri());
        setResultMap(resultMap, chosahyo, ChosahyoItems.視力, chosahyoEntity.getCk_shiryoku());
        setResultMap(resultMap, chosahyo, ChosahyoItems.聴力, chosahyoEntity.getCk_choryoku());
        setResultMap(resultMap, chosahyo, ChosahyoItems.移乗, chosahyoEntity.getCk_ijo());
        setResultMap(resultMap, chosahyo, ChosahyoItems.移動, chosahyoEntity.getCk_ido());
        setResultMap(resultMap, chosahyo, ChosahyoItems.嚥下, chosahyoEntity.getCk_enge());
        setResultMap(resultMap, chosahyo, ChosahyoItems.食事摂取, chosahyoEntity.getCk_shokujiSesshu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.排尿, chosahyoEntity.getCk_hainyo());
        setResultMap(resultMap, chosahyo, ChosahyoItems.排便, chosahyoEntity.getCk_haiben());
        setResultMap(resultMap, chosahyo, ChosahyoItems.口腔清潔, chosahyoEntity.getCk_kokoSeiketsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.洗顔, chosahyoEntity.getCk_sengan());
        setResultMap(resultMap, chosahyo, ChosahyoItems.整髪, chosahyoEntity.getCk_seihatsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.上衣の着脱, chosahyoEntity.getCk_joiChakudatsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.ズボン等の着脱, chosahyoEntity.getCk_zubonChakudatsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.外出頻度, chosahyoEntity.getCk_gaishutsuHindo());
        setResultMap(resultMap, chosahyo, ChosahyoItems.意思の伝達, chosahyoEntity.getCk_ishiDentatsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.毎日の日課を理解, chosahyoEntity.getCk_nikka());
        setResultMap(resultMap, chosahyo, ChosahyoItems.生年月日をいう, chosahyoEntity.getCk_seinengappi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.短期記憶, chosahyoEntity.getCk_tankiKioku());
        setResultMap(resultMap, chosahyo, ChosahyoItems.自分の名前をいう, chosahyoEntity.getCk_namae());
        setResultMap(resultMap, chosahyo, ChosahyoItems.今の季節を理解, chosahyoEntity.getCk_kisetsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.場所の理解, chosahyoEntity.getCk_basho());
        setResultMap(resultMap, chosahyo, ChosahyoItems.常時の徘徊, chosahyoEntity.getCk_haikai());
        setResultMap(resultMap, chosahyo, ChosahyoItems.外出して戻れない, chosahyoEntity.getCk_gaishutsu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.被害的, chosahyoEntity.getCk_higaiteki());
        setResultMap(resultMap, chosahyo, ChosahyoItems.作話, chosahyoEntity.getCk_sakuwa());
        setResultMap(resultMap, chosahyo, ChosahyoItems.感情が不安定, chosahyoEntity.getCk_kanjoHuantei());
        setResultMap(resultMap, chosahyo, ChosahyoItems.昼夜逆転, chosahyoEntity.getCk_chuyaGyakuten());
        setResultMap(resultMap, chosahyo, ChosahyoItems.同じ話をする, chosahyoEntity.getCk_onajiHanashi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.大声を出す, chosahyoEntity.getCk_ogoe());
        setResultMap(resultMap, chosahyo, ChosahyoItems.介護に抵抗, chosahyoEntity.getCk_kaigoNiTeiko());
        setResultMap(resultMap, chosahyo, ChosahyoItems.落ち着きなし, chosahyoEntity.getCk_ochitsuki());
        setResultMap(resultMap, chosahyo, ChosahyoItems.一人で出たがる, chosahyoEntity.getCk_hitoriDeDetagaru());
        setResultMap(resultMap, chosahyo, ChosahyoItems.収集癖, chosahyoEntity.getCk_shushuheki());
        setResultMap(resultMap, chosahyo, ChosahyoItems.物や衣類を壊す, chosahyoEntity.getCk_monoYaIruiWoKowasu());
        setResultMap(resultMap, chosahyo, ChosahyoItems.ひどい物忘れ, chosahyoEntity.getCk_hidoiMonowasure());
        setResultMap(resultMap, chosahyo, ChosahyoItems.独り言_独り笑, chosahyoEntity.getCk_hitorigotoHitoriwarai());
        setResultMap(resultMap, chosahyo, ChosahyoItems.自分勝手に行動する, chosahyoEntity.getCk_jibunKatte());
        setResultMap(resultMap, chosahyo, ChosahyoItems.話がまとまらない, chosahyoEntity.getCk_hanashiGaMatomaranai());
        setResultMap(resultMap, chosahyo, ChosahyoItems.薬の内服, chosahyoEntity.getCk_kusuri());
        setResultMap(resultMap, chosahyo, ChosahyoItems.金銭の管理, chosahyoEntity.getCk_kinsenKanri());
        setResultMap(resultMap, chosahyo, ChosahyoItems.日常の意思決定, chosahyoEntity.getCk_ishiKettei());
        setResultMap(resultMap, chosahyo, ChosahyoItems.集団への不適応, chosahyoEntity.getCk_shudanHutekio());
        setResultMap(resultMap, chosahyo, ChosahyoItems.買い物, chosahyoEntity.getCk_kaimono());
        setResultMap(resultMap, chosahyo, ChosahyoItems.簡単な調理, chosahyoEntity.getCk_chori());
        setResultMap(resultMap, chosahyo, ChosahyoItems.点滴の管理, chosahyoEntity.getCk_tenteki());
        setResultMap(resultMap, chosahyo, ChosahyoItems.中心静脈栄養, chosahyoEntity.getCk_chushinJomyakuEiyo());
        setResultMap(resultMap, chosahyo, ChosahyoItems.透析, chosahyoEntity.getCk_toseki());
        setResultMap(resultMap, chosahyo, ChosahyoItems.ストーマの処置, chosahyoEntity.getCk_stomaShochi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.酸素療法, chosahyoEntity.getCk_sansoRyoho());
        setResultMap(resultMap, chosahyo, ChosahyoItems.レスピレーター, chosahyoEntity.getCk_respirator());
        setResultMap(resultMap, chosahyo, ChosahyoItems.気管切開, chosahyoEntity.getCk_kikanSekkai());
        setResultMap(resultMap, chosahyo, ChosahyoItems.疼痛の看護, chosahyoEntity.getCk_totsuKango());
        setResultMap(resultMap, chosahyo, ChosahyoItems.経管栄養, chosahyoEntity.getCk_keikanEiyo());
        setResultMap(resultMap, chosahyo, ChosahyoItems.モニター測定, chosahyoEntity.getCk_monitorSokutei());
        setResultMap(resultMap, chosahyo, ChosahyoItems.じょくそうの処置, chosahyoEntity.getCk_jokusoShochi());
        setResultMap(resultMap, chosahyo, ChosahyoItems.カテーテル, chosahyoEntity.getCk_catheter());
        setResultMap(resultMap, chosahyo, ChosahyoItems.障害高齢者の日常生活自立度, chosaKekkaEntity.getShogaiNichijoSeikatsuJiritsudoCode());
        setResultMap(resultMap, chosahyo, ChosahyoItems.認知症高齢者の日常生活自立度, chosaKekkaEntity.getNinchishoNichijoSeikatsuJiritsudoCode());
        return new NinteichosaResultChosahyo(
                new ShinseishoKanriNo(chosahyoEntity.getShinseishoKanriNo()), chosahyoEntity.getNinteichosaRirekiNo(), NENDO_2006, resultMap);
    }

    private static void setResultMap(
            Map<ChosahyoItems, NinteichosaItemResult> 調査結果Map, Ninteichosahyo 調査票, ChosahyoItems 調査票項目, RString 調査結果) {
        調査結果Map.put(調査票項目, new NinteichosaItemResult((NinteichosaItem) 調査票.get調査項目(調査票項目), 調査結果));
    }

    private static NinteichosaResultGaikyo toNinteichosaResultGaikyo(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultGaikyo(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                entity.getNinteichosaRirekiNo(),
                toNinteichosaResultGaikyoKihon(entity),
                toNinteichosaResultGaikyoService(entity));
    }

    private static NinteichosaResultGaikyoKihon toNinteichosaResultGaikyoKihon(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultGaikyoKihon(
                entity.getNinteichosaJisshiYMD(),
                ChosaIraiKubun.toValue(entity.getNinteichousaIraiKubunCode()),
                entity.getChosaJisshiBashoCode(),
                entity.getChosaJisshiBashoMeisho(),
                ChosaKubun.toValue(entity.getNinteiChosaKubunCode()),
                entity.getGaikyochosaTokkijiko(),
                ShinsakaiFuriwakeKubun.toValue(entity.getShinsakaiYusenWaritsukeKubunCode()));
    }

    private static NinteichosaResultGaikyoService toNinteichosaResultGaikyoService(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultGaikyoService(
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
}
