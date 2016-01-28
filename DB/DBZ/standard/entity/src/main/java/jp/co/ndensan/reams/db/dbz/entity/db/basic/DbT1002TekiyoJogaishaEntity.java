package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import lombok.NonNull;

/**
 * 適用除外者テーブルのエンティティクラスです。
 */
public class DbT1002TekiyoJogaishaEntity extends DbTableEntityBase<DbT1002TekiyoJogaishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1002TekiyoJogaisha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString edaNo;
    private RString idoJiyuCode;
    private LasdecCode shichosonCode;
    private RString tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString tekiyoJogaikaijokaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private FlexibleDate nyushoTsuchiHakkoYMD;
    private FlexibleDate taishoTsuchiHakkoYMD;
    private FlexibleDate henkoTsuchiHakkoYMD;
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
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@NonNull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 異動日のgetメソッドです。
     * 
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動日のsetメソッドです。
     * 
     * @param idoYMD 異動日
     */
    public void setIdoYMD(@NonNull FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 枝番のgetメソッドです。
     * 
     * @return 枝番
     */
    public RString getEdaNo() {
        return edaNo;
    }

    /**
     * 枝番のsetメソッドです。
     * 
     * @param edaNo 枝番
     */
    public void setEdaNo(@NonNull RString edaNo) {
        this.edaNo = edaNo;
    }

    /**
     * 異動事由コードのgetメソッドです。
     * 
     * @return 異動事由コード
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由コードのsetメソッドです。
     * 
     * @param idoJiyuCode 異動事由コード
     */
    public void setIdoJiyuCode(@NonNull RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@NonNull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 適用除外適用事由コードのgetメソッドです。
     * 
     * @return 適用除外適用事由コード
     */
    public RString getTekiyoJogaiTekiyoJiyuCode() {
        return tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * 適用除外適用事由コードのsetメソッドです。
     * 
     * @param tekiyoJogaiTekiyoJiyuCode 適用除外適用事由コード
     */
    public void setTekiyoJogaiTekiyoJiyuCode(@NonNull RString tekiyoJogaiTekiyoJiyuCode) {
        this.tekiyoJogaiTekiyoJiyuCode = tekiyoJogaiTekiyoJiyuCode;
    }

    /**
     * 適用年月日のgetメソッドです。
     * 
     * @return 適用年月日
     */
    public FlexibleDate getTekiyoYMD() {
        return tekiyoYMD;
    }

    /**
     * 適用年月日のsetメソッドです。
     * 
     * @param tekiyoYMD 適用年月日
     */
    public void setTekiyoYMD(@NonNull FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * 適用届出年月日のgetメソッドです。
     * 
     * @return 適用届出年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoTodokedeYMD() {
        return tekiyoTodokedeYMD;
    }

    /**
     * 適用届出年月日のsetメソッドです。
     * 
     * @param tekiyoTodokedeYMD 適用届出年月日
     */
    public void setTekiyoTodokedeYMD(FlexibleDate tekiyoTodokedeYMD) {
        this.tekiyoTodokedeYMD = tekiyoTodokedeYMD;
    }

    /**
     * 適用受付年月日のgetメソッドです。
     * 
     * @return 適用受付年月日
     */
    @CheckForNull
    public FlexibleDate getTekiyoUketsukeYMD() {
        return tekiyoUketsukeYMD;
    }

    /**
     * 適用受付年月日のsetメソッドです。
     * 
     * @param tekiyoUketsukeYMD 適用受付年月日
     */
    public void setTekiyoUketsukeYMD(FlexibleDate tekiyoUketsukeYMD) {
        this.tekiyoUketsukeYMD = tekiyoUketsukeYMD;
    }

    /**
     * 適用除外解除事由コードのgetメソッドです。
     * 
     * @return 適用除外解除事由コード
     */
    @CheckForNull
    public RString getTekiyoJogaikaijokaijoJiyuCode() {
        return tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * 適用除外解除事由コードのsetメソッドです。
     * 
     * @param tekiyoJogaikaijokaijoJiyuCode 適用除外解除事由コード
     */
    public void setTekiyoJogaikaijokaijoJiyuCode(RString tekiyoJogaikaijokaijoJiyuCode) {
        this.tekiyoJogaikaijokaijoJiyuCode = tekiyoJogaikaijokaijoJiyuCode;
    }

    /**
     * 解除年月日のgetメソッドです。
     * 
     * @return 解除年月日
     */
    @CheckForNull
    public FlexibleDate getKaijoYMD() {
        return kaijoYMD;
    }

    /**
     * 解除年月日のsetメソッドです。
     * 
     * @param kaijoYMD 解除年月日
     */
    public void setKaijoYMD(FlexibleDate kaijoYMD) {
        this.kaijoYMD = kaijoYMD;
    }

    /**
     * 解除届出年月日のgetメソッドです。
     * 
     * @return 解除届出年月日
     */
    @CheckForNull
    public FlexibleDate getKaijoTodokedeYMD() {
        return kaijoTodokedeYMD;
    }

    /**
     * 解除届出年月日のsetメソッドです。
     * 
     * @param kaijoTodokedeYMD 解除届出年月日
     */
    public void setKaijoTodokedeYMD(FlexibleDate kaijoTodokedeYMD) {
        this.kaijoTodokedeYMD = kaijoTodokedeYMD;
    }

    /**
     * 解除受付年月日のgetメソッドです。
     * 
     * @return 解除受付年月日
     */
    @CheckForNull
    public FlexibleDate getKaijoUketsukeYMD() {
        return kaijoUketsukeYMD;
    }

    /**
     * 解除受付年月日のsetメソッドです。
     * 
     * @param kaijoUketsukeYMD 解除受付年月日
     */
    public void setKaijoUketsukeYMD(FlexibleDate kaijoUketsukeYMD) {
        this.kaijoUketsukeYMD = kaijoUketsukeYMD;
    }

    /**
     * 入所通知発行日のgetメソッドです。
     * 
     * @return 入所通知発行日
     */
    @CheckForNull
    public FlexibleDate getNyushoTsuchiHakkoYMD() {
        return nyushoTsuchiHakkoYMD;
    }

    /**
     * 入所通知発行日のsetメソッドです。
     * 
     * @param nyushoTsuchiHakkoYMD 入所通知発行日
     */
    public void setNyushoTsuchiHakkoYMD(FlexibleDate nyushoTsuchiHakkoYMD) {
        this.nyushoTsuchiHakkoYMD = nyushoTsuchiHakkoYMD;
    }

    /**
     * 退所通知発行日のgetメソッドです。
     * 
     * @return 退所通知発行日
     */
    @CheckForNull
    public FlexibleDate getTaishoTsuchiHakkoYMD() {
        return taishoTsuchiHakkoYMD;
    }

    /**
     * 退所通知発行日のsetメソッドです。
     * 
     * @param taishoTsuchiHakkoYMD 退所通知発行日
     */
    public void setTaishoTsuchiHakkoYMD(FlexibleDate taishoTsuchiHakkoYMD) {
        this.taishoTsuchiHakkoYMD = taishoTsuchiHakkoYMD;
    }

    /**
     * 変更通知発行日のgetメソッドです。
     * 
     * @return 変更通知発行日
     */
    @CheckForNull
    public FlexibleDate getHenkoTsuchiHakkoYMD() {
        return henkoTsuchiHakkoYMD;
    }

    /**
     * 変更通知発行日のsetメソッドです。
     * 
     * @param henkoTsuchiHakkoYMD 変更通知発行日
     */
    public void setHenkoTsuchiHakkoYMD(FlexibleDate henkoTsuchiHakkoYMD) {
        this.henkoTsuchiHakkoYMD = henkoTsuchiHakkoYMD;
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
     * このエンティティの主キーが他の{@literal DbT1002TekiyoJogaishaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1002TekiyoJogaishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1002TekiyoJogaishaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.edaNo, other.edaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1002TekiyoJogaishaEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.tekiyoJogaiTekiyoJiyuCode = entity.tekiyoJogaiTekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.tekiyoJogaikaijokaijoJiyuCode = entity.tekiyoJogaikaijokaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.nyushoTsuchiHakkoYMD = entity.nyushoTsuchiHakkoYMD;
        this.taishoTsuchiHakkoYMD = entity.taishoTsuchiHakkoYMD;
        this.henkoTsuchiHakkoYMD = entity.henkoTsuchiHakkoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, idoYMD, edaNo, idoJiyuCode, shichosonCode, tekiyoJogaiTekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, tekiyoJogaikaijokaijoJiyuCode, kaijoYMD, kaijoTodokedeYMD, kaijoUketsukeYMD, nyushoTsuchiHakkoYMD, taishoTsuchiHakkoYMD, henkoTsuchiHakkoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
