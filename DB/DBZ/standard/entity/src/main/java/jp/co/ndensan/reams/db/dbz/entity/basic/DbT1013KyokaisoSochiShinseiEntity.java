package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT1013KyokaisoSochiShinseiの項目定義クラスです
 *
 */
public class DbT1013KyokaisoSochiShinseiEntity extends DbTableEntityBase<DbT1013KyokaisoSochiShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1013KyokaisoSochiShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate shinseiYMD;
    @PrimaryKey
    private YMDHMS shoriTimeStamp;
    private FlexibleDate uketsukeYMD;
    private RString shinsei_HaishiKubun;
    private FlexibleDate shinsei_HaishiYMD;
    private Decimal hogoHuyoKonkyoGengakuKingaku;
    private FlexibleDate kyokaisoShomeishoKofuYMD;
    private Decimal kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    private Decimal kyojuhiKeigen_GengakuJikofutanGetsugaku;
    private RString kyojuhiKeigen_FutangendogakuDankaiCode;
    private Decimal shokuhiKeigen_GengakuJikofutanGetsugaku;
    private RString shokuhiKeigen_FutangendogakuDankaiCode;
    private Decimal riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    private Decimal hokenryoGengaku_GengakuJikofutanGetsugaku;
    private Decimal gengakuJikofutanGetsugakuGokeigaku;
    private FlexibleDate kyukaisoSochiKetteiYMD;
    private RString sochiGaito_HigaitoKubun;

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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getShinseiYMD
     *
     * @return shinseiYMD
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * setShinseiYMD
     *
     * @param shinseiYMD shinseiYMD
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * getShoriTimeStamp
     *
     * @return shoriTimeStamp
     */
    public YMDHMS getShoriTimeStamp() {
        return shoriTimeStamp;
    }

    /**
     * setShoriTimeStamp
     *
     * @param shoriTimeStamp shoriTimeStamp
     */
    public void setShoriTimeStamp(YMDHMS shoriTimeStamp) {
        this.shoriTimeStamp = shoriTimeStamp;
    }

    /**
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * getShinsei_HaishiKubun
     *
     * @return shinsei_HaishiKubun
     */
    public RString getShinsei_HaishiKubun() {
        return shinsei_HaishiKubun;
    }

    /**
     * setShinsei_HaishiKubun
     *
     * @param shinsei_HaishiKubun shinsei_HaishiKubun
     */
    public void setShinsei_HaishiKubun(RString shinsei_HaishiKubun) {
        this.shinsei_HaishiKubun = shinsei_HaishiKubun;
    }

    /**
     * getShinsei_HaishiYMD
     *
     * @return shinsei_HaishiYMD
     */
    public FlexibleDate getShinsei_HaishiYMD() {
        return shinsei_HaishiYMD;
    }

    /**
     * setShinsei_HaishiYMD
     *
     * @param shinsei_HaishiYMD shinsei_HaishiYMD
     */
    public void setShinsei_HaishiYMD(FlexibleDate shinsei_HaishiYMD) {
        this.shinsei_HaishiYMD = shinsei_HaishiYMD;
    }

    /**
     * getHogoHuyoKonkyoGengakuKingaku
     *
     * @return hogoHuyoKonkyoGengakuKingaku
     */
    public Decimal getHogoHuyoKonkyoGengakuKingaku() {
        return hogoHuyoKonkyoGengakuKingaku;
    }

    /**
     * setHogoHuyoKonkyoGengakuKingaku
     *
     * @param hogoHuyoKonkyoGengakuKingaku hogoHuyoKonkyoGengakuKingaku
     */
    public void setHogoHuyoKonkyoGengakuKingaku(Decimal hogoHuyoKonkyoGengakuKingaku) {
        this.hogoHuyoKonkyoGengakuKingaku = hogoHuyoKonkyoGengakuKingaku;
    }

    /**
     * getKyokaisoShomeishoKofuYMD
     *
     * @return kyokaisoShomeishoKofuYMD
     */
    public FlexibleDate getKyokaisoShomeishoKofuYMD() {
        return kyokaisoShomeishoKofuYMD;
    }

    /**
     * setKyokaisoShomeishoKofuYMD
     *
     * @param kyokaisoShomeishoKofuYMD kyokaisoShomeishoKofuYMD
     */
    public void setKyokaisoShomeishoKofuYMD(FlexibleDate kyokaisoShomeishoKofuYMD) {
        this.kyokaisoShomeishoKofuYMD = kyokaisoShomeishoKofuYMD;
    }

    /**
     * getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku
     *
     * @return kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku
     */
    public Decimal getKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku() {
        return kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    }

    /**
     * setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku
     *
     * @param kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku
     */
    public void setKyufuGengakuTorikeshi_GengakuJikofutanGetsugaku(Decimal kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku) {
        this.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku = kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
    }

    /**
     * getKyojuhiKeigen_GengakuJikofutanGetsugaku
     *
     * @return kyojuhiKeigen_GengakuJikofutanGetsugaku
     */
    public Decimal getKyojuhiKeigen_GengakuJikofutanGetsugaku() {
        return kyojuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * setKyojuhiKeigen_GengakuJikofutanGetsugaku
     *
     * @param kyojuhiKeigen_GengakuJikofutanGetsugaku kyojuhiKeigen_GengakuJikofutanGetsugaku
     */
    public void setKyojuhiKeigen_GengakuJikofutanGetsugaku(Decimal kyojuhiKeigen_GengakuJikofutanGetsugaku) {
        this.kyojuhiKeigen_GengakuJikofutanGetsugaku = kyojuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * getKyojuhiKeigen_FutangendogakuDankaiCode
     *
     * @return kyojuhiKeigen_FutangendogakuDankaiCode
     */
    public RString getKyojuhiKeigen_FutangendogakuDankaiCode() {
        return kyojuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * setKyojuhiKeigen_FutangendogakuDankaiCode
     *
     * @param kyojuhiKeigen_FutangendogakuDankaiCode kyojuhiKeigen_FutangendogakuDankaiCode
     */
    public void setKyojuhiKeigen_FutangendogakuDankaiCode(RString kyojuhiKeigen_FutangendogakuDankaiCode) {
        this.kyojuhiKeigen_FutangendogakuDankaiCode = kyojuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * getShokuhiKeigen_GengakuJikofutanGetsugaku
     *
     * @return shokuhiKeigen_GengakuJikofutanGetsugaku
     */
    public Decimal getShokuhiKeigen_GengakuJikofutanGetsugaku() {
        return shokuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * setShokuhiKeigen_GengakuJikofutanGetsugaku
     *
     * @param shokuhiKeigen_GengakuJikofutanGetsugaku shokuhiKeigen_GengakuJikofutanGetsugaku
     */
    public void setShokuhiKeigen_GengakuJikofutanGetsugaku(Decimal shokuhiKeigen_GengakuJikofutanGetsugaku) {
        this.shokuhiKeigen_GengakuJikofutanGetsugaku = shokuhiKeigen_GengakuJikofutanGetsugaku;
    }

    /**
     * getShokuhiKeigen_FutangendogakuDankaiCode
     *
     * @return shokuhiKeigen_FutangendogakuDankaiCode
     */
    public RString getShokuhiKeigen_FutangendogakuDankaiCode() {
        return shokuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * setShokuhiKeigen_FutangendogakuDankaiCode
     *
     * @param shokuhiKeigen_FutangendogakuDankaiCode shokuhiKeigen_FutangendogakuDankaiCode
     */
    public void setShokuhiKeigen_FutangendogakuDankaiCode(RString shokuhiKeigen_FutangendogakuDankaiCode) {
        this.shokuhiKeigen_FutangendogakuDankaiCode = shokuhiKeigen_FutangendogakuDankaiCode;
    }

    /**
     * getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku
     *
     * @return riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku
     */
    public Decimal getRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku() {
        return riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    }

    /**
     * setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku
     *
     * @param riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku
     * riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku
     */
    public void setRiyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku(Decimal riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku) {
        this.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku = riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
    }

    /**
     * getHokenryoGengaku_GengakuJikofutanGetsugaku
     *
     * @return hokenryoGengaku_GengakuJikofutanGetsugaku
     */
    public Decimal getHokenryoGengaku_GengakuJikofutanGetsugaku() {
        return hokenryoGengaku_GengakuJikofutanGetsugaku;
    }

    /**
     * setHokenryoGengaku_GengakuJikofutanGetsugaku
     *
     * @param hokenryoGengaku_GengakuJikofutanGetsugaku hokenryoGengaku_GengakuJikofutanGetsugaku
     */
    public void setHokenryoGengaku_GengakuJikofutanGetsugaku(Decimal hokenryoGengaku_GengakuJikofutanGetsugaku) {
        this.hokenryoGengaku_GengakuJikofutanGetsugaku = hokenryoGengaku_GengakuJikofutanGetsugaku;
    }

    /**
     * getGengakuJikofutanGetsugakuGokeigaku
     *
     * @return gengakuJikofutanGetsugakuGokeigaku
     */
    public Decimal getGengakuJikofutanGetsugakuGokeigaku() {
        return gengakuJikofutanGetsugakuGokeigaku;
    }

    /**
     * setGengakuJikofutanGetsugakuGokeigaku
     *
     * @param gengakuJikofutanGetsugakuGokeigaku gengakuJikofutanGetsugakuGokeigaku
     */
    public void setGengakuJikofutanGetsugakuGokeigaku(Decimal gengakuJikofutanGetsugakuGokeigaku) {
        this.gengakuJikofutanGetsugakuGokeigaku = gengakuJikofutanGetsugakuGokeigaku;
    }

    /**
     * getKyukaisoSochiKetteiYMD
     *
     * @return kyukaisoSochiKetteiYMD
     */
    public FlexibleDate getKyukaisoSochiKetteiYMD() {
        return kyukaisoSochiKetteiYMD;
    }

    /**
     * setKyukaisoSochiKetteiYMD
     *
     * @param kyukaisoSochiKetteiYMD kyukaisoSochiKetteiYMD
     */
    public void setKyukaisoSochiKetteiYMD(FlexibleDate kyukaisoSochiKetteiYMD) {
        this.kyukaisoSochiKetteiYMD = kyukaisoSochiKetteiYMD;
    }

    /**
     * getSochiGaito_HigaitoKubun
     *
     * @return sochiGaito_HigaitoKubun
     */
    public RString getSochiGaito_HigaitoKubun() {
        return sochiGaito_HigaitoKubun;
    }

    /**
     * setSochiGaito_HigaitoKubun
     *
     * @param sochiGaito_HigaitoKubun sochiGaito_HigaitoKubun
     */
    public void setSochiGaito_HigaitoKubun(RString sochiGaito_HigaitoKubun) {
        this.sochiGaito_HigaitoKubun = sochiGaito_HigaitoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1013KyokaisoSochiShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1013KyokaisoSochiShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1013KyokaisoSochiShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseiYMD, other.shinseiYMD)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimeStamp, other.shoriTimeStamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1013KyokaisoSochiShinseiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.shoriTimeStamp = entity.shoriTimeStamp;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinsei_HaishiKubun = entity.shinsei_HaishiKubun;
        this.shinsei_HaishiYMD = entity.shinsei_HaishiYMD;
        this.hogoHuyoKonkyoGengakuKingaku = entity.hogoHuyoKonkyoGengakuKingaku;
        this.kyokaisoShomeishoKofuYMD = entity.kyokaisoShomeishoKofuYMD;
        this.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku = entity.kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku;
        this.kyojuhiKeigen_GengakuJikofutanGetsugaku = entity.kyojuhiKeigen_GengakuJikofutanGetsugaku;
        this.kyojuhiKeigen_FutangendogakuDankaiCode = entity.kyojuhiKeigen_FutangendogakuDankaiCode;
        this.shokuhiKeigen_GengakuJikofutanGetsugaku = entity.shokuhiKeigen_GengakuJikofutanGetsugaku;
        this.shokuhiKeigen_FutangendogakuDankaiCode = entity.shokuhiKeigen_FutangendogakuDankaiCode;
        this.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku = entity.riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku;
        this.hokenryoGengaku_GengakuJikofutanGetsugaku = entity.hokenryoGengaku_GengakuJikofutanGetsugaku;
        this.gengakuJikofutanGetsugakuGokeigaku = entity.gengakuJikofutanGetsugakuGokeigaku;
        this.kyukaisoSochiKetteiYMD = entity.kyukaisoSochiKetteiYMD;
        this.sochiGaito_HigaitoKubun = entity.sochiGaito_HigaitoKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, shinseiYMD, shoriTimeStamp, uketsukeYMD, shinsei_HaishiKubun, shinsei_HaishiYMD, hogoHuyoKonkyoGengakuKingaku, kyokaisoShomeishoKofuYMD, kyufuGengakuTorikeshi_GengakuJikofutanGetsugaku, kyojuhiKeigen_GengakuJikofutanGetsugaku, kyojuhiKeigen_FutangendogakuDankaiCode, shokuhiKeigen_GengakuJikofutanGetsugaku, shokuhiKeigen_FutangendogakuDankaiCode, riyoshaFutanSetaiGassanGaku_GengakuJokofutanGetsugaku, hokenryoGengaku_GengakuJikofutanGetsugaku, gengakuJikofutanGetsugakuGokeigaku, kyukaisoSochiKetteiYMD, sochiGaito_HigaitoKubun);
    }

// </editor-fold>
}
