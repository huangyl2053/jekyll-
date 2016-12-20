package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.ur.urz.definition.core.iryokikan.IryoKikanCode;

/**
 * 主治医医療機関情報（子）テーブルのエンティティクラスです。
 */
public class DbT4911ShujiiIryoKikanJohoEntity extends DbTableEntityBase<DbT4911ShujiiIryoKikanJohoEntity> implements IDbAccessable, IShujiiIryoKikanJohoEntity {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4911ShujiiIryoKikanJoho");

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
    private ShujiiIryokikanCode shujiiIryokikanCode;
    private IryoKikanCode iryokikanCode;
    private RString iryoKikanMeisho;
    private RString iryoKikanMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString daihyoshaName;
    private RString daihyoshaNameKana;
    private boolean jokyoFlag;

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
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 主治医医療機関コードのgetメソッドです。
     * 
     * @return 主治医医療機関コード
     */
    public ShujiiIryokikanCode getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * 
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public void setShujiiIryokikanCode(@Nonnull ShujiiIryokikanCode shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * 医療機関コードのgetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     * 
     * @return 医療機関コード
     */
    @CheckForNull
    public IryoKikanCode getIryokikanCode() {
        return iryokikanCode;
    }

    /**
     * 医療機関コードのsetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     * 
     * @param iryokikanCode 医療機関コード
     */
    public void setIryokikanCode(IryoKikanCode iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
    }

    /**
     * 医療機関名称のgetメソッドです。
     * 
     * @return 医療機関名称
     */
    @CheckForNull
    public RString getIryoKikanMeisho() {
        return iryoKikanMeisho;
    }

    /**
     * 医療機関名称のsetメソッドです。
     * 
     * @param iryoKikanMeisho 医療機関名称
     */
    public void setIryoKikanMeisho(RString iryoKikanMeisho) {
        this.iryoKikanMeisho = iryoKikanMeisho;
    }

    /**
     * 医療機関名称カナのgetメソッドです。
     * 
     * @return 医療機関名称カナ
     */
    @CheckForNull
    public RString getIryoKikanMeishoKana() {
        return iryoKikanMeishoKana;
    }

    /**
     * 医療機関名称カナのsetメソッドです。
     * 
     * @param iryoKikanMeishoKana 医療機関名称カナ
     */
    public void setIryoKikanMeishoKana(RString iryoKikanMeishoKana) {
        this.iryoKikanMeishoKana = iryoKikanMeishoKana;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     * 
     * @return 住所
     */
    @CheckForNull
    public RString getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param jusho 住所
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     * 
     * @return FAX番号
     */
    @CheckForNull
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     * 
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 代表者名のgetメソッドです。
     * 
     * @return 代表者名
     */
    @CheckForNull
    public RString getDaihyoshaName() {
        return daihyoshaName;
    }

    /**
     * 代表者名のsetメソッドです。
     * 
     * @param daihyoshaName 代表者名
     */
    public void setDaihyoshaName(RString daihyoshaName) {
        this.daihyoshaName = daihyoshaName;
    }

    /**
     * 代表者名カナのgetメソッドです。
     * 
     * @return 代表者名カナ
     */
    @CheckForNull
    public RString getDaihyoshaNameKana() {
        return daihyoshaNameKana;
    }

    /**
     * 代表者名カナのsetメソッドです。
     * 
     * @param daihyoshaNameKana 代表者名カナ
     */
    public void setDaihyoshaNameKana(RString daihyoshaNameKana) {
        this.daihyoshaNameKana = daihyoshaNameKana;
    }

    /**
     * 状況フラグのgetメソッドです。
     * <br/>
     * <br/>True：有効　False：無効
     * 
     * @return 状況フラグ
     */
    public boolean getJokyoFlag() {
        return jokyoFlag;
    }

    /**
     * 状況フラグのsetメソッドです。
     * <br/>
     * <br/>True：有効　False：無効
     * 
     * @param jokyoFlag 状況フラグ
     */
    public void setJokyoFlag(@Nonnull boolean jokyoFlag) {
        this.jokyoFlag = jokyoFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4911ShujiiIryoKikanJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4911ShujiiIryoKikanJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4911ShujiiIryoKikanJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shujiiIryokikanCode, other.shujiiIryokikanCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4911ShujiiIryoKikanJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.iryokikanCode = entity.iryokikanCode;
        this.iryoKikanMeisho = entity.iryoKikanMeisho;
        this.iryoKikanMeishoKana = entity.iryoKikanMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.daihyoshaName = entity.daihyoshaName;
        this.daihyoshaNameKana = entity.daihyoshaNameKana;
        this.jokyoFlag = entity.jokyoFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shujiiIryokikanCode, iryokikanCode, iryoKikanMeisho, iryoKikanMeishoKana, yubinNo, jusho, telNo, faxNo, daihyoshaName, daihyoshaNameKana, jokyoFlag);
    }

// </editor-fold>

}
