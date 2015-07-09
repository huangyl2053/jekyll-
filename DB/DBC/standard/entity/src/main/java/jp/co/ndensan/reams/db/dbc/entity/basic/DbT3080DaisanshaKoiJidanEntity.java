package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;

/**
 * 介護第三者行為示談テーブルのエンティティクラスです。
 */
public class DbT3080DaisanshaKoiJidanEntity extends DbTableEntityBase<DbT3080DaisanshaKoiJidanEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString todokedeKanriNo;
    @PrimaryKey
    private FlexibleDate jidanHokokushoUketukeYMD;
    @PrimaryKey
    private int rirekiNo;
    private RString kyushoKyogiKubun;
    private FlexibleDate jidanHokokushoTeishutsuYMD;
    private FlexibleDate jidanSeiritsuYMD;
    private FlexibleYearMonth kyufuKaishiYMD;
    private FlexibleYearMonth kyufuShuryoYMD;
    private RString kashitsuWariai_Kagaisha;
    private RString kashitsuWariai_Higaisha;

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
    public DbUDD002HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(DbUDD002HihokenshaNo hihokenshaNo) {
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
     * 示談報告書受付年月日のgetメソッドです。
     * 
     * @return 示談報告書受付年月日
     */
    public FlexibleDate getJidanHokokushoUketukeYMD() {
        return jidanHokokushoUketukeYMD;
    }

    /**
     * 示談報告書受付年月日のsetメソッドです。
     * 
     * @param jidanHokokushoUketukeYMD 示談報告書受付年月日
     */
    public void setJidanHokokushoUketukeYMD(FlexibleDate jidanHokokushoUketukeYMD) {
        this.jidanHokokushoUketukeYMD = jidanHokokushoUketukeYMD;
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
     * 第三者行為求償協議区分のgetメソッドです。
     * 
     * @return 第三者行為求償協議区分
     */
    public RString getKyushoKyogiKubun() {
        return kyushoKyogiKubun;
    }

    /**
     * 第三者行為求償協議区分のsetメソッドです。
     * 
     * @param kyushoKyogiKubun 第三者行為求償協議区分
     */
    public void setKyushoKyogiKubun(RString kyushoKyogiKubun) {
        this.kyushoKyogiKubun = kyushoKyogiKubun;
    }

    /**
     * 示談報告書提出年月日のgetメソッドです。
     * 
     * @return 示談報告書提出年月日
     */
    public FlexibleDate getJidanHokokushoTeishutsuYMD() {
        return jidanHokokushoTeishutsuYMD;
    }

    /**
     * 示談報告書提出年月日のsetメソッドです。
     * 
     * @param jidanHokokushoTeishutsuYMD 示談報告書提出年月日
     */
    public void setJidanHokokushoTeishutsuYMD(FlexibleDate jidanHokokushoTeishutsuYMD) {
        this.jidanHokokushoTeishutsuYMD = jidanHokokushoTeishutsuYMD;
    }

    /**
     * 示談成立年月日のgetメソッドです。
     * 
     * @return 示談成立年月日
     */
    public FlexibleDate getJidanSeiritsuYMD() {
        return jidanSeiritsuYMD;
    }

    /**
     * 示談成立年月日のsetメソッドです。
     * 
     * @param jidanSeiritsuYMD 示談成立年月日
     */
    public void setJidanSeiritsuYMD(FlexibleDate jidanSeiritsuYMD) {
        this.jidanSeiritsuYMD = jidanSeiritsuYMD;
    }

    /**
     * 給付期間開始年月のgetメソッドです。
     * 
     * @return 給付期間開始年月
     */
    public FlexibleYearMonth getKyufuKaishiYMD() {
        return kyufuKaishiYMD;
    }

    /**
     * 給付期間開始年月のsetメソッドです。
     * 
     * @param kyufuKaishiYMD 給付期間開始年月
     */
    public void setKyufuKaishiYMD(FlexibleYearMonth kyufuKaishiYMD) {
        this.kyufuKaishiYMD = kyufuKaishiYMD;
    }

    /**
     * 給付期間終了年月のgetメソッドです。
     * 
     * @return 給付期間終了年月
     */
    public FlexibleYearMonth getKyufuShuryoYMD() {
        return kyufuShuryoYMD;
    }

    /**
     * 給付期間終了年月のsetメソッドです。
     * 
     * @param kyufuShuryoYMD 給付期間終了年月
     */
    public void setKyufuShuryoYMD(FlexibleYearMonth kyufuShuryoYMD) {
        this.kyufuShuryoYMD = kyufuShuryoYMD;
    }

    /**
     * 過失割合・加害者のgetメソッドです。
     * 
     * @return 過失割合・加害者
     */
    public RString getKashitsuWariai_Kagaisha() {
        return kashitsuWariai_Kagaisha;
    }

    /**
     * 過失割合・加害者のsetメソッドです。
     * 
     * @param kashitsuWariai_Kagaisha 過失割合・加害者
     */
    public void setKashitsuWariai_Kagaisha(RString kashitsuWariai_Kagaisha) {
        this.kashitsuWariai_Kagaisha = kashitsuWariai_Kagaisha;
    }

    /**
     * 過失割合・被害者のgetメソッドです。
     * 
     * @return 過失割合・被害者
     */
    public RString getKashitsuWariai_Higaisha() {
        return kashitsuWariai_Higaisha;
    }

    /**
     * 過失割合・被害者のsetメソッドです。
     * 
     * @param kashitsuWariai_Higaisha 過失割合・被害者
     */
    public void setKashitsuWariai_Higaisha(RString kashitsuWariai_Higaisha) {
        this.kashitsuWariai_Higaisha = kashitsuWariai_Higaisha;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3080DaisanshaKoiJidanEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3080DaisanshaKoiJidanEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, jidanHokokushoUketukeYMD, rirekiNo, kyushoKyogiKubun, jidanHokokushoTeishutsuYMD, jidanSeiritsuYMD, kyufuKaishiYMD, kyufuShuryoYMD, kashitsuWariai_Kagaisha, kashitsuWariai_Higaisha);
    }

// </editor-fold>
}
