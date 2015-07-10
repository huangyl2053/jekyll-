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
 * DbT3022KyufujissekiShokujiHiyoの項目定義クラスです
 *
 */
public class DbT3022KyufujissekiShokujiHiyoEntity extends DbTableEntityBase<DbT3022KyufujissekiShokujiHiyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3022KyufujissekiShokujiHiyo");

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
    private int kihonTeikyoNissu;
    private int kihonTeikyoTanka;
    private int kihonTeikyoKingaku;
    private int tokubestuTeikyoNissu;
    private int tokubestuTeikyoTanka;
    private int tokubestuTeikyoKingaku;
    private int syokujiTeikyoNissu;
    private int kohi1SyokujiTeikyoNissu;
    private int kohi2SyokujiTeikyoNissu;
    private int kohi3SyokujiTeikyoNissu;
    private int syokujiTeikyohiTotal;
    private int getsugakuHyojunFutanGaku;
    private int syokujiTeikyohiSeikyugaku;
    private int kohi1SyokujiTeikyohiSeikyugaku;
    private int kohi2SyokujiTeikyohiSeikyugaku;
    private int kohi3SyokujiTeikyohiSeikyugaku;
    private int nichigakuHyojunFutanGaku;
    private int atoKihonTeikyoTanka;
    private int atoTokubestuTeikyoTanka;
    private int atoSyokujiTeikyohiSeikyugaku;
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
     * getKihonTeikyoNissu
     *
     * @return kihonTeikyoNissu
     */
    public int getKihonTeikyoNissu() {
        return kihonTeikyoNissu;
    }

    /**
     * setKihonTeikyoNissu
     *
     * @param kihonTeikyoNissu kihonTeikyoNissu
     */
    public void setKihonTeikyoNissu(int kihonTeikyoNissu) {
        this.kihonTeikyoNissu = kihonTeikyoNissu;
    }

    /**
     * getKihonTeikyoTanka
     *
     * @return kihonTeikyoTanka
     */
    public int getKihonTeikyoTanka() {
        return kihonTeikyoTanka;
    }

    /**
     * setKihonTeikyoTanka
     *
     * @param kihonTeikyoTanka kihonTeikyoTanka
     */
    public void setKihonTeikyoTanka(int kihonTeikyoTanka) {
        this.kihonTeikyoTanka = kihonTeikyoTanka;
    }

    /**
     * getKihonTeikyoKingaku
     *
     * @return kihonTeikyoKingaku
     */
    public int getKihonTeikyoKingaku() {
        return kihonTeikyoKingaku;
    }

    /**
     * setKihonTeikyoKingaku
     *
     * @param kihonTeikyoKingaku kihonTeikyoKingaku
     */
    public void setKihonTeikyoKingaku(int kihonTeikyoKingaku) {
        this.kihonTeikyoKingaku = kihonTeikyoKingaku;
    }

    /**
     * getTokubestuTeikyoNissu
     *
     * @return tokubestuTeikyoNissu
     */
    public int getTokubestuTeikyoNissu() {
        return tokubestuTeikyoNissu;
    }

    /**
     * setTokubestuTeikyoNissu
     *
     * @param tokubestuTeikyoNissu tokubestuTeikyoNissu
     */
    public void setTokubestuTeikyoNissu(int tokubestuTeikyoNissu) {
        this.tokubestuTeikyoNissu = tokubestuTeikyoNissu;
    }

    /**
     * getTokubestuTeikyoTanka
     *
     * @return tokubestuTeikyoTanka
     */
    public int getTokubestuTeikyoTanka() {
        return tokubestuTeikyoTanka;
    }

    /**
     * setTokubestuTeikyoTanka
     *
     * @param tokubestuTeikyoTanka tokubestuTeikyoTanka
     */
    public void setTokubestuTeikyoTanka(int tokubestuTeikyoTanka) {
        this.tokubestuTeikyoTanka = tokubestuTeikyoTanka;
    }

    /**
     * getTokubestuTeikyoKingaku
     *
     * @return tokubestuTeikyoKingaku
     */
    public int getTokubestuTeikyoKingaku() {
        return tokubestuTeikyoKingaku;
    }

    /**
     * setTokubestuTeikyoKingaku
     *
     * @param tokubestuTeikyoKingaku tokubestuTeikyoKingaku
     */
    public void setTokubestuTeikyoKingaku(int tokubestuTeikyoKingaku) {
        this.tokubestuTeikyoKingaku = tokubestuTeikyoKingaku;
    }

    /**
     * getSyokujiTeikyoNissu
     *
     * @return syokujiTeikyoNissu
     */
    public int getSyokujiTeikyoNissu() {
        return syokujiTeikyoNissu;
    }

    /**
     * setSyokujiTeikyoNissu
     *
     * @param syokujiTeikyoNissu syokujiTeikyoNissu
     */
    public void setSyokujiTeikyoNissu(int syokujiTeikyoNissu) {
        this.syokujiTeikyoNissu = syokujiTeikyoNissu;
    }

    /**
     * getKohi1SyokujiTeikyoNissu
     *
     * @return kohi1SyokujiTeikyoNissu
     */
    public int getKohi1SyokujiTeikyoNissu() {
        return kohi1SyokujiTeikyoNissu;
    }

    /**
     * setKohi1SyokujiTeikyoNissu
     *
     * @param kohi1SyokujiTeikyoNissu kohi1SyokujiTeikyoNissu
     */
    public void setKohi1SyokujiTeikyoNissu(int kohi1SyokujiTeikyoNissu) {
        this.kohi1SyokujiTeikyoNissu = kohi1SyokujiTeikyoNissu;
    }

    /**
     * getKohi2SyokujiTeikyoNissu
     *
     * @return kohi2SyokujiTeikyoNissu
     */
    public int getKohi2SyokujiTeikyoNissu() {
        return kohi2SyokujiTeikyoNissu;
    }

    /**
     * setKohi2SyokujiTeikyoNissu
     *
     * @param kohi2SyokujiTeikyoNissu kohi2SyokujiTeikyoNissu
     */
    public void setKohi2SyokujiTeikyoNissu(int kohi2SyokujiTeikyoNissu) {
        this.kohi2SyokujiTeikyoNissu = kohi2SyokujiTeikyoNissu;
    }

    /**
     * getKohi3SyokujiTeikyoNissu
     *
     * @return kohi3SyokujiTeikyoNissu
     */
    public int getKohi3SyokujiTeikyoNissu() {
        return kohi3SyokujiTeikyoNissu;
    }

    /**
     * setKohi3SyokujiTeikyoNissu
     *
     * @param kohi3SyokujiTeikyoNissu kohi3SyokujiTeikyoNissu
     */
    public void setKohi3SyokujiTeikyoNissu(int kohi3SyokujiTeikyoNissu) {
        this.kohi3SyokujiTeikyoNissu = kohi3SyokujiTeikyoNissu;
    }

    /**
     * getSyokujiTeikyohiTotal
     *
     * @return syokujiTeikyohiTotal
     */
    public int getSyokujiTeikyohiTotal() {
        return syokujiTeikyohiTotal;
    }

    /**
     * setSyokujiTeikyohiTotal
     *
     * @param syokujiTeikyohiTotal syokujiTeikyohiTotal
     */
    public void setSyokujiTeikyohiTotal(int syokujiTeikyohiTotal) {
        this.syokujiTeikyohiTotal = syokujiTeikyohiTotal;
    }

    /**
     * getGetsugakuHyojunFutanGaku
     *
     * @return getsugakuHyojunFutanGaku
     */
    public int getGetsugakuHyojunFutanGaku() {
        return getsugakuHyojunFutanGaku;
    }

    /**
     * setGetsugakuHyojunFutanGaku
     *
     * @param getsugakuHyojunFutanGaku getsugakuHyojunFutanGaku
     */
    public void setGetsugakuHyojunFutanGaku(int getsugakuHyojunFutanGaku) {
        this.getsugakuHyojunFutanGaku = getsugakuHyojunFutanGaku;
    }

    /**
     * getSyokujiTeikyohiSeikyugaku
     *
     * @return syokujiTeikyohiSeikyugaku
     */
    public int getSyokujiTeikyohiSeikyugaku() {
        return syokujiTeikyohiSeikyugaku;
    }

    /**
     * setSyokujiTeikyohiSeikyugaku
     *
     * @param syokujiTeikyohiSeikyugaku syokujiTeikyohiSeikyugaku
     */
    public void setSyokujiTeikyohiSeikyugaku(int syokujiTeikyohiSeikyugaku) {
        this.syokujiTeikyohiSeikyugaku = syokujiTeikyohiSeikyugaku;
    }

    /**
     * getKohi1SyokujiTeikyohiSeikyugaku
     *
     * @return kohi1SyokujiTeikyohiSeikyugaku
     */
    public int getKohi1SyokujiTeikyohiSeikyugaku() {
        return kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * setKohi1SyokujiTeikyohiSeikyugaku
     *
     * @param kohi1SyokujiTeikyohiSeikyugaku kohi1SyokujiTeikyohiSeikyugaku
     */
    public void setKohi1SyokujiTeikyohiSeikyugaku(int kohi1SyokujiTeikyohiSeikyugaku) {
        this.kohi1SyokujiTeikyohiSeikyugaku = kohi1SyokujiTeikyohiSeikyugaku;
    }

    /**
     * getKohi2SyokujiTeikyohiSeikyugaku
     *
     * @return kohi2SyokujiTeikyohiSeikyugaku
     */
    public int getKohi2SyokujiTeikyohiSeikyugaku() {
        return kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * setKohi2SyokujiTeikyohiSeikyugaku
     *
     * @param kohi2SyokujiTeikyohiSeikyugaku kohi2SyokujiTeikyohiSeikyugaku
     */
    public void setKohi2SyokujiTeikyohiSeikyugaku(int kohi2SyokujiTeikyohiSeikyugaku) {
        this.kohi2SyokujiTeikyohiSeikyugaku = kohi2SyokujiTeikyohiSeikyugaku;
    }

    /**
     * getKohi3SyokujiTeikyohiSeikyugaku
     *
     * @return kohi3SyokujiTeikyohiSeikyugaku
     */
    public int getKohi3SyokujiTeikyohiSeikyugaku() {
        return kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * setKohi3SyokujiTeikyohiSeikyugaku
     *
     * @param kohi3SyokujiTeikyohiSeikyugaku kohi3SyokujiTeikyohiSeikyugaku
     */
    public void setKohi3SyokujiTeikyohiSeikyugaku(int kohi3SyokujiTeikyohiSeikyugaku) {
        this.kohi3SyokujiTeikyohiSeikyugaku = kohi3SyokujiTeikyohiSeikyugaku;
    }

    /**
     * getNichigakuHyojunFutanGaku
     *
     * @return nichigakuHyojunFutanGaku
     */
    public int getNichigakuHyojunFutanGaku() {
        return nichigakuHyojunFutanGaku;
    }

    /**
     * setNichigakuHyojunFutanGaku
     *
     * @param nichigakuHyojunFutanGaku nichigakuHyojunFutanGaku
     */
    public void setNichigakuHyojunFutanGaku(int nichigakuHyojunFutanGaku) {
        this.nichigakuHyojunFutanGaku = nichigakuHyojunFutanGaku;
    }

    /**
     * getAtoKihonTeikyoTanka
     *
     * @return atoKihonTeikyoTanka
     */
    public int getAtoKihonTeikyoTanka() {
        return atoKihonTeikyoTanka;
    }

    /**
     * setAtoKihonTeikyoTanka
     *
     * @param atoKihonTeikyoTanka atoKihonTeikyoTanka
     */
    public void setAtoKihonTeikyoTanka(int atoKihonTeikyoTanka) {
        this.atoKihonTeikyoTanka = atoKihonTeikyoTanka;
    }

    /**
     * getAtoTokubestuTeikyoTanka
     *
     * @return atoTokubestuTeikyoTanka
     */
    public int getAtoTokubestuTeikyoTanka() {
        return atoTokubestuTeikyoTanka;
    }

    /**
     * setAtoTokubestuTeikyoTanka
     *
     * @param atoTokubestuTeikyoTanka atoTokubestuTeikyoTanka
     */
    public void setAtoTokubestuTeikyoTanka(int atoTokubestuTeikyoTanka) {
        this.atoTokubestuTeikyoTanka = atoTokubestuTeikyoTanka;
    }

    /**
     * getAtoSyokujiTeikyohiSeikyugaku
     *
     * @return atoSyokujiTeikyohiSeikyugaku
     */
    public int getAtoSyokujiTeikyohiSeikyugaku() {
        return atoSyokujiTeikyohiSeikyugaku;
    }

    /**
     * setAtoSyokujiTeikyohiSeikyugaku
     *
     * @param atoSyokujiTeikyohiSeikyugaku atoSyokujiTeikyohiSeikyugaku
     */
    public void setAtoSyokujiTeikyohiSeikyugaku(int atoSyokujiTeikyohiSeikyugaku) {
        this.atoSyokujiTeikyohiSeikyugaku = atoSyokujiTeikyohiSeikyugaku;
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
     * このエンティティの主キーが他の{@literal DbT3022KyufujissekiShokujiHiyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3022KyufujissekiShokujiHiyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3022KyufujissekiShokujiHiyoEntity other) {
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
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3022KyufujissekiShokujiHiyoEntity entity) {
        this.kokanJohoShikibetsuNo = entity.kokanJohoShikibetsuNo;
        this.inputShikibetsuNo = entity.inputShikibetsuNo;
        this.recodeShubetsuCode = entity.recodeShubetsuCode;
        this.shokisaiHokenshaNo = entity.shokisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.toshiNo = entity.toshiNo;
        this.kihonTeikyoNissu = entity.kihonTeikyoNissu;
        this.kihonTeikyoTanka = entity.kihonTeikyoTanka;
        this.kihonTeikyoKingaku = entity.kihonTeikyoKingaku;
        this.tokubestuTeikyoNissu = entity.tokubestuTeikyoNissu;
        this.tokubestuTeikyoTanka = entity.tokubestuTeikyoTanka;
        this.tokubestuTeikyoKingaku = entity.tokubestuTeikyoKingaku;
        this.syokujiTeikyoNissu = entity.syokujiTeikyoNissu;
        this.kohi1SyokujiTeikyoNissu = entity.kohi1SyokujiTeikyoNissu;
        this.kohi2SyokujiTeikyoNissu = entity.kohi2SyokujiTeikyoNissu;
        this.kohi3SyokujiTeikyoNissu = entity.kohi3SyokujiTeikyoNissu;
        this.syokujiTeikyohiTotal = entity.syokujiTeikyohiTotal;
        this.getsugakuHyojunFutanGaku = entity.getsugakuHyojunFutanGaku;
        this.syokujiTeikyohiSeikyugaku = entity.syokujiTeikyohiSeikyugaku;
        this.kohi1SyokujiTeikyohiSeikyugaku = entity.kohi1SyokujiTeikyohiSeikyugaku;
        this.kohi2SyokujiTeikyohiSeikyugaku = entity.kohi2SyokujiTeikyohiSeikyugaku;
        this.kohi3SyokujiTeikyohiSeikyugaku = entity.kohi3SyokujiTeikyohiSeikyugaku;
        this.nichigakuHyojunFutanGaku = entity.nichigakuHyojunFutanGaku;
        this.atoKihonTeikyoTanka = entity.atoKihonTeikyoTanka;
        this.atoTokubestuTeikyoTanka = entity.atoTokubestuTeikyoTanka;
        this.atoSyokujiTeikyohiSeikyugaku = entity.atoSyokujiTeikyohiSeikyugaku;
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
        return super.toMd5(kokanJohoShikibetsuNo, inputShikibetsuNo, recodeShubetsuCode, shokisaiHokenshaNo, hiHokenshaNo, serviceTeikyoYM, jigyoshoNo, toshiNo, kihonTeikyoNissu, kihonTeikyoTanka, kihonTeikyoKingaku, tokubestuTeikyoNissu, tokubestuTeikyoTanka, tokubestuTeikyoKingaku, syokujiTeikyoNissu, kohi1SyokujiTeikyoNissu, kohi2SyokujiTeikyoNissu, kohi3SyokujiTeikyoNissu, syokujiTeikyohiTotal, getsugakuHyojunFutanGaku, syokujiTeikyohiSeikyugaku, kohi1SyokujiTeikyohiSeikyugaku, kohi2SyokujiTeikyohiSeikyugaku, kohi3SyokujiTeikyohiSeikyugaku, nichigakuHyojunFutanGaku, atoKihonTeikyoTanka, atoTokubestuTeikyoTanka, atoSyokujiTeikyohiSeikyugaku, saishinsaKaisu, kagoKaisu, shinsaYM, seiriNo, torikomiYM);
    }

// </editor-fold>
}
