package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 認定調査スケジュール情報テーブルのエンティティクラスです。
 */
public class DbT5221NinteichosaScheduleEntity extends DbTableEntityBase<DbT5221NinteichosaScheduleEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5221NinteichosaSchedule");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private FlexibleDate ninteiChosaYoteiYMD;
    @PrimaryKey
    private RString ninteiChosaYoteiKaishiTime;
    @PrimaryKey
    private RString ninteiChosaYoteiShuryoTime;
    @PrimaryKey
    private Code ninteiChosaJikanWaku;
    @PrimaryKey
    private Code chosaChikuCode;
    @PrimaryKey
    private RString ninteiChosaItakusakiCode;
    @PrimaryKey
    private RString ninteiChosainCode;
    @PrimaryKey
    private LasdecCode shichosonCode;
    private ShinseishoKanriNo shinseishoKanriNo;
    private Code yoyakuJokyo;
    private boolean yoyakuKaoFlag;
    private RString biko;
    private RString basho;
    private RString chushajo;
    private RString tachiainin1;
    private TelNo renrakusaki1;
    private RString tachiainin2;
    private TelNo renrakusaki2;
    private RString taishoshaMemo;

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
     * 認定調査予定年月日のgetメソッドです。
     * 
     * @return 認定調査予定年月日
     */
    public FlexibleDate getNinteiChosaYoteiYMD() {
        return ninteiChosaYoteiYMD;
    }

    /**
     * 認定調査予定年月日のsetメソッドです。
     * 
     * @param ninteiChosaYoteiYMD 認定調査予定年月日
     */
    public void setNinteiChosaYoteiYMD(@Nonnull FlexibleDate ninteiChosaYoteiYMD) {
        this.ninteiChosaYoteiYMD = ninteiChosaYoteiYMD;
    }

    /**
     * 認定調査予定開始時間のgetメソッドです。
     * 
     * @return 認定調査予定開始時間
     */
    public RString getNinteiChosaYoteiKaishiTime() {
        return ninteiChosaYoteiKaishiTime;
    }

    /**
     * 認定調査予定開始時間のsetメソッドです。
     * 
     * @param ninteiChosaYoteiKaishiTime 認定調査予定開始時間
     */
    public void setNinteiChosaYoteiKaishiTime(@Nonnull RString ninteiChosaYoteiKaishiTime) {
        this.ninteiChosaYoteiKaishiTime = ninteiChosaYoteiKaishiTime;
    }

    /**
     * 認定調査予定終了時間のgetメソッドです。
     * 
     * @return 認定調査予定終了時間
     */
    public RString getNinteiChosaYoteiShuryoTime() {
        return ninteiChosaYoteiShuryoTime;
    }

    /**
     * 認定調査予定終了時間のsetメソッドです。
     * 
     * @param ninteiChosaYoteiShuryoTime 認定調査予定終了時間
     */
    public void setNinteiChosaYoteiShuryoTime(@Nonnull RString ninteiChosaYoteiShuryoTime) {
        this.ninteiChosaYoteiShuryoTime = ninteiChosaYoteiShuryoTime;
    }

    /**
     * 認定調査時間枠のgetメソッドです。
     * 
     * @return 認定調査時間枠
     */
    public Code getNinteiChosaJikanWaku() {
        return ninteiChosaJikanWaku;
    }

    /**
     * 認定調査時間枠のsetメソッドです。
     * 
     * @param ninteiChosaJikanWaku 認定調査時間枠
     */
    public void setNinteiChosaJikanWaku(@Nonnull Code ninteiChosaJikanWaku) {
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
    }

    /**
     * 調査地区コードのgetメソッドです。
     * 
     * @return 調査地区コード
     */
    public Code getChosaChikuCode() {
        return chosaChikuCode;
    }

    /**
     * 調査地区コードのsetメソッドです。
     * 
     * @param chosaChikuCode 調査地区コード
     */
    public void setChosaChikuCode(@Nonnull Code chosaChikuCode) {
        this.chosaChikuCode = chosaChikuCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @return 認定調査委託先コード
     */
    public RString getNinteiChosaItakusakiCode() {
        return ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     * 
     * @param ninteiChosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteiChosaItakusakiCode(@Nonnull RString ninteiChosaItakusakiCode) {
        this.ninteiChosaItakusakiCode = ninteiChosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @return 認定調査員コード
     */
    public RString getNinteiChosainCode() {
        return ninteiChosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     * 
     * @param ninteiChosainCode 認定調査員コード
     */
    public void setNinteiChosainCode(@Nonnull RString ninteiChosainCode) {
        this.ninteiChosainCode = ninteiChosainCode;
    }

    /**
     * 市町村コードのgetメソッドです。
     * <br/>
     * <br/>市町村コード
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * <br/>
     * <br/>市町村コード
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @return 申請書管理番号
     */
    @CheckForNull
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 予約状況のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：予約状況）
     * 
     * @return 予約状況
     */
    public Code getYoyakuJokyo() {
        return yoyakuJokyo;
    }

    /**
     * 予約状況のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：予約状況）
     * 
     * @param yoyakuJokyo 予約状況
     */
    public void setYoyakuJokyo(@Nonnull Code yoyakuJokyo) {
        this.yoyakuJokyo = yoyakuJokyo;
    }

    /**
     * 予約可能フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：予約可能フラグ）
     * 
     * @return 予約可能フラグ
     */
    public boolean getYoyakuKaoFlag() {
        return yoyakuKaoFlag;
    }

    /**
     * 予約可能フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：予約可能フラグ）
     * 
     * @param yoyakuKaoFlag 予約可能フラグ
     */
    public void setYoyakuKaoFlag(@Nonnull boolean yoyakuKaoFlag) {
        this.yoyakuKaoFlag = yoyakuKaoFlag;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     * 
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * 場所のgetメソッドです。
     * 
     * @return 場所
     */
    @CheckForNull
    public RString getBasho() {
        return basho;
    }

    /**
     * 場所のsetメソッドです。
     * 
     * @param basho 場所
     */
    public void setBasho(RString basho) {
        this.basho = basho;
    }

    /**
     * 駐車場のgetメソッドです。
     * 
     * @return 駐車場
     */
    @CheckForNull
    public RString getChushajo() {
        return chushajo;
    }

    /**
     * 駐車場のsetメソッドです。
     * 
     * @param chushajo 駐車場
     */
    public void setChushajo(RString chushajo) {
        this.chushajo = chushajo;
    }

    /**
     * 立会人１のgetメソッドです。
     * 
     * @return 立会人１
     */
    @CheckForNull
    public RString getTachiainin1() {
        return tachiainin1;
    }

    /**
     * 立会人１のsetメソッドです。
     * 
     * @param tachiainin1 立会人１
     */
    public void setTachiainin1(RString tachiainin1) {
        this.tachiainin1 = tachiainin1;
    }

    /**
     * 連絡先１のgetメソッドです。
     * 
     * @return 連絡先１
     */
    @CheckForNull
    public TelNo getRenrakusaki1() {
        return renrakusaki1;
    }

    /**
     * 連絡先１のsetメソッドです。
     * 
     * @param renrakusaki1 連絡先１
     */
    public void setRenrakusaki1(TelNo renrakusaki1) {
        this.renrakusaki1 = renrakusaki1;
    }

    /**
     * 立会人２のgetメソッドです。
     * 
     * @return 立会人２
     */
    @CheckForNull
    public RString getTachiainin2() {
        return tachiainin2;
    }

    /**
     * 立会人２のsetメソッドです。
     * 
     * @param tachiainin2 立会人２
     */
    public void setTachiainin2(RString tachiainin2) {
        this.tachiainin2 = tachiainin2;
    }

    /**
     * 連絡先２のgetメソッドです。
     * 
     * @return 連絡先２
     */
    @CheckForNull
    public TelNo getRenrakusaki2() {
        return renrakusaki2;
    }

    /**
     * 連絡先２のsetメソッドです。
     * 
     * @param renrakusaki2 連絡先２
     */
    public void setRenrakusaki2(TelNo renrakusaki2) {
        this.renrakusaki2 = renrakusaki2;
    }

    /**
     * 対象者メモのgetメソッドです。
     * 
     * @return 対象者メモ
     */
    @CheckForNull
    public RString getTaishoshaMemo() {
        return taishoshaMemo;
    }

    /**
     * 対象者メモのsetメソッドです。
     * 
     * @param taishoshaMemo 対象者メモ
     */
    public void setTaishoshaMemo(RString taishoshaMemo) {
        this.taishoshaMemo = taishoshaMemo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5221NinteichosaScheduleEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5221NinteichosaScheduleEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5221NinteichosaScheduleEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaYoteiYMD, other.ninteiChosaYoteiYMD)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaYoteiKaishiTime, other.ninteiChosaYoteiKaishiTime)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaYoteiShuryoTime, other.ninteiChosaYoteiShuryoTime)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaJikanWaku, other.ninteiChosaJikanWaku)) {
            return false;
        }
        if (!Objects.equals(this.chosaChikuCode, other.chosaChikuCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosaItakusakiCode, other.ninteiChosaItakusakiCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosainCode, other.ninteiChosainCode)) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5221NinteichosaScheduleEntity entity) {
        this.ninteiChosaYoteiYMD = entity.ninteiChosaYoteiYMD;
        this.ninteiChosaYoteiKaishiTime = entity.ninteiChosaYoteiKaishiTime;
        this.ninteiChosaYoteiShuryoTime = entity.ninteiChosaYoteiShuryoTime;
        this.ninteiChosaJikanWaku = entity.ninteiChosaJikanWaku;
        this.chosaChikuCode = entity.chosaChikuCode;
        this.ninteiChosaItakusakiCode = entity.ninteiChosaItakusakiCode;
        this.ninteiChosainCode = entity.ninteiChosainCode;
        this.shichosonCode = entity.shichosonCode;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.yoyakuJokyo = entity.yoyakuJokyo;
        this.yoyakuKaoFlag = entity.yoyakuKaoFlag;
        this.biko = entity.biko;
        this.basho = entity.basho;
        this.chushajo = entity.chushajo;
        this.tachiainin1 = entity.tachiainin1;
        this.renrakusaki1 = entity.renrakusaki1;
        this.tachiainin2 = entity.tachiainin2;
        this.renrakusaki2 = entity.renrakusaki2;
        this.taishoshaMemo = entity.taishoshaMemo;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(ninteiChosaYoteiYMD, ninteiChosaYoteiKaishiTime, ninteiChosaYoteiShuryoTime, ninteiChosaJikanWaku, chosaChikuCode, ninteiChosaItakusakiCode, ninteiChosainCode, shichosonCode, shinseishoKanriNo, yoyakuJokyo, yoyakuKaoFlag, biko, basho, chushajo, tachiainin1, renrakusaki1, tachiainin2, renrakusaki2, taishoshaMemo);
    }

// </editor-fold>

}
