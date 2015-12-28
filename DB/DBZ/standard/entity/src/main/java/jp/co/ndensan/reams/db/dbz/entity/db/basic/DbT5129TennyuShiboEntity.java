package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 転入・死亡情報テーブルのエンティティクラスです。
 */
public class DbT5129TennyuShiboEntity extends DbTableEntityBase<DbT5129TennyuShiboEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5129TennyuShibo");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    private FlexibleDate nijiHanteiYMD;
    private Code nijiHanteiYokaigoJotaiKubunCode;
    private int nijiHanteiNinteiYukoKikan;
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private int shinsakaiKaisaiNo;
    private RString shinsakaiIken;
    private RString ichijiHnateiKekkaHenkoRiyu;
    private Code yokaigoJotaizoReiCode;
    private RString ninteishinsakaiIkenShurui;
    private RString shinsakaiMemo;
    private Code nijiHanteiKekkaInputHoho;
    private FlexibleDate niniHanteiKekkaInputYMD;

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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @return 申請書管理番号
     */
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
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 二次判定年月日のgetメソッドです。
     *
     * @return 二次判定年月日
     */
    public FlexibleDate getNijiHanteiYMD() {
        return nijiHanteiYMD;
    }

    /**
     * 二次判定年月日のsetメソッドです。
     *
     * @param nijiHanteiYMD 二次判定年月日
     */
    public void setNijiHanteiYMD(@Nonnull FlexibleDate nijiHanteiYMD) {
        this.nijiHanteiYMD = nijiHanteiYMD;
    }

    /**
     * 二次判定要介護状態区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード09）
     *
     * @return 二次判定要介護状態区分コード
     */
    public Code getNijiHanteiYokaigoJotaiKubunCode() {
        return nijiHanteiYokaigoJotaiKubunCode;
    }

    /**
     * 二次判定要介護状態区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード09）
     *
     * @param nijiHanteiYokaigoJotaiKubunCode 二次判定要介護状態区分コード
     */
    public void setNijiHanteiYokaigoJotaiKubunCode(@Nonnull Code nijiHanteiYokaigoJotaiKubunCode) {
        this.nijiHanteiYokaigoJotaiKubunCode = nijiHanteiYokaigoJotaiKubunCode;
    }

    /**
     * 二次判定認定有効期間のgetメソッドです。
     *
     * @return 二次判定認定有効期間
     */
    public int getNijiHanteiNinteiYukoKikan() {
        return nijiHanteiNinteiYukoKikan;
    }

    /**
     * 二次判定認定有効期間のsetメソッドです。
     *
     * @param nijiHanteiNinteiYukoKikan 二次判定認定有効期間
     */
    public void setNijiHanteiNinteiYukoKikan(@Nonnull int nijiHanteiNinteiYukoKikan) {
        this.nijiHanteiNinteiYukoKikan = nijiHanteiNinteiYukoKikan;
    }

    /**
     * 二時判定認定有効開始年月日のgetメソッドです。
     *
     * @return 二時判定認定有効開始年月日
     */
    @CheckForNull
    public FlexibleDate getNijiHanteiNinteiYukoKaishiYMD() {
        return nijiHanteiNinteiYukoKaishiYMD;
    }

    /**
     * 二時判定認定有効開始年月日のsetメソッドです。
     *
     * @param nijiHanteiNinteiYukoKaishiYMD 二時判定認定有効開始年月日
     */
    public void setNijiHanteiNinteiYukoKaishiYMD(FlexibleDate nijiHanteiNinteiYukoKaishiYMD) {
        this.nijiHanteiNinteiYukoKaishiYMD = nijiHanteiNinteiYukoKaishiYMD;
    }

    /**
     * 二時判定認定有効終了年月日のgetメソッドです。
     *
     * @return 二時判定認定有効終了年月日
     */
    @CheckForNull
    public FlexibleDate getNijiHanteiNinteiYukoShuryoYMD() {
        return nijiHanteiNinteiYukoShuryoYMD;
    }

    /**
     * 二時判定認定有効終了年月日のsetメソッドです。
     *
     * @param nijiHanteiNinteiYukoShuryoYMD 二時判定認定有効終了年月日
     */
    public void setNijiHanteiNinteiYukoShuryoYMD(FlexibleDate nijiHanteiNinteiYukoShuryoYMD) {
        this.nijiHanteiNinteiYukoShuryoYMD = nijiHanteiNinteiYukoShuryoYMD;
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
     * 介護認定審査会開催番号のgetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @return 介護認定審査会開催番号
     */
    @CheckForNull
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * <br/>
     * <br/>介護認定審査会開催予定情報
     *
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会意見のgetメソッドです。
     *
     * @return 介護認定審査会意見
     */
    @CheckForNull
    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    /**
     * 介護認定審査会意見のsetメソッドです。
     *
     * @param shinsakaiIken 介護認定審査会意見
     */
    public void setShinsakaiIken(RString shinsakaiIken) {
        this.shinsakaiIken = shinsakaiIken;
    }

    /**
     * 一次判定結果変更理由のgetメソッドです。
     *
     * @return 一次判定結果変更理由
     */
    @CheckForNull
    public RString getIchijiHnateiKekkaHenkoRiyu() {
        return ichijiHnateiKekkaHenkoRiyu;
    }

    /**
     * 一次判定結果変更理由のsetメソッドです。
     *
     * @param ichijiHnateiKekkaHenkoRiyu 一次判定結果変更理由
     */
    public void setIchijiHnateiKekkaHenkoRiyu(RString ichijiHnateiKekkaHenkoRiyu) {
        this.ichijiHnateiKekkaHenkoRiyu = ichijiHnateiKekkaHenkoRiyu;
    }

    /**
     * 要介護状態像例コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護状態像例コード）要介護１の場合の状態像
     *
     * @return 要介護状態像例コード
     */
    @CheckForNull
    public Code getYokaigoJotaizoReiCode() {
        return yokaigoJotaizoReiCode;
    }

    /**
     * 要介護状態像例コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護状態像例コード）要介護１の場合の状態像
     *
     * @param yokaigoJotaizoReiCode 要介護状態像例コード
     */
    public void setYokaigoJotaizoReiCode(Code yokaigoJotaizoReiCode) {
        this.yokaigoJotaizoReiCode = yokaigoJotaizoReiCode;
    }

    /**
     * 認定審査会意見種類のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定審査会意見種類）
     *
     * @return 認定審査会意見種類
     */
    @CheckForNull
    public RString getNinteishinsakaiIkenShurui() {
        return ninteishinsakaiIkenShurui;
    }

    /**
     * 認定審査会意見種類のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定審査会意見種類）
     *
     * @param ninteishinsakaiIkenShurui 認定審査会意見種類
     */
    public void setNinteishinsakaiIkenShurui(RString ninteishinsakaiIkenShurui) {
        this.ninteishinsakaiIkenShurui = ninteishinsakaiIkenShurui;
    }

    /**
     * 審査会メモのgetメソッドです。
     *
     * @return 審査会メモ
     */
    @CheckForNull
    public RString getShinsakaiMemo() {
        return shinsakaiMemo;
    }

    /**
     * 審査会メモのsetメソッドです。
     *
     * @param shinsakaiMemo 審査会メモ
     */
    public void setShinsakaiMemo(RString shinsakaiMemo) {
        this.shinsakaiMemo = shinsakaiMemo;
    }

    /**
     * 二次判定結果入力方法のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：二次判定結果入力方法）1:画面入力、2:モバイル取込、3:ＯＣＲ取込
     *
     * @return 二次判定結果入力方法
     */
    @CheckForNull
    public Code getNijiHanteiKekkaInputHoho() {
        return nijiHanteiKekkaInputHoho;
    }

    /**
     * 二次判定結果入力方法のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：二次判定結果入力方法）1:画面入力、2:モバイル取込、3:ＯＣＲ取込
     *
     * @param nijiHanteiKekkaInputHoho 二次判定結果入力方法
     */
    public void setNijiHanteiKekkaInputHoho(Code nijiHanteiKekkaInputHoho) {
        this.nijiHanteiKekkaInputHoho = nijiHanteiKekkaInputHoho;
    }

    /**
     * 二次判定結果入力年月日のgetメソッドです。
     *
     * @return 二次判定結果入力年月日
     */
    @CheckForNull
    public FlexibleDate getNiniHanteiKekkaInputYMD() {
        return niniHanteiKekkaInputYMD;
    }

    /**
     * 二次判定結果入力年月日のsetメソッドです。
     *
     * @param niniHanteiKekkaInputYMD 二次判定結果入力年月日
     */
    public void setNiniHanteiKekkaInputYMD(FlexibleDate niniHanteiKekkaInputYMD) {
        this.niniHanteiKekkaInputYMD = niniHanteiKekkaInputYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5129TennyuShiboEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5129TennyuShiboEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5129TennyuShiboEntity other) {
        if (other == null) {
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
    public void shallowCopy(DbT5129TennyuShiboEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.nijiHanteiYMD = entity.nijiHanteiYMD;
        this.nijiHanteiYokaigoJotaiKubunCode = entity.nijiHanteiYokaigoJotaiKubunCode;
        this.nijiHanteiNinteiYukoKikan = entity.nijiHanteiNinteiYukoKikan;
        this.nijiHanteiNinteiYukoKaishiYMD = entity.nijiHanteiNinteiYukoKaishiYMD;
        this.nijiHanteiNinteiYukoShuryoYMD = entity.nijiHanteiNinteiYukoShuryoYMD;
        this.shinsakaiShiryoSakuseiYMD = entity.shinsakaiShiryoSakuseiYMD;
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiIken = entity.shinsakaiIken;
        this.ichijiHnateiKekkaHenkoRiyu = entity.ichijiHnateiKekkaHenkoRiyu;
        this.yokaigoJotaizoReiCode = entity.yokaigoJotaizoReiCode;
        this.ninteishinsakaiIkenShurui = entity.ninteishinsakaiIkenShurui;
        this.shinsakaiMemo = entity.shinsakaiMemo;
        this.nijiHanteiKekkaInputHoho = entity.nijiHanteiKekkaInputHoho;
        this.niniHanteiKekkaInputYMD = entity.niniHanteiKekkaInputYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, nijiHanteiYMD, nijiHanteiYokaigoJotaiKubunCode, nijiHanteiNinteiYukoKikan, nijiHanteiNinteiYukoKaishiYMD, nijiHanteiNinteiYukoShuryoYMD, shinsakaiShiryoSakuseiYMD, shinsakaiKaisaiNo, shinsakaiIken, ichijiHnateiKekkaHenkoRiyu, yokaigoJotaizoReiCode, ninteishinsakaiIkenShurui, shinsakaiMemo, nijiHanteiKekkaInputHoho, niniHanteiKekkaInputYMD);
    }

// </editor-fold>
}
