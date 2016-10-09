package jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.util.db.annotation.TempTableColumnOrder;

/**
 * 提供基本情報nn一時テーブルです。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
@OnNextSchema("rgdb")
public class TeikyoKihonJohoNNTempEntity extends DbTableEntityBase<TeikyoKihonJohoNNTempEntity> implements IDbAccessable {

    /**
     * 提供基本情報nn一時テーブル
     */
    @TableName
    public static final RString TABLE_NAME;

    static {
        TABLE_NAME = (new RString("TeikyoKihonJohoNNTemp"));
    }
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString dataSetNo;
    @TempTableColumnOrder(10)
    private RString teikyoKubun;
    @TempTableColumnOrder(20)
    private ShikibetsuCode shikibetsuCode;
    @TempTableColumnOrder(30)
    private RString kojinNo;
    @TempTableColumnOrder(40)
    private RString tokuteiKojinJohoMeiCode;
    @TempTableColumnOrder(50)
    private RString hanNo;
    @TempTableColumnOrder(60)
    private RString teikyoNaiyo01;
    @TempTableColumnOrder(70)
    private RString misetteiJiyu01;
    @TempTableColumnOrder(80)
    private RString teikyoNaiyo02;
    @TempTableColumnOrder(90)
    private RString misetteiJiyu02;
    @TempTableColumnOrder(100)
    private RString teikyoNaiyo03;
    @TempTableColumnOrder(110)
    private RString misetteiJiyu03;
    @TempTableColumnOrder(120)
    private RString teikyoNaiyo04;
    @TempTableColumnOrder(130)
    private RString misetteiJiyu04;
    @TempTableColumnOrder(140)
    private RString teikyoNaiyo05;
    @TempTableColumnOrder(150)
    private RString misetteiJiyu05;
    @TempTableColumnOrder(160)
    private RString teikyoNaiyo06;
    @TempTableColumnOrder(170)
    private RString misetteiJiyu06;
    @TempTableColumnOrder(180)
    private RString teikyoNaiyo07;
    @TempTableColumnOrder(190)
    private RString misetteiJiyu07;
    @TempTableColumnOrder(200)
    private RString teikyoNaiyo08;
    @TempTableColumnOrder(210)
    private RString misetteiJiyu08;
    @TempTableColumnOrder(220)
    private RString teikyoNaiyo09;
    @TempTableColumnOrder(230)
    private RString misetteiJiyu09;
    @TempTableColumnOrder(240)
    private RString teikyoNaiyo10;
    @TempTableColumnOrder(250)
    private RString misetteiJiyu10;
    @TempTableColumnOrder(260)
    private FlexibleDate kokaiYMD;

    /**
     * {@inheritDoc}
     *
     * @param entity
     */
    @Override
    public void shallowCopy(TeikyoKihonJohoNNTempEntity entity) {
        this.setHihokenshaNo(entity.getHihokenshaNo());
        this.setDataSetNo(entity.getDataSetNo());
        this.setTeikyoKubun(entity.getTeikyoKubun());
        this.setShikibetsuCode(entity.getShikibetsuCode());
        this.setKojinNo(entity.getKojinNo());
        this.setTokuteiKojinJohoMeiCode(entity.getTokuteiKojinJohoMeiCode());
        this.setTeikyoNaiyo01(entity.getTeikyoNaiyo01());
        this.setMisetteiJiyu01(entity.getMisetteiJiyu01());
        this.setTeikyoNaiyo02(entity.getTeikyoNaiyo02());
        this.setMisetteiJiyu02(entity.getMisetteiJiyu02());
        this.setTeikyoNaiyo03(entity.getTeikyoNaiyo03());
        this.setMisetteiJiyu03(entity.getMisetteiJiyu03());
        this.setTeikyoNaiyo04(entity.getTeikyoNaiyo04());
        this.setMisetteiJiyu04(entity.getMisetteiJiyu04());
        this.setTeikyoNaiyo05(entity.getTeikyoNaiyo05());
        this.setMisetteiJiyu05(entity.getMisetteiJiyu05());
        this.setTeikyoNaiyo06(entity.getTeikyoNaiyo06());
        this.setMisetteiJiyu06(entity.getMisetteiJiyu06());
        this.setTeikyoNaiyo07(entity.getTeikyoNaiyo07());
        this.setMisetteiJiyu07(entity.getMisetteiJiyu07());
        this.setTeikyoNaiyo08(entity.getTeikyoNaiyo08());
        this.setMisetteiJiyu08(entity.getMisetteiJiyu08());
        this.setTeikyoNaiyo09(entity.getTeikyoNaiyo09());
        this.setMisetteiJiyu09(entity.getMisetteiJiyu09());
        this.setTeikyoNaiyo10(entity.getTeikyoNaiyo10());
        this.setMisetteiJiyu10(entity.getMisetteiJiyu10());
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, dataSetNo, teikyoKubun, shikibetsuCode, kojinNo, tokuteiKojinJohoMeiCode,
                hanNo, teikyoNaiyo01, misetteiJiyu01, teikyoNaiyo02, misetteiJiyu02, teikyoNaiyo03, misetteiJiyu03,
                teikyoNaiyo04, misetteiJiyu04, teikyoNaiyo05, misetteiJiyu05, teikyoNaiyo06, misetteiJiyu06,
                teikyoNaiyo07, misetteiJiyu07, teikyoNaiyo08, misetteiJiyu08, teikyoNaiyo09, misetteiJiyu09,
                teikyoNaiyo10, misetteiJiyu10);
    }
// </editor-fold>

    /**
     * @return the hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * @param hihokenshaNo the hihokenshaNo to set
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * @return the dataSetNo
     */
    public RString getDataSetNo() {
        return dataSetNo;
    }

    /**
     * @param dataSetNo the dataSetNo to set
     */
    public void setDataSetNo(RString dataSetNo) {
        this.dataSetNo = dataSetNo;
    }

    /**
     * @return the teikyoKubun
     */
    public RString getTeikyoKubun() {
        return teikyoKubun;
    }

    /**
     * @param teikyoKubun the teikyoKubun to set
     */
    public void setTeikyoKubun(RString teikyoKubun) {
        this.teikyoKubun = teikyoKubun;
    }

    /**
     * @return the shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * @param shikibetsuCode the shikibetsuCode to set
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * @return the kojinNo
     */
    public RString getKojinNo() {
        return kojinNo;
    }

    /**
     * @param kojinNo the kojinNo to set
     */
    public void setKojinNo(RString kojinNo) {
        this.kojinNo = kojinNo;
    }

    /**
     * @return the tokuteiKojinJohoMeiCode
     */
    public RString getTokuteiKojinJohoMeiCode() {
        return tokuteiKojinJohoMeiCode;
    }

    /**
     * @param tokuteiKojinJohoMeiCode the tokuteiKojinJohoMeiCode to set
     */
    public void setTokuteiKojinJohoMeiCode(RString tokuteiKojinJohoMeiCode) {
        this.tokuteiKojinJohoMeiCode = tokuteiKojinJohoMeiCode;
    }

    /**
     * @return the hanNo
     */
    public RString getHanNo() {
        return hanNo;
    }

    /**
     * @param hanNo the hanNo to set
     */
    public void setHanNo(RString hanNo) {
        this.hanNo = hanNo;
    }

    /**
     * @return the teikyoNaiyo01
     */
    public RString getTeikyoNaiyo01() {
        return teikyoNaiyo01;
    }

    /**
     * @param teikyoNaiyo01 the teikyoNaiyo01 to set
     */
    public void setTeikyoNaiyo01(RString teikyoNaiyo01) {
        this.teikyoNaiyo01 = teikyoNaiyo01;
    }

    /**
     * @return the misetteiJiyu01
     */
    public RString getMisetteiJiyu01() {
        return misetteiJiyu01;
    }

    /**
     * @param misetteiJiyu01 the misetteiJiyu01 to set
     */
    public void setMisetteiJiyu01(RString misetteiJiyu01) {
        this.misetteiJiyu01 = misetteiJiyu01;
    }

    /**
     * @return the teikyoNaiyo02
     */
    public RString getTeikyoNaiyo02() {
        return teikyoNaiyo02;
    }

    /**
     * @param teikyoNaiyo02 the teikyoNaiyo02 to set
     */
    public void setTeikyoNaiyo02(RString teikyoNaiyo02) {
        this.teikyoNaiyo02 = teikyoNaiyo02;
    }

    /**
     * @return the misetteiJiyu02
     */
    public RString getMisetteiJiyu02() {
        return misetteiJiyu02;
    }

    /**
     * @param misetteiJiyu02 the misetteiJiyu02 to set
     */
    public void setMisetteiJiyu02(RString misetteiJiyu02) {
        this.misetteiJiyu02 = misetteiJiyu02;
    }

    /**
     * @return the teikyoNaiyo03
     */
    public RString getTeikyoNaiyo03() {
        return teikyoNaiyo03;
    }

    /**
     * @param teikyoNaiyo03 the teikyoNaiyo03 to set
     */
    public void setTeikyoNaiyo03(RString teikyoNaiyo03) {
        this.teikyoNaiyo03 = teikyoNaiyo03;
    }

    /**
     * @return the misetteiJiyu03
     */
    public RString getMisetteiJiyu03() {
        return misetteiJiyu03;
    }

    /**
     * @param misetteiJiyu03 the misetteiJiyu03 to set
     */
    public void setMisetteiJiyu03(RString misetteiJiyu03) {
        this.misetteiJiyu03 = misetteiJiyu03;
    }

    /**
     * @return the teikyoNaiyo04
     */
    public RString getTeikyoNaiyo04() {
        return teikyoNaiyo04;
    }

    /**
     * @param teikyoNaiyo04 the teikyoNaiyo04 to set
     */
    public void setTeikyoNaiyo04(RString teikyoNaiyo04) {
        this.teikyoNaiyo04 = teikyoNaiyo04;
    }

    /**
     * @return the misetteiJiyu04
     */
    public RString getMisetteiJiyu04() {
        return misetteiJiyu04;
    }

    /**
     * @param misetteiJiyu04 the misetteiJiyu04 to set
     */
    public void setMisetteiJiyu04(RString misetteiJiyu04) {
        this.misetteiJiyu04 = misetteiJiyu04;
    }

    /**
     * @return the teikyoNaiyo05
     */
    public RString getTeikyoNaiyo05() {
        return teikyoNaiyo05;
    }

    /**
     * @param teikyoNaiyo05 the teikyoNaiyo05 to set
     */
    public void setTeikyoNaiyo05(RString teikyoNaiyo05) {
        this.teikyoNaiyo05 = teikyoNaiyo05;
    }

    /**
     * @return the misetteiJiyu05
     */
    public RString getMisetteiJiyu05() {
        return misetteiJiyu05;
    }

    /**
     * @param misetteiJiyu05 the misetteiJiyu05 to set
     */
    public void setMisetteiJiyu05(RString misetteiJiyu05) {
        this.misetteiJiyu05 = misetteiJiyu05;
    }

    /**
     * @return the teikyoNaiyo06
     */
    public RString getTeikyoNaiyo06() {
        return teikyoNaiyo06;
    }

    /**
     * @param teikyoNaiyo06 the teikyoNaiyo06 to set
     */
    public void setTeikyoNaiyo06(RString teikyoNaiyo06) {
        this.teikyoNaiyo06 = teikyoNaiyo06;
    }

    /**
     * @return the misetteiJiyu06
     */
    public RString getMisetteiJiyu06() {
        return misetteiJiyu06;
    }

    /**
     * @param misetteiJiyu06 the misetteiJiyu06 to set
     */
    public void setMisetteiJiyu06(RString misetteiJiyu06) {
        this.misetteiJiyu06 = misetteiJiyu06;
    }

    /**
     * @return the teikyoNaiyo07
     */
    public RString getTeikyoNaiyo07() {
        return teikyoNaiyo07;
    }

    /**
     * @param teikyoNaiyo07 the teikyoNaiyo07 to set
     */
    public void setTeikyoNaiyo07(RString teikyoNaiyo07) {
        this.teikyoNaiyo07 = teikyoNaiyo07;
    }

    /**
     * @return the misetteiJiyu07
     */
    public RString getMisetteiJiyu07() {
        return misetteiJiyu07;
    }

    /**
     * @param misetteiJiyu07 the misetteiJiyu07 to set
     */
    public void setMisetteiJiyu07(RString misetteiJiyu07) {
        this.misetteiJiyu07 = misetteiJiyu07;
    }

    /**
     * @return the teikyoNaiyo08
     */
    public RString getTeikyoNaiyo08() {
        return teikyoNaiyo08;
    }

    /**
     * @param teikyoNaiyo08 the teikyoNaiyo08 to set
     */
    public void setTeikyoNaiyo08(RString teikyoNaiyo08) {
        this.teikyoNaiyo08 = teikyoNaiyo08;
    }

    /**
     * @return the misetteiJiyu08
     */
    public RString getMisetteiJiyu08() {
        return misetteiJiyu08;
    }

    /**
     * @param misetteiJiyu08 the misetteiJiyu08 to set
     */
    public void setMisetteiJiyu08(RString misetteiJiyu08) {
        this.misetteiJiyu08 = misetteiJiyu08;
    }

    /**
     * @return the teikyoNaiyo09
     */
    public RString getTeikyoNaiyo09() {
        return teikyoNaiyo09;
    }

    /**
     * @param teikyoNaiyo09 the teikyoNaiyo09 to set
     */
    public void setTeikyoNaiyo09(RString teikyoNaiyo09) {
        this.teikyoNaiyo09 = teikyoNaiyo09;
    }

    /**
     * @return the misetteiJiyu09
     */
    public RString getMisetteiJiyu09() {
        return misetteiJiyu09;
    }

    /**
     * @param misetteiJiyu09 the misetteiJiyu09 to set
     */
    public void setMisetteiJiyu09(RString misetteiJiyu09) {
        this.misetteiJiyu09 = misetteiJiyu09;
    }

    /**
     * @return the teikyoNaiyo10
     */
    public RString getTeikyoNaiyo10() {
        return teikyoNaiyo10;
    }

    /**
     * @param teikyoNaiyo10 the teikyoNaiyo10 to set
     */
    public void setTeikyoNaiyo10(RString teikyoNaiyo10) {
        this.teikyoNaiyo10 = teikyoNaiyo10;
    }

    /**
     * @return the misetteiJiyu10
     */
    public RString getMisetteiJiyu10() {
        return misetteiJiyu10;
    }

    /**
     * @param misetteiJiyu10 the misetteiJiyu10 to set
     */
    public void setMisetteiJiyu10(RString misetteiJiyu10) {
        this.misetteiJiyu10 = misetteiJiyu10;
    }

    /**
     * @return the kokaiYMD
     */
    public FlexibleDate getKokaiYMD() {
        return kokaiYMD;
    }

    /**
     * @param kokaiYMD the kokaiYMD to set
     */
    public void setKokaiYMD(FlexibleDate kokaiYMD) {
        this.kokaiYMD = kokaiYMD;
    }
}
