package jp.co.ndensan.reams.db.dbb.entity.db.relate.fukajohotoroku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.ur.urz.definition.core.code.RyokinShubetsuCodeValue;
import jp.co.ndensan.reams.uz.uza.biz.EdabanCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * DbT0700ShunoKanriTempTableEntity項目定義クラスです。
 *
 * @reamsid_L DBB-9040-070 wangxiaodong
 */
@OnNextSchema("rgdb")
public class DbT0700ShunoKanriTempTableEntity extends DbTableEntityBase<DbT0700ShunoKanriTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    /**
     * 収納管理（一時テーブル）
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = new RString("DbT0700ShunoKanriTemp");
    }
    @TempTableColumnOrder(1)
    private long shunoId;
    @TempTableColumnOrder(2)
    private KamokuCode kamokuCode;
    @TempTableColumnOrder(3)
    private EdabanCode edabanCode;
    @TempTableColumnOrder(4)
    private RyokinShubetsuCodeValue ryokinShubetsuCode;
    @TempTableColumnOrder(5)
    private RString jigyoKubun;
    @TempTableColumnOrder(6)
    private FlexibleYear choteiNendo;
    @TempTableColumnOrder(7)
    private FlexibleYear kazeiNendo;
    @TempTableColumnOrder(8)
    private int kibetsu;
    @TempTableColumnOrder(9)
    private TsuchishoNo tsuchishoNo;
    @TempTableColumnOrder(10)
    private boolean choshukenUmu;
    @TempTableColumnOrder(11)
    private long choteiId;
    @TempTableColumnOrder(12)
    private ShikibetsuCode shikibetsuCode;

    /**
     * 収納IDのgetメソッドです。
     *
     * @return the shunoId
     */
    public long getShunoId() {
        return shunoId;
    }

    /**
     * 収納IDのsetメソッドです。
     *
     * @param shunoId the shunoId to set
     */
    public void setShunoId(long shunoId) {
        this.shunoId = shunoId;
    }

    /**
     * 科目コードのgetメソッドです。
     *
     * @return the kamokuCode
     */
    public KamokuCode getKamokuCode() {
        return kamokuCode;
    }

    /**
     * 科目コードのsetメソッドです。
     *
     * @param kamokuCode the kamokuCode to set
     */
    public void setKamokuCode(KamokuCode kamokuCode) {
        this.kamokuCode = kamokuCode;
    }

    /**
     * 科目枝番コードのgetメソッドです。
     *
     * @return the edabanCode
     */
    public EdabanCode getEdabanCode() {
        return edabanCode;
    }

    /**
     * 科目枝番コードのsetメソッドです。
     *
     * @param edabanCode the edabanCode to set
     */
    public void setEdabanCode(EdabanCode edabanCode) {
        this.edabanCode = edabanCode;
    }

    /**
     * 料金種別コードのgetメソッドです。
     *
     * @return the ryokinShubetsuCode
     */
    public RyokinShubetsuCodeValue getRyokinShubetsuCode() {
        return ryokinShubetsuCode;
    }

    /**
     * 料金種別コードのsetメソッドです。
     *
     * @param ryokinShubetsuCode the ryokinShubetsuCode to set
     */
    public void setRyokinShubetsuCode(RyokinShubetsuCodeValue ryokinShubetsuCode) {
        this.ryokinShubetsuCode = ryokinShubetsuCode;
    }

    /**
     * 事業区分コードのgetメソッドです。
     *
     * @return the jigyoKubun
     */
    public RString getJigyoKubun() {
        return jigyoKubun;
    }

    /**
     * 事業区分コードのsetメソッドです。
     *
     * @param jigyoKubun the jigyoKubun to set
     */
    public void setJigyoKubun(RString jigyoKubun) {
        this.jigyoKubun = jigyoKubun;
    }

    /**
     * 調定年度のgetメソッドです。
     *
     * @return the choteiNendo
     */
    public FlexibleYear getChoteiNendo() {
        return choteiNendo;
    }

    /**
     * 調定年度のsetメソッドです。
     *
     * @param choteiNendo the choteiNendo to set
     */
    public void setChoteiNendo(FlexibleYear choteiNendo) {
        this.choteiNendo = choteiNendo;
    }

    /**
     * 課税年度のgetメソッドです。
     *
     * @return the kazeiNendo
     */
    public FlexibleYear getKazeiNendo() {
        return kazeiNendo;
    }

    /**
     * 課税年度のsetメソッドです。
     *
     * @param kazeiNendo the kazeiNendo to set
     */
    public void setKazeiNendo(FlexibleYear kazeiNendo) {
        this.kazeiNendo = kazeiNendo;
    }

    /**
     * 期別のgetメソッドです。
     *
     * @return the kibetsu
     */
    public int getKibetsu() {
        return kibetsu;
    }

    /**
     * 期別のsetメソッドです。
     *
     * @param kibetsu the kibetsu to set
     */
    public void setKibetsu(int kibetsu) {
        this.kibetsu = kibetsu;
    }

    /**
     * 通知書番号のgetメソッドです。
     *
     * @return the tsuchishoNo
     */
    public TsuchishoNo getTsuchishoNo() {
        return tsuchishoNo;
    }

    /**
     * 通知書番号のsetメソッドです。
     *
     * @param tsuchishoNo the tsuchishoNo to set
     */
    public void setTsuchishoNo(TsuchishoNo tsuchishoNo) {
        this.tsuchishoNo = tsuchishoNo;
    }

    /**
     * 徴収権有無のgetメソッドです。
     *
     * @return the choshukenUmu
     */
    public boolean isChoshukenUmu() {
        return choshukenUmu;
    }

    /**
     * 徴収権有無のsetメソッドです。
     *
     * @param choshukenUmu the choshukenUmu to set
     */
    public void setChoshukenUmu(boolean choshukenUmu) {
        this.choshukenUmu = choshukenUmu;
    }

    /**
     * 調定番号のgetメソッドです。
     *
     * @return the choteiId
     */
    public long getChoteiId() {
        return choteiId;
    }

    /**
     * 調定番号のsetメソッドです。
     *
     * @param choteiId the choteiId to set
     */
    public void setChoteiId(long choteiId) {
        this.choteiId = choteiId;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return the shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode the shikibetsuCode to set
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(DbT0700ShunoKanriTempTableEntity entity) {
        this.setShunoId(entity.getShunoId());
        this.setKamokuCode(entity.getKamokuCode());
        this.setEdabanCode(entity.getEdabanCode());
        this.setRyokinShubetsuCode(entity.getRyokinShubetsuCode());
        this.setJigyoKubun(entity.getJigyoKubun());
        this.setChoteiNendo(entity.getChoteiNendo());
        this.setKazeiNendo(entity.getKazeiNendo());
        this.setKibetsu(entity.getKibetsu());
        this.setTsuchishoNo(entity.getTsuchishoNo());
        this.setChoshukenUmu(entity.isChoshukenUmu());
        this.setChoteiId(entity.getChoteiId());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shunoId, kamokuCode, edabanCode, ryokinShubetsuCode, jigyoKubun,
                choteiNendo, kazeiNendo, kibetsu, tsuchishoNo, choshukenUmu, choteiId, shikibetsuCode);
    }
// </editor-fold>
}
