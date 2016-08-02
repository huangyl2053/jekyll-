package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 高額介護サービス費支給判定結果・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7509KogakuShikyuHanteiKekkaFukushiEntity extends DbTableEntityBase<DbV7509KogakuShikyuHanteiKekkaFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7509KogakuShikyuHanteiKekkaFukushi");

    private HihokenshaNo hihokenshaNo;
    private FlexibleYearMonth serviceTeikyoYM;
    private HokenshaNo shoKisaiHokenshaNo;
    private int rirekiNo;
    private FlexibleDate ketteiYMD;
    private Decimal honninShiharaiGaku;
    private RString shikyuKubunCode;
    private Decimal shikyuKingaku;
    private RString fushikyuRiyu;
    private RString shinsaHohoKubun;
    private FlexibleYearMonth hanteiKekkaSofuYM;
    private boolean saiSofuFlag;
    private boolean hanteiKekkaSofuFuyoFlag;
    private RString shinsaKekkaHaneiKubun;
    private FlexibleDate ketteiTsuchishoSakuseiYMD;
    private FlexibleDate furikomiMeisaishoSakuseiYMD;

    /**
     * hihokenshaNoのgetメソッドです。
     * 
     * @return hihokenshaNo
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * hihokenshaNoのsetメソッドです。
     * 
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * serviceTeikyoYMのgetメソッドです。
     * 
     * @return serviceTeikyoYM
     */
    @CheckForNull
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * serviceTeikyoYMのsetメソッドです。
     * 
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * shoKisaiHokenshaNoのgetメソッドです。
     * 
     * @return shoKisaiHokenshaNo
     */
    @CheckForNull
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * shoKisaiHokenshaNoのsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * rirekiNoのgetメソッドです。
     * 
     * @return rirekiNo
     */
    @CheckForNull
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * rirekiNoのsetメソッドです。
     * 
     * @param rirekiNo rirekiNo
     */
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * ketteiYMDのgetメソッドです。
     * 
     * @return ketteiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * ketteiYMDのsetメソッドです。
     * 
     * @param ketteiYMD ketteiYMD
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * honninShiharaiGakuのgetメソッドです。
     * 
     * @return honninShiharaiGaku
     */
    @CheckForNull
    public Decimal getHonninShiharaiGaku() {
        return honninShiharaiGaku;
    }

    /**
     * honninShiharaiGakuのsetメソッドです。
     * 
     * @param honninShiharaiGaku honninShiharaiGaku
     */
    public void setHonninShiharaiGaku(Decimal honninShiharaiGaku) {
        this.honninShiharaiGaku = honninShiharaiGaku;
    }

    /**
     * shikyuKubunCodeのgetメソッドです。
     * 
     * @return shikyuKubunCode
     */
    @CheckForNull
    public RString getShikyuKubunCode() {
        return shikyuKubunCode;
    }

    /**
     * shikyuKubunCodeのsetメソッドです。
     * 
     * @param shikyuKubunCode shikyuKubunCode
     */
    public void setShikyuKubunCode(RString shikyuKubunCode) {
        this.shikyuKubunCode = shikyuKubunCode;
    }

    /**
     * shikyuKingakuのgetメソッドです。
     * 
     * @return shikyuKingaku
     */
    @CheckForNull
    public Decimal getShikyuKingaku() {
        return shikyuKingaku;
    }

    /**
     * shikyuKingakuのsetメソッドです。
     * 
     * @param shikyuKingaku shikyuKingaku
     */
    public void setShikyuKingaku(Decimal shikyuKingaku) {
        this.shikyuKingaku = shikyuKingaku;
    }

    /**
     * fushikyuRiyuのgetメソッドです。
     * 
     * @return fushikyuRiyu
     */
    @CheckForNull
    public RString getFushikyuRiyu() {
        return fushikyuRiyu;
    }

    /**
     * fushikyuRiyuのsetメソッドです。
     * 
     * @param fushikyuRiyu fushikyuRiyu
     */
    public void setFushikyuRiyu(RString fushikyuRiyu) {
        this.fushikyuRiyu = fushikyuRiyu;
    }

    /**
     * shinsaHohoKubunのgetメソッドです。
     * 
     * @return shinsaHohoKubun
     */
    @CheckForNull
    public RString getShinsaHohoKubun() {
        return shinsaHohoKubun;
    }

    /**
     * shinsaHohoKubunのsetメソッドです。
     * 
     * @param shinsaHohoKubun shinsaHohoKubun
     */
    public void setShinsaHohoKubun(RString shinsaHohoKubun) {
        this.shinsaHohoKubun = shinsaHohoKubun;
    }

    /**
     * hanteiKekkaSofuYMのgetメソッドです。
     * 
     * @return hanteiKekkaSofuYM
     */
    @CheckForNull
    public FlexibleYearMonth getHanteiKekkaSofuYM() {
        return hanteiKekkaSofuYM;
    }

    /**
     * hanteiKekkaSofuYMのsetメソッドです。
     * 
     * @param hanteiKekkaSofuYM hanteiKekkaSofuYM
     */
    public void setHanteiKekkaSofuYM(FlexibleYearMonth hanteiKekkaSofuYM) {
        this.hanteiKekkaSofuYM = hanteiKekkaSofuYM;
    }

    /**
     * saiSofuFlagのgetメソッドです。
     * 
     * @return saiSofuFlag
     */
    @CheckForNull
    public boolean getSaiSofuFlag() {
        return saiSofuFlag;
    }

    /**
     * saiSofuFlagのsetメソッドです。
     * 
     * @param saiSofuFlag saiSofuFlag
     */
    public void setSaiSofuFlag(boolean saiSofuFlag) {
        this.saiSofuFlag = saiSofuFlag;
    }

    /**
     * hanteiKekkaSofuFuyoFlagのgetメソッドです。
     * 
     * @return hanteiKekkaSofuFuyoFlag
     */
    @CheckForNull
    public boolean getHanteiKekkaSofuFuyoFlag() {
        return hanteiKekkaSofuFuyoFlag;
    }

    /**
     * hanteiKekkaSofuFuyoFlagのsetメソッドです。
     * 
     * @param hanteiKekkaSofuFuyoFlag hanteiKekkaSofuFuyoFlag
     */
    public void setHanteiKekkaSofuFuyoFlag(boolean hanteiKekkaSofuFuyoFlag) {
        this.hanteiKekkaSofuFuyoFlag = hanteiKekkaSofuFuyoFlag;
    }

    /**
     * shinsaKekkaHaneiKubunのgetメソッドです。
     * 
     * @return shinsaKekkaHaneiKubun
     */
    @CheckForNull
    public RString getShinsaKekkaHaneiKubun() {
        return shinsaKekkaHaneiKubun;
    }

    /**
     * shinsaKekkaHaneiKubunのsetメソッドです。
     * 
     * @param shinsaKekkaHaneiKubun shinsaKekkaHaneiKubun
     */
    public void setShinsaKekkaHaneiKubun(RString shinsaKekkaHaneiKubun) {
        this.shinsaKekkaHaneiKubun = shinsaKekkaHaneiKubun;
    }

    /**
     * ketteiTsuchishoSakuseiYMDのgetメソッドです。
     * 
     * @return ketteiTsuchishoSakuseiYMD
     */
    @CheckForNull
    public FlexibleDate getKetteiTsuchishoSakuseiYMD() {
        return ketteiTsuchishoSakuseiYMD;
    }

    /**
     * ketteiTsuchishoSakuseiYMDのsetメソッドです。
     * 
     * @param ketteiTsuchishoSakuseiYMD ketteiTsuchishoSakuseiYMD
     */
    public void setKetteiTsuchishoSakuseiYMD(FlexibleDate ketteiTsuchishoSakuseiYMD) {
        this.ketteiTsuchishoSakuseiYMD = ketteiTsuchishoSakuseiYMD;
    }

    /**
     * furikomiMeisaishoSakuseiYMDのgetメソッドです。
     * 
     * @return furikomiMeisaishoSakuseiYMD
     */
    @CheckForNull
    public FlexibleDate getFurikomiMeisaishoSakuseiYMD() {
        return furikomiMeisaishoSakuseiYMD;
    }

    /**
     * furikomiMeisaishoSakuseiYMDのsetメソッドです。
     * 
     * @param furikomiMeisaishoSakuseiYMD furikomiMeisaishoSakuseiYMD
     */
    public void setFurikomiMeisaishoSakuseiYMD(FlexibleDate furikomiMeisaishoSakuseiYMD) {
        this.furikomiMeisaishoSakuseiYMD = furikomiMeisaishoSakuseiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7509KogakuShikyuHanteiKekkaFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7509KogakuShikyuHanteiKekkaFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7509KogakuShikyuHanteiKekkaFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7509KogakuShikyuHanteiKekkaFukushiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.ketteiYMD = entity.ketteiYMD;
        this.honninShiharaiGaku = entity.honninShiharaiGaku;
        this.shikyuKubunCode = entity.shikyuKubunCode;
        this.shikyuKingaku = entity.shikyuKingaku;
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoKisaiHokenshaNo, rirekiNo, ketteiYMD, honninShiharaiGaku, shikyuKubunCode, shikyuKingaku, fushikyuRiyu, shinsaHohoKubun, hanteiKekkaSofuYM, saiSofuFlag, hanteiKekkaSofuFuyoFlag, shinsaKekkaHaneiKubun, ketteiTsuchishoSakuseiYMD, furikomiMeisaishoSakuseiYMD);
    }

// </editor-fold>
}
