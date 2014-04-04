package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医意見書詳細情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5013ShujiiIkenshoShosaiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    ikenshoIraiRirekiNo(5, 0),
    koroshoIfShikibetsuCode(3, 0),
    saishuShinryoYMD(2147483647, 0),
    takaJushinUmuKubun(1, 0),
    naiKaJushinUmuKubun(1, 0),
    seishinKaJushinUmuKubun(1, 0),
    geKaJushinUmuKubun(1, 0),
    seikeigeKaJushinUmuKubun(1, 0),
    noushinkeigeKaJushinUmuKubun(1, 0),
    hifuKaJushinUmuKubun(1, 0),
    hinyokiKaJushinUmuKubun(1, 0),
    fujinKaJushinUmuKubun(1, 0),
    jibiinkoKaJushinUmuKubun(1, 0),
    rehabilitationKaJushinUmuKubun(1, 0),
    shiKaJushinUmuKubun(1, 0),
    ganKaJushinUmuKubun(1, 0),
    sonotaJushinKaUmuKubun(1, 0),
    sonotaJushinKaShimei(40, 0),
    ik_shindamMei1(40, 0),
    ik_hasshoYMD1(2147483647, 0),
    ik_shindamMei2(40, 0),
    ik_hasshoYMD2(2147483647, 0),
    ik_shindamMei3(40, 0),
    ik_hasshoYMD3(2147483647, 0),
    ik_anteisei(1, 0),
    ik_anteiseiHuanteiJokyo(2147483647, 0),
    ik_chiryoNaiyo(2147483647, 0),
    ik_tokubetsuIryoTentekiUmuKubun(1, 0),
    ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun(1, 0),
    ik_tokubetsuIryoTosekiUmuKubun(1, 0),
    ik_tokubetsuIryoStomaShochiUmuKubun(1, 0),
    ik_tokubetsuIryoSansoRyohoUmuKubun(1, 0),
    ik_tokubetsuIryoRespiratorUmuKubun(1, 0),
    ik_tokubetsuIryoKikanSekkaiUmuKubun(1, 0),
    ik_tokubetsuIryoTotsuKangoUmuKubun(1, 0),
    ik_tokubetsuIryoKeikanEiyoUmuKubun(1, 0),
    ik_tokubetsuIryoMonitorSokuteiUmuKubun(1, 0),
    ik_tokubetsuIryoJokusoShochiUmuKubun(1, 0),
    ik_tokubetsuIryoCatheterUmuKubun(1, 0),
    ik_seikatsuJiritsudoShyogaiCode(2147483647, 0),
    ik_seikatsuJiritsudoNinchshoCode(2147483647, 0),
    ik_chukakuShojoTankiKioku(1, 0),
    ik_chukakuShojoNinchiNoryoku(1, 0),
    ik_chukakuShojoDentatsuNoryoku(1, 0),
    ik_shuhenShojoUmuKubun(1, 0),
    ik_shuhenShojoGenshiGenchoUmuKubun(1, 0),
    ik_shuhenShojoMosoUmuKubun(1, 0),
    ik_shuhenShojoChuyaGakutenUmuKubun(1, 0),
    ik_shuhenShojoBogenUmuKubun(1, 0),
    ik_shuhenShojoBokoUmuKubun(1, 0),
    ik_shuhenShojoKaigoHenoTeikoUmuKubun(1, 0),
    ik_shuhenShojoHaikaiUmuKubun(1, 0),
    ik_shuhenShojoHiNoFushimatsuUmuKubun(1, 0),
    ik_shuhenShojoFuketsuKoiUmuKubun(1, 0),
    ik_shuhenShojoIshokuKodoUmuKubun(1, 0),
    ik_shuhenShojoSeitekiMondaiKodoUmuKubun(1, 0),
    ik_shuhenShojoSonotaUmuKubun(1, 0),
    ik_shuhenShojoSonotaNaiyo(20, 0),
    ik_seishinOrShinkeiShojoUmuKubun(1, 0),
    ik_seishinOrShinkeiShojoShimei(20, 0),
    ik_semmonkaiJushinUmuKubun(1, 0),
    ik_semmonkaiJushin(20, 0),
    ik_kikiudeKubun(1, 0),
    ik_shincho(5, 0),
    ik_taiju(5, 0),
    ik_taijuHenka(1, 0),
    ik_shishiKessonUmuKubun(1, 0),
    ik_shishiKessonBui(20, 0),
    ik_shishiKessonTeido(1, 0),
    ik_mahiUmuKubun(1, 0),
    ik_mahiTeido(1, 0),
    ik_mahiHidariJoshi(1, 0),
    ik_mahiMigiJoshi(1, 0),
    ik_mahiHidariKashi(1, 0),
    ik_mahiMigiKashi(1, 0),
    ik_mahiSonota(1, 0),
    ik_kinryokuTeikaUmuKubun(1, 0),
    ik_kinryokuTeikaBui(20, 0),
    ik_kinryokuTeikaTeido(1, 0),
    ik_koshukuMigiKataUmuKubun(1, 0),
    ik_koshukuHidariKataUmuKubun(1, 0),
    ik_koshukuMigiHijiUmuKubun(1, 0),
    ik_koshukuHidariHijiUmuKubun(1, 0),
    ik_koshukuMigiMataUmuKubun(1, 0),
    ik_koshukuHidariMataUmuKubun(1, 0),
    ik_koshukuMigiHizaUmuKubun(1, 0),
    ik_koshukuHidariHizaUmuKubun(1, 0),
    ik_kansetsuKoshukuTeido(1, 0),
    ik_kansetsuItamiUmuKubun(1, 0),
    ik_kansetsuItamiBui(20, 0),
    ik_kansatsuItamiTeido(1, 0),
    ik_huzuiiUmuKubun(1, 0),
    ik_huzuiiMigiJoshiUmuKubun(1, 0),
    ik_huzuiiHidariJoshiUmuKubun(1, 0),
    ik_huzuiiMigiTaikanUmuKubun(1, 0),
    ik_huzuiiHidariTaikanUmuKubun(1, 0),
    ik_huzuiiMigiKashiUmuKubun(1, 0),
    ik_huzuiiHidariKashiUmuKubun(1, 0),
    ik_jokusoUmuKubun(1, 0),
    ik_jokusoBui(20, 0),
    ik_jokusoTeido(1, 0),
    ik_sonotaHifuShikkanUmuKubun(1, 0),
    ik_sonotaHifuShikkkanBui(20, 0),
    ik_sonotaHifushikkanTeido(1, 0),
    ik_idoOkugaiHoko(1, 0),
    ik_idoKurumaisu(1, 0),
    ik_idoHokohojoguMishiyo(1, 0),
    ik_idoHokohojoguOkugai(1, 0),
    ik_idoHokohojoguOkunai(1, 0),
    ik_shokuseikatsuShokujiKoi(1, 0),
    ik_shokuseikatsuEiyoJotai(1, 0),
    ik_shokuseikatsuRyuiten(80, 0),
    ik_probabilityNyoShikkinUmuKubun(1, 0),
    ik_probabilityTentoOrKossetsuUmuKubun(1, 0),
    ik_probabilityIdoNoryokuTeikaUmuKubun(1, 0),
    ik_probabilityJokusoUmuKubun(1, 0),
    ik_probabilityTojikomoriUmuKubun(1, 0),
    ik_probabilitiyIyokuTeikaUmuKubun(1, 0),
    ik_probabilityHaikaiUmuKubun(1, 0),
    ik_probabilityTeiEiyoUmuKubun(1, 0),
    ik_probabilitySesshokuEngiKinoTeikaUmuKubun(1, 0),
    ik_probabilityDassuiUmuKubun(1, 0),
    ik_probabilityIkansenshoUmuKubun(1, 0),
    ik_probabilityTotsuUmuKubun(1, 0),
    ik_probabilitySonotaUmuKubun(1, 0),
    ik_probabilitySonotaNaiyo(20, 0),
    ik_probabilityEngeseiHaienUmuKubun(1, 0),
    ik_probabilityChoHeisokuUmuKubun(1, 0),
    ik_probabilityShinpaiKinoTeikaUmuKubun(1, 0),
    ik_probabilityItamiUmuKubun(1, 0),
    ik_probabilityTaisho(80, 0),
    ik_yogoMitoshi(1, 0),
    ik_ijiKaizenMitoshi(1, 0),
    ik_homonShinryoUmuKubun(1, 0),
    ik_tankiNyushoRyoyoKaigoUmuKubun(1, 0),
    ik_homonEiyoShokujiShidoUmuKubun(1, 0),
    ik_homonKangoUmuKubun(1, 0),
    ik_homonShikaShinryoUmuKubun(1, 0),
    ik_homonRihabilitationUmuKubun(1, 0),
    ik_homonShikaEiseiShidoUmuKubun(1, 0),
    ik_tushoRihabilitationUmuKubun(1, 0),
    ik_homonYakuzaiKanriShidoUmuKubun(1, 0),
    ik_sonotaIgakutekiKanriUmuKubun(1, 0),
    ik_ryuiJikoKetsuatsuUmuKubun(1, 0),
    ik_ryuiJikoKetsuatsu(20, 0),
    ik_ryuiJikoSesshokuUmuKubun(1, 0),
    ik_ryuiJikoSesshoku(20, 0),
    ik_ryuiJikoEngeUmuKubun(1, 0),
    ik_ryuiJikoEnge(20, 0),
    ik_ryuiJikoIdoUmuKubun(1, 0),
    ik_ryuiJikoIdo(20, 0),
    ik_ryuiJikoUndoUmuKubun(1, 0),
    ik_ryuiJikoUndo(20, 0),
    ik_ryuiJikoSonota(40, 0),
    ik_kansenshoUmu(1, 0),
    ik_kansenshoShojo(80, 0),
    ik_tokkiJiko(2147483647, 0),
    ik_tokkiJikoImage(2147483647, 0),
    ik_kangoShokuiHomonUmu(1, 0);
    private final int maxLength;
    private final int scale;

    private DbT5013ShujiiIkenshoShosaiJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
