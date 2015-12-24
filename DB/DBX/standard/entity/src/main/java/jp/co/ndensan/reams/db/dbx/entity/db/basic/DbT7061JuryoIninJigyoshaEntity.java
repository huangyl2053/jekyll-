package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 受領委任事業者テーブルのエンティティクラスです。
 * <br/> 受領委任契約をしている事業者を管理します。
 */
public class DbT7061JuryoIninJigyoshaEntity extends DbTableEntityBase<DbT7061JuryoIninJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7061JuryoIninJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private FlexibleDate keiyakuKaishiYMD;
    private FlexibleDate keiyakuShuryoYMD;
    @PrimaryKey
    private RString serviceShubetsuCode;
    private YubinNo jigyoshaYubinNo;
    private AtenaJusho jigyoshaJusho;
    private TelNo jigyoshaTelNo;
    private TelNo jigyoshaFaxNo;

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
     * 受領委任契約事業者番号のgetメソッドです。
     * 
     * @return 受領委任契約事業者番号
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 受領委任契約事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 受領委任契約事業者番号
     */
    public void setJigyoshaNo(@Nonnull KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 受領委任契約開始日のgetメソッドです。
     * 
     * @return 受領委任契約開始日
     */
    public FlexibleDate getKeiyakuKaishiYMD() {
        return keiyakuKaishiYMD;
    }

    /**
     * 受領委任契約開始日のsetメソッドです。
     * 
     * @param keiyakuKaishiYMD 受領委任契約開始日
     */
    public void setKeiyakuKaishiYMD(@Nonnull FlexibleDate keiyakuKaishiYMD) {
        this.keiyakuKaishiYMD = keiyakuKaishiYMD;
    }

    /**
     * 受領委任契約終了日のgetメソッドです。
     * 
     * @return 受領委任契約終了日
     */
    @CheckForNull
    public FlexibleDate getKeiyakuShuryoYMD() {
        return keiyakuShuryoYMD;
    }

    /**
     * 受領委任契約終了日のsetメソッドです。
     * 
     * @param keiyakuShuryoYMD 受領委任契約終了日
     */
    public void setKeiyakuShuryoYMD(FlexibleDate keiyakuShuryoYMD) {
        this.keiyakuShuryoYMD = keiyakuShuryoYMD;
    }

    /**
     * 契約サービス種別のgetメソッドです。
     * <br/>
     * <br/>＜Enumで管理＞
     * <br/>1：特定福祉用具販売事業者
     * <br/>2：住宅改修事業者
     * <br/>3：サービス提供事業者
     * 
     * @return 契約サービス種別
     */
    public RString getServiceShubetsuCode() {
        return serviceShubetsuCode;
    }

    /**
     * 契約サービス種別のsetメソッドです。
     * <br/>
     * <br/>＜Enumで管理＞
     * <br/>1：特定福祉用具販売事業者
     * <br/>2：住宅改修事業者
     * <br/>3：サービス提供事業者
     * 
     * @param serviceShubetsuCode 契約サービス種別
     */
    public void setServiceShubetsuCode(@Nonnull RString serviceShubetsuCode) {
        this.serviceShubetsuCode = serviceShubetsuCode;
    }

    /**
     * 契約事業者郵便番号のgetメソッドです。
     * 
     * @return 契約事業者郵便番号
     */
    @CheckForNull
    public YubinNo getJigyoshaYubinNo() {
        return jigyoshaYubinNo;
    }

    /**
     * 契約事業者郵便番号のsetメソッドです。
     * 
     * @param jigyoshaYubinNo 契約事業者郵便番号
     */
    public void setJigyoshaYubinNo(YubinNo jigyoshaYubinNo) {
        this.jigyoshaYubinNo = jigyoshaYubinNo;
    }

    /**
     * 契約事業者住所のgetメソッドです。
     * 
     * @return 契約事業者住所
     */
    @CheckForNull
    public AtenaJusho getJigyoshaJusho() {
        return jigyoshaJusho;
    }

    /**
     * 契約事業者住所のsetメソッドです。
     * 
     * @param jigyoshaJusho 契約事業者住所
     */
    public void setJigyoshaJusho(AtenaJusho jigyoshaJusho) {
        this.jigyoshaJusho = jigyoshaJusho;
    }

    /**
     * 契約事業者電話番号のgetメソッドです。
     * 
     * @return 契約事業者電話番号
     */
    @CheckForNull
    public TelNo getJigyoshaTelNo() {
        return jigyoshaTelNo;
    }

    /**
     * 契約事業者電話番号のsetメソッドです。
     * 
     * @param jigyoshaTelNo 契約事業者電話番号
     */
    public void setJigyoshaTelNo(TelNo jigyoshaTelNo) {
        this.jigyoshaTelNo = jigyoshaTelNo;
    }

    /**
     * 契約事業者FAX番号のgetメソッドです。
     * 
     * @return 契約事業者FAX番号
     */
    @CheckForNull
    public TelNo getJigyoshaFaxNo() {
        return jigyoshaFaxNo;
    }

    /**
     * 契約事業者FAX番号のsetメソッドです。
     * 
     * @param jigyoshaFaxNo 契約事業者FAX番号
     */
    public void setJigyoshaFaxNo(TelNo jigyoshaFaxNo) {
        this.jigyoshaFaxNo = jigyoshaFaxNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7061JuryoIninJigyoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7061JuryoIninJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7061JuryoIninJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.keiyakuKaishiYMD, other.keiyakuKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.serviceShubetsuCode, other.serviceShubetsuCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7061JuryoIninJigyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.keiyakuKaishiYMD = entity.keiyakuKaishiYMD;
        this.keiyakuShuryoYMD = entity.keiyakuShuryoYMD;
        this.serviceShubetsuCode = entity.serviceShubetsuCode;
        this.jigyoshaYubinNo = entity.jigyoshaYubinNo;
        this.jigyoshaJusho = entity.jigyoshaJusho;
        this.jigyoshaTelNo = entity.jigyoshaTelNo;
        this.jigyoshaFaxNo = entity.jigyoshaFaxNo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, keiyakuKaishiYMD, keiyakuShuryoYMD, serviceShubetsuCode, jigyoshaYubinNo, jigyoshaJusho, jigyoshaTelNo, jigyoshaFaxNo);
    }

// </editor-fold>
}
