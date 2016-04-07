package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 共同処理用受給者異動高額送付テーブルのエンティティクラスです。
 */
public class DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity extends DbTableEntityBase<DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3004KyodoShoriyoJukyushaIdoKogakuSofu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleDate idoYMD;
    @PrimaryKey
    private int rirekiNo;
    private RString idoKubunCode;
    private RString jukyushaIdoJiyu;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private HihokenshaNo setaiShuyakuNo;
    private RString setaiShotokuKubunCode;
    private RString shotokuKubunCode;
    private boolean roureiFukushiNenkinJukyuAriFlag;
    private boolean riyoshaFutan2DankaiAriFlag;
    private boolean shikyuShinseishoOutputAriFlag;
    private boolean teiseiRenrakuhyoFlag;
    private FlexibleYearMonth sofuYM;
    private RString teiseiKubunCode;
    private FlexibleDate teiseiYMD;
    private boolean logicalDeletedFlag;

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
     * 世帯集約番号のgetメソッドです。
     * <br/>
     * <br/>世帯主被保険者番号（世帯集約番号）
     * 
     * @return 世帯集約番号
     */
    @CheckForNull
    public HihokenshaNo getSetaiShuyakuNo() {
        return setaiShuyakuNo;
    }

    /**
     * 世帯集約番号のsetメソッドです。
     * <br/>
     * <br/>世帯主被保険者番号（世帯集約番号）
     * 
     * @param setaiShuyakuNo 世帯集約番号
     */
    public void setSetaiShuyakuNo(HihokenshaNo setaiShuyakuNo) {
        this.setaiShuyakuNo = setaiShuyakuNo;
    }

    /**
     * 世帯所得区分コードのgetメソッドです。
     * <br/>
     * <br/>1:低所得者等以外,2:市町村民税世帯非課税者等,3:生活保護
     * 
     * @return 世帯所得区分コード
     */
    @CheckForNull
    public RString getSetaiShotokuKubunCode() {
        return setaiShotokuKubunCode;
    }

    /**
     * 世帯所得区分コードのsetメソッドです。
     * <br/>
     * <br/>1:低所得者等以外,2:市町村民税世帯非課税者等,3:生活保護
     * 
     * @param setaiShotokuKubunCode 世帯所得区分コード
     */
    public void setSetaiShotokuKubunCode(RString setaiShotokuKubunCode) {
        this.setaiShotokuKubunCode = setaiShotokuKubunCode;
    }

    /**
     * 所得区分コードのgetメソッドです。
     * <br/>
     * <br/>1:低所得者等以外,2:市町村民税非課税者等,3:生活保護
     * 
     * @return 所得区分コード
     */
    @CheckForNull
    public RString getShotokuKubunCode() {
        return shotokuKubunCode;
    }

    /**
     * 所得区分コードのsetメソッドです。
     * <br/>
     * <br/>1:低所得者等以外,2:市町村民税非課税者等,3:生活保護
     * 
     * @param shotokuKubunCode 所得区分コード
     */
    public void setShotokuKubunCode(RString shotokuKubunCode) {
        this.shotokuKubunCode = shotokuKubunCode;
    }

    /**
     * 老齢福祉年金受給有フラグのgetメソッドです。
     * <br/>
     * <br/>1:受給無し,2:受給有り
     * 
     * @return 老齢福祉年金受給有フラグ
     */
    @CheckForNull
    public boolean getRoureiFukushiNenkinJukyuAriFlag() {
        return roureiFukushiNenkinJukyuAriFlag;
    }

    /**
     * 老齢福祉年金受給有フラグのsetメソッドです。
     * <br/>
     * <br/>1:受給無し,2:受給有り
     * 
     * @param roureiFukushiNenkinJukyuAriFlag 老齢福祉年金受給有フラグ
     */
    public void setRoureiFukushiNenkinJukyuAriFlag(boolean roureiFukushiNenkinJukyuAriFlag) {
        this.roureiFukushiNenkinJukyuAriFlag = roureiFukushiNenkinJukyuAriFlag;
    }

    /**
     * 利用者負担第２段階有フラグのgetメソッドです。
     * <br/>
     * <br/>1:該当無し,2:該当有り
     * 
     * @return 利用者負担第２段階有フラグ
     */
    @CheckForNull
    public boolean getRiyoshaFutan2DankaiAriFlag() {
        return riyoshaFutan2DankaiAriFlag;
    }

    /**
     * 利用者負担第２段階有フラグのsetメソッドです。
     * <br/>
     * <br/>1:該当無し,2:該当有り
     * 
     * @param riyoshaFutan2DankaiAriFlag 利用者負担第２段階有フラグ
     */
    public void setRiyoshaFutan2DankaiAriFlag(boolean riyoshaFutan2DankaiAriFlag) {
        this.riyoshaFutan2DankaiAriFlag = riyoshaFutan2DankaiAriFlag;
    }

    /**
     * 支給申請書出力有フラグのgetメソッドです。
     * <br/>
     * <br/>1:出力無し,2:出力有り
     * 
     * @return 支給申請書出力有フラグ
     */
    @CheckForNull
    public boolean getShikyuShinseishoOutputAriFlag() {
        return shikyuShinseishoOutputAriFlag;
    }

    /**
     * 支給申請書出力有フラグのsetメソッドです。
     * <br/>
     * <br/>1:出力無し,2:出力有り
     * 
     * @param shikyuShinseishoOutputAriFlag 支給申請書出力有フラグ
     */
    public void setShikyuShinseishoOutputAriFlag(boolean shikyuShinseishoOutputAriFlag) {
        this.shikyuShinseishoOutputAriFlag = shikyuShinseishoOutputAriFlag;
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
     * 訂正区分コードのgetメソッドです。
     * <br/>
     * <br/>2：修正、3：削除
     * 
     * @return 訂正区分コード
     */
    @CheckForNull
    public RString getTeiseiKubunCode() {
        return teiseiKubunCode;
    }

    /**
     * 訂正区分コードのsetメソッドです。
     * <br/>
     * <br/>2：修正、3：削除
     * 
     * @param teiseiKubunCode 訂正区分コード
     */
    public void setTeiseiKubunCode(RString teiseiKubunCode) {
        this.teiseiKubunCode = teiseiKubunCode;
    }

    /**
     * 訂正年月日のgetメソッドです。
     * 
     * @return 訂正年月日
     */
    @CheckForNull
    public FlexibleDate getTeiseiYMD() {
        return teiseiYMD;
    }

    /**
     * 訂正年月日のsetメソッドです。
     * 
     * @param teiseiYMD 訂正年月日
     */
    public void setTeiseiYMD(FlexibleDate teiseiYMD) {
        this.teiseiYMD = teiseiYMD;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * 
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * 
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.idoYMD, other.idoYMD)) {
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
    public void shallowCopy(DbT3004KyodoShoriyoJukyushaIdoKogakuSofuEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.idoYMD = entity.idoYMD;
        this.rirekiNo = entity.rirekiNo;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.setaiShuyakuNo = entity.setaiShuyakuNo;
        this.setaiShotokuKubunCode = entity.setaiShotokuKubunCode;
        this.shotokuKubunCode = entity.shotokuKubunCode;
        this.roureiFukushiNenkinJukyuAriFlag = entity.roureiFukushiNenkinJukyuAriFlag;
        this.riyoshaFutan2DankaiAriFlag = entity.riyoshaFutan2DankaiAriFlag;
        this.shikyuShinseishoOutputAriFlag = entity.shikyuShinseishoOutputAriFlag;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
        this.teiseiKubunCode = entity.teiseiKubunCode;
        this.teiseiYMD = entity.teiseiYMD;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, idoYMD, rirekiNo, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, setaiShuyakuNo, setaiShotokuKubunCode, shotokuKubunCode, roureiFukushiNenkinJukyuAriFlag, riyoshaFutan2DankaiAriFlag, shikyuShinseishoOutputAriFlag, teiseiRenrakuhyoFlag, sofuYM, teiseiKubunCode, teiseiYMD, logicalDeletedFlag);
    }

// </editor-fold>


}
