package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;

/**
 * 介護連絡先情報テーブルのエンティティクラスです。
 */
public class DbT5150RenrakusakiJohoEntity extends DbTableEntityBase<DbT5150RenrakusakiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5150RenrakusakiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int renban;
    private RString renrakusakiKubunNo;
    private ShishoCode shishoCode;
    private AtenaMeisho renrakusakiShimei;
    private AtenaKanaMeisho renrakusakiKanaSimei;
    private RString renrakusakiTuzukigara;
    private YubinNo renrakusakiYubinNo;
    private AtenaJusho renrakusakiJusho;
    private TelNo renrakusakiTelNo;
    private TelNo renrakusakiKeitaiTelNo;
    private int priority;

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
     * updateCountのgetメソッドです。
     * 
     * @return updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }
    
    /**
     * updateCountのsetメソッドです。
     * 
     * @param updateCount updateCount
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRenban() {
        return renban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param renban 連番
     */
    public void setRenban(@Nonnull int renban) {
        this.renban = renban;
    }

    /**
     * 連絡先区分のgetメソッドです。
     * 
     * @return 連絡先区分
     */
    @CheckForNull
    public RString getRenrakusakiKubunNo() {
        return renrakusakiKubunNo;
    }

    /**
     * 連絡先区分のsetメソッドです。
     * 
     * @param renrakusakiKubunNo 連絡先区分
     */
    public void setRenrakusakiKubunNo(RString renrakusakiKubunNo) {
        this.renrakusakiKubunNo = renrakusakiKubunNo;
    }

    /**
     * 支所コードのgetメソッドです。
     * 
     * @return 支所コード
     */
    @CheckForNull
    public ShishoCode getShishoCode() {
        return shishoCode;
    }

    /**
     * 支所コードのsetメソッドです。
     * 
     * @param shishoCode 支所コード
     */
    public void setShishoCode(ShishoCode shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * 連絡先氏名のgetメソッドです。
     * 
     * @return 連絡先氏名
     */
    @CheckForNull
    public AtenaMeisho getRenrakusakiShimei() {
        return renrakusakiShimei;
    }

    /**
     * 連絡先氏名のsetメソッドです。
     * 
     * @param renrakusakiShimei 連絡先氏名
     */
    public void setRenrakusakiShimei(AtenaMeisho renrakusakiShimei) {
        this.renrakusakiShimei = renrakusakiShimei;
    }

    /**
     * 連絡先氏名カナのgetメソッドです。
     * 
     * @return 連絡先氏名カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getRenrakusakiKanaSimei() {
        return renrakusakiKanaSimei;
    }

    /**
     * 連絡先氏名カナのsetメソッドです。
     * 
     * @param renrakusakiKanaSimei 連絡先氏名カナ
     */
    public void setRenrakusakiKanaSimei(AtenaKanaMeisho renrakusakiKanaSimei) {
        this.renrakusakiKanaSimei = renrakusakiKanaSimei;
    }

    /**
     * 連絡先続柄のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：連絡先続柄コード）
     * 
     * @return 連絡先続柄
     */
    @CheckForNull
    public RString getRenrakusakiTuzukigara() {
        return renrakusakiTuzukigara;
    }

    /**
     * 連絡先続柄のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：連絡先続柄コード）
     * 
     * @param renrakusakiTuzukigara 連絡先続柄
     */
    public void setRenrakusakiTuzukigara(RString renrakusakiTuzukigara) {
        this.renrakusakiTuzukigara = renrakusakiTuzukigara;
    }

    /**
     * 連絡先郵便番号のgetメソッドです。
     * 
     * @return 連絡先郵便番号
     */
    @CheckForNull
    public YubinNo getRenrakusakiYubinNo() {
        return renrakusakiYubinNo;
    }

    /**
     * 連絡先郵便番号のsetメソッドです。
     * 
     * @param renrakusakiYubinNo 連絡先郵便番号
     */
    public void setRenrakusakiYubinNo(YubinNo renrakusakiYubinNo) {
        this.renrakusakiYubinNo = renrakusakiYubinNo;
    }

    /**
     * 連絡先住所のgetメソッドです。
     * 
     * @return 連絡先住所
     */
    @CheckForNull
    public AtenaJusho getRenrakusakiJusho() {
        return renrakusakiJusho;
    }

    /**
     * 連絡先住所のsetメソッドです。
     * 
     * @param renrakusakiJusho 連絡先住所
     */
    public void setRenrakusakiJusho(AtenaJusho renrakusakiJusho) {
        this.renrakusakiJusho = renrakusakiJusho;
    }

    /**
     * 連絡先電話番号のgetメソッドです。
     * 
     * @return 連絡先電話番号
     */
    @CheckForNull
    public TelNo getRenrakusakiTelNo() {
        return renrakusakiTelNo;
    }

    /**
     * 連絡先電話番号のsetメソッドです。
     * 
     * @param renrakusakiTelNo 連絡先電話番号
     */
    public void setRenrakusakiTelNo(TelNo renrakusakiTelNo) {
        this.renrakusakiTelNo = renrakusakiTelNo;
    }

    /**
     * 連絡先携帯番号のgetメソッドです。
     * 
     * @return 連絡先携帯番号
     */
    @CheckForNull
    public TelNo getRenrakusakiKeitaiTelNo() {
        return renrakusakiKeitaiTelNo;
    }

    /**
     * 連絡先携帯番号のsetメソッドです。
     * 
     * @param renrakusakiKeitaiTelNo 連絡先携帯番号
     */
    public void setRenrakusakiKeitaiTelNo(TelNo renrakusakiKeitaiTelNo) {
        this.renrakusakiKeitaiTelNo = renrakusakiKeitaiTelNo;
    }

    /**
     * 優先順位のgetメソッドです。
     * 
     * @return 優先順位
     */
    @CheckForNull
    public int getPriority() {
        return priority;
    }

    /**
     * 優先順位のsetメソッドです。
     * 
     * @param priority 優先順位
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5150RenrakusakiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5150RenrakusakiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5150RenrakusakiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.renban != other.renban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5150RenrakusakiJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.renban = entity.renban;
        this.renrakusakiKubunNo = entity.renrakusakiKubunNo;
        this.shishoCode = entity.shishoCode;
        this.renrakusakiShimei = entity.renrakusakiShimei;
        this.renrakusakiKanaSimei = entity.renrakusakiKanaSimei;
        this.renrakusakiTuzukigara = entity.renrakusakiTuzukigara;
        this.renrakusakiYubinNo = entity.renrakusakiYubinNo;
        this.renrakusakiJusho = entity.renrakusakiJusho;
        this.renrakusakiTelNo = entity.renrakusakiTelNo;
        this.renrakusakiKeitaiTelNo = entity.renrakusakiKeitaiTelNo;
        this.priority = entity.priority;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, renban, renrakusakiKubunNo, shishoCode, renrakusakiShimei, renrakusakiKanaSimei, renrakusakiTuzukigara, renrakusakiYubinNo, renrakusakiJusho, renrakusakiTelNo, renrakusakiKeitaiTelNo, priority);
    }

// </editor-fold>


}
