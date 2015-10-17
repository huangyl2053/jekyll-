package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT1003TashichosonJushochiTokureiの項目定義クラスです
 *
 */
public class DbT1003TashichosonJushochiTokureiEntity extends DbTableEntityBase<DbT1003TashichosonJushochiTokureiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1003TashichosonJushochiTokurei");

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
    private KaigoTatokuTekiyoJiyu tekiyoJiyuCode;
    private FlexibleDate tekiyoYMD;
    private FlexibleDate tekiyoTodokedeYMD;
    private FlexibleDate tekiyoUketsukeYMD;
    private KaigoTatokuKaijoJiyu kaijoJiyuCode;
    private FlexibleDate kaijoYMD;
    private FlexibleDate kaijoTodokedeYMD;
    private FlexibleDate kaijoUketsukeYMD;
    private ShoKisaiHokenshaNo sochiHokenshaNo;
    private HihokenshaNo sochiHihokenshaNo;
    private FlexibleDate tatokuRenrakuhyoHakkoYMD;
    private FlexibleDate shisetsuTaishoTsuchiHakkoYMD;
    private FlexibleDate shisetsuHenkoTsuchiHakkoYMD;
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
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
    public void setIdoYMD(FlexibleDate idoYMD) {
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
    public void setEdaNo(RString edaNo) {
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
    public void setIdoJiyuCode(RString idoJiyuCode) {
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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 他市町村住所地特例適用事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public KaigoTatokuTekiyoJiyu getTekiyoJiyuCode() {
        return tekiyoJiyuCode;
    }

    /**
     * 他市町村住所地特例適用事由コードのsetメソッドです。
     *
     * @param tekiyoJiyuCode 他市町村住所地特例適用事由コード
     */
    public void setTekiyoJiyuCode(KaigoTatokuTekiyoJiyu tekiyoJiyuCode) {
        this.tekiyoJiyuCode = tekiyoJiyuCode;
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
     * 他市町村住所地特例解除事由コードのgetメソッドです。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public KaigoTatokuKaijoJiyu getKaijoJiyuCode() {
        return kaijoJiyuCode;
    }

    /**
     * 他市町村住所地特例解除事由コードのsetメソッドです。
     *
     * @param kaijoJiyuCode 他市町村住所地特例解除事由コード
     */
    public void setKaijoJiyuCode(KaigoTatokuKaijoJiyu kaijoJiyuCode) {
        this.kaijoJiyuCode = kaijoJiyuCode;
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
     * 措置保険者番号のgetメソッドです。
     *
     * @return 措置保険者番号
     */
    public ShoKisaiHokenshaNo getSochiHokenshaNo() {
        return sochiHokenshaNo;
    }

    /**
     * 措置保険者番号のsetメソッドです。
     *
     * @param sochiHokenshaNo 措置保険者番号
     */
    public void setSochiHokenshaNo(ShoKisaiHokenshaNo sochiHokenshaNo) {
        this.sochiHokenshaNo = sochiHokenshaNo;
    }

    /**
     * 措置被保険者番号のgetメソッドです。
     *
     * @return 措置被保険者番号
     */
    public HihokenshaNo getSochiHihokenshaNo() {
        return sochiHihokenshaNo;
    }

    /**
     * 措置被保険者番号のsetメソッドです。
     *
     * @param sochiHihokenshaNo 措置被保険者番号
     */
    public void setSochiHihokenshaNo(HihokenshaNo sochiHihokenshaNo) {
        this.sochiHihokenshaNo = sochiHihokenshaNo;
    }

    /**
     * 他特例連絡票発行年月日のgetメソッドです。
     *
     * @return 他特例連絡票発行年月日
     */
    public FlexibleDate getTatokuRenrakuhyoHakkoYMD() {
        return tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * 他特例連絡票発行年月日のsetメソッドです。
     *
     * @param tatokuRenrakuhyoHakkoYMD 他特例連絡票発行年月日
     */
    public void setTatokuRenrakuhyoHakkoYMD(FlexibleDate tatokuRenrakuhyoHakkoYMD) {
        this.tatokuRenrakuhyoHakkoYMD = tatokuRenrakuhyoHakkoYMD;
    }

    /**
     * 施設退所通知発行年月日のgetメソッドです。
     *
     * @return 施設退所通知発行年月日
     */
    public FlexibleDate getShisetsuTaishoTsuchiHakkoYMD() {
        return shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * 施設退所通知発行年月日のsetメソッドです。
     *
     * @param shisetsuTaishoTsuchiHakkoYMD 施設退所通知発行年月日
     */
    public void setShisetsuTaishoTsuchiHakkoYMD(FlexibleDate shisetsuTaishoTsuchiHakkoYMD) {
        this.shisetsuTaishoTsuchiHakkoYMD = shisetsuTaishoTsuchiHakkoYMD;
    }

    /**
     * 施設変更通知発行年月日のgetメソッドです。
     *
     * @return 施設変更通知発行年月日
     */
    public FlexibleDate getShisetsuHenkoTsuchiHakkoYMD() {
        return shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * 施設変更通知発行年月日のsetメソッドです。
     *
     * @param shisetsuHenkoTsuchiHakkoYMD 施設変更通知発行年月日
     */
    public void setShisetsuHenkoTsuchiHakkoYMD(FlexibleDate shisetsuHenkoTsuchiHakkoYMD) {
        this.shisetsuHenkoTsuchiHakkoYMD = shisetsuHenkoTsuchiHakkoYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
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
     * このエンティティの主キーが他の{@literal DbT1003TashichosonJushochiTokureiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT1003TashichosonJushochiTokureiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1003TashichosonJushochiTokureiEntity other) {
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
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT1003TashichosonJushochiTokureiEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.idoYMD = entity.idoYMD;
        this.edaNo = entity.edaNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.shichosonCode = entity.shichosonCode;
        this.tekiyoJiyuCode = entity.tekiyoJiyuCode;
        this.tekiyoYMD = entity.tekiyoYMD;
        this.tekiyoTodokedeYMD = entity.tekiyoTodokedeYMD;
        this.tekiyoUketsukeYMD = entity.tekiyoUketsukeYMD;
        this.kaijoJiyuCode = entity.kaijoJiyuCode;
        this.kaijoYMD = entity.kaijoYMD;
        this.kaijoTodokedeYMD = entity.kaijoTodokedeYMD;
        this.kaijoUketsukeYMD = entity.kaijoUketsukeYMD;
        this.sochiHokenshaNo = entity.sochiHokenshaNo;
        this.sochiHihokenshaNo = entity.sochiHihokenshaNo;
        this.tatokuRenrakuhyoHakkoYMD = entity.tatokuRenrakuhyoHakkoYMD;
        this.shisetsuTaishoTsuchiHakkoYMD = entity.shisetsuTaishoTsuchiHakkoYMD;
        this.shisetsuHenkoTsuchiHakkoYMD = entity.shisetsuHenkoTsuchiHakkoYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, idoYMD, edaNo, idoJiyuCode, shichosonCode, tekiyoJiyuCode, tekiyoYMD, tekiyoTodokedeYMD, tekiyoUketsukeYMD, kaijoJiyuCode, kaijoYMD, kaijoTodokedeYMD, kaijoUketsukeYMD, sochiHokenshaNo, sochiHihokenshaNo, tatokuRenrakuhyoHakkoYMD, shisetsuTaishoTsuchiHakkoYMD, shisetsuHenkoTsuchiHakkoYMD, logicalDeletedFlag);
    }

// </editor-fold>
}
