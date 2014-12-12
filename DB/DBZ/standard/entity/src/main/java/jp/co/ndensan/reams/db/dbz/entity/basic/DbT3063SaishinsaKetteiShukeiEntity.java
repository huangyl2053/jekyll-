package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * DbT3063SaishinsaKetteiShukeiの項目定義クラスです
 *
 */
public class DbT3063SaishinsaKetteiShukeiEntity extends DbTableEntityBase<DbT3063SaishinsaKetteiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3063SaishinsaKetteiShukei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYearMonth toriatsukaiYM;
    @PrimaryKey
    private RString hokenshaKubun;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private int kaigoKyufuhiSeikyuKensu;
    private Decimal kaigoKyufuhiSeikyuTanisu;
    private Decimal kaigoKyufuhiSeikyuFutangaku;
    private int kaigoKyufuhiKetteiKensu;
    private Decimal kaigoKyufuhiKetteiTanisu;
    private Decimal kaigoKyufuhiKetteiFutangaku;
    private int kaigoKyufuhiChoseiKensu;
    private Decimal kaigoKyufuhiChoseiTanisu;
    private Decimal kaigoKyufuhiChoseiFutangaku;
    private int kogakuKaigoServicehiSeikyuKensu;
    private Decimal kogakuKaigoServicehiSeikyuTanisu;
    private Decimal kogakuKaigoServicehiSeikyuFutangaku;
    private int kogakuKaigoServicehiKetteiKensu;
    private Decimal kogakuKaigoServicehiKetteiTanisu;
    private Decimal kogakuKaigoServicehiKetteiFutangaku;
    private int kogakuKaigoServicehiChoseiKensu;
    private Decimal kogakuKaigoServicehiChoseiTanisu;
    private Decimal kogakuKaigoServicehiChoseiFutangaku;
    private RString kohiFutanshaNo;
    private FlexibleDate sakuseiYMD;
    private RString sinsaiinkaiName;
    private FlexibleYearMonth torikomiYM;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getToriatsukaiYM
     * @return toriatsukaiYM
     */
    public FlexibleYearMonth getToriatsukaiYM() {
        return toriatsukaiYM;
    }

    /**
     * setToriatsukaiYM
     * @param toriatsukaiYM toriatsukaiYM
     */
    public void setToriatsukaiYM(FlexibleYearMonth toriatsukaiYM) {
        this.toriatsukaiYM = toriatsukaiYM;
    }

    /**
     * getHokenshaKubun
     * @return hokenshaKubun
     */
    public RString getHokenshaKubun() {
        return hokenshaKubun;
    }

    /**
     * setHokenshaKubun
     * @param hokenshaKubun hokenshaKubun
     */
    public void setHokenshaKubun(RString hokenshaKubun) {
        this.hokenshaKubun = hokenshaKubun;
    }

    /**
     * getShoriTimestamp
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getKaigoKyufuhiSeikyuKensu
     * @return kaigoKyufuhiSeikyuKensu
     */
    public int getKaigoKyufuhiSeikyuKensu() {
        return kaigoKyufuhiSeikyuKensu;
    }

    /**
     * setKaigoKyufuhiSeikyuKensu
     * @param kaigoKyufuhiSeikyuKensu kaigoKyufuhiSeikyuKensu
     */
    public void setKaigoKyufuhiSeikyuKensu(int kaigoKyufuhiSeikyuKensu) {
        this.kaigoKyufuhiSeikyuKensu = kaigoKyufuhiSeikyuKensu;
    }

    /**
     * getKaigoKyufuhiSeikyuTanisu
     * @return kaigoKyufuhiSeikyuTanisu
     */
    public Decimal getKaigoKyufuhiSeikyuTanisu() {
        return kaigoKyufuhiSeikyuTanisu;
    }

    /**
     * setKaigoKyufuhiSeikyuTanisu
     * @param kaigoKyufuhiSeikyuTanisu kaigoKyufuhiSeikyuTanisu
     */
    public void setKaigoKyufuhiSeikyuTanisu(Decimal kaigoKyufuhiSeikyuTanisu) {
        this.kaigoKyufuhiSeikyuTanisu = kaigoKyufuhiSeikyuTanisu;
    }

    /**
     * getKaigoKyufuhiSeikyuFutangaku
     * @return kaigoKyufuhiSeikyuFutangaku
     */
    public Decimal getKaigoKyufuhiSeikyuFutangaku() {
        return kaigoKyufuhiSeikyuFutangaku;
    }

    /**
     * setKaigoKyufuhiSeikyuFutangaku
     * @param kaigoKyufuhiSeikyuFutangaku kaigoKyufuhiSeikyuFutangaku
     */
    public void setKaigoKyufuhiSeikyuFutangaku(Decimal kaigoKyufuhiSeikyuFutangaku) {
        this.kaigoKyufuhiSeikyuFutangaku = kaigoKyufuhiSeikyuFutangaku;
    }

    /**
     * getKaigoKyufuhiKetteiKensu
     * @return kaigoKyufuhiKetteiKensu
     */
    public int getKaigoKyufuhiKetteiKensu() {
        return kaigoKyufuhiKetteiKensu;
    }

    /**
     * setKaigoKyufuhiKetteiKensu
     * @param kaigoKyufuhiKetteiKensu kaigoKyufuhiKetteiKensu
     */
    public void setKaigoKyufuhiKetteiKensu(int kaigoKyufuhiKetteiKensu) {
        this.kaigoKyufuhiKetteiKensu = kaigoKyufuhiKetteiKensu;
    }

    /**
     * getKaigoKyufuhiKetteiTanisu
     * @return kaigoKyufuhiKetteiTanisu
     */
    public Decimal getKaigoKyufuhiKetteiTanisu() {
        return kaigoKyufuhiKetteiTanisu;
    }

    /**
     * setKaigoKyufuhiKetteiTanisu
     * @param kaigoKyufuhiKetteiTanisu kaigoKyufuhiKetteiTanisu
     */
    public void setKaigoKyufuhiKetteiTanisu(Decimal kaigoKyufuhiKetteiTanisu) {
        this.kaigoKyufuhiKetteiTanisu = kaigoKyufuhiKetteiTanisu;
    }

    /**
     * getKaigoKyufuhiKetteiFutangaku
     * @return kaigoKyufuhiKetteiFutangaku
     */
    public Decimal getKaigoKyufuhiKetteiFutangaku() {
        return kaigoKyufuhiKetteiFutangaku;
    }

    /**
     * setKaigoKyufuhiKetteiFutangaku
     * @param kaigoKyufuhiKetteiFutangaku kaigoKyufuhiKetteiFutangaku
     */
    public void setKaigoKyufuhiKetteiFutangaku(Decimal kaigoKyufuhiKetteiFutangaku) {
        this.kaigoKyufuhiKetteiFutangaku = kaigoKyufuhiKetteiFutangaku;
    }

    /**
     * getKaigoKyufuhiChoseiKensu
     * @return kaigoKyufuhiChoseiKensu
     */
    public int getKaigoKyufuhiChoseiKensu() {
        return kaigoKyufuhiChoseiKensu;
    }

    /**
     * setKaigoKyufuhiChoseiKensu
     * @param kaigoKyufuhiChoseiKensu kaigoKyufuhiChoseiKensu
     */
    public void setKaigoKyufuhiChoseiKensu(int kaigoKyufuhiChoseiKensu) {
        this.kaigoKyufuhiChoseiKensu = kaigoKyufuhiChoseiKensu;
    }

    /**
     * getKaigoKyufuhiChoseiTanisu
     * @return kaigoKyufuhiChoseiTanisu
     */
    public Decimal getKaigoKyufuhiChoseiTanisu() {
        return kaigoKyufuhiChoseiTanisu;
    }

    /**
     * setKaigoKyufuhiChoseiTanisu
     * @param kaigoKyufuhiChoseiTanisu kaigoKyufuhiChoseiTanisu
     */
    public void setKaigoKyufuhiChoseiTanisu(Decimal kaigoKyufuhiChoseiTanisu) {
        this.kaigoKyufuhiChoseiTanisu = kaigoKyufuhiChoseiTanisu;
    }

    /**
     * getKaigoKyufuhiChoseiFutangaku
     * @return kaigoKyufuhiChoseiFutangaku
     */
    public Decimal getKaigoKyufuhiChoseiFutangaku() {
        return kaigoKyufuhiChoseiFutangaku;
    }

    /**
     * setKaigoKyufuhiChoseiFutangaku
     * @param kaigoKyufuhiChoseiFutangaku kaigoKyufuhiChoseiFutangaku
     */
    public void setKaigoKyufuhiChoseiFutangaku(Decimal kaigoKyufuhiChoseiFutangaku) {
        this.kaigoKyufuhiChoseiFutangaku = kaigoKyufuhiChoseiFutangaku;
    }

    /**
     * getKogakuKaigoServicehiSeikyuKensu
     * @return kogakuKaigoServicehiSeikyuKensu
     */
    public int getKogakuKaigoServicehiSeikyuKensu() {
        return kogakuKaigoServicehiSeikyuKensu;
    }

    /**
     * setKogakuKaigoServicehiSeikyuKensu
     * @param kogakuKaigoServicehiSeikyuKensu kogakuKaigoServicehiSeikyuKensu
     */
    public void setKogakuKaigoServicehiSeikyuKensu(int kogakuKaigoServicehiSeikyuKensu) {
        this.kogakuKaigoServicehiSeikyuKensu = kogakuKaigoServicehiSeikyuKensu;
    }

    /**
     * getKogakuKaigoServicehiSeikyuTanisu
     * @return kogakuKaigoServicehiSeikyuTanisu
     */
    public Decimal getKogakuKaigoServicehiSeikyuTanisu() {
        return kogakuKaigoServicehiSeikyuTanisu;
    }

    /**
     * setKogakuKaigoServicehiSeikyuTanisu
     * @param kogakuKaigoServicehiSeikyuTanisu kogakuKaigoServicehiSeikyuTanisu
     */
    public void setKogakuKaigoServicehiSeikyuTanisu(Decimal kogakuKaigoServicehiSeikyuTanisu) {
        this.kogakuKaigoServicehiSeikyuTanisu = kogakuKaigoServicehiSeikyuTanisu;
    }

    /**
     * getKogakuKaigoServicehiSeikyuFutangaku
     * @return kogakuKaigoServicehiSeikyuFutangaku
     */
    public Decimal getKogakuKaigoServicehiSeikyuFutangaku() {
        return kogakuKaigoServicehiSeikyuFutangaku;
    }

    /**
     * setKogakuKaigoServicehiSeikyuFutangaku
     * @param kogakuKaigoServicehiSeikyuFutangaku kogakuKaigoServicehiSeikyuFutangaku
     */
    public void setKogakuKaigoServicehiSeikyuFutangaku(Decimal kogakuKaigoServicehiSeikyuFutangaku) {
        this.kogakuKaigoServicehiSeikyuFutangaku = kogakuKaigoServicehiSeikyuFutangaku;
    }

    /**
     * getKogakuKaigoServicehiKetteiKensu
     * @return kogakuKaigoServicehiKetteiKensu
     */
    public int getKogakuKaigoServicehiKetteiKensu() {
        return kogakuKaigoServicehiKetteiKensu;
    }

    /**
     * setKogakuKaigoServicehiKetteiKensu
     * @param kogakuKaigoServicehiKetteiKensu kogakuKaigoServicehiKetteiKensu
     */
    public void setKogakuKaigoServicehiKetteiKensu(int kogakuKaigoServicehiKetteiKensu) {
        this.kogakuKaigoServicehiKetteiKensu = kogakuKaigoServicehiKetteiKensu;
    }

    /**
     * getKogakuKaigoServicehiKetteiTanisu
     * @return kogakuKaigoServicehiKetteiTanisu
     */
    public Decimal getKogakuKaigoServicehiKetteiTanisu() {
        return kogakuKaigoServicehiKetteiTanisu;
    }

    /**
     * setKogakuKaigoServicehiKetteiTanisu
     * @param kogakuKaigoServicehiKetteiTanisu kogakuKaigoServicehiKetteiTanisu
     */
    public void setKogakuKaigoServicehiKetteiTanisu(Decimal kogakuKaigoServicehiKetteiTanisu) {
        this.kogakuKaigoServicehiKetteiTanisu = kogakuKaigoServicehiKetteiTanisu;
    }

    /**
     * getKogakuKaigoServicehiKetteiFutangaku
     * @return kogakuKaigoServicehiKetteiFutangaku
     */
    public Decimal getKogakuKaigoServicehiKetteiFutangaku() {
        return kogakuKaigoServicehiKetteiFutangaku;
    }

    /**
     * setKogakuKaigoServicehiKetteiFutangaku
     * @param kogakuKaigoServicehiKetteiFutangaku kogakuKaigoServicehiKetteiFutangaku
     */
    public void setKogakuKaigoServicehiKetteiFutangaku(Decimal kogakuKaigoServicehiKetteiFutangaku) {
        this.kogakuKaigoServicehiKetteiFutangaku = kogakuKaigoServicehiKetteiFutangaku;
    }

    /**
     * getKogakuKaigoServicehiChoseiKensu
     * @return kogakuKaigoServicehiChoseiKensu
     */
    public int getKogakuKaigoServicehiChoseiKensu() {
        return kogakuKaigoServicehiChoseiKensu;
    }

    /**
     * setKogakuKaigoServicehiChoseiKensu
     * @param kogakuKaigoServicehiChoseiKensu kogakuKaigoServicehiChoseiKensu
     */
    public void setKogakuKaigoServicehiChoseiKensu(int kogakuKaigoServicehiChoseiKensu) {
        this.kogakuKaigoServicehiChoseiKensu = kogakuKaigoServicehiChoseiKensu;
    }

    /**
     * getKogakuKaigoServicehiChoseiTanisu
     * @return kogakuKaigoServicehiChoseiTanisu
     */
    public Decimal getKogakuKaigoServicehiChoseiTanisu() {
        return kogakuKaigoServicehiChoseiTanisu;
    }

    /**
     * setKogakuKaigoServicehiChoseiTanisu
     * @param kogakuKaigoServicehiChoseiTanisu kogakuKaigoServicehiChoseiTanisu
     */
    public void setKogakuKaigoServicehiChoseiTanisu(Decimal kogakuKaigoServicehiChoseiTanisu) {
        this.kogakuKaigoServicehiChoseiTanisu = kogakuKaigoServicehiChoseiTanisu;
    }

    /**
     * getKogakuKaigoServicehiChoseiFutangaku
     * @return kogakuKaigoServicehiChoseiFutangaku
     */
    public Decimal getKogakuKaigoServicehiChoseiFutangaku() {
        return kogakuKaigoServicehiChoseiFutangaku;
    }

    /**
     * setKogakuKaigoServicehiChoseiFutangaku
     * @param kogakuKaigoServicehiChoseiFutangaku kogakuKaigoServicehiChoseiFutangaku
     */
    public void setKogakuKaigoServicehiChoseiFutangaku(Decimal kogakuKaigoServicehiChoseiFutangaku) {
        this.kogakuKaigoServicehiChoseiFutangaku = kogakuKaigoServicehiChoseiFutangaku;
    }

    /**
     * getKohiFutanshaNo
     * @return kohiFutanshaNo
     */
    public RString getKohiFutanshaNo() {
        return kohiFutanshaNo;
    }

    /**
     * setKohiFutanshaNo
     * @param kohiFutanshaNo kohiFutanshaNo
     */
    public void setKohiFutanshaNo(RString kohiFutanshaNo) {
        this.kohiFutanshaNo = kohiFutanshaNo;
    }

    /**
     * getSakuseiYMD
     * @return sakuseiYMD
     */
    public FlexibleDate getSakuseiYMD() {
        return sakuseiYMD;
    }

    /**
     * setSakuseiYMD
     * @param sakuseiYMD sakuseiYMD
     */
    public void setSakuseiYMD(FlexibleDate sakuseiYMD) {
        this.sakuseiYMD = sakuseiYMD;
    }

    /**
     * getSinsaiinkaiName
     * @return sinsaiinkaiName
     */
    public RString getSinsaiinkaiName() {
        return sinsaiinkaiName;
    }

    /**
     * setSinsaiinkaiName
     * @param sinsaiinkaiName sinsaiinkaiName
     */
    public void setSinsaiinkaiName(RString sinsaiinkaiName) {
        this.sinsaiinkaiName = sinsaiinkaiName;
    }

    /**
     * getTorikomiYM
     * @return torikomiYM
     */
    public FlexibleYearMonth getTorikomiYM() {
        return torikomiYM;
    }

    /**
     * setTorikomiYM
     * @param torikomiYM torikomiYM
     */
    public void setTorikomiYM(FlexibleYearMonth torikomiYM) {
        this.torikomiYM = torikomiYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3063SaishinsaKetteiShukeiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3063SaishinsaKetteiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3063SaishinsaKetteiShukeiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.toriatsukaiYM, other.toriatsukaiYM)) {
            return false;
        }
        if (!Objects.equals(this.hokenshaKubun, other.hokenshaKubun)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3063SaishinsaKetteiShukeiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kaigoKyufuhiSeikyuKensu = entity.kaigoKyufuhiSeikyuKensu;
        this.kaigoKyufuhiSeikyuTanisu = entity.kaigoKyufuhiSeikyuTanisu;
        this.kaigoKyufuhiSeikyuFutangaku = entity.kaigoKyufuhiSeikyuFutangaku;
        this.kaigoKyufuhiKetteiKensu = entity.kaigoKyufuhiKetteiKensu;
        this.kaigoKyufuhiKetteiTanisu = entity.kaigoKyufuhiKetteiTanisu;
        this.kaigoKyufuhiKetteiFutangaku = entity.kaigoKyufuhiKetteiFutangaku;
        this.kaigoKyufuhiChoseiKensu = entity.kaigoKyufuhiChoseiKensu;
        this.kaigoKyufuhiChoseiTanisu = entity.kaigoKyufuhiChoseiTanisu;
        this.kaigoKyufuhiChoseiFutangaku = entity.kaigoKyufuhiChoseiFutangaku;
        this.kogakuKaigoServicehiSeikyuKensu = entity.kogakuKaigoServicehiSeikyuKensu;
        this.kogakuKaigoServicehiSeikyuTanisu = entity.kogakuKaigoServicehiSeikyuTanisu;
        this.kogakuKaigoServicehiSeikyuFutangaku = entity.kogakuKaigoServicehiSeikyuFutangaku;
        this.kogakuKaigoServicehiKetteiKensu = entity.kogakuKaigoServicehiKetteiKensu;
        this.kogakuKaigoServicehiKetteiTanisu = entity.kogakuKaigoServicehiKetteiTanisu;
        this.kogakuKaigoServicehiKetteiFutangaku = entity.kogakuKaigoServicehiKetteiFutangaku;
        this.kogakuKaigoServicehiChoseiKensu = entity.kogakuKaigoServicehiChoseiKensu;
        this.kogakuKaigoServicehiChoseiTanisu = entity.kogakuKaigoServicehiChoseiTanisu;
        this.kogakuKaigoServicehiChoseiFutangaku = entity.kogakuKaigoServicehiChoseiFutangaku;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.sinsaiinkaiName = entity.sinsaiinkaiName;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, shoriTimestamp, kaigoKyufuhiSeikyuKensu, kaigoKyufuhiSeikyuTanisu, kaigoKyufuhiSeikyuFutangaku, kaigoKyufuhiKetteiKensu, kaigoKyufuhiKetteiTanisu, kaigoKyufuhiKetteiFutangaku, kaigoKyufuhiChoseiKensu, kaigoKyufuhiChoseiTanisu, kaigoKyufuhiChoseiFutangaku, kogakuKaigoServicehiSeikyuKensu, kogakuKaigoServicehiSeikyuTanisu, kogakuKaigoServicehiSeikyuFutangaku, kogakuKaigoServicehiKetteiKensu, kogakuKaigoServicehiKetteiTanisu, kogakuKaigoServicehiKetteiFutangaku, kogakuKaigoServicehiChoseiKensu, kogakuKaigoServicehiChoseiTanisu, kogakuKaigoServicehiChoseiFutangaku, kohiFutanshaNo, sakuseiYMD, sinsaiinkaiName, torikomiYM);
    }

// </editor-fold>

}
