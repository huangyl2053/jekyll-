package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払請求特定診療費テーブルのエンティティクラスです。
 */
public class DbT3041ShokanTokuteiShinryohiEntity extends DbTableEntityBase<DbT3041ShokanTokuteiShinryohiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private Decimal rirekiNo;
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
    public void setHiHokenshaNo(HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
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
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(RString seiriNo) {
        this.seiriNo = seiriNo;
    }

    /**
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 様式番号のgetメソッドです。
     *
     * @return 様式番号
     */
    public RString getYoshikiNo() {
        return yoshikiNo;
    }

    /**
     * 様式番号のsetメソッドです。
     *
     * @param yoshikiNo 様式番号
     */
    public void setYoshikiNo(RString yoshikiNo) {
        this.yoshikiNo = yoshikiNo;
    }

    /**
     * 順次番号のgetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @return 順次番号
     */
    public RString getJunjiNo() {
        return junjiNo;
    }

    /**
     * 順次番号のsetメソッドです。
     * <br/>
     * <br/>複数レコード対応のため
     *
     * @param junjiNo 順次番号
     */
    public void setJunjiNo(RString junjiNo) {
        this.junjiNo = junjiNo;
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
     * 傷病名のgetメソッドです。
     *
     * @return 傷病名
     */
    public RString getShobyoName() {
        return shobyoName;
    }

    /**
     * 傷病名のsetメソッドです。
     *
     * @param shobyoName 傷病名
     */
    public void setShobyoName(RString shobyoName) {
        this.shobyoName = shobyoName;
    }

    /**
     * 指導管理料等単位数のgetメソッドです。
     *
     * @return 指導管理料等単位数
     */
    public int getShidoKanriryoTanisu() {
        return shidoKanriryoTanisu;
    }

    /**
     * 指導管理料等単位数のsetメソッドです。
     *
     * @param shidoKanriryoTanisu 指導管理料等単位数
     */
    public void setShidoKanriryoTanisu(int shidoKanriryoTanisu) {
        this.shidoKanriryoTanisu = shidoKanriryoTanisu;
    }

    /**
     * 単純エックス線単位数のgetメソッドです。
     *
     * @return 単純エックス線単位数
     */
    public int getTanjunXsenTanisu() {
        return tanjunXsenTanisu;
    }

    /**
     * 単純エックス線単位数のsetメソッドです。
     *
     * @param tanjunXsenTanisu 単純エックス線単位数
     */
    public void setTanjunXsenTanisu(int tanjunXsenTanisu) {
        this.tanjunXsenTanisu = tanjunXsenTanisu;
    }

    /**
     * リハビリテーション単位数のgetメソッドです。
     *
     * @return リハビリテーション単位数
     */
    public int getRehabilitationTanisu() {
        return rehabilitationTanisu;
    }

    /**
     * リハビリテーション単位数のsetメソッドです。
     *
     * @param rehabilitationTanisu リハビリテーション単位数
     */
    public void setRehabilitationTanisu(int rehabilitationTanisu) {
        this.rehabilitationTanisu = rehabilitationTanisu;
    }

    /**
     * 精神科専門療法単位数のgetメソッドです。
     *
     * @return 精神科専門療法単位数
     */
    public int getSeishinkaSemmonRyoyohouTanisu() {
        return seishinkaSemmonRyoyohouTanisu;
    }

    /**
     * 精神科専門療法単位数のsetメソッドです。
     *
     * @param seishinkaSemmonRyoyohouTanisu 精神科専門療法単位数
     */
    public void setSeishinkaSemmonRyoyohouTanisu(int seishinkaSemmonRyoyohouTanisu) {
        this.seishinkaSemmonRyoyohouTanisu = seishinkaSemmonRyoyohouTanisu;
    }

    /**
     * 合計単位数のgetメソッドです。
     *
     * @return 合計単位数
     */
    public int getTotalTanisu() {
        return TotalTanisu;
    }

    /**
     * 合計単位数のsetメソッドです。
     *
     * @param TotalTanisu 合計単位数
     */
    public void setTotalTanisu(int TotalTanisu) {
        this.TotalTanisu = TotalTanisu;
    }

    /**
     * 摘要１のgetメソッドです。
     *
     * @return 摘要１
     */
    public RString getTekiyo1() {
        return tekiyo1;
    }

    /**
     * 摘要１のsetメソッドです。
     *
     * @param tekiyo1 摘要１
     */
    public void setTekiyo1(RString tekiyo1) {
        this.tekiyo1 = tekiyo1;
    }

    /**
     * 摘要２のgetメソッドです。
     *
     * @return 摘要２
     */
    public RString getTekiyo2() {
        return tekiyo2;
    }

    /**
     * 摘要２のsetメソッドです。
     *
     * @param tekiyo2 摘要２
     */
    public void setTekiyo2(RString tekiyo2) {
        this.tekiyo2 = tekiyo2;
    }

    /**
     * 摘要３のgetメソッドです。
     *
     * @return 摘要３
     */
    public RString getTekiyo3() {
        return tekiyo3;
    }

    /**
     * 摘要３のsetメソッドです。
     *
     * @param tekiyo3 摘要３
     */
    public void setTekiyo3(RString tekiyo3) {
        this.tekiyo3 = tekiyo3;
    }

    /**
     * 摘要４のgetメソッドです。
     *
     * @return 摘要４
     */
    public RString getTekiyo4() {
        return tekiyo4;
    }

    /**
     * 摘要４のsetメソッドです。
     *
     * @param tekiyo4 摘要４
     */
    public void setTekiyo4(RString tekiyo4) {
        this.tekiyo4 = tekiyo4;
    }

    /**
     * 摘要５のgetメソッドです。
     *
     * @return 摘要５
     */
    public RString getTekiyo5() {
        return tekiyo5;
    }

    /**
     * 摘要５のsetメソッドです。
     *
     * @param tekiyo5 摘要５
     */
    public void setTekiyo5(RString tekiyo5) {
        this.tekiyo5 = tekiyo5;
    }

    /**
     * 摘要６のgetメソッドです。
     *
     * @return 摘要６
     */
    public RString getTekiyo6() {
        return tekiyo6;
    }

    /**
     * 摘要６のsetメソッドです。
     *
     * @param tekiyo6 摘要６
     */
    public void setTekiyo6(RString tekiyo6) {
        this.tekiyo6 = tekiyo6;
    }

    /**
     * 摘要７のgetメソッドです。
     *
     * @return 摘要７
     */
    public RString getTekiyo7() {
        return tekiyo7;
    }

    /**
     * 摘要７のsetメソッドです。
     *
     * @param tekiyo7 摘要７
     */
    public void setTekiyo7(RString tekiyo7) {
        this.tekiyo7 = tekiyo7;
    }

    /**
     * 摘要８のgetメソッドです。
     *
     * @return 摘要８
     */
    public RString getTekiyo8() {
        return tekiyo8;
    }

    /**
     * 摘要８のsetメソッドです。
     *
     * @param tekiyo8 摘要８
     */
    public void setTekiyo8(RString tekiyo8) {
        this.tekiyo8 = tekiyo8;
    }

    /**
     * 摘要９のgetメソッドです。
     *
     * @return 摘要９
     */
    public RString getTekiyo9() {
        return tekiyo9;
    }

    /**
     * 摘要９のsetメソッドです。
     *
     * @param tekiyo9 摘要９
     */
    public void setTekiyo9(RString tekiyo9) {
        this.tekiyo9 = tekiyo9;
    }

    /**
     * 摘要１０のgetメソッドです。
     *
     * @return 摘要１０
     */
    public RString getTekiyo10() {
        return tekiyo10;
    }

    /**
     * 摘要１０のsetメソッドです。
     *
     * @param tekiyo10 摘要１０
     */
    public void setTekiyo10(RString tekiyo10) {
        this.tekiyo10 = tekiyo10;
    }

    /**
     * 摘要１１のgetメソッドです。
     *
     * @return 摘要１１
     */
    public RString getTekiyo11() {
        return tekiyo11;
    }

    /**
     * 摘要１１のsetメソッドです。
     *
     * @param tekiyo11 摘要１１
     */
    public void setTekiyo11(RString tekiyo11) {
        this.tekiyo11 = tekiyo11;
    }

    /**
     * 摘要１２のgetメソッドです。
     *
     * @return 摘要１２
     */
    public RString getTekiyo12() {
        return tekiyo12;
    }

    /**
     * 摘要１２のsetメソッドです。
     *
     * @param tekiyo12 摘要１２
     */
    public void setTekiyo12(RString tekiyo12) {
        this.tekiyo12 = tekiyo12;
    }

    /**
     * 摘要１３のgetメソッドです。
     *
     * @return 摘要１３
     */
    public RString getTekiyo13() {
        return tekiyo13;
    }

    /**
     * 摘要１３のsetメソッドです。
     *
     * @param tekiyo13 摘要１３
     */
    public void setTekiyo13(RString tekiyo13) {
        this.tekiyo13 = tekiyo13;
    }

    /**
     * 摘要１４のgetメソッドです。
     *
     * @return 摘要１４
     */
    public RString getTekiyo14() {
        return tekiyo14;
    }

    /**
     * 摘要１４のsetメソッドです。
     *
     * @param tekiyo14 摘要１４
     */
    public void setTekiyo14(RString tekiyo14) {
        this.tekiyo14 = tekiyo14;
    }

    /**
     * 摘要１５のgetメソッドです。
     *
     * @return 摘要１５
     */
    public RString getTekiyo15() {
        return tekiyo15;
    }

    /**
     * 摘要１５のsetメソッドです。
     *
     * @param tekiyo15 摘要１５
     */
    public void setTekiyo15(RString tekiyo15) {
        this.tekiyo15 = tekiyo15;
    }

    /**
     * 摘要１６のgetメソッドです。
     *
     * @return 摘要１６
     */
    public RString getTekiyo16() {
        return tekiyo16;
    }

    /**
     * 摘要１６のsetメソッドです。
     *
     * @param tekiyo16 摘要１６
     */
    public void setTekiyo16(RString tekiyo16) {
        this.tekiyo16 = tekiyo16;
    }

    /**
     * 摘要１７のgetメソッドです。
     *
     * @return 摘要１７
     */
    public RString getTekiyo17() {
        return tekiyo17;
    }

    /**
     * 摘要１７のsetメソッドです。
     *
     * @param tekiyo17 摘要１７
     */
    public void setTekiyo17(RString tekiyo17) {
        this.tekiyo17 = tekiyo17;
    }

    /**
     * 摘要１８のgetメソッドです。
     *
     * @return 摘要１８
     */
    public RString getTekiyo18() {
        return tekiyo18;
    }

    /**
     * 摘要１８のsetメソッドです。
     *
     * @param tekiyo18 摘要１８
     */
    public void setTekiyo18(RString tekiyo18) {
        this.tekiyo18 = tekiyo18;
    }

    /**
     * 摘要１９のgetメソッドです。
     *
     * @return 摘要１９
     */
    public RString getTekiyo19() {
        return tekiyo19;
    }

    /**
     * 摘要１９のsetメソッドです。
     *
     * @param tekiyo19 摘要１９
     */
    public void setTekiyo19(RString tekiyo19) {
        this.tekiyo19 = tekiyo19;
    }

    /**
     * 摘要２０のgetメソッドです。
     *
     * @return 摘要２０
     */
    public RString getTekiyo20() {
        return tekiyo20;
    }

    /**
     * 摘要２０のsetメソッドです。
     *
     * @param tekiyo20 摘要２０
     */
    public void setTekiyo20(RString tekiyo20) {
        this.tekiyo20 = tekiyo20;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3041ShokanTokuteiShinryohiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (this.rirekiNo != other.rirekiNo) {
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
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, jigyoshaNo, yoshikiNo, junjiNo, rirekiNo, shobyoName, shidoKanriryoTanisu, tanjunXsenTanisu, rehabilitationTanisu, seishinkaSemmonRyoyohouTanisu, TotalTanisu, tekiyo1, tekiyo2, tekiyo3, tekiyo4, tekiyo5, tekiyo6, tekiyo7, tekiyo8, tekiyo9, tekiyo10, tekiyo11, tekiyo12, tekiyo13, tekiyo14, tekiyo15, tekiyo16, tekiyo17, tekiyo18, tekiyo19, tekiyo20);
    }

// </editor-fold>
}
