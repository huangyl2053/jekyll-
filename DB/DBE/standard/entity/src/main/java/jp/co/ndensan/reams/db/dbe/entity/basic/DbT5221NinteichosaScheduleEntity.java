package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * 認定調査スケジュール情報テーブルのエンティティクラスです。
 */
public class DbT5221NinteichosaScheduleEntity extends DbTableEntityBase<DbT5221NinteichosaScheduleEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    private RString ninteichosaItakusakiCode;
    @PrimaryKey
    private RString ninteiChosainNo;
    @PrimaryKey
    private DbUDD013ShinseishoKanriNo shinseishoKanriNo;
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
    public void setNinteiChosaYoteiYMD(FlexibleDate ninteiChosaYoteiYMD) {
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
    public void setNinteiChosaYoteiKaishiTime(RString ninteiChosaYoteiKaishiTime) {
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
    public void setNinteiChosaYoteiShuryoTime(RString ninteiChosaYoteiShuryoTime) {
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
    public void setNinteiChosaJikanWaku(Code ninteiChosaJikanWaku) {
        this.ninteiChosaJikanWaku = ninteiChosaJikanWaku;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * 
     * @return 認定調査委託先コード
     */
    public RString getNinteichosaItakusakiCode() {
        return ninteichosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * 
     * @param ninteichosaItakusakiCode 認定調査委託先コード
     */
    public void setNinteichosaItakusakiCode(RString ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * 
     * @return 認定調査員コード
     */
    public RString getNinteiChosainNo() {
        return ninteiChosainNo;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * 
     * @param ninteiChosainNo 認定調査員コード
     */
    public void setNinteiChosainNo(RString ninteiChosainNo) {
        this.ninteiChosainNo = ninteiChosainNo;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     * 
     * @return 申請書管理番号
     */
    public DbUDD013ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(DbUDD013ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 予約状況のgetメソッドです。
     * 
     * @return 予約状況
     */
    public Code getYoyakuJokyo() {
        return yoyakuJokyo;
    }

    /**
     * 予約状況のsetメソッドです。
     * 
     * @param yoyakuJokyo 予約状況
     */
    public void setYoyakuJokyo(Code yoyakuJokyo) {
        this.yoyakuJokyo = yoyakuJokyo;
    }

    /**
     * 予約可能フラグのgetメソッドです。
     * 
     * @return 予約可能フラグ
     */
    public boolean getYoyakuKaoFlag() {
        return yoyakuKaoFlag;
    }

    /**
     * 予約可能フラグのsetメソッドです。
     * 
     * @param yoyakuKaoFlag 予約可能フラグ
     */
    public void setYoyakuKaoFlag(boolean yoyakuKaoFlag) {
        this.yoyakuKaoFlag = yoyakuKaoFlag;
    }

    /**
     * 備考のgetメソッドです。
     * 
     * @return 備考
     */
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
     * @@return 
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
        if (!Objects.equals(this.ninteichosaItakusakiCode, other.ninteichosaItakusakiCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteiChosainNo, other.ninteiChosainNo)) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
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
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.ninteiChosainNo = entity.ninteiChosainNo;
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
        return super.toMd5(ninteiChosaYoteiYMD, ninteiChosaYoteiKaishiTime, ninteiChosaYoteiShuryoTime, ninteiChosaJikanWaku, ninteichosaItakusakiCode, ninteiChosainNo, shinseishoKanriNo, yoyakuJokyo, yoyakuKaoFlag, biko, basho, chushajo, tachiainin1, renrakusaki1, tachiainin2, renrakusaki2, taishoshaMemo);
    }

// </editor-fold>
}
