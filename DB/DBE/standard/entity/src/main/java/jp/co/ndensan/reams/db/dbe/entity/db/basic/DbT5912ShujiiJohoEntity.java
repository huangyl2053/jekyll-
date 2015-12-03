package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 主治医情報テーブルのエンティティクラスです。
 */
public class DbT5912ShujiiJohoEntity extends DbTableEntityBase<DbT5912ShujiiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5912ShujiiJoho");

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
    private RString shujiiIryokikanCode;
    @PrimaryKey
    private RString shujiiCode;
    private RString shujiiName;
    private AtenaKanaMeisho shujiiKana;
    private Code seibetsu;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString shinryokaName;
    private boolean shiteiiFlag;
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
     * <br/>
     * <br/>主治医医療機関情報
     *
     * @return 主治医医療機関コード
     */
    public RString getShujiiIryokikanCode() {
        return shujiiIryokikanCode;
    }

    /**
     * 主治医医療機関コードのsetメソッドです。
     * <br/>
     * <br/>主治医医療機関情報
     *
     * @param shujiiIryokikanCode 主治医医療機関コード
     */
    public void setShujiiIryokikanCode(@Nonnull RString shujiiIryokikanCode) {
        this.shujiiIryokikanCode = shujiiIryokikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * <br/>
     * <br/>主治医コード
     *
     * @return 主治医コード
     */
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * <br/>
     * <br/>主治医コード
     *
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(@Nonnull RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 主治医氏名のgetメソッドです。
     *
     * @return 主治医氏名
     */
    public RString getShujiiName() {
        return shujiiName;
    }

    /**
     * 主治医氏名のsetメソッドです。
     *
     * @param shujiiName 主治医氏名
     */
    public void setShujiiName(@Nonnull RString shujiiName) {
        this.shujiiName = shujiiName;
    }

    /**
     * 主治医カナのgetメソッドです。
     *
     * @return 主治医カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getShujiiKana() {
        return shujiiKana;
    }

    /**
     * 主治医カナのsetメソッドです。
     *
     * @param shujiiKana 主治医カナ
     */
    public void setShujiiKana(AtenaKanaMeisho shujiiKana) {
        this.shujiiKana = shujiiKana;
    }

    /**
     * 性別のgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     *
     * @return 性別
     */
    @CheckForNull
    public Code getSeibetsu() {
        return seibetsu;
    }

    /**
     * 性別のsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     *
     * @param seibetsu 性別
     */
    public void setSeibetsu(Code seibetsu) {
        this.seibetsu = seibetsu;
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
     * 診療科名称のgetメソッドです。
     *
     * @return 診療科名称
     */
    @CheckForNull
    public RString getShinryokaName() {
        return shinryokaName;
    }

    /**
     * 診療科名称のsetメソッドです。
     *
     * @param shinryokaName 診療科名称
     */
    public void setShinryokaName(RString shinryokaName) {
        this.shinryokaName = shinryokaName;
    }

    /**
     * 指定医フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：指定医フラグ）True：指定医になれる、False：なれない
     *
     * @return 指定医フラグ
     */
    @CheckForNull
    public boolean getShiteiiFlag() {
        return shiteiiFlag;
    }

    /**
     * 指定医フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：指定医フラグ）True：指定医になれる、False：なれない
     *
     * @param shiteiiFlag 指定医フラグ
     */
    public void setShiteiiFlag(boolean shiteiiFlag) {
        this.shiteiiFlag = shiteiiFlag;
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
     * このエンティティの主キーが他の{@literal DbT5912ShujiiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5912ShujiiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5912ShujiiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shujiiIryokikanCode, other.shujiiIryokikanCode)) {
            return false;
        }
        if (!Objects.equals(this.shujiiCode, other.shujiiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT5912ShujiiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.shujiiIryokikanCode = entity.shujiiIryokikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.shujiiName = entity.shujiiName;
        this.shujiiKana = entity.shujiiKana;
        this.seibetsu = entity.seibetsu;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.shinryokaName = entity.shinryokaName;
        this.shiteiiFlag = entity.shiteiiFlag;
        this.jokyoFlag = entity.jokyoFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, shujiiIryokikanCode, shujiiCode, shujiiName, shujiiKana, seibetsu, yubinNo, jusho, telNo, faxNo, shinryokaName, shiteiiFlag, jokyoFlag);
    }

// </editor-fold>
}
