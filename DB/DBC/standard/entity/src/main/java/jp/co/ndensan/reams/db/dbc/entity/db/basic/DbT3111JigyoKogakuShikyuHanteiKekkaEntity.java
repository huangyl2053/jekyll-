package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 事業高額介護サービス費支給判定結果テーブルのエンティティクラスです。
 */
public class DbT3111JigyoKogakuShikyuHanteiKekkaEntity extends DbTableEntityBase<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3111JigyoKogakuShikyuHanteiKekka");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private int rirekiEdaNo;
    private FlexibleDate ketteiYMD;
    private Decimal honninShiharaiGaku;
    private RString shiharaiKubunCode;
    private Decimal shiharaiKingaku;
    private RString fushikyuRiyu;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth hanteiKekkaSofuYM;
    private boolean saiSofuFlag;
    private boolean hanteiKekkaSofuFuyoFlag;
    private RString shinsaKekkaHaneiKubun;
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    private FlexibleDate furikomiMeisaishoSakuseiYMD;

    /**
     * rirekiEdaNoのgetメソッドです。
     *
     * @return rirekiEdaNo
     */
    public int getRirekiEdaNo() {
        return rirekiEdaNo;
    }

    /**
     * rirekiEdaNoのsetメソッドです。
     *
     * @param rirekiEdaNo rirekiEdaNo
     */
    public void setRirekiEdaNo(int rirekiEdaNo) {
        this.rirekiEdaNo = rirekiEdaNo;
    }

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
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 本人支払額のgetメソッドです。
     *
     * @return 本人支払額
     */
    public Decimal getHonninShiharaiGaku() {
        return honninShiharaiGaku;
    }

    /**
     * 本人支払額のsetメソッドです。
     *
     * @param honninShiharaiGaku 本人支払額
     */
    public void setHonninShiharaiGaku(Decimal honninShiharaiGaku) {
        this.honninShiharaiGaku = honninShiharaiGaku;
    }

    /**
     * 支給区分コードのgetメソッドです。
     * <br/>
     * <br/>1:支給,2:不支給
     *
     * @return 支給区分コード
     */
    public RString getShiharaiKubunCode() {
        return shiharaiKubunCode;
    }

    /**
     * 支給区分コードのsetメソッドです。
     * <br/>
     * <br/>1:支給,2:不支給
     *
     * @param shiharaiKubunCode 支給区分コード
     */
    public void setShiharaiKubunCode(RString shiharaiKubunCode) {
        this.shiharaiKubunCode = shiharaiKubunCode;
    }

    /**
     * 支給金額のgetメソッドです。
     *
     * @return 支給金額
     */
    public Decimal getShiharaiKingaku() {
        return shiharaiKingaku;
    }

    /**
     * 支給金額のsetメソッドです。
     *
     * @param shiharaiKingaku 支給金額
     */
    public void setShiharaiKingaku(Decimal shiharaiKingaku) {
        this.shiharaiKingaku = shiharaiKingaku;
    }

    /**
     * 不支給理由のgetメソッドです。
     *
     * @return 不支給理由
     */
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * 不支給理由のsetメソッドです。
     *
     * @param fushikyuRiyu 不支給理由
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * 審査方法区分のgetメソッドです。
     *
     * @return 審査方法区分
     */
    public RString getShinsaHohoKubun() {
        return shinsaHohoKubun;
    }

    /**
     * 審査方法区分のsetメソッドです。
     *
     * @param shinsaHohoKubun 審査方法区分
     */
    public void setShinsaHohoKubun(RString shinsaHohoKubun) {
        this.shinsaHohoKubun = shinsaHohoKubun;
    }

    /**
     * 判定結果送付年月のgetメソッドです。
     *
     * @return 判定結果送付年月
     */
    public FlexibleYearMonth getHanteiKekkaSofuYM() {
        return hanteiKekkaSofuYM;
    }

    /**
     * 判定結果送付年月のsetメソッドです。
     *
     * @param hanteiKekkaSofuYM 判定結果送付年月
     */
    public void setHanteiKekkaSofuYM(FlexibleYearMonth hanteiKekkaSofuYM) {
        this.hanteiKekkaSofuYM = hanteiKekkaSofuYM;
    }

    /**
     * 再送付フラグのgetメソッドです。
     * <br/>
     * <br/>True:する,False:しない
     *
     * @return 再送付フラグ
     */
    public boolean getSaiSofuFlag() {
        return saiSofuFlag;
    }

    /**
     * 再送付フラグのsetメソッドです。
     * <br/>
     * <br/>True:する,False:しない
     *
     * @param saiSofuFlag 再送付フラグ
     */
    public void setSaiSofuFlag(boolean saiSofuFlag) {
        this.saiSofuFlag = saiSofuFlag;
    }

    /**
     * 判定結果送付不要フラグのgetメソッドです。
     * <br/>
     * <br/>True:送付不要,False:送付必要
     *
     * @return 判定結果送付不要フラグ
     */
    public boolean getHanteiKekkaSofuFuyoFlag() {
        return hanteiKekkaSofuFuyoFlag;
    }

    /**
     * 判定結果送付不要フラグのsetメソッドです。
     * <br/>
     * <br/>True:送付不要,False:送付必要
     *
     * @param hanteiKekkaSofuFuyoFlag 判定結果送付不要フラグ
     */
    public void setHanteiKekkaSofuFuyoFlag(boolean hanteiKekkaSofuFuyoFlag) {
        this.hanteiKekkaSofuFuyoFlag = hanteiKekkaSofuFuyoFlag;
    }

    /**
     * 審査結果反映区分のgetメソッドです。
     * <br/>
     * <br/>0:審査結果未反映,1:審査結果反映済,2:審査結果不要
     *
     * @return 審査結果反映区分
     */
    public RString getShinsaKekkaHaneiKubun() {
        return shinsaKekkaHaneiKubun;
    }

    /**
     * 審査結果反映区分のsetメソッドです。
     * <br/>
     * <br/>0:審査結果未反映,1:審査結果反映済,2:審査結果不要
     *
     * @param shinsaKekkaHaneiKubun 審査結果反映区分
     */
    public void setShinsaKekkaHaneiKubun(RString shinsaKekkaHaneiKubun) {
        this.shinsaKekkaHaneiKubun = shinsaKekkaHaneiKubun;
    }

    /**
     * 決定通知書作成年月日のgetメソッドです。
     *
     * @return 決定通知書作成年月日
     */
    public FlexibleDate getKetteiTsuchishoSakuseiYMD() {
        return ketteiTsuchishoSakuseiYMD;
    }

    /**
     * 決定通知書作成年月日のsetメソッドです。
     *
     * @param ketteiTsuchishoSakuseiYMD 決定通知書作成年月日
     */
    public void setKetteiTsuchishoSakuseiYMD(FlexibleDate ketteiTsuchishoSakuseiYMD) {
        this.ketteiTsuchishoSakuseiYMD = ketteiTsuchishoSakuseiYMD;
    }

    /**
     * 振込明細書作成年月日のgetメソッドです。
     *
     * @return 振込明細書作成年月日
     */
    public FlexibleDate getFurikomiMeisaishoSakuseiYMD() {
        return furikomiMeisaishoSakuseiYMD;
    }

    /**
     * 振込明細書作成年月日のsetメソッドです。
     *
     * @param furikomiMeisaishoSakuseiYMD 振込明細書作成年月日
     */
    public void setFurikomiMeisaishoSakuseiYMD(FlexibleDate furikomiMeisaishoSakuseiYMD) {
        this.furikomiMeisaishoSakuseiYMD = furikomiMeisaishoSakuseiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3111JigyoKogakuShikyuHanteiKekkaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3111JigyoKogakuShikyuHanteiKekkaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3111JigyoKogakuShikyuHanteiKekkaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
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
    public void shallowCopy(DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.honninShiharaiGaku = entity.honninShiharaiGaku;
        this.shiharaiKubunCode = entity.shiharaiKubunCode;
        this.shiharaiKingaku = entity.shiharaiKingaku;
        this.fushikyuRiyu = entity.fushikyuRiyu;
        this.shinsaHohoKubun = entity.shinsaHohoKubun;
        this.hanteiKekkaSofuYM = entity.hanteiKekkaSofuYM;
        this.saiSofuFlag = entity.saiSofuFlag;
        this.hanteiKekkaSofuFuyoFlag = entity.hanteiKekkaSofuFuyoFlag;
        this.shinsaKekkaHaneiKubun = entity.shinsaKekkaHaneiKubun;
        this.ketteiTsuchishoSakuseiYMD = entity.ketteiTsuchishoSakuseiYMD;
        this.furikomiMeisaishoSakuseiYMD = entity.furikomiMeisaishoSakuseiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoKisaiHokenshaNo, rirekiNo, ketteiYMD, honninShiharaiGaku, shiharaiKubunCode, shiharaiKingaku, fushikyuRiyu, shinsaHohoKubun, hanteiKekkaSofuYM, saiSofuFlag, hanteiKekkaSofuFuyoFlag, shinsaKekkaHaneiKubun, ketteiTsuchishoSakuseiYMD, furikomiMeisaishoSakuseiYMD);
    }

// </editor-fold>
}
