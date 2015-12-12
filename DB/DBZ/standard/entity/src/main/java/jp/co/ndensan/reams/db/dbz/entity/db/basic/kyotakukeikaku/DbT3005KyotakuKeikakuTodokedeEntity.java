package jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * DbT3005KyotakuKeikakuTodokedeの項目定義クラスです
 *
 */
public class DbT3005KyotakuKeikakuTodokedeEntity extends DbTableEntityBase<DbT3005KyotakuKeikakuTodokedeEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
    private FlexibleYearMonth taishoYM;
    @PrimaryKey
    private Decimal rirekiNo;
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
     * 対象年月のgetメソッドです。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth getTaishoYM() {
        return taishoYM;
    }

    /**
     * 対象年月のsetメソッドです。
     *
     * @param taishoYM 対象年月
     */
    public void setTaishoYM(FlexibleYearMonth taishoYM) {
        this.taishoYM = taishoYM;
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
     * 届出区分のgetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:暫定
     *
     * @return 届出区分
     */
    public RString getTodokedeKubun() {
        return todokedeKubun;
    }

    /**
     * 届出区分のsetメソッドです。
     * <br/>
     * <br/>1:新規,2:変更,3:暫定
     *
     * @param todokedeKubun 届出区分
     */
    public void setTodokedeKubun(RString todokedeKubun) {
        this.todokedeKubun = todokedeKubun;
    }

    /**
     * 届出年月日のgetメソッドです。
     *
     * @return 届出年月日
     */
    public FlexibleDate getTodokedeYMD() {
        return todokedeYMD;
    }

    /**
     * 届出年月日のsetメソッドです。
     *
     * @param todokedeYMD 届出年月日
     */
    public void setTodokedeYMD(FlexibleDate todokedeYMD) {
        this.todokedeYMD = todokedeYMD;
    }

    /**
     * 届出者氏名のgetメソッドです。
     *
     * @return 届出者氏名
     */
    public AtenaMeisho getTodokedeshaShimei() {
        return todokedeshaShimei;
    }

    /**
     * 届出者氏名のsetメソッドです。
     *
     * @param todokedeshaShimei 届出者氏名
     */
    public void setTodokedeshaShimei(AtenaMeisho todokedeshaShimei) {
        this.todokedeshaShimei = todokedeshaShimei;
    }

    /**
     * 届出者氏名カナのgetメソッドです。
     *
     * @return 届出者氏名カナ
     */
    public AtenaKanaMeisho getTodokedeshaShimeiKana() {
        return todokedeshaShimeiKana;
    }

    /**
     * 届出者氏名カナのsetメソッドです。
     *
     * @param todokedeshaShimeiKana 届出者氏名カナ
     */
    public void setTodokedeshaShimeiKana(AtenaKanaMeisho todokedeshaShimeiKana) {
        this.todokedeshaShimeiKana = todokedeshaShimeiKana;
    }

    /**
     * 届出者郵便番号のgetメソッドです。
     *
     * @return 届出者郵便番号
     */
    public YubinNo getTodokedeshaYubinNo() {
        return todokedeshaYubinNo;
    }

    /**
     * 届出者郵便番号のsetメソッドです。
     *
     * @param todokedeshaYubinNo 届出者郵便番号
     */
    public void setTodokedeshaYubinNo(YubinNo todokedeshaYubinNo) {
        this.todokedeshaYubinNo = todokedeshaYubinNo;
    }

    /**
     * 届出者住所のgetメソッドです。
     *
     * @return 届出者住所
     */
    public RString getTodokedeshaJusho() {
        return todokedeshaJusho;
    }

    /**
     * 届出者住所のsetメソッドです。
     *
     * @param todokedeshaJusho 届出者住所
     */
    public void setTodokedeshaJusho(RString todokedeshaJusho) {
        this.todokedeshaJusho = todokedeshaJusho;
    }

    /**
     * 届出者電話番号のgetメソッドです。
     *
     * @return 届出者電話番号
     */
    public TelNo getTodokedeshaTelNo() {
        return todokedeshaTelNo;
    }

    /**
     * 届出者電話番号のsetメソッドです。
     *
     * @param todokedeshaTelNo 届出者電話番号
     */
    public void setTodokedeshaTelNo(TelNo todokedeshaTelNo) {
        this.todokedeshaTelNo = todokedeshaTelNo;
    }

    /**
     * 届出者関係区分のgetメソッドです。
     * <br/>
     * <br/>1:本人,2:家族,3:代理人,4:サービス事業者,5:ケアマネージャ
     *
     * @return 届出者関係区分
     */
    public RString getTodokedeshaKankeiKubun() {
        return todokedeshaKankeiKubun;
    }

    /**
     * 届出者関係区分のsetメソッドです。
     * <br/>
     * <br/>1:本人,2:家族,3:代理人,4:サービス事業者,5:ケアマネージャ
     *
     * @param todokedeshaKankeiKubun 届出者関係区分
     */
    public void setTodokedeshaKankeiKubun(RString todokedeshaKankeiKubun) {
        this.todokedeshaKankeiKubun = todokedeshaKankeiKubun;
    }

    /**
     * 暫定区分のgetメソッドです。
     *
     * @return 暫定区分
     */
    public RString getZanteiKubun() {
        return zanteiKubun;
    }

    /**
     * 暫定区分のsetメソッドです。
     *
     * @param zanteiKubun 暫定区分
     */
    public void setZanteiKubun(RString zanteiKubun) {
        this.zanteiKubun = zanteiKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3005KyotakuKeikakuTodokedeEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
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
        if (!Objects.equals(this.taishoYM, other.taishoYM)) {
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
    public void shallowCopy(DbT3005KyotakuKeikakuTodokedeEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.taishoYM = entity.taishoYM;
        this.rirekiNo = entity.rirekiNo;
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
        return super.toMd5(hihokenshaNo, taishoYM, rirekiNo, todokedeKubun, todokedeYMD, todokedeshaShimei, todokedeshaShimeiKana, todokedeshaYubinNo, todokedeshaJusho, todokedeshaTelNo, todokedeshaKankeiKubun, zanteiKubun);
    }

// </editor-fold>
}
