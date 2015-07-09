package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 支払方法変更差止テーブルのエンティティクラスです。
 */
public class DbT4024ShiharaiHohoHenkoSashitomeEntity extends DbTableEntityBase<DbT4024ShiharaiHohoHenkoSashitomeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4024ShiharaiHohoHenkoSashitome");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private DbUDD015ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private DbUDD002HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString kanriKubun;
    @PrimaryKey
    private FlexibleYearMonth sashitome_ServiceTeikyoYM;
    @PrimaryKey
    private RString sashitome_ShokanSeiriNo;
    @PrimaryKey
    private int rirekiNo;
    private RString sashitome_JokyoKubun;
    private FlexibleDate sashitome_KetteiYMD;
    private FlexibleDate sashitome_TsuchiHakkoYMD;
    private boolean sashitome_TsuchiSaiHakkoFlag;
    private FlexibleDate sashitome_NofuYMD;
    private FlexibleDate sashitome_KaijoYMD;
    private FlexibleDate kojo_KetteiYMD;
    private FlexibleDate kojo_TsuchiHakkoYMD;
    private boolean kojo_TsuchiSaiHakkoYMD;
    private FlexibleDate kojo_ShoTeishutsuYMD;

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
    public DbUDD015ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(DbUDD015ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 管理区分のgetメソッドです。
     * <br/>
     * <br/>1：２号差止
     * <br/>2：１号償還払い化
     * <br/>3：１号給付額減額
     * 
     * @return 管理区分
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * 管理区分のsetメソッドです。
     * <br/>
     * <br/>1：２号差止
     * <br/>2：１号償還払い化
     * <br/>3：１号給付額減額
     * 
     * @param kanriKubun 管理区分
     */
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /**
     * 差止サービス提供年月のgetメソッドです。
     * 
     * @return 差止サービス提供年月
     */
    public FlexibleYearMonth getSashitome_ServiceTeikyoYM() {
        return sashitome_ServiceTeikyoYM;
    }

    /**
     * 差止サービス提供年月のsetメソッドです。
     * 
     * @param sashitome_ServiceTeikyoYM 差止サービス提供年月
     */
    public void setSashitome_ServiceTeikyoYM(FlexibleYearMonth sashitome_ServiceTeikyoYM) {
        this.sashitome_ServiceTeikyoYM = sashitome_ServiceTeikyoYM;
    }

    /**
     * 差止償還整理番号のgetメソッドです。
     * 
     * @return 差止償還整理番号
     */
    public RString getSashitome_ShokanSeiriNo() {
        return sashitome_ShokanSeiriNo;
    }

    /**
     * 差止償還整理番号のsetメソッドです。
     * 
     * @param sashitome_ShokanSeiriNo 差止償還整理番号
     */
    public void setSashitome_ShokanSeiriNo(RString sashitome_ShokanSeiriNo) {
        this.sashitome_ShokanSeiriNo = sashitome_ShokanSeiriNo;
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
     * 差止状況区分のgetメソッドです。
     * <br/>
     * <br/>1：差止登録,9：差止解除
     * 
     * @return 差止状況区分
     */
    public RString getSashitome_JokyoKubun() {
        return sashitome_JokyoKubun;
    }

    /**
     * 差止状況区分のsetメソッドです。
     * <br/>
     * <br/>1：差止登録,9：差止解除
     * 
     * @param sashitome_JokyoKubun 差止状況区分
     */
    public void setSashitome_JokyoKubun(RString sashitome_JokyoKubun) {
        this.sashitome_JokyoKubun = sashitome_JokyoKubun;
    }

    /**
     * 差止決定年月日のgetメソッドです。
     * 
     * @return 差止決定年月日
     */
    public FlexibleDate getSashitome_KetteiYMD() {
        return sashitome_KetteiYMD;
    }

    /**
     * 差止決定年月日のsetメソッドです。
     * 
     * @param sashitome_KetteiYMD 差止決定年月日
     */
    public void setSashitome_KetteiYMD(FlexibleDate sashitome_KetteiYMD) {
        this.sashitome_KetteiYMD = sashitome_KetteiYMD;
    }

    /**
     * 差止通知書発行年月日のgetメソッドです。
     * 
     * @return 差止通知書発行年月日
     */
    public FlexibleDate getSashitome_TsuchiHakkoYMD() {
        return sashitome_TsuchiHakkoYMD;
    }

    /**
     * 差止通知書発行年月日のsetメソッドです。
     * 
     * @param sashitome_TsuchiHakkoYMD 差止通知書発行年月日
     */
    public void setSashitome_TsuchiHakkoYMD(FlexibleDate sashitome_TsuchiHakkoYMD) {
        this.sashitome_TsuchiHakkoYMD = sashitome_TsuchiHakkoYMD;
    }

    /**
     * 差止通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @return 差止通知書再発行フラグ
     */
    public boolean getSashitome_TsuchiSaiHakkoFlag() {
        return sashitome_TsuchiSaiHakkoFlag;
    }

    /**
     * 差止通知書再発行フラグのsetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @param sashitome_TsuchiSaiHakkoFlag 差止通知書再発行フラグ
     */
    public void setSashitome_TsuchiSaiHakkoFlag(boolean sashitome_TsuchiSaiHakkoFlag) {
        this.sashitome_TsuchiSaiHakkoFlag = sashitome_TsuchiSaiHakkoFlag;
    }

    /**
     * 差止納付期限のgetメソッドです。
     * 
     * @return 差止納付期限
     */
    public FlexibleDate getSashitome_NofuYMD() {
        return sashitome_NofuYMD;
    }

    /**
     * 差止納付期限のsetメソッドです。
     * 
     * @param sashitome_NofuYMD 差止納付期限
     */
    public void setSashitome_NofuYMD(FlexibleDate sashitome_NofuYMD) {
        this.sashitome_NofuYMD = sashitome_NofuYMD;
    }

    /**
     * 差止解除年月日のgetメソッドです。
     * 
     * @return 差止解除年月日
     */
    public FlexibleDate getSashitome_KaijoYMD() {
        return sashitome_KaijoYMD;
    }

    /**
     * 差止解除年月日のsetメソッドです。
     * 
     * @param sashitome_KaijoYMD 差止解除年月日
     */
    public void setSashitome_KaijoYMD(FlexibleDate sashitome_KaijoYMD) {
        this.sashitome_KaijoYMD = sashitome_KaijoYMD;
    }

    /**
     * 控除決定年月日のgetメソッドです。
     * 
     * @return 控除決定年月日
     */
    public FlexibleDate getKojo_KetteiYMD() {
        return kojo_KetteiYMD;
    }

    /**
     * 控除決定年月日のsetメソッドです。
     * 
     * @param kojo_KetteiYMD 控除決定年月日
     */
    public void setKojo_KetteiYMD(FlexibleDate kojo_KetteiYMD) {
        this.kojo_KetteiYMD = kojo_KetteiYMD;
    }

    /**
     * 控除通知書発行年月日のgetメソッドです。
     * 
     * @return 控除通知書発行年月日
     */
    public FlexibleDate getKojo_TsuchiHakkoYMD() {
        return kojo_TsuchiHakkoYMD;
    }

    /**
     * 控除通知書発行年月日のsetメソッドです。
     * 
     * @param kojo_TsuchiHakkoYMD 控除通知書発行年月日
     */
    public void setKojo_TsuchiHakkoYMD(FlexibleDate kojo_TsuchiHakkoYMD) {
        this.kojo_TsuchiHakkoYMD = kojo_TsuchiHakkoYMD;
    }

    /**
     * 控除通知書再発行フラグのgetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @return 控除通知書再発行フラグ
     */
    public boolean getKojo_TsuchiSaiHakkoYMD() {
        return kojo_TsuchiSaiHakkoYMD;
    }

    /**
     * 控除通知書再発行フラグのsetメソッドです。
     * <br/>
     * <br/>1：再発行対象,0：再発行対象外
     * 
     * @param kojo_TsuchiSaiHakkoYMD 控除通知書再発行フラグ
     */
    public void setKojo_TsuchiSaiHakkoYMD(boolean kojo_TsuchiSaiHakkoYMD) {
        this.kojo_TsuchiSaiHakkoYMD = kojo_TsuchiSaiHakkoYMD;
    }

    /**
     * 控除被保険者証提出期限のgetメソッドです。
     * 
     * @return 控除被保険者証提出期限
     */
    public FlexibleDate getKojo_ShoTeishutsuYMD() {
        return kojo_ShoTeishutsuYMD;
    }

    /**
     * 控除被保険者証提出期限のsetメソッドです。
     * 
     * @param kojo_ShoTeishutsuYMD 控除被保険者証提出期限
     */
    public void setKojo_ShoTeishutsuYMD(FlexibleDate kojo_ShoTeishutsuYMD) {
        this.kojo_ShoTeishutsuYMD = kojo_ShoTeishutsuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4024ShiharaiHohoHenkoSashitomeEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4024ShiharaiHohoHenkoSashitomeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4024ShiharaiHohoHenkoSashitomeEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKubun, other.kanriKubun)) {
            return false;
        }
        if (!Objects.equals(this.sashitome_ServiceTeikyoYM, other.sashitome_ServiceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.sashitome_ShokanSeiriNo, other.sashitome_ShokanSeiriNo)) {
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
    public void shallowCopy(DbT4024ShiharaiHohoHenkoSashitomeEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.sashitome_ServiceTeikyoYM = entity.sashitome_ServiceTeikyoYM;
        this.sashitome_ShokanSeiriNo = entity.sashitome_ShokanSeiriNo;
        this.rirekiNo = entity.rirekiNo;
        this.sashitome_JokyoKubun = entity.sashitome_JokyoKubun;
        this.sashitome_KetteiYMD = entity.sashitome_KetteiYMD;
        this.sashitome_TsuchiHakkoYMD = entity.sashitome_TsuchiHakkoYMD;
        this.sashitome_TsuchiSaiHakkoFlag = entity.sashitome_TsuchiSaiHakkoFlag;
        this.sashitome_NofuYMD = entity.sashitome_NofuYMD;
        this.sashitome_KaijoYMD = entity.sashitome_KaijoYMD;
        this.kojo_KetteiYMD = entity.kojo_KetteiYMD;
        this.kojo_TsuchiHakkoYMD = entity.kojo_TsuchiHakkoYMD;
        this.kojo_TsuchiSaiHakkoYMD = entity.kojo_TsuchiSaiHakkoYMD;
        this.kojo_ShoTeishutsuYMD = entity.kojo_ShoTeishutsuYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, sashitome_ServiceTeikyoYM, sashitome_ShokanSeiriNo, rirekiNo, sashitome_JokyoKubun, sashitome_KetteiYMD, sashitome_TsuchiHakkoYMD, sashitome_TsuchiSaiHakkoFlag, sashitome_NofuYMD, sashitome_KaijoYMD, kojo_KetteiYMD, kojo_TsuchiHakkoYMD, kojo_TsuchiSaiHakkoYMD, kojo_ShoTeishutsuYMD);
    }

// </editor-fold>
}
