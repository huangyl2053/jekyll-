package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 二次予防基本チェックリストテーブルのエンティティクラスです。
 */
public class DbT3101NijiYoboKihonCheckListEntity extends DbTableEntityBase<DbT3101NijiYoboKihonCheckListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleDate uketsukeYMD;
    @PrimaryKey
    private int rirekiNo;
    private FlexibleDate kinyuYMD;
    private int shitsumonJiko01;
    private int shitsumonJiko02;
    private int shitsumonJiko03;
    private int shitsumonJiko04;
    private int shitsumonJiko05;
    private int shitsumonJiko06;
    private int shitsumonJiko07;
    private int shitsumonJiko08;
    private int shitsumonJiko09;
    private int shitsumonJiko10;
    private int shitsumonJiko11;
    private Decimal shitsumonJiko12Shincho;
    private Decimal shitsumonJiko12Taiju;
    private int shitsumonJiko13;
    private int shitsumonJiko14;
    private int shitsumonJiko15;
    private int shitsumonJiko16;
    private int shitsumonJiko17;
    private int shitsumonJiko18;
    private int shitsumonJiko19;
    private int shitsumonJiko20;
    private int shitsumonJiko21;
    private int shitsumonJiko22;
    private int shitsumonJiko23;
    private int shitsumonJiko24;
    private int shitsumonJiko25;

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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
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
    public void setUketsukeYMD(@Nonnull FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 記入年月日のgetメソッドです。
     * 
     * @return 記入年月日
     */
    @CheckForNull
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
    @CheckForNull
    public int getShitsumonJiko01() {
        return shitsumonJiko01;
    }

    /**
     * 質問事項１のsetメソッドです。
     * 
     * @param shitsumonJiko01 質問事項１
     */
    public void setShitsumonJiko01(int shitsumonJiko01) {
        this.shitsumonJiko01 = shitsumonJiko01;
    }

    /**
     * 質問事項２のgetメソッドです。
     * 
     * @return 質問事項２
     */
    @CheckForNull
    public int getShitsumonJiko02() {
        return shitsumonJiko02;
    }

    /**
     * 質問事項２のsetメソッドです。
     * 
     * @param shitsumonJiko02 質問事項２
     */
    public void setShitsumonJiko02(int shitsumonJiko02) {
        this.shitsumonJiko02 = shitsumonJiko02;
    }

    /**
     * 質問事項３のgetメソッドです。
     * 
     * @return 質問事項３
     */
    @CheckForNull
    public int getShitsumonJiko03() {
        return shitsumonJiko03;
    }

    /**
     * 質問事項３のsetメソッドです。
     * 
     * @param shitsumonJiko03 質問事項３
     */
    public void setShitsumonJiko03(int shitsumonJiko03) {
        this.shitsumonJiko03 = shitsumonJiko03;
    }

    /**
     * 質問事項４のgetメソッドです。
     * 
     * @return 質問事項４
     */
    @CheckForNull
    public int getShitsumonJiko04() {
        return shitsumonJiko04;
    }

    /**
     * 質問事項４のsetメソッドです。
     * 
     * @param shitsumonJiko04 質問事項４
     */
    public void setShitsumonJiko04(int shitsumonJiko04) {
        this.shitsumonJiko04 = shitsumonJiko04;
    }

    /**
     * 質問事項５のgetメソッドです。
     * 
     * @return 質問事項５
     */
    @CheckForNull
    public int getShitsumonJiko05() {
        return shitsumonJiko05;
    }

    /**
     * 質問事項５のsetメソッドです。
     * 
     * @param shitsumonJiko05 質問事項５
     */
    public void setShitsumonJiko05(int shitsumonJiko05) {
        this.shitsumonJiko05 = shitsumonJiko05;
    }

    /**
     * 質問事項６のgetメソッドです。
     * 
     * @return 質問事項６
     */
    @CheckForNull
    public int getShitsumonJiko06() {
        return shitsumonJiko06;
    }

    /**
     * 質問事項６のsetメソッドです。
     * 
     * @param shitsumonJiko06 質問事項６
     */
    public void setShitsumonJiko06(int shitsumonJiko06) {
        this.shitsumonJiko06 = shitsumonJiko06;
    }

    /**
     * 質問事項７のgetメソッドです。
     * 
     * @return 質問事項７
     */
    @CheckForNull
    public int getShitsumonJiko07() {
        return shitsumonJiko07;
    }

    /**
     * 質問事項７のsetメソッドです。
     * 
     * @param shitsumonJiko07 質問事項７
     */
    public void setShitsumonJiko07(int shitsumonJiko07) {
        this.shitsumonJiko07 = shitsumonJiko07;
    }

    /**
     * 質問事項８のgetメソッドです。
     * 
     * @return 質問事項８
     */
    @CheckForNull
    public int getShitsumonJiko08() {
        return shitsumonJiko08;
    }

    /**
     * 質問事項８のsetメソッドです。
     * 
     * @param shitsumonJiko08 質問事項８
     */
    public void setShitsumonJiko08(int shitsumonJiko08) {
        this.shitsumonJiko08 = shitsumonJiko08;
    }

    /**
     * 質問事項９のgetメソッドです。
     * 
     * @return 質問事項９
     */
    @CheckForNull
    public int getShitsumonJiko09() {
        return shitsumonJiko09;
    }

    /**
     * 質問事項９のsetメソッドです。
     * 
     * @param shitsumonJiko09 質問事項９
     */
    public void setShitsumonJiko09(int shitsumonJiko09) {
        this.shitsumonJiko09 = shitsumonJiko09;
    }

    /**
     * 質問事項１０のgetメソッドです。
     * 
     * @return 質問事項１０
     */
    @CheckForNull
    public int getShitsumonJiko10() {
        return shitsumonJiko10;
    }

    /**
     * 質問事項１０のsetメソッドです。
     * 
     * @param shitsumonJiko10 質問事項１０
     */
    public void setShitsumonJiko10(int shitsumonJiko10) {
        this.shitsumonJiko10 = shitsumonJiko10;
    }

    /**
     * 質問事項１１のgetメソッドです。
     * 
     * @return 質問事項１１
     */
    @CheckForNull
    public int getShitsumonJiko11() {
        return shitsumonJiko11;
    }

    /**
     * 質問事項１１のsetメソッドです。
     * 
     * @param shitsumonJiko11 質問事項１１
     */
    public void setShitsumonJiko11(int shitsumonJiko11) {
        this.shitsumonJiko11 = shitsumonJiko11;
    }

    /**
     * 質問事項１２身長のgetメソッドです。
     * 
     * @return 質問事項１２身長
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
    public int getShitsumonJiko13() {
        return shitsumonJiko13;
    }

    /**
     * 質問事項１３のsetメソッドです。
     * 
     * @param shitsumonJiko13 質問事項１３
     */
    public void setShitsumonJiko13(int shitsumonJiko13) {
        this.shitsumonJiko13 = shitsumonJiko13;
    }

    /**
     * 質問事項１４のgetメソッドです。
     * 
     * @return 質問事項１４
     */
    @CheckForNull
    public int getShitsumonJiko14() {
        return shitsumonJiko14;
    }

    /**
     * 質問事項１４のsetメソッドです。
     * 
     * @param shitsumonJiko14 質問事項１４
     */
    public void setShitsumonJiko14(int shitsumonJiko14) {
        this.shitsumonJiko14 = shitsumonJiko14;
    }

    /**
     * 質問事項１５のgetメソッドです。
     * 
     * @return 質問事項１５
     */
    @CheckForNull
    public int getShitsumonJiko15() {
        return shitsumonJiko15;
    }

    /**
     * 質問事項１５のsetメソッドです。
     * 
     * @param shitsumonJiko15 質問事項１５
     */
    public void setShitsumonJiko15(int shitsumonJiko15) {
        this.shitsumonJiko15 = shitsumonJiko15;
    }

    /**
     * 質問事項１６のgetメソッドです。
     * 
     * @return 質問事項１６
     */
    @CheckForNull
    public int getShitsumonJiko16() {
        return shitsumonJiko16;
    }

    /**
     * 質問事項１６のsetメソッドです。
     * 
     * @param shitsumonJiko16 質問事項１６
     */
    public void setShitsumonJiko16(int shitsumonJiko16) {
        this.shitsumonJiko16 = shitsumonJiko16;
    }

    /**
     * 質問事項１７のgetメソッドです。
     * 
     * @return 質問事項１７
     */
    @CheckForNull
    public int getShitsumonJiko17() {
        return shitsumonJiko17;
    }

    /**
     * 質問事項１７のsetメソッドです。
     * 
     * @param shitsumonJiko17 質問事項１７
     */
    public void setShitsumonJiko17(int shitsumonJiko17) {
        this.shitsumonJiko17 = shitsumonJiko17;
    }

    /**
     * 質問事項１８のgetメソッドです。
     * 
     * @return 質問事項１８
     */
    @CheckForNull
    public int getShitsumonJiko18() {
        return shitsumonJiko18;
    }

    /**
     * 質問事項１８のsetメソッドです。
     * 
     * @param shitsumonJiko18 質問事項１８
     */
    public void setShitsumonJiko18(int shitsumonJiko18) {
        this.shitsumonJiko18 = shitsumonJiko18;
    }

    /**
     * 質問事項１９のgetメソッドです。
     * 
     * @return 質問事項１９
     */
    @CheckForNull
    public int getShitsumonJiko19() {
        return shitsumonJiko19;
    }

    /**
     * 質問事項１９のsetメソッドです。
     * 
     * @param shitsumonJiko19 質問事項１９
     */
    public void setShitsumonJiko19(int shitsumonJiko19) {
        this.shitsumonJiko19 = shitsumonJiko19;
    }

    /**
     * 質問事項２０のgetメソッドです。
     * 
     * @return 質問事項２０
     */
    @CheckForNull
    public int getShitsumonJiko20() {
        return shitsumonJiko20;
    }

    /**
     * 質問事項２０のsetメソッドです。
     * 
     * @param shitsumonJiko20 質問事項２０
     */
    public void setShitsumonJiko20(int shitsumonJiko20) {
        this.shitsumonJiko20 = shitsumonJiko20;
    }

    /**
     * 質問事項２１のgetメソッドです。
     * 
     * @return 質問事項２１
     */
    @CheckForNull
    public int getShitsumonJiko21() {
        return shitsumonJiko21;
    }

    /**
     * 質問事項２１のsetメソッドです。
     * 
     * @param shitsumonJiko21 質問事項２１
     */
    public void setShitsumonJiko21(int shitsumonJiko21) {
        this.shitsumonJiko21 = shitsumonJiko21;
    }

    /**
     * 質問事項２２のgetメソッドです。
     * 
     * @return 質問事項２２
     */
    @CheckForNull
    public int getShitsumonJiko22() {
        return shitsumonJiko22;
    }

    /**
     * 質問事項２２のsetメソッドです。
     * 
     * @param shitsumonJiko22 質問事項２２
     */
    public void setShitsumonJiko22(int shitsumonJiko22) {
        this.shitsumonJiko22 = shitsumonJiko22;
    }

    /**
     * 質問事項２３のgetメソッドです。
     * 
     * @return 質問事項２３
     */
    @CheckForNull
    public int getShitsumonJiko23() {
        return shitsumonJiko23;
    }

    /**
     * 質問事項２３のsetメソッドです。
     * 
     * @param shitsumonJiko23 質問事項２３
     */
    public void setShitsumonJiko23(int shitsumonJiko23) {
        this.shitsumonJiko23 = shitsumonJiko23;
    }

    /**
     * 質問事項２４のgetメソッドです。
     * 
     * @return 質問事項２４
     */
    @CheckForNull
    public int getShitsumonJiko24() {
        return shitsumonJiko24;
    }

    /**
     * 質問事項２４のsetメソッドです。
     * 
     * @param shitsumonJiko24 質問事項２４
     */
    public void setShitsumonJiko24(int shitsumonJiko24) {
        this.shitsumonJiko24 = shitsumonJiko24;
    }

    /**
     * 質問事項２５のgetメソッドです。
     * 
     * @return 質問事項２５
     */
    @CheckForNull
    public int getShitsumonJiko25() {
        return shitsumonJiko25;
    }

    /**
     * 質問事項２５のsetメソッドです。
     * 
     * @param shitsumonJiko25 質問事項２５
     */
    public void setShitsumonJiko25(int shitsumonJiko25) {
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, uketsukeYMD, rirekiNo, kinyuYMD, shitsumonJiko01, shitsumonJiko02, shitsumonJiko03, shitsumonJiko04, shitsumonJiko05, shitsumonJiko06, shitsumonJiko07, shitsumonJiko08, shitsumonJiko09, shitsumonJiko10, shitsumonJiko11, shitsumonJiko12Shincho, shitsumonJiko12Taiju, shitsumonJiko13, shitsumonJiko14, shitsumonJiko15, shitsumonJiko16, shitsumonJiko17, shitsumonJiko18, shitsumonJiko19, shitsumonJiko20, shitsumonJiko21, shitsumonJiko22, shitsumonJiko23, shitsumonJiko24, shitsumonJiko25);
    }

// </editor-fold>

}
