package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 短期入所系支給限度額テーブルのエンティティクラスです。
 */
public class DbT7110TankiNyushoShikyuGendoGakuEntity extends DbTableEntityBase<DbT7110TankiNyushoShikyuGendoGakuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7110TankiNyushoShikyuGendoGaku");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString yoKaigoJotaiKubun;
    @PrimaryKey
    private FlexibleYearMonth tekiyoKaishiYM;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleYearMonth tekiyoShuryoYM;
    private Decimal shikyuGendoNissu;

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
    public FlexibleYearMonth getTekiyoKaishiYM() {
        return tekiyoKaishiYM;
    }

    /**
     * 適用開始年月のsetメソッドです。
     * 
     * @param tekiyoKaishiYM 適用開始年月
     */
    public void setTekiyoKaishiYM(FlexibleYearMonth tekiyoKaishiYM) {
        this.tekiyoKaishiYM = tekiyoKaishiYM;
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
    public FlexibleYearMonth getTekiyoShuryoYM() {
        return tekiyoShuryoYM;
    }

    /**
     * 適用終了年月のsetメソッドです。
     * 
     * @param tekiyoShuryoYM 適用終了年月
     */
    public void setTekiyoShuryoYM(FlexibleYearMonth tekiyoShuryoYM) {
        this.tekiyoShuryoYM = tekiyoShuryoYM;
    }

    /**
     * 支給限度日数のgetメソッドです。
     * 
     * @return 支給限度日数
     */
    public Decimal getShikyuGendoNissu() {
        return shikyuGendoNissu;
    }

    /**
     * 支給限度日数のsetメソッドです。
     * 
     * @param shikyuGendoNissu 支給限度日数
     */
    public void setShikyuGendoNissu(Decimal shikyuGendoNissu) {
        this.shikyuGendoNissu = shikyuGendoNissu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7110TankiNyushoShikyuGendoGakuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7110TankiNyushoShikyuGendoGakuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7110TankiNyushoShikyuGendoGakuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.yoKaigoJotaiKubun, other.yoKaigoJotaiKubun)) {
            return false;
        }
        if (!Objects.equals(this.tekiyoKaishiYM, other.tekiyoKaishiYM)) {
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
    public void shallowCopy(DbT7110TankiNyushoShikyuGendoGakuEntity entity) {
        this.yoKaigoJotaiKubun = entity.yoKaigoJotaiKubun;
        this.tekiyoKaishiYM = entity.tekiyoKaishiYM;
        this.rirekiNo = entity.rirekiNo;
        this.tekiyoShuryoYM = entity.tekiyoShuryoYM;
        this.shikyuGendoNissu = entity.shikyuGendoNissu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(yoKaigoJotaiKubun, tekiyoKaishiYM, rirekiNo, tekiyoShuryoYM, shikyuGendoNissu);
    }

// </editor-fold>
}
