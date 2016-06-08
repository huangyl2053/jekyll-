package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 介護第三者行為給付額減額テーブルのエンティティクラスです。
 */
public class DbT3081DaisanshaKoiKyufugakuGengakuEntity extends DbTableEntityBase<DbT3081DaisanshaKoiKyufugakuGengakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
    private Decimal gengakuTaishoKingaku;
    private FlexibleDate gengakuKaishiYMD;
    private FlexibleDate gengakuShuryoYMD;

    /**
     * insertDantaiCdのgetメソッドです。
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * insertDantaiCdのsetメソッドです。
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * isDeletedのgetメソッドです。
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * isDeletedのsetメソッドです。
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 第三者行為届出管理番号のgetメソッドです。
     *
     * @return 第三者行為届出管理番号
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * 第三者行為届出管理番号のsetメソッドです。
     *
     * @param todokedeKanriNo 第三者行為届出管理番号
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 減額対象金額のgetメソッドです。
     *
     * @return 減額対象金額
     */
    public Decimal getGengakuTaishoKingaku() {
        return gengakuTaishoKingaku;
    }

    /**
     * 減額対象金額のsetメソッドです。
     *
     * @param gengakuTaishoKingaku 減額対象金額
     */
    public void setGengakuTaishoKingaku(Decimal gengakuTaishoKingaku) {
        this.gengakuTaishoKingaku = gengakuTaishoKingaku;
    }

    /**
     * 給付額減額期間開始年月日のgetメソッドです。
     *
     * @return 給付額減額期間開始年月日
     */
    public FlexibleDate getGengakuKaishiYMD() {
        return gengakuKaishiYMD;
    }

    /**
     * 給付額減額期間開始年月日のsetメソッドです。
     *
     * @param gengakuKaishiYMD 給付額減額期間開始年月日
     */
    public void setGengakuKaishiYMD(FlexibleDate gengakuKaishiYMD) {
        this.gengakuKaishiYMD = gengakuKaishiYMD;
    }

    /**
     * 給付額減額期間終了年月日のgetメソッドです。
     *
     * @return 給付額減額期間終了年月日
     */
    public FlexibleDate getGengakuShuryoYMD() {
        return gengakuShuryoYMD;
    }

    /**
     * 給付額減額期間終了年月日のsetメソッドです。
     *
     * @param gengakuShuryoYMD 給付額減額期間終了年月日
     */
    public void setGengakuShuryoYMD(FlexibleDate gengakuShuryoYMD) {
        this.gengakuShuryoYMD = gengakuShuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3081DaisanshaKoiKyufugakuGengakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, todokedeKanriNo, rirekiNo, gengakuTaishoKingaku, gengakuKaishiYMD, gengakuShuryoYMD);
    }

// </editor-fold>
}
