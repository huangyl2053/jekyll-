package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 介護第三者行為損害賠償金受領テーブルのエンティティクラスです。
 */
public class DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity extends DbTableEntityBase<DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private int rirekiNo;
    private FlexibleDate nyukinKakuninYMD;
    private FlexibleDate ryoshuYMD;
    private Decimal ryoshuKingaku;
    private RString mabusokuKinUMU;
    private Decimal kabusokuGaku;

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
     * 第三者行為求償請求番号のgetメソッドです。
     *
     * @return 第三者行為求償請求番号
     */
    public RString getKyushoSeikyuNo() {
        return kyushoSeikyuNo;
    }

    /**
     * 第三者行為求償請求番号のsetメソッドです。
     *
     * @param kyushoSeikyuNo 第三者行為求償請求番号
     */
    public void setKyushoSeikyuNo(RString kyushoSeikyuNo) {
        this.kyushoSeikyuNo = kyushoSeikyuNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 入金確認年月日のgetメソッドです。
     *
     * @return 入金確認年月日
     */
    public FlexibleDate getNyukinKakuninYMD() {
        return nyukinKakuninYMD;
    }

    /**
     * 入金確認年月日のsetメソッドです。
     *
     * @param nyukinKakuninYMD 入金確認年月日
     */
    public void setNyukinKakuninYMD(FlexibleDate nyukinKakuninYMD) {
        this.nyukinKakuninYMD = nyukinKakuninYMD;
    }

    /**
     * 領収年月日のgetメソッドです。
     *
     * @return 領収年月日
     */
    public FlexibleDate getRyoshuYMD() {
        return ryoshuYMD;
    }

    /**
     * 領収年月日のsetメソッドです。
     *
     * @param ryoshuYMD 領収年月日
     */
    public void setRyoshuYMD(FlexibleDate ryoshuYMD) {
        this.ryoshuYMD = ryoshuYMD;
    }

    /**
     * 領収金額のgetメソッドです。
     *
     * @return 領収金額
     */
    public Decimal getRyoshuKingaku() {
        return ryoshuKingaku;
    }

    /**
     * 領収金額のsetメソッドです。
     *
     * @param ryoshuKingaku 領収金額
     */
    public void setRyoshuKingaku(Decimal ryoshuKingaku) {
        this.ryoshuKingaku = ryoshuKingaku;
    }

    /**
     * 過不足金有無のgetメソッドです。
     *
     * @return 過不足金有無
     */
    public RString getMabusokuKinUMU() {
        return mabusokuKinUMU;
    }

    /**
     * 過不足金有無のsetメソッドです。
     *
     * @param mabusokuKinUMU 過不足金有無
     */
    public void setMabusokuKinUMU(RString mabusokuKinUMU) {
        this.mabusokuKinUMU = mabusokuKinUMU;
    }

    /**
     * 過不足額のgetメソッドです。
     *
     * @return 過不足額
     */
    public Decimal getKabusokuGaku() {
        return kabusokuGaku;
    }

    /**
     * 過不足額のsetメソッドです。
     *
     * @param kabusokuGaku 過不足額
     */
    public void setKabusokuGaku(Decimal kabusokuGaku) {
        this.kabusokuGaku = kabusokuGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3079DaisanshaKoiSongaiBaishoKinJuryoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, todokedeKanriNo, kyushoSeikyuNo, rirekiNo, nyukinKakuninYMD, ryoshuYMD, ryoshuKingaku, mabusokuKinUMU, kabusokuGaku);
    }

// </editor-fold>
}
