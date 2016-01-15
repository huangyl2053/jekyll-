package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 共同処理用受給者異動基本送付テーブルのエンティティクラスです。
 */
public class DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity extends DbTableEntityBase<DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3002KyodoShoriyoJukyushaIdoKihonSofu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private RString idoKubunCode;
    @PrimaryKey
    private RString jukyushaIdoJiyu;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private RString hiHokenshaName;
    private YubinNo YubinNo;
    private RString ddressKana;
    private RString address;
    private TelNo telNo;
    private RString chohyoOutputJunjyoCode;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;

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
     * 異動年月日のgetメソッドです。
     * 
     * @return 異動年月日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動年月日のsetメソッドです。
     * 
     * @param idoYMD 異動年月日
     */
    public void setIdoYMD(@Nonnull FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 異動区分コードのgetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:終了
     * 
     * @return 異動区分コード
     */
    public RString getIdoKubunCode() {
        return idoKubunCode;
    }

    /**
     * 異動区分コードのsetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:終了
     * 
     * @param idoKubunCode 異動区分コード
     */
    public void setIdoKubunCode(@Nonnull RString idoKubunCode) {
        this.idoKubunCode = idoKubunCode;
    }

    /**
     * 受給者異動事由のgetメソッドです。
     * <br/>
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     * 
     * @return 受給者異動事由
     */
    public RString getJukyushaIdoJiyu() {
        return jukyushaIdoJiyu;
    }

    /**
     * 受給者異動事由のsetメソッドです。
     * <br/>
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     * 
     * @param jukyushaIdoJiyu 受給者異動事由
     */
    public void setJukyushaIdoJiyu(@Nonnull RString jukyushaIdoJiyu) {
        this.jukyushaIdoJiyu = jukyushaIdoJiyu;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     * 
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
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
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 被保険者氏名のgetメソッドです。
     * <br/>
     * <br/>氏名（漢字）
     * 
     * @return 被保険者氏名
     */
    @CheckForNull
    public RString getHiHokenshaName() {
        return hiHokenshaName;
    }

    /**
     * 被保険者氏名のsetメソッドです。
     * <br/>
     * <br/>氏名（漢字）
     * 
     * @param hiHokenshaName 被保険者氏名
     */
    public void setHiHokenshaName(RString hiHokenshaName) {
        this.hiHokenshaName = hiHokenshaName;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return YubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param YubinNo 郵便番号
     */
    public void setYubinNo(YubinNo YubinNo) {
        this.YubinNo = YubinNo;
    }

    /**
     * 住所カナのgetメソッドです。
     * 
     * @return 住所カナ
     */
    @CheckForNull
    public RString getDdressKana() {
        return ddressKana;
    }

    /**
     * 住所カナのsetメソッドです。
     * 
     * @param ddressKana 住所カナ
     */
    public void setDdressKana(RString ddressKana) {
        this.ddressKana = ddressKana;
    }

    /**
     * 住所のgetメソッドです。
     * <br/>
     * <br/>住所（漢字）
     * 
     * @return 住所
     */
    @CheckForNull
    public RString getAddress() {
        return address;
    }

    /**
     * 住所のsetメソッドです。
     * <br/>
     * <br/>住所（漢字）
     * 
     * @param address 住所
     */
    public void setAddress(RString address) {
        this.address = address;
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
     * 帳票出力順序コードのgetメソッドです。
     * 
     * @return 帳票出力順序コード
     */
    @CheckForNull
    public RString getChohyoOutputJunjyoCode() {
        return chohyoOutputJunjyoCode;
    }

    /**
     * 帳票出力順序コードのsetメソッドです。
     * 
     * @param chohyoOutputJunjyoCode 帳票出力順序コード
     */
    public void setChohyoOutputJunjyoCode(RString chohyoOutputJunjyoCode) {
        this.chohyoOutputJunjyoCode = chohyoOutputJunjyoCode;
    }

    /**
     * 訂正連絡票フラグのgetメソッドです。
     * <br/>
     * <br/>異動or訂正 訂正ならtrue
     * 
     * @return 訂正連絡票フラグ
     */
    @CheckForNull
    public boolean getTeiseiRenrakuhyoFlag() {
        return teiseiRenrakuhyoFlag;
    }

    /**
     * 訂正連絡票フラグのsetメソッドです。
     * <br/>
     * <br/>異動or訂正 訂正ならtrue
     * 
     * @param teiseiRenrakuhyoFlag 訂正連絡票フラグ
     */
    public void setTeiseiRenrakuhyoFlag(boolean teiseiRenrakuhyoFlag) {
        this.teiseiRenrakuhyoFlag = teiseiRenrakuhyoFlag;
    }

    /**
     * 送付年月のgetメソッドです。
     * 
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     * 
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
            return false;
        }
        if (!Objects.equals(this.idoKubunCode, other.idoKubunCode)) {
            return false;
        }
        if (!Objects.equals(this.jukyushaIdoJiyu, other.jukyushaIdoJiyu)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
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
    public void shallowCopy(DbT3002KyodoShoriyoJukyushaIdoKihonSofuEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hiHokenshaName = entity.hiHokenshaName;
        this.YubinNo = entity.YubinNo;
        this.ddressKana = entity.ddressKana;
        this.address = entity.address;
        this.telNo = entity.telNo;
        this.chohyoOutputJunjyoCode = entity.chohyoOutputJunjyoCode;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, rirekiNo, hiHokenshaName, YubinNo, ddressKana, address, telNo, chohyoOutputJunjyoCode, teiseiRenrakuhyoFlag, sofuYM);
    }

// </editor-fold>

}
