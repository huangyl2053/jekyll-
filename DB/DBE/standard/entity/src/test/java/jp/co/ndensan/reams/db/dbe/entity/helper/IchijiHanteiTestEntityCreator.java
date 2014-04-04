/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DentatsuNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KariIchijiHanteiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.NinchiNoryokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShokujiKoiHyokaKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.TankiKiokuKomoku;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5016IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.doReturn;

/**
 * 一次判定のテストで使用されるEntityを生成するクラスです。
 *
 * @author n8178 城間篤人
 */
public final class IchijiHanteiTestEntityCreator {

    private IchijiHanteiTestEntityCreator() {
    }

    /**
     * 一次判定結果Entityを生成して返します。
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity() {
        DbT5016IchijiHanteiKekkaJohoEntity entity = new DbT5016IchijiHanteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("01")));
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setKariIchijiHanteiKubun(KariIchijiHanteiKubun.本判定.is仮判定());
        entity.setIchijiHanteiYMD(new FlexibleDate("20060101"));
        entity.setIchijiHanteiKekkaCode(new Code("01"));
        entity.setIchijiHanteiKekkaNinchishoKasanCode(new Code("12"));
        entity.setKijunJikan(11);
        entity.setKijunJikanShokuji(12);
        entity.setKijunJikanHaisetsu(13);
        entity.setKijunJikanIdo(14);
        entity.setKijunJikanSeiketsuHoji(15);
        entity.setKijunJikanKansetsuCare(16);
        entity.setKijunJikanBPSDKanren(17);
        entity.setKijunJikanKinoKunren(18);
        entity.setKijunJikanIryoKanren(19);
        entity.setKijunJikanNinchishoKasan(20);
        entity.setChukanHyokaKomoku1gun(1);
        entity.setChukanHyokaKomoku2gun(2);
        entity.setChukanHyokaKomoku3gun(3);
        entity.setChukanHyokaKomoku4gun(4);
        entity.setChukanHyokaKomoku5gun(5);
        entity.setChukanHyokaKomoku6gun(6);
        entity.setChukanHyokaKomoku7gun(7);
        entity.setIchijiHnateiKeikokuCode(new RString("000111000111000111"));
        entity.setJotaiAnteiseiCode(new Code("3"));
        entity.setNinchishoJiritsudoIIijoNoGaizensei(new Decimal(12.34));
        entity.setSuiteiKyufuKubunCode(new Code("4"));
        entity.setNinchishoKoreishaShihyoCode(new Code("5"));
        entity.setJiiritsudoKumiawase1(21);
        entity.setJiiritsudoKumiawase2(22);
        entity.setJiiritsudoKumiawase3(23);
        entity.setJiiritsudoKumiawase4(24);
        entity.setJiiritsudoKumiawase5(25);
        entity.setJiiritsudoKumiawase6(26);
        entity.setJiiritsudoKumiawase7(27);
        entity.setGaizenseiHyokaCode(new Code("6"));
        entity.setGaizenseiHyokaPercent(48);
        entity.setIchijiHanteiSofuKubun(new RString("1"));
        entity.setIchijiHanteiKekkaSofuYMD(new FlexibleDate("20061231"));
        return entity;
    }

    /**
     * 一次判定結果Entityを生成して返します。(spy)
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy() {
        return set一次判定結果コードマスタ項目(create一次判定結果Entity());
    }

    private static DbT5016IchijiHanteiKekkaJohoEntity set一次判定結果コードマスタ項目(DbT5016IchijiHanteiKekkaJohoEntity entity) {
        entity = spy(entity);
        doReturn(new RString("meisho")).when(entity).getIchijiHanteiKekkaCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getIchijiHanteiKekkaNinchishoKasanCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getJotaiAnteiseiCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getSuiteiKyufuKubunCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getNinchishoKoreishaShihyoCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getGaizenseiHyokaCodeMeisho();
        doReturn(new RString("ryakusho")).when(entity).getIchijiHanteiKekkaCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getIchijiHanteiKekkaNinchishoKasanCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getJotaiAnteiseiCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getSuiteiKyufuKubunCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getNinchishoKoreishaShihyoCodeRyakusho();
        doReturn(new RString("ryakusho")).when(entity).getGaizenseiHyokaCodeRyakusho();
        return entity;
    }

    /**
     * 申請書管理番号を外部から指定して、一次判定結果Entityを生成して返します。
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = create一次判定結果Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        return entity;
    }

    /**
     * 申請書管理番号を外部から指定して、一次判定結果Entityを生成して返します。(Spy)
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy(String 申請書管理番号) {
        return (set一次判定結果コードマスタ項目(create一次判定結果Entity(申請書管理番号)));
    }

    /**
     * 申請書管理番号と仮一次判定フラグを外部から指定して、一次判定結果Entityを生成して返します。
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果Entity(String 申請書管理番号, boolean 仮一次判定フラグ) {
        DbT5016IchijiHanteiKekkaJohoEntity entity = create一次判定結果Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setKariIchijiHanteiKubun(仮一次判定フラグ);
        return entity;
    }

    /**
     * 申請書管理番号と仮一次判定フラグを外部から指定して、一次判定結果Entityを生成して返します。(Spy)
     *
     * @return 一次判定結果Entity
     */
    public static DbT5016IchijiHanteiKekkaJohoEntity create一次判定結果EntitySpy(String 申請書管理番号, boolean 仮一次判定フラグ) {
        return set一次判定結果コードマスタ項目(create一次判定結果Entity(申請書管理番号, 仮一次判定フラグ));
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity() {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setIk_seikatsuJiritsudoShyogaiCode(new Code("9"));
        entity.setIk_seikatsuJiritsudoNinchshoCode(new Code("8"));
        entity.setIk_chukakuShojoTankiKioku(TankiKiokuKomoku.問題あり.get項目コード());
        entity.setIk_chukakuShojoNinchiNoryoku(NinchiNoryokuKomoku.判断できない.get項目コード());
        entity.setIk_chukakuShojoDentatsuNoryoku(DentatsuNoryokuKomoku.具体的要求に限られる.get項目コード());
        entity.setIk_shokuseikatsuShokujiKoi(ShokujiKoiHyokaKomoku.自立ないし何とか自分で食べられる.get項目コード());
        return entity;
    }

    /**
     * 主治医意見書詳細情報Entityの中で、一次判定処理に使用される主治医意見書5項目の要素を持ったEntityを返します。(Spy)
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目EntitySpy() {
        return set主治医意見書コードマスタ項目(create主治医意見書5項目Entity());
    }

    private static DbT5013ShujiiIkenshoShosaiJohoEntity set主治医意見書コードマスタ項目(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        entity = spy(entity);
        doReturn(new RString("meisho")).when(entity).getIk_seikatsuJiritsudoShyogaiCodeMeisho();
        doReturn(new RString("meisho")).when(entity).getIk_seikatsuJiritsudoNinchshoCodeMeisho();
        doReturn(new RString("ryakujo")).when(entity).getIk_seikatsuJiritsudoShyogaiCodeRyakusho();
        doReturn(new RString("ryakujo")).when(entity).getIk_seikatsuJiritsudoNinchshoCodeRyakusho();
        return entity;
    }

    /**
     * 申請書管理番号と履歴番号を指定し、一次判定で使用される主治医意見書詳細情報Entityを生成して返します。
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity(String 申請書管理番号, int 履歴番号) {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = create主治医意見書5項目Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setIkenshoIraiRirekiNo(履歴番号);
        return entity;
    }

    /**
     * 主治医意見書5項目回答結果の数列を指定して、その情報を元に主治医意見書詳細情報Entityを生成します。
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目Entity(String 回答結果数列) {
        RString 回答結果 = new RString(回答結果数列);
        回答結果 = 回答結果.padZeroToLeft(5);

        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setIk_seikatsuJiritsudoShyogaiCode(new Code("9"));
        entity.setIk_seikatsuJiritsudoNinchshoCode(new Code(回答結果.stringAt(0)));
        entity.setIk_chukakuShojoTankiKioku(TankiKiokuKomoku.toValue(回答結果.stringAt(1)).get項目コード());
        entity.setIk_chukakuShojoNinchiNoryoku(NinchiNoryokuKomoku.toValue(回答結果.stringAt(2)).get項目コード());
        entity.setIk_chukakuShojoDentatsuNoryoku(DentatsuNoryokuKomoku.toValue(回答結果.stringAt(3)).get項目コード());
        entity.setIk_shokuseikatsuShokujiKoi(ShokujiKoiHyokaKomoku.toValue(回答結果.stringAt(4)).get項目コード());

        return entity;
    }

    /**
     * 主治医意見書5項目回答結果の数列を指定して、その情報を元に主治医意見書詳細情報Entityを生成します。(Spy)
     *
     * @return 主治医意見書詳細情報Entity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity create主治医意見書5項目EntitySpy(String 回答結果数列) {
        return set主治医意見書コードマスタ項目(create主治医意見書5項目Entity(回答結果数列));
    }

    /**
     * 認定調査票Entityを生成して返します。
     *
     * @return 認定調査票Entity
     */
    public static DbT5009NinteichosahyoJohoEntity create認定調査票Entity() {
        DbT5009NinteichosahyoJohoEntity entity = new DbT5009NinteichosahyoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("01")));
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V02A.getCode());
        entity.setNinteichosaRirekiNo(1);
        entity.setCk_mahiHidariJoshi(new RString("2"));
        entity.setCk_mahiMigiJoshi(new RString("2"));
        entity.setCk_mahiHidariKashi(new RString("2"));
        entity.setCk_mahiMigiKashi(new RString("2"));
        entity.setCk_mahiSonota(new RString("2"));
        entity.setCk_koshukuKata(new RString("1"));
        entity.setCk_koshukuHiji(new RString("1"));
        entity.setCk_koshukuMata(new RString("1"));
        entity.setCk_koshukuHiza(new RString("1"));
        entity.setCk_koshukuAshi(new RString("1"));
        entity.setCk_koshukuSonota(new RString("2"));
        entity.setCk_negaeri(new RString("2"));
        entity.setCk_okiagari(new RString("2"));
        entity.setCk_zaihoji(new RString("2"));
        entity.setCk_hisetchiZaihoji(new RString("2"));
        entity.setCk_ryoashiRitsui(new RString("1"));
        entity.setCk_hoko(new RString("1"));
        entity.setCk_tachiagari(new RString("1"));
        entity.setCk_kataashiRitsui(new RString("1"));
        entity.setCk_yokusoDeiri(new RString("1"));
        entity.setCk_senshin(new RString("2"));
        entity.setCk_jokuso(new RString("2"));
        entity.setCk_sonotaHihushikkan(new RString("2"));
        entity.setCk_katateMunamotoage(new RString("2"));
        entity.setCk_tumekiri(new RString("2"));
        entity.setCk_shiryoku(new RString("3"));
        entity.setCk_choryoku(new RString("3"));
        entity.setCk_ijo(new RString("3"));
        entity.setCk_ido(new RString("3"));
        entity.setCk_enge(new RString("3"));
        entity.setCk_shokujiSesshu(new RString("1"));
        entity.setCk_insui(new RString("1"));
        entity.setCk_hainyo(new RString("1"));
        entity.setCk_haiben(new RString("1"));
        entity.setCk_nyoi(new RString("1"));
        entity.setCk_beni(new RString("2"));
        entity.setCk_hainyogoShimatsu(new RString("2"));
        entity.setCk_haibengoShimatsu(new RString("2"));
        entity.setCk_kokoSeiketsu(new RString("2"));
        entity.setCk_sengan(new RString("2"));
        entity.setCk_seihatsu(new RString("3"));
        entity.setCk_buttonKakehazushi(new RString("3"));
        entity.setCk_joiChakudatsu(new RString("3"));
        entity.setCk_zubonChakudatsu(new RString("3"));
        entity.setCk_kutsushitaChakudatsu(new RString("3"));
        entity.setCk_koshitsuSeiso(new RString("4"));
        entity.setCk_gaishutsuHindo(new RString("4"));
        entity.setCk_ishiDentatsu(new RString("4"));
        entity.setCk_hanno(new RString("4"));
        entity.setCk_nikka(new RString("4"));
        entity.setCk_seinengappi(new RString("1"));
        entity.setCk_tankiKioku(new RString("1"));
        entity.setCk_namae(new RString("1"));
        entity.setCk_kisetsu(new RString("1"));
        entity.setCk_basho(new RString("1"));
        entity.setCk_haikai(new RString("2"));
        entity.setCk_gaishutsu(new RString("2"));
        entity.setCk_higaiteki(new RString("2"));
        entity.setCk_sakuwa(new RString("2"));
        entity.setCk_genshiGencho(new RString("2"));
        entity.setCk_kanjoHuantei(new RString("3"));
        entity.setCk_chuyaGyakuten(new RString("3"));
        entity.setCk_bogenBoko(new RString("3"));
        entity.setCk_onajiHanashi(new RString("3"));
        entity.setCk_ogoe(new RString("3"));
        entity.setCk_kaigoNiTeiko(new RString("4"));
        entity.setCk_ochitsuki(new RString("4"));
        entity.setCk_hitoriDeDetagaru(new RString("4"));
        entity.setCk_shushuheki(new RString("4"));
        entity.setCk_hiNoHushimatsu(new RString("4"));
        entity.setCk_monoYaIruiWoKowasu(new RString("5"));
        entity.setCk_huketsuKoi(new RString("5"));
        entity.setCk_ishokuKodo(new RString("5"));
        entity.setCk_hidoiMonowasure(new RString("5"));
        entity.setCk_seitekiMeiwakuKoi(new RString("5"));
        entity.setCk_hitorigotoHitoriwarai(new RString("1"));
        entity.setCk_jibunKatte(new RString("1"));
        entity.setCk_hanashiGaMatomaranai(new RString("1"));
        entity.setCk_kusuri(new RString("1"));
        entity.setCk_kinsenKanri(new RString("1"));
        entity.setCk_ishiKettei(new RString("2"));
        entity.setCk_mukanshin(new RString("2"));
        entity.setCk_shudanHutekio(new RString("2"));
        entity.setCk_denwa(new RString("2"));
        entity.setCk_kaimono(new RString("2"));
        entity.setCk_chori(new RString("3"));
        entity.setCk_tenteki(new RString("3"));
        entity.setCk_chushinJomyakuEiyo(new RString("3"));
        entity.setCk_toseki(new RString("3"));
        entity.setCk_stomaShochi(new RString("3"));
        entity.setCk_sansoRyoho(new RString("4"));
        entity.setCk_respirator(new RString("4"));
        entity.setCk_kikanSekkai(new RString("4"));
        entity.setCk_totsuKango(new RString("4"));
        entity.setCk_keikanEiyo(new RString("4"));
        entity.setCk_monitorSokutei(new RString("5"));
        entity.setCk_jokusoShochi(new RString("5"));
        entity.setCk_catheter(new RString("5"));
        entity.setCk_nitchuNoSeikatsuNiTsuite(new RString("5"));
        entity.setCk_gaishutsuHindoNiTsuite(new RString("5"));
        entity.setCk_jokyoHenka(new RString("6"));
        return entity;
    }

    /**
     * 申請書管理番号と履歴番号を指定して、認定調査票Entityを生成して返します。
     *
     * @return 認定調査票Entity
     */
    public static DbT5009NinteichosahyoJohoEntity create認定調査票Entity(String 申請書管理番号, int 履歴番号) {
        DbT5009NinteichosahyoJohoEntity entity = create認定調査票Entity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString(申請書管理番号)));
        entity.setNinteichosaRirekiNo(履歴番号);
        return entity;
    }
}
