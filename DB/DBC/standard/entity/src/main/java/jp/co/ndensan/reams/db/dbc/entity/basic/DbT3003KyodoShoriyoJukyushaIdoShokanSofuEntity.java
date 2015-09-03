package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import java.util.Objects;

/**
 * 共同処理用受給者異動償還送付テーブルのエンティティクラスです。
 */
public class DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity extends DbTableEntityBase<DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3003KyodoShoriyoJukyushaIdoShokanSofu");

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
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate hokenKyufuIchijiSashitomeKaishiYMD;
    private FlexibleDate hokenKyufuIchijiSashitomeShuryoYMD;
    private RString hokenkyufuIchijiSashitomeKubunCode;
    private Decimal hokenkyufuIchijiSashitomeKingaku;
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
    public void setIdoYMD(FlexibleDate idoYMD) {
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
    public void setIdoKubunCode(RString idoKubunCode) {
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
    public void setJukyushaIdoJiyu(RString jukyushaIdoJiyu) {
        this.jukyushaIdoJiyu = jukyushaIdoJiyu;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * <br/>
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
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
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 保険給付支払一時差止開始年月日のgetメソッドです。
     *
     * @return 保険給付支払一時差止開始年月日
     */
    public FlexibleDate getHokenKyufuIchijiSashitomeKaishiYMD() {
        return hokenKyufuIchijiSashitomeKaishiYMD;
    }

    /**
     * 保険給付支払一時差止開始年月日のsetメソッドです。
     *
     * @param hokenKyufuIchijiSashitomeKaishiYMD 保険給付支払一時差止開始年月日
     */
    public void setHokenKyufuIchijiSashitomeKaishiYMD(FlexibleDate hokenKyufuIchijiSashitomeKaishiYMD) {
        this.hokenKyufuIchijiSashitomeKaishiYMD = hokenKyufuIchijiSashitomeKaishiYMD;
    }

    /**
     * 保険給付支払一時差止終了年月日のgetメソッドです。
     *
     * @return 保険給付支払一時差止終了年月日
     */
    public FlexibleDate getHokenKyufuIchijiSashitomeShuryoYMD() {
        return hokenKyufuIchijiSashitomeShuryoYMD;
    }

    /**
     * 保険給付支払一時差止終了年月日のsetメソッドです。
     *
     * @param hokenKyufuIchijiSashitomeShuryoYMD 保険給付支払一時差止終了年月日
     */
    public void setHokenKyufuIchijiSashitomeShuryoYMD(FlexibleDate hokenKyufuIchijiSashitomeShuryoYMD) {
        this.hokenKyufuIchijiSashitomeShuryoYMD = hokenKyufuIchijiSashitomeShuryoYMD;
    }

    /**
     * 保険給付支払一時差止区分コードのgetメソッドです。
     * <br/>
     * <br/>1:一部差止,2:全部差止
     *
     * @return 保険給付支払一時差止区分コード
     */
    public RString getHokenkyufuIchijiSashitomeKubunCode() {
        return hokenkyufuIchijiSashitomeKubunCode;
    }

    /**
     * 保険給付支払一時差止区分コードのsetメソッドです。
     * <br/>
     * <br/>1:一部差止,2:全部差止
     *
     * @param hokenkyufuIchijiSashitomeKubunCode 保険給付支払一時差止区分コード
     */
    public void setHokenkyufuIchijiSashitomeKubunCode(RString hokenkyufuIchijiSashitomeKubunCode) {
        this.hokenkyufuIchijiSashitomeKubunCode = hokenkyufuIchijiSashitomeKubunCode;
    }

    /**
     * 保険給付支払一時差止金額のgetメソッドです。
     * <br/>
     * <br/>保険給付支払一時差止区分コードが「1」の場合、必須
     *
     * @return 保険給付支払一時差止金額
     */
    public Decimal getHokenkyufuIchijiSashitomeKingaku() {
        return hokenkyufuIchijiSashitomeKingaku;
    }

    /**
     * 保険給付支払一時差止金額のsetメソッドです。
     * <br/>
     * <br/>保険給付支払一時差止区分コードが「1」の場合、必須
     *
     * @param hokenkyufuIchijiSashitomeKingaku 保険給付支払一時差止金額
     */
    public void setHokenkyufuIchijiSashitomeKingaku(Decimal hokenkyufuIchijiSashitomeKingaku) {
        this.hokenkyufuIchijiSashitomeKingaku = hokenkyufuIchijiSashitomeKingaku;
    }

    /**
     * 訂正連絡票フラグのgetメソッドです。
     * <br/>
     * <br/>異動or訂正 訂正ならtrue
     *
     * @return 訂正連絡票フラグ
     */
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
     * このエンティティの主キーが他の{@literal DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity other) {
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
    public void shallowCopy(DbT3003KyodoShoriyoJukyushaIdoShokanSofuEntity entity) {
        this.idoYMD = entity.idoYMD;
        this.idoKubunCode = entity.idoKubunCode;
        this.jukyushaIdoJiyu = entity.jukyushaIdoJiyu;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hokenKyufuIchijiSashitomeKaishiYMD = entity.hokenKyufuIchijiSashitomeKaishiYMD;
        this.hokenKyufuIchijiSashitomeShuryoYMD = entity.hokenKyufuIchijiSashitomeShuryoYMD;
        this.hokenkyufuIchijiSashitomeKubunCode = entity.hokenkyufuIchijiSashitomeKubunCode;
        this.hokenkyufuIchijiSashitomeKingaku = entity.hokenkyufuIchijiSashitomeKingaku;
        this.teiseiRenrakuhyoFlag = entity.teiseiRenrakuhyoFlag;
        this.sofuYM = entity.sofuYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(idoYMD, idoKubunCode, jukyushaIdoJiyu, shoKisaiHokenshaNo, hiHokenshaNo, rirekiNo, hokenKyufuIchijiSashitomeKaishiYMD, hokenKyufuIchijiSashitomeShuryoYMD, hokenkyufuIchijiSashitomeKubunCode, hokenkyufuIchijiSashitomeKingaku, teiseiRenrakuhyoFlag, sofuYM);
    }

// </editor-fold>
}
