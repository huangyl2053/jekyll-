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
 * 適用除外者テーブルのエンティティクラスです。
 */
public class DbT1002TekiyoJogaishaEntity extends DbTableEntityBase<DbT1002TekiyoJogaishaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private LasdecCode shichosonCode;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private int rirekiNo;
    private RString tekiyoJogaiTekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private RString tekiyoJogaikaijokaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;

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
    public void setTekiyoJogaiTekiyoJiyuCode(RString tekiyoJogaiTekiyoJiyuCode) {
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
    public void setTekiyoYMD(FlexibleDate tekiyoYMD) {
        this.tekiyoYMD = tekiyoYMD;
    }

    /**
     * 適用届出年月日のgetメソッドです。
     * 
     * @return 適用届出年月日
     */
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
     * このエンティティの主キーが他の{@literal DbT1002TekiyoJogaishaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1002TekiyoJogaishaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1002TekiyoJogaishaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
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
    public void shallowCopy(DbT1002TekiyoJogaishaEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoJogaiTekiyoJiyuCode = entity.tekiyoJogaiTekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.tekiyoJogaikaijokaijoJiyuCode = entity.tekiyoJogaikaijokaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shikibetsuCode, rirekiNo, tekiyoJogaiTekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, tekiyoJogaikaijokaijoJiyuCode, kaijoYMD, kaijoTodokedeYMD, kaijoUketsukeYMD);
    }

// </editor-fold>
}
