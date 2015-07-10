package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3080DaisanshaKoiJidanの項目定義クラスです
 *
 */
public class DbT3080DaisanshaKoiJidanEntity extends DbTableEntityBase<DbT3080DaisanshaKoiJidanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3080DaisanshaKoiJidan");

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
    private FlexibleDate jidanHokokushoUketukeYMD;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString kyushoKyogiKubun;
    private FlexibleDate jidanHokokushoTeishutsuYMD;
    private FlexibleDate jidanSeiritsuYMD;
    private FlexibleYearMonth kyufuKaishiYMD;
    private FlexibleYearMonth kyufuShuryoYMD;
    private RString kashitsuWariai_Kagaisha;
    private RString kashitsuWariai_Higaisha;

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
     * getJidanHokokushoUketukeYMD
     *
     * @return jidanHokokushoUketukeYMD
     */
    public FlexibleDate getJidanHokokushoUketukeYMD() {
        return jidanHokokushoUketukeYMD;
    }

    /**
     * setJidanHokokushoUketukeYMD
     *
     * @param jidanHokokushoUketukeYMD jidanHokokushoUketukeYMD
     */
    public void setJidanHokokushoUketukeYMD(FlexibleDate jidanHokokushoUketukeYMD) {
        this.jidanHokokushoUketukeYMD = jidanHokokushoUketukeYMD;
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
     * getKyushoKyogiKubun
     *
     * @return kyushoKyogiKubun
     */
    public RString getKyushoKyogiKubun() {
        return kyushoKyogiKubun;
    }

    /**
     * setKyushoKyogiKubun
     *
     * @param kyushoKyogiKubun kyushoKyogiKubun
     */
    public void setKyushoKyogiKubun(RString kyushoKyogiKubun) {
        this.kyushoKyogiKubun = kyushoKyogiKubun;
    }

    /**
     * getJidanHokokushoTeishutsuYMD
     *
     * @return jidanHokokushoTeishutsuYMD
     */
    public FlexibleDate getJidanHokokushoTeishutsuYMD() {
        return jidanHokokushoTeishutsuYMD;
    }

    /**
     * setJidanHokokushoTeishutsuYMD
     *
     * @param jidanHokokushoTeishutsuYMD jidanHokokushoTeishutsuYMD
     */
    public void setJidanHokokushoTeishutsuYMD(FlexibleDate jidanHokokushoTeishutsuYMD) {
        this.jidanHokokushoTeishutsuYMD = jidanHokokushoTeishutsuYMD;
    }

    /**
     * getJidanSeiritsuYMD
     *
     * @return jidanSeiritsuYMD
     */
    public FlexibleDate getJidanSeiritsuYMD() {
        return jidanSeiritsuYMD;
    }

    /**
     * setJidanSeiritsuYMD
     *
     * @param jidanSeiritsuYMD jidanSeiritsuYMD
     */
    public void setJidanSeiritsuYMD(FlexibleDate jidanSeiritsuYMD) {
        this.jidanSeiritsuYMD = jidanSeiritsuYMD;
    }

    /**
     * getKyufuKaishiYMD
     *
     * @return kyufuKaishiYMD
     */
    public FlexibleYearMonth getKyufuKaishiYMD() {
        return kyufuKaishiYMD;
    }

    /**
     * setKyufuKaishiYMD
     *
     * @param kyufuKaishiYMD kyufuKaishiYMD
     */
    public void setKyufuKaishiYMD(FlexibleYearMonth kyufuKaishiYMD) {
        this.kyufuKaishiYMD = kyufuKaishiYMD;
    }

    /**
     * getKyufuShuryoYMD
     *
     * @return kyufuShuryoYMD
     */
    public FlexibleYearMonth getKyufuShuryoYMD() {
        return kyufuShuryoYMD;
    }

    /**
     * setKyufuShuryoYMD
     *
     * @param kyufuShuryoYMD kyufuShuryoYMD
     */
    public void setKyufuShuryoYMD(FlexibleYearMonth kyufuShuryoYMD) {
        this.kyufuShuryoYMD = kyufuShuryoYMD;
    }

    /**
     * getKashitsuWariai_Kagaisha
     *
     * @return kashitsuWariai_Kagaisha
     */
    public RString getKashitsuWariai_Kagaisha() {
        return kashitsuWariai_Kagaisha;
    }

    /**
     * setKashitsuWariai_Kagaisha
     *
     * @param kashitsuWariai_Kagaisha kashitsuWariai_Kagaisha
     */
    public void setKashitsuWariai_Kagaisha(RString kashitsuWariai_Kagaisha) {
        this.kashitsuWariai_Kagaisha = kashitsuWariai_Kagaisha;
    }

    /**
     * getKashitsuWariai_Higaisha
     *
     * @return kashitsuWariai_Higaisha
     */
    public RString getKashitsuWariai_Higaisha() {
        return kashitsuWariai_Higaisha;
    }

    /**
     * setKashitsuWariai_Higaisha
     *
     * @param kashitsuWariai_Higaisha kashitsuWariai_Higaisha
     */
    public void setKashitsuWariai_Higaisha(RString kashitsuWariai_Higaisha) {
        this.kashitsuWariai_Higaisha = kashitsuWariai_Higaisha;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3080DaisanshaKoiJidanEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3080DaisanshaKoiJidanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3080DaisanshaKoiJidanEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.jidanHokokushoUketukeYMD, other.jidanHokokushoUketukeYMD)) {
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
    public void shallowCopy(DbT3080DaisanshaKoiJidanEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.jidanHokokushoUketukeYMD = entity.jidanHokokushoUketukeYMD;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kyushoKyogiKubun = entity.kyushoKyogiKubun;
        this.jidanHokokushoTeishutsuYMD = entity.jidanHokokushoTeishutsuYMD;
        this.jidanSeiritsuYMD = entity.jidanSeiritsuYMD;
        this.kyufuKaishiYMD = entity.kyufuKaishiYMD;
        this.kyufuShuryoYMD = entity.kyufuShuryoYMD;
        this.kashitsuWariai_Kagaisha = entity.kashitsuWariai_Kagaisha;
        this.kashitsuWariai_Higaisha = entity.kashitsuWariai_Higaisha;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, jidanHokokushoUketukeYMD, shoriTimestamp, kyushoKyogiKubun, jidanHokokushoTeishutsuYMD, jidanSeiritsuYMD, kyufuKaishiYMD, kyufuShuryoYMD, kashitsuWariai_Kagaisha, kashitsuWariai_Higaisha);
    }

// </editor-fold>
}
