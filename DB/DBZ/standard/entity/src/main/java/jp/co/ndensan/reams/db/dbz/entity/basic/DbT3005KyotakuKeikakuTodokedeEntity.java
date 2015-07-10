package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3005KyotakuKeikakuTodokedeの項目定義クラスです
 *
 */
public class DbT3005KyotakuKeikakuTodokedeEntity extends DbTableEntityBase<DbT3005KyotakuKeikakuTodokedeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3005KyotakuKeikakuTodokede");

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
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private YMDHMS shoriTimestamp;
    private RString todokedeKubun;
    private FlexibleDate todokedeYMD;
    private AtenaMeisho todokedeshaShimei;
    private AtenaKanaMeisho todokedeshaShimeiKana;
    private YubinNo todokedeshaYubinNo;
    private RString todokedeshaJusho;
    private TelNo todokedeshaTelNo;
    private RString todokedeshaKankeiKubun;
    private RString zanteiKubun;

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
     * getShoKisaiHokenshaNo
     *
     * @return shoKisaiHokenshaNo
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * setShoKisaiHokenshaNo
     *
     * @param shoKisaiHokenshaNo shoKisaiHokenshaNo
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * getShikibetsuCode
     *
     * @return shikibetsuCode
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * setShikibetsuCode
     *
     * @param shikibetsuCode shikibetsuCode
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * getTaishoYM
     *
     * @return taishoYM
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * setTaishoYM
     *
     * @param taishoYM taishoYM
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * getTodokedeKubun
     *
     * @return todokedeKubun
     */
    public RString getTodokedeKubun() {
        return todokedeKubun;
    }

    /**
     * setTodokedeKubun
     *
     * @param todokedeKubun todokedeKubun
     */
    public void setTodokedeKubun(RString todokedeKubun) {
        this.todokedeKubun = todokedeKubun;
    }

    /**
     * getTodokedeYMD
     *
     * @return todokedeYMD
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * setTodokedeYMD
     *
     * @param todokedeYMD todokedeYMD
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * getTodokedeshaShimei
     *
     * @return todokedeshaShimei
     */
    public AtenaMeisho getTodokedeshaShimei() {
        return todokedeshaShimei;
    }

    /**
     * setTodokedeshaShimei
     *
     * @param todokedeshaShimei todokedeshaShimei
     */
    public void setTodokedeshaShimei(AtenaMeisho todokedeshaShimei) {
        this.todokedeshaShimei = todokedeshaShimei;
    }

    /**
     * getTodokedeshaShimeiKana
     *
     * @return todokedeshaShimeiKana
     */
    public AtenaKanaMeisho getTodokedeshaShimeiKana() {
        return todokedeshaShimeiKana;
    }

    /**
     * setTodokedeshaShimeiKana
     *
     * @param todokedeshaShimeiKana todokedeshaShimeiKana
     */
    public void setTodokedeshaShimeiKana(AtenaKanaMeisho todokedeshaShimeiKana) {
        this.todokedeshaShimeiKana = todokedeshaShimeiKana;
    }

    /**
     * getTodokedeshaYubinNo
     *
     * @return todokedeshaYubinNo
     */
    public YubinNo getTodokedeshaYubinNo() {
        return todokedeshaYubinNo;
    }

    /**
     * setTodokedeshaYubinNo
     *
     * @param todokedeshaYubinNo todokedeshaYubinNo
     */
    public void setTodokedeshaYubinNo(YubinNo todokedeshaYubinNo) {
        this.todokedeshaYubinNo = todokedeshaYubinNo;
    }

    /**
     * getTodokedeshaJusho
     *
     * @return todokedeshaJusho
     */
    public RString getTodokedeshaJusho() {
        return todokedeshaJusho;
    }

    /**
     * setTodokedeshaJusho
     *
     * @param todokedeshaJusho todokedeshaJusho
     */
    public void setTodokedeshaJusho(RString todokedeshaJusho) {
        this.todokedeshaJusho = todokedeshaJusho;
    }

    /**
     * getTodokedeshaTelNo
     *
     * @return todokedeshaTelNo
     */
    public TelNo getTodokedeshaTelNo() {
        return todokedeshaTelNo;
    }

    /**
     * setTodokedeshaTelNo
     *
     * @param todokedeshaTelNo todokedeshaTelNo
     */
    public void setTodokedeshaTelNo(TelNo todokedeshaTelNo) {
        this.todokedeshaTelNo = todokedeshaTelNo;
    }

    /**
     * getTodokedeshaKankeiKubun
     *
     * @return todokedeshaKankeiKubun
     */
    public RString getTodokedeshaKankeiKubun() {
        return todokedeshaKankeiKubun;
    }

    /**
     * setTodokedeshaKankeiKubun
     *
     * @param todokedeshaKankeiKubun todokedeshaKankeiKubun
     */
    public void setTodokedeshaKankeiKubun(RString todokedeshaKankeiKubun) {
        this.todokedeshaKankeiKubun = todokedeshaKankeiKubun;
    }

    /**
     * getZanteiKubun
     *
     * @return zanteiKubun
     */
    public RString getZanteiKubun() {
        return zanteiKubun;
    }

    /**
     * setZanteiKubun
     *
     * @param zanteiKubun zanteiKubun
     */
    public void setZanteiKubun(RString zanteiKubun) {
        this.zanteiKubun = zanteiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3005KyotakuKeikakuTodokedeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3005KyotakuKeikakuTodokedeEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3005KyotakuKeikakuTodokedeEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.taishoYM = entity.taishoYM;
        this.shoriTimestamp = entity.shoriTimestamp;
        this.todokedeKubun = entity.todokedeKubun;
        this.todokedeYMD = entity.todokedeYMD;
        this.todokedeshaShimei = entity.todokedeshaShimei;
        this.todokedeshaShimeiKana = entity.todokedeshaShimeiKana;
        this.todokedeshaYubinNo = entity.todokedeshaYubinNo;
        this.todokedeshaJusho = entity.todokedeshaJusho;
        this.todokedeshaTelNo = entity.todokedeshaTelNo;
        this.todokedeshaKankeiKubun = entity.todokedeshaKankeiKubun;
        this.zanteiKubun = entity.zanteiKubun;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, shoKisaiHokenshaNo, shikibetsuCode, taishoYM, shoriTimestamp, todokedeKubun, todokedeYMD, todokedeshaShimei, todokedeshaShimeiKana, todokedeshaYubinNo, todokedeshaJusho, todokedeshaTelNo, todokedeshaKankeiKubun, zanteiKubun);
    }

// </editor-fold>
}
