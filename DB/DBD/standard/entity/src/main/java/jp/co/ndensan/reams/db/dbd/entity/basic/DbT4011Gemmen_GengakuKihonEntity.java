package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 減免・減額基本テーブルのエンティティクラスです。
 */
public class DbT4011Gemmen_GengakuKihonEntity extends DbTableEntityBase<DbT4011Gemmen_GengakuKihonEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4011Gemmen_GengakuKihon");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate tekiyoKaishiYMD;
    private FlexibleDate tekiyoShuryoYMD;
    private RString ketteiKubun;
    private RString hiShoninRiyu;

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
     * 申請年月日のgetメソッドです。
     * 
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * 
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 決定年月日のgetメソッドです。
     * 
     * @return 決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 決定年月日のsetメソッドです。
     * 
     * @param ketteiYMD 決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 適用開始年月日のgetメソッドです。
     * 
     * @return 適用開始年月日
     */
    public FlexibleDate getTekiyoKaishiYMD() {
        return tekiyoKaishiYMD;
    }

    /**
     * 適用開始年月日のsetメソッドです。
     * 
     * @param tekiyoKaishiYMD 適用開始年月日
     */
    public void setTekiyoKaishiYMD(FlexibleDate tekiyoKaishiYMD) {
        this.tekiyoKaishiYMD = tekiyoKaishiYMD;
    }

    /**
     * 適用終了年月日のgetメソッドです。
     * 
     * @return 適用終了年月日
     */
    public FlexibleDate getTekiyoShuryoYMD() {
        return tekiyoShuryoYMD;
    }

    /**
     * 適用終了年月日のsetメソッドです。
     * 
     * @param tekiyoShuryoYMD 適用終了年月日
     */
    public void setTekiyoShuryoYMD(FlexibleDate tekiyoShuryoYMD) {
        this.tekiyoShuryoYMD = tekiyoShuryoYMD;
    }

    /**
     * 決定区分のgetメソッドです。
     * 
     * @return 決定区分
     */
    public RString getKetteiKubun() {
        return ketteiKubun;
    }

    /**
     * 決定区分のsetメソッドです。
     * 
     * @param ketteiKubun 決定区分
     */
    public void setKetteiKubun(RString ketteiKubun) {
        this.ketteiKubun = ketteiKubun;
    }

    /**
     * 非承認理由のgetメソッドです。
     * 
     * @return 非承認理由
     */
    public RString getHiShoninRiyu() {
        return hiShoninRiyu;
    }

    /**
     * 非承認理由のsetメソッドです。
     * 
     * @param hiShoninRiyu 非承認理由
     */
    public void setHiShoninRiyu(RString hiShoninRiyu) {
        this.hiShoninRiyu = hiShoninRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4011Gemmen_GengakuKihonEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4011Gemmen_GengakuKihonEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4011Gemmen_GengakuKihonEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4011Gemmen_GengakuKihonEntity entity) {
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.tekiyoKaishiYMD = entity.tekiyoKaishiYMD;
        this.tekiyoShuryoYMD = entity.tekiyoShuryoYMD;
        this.ketteiKubun = entity.ketteiKubun;
        this.hiShoninRiyu = entity.hiShoninRiyu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseiYMD, ketteiYMD, tekiyoKaishiYMD, tekiyoShuryoYMD, ketteiKubun, hiShoninRiyu);
    }

// </editor-fold>
}
