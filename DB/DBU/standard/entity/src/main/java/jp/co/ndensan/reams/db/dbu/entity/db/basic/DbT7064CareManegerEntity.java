package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;

/**
 * 介護支援専門員テーブルのエンティティクラスです。
 * <br/> 介護支援専門員(ケアマネージャー)を管理する。
 */
public class DbT7064CareManegerEntity extends DbTableEntityBase<DbT7064CareManegerEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7064CareManeger");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString kaigoShienSenmoninNo;
    private AtenaMeisho kaigoShienSenmoninMei;
    private AtenaKanaMeisho kaigoShienSenmoninMeiKana;
    private KaigoJigyoshaNo shozokuJigyoshaNo;
    private FlexibleDate yukoKaishiDate;
    private FlexibleDate yukoShuryoDate;

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
     * 介護支援専門員番号のgetメソッドです。
     *
     * @return 介護支援専門員番号
     */
    public RString getKaigoShienSenmoninNo() {
        return kaigoShienSenmoninNo;
    }

    /**
     * 介護支援専門員番号のsetメソッドです。
     *
     * @param kaigoShienSenmoninNo 介護支援専門員番号
     */
    public void setKaigoShienSenmoninNo(RString kaigoShienSenmoninNo) {
        this.kaigoShienSenmoninNo = kaigoShienSenmoninNo;
    }

    /**
     * 介護支援専門員名のgetメソッドです。
     *
     * @return 介護支援専門員名
     */
    public AtenaMeisho getKaigoShienSenmoninMei() {
        return kaigoShienSenmoninMei;
    }

    /**
     * 介護支援専門員名のsetメソッドです。
     *
     * @param kaigoShienSenmoninMei 介護支援専門員名
     */
    public void setKaigoShienSenmoninMei(AtenaMeisho kaigoShienSenmoninMei) {
        this.kaigoShienSenmoninMei = kaigoShienSenmoninMei;
    }

    /**
     * 介護支援専門員名カナのgetメソッドです。
     *
     * @return 介護支援専門員名カナ
     */
    public AtenaKanaMeisho getKaigoShienSenmoninMeiKana() {
        return kaigoShienSenmoninMeiKana;
    }

    /**
     * 介護支援専門員名カナのsetメソッドです。
     *
     * @param kaigoShienSenmoninMeiKana 介護支援専門員名カナ
     */
    public void setKaigoShienSenmoninMeiKana(AtenaKanaMeisho kaigoShienSenmoninMeiKana) {
        this.kaigoShienSenmoninMeiKana = kaigoShienSenmoninMeiKana;
    }

    /**
     * 所属事業者番号のgetメソッドです。
     *
     * @return 所属事業者番号
     */
    public KaigoJigyoshaNo getShozokuJigyoshaNo() {
        return shozokuJigyoshaNo;
    }

    /**
     * 所属事業者番号のsetメソッドです。
     *
     * @param shozokuJigyoshaNo 所属事業者番号
     */
    public void setShozokuJigyoshaNo(KaigoJigyoshaNo shozokuJigyoshaNo) {
        this.shozokuJigyoshaNo = shozokuJigyoshaNo;
    }

    /**
     * 有効開始年月日のgetメソッドです。
     *
     * @return 有効開始年月日
     */
    public FlexibleDate getYukoKaishiDate() {
        return yukoKaishiDate;
    }

    /**
     * 有効開始年月日のsetメソッドです。
     *
     * @param yukoKaishiDate 有効開始年月日
     */
    public void setYukoKaishiDate(FlexibleDate yukoKaishiDate) {
        this.yukoKaishiDate = yukoKaishiDate;
    }

    /**
     * 有効終了年月日のgetメソッドです。
     *
     * @return 有効終了年月日
     */
    public FlexibleDate getYukoShuryoDate() {
        return yukoShuryoDate;
    }

    /**
     * 有効終了年月日のsetメソッドです。
     *
     * @param yukoShuryoDate 有効終了年月日
     */
    public void setYukoShuryoDate(FlexibleDate yukoShuryoDate) {
        this.yukoShuryoDate = yukoShuryoDate;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7064CareManegerEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7064CareManegerEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7064CareManegerEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.kaigoShienSenmoninNo, other.kaigoShienSenmoninNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7064CareManegerEntity entity) {
        this.kaigoShienSenmoninNo = entity.kaigoShienSenmoninNo;
        this.kaigoShienSenmoninMei = entity.kaigoShienSenmoninMei;
        this.kaigoShienSenmoninMeiKana = entity.kaigoShienSenmoninMeiKana;
        this.shozokuJigyoshaNo = entity.shozokuJigyoshaNo;
        this.yukoKaishiDate = entity.yukoKaishiDate;
        this.yukoShuryoDate = entity.yukoShuryoDate;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(kaigoShienSenmoninNo, kaigoShienSenmoninMei, kaigoShienSenmoninMeiKana, shozokuJigyoshaNo, yukoKaishiDate, yukoShuryoDate);
    }

// </editor-fold>
}
