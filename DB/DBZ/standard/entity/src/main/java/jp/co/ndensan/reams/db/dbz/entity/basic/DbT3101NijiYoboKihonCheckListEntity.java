package jp.co.ndensan.reams.db.dbz.entity.basic;

import java.util.Objects;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * DbT3101NijiYoboKihonCheckListの項目定義クラスです
 *
 */
public class DbT3101NijiYoboKihonCheckListEntity extends DbTableEntityBase<DbT3101NijiYoboKihonCheckListEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

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
    private YMDHMS shoriTimestamp;
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
     * getUketsukeYMD
     *
     * @return uketsukeYMD
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * setUketsukeYMD
     *
     * @param uketsukeYMD uketsukeYMD
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
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
     * getKinyuYMD
     *
     * @return kinyuYMD
     */
    public FlexibleDate getKinyuYMD() {
        return kinyuYMD;
    }

    /**
     * setKinyuYMD
     *
     * @param kinyuYMD kinyuYMD
     */
    public void setKinyuYMD(FlexibleDate kinyuYMD) {
        this.kinyuYMD = kinyuYMD;
    }

    /**
     * getShitsumonJiko01
     *
     * @return shitsumonJiko01
     */
    public int getShitsumonJiko01() {
        return shitsumonJiko01;
    }

    /**
     * setShitsumonJiko01
     *
     * @param shitsumonJiko01 shitsumonJiko01
     */
    public void setShitsumonJiko01(int shitsumonJiko01) {
        this.shitsumonJiko01 = shitsumonJiko01;
    }

    /**
     * getShitsumonJiko02
     *
     * @return shitsumonJiko02
     */
    public int getShitsumonJiko02() {
        return shitsumonJiko02;
    }

    /**
     * setShitsumonJiko02
     *
     * @param shitsumonJiko02 shitsumonJiko02
     */
    public void setShitsumonJiko02(int shitsumonJiko02) {
        this.shitsumonJiko02 = shitsumonJiko02;
    }

    /**
     * getShitsumonJiko03
     *
     * @return shitsumonJiko03
     */
    public int getShitsumonJiko03() {
        return shitsumonJiko03;
    }

    /**
     * setShitsumonJiko03
     *
     * @param shitsumonJiko03 shitsumonJiko03
     */
    public void setShitsumonJiko03(int shitsumonJiko03) {
        this.shitsumonJiko03 = shitsumonJiko03;
    }

    /**
     * getShitsumonJiko04
     *
     * @return shitsumonJiko04
     */
    public int getShitsumonJiko04() {
        return shitsumonJiko04;
    }

    /**
     * setShitsumonJiko04
     *
     * @param shitsumonJiko04 shitsumonJiko04
     */
    public void setShitsumonJiko04(int shitsumonJiko04) {
        this.shitsumonJiko04 = shitsumonJiko04;
    }

    /**
     * getShitsumonJiko05
     *
     * @return shitsumonJiko05
     */
    public int getShitsumonJiko05() {
        return shitsumonJiko05;
    }

    /**
     * setShitsumonJiko05
     *
     * @param shitsumonJiko05 shitsumonJiko05
     */
    public void setShitsumonJiko05(int shitsumonJiko05) {
        this.shitsumonJiko05 = shitsumonJiko05;
    }

    /**
     * getShitsumonJiko06
     *
     * @return shitsumonJiko06
     */
    public int getShitsumonJiko06() {
        return shitsumonJiko06;
    }

    /**
     * setShitsumonJiko06
     *
     * @param shitsumonJiko06 shitsumonJiko06
     */
    public void setShitsumonJiko06(int shitsumonJiko06) {
        this.shitsumonJiko06 = shitsumonJiko06;
    }

    /**
     * getShitsumonJiko07
     *
     * @return shitsumonJiko07
     */
    public int getShitsumonJiko07() {
        return shitsumonJiko07;
    }

    /**
     * setShitsumonJiko07
     *
     * @param shitsumonJiko07 shitsumonJiko07
     */
    public void setShitsumonJiko07(int shitsumonJiko07) {
        this.shitsumonJiko07 = shitsumonJiko07;
    }

    /**
     * getShitsumonJiko08
     *
     * @return shitsumonJiko08
     */
    public int getShitsumonJiko08() {
        return shitsumonJiko08;
    }

    /**
     * setShitsumonJiko08
     *
     * @param shitsumonJiko08 shitsumonJiko08
     */
    public void setShitsumonJiko08(int shitsumonJiko08) {
        this.shitsumonJiko08 = shitsumonJiko08;
    }

    /**
     * getShitsumonJiko09
     *
     * @return shitsumonJiko09
     */
    public int getShitsumonJiko09() {
        return shitsumonJiko09;
    }

    /**
     * setShitsumonJiko09
     *
     * @param shitsumonJiko09 shitsumonJiko09
     */
    public void setShitsumonJiko09(int shitsumonJiko09) {
        this.shitsumonJiko09 = shitsumonJiko09;
    }

    /**
     * getShitsumonJiko10
     *
     * @return shitsumonJiko10
     */
    public int getShitsumonJiko10() {
        return shitsumonJiko10;
    }

    /**
     * setShitsumonJiko10
     *
     * @param shitsumonJiko10 shitsumonJiko10
     */
    public void setShitsumonJiko10(int shitsumonJiko10) {
        this.shitsumonJiko10 = shitsumonJiko10;
    }

    /**
     * getShitsumonJiko11
     *
     * @return shitsumonJiko11
     */
    public int getShitsumonJiko11() {
        return shitsumonJiko11;
    }

    /**
     * setShitsumonJiko11
     *
     * @param shitsumonJiko11 shitsumonJiko11
     */
    public void setShitsumonJiko11(int shitsumonJiko11) {
        this.shitsumonJiko11 = shitsumonJiko11;
    }

    /**
     * getShitsumonJiko12Shincho
     *
     * @return shitsumonJiko12Shincho
     */
    public Decimal getShitsumonJiko12Shincho() {
        return shitsumonJiko12Shincho;
    }

    /**
     * setShitsumonJiko12Shincho
     *
     * @param shitsumonJiko12Shincho shitsumonJiko12Shincho
     */
    public void setShitsumonJiko12Shincho(Decimal shitsumonJiko12Shincho) {
        this.shitsumonJiko12Shincho = shitsumonJiko12Shincho;
    }

    /**
     * getShitsumonJiko12Taiju
     *
     * @return shitsumonJiko12Taiju
     */
    public Decimal getShitsumonJiko12Taiju() {
        return shitsumonJiko12Taiju;
    }

    /**
     * setShitsumonJiko12Taiju
     *
     * @param shitsumonJiko12Taiju shitsumonJiko12Taiju
     */
    public void setShitsumonJiko12Taiju(Decimal shitsumonJiko12Taiju) {
        this.shitsumonJiko12Taiju = shitsumonJiko12Taiju;
    }

    /**
     * getShitsumonJiko13
     *
     * @return shitsumonJiko13
     */
    public int getShitsumonJiko13() {
        return shitsumonJiko13;
    }

    /**
     * setShitsumonJiko13
     *
     * @param shitsumonJiko13 shitsumonJiko13
     */
    public void setShitsumonJiko13(int shitsumonJiko13) {
        this.shitsumonJiko13 = shitsumonJiko13;
    }

    /**
     * getShitsumonJiko14
     *
     * @return shitsumonJiko14
     */
    public int getShitsumonJiko14() {
        return shitsumonJiko14;
    }

    /**
     * setShitsumonJiko14
     *
     * @param shitsumonJiko14 shitsumonJiko14
     */
    public void setShitsumonJiko14(int shitsumonJiko14) {
        this.shitsumonJiko14 = shitsumonJiko14;
    }

    /**
     * getShitsumonJiko15
     *
     * @return shitsumonJiko15
     */
    public int getShitsumonJiko15() {
        return shitsumonJiko15;
    }

    /**
     * setShitsumonJiko15
     *
     * @param shitsumonJiko15 shitsumonJiko15
     */
    public void setShitsumonJiko15(int shitsumonJiko15) {
        this.shitsumonJiko15 = shitsumonJiko15;
    }

    /**
     * getShitsumonJiko16
     *
     * @return shitsumonJiko16
     */
    public int getShitsumonJiko16() {
        return shitsumonJiko16;
    }

    /**
     * setShitsumonJiko16
     *
     * @param shitsumonJiko16 shitsumonJiko16
     */
    public void setShitsumonJiko16(int shitsumonJiko16) {
        this.shitsumonJiko16 = shitsumonJiko16;
    }

    /**
     * getShitsumonJiko17
     *
     * @return shitsumonJiko17
     */
    public int getShitsumonJiko17() {
        return shitsumonJiko17;
    }

    /**
     * setShitsumonJiko17
     *
     * @param shitsumonJiko17 shitsumonJiko17
     */
    public void setShitsumonJiko17(int shitsumonJiko17) {
        this.shitsumonJiko17 = shitsumonJiko17;
    }

    /**
     * getShitsumonJiko18
     *
     * @return shitsumonJiko18
     */
    public int getShitsumonJiko18() {
        return shitsumonJiko18;
    }

    /**
     * setShitsumonJiko18
     *
     * @param shitsumonJiko18 shitsumonJiko18
     */
    public void setShitsumonJiko18(int shitsumonJiko18) {
        this.shitsumonJiko18 = shitsumonJiko18;
    }

    /**
     * getShitsumonJiko19
     *
     * @return shitsumonJiko19
     */
    public int getShitsumonJiko19() {
        return shitsumonJiko19;
    }

    /**
     * setShitsumonJiko19
     *
     * @param shitsumonJiko19 shitsumonJiko19
     */
    public void setShitsumonJiko19(int shitsumonJiko19) {
        this.shitsumonJiko19 = shitsumonJiko19;
    }

    /**
     * getShitsumonJiko20
     *
     * @return shitsumonJiko20
     */
    public int getShitsumonJiko20() {
        return shitsumonJiko20;
    }

    /**
     * setShitsumonJiko20
     *
     * @param shitsumonJiko20 shitsumonJiko20
     */
    public void setShitsumonJiko20(int shitsumonJiko20) {
        this.shitsumonJiko20 = shitsumonJiko20;
    }

    /**
     * getShitsumonJiko21
     *
     * @return shitsumonJiko21
     */
    public int getShitsumonJiko21() {
        return shitsumonJiko21;
    }

    /**
     * setShitsumonJiko21
     *
     * @param shitsumonJiko21 shitsumonJiko21
     */
    public void setShitsumonJiko21(int shitsumonJiko21) {
        this.shitsumonJiko21 = shitsumonJiko21;
    }

    /**
     * getShitsumonJiko22
     *
     * @return shitsumonJiko22
     */
    public int getShitsumonJiko22() {
        return shitsumonJiko22;
    }

    /**
     * setShitsumonJiko22
     *
     * @param shitsumonJiko22 shitsumonJiko22
     */
    public void setShitsumonJiko22(int shitsumonJiko22) {
        this.shitsumonJiko22 = shitsumonJiko22;
    }

    /**
     * getShitsumonJiko23
     *
     * @return shitsumonJiko23
     */
    public int getShitsumonJiko23() {
        return shitsumonJiko23;
    }

    /**
     * setShitsumonJiko23
     *
     * @param shitsumonJiko23 shitsumonJiko23
     */
    public void setShitsumonJiko23(int shitsumonJiko23) {
        this.shitsumonJiko23 = shitsumonJiko23;
    }

    /**
     * getShitsumonJiko24
     *
     * @return shitsumonJiko24
     */
    public int getShitsumonJiko24() {
        return shitsumonJiko24;
    }

    /**
     * setShitsumonJiko24
     *
     * @param shitsumonJiko24 shitsumonJiko24
     */
    public void setShitsumonJiko24(int shitsumonJiko24) {
        this.shitsumonJiko24 = shitsumonJiko24;
    }

    /**
     * getShitsumonJiko25
     *
     * @return shitsumonJiko25
     */
    public int getShitsumonJiko25() {
        return shitsumonJiko25;
    }

    /**
     * setShitsumonJiko25
     *
     * @param shitsumonJiko25 shitsumonJiko25
     */
    public void setShitsumonJiko25(int shitsumonJiko25) {
        this.shitsumonJiko25 = shitsumonJiko25;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3101NijiYoboKihonCheckListEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
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
        if (!Objects.equals(this.shoriTimestamp, other.shoriTimestamp)) {
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
        this.shoriTimestamp = entity.shoriTimestamp;
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
        return super.toMd5(shikibetsuCode, hihokenshaNo, uketsukeYMD, shoriTimestamp, kinyuYMD, shitsumonJiko01, shitsumonJiko02, shitsumonJiko03, shitsumonJiko04, shitsumonJiko05, shitsumonJiko06, shitsumonJiko07, shitsumonJiko08, shitsumonJiko09, shitsumonJiko10, shitsumonJiko11, shitsumonJiko12Shincho, shitsumonJiko12Taiju, shitsumonJiko13, shitsumonJiko14, shitsumonJiko15, shitsumonJiko16, shitsumonJiko17, shitsumonJiko18, shitsumonJiko19, shitsumonJiko20, shitsumonJiko21, shitsumonJiko22, shitsumonJiko23, shitsumonJiko24, shitsumonJiko25);
    }

// </editor-fold>
}
