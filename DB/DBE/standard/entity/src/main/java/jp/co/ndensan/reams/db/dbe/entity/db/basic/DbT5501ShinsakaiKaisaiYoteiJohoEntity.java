package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護認定審査会開催予定情報テーブルのエンティティクラスです。
 */
public class DbT5501ShinsakaiKaisaiYoteiJohoEntity extends DbTableEntityBase<DbT5501ShinsakaiKaisaiYoteiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5501ShinsakaiKaisaiYoteiJoho");

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
    private FlexibleDate shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private RString shinsakaiKaisaiYoteiBashoCode;
    private int gogitaiNo;
    private int shinsakaiYoteiTeiin;
    private int shinsakaiSaidaiTeiin;
    private int shinsakaiJidoWariateTeiin;
    private int shinsakaiIinTeiin;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private Code ShinsakaiShinchokuJokyo;
    private int shinsakaiWariateZumiNinzu;
    private boolean shiryoSakuseiZumiFlag;
    private FlexibleDate mobileDataOutputYMD;

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
     *
     * @return 介護認定審査会開催番号
     */
    public RString getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(@Nonnull RString shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催予定年月日のgetメソッドです。
     *
     * @return 介護認定審査会開催予定年月日
     */
    public FlexibleDate getShinsakaiKaisaiYoteiYMD() {
        return shinsakaiKaisaiYoteiYMD;
    }

    /**
     * 介護認定審査会開催予定年月日のsetメソッドです。
     *
     * @param shinsakaiKaisaiYoteiYMD 介護認定審査会開催予定年月日
     */
    public void setShinsakaiKaisaiYoteiYMD(@Nonnull FlexibleDate shinsakaiKaisaiYoteiYMD) {
        this.shinsakaiKaisaiYoteiYMD = shinsakaiKaisaiYoteiYMD;
    }

    /**
     * 介護認定審査会開始予定時刻のgetメソッドです。
     *
     * @return 介護認定審査会開始予定時刻
     */
    public RString getShinsakaiKaishiYoteiTime() {
        return shinsakaiKaishiYoteiTime;
    }

    /**
     * 介護認定審査会開始予定時刻のsetメソッドです。
     *
     * @param shinsakaiKaishiYoteiTime 介護認定審査会開始予定時刻
     */
    public void setShinsakaiKaishiYoteiTime(@Nonnull RString shinsakaiKaishiYoteiTime) {
        this.shinsakaiKaishiYoteiTime = shinsakaiKaishiYoteiTime;
    }

    /**
     * 介護認定審査会終了予定時刻のgetメソッドです。
     *
     * @return 介護認定審査会終了予定時刻
     */
    public RString getShinsakaiShuryoYoteiTime() {
        return shinsakaiShuryoYoteiTime;
    }

    /**
     * 介護認定審査会終了予定時刻のsetメソッドです。
     *
     * @param shinsakaiShuryoYoteiTime 介護認定審査会終了予定時刻
     */
    public void setShinsakaiShuryoYoteiTime(@Nonnull RString shinsakaiShuryoYoteiTime) {
        this.shinsakaiShuryoYoteiTime = shinsakaiShuryoYoteiTime;
    }

    /**
     * 介護認定審査会開催予定場所コードのgetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催場所情報
     *
     * @return 介護認定審査会開催予定場所コード
     */
    public RString getShinsakaiKaisaiYoteiBashoCode() {
        return shinsakaiKaisaiYoteiBashoCode;
    }

    /**
     * 介護認定審査会開催予定場所コードのsetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催場所情報
     *
     * @param shinsakaiKaisaiYoteiBashoCode 介護認定審査会開催予定場所コード
     */
    public void setShinsakaiKaisaiYoteiBashoCode(@Nonnull RString shinsakaiKaisaiYoteiBashoCode) {
        this.shinsakaiKaisaiYoteiBashoCode = shinsakaiKaisaiYoteiBashoCode;
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
     * 介護認定審査会予定定員のgetメソッドです。
     *
     * @return 介護認定審査会予定定員
     */
    public int getShinsakaiYoteiTeiin() {
        return shinsakaiYoteiTeiin;
    }

    /**
     * 介護認定審査会予定定員のsetメソッドです。
     *
     * @param shinsakaiYoteiTeiin 介護認定審査会予定定員
     */
    public void setShinsakaiYoteiTeiin(@Nonnull int shinsakaiYoteiTeiin) {
        this.shinsakaiYoteiTeiin = shinsakaiYoteiTeiin;
    }

    /**
     * 介護認定審査会最大定員のgetメソッドです。
     *
     * @return 介護認定審査会最大定員
     */
    public int getShinsakaiSaidaiTeiin() {
        return shinsakaiSaidaiTeiin;
    }

    /**
     * 介護認定審査会最大定員のsetメソッドです。
     *
     * @param shinsakaiSaidaiTeiin 介護認定審査会最大定員
     */
    public void setShinsakaiSaidaiTeiin(@Nonnull int shinsakaiSaidaiTeiin) {
        this.shinsakaiSaidaiTeiin = shinsakaiSaidaiTeiin;
    }

    /**
     * 介護認定審査会自動割当定員のgetメソッドです。
     *
     * @return 介護認定審査会自動割当定員
     */
    @CheckForNull
    public int getShinsakaiJidoWariateTeiin() {
        return shinsakaiJidoWariateTeiin;
    }

    /**
     * 介護認定審査会自動割当定員のsetメソッドです。
     *
     * @param shinsakaiJidoWariateTeiin 介護認定審査会自動割当定員
     */
    public void setShinsakaiJidoWariateTeiin(int shinsakaiJidoWariateTeiin) {
        this.shinsakaiJidoWariateTeiin = shinsakaiJidoWariateTeiin;
    }

    /**
     * 介護認定審査会委員定員のgetメソッドです。
     *
     * @return 介護認定審査会委員定員
     */
    public int getShinsakaiIinTeiin() {
        return shinsakaiIinTeiin;
    }

    /**
     * 介護認定審査会委員定員のsetメソッドです。
     *
     * @param shinsakaiIinTeiin 介護認定審査会委員定員
     */
    public void setShinsakaiIinTeiin(@Nonnull int shinsakaiIinTeiin) {
        this.shinsakaiIinTeiin = shinsakaiIinTeiin;
    }

    /**
     * 介護認定審査会資料作成年月日のgetメソッドです。
     *
     * @return 介護認定審査会資料作成年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 介護認定審査会資料作成年月日のsetメソッドです。
     *
     * @param shinsakaiShiryoSakuseiYMD 介護認定審査会資料作成年月日
     */
    public void setShinsakaiShiryoSakuseiYMD(FlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 介護認定審査会進捗状況のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会進捗状況）1:未開催、2:中止、3:完了
     *
     * @return 介護認定審査会進捗状況
     */
    public Code getShinsakaiShinchokuJokyo() {
        return ShinsakaiShinchokuJokyo;
    }

    /**
     * 介護認定審査会進捗状況のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：介護認定審査会進捗状況）1:未開催、2:中止、3:完了
     *
     * @param ShinsakaiShinchokuJokyo 介護認定審査会進捗状況
     */
    public void setShinsakaiShinchokuJokyo(@Nonnull Code ShinsakaiShinchokuJokyo) {
        this.ShinsakaiShinchokuJokyo = ShinsakaiShinchokuJokyo;
    }

    /**
     * 介護認定審査会割当済み人数のgetメソッドです。
     *
     * @return 介護認定審査会割当済み人数
     */
    public int getShinsakaiWariateZumiNinzu() {
        return shinsakaiWariateZumiNinzu;
    }

    /**
     * 介護認定審査会割当済み人数のsetメソッドです。
     *
     * @param shinsakaiWariateZumiNinzu 介護認定審査会割当済み人数
     */
    public void setShinsakaiWariateZumiNinzu(@Nonnull int shinsakaiWariateZumiNinzu) {
        this.shinsakaiWariateZumiNinzu = shinsakaiWariateZumiNinzu;
    }

    /**
     * 資料作成済フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：資料作成済区分）
     *
     * @return 資料作成済フラグ
     */
    @CheckForNull
    public boolean getShiryoSakuseiZumiFlag() {
        return shiryoSakuseiZumiFlag;
    }

    /**
     * 資料作成済フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：資料作成済区分）
     *
     * @param shiryoSakuseiZumiFlag 資料作成済フラグ
     */
    public void setShiryoSakuseiZumiFlag(boolean shiryoSakuseiZumiFlag) {
        this.shiryoSakuseiZumiFlag = shiryoSakuseiZumiFlag;
    }

    /**
     * モバイルデータ出力年月日のgetメソッドです。
     *
     * @return モバイルデータ出力年月日
     */
    @CheckForNull
    public FlexibleDate getMobileDataOutputYMD() {
        return mobileDataOutputYMD;
    }

    /**
     * モバイルデータ出力年月日のsetメソッドです。
     *
     * @param mobileDataOutputYMD モバイルデータ出力年月日
     */
    public void setMobileDataOutputYMD(FlexibleDate mobileDataOutputYMD) {
        this.mobileDataOutputYMD = mobileDataOutputYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5501ShinsakaiKaisaiYoteiJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5501ShinsakaiKaisaiYoteiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5501ShinsakaiKaisaiYoteiJohoEntity other) {
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
    public void shallowCopy(DbT5501ShinsakaiKaisaiYoteiJohoEntity entity) {
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYoteiYMD = entity.shinsakaiKaisaiYoteiYMD;
        this.shinsakaiKaishiYoteiTime = entity.shinsakaiKaishiYoteiTime;
        this.shinsakaiShuryoYoteiTime = entity.shinsakaiShuryoYoteiTime;
        this.shinsakaiKaisaiYoteiBashoCode = entity.shinsakaiKaisaiYoteiBashoCode;
        this.gogitaiNo = entity.gogitaiNo;
        this.shinsakaiYoteiTeiin = entity.shinsakaiYoteiTeiin;
        this.shinsakaiSaidaiTeiin = entity.shinsakaiSaidaiTeiin;
        this.shinsakaiJidoWariateTeiin = entity.shinsakaiJidoWariateTeiin;
        this.shinsakaiIinTeiin = entity.shinsakaiIinTeiin;
        this.shinsakaiShiryoSakuseiYMD = entity.shinsakaiShiryoSakuseiYMD;
        this.ShinsakaiShinchokuJokyo = entity.ShinsakaiShinchokuJokyo;
        this.shinsakaiWariateZumiNinzu = entity.shinsakaiWariateZumiNinzu;
        this.shiryoSakuseiZumiFlag = entity.shiryoSakuseiZumiFlag;
        this.mobileDataOutputYMD = entity.mobileDataOutputYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiKaisaiNo, shinsakaiKaisaiYoteiYMD, shinsakaiKaishiYoteiTime, shinsakaiShuryoYoteiTime, shinsakaiKaisaiYoteiBashoCode, gogitaiNo, shinsakaiYoteiTeiin, shinsakaiSaidaiTeiin, shinsakaiJidoWariateTeiin, shinsakaiIinTeiin, shinsakaiShiryoSakuseiYMD, ShinsakaiShinchokuJokyo, shinsakaiWariateZumiNinzu, shiryoSakuseiZumiFlag, mobileDataOutputYMD);
    }

// </editor-fold>
}
