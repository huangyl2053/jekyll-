package jp.co.ndensan.reams.db.dbc.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 利用者負担割合テーブルのエンティティクラスです。
 */
public class DbT3113RiyoshaFutanWariaiEntity extends DbTableEntityBase<DbT3113RiyoshaFutanWariaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3113RiyoshaFutanWariai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear nendo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private boolean hakoFuyoFlag;
    private boolean shokenFlag;
    private FlexibleDate hanteiYMD;
    private RString hanteiKubun;
    private Code koseiJiyu;
    private RString hakoKubun;
    private FlexibleDate hakoYMD;
    private FlexibleDate kofuYMD;

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
     * 年度のgetメソッドです。
     *
     * @return 年度
     */
    public FlexibleYear getNendo() {
        return nendo;
    }

    /**
     * 年度のsetメソッドです。
     *
     * @param nendo 年度
     */
    public void setNendo(FlexibleYear nendo) {
        this.nendo = nendo;
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
     * 発行不要フラグのgetメソッドです。
     *
     * @return 発行不要フラグ
     */
    public boolean getHakoFuyoFlag() {
        return hakoFuyoFlag;
    }

    /**
     * 発行不要フラグのsetメソッドです。
     *
     * @param hakoFuyoFlag 発行不要フラグ
     */
    public void setHakoFuyoFlag(boolean hakoFuyoFlag) {
        this.hakoFuyoFlag = hakoFuyoFlag;
    }

    /**
     * 職権変更フラグのgetメソッドです。
     *
     * @return 職権変更フラグ
     */
    public boolean getShokenFlag() {
        return shokenFlag;
    }

    /**
     * 職権変更フラグのsetメソッドです。
     *
     * @param shokenFlag 職権変更フラグ
     */
    public void setShokenFlag(boolean shokenFlag) {
        this.shokenFlag = shokenFlag;
    }

    /**
     * 判定日のgetメソッドです。
     *
     * @return 判定日
     */
    public FlexibleDate getHanteiYMD() {
        return hanteiYMD;
    }

    /**
     * 判定日のsetメソッドです。
     *
     * @param hanteiYMD 判定日
     */
    public void setHanteiYMD(FlexibleDate hanteiYMD) {
        this.hanteiYMD = hanteiYMD;
    }

    /**
     * 判定区分のgetメソッドです。
     * <br/>
     * <br/>1：年次判定　2：異動分判定　3：過年度分判定　3：即時更正
     *
     * @return 判定区分
     */
    public RString getHanteiKubun() {
        return hanteiKubun;
    }

    /**
     * 判定区分のsetメソッドです。
     * <br/>
     * <br/>1：年次判定　2：異動分判定　3：過年度分判定　3：即時更正
     *
     * @param hanteiKubun 判定区分
     */
    public void setHanteiKubun(RString hanteiKubun) {
        this.hanteiKubun = hanteiKubun;
    }

    /**
     * 更正事由のgetメソッドです。
     * <br/>
     * <br/>コードマスタ（DBD　種別=999）
     *
     * <br/>00：当初（継続、新規認定）
     *
     * <br/>10：本人所得更正
     *
     * <br/>20：世帯員所得更正
     *
     * <br/>30：世帯構成変更
     *
     * <br/>40: その他（即時判定など）
     *
     * @return 更正事由
     */
    public Code getKoseiJiyu() {
        return koseiJiyu;
    }

    /**
     * 更正事由のsetメソッドです。
     * <br/>
     * <br/>コードマスタ（DBD　種別=999）
     *
     * <br/>00：当初（継続、新規認定）
     *
     * <br/>10：本人所得更正
     *
     * <br/>20：世帯員所得更正
     *
     * <br/>30：世帯構成変更
     *
     * <br/>40: その他（即時判定など）
     *
     * @param koseiJiyu 更正事由
     */
    public void setKoseiJiyu(Code koseiJiyu) {
        this.koseiJiyu = koseiJiyu;
    }

    /**
     * 発行区分のgetメソッドです。
     * <br/>
     * <br/>0：未発行
     *
     * <br/>1：一括発行で発行済み。
     *
     * <br/>2：単票発行で発行済み。
     *
     * @return 発行区分
     */
    public RString getHakoKubun() {
        return hakoKubun;
    }

    /**
     * 発行区分のsetメソッドです。
     * <br/>
     * <br/>0：未発行
     *
     * <br/>1：一括発行で発行済み。
     *
     * <br/>2：単票発行で発行済み。
     *
     * @param hakoKubun 発行区分
     */
    public void setHakoKubun(RString hakoKubun) {
        this.hakoKubun = hakoKubun;
    }

    /**
     * 発行日のgetメソッドです。
     *
     * @return 発行日
     */
    public FlexibleDate getHakoYMD() {
        return hakoYMD;
    }

    /**
     * 発行日のsetメソッドです。
     *
     * @param hakoYMD 発行日
     */
    public void setHakoYMD(FlexibleDate hakoYMD) {
        this.hakoYMD = hakoYMD;
    }

    /**
     * 交付日のgetメソッドです。
     *
     * @return 交付日
     */
    public FlexibleDate getKofuYMD() {
        return kofuYMD;
    }

    /**
     * 交付日のsetメソッドです。
     *
     * @param kofuYMD 交付日
     */
    public void setKofuYMD(FlexibleDate kofuYMD) {
        this.kofuYMD = kofuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3113RiyoshaFutanWariaiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3113RiyoshaFutanWariaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3113RiyoshaFutanWariaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.nendo, other.nendo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3113RiyoshaFutanWariaiEntity entity) {
        this.nendo = entity.nendo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.hakoFuyoFlag = entity.hakoFuyoFlag;
        this.shokenFlag = entity.shokenFlag;
        this.hanteiYMD = entity.hanteiYMD;
        this.hanteiKubun = entity.hanteiKubun;
        this.koseiJiyu = entity.koseiJiyu;
        this.hakoKubun = entity.hakoKubun;
        this.hakoYMD = entity.hakoYMD;
        this.kofuYMD = entity.kofuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(nendo, hihokenshaNo, rirekiNo, hakoFuyoFlag, shokenFlag, hanteiYMD, hanteiKubun, koseiJiyu, hakoKubun, hakoYMD, kofuYMD);
    }

// </editor-fold>
}
