package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
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
 * DbT3079DaisanshaKoiSongaiBaishoKinJuryoの項目定義クラスです
 *
 */
public class DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity extends DbTableEntityBase<DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3079DaisanshaKoiSongaiBaishoKinJuryo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString todokedeKanriNo;
    @PrimaryKey
    private RString kyushoSeikyuNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleDate nyukinKakuninYMD;
    private FlexibleDate ryoshuYMD;
    private Decimal ryoshuKingaku;
    private RString mabusokuKinUMU;
    private Decimal kabusokuGaku;

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
     * getTodokedeKanriNo
     *
     * @return todokedeKanriNo
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * setTodokedeKanriNo
     *
     * @param todokedeKanriNo todokedeKanriNo
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
    }

    /**
     * getKyushoSeikyuNo
     *
     * @return kyushoSeikyuNo
     */
    public RString getKyushoSeikyuNo() {
        return kyushoSeikyuNo;
    }

    /**
     * setKyushoSeikyuNo
     *
     * @param kyushoSeikyuNo kyushoSeikyuNo
     */
    public void setKyushoSeikyuNo(RString kyushoSeikyuNo) {
        this.kyushoSeikyuNo = kyushoSeikyuNo;
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
     * getNyukinKakuninYMD
     *
     * @return nyukinKakuninYMD
     */
    public FlexibleDate getNyukinKakuninYMD() {
        return nyukinKakuninYMD;
    }

    /**
     * setNyukinKakuninYMD
     *
     * @param nyukinKakuninYMD nyukinKakuninYMD
     */
    public void setNyukinKakuninYMD(FlexibleDate nyukinKakuninYMD) {
        this.nyukinKakuninYMD = nyukinKakuninYMD;
    }

    /**
     * getRyoshuYMD
     *
     * @return ryoshuYMD
     */
    public FlexibleDate getRyoshuYMD() {
        return ryoshuYMD;
    }

    /**
     * setRyoshuYMD
     *
     * @param ryoshuYMD ryoshuYMD
     */
    public void setRyoshuYMD(FlexibleDate ryoshuYMD) {
        this.ryoshuYMD = ryoshuYMD;
    }

    /**
     * getRyoshuKingaku
     *
     * @return ryoshuKingaku
     */
    public Decimal getRyoshuKingaku() {
        return ryoshuKingaku;
    }

    /**
     * setRyoshuKingaku
     *
     * @param ryoshuKingaku ryoshuKingaku
     */
    public void setRyoshuKingaku(Decimal ryoshuKingaku) {
        this.ryoshuKingaku = ryoshuKingaku;
    }

    /**
     * getMabusokuKinUMU
     *
     * @return mabusokuKinUMU
     */
    public RString getMabusokuKinUMU() {
        return mabusokuKinUMU;
    }

    /**
     * setMabusokuKinUMU
     *
     * @param mabusokuKinUMU mabusokuKinUMU
     */
    public void setMabusokuKinUMU(RString mabusokuKinUMU) {
        this.mabusokuKinUMU = mabusokuKinUMU;
    }

    /**
     * getKabusokuGaku
     *
     * @return kabusokuGaku
     */
    public Decimal getKabusokuGaku() {
        return kabusokuGaku;
    }

    /**
     * setKabusokuGaku
     *
     * @param kabusokuGaku kabusokuGaku
     */
    public void setKabusokuGaku(Decimal kabusokuGaku) {
        this.kabusokuGaku = kabusokuGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.kyushoSeikyuNo, other.kyushoSeikyuNo)) {
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
    public void shallowCopy(DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.kyushoSeikyuNo = entity.kyushoSeikyuNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.nyukinKakuninYMD = entity.nyukinKakuninYMD;
        this.ryoshuYMD = entity.ryoshuYMD;
        this.ryoshuKingaku = entity.ryoshuKingaku;
        this.mabusokuKinUMU = entity.mabusokuKinUMU;
        this.kabusokuGaku = entity.kabusokuGaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, kyushoSeikyuNo, shoriTimestamp, nyukinKakuninYMD, ryoshuYMD, ryoshuKingaku, mabusokuKinUMU, kabusokuGaku);
    }

// </editor-fold>
}
