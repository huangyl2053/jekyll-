package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
@OnNextSchema("rgdb")
public class DbT5511ShinsakaiKaisaiKekkaJohoEntity extends DbTableEntityBase<DbT5511ShinsakaiKaisaiKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5511ShinsakaiKaisaiKekkaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiKaisaiNo;
    private int gogitaiNo;
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaishiTime;
    private RString shinsakaiShuryoTime;
    private RString shinsakaiKaisaiBashoCode;
    private int shoyoJikanGokei;
    private int shinsakaiJisshiNinzu;

    /**
     * コンストラクタです。
     */
    public DbT5511ShinsakaiKaisaiKekkaJohoEntity() {
        shinsakaiKaisaiNo = RString.EMPTY;
        shinsakaiKaisaiYMD = FlexibleDate.EMPTY;
        shinsakaiKaishiTime = RString.EMPTY;
        shinsakaiShuryoTime = RString.EMPTY;
        shinsakaiKaisaiBashoCode = RString.EMPTY;
        shoyoJikanGokei = 0;
        shinsakaiJisshiNinzu = 0;
    }

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
     * 介護認定審査会開催番号のgetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @return 介護認定審査会開催番号
     */
    public RString getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(@Nonnull RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 合議体番号のgetメソッドです。
     * <br/>
     * <br/>合議体情報
     *
     * @return 合議体番号
     */
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * 合議体番号のsetメソッドです。
     * <br/>
     * <br/>合議体情報
     *
     * @param gogitaiNo 合議体番号
     */
    public void setGogitaiNo(@Nonnull int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * 介護認定審査会開催年月日のgetメソッドです。
     *
     * @return 介護認定審査会開催年月日
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会開催年月日のsetメソッドです。
     *
     * @param shinsakaiKaisaiYMD 介護認定審査会開催年月日
     */
    public void setShinsakaiKaisaiYMD(@Nonnull FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会開始時刻のgetメソッドです。
     *
     * @return 介護認定審査会開始時刻
     */
    public RString getShinsakaiKaishiTime() {
        return shinsakaiKaishiTime;
    }

    /**
     * 介護認定審査会開始時刻のsetメソッドです。
     *
     * @param shinsakaiKaishiTime 介護認定審査会開始時刻
     */
    public void setShinsakaiKaishiTime(@Nonnull RString shinsakaiKaishiTime) {
        this.shinsakaiKaishiTime = shinsakaiKaishiTime;
    }

    /**
     * 介護認定審査会終了時刻のgetメソッドです。
     *
     * @return 介護認定審査会終了時刻
     */
    public RString getShinsakaiShuryoTime() {
        return shinsakaiShuryoTime;
    }

    /**
     * 介護認定審査会終了時刻のsetメソッドです。
     *
     * @param shinsakaiShuryoTime 介護認定審査会終了時刻
     */
    public void setShinsakaiShuryoTime(@Nonnull RString shinsakaiShuryoTime) {
        this.shinsakaiShuryoTime = shinsakaiShuryoTime;
    }

    /**
     * 介護認定審査会開催場所コードのgetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催場所情報
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString getShinsakaiKaisaiBashoCode() {
        return shinsakaiKaisaiBashoCode;
    }

    /**
     * 介護認定審査会開催場所コードのsetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催場所情報
     *
     * @param shinsakaiKaisaiBashoCode 介護認定審査会開催場所コード
     */
    public void setShinsakaiKaisaiBashoCode(@Nonnull RString shinsakaiKaisaiBashoCode) {
        this.shinsakaiKaisaiBashoCode = shinsakaiKaisaiBashoCode;
    }

    /**
     * 所要時間合計のgetメソッドです。
     *
     * @return 所要時間合計
     */
    @CheckForNull
    public int getShoyoJikanGokei() {
        return shoyoJikanGokei;
    }

    /**
     * 所要時間合計のsetメソッドです。
     *
     * @param shoyoJikanGokei 所要時間合計
     */
    public void setShoyoJikanGokei(int shoyoJikanGokei) {
        this.shoyoJikanGokei = shoyoJikanGokei;
    }

    /**
     * 介護認定審査会実施人数のgetメソッドです。
     *
     * @return 介護認定審査会実施人数
     */
    @CheckForNull
    public int getShinsakaiJisshiNinzu() {
        return shinsakaiJisshiNinzu;
    }

    /**
     * 介護認定審査会実施人数のsetメソッドです。
     *
     * @param shinsakaiJisshiNinzu 介護認定審査会実施人数
     */
    public void setShinsakaiJisshiNinzu(int shinsakaiJisshiNinzu) {
        this.shinsakaiJisshiNinzu = shinsakaiJisshiNinzu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5511ShinsakaiKaisaiKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT5511ShinsakaiKaisaiKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5511ShinsakaiKaisaiKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiNo, other.shinsakaiKaisaiNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5511ShinsakaiKaisaiKekkaJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.gogitaiNo = entity.gogitaiNo;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.shinsakaiKaishiTime = entity.shinsakaiKaishiTime;
        this.shinsakaiShuryoTime = entity.shinsakaiShuryoTime;
        this.shinsakaiKaisaiBashoCode = entity.shinsakaiKaisaiBashoCode;
        this.shoyoJikanGokei = entity.shoyoJikanGokei;
        this.shinsakaiJisshiNinzu = entity.shinsakaiJisshiNinzu;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, gogitaiNo, shinsakaiKaisaiYMD, shinsakaiKaishiTime, shinsakaiShuryoTime, shinsakaiKaisaiBashoCode, shoyoJikanGokei, shinsakaiJisshiNinzu);
    }

// </editor-fold>
}
