package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT7111ServiceShuruiShikyuGendoGakuの項目定義クラスです
 *
 */
public class DbT7111ServiceShuruiShikyuGendoGakuEntity extends DbTableEntityBase<DbT7111ServiceShuruiShikyuGendoGakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7111ServiceShuruiShikyuGendoGaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ServiceShuruiCode serviceShuruiCode;
    @PrimaryKey
    private RString yoKaigoJotaiKubun;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishuYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private FlexibleYearMonth tekiyoShuryuYM;
    private Decimal shikyuGendoTaniSu;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getServiceShuruiCode
     *
     * @return serviceShuruiCode
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * setServiceShuruiCode
     *
     * @param serviceShuruiCode serviceShuruiCode
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * getYoKaigoJotaiKubun
     *
     * @return yoKaigoJotaiKubun
     */
    public RString getYoKaigoJotaiKubun() {
        return yoKaigoJotaiKubun;
    }

    /**
     * setYoKaigoJotaiKubun
     *
     * @param yoKaigoJotaiKubun yoKaigoJotaiKubun
     */
    public void setYoKaigoJotaiKubun(RString yoKaigoJotaiKubun) {
        this.yoKaigoJotaiKubun = yoKaigoJotaiKubun;
    }

    /**
     * getTekiyoKaishuYM
     *
     * @return tekiyoKaishuYM
     */
    public FlexibleYearMonth getTekiyoKaishuYM() {
        return tekiyoKaishuYM;
    }

    /**
     * setTekiyoKaishuYM
     *
     * @param tekiyoKaishuYM tekiyoKaishuYM
     */
    public void setTekiyoKaishuYM(FlexibleYearMonth tekiyoKaishuYM) {
        this.tekiyoKaishuYM = tekiyoKaishuYM;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getTekiyoShuryuYM
     *
     * @return tekiyoShuryuYM
     */
    public FlexibleYearMonth getTekiyoShuryuYM() {
        return tekiyoShuryuYM;
    }

    /**
     * setTekiyoShuryuYM
     *
     * @param tekiyoShuryuYM tekiyoShuryuYM
     */
    public void setTekiyoShuryuYM(FlexibleYearMonth tekiyoShuryuYM) {
        this.tekiyoShuryuYM = tekiyoShuryuYM;
    }

    /**
     * getShikyuGendoTaniSu
     *
     * @return shikyuGendoTaniSu
     */
    public Decimal getShikyuGendoTaniSu() {
        return shikyuGendoTaniSu;
    }

    /**
     * setShikyuGendoTaniSu
     *
     * @param shikyuGendoTaniSu shikyuGendoTaniSu
     */
    public void setShikyuGendoTaniSu(Decimal shikyuGendoTaniSu) {
        this.shikyuGendoTaniSu = shikyuGendoTaniSu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7111ServiceShuruiShikyuGendoGakuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7111ServiceShuruiShikyuGendoGakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7111ServiceShuruiShikyuGendoGakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.serviceShuruiCode, other.serviceShuruiCode)) {
            return false;
        }
        if (!Objects.equals(this.yoKaigoJotaiKubun, other.yoKaigoJotaiKubun)) {
            return false;
        }
        if (!Objects.equals(this.tekiyoKaishuYM, other.tekiyoKaishuYM)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7111ServiceShuruiShikyuGendoGakuEntity entity) {
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.yoKaigoJotaiKubun = entity.yoKaigoJotaiKubun;
        this.tekiyoKaishuYM = entity.tekiyoKaishuYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.tekiyoShuryuYM = entity.tekiyoShuryuYM;
        this.shikyuGendoTaniSu = entity.shikyuGendoTaniSu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(serviceShuruiCode, yoKaigoJotaiKubun, tekiyoKaishuYM, shoriTimestamp, tekiyoShuryuYM, shikyuGendoTaniSu);
    }

// </editor-fold>
}
