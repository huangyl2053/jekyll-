package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;

/**
 * 支払方法変更滞納テーブルのエンティティクラスです。
 */
public class DbT4022ShiharaiHohoHenkoTainoEntity extends DbTableEntityBase<DbT4022ShiharaiHohoHenkoTainoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4022ShiharaiHohoHenkoTaino");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString kanriKubun;
    @PrimaryKey
    private RString tainoHanteiKubun;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private RString Tokucho_fuchoKubun;
    @PrimaryKey
    private RString shuno_Ki_Tsuki;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate tainoHanteiYMD;
    private FlexibleDate hanteiKijunYMD;
    private FlexibleDate jikoKisanYMD;
    private RString jikoKisanKubun;
    private RString kanno_MinoKubun;
    private RString jikoKubun;
    private RString jikoAtoShunyuKubun;
    private RString taishoKanriKubun;

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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 管理区分のgetメソッドです。
     * <br/>
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
     *
     * @return 管理区分
     */
    public RString getKanriKubun() {
        return kanriKubun;
    }

    /**
     * 管理区分のsetメソッドです。
     * <br/>
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
     *
     * @param kanriKubun 管理区分
     */
    public void setKanriKubun(RString kanriKubun) {
        this.kanriKubun = kanriKubun;
    }

    /**
     * 滞納判定区分のgetメソッドです。
     * <br/>
     * <br/>1:予告登録,2:償還払化登録,3:差止登録,4:控除登録,5:給付額減額登録
     *
     * @return 滞納判定区分
     */
    public RString getTainoHanteiKubun() {
        return tainoHanteiKubun;
    }

    /**
     * 滞納判定区分のsetメソッドです。
     * <br/>
     * <br/>1:予告登録,2:償還払化登録,3:差止登録,4:控除登録,5:給付額減額登録
     *
     * @param tainoHanteiKubun 滞納判定区分
     */
    public void setTainoHanteiKubun(RString tainoHanteiKubun) {
        this.tainoHanteiKubun = tainoHanteiKubun;
    }

    /**
     * 調定年度のgetメソッドです。
     *
     * @return 調定年度
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * 調定年度のsetメソッドです。
     *
     * @param choteiNendo 調定年度
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * 賦課年度のgetメソッドです。
     *
     * @return 賦課年度
     */
    public FlexibleYear getFukaNendo() {
        return fukaNendo;
    }

    /**
     * 賦課年度のsetメソッドです。
     *
     * @param fukaNendo 賦課年度
     */
    public void setFukaNendo(FlexibleYear fukaNendo) {
        this.fukaNendo = fukaNendo;
    }

    /**
     * 通知書番号のgetメソッドです。
     *
     * @return 通知書番号
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo 通知書番号
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 特徴・普徴区分のgetメソッドです。
     * <br/>
     * <br/>1:特別徴収,2:普通徴収
     *
     * @return 特徴・普徴区分
     */
    public RString getTokucho_fuchoKubun() {
        return Tokucho_fuchoKubun;
    }

    /**
     * 特徴・普徴区分のsetメソッドです。
     * <br/>
     * <br/>1:特別徴収,2:普通徴収
     *
     * @param Tokucho_fuchoKubun 特徴・普徴区分
     */
    public void setTokucho_fuchoKubun(RString Tokucho_fuchoKubun) {
        this.Tokucho_fuchoKubun = Tokucho_fuchoKubun;
    }

    /**
     * 収納期・月のgetメソッドです。
     *
     * @return 収納期・月
     */
    public RString getShuno_Ki_Tsuki() {
        return shuno_Ki_Tsuki;
    }

    /**
     * 収納期・月のsetメソッドです。
     *
     * @param shuno_Ki_Tsuki 収納期・月
     */
    public void setShuno_Ki_Tsuki(RString shuno_Ki_Tsuki) {
        this.shuno_Ki_Tsuki = shuno_Ki_Tsuki;
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
     * 滞納判定年月日のgetメソッドです。
     *
     * @return 滞納判定年月日
     */
    public FlexibleDate getTainoHanteiYMD() {
        return tainoHanteiYMD;
    }

    /**
     * 滞納判定年月日のsetメソッドです。
     *
     * @param tainoHanteiYMD 滞納判定年月日
     */
    public void setTainoHanteiYMD(FlexibleDate tainoHanteiYMD) {
        this.tainoHanteiYMD = tainoHanteiYMD;
    }

    /**
     * 判定基準年月日のgetメソッドです。
     * <br/>
     * <br/>当日以前の基準年月日（当日：判定処理日は収入が確定していないため含まない）
     *
     * @return 判定基準年月日
     */
    public FlexibleDate getHanteiKijunYMD() {
        return hanteiKijunYMD;
    }

    /**
     * 判定基準年月日のsetメソッドです。
     * <br/>
     * <br/>当日以前の基準年月日（当日：判定処理日は収入が確定していないため含まない）
     *
     * @param hanteiKijunYMD 判定基準年月日
     */
    public void setHanteiKijunYMD(FlexibleDate hanteiKijunYMD) {
        this.hanteiKijunYMD = hanteiKijunYMD;
    }

    /**
     * 時効起算年月日のgetメソッドです。
     *
     * @return 時効起算年月日
     */
    public FlexibleDate getJikoKisanYMD() {
        return jikoKisanYMD;
    }

    /**
     * 時効起算年月日のsetメソッドです。
     *
     * @param jikoKisanYMD 時効起算年月日
     */
    public void setJikoKisanYMD(FlexibleDate jikoKisanYMD) {
        this.jikoKisanYMD = jikoKisanYMD;
    }

    /**
     * 時効起算日区分のgetメソッドです。
     * <br/>
     * <br/>1:納期限翌日（収）,2:督促状発行日（収）,3:収入日（収）,4:債務者の債務の承認,5:差押,6:仮差押,7:仮処分,8:裁判上の請求等、被保険者に対する請求,9:不明（調定無し）（収）,A:その他,B:分納契約日（収）
     *
     * @return 時効起算日区分
     */
    public RString getJikoKisanKubun() {
        return jikoKisanKubun;
    }

    /**
     * 時効起算日区分のsetメソッドです。
     * <br/>
     * <br/>1:納期限翌日（収）,2:督促状発行日（収）,3:収入日（収）,4:債務者の債務の承認,5:差押,6:仮差押,7:仮処分,8:裁判上の請求等、被保険者に対する請求,9:不明（調定無し）（収）,A:その他,B:分納契約日（収）
     *
     * @param jikoKisanKubun 時効起算日区分
     */
    public void setJikoKisanKubun(RString jikoKisanKubun) {
        this.jikoKisanKubun = jikoKisanKubun;
    }

    /**
     * 完納・未納区分のgetメソッドです。
     * <br/>
     * <br/>1:完納,2:過納,3:未納有り,4:未来納期,9:0円調定／0円収入
     *
     * @return 完納・未納区分
     */
    public RString getKanno_MinoKubun() {
        return kanno_MinoKubun;
    }

    /**
     * 完納・未納区分のsetメソッドです。
     * <br/>
     * <br/>1:完納,2:過納,3:未納有り,4:未来納期,9:0円調定／0円収入
     *
     * @param kanno_MinoKubun 完納・未納区分
     */
    public void setKanno_MinoKubun(RString kanno_MinoKubun) {
        this.kanno_MinoKubun = kanno_MinoKubun;
    }

    /**
     * 時効区分のgetメソッドです。
     * <br/>
     * <br/>1:時効未到来,2:時効到来
     *
     * @return 時効区分
     */
    public RString getJikoKubun() {
        return jikoKubun;
    }

    /**
     * 時効区分のsetメソッドです。
     * <br/>
     * <br/>1:時効未到来,2:時効到来
     *
     * @param jikoKubun 時効区分
     */
    public void setJikoKubun(RString jikoKubun) {
        this.jikoKubun = jikoKubun;
    }

    /**
     * 時効後収入区分のgetメソッドです。
     * <br/>
     * <br/>1:時効後収入有り
     *
     * @return 時効後収入区分
     */
    public RString getJikoAtoShunyuKubun() {
        return jikoAtoShunyuKubun;
    }

    /**
     * 時効後収入区分のsetメソッドです。
     * <br/>
     * <br/>1:時効後収入有り
     *
     * @param jikoAtoShunyuKubun 時効後収入区分
     */
    public void setJikoAtoShunyuKubun(RString jikoAtoShunyuKubun) {
        this.jikoAtoShunyuKubun = jikoAtoShunyuKubun;
    }

    /**
     * 対象管理区分のgetメソッドです。
     *
     * @return 対象管理区分
     */
    public RString getTaishoKanriKubun() {
        return taishoKanriKubun;
    }

    /**
     * 対象管理区分のsetメソッドです。
     *
     * @param taishoKanriKubun 対象管理区分
     */
    public void setTaishoKanriKubun(RString taishoKanriKubun) {
        this.taishoKanriKubun = taishoKanriKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4022ShiharaiHohoHenkoTainoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4022ShiharaiHohoHenkoTainoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4022ShiharaiHohoHenkoTainoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.kanriKubun, other.kanriKubun)) {
            return false;
        }
        if (!Objects.equals(this.tainoHanteiKubun, other.tainoHanteiKubun)) {
            return false;
        }
        if (!Objects.equals(this.choteiNendo, other.choteiNendo)) {
            return false;
        }
        if (!Objects.equals(this.fukaNendo, other.fukaNendo)) {
            return false;
        }
        if (!Objects.equals(this.tsuchishoNo, other.tsuchishoNo)) {
            return false;
        }
        if (!Objects.equals(this.Tokucho_fuchoKubun, other.Tokucho_fuchoKubun)) {
            return false;
        }
        if (!Objects.equals(this.shuno_Ki_Tsuki, other.shuno_Ki_Tsuki)) {
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
    public void shallowCopy(DbT4022ShiharaiHohoHenkoTainoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.kanriKubun = entity.kanriKubun;
        this.tainoHanteiKubun = entity.tainoHanteiKubun;
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.Tokucho_fuchoKubun = entity.Tokucho_fuchoKubun;
        this.shuno_Ki_Tsuki = entity.shuno_Ki_Tsuki;
        this.rirekiNo = entity.rirekiNo;
        this.tainoHanteiYMD = entity.tainoHanteiYMD;
        this.hanteiKijunYMD = entity.hanteiKijunYMD;
        this.jikoKisanYMD = entity.jikoKisanYMD;
        this.jikoKisanKubun = entity.jikoKisanKubun;
        this.kanno_MinoKubun = entity.kanno_MinoKubun;
        this.jikoKubun = entity.jikoKubun;
        this.jikoAtoShunyuKubun = entity.jikoAtoShunyuKubun;
        this.taishoKanriKubun = entity.taishoKanriKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, kanriKubun, tainoHanteiKubun, choteiNendo, fukaNendo, tsuchishoNo, Tokucho_fuchoKubun, shuno_Ki_Tsuki, rirekiNo, tainoHanteiYMD, hanteiKijunYMD, jikoKisanYMD, jikoKisanKubun, kanno_MinoKubun, jikoKubun, jikoAtoShunyuKubun, taishoKanriKubun);
    }

// </editor-fold>
}
