package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * サービス種類支給限度額テーブルのエンティティクラスです。
 */
public class DbT7111ServiceShuruiShikyuGendoGakuEntity extends DbTableEntityBase<DbT7111ServiceShuruiShikyuGendoGakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
    private int rirekiNo;
    private FlexibleYearMonth tekiyoShuryuYM;
    private Decimal shikyuGendoTaniSu;

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
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
    }

    /**
     * 要介護状態区分のgetメソッドです。
     *
     * @return 要介護状態区分
     */
    public RString getYoKaigoJotaiKubun() {
        return yoKaigoJotaiKubun;
    }

    /**
     * 要介護状態区分のsetメソッドです。
     *
     * @param yoKaigoJotaiKubun 要介護状態区分
     */
    public void setYoKaigoJotaiKubun(RString yoKaigoJotaiKubun) {
        this.yoKaigoJotaiKubun = yoKaigoJotaiKubun;
    }

    /**
     * 適用開始年月のgetメソッドです。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth getTekiyoKaishuYM() {
        return tekiyoKaishuYM;
    }

    /**
     * 適用開始年月のsetメソッドです。
     *
     * @param tekiyoKaishuYM 適用開始年月
     */
    public void setTekiyoKaishuYM(FlexibleYearMonth tekiyoKaishuYM) {
        this.tekiyoKaishuYM = tekiyoKaishuYM;
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
     * 適用終了年月のgetメソッドです。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth getTekiyoShuryuYM() {
        return tekiyoShuryuYM;
    }

    /**
     * 適用終了年月のsetメソッドです。
     *
     * @param tekiyoShuryuYM 適用終了年月
     */
    public void setTekiyoShuryuYM(FlexibleYearMonth tekiyoShuryuYM) {
        this.tekiyoShuryuYM = tekiyoShuryuYM;
    }

    /**
     * 支給限度単位数のgetメソッドです。
     *
     * @return 支給限度単位数
     */
    public Decimal getShikyuGendoTaniSu() {
        return shikyuGendoTaniSu;
    }

    /**
     * 支給限度単位数のsetメソッドです。
     *
     * @param shikyuGendoTaniSu 支給限度単位数
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(serviceShuruiCode, yoKaigoJotaiKubun, tekiyoKaishuYM, rirekiNo, tekiyoShuryuYM, shikyuGendoTaniSu);
    }

// </editor-fold>
}
