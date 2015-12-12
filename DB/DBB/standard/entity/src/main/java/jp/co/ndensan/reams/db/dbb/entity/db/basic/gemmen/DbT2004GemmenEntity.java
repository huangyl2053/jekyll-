package jp.co.ndensan.reams.db.dbb.entity.db.basic.gemmen;

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
 * 介護賦課減免テーブルのエンティティクラスです。
 */
public class DbT2004GemmenEntity extends DbTableEntityBase<DbT2004GemmenEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT2004Gemmen");

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
    private Code gemmenJiyuCode;
    private RString gemmenJiyu;
    private Code gemmenTorikeshiJiyuCode;
    private RString gemmenTorikeshiJiyu;
    private Decimal shinseiGemmenGaku;
    private Decimal ketteiGemmenGaku;
    private Decimal torikeshiGemmenGaku;

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
     * 減免申請日のgetメソッドです。
     *
     * @return 減免申請日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 減免申請日のsetメソッドです。
     *
     * @param shinseiYMD 減免申請日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 減免決定日のgetメソッドです。
     *
     * @return 減免決定日
     */
    public FlexibleDate getKetteiYMD() {
        return ketteiYMD;
    }

    /**
     * 減免決定日のsetメソッドです。
     *
     * @param ketteiYMD 減免決定日
     */
    public void setKetteiYMD(FlexibleDate ketteiYMD) {
        this.ketteiYMD = ketteiYMD;
    }

    /**
     * 減免取消日のgetメソッドです。
     *
     * @return 減免取消日
     */
    public FlexibleDate getTorikeshiYMD() {
        return torikeshiYMD;
    }

    /**
     * 減免取消日のsetメソッドです。
     *
     * @param torikeshiYMD 減免取消日
     */
    public void setTorikeshiYMD(FlexibleDate torikeshiYMD) {
        this.torikeshiYMD = torikeshiYMD;
    }

    /**
     * 減免状態区分のgetメソッドです。
     * <br/>
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　9:論理削除
     *
     * @return 減免状態区分
     */
    public RString getJotaiKubun() {
        return jotaiKubun;
    }

    /**
     * 減免状態区分のsetメソッドです。
     * <br/>
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　9:論理削除
     *
     * @param jotaiKubun 減免状態区分
     */
    public void setJotaiKubun(RString jotaiKubun) {
        this.jotaiKubun = jotaiKubun;
    }

    /**
     * 減免作成区分のgetメソッドです。
     * <br/>
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　4:訂正　9:論理削除
     *
     * @return 減免作成区分
     */
    public RString getSakuseiKubun() {
        return sakuseiKubun;
    }

    /**
     * 減免作成区分のsetメソッドです。
     * <br/>
     * <br/>0:申請　1:決定(承認)　2:決定(不承認)　3:取消　4:訂正　9:論理削除
     *
     * @param sakuseiKubun 減免作成区分
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
     * 減免種類コードのgetメソッドです。
     *
     * @return 減免種類コード
     */
    public Code getGemmenJiyuCode() {
        return gemmenJiyuCode;
    }

    /**
     * 減免種類コードのsetメソッドです。
     *
     * @param gemmenJiyuCode 減免種類コード
     */
    public void setGemmenJiyuCode(Code gemmenJiyuCode) {
        this.gemmenJiyuCode = gemmenJiyuCode;
    }

    /**
     * 減免事由のgetメソッドです。
     *
     * @return 減免事由
     */
    public RString getGemmenJiyu() {
        return gemmenJiyu;
    }

    /**
     * 減免事由のsetメソッドです。
     *
     * @param gemmenJiyu 減免事由
     */
    public void setGemmenJiyu(RString gemmenJiyu) {
        this.gemmenJiyu = gemmenJiyu;
    }

    /**
     * 減免取消種類コードのgetメソッドです。
     *
     * @return 減免取消種類コード
     */
    public Code getGemmenTorikeshiJiyuCode() {
        return gemmenTorikeshiJiyuCode;
    }

    /**
     * 減免取消種類コードのsetメソッドです。
     *
     * @param gemmenTorikeshiJiyuCode 減免取消種類コード
     */
    public void setGemmenTorikeshiJiyuCode(Code gemmenTorikeshiJiyuCode) {
        this.gemmenTorikeshiJiyuCode = gemmenTorikeshiJiyuCode;
    }

    /**
     * 減免取消事由のgetメソッドです。
     *
     * @return 減免取消事由
     */
    public RString getGemmenTorikeshiJiyu() {
        return gemmenTorikeshiJiyu;
    }

    /**
     * 減免取消事由のsetメソッドです。
     *
     * @param gemmenTorikeshiJiyu 減免取消事由
     */
    public void setGemmenTorikeshiJiyu(RString gemmenTorikeshiJiyu) {
        this.gemmenTorikeshiJiyu = gemmenTorikeshiJiyu;
    }

    /**
     * 申請減免額のgetメソッドです。
     *
     * @return 申請減免額
     */
    public Decimal getShinseiGemmenGaku() {
        return shinseiGemmenGaku;
    }

    /**
     * 申請減免額のsetメソッドです。
     *
     * @param shinseiGemmenGaku 申請減免額
     */
    public void setShinseiGemmenGaku(Decimal shinseiGemmenGaku) {
        this.shinseiGemmenGaku = shinseiGemmenGaku;
    }

    /**
     * 決定減免額のgetメソッドです。
     *
     * @return 決定減免額
     */
    public Decimal getKetteiGemmenGaku() {
        return ketteiGemmenGaku;
    }

    /**
     * 決定減免額のsetメソッドです。
     *
     * @param ketteiGemmenGaku 決定減免額
     */
    public void setKetteiGemmenGaku(Decimal ketteiGemmenGaku) {
        this.ketteiGemmenGaku = ketteiGemmenGaku;
    }

    /**
     * 取消減免額のgetメソッドです。
     *
     * @return 取消減免額
     */
    public Decimal getTorikeshiGemmenGaku() {
        return torikeshiGemmenGaku;
    }

    /**
     * 取消減免額のsetメソッドです。
     *
     * @param torikeshiGemmenGaku 取消減免額
     */
    public void setTorikeshiGemmenGaku(Decimal torikeshiGemmenGaku) {
        this.torikeshiGemmenGaku = torikeshiGemmenGaku;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT2004GemmenEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT2004GemmenEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT2004GemmenEntity other) {
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
    public void shallowCopy(DbT2004GemmenEntity entity) {
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
        this.gemmenJiyuCode = entity.gemmenJiyuCode;
        this.gemmenJiyu = entity.gemmenJiyu;
        this.gemmenTorikeshiJiyuCode = entity.gemmenTorikeshiJiyuCode;
        this.gemmenTorikeshiJiyu = entity.gemmenTorikeshiJiyu;
        this.shinseiGemmenGaku = entity.shinseiGemmenGaku;
        this.ketteiGemmenGaku = entity.ketteiGemmenGaku;
        this.torikeshiGemmenGaku = entity.torikeshiGemmenGaku;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(choteiNendo, fukaNendo, tsuchishoNo, rirekiNo, shinseiYMD, ketteiYMD, torikeshiYMD, jotaiKubun, sakuseiKubun, shinseiJiyu, gemmenJiyuCode, gemmenJiyu, gemmenTorikeshiJiyuCode, gemmenTorikeshiJiyu, shinseiGemmenGaku, ketteiGemmenGaku, torikeshiGemmenGaku);
    }

// </editor-fold>
}
