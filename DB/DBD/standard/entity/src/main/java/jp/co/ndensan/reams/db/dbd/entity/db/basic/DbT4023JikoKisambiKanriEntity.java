package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 時効起算日管理テーブルのエンティティクラスです。
 */
public class DbT4023JikoKisambiKanriEntity extends DbTableEntityBase<DbT4023JikoKisambiKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4023JikoKisambiKanri");

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
    private FlexibleDate choteiNendo;
    @PrimaryKey
    private FlexibleDate fukaNendo;
    @PrimaryKey
    private RString tokucho_FuchoKubun;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private RString shuno_Ki_Tsuki;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate jikoKisanYMD;
    private RString jikoKisanYMDKubun;
    private boolean logicalDeletedFlag;

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
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 調定年度のgetメソッドです。
     * 
     * @return 調定年度
     */
    public FlexibleDate getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * 調定年度のsetメソッドです。
     * 
     * @param choteiNendo 調定年度
     */
    public void setChoteiNendo(@Nonnull FlexibleDate choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * 賦課年度のgetメソッドです。
     * 
     * @return 賦課年度
     */
    public FlexibleDate getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     * 
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(@Nonnull FlexibleDate fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 特徴・普徴区分のgetメソッドです。
     * <br/>
     * <br/>1：特別徴収

     * <br/>2：普通徴収
     * 
     * @return 特徴・普徴区分
     */
    public RString getTokucho_FuchoKubun() {
        return tokucho_FuchoKubun;
    }

    /**
     * 特徴・普徴区分のsetメソッドです。
     * <br/>
     * <br/>1：特別徴収

     * <br/>2：普通徴収
     * 
     * @param tokucho_FuchoKubun 特徴・普徴区分
     */
    public void setTokucho_FuchoKubun(@Nonnull RString tokucho_FuchoKubun) {
        this.tokucho_FuchoKubun = tokucho_FuchoKubun;
    }

    /**
     * 通知書番号のgetメソッドです。
     * 
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     * 
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(@Nonnull TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 収納期・月のgetメソッドです。
     * 
     * @return 収納期・月
     */
    public RString getShuno_Ki_Tsuki() {
        return shuno_Ki_Tsuki;
    }

    /**
     * 収納期・月のsetメソッドです。
     * 
     * @param shuno_Ki_Tsuki 収納期・月
     */
    public void setShuno_Ki_Tsuki(@Nonnull RString shuno_Ki_Tsuki) {
        this.shuno_Ki_Tsuki = shuno_Ki_Tsuki;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 時効起算年月日のgetメソッドです。
     * 
     * @return 時効起算年月日
     */
    public FlexibleDate getJikoKisanYMD() {
        return jikoKisanYMD;
    }

    /**
     * 時効起算年月日のsetメソッドです。
     * 
     * @param jikoKisanYMD 時効起算年月日
     */
    public void setJikoKisanYMD(@Nonnull FlexibleDate jikoKisanYMD) {
        this.jikoKisanYMD = jikoKisanYMD;
    }

    /**
     * 時効起算日区分のgetメソッドです。
     * <br/>
     * <br/>1:納期限翌日（収）,2:督促状発行日（収）,3:収入日（収）,4:債務者の債務の承認,5:差押,6:仮差押,7:仮処分,8:裁判上の請求等、被保険者に対する請求,9:不明（調定無し）（収）,A:その他,B:分納契約日（収）
     * 
     * @return 時効起算日区分
     */
    public RString getJikoKisanYMDKubun() {
        return jikoKisanYMDKubun;
    }

    /**
     * 時効起算日区分のsetメソッドです。
     * <br/>
     * <br/>1:納期限翌日（収）,2:督促状発行日（収）,3:収入日（収）,4:債務者の債務の承認,5:差押,6:仮差押,7:仮処分,8:裁判上の請求等、被保険者に対する請求,9:不明（調定無し）（収）,A:その他,B:分納契約日（収）
     * 
     * @param jikoKisanYMDKubun 時効起算日区分
     */
    public void setJikoKisanYMDKubun(@Nonnull RString jikoKisanYMDKubun) {
        this.jikoKisanYMDKubun = jikoKisanYMDKubun;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * 
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4023JikoKisambiKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4023JikoKisambiKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4023JikoKisambiKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tokucho_FuchoKubun, other.tokucho_FuchoKubun)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        if (!Objects.equals(this.shuno_Ki_Tsuki, other.shuno_Ki_Tsuki)) {
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
    public void shallowCopy(DbT4023JikoKisambiKanriEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tokucho_FuchoKubun = entity.tokucho_FuchoKubun;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.shuno_Ki_Tsuki = entity.shuno_Ki_Tsuki;
        this.rirekiNo = entity.rirekiNo;
        this.jikoKisanYMD = entity.jikoKisanYMD;
        this.jikoKisanYMDKubun = entity.jikoKisanYMDKubun;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, choteiNendo, fukaNendo, tokucho_FuchoKubun, tsuchishoNo, shuno_Ki_Tsuki, rirekiNo, jikoKisanYMD, jikoKisanYMDKubun, logicalDeletedFlag);
    }

// </editor-fold>

}
