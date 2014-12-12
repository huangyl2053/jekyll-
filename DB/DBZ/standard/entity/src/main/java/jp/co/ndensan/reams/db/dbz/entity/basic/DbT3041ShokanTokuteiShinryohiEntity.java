package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3041ShokanTokuteiShinryohiの項目定義クラスです
 *
 */
public class DbT3041ShokanTokuteiShinryohiEntity extends DbTableEntityBase<DbT3041ShokanTokuteiShinryohiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3041ShokanTokuteiShinryohi");

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
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private RString yoshikiNo;
    @PrimaryKey
    private RString junjiNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString shobyoName;
    private int shidoKanriryoTanisu;
    private int tanjunXsenTanisu;
    private int rehabilitationTanisu;
    private int seishinkaSemmonRyoyohouTanisu;
    private int TotalTanisu;
    private RString tekiyo1;
    private RString tekiyo2;
    private RString tekiyo3;
    private RString tekiyo4;
    private RString tekiyo5;
    private RString tekiyo6;
    private RString tekiyo7;
    private RString tekiyo8;
    private RString tekiyo9;
    private RString tekiyo10;
    private RString tekiyo11;
    private RString tekiyo12;
    private RString tekiyo13;
    private RString tekiyo14;
    private RString tekiyo15;
    private RString tekiyo16;
    private RString tekiyo17;
    private RString tekiyo18;
    private RString tekiyo19;
    private RString tekiyo20;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getHiHokenshaNo
     *
     * @return hiHokenshaNo
     */
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * setHiHokenshaNo
     *
     * @param hiHokenshaNo hiHokenshaNo
     */
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
    }

    /**
     * getServiceTeikyoYM
     *
     * @return serviceTeikyoYM
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * setServiceTeikyoYM
     *
     * @param serviceTeikyoYM serviceTeikyoYM
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * getSeiriNo
     *
     * @return seiriNo
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * setSeiriNo
     *
     * @param seiriNo seiriNo
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYoshikiNo
     *
     * @return yoshikiNo
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * setYoshikiNo
     *
     * @param yoshikiNo yoshikiNo
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * getJunjiNo
     *
     * @return junjiNo
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * setJunjiNo
     *
     * @param junjiNo junjiNo
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
    }

    /**
     * getShoriTimestamp
     *
     * @return shoriTimestamp
     */
    public YMDHMS getShoriTimestamp() {
        return shoriTimestamp;
    }

    /**
     * setShoriTimestamp
     *
     * @param shoriTimestamp shoriTimestamp
     */
    public void setShoriTimestamp(YMDHMS shoriTimestamp) {
        this.shoriTimestamp = shoriTimestamp;
    }

    /**
     * getShobyoName
     *
     * @return shobyoName
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * setShobyoName
     *
     * @param shobyoName shobyoName
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * getShidoKanriryoTanisu
     *
     * @return shidoKanriryoTanisu
     */
    public int getShidoKanriryoTanisu() {
        return shidoKanriryoTanisu;
    }

    /**
     * setShidoKanriryoTanisu
     *
     * @param shidoKanriryoTanisu shidoKanriryoTanisu
     */
    public void setShidoKanriryoTanisu(int shidoKanriryoTanisu) {
        this.shidoKanriryoTanisu = shidoKanriryoTanisu;
    }

    /**
     * getTanjunXsenTanisu
     *
     * @return tanjunXsenTanisu
     */
    public int getTanjunXsenTanisu() {
        return tanjunXsenTanisu;
    }

    /**
     * setTanjunXsenTanisu
     *
     * @param tanjunXsenTanisu tanjunXsenTanisu
     */
    public void setTanjunXsenTanisu(int tanjunXsenTanisu) {
        this.tanjunXsenTanisu = tanjunXsenTanisu;
    }

    /**
     * getRehabilitationTanisu
     *
     * @return rehabilitationTanisu
     */
    public int getRehabilitationTanisu() {
        return rehabilitationTanisu;
    }

    /**
     * setRehabilitationTanisu
     *
     * @param rehabilitationTanisu rehabilitationTanisu
     */
    public void setRehabilitationTanisu(int rehabilitationTanisu) {
        this.rehabilitationTanisu = rehabilitationTanisu;
    }

    /**
     * getSeishinkaSemmonRyoyohouTanisu
     *
     * @return seishinkaSemmonRyoyohouTanisu
     */
    public int getSeishinkaSemmonRyoyohouTanisu() {
        return seishinkaSemmonRyoyohouTanisu;
    }

    /**
     * setSeishinkaSemmonRyoyohouTanisu
     *
     * @param seishinkaSemmonRyoyohouTanisu seishinkaSemmonRyoyohouTanisu
     */
    public void setSeishinkaSemmonRyoyohouTanisu(int seishinkaSemmonRyoyohouTanisu) {
        this.seishinkaSemmonRyoyohouTanisu = seishinkaSemmonRyoyohouTanisu;
    }

    /**
     * getTotalTanisu
     *
     * @return TotalTanisu
     */
    public int getTotalTanisu() {
        return TotalTanisu;
    }

    /**
     * setTotalTanisu
     *
     * @param TotalTanisu TotalTanisu
     */
    public void setTotalTanisu(int TotalTanisu) {
        this.TotalTanisu = TotalTanisu;
    }

    /**
     * getTekiyo1
     *
     * @return tekiyo1
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * setTekiyo1
     *
     * @param tekiyo1 tekiyo1
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * getTekiyo2
     *
     * @return tekiyo2
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * setTekiyo2
     *
     * @param tekiyo2 tekiyo2
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * getTekiyo3
     *
     * @return tekiyo3
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * setTekiyo3
     *
     * @param tekiyo3 tekiyo3
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * getTekiyo4
     *
     * @return tekiyo4
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * setTekiyo4
     *
     * @param tekiyo4 tekiyo4
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * getTekiyo5
     *
     * @return tekiyo5
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * setTekiyo5
     *
     * @param tekiyo5 tekiyo5
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * getTekiyo6
     *
     * @return tekiyo6
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * setTekiyo6
     *
     * @param tekiyo6 tekiyo6
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * getTekiyo7
     *
     * @return tekiyo7
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * setTekiyo7
     *
     * @param tekiyo7 tekiyo7
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * getTekiyo8
     *
     * @return tekiyo8
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * setTekiyo8
     *
     * @param tekiyo8 tekiyo8
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * getTekiyo9
     *
     * @return tekiyo9
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * setTekiyo9
     *
     * @param tekiyo9 tekiyo9
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * getTekiyo10
     *
     * @return tekiyo10
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * setTekiyo10
     *
     * @param tekiyo10 tekiyo10
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * getTekiyo11
     *
     * @return tekiyo11
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * setTekiyo11
     *
     * @param tekiyo11 tekiyo11
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * getTekiyo12
     *
     * @return tekiyo12
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * setTekiyo12
     *
     * @param tekiyo12 tekiyo12
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * getTekiyo13
     *
     * @return tekiyo13
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * setTekiyo13
     *
     * @param tekiyo13 tekiyo13
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * getTekiyo14
     *
     * @return tekiyo14
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * setTekiyo14
     *
     * @param tekiyo14 tekiyo14
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * getTekiyo15
     *
     * @return tekiyo15
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * setTekiyo15
     *
     * @param tekiyo15 tekiyo15
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * getTekiyo16
     *
     * @return tekiyo16
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * setTekiyo16
     *
     * @param tekiyo16 tekiyo16
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * getTekiyo17
     *
     * @return tekiyo17
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * setTekiyo17
     *
     * @param tekiyo17 tekiyo17
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * getTekiyo18
     *
     * @return tekiyo18
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * setTekiyo18
     *
     * @param tekiyo18 tekiyo18
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * getTekiyo19
     *
     * @return tekiyo19
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * setTekiyo19
     *
     * @param tekiyo19 tekiyo19
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * getTekiyo20
     *
     * @return tekiyo20
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * setTekiyo20
     *
     * @param tekiyo20 tekiyo20
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3041ShokanTokuteiShinryohiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3041ShokanTokuteiShinryohiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3041ShokanTokuteiShinryohiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yoshikiNo, other.yoshikiNo)) {
            return false;
        }
        if (!Objects.equals(this.junjiNo, other.junjiNo)) {
            return false;
        }
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3041ShokanTokuteiShinryohiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yoshikiNo = entity.yoshikiNo;
        this.junjiNo = entity.junjiNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.shobyoName = entity.shobyoName;
        this.shidoKanriryoTanisu = entity.shidoKanriryoTanisu;
        this.tanjunXsenTanisu = entity.tanjunXsenTanisu;
        this.rehabilitationTanisu = entity.rehabilitationTanisu;
        this.seishinkaSemmonRyoyohouTanisu = entity.seishinkaSemmonRyoyohouTanisu;
        this.TotalTanisu = entity.TotalTanisu;
        this.tekiyo1 = entity.tekiyo1;
        this.tekiyo2 = entity.tekiyo2;
        this.tekiyo3 = entity.tekiyo3;
        this.tekiyo4 = entity.tekiyo4;
        this.tekiyo5 = entity.tekiyo5;
        this.tekiyo6 = entity.tekiyo6;
        this.tekiyo7 = entity.tekiyo7;
        this.tekiyo8 = entity.tekiyo8;
        this.tekiyo9 = entity.tekiyo9;
        this.tekiyo10 = entity.tekiyo10;
        this.tekiyo11 = entity.tekiyo11;
        this.tekiyo12 = entity.tekiyo12;
        this.tekiyo13 = entity.tekiyo13;
        this.tekiyo14 = entity.tekiyo14;
        this.tekiyo15 = entity.tekiyo15;
        this.tekiyo16 = entity.tekiyo16;
        this.tekiyo17 = entity.tekiyo17;
        this.tekiyo18 = entity.tekiyo18;
        this.tekiyo19 = entity.tekiyo19;
        this.tekiyo20 = entity.tekiyo20;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, shoriTimestamp, shobyoName, shidoKanriryoTanisu, tanjunXsenTanisu, rehabilitationTanisu, seishinkaSemmonRyoyohouTanisu, TotalTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20);
    }

// </editor-fold>
}
