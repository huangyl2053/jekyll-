/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import java.util.EnumMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaItemResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResult;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosaResultOfChosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.Ninteichosahyo;
import jp.co.ndensan.reams.db.dbe.business.ninteichosa.NinteichosahyoFactory;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ChosaKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.GenzaiJokyoKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ServiceKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShinsakaiFuriwakeKubun;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.NinteichosaItem;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItemGroup;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.ChosahyoItems;
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

        NinteichosaResultOfGaikyoKihon kihon = ninteichosaKekka.get概況調査結果().get基本情報();
        NinteichosaResultOfGaikyoService service = ninteichosaKekka.get概況調査結果().getサービス状況();
        Ninteichosahyo<NinteichosaItemResult> rslt = ninteichosaKekka.get調査票結果().get調査票結果();

        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get概況調査結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get概況調査結果().get認定調査依頼履歴番号().value().intValue());
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
        entity.setShogaiNichijoSeikatsuJiritsudoCode(rslt.get調査項目(ChosahyoItems.障害高齢者の日常生活自立度).get調査結果コード());
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(rslt.get調査項目(ChosahyoItems.認知症高齢者の日常生活自立度).get調査結果コード());

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査票情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査票情報エンティティ
     */
    public static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaResult ninteichosaKekka) {

        Ninteichosahyo<NinteichosaItemResult> rslt = ninteichosaKekka.get調査票結果().get調査票結果();

        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(ninteichosaKekka.get調査票結果().get申請書管理番号().value());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get調査票結果().get認定調査依頼履歴番号().value().intValue());
        entity.setCk_mahiHidariJoshi(rslt.get調査項目(ChosahyoItems.麻痺等の有無_左上肢).get調査結果コード());
        entity.setCk_mahiMigiJoshi(rslt.get調査項目(ChosahyoItems.麻痺等の有無_右上肢).get調査結果コード());
        entity.setCk_mahiHidariKashi(rslt.get調査項目(ChosahyoItems.麻痺等の有無_左下肢).get調査結果コード());
        entity.setCk_mahiMigiKashi(rslt.get調査項目(ChosahyoItems.麻痺等の有無_右下肢).get調査結果コード());
        entity.setCk_mahiSonota(rslt.get調査項目(ChosahyoItems.麻痺等の有無_その他).get調査結果コード());
        entity.setCk_koshukuKata(rslt.get調査項目(ChosahyoItems.関節の動く範囲の制限_肩関節).get調査結果コード());
        entity.setCk_koshukuMata(rslt.get調査項目(ChosahyoItems.関節の動く範囲の制限_股関節).get調査結果コード());
        entity.setCk_koshukuHiza(rslt.get調査項目(ChosahyoItems.関節の動く範囲の制限_膝関節).get調査結果コード());
        entity.setCk_koshukuSonota(rslt.get調査項目(ChosahyoItems.関節の動く範囲の制限_その他).get調査結果コード());
        entity.setCk_negaeri(rslt.get調査項目(ChosahyoItems.寝返り).get調査結果コード());
        entity.setCk_okiagari(rslt.get調査項目(ChosahyoItems.起き上がり).get調査結果コード());
        entity.setCk_zaihoji(rslt.get調査項目(ChosahyoItems.座位保持).get調査結果コード());
        entity.setCk_ryoashiRitsui(rslt.get調査項目(ChosahyoItems.両足での立位).get調査結果コード());
        entity.setCk_hoko(rslt.get調査項目(ChosahyoItems.歩行).get調査結果コード());
        entity.setCk_tachiagari(rslt.get調査項目(ChosahyoItems.立ち上がり).get調査結果コード());
        entity.setCk_kataashiRitsui(rslt.get調査項目(ChosahyoItems.片足での立位).get調査結果コード());
        entity.setCk_senshin(rslt.get調査項目(ChosahyoItems.洗身).get調査結果コード());
        entity.setCk_tumekiri(rslt.get調査項目(ChosahyoItems.つめ切り).get調査結果コード());
        entity.setCk_shiryoku(rslt.get調査項目(ChosahyoItems.視力).get調査結果コード());
        entity.setCk_choryoku(rslt.get調査項目(ChosahyoItems.聴力).get調査結果コード());
        entity.setCk_ijo(rslt.get調査項目(ChosahyoItems.移乗).get調査結果コード());
        entity.setCk_ido(rslt.get調査項目(ChosahyoItems.移動).get調査結果コード());
        entity.setCk_enge(rslt.get調査項目(ChosahyoItems.嚥下).get調査結果コード());
        entity.setCk_shokujiSesshu(rslt.get調査項目(ChosahyoItems.食事摂取).get調査結果コード());
        entity.setCk_hainyo(rslt.get調査項目(ChosahyoItems.排尿).get調査結果コード());
        entity.setCk_haiben(rslt.get調査項目(ChosahyoItems.排便).get調査結果コード());
        entity.setCk_kokoSeiketsu(rslt.get調査項目(ChosahyoItems.口腔清潔).get調査結果コード());
        entity.setCk_sengan(rslt.get調査項目(ChosahyoItems.洗顔).get調査結果コード());
        entity.setCk_seihatsu(rslt.get調査項目(ChosahyoItems.整髪).get調査結果コード());
        entity.setCk_joiChakudatsu(rslt.get調査項目(ChosahyoItems.上衣の着脱).get調査結果コード());
        entity.setCk_zubonChakudatsu(rslt.get調査項目(ChosahyoItems.ズボン等の着脱).get調査結果コード());
        entity.setCk_gaishutsuHindo(rslt.get調査項目(ChosahyoItems.外出頻度).get調査結果コード());
        entity.setCk_ishiDentatsu(rslt.get調査項目(ChosahyoItems.意思の伝達).get調査結果コード());
        entity.setCk_nikka(rslt.get調査項目(ChosahyoItems.毎日の日課を理解).get調査結果コード());
        entity.setCk_seinengappi(rslt.get調査項目(ChosahyoItems.生年月日をいう).get調査結果コード());
        entity.setCk_tankiKioku(rslt.get調査項目(ChosahyoItems.短期記憶).get調査結果コード());
        entity.setCk_namae(rslt.get調査項目(ChosahyoItems.自分の名前をいう).get調査結果コード());
        entity.setCk_kisetsu(rslt.get調査項目(ChosahyoItems.今の季節を理解).get調査結果コード());
        entity.setCk_basho(rslt.get調査項目(ChosahyoItems.場所の理解).get調査結果コード());
        entity.setCk_haikai(rslt.get調査項目(ChosahyoItems.常時の徘徊).get調査結果コード());
        entity.setCk_gaishutsu(rslt.get調査項目(ChosahyoItems.外出して戻れない).get調査結果コード());
        entity.setCk_higaiteki(rslt.get調査項目(ChosahyoItems.被害的).get調査結果コード());
        entity.setCk_sakuwa(rslt.get調査項目(ChosahyoItems.作話).get調査結果コード());
        entity.setCk_kanjoHuantei(rslt.get調査項目(ChosahyoItems.感情が不安定).get調査結果コード());
        entity.setCk_chuyaGyakuten(rslt.get調査項目(ChosahyoItems.昼夜逆転).get調査結果コード());
        entity.setCk_onajiHanashi(rslt.get調査項目(ChosahyoItems.同じ話をする).get調査結果コード());
        entity.setCk_ogoe(rslt.get調査項目(ChosahyoItems.大声を出す).get調査結果コード());
        entity.setCk_kaigoNiTeiko(rslt.get調査項目(ChosahyoItems.介護に抵抗).get調査結果コード());
        entity.setCk_ochitsuki(rslt.get調査項目(ChosahyoItems.落ち着きなし).get調査結果コード());
        entity.setCk_hitoriDeDetagaru(rslt.get調査項目(ChosahyoItems.一人で出たがる).get調査結果コード());
        entity.setCk_shushuheki(rslt.get調査項目(ChosahyoItems.収集癖).get調査結果コード());
        entity.setCk_monoYaIruiWoKowasu(rslt.get調査項目(ChosahyoItems.物や衣類を壊す).get調査結果コード());
        entity.setCk_hidoiMonowasure(rslt.get調査項目(ChosahyoItems.ひどい物忘れ).get調査結果コード());
        entity.setCk_hitorigotoHitoriwarai(rslt.get調査項目(ChosahyoItems.独り言_独り笑).get調査結果コード());
        entity.setCk_jibunKatte(rslt.get調査項目(ChosahyoItems.自分勝手に行動する).get調査結果コード());
        entity.setCk_hanashiGaMatomaranai(rslt.get調査項目(ChosahyoItems.話がまとまらない).get調査結果コード());
        entity.setCk_kusuri(rslt.get調査項目(ChosahyoItems.薬の内服).get調査結果コード());
        entity.setCk_kinsenKanri(rslt.get調査項目(ChosahyoItems.金銭の管理).get調査結果コード());
        entity.setCk_ishiKettei(rslt.get調査項目(ChosahyoItems.日常の意思決定).get調査結果コード());
        entity.setCk_shudanHutekio(rslt.get調査項目(ChosahyoItems.集団への不適応).get調査結果コード());
        entity.setCk_kaimono(rslt.get調査項目(ChosahyoItems.買い物).get調査結果コード());
        entity.setCk_chori(rslt.get調査項目(ChosahyoItems.簡単な調理).get調査結果コード());
        entity.setCk_tenteki(rslt.get調査項目(ChosahyoItems.点滴の管理).get調査結果コード());
        entity.setCk_chushinJomyakuEiyo(rslt.get調査項目(ChosahyoItems.中心静脈栄養).get調査結果コード());
        entity.setCk_toseki(rslt.get調査項目(ChosahyoItems.透析).get調査結果コード());
        entity.setCk_stomaShochi(rslt.get調査項目(ChosahyoItems.ストーマの処置).get調査結果コード());
        entity.setCk_sansoRyoho(rslt.get調査項目(ChosahyoItems.酸素療法).get調査結果コード());
        entity.setCk_respirator(rslt.get調査項目(ChosahyoItems.レスピレーター).get調査結果コード());
        entity.setCk_kikanSekkai(rslt.get調査項目(ChosahyoItems.気管切開).get調査結果コード());
        entity.setCk_totsuKango(rslt.get調査項目(ChosahyoItems.疼痛の看護).get調査結果コード());
        entity.setCk_keikanEiyo(rslt.get調査項目(ChosahyoItems.経管栄養).get調査結果コード());
        entity.setCk_monitorSokutei(rslt.get調査項目(ChosahyoItems.モニター測定).get調査結果コード());
        entity.setCk_jokusoShochi(rslt.get調査項目(ChosahyoItems.じょくそうの処置).get調査結果コード());
        entity.setCk_catheter(rslt.get調査項目(ChosahyoItems.カテーテル).get調査結果コード());

        return entity;
    }

    private static NinteichosaResultOfChosahyo toNinteichosaResultChosahyo(
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
        return new NinteichosaResultOfChosahyo(
                new ShinseishoKanriNo(chosahyoEntity.getShinseishoKanriNo()), new NinteichosaIraiRirekiNo(chosahyoEntity.getNinteichosaRirekiNo()),
                NENDO_2006, new Ninteichosahyo(resultMap, ChosahyoItemGroup.Of2006.values()));
    }

    private static void setResultMap(
            Map<ChosahyoItems, NinteichosaItemResult> 調査結果Map, Ninteichosahyo 調査票, ChosahyoItems 調査票項目, RString 調査結果) {
        調査結果Map.put(調査票項目, new NinteichosaItemResult((NinteichosaItem) 調査票.get調査項目(調査票項目), 調査結果));
    }

    private static NinteichosaResultOfGaikyo toNinteichosaResultGaikyo(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultOfGaikyo(
                new ShinseishoKanriNo(entity.getShinseishoKanriNo()),
                new NinteichosaIraiRirekiNo(entity.getNinteichosaRirekiNo()),
                toNinteichosaResultGaikyoKihon(entity),
                toNinteichosaResultGaikyoService(entity));
    }

    private static NinteichosaResultOfGaikyoKihon toNinteichosaResultGaikyoKihon(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultOfGaikyoKihon(
                entity.getNinteichosaJisshiYMD(),
                ChosaIraiKubun.toValue(entity.getNinteichousaIraiKubunCode()),
                entity.getChosaJisshiBashoCode(),
                entity.getChosaJisshiBashoMeisho(),
                ChosaKubun.toValue(entity.getNinteiChosaKubunCode()),
                entity.getGaikyochosaTokkijiko(),
                ShinsakaiFuriwakeKubun.toValue(entity.getShinsakaiYusenWaritsukeKubunCode()));
    }

    private static NinteichosaResultOfGaikyoService toNinteichosaResultGaikyoService(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new NinteichosaResultOfGaikyoService(
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
