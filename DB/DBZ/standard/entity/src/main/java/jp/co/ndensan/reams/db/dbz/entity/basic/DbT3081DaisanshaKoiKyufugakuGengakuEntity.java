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
 * DbT3081DaisanshaKoiKyufugakuGengakuの項目定義クラスです
 *
 */
public class DbT3081DaisanshaKoiKyufugakuGengakuEntity extends DbTableEntityBase<DbT3081DaisanshaKoiKyufugakuGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3081DaisanshaKoiKyufugakuGengaku");

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
    private YMDHMS shoriTimestamp;
    private Decimal gengakuTaishoKingaku;
    private FlexibleDate gengakuKaishiYMD;
    private FlexibleDate gengakuShuryoYMD;

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
     * getGengakuTaishoKingaku
     *
     * @return gengakuTaishoKingaku
     */
    public Decimal getGengakuTaishoKingaku() {
        return gengakuTaishoKingaku;
    }

    /**
     * setGengakuTaishoKingaku
     *
     * @param gengakuTaishoKingaku gengakuTaishoKingaku
     */
    public void setGengakuTaishoKingaku(Decimal gengakuTaishoKingaku) {
        this.gengakuTaishoKingaku = gengakuTaishoKingaku;
    }

    /**
     * getGengakuKaishiYMD
     *
     * @return gengakuKaishiYMD
     */
    public FlexibleDate getGengakuKaishiYMD() {
        return gengakuKaishiYMD;
    }

    /**
     * setGengakuKaishiYMD
     *
     * @param gengakuKaishiYMD gengakuKaishiYMD
     */
    public void setGengakuKaishiYMD(FlexibleDate gengakuKaishiYMD) {
        this.gengakuKaishiYMD = gengakuKaishiYMD;
    }

    /**
     * getGengakuShuryoYMD
     *
     * @return gengakuShuryoYMD
     */
    public FlexibleDate getGengakuShuryoYMD() {
        return gengakuShuryoYMD;
    }

    /**
     * setGengakuShuryoYMD
     *
     * @param gengakuShuryoYMD gengakuShuryoYMD
     */
    public void setGengakuShuryoYMD(FlexibleDate gengakuShuryoYMD) {
        this.gengakuShuryoYMD = gengakuShuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3081DaisanshaKoiKyufugakuGengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3081DaisanshaKoiKyufugakuGengakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3081DaisanshaKoiKyufugakuGengakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
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
    public void shallowCopy(DbT3081DaisanshaKoiKyufugakuGengakuEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.gengakuTaishoKingaku = entity.gengakuTaishoKingaku;
        this.gengakuKaishiYMD = entity.gengakuKaishiYMD;
        this.gengakuShuryoYMD = entity.gengakuShuryoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, shoriTimestamp, gengakuTaishoKingaku, gengakuKaishiYMD, gengakuShuryoYMD);
    }

// </editor-fold>
}
