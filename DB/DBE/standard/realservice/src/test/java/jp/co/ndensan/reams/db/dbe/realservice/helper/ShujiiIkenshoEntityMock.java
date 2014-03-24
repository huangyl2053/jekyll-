/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.realservice.helper;

import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoIraiKubun;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiKaisu;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.ShujiiIkenshoSakuseiryoShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.KoroshoIFKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.relate.ShujiiIkenshoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static jp.co.ndensan.reams.db.dbe.definition.ninteichosa.enumeratedtype.Choice.*;
import static org.mockito.Mockito.spy;

/**
 * ShujiiIkenshoEntityを生成するMockです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoEntityMock {

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private ShujiiIkenshoEntityMock() {
    }

    /**
     * ShujiiIkenshoEntityを生成して返します。
     *
     * @return ShujiiIkenshoEntity
     */
    public static ShujiiIkenshoEntity getSpiedShujiiIkenshoEntityInstance() {
        return spy(getShujiiIkenshoEntity());
    }

    /**
     * ShujiiIkenshoEntityを生成して返します。
     *
     * @return ShujiiIkenshoEntity
     */
    public static ShujiiIkenshoEntity getShujiiIkenshoEntity() {
        ShujiiIkenshoEntity entity = new ShujiiIkenshoEntity();
        entity.setDbT5012ShujiiIkenshoJohoEntity(getDbT5012ShujiiIkenshoJohoEntity());
        entity.setDbT5013ShujiiIkenshoShosaiJohoEntity(getDbT5013ShujiiIkenshoShosaiJohoEntity());
        return entity;
    }

    /**
     * DbT5012ShujiiIkenshoJohoEntityを生成して返します。
     *
     * @return DbT5012ShujiiIkenshoJohoEntity
     */
    public static DbT5012ShujiiIkenshoJohoEntity getSpiedDbT5012ShujiiIkenshoJohoEntityInstance() {
        return spy(getDbT5012ShujiiIkenshoJohoEntity());
    }

    /**
     * DbT5012ShujiiIkenshoJohoEntityを生成して返します。
     *
     * @return DbT5012ShujiiIkenshoJohoEntity
     */
    public static DbT5012ShujiiIkenshoJohoEntity getDbT5012ShujiiIkenshoJohoEntity() {
        DbT5012ShujiiIkenshoJohoEntity entity = new DbT5012ShujiiIkenshoJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1234567890")));
        entity.setIkenshoIraiKubun(ShujiiIkenshoIraiKubun.初回.getCode());
        entity.setIkenshoIraiRirekiNo(0);
        entity.setShujiiIryoKikanCode(new RString("1234567890"));
        entity.setShujiiCode(new RString("12345678"));
        entity.setIkenshoJuryoYMD(new FlexibleDate("20140101"));
        entity.setIkenshoKinyuYMD(new FlexibleDate("20140202"));
        entity.setIkenshoSakuseiKaisu(ShujiiIkenshoSakuseiKaisu.二回目以上.getCode());
        entity.setIkenshoSakuseiryoShubetsu(ShujiiIkenshoSakuseiryoShubetsu.施設.getCode());
        entity.setNinteiJohoTeikyoKiboFlag(true);
        entity.setIkenshoDoiUmuFlag(false);
        return entity;
    }

    /**
     * DbT5013ShujiiIkenshoShosaiJohoEntityを生成して返します。
     *
     * @return DbT5013ShujiiIkenshoShosaiJohoEntity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity getSpiedDbT5013ShujiiIkenshoShosaiJohoEntityInstance() {
        return spy(getDbT5013ShujiiIkenshoShosaiJohoEntity());
    }

    /**
     * DbT5013ShujiiIkenshoShosaiJohoEntityを生成して返します。
     *
     * @return DbT5013ShujiiIkenshoShosaiJohoEntity
     */
    public static DbT5013ShujiiIkenshoShosaiJohoEntity getDbT5013ShujiiIkenshoShosaiJohoEntity() {
        DbT5013ShujiiIkenshoShosaiJohoEntity entity = new DbT5013ShujiiIkenshoShosaiJohoEntity();
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(new RString("1234567890")));
        entity.setIkenshoIraiRirekiNo(0);
        entity.setKoroshoIfShikibetsuCode(KoroshoIFKubun.V09A.getCode());
        entity.setSaishuShinryoYMD(new FlexibleDate("20141231"));
        entity.setTakaJushinUmuKubun(true);
        entity.setNaiKaJushinUmuKubun(false);
        entity.setSeishinKaJushinUmuKubun(true);
        entity.setGeKaJushinUmuKubun(false);
        entity.setSeikeigeKaJushinUmuKubun(true);
        entity.setNoushinkeigeKaJushinUmuKubun(false);
        entity.setHifuKaJushinUmuKubun(true);
        entity.setHinyokiKaJushinUmuKubun(false);
        entity.setFujinKaJushinUmuKubun(true);
        entity.setJibiinkoKaJushinUmuKubun(false);
        entity.setRehabilitationKaJushinUmuKubun(true);
        entity.setShiKaJushinUmuKubun(false);
        entity.setGanKaJushinUmuKubun(true);
        entity.setSonotaJushinKaUmuKubun(false);
        entity.setSonotaJushinKaShimei(new RString("その他受診科名"));
        entity.setIk_shindamMei1(new RString("診断名1"));
        entity.setIk_hasshoYMD1(new FlexibleDate("20140101"));
        entity.setIk_shindamMei2(new RString("診断名2"));
        entity.setIk_hasshoYMD2(new FlexibleDate("20140202"));
        entity.setIk_shindamMei3(new RString("診断名3"));
        entity.setIk_hasshoYMD3(new FlexibleDate("20140303"));
        entity.setIk_anteisei(Antei.安定.getCode());
        entity.setIk_anteiseiHuanteiJokyo(new RString("具体的な状況"));
        entity.setIk_chiryoNaiyo(new RString("治療内容"));
        entity.setIk_tokubetsuIryoTentekiUmuKubun(true);
        entity.setIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun(false);
        entity.setIk_tokubetsuIryoTosekiUmuKubun(true);
        entity.setIk_tokubetsuIryoStomaShochiUmuKubun(false);
        entity.setIk_tokubetsuIryoSansoRyohoUmuKubun(true);
        entity.setIk_tokubetsuIryoRespiratorUmuKubun(false);
        entity.setIk_tokubetsuIryoKikanSekkaiUmuKubun(true);
        entity.setIk_tokubetsuIryoTotsuKangoUmuKubun(false);
        entity.setIk_tokubetsuIryoKeikanEiyoUmuKubun(true);
        entity.setIk_tokubetsuIryoMonitorSokuteiUmuKubun(false);
        entity.setIk_tokubetsuIryoJokusoShochiUmuKubun(true);
        entity.setIk_tokubetsuIryoCatheterUmuKubun(false);
        entity.setIk_seikatsuJiritsudoShyogaiCode(new Code(ShogaiJiritsu.Ａ１.getCode()));
        entity.setIk_seikatsuJiritsudoNinchshoCode(new Code(NinchishoJiritsu.Ⅱａ.getCode()));
        entity.setIk_chukakuShojoTankiKioku(MondaiNashiAri.問題なし.getCode());
        entity.setIk_chukakuShojoNinchiNoryoku(Ninchi.見守りが必要.getCode());
        entity.setIk_chukakuShojoDentatsuNoryoku(Dentatsu.いくらか困難.getCode());
        entity.setIk_shuhenShojoUmuKubun(false);
        entity.setIk_shuhenShojoGenshiGenchoUmuKubun(true);
        entity.setIk_shuhenShojoMosoUmuKubun(false);
        entity.setIk_shuhenShojoChuyaGakutenUmuKubun(true);
        entity.setIk_shuhenShojoBogenUmuKubun(false);
        entity.setIk_shuhenShojoBokoUmuKubun(true);
        entity.setIk_shuhenShojoKaigoHenoTeikoUmuKubun(false);
        entity.setIk_shuhenShojoHaikaiUmuKubun(true);
        entity.setIk_shuhenShojoHiNoFushimatsuUmuKubun(false);
        entity.setIk_shuhenShojoFuketsuKoiUmuKubun(true);
        entity.setIk_shuhenShojoIshokuKodoUmuKubun(false);
        entity.setIk_shuhenShojoSeitekiMondaiKodoUmuKubun(true);
        entity.setIk_shuhenShojoSonotaUmuKubun(false);
        entity.setIk_shuhenShojoSonotaNaiyo(new RString("認知症_その他内容"));
        entity.setIk_seishinOrShinkeiShojoUmuKubun(true);
        entity.setIk_seishinOrShinkeiShojoShimei(new RString("精神_神経症状名"));
        entity.setIk_semmonkaiJushinUmuKubun(false);
        entity.setIk_semmonkaiJushin(new RString("専門科医受診内容"));
        entity.setIk_kikiudeKubun(MigiHidari.右.getCode());
        entity.setIk_shincho(160);
        entity.setIk_taiju(50);
        entity.setIk_taijuHenka(ZokaGensho.維持.getCode());
        entity.setIk_shishiKessonUmuKubun(true);
        entity.setIk_shishiKessonBui(new RString("四肢欠損部位"));
        entity.setIk_shishiKessonTeido(Teido.中.getCode());
        entity.setIk_mahiUmuKubun(true);
        entity.setIk_mahiTeido(Teido.重.getCode());
        entity.setIk_mahiHidariJoshi(Checked.有り.getCode());
        entity.setIk_mahiMigiJoshi(Checked.無し.getCode());
        entity.setIk_mahiHidariKashi(Checked.有り.getCode());
        entity.setIk_mahiMigiKashi(Checked.無し.getCode());
        entity.setIk_mahiSonota(Checked.有り.getCode());
        entity.setIk_kinryokuTeikaUmuKubun(true);
        entity.setIk_kinryokuTeikaBui(new RString("筋力低下部位"));
        entity.setIk_kinryokuTeikaTeido(Teido.軽.getCode());
        entity.setIk_koshukuMigiKataUmuKubun(true);
        entity.setIk_koshukuHidariKataUmuKubun(false);
        entity.setIk_koshukuMigiHijiUmuKubun(true);
        entity.setIk_koshukuHidariHijiUmuKubun(false);
        entity.setIk_koshukuMigiMataUmuKubun(true);
        entity.setIk_koshukuHidariMataUmuKubun(false);
        entity.setIk_koshukuMigiHizaUmuKubun(true);
        entity.setIk_koshukuHidariHizaUmuKubun(false);
        entity.setIk_kansetsuKoshukuTeido(Teido.重.getCode());
        entity.setIk_kansetsuItamiUmuKubun(true);
        entity.setIk_kansetsuItamiBui(new RString("関節の痛み部位"));
        entity.setIk_kansatsuItamiTeido(Teido.中.getCode());
        entity.setIk_huzuiiUmuKubun(true);
        entity.setIk_huzuiiMigiJoshiUmuKubun(false);
        entity.setIk_huzuiiHidariJoshiUmuKubun(true);
        entity.setIk_huzuiiMigiTaikanUmuKubun(false);
        entity.setIk_huzuiiHidariTaikanUmuKubun(true);
        entity.setIk_huzuiiMigiKashiUmuKubun(false);
        entity.setIk_huzuiiHidariKashiUmuKubun(true);
        entity.setIk_jokusoUmuKubun(false);
        entity.setIk_jokusoBui(new RString("じょくそう部位"));
        entity.setIk_jokusoTeido(Teido.軽.getCode());
        entity.setIk_sonotaHifuShikkanUmuKubun(true);
        entity.setIk_sonotaHifuShikkkanBui(new RString("その他皮膚疾患部位"));
        entity.setIk_sonotaHifushikkanTeido(Teido.重.getCode());
        entity.setIk_idoOkugaiHoko(Kaijo4.自立.getCode());
        entity.setIk_idoKurumaisu(Kurumaisu.用いていない.getCode());
        entity.setIk_idoHokohojoguMishiyo(Checked.有り.getCode());
        entity.setIk_idoHokohojoguOkugai(Checked.無し.getCode());
        entity.setIk_idoHokohojoguOkunai(Checked.有り.getCode());
        entity.setIk_shokuseikatsuShokujiKoi(Shokuji.自立ないし何とか自分で食べられる.getCode());
        entity.setIk_shokuseikatsuEiyoJotai(Jotai.良好.getCode());
        entity.setIk_shokuseikatsuRyuiten(new RString("栄養_食生活留意点"));
        entity.setIk_probabilityNyoShikkinUmuKubun(true);
        entity.setIk_probabilityTentoOrKossetsuUmuKubun(false);
        entity.setIk_probabilityIdoNoryokuTeikaUmuKubun(true);
        entity.setIk_probabilityJokusoUmuKubun(false);
        entity.setIk_probabilityTojikomoriUmuKubun(false);
        entity.setIk_probabilitiyIyokuTeikaUmuKubun(true);
        entity.setIk_probabilityHaikaiUmuKubun(false);
        entity.setIk_probabilityTeiEiyoUmuKubun(true);
        entity.setIk_probabilitySesshokuEngiKinoTeikaUmuKubun(false);
        entity.setIk_probabilityDassuiUmuKubun(true);
        entity.setIk_probabilityIkansenshoUmuKubun(false);
        entity.setIk_probabilityTotsuUmuKubun(true);
        entity.setIk_probabilitySonotaUmuKubun(false);
        entity.setIk_probabilitySonotaNaiyo(new RString("その他状態内容"));
        entity.setIk_probabilityEngeseiHaienUmuKubun(false);
        entity.setIk_probabilityChoHeisokuUmuKubun(false);
        entity.setIk_probabilityShinpaiKinoTeikaUmuKubun(true);
        entity.setIk_probabilityItamiUmuKubun(false);
        entity.setIk_probabilityTaisho(new RString("状態対処方針"));
        entity.setIk_yogoMitoshi(Kitai.期待できる.getCode());
        entity.setIk_ijiKaizenMitoshi(Kitai.期待できない.getCode());
        entity.setIk_homonShinryoUmuKubun(true);
        entity.setIk_tankiNyushoRyoyoKaigoUmuKubun(true);
        entity.setIk_homonEiyoShokujiShidoUmuKubun(true);
        entity.setIk_homonKangoUmuKubun(false);
        entity.setIk_homonShikaShinryoUmuKubun(false);
        entity.setIk_homonRihabilitationUmuKubun(false);
        entity.setIk_homonShikaEiseiShidoUmuKubun(false);
        entity.setIk_tushoRihabilitationUmuKubun(false);
        entity.setIk_homonYakuzaiKanriShidoUmuKubun(true);
        entity.setIk_sonotaIgakutekiKanriUmuKubun(true);
        entity.setIk_ryuiJikoKetsuatsuUmuKubun(true);
        entity.setIk_ryuiJikoKetsuatsu(new RString("血圧内容"));
        entity.setIk_ryuiJikoSesshokuUmuKubun(true);
        entity.setIk_ryuiJikoSesshoku(new RString("摂食内容"));
        entity.setIk_ryuiJikoEngeUmuKubun(true);
        entity.setIk_ryuiJikoEnge(new RString("嚥下内容"));
        entity.setIk_ryuiJikoIdoUmuKubun(false);
        entity.setIk_ryuiJikoIdo(new RString("移動内容"));
        entity.setIk_ryuiJikoUndoUmuKubun(false);
        entity.setIk_ryuiJikoUndo(new RString("運動内容"));
        entity.setIk_ryuiJikoSonota(new RString("その他留意事項"));
        entity.setIk_kansenshoUmu(NashiAri2.無.getCode());
        entity.setIk_kansenshoShojo(new RString("感染症内容"));
        entity.setIk_tokkiJiko(new RString("特記事項"));
        entity.setIk_kangoSyokuiHomonUmu(Checked.有り.getCode());
        return entity;
    }
}
