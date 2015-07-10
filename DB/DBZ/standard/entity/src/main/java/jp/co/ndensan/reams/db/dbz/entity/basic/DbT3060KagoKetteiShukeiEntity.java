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
 * DbT3060KagoKetteiShukeiの項目定義クラスです
 *
 */
public class DbT3060KagoKetteiShukeiEntity extends DbTableEntityBase<DbT3060KagoKetteiShukeiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3060KagoKetteiShukei");

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
    private int kaigoKyufuhiKensu;
    private Decimal kaigoKyufuhiTanisu;
    private Decimal kaigoKyufuhiFutangaku;
    private int kogakuServicehiKensu;
    private Decimal kogakuServicehiTanisu;
    private Decimal kogakuServicehiFutangaku;
    private int tokuteiNyushoshaServicehiKensu;
    private Decimal tokuteiNyushoshaServicehiTanisu;
    private Decimal tokuteiNyushoshaServicehiFutangaku;
    private RString kohiFutanshaNo;
    private FlexibleDate sakuseiYMD;
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
     * getKaigoKyufuhiKensu
     * @return kaigoKyufuhiKensu
     */
    public int getKaigoKyufuhiKensu() {
        return kaigoKyufuhiKensu;
    }

    /**
     * setKaigoKyufuhiKensu
     * @param kaigoKyufuhiKensu kaigoKyufuhiKensu
     */
    public void setKaigoKyufuhiKensu(int kaigoKyufuhiKensu) {
        this.kaigoKyufuhiKensu = kaigoKyufuhiKensu;
    }

    /**
     * getKaigoKyufuhiTanisu
     * @return kaigoKyufuhiTanisu
     */
    public Decimal getKaigoKyufuhiTanisu() {
        return kaigoKyufuhiTanisu;
    }

    /**
     * setKaigoKyufuhiTanisu
     * @param kaigoKyufuhiTanisu kaigoKyufuhiTanisu
     */
    public void setKaigoKyufuhiTanisu(Decimal kaigoKyufuhiTanisu) {
        this.kaigoKyufuhiTanisu = kaigoKyufuhiTanisu;
    }

    /**
     * getKaigoKyufuhiFutangaku
     * @return kaigoKyufuhiFutangaku
     */
    public Decimal getKaigoKyufuhiFutangaku() {
        return kaigoKyufuhiFutangaku;
    }

    /**
     * setKaigoKyufuhiFutangaku
     * @param kaigoKyufuhiFutangaku kaigoKyufuhiFutangaku
     */
    public void setKaigoKyufuhiFutangaku(Decimal kaigoKyufuhiFutangaku) {
        this.kaigoKyufuhiFutangaku = kaigoKyufuhiFutangaku;
    }

    /**
     * getKogakuServicehiKensu
     * @return kogakuServicehiKensu
     */
    public int getKogakuServicehiKensu() {
        return kogakuServicehiKensu;
    }

    /**
     * setKogakuServicehiKensu
     * @param kogakuServicehiKensu kogakuServicehiKensu
     */
    public void setKogakuServicehiKensu(int kogakuServicehiKensu) {
        this.kogakuServicehiKensu = kogakuServicehiKensu;
    }

    /**
     * getKogakuServicehiTanisu
     * @return kogakuServicehiTanisu
     */
    public Decimal getKogakuServicehiTanisu() {
        return kogakuServicehiTanisu;
    }

    /**
     * setKogakuServicehiTanisu
     * @param kogakuServicehiTanisu kogakuServicehiTanisu
     */
    public void setKogakuServicehiTanisu(Decimal kogakuServicehiTanisu) {
        this.kogakuServicehiTanisu = kogakuServicehiTanisu;
    }

    /**
     * getKogakuServicehiFutangaku
     * @return kogakuServicehiFutangaku
     */
    public Decimal getKogakuServicehiFutangaku() {
        return kogakuServicehiFutangaku;
    }

    /**
     * setKogakuServicehiFutangaku
     * @param kogakuServicehiFutangaku kogakuServicehiFutangaku
     */
    public void setKogakuServicehiFutangaku(Decimal kogakuServicehiFutangaku) {
        this.kogakuServicehiFutangaku = kogakuServicehiFutangaku;
    }

    /**
     * getTokuteiNyushoshaServicehiKensu
     * @return tokuteiNyushoshaServicehiKensu
     */
    public int getTokuteiNyushoshaServicehiKensu() {
        return tokuteiNyushoshaServicehiKensu;
    }

    /**
     * setTokuteiNyushoshaServicehiKensu
     * @param tokuteiNyushoshaServicehiKensu tokuteiNyushoshaServicehiKensu
     */
    public void setTokuteiNyushoshaServicehiKensu(int tokuteiNyushoshaServicehiKensu) {
        this.tokuteiNyushoshaServicehiKensu = tokuteiNyushoshaServicehiKensu;
    }

    /**
     * getTokuteiNyushoshaServicehiTanisu
     * @return tokuteiNyushoshaServicehiTanisu
     */
    public Decimal getTokuteiNyushoshaServicehiTanisu() {
        return tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * setTokuteiNyushoshaServicehiTanisu
     * @param tokuteiNyushoshaServicehiTanisu tokuteiNyushoshaServicehiTanisu
     */
    public void setTokuteiNyushoshaServicehiTanisu(Decimal tokuteiNyushoshaServicehiTanisu) {
        this.tokuteiNyushoshaServicehiTanisu = tokuteiNyushoshaServicehiTanisu;
    }

    /**
     * getTokuteiNyushoshaServicehiFutangaku
     * @return tokuteiNyushoshaServicehiFutangaku
     */
    public Decimal getTokuteiNyushoshaServicehiFutangaku() {
        return tokuteiNyushoshaServicehiFutangaku;
    }

    /**
     * setTokuteiNyushoshaServicehiFutangaku
     * @param tokuteiNyushoshaServicehiFutangaku tokuteiNyushoshaServicehiFutangaku
     */
    public void setTokuteiNyushoshaServicehiFutangaku(Decimal tokuteiNyushoshaServicehiFutangaku) {
        this.tokuteiNyushoshaServicehiFutangaku = tokuteiNyushoshaServicehiFutangaku;
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
     * このエンティティの主キーが他の{@literal DbT3060KagoKetteiShukeiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3060KagoKetteiShukeiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3060KagoKetteiShukeiEntity other) {
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
    public void shallowCopy(DbT3060KagoKetteiShukeiEntity entity) {
        this.toriatsukaiYM = entity.toriatsukaiYM;
        this.hokenshaKubun = entity.hokenshaKubun;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kaigoKyufuhiKensu = entity.kaigoKyufuhiKensu;
        this.kaigoKyufuhiTanisu = entity.kaigoKyufuhiTanisu;
        this.kaigoKyufuhiFutangaku = entity.kaigoKyufuhiFutangaku;
        this.kogakuServicehiKensu = entity.kogakuServicehiKensu;
        this.kogakuServicehiTanisu = entity.kogakuServicehiTanisu;
        this.kogakuServicehiFutangaku = entity.kogakuServicehiFutangaku;
        this.tokuteiNyushoshaServicehiKensu = entity.tokuteiNyushoshaServicehiKensu;
        this.tokuteiNyushoshaServicehiTanisu = entity.tokuteiNyushoshaServicehiTanisu;
        this.tokuteiNyushoshaServicehiFutangaku = entity.tokuteiNyushoshaServicehiFutangaku;
        this.kohiFutanshaNo = entity.kohiFutanshaNo;
        this.sakuseiYMD = entity.sakuseiYMD;
        this.torikomiYM = entity.torikomiYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(toriatsukaiYM, hokenshaKubun, shoriTimestamp, kaigoKyufuhiKensu, kaigoKyufuhiTanisu, kaigoKyufuhiFutangaku, kogakuServicehiKensu, kogakuServicehiTanisu, kogakuServicehiFutangaku, tokuteiNyushoshaServicehiKensu, tokuteiNyushoshaServicehiTanisu, tokuteiNyushoshaServicehiFutangaku, kohiFutanshaNo, sakuseiYMD, torikomiYM);
    }

// </editor-fold>

}
