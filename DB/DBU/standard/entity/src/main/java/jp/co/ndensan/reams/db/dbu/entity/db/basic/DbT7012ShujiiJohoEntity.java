package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 主治医情報　継承テーブルのエンティティクラスです。
 */
public class DbT7012ShujiiJohoEntity extends DbTableEntityBase<DbT7012ShujiiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7012ShujiiJoho");

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
    private RString kaigoIryokikanCode;
    @PrimaryKey
    private RString kaigoIshiCode;
    private RString iryokikanCode;
    private RString ishiShikibetsuNo;
    private RString shujiiJokyo;
    private YubinNo yubinNo;
    private AtenaJusho jusho;
    private TelNo telNo;
    private TelNo faxNo;

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
     * 介護医療機関コードのgetメソッドです。
     * 
     * @return 介護医療機関コード
     */
    public RString getKaigoIryokikanCode() {
        return kaigoIryokikanCode;
    }

    /**
     * 介護医療機関コードのsetメソッドです。
     * 
     * @param kaigoIryokikanCode 介護医療機関コード
     */
    public void setKaigoIryokikanCode(RString kaigoIryokikanCode) {
        this.kaigoIryokikanCode = kaigoIryokikanCode;
    }

    /**
     * 介護医師コードのgetメソッドです。
     * 
     * @return 介護医師コード
     */
    public RString getKaigoIshiCode() {
        return kaigoIshiCode;
    }

    /**
     * 介護医師コードのsetメソッドです。
     * 
     * @param kaigoIshiCode 介護医師コード
     */
    public void setKaigoIshiCode(RString kaigoIshiCode) {
        this.kaigoIshiCode = kaigoIshiCode;
    }

    /**
     * 医療機関コードのgetメソッドです。
     * 
     * @return 医療機関コード
     */
    public RString getIryokikanCode() {
        return iryokikanCode;
    }

    /**
     * 医療機関コードのsetメソッドです。
     * 
     * @param iryokikanCode 医療機関コード
     */
    public void setIryokikanCode(RString iryokikanCode) {
        this.iryokikanCode = iryokikanCode;
    }

    /**
     * 医師コードのgetメソッドです。
     * 
     * @return 医師コード
     */
    public RString getIshiShikibetsuNo() {
        return ishiShikibetsuNo;
    }

    /**
     * 医師コードのsetメソッドです。
     * 
     * @param ishiShikibetsuNo 医師コード
     */
    public void setIshiShikibetsuNo(RString ishiShikibetsuNo) {
        this.ishiShikibetsuNo = ishiShikibetsuNo;
    }

    /**
     * 医師の状況のgetメソッドです。
     * 
     * @return 医師の状況
     */
    public RString getShujiiJokyo() {
        return shujiiJokyo;
    }

    /**
     * 医師の状況のsetメソッドです。
     * 
     * @param shujiiJokyo 医師の状況
     */
    public void setShujiiJokyo(RString shujiiJokyo) {
        this.shujiiJokyo = shujiiJokyo;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
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
    public AtenaJusho getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param jusho 住所
     */
    public void setJusho(AtenaJusho jusho) {
        this.jusho = jusho;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
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
     * このエンティティの主キーが他の{@literal DbT7012ShujiiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7012ShujiiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7012ShujiiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoIryokikanCode, other.kaigoIryokikanCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoIshiCode, other.kaigoIshiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7012ShujiiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.kaigoIryokikanCode = entity.kaigoIryokikanCode;
        this.kaigoIshiCode = entity.kaigoIshiCode;
        this.iryokikanCode = entity.iryokikanCode;
        this.ishiShikibetsuNo = entity.ishiShikibetsuNo;
        this.shujiiJokyo = entity.shujiiJokyo;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, kaigoIryokikanCode, kaigoIshiCode, iryokikanCode, ishiShikibetsuNo, shujiiJokyo, yubinNo, jusho, telNo, faxNo);
    }

// </editor-fold>
}
