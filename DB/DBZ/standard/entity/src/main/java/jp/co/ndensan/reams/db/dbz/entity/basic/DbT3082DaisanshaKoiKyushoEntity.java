package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3082DaisanshaKoiKyushoの項目定義クラスです
 *
 */
public class DbT3082DaisanshaKoiKyushoEntity extends DbTableEntityBase<DbT3082DaisanshaKoiKyushoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3082DaisanshaKoiKyusho");

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
    private RString todokedeKanriNo;
    @PrimaryKey
    private RString kyushoSeikyuNo;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private Decimal kyufuGakuGokei;
    private Decimal kashitsuSosatsuGaku;
    private Decimal hokenKyufuSeikyuGaku;
    private FlexibleDate songaiBaishoKinNonyuYMD;
    private YubinNo seikyusakiYubinNo;
    private RString seikyusakiJusho;
    private AtenaMeisho seikyusakiMeisho;
    private RString seikyusakiBusho;
    private AtenaMeisho seikyusakiTantosha;
    private TelNo seikyusakiTelNo;

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
     * getHihokenshaNo
     *
     * @return hihokenshaNo
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * setHihokenshaNo
     *
     * @param hihokenshaNo hihokenshaNo
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * getTodokedeKanriNo
     *
     * @return todokedeKanriNo
     */
    public RString getTodokedeKanriNo() {
        return todokedeKanriNo;
    }

    /**
     * setTodokedeKanriNo
     *
     * @param todokedeKanriNo todokedeKanriNo
     */
    public void setTodokedeKanriNo(RString todokedeKanriNo) {
        this.todokedeKanriNo = todokedeKanriNo;
    }

    /**
     * getKyushoSeikyuNo
     *
     * @return kyushoSeikyuNo
     */
    public RString getKyushoSeikyuNo() {
        return kyushoSeikyuNo;
    }

    /**
     * setKyushoSeikyuNo
     *
     * @param kyushoSeikyuNo kyushoSeikyuNo
     */
    public void setKyushoSeikyuNo(RString kyushoSeikyuNo) {
        this.kyushoSeikyuNo = kyushoSeikyuNo;
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
     * getKyufuGakuGokei
     *
     * @return kyufuGakuGokei
     */
    public Decimal getKyufuGakuGokei() {
        return kyufuGakuGokei;
    }

    /**
     * setKyufuGakuGokei
     *
     * @param kyufuGakuGokei kyufuGakuGokei
     */
    public void setKyufuGakuGokei(Decimal kyufuGakuGokei) {
        this.kyufuGakuGokei = kyufuGakuGokei;
    }

    /**
     * getKashitsuSosatsuGaku
     *
     * @return kashitsuSosatsuGaku
     */
    public Decimal getKashitsuSosatsuGaku() {
        return kashitsuSosatsuGaku;
    }

    /**
     * setKashitsuSosatsuGaku
     *
     * @param kashitsuSosatsuGaku kashitsuSosatsuGaku
     */
    public void setKashitsuSosatsuGaku(Decimal kashitsuSosatsuGaku) {
        this.kashitsuSosatsuGaku = kashitsuSosatsuGaku;
    }

    /**
     * getHokenKyufuSeikyuGaku
     *
     * @return hokenKyufuSeikyuGaku
     */
    public Decimal getHokenKyufuSeikyuGaku() {
        return hokenKyufuSeikyuGaku;
    }

    /**
     * setHokenKyufuSeikyuGaku
     *
     * @param hokenKyufuSeikyuGaku hokenKyufuSeikyuGaku
     */
    public void setHokenKyufuSeikyuGaku(Decimal hokenKyufuSeikyuGaku) {
        this.hokenKyufuSeikyuGaku = hokenKyufuSeikyuGaku;
    }

    /**
     * getSongaiBaishoKinNonyuYMD
     *
     * @return songaiBaishoKinNonyuYMD
     */
    public FlexibleDate getSongaiBaishoKinNonyuYMD() {
        return songaiBaishoKinNonyuYMD;
    }

    /**
     * setSongaiBaishoKinNonyuYMD
     *
     * @param songaiBaishoKinNonyuYMD songaiBaishoKinNonyuYMD
     */
    public void setSongaiBaishoKinNonyuYMD(FlexibleDate songaiBaishoKinNonyuYMD) {
        this.songaiBaishoKinNonyuYMD = songaiBaishoKinNonyuYMD;
    }

    /**
     * getSeikyusakiYubinNo
     *
     * @return seikyusakiYubinNo
     */
    public YubinNo getSeikyusakiYubinNo() {
        return seikyusakiYubinNo;
    }

    /**
     * setSeikyusakiYubinNo
     *
     * @param seikyusakiYubinNo seikyusakiYubinNo
     */
    public void setSeikyusakiYubinNo(YubinNo seikyusakiYubinNo) {
        this.seikyusakiYubinNo = seikyusakiYubinNo;
    }

    /**
     * getSeikyusakiJusho
     *
     * @return seikyusakiJusho
     */
    public RString getSeikyusakiJusho() {
        return seikyusakiJusho;
    }

    /**
     * setSeikyusakiJusho
     *
     * @param seikyusakiJusho seikyusakiJusho
     */
    public void setSeikyusakiJusho(RString seikyusakiJusho) {
        this.seikyusakiJusho = seikyusakiJusho;
    }

    /**
     * getSeikyusakiMeisho
     *
     * @return seikyusakiMeisho
     */
    public AtenaMeisho getSeikyusakiMeisho() {
        return seikyusakiMeisho;
    }

    /**
     * setSeikyusakiMeisho
     *
     * @param seikyusakiMeisho seikyusakiMeisho
     */
    public void setSeikyusakiMeisho(AtenaMeisho seikyusakiMeisho) {
        this.seikyusakiMeisho = seikyusakiMeisho;
    }

    /**
     * getSeikyusakiBusho
     *
     * @return seikyusakiBusho
     */
    public RString getSeikyusakiBusho() {
        return seikyusakiBusho;
    }

    /**
     * setSeikyusakiBusho
     *
     * @param seikyusakiBusho seikyusakiBusho
     */
    public void setSeikyusakiBusho(RString seikyusakiBusho) {
        this.seikyusakiBusho = seikyusakiBusho;
    }

    /**
     * getSeikyusakiTantosha
     *
     * @return seikyusakiTantosha
     */
    public AtenaMeisho getSeikyusakiTantosha() {
        return seikyusakiTantosha;
    }

    /**
     * setSeikyusakiTantosha
     *
     * @param seikyusakiTantosha seikyusakiTantosha
     */
    public void setSeikyusakiTantosha(AtenaMeisho seikyusakiTantosha) {
        this.seikyusakiTantosha = seikyusakiTantosha;
    }

    /**
     * getSeikyusakiTelNo
     *
     * @return seikyusakiTelNo
     */
    public TelNo getSeikyusakiTelNo() {
        return seikyusakiTelNo;
    }

    /**
     * setSeikyusakiTelNo
     *
     * @param seikyusakiTelNo seikyusakiTelNo
     */
    public void setSeikyusakiTelNo(TelNo seikyusakiTelNo) {
        this.seikyusakiTelNo = seikyusakiTelNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3082DaisanshaKoiKyushoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3082DaisanshaKoiKyushoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3082DaisanshaKoiKyushoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.todokedeKanriNo, other.todokedeKanriNo)) {
            return false;
        }
        if (!Objects.equals(this.kyushoSeikyuNo, other.kyushoSeikyuNo)) {
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
    public void shallowCopy(DbT3082DaisanshaKoiKyushoEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.todokedeKanriNo = entity.todokedeKanriNo;
        this.kyushoSeikyuNo = entity.kyushoSeikyuNo;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.kyufuGakuGokei = entity.kyufuGakuGokei;
        this.kashitsuSosatsuGaku = entity.kashitsuSosatsuGaku;
        this.hokenKyufuSeikyuGaku = entity.hokenKyufuSeikyuGaku;
        this.songaiBaishoKinNonyuYMD = entity.songaiBaishoKinNonyuYMD;
        this.seikyusakiYubinNo = entity.seikyusakiYubinNo;
        this.seikyusakiJusho = entity.seikyusakiJusho;
        this.seikyusakiMeisho = entity.seikyusakiMeisho;
        this.seikyusakiBusho = entity.seikyusakiBusho;
        this.seikyusakiTantosha = entity.seikyusakiTantosha;
        this.seikyusakiTelNo = entity.seikyusakiTelNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, todokedeKanriNo, kyushoSeikyuNo, shoriTimestamp, kyufuGakuGokei, kashitsuSosatsuGaku, hokenKyufuSeikyuGaku, songaiBaishoKinNonyuYMD, seikyusakiYubinNo, seikyusakiJusho, seikyusakiMeisho, seikyusakiBusho, seikyusakiTantosha, seikyusakiTelNo);
    }

// </editor-fold>
}
