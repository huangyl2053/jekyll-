/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.mapper;

import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyo;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaGaikyoService;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihonJiritsu;
import jp.co.ndensan.reams.db.dbe.business.NinteichosaKekka;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon1;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon2;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon3;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon4;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihon5;
import jp.co.ndensan.reams.db.dbe.business.ChosaKekkaKihonIryo;
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
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5010NinteiChosaTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;

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
        DbT5008NinteichosaKekkaJohoEntity entity = new DbT5008NinteichosaKekkaJohoEntity();

        ChosaKekkaGaikyoKihon kihon = ninteichosaKekka.get概況情報().get基本情報();
        ChosaKekkaGaikyoService service = ninteichosaKekka.get概況情報().getサービス状況();
        ChosaKekkaKihonJiritsu jiritsu = ninteichosaKekka.get基本情報().get自立度情報();

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
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(jiritsu.get認知症高齢者の日常生活自立度().getCode());
        entity.setShogaiNichijoSeikatsuJiritsudoCode(jiritsu.get障害高齢者の日常生活自立度().getCode());
        entity.setShinsakaiYusenWaritsukeKubunCode(kihon.get審査会優先振分区分().getCode());

        return entity;
    }

    /**
     * 引数の認定調査結果情報から認定調査票情報エンティティを作成して返します。
     *
     * @param ninteichosaKekka 認定調査結果情報
     * @return 認定調査票情報エンティティ
     */
    public static DbT5009NinteichosahyoJohoEntity toDbT5009NinteichosahyoJohoEntity(NinteichosaKekka ninteichosaKekka) {
        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();

        entity.setShinseishoKanriNo(ninteichosaKekka.get申請書管理番号().getValue());
        entity.setNinteichosaRirekiNo(ninteichosaKekka.get要介護認定調査履歴番号());

        ChosaKekkaKihon1 kihon1 = ninteichosaKekka.get基本情報().get基本情報1();
        entity.setCk_mahiHidariJoshi(kihon1.get麻痺左上肢().getCode());
        entity.setCk_mahiMigiJoshi(kihon1.get麻痺右上肢().getCode());
        entity.setCk_mahiHidariKashi(kihon1.get麻痺左下肢().getCode());
        entity.setCk_mahiMigiKashi(kihon1.get麻痺右下肢().getCode());
        entity.setCk_mahiSonota(kihon1.get麻痺その他().getCode());
        entity.setCk_koshukuKata(kihon1.get拘縮肩関節().getCode());
        entity.setCk_koshukuMata(kihon1.get拘縮股関節().getCode());
        entity.setCk_koshukuHiza(kihon1.get拘縮膝関節().getCode());
        entity.setCk_koshukuSonota(kihon1.get拘縮その他().getCode());
        entity.setCk_negaeri(kihon1.get寝返り().getCode());
        entity.setCk_okiagari(kihon1.get起き上がり().getCode());
        entity.setCk_zaihoji(kihon1.get座位保持().getCode());
        entity.setCk_ryoashiRitsui(kihon1.get両足での立位().getCode());
        entity.setCk_hoko(kihon1.get歩行().getCode());
        entity.setCk_tachiagari(kihon1.get立ち上がり().getCode());
        entity.setCk_kataashiRitsui(kihon1.get片足での立位().getCode());
        entity.setCk_senshin(kihon1.get洗身().getCode());
        entity.setCk_tumekiri(kihon1.getつめ切り().getCode());
        entity.setCk_shiryoku(kihon1.get視力().getCode());
        entity.setCk_choryoku(kihon1.get聴力().getCode());

        ChosaKekkaKihon2 kihon2 = ninteichosaKekka.get基本情報().get基本情報2();
        entity.setCk_ijo(kihon2.get移乗().getCode());
        entity.setCk_ido(kihon2.get移動().getCode());
        entity.setCk_enge(kihon2.get嚥下().getCode());
        entity.setCk_shokujiSesshu(kihon2.get食事摂取().getCode());
        entity.setCk_hainyo(kihon2.get排尿().getCode());
        entity.setCk_haiben(kihon2.get排便().getCode());
        entity.setCk_kokoSeiketsu(kihon2.get口腔清潔().getCode());
        entity.setCk_sengan(kihon2.get洗顔().getCode());
        entity.setCk_seihatsu(kihon2.get整髪().getCode());
        entity.setCk_joiChakudatsu(kihon2.get上衣の着脱().getCode());
        entity.setCk_zubonChakudatsu(kihon2.getズボン等の着脱().getCode());
        entity.setCk_gaishutsuHindo(kihon2.get外出頻度().getCode());

        ChosaKekkaKihon3 kihon3 = ninteichosaKekka.get基本情報().get基本情報3();
        entity.setCk_ishiDentatsu(kihon3.get意思の伝達().getCode());
        entity.setCk_nikka(kihon3.get毎日の日課を理解().getCode());
        entity.setCk_seinengappi(kihon3.get生年月日をいう().getCode());
        entity.setCk_tankiKioku(kihon3.get短期記憶().getCode());
        entity.setCk_namae(kihon3.get自分の名前をいう().getCode());
        entity.setCk_kisetsu(kihon3.get今の季節を理解().getCode());
        entity.setCk_basho(kihon3.get場所の理解().getCode());
        entity.setCk_haikai(kihon3.get徘徊().getCode());
        entity.setCk_gaishutsu(kihon3.get外出して戻れない().getCode());

        ChosaKekkaKihon4 kihon4 = ninteichosaKekka.get基本情報().get基本情報4();
        entity.setCk_higaiteki(kihon4.get被害的().getCode());
        entity.setCk_sakuwa(kihon4.get作話().getCode());
        entity.setCk_kanjoHuantei(kihon4.get感情が不安定().getCode());
        entity.setCk_chuyaGyakuten(kihon4.get昼夜逆転().getCode());
        entity.setCk_onajiHanashi(kihon4.get同じ話をする().getCode());
        entity.setCk_ogoe(kihon4.get大声を出す().getCode());
        entity.setCk_kaigoNiTeiko(kihon4.get介護に抵抗().getCode());
        entity.setCk_ochitsuki(kihon4.get落ち着きなし().getCode());
        entity.setCk_hitoriDeDetagaru(kihon4.get一人で出たがる().getCode());
        entity.setCk_shushuheki(kihon4.get収集癖().getCode());
        entity.setCk_monoYaIruiWoKowasu(kihon4.get物や衣類を壊す().getCode());
        entity.setCk_hidoiMonowasure(kihon4.getひどい物忘れ().getCode());
        entity.setCk_hitorigotoHitoriwarai(kihon4.get独り言独り笑い().getCode());
        entity.setCk_jibunKatte(kihon4.get自分勝手に行動する().getCode());
        entity.setCk_hanashiGaMatomaranai(kihon4.get話がまとまらない().getCode());

        ChosaKekkaKihon5 kihon5 = ninteichosaKekka.get基本情報().get基本情報5();
        entity.setCk_kusuri(kihon5.get薬の内服().getCode());
        entity.setCk_kinsenKanri(kihon5.get金銭の管理().getCode());
        entity.setCk_ishiKettei(kihon5.get日常の意思決定().getCode());
        entity.setCk_shudanHutekio(kihon5.get集団への不適応().getCode());
        entity.setCk_kaimono(kihon5.get買い物().getCode());
        entity.setCk_chori(kihon5.get簡単な調理().getCode());

        ChosaKekkaKihonIryo iryo = ninteichosaKekka.get基本情報().get特別医療情報();
        entity.setCk_tenteki(iryo.get点滴の管理().getCode());
        entity.setCk_chushinJomyakuEiyo(iryo.get中心静脈栄養().getCode());
        entity.setCk_toseki(iryo.get透析().getCode());
        entity.setCk_stomaShochi(iryo.getストーマの処置().getCode());
        entity.setCk_sansoRyoho(iryo.get酸素療法().getCode());
        entity.setCk_respirator(iryo.getレスピレーター().getCode());
        entity.setCk_kikanSekkai(iryo.get気管切開の処置().getCode());
        entity.setCk_totsuKango(iryo.get疼痛の看護().getCode());
        entity.setCk_keikanEiyo(iryo.get経管栄養().getCode());
        entity.setCk_monitorSokutei(iryo.getモニター測定().getCode());
        entity.setCk_jokusoShochi(iryo.getじょくそうの処置().getCode());
        entity.setCk_catheter(iryo.getカテーテル().getCode());

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

    private static ChosaKekkaKihon toChosaKekkaKihon(
            DbT5008NinteichosaKekkaJohoEntity chosaKekkaEntity,
            DbT5009NinteichosahyoJohoEntity chosahyoEntity) {
        return new ChosaKekkaKihon(
                toChosaKekkaKihon1(chosahyoEntity),
                toChosaKekkaKihon2(chosahyoEntity),
                toChosaKekkaKihon3(chosahyoEntity),
                toChosaKekkaKihon4(chosahyoEntity),
                toChosaKekkaKihon5(chosahyoEntity),
                toChosaKekkaKihonIryo(chosahyoEntity),
                toChosaKekkaKihonJiritsu(chosaKekkaEntity));
    }

    private static ChosaKekkaKihon1 toChosaKekkaKihon1(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihon1(
                ChosaKekkaKubun1.MahiHidariJoshi.toValue(entity.getCk_mahiHidariJoshi()),
                ChosaKekkaKubun1.MahiMigiJoshi.toValue(entity.getCk_mahiMigiJoshi()),
                ChosaKekkaKubun1.MahiHidariKashi.toValue(entity.getCk_mahiHidariKashi()),
                ChosaKekkaKubun1.MahiMigiKashi.toValue(entity.getCk_mahiMigiKashi()),
                ChosaKekkaKubun1.MahiSonota.toValue(entity.getCk_mahiSonota()),
                ChosaKekkaKubun1.KoshukuKata.toValue(entity.getCk_koshukuKata()),
                ChosaKekkaKubun1.KoshukuMata.toValue(entity.getCk_koshukuMata()),
                ChosaKekkaKubun1.KoshukuHiza.toValue(entity.getCk_koshukuHiza()),
                ChosaKekkaKubun1.KoshukuSonota.toValue(entity.getCk_koshukuSonota()),
                ChosaKekkaKubun1.Negaeri.toValue(entity.getCk_negaeri()),
                ChosaKekkaKubun1.Okiagari.toValue(entity.getCk_okiagari()),
                ChosaKekkaKubun1.Zaihoji.toValue(entity.getCk_zaihoji()),
                ChosaKekkaKubun1.RyoashiRitsui.toValue(entity.getCk_ryoashiRitsui()),
                ChosaKekkaKubun1.Hoko.toValue(entity.getCk_hoko()),
                ChosaKekkaKubun1.Tachiagari.toValue(entity.getCk_tachiagari()),
                ChosaKekkaKubun1.KataashiRitsui.toValue(entity.getCk_kataashiRitsui()),
                ChosaKekkaKubun1.Senshin.toValue(entity.getCk_senshin()),
                ChosaKekkaKubun1.Tsumekiri.toValue(entity.getCk_tumekiri()),
                ChosaKekkaKubun1.Shiryoku.toValue(entity.getCk_shiryoku()),
                ChosaKekkaKubun1.Choryoku.toValue(entity.getCk_choryoku()));
    }

    private static ChosaKekkaKihon2 toChosaKekkaKihon2(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihon2(
                ChosaKekkaKubun2.Ijo.toValue(entity.getCk_ijo()),
                ChosaKekkaKubun2.Ido.toValue(entity.getCk_ido()),
                ChosaKekkaKubun2.Enge.toValue(entity.getCk_enge()),
                ChosaKekkaKubun2.ShokujiSesshu.toValue(entity.getCk_shokujiSesshu()),
                ChosaKekkaKubun2.Hainyo.toValue(entity.getCk_hainyo()),
                ChosaKekkaKubun2.Haiben.toValue(entity.getCk_haiben()),
                ChosaKekkaKubun2.KokoSeiketsu.toValue(entity.getCk_kokoSeiketsu()),
                ChosaKekkaKubun2.Sengan.toValue(entity.getCk_sengan()),
                ChosaKekkaKubun2.Seihatsu.toValue(entity.getCk_seihatsu()),
                ChosaKekkaKubun2.JoiChakudatsu.toValue(entity.getCk_joiChakudatsu()),
                ChosaKekkaKubun2.ZubonChakudatsu.toValue(entity.getCk_zubonChakudatsu()),
                ChosaKekkaKubun2.GaishutsuHindo.toValue(entity.getCk_gaishutsuHindo()));
    }

    private static ChosaKekkaKihon3 toChosaKekkaKihon3(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihon3(
                ChosaKekkaKubun3.IshiDentatsu.toValue(entity.getCk_ishiDentatsu()),
                ChosaKekkaKubun3.Nikka.toValue(entity.getCk_nikka()),
                ChosaKekkaKubun3.Seinengappi.toValue(entity.getCk_seinengappi()),
                ChosaKekkaKubun3.TankiKioku.toValue(entity.getCk_tankiKioku()),
                ChosaKekkaKubun3.Namae.toValue(entity.getCk_namae()),
                ChosaKekkaKubun3.Kisetsu.toValue(entity.getCk_kisetsu()),
                ChosaKekkaKubun3.Basho.toValue(entity.getCk_basho()),
                ChosaKekkaKubun3.Haikai.toValue(entity.getCk_haikai()),
                ChosaKekkaKubun3.Gaishutsu.toValue(entity.getCk_gaishutsu()));
    }

    private static ChosaKekkaKihon4 toChosaKekkaKihon4(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihon4(
                ChosaKekkaKubun4.Higaiteki.toValue(entity.getCk_higaiteki()),
                ChosaKekkaKubun4.Sakuwa.toValue(entity.getCk_sakuwa()),
                ChosaKekkaKubun4.KanjoHuantei.toValue(entity.getCk_kanjoHuantei()),
                ChosaKekkaKubun4.ChuyaGyakuten.toValue(entity.getCk_chuyaGyakuten()),
                ChosaKekkaKubun4.OnajiHanashi.toValue(entity.getCk_onajiHanashi()),
                ChosaKekkaKubun4.Ogoe.toValue(entity.getCk_ogoe()),
                ChosaKekkaKubun4.KaigoNiTeiko.toValue(entity.getCk_kaigoNiTeiko()),
                ChosaKekkaKubun4.Ochitsuki.toValue(entity.getCk_ochitsuki()),
                ChosaKekkaKubun4.HitoriDeDetagaru.toValue(entity.getCk_hitoriDeDetagaru()),
                ChosaKekkaKubun4.Shushuheki.toValue(entity.getCk_shushuheki()),
                ChosaKekkaKubun4.MonoYaIruiWoKowasu.toValue(entity.getCk_monoYaIruiWoKowasu()),
                ChosaKekkaKubun4.HidoiMonowasure.toValue(entity.getCk_hidoiMonowasure()),
                ChosaKekkaKubun4.HitorigotoHitoriwarai.toValue(entity.getCk_hitorigotoHitoriwarai()),
                ChosaKekkaKubun4.JibunKatte.toValue(entity.getCk_jibunKatte()),
                ChosaKekkaKubun4.HanashiGaMatomaranai.toValue(entity.getCk_hanashiGaMatomaranai()));
    }

    private static ChosaKekkaKihon5 toChosaKekkaKihon5(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihon5(
                ChosaKekkaKubun5.Kusuri.toValue(entity.getCk_kusuri()),
                ChosaKekkaKubun5.KinsenKanri.toValue(entity.getCk_kinsenKanri()),
                ChosaKekkaKubun5.IshiKettei.toValue(entity.getCk_ishiKettei()),
                ChosaKekkaKubun5.ShudanFutekio.toValue(entity.getCk_shudanHutekio()),
                ChosaKekkaKubun5.Kaimono.toValue(entity.getCk_kaimono()),
                ChosaKekkaKubun5.Chori.toValue(entity.getCk_chori()));
    }

    private static ChosaKekkaKihonIryo toChosaKekkaKihonIryo(DbT5009NinteichosahyoJohoEntity entity) {
        return new ChosaKekkaKihonIryo(
                ChosaKekkaKubunIryo.Tenteki.toValue(entity.getCk_tenteki()),
                ChosaKekkaKubunIryo.ChushinJomyakuEiyo.toValue(entity.getCk_chushinJomyakuEiyo()),
                ChosaKekkaKubunIryo.Toseki.toValue(entity.getCk_toseki()),
                ChosaKekkaKubunIryo.StomaShochi.toValue(entity.getCk_stomaShochi()),
                ChosaKekkaKubunIryo.SansoRyoho.toValue(entity.getCk_sansoRyoho()),
                ChosaKekkaKubunIryo.Respirator.toValue(entity.getCk_respirator()),
                ChosaKekkaKubunIryo.KikanSekkai.toValue(entity.getCk_kikanSekkai()),
                ChosaKekkaKubunIryo.TotsuKango.toValue(entity.getCk_totsuKango()),
                ChosaKekkaKubunIryo.KeikanEiyo.toValue(entity.getCk_keikanEiyo()),
                ChosaKekkaKubunIryo.MonitorSokutei.toValue(entity.getCk_monitorSokutei()),
                ChosaKekkaKubunIryo.JokusoShochi.toValue(entity.getCk_jokusoShochi()),
                ChosaKekkaKubunIryo.Catheter.toValue(entity.getCk_catheter()));
    }

    private static ChosaKekkaKihonJiritsu toChosaKekkaKihonJiritsu(DbT5008NinteichosaKekkaJohoEntity entity) {
        return new ChosaKekkaKihonJiritsu(
                ChosaKekkaKubunJiritsu.NinchishoNichijoSeikatsu.toValue(entity.getNinchishoNichijoSeikatsuJiritsudoCode()),
                ChosaKekkaKubunJiritsu.ShogaiNichijoSeikatsu.toValue(entity.getShogaiNichijoSeikatsuJiritsudoCode()));
    }
}
