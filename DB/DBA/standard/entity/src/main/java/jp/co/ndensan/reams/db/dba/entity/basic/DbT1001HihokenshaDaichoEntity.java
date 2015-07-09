package jp.co.ndensan.reams.db.dba.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 被保険者台帳管理テーブルのエンティティクラスです。
 * <br/> 介護保険被保険者の資格を管理する （介護被保険者台帳管理の親share）
 */
public class DbT1001HihokenshaDaichoEntity extends DbTableEntityBase<DbT1001HihokenshaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT1001HihokenshaDaicho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private ShikibetsuCode shikibetsuCode;
    private RString shikakuShutokuJiyuCode;
    private FlexibleDate shikakuShutokuYMD;
    private FlexibleDate shikakuShutokuTodokedeYMD;
    private FlexibleDate ichigoShikakuShutokuYMD;
    private RString hihokennshaKubunCode;
    private RString shikakuSoshitsuJiyuCode;
    private FlexibleDate shikakuSoshitsuYMD;
    private FlexibleDate shikakuSoshitsuTodokedeYMD;
    private RString jushochiTokureiFlag;

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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 資格取得事由コードのgetメソッドです。
     * 
     * @return 資格取得事由コード
     */
    public RString getShikakuShutokuJiyuCode() {
        return shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得事由コードのsetメソッドです。
     * 
     * @param shikakuShutokuJiyuCode 資格取得事由コード
     */
    public void setShikakuShutokuJiyuCode(RString shikakuShutokuJiyuCode) {
        this.shikakuShutokuJiyuCode = shikakuShutokuJiyuCode;
    }

    /**
     * 資格取得年月日のgetメソッドです。
     * 
     * @return 資格取得年月日
     */
    public FlexibleDate getShikakuShutokuYMD() {
        return shikakuShutokuYMD;
    }

    /**
     * 資格取得年月日のsetメソッドです。
     * 
     * @param shikakuShutokuYMD 資格取得年月日
     */
    public void setShikakuShutokuYMD(FlexibleDate shikakuShutokuYMD) {
        this.shikakuShutokuYMD = shikakuShutokuYMD;
    }

    /**
     * 資格取得届出年月日のgetメソッドです。
     * 
     * @return 資格取得届出年月日
     */
    public FlexibleDate getShikakuShutokuTodokedeYMD() {
        return shikakuShutokuTodokedeYMD;
    }

    /**
     * 資格取得届出年月日のsetメソッドです。
     * 
     * @param shikakuShutokuTodokedeYMD 資格取得届出年月日
     */
    public void setShikakuShutokuTodokedeYMD(FlexibleDate shikakuShutokuTodokedeYMD) {
        this.shikakuShutokuTodokedeYMD = shikakuShutokuTodokedeYMD;
    }

    /**
     * 第1号資格取得年月日のgetメソッドです。
     * 
     * @return 第1号資格取得年月日
     */
    public FlexibleDate getIchigoShikakuShutokuYMD() {
        return ichigoShikakuShutokuYMD;
    }

    /**
     * 第1号資格取得年月日のsetメソッドです。
     * 
     * @param ichigoShikakuShutokuYMD 第1号資格取得年月日
     */
    public void setIchigoShikakuShutokuYMD(FlexibleDate ichigoShikakuShutokuYMD) {
        this.ichigoShikakuShutokuYMD = ichigoShikakuShutokuYMD;
    }

    /**
     * 被保険者区分コードのgetメソッドです。
     * <br/>
     * <br/>１号・２号
     * 
     * @return 被保険者区分コード
     */
    public RString getHihokennshaKubunCode() {
        return hihokennshaKubunCode;
    }

    /**
     * 被保険者区分コードのsetメソッドです。
     * <br/>
     * <br/>１号・２号
     * 
     * @param hihokennshaKubunCode 被保険者区分コード
     */
    public void setHihokennshaKubunCode(RString hihokennshaKubunCode) {
        this.hihokennshaKubunCode = hihokennshaKubunCode;
    }

    /**
     * 資格喪失事由コードのgetメソッドです。
     * 
     * @return 資格喪失事由コード
     */
    public RString getShikakuSoshitsuJiyuCode() {
        return shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失事由コードのsetメソッドです。
     * 
     * @param shikakuSoshitsuJiyuCode 資格喪失事由コード
     */
    public void setShikakuSoshitsuJiyuCode(RString shikakuSoshitsuJiyuCode) {
        this.shikakuSoshitsuJiyuCode = shikakuSoshitsuJiyuCode;
    }

    /**
     * 資格喪失年月日のgetメソッドです。
     * 
     * @return 資格喪失年月日
     */
    public FlexibleDate getShikakuSoshitsuYMD() {
        return shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失年月日のsetメソッドです。
     * 
     * @param shikakuSoshitsuYMD 資格喪失年月日
     */
    public void setShikakuSoshitsuYMD(FlexibleDate shikakuSoshitsuYMD) {
        this.shikakuSoshitsuYMD = shikakuSoshitsuYMD;
    }

    /**
     * 資格喪失届出年月日のgetメソッドです。
     * 
     * @return 資格喪失届出年月日
     */
    public FlexibleDate getShikakuSoshitsuTodokedeYMD() {
        return shikakuSoshitsuTodokedeYMD;
    }

    /**
     * 資格喪失届出年月日のsetメソッドです。
     * 
     * @param shikakuSoshitsuTodokedeYMD 資格喪失届出年月日
     */
    public void setShikakuSoshitsuTodokedeYMD(FlexibleDate shikakuSoshitsuTodokedeYMD) {
        this.shikakuSoshitsuTodokedeYMD = shikakuSoshitsuTodokedeYMD;
    }

    /**
     * 住所地特例フラグのgetメソッドです。
     * 
     * @return 住所地特例フラグ
     */
    public RString getJushochiTokureiFlag() {
        return jushochiTokureiFlag;
    }

    /**
     * 住所地特例フラグのsetメソッドです。
     * 
     * @param jushochiTokureiFlag 住所地特例フラグ
     */
    public void setJushochiTokureiFlag(RString jushochiTokureiFlag) {
        this.jushochiTokureiFlag = jushochiTokureiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1001HihokenshaDaichoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1001HihokenshaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1001HihokenshaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT1001HihokenshaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.shikakuShutokuJiyuCode = entity.shikakuShutokuJiyuCode;
        this.shikakuShutokuYMD = entity.shikakuShutokuYMD;
        this.shikakuShutokuTodokedeYMD = entity.shikakuShutokuTodokedeYMD;
        this.ichigoShikakuShutokuYMD = entity.ichigoShikakuShutokuYMD;
        this.hihokennshaKubunCode = entity.hihokennshaKubunCode;
        this.shikakuSoshitsuJiyuCode = entity.shikakuSoshitsuJiyuCode;
        this.shikakuSoshitsuYMD = entity.shikakuSoshitsuYMD;
        this.shikakuSoshitsuTodokedeYMD = entity.shikakuSoshitsuTodokedeYMD;
        this.jushochiTokureiFlag = entity.jushochiTokureiFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, rirekiNo, shikibetsuCode, shikakuShutokuJiyuCode, shikakuShutokuYMD, shikakuShutokuTodokedeYMD, ichigoShikakuShutokuYMD, hihokennshaKubunCode, shikakuSoshitsuJiyuCode, shikakuSoshitsuYMD, shikakuSoshitsuTodokedeYMD, jushochiTokureiFlag);
    }

// </editor-fold>
}
