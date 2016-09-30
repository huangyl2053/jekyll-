package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 特定個人情報提供管理テーブルのエンティティクラスです。
 */
public class DbT7304TokuteiKojinJohoTeikyoKanriEntity extends DbTableEntityBase<DbT7304TokuteiKojinJohoTeikyoKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7304TokuteiKojinJohoTeikyoKanri");

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
    private RString dataSetRecordKey;
    private RDateTime teikyoNichiji;
    private RString shinkiIdoKubun;
    private RString teikyoKubun;
    private RString tokuteiKojinJohoMeiCode;
    private RString hanNo;
    private RString dataSetNo;
    private FlexibleDate kokaiYMD;
    private ShikibetsuCode tateNo;
    private RString soshinNaiyo01;
    private RString misetteiJiyu01;
    private RString soshinNaiyo02;
    private RString misetteiJiyu02;
    private RString soshinNaiyo03;
    private RString misetteiJiyu03;
    private RString soshinNaiyo04;
    private RString misetteiJiyu04;
    private RString soshinNaiyo05;
    private RString misetteiJiyu05;
    private RString soshinNaiyo06;
    private RString misetteiJiyu06;
    private RString soshinNaiyo07;
    private RString misetteiJiyu07;
    private RString soshinNaiyo08;
    private RString misetteiJiyu08;
    private RString soshinNaiyo09;
    private RString misetteiJiyu09;
    private RString soshinNaiyo10;
    private RString misetteiJiyu10;

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
     * <br/>
     * <br/>年報時は、年度を設定
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * データセットレコードキーのgetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     *
     * @return データセットレコードキー
     */
    public RString getDataSetRecordKey() {
        return dataSetRecordKey;
    }

    /**
     * データセットレコードキーのsetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     *
     * @param dataSetRecordKey データセットレコードキー
     */
    public void setDataSetRecordKey(@Nonnull RString dataSetRecordKey) {
        this.dataSetRecordKey = dataSetRecordKey;
    }

    /**
     * 提供日時のgetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     *
     * @return 提供日時
     */
    @CheckForNull
    public RDateTime getTeikyoNichiji() {
        return teikyoNichiji;
    }

    /**
     * 提供日時のsetメソッドです。
     * <br/>
     * <br/>年報時は、年度を設定
     *
     * @param teikyoNichiji 提供日時
     */
    public void setTeikyoNichiji(RDateTime teikyoNichiji) {
        this.teikyoNichiji = teikyoNichiji;
    }

    /**
     * 新規異動区分のgetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     *
     * @return 新規異動区分
     */
    @CheckForNull
    public RString getShinkiIdoKubun() {
        return shinkiIdoKubun;
    }

    /**
     * 新規異動区分のsetメソッドです。
     * <br/>
     * <br/>年報時は、「00」を設定
     *
     * @param shinkiIdoKubun 新規異動区分
     */
    public void setShinkiIdoKubun(RString shinkiIdoKubun) {
        this.shinkiIdoKubun = shinkiIdoKubun;
    }

    /**
     * 提供区分のgetメソッドです。
     * <br/>
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     *
     * @return 提供区分
     */
    @CheckForNull
    public RString getTeikyoKubun() {
        return teikyoKubun;
    }

    /**
     * 提供区分のsetメソッドです。
     * <br/>
     * <br/>広域の場合、広域保険者か構成市町村か、 合併市町村の場合、新市町村か旧市町村か
     *
     * @param teikyoKubun 提供区分
     */
    public void setTeikyoKubun(RString teikyoKubun) {
        this.teikyoKubun = teikyoKubun;
    }

    /**
     * 特定個人情報名コードのgetメソッドです。
     *
     * @return 特定個人情報名コード
     */
    @CheckForNull
    public RString getTokuteiKojinJohoMeiCode() {
        return tokuteiKojinJohoMeiCode;
    }

    /**
     * 特定個人情報名コードのsetメソッドです。
     *
     * @param tokuteiKojinJohoMeiCode 特定個人情報名コード
     */
    public void setTokuteiKojinJohoMeiCode(RString tokuteiKojinJohoMeiCode) {
        this.tokuteiKojinJohoMeiCode = tokuteiKojinJohoMeiCode;
    }

    /**
     * 版番号のgetメソッドです。
     *
     * @return 版番号
     */
    @CheckForNull
    public RString getHanNo() {
        return hanNo;
    }

    /**
     * 版番号のsetメソッドです。
     *
     * @param hanNo 版番号
     */
    public void setHanNo(RString hanNo) {
        this.hanNo = hanNo;
    }

    /**
     * データセット番号のgetメソッドです。
     *
     * @return データセット番号
     */
    @CheckForNull
    public RString getDataSetNo() {
        return dataSetNo;
    }

    /**
     * データセット番号のsetメソッドです。
     *
     * @param dataSetNo データセット番号
     */
    public void setDataSetNo(RString dataSetNo) {
        this.dataSetNo = dataSetNo;
    }

    /**
     * 公開年月日のgetメソッドです。
     *
     * @return 公開年月日
     */
    @CheckForNull
    public FlexibleDate getKokaiYMD() {
        return kokaiYMD;
    }

    /**
     * 公開年月日のsetメソッドです。
     *
     * @param kokaiYMD 公開年月日
     */
    public void setKokaiYMD(FlexibleDate kokaiYMD) {
        this.kokaiYMD = kokaiYMD;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    @CheckForNull
    public ShikibetsuCode getTateNo() {
        return tateNo;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param tateNo 識別コード
     */
    public void setTateNo(ShikibetsuCode tateNo) {
        this.tateNo = tateNo;
    }

    /**
     * 送信内容１のgetメソッドです。
     *
     * @return 送信内容１
     */
    @CheckForNull
    public RString getSoshinNaiyo01() {
        return soshinNaiyo01;
    }

    /**
     * 送信内容１のsetメソッドです。
     *
     * @param soshinNaiyo01 送信内容１
     */
    public void setSoshinNaiyo01(RString soshinNaiyo01) {
        this.soshinNaiyo01 = soshinNaiyo01;
    }

    /**
     * 未設定事由１のgetメソッドです。
     *
     * @return 未設定事由１
     */
    @CheckForNull
    public RString getMisetteiJiyu01() {
        return misetteiJiyu01;
    }

    /**
     * 未設定事由１のsetメソッドです。
     *
     * @param misetteiJiyu01 未設定事由１
     */
    public void setMisetteiJiyu01(RString misetteiJiyu01) {
        this.misetteiJiyu01 = misetteiJiyu01;
    }

    /**
     * 送信内容２のgetメソッドです。
     *
     * @return 送信内容２
     */
    @CheckForNull
    public RString getSoshinNaiyo02() {
        return soshinNaiyo02;
    }

    /**
     * 送信内容２のsetメソッドです。
     *
     * @param soshinNaiyo02 送信内容２
     */
    public void setSoshinNaiyo02(RString soshinNaiyo02) {
        this.soshinNaiyo02 = soshinNaiyo02;
    }

    /**
     * 未設定事由２のgetメソッドです。
     *
     * @return 未設定事由２
     */
    @CheckForNull
    public RString getMisetteiJiyu02() {
        return misetteiJiyu02;
    }

    /**
     * 未設定事由２のsetメソッドです。
     *
     * @param misetteiJiyu02 未設定事由２
     */
    public void setMisetteiJiyu02(RString misetteiJiyu02) {
        this.misetteiJiyu02 = misetteiJiyu02;
    }

    /**
     * 送信内容３のgetメソッドです。
     *
     * @return 送信内容３
     */
    @CheckForNull
    public RString getSoshinNaiyo03() {
        return soshinNaiyo03;
    }

    /**
     * 送信内容３のsetメソッドです。
     *
     * @param soshinNaiyo03 送信内容３
     */
    public void setSoshinNaiyo03(RString soshinNaiyo03) {
        this.soshinNaiyo03 = soshinNaiyo03;
    }

    /**
     * 未設定事由３のgetメソッドです。
     *
     * @return 未設定事由３
     */
    @CheckForNull
    public RString getMisetteiJiyu03() {
        return misetteiJiyu03;
    }

    /**
     * 未設定事由３のsetメソッドです。
     *
     * @param misetteiJiyu03 未設定事由３
     */
    public void setMisetteiJiyu03(RString misetteiJiyu03) {
        this.misetteiJiyu03 = misetteiJiyu03;
    }

    /**
     * 送信内容４のgetメソッドです。
     *
     * @return 送信内容４
     */
    @CheckForNull
    public RString getSoshinNaiyo04() {
        return soshinNaiyo04;
    }

    /**
     * 送信内容４のsetメソッドです。
     *
     * @param soshinNaiyo04 送信内容４
     */
    public void setSoshinNaiyo04(RString soshinNaiyo04) {
        this.soshinNaiyo04 = soshinNaiyo04;
    }

    /**
     * 未設定事由４のgetメソッドです。
     *
     * @return 未設定事由４
     */
    @CheckForNull
    public RString getMisetteiJiyu04() {
        return misetteiJiyu04;
    }

    /**
     * 未設定事由４のsetメソッドです。
     *
     * @param misetteiJiyu04 未設定事由４
     */
    public void setMisetteiJiyu04(RString misetteiJiyu04) {
        this.misetteiJiyu04 = misetteiJiyu04;
    }

    /**
     * 送信内容５のgetメソッドです。
     *
     * @return 送信内容５
     */
    @CheckForNull
    public RString getSoshinNaiyo05() {
        return soshinNaiyo05;
    }

    /**
     * 送信内容５のsetメソッドです。
     *
     * @param soshinNaiyo05 送信内容５
     */
    public void setSoshinNaiyo05(RString soshinNaiyo05) {
        this.soshinNaiyo05 = soshinNaiyo05;
    }

    /**
     * 未設定事由５のgetメソッドです。
     *
     * @return 未設定事由５
     */
    @CheckForNull
    public RString getMisetteiJiyu05() {
        return misetteiJiyu05;
    }

    /**
     * 未設定事由５のsetメソッドです。
     *
     * @param misetteiJiyu05 未設定事由５
     */
    public void setMisetteiJiyu05(RString misetteiJiyu05) {
        this.misetteiJiyu05 = misetteiJiyu05;
    }

    /**
     * 送信内容６のgetメソッドです。
     *
     * @return 送信内容６
     */
    @CheckForNull
    public RString getSoshinNaiyo06() {
        return soshinNaiyo06;
    }

    /**
     * 送信内容６のsetメソッドです。
     *
     * @param soshinNaiyo06 送信内容６
     */
    public void setSoshinNaiyo06(RString soshinNaiyo06) {
        this.soshinNaiyo06 = soshinNaiyo06;
    }

    /**
     * 未設定事由６のgetメソッドです。
     *
     * @return 未設定事由６
     */
    @CheckForNull
    public RString getMisetteiJiyu06() {
        return misetteiJiyu06;
    }

    /**
     * 未設定事由６のsetメソッドです。
     *
     * @param misetteiJiyu06 未設定事由６
     */
    public void setMisetteiJiyu06(RString misetteiJiyu06) {
        this.misetteiJiyu06 = misetteiJiyu06;
    }

    /**
     * 送信内容７のgetメソッドです。
     *
     * @return 送信内容７
     */
    @CheckForNull
    public RString getSoshinNaiyo07() {
        return soshinNaiyo07;
    }

    /**
     * 送信内容７のsetメソッドです。
     *
     * @param soshinNaiyo07 送信内容７
     */
    public void setSoshinNaiyo07(RString soshinNaiyo07) {
        this.soshinNaiyo07 = soshinNaiyo07;
    }

    /**
     * 未設定事由７のgetメソッドです。
     *
     * @return 未設定事由７
     */
    @CheckForNull
    public RString getMisetteiJiyu07() {
        return misetteiJiyu07;
    }

    /**
     * 未設定事由７のsetメソッドです。
     *
     * @param misetteiJiyu07 未設定事由７
     */
    public void setMisetteiJiyu07(RString misetteiJiyu07) {
        this.misetteiJiyu07 = misetteiJiyu07;
    }

    /**
     * 送信内容８のgetメソッドです。
     *
     * @return 送信内容８
     */
    @CheckForNull
    public RString getSoshinNaiyo08() {
        return soshinNaiyo08;
    }

    /**
     * 送信内容８のsetメソッドです。
     *
     * @param soshinNaiyo08 送信内容８
     */
    public void setSoshinNaiyo08(RString soshinNaiyo08) {
        this.soshinNaiyo08 = soshinNaiyo08;
    }

    /**
     * 未設定事由８のgetメソッドです。
     *
     * @return 未設定事由８
     */
    @CheckForNull
    public RString getMisetteiJiyu08() {
        return misetteiJiyu08;
    }

    /**
     * 未設定事由８のsetメソッドです。
     *
     * @param misetteiJiyu08 未設定事由８
     */
    public void setMisetteiJiyu08(RString misetteiJiyu08) {
        this.misetteiJiyu08 = misetteiJiyu08;
    }

    /**
     * 送信内容９のgetメソッドです。
     *
     * @return 送信内容９
     */
    @CheckForNull
    public RString getSoshinNaiyo09() {
        return soshinNaiyo09;
    }

    /**
     * 送信内容９のsetメソッドです。
     *
     * @param soshinNaiyo09 送信内容９
     */
    public void setSoshinNaiyo09(RString soshinNaiyo09) {
        this.soshinNaiyo09 = soshinNaiyo09;
    }

    /**
     * 未設定事由９のgetメソッドです。
     *
     * @return 未設定事由９
     */
    @CheckForNull
    public RString getMisetteiJiyu09() {
        return misetteiJiyu09;
    }

    /**
     * 未設定事由９のsetメソッドです。
     *
     * @param misetteiJiyu09 未設定事由９
     */
    public void setMisetteiJiyu09(RString misetteiJiyu09) {
        this.misetteiJiyu09 = misetteiJiyu09;
    }

    /**
     * 送信内容１０のgetメソッドです。
     *
     * @return 送信内容１０
     */
    @CheckForNull
    public RString getSoshinNaiyo10() {
        return soshinNaiyo10;
    }

    /**
     * 送信内容１０のsetメソッドです。
     *
     * @param soshinNaiyo10 送信内容１０
     */
    public void setSoshinNaiyo10(RString soshinNaiyo10) {
        this.soshinNaiyo10 = soshinNaiyo10;
    }

    /**
     * 未設定事由１０のgetメソッドです。
     *
     * @return 未設定事由１０
     */
    @CheckForNull
    public RString getMisetteiJiyu10() {
        return misetteiJiyu10;
    }

    /**
     * 未設定事由１０のsetメソッドです。
     *
     * @param misetteiJiyu10 未設定事由１０
     */
    public void setMisetteiJiyu10(RString misetteiJiyu10) {
        this.misetteiJiyu10 = misetteiJiyu10;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7304TokuteiKojinJohoTeikyoKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7304TokuteiKojinJohoTeikyoKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7304TokuteiKojinJohoTeikyoKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.dataSetRecordKey, other.dataSetRecordKey)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7304TokuteiKojinJohoTeikyoKanriEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.dataSetRecordKey = entity.dataSetRecordKey;
        this.teikyoNichiji = entity.teikyoNichiji;
        this.shinkiIdoKubun = entity.shinkiIdoKubun;
        this.teikyoKubun = entity.teikyoKubun;
        this.tokuteiKojinJohoMeiCode = entity.tokuteiKojinJohoMeiCode;
        this.hanNo = entity.hanNo;
        this.dataSetNo = entity.dataSetNo;
        this.kokaiYMD = entity.kokaiYMD;
        this.tateNo = entity.tateNo;
        this.soshinNaiyo01 = entity.soshinNaiyo01;
        this.misetteiJiyu01 = entity.misetteiJiyu01;
        this.soshinNaiyo02 = entity.soshinNaiyo02;
        this.misetteiJiyu02 = entity.misetteiJiyu02;
        this.soshinNaiyo03 = entity.soshinNaiyo03;
        this.misetteiJiyu03 = entity.misetteiJiyu03;
        this.soshinNaiyo04 = entity.soshinNaiyo04;
        this.misetteiJiyu04 = entity.misetteiJiyu04;
        this.soshinNaiyo05 = entity.soshinNaiyo05;
        this.misetteiJiyu05 = entity.misetteiJiyu05;
        this.soshinNaiyo06 = entity.soshinNaiyo06;
        this.misetteiJiyu06 = entity.misetteiJiyu06;
        this.soshinNaiyo07 = entity.soshinNaiyo07;
        this.misetteiJiyu07 = entity.misetteiJiyu07;
        this.soshinNaiyo08 = entity.soshinNaiyo08;
        this.misetteiJiyu08 = entity.misetteiJiyu08;
        this.soshinNaiyo09 = entity.soshinNaiyo09;
        this.misetteiJiyu09 = entity.misetteiJiyu09;
        this.soshinNaiyo10 = entity.soshinNaiyo10;
        this.misetteiJiyu10 = entity.misetteiJiyu10;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, dataSetRecordKey, teikyoNichiji, shinkiIdoKubun, teikyoKubun, tokuteiKojinJohoMeiCode, hanNo, dataSetNo, kokaiYMD, tateNo, soshinNaiyo01, misetteiJiyu01, soshinNaiyo02, misetteiJiyu02, soshinNaiyo03, misetteiJiyu03, soshinNaiyo04, misetteiJiyu04, soshinNaiyo05, misetteiJiyu05, soshinNaiyo06, misetteiJiyu06, soshinNaiyo07, misetteiJiyu07, soshinNaiyo08, misetteiJiyu08, soshinNaiyo09, misetteiJiyu09, soshinNaiyo10, misetteiJiyu10);
    }

// </editor-fold>
}
