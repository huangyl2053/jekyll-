package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.DbeShubetsuKey;

/**
 * DbT5013ShujiiIkenshoShosaiJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5013ShujiiIkenshoShosaiJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5013ShujiiIkenshoShosaiJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ikenshoIraiRirekiNo;
    private RString koroshoIfShikibetsuCode;
    private FlexibleDate saishuShinryoYMD;
    private boolean takaJushinUmuKubun;
    private boolean naiKaJushinUmuKubun;
    private boolean seishinKaJushinUmuKubun;
    private boolean geKaJushinUmuKubun;
    private boolean seikeigeKaJushinUmuKubun;
    private boolean noushinkeigeKaJushinUmuKubun;
    private boolean hifuKaJushinUmuKubun;
    private boolean hinyokiKaJushinUmuKubun;
    private boolean fujinKaJushinUmuKubun;
    private boolean jibiinkoKaJushinUmuKubun;
    private boolean rehabilitationKaJushinUmuKubun;
    private boolean shiKaJushinUmuKubun;
    private boolean ganKaJushinUmuKubun;
    private boolean sonotaJushinKaUmuKubun;
    private RString sonotaJushinKaShimei;
    private RString ik_shindamMei1;
    private FlexibleDate ik_hasshoYMD1;
    private RString ik_shindamMei2;
    private FlexibleDate ik_hasshoYMD2;
    private RString ik_shindamMei3;
    private FlexibleDate ik_hasshoYMD3;
    private RString ik_anteisei;
    private RString ik_anteiseiHuanteiJokyo;
    private RString ik_chiryoNaiyo;
    private boolean ik_tokubetsuIryoTentekiUmuKubun;
    private boolean ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun;
    private boolean ik_tokubetsuIryoTosekiUmuKubun;
    private boolean ik_tokubetsuIryoStomaShochiUmuKubun;
    private boolean ik_tokubetsuIryoSansoRyohoUmuKubun;
    private boolean ik_tokubetsuIryoRespiratorUmuKubun;
    private boolean ik_tokubetsuIryoKikanSekkaiUmuKubun;
    private boolean ik_tokubetsuIryoTotsuKangoUmuKubun;
    private boolean ik_tokubetsuIryoKeikanEiyoUmuKubun;
    private boolean ik_tokubetsuIryoMonitorSokuteiUmuKubun;
    private boolean ik_tokubetsuIryoJokusoShochiUmuKubun;
    private boolean ik_tokubetsuIryoCatheterUmuKubun;
    private Code ik_seikatsuJiritsudoShyogaiCode;
    private Code ik_seikatsuJiritsudoNinchshoCode;
    private RString ik_chukakuShojoTankiKioku;
    private RString ik_chukakuShojoNinchiNoryoku;
    private RString ik_chukakuShojoDentatsuNoryoku;
    private boolean ik_shuhenShojoUmuKubun;
    private boolean ik_shuhenShojoGenshiGenchoUmuKubun;
    private boolean ik_shuhenShojoMosoUmuKubun;
    private boolean ik_shuhenShojoChuyaGakutenUmuKubun;
    private boolean ik_shuhenShojoBogenUmuKubun;
    private boolean ik_shuhenShojoBokoUmuKubun;
    private boolean ik_shuhenShojoKaigoHenoTeikoUmuKubun;
    private boolean ik_shuhenShojoHaikaiUmuKubun;
    private boolean ik_shuhenShojoHiNoFushimatsuUmuKubun;
    private boolean ik_shuhenShojoFuketsuKoiUmuKubun;
    private boolean ik_shuhenShojoIshokuKodoUmuKubun;
    private boolean ik_shuhenShojoSeitekiMondaiKodoUmuKubun;
    private boolean ik_shuhenShojoSonotaUmuKubun;
    private RString ik_shuhenShojoSonotaNaiyo;
    private boolean ik_seishinOrShinkeiShojoUmuKubun;
    private RString ik_seishinOrShinkeiShojoShimei;
    private boolean ik_semmonkaiJushinUmuKubun;
    private RString ik_semmonkaiJushin;
    private RString ik_kikiudeKubun;
    private int ik_shincho;
    private int ik_taiju;
    private RString ik_taijuHenka;
    private boolean ik_shishiKessonUmuKubun;
    private RString ik_shishiKessonBui;
    private RString ik_shishiKessonTeido;
    private boolean ik_mahiUmuKubun;
    private RString ik_mahiTeido;
    private RString ik_mahiHidariJoshi;
    private RString ik_mahiMigiJoshi;
    private RString ik_mahiHidariKashi;
    private RString ik_mahiMigiKashi;
    private RString ik_mahiSonota;
    private boolean ik_kinryokuTeikaUmuKubun;
    private RString ik_kinryokuTeikaBui;
    private RString ik_kinryokuTeikaTeido;
    private boolean ik_koshukuMigiKataUmuKubun;
    private boolean ik_koshukuHidariKataUmuKubun;
    private boolean ik_koshukuMigiHijiUmuKubun;
    private boolean ik_koshukuHidariHijiUmuKubun;
    private boolean ik_koshukuMigiMataUmuKubun;
    private boolean ik_koshukuHidariMataUmuKubun;
    private boolean ik_koshukuMigiHizaUmuKubun;
    private boolean ik_koshukuHidariHizaUmuKubun;
    private RString ik_kansetsuKoshukuTeido;
    private boolean ik_kansetsuItamiUmuKubun;
    private RString ik_kansetsuItamiBui;
    private RString ik_kansatsuItamiTeido;
    private boolean ik_huzuiiUmuKubun;
    private boolean ik_huzuiiMigiJoshiUmuKubun;
    private boolean ik_huzuiiHidariJoshiUmuKubun;
    private boolean ik_huzuiiMigiTaikanUmuKubun;
    private boolean ik_huzuiiHidariTaikanUmuKubun;
    private boolean ik_huzuiiMigiKashiUmuKubun;
    private boolean ik_huzuiiHidariKashiUmuKubun;
    private boolean ik_jokusoUmuKubun;
    private RString ik_jokusoBui;
    private RString ik_jokusoTeido;
    private boolean ik_sonotaHifuShikkanUmuKubun;
    private RString ik_sonotaHifuShikkkanBui;
    private RString ik_sonotaHifushikkanTeido;
    private RString ik_idoOkugaiHoko;
    private RString ik_idoKurumaisu;
    private RString ik_idoHokohojoguMishiyo;
    private RString ik_idoHokohojoguOkugai;
    private RString ik_idoHokohojoguOkunai;
    private RString ik_shokuseikatsuShokujiKoi;
    private RString ik_shokuseikatsuEiyoJotai;
    private RString ik_shokuseikatsuRyuiten;
    private boolean ik_probabilityNyoShikkinUmuKubun;
    private boolean ik_probabilityTentoOrKossetsuUmuKubun;
    private boolean ik_probabilityIdoNoryokuTeikaUmuKubun;
    private boolean ik_probabilityJokusoUmuKubun;
    private boolean ik_probabilityTojikomoriUmuKubun;
    private boolean ik_probabilitiyIyokuTeikaUmuKubun;
    private boolean ik_probabilityHaikaiUmuKubun;
    private boolean ik_probabilityTeiEiyoUmuKubun;
    private boolean ik_probabilitySesshokuEngiKinoTeikaUmuKubun;
    private boolean ik_probabilityDassuiUmuKubun;
    private boolean ik_probabilityIkansenshoUmuKubun;
    private boolean ik_probabilityTotsuUmuKubun;
    private boolean ik_probabilitySonotaUmuKubun;
    private RString ik_probabilitySonotaNaiyo;
    private boolean ik_probabilityEngeseiHaienUmuKubun;
    private boolean ik_probabilityChoHeisokuUmuKubun;
    private boolean ik_probabilityShinpaiKinoTeikaUmuKubun;
    private boolean ik_probabilityItamiUmuKubun;
    private RString ik_probabilityTaisho;
    private RString ik_yogoMitoshi;
    private RString ik_ijiKaizenMitoshi;
    private boolean ik_homonShinryoUmuKubun;
    private boolean ik_tankiNyushoRyoyoKaigoUmuKubun;
    private boolean ik_homonEiyoShokujiShidoUmuKubun;
    private boolean ik_homonKangoUmuKubun;
    private boolean ik_homonShikaShinryoUmuKubun;
    private boolean ik_homonRihabilitationUmuKubun;
    private boolean ik_homonShikaEiseiShidoUmuKubun;
    private boolean ik_tushoRihabilitationUmuKubun;
    private boolean ik_homonYakuzaiKanriShidoUmuKubun;
    private boolean ik_sonotaIgakutekiKanriUmuKubun;
    private boolean ik_ryuiJikoKetsuatsuUmuKubun;
    private RString ik_ryuiJikoKetsuatsu;
    private boolean ik_ryuiJikoSesshokuUmuKubun;
    private RString ik_ryuiJikoSesshoku;
    private boolean ik_ryuiJikoEngeUmuKubun;
    private RString ik_ryuiJikoEnge;
    private boolean ik_ryuiJikoIdoUmuKubun;
    private RString ik_ryuiJikoIdo;
    private boolean ik_ryuiJikoUndoUmuKubun;
    private RString ik_ryuiJikoUndo;
    private RString ik_ryuiJikoSonota;
    private RString ik_kansenshoUmu;
    private RString ik_kansenshoShojo;
    private RString ik_tokkiJiko;
    private byte[] ik_tokkiJikoImage;
    private RString ik_kangoShokuiHomonUmu;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShinseishoKanriNo
     *
     * @return shinseishoKanriNo
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * setShinseishoKanriNo
     *
     * @param shinseishoKanriNo shinseishoKanriNo
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * getIkenshoIraiRirekiNo
     *
     * @return ikenshoIraiRirekiNo
     */
    public int getIkenshoIraiRirekiNo() {
        return ikenshoIraiRirekiNo;
    }

    /**
     * setIkenshoIraiRirekiNo
     *
     * @param ikenshoIraiRirekiNo ikenshoIraiRirekiNo
     */
    public void setIkenshoIraiRirekiNo(int ikenshoIraiRirekiNo) {
        this.ikenshoIraiRirekiNo = ikenshoIraiRirekiNo;
    }

    /**
     * getKoroshoIfShikibetsuCode
     *
     * @return koroshoIfShikibetsuCode
     */
    public RString getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * setKoroshoIfShikibetsuCode
     *
     * @param koroshoIfShikibetsuCode koroshoIfShikibetsuCode
     */
    public void setKoroshoIfShikibetsuCode(RString koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * getSaishuShinryoYMD
     *
     * @return saishuShinryoYMD
     */
    public FlexibleDate getSaishuShinryoYMD() {
        return saishuShinryoYMD;
    }

    /**
     * setSaishuShinryoYMD
     *
     * @param saishuShinryoYMD saishuShinryoYMD
     */
    public void setSaishuShinryoYMD(FlexibleDate saishuShinryoYMD) {
        this.saishuShinryoYMD = saishuShinryoYMD;
    }

    /**
     * getTakaJushinUmuKubun
     *
     * @return takaJushinUmuKubun
     */
    public boolean getTakaJushinUmuKubun() {
        return takaJushinUmuKubun;
    }

    /**
     * setTakaJushinUmuKubun
     *
     * @param takaJushinUmuKubun takaJushinUmuKubun
     */
    public void setTakaJushinUmuKubun(boolean takaJushinUmuKubun) {
        this.takaJushinUmuKubun = takaJushinUmuKubun;
    }

    /**
     * getNaiKaJushinUmuKubun
     *
     * @return naiKaJushinUmuKubun
     */
    public boolean getNaiKaJushinUmuKubun() {
        return naiKaJushinUmuKubun;
    }

    /**
     * setNaiKaJushinUmuKubun
     *
     * @param naiKaJushinUmuKubun naiKaJushinUmuKubun
     */
    public void setNaiKaJushinUmuKubun(boolean naiKaJushinUmuKubun) {
        this.naiKaJushinUmuKubun = naiKaJushinUmuKubun;
    }

    /**
     * getSeishinKaJushinUmuKubun
     *
     * @return seishinKaJushinUmuKubun
     */
    public boolean getSeishinKaJushinUmuKubun() {
        return seishinKaJushinUmuKubun;
    }

    /**
     * setSeishinKaJushinUmuKubun
     *
     * @param seishinKaJushinUmuKubun seishinKaJushinUmuKubun
     */
    public void setSeishinKaJushinUmuKubun(boolean seishinKaJushinUmuKubun) {
        this.seishinKaJushinUmuKubun = seishinKaJushinUmuKubun;
    }

    /**
     * getGeKaJushinUmuKubun
     *
     * @return geKaJushinUmuKubun
     */
    public boolean getGeKaJushinUmuKubun() {
        return geKaJushinUmuKubun;
    }

    /**
     * setGeKaJushinUmuKubun
     *
     * @param geKaJushinUmuKubun geKaJushinUmuKubun
     */
    public void setGeKaJushinUmuKubun(boolean geKaJushinUmuKubun) {
        this.geKaJushinUmuKubun = geKaJushinUmuKubun;
    }

    /**
     * getSeikeigeKaJushinUmuKubun
     *
     * @return seikeigeKaJushinUmuKubun
     */
    public boolean getSeikeigeKaJushinUmuKubun() {
        return seikeigeKaJushinUmuKubun;
    }

    /**
     * setSeikeigeKaJushinUmuKubun
     *
     * @param seikeigeKaJushinUmuKubun seikeigeKaJushinUmuKubun
     */
    public void setSeikeigeKaJushinUmuKubun(boolean seikeigeKaJushinUmuKubun) {
        this.seikeigeKaJushinUmuKubun = seikeigeKaJushinUmuKubun;
    }

    /**
     * getNoushinkeigeKaJushinUmuKubun
     *
     * @return noushinkeigeKaJushinUmuKubun
     */
    public boolean getNoushinkeigeKaJushinUmuKubun() {
        return noushinkeigeKaJushinUmuKubun;
    }

    /**
     * setNoushinkeigeKaJushinUmuKubun
     *
     * @param noushinkeigeKaJushinUmuKubun noushinkeigeKaJushinUmuKubun
     */
    public void setNoushinkeigeKaJushinUmuKubun(boolean noushinkeigeKaJushinUmuKubun) {
        this.noushinkeigeKaJushinUmuKubun = noushinkeigeKaJushinUmuKubun;
    }

    /**
     * getHifuKaJushinUmuKubun
     *
     * @return hifuKaJushinUmuKubun
     */
    public boolean getHifuKaJushinUmuKubun() {
        return hifuKaJushinUmuKubun;
    }

    /**
     * setHifuKaJushinUmuKubun
     *
     * @param hifuKaJushinUmuKubun hifuKaJushinUmuKubun
     */
    public void setHifuKaJushinUmuKubun(boolean hifuKaJushinUmuKubun) {
        this.hifuKaJushinUmuKubun = hifuKaJushinUmuKubun;
    }

    /**
     * getHinyokiKaJushinUmuKubun
     *
     * @return hinyokiKaJushinUmuKubun
     */
    public boolean getHinyokiKaJushinUmuKubun() {
        return hinyokiKaJushinUmuKubun;
    }

    /**
     * setHinyokiKaJushinUmuKubun
     *
     * @param hinyokiKaJushinUmuKubun hinyokiKaJushinUmuKubun
     */
    public void setHinyokiKaJushinUmuKubun(boolean hinyokiKaJushinUmuKubun) {
        this.hinyokiKaJushinUmuKubun = hinyokiKaJushinUmuKubun;
    }

    /**
     * getFujinKaJushinUmuKubun
     *
     * @return fujinKaJushinUmuKubun
     */
    public boolean getFujinKaJushinUmuKubun() {
        return fujinKaJushinUmuKubun;
    }

    /**
     * setFujinKaJushinUmuKubun
     *
     * @param fujinKaJushinUmuKubun fujinKaJushinUmuKubun
     */
    public void setFujinKaJushinUmuKubun(boolean fujinKaJushinUmuKubun) {
        this.fujinKaJushinUmuKubun = fujinKaJushinUmuKubun;
    }

    /**
     * getJibiinkoKaJushinUmuKubun
     *
     * @return jibiinkoKaJushinUmuKubun
     */
    public boolean getJibiinkoKaJushinUmuKubun() {
        return jibiinkoKaJushinUmuKubun;
    }

    /**
     * setJibiinkoKaJushinUmuKubun
     *
     * @param jibiinkoKaJushinUmuKubun jibiinkoKaJushinUmuKubun
     */
    public void setJibiinkoKaJushinUmuKubun(boolean jibiinkoKaJushinUmuKubun) {
        this.jibiinkoKaJushinUmuKubun = jibiinkoKaJushinUmuKubun;
    }

    /**
     * getRehabilitationKaJushinUmuKubun
     *
     * @return rehabilitationKaJushinUmuKubun
     */
    public boolean getRehabilitationKaJushinUmuKubun() {
        return rehabilitationKaJushinUmuKubun;
    }

    /**
     * setRehabilitationKaJushinUmuKubun
     *
     * @param rehabilitationKaJushinUmuKubun rehabilitationKaJushinUmuKubun
     */
    public void setRehabilitationKaJushinUmuKubun(boolean rehabilitationKaJushinUmuKubun) {
        this.rehabilitationKaJushinUmuKubun = rehabilitationKaJushinUmuKubun;
    }

    /**
     * getShiKaJushinUmuKubun
     *
     * @return shiKaJushinUmuKubun
     */
    public boolean getShiKaJushinUmuKubun() {
        return shiKaJushinUmuKubun;
    }

    /**
     * setShiKaJushinUmuKubun
     *
     * @param shiKaJushinUmuKubun shiKaJushinUmuKubun
     */
    public void setShiKaJushinUmuKubun(boolean shiKaJushinUmuKubun) {
        this.shiKaJushinUmuKubun = shiKaJushinUmuKubun;
    }

    /**
     * getGanKaJushinUmuKubun
     *
     * @return ganKaJushinUmuKubun
     */
    public boolean getGanKaJushinUmuKubun() {
        return ganKaJushinUmuKubun;
    }

    /**
     * setGanKaJushinUmuKubun
     *
     * @param ganKaJushinUmuKubun ganKaJushinUmuKubun
     */
    public void setGanKaJushinUmuKubun(boolean ganKaJushinUmuKubun) {
        this.ganKaJushinUmuKubun = ganKaJushinUmuKubun;
    }

    /**
     * getSonotaJushinKaUmuKubun
     *
     * @return sonotaJushinKaUmuKubun
     */
    public boolean getSonotaJushinKaUmuKubun() {
        return sonotaJushinKaUmuKubun;
    }

    /**
     * setSonotaJushinKaUmuKubun
     *
     * @param sonotaJushinKaUmuKubun sonotaJushinKaUmuKubun
     */
    public void setSonotaJushinKaUmuKubun(boolean sonotaJushinKaUmuKubun) {
        this.sonotaJushinKaUmuKubun = sonotaJushinKaUmuKubun;
    }

    /**
     * getSonotaJushinKaShimei
     *
     * @return sonotaJushinKaShimei
     */
    public RString getSonotaJushinKaShimei() {
        return sonotaJushinKaShimei;
    }

    /**
     * setSonotaJushinKaShimei
     *
     * @param sonotaJushinKaShimei sonotaJushinKaShimei
     */
    public void setSonotaJushinKaShimei(RString sonotaJushinKaShimei) {
        this.sonotaJushinKaShimei = sonotaJushinKaShimei;
    }

    /**
     * getIk_shindamMei1
     *
     * @return ik_shindamMei1
     */
    public RString getIk_shindamMei1() {
        return ik_shindamMei1;
    }

    /**
     * setIk_shindamMei1
     *
     * @param ik_shindamMei1 ik_shindamMei1
     */
    public void setIk_shindamMei1(RString ik_shindamMei1) {
        this.ik_shindamMei1 = ik_shindamMei1;
    }

    /**
     * getIk_hasshoYMD1
     *
     * @return ik_hasshoYMD1
     */
    public FlexibleDate getIk_hasshoYMD1() {
        return ik_hasshoYMD1;
    }

    /**
     * setIk_hasshoYMD1
     *
     * @param ik_hasshoYMD1 ik_hasshoYMD1
     */
    public void setIk_hasshoYMD1(FlexibleDate ik_hasshoYMD1) {
        this.ik_hasshoYMD1 = ik_hasshoYMD1;
    }

    /**
     * getIk_shindamMei2
     *
     * @return ik_shindamMei2
     */
    public RString getIk_shindamMei2() {
        return ik_shindamMei2;
    }

    /**
     * setIk_shindamMei2
     *
     * @param ik_shindamMei2 ik_shindamMei2
     */
    public void setIk_shindamMei2(RString ik_shindamMei2) {
        this.ik_shindamMei2 = ik_shindamMei2;
    }

    /**
     * getIk_hasshoYMD2
     *
     * @return ik_hasshoYMD2
     */
    public FlexibleDate getIk_hasshoYMD2() {
        return ik_hasshoYMD2;
    }

    /**
     * setIk_hasshoYMD2
     *
     * @param ik_hasshoYMD2 ik_hasshoYMD2
     */
    public void setIk_hasshoYMD2(FlexibleDate ik_hasshoYMD2) {
        this.ik_hasshoYMD2 = ik_hasshoYMD2;
    }

    /**
     * getIk_shindamMei3
     *
     * @return ik_shindamMei3
     */
    public RString getIk_shindamMei3() {
        return ik_shindamMei3;
    }

    /**
     * setIk_shindamMei3
     *
     * @param ik_shindamMei3 ik_shindamMei3
     */
    public void setIk_shindamMei3(RString ik_shindamMei3) {
        this.ik_shindamMei3 = ik_shindamMei3;
    }

    /**
     * getIk_hasshoYMD3
     *
     * @return ik_hasshoYMD3
     */
    public FlexibleDate getIk_hasshoYMD3() {
        return ik_hasshoYMD3;
    }

    /**
     * setIk_hasshoYMD3
     *
     * @param ik_hasshoYMD3 ik_hasshoYMD3
     */
    public void setIk_hasshoYMD3(FlexibleDate ik_hasshoYMD3) {
        this.ik_hasshoYMD3 = ik_hasshoYMD3;
    }

    /**
     * getIk_anteisei
     *
     * @return ik_anteisei
     */
    public RString getIk_anteisei() {
        return ik_anteisei;
    }

    /**
     * setIk_anteisei
     *
     * @param ik_anteisei ik_anteisei
     */
    public void setIk_anteisei(RString ik_anteisei) {
        this.ik_anteisei = ik_anteisei;
    }

    /**
     * getIk_anteiseiHuanteiJokyo
     *
     * @return ik_anteiseiHuanteiJokyo
     */
    public RString getIk_anteiseiHuanteiJokyo() {
        return ik_anteiseiHuanteiJokyo;
    }

    /**
     * setIk_anteiseiHuanteiJokyo
     *
     * @param ik_anteiseiHuanteiJokyo ik_anteiseiHuanteiJokyo
     */
    public void setIk_anteiseiHuanteiJokyo(RString ik_anteiseiHuanteiJokyo) {
        this.ik_anteiseiHuanteiJokyo = ik_anteiseiHuanteiJokyo;
    }

    /**
     * getIk_chiryoNaiyo
     *
     * @return ik_chiryoNaiyo
     */
    public RString getIk_chiryoNaiyo() {
        return ik_chiryoNaiyo;
    }

    /**
     * setIk_chiryoNaiyo
     *
     * @param ik_chiryoNaiyo ik_chiryoNaiyo
     */
    public void setIk_chiryoNaiyo(RString ik_chiryoNaiyo) {
        this.ik_chiryoNaiyo = ik_chiryoNaiyo;
    }

    /**
     * getIk_tokubetsuIryoTentekiUmuKubun
     *
     * @return ik_tokubetsuIryoTentekiUmuKubun
     */
    public boolean getIk_tokubetsuIryoTentekiUmuKubun() {
        return ik_tokubetsuIryoTentekiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoTentekiUmuKubun
     *
     * @param ik_tokubetsuIryoTentekiUmuKubun ik_tokubetsuIryoTentekiUmuKubun
     */
    public void setIk_tokubetsuIryoTentekiUmuKubun(boolean ik_tokubetsuIryoTentekiUmuKubun) {
        this.ik_tokubetsuIryoTentekiUmuKubun = ik_tokubetsuIryoTentekiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun
     *
     * @return ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun
     */
    public boolean getIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun() {
        return ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun
     *
     * @param ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun
     * ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun
     */
    public void setIk_tokubetsuIryoChushinJomyakuEiyoUmuKubun(boolean ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun) {
        this.ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun = ik_tokubetsuIryoChushinJomyakuEiyoUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoTosekiUmuKubun
     *
     * @return ik_tokubetsuIryoTosekiUmuKubun
     */
    public boolean getIk_tokubetsuIryoTosekiUmuKubun() {
        return ik_tokubetsuIryoTosekiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoTosekiUmuKubun
     *
     * @param ik_tokubetsuIryoTosekiUmuKubun ik_tokubetsuIryoTosekiUmuKubun
     */
    public void setIk_tokubetsuIryoTosekiUmuKubun(boolean ik_tokubetsuIryoTosekiUmuKubun) {
        this.ik_tokubetsuIryoTosekiUmuKubun = ik_tokubetsuIryoTosekiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoStomaShochiUmuKubun
     *
     * @return ik_tokubetsuIryoStomaShochiUmuKubun
     */
    public boolean getIk_tokubetsuIryoStomaShochiUmuKubun() {
        return ik_tokubetsuIryoStomaShochiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoStomaShochiUmuKubun
     *
     * @param ik_tokubetsuIryoStomaShochiUmuKubun
     * ik_tokubetsuIryoStomaShochiUmuKubun
     */
    public void setIk_tokubetsuIryoStomaShochiUmuKubun(boolean ik_tokubetsuIryoStomaShochiUmuKubun) {
        this.ik_tokubetsuIryoStomaShochiUmuKubun = ik_tokubetsuIryoStomaShochiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoSansoRyohoUmuKubun
     *
     * @return ik_tokubetsuIryoSansoRyohoUmuKubun
     */
    public boolean getIk_tokubetsuIryoSansoRyohoUmuKubun() {
        return ik_tokubetsuIryoSansoRyohoUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoSansoRyohoUmuKubun
     *
     * @param ik_tokubetsuIryoSansoRyohoUmuKubun
     * ik_tokubetsuIryoSansoRyohoUmuKubun
     */
    public void setIk_tokubetsuIryoSansoRyohoUmuKubun(boolean ik_tokubetsuIryoSansoRyohoUmuKubun) {
        this.ik_tokubetsuIryoSansoRyohoUmuKubun = ik_tokubetsuIryoSansoRyohoUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoRespiratorUmuKubun
     *
     * @return ik_tokubetsuIryoRespiratorUmuKubun
     */
    public boolean getIk_tokubetsuIryoRespiratorUmuKubun() {
        return ik_tokubetsuIryoRespiratorUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoRespiratorUmuKubun
     *
     * @param ik_tokubetsuIryoRespiratorUmuKubun
     * ik_tokubetsuIryoRespiratorUmuKubun
     */
    public void setIk_tokubetsuIryoRespiratorUmuKubun(boolean ik_tokubetsuIryoRespiratorUmuKubun) {
        this.ik_tokubetsuIryoRespiratorUmuKubun = ik_tokubetsuIryoRespiratorUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoKikanSekkaiUmuKubun
     *
     * @return ik_tokubetsuIryoKikanSekkaiUmuKubun
     */
    public boolean getIk_tokubetsuIryoKikanSekkaiUmuKubun() {
        return ik_tokubetsuIryoKikanSekkaiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoKikanSekkaiUmuKubun
     *
     * @param ik_tokubetsuIryoKikanSekkaiUmuKubun
     * ik_tokubetsuIryoKikanSekkaiUmuKubun
     */
    public void setIk_tokubetsuIryoKikanSekkaiUmuKubun(boolean ik_tokubetsuIryoKikanSekkaiUmuKubun) {
        this.ik_tokubetsuIryoKikanSekkaiUmuKubun = ik_tokubetsuIryoKikanSekkaiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoTotsuKangoUmuKubun
     *
     * @return ik_tokubetsuIryoTotsuKangoUmuKubun
     */
    public boolean getIk_tokubetsuIryoTotsuKangoUmuKubun() {
        return ik_tokubetsuIryoTotsuKangoUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoTotsuKangoUmuKubun
     *
     * @param ik_tokubetsuIryoTotsuKangoUmuKubun
     * ik_tokubetsuIryoTotsuKangoUmuKubun
     */
    public void setIk_tokubetsuIryoTotsuKangoUmuKubun(boolean ik_tokubetsuIryoTotsuKangoUmuKubun) {
        this.ik_tokubetsuIryoTotsuKangoUmuKubun = ik_tokubetsuIryoTotsuKangoUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoKeikanEiyoUmuKubun
     *
     * @return ik_tokubetsuIryoKeikanEiyoUmuKubun
     */
    public boolean getIk_tokubetsuIryoKeikanEiyoUmuKubun() {
        return ik_tokubetsuIryoKeikanEiyoUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoKeikanEiyoUmuKubun
     *
     * @param ik_tokubetsuIryoKeikanEiyoUmuKubun
     * ik_tokubetsuIryoKeikanEiyoUmuKubun
     */
    public void setIk_tokubetsuIryoKeikanEiyoUmuKubun(boolean ik_tokubetsuIryoKeikanEiyoUmuKubun) {
        this.ik_tokubetsuIryoKeikanEiyoUmuKubun = ik_tokubetsuIryoKeikanEiyoUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoMonitorSokuteiUmuKubun
     *
     * @return ik_tokubetsuIryoMonitorSokuteiUmuKubun
     */
    public boolean getIk_tokubetsuIryoMonitorSokuteiUmuKubun() {
        return ik_tokubetsuIryoMonitorSokuteiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoMonitorSokuteiUmuKubun
     *
     * @param ik_tokubetsuIryoMonitorSokuteiUmuKubun
     * ik_tokubetsuIryoMonitorSokuteiUmuKubun
     */
    public void setIk_tokubetsuIryoMonitorSokuteiUmuKubun(boolean ik_tokubetsuIryoMonitorSokuteiUmuKubun) {
        this.ik_tokubetsuIryoMonitorSokuteiUmuKubun = ik_tokubetsuIryoMonitorSokuteiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoJokusoShochiUmuKubun
     *
     * @return ik_tokubetsuIryoJokusoShochiUmuKubun
     */
    public boolean getIk_tokubetsuIryoJokusoShochiUmuKubun() {
        return ik_tokubetsuIryoJokusoShochiUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoJokusoShochiUmuKubun
     *
     * @param ik_tokubetsuIryoJokusoShochiUmuKubun
     * ik_tokubetsuIryoJokusoShochiUmuKubun
     */
    public void setIk_tokubetsuIryoJokusoShochiUmuKubun(boolean ik_tokubetsuIryoJokusoShochiUmuKubun) {
        this.ik_tokubetsuIryoJokusoShochiUmuKubun = ik_tokubetsuIryoJokusoShochiUmuKubun;
    }

    /**
     * getIk_tokubetsuIryoCatheterUmuKubun
     *
     * @return ik_tokubetsuIryoCatheterUmuKubun
     */
    public boolean getIk_tokubetsuIryoCatheterUmuKubun() {
        return ik_tokubetsuIryoCatheterUmuKubun;
    }

    /**
     * setIk_tokubetsuIryoCatheterUmuKubun
     *
     * @param ik_tokubetsuIryoCatheterUmuKubun ik_tokubetsuIryoCatheterUmuKubun
     */
    public void setIk_tokubetsuIryoCatheterUmuKubun(boolean ik_tokubetsuIryoCatheterUmuKubun) {
        this.ik_tokubetsuIryoCatheterUmuKubun = ik_tokubetsuIryoCatheterUmuKubun;
    }

    /**
     * getIk_seikatsuJiritsudoShyogaiCode
     *
     * @return ik_seikatsuJiritsudoShyogaiCode
     */
    public Code getIk_seikatsuJiritsudoShyogaiCode() {
        return ik_seikatsuJiritsudoShyogaiCode;
    }

    /**
     * setIk_seikatsuJiritsudoShyogaiCode
     *
     * @param ik_seikatsuJiritsudoShyogaiCode ik_seikatsuJiritsudoShyogaiCode
     */
    public void setIk_seikatsuJiritsudoShyogaiCode(Code ik_seikatsuJiritsudoShyogaiCode) {
        this.ik_seikatsuJiritsudoShyogaiCode = ik_seikatsuJiritsudoShyogaiCode;
    }

    /**
     * getIk_seikatsuJiritsudoShyogaiCodeMeisho
     *
     * @return Meisho
     */
    public RString getIk_seikatsuJiritsudoShyogaiCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.障害高齢者自立度, ik_seikatsuJiritsudoShyogaiCode);
    }

    /**
     * getIk_seikatsuJiritsudoShyogaiCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getIk_seikatsuJiritsudoShyogaiCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.障害高齢者自立度, ik_seikatsuJiritsudoShyogaiCode);
    }

    /**
     * getIk_seikatsuJiritsudoNinchshoCode
     *
     * @return ik_seikatsuJiritsudoNinchshoCode
     */
    public Code getIk_seikatsuJiritsudoNinchshoCode() {
        return ik_seikatsuJiritsudoNinchshoCode;
    }

    /**
     * setIk_seikatsuJiritsudoNinchshoCode
     *
     * @param ik_seikatsuJiritsudoNinchshoCode ik_seikatsuJiritsudoNinchshoCode
     */
    public void setIk_seikatsuJiritsudoNinchshoCode(Code ik_seikatsuJiritsudoNinchshoCode) {
        this.ik_seikatsuJiritsudoNinchshoCode = ik_seikatsuJiritsudoNinchshoCode;
    }

    /**
     * getIk_seikatsuJiritsudoNinchshoCodeMeisho
     *
     * @return Meisho
     */
    public RString getIk_seikatsuJiritsudoNinchshoCodeMeisho() {
        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認知症高齢者自立度, ik_seikatsuJiritsudoNinchshoCode);
    }

    /**
     * getIk_seikatsuJiritsudoNinchshoCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getIk_seikatsuJiritsudoNinchshoCodeRyakusho() {
        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.認知症高齢者自立度, ik_seikatsuJiritsudoNinchshoCode);
    }

    /**
     * getIk_chukakuShojoTankiKioku
     *
     * @return ik_chukakuShojoTankiKioku
     */
    public RString getIk_chukakuShojoTankiKioku() {
        return ik_chukakuShojoTankiKioku;
    }

    /**
     * setIk_chukakuShojoTankiKioku
     *
     * @param ik_chukakuShojoTankiKioku ik_chukakuShojoTankiKioku
     */
    public void setIk_chukakuShojoTankiKioku(RString ik_chukakuShojoTankiKioku) {
        this.ik_chukakuShojoTankiKioku = ik_chukakuShojoTankiKioku;
    }

    /**
     * getIk_chukakuShojoNinchiNoryoku
     *
     * @return ik_chukakuShojoNinchiNoryoku
     */
    public RString getIk_chukakuShojoNinchiNoryoku() {
        return ik_chukakuShojoNinchiNoryoku;
    }

    /**
     * setIk_chukakuShojoNinchiNoryoku
     *
     * @param ik_chukakuShojoNinchiNoryoku ik_chukakuShojoNinchiNoryoku
     */
    public void setIk_chukakuShojoNinchiNoryoku(RString ik_chukakuShojoNinchiNoryoku) {
        this.ik_chukakuShojoNinchiNoryoku = ik_chukakuShojoNinchiNoryoku;
    }

    /**
     * getIk_chukakuShojoDentatsuNoryoku
     *
     * @return ik_chukakuShojoDentatsuNoryoku
     */
    public RString getIk_chukakuShojoDentatsuNoryoku() {
        return ik_chukakuShojoDentatsuNoryoku;
    }

    /**
     * setIk_chukakuShojoDentatsuNoryoku
     *
     * @param ik_chukakuShojoDentatsuNoryoku ik_chukakuShojoDentatsuNoryoku
     */
    public void setIk_chukakuShojoDentatsuNoryoku(RString ik_chukakuShojoDentatsuNoryoku) {
        this.ik_chukakuShojoDentatsuNoryoku = ik_chukakuShojoDentatsuNoryoku;
    }

    /**
     * getIk_shuhenShojoUmuKubun
     *
     * @return ik_shuhenShojoUmuKubun
     */
    public boolean getIk_shuhenShojoUmuKubun() {
        return ik_shuhenShojoUmuKubun;
    }

    /**
     * setIk_shuhenShojoUmuKubun
     *
     * @param ik_shuhenShojoUmuKubun ik_shuhenShojoUmuKubun
     */
    public void setIk_shuhenShojoUmuKubun(boolean ik_shuhenShojoUmuKubun) {
        this.ik_shuhenShojoUmuKubun = ik_shuhenShojoUmuKubun;
    }

    /**
     * getIk_shuhenShojoGenshiGenchoUmuKubun
     *
     * @return ik_shuhenShojoGenshiGenchoUmuKubun
     */
    public boolean getIk_shuhenShojoGenshiGenchoUmuKubun() {
        return ik_shuhenShojoGenshiGenchoUmuKubun;
    }

    /**
     * setIk_shuhenShojoGenshiGenchoUmuKubun
     *
     * @param ik_shuhenShojoGenshiGenchoUmuKubun
     * ik_shuhenShojoGenshiGenchoUmuKubun
     */
    public void setIk_shuhenShojoGenshiGenchoUmuKubun(boolean ik_shuhenShojoGenshiGenchoUmuKubun) {
        this.ik_shuhenShojoGenshiGenchoUmuKubun = ik_shuhenShojoGenshiGenchoUmuKubun;
    }

    /**
     * getIk_shuhenShojoMosoUmuKubun
     *
     * @return ik_shuhenShojoMosoUmuKubun
     */
    public boolean getIk_shuhenShojoMosoUmuKubun() {
        return ik_shuhenShojoMosoUmuKubun;
    }

    /**
     * setIk_shuhenShojoMosoUmuKubun
     *
     * @param ik_shuhenShojoMosoUmuKubun ik_shuhenShojoMosoUmuKubun
     */
    public void setIk_shuhenShojoMosoUmuKubun(boolean ik_shuhenShojoMosoUmuKubun) {
        this.ik_shuhenShojoMosoUmuKubun = ik_shuhenShojoMosoUmuKubun;
    }

    /**
     * getIk_shuhenShojoChuyaGakutenUmuKubun
     *
     * @return ik_shuhenShojoChuyaGakutenUmuKubun
     */
    public boolean getIk_shuhenShojoChuyaGakutenUmuKubun() {
        return ik_shuhenShojoChuyaGakutenUmuKubun;
    }

    /**
     * setIk_shuhenShojoChuyaGakutenUmuKubun
     *
     * @param ik_shuhenShojoChuyaGakutenUmuKubun
     * ik_shuhenShojoChuyaGakutenUmuKubun
     */
    public void setIk_shuhenShojoChuyaGakutenUmuKubun(boolean ik_shuhenShojoChuyaGakutenUmuKubun) {
        this.ik_shuhenShojoChuyaGakutenUmuKubun = ik_shuhenShojoChuyaGakutenUmuKubun;
    }

    /**
     * getIk_shuhenShojoBogenUmuKubun
     *
     * @return ik_shuhenShojoBogenUmuKubun
     */
    public boolean getIk_shuhenShojoBogenUmuKubun() {
        return ik_shuhenShojoBogenUmuKubun;
    }

    /**
     * setIk_shuhenShojoBogenUmuKubun
     *
     * @param ik_shuhenShojoBogenUmuKubun ik_shuhenShojoBogenUmuKubun
     */
    public void setIk_shuhenShojoBogenUmuKubun(boolean ik_shuhenShojoBogenUmuKubun) {
        this.ik_shuhenShojoBogenUmuKubun = ik_shuhenShojoBogenUmuKubun;
    }

    /**
     * getIk_shuhenShojoBokoUmuKubun
     *
     * @return ik_shuhenShojoBokoUmuKubun
     */
    public boolean getIk_shuhenShojoBokoUmuKubun() {
        return ik_shuhenShojoBokoUmuKubun;
    }

    /**
     * setIk_shuhenShojoBokoUmuKubun
     *
     * @param ik_shuhenShojoBokoUmuKubun ik_shuhenShojoBokoUmuKubun
     */
    public void setIk_shuhenShojoBokoUmuKubun(boolean ik_shuhenShojoBokoUmuKubun) {
        this.ik_shuhenShojoBokoUmuKubun = ik_shuhenShojoBokoUmuKubun;
    }

    /**
     * getIk_shuhenShojoKaigoHenoTeikoUmuKubun
     *
     * @return ik_shuhenShojoKaigoHenoTeikoUmuKubun
     */
    public boolean getIk_shuhenShojoKaigoHenoTeikoUmuKubun() {
        return ik_shuhenShojoKaigoHenoTeikoUmuKubun;
    }

    /**
     * setIk_shuhenShojoKaigoHenoTeikoUmuKubun
     *
     * @param ik_shuhenShojoKaigoHenoTeikoUmuKubun
     * ik_shuhenShojoKaigoHenoTeikoUmuKubun
     */
    public void setIk_shuhenShojoKaigoHenoTeikoUmuKubun(boolean ik_shuhenShojoKaigoHenoTeikoUmuKubun) {
        this.ik_shuhenShojoKaigoHenoTeikoUmuKubun = ik_shuhenShojoKaigoHenoTeikoUmuKubun;
    }

    /**
     * getIk_shuhenShojoHaikaiUmuKubun
     *
     * @return ik_shuhenShojoHaikaiUmuKubun
     */
    public boolean getIk_shuhenShojoHaikaiUmuKubun() {
        return ik_shuhenShojoHaikaiUmuKubun;
    }

    /**
     * setIk_shuhenShojoHaikaiUmuKubun
     *
     * @param ik_shuhenShojoHaikaiUmuKubun ik_shuhenShojoHaikaiUmuKubun
     */
    public void setIk_shuhenShojoHaikaiUmuKubun(boolean ik_shuhenShojoHaikaiUmuKubun) {
        this.ik_shuhenShojoHaikaiUmuKubun = ik_shuhenShojoHaikaiUmuKubun;
    }

    /**
     * getIk_shuhenShojoHiNoFushimatsuUmuKubun
     *
     * @return ik_shuhenShojoHiNoFushimatsuUmuKubun
     */
    public boolean getIk_shuhenShojoHiNoFushimatsuUmuKubun() {
        return ik_shuhenShojoHiNoFushimatsuUmuKubun;
    }

    /**
     * setIk_shuhenShojoHiNoFushimatsuUmuKubun
     *
     * @param ik_shuhenShojoHiNoFushimatsuUmuKubun
     * ik_shuhenShojoHiNoFushimatsuUmuKubun
     */
    public void setIk_shuhenShojoHiNoFushimatsuUmuKubun(boolean ik_shuhenShojoHiNoFushimatsuUmuKubun) {
        this.ik_shuhenShojoHiNoFushimatsuUmuKubun = ik_shuhenShojoHiNoFushimatsuUmuKubun;
    }

    /**
     * getIk_shuhenShojoFuketsuKoiUmuKubun
     *
     * @return ik_shuhenShojoFuketsuKoiUmuKubun
     */
    public boolean getIk_shuhenShojoFuketsuKoiUmuKubun() {
        return ik_shuhenShojoFuketsuKoiUmuKubun;
    }

    /**
     * setIk_shuhenShojoFuketsuKoiUmuKubun
     *
     * @param ik_shuhenShojoFuketsuKoiUmuKubun ik_shuhenShojoFuketsuKoiUmuKubun
     */
    public void setIk_shuhenShojoFuketsuKoiUmuKubun(boolean ik_shuhenShojoFuketsuKoiUmuKubun) {
        this.ik_shuhenShojoFuketsuKoiUmuKubun = ik_shuhenShojoFuketsuKoiUmuKubun;
    }

    /**
     * getIk_shuhenShojoIshokuKodoUmuKubun
     *
     * @return ik_shuhenShojoIshokuKodoUmuKubun
     */
    public boolean getIk_shuhenShojoIshokuKodoUmuKubun() {
        return ik_shuhenShojoIshokuKodoUmuKubun;
    }

    /**
     * setIk_shuhenShojoIshokuKodoUmuKubun
     *
     * @param ik_shuhenShojoIshokuKodoUmuKubun ik_shuhenShojoIshokuKodoUmuKubun
     */
    public void setIk_shuhenShojoIshokuKodoUmuKubun(boolean ik_shuhenShojoIshokuKodoUmuKubun) {
        this.ik_shuhenShojoIshokuKodoUmuKubun = ik_shuhenShojoIshokuKodoUmuKubun;
    }

    /**
     * getIk_shuhenShojoSeitekiMondaiKodoUmuKubun
     *
     * @return ik_shuhenShojoSeitekiMondaiKodoUmuKubun
     */
    public boolean getIk_shuhenShojoSeitekiMondaiKodoUmuKubun() {
        return ik_shuhenShojoSeitekiMondaiKodoUmuKubun;
    }

    /**
     * setIk_shuhenShojoSeitekiMondaiKodoUmuKubun
     *
     * @param ik_shuhenShojoSeitekiMondaiKodoUmuKubun
     * ik_shuhenShojoSeitekiMondaiKodoUmuKubun
     */
    public void setIk_shuhenShojoSeitekiMondaiKodoUmuKubun(boolean ik_shuhenShojoSeitekiMondaiKodoUmuKubun) {
        this.ik_shuhenShojoSeitekiMondaiKodoUmuKubun = ik_shuhenShojoSeitekiMondaiKodoUmuKubun;
    }

    /**
     * getIk_shuhenShojoSonotaUmuKubun
     *
     * @return ik_shuhenShojoSonotaUmuKubun
     */
    public boolean getIk_shuhenShojoSonotaUmuKubun() {
        return ik_shuhenShojoSonotaUmuKubun;
    }

    /**
     * setIk_shuhenShojoSonotaUmuKubun
     *
     * @param ik_shuhenShojoSonotaUmuKubun ik_shuhenShojoSonotaUmuKubun
     */
    public void setIk_shuhenShojoSonotaUmuKubun(boolean ik_shuhenShojoSonotaUmuKubun) {
        this.ik_shuhenShojoSonotaUmuKubun = ik_shuhenShojoSonotaUmuKubun;
    }

    /**
     * getIk_shuhenShojoSonotaNaiyo
     *
     * @return ik_shuhenShojoSonotaNaiyo
     */
    public RString getIk_shuhenShojoSonotaNaiyo() {
        return ik_shuhenShojoSonotaNaiyo;
    }

    /**
     * setIk_shuhenShojoSonotaNaiyo
     *
     * @param ik_shuhenShojoSonotaNaiyo ik_shuhenShojoSonotaNaiyo
     */
    public void setIk_shuhenShojoSonotaNaiyo(RString ik_shuhenShojoSonotaNaiyo) {
        this.ik_shuhenShojoSonotaNaiyo = ik_shuhenShojoSonotaNaiyo;
    }

    /**
     * getIk_seishinOrShinkeiShojoUmuKubun
     *
     * @return ik_seishinOrShinkeiShojoUmuKubun
     */
    public boolean getIk_seishinOrShinkeiShojoUmuKubun() {
        return ik_seishinOrShinkeiShojoUmuKubun;
    }

    /**
     * setIk_seishinOrShinkeiShojoUmuKubun
     *
     * @param ik_seishinOrShinkeiShojoUmuKubun ik_seishinOrShinkeiShojoUmuKubun
     */
    public void setIk_seishinOrShinkeiShojoUmuKubun(boolean ik_seishinOrShinkeiShojoUmuKubun) {
        this.ik_seishinOrShinkeiShojoUmuKubun = ik_seishinOrShinkeiShojoUmuKubun;
    }

    /**
     * getIk_seishinOrShinkeiShojoShimei
     *
     * @return ik_seishinOrShinkeiShojoShimei
     */
    public RString getIk_seishinOrShinkeiShojoShimei() {
        return ik_seishinOrShinkeiShojoShimei;
    }

    /**
     * setIk_seishinOrShinkeiShojoShimei
     *
     * @param ik_seishinOrShinkeiShojoShimei ik_seishinOrShinkeiShojoShimei
     */
    public void setIk_seishinOrShinkeiShojoShimei(RString ik_seishinOrShinkeiShojoShimei) {
        this.ik_seishinOrShinkeiShojoShimei = ik_seishinOrShinkeiShojoShimei;
    }

    /**
     * getIk_semmonkaiJushinUmuKubun
     *
     * @return ik_semmonkaiJushinUmuKubun
     */
    public boolean getIk_semmonkaiJushinUmuKubun() {
        return ik_semmonkaiJushinUmuKubun;
    }

    /**
     * setIk_semmonkaiJushinUmuKubun
     *
     * @param ik_semmonkaiJushinUmuKubun ik_semmonkaiJushinUmuKubun
     */
    public void setIk_semmonkaiJushinUmuKubun(boolean ik_semmonkaiJushinUmuKubun) {
        this.ik_semmonkaiJushinUmuKubun = ik_semmonkaiJushinUmuKubun;
    }

    /**
     * getIk_semmonkaiJushin
     *
     * @return ik_semmonkaiJushin
     */
    public RString getIk_semmonkaiJushin() {
        return ik_semmonkaiJushin;
    }

    /**
     * setIk_semmonkaiJushin
     *
     * @param ik_semmonkaiJushin ik_semmonkaiJushin
     */
    public void setIk_semmonkaiJushin(RString ik_semmonkaiJushin) {
        this.ik_semmonkaiJushin = ik_semmonkaiJushin;
    }

    /**
     * getIk_kikiudeKubun
     *
     * @return ik_kikiudeKubun
     */
    public RString getIk_kikiudeKubun() {
        return ik_kikiudeKubun;
    }

    /**
     * setIk_kikiudeKubun
     *
     * @param ik_kikiudeKubun ik_kikiudeKubun
     */
    public void setIk_kikiudeKubun(RString ik_kikiudeKubun) {
        this.ik_kikiudeKubun = ik_kikiudeKubun;
    }

    /**
     * getIk_shincho
     *
     * @return ik_shincho
     */
    public int getIk_shincho() {
        return ik_shincho;
    }

    /**
     * setIk_shincho
     *
     * @param ik_shincho ik_shincho
     */
    public void setIk_shincho(int ik_shincho) {
        this.ik_shincho = ik_shincho;
    }

    /**
     * getIk_taiju
     *
     * @return ik_taiju
     */
    public int getIk_taiju() {
        return ik_taiju;
    }

    /**
     * setIk_taiju
     *
     * @param ik_taiju ik_taiju
     */
    public void setIk_taiju(int ik_taiju) {
        this.ik_taiju = ik_taiju;
    }

    /**
     * getIk_taijuHenka
     *
     * @return ik_taijuHenka
     */
    public RString getIk_taijuHenka() {
        return ik_taijuHenka;
    }

    /**
     * setIk_taijuHenka
     *
     * @param ik_taijuHenka ik_taijuHenka
     */
    public void setIk_taijuHenka(RString ik_taijuHenka) {
        this.ik_taijuHenka = ik_taijuHenka;
    }

    /**
     * getIk_shishiKessonUmuKubun
     *
     * @return ik_shishiKessonUmuKubun
     */
    public boolean getIk_shishiKessonUmuKubun() {
        return ik_shishiKessonUmuKubun;
    }

    /**
     * setIk_shishiKessonUmuKubun
     *
     * @param ik_shishiKessonUmuKubun ik_shishiKessonUmuKubun
     */
    public void setIk_shishiKessonUmuKubun(boolean ik_shishiKessonUmuKubun) {
        this.ik_shishiKessonUmuKubun = ik_shishiKessonUmuKubun;
    }

    /**
     * getIk_shishiKessonBui
     *
     * @return ik_shishiKessonBui
     */
    public RString getIk_shishiKessonBui() {
        return ik_shishiKessonBui;
    }

    /**
     * setIk_shishiKessonBui
     *
     * @param ik_shishiKessonBui ik_shishiKessonBui
     */
    public void setIk_shishiKessonBui(RString ik_shishiKessonBui) {
        this.ik_shishiKessonBui = ik_shishiKessonBui;
    }

    /**
     * getIk_shishiKessonTeido
     *
     * @return ik_shishiKessonTeido
     */
    public RString getIk_shishiKessonTeido() {
        return ik_shishiKessonTeido;
    }

    /**
     * setIk_shishiKessonTeido
     *
     * @param ik_shishiKessonTeido ik_shishiKessonTeido
     */
    public void setIk_shishiKessonTeido(RString ik_shishiKessonTeido) {
        this.ik_shishiKessonTeido = ik_shishiKessonTeido;
    }

    /**
     * getIk_mahiUmuKubun
     *
     * @return ik_mahiUmuKubun
     */
    public boolean getIk_mahiUmuKubun() {
        return ik_mahiUmuKubun;
    }

    /**
     * setIk_mahiUmuKubun
     *
     * @param ik_mahiUmuKubun ik_mahiUmuKubun
     */
    public void setIk_mahiUmuKubun(boolean ik_mahiUmuKubun) {
        this.ik_mahiUmuKubun = ik_mahiUmuKubun;
    }

    /**
     * getIk_mahiTeido
     *
     * @return ik_mahiTeido
     */
    public RString getIk_mahiTeido() {
        return ik_mahiTeido;
    }

    /**
     * setIk_mahiTeido
     *
     * @param ik_mahiTeido ik_mahiTeido
     */
    public void setIk_mahiTeido(RString ik_mahiTeido) {
        this.ik_mahiTeido = ik_mahiTeido;
    }

    /**
     * getIk_mahiHidariJoshi
     *
     * @return ik_mahiHidariJoshi
     */
    public RString getIk_mahiHidariJoshi() {
        return ik_mahiHidariJoshi;
    }

    /**
     * setIk_mahiHidariJoshi
     *
     * @param ik_mahiHidariJoshi ik_mahiHidariJoshi
     */
    public void setIk_mahiHidariJoshi(RString ik_mahiHidariJoshi) {
        this.ik_mahiHidariJoshi = ik_mahiHidariJoshi;
    }

    /**
     * getIk_mahiMigiJoshi
     *
     * @return ik_mahiMigiJoshi
     */
    public RString getIk_mahiMigiJoshi() {
        return ik_mahiMigiJoshi;
    }

    /**
     * setIk_mahiMigiJoshi
     *
     * @param ik_mahiMigiJoshi ik_mahiMigiJoshi
     */
    public void setIk_mahiMigiJoshi(RString ik_mahiMigiJoshi) {
        this.ik_mahiMigiJoshi = ik_mahiMigiJoshi;
    }

    /**
     * getIk_mahiHidariKashi
     *
     * @return ik_mahiHidariKashi
     */
    public RString getIk_mahiHidariKashi() {
        return ik_mahiHidariKashi;
    }

    /**
     * setIk_mahiHidariKashi
     *
     * @param ik_mahiHidariKashi ik_mahiHidariKashi
     */
    public void setIk_mahiHidariKashi(RString ik_mahiHidariKashi) {
        this.ik_mahiHidariKashi = ik_mahiHidariKashi;
    }

    /**
     * getIk_mahiMigiKashi
     *
     * @return ik_mahiMigiKashi
     */
    public RString getIk_mahiMigiKashi() {
        return ik_mahiMigiKashi;
    }

    /**
     * setIk_mahiMigiKashi
     *
     * @param ik_mahiMigiKashi ik_mahiMigiKashi
     */
    public void setIk_mahiMigiKashi(RString ik_mahiMigiKashi) {
        this.ik_mahiMigiKashi = ik_mahiMigiKashi;
    }

    /**
     * getIk_mahiSonota
     *
     * @return ik_mahiSonota
     */
    public RString getIk_mahiSonota() {
        return ik_mahiSonota;
    }

    /**
     * setIk_mahiSonota
     *
     * @param ik_mahiSonota ik_mahiSonota
     */
    public void setIk_mahiSonota(RString ik_mahiSonota) {
        this.ik_mahiSonota = ik_mahiSonota;
    }

    /**
     * getIk_kinryokuTeikaUmuKubun
     *
     * @return ik_kinryokuTeikaUmuKubun
     */
    public boolean getIk_kinryokuTeikaUmuKubun() {
        return ik_kinryokuTeikaUmuKubun;
    }

    /**
     * setIk_kinryokuTeikaUmuKubun
     *
     * @param ik_kinryokuTeikaUmuKubun ik_kinryokuTeikaUmuKubun
     */
    public void setIk_kinryokuTeikaUmuKubun(boolean ik_kinryokuTeikaUmuKubun) {
        this.ik_kinryokuTeikaUmuKubun = ik_kinryokuTeikaUmuKubun;
    }

    /**
     * getIk_kinryokuTeikaBui
     *
     * @return ik_kinryokuTeikaBui
     */
    public RString getIk_kinryokuTeikaBui() {
        return ik_kinryokuTeikaBui;
    }

    /**
     * setIk_kinryokuTeikaBui
     *
     * @param ik_kinryokuTeikaBui ik_kinryokuTeikaBui
     */
    public void setIk_kinryokuTeikaBui(RString ik_kinryokuTeikaBui) {
        this.ik_kinryokuTeikaBui = ik_kinryokuTeikaBui;
    }

    /**
     * getIk_kinryokuTeikaTeido
     *
     * @return ik_kinryokuTeikaTeido
     */
    public RString getIk_kinryokuTeikaTeido() {
        return ik_kinryokuTeikaTeido;
    }

    /**
     * setIk_kinryokuTeikaTeido
     *
     * @param ik_kinryokuTeikaTeido ik_kinryokuTeikaTeido
     */
    public void setIk_kinryokuTeikaTeido(RString ik_kinryokuTeikaTeido) {
        this.ik_kinryokuTeikaTeido = ik_kinryokuTeikaTeido;
    }

    /**
     * getIk_koshukuMigiKataUmuKubun
     *
     * @return ik_koshukuMigiKataUmuKubun
     */
    public boolean getIk_koshukuMigiKataUmuKubun() {
        return ik_koshukuMigiKataUmuKubun;
    }

    /**
     * setIk_koshukuMigiKataUmuKubun
     *
     * @param ik_koshukuMigiKataUmuKubun ik_koshukuMigiKataUmuKubun
     */
    public void setIk_koshukuMigiKataUmuKubun(boolean ik_koshukuMigiKataUmuKubun) {
        this.ik_koshukuMigiKataUmuKubun = ik_koshukuMigiKataUmuKubun;
    }

    /**
     * getIk_koshukuHidariKataUmuKubun
     *
     * @return ik_koshukuHidariKataUmuKubun
     */
    public boolean getIk_koshukuHidariKataUmuKubun() {
        return ik_koshukuHidariKataUmuKubun;
    }

    /**
     * setIk_koshukuHidariKataUmuKubun
     *
     * @param ik_koshukuHidariKataUmuKubun ik_koshukuHidariKataUmuKubun
     */
    public void setIk_koshukuHidariKataUmuKubun(boolean ik_koshukuHidariKataUmuKubun) {
        this.ik_koshukuHidariKataUmuKubun = ik_koshukuHidariKataUmuKubun;
    }

    /**
     * getIk_koshukuMigiHijiUmuKubun
     *
     * @return ik_koshukuMigiHijiUmuKubun
     */
    public boolean getIk_koshukuMigiHijiUmuKubun() {
        return ik_koshukuMigiHijiUmuKubun;
    }

    /**
     * setIk_koshukuMigiHijiUmuKubun
     *
     * @param ik_koshukuMigiHijiUmuKubun ik_koshukuMigiHijiUmuKubun
     */
    public void setIk_koshukuMigiHijiUmuKubun(boolean ik_koshukuMigiHijiUmuKubun) {
        this.ik_koshukuMigiHijiUmuKubun = ik_koshukuMigiHijiUmuKubun;
    }

    /**
     * getIk_koshukuHidariHijiUmuKubun
     *
     * @return ik_koshukuHidariHijiUmuKubun
     */
    public boolean getIk_koshukuHidariHijiUmuKubun() {
        return ik_koshukuHidariHijiUmuKubun;
    }

    /**
     * setIk_koshukuHidariHijiUmuKubun
     *
     * @param ik_koshukuHidariHijiUmuKubun ik_koshukuHidariHijiUmuKubun
     */
    public void setIk_koshukuHidariHijiUmuKubun(boolean ik_koshukuHidariHijiUmuKubun) {
        this.ik_koshukuHidariHijiUmuKubun = ik_koshukuHidariHijiUmuKubun;
    }

    /**
     * getIk_koshukuMigiMataUmuKubun
     *
     * @return ik_koshukuMigiMataUmuKubun
     */
    public boolean getIk_koshukuMigiMataUmuKubun() {
        return ik_koshukuMigiMataUmuKubun;
    }

    /**
     * setIk_koshukuMigiMataUmuKubun
     *
     * @param ik_koshukuMigiMataUmuKubun ik_koshukuMigiMataUmuKubun
     */
    public void setIk_koshukuMigiMataUmuKubun(boolean ik_koshukuMigiMataUmuKubun) {
        this.ik_koshukuMigiMataUmuKubun = ik_koshukuMigiMataUmuKubun;
    }

    /**
     * getIk_koshukuHidariMataUmuKubun
     *
     * @return ik_koshukuHidariMataUmuKubun
     */
    public boolean getIk_koshukuHidariMataUmuKubun() {
        return ik_koshukuHidariMataUmuKubun;
    }

    /**
     * setIk_koshukuHidariMataUmuKubun
     *
     * @param ik_koshukuHidariMataUmuKubun ik_koshukuHidariMataUmuKubun
     */
    public void setIk_koshukuHidariMataUmuKubun(boolean ik_koshukuHidariMataUmuKubun) {
        this.ik_koshukuHidariMataUmuKubun = ik_koshukuHidariMataUmuKubun;
    }

    /**
     * getIk_koshukuMigiHizaUmuKubun
     *
     * @return ik_koshukuMigiHizaUmuKubun
     */
    public boolean getIk_koshukuMigiHizaUmuKubun() {
        return ik_koshukuMigiHizaUmuKubun;
    }

    /**
     * setIk_koshukuMigiHizaUmuKubun
     *
     * @param ik_koshukuMigiHizaUmuKubun ik_koshukuMigiHizaUmuKubun
     */
    public void setIk_koshukuMigiHizaUmuKubun(boolean ik_koshukuMigiHizaUmuKubun) {
        this.ik_koshukuMigiHizaUmuKubun = ik_koshukuMigiHizaUmuKubun;
    }

    /**
     * getIk_koshukuHidariHizaUmuKubun
     *
     * @return ik_koshukuHidariHizaUmuKubun
     */
    public boolean getIk_koshukuHidariHizaUmuKubun() {
        return ik_koshukuHidariHizaUmuKubun;
    }

    /**
     * setIk_koshukuHidariHizaUmuKubun
     *
     * @param ik_koshukuHidariHizaUmuKubun ik_koshukuHidariHizaUmuKubun
     */
    public void setIk_koshukuHidariHizaUmuKubun(boolean ik_koshukuHidariHizaUmuKubun) {
        this.ik_koshukuHidariHizaUmuKubun = ik_koshukuHidariHizaUmuKubun;
    }

    /**
     * getIk_kansetsuKoshukuTeido
     *
     * @return ik_kansetsuKoshukuTeido
     */
    public RString getIk_kansetsuKoshukuTeido() {
        return ik_kansetsuKoshukuTeido;
    }

    /**
     * setIk_kansetsuKoshukuTeido
     *
     * @param ik_kansetsuKoshukuTeido ik_kansetsuKoshukuTeido
     */
    public void setIk_kansetsuKoshukuTeido(RString ik_kansetsuKoshukuTeido) {
        this.ik_kansetsuKoshukuTeido = ik_kansetsuKoshukuTeido;
    }

    /**
     * getIk_kansetsuItamiUmuKubun
     *
     * @return ik_kansetsuItamiUmuKubun
     */
    public boolean getIk_kansetsuItamiUmuKubun() {
        return ik_kansetsuItamiUmuKubun;
    }

    /**
     * setIk_kansetsuItamiUmuKubun
     *
     * @param ik_kansetsuItamiUmuKubun ik_kansetsuItamiUmuKubun
     */
    public void setIk_kansetsuItamiUmuKubun(boolean ik_kansetsuItamiUmuKubun) {
        this.ik_kansetsuItamiUmuKubun = ik_kansetsuItamiUmuKubun;
    }

    /**
     * getIk_kansetsuItamiBui
     *
     * @return ik_kansetsuItamiBui
     */
    public RString getIk_kansetsuItamiBui() {
        return ik_kansetsuItamiBui;
    }

    /**
     * setIk_kansetsuItamiBui
     *
     * @param ik_kansetsuItamiBui ik_kansetsuItamiBui
     */
    public void setIk_kansetsuItamiBui(RString ik_kansetsuItamiBui) {
        this.ik_kansetsuItamiBui = ik_kansetsuItamiBui;
    }

    /**
     * getIk_kansatsuItamiTeido
     *
     * @return ik_kansatsuItamiTeido
     */
    public RString getIk_kansatsuItamiTeido() {
        return ik_kansatsuItamiTeido;
    }

    /**
     * setIk_kansatsuItamiTeido
     *
     * @param ik_kansatsuItamiTeido ik_kansatsuItamiTeido
     */
    public void setIk_kansatsuItamiTeido(RString ik_kansatsuItamiTeido) {
        this.ik_kansatsuItamiTeido = ik_kansatsuItamiTeido;
    }

    /**
     * getIk_huzuiiUmuKubun
     *
     * @return ik_huzuiiUmuKubun
     */
    public boolean getIk_huzuiiUmuKubun() {
        return ik_huzuiiUmuKubun;
    }

    /**
     * setIk_huzuiiUmuKubun
     *
     * @param ik_huzuiiUmuKubun ik_huzuiiUmuKubun
     */
    public void setIk_huzuiiUmuKubun(boolean ik_huzuiiUmuKubun) {
        this.ik_huzuiiUmuKubun = ik_huzuiiUmuKubun;
    }

    /**
     * getIk_huzuiiMigiJoshiUmuKubun
     *
     * @return ik_huzuiiMigiJoshiUmuKubun
     */
    public boolean getIk_huzuiiMigiJoshiUmuKubun() {
        return ik_huzuiiMigiJoshiUmuKubun;
    }

    /**
     * setIk_huzuiiMigiJoshiUmuKubun
     *
     * @param ik_huzuiiMigiJoshiUmuKubun ik_huzuiiMigiJoshiUmuKubun
     */
    public void setIk_huzuiiMigiJoshiUmuKubun(boolean ik_huzuiiMigiJoshiUmuKubun) {
        this.ik_huzuiiMigiJoshiUmuKubun = ik_huzuiiMigiJoshiUmuKubun;
    }

    /**
     * getIk_huzuiiHidariJoshiUmuKubun
     *
     * @return ik_huzuiiHidariJoshiUmuKubun
     */
    public boolean getIk_huzuiiHidariJoshiUmuKubun() {
        return ik_huzuiiHidariJoshiUmuKubun;
    }

    /**
     * setIk_huzuiiHidariJoshiUmuKubun
     *
     * @param ik_huzuiiHidariJoshiUmuKubun ik_huzuiiHidariJoshiUmuKubun
     */
    public void setIk_huzuiiHidariJoshiUmuKubun(boolean ik_huzuiiHidariJoshiUmuKubun) {
        this.ik_huzuiiHidariJoshiUmuKubun = ik_huzuiiHidariJoshiUmuKubun;
    }

    /**
     * getIk_huzuiiMigiTaikanUmuKubun
     *
     * @return ik_huzuiiMigiTaikanUmuKubun
     */
    public boolean getIk_huzuiiMigiTaikanUmuKubun() {
        return ik_huzuiiMigiTaikanUmuKubun;
    }

    /**
     * setIk_huzuiiMigiTaikanUmuKubun
     *
     * @param ik_huzuiiMigiTaikanUmuKubun ik_huzuiiMigiTaikanUmuKubun
     */
    public void setIk_huzuiiMigiTaikanUmuKubun(boolean ik_huzuiiMigiTaikanUmuKubun) {
        this.ik_huzuiiMigiTaikanUmuKubun = ik_huzuiiMigiTaikanUmuKubun;
    }

    /**
     * getIk_huzuiiHidariTaikanUmuKubun
     *
     * @return ik_huzuiiHidariTaikanUmuKubun
     */
    public boolean getIk_huzuiiHidariTaikanUmuKubun() {
        return ik_huzuiiHidariTaikanUmuKubun;
    }

    /**
     * setIk_huzuiiHidariTaikanUmuKubun
     *
     * @param ik_huzuiiHidariTaikanUmuKubun ik_huzuiiHidariTaikanUmuKubun
     */
    public void setIk_huzuiiHidariTaikanUmuKubun(boolean ik_huzuiiHidariTaikanUmuKubun) {
        this.ik_huzuiiHidariTaikanUmuKubun = ik_huzuiiHidariTaikanUmuKubun;
    }

    /**
     * getIk_huzuiiMigiKashiUmuKubun
     *
     * @return ik_huzuiiMigiKashiUmuKubun
     */
    public boolean getIk_huzuiiMigiKashiUmuKubun() {
        return ik_huzuiiMigiKashiUmuKubun;
    }

    /**
     * setIk_huzuiiMigiKashiUmuKubun
     *
     * @param ik_huzuiiMigiKashiUmuKubun ik_huzuiiMigiKashiUmuKubun
     */
    public void setIk_huzuiiMigiKashiUmuKubun(boolean ik_huzuiiMigiKashiUmuKubun) {
        this.ik_huzuiiMigiKashiUmuKubun = ik_huzuiiMigiKashiUmuKubun;
    }

    /**
     * getIk_huzuiiHidariKashiUmuKubun
     *
     * @return ik_huzuiiHidariKashiUmuKubun
     */
    public boolean getIk_huzuiiHidariKashiUmuKubun() {
        return ik_huzuiiHidariKashiUmuKubun;
    }

    /**
     * setIk_huzuiiHidariKashiUmuKubun
     *
     * @param ik_huzuiiHidariKashiUmuKubun ik_huzuiiHidariKashiUmuKubun
     */
    public void setIk_huzuiiHidariKashiUmuKubun(boolean ik_huzuiiHidariKashiUmuKubun) {
        this.ik_huzuiiHidariKashiUmuKubun = ik_huzuiiHidariKashiUmuKubun;
    }

    /**
     * getIk_jokusoUmuKubun
     *
     * @return ik_jokusoUmuKubun
     */
    public boolean getIk_jokusoUmuKubun() {
        return ik_jokusoUmuKubun;
    }

    /**
     * setIk_jokusoUmuKubun
     *
     * @param ik_jokusoUmuKubun ik_jokusoUmuKubun
     */
    public void setIk_jokusoUmuKubun(boolean ik_jokusoUmuKubun) {
        this.ik_jokusoUmuKubun = ik_jokusoUmuKubun;
    }

    /**
     * getIk_jokusoBui
     *
     * @return ik_jokusoBui
     */
    public RString getIk_jokusoBui() {
        return ik_jokusoBui;
    }

    /**
     * setIk_jokusoBui
     *
     * @param ik_jokusoBui ik_jokusoBui
     */
    public void setIk_jokusoBui(RString ik_jokusoBui) {
        this.ik_jokusoBui = ik_jokusoBui;
    }

    /**
     * getIk_jokusoTeido
     *
     * @return ik_jokusoTeido
     */
    public RString getIk_jokusoTeido() {
        return ik_jokusoTeido;
    }

    /**
     * setIk_jokusoTeido
     *
     * @param ik_jokusoTeido ik_jokusoTeido
     */
    public void setIk_jokusoTeido(RString ik_jokusoTeido) {
        this.ik_jokusoTeido = ik_jokusoTeido;
    }

    /**
     * getIk_sonotaHifuShikkanUmuKubun
     *
     * @return ik_sonotaHifuShikkanUmuKubun
     */
    public boolean getIk_sonotaHifuShikkanUmuKubun() {
        return ik_sonotaHifuShikkanUmuKubun;
    }

    /**
     * setIk_sonotaHifuShikkanUmuKubun
     *
     * @param ik_sonotaHifuShikkanUmuKubun ik_sonotaHifuShikkanUmuKubun
     */
    public void setIk_sonotaHifuShikkanUmuKubun(boolean ik_sonotaHifuShikkanUmuKubun) {
        this.ik_sonotaHifuShikkanUmuKubun = ik_sonotaHifuShikkanUmuKubun;
    }

    /**
     * getIk_sonotaHifuShikkkanBui
     *
     * @return ik_sonotaHifuShikkkanBui
     */
    public RString getIk_sonotaHifuShikkkanBui() {
        return ik_sonotaHifuShikkkanBui;
    }

    /**
     * setIk_sonotaHifuShikkkanBui
     *
     * @param ik_sonotaHifuShikkkanBui ik_sonotaHifuShikkkanBui
     */
    public void setIk_sonotaHifuShikkkanBui(RString ik_sonotaHifuShikkkanBui) {
        this.ik_sonotaHifuShikkkanBui = ik_sonotaHifuShikkkanBui;
    }

    /**
     * getIk_sonotaHifushikkanTeido
     *
     * @return ik_sonotaHifushikkanTeido
     */
    public RString getIk_sonotaHifushikkanTeido() {
        return ik_sonotaHifushikkanTeido;
    }

    /**
     * setIk_sonotaHifushikkanTeido
     *
     * @param ik_sonotaHifushikkanTeido ik_sonotaHifushikkanTeido
     */
    public void setIk_sonotaHifushikkanTeido(RString ik_sonotaHifushikkanTeido) {
        this.ik_sonotaHifushikkanTeido = ik_sonotaHifushikkanTeido;
    }

    /**
     * getIk_idoOkugaiHoko
     *
     * @return ik_idoOkugaiHoko
     */
    public RString getIk_idoOkugaiHoko() {
        return ik_idoOkugaiHoko;
    }

    /**
     * setIk_idoOkugaiHoko
     *
     * @param ik_idoOkugaiHoko ik_idoOkugaiHoko
     */
    public void setIk_idoOkugaiHoko(RString ik_idoOkugaiHoko) {
        this.ik_idoOkugaiHoko = ik_idoOkugaiHoko;
    }

    /**
     * getIk_idoKurumaisu
     *
     * @return ik_idoKurumaisu
     */
    public RString getIk_idoKurumaisu() {
        return ik_idoKurumaisu;
    }

    /**
     * setIk_idoKurumaisu
     *
     * @param ik_idoKurumaisu ik_idoKurumaisu
     */
    public void setIk_idoKurumaisu(RString ik_idoKurumaisu) {
        this.ik_idoKurumaisu = ik_idoKurumaisu;
    }

    /**
     * getIk_idoHokohojoguMishiyo
     *
     * @return ik_idoHokohojoguMishiyo
     */
    public RString getIk_idoHokohojoguMishiyo() {
        return ik_idoHokohojoguMishiyo;
    }

    /**
     * setIk_idoHokohojoguMishiyo
     *
     * @param ik_idoHokohojoguMishiyo ik_idoHokohojoguMishiyo
     */
    public void setIk_idoHokohojoguMishiyo(RString ik_idoHokohojoguMishiyo) {
        this.ik_idoHokohojoguMishiyo = ik_idoHokohojoguMishiyo;
    }

    /**
     * getIk_idoHokohojoguOkugai
     *
     * @return ik_idoHokohojoguOkugai
     */
    public RString getIk_idoHokohojoguOkugai() {
        return ik_idoHokohojoguOkugai;
    }

    /**
     * setIk_idoHokohojoguOkugai
     *
     * @param ik_idoHokohojoguOkugai ik_idoHokohojoguOkugai
     */
    public void setIk_idoHokohojoguOkugai(RString ik_idoHokohojoguOkugai) {
        this.ik_idoHokohojoguOkugai = ik_idoHokohojoguOkugai;
    }

    /**
     * getIk_idoHokohojoguOkunai
     *
     * @return ik_idoHokohojoguOkunai
     */
    public RString getIk_idoHokohojoguOkunai() {
        return ik_idoHokohojoguOkunai;
    }

    /**
     * setIk_idoHokohojoguOkunai
     *
     * @param ik_idoHokohojoguOkunai ik_idoHokohojoguOkunai
     */
    public void setIk_idoHokohojoguOkunai(RString ik_idoHokohojoguOkunai) {
        this.ik_idoHokohojoguOkunai = ik_idoHokohojoguOkunai;
    }

    /**
     * getIk_shokuseikatsuShokujiKoi
     *
     * @return ik_shokuseikatsuShokujiKoi
     */
    public RString getIk_shokuseikatsuShokujiKoi() {
        return ik_shokuseikatsuShokujiKoi;
    }

    /**
     * setIk_shokuseikatsuShokujiKoi
     *
     * @param ik_shokuseikatsuShokujiKoi ik_shokuseikatsuShokujiKoi
     */
    public void setIk_shokuseikatsuShokujiKoi(RString ik_shokuseikatsuShokujiKoi) {
        this.ik_shokuseikatsuShokujiKoi = ik_shokuseikatsuShokujiKoi;
    }

    /**
     * getIk_shokuseikatsuEiyoJotai
     *
     * @return ik_shokuseikatsuEiyoJotai
     */
    public RString getIk_shokuseikatsuEiyoJotai() {
        return ik_shokuseikatsuEiyoJotai;
    }

    /**
     * setIk_shokuseikatsuEiyoJotai
     *
     * @param ik_shokuseikatsuEiyoJotai ik_shokuseikatsuEiyoJotai
     */
    public void setIk_shokuseikatsuEiyoJotai(RString ik_shokuseikatsuEiyoJotai) {
        this.ik_shokuseikatsuEiyoJotai = ik_shokuseikatsuEiyoJotai;
    }

    /**
     * getIk_shokuseikatsuRyuiten
     *
     * @return ik_shokuseikatsuRyuiten
     */
    public RString getIk_shokuseikatsuRyuiten() {
        return ik_shokuseikatsuRyuiten;
    }

    /**
     * setIk_shokuseikatsuRyuiten
     *
     * @param ik_shokuseikatsuRyuiten ik_shokuseikatsuRyuiten
     */
    public void setIk_shokuseikatsuRyuiten(RString ik_shokuseikatsuRyuiten) {
        this.ik_shokuseikatsuRyuiten = ik_shokuseikatsuRyuiten;
    }

    /**
     * getIk_probabilityNyoShikkinUmuKubun
     *
     * @return ik_probabilityNyoShikkinUmuKubun
     */
    public boolean getIk_probabilityNyoShikkinUmuKubun() {
        return ik_probabilityNyoShikkinUmuKubun;
    }

    /**
     * setIk_probabilityNyoShikkinUmuKubun
     *
     * @param ik_probabilityNyoShikkinUmuKubun ik_probabilityNyoShikkinUmuKubun
     */
    public void setIk_probabilityNyoShikkinUmuKubun(boolean ik_probabilityNyoShikkinUmuKubun) {
        this.ik_probabilityNyoShikkinUmuKubun = ik_probabilityNyoShikkinUmuKubun;
    }

    /**
     * getIk_probabilityTentoOrKossetsuUmuKubun
     *
     * @return ik_probabilityTentoOrKossetsuUmuKubun
     */
    public boolean getIk_probabilityTentoOrKossetsuUmuKubun() {
        return ik_probabilityTentoOrKossetsuUmuKubun;
    }

    /**
     * setIk_probabilityTentoOrKossetsuUmuKubun
     *
     * @param ik_probabilityTentoOrKossetsuUmuKubun
     * ik_probabilityTentoOrKossetsuUmuKubun
     */
    public void setIk_probabilityTentoOrKossetsuUmuKubun(boolean ik_probabilityTentoOrKossetsuUmuKubun) {
        this.ik_probabilityTentoOrKossetsuUmuKubun = ik_probabilityTentoOrKossetsuUmuKubun;
    }

    /**
     * getIk_probabilityIdoNoryokuTeikaUmuKubun
     *
     * @return ik_probabilityIdoNoryokuTeikaUmuKubun
     */
    public boolean getIk_probabilityIdoNoryokuTeikaUmuKubun() {
        return ik_probabilityIdoNoryokuTeikaUmuKubun;
    }

    /**
     * setIk_probabilityIdoNoryokuTeikaUmuKubun
     *
     * @param ik_probabilityIdoNoryokuTeikaUmuKubun
     * ik_probabilityIdoNoryokuTeikaUmuKubun
     */
    public void setIk_probabilityIdoNoryokuTeikaUmuKubun(boolean ik_probabilityIdoNoryokuTeikaUmuKubun) {
        this.ik_probabilityIdoNoryokuTeikaUmuKubun = ik_probabilityIdoNoryokuTeikaUmuKubun;
    }

    /**
     * getIk_probabilityJokusoUmuKubun
     *
     * @return ik_probabilityJokusoUmuKubun
     */
    public boolean getIk_probabilityJokusoUmuKubun() {
        return ik_probabilityJokusoUmuKubun;
    }

    /**
     * setIk_probabilityJokusoUmuKubun
     *
     * @param ik_probabilityJokusoUmuKubun ik_probabilityJokusoUmuKubun
     */
    public void setIk_probabilityJokusoUmuKubun(boolean ik_probabilityJokusoUmuKubun) {
        this.ik_probabilityJokusoUmuKubun = ik_probabilityJokusoUmuKubun;
    }

    /**
     * getIk_probabilityTojikomoriUmuKubun
     *
     * @return ik_probabilityTojikomoriUmuKubun
     */
    public boolean getIk_probabilityTojikomoriUmuKubun() {
        return ik_probabilityTojikomoriUmuKubun;
    }

    /**
     * setIk_probabilityTojikomoriUmuKubun
     *
     * @param ik_probabilityTojikomoriUmuKubun ik_probabilityTojikomoriUmuKubun
     */
    public void setIk_probabilityTojikomoriUmuKubun(boolean ik_probabilityTojikomoriUmuKubun) {
        this.ik_probabilityTojikomoriUmuKubun = ik_probabilityTojikomoriUmuKubun;
    }

    /**
     * getIk_probabilitiyIyokuTeikaUmuKubun
     *
     * @return ik_probabilitiyIyokuTeikaUmuKubun
     */
    public boolean getIk_probabilitiyIyokuTeikaUmuKubun() {
        return ik_probabilitiyIyokuTeikaUmuKubun;
    }

    /**
     * setIk_probabilitiyIyokuTeikaUmuKubun
     *
     * @param ik_probabilitiyIyokuTeikaUmuKubun
     * ik_probabilitiyIyokuTeikaUmuKubun
     */
    public void setIk_probabilitiyIyokuTeikaUmuKubun(boolean ik_probabilitiyIyokuTeikaUmuKubun) {
        this.ik_probabilitiyIyokuTeikaUmuKubun = ik_probabilitiyIyokuTeikaUmuKubun;
    }

    /**
     * getIk_probabilityHaikaiUmuKubun
     *
     * @return ik_probabilityHaikaiUmuKubun
     */
    public boolean getIk_probabilityHaikaiUmuKubun() {
        return ik_probabilityHaikaiUmuKubun;
    }

    /**
     * setIk_probabilityHaikaiUmuKubun
     *
     * @param ik_probabilityHaikaiUmuKubun ik_probabilityHaikaiUmuKubun
     */
    public void setIk_probabilityHaikaiUmuKubun(boolean ik_probabilityHaikaiUmuKubun) {
        this.ik_probabilityHaikaiUmuKubun = ik_probabilityHaikaiUmuKubun;
    }

    /**
     * getIk_probabilityTeiEiyoUmuKubun
     *
     * @return ik_probabilityTeiEiyoUmuKubun
     */
    public boolean getIk_probabilityTeiEiyoUmuKubun() {
        return ik_probabilityTeiEiyoUmuKubun;
    }

    /**
     * setIk_probabilityTeiEiyoUmuKubun
     *
     * @param ik_probabilityTeiEiyoUmuKubun ik_probabilityTeiEiyoUmuKubun
     */
    public void setIk_probabilityTeiEiyoUmuKubun(boolean ik_probabilityTeiEiyoUmuKubun) {
        this.ik_probabilityTeiEiyoUmuKubun = ik_probabilityTeiEiyoUmuKubun;
    }

    /**
     * getIk_probabilitySesshokuEngiKinoTeikaUmuKubun
     *
     * @return ik_probabilitySesshokuEngiKinoTeikaUmuKubun
     */
    public boolean getIk_probabilitySesshokuEngiKinoTeikaUmuKubun() {
        return ik_probabilitySesshokuEngiKinoTeikaUmuKubun;
    }

    /**
     * setIk_probabilitySesshokuEngiKinoTeikaUmuKubun
     *
     * @param ik_probabilitySesshokuEngiKinoTeikaUmuKubun
     * ik_probabilitySesshokuEngiKinoTeikaUmuKubun
     */
    public void setIk_probabilitySesshokuEngiKinoTeikaUmuKubun(boolean ik_probabilitySesshokuEngiKinoTeikaUmuKubun) {
        this.ik_probabilitySesshokuEngiKinoTeikaUmuKubun = ik_probabilitySesshokuEngiKinoTeikaUmuKubun;
    }

    /**
     * getIk_probabilityDassuiUmuKubun
     *
     * @return ik_probabilityDassuiUmuKubun
     */
    public boolean getIk_probabilityDassuiUmuKubun() {
        return ik_probabilityDassuiUmuKubun;
    }

    /**
     * setIk_probabilityDassuiUmuKubun
     *
     * @param ik_probabilityDassuiUmuKubun ik_probabilityDassuiUmuKubun
     */
    public void setIk_probabilityDassuiUmuKubun(boolean ik_probabilityDassuiUmuKubun) {
        this.ik_probabilityDassuiUmuKubun = ik_probabilityDassuiUmuKubun;
    }

    /**
     * getIk_probabilityIkansenshoUmuKubun
     *
     * @return ik_probabilityIkansenshoUmuKubun
     */
    public boolean getIk_probabilityIkansenshoUmuKubun() {
        return ik_probabilityIkansenshoUmuKubun;
    }

    /**
     * setIk_probabilityIkansenshoUmuKubun
     *
     * @param ik_probabilityIkansenshoUmuKubun ik_probabilityIkansenshoUmuKubun
     */
    public void setIk_probabilityIkansenshoUmuKubun(boolean ik_probabilityIkansenshoUmuKubun) {
        this.ik_probabilityIkansenshoUmuKubun = ik_probabilityIkansenshoUmuKubun;
    }

    /**
     * getIk_probabilityTotsuUmuKubun
     *
     * @return ik_probabilityTotsuUmuKubun
     */
    public boolean getIk_probabilityTotsuUmuKubun() {
        return ik_probabilityTotsuUmuKubun;
    }

    /**
     * setIk_probabilityTotsuUmuKubun
     *
     * @param ik_probabilityTotsuUmuKubun ik_probabilityTotsuUmuKubun
     */
    public void setIk_probabilityTotsuUmuKubun(boolean ik_probabilityTotsuUmuKubun) {
        this.ik_probabilityTotsuUmuKubun = ik_probabilityTotsuUmuKubun;
    }

    /**
     * getIk_probabilitySonotaUmuKubun
     *
     * @return ik_probabilitySonotaUmuKubun
     */
    public boolean getIk_probabilitySonotaUmuKubun() {
        return ik_probabilitySonotaUmuKubun;
    }

    /**
     * setIk_probabilitySonotaUmuKubun
     *
     * @param ik_probabilitySonotaUmuKubun ik_probabilitySonotaUmuKubun
     */
    public void setIk_probabilitySonotaUmuKubun(boolean ik_probabilitySonotaUmuKubun) {
        this.ik_probabilitySonotaUmuKubun = ik_probabilitySonotaUmuKubun;
    }

    /**
     * getIk_probabilitySonotaNaiyo
     *
     * @return ik_probabilitySonotaNaiyo
     */
    public RString getIk_probabilitySonotaNaiyo() {
        return ik_probabilitySonotaNaiyo;
    }

    /**
     * setIk_probabilitySonotaNaiyo
     *
     * @param ik_probabilitySonotaNaiyo ik_probabilitySonotaNaiyo
     */
    public void setIk_probabilitySonotaNaiyo(RString ik_probabilitySonotaNaiyo) {
        this.ik_probabilitySonotaNaiyo = ik_probabilitySonotaNaiyo;
    }

    /**
     * getIk_probabilityEngeseiHaienUmuKubun
     *
     * @return ik_probabilityEngeseiHaienUmuKubun
     */
    public boolean getIk_probabilityEngeseiHaienUmuKubun() {
        return ik_probabilityEngeseiHaienUmuKubun;
    }

    /**
     * setIk_probabilityEngeseiHaienUmuKubun
     *
     * @param ik_probabilityEngeseiHaienUmuKubun
     * ik_probabilityEngeseiHaienUmuKubun
     */
    public void setIk_probabilityEngeseiHaienUmuKubun(boolean ik_probabilityEngeseiHaienUmuKubun) {
        this.ik_probabilityEngeseiHaienUmuKubun = ik_probabilityEngeseiHaienUmuKubun;
    }

    /**
     * getIk_probabilityChoHeisokuUmuKubun
     *
     * @return ik_probabilityChoHeisokuUmuKubun
     */
    public boolean getIk_probabilityChoHeisokuUmuKubun() {
        return ik_probabilityChoHeisokuUmuKubun;
    }

    /**
     * setIk_probabilityChoHeisokuUmuKubun
     *
     * @param ik_probabilityChoHeisokuUmuKubun ik_probabilityChoHeisokuUmuKubun
     */
    public void setIk_probabilityChoHeisokuUmuKubun(boolean ik_probabilityChoHeisokuUmuKubun) {
        this.ik_probabilityChoHeisokuUmuKubun = ik_probabilityChoHeisokuUmuKubun;
    }

    /**
     * getIk_probabilityShinpaiKinoTeikaUmuKubun
     *
     * @return ik_probabilityShinpaiKinoTeikaUmuKubun
     */
    public boolean getIk_probabilityShinpaiKinoTeikaUmuKubun() {
        return ik_probabilityShinpaiKinoTeikaUmuKubun;
    }

    /**
     * setIk_probabilityShinpaiKinoTeikaUmuKubun
     *
     * @param ik_probabilityShinpaiKinoTeikaUmuKubun
     * ik_probabilityShinpaiKinoTeikaUmuKubun
     */
    public void setIk_probabilityShinpaiKinoTeikaUmuKubun(boolean ik_probabilityShinpaiKinoTeikaUmuKubun) {
        this.ik_probabilityShinpaiKinoTeikaUmuKubun = ik_probabilityShinpaiKinoTeikaUmuKubun;
    }

    /**
     * getIk_probabilityItamiUmuKubun
     *
     * @return ik_probabilityItamiUmuKubun
     */
    public boolean getIk_probabilityItamiUmuKubun() {
        return ik_probabilityItamiUmuKubun;
    }

    /**
     * setIk_probabilityItamiUmuKubun
     *
     * @param ik_probabilityItamiUmuKubun ik_probabilityItamiUmuKubun
     */
    public void setIk_probabilityItamiUmuKubun(boolean ik_probabilityItamiUmuKubun) {
        this.ik_probabilityItamiUmuKubun = ik_probabilityItamiUmuKubun;
    }

    /**
     * getIk_probabilityTaisho
     *
     * @return ik_probabilityTaisho
     */
    public RString getIk_probabilityTaisho() {
        return ik_probabilityTaisho;
    }

    /**
     * setIk_probabilityTaisho
     *
     * @param ik_probabilityTaisho ik_probabilityTaisho
     */
    public void setIk_probabilityTaisho(RString ik_probabilityTaisho) {
        this.ik_probabilityTaisho = ik_probabilityTaisho;
    }

    /**
     * getIk_yogoMitoshi
     *
     * @return ik_yogoMitoshi
     */
    public RString getIk_yogoMitoshi() {
        return ik_yogoMitoshi;
    }

    /**
     * setIk_yogoMitoshi
     *
     * @param ik_yogoMitoshi ik_yogoMitoshi
     */
    public void setIk_yogoMitoshi(RString ik_yogoMitoshi) {
        this.ik_yogoMitoshi = ik_yogoMitoshi;
    }

    /**
     * getIk_ijiKaizenMitoshi
     *
     * @return ik_ijiKaizenMitoshi
     */
    public RString getIk_ijiKaizenMitoshi() {
        return ik_ijiKaizenMitoshi;
    }

    /**
     * setIk_ijiKaizenMitoshi
     *
     * @param ik_ijiKaizenMitoshi ik_ijiKaizenMitoshi
     */
    public void setIk_ijiKaizenMitoshi(RString ik_ijiKaizenMitoshi) {
        this.ik_ijiKaizenMitoshi = ik_ijiKaizenMitoshi;
    }

    /**
     * getIk_homonShinryoUmuKubun
     *
     * @return ik_homonShinryoUmuKubun
     */
    public boolean getIk_homonShinryoUmuKubun() {
        return ik_homonShinryoUmuKubun;
    }

    /**
     * setIk_homonShinryoUmuKubun
     *
     * @param ik_homonShinryoUmuKubun ik_homonShinryoUmuKubun
     */
    public void setIk_homonShinryoUmuKubun(boolean ik_homonShinryoUmuKubun) {
        this.ik_homonShinryoUmuKubun = ik_homonShinryoUmuKubun;
    }

    /**
     * getIk_tankiNyushoRyoyoKaigoUmuKubun
     *
     * @return ik_tankiNyushoRyoyoKaigoUmuKubun
     */
    public boolean getIk_tankiNyushoRyoyoKaigoUmuKubun() {
        return ik_tankiNyushoRyoyoKaigoUmuKubun;
    }

    /**
     * setIk_tankiNyushoRyoyoKaigoUmuKubun
     *
     * @param ik_tankiNyushoRyoyoKaigoUmuKubun ik_tankiNyushoRyoyoKaigoUmuKubun
     */
    public void setIk_tankiNyushoRyoyoKaigoUmuKubun(boolean ik_tankiNyushoRyoyoKaigoUmuKubun) {
        this.ik_tankiNyushoRyoyoKaigoUmuKubun = ik_tankiNyushoRyoyoKaigoUmuKubun;
    }

    /**
     * getIk_homonEiyoShokujiShidoUmuKubun
     *
     * @return ik_homonEiyoShokujiShidoUmuKubun
     */
    public boolean getIk_homonEiyoShokujiShidoUmuKubun() {
        return ik_homonEiyoShokujiShidoUmuKubun;
    }

    /**
     * setIk_homonEiyoShokujiShidoUmuKubun
     *
     * @param ik_homonEiyoShokujiShidoUmuKubun ik_homonEiyoShokujiShidoUmuKubun
     */
    public void setIk_homonEiyoShokujiShidoUmuKubun(boolean ik_homonEiyoShokujiShidoUmuKubun) {
        this.ik_homonEiyoShokujiShidoUmuKubun = ik_homonEiyoShokujiShidoUmuKubun;
    }

    /**
     * getIk_homonKangoUmuKubun
     *
     * @return ik_homonKangoUmuKubun
     */
    public boolean getIk_homonKangoUmuKubun() {
        return ik_homonKangoUmuKubun;
    }

    /**
     * setIk_homonKangoUmuKubun
     *
     * @param ik_homonKangoUmuKubun ik_homonKangoUmuKubun
     */
    public void setIk_homonKangoUmuKubun(boolean ik_homonKangoUmuKubun) {
        this.ik_homonKangoUmuKubun = ik_homonKangoUmuKubun;
    }

    /**
     * getIk_homonShikaShinryoUmuKubun
     *
     * @return ik_homonShikaShinryoUmuKubun
     */
    public boolean getIk_homonShikaShinryoUmuKubun() {
        return ik_homonShikaShinryoUmuKubun;
    }

    /**
     * setIk_homonShikaShinryoUmuKubun
     *
     * @param ik_homonShikaShinryoUmuKubun ik_homonShikaShinryoUmuKubun
     */
    public void setIk_homonShikaShinryoUmuKubun(boolean ik_homonShikaShinryoUmuKubun) {
        this.ik_homonShikaShinryoUmuKubun = ik_homonShikaShinryoUmuKubun;
    }

    /**
     * getIk_homonRihabilitationUmuKubun
     *
     * @return ik_homonRihabilitationUmuKubun
     */
    public boolean getIk_homonRihabilitationUmuKubun() {
        return ik_homonRihabilitationUmuKubun;
    }

    /**
     * setIk_homonRihabilitationUmuKubun
     *
     * @param ik_homonRihabilitationUmuKubun ik_homonRihabilitationUmuKubun
     */
    public void setIk_homonRihabilitationUmuKubun(boolean ik_homonRihabilitationUmuKubun) {
        this.ik_homonRihabilitationUmuKubun = ik_homonRihabilitationUmuKubun;
    }

    /**
     * getIk_homonShikaEiseiShidoUmuKubun
     *
     * @return ik_homonShikaEiseiShidoUmuKubun
     */
    public boolean getIk_homonShikaEiseiShidoUmuKubun() {
        return ik_homonShikaEiseiShidoUmuKubun;
    }

    /**
     * setIk_homonShikaEiseiShidoUmuKubun
     *
     * @param ik_homonShikaEiseiShidoUmuKubun ik_homonShikaEiseiShidoUmuKubun
     */
    public void setIk_homonShikaEiseiShidoUmuKubun(boolean ik_homonShikaEiseiShidoUmuKubun) {
        this.ik_homonShikaEiseiShidoUmuKubun = ik_homonShikaEiseiShidoUmuKubun;
    }

    /**
     * getIk_tushoRihabilitationUmuKubun
     *
     * @return ik_tushoRihabilitationUmuKubun
     */
    public boolean getIk_tushoRihabilitationUmuKubun() {
        return ik_tushoRihabilitationUmuKubun;
    }

    /**
     * setIk_tushoRihabilitationUmuKubun
     *
     * @param ik_tushoRihabilitationUmuKubun ik_tushoRihabilitationUmuKubun
     */
    public void setIk_tushoRihabilitationUmuKubun(boolean ik_tushoRihabilitationUmuKubun) {
        this.ik_tushoRihabilitationUmuKubun = ik_tushoRihabilitationUmuKubun;
    }

    /**
     * getIk_homonYakuzaiKanriShidoUmuKubun
     *
     * @return ik_homonYakuzaiKanriShidoUmuKubun
     */
    public boolean getIk_homonYakuzaiKanriShidoUmuKubun() {
        return ik_homonYakuzaiKanriShidoUmuKubun;
    }

    /**
     * setIk_homonYakuzaiKanriShidoUmuKubun
     *
     * @param ik_homonYakuzaiKanriShidoUmuKubun
     * ik_homonYakuzaiKanriShidoUmuKubun
     */
    public void setIk_homonYakuzaiKanriShidoUmuKubun(boolean ik_homonYakuzaiKanriShidoUmuKubun) {
        this.ik_homonYakuzaiKanriShidoUmuKubun = ik_homonYakuzaiKanriShidoUmuKubun;
    }

    /**
     * getIk_sonotaIgakutekiKanriUmuKubun
     *
     * @return ik_sonotaIgakutekiKanriUmuKubun
     */
    public boolean getIk_sonotaIgakutekiKanriUmuKubun() {
        return ik_sonotaIgakutekiKanriUmuKubun;
    }

    /**
     * setIk_sonotaIgakutekiKanriUmuKubun
     *
     * @param ik_sonotaIgakutekiKanriUmuKubun ik_sonotaIgakutekiKanriUmuKubun
     */
    public void setIk_sonotaIgakutekiKanriUmuKubun(boolean ik_sonotaIgakutekiKanriUmuKubun) {
        this.ik_sonotaIgakutekiKanriUmuKubun = ik_sonotaIgakutekiKanriUmuKubun;
    }

    /**
     * getIk_ryuiJikoKetsuatsuUmuKubun
     *
     * @return ik_ryuiJikoKetsuatsuUmuKubun
     */
    public boolean getIk_ryuiJikoKetsuatsuUmuKubun() {
        return ik_ryuiJikoKetsuatsuUmuKubun;
    }

    /**
     * setIk_ryuiJikoKetsuatsuUmuKubun
     *
     * @param ik_ryuiJikoKetsuatsuUmuKubun ik_ryuiJikoKetsuatsuUmuKubun
     */
    public void setIk_ryuiJikoKetsuatsuUmuKubun(boolean ik_ryuiJikoKetsuatsuUmuKubun) {
        this.ik_ryuiJikoKetsuatsuUmuKubun = ik_ryuiJikoKetsuatsuUmuKubun;
    }

    /**
     * getIk_ryuiJikoKetsuatsu
     *
     * @return ik_ryuiJikoKetsuatsu
     */
    public RString getIk_ryuiJikoKetsuatsu() {
        return ik_ryuiJikoKetsuatsu;
    }

    /**
     * setIk_ryuiJikoKetsuatsu
     *
     * @param ik_ryuiJikoKetsuatsu ik_ryuiJikoKetsuatsu
     */
    public void setIk_ryuiJikoKetsuatsu(RString ik_ryuiJikoKetsuatsu) {
        this.ik_ryuiJikoKetsuatsu = ik_ryuiJikoKetsuatsu;
    }

    /**
     * getIk_ryuiJikoSesshokuUmuKubun
     *
     * @return ik_ryuiJikoSesshokuUmuKubun
     */
    public boolean getIk_ryuiJikoSesshokuUmuKubun() {
        return ik_ryuiJikoSesshokuUmuKubun;
    }

    /**
     * setIk_ryuiJikoSesshokuUmuKubun
     *
     * @param ik_ryuiJikoSesshokuUmuKubun ik_ryuiJikoSesshokuUmuKubun
     */
    public void setIk_ryuiJikoSesshokuUmuKubun(boolean ik_ryuiJikoSesshokuUmuKubun) {
        this.ik_ryuiJikoSesshokuUmuKubun = ik_ryuiJikoSesshokuUmuKubun;
    }

    /**
     * getIk_ryuiJikoSesshoku
     *
     * @return ik_ryuiJikoSesshoku
     */
    public RString getIk_ryuiJikoSesshoku() {
        return ik_ryuiJikoSesshoku;
    }

    /**
     * setIk_ryuiJikoSesshoku
     *
     * @param ik_ryuiJikoSesshoku ik_ryuiJikoSesshoku
     */
    public void setIk_ryuiJikoSesshoku(RString ik_ryuiJikoSesshoku) {
        this.ik_ryuiJikoSesshoku = ik_ryuiJikoSesshoku;
    }

    /**
     * getIk_ryuiJikoEngeUmuKubun
     *
     * @return ik_ryuiJikoEngeUmuKubun
     */
    public boolean getIk_ryuiJikoEngeUmuKubun() {
        return ik_ryuiJikoEngeUmuKubun;
    }

    /**
     * setIk_ryuiJikoEngeUmuKubun
     *
     * @param ik_ryuiJikoEngeUmuKubun ik_ryuiJikoEngeUmuKubun
     */
    public void setIk_ryuiJikoEngeUmuKubun(boolean ik_ryuiJikoEngeUmuKubun) {
        this.ik_ryuiJikoEngeUmuKubun = ik_ryuiJikoEngeUmuKubun;
    }

    /**
     * getIk_ryuiJikoEnge
     *
     * @return ik_ryuiJikoEnge
     */
    public RString getIk_ryuiJikoEnge() {
        return ik_ryuiJikoEnge;
    }

    /**
     * setIk_ryuiJikoEnge
     *
     * @param ik_ryuiJikoEnge ik_ryuiJikoEnge
     */
    public void setIk_ryuiJikoEnge(RString ik_ryuiJikoEnge) {
        this.ik_ryuiJikoEnge = ik_ryuiJikoEnge;
    }

    /**
     * getIk_ryuiJikoIdoUmuKubun
     *
     * @return ik_ryuiJikoIdoUmuKubun
     */
    public boolean getIk_ryuiJikoIdoUmuKubun() {
        return ik_ryuiJikoIdoUmuKubun;
    }

    /**
     * setIk_ryuiJikoIdoUmuKubun
     *
     * @param ik_ryuiJikoIdoUmuKubun ik_ryuiJikoIdoUmuKubun
     */
    public void setIk_ryuiJikoIdoUmuKubun(boolean ik_ryuiJikoIdoUmuKubun) {
        this.ik_ryuiJikoIdoUmuKubun = ik_ryuiJikoIdoUmuKubun;
    }

    /**
     * getIk_ryuiJikoIdo
     *
     * @return ik_ryuiJikoIdo
     */
    public RString getIk_ryuiJikoIdo() {
        return ik_ryuiJikoIdo;
    }

    /**
     * setIk_ryuiJikoIdo
     *
     * @param ik_ryuiJikoIdo ik_ryuiJikoIdo
     */
    public void setIk_ryuiJikoIdo(RString ik_ryuiJikoIdo) {
        this.ik_ryuiJikoIdo = ik_ryuiJikoIdo;
    }

    /**
     * getIk_ryuiJikoUndoUmuKubun
     *
     * @return ik_ryuiJikoUndoUmuKubun
     */
    public boolean getIk_ryuiJikoUndoUmuKubun() {
        return ik_ryuiJikoUndoUmuKubun;
    }

    /**
     * setIk_ryuiJikoUndoUmuKubun
     *
     * @param ik_ryuiJikoUndoUmuKubun ik_ryuiJikoUndoUmuKubun
     */
    public void setIk_ryuiJikoUndoUmuKubun(boolean ik_ryuiJikoUndoUmuKubun) {
        this.ik_ryuiJikoUndoUmuKubun = ik_ryuiJikoUndoUmuKubun;
    }

    /**
     * getIk_ryuiJikoUndo
     *
     * @return ik_ryuiJikoUndo
     */
    public RString getIk_ryuiJikoUndo() {
        return ik_ryuiJikoUndo;
    }

    /**
     * setIk_ryuiJikoUndo
     *
     * @param ik_ryuiJikoUndo ik_ryuiJikoUndo
     */
    public void setIk_ryuiJikoUndo(RString ik_ryuiJikoUndo) {
        this.ik_ryuiJikoUndo = ik_ryuiJikoUndo;
    }

    /**
     * getIk_ryuiJikoSonota
     *
     * @return ik_ryuiJikoSonota
     */
    public RString getIk_ryuiJikoSonota() {
        return ik_ryuiJikoSonota;
    }

    /**
     * setIk_ryuiJikoSonota
     *
     * @param ik_ryuiJikoSonota ik_ryuiJikoSonota
     */
    public void setIk_ryuiJikoSonota(RString ik_ryuiJikoSonota) {
        this.ik_ryuiJikoSonota = ik_ryuiJikoSonota;
    }

    /**
     * getIk_kansenshoUmu
     *
     * @return ik_kansenshoUmu
     */
    public RString getIk_kansenshoUmu() {
        return ik_kansenshoUmu;
    }

    /**
     * setIk_kansenshoUmu
     *
     * @param ik_kansenshoUmu ik_kansenshoUmu
     */
    public void setIk_kansenshoUmu(RString ik_kansenshoUmu) {
        this.ik_kansenshoUmu = ik_kansenshoUmu;
    }

    /**
     * getIk_kansenshoShojo
     *
     * @return ik_kansenshoShojo
     */
    public RString getIk_kansenshoShojo() {
        return ik_kansenshoShojo;
    }

    /**
     * setIk_kansenshoShojo
     *
     * @param ik_kansenshoShojo ik_kansenshoShojo
     */
    public void setIk_kansenshoShojo(RString ik_kansenshoShojo) {
        this.ik_kansenshoShojo = ik_kansenshoShojo;
    }

    /**
     * getIk_tokkiJiko
     *
     * @return ik_tokkiJiko
     */
    public RString getIk_tokkiJiko() {
        return ik_tokkiJiko;
    }

    /**
     * setIk_tokkiJiko
     *
     * @param ik_tokkiJiko ik_tokkiJiko
     */
    public void setIk_tokkiJiko(RString ik_tokkiJiko) {
        this.ik_tokkiJiko = ik_tokkiJiko;
    }

    /**
     * getIk_tokkiJikoImage
     *
     * @return ik_tokkiJikoImage
     */
    public byte[] getIk_tokkiJikoImage() {
        return ik_tokkiJikoImage;
    }

    /**
     * setIk_tokkiJikoImage
     *
     * @param ik_tokkiJikoImage ik_tokkiJikoImage
     */
    public void setIk_tokkiJikoImage(byte[] ik_tokkiJikoImage) {
        this.ik_tokkiJikoImage = ik_tokkiJikoImage;
    }

    /**
     * getIk_kangoShokuiHomonUmu
     *
     * @return ik_kangoShokuiHomonUmu
     */
    public RString getIk_kangoShokuiHomonUmu() {
        return ik_kangoShokuiHomonUmu;
    }

    /**
     * setIk_kangoShokuiHomonUmu
     *
     * @param ik_kangoShokuiHomonUmu ik_kangoShokuiHomonUmu
     */
    public void setIk_kangoShokuiHomonUmu(RString ik_kangoShokuiHomonUmu) {
        this.ik_kangoShokuiHomonUmu = ik_kangoShokuiHomonUmu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5013ShujiiIkenshoShosaiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5013ShujiiIkenshoShosaiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5013ShujiiIkenshoShosaiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ikenshoIraiRirekiNo != other.ikenshoIraiRirekiNo) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
