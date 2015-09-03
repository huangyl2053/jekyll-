package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;

/**
 * 二次予防基本チェックリストテーブルのエンティティクラスです。
 */
public class DbT3101NijiYoboKihonCheckListEntity extends DbTableEntityBase<DbT3101NijiYoboKihonCheckListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3101NijiYoboKihonCheckList");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate kinyuYMD;
    private Decimal shitsumonJiko01;
    private Decimal shitsumonJiko02;
    private Decimal shitsumonJiko03;
    private Decimal shitsumonJiko04;
    private Decimal shitsumonJiko05;
    private Decimal shitsumonJiko06;
    private Decimal shitsumonJiko07;
    private Decimal shitsumonJiko08;
    private Decimal shitsumonJiko09;
    private Decimal shitsumonJiko10;
    private Decimal shitsumonJiko11;
    private Decimal shitsumonJiko12Shincho;
    private Decimal shitsumonJiko12Taiju;
    private Decimal shitsumonJiko13;
    private Decimal shitsumonJiko14;
    private Decimal shitsumonJiko15;
    private Decimal shitsumonJiko16;
    private Decimal shitsumonJiko17;
    private Decimal shitsumonJiko18;
    private Decimal shitsumonJiko19;
    private Decimal shitsumonJiko20;
    private Decimal shitsumonJiko21;
    private Decimal shitsumonJiko22;
    private Decimal shitsumonJiko23;
    private Decimal shitsumonJiko24;
    private Decimal shitsumonJiko25;

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
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
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
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * 記入年月日のgetメソッドです。
     *
     * @return 記入年月日
     */
    public FlexibleDate getKinyuYMD() {
        return kinyuYMD;
    }

    /**
     * 記入年月日のsetメソッドです。
     *
     * @param kinyuYMD 記入年月日
     */
    public void setKinyuYMD(FlexibleDate kinyuYMD) {
        this.kinyuYMD = kinyuYMD;
    }

    /**
     * 質問事項１のgetメソッドです。
     *
     * @return 質問事項１
     */
    public Decimal getShitsumonJiko01() {
        return shitsumonJiko01;
    }

    /**
     * 質問事項１のsetメソッドです。
     *
     * @param shitsumonJiko01 質問事項１
     */
    public void setShitsumonJiko01(Decimal shitsumonJiko01) {
        this.shitsumonJiko01 = shitsumonJiko01;
    }

    /**
     * 質問事項２のgetメソッドです。
     *
     * @return 質問事項２
     */
    public Decimal getShitsumonJiko02() {
        return shitsumonJiko02;
    }

    /**
     * 質問事項２のsetメソッドです。
     *
     * @param shitsumonJiko02 質問事項２
     */
    public void setShitsumonJiko02(Decimal shitsumonJiko02) {
        this.shitsumonJiko02 = shitsumonJiko02;
    }

    /**
     * 質問事項３のgetメソッドです。
     *
     * @return 質問事項３
     */
    public Decimal getShitsumonJiko03() {
        return shitsumonJiko03;
    }

    /**
     * 質問事項３のsetメソッドです。
     *
     * @param shitsumonJiko03 質問事項３
     */
    public void setShitsumonJiko03(Decimal shitsumonJiko03) {
        this.shitsumonJiko03 = shitsumonJiko03;
    }

    /**
     * 質問事項４のgetメソッドです。
     *
     * @return 質問事項４
     */
    public Decimal getShitsumonJiko04() {
        return shitsumonJiko04;
    }

    /**
     * 質問事項４のsetメソッドです。
     *
     * @param shitsumonJiko04 質問事項４
     */
    public void setShitsumonJiko04(Decimal shitsumonJiko04) {
        this.shitsumonJiko04 = shitsumonJiko04;
    }

    /**
     * 質問事項５のgetメソッドです。
     *
     * @return 質問事項５
     */
    public Decimal getShitsumonJiko05() {
        return shitsumonJiko05;
    }

    /**
     * 質問事項５のsetメソッドです。
     *
     * @param shitsumonJiko05 質問事項５
     */
    public void setShitsumonJiko05(Decimal shitsumonJiko05) {
        this.shitsumonJiko05 = shitsumonJiko05;
    }

    /**
     * 質問事項６のgetメソッドです。
     *
     * @return 質問事項６
     */
    public Decimal getShitsumonJiko06() {
        return shitsumonJiko06;
    }

    /**
     * 質問事項６のsetメソッドです。
     *
     * @param shitsumonJiko06 質問事項６
     */
    public void setShitsumonJiko06(Decimal shitsumonJiko06) {
        this.shitsumonJiko06 = shitsumonJiko06;
    }

    /**
     * 質問事項７のgetメソッドです。
     *
     * @return 質問事項７
     */
    public Decimal getShitsumonJiko07() {
        return shitsumonJiko07;
    }

    /**
     * 質問事項７のsetメソッドです。
     *
     * @param shitsumonJiko07 質問事項７
     */
    public void setShitsumonJiko07(Decimal shitsumonJiko07) {
        this.shitsumonJiko07 = shitsumonJiko07;
    }

    /**
     * 質問事項８のgetメソッドです。
     *
     * @return 質問事項８
     */
    public Decimal getShitsumonJiko08() {
        return shitsumonJiko08;
    }

    /**
     * 質問事項８のsetメソッドです。
     *
     * @param shitsumonJiko08 質問事項８
     */
    public void setShitsumonJiko08(Decimal shitsumonJiko08) {
        this.shitsumonJiko08 = shitsumonJiko08;
    }

    /**
     * 質問事項９のgetメソッドです。
     *
     * @return 質問事項９
     */
    public Decimal getShitsumonJiko09() {
        return shitsumonJiko09;
    }

    /**
     * 質問事項９のsetメソッドです。
     *
     * @param shitsumonJiko09 質問事項９
     */
    public void setShitsumonJiko09(Decimal shitsumonJiko09) {
        this.shitsumonJiko09 = shitsumonJiko09;
    }

    /**
     * 質問事項１０のgetメソッドです。
     *
     * @return 質問事項１０
     */
    public Decimal getShitsumonJiko10() {
        return shitsumonJiko10;
    }

    /**
     * 質問事項１０のsetメソッドです。
     *
     * @param shitsumonJiko10 質問事項１０
     */
    public void setShitsumonJiko10(Decimal shitsumonJiko10) {
        this.shitsumonJiko10 = shitsumonJiko10;
    }

    /**
     * 質問事項１１のgetメソッドです。
     *
     * @return 質問事項１１
     */
    public Decimal getShitsumonJiko11() {
        return shitsumonJiko11;
    }

    /**
     * 質問事項１１のsetメソッドです。
     *
     * @param shitsumonJiko11 質問事項１１
     */
    public void setShitsumonJiko11(Decimal shitsumonJiko11) {
        this.shitsumonJiko11 = shitsumonJiko11;
    }

    /**
     * 質問事項１２身長のgetメソッドです。
     *
     * @return 質問事項１２身長
     */
    public Decimal getShitsumonJiko12Shincho() {
        return shitsumonJiko12Shincho;
    }

    /**
     * 質問事項１２身長のsetメソッドです。
     *
     * @param shitsumonJiko12Shincho 質問事項１２身長
     */
    public void setShitsumonJiko12Shincho(Decimal shitsumonJiko12Shincho) {
        this.shitsumonJiko12Shincho = shitsumonJiko12Shincho;
    }

    /**
     * 質問事項１２体重のgetメソッドです。
     *
     * @return 質問事項１２体重
     */
    public Decimal getShitsumonJiko12Taiju() {
        return shitsumonJiko12Taiju;
    }

    /**
     * 質問事項１２体重のsetメソッドです。
     *
     * @param shitsumonJiko12Taiju 質問事項１２体重
     */
    public void setShitsumonJiko12Taiju(Decimal shitsumonJiko12Taiju) {
        this.shitsumonJiko12Taiju = shitsumonJiko12Taiju;
    }

    /**
     * 質問事項１３のgetメソッドです。
     *
     * @return 質問事項１３
     */
    public Decimal getShitsumonJiko13() {
        return shitsumonJiko13;
    }

    /**
     * 質問事項１３のsetメソッドです。
     *
     * @param shitsumonJiko13 質問事項１３
     */
    public void setShitsumonJiko13(Decimal shitsumonJiko13) {
        this.shitsumonJiko13 = shitsumonJiko13;
    }

    /**
     * 質問事項１４のgetメソッドです。
     *
     * @return 質問事項１４
     */
    public Decimal getShitsumonJiko14() {
        return shitsumonJiko14;
    }

    /**
     * 質問事項１４のsetメソッドです。
     *
     * @param shitsumonJiko14 質問事項１４
     */
    public void setShitsumonJiko14(Decimal shitsumonJiko14) {
        this.shitsumonJiko14 = shitsumonJiko14;
    }

    /**
     * 質問事項１５のgetメソッドです。
     *
     * @return 質問事項１５
     */
    public Decimal getShitsumonJiko15() {
        return shitsumonJiko15;
    }

    /**
     * 質問事項１５のsetメソッドです。
     *
     * @param shitsumonJiko15 質問事項１５
     */
    public void setShitsumonJiko15(Decimal shitsumonJiko15) {
        this.shitsumonJiko15 = shitsumonJiko15;
    }

    /**
     * 質問事項１６のgetメソッドです。
     *
     * @return 質問事項１６
     */
    public Decimal getShitsumonJiko16() {
        return shitsumonJiko16;
    }

    /**
     * 質問事項１６のsetメソッドです。
     *
     * @param shitsumonJiko16 質問事項１６
     */
    public void setShitsumonJiko16(Decimal shitsumonJiko16) {
        this.shitsumonJiko16 = shitsumonJiko16;
    }

    /**
     * 質問事項１７のgetメソッドです。
     *
     * @return 質問事項１７
     */
    public Decimal getShitsumonJiko17() {
        return shitsumonJiko17;
    }

    /**
     * 質問事項１７のsetメソッドです。
     *
     * @param shitsumonJiko17 質問事項１７
     */
    public void setShitsumonJiko17(Decimal shitsumonJiko17) {
        this.shitsumonJiko17 = shitsumonJiko17;
    }

    /**
     * 質問事項１８のgetメソッドです。
     *
     * @return 質問事項１８
     */
    public Decimal getShitsumonJiko18() {
        return shitsumonJiko18;
    }

    /**
     * 質問事項１８のsetメソッドです。
     *
     * @param shitsumonJiko18 質問事項１８
     */
    public void setShitsumonJiko18(Decimal shitsumonJiko18) {
        this.shitsumonJiko18 = shitsumonJiko18;
    }

    /**
     * 質問事項１９のgetメソッドです。
     *
     * @return 質問事項１９
     */
    public Decimal getShitsumonJiko19() {
        return shitsumonJiko19;
    }

    /**
     * 質問事項１９のsetメソッドです。
     *
     * @param shitsumonJiko19 質問事項１９
     */
    public void setShitsumonJiko19(Decimal shitsumonJiko19) {
        this.shitsumonJiko19 = shitsumonJiko19;
    }

    /**
     * 質問事項２０のgetメソッドです。
     *
     * @return 質問事項２０
     */
    public Decimal getShitsumonJiko20() {
        return shitsumonJiko20;
    }

    /**
     * 質問事項２０のsetメソッドです。
     *
     * @param shitsumonJiko20 質問事項２０
     */
    public void setShitsumonJiko20(Decimal shitsumonJiko20) {
        this.shitsumonJiko20 = shitsumonJiko20;
    }

    /**
     * 質問事項２１のgetメソッドです。
     *
     * @return 質問事項２１
     */
    public Decimal getShitsumonJiko21() {
        return shitsumonJiko21;
    }

    /**
     * 質問事項２１のsetメソッドです。
     *
     * @param shitsumonJiko21 質問事項２１
     */
    public void setShitsumonJiko21(Decimal shitsumonJiko21) {
        this.shitsumonJiko21 = shitsumonJiko21;
    }

    /**
     * 質問事項２２のgetメソッドです。
     *
     * @return 質問事項２２
     */
    public Decimal getShitsumonJiko22() {
        return shitsumonJiko22;
    }

    /**
     * 質問事項２２のsetメソッドです。
     *
     * @param shitsumonJiko22 質問事項２２
     */
    public void setShitsumonJiko22(Decimal shitsumonJiko22) {
        this.shitsumonJiko22 = shitsumonJiko22;
    }

    /**
     * 質問事項２３のgetメソッドです。
     *
     * @return 質問事項２３
     */
    public Decimal getShitsumonJiko23() {
        return shitsumonJiko23;
    }

    /**
     * 質問事項２３のsetメソッドです。
     *
     * @param shitsumonJiko23 質問事項２３
     */
    public void setShitsumonJiko23(Decimal shitsumonJiko23) {
        this.shitsumonJiko23 = shitsumonJiko23;
    }

    /**
     * 質問事項２４のgetメソッドです。
     *
     * @return 質問事項２４
     */
    public Decimal getShitsumonJiko24() {
        return shitsumonJiko24;
    }

    /**
     * 質問事項２４のsetメソッドです。
     *
     * @param shitsumonJiko24 質問事項２４
     */
    public void setShitsumonJiko24(Decimal shitsumonJiko24) {
        this.shitsumonJiko24 = shitsumonJiko24;
    }

    /**
     * 質問事項２５のgetメソッドです。
     *
     * @return 質問事項２５
     */
    public Decimal getShitsumonJiko25() {
        return shitsumonJiko25;
    }

    /**
     * 質問事項２５のsetメソッドです。
     *
     * @param shitsumonJiko25 質問事項２５
     */
    public void setShitsumonJiko25(Decimal shitsumonJiko25) {
        this.shitsumonJiko25 = shitsumonJiko25;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3101NijiYoboKihonCheckListEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3101NijiYoboKihonCheckListEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3101NijiYoboKihonCheckListEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.uketsukeYMD, other.uketsukeYMD)) {
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
    public void shallowCopy(DbT3101NijiYoboKihonCheckListEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.rirekiNo = entity.rirekiNo;
        this.kinyuYMD = entity.kinyuYMD;
        this.shitsumonJiko01 = entity.shitsumonJiko01;
        this.shitsumonJiko02 = entity.shitsumonJiko02;
        this.shitsumonJiko03 = entity.shitsumonJiko03;
        this.shitsumonJiko04 = entity.shitsumonJiko04;
        this.shitsumonJiko05 = entity.shitsumonJiko05;
        this.shitsumonJiko06 = entity.shitsumonJiko06;
        this.shitsumonJiko07 = entity.shitsumonJiko07;
        this.shitsumonJiko08 = entity.shitsumonJiko08;
        this.shitsumonJiko09 = entity.shitsumonJiko09;
        this.shitsumonJiko10 = entity.shitsumonJiko10;
        this.shitsumonJiko11 = entity.shitsumonJiko11;
        this.shitsumonJiko12Shincho = entity.shitsumonJiko12Shincho;
        this.shitsumonJiko12Taiju = entity.shitsumonJiko12Taiju;
        this.shitsumonJiko13 = entity.shitsumonJiko13;
        this.shitsumonJiko14 = entity.shitsumonJiko14;
        this.shitsumonJiko15 = entity.shitsumonJiko15;
        this.shitsumonJiko16 = entity.shitsumonJiko16;
        this.shitsumonJiko17 = entity.shitsumonJiko17;
        this.shitsumonJiko18 = entity.shitsumonJiko18;
        this.shitsumonJiko19 = entity.shitsumonJiko19;
        this.shitsumonJiko20 = entity.shitsumonJiko20;
        this.shitsumonJiko21 = entity.shitsumonJiko21;
        this.shitsumonJiko22 = entity.shitsumonJiko22;
        this.shitsumonJiko23 = entity.shitsumonJiko23;
        this.shitsumonJiko24 = entity.shitsumonJiko24;
        this.shitsumonJiko25 = entity.shitsumonJiko25;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, hihokenshaNo, uketsukeYMD, rirekiNo, kinyuYMD, shitsumonJiko01, shitsumonJiko02, shitsumonJiko03, shitsumonJiko04, shitsumonJiko05, shitsumonJiko06, shitsumonJiko07, shitsumonJiko08, shitsumonJiko09, shitsumonJiko10, shitsumonJiko11, shitsumonJiko12Shincho, shitsumonJiko12Taiju, shitsumonJiko13, shitsumonJiko14, shitsumonJiko15, shitsumonJiko16, shitsumonJiko17, shitsumonJiko18, shitsumonJiko19, shitsumonJiko20, shitsumonJiko21, shitsumonJiko22, shitsumonJiko23, shitsumonJiko24, shitsumonJiko25);
    }

// </editor-fold>
}
