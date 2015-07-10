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
 * DbT1006KyokaisoGaitoshaの項目定義クラスです
 *
 */
public class DbT1006KyokaisoGaitoshaEntity extends DbTableEntityBase<DbT1006KyokaisoGaitoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1006KyokaisoGaitosha");

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
    private FlexibleDate kyokaisoSochiKetteiYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString kyuufugakuGengakuKisaiKiajoFlag;
    private RString hyojunFutanGengakuGaitoFlag;
    private Decimal hyojunFutanKeigengoFutangaku;
    private RString kyojuhinadoFutangakugengakuGaitoFlag;
    private RString kyojuhiKeigengoKyoshitsuShuruiCode;
    private Decimal kyojuhiKeigengoHutangaku;
    private RString shokuhiKeigengoHutangakuGaitoFlag;
    private Decimal shokuhiKeigengoHutangaku;
    private RString kogakuServicehiJogengakuGengakuGaitoFlag;
    private Decimal kogakuServicehiJogengakuGengakugoJogengaku;
    private RString hokenryoNofuGengakuFlag;

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
     * getKyokaisoSochiKetteiYMD
     *
     * @return kyokaisoSochiKetteiYMD
     */
    public FlexibleDate getKyokaisoSochiKetteiYMD() {
        return kyokaisoSochiKetteiYMD;
    }

    /**
     * setKyokaisoSochiKetteiYMD
     *
     * @param kyokaisoSochiKetteiYMD kyokaisoSochiKetteiYMD
     */
    public void setKyokaisoSochiKetteiYMD(FlexibleDate kyokaisoSochiKetteiYMD) {
        this.kyokaisoSochiKetteiYMD = kyokaisoSochiKetteiYMD;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTekiyoKaishiYMD
     *
     * @return tekiyoKaishiYMD
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * setTekiyoKaishiYMD
     *
     * @param tekiyoKaishiYMD tekiyoKaishiYMD
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * getTekiyoShuryoYMD
     *
     * @return tekiyoShuryoYMD
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * setTekiyoShuryoYMD
     *
     * @param tekiyoShuryoYMD tekiyoShuryoYMD
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * getKyuufugakuGengakuKisaiKiajoFlag
     *
     * @return kyuufugakuGengakuKisaiKiajoFlag
     */
    public RString getKyuufugakuGengakuKisaiKiajoFlag() {
        return kyuufugakuGengakuKisaiKiajoFlag;
    }

    /**
     * setKyuufugakuGengakuKisaiKiajoFlag
     *
     * @param kyuufugakuGengakuKisaiKiajoFlag kyuufugakuGengakuKisaiKiajoFlag
     */
    public void setKyuufugakuGengakuKisaiKiajoFlag(RString kyuufugakuGengakuKisaiKiajoFlag) {
        this.kyuufugakuGengakuKisaiKiajoFlag = kyuufugakuGengakuKisaiKiajoFlag;
    }

    /**
     * getHyojunFutanGengakuGaitoFlag
     *
     * @return hyojunFutanGengakuGaitoFlag
     */
    public RString getHyojunFutanGengakuGaitoFlag() {
        return hyojunFutanGengakuGaitoFlag;
    }

    /**
     * setHyojunFutanGengakuGaitoFlag
     *
     * @param hyojunFutanGengakuGaitoFlag hyojunFutanGengakuGaitoFlag
     */
    public void setHyojunFutanGengakuGaitoFlag(RString hyojunFutanGengakuGaitoFlag) {
        this.hyojunFutanGengakuGaitoFlag = hyojunFutanGengakuGaitoFlag;
    }

    /**
     * getHyojunFutanKeigengoFutangaku
     *
     * @return hyojunFutanKeigengoFutangaku
     */
    public Decimal getHyojunFutanKeigengoFutangaku() {
        return hyojunFutanKeigengoFutangaku;
    }

    /**
     * setHyojunFutanKeigengoFutangaku
     *
     * @param hyojunFutanKeigengoFutangaku hyojunFutanKeigengoFutangaku
     */
    public void setHyojunFutanKeigengoFutangaku(Decimal hyojunFutanKeigengoFutangaku) {
        this.hyojunFutanKeigengoFutangaku = hyojunFutanKeigengoFutangaku;
    }

    /**
     * getKyojuhinadoFutangakugengakuGaitoFlag
     *
     * @return kyojuhinadoFutangakugengakuGaitoFlag
     */
    public RString getKyojuhinadoFutangakugengakuGaitoFlag() {
        return kyojuhinadoFutangakugengakuGaitoFlag;
    }

    /**
     * setKyojuhinadoFutangakugengakuGaitoFlag
     *
     * @param kyojuhinadoFutangakugengakuGaitoFlag kyojuhinadoFutangakugengakuGaitoFlag
     */
    public void setKyojuhinadoFutangakugengakuGaitoFlag(RString kyojuhinadoFutangakugengakuGaitoFlag) {
        this.kyojuhinadoFutangakugengakuGaitoFlag = kyojuhinadoFutangakugengakuGaitoFlag;
    }

    /**
     * getKyojuhiKeigengoKyoshitsuShuruiCode
     *
     * @return kyojuhiKeigengoKyoshitsuShuruiCode
     */
    public RString getKyojuhiKeigengoKyoshitsuShuruiCode() {
        return kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    /**
     * setKyojuhiKeigengoKyoshitsuShuruiCode
     *
     * @param kyojuhiKeigengoKyoshitsuShuruiCode kyojuhiKeigengoKyoshitsuShuruiCode
     */
    public void setKyojuhiKeigengoKyoshitsuShuruiCode(RString kyojuhiKeigengoKyoshitsuShuruiCode) {
        this.kyojuhiKeigengoKyoshitsuShuruiCode = kyojuhiKeigengoKyoshitsuShuruiCode;
    }

    /**
     * getKyojuhiKeigengoHutangaku
     *
     * @return kyojuhiKeigengoHutangaku
     */
    public Decimal getKyojuhiKeigengoHutangaku() {
        return kyojuhiKeigengoHutangaku;
    }

    /**
     * setKyojuhiKeigengoHutangaku
     *
     * @param kyojuhiKeigengoHutangaku kyojuhiKeigengoHutangaku
     */
    public void setKyojuhiKeigengoHutangaku(Decimal kyojuhiKeigengoHutangaku) {
        this.kyojuhiKeigengoHutangaku = kyojuhiKeigengoHutangaku;
    }

    /**
     * getShokuhiKeigengoHutangakuGaitoFlag
     *
     * @return shokuhiKeigengoHutangakuGaitoFlag
     */
    public RString getShokuhiKeigengoHutangakuGaitoFlag() {
        return shokuhiKeigengoHutangakuGaitoFlag;
    }

    /**
     * setShokuhiKeigengoHutangakuGaitoFlag
     *
     * @param shokuhiKeigengoHutangakuGaitoFlag shokuhiKeigengoHutangakuGaitoFlag
     */
    public void setShokuhiKeigengoHutangakuGaitoFlag(RString shokuhiKeigengoHutangakuGaitoFlag) {
        this.shokuhiKeigengoHutangakuGaitoFlag = shokuhiKeigengoHutangakuGaitoFlag;
    }

    /**
     * getShokuhiKeigengoHutangaku
     *
     * @return shokuhiKeigengoHutangaku
     */
    public Decimal getShokuhiKeigengoHutangaku() {
        return shokuhiKeigengoHutangaku;
    }

    /**
     * setShokuhiKeigengoHutangaku
     *
     * @param shokuhiKeigengoHutangaku shokuhiKeigengoHutangaku
     */
    public void setShokuhiKeigengoHutangaku(Decimal shokuhiKeigengoHutangaku) {
        this.shokuhiKeigengoHutangaku = shokuhiKeigengoHutangaku;
    }

    /**
     * getKogakuServicehiJogengakuGengakuGaitoFlag
     *
     * @return kogakuServicehiJogengakuGengakuGaitoFlag
     */
    public RString getKogakuServicehiJogengakuGengakuGaitoFlag() {
        return kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    /**
     * setKogakuServicehiJogengakuGengakuGaitoFlag
     *
     * @param kogakuServicehiJogengakuGengakuGaitoFlag kogakuServicehiJogengakuGengakuGaitoFlag
     */
    public void setKogakuServicehiJogengakuGengakuGaitoFlag(RString kogakuServicehiJogengakuGengakuGaitoFlag) {
        this.kogakuServicehiJogengakuGengakuGaitoFlag = kogakuServicehiJogengakuGengakuGaitoFlag;
    }

    /**
     * getKogakuServicehiJogengakuGengakugoJogengaku
     *
     * @return kogakuServicehiJogengakuGengakugoJogengaku
     */
    public Decimal getKogakuServicehiJogengakuGengakugoJogengaku() {
        return kogakuServicehiJogengakuGengakugoJogengaku;
    }

    /**
     * setKogakuServicehiJogengakuGengakugoJogengaku
     *
     * @param kogakuServicehiJogengakuGengakugoJogengaku kogakuServicehiJogengakuGengakugoJogengaku
     */
    public void setKogakuServicehiJogengakuGengakugoJogengaku(Decimal kogakuServicehiJogengakuGengakugoJogengaku) {
        this.kogakuServicehiJogengakuGengakugoJogengaku = kogakuServicehiJogengakuGengakugoJogengaku;
    }

    /**
     * getHokenryoNofuGengakuFlag
     *
     * @return hokenryoNofuGengakuFlag
     */
    public RString getHokenryoNofuGengakuFlag() {
        return hokenryoNofuGengakuFlag;
    }

    /**
     * setHokenryoNofuGengakuFlag
     *
     * @param hokenryoNofuGengakuFlag hokenryoNofuGengakuFlag
     */
    public void setHokenryoNofuGengakuFlag(RString hokenryoNofuGengakuFlag) {
        this.hokenryoNofuGengakuFlag = hokenryoNofuGengakuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1006KyokaisoGaitoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT1006KyokaisoGaitoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1006KyokaisoGaitoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kyokaisoSochiKetteiYMD, other.kyokaisoSochiKetteiYMD)) {
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
    public void shallowCopy(DbT1006KyokaisoGaitoshaEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kyokaisoSochiKetteiYMD = entity.kyokaisoSochiKetteiYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.kyuufugakuGengakuKisaiKiajoFlag = entity.kyuufugakuGengakuKisaiKiajoFlag;
        this.hyojunFutanGengakuGaitoFlag = entity.hyojunFutanGengakuGaitoFlag;
        this.hyojunFutanKeigengoFutangaku = entity.hyojunFutanKeigengoFutangaku;
        this.kyojuhinadoFutangakugengakuGaitoFlag = entity.kyojuhinadoFutangakugengakuGaitoFlag;
        this.kyojuhiKeigengoKyoshitsuShuruiCode = entity.kyojuhiKeigengoKyoshitsuShuruiCode;
        this.kyojuhiKeigengoHutangaku = entity.kyojuhiKeigengoHutangaku;
        this.shokuhiKeigengoHutangakuGaitoFlag = entity.shokuhiKeigengoHutangakuGaitoFlag;
        this.shokuhiKeigengoHutangaku = entity.shokuhiKeigengoHutangaku;
        this.kogakuServicehiJogengakuGengakuGaitoFlag = entity.kogakuServicehiJogengakuGengakuGaitoFlag;
        this.kogakuServicehiJogengakuGengakugoJogengaku = entity.kogakuServicehiJogengakuGengakugoJogengaku;
        this.hokenryoNofuGengakuFlag = entity.hokenryoNofuGengakuFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kyokaisoSochiKetteiYMD, shoriTimestamp, tekiyoKaishiYMD, tekiyoShuryoYMD, kyuufugakuGengakuKisaiKiajoFlag, hyojunFutanGengakuGaitoFlag, hyojunFutanKeigengoFutangaku, kyojuhinadoFutangakugengakuGaitoFlag, kyojuhiKeigengoKyoshitsuShuruiCode, kyojuhiKeigengoHutangaku, shokuhiKeigengoHutangakuGaitoFlag, shokuhiKeigengoHutangaku, kogakuServicehiJogengakuGengakuGaitoFlag, kogakuServicehiJogengakuGengakugoJogengaku, hokenryoNofuGengakuFlag);
    }

// </editor-fold>
}
