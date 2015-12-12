package jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
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
 * 介護賦課徴収猶予テーブルのエンティティクラスです。
 */
public class DbT2006ChoshuYuyoEntity extends DbTableEntityBase<DbT2006ChoshuYuyoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2006ChoshuYuyo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleYear choteiNendo;
    @PrimaryKey
    private FlexibleYear fukaNendo;
    @PrimaryKey
    private TsuchishoNo tsuchishoNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate shinseiYMD;
    private FlexibleDate ketteiYMD;
    private FlexibleDate torikeshiYMD;
    private RString jotaiKubun;
    private RString sakuseiKubun;
    private RString shinseiJiyu;
    private Code yuyoJiyuCode;
    private RString yuyoJiyu;
    private Code yuyoTorikeshiJiyuCode;
    private RString yuyoTorikeshiJiyu;

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
     * 徴収猶予申請年月日のgetメソッドです。
     *
     * @return 徴収猶予申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 徴収猶予申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 徴収猶予申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 徴収猶予決定年月日のgetメソッドです。
     *
     * @return 徴収猶予決定年月日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 徴収猶予決定年月日のsetメソッドです。
     *
     * @param ketteiYMD 徴収猶予決定年月日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 徴収猶予取消年月日のgetメソッドです。
     *
     * @return 徴収猶予取消年月日
     */
    public FlexibleDate getTorikeshiYMD() {
        return torikeshiYMD;
    }

    /**
     * 徴収猶予取消年月日のsetメソッドです。
     *
     * @param torikeshiYMD 徴収猶予取消年月日
     */
    public void setTorikeshiYMD(FlexibleDate torikeshiYMD) {
        this.torikeshiYMD = torikeshiYMD;
    }

    /**
     * 徴収猶予状態区分のgetメソッドです。
     *
     * @return 徴収猶予状態区分
     */
    public RString getJotaiKubun() {
        return jotaiKubun;
    }

    /**
     * 徴収猶予状態区分のsetメソッドです。
     *
     * @param jotaiKubun 徴収猶予状態区分
     */
    public void setJotaiKubun(RString jotaiKubun) {
        this.jotaiKubun = jotaiKubun;
    }

    /**
     * 徴収猶予作成区分のgetメソッドです。
     *
     * @return 徴収猶予作成区分
     */
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * 徴収猶予作成区分のsetメソッドです。
     *
     * @param sakuseiKubun 徴収猶予作成区分
     */
    public void setSakuseiKubun(RString sakuseiKubun) {
        this.sakuseiKubun = sakuseiKubun;
    }

    /**
     * 申請事由のgetメソッドです。
     *
     * @return 申請事由
     */
    public RString getShinseiJiyu() {
        return shinseiJiyu;
    }

    /**
     * 申請事由のsetメソッドです。
     *
     * @param shinseiJiyu 申請事由
     */
    public void setShinseiJiyu(RString shinseiJiyu) {
        this.shinseiJiyu = shinseiJiyu;
    }

    /**
     * 徴収猶予種類コードのgetメソッドです。
     *
     * @return 徴収猶予種類コード
     */
    public Code getYuyoJiyuCode() {
        return yuyoJiyuCode;
    }

    /**
     * 徴収猶予種類コードのsetメソッドです。
     *
     * @param yuyoJiyuCode 徴収猶予種類コード
     */
    public void setYuyoJiyuCode(Code yuyoJiyuCode) {
        this.yuyoJiyuCode = yuyoJiyuCode;
    }

    /**
     * 徴収猶予事由のgetメソッドです。
     *
     * @return 徴収猶予事由
     */
    public RString getYuyoJiyu() {
        return yuyoJiyu;
    }

    /**
     * 徴収猶予事由のsetメソッドです。
     *
     * @param yuyoJiyu 徴収猶予事由
     */
    public void setYuyoJiyu(RString yuyoJiyu) {
        this.yuyoJiyu = yuyoJiyu;
    }

    /**
     * 徴収猶予取消種類コードのgetメソッドです。
     *
     * @return 徴収猶予取消種類コード
     */
    public Code getYuyoTorikeshiJiyuCode() {
        return yuyoTorikeshiJiyuCode;
    }

    /**
     * 徴収猶予取消種類コードのsetメソッドです。
     *
     * @param yuyoTorikeshiJiyuCode 徴収猶予取消種類コード
     */
    public void setYuyoTorikeshiJiyuCode(Code yuyoTorikeshiJiyuCode) {
        this.yuyoTorikeshiJiyuCode = yuyoTorikeshiJiyuCode;
    }

    /**
     * 徴収猶予取消事由のgetメソッドです。
     *
     * @return 徴収猶予取消事由
     */
    public RString getYuyoTorikeshiJiyu() {
        return yuyoTorikeshiJiyu;
    }

    /**
     * 徴収猶予取消事由のsetメソッドです。
     *
     * @param yuyoTorikeshiJiyu 徴収猶予取消事由
     */
    public void setYuyoTorikeshiJiyu(RString yuyoTorikeshiJiyu) {
        this.yuyoTorikeshiJiyu = yuyoTorikeshiJiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2006ChoshuYuyoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2006ChoshuYuyoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2006ChoshuYuyoEntity other) {
        if (other == null) {
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
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT2006ChoshuYuyoEntity entity) {
        this.choteiNendo = entity.choteiNendo;
        this.fukaNendo = entity.fukaNendo;
        this.tsuchishoNo = entity.tsuchishoNo;
        this.rirekiNo = entity.rirekiNo;
        this.shinseiYMD = entity.shinseiYMD;
        this.ketteiYMD = entity.ketteiYMD;
        this.torikeshiYMD = entity.torikeshiYMD;
        this.jotaiKubun = entity.jotaiKubun;
        this.sakuseiKubun = entity.sakuseiKubun;
        this.shinseiJiyu = entity.shinseiJiyu;
        this.yuyoJiyuCode = entity.yuyoJiyuCode;
        this.yuyoJiyu = entity.yuyoJiyu;
        this.yuyoTorikeshiJiyuCode = entity.yuyoTorikeshiJiyuCode;
        this.yuyoTorikeshiJiyu = entity.yuyoTorikeshiJiyu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, shinseiYMD, ketteiYMD, torikeshiYMD, jotaiKubun, sakuseiKubun, shinseiJiyu, yuyoJiyuCode, yuyoJiyu, yuyoTorikeshiJiyuCode, yuyoTorikeshiJiyu);
    }

// </editor-fold>
}
