package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3020KyufujissekiTokuteiSinryohiの項目定義クラスです
 *
 */
public class DbT3020KyufujissekiTokuteiSinryohiEntity extends DbTableEntityBase<DbT3020KyufujissekiTokuteiSinryohiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3020KyufujissekiTokuteiSinryohi");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KokanShikibetsuNo kokanJohoShikibetsuNo;
    @PrimaryKey
    private NyuryokuShikibetsuNo inputShikibetsuNo;
    @PrimaryKey
    private RString recodeShubetsuCode;
    @PrimaryKey
    private HokenshaNo shokisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private JigyoshaNo jigyoshoNo;
    @PrimaryKey
    private RString toshiNo;
    @PrimaryKey
    private RString recodeJunjiNo;
    private RString shobyoName;
    private int hokenShidoKanriryo;
    private int hokenTanjunXsen;
    private int hokenRehabilitation;
    private int hokenSeishinkaSemmonRyoho;
    private int hokenTotalTanisu;
    private int kohi1ShidoKanriryo;
    private int kohi1TanjunXsen;
    private int kohi1Rehabilitation;
    private int kohi1SeishinkaSemmonRyoho;
    private int kohi1TotalTanisu;
    private int kohi2ShidoKanriryo;
    private int kohi2TanjunXsen;
    private int kohi2Rehabilitation;
    private int kohi2SeishinkaSemmonRyoho;
    private int kohi2TotalTanisu;
    private int kohi3ShidoKanriryo;
    private int kohi3TanjunXsen;
    private int kohi3Rehabilitation;
    private int kohi3SeishinkaSemmonRyoho;
    private int kohi3TotalTanisu;
    private RString tekiyo1;
    private RString tekiyo2;
    private RString tekiyo3;
    private RString tekiyo4;
    private RString tekiyo5;
    private RString tekiyo6;
    private RString tekiyo7;
    private RString tekiyo8;
    private RString tekiyo9;
    private RString tekiyo10;
    private RString tekiyo11;
    private RString tekiyo12;
    private RString tekiyo13;
    private RString tekiyo14;
    private RString tekiyo15;
    private RString tekiyo16;
    private RString tekiyo17;
    private RString tekiyo18;
    private RString tekiyo19;
    private RString tekiyo20;
    private int atoHokenShidoKanriryo;
    private int atoHokenTanjunXsen;
    private int atoHokenRehabilitation;
    private int atoHokenSeishinkaSemmonRyoho;
    private int atoKohi1ShidoKanriryo;
    private int atoKohi1TanjunXsen;
    private int atoKohi1Rehabilitation;
    private int atoKohi1SeishinkaSemmonRyoho;
    private int atoKohi2ShidoKanriryo;
    private int atoKohi2TanjunXsen;
    private int atoKohi2Rehabilitation;
    private int atoKohi2SeishinkaSemmonRyoho;
    private int atoKohi3ShidoKanriryo;
    private int atoKohi3TanjunXsen;
    private int atoKohi3Rehabilitation;
    private int atoKohi3SeishinkaSemmonRyoho;
    private int saishinsaKaisu;
    private int kagoKaisu;
    private FlexibleYearMonth shinsaYM;
    private RString seiriNo;
    private FlexibleYearMonth torikomiYM;

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
     * getKokanJohoShikibetsuNo
     *
     * @return kokanJohoShikibetsuNo
     */
    public KokanShikibetsuNo getKokanJohoShikibetsuNo() {
        return kokanJohoShikibetsuNo;
    }

    /**
     * setKokanJohoShikibetsuNo
     *
     * @param kokanJohoShikibetsuNo kokanJohoShikibetsuNo
     */
    public void setKokanJohoShikibetsuNo(KokanShikibetsuNo kokanJohoShikibetsuNo) {
        this.kokanJohoShikibetsuNo = kokanJohoShikibetsuNo;
    }

    /**
     * getInputShikibetsuNo
     *
     * @return inputShikibetsuNo
     */
    public NyuryokuShikibetsuNo getInputShikibetsuNo() {
        return inputShikibetsuNo;
    }

    /**
     * setInputShikibetsuNo
     *
     * @param inputShikibetsuNo inputShikibetsuNo
     */
    public void setInputShikibetsuNo(NyuryokuShikibetsuNo inputShikibetsuNo) {
        this.inputShikibetsuNo = inputShikibetsuNo;
    }

    /**
     * getRecodeShubetsuCode
     *
     * @return recodeShubetsuCode
     */
    public RString getRecodeShubetsuCode() {
        return recodeShubetsuCode;
    }

    /**
     * setRecodeShubetsuCode
     *
     * @param recodeShubetsuCode recodeShubetsuCode
     */
    public void setRecodeShubetsuCode(RString recodeShubetsuCode) {
        this.recodeShubetsuCode = recodeShubetsuCode;
    }

    /**
     * getShokisaiHokenshaNo
     *
     * @return shokisaiHokenshaNo
     */
    public HokenshaNo getShokisaiHokenshaNo() {
        return shokisaiHokenshaNo;
    }

    /**
     * setShokisaiHokenshaNo
     *
     * @param shokisaiHokenshaNo shokisaiHokenshaNo
     */
    public void setShokisaiHokenshaNo(HokenshaNo shokisaiHokenshaNo) {
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public JigyoshaNo getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(JigyoshaNo jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getToshiNo
     *
     * @return toshiNo
     */
    public RString getToshiNo() {
        return toshiNo;
    }

    /**
     * setToshiNo
     *
     * @param toshiNo toshiNo
     */
    public void setToshiNo(RString toshiNo) {
        this.toshiNo = toshiNo;
    }

    /**
     * getRecodeJunjiNo
     *
     * @return recodeJunjiNo
     */
    public RString getRecodeJunjiNo() {
        return recodeJunjiNo;
    }

    /**
     * setRecodeJunjiNo
     *
     * @param recodeJunjiNo recodeJunjiNo
     */
    public void setRecodeJunjiNo(RString recodeJunjiNo) {
        this.recodeJunjiNo = recodeJunjiNo;
    }

    /**
     * getShobyoName
     *
     * @return shobyoName
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * setShobyoName
     *
     * @param shobyoName shobyoName
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * getHokenShidoKanriryo
     *
     * @return hokenShidoKanriryo
     */
    public int getHokenShidoKanriryo() {
        return hokenShidoKanriryo;
    }

    /**
     * setHokenShidoKanriryo
     *
     * @param hokenShidoKanriryo hokenShidoKanriryo
     */
    public void setHokenShidoKanriryo(int hokenShidoKanriryo) {
        this.hokenShidoKanriryo = hokenShidoKanriryo;
    }

    /**
     * getHokenTanjunXsen
     *
     * @return hokenTanjunXsen
     */
    public int getHokenTanjunXsen() {
        return hokenTanjunXsen;
    }

    /**
     * setHokenTanjunXsen
     *
     * @param hokenTanjunXsen hokenTanjunXsen
     */
    public void setHokenTanjunXsen(int hokenTanjunXsen) {
        this.hokenTanjunXsen = hokenTanjunXsen;
    }

    /**
     * getHokenRehabilitation
     *
     * @return hokenRehabilitation
     */
    public int getHokenRehabilitation() {
        return hokenRehabilitation;
    }

    /**
     * setHokenRehabilitation
     *
     * @param hokenRehabilitation hokenRehabilitation
     */
    public void setHokenRehabilitation(int hokenRehabilitation) {
        this.hokenRehabilitation = hokenRehabilitation;
    }

    /**
     * getHokenSeishinkaSemmonRyoho
     *
     * @return hokenSeishinkaSemmonRyoho
     */
    public int getHokenSeishinkaSemmonRyoho() {
        return hokenSeishinkaSemmonRyoho;
    }

    /**
     * setHokenSeishinkaSemmonRyoho
     *
     * @param hokenSeishinkaSemmonRyoho hokenSeishinkaSemmonRyoho
     */
    public void setHokenSeishinkaSemmonRyoho(int hokenSeishinkaSemmonRyoho) {
        this.hokenSeishinkaSemmonRyoho = hokenSeishinkaSemmonRyoho;
    }

    /**
     * getHokenTotalTanisu
     *
     * @return hokenTotalTanisu
     */
    public int getHokenTotalTanisu() {
        return hokenTotalTanisu;
    }

    /**
     * setHokenTotalTanisu
     *
     * @param hokenTotalTanisu hokenTotalTanisu
     */
    public void setHokenTotalTanisu(int hokenTotalTanisu) {
        this.hokenTotalTanisu = hokenTotalTanisu;
    }

    /**
     * getKohi1ShidoKanriryo
     *
     * @return kohi1ShidoKanriryo
     */
    public int getKohi1ShidoKanriryo() {
        return kohi1ShidoKanriryo;
    }

    /**
     * setKohi1ShidoKanriryo
     *
     * @param kohi1ShidoKanriryo kohi1ShidoKanriryo
     */
    public void setKohi1ShidoKanriryo(int kohi1ShidoKanriryo) {
        this.kohi1ShidoKanriryo = kohi1ShidoKanriryo;
    }

    /**
     * getKohi1TanjunXsen
     *
     * @return kohi1TanjunXsen
     */
    public int getKohi1TanjunXsen() {
        return kohi1TanjunXsen;
    }

    /**
     * setKohi1TanjunXsen
     *
     * @param kohi1TanjunXsen kohi1TanjunXsen
     */
    public void setKohi1TanjunXsen(int kohi1TanjunXsen) {
        this.kohi1TanjunXsen = kohi1TanjunXsen;
    }

    /**
     * getKohi1Rehabilitation
     *
     * @return kohi1Rehabilitation
     */
    public int getKohi1Rehabilitation() {
        return kohi1Rehabilitation;
    }

    /**
     * setKohi1Rehabilitation
     *
     * @param kohi1Rehabilitation kohi1Rehabilitation
     */
    public void setKohi1Rehabilitation(int kohi1Rehabilitation) {
        this.kohi1Rehabilitation = kohi1Rehabilitation;
    }

    /**
     * getKohi1SeishinkaSemmonRyoho
     *
     * @return kohi1SeishinkaSemmonRyoho
     */
    public int getKohi1SeishinkaSemmonRyoho() {
        return kohi1SeishinkaSemmonRyoho;
    }

    /**
     * setKohi1SeishinkaSemmonRyoho
     *
     * @param kohi1SeishinkaSemmonRyoho kohi1SeishinkaSemmonRyoho
     */
    public void setKohi1SeishinkaSemmonRyoho(int kohi1SeishinkaSemmonRyoho) {
        this.kohi1SeishinkaSemmonRyoho = kohi1SeishinkaSemmonRyoho;
    }

    /**
     * getKohi1TotalTanisu
     *
     * @return kohi1TotalTanisu
     */
    public int getKohi1TotalTanisu() {
        return kohi1TotalTanisu;
    }

    /**
     * setKohi1TotalTanisu
     *
     * @param kohi1TotalTanisu kohi1TotalTanisu
     */
    public void setKohi1TotalTanisu(int kohi1TotalTanisu) {
        this.kohi1TotalTanisu = kohi1TotalTanisu;
    }

    /**
     * getKohi2ShidoKanriryo
     *
     * @return kohi2ShidoKanriryo
     */
    public int getKohi2ShidoKanriryo() {
        return kohi2ShidoKanriryo;
    }

    /**
     * setKohi2ShidoKanriryo
     *
     * @param kohi2ShidoKanriryo kohi2ShidoKanriryo
     */
    public void setKohi2ShidoKanriryo(int kohi2ShidoKanriryo) {
        this.kohi2ShidoKanriryo = kohi2ShidoKanriryo;
    }

    /**
     * getKohi2TanjunXsen
     *
     * @return kohi2TanjunXsen
     */
    public int getKohi2TanjunXsen() {
        return kohi2TanjunXsen;
    }

    /**
     * setKohi2TanjunXsen
     *
     * @param kohi2TanjunXsen kohi2TanjunXsen
     */
    public void setKohi2TanjunXsen(int kohi2TanjunXsen) {
        this.kohi2TanjunXsen = kohi2TanjunXsen;
    }

    /**
     * getKohi2Rehabilitation
     *
     * @return kohi2Rehabilitation
     */
    public int getKohi2Rehabilitation() {
        return kohi2Rehabilitation;
    }

    /**
     * setKohi2Rehabilitation
     *
     * @param kohi2Rehabilitation kohi2Rehabilitation
     */
    public void setKohi2Rehabilitation(int kohi2Rehabilitation) {
        this.kohi2Rehabilitation = kohi2Rehabilitation;
    }

    /**
     * getKohi2SeishinkaSemmonRyoho
     *
     * @return kohi2SeishinkaSemmonRyoho
     */
    public int getKohi2SeishinkaSemmonRyoho() {
        return kohi2SeishinkaSemmonRyoho;
    }

    /**
     * setKohi2SeishinkaSemmonRyoho
     *
     * @param kohi2SeishinkaSemmonRyoho kohi2SeishinkaSemmonRyoho
     */
    public void setKohi2SeishinkaSemmonRyoho(int kohi2SeishinkaSemmonRyoho) {
        this.kohi2SeishinkaSemmonRyoho = kohi2SeishinkaSemmonRyoho;
    }

    /**
     * getKohi2TotalTanisu
     *
     * @return kohi2TotalTanisu
     */
    public int getKohi2TotalTanisu() {
        return kohi2TotalTanisu;
    }

    /**
     * setKohi2TotalTanisu
     *
     * @param kohi2TotalTanisu kohi2TotalTanisu
     */
    public void setKohi2TotalTanisu(int kohi2TotalTanisu) {
        this.kohi2TotalTanisu = kohi2TotalTanisu;
    }

    /**
     * getKohi3ShidoKanriryo
     *
     * @return kohi3ShidoKanriryo
     */
    public int getKohi3ShidoKanriryo() {
        return kohi3ShidoKanriryo;
    }

    /**
     * setKohi3ShidoKanriryo
     *
     * @param kohi3ShidoKanriryo kohi3ShidoKanriryo
     */
    public void setKohi3ShidoKanriryo(int kohi3ShidoKanriryo) {
        this.kohi3ShidoKanriryo = kohi3ShidoKanriryo;
    }

    /**
     * getKohi3TanjunXsen
     *
     * @return kohi3TanjunXsen
     */
    public int getKohi3TanjunXsen() {
        return kohi3TanjunXsen;
    }

    /**
     * setKohi3TanjunXsen
     *
     * @param kohi3TanjunXsen kohi3TanjunXsen
     */
    public void setKohi3TanjunXsen(int kohi3TanjunXsen) {
        this.kohi3TanjunXsen = kohi3TanjunXsen;
    }

    /**
     * getKohi3Rehabilitation
     *
     * @return kohi3Rehabilitation
     */
    public int getKohi3Rehabilitation() {
        return kohi3Rehabilitation;
    }

    /**
     * setKohi3Rehabilitation
     *
     * @param kohi3Rehabilitation kohi3Rehabilitation
     */
    public void setKohi3Rehabilitation(int kohi3Rehabilitation) {
        this.kohi3Rehabilitation = kohi3Rehabilitation;
    }

    /**
     * getKohi3SeishinkaSemmonRyoho
     *
     * @return kohi3SeishinkaSemmonRyoho
     */
    public int getKohi3SeishinkaSemmonRyoho() {
        return kohi3SeishinkaSemmonRyoho;
    }

    /**
     * setKohi3SeishinkaSemmonRyoho
     *
     * @param kohi3SeishinkaSemmonRyoho kohi3SeishinkaSemmonRyoho
     */
    public void setKohi3SeishinkaSemmonRyoho(int kohi3SeishinkaSemmonRyoho) {
        this.kohi3SeishinkaSemmonRyoho = kohi3SeishinkaSemmonRyoho;
    }

    /**
     * getKohi3TotalTanisu
     *
     * @return kohi3TotalTanisu
     */
    public int getKohi3TotalTanisu() {
        return kohi3TotalTanisu;
    }

    /**
     * setKohi3TotalTanisu
     *
     * @param kohi3TotalTanisu kohi3TotalTanisu
     */
    public void setKohi3TotalTanisu(int kohi3TotalTanisu) {
        this.kohi3TotalTanisu = kohi3TotalTanisu;
    }

    /**
     * getTekiyo1
     *
     * @return tekiyo1
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * setTekiyo1
     *
     * @param tekiyo1 tekiyo1
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * getTekiyo2
     *
     * @return tekiyo2
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * setTekiyo2
     *
     * @param tekiyo2 tekiyo2
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * getTekiyo3
     *
     * @return tekiyo3
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * setTekiyo3
     *
     * @param tekiyo3 tekiyo3
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * getTekiyo4
     *
     * @return tekiyo4
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * setTekiyo4
     *
     * @param tekiyo4 tekiyo4
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * getTekiyo5
     *
     * @return tekiyo5
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * setTekiyo5
     *
     * @param tekiyo5 tekiyo5
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * getTekiyo6
     *
     * @return tekiyo6
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * setTekiyo6
     *
     * @param tekiyo6 tekiyo6
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * getTekiyo7
     *
     * @return tekiyo7
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * setTekiyo7
     *
     * @param tekiyo7 tekiyo7
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * getTekiyo8
     *
     * @return tekiyo8
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * setTekiyo8
     *
     * @param tekiyo8 tekiyo8
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * getTekiyo9
     *
     * @return tekiyo9
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * setTekiyo9
     *
     * @param tekiyo9 tekiyo9
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * getTekiyo10
     *
     * @return tekiyo10
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * setTekiyo10
     *
     * @param tekiyo10 tekiyo10
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * getTekiyo11
     *
     * @return tekiyo11
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * setTekiyo11
     *
     * @param tekiyo11 tekiyo11
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * getTekiyo12
     *
     * @return tekiyo12
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * setTekiyo12
     *
     * @param tekiyo12 tekiyo12
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * getTekiyo13
     *
     * @return tekiyo13
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * setTekiyo13
     *
     * @param tekiyo13 tekiyo13
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * getTekiyo14
     *
     * @return tekiyo14
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * setTekiyo14
     *
     * @param tekiyo14 tekiyo14
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * getTekiyo15
     *
     * @return tekiyo15
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * setTekiyo15
     *
     * @param tekiyo15 tekiyo15
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * getTekiyo16
     *
     * @return tekiyo16
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * setTekiyo16
     *
     * @param tekiyo16 tekiyo16
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * getTekiyo17
     *
     * @return tekiyo17
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * setTekiyo17
     *
     * @param tekiyo17 tekiyo17
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * getTekiyo18
     *
     * @return tekiyo18
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * setTekiyo18
     *
     * @param tekiyo18 tekiyo18
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * getTekiyo19
     *
     * @return tekiyo19
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * setTekiyo19
     *
     * @param tekiyo19 tekiyo19
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * getTekiyo20
     *
     * @return tekiyo20
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * setTekiyo20
     *
     * @param tekiyo20 tekiyo20
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * getAtoHokenShidoKanriryo
     *
     * @return atoHokenShidoKanriryo
     */
    public int getAtoHokenShidoKanriryo() {
        return atoHokenShidoKanriryo;
    }

    /**
     * setAtoHokenShidoKanriryo
     *
     * @param atoHokenShidoKanriryo atoHokenShidoKanriryo
     */
    public void setAtoHokenShidoKanriryo(int atoHokenShidoKanriryo) {
        this.atoHokenShidoKanriryo = atoHokenShidoKanriryo;
    }

    /**
     * getAtoHokenTanjunXsen
     *
     * @return atoHokenTanjunXsen
     */
    public int getAtoHokenTanjunXsen() {
        return atoHokenTanjunXsen;
    }

    /**
     * setAtoHokenTanjunXsen
     *
     * @param atoHokenTanjunXsen atoHokenTanjunXsen
     */
    public void setAtoHokenTanjunXsen(int atoHokenTanjunXsen) {
        this.atoHokenTanjunXsen = atoHokenTanjunXsen;
    }

    /**
     * getAtoHokenRehabilitation
     *
     * @return atoHokenRehabilitation
     */
    public int getAtoHokenRehabilitation() {
        return atoHokenRehabilitation;
    }

    /**
     * setAtoHokenRehabilitation
     *
     * @param atoHokenRehabilitation atoHokenRehabilitation
     */
    public void setAtoHokenRehabilitation(int atoHokenRehabilitation) {
        this.atoHokenRehabilitation = atoHokenRehabilitation;
    }

    /**
     * getAtoHokenSeishinkaSemmonRyoho
     *
     * @return atoHokenSeishinkaSemmonRyoho
     */
    public int getAtoHokenSeishinkaSemmonRyoho() {
        return atoHokenSeishinkaSemmonRyoho;
    }

    /**
     * setAtoHokenSeishinkaSemmonRyoho
     *
     * @param atoHokenSeishinkaSemmonRyoho atoHokenSeishinkaSemmonRyoho
     */
    public void setAtoHokenSeishinkaSemmonRyoho(int atoHokenSeishinkaSemmonRyoho) {
        this.atoHokenSeishinkaSemmonRyoho = atoHokenSeishinkaSemmonRyoho;
    }

    /**
     * getAtoKohi1ShidoKanriryo
     *
     * @return atoKohi1ShidoKanriryo
     */
    public int getAtoKohi1ShidoKanriryo() {
        return atoKohi1ShidoKanriryo;
    }

    /**
     * setAtoKohi1ShidoKanriryo
     *
     * @param atoKohi1ShidoKanriryo atoKohi1ShidoKanriryo
     */
    public void setAtoKohi1ShidoKanriryo(int atoKohi1ShidoKanriryo) {
        this.atoKohi1ShidoKanriryo = atoKohi1ShidoKanriryo;
    }

    /**
     * getAtoKohi1TanjunXsen
     *
     * @return atoKohi1TanjunXsen
     */
    public int getAtoKohi1TanjunXsen() {
        return atoKohi1TanjunXsen;
    }

    /**
     * setAtoKohi1TanjunXsen
     *
     * @param atoKohi1TanjunXsen atoKohi1TanjunXsen
     */
    public void setAtoKohi1TanjunXsen(int atoKohi1TanjunXsen) {
        this.atoKohi1TanjunXsen = atoKohi1TanjunXsen;
    }

    /**
     * getAtoKohi1Rehabilitation
     *
     * @return atoKohi1Rehabilitation
     */
    public int getAtoKohi1Rehabilitation() {
        return atoKohi1Rehabilitation;
    }

    /**
     * setAtoKohi1Rehabilitation
     *
     * @param atoKohi1Rehabilitation atoKohi1Rehabilitation
     */
    public void setAtoKohi1Rehabilitation(int atoKohi1Rehabilitation) {
        this.atoKohi1Rehabilitation = atoKohi1Rehabilitation;
    }

    /**
     * getAtoKohi1SeishinkaSemmonRyoho
     *
     * @return atoKohi1SeishinkaSemmonRyoho
     */
    public int getAtoKohi1SeishinkaSemmonRyoho() {
        return atoKohi1SeishinkaSemmonRyoho;
    }

    /**
     * setAtoKohi1SeishinkaSemmonRyoho
     *
     * @param atoKohi1SeishinkaSemmonRyoho atoKohi1SeishinkaSemmonRyoho
     */
    public void setAtoKohi1SeishinkaSemmonRyoho(int atoKohi1SeishinkaSemmonRyoho) {
        this.atoKohi1SeishinkaSemmonRyoho = atoKohi1SeishinkaSemmonRyoho;
    }

    /**
     * getAtoKohi2ShidoKanriryo
     *
     * @return atoKohi2ShidoKanriryo
     */
    public int getAtoKohi2ShidoKanriryo() {
        return atoKohi2ShidoKanriryo;
    }

    /**
     * setAtoKohi2ShidoKanriryo
     *
     * @param atoKohi2ShidoKanriryo atoKohi2ShidoKanriryo
     */
    public void setAtoKohi2ShidoKanriryo(int atoKohi2ShidoKanriryo) {
        this.atoKohi2ShidoKanriryo = atoKohi2ShidoKanriryo;
    }

    /**
     * getAtoKohi2TanjunXsen
     *
     * @return atoKohi2TanjunXsen
     */
    public int getAtoKohi2TanjunXsen() {
        return atoKohi2TanjunXsen;
    }

    /**
     * setAtoKohi2TanjunXsen
     *
     * @param atoKohi2TanjunXsen atoKohi2TanjunXsen
     */
    public void setAtoKohi2TanjunXsen(int atoKohi2TanjunXsen) {
        this.atoKohi2TanjunXsen = atoKohi2TanjunXsen;
    }

    /**
     * getAtoKohi2Rehabilitation
     *
     * @return atoKohi2Rehabilitation
     */
    public int getAtoKohi2Rehabilitation() {
        return atoKohi2Rehabilitation;
    }

    /**
     * setAtoKohi2Rehabilitation
     *
     * @param atoKohi2Rehabilitation atoKohi2Rehabilitation
     */
    public void setAtoKohi2Rehabilitation(int atoKohi2Rehabilitation) {
        this.atoKohi2Rehabilitation = atoKohi2Rehabilitation;
    }

    /**
     * getAtoKohi2SeishinkaSemmonRyoho
     *
     * @return atoKohi2SeishinkaSemmonRyoho
     */
    public int getAtoKohi2SeishinkaSemmonRyoho() {
        return atoKohi2SeishinkaSemmonRyoho;
    }

    /**
     * setAtoKohi2SeishinkaSemmonRyoho
     *
     * @param atoKohi2SeishinkaSemmonRyoho atoKohi2SeishinkaSemmonRyoho
     */
    public void setAtoKohi2SeishinkaSemmonRyoho(int atoKohi2SeishinkaSemmonRyoho) {
        this.atoKohi2SeishinkaSemmonRyoho = atoKohi2SeishinkaSemmonRyoho;
    }

    /**
     * getAtoKohi3ShidoKanriryo
     *
     * @return atoKohi3ShidoKanriryo
     */
    public int getAtoKohi3ShidoKanriryo() {
        return atoKohi3ShidoKanriryo;
    }

    /**
     * setAtoKohi3ShidoKanriryo
     *
     * @param atoKohi3ShidoKanriryo atoKohi3ShidoKanriryo
     */
    public void setAtoKohi3ShidoKanriryo(int atoKohi3ShidoKanriryo) {
        this.atoKohi3ShidoKanriryo = atoKohi3ShidoKanriryo;
    }

    /**
     * getAtoKohi3TanjunXsen
     *
     * @return atoKohi3TanjunXsen
     */
    public int getAtoKohi3TanjunXsen() {
        return atoKohi3TanjunXsen;
    }

    /**
     * setAtoKohi3TanjunXsen
     *
     * @param atoKohi3TanjunXsen atoKohi3TanjunXsen
     */
    public void setAtoKohi3TanjunXsen(int atoKohi3TanjunXsen) {
        this.atoKohi3TanjunXsen = atoKohi3TanjunXsen;
    }

    /**
     * getAtoKohi3Rehabilitation
     *
     * @return atoKohi3Rehabilitation
     */
    public int getAtoKohi3Rehabilitation() {
        return atoKohi3Rehabilitation;
    }

    /**
     * setAtoKohi3Rehabilitation
     *
     * @param atoKohi3Rehabilitation atoKohi3Rehabilitation
     */
    public void setAtoKohi3Rehabilitation(int atoKohi3Rehabilitation) {
        this.atoKohi3Rehabilitation = atoKohi3Rehabilitation;
    }

    /**
     * getAtoKohi3SeishinkaSemmonRyoho
     *
     * @return atoKohi3SeishinkaSemmonRyoho
     */
    public int getAtoKohi3SeishinkaSemmonRyoho() {
        return atoKohi3SeishinkaSemmonRyoho;
    }

    /**
     * setAtoKohi3SeishinkaSemmonRyoho
     *
     * @param atoKohi3SeishinkaSemmonRyoho atoKohi3SeishinkaSemmonRyoho
     */
    public void setAtoKohi3SeishinkaSemmonRyoho(int atoKohi3SeishinkaSemmonRyoho) {
        this.atoKohi3SeishinkaSemmonRyoho = atoKohi3SeishinkaSemmonRyoho;
    }

    /**
     * getSaishinsaKaisu
     *
     * @return saishinsaKaisu
     */
    public int getSaishinsaKaisu() {
        return saishinsaKaisu;
    }

    /**
     * setSaishinsaKaisu
     *
     * @param saishinsaKaisu saishinsaKaisu
     */
    public void setSaishinsaKaisu(int saishinsaKaisu) {
        this.saishinsaKaisu = saishinsaKaisu;
    }

    /**
     * getKagoKaisu
     *
     * @return kagoKaisu
     */
    public int getKagoKaisu() {
        return kagoKaisu;
    }

    /**
     * setKagoKaisu
     *
     * @param kagoKaisu kagoKaisu
     */
    public void setKagoKaisu(int kagoKaisu) {
        this.kagoKaisu = kagoKaisu;
    }

    /**
     * getShinsaYM
     *
     * @return shinsaYM
     */
    public FlexibleYearMonth getShinsaYM() {
        return shinsaYM;
    }

    /**
     * setShinsaYM
     *
     * @param shinsaYM shinsaYM
     */
    public void setShinsaYM(FlexibleYearMonth shinsaYM) {
        this.shinsaYM = shinsaYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getTorikomiYM
     *
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     *
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3020KyufujissekiTokuteiSinryohiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3020KyufujissekiTokuteiSinryohiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3020KyufujissekiTokuteiSinryohiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kokanJohoShikibetsuNo, other.kokanJohoShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.inputShikibetsuNo, other.inputShikibetsuNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeShubetsuCode, other.recodeShubetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.shokisaiHokenshaNo, other.shokisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshoNo, other.jigyoshoNo)) {
            return false;
        }
        if (!Objects.equals(this.toshiNo, other.toshiNo)) {
            return false;
        }
        if (!Objects.equals(this.recodeJunjiNo, other.recodeJunjiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3020KyufujissekiTokuteiSinryohiEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.recodeJunjiNo = entity.recodeJunjiNo;
        this.shobyoName = entity.shobyoName;
        this.hokenShidoKanriryo = entity.hokenShidoKanriryo;
        this.hokenTanjunXsen = entity.hokenTanjunXsen;
        this.hokenRehabilitation = entity.hokenRehabilitation;
        this.hokenSeishinkaSemmonRyoho = entity.hokenSeishinkaSemmonRyoho;
        this.hokenTotalTanisu = entity.hokenTotalTanisu;
        this.kohi1ShidoKanriryo = entity.kohi1ShidoKanriryo;
        this.kohi1TanjunXsen = entity.kohi1TanjunXsen;
        this.kohi1Rehabilitation = entity.kohi1Rehabilitation;
        this.kohi1SeishinkaSemmonRyoho = entity.kohi1SeishinkaSemmonRyoho;
        this.kohi1TotalTanisu = entity.kohi1TotalTanisu;
        this.kohi2ShidoKanriryo = entity.kohi2ShidoKanriryo;
        this.kohi2TanjunXsen = entity.kohi2TanjunXsen;
        this.kohi2Rehabilitation = entity.kohi2Rehabilitation;
        this.kohi2SeishinkaSemmonRyoho = entity.kohi2SeishinkaSemmonRyoho;
        this.kohi2TotalTanisu = entity.kohi2TotalTanisu;
        this.kohi3ShidoKanriryo = entity.kohi3ShidoKanriryo;
        this.kohi3TanjunXsen = entity.kohi3TanjunXsen;
        this.kohi3Rehabilitation = entity.kohi3Rehabilitation;
        this.kohi3SeishinkaSemmonRyoho = entity.kohi3SeishinkaSemmonRyoho;
        this.kohi3TotalTanisu = entity.kohi3TotalTanisu;
        this.tekiyo1 = entity.tekiyo1;
        this.tekiyo2 = entity.tekiyo2;
        this.tekiyo3 = entity.tekiyo3;
        this.tekiyo4 = entity.tekiyo4;
        this.tekiyo5 = entity.tekiyo5;
        this.tekiyo6 = entity.tekiyo6;
        this.tekiyo7 = entity.tekiyo7;
        this.tekiyo8 = entity.tekiyo8;
        this.tekiyo9 = entity.tekiyo9;
        this.tekiyo10 = entity.tekiyo10;
        this.tekiyo11 = entity.tekiyo11;
        this.tekiyo12 = entity.tekiyo12;
        this.tekiyo13 = entity.tekiyo13;
        this.tekiyo14 = entity.tekiyo14;
        this.tekiyo15 = entity.tekiyo15;
        this.tekiyo16 = entity.tekiyo16;
        this.tekiyo17 = entity.tekiyo17;
        this.tekiyo18 = entity.tekiyo18;
        this.tekiyo19 = entity.tekiyo19;
        this.tekiyo20 = entity.tekiyo20;
        this.atoHokenShidoKanriryo = entity.atoHokenShidoKanriryo;
        this.atoHokenTanjunXsen = entity.atoHokenTanjunXsen;
        this.atoHokenRehabilitation = entity.atoHokenRehabilitation;
        this.atoHokenSeishinkaSemmonRyoho = entity.atoHokenSeishinkaSemmonRyoho;
        this.atoKohi1ShidoKanriryo = entity.atoKohi1ShidoKanriryo;
        this.atoKohi1TanjunXsen = entity.atoKohi1TanjunXsen;
        this.atoKohi1Rehabilitation = entity.atoKohi1Rehabilitation;
        this.atoKohi1SeishinkaSemmonRyoho = entity.atoKohi1SeishinkaSemmonRyoho;
        this.atoKohi2ShidoKanriryo = entity.atoKohi2ShidoKanriryo;
        this.atoKohi2TanjunXsen = entity.atoKohi2TanjunXsen;
        this.atoKohi2Rehabilitation = entity.atoKohi2Rehabilitation;
        this.atoKohi2SeishinkaSemmonRyoho = entity.atoKohi2SeishinkaSemmonRyoho;
        this.atoKohi3ShidoKanriryo = entity.atoKohi3ShidoKanriryo;
        this.atoKohi3TanjunXsen = entity.atoKohi3TanjunXsen;
        this.atoKohi3Rehabilitation = entity.atoKohi3Rehabilitation;
        this.atoKohi3SeishinkaSemmonRyoho = entity.atoKohi3SeishinkaSemmonRyoho;
        this.saishinsaKaisu = entity.saishinsaKaisu;
        this.kagoKaisu = entity.kagoKaisu;
        this.shinsaYM = entity.shinsaYM;
        this.seiriNo = entity.seiriNo;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, recodeJunjiNo, shobyoName, hokenShidoKanriryo, hokenTanjunXsen, hokenRehabilitation, hokenSeishinkaSemmonRyoho, hokenTotalTanisu, kohi1ShidoKanriryo, kohi1TanjunXsen, kohi1Rehabilitation, kohi1SeishinkaSemmonRyoho, kohi1TotalTanisu, kohi2ShidoKanriryo, kohi2TanjunXsen, kohi2Rehabilitation, kohi2SeishinkaSemmonRyoho, kohi2TotalTanisu, kohi3ShidoKanriryo, kohi3TanjunXsen, kohi3Rehabilitation, kohi3SeishinkaSemmonRyoho, kohi3TotalTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20, atoHokenShidoKanriryo, atoHokenTanjunXsen, atoHokenRehabilitation, atoHokenSeishinkaSemmonRyoho, atoKohi1ShidoKanriryo, atoKohi1TanjunXsen, atoKohi1Rehabilitation, atoKohi1SeishinkaSemmonRyoho, atoKohi2ShidoKanriryo, atoKohi2TanjunXsen, atoKohi2Rehabilitation, atoKohi2SeishinkaSemmonRyoho, atoKohi3ShidoKanriryo, atoKohi3TanjunXsen, atoKohi3Rehabilitation, atoKohi3SeishinkaSemmonRyoho, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
