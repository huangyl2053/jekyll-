package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;

/**
 * 介護認定審査会委員報酬実績情報テーブルのエンティティクラスです。
 */
public class DbT5603ShinsakaiIinHoshuJissekiJohoEntity extends DbTableEntityBase<DbT5603ShinsakaiIinHoshuJissekiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5603ShinsakaiIinHoshuJissekiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiIinCode;
    @PrimaryKey
    private Code shinsakaiIinHoshuKubun;
    @PrimaryKey
    private FlexibleDate shinsakaiKaisaiYMD;
    @PrimaryKey
    private int remban;
    private int shinsakaiKaisaiNo;
    private int shinsakaiHoshuZeiritsu;
    private int shinsakaiHoshu;
    private int shinsakaiSonotaHoshu;
    private int shinsakaiKotsuhi;
    private int shinsakaiKojoZeigaku;
    private int shinsakaiHoshuGokei;
    private FlexibleDate hoshuShiharaiYMD;
    private RString hoshuShiharaiMemo;
    private boolean ginkoFurikomiShutsuryokuFlag;

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
     * 介護認定審査会委員コードのgetメソッドです。
     * 
     * @return 介護認定審査会委員コード
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員コードのsetメソッドです。
     * 
     * @param shinsakaiIinCode 介護認定審査会委員コード
     */
    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 審査会委員報酬区分のgetメソッドです。
     * <br/>
     * <br/>1:審査報酬、2:その他報酬
     * 
     * @return 審査会委員報酬区分
     */
    public Code getShinsakaiIinHoshuKubun() {
        return shinsakaiIinHoshuKubun;
    }

    /**
     * 審査会委員報酬区分のsetメソッドです。
     * <br/>
     * <br/>1:審査報酬、2:その他報酬
     * 
     * @param shinsakaiIinHoshuKubun 審査会委員報酬区分
     */
    public void setShinsakaiIinHoshuKubun(Code shinsakaiIinHoshuKubun) {
        this.shinsakaiIinHoshuKubun = shinsakaiIinHoshuKubun;
    }

    /**
     * 実施年月日のgetメソッドです。
     * 
     * @return 実施年月日
     */
    public FlexibleDate getShinsakaiKaisaiYMD() {
        return shinsakaiKaisaiYMD;
    }

    /**
     * 実施年月日のsetメソッドです。
     * 
     * @param shinsakaiKaisaiYMD 実施年月日
     */
    public void setShinsakaiKaisaiYMD(FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * 連番のgetメソッドです。
     * 
     * @return 連番
     */
    public int getRemban() {
        return remban;
    }

    /**
     * 連番のsetメソッドです。
     * 
     * @param remban 連番
     */
    public void setRemban(int remban) {
        this.remban = remban;
    }

    /**
     * 介護認定審査会開催番号のgetメソッドです。
     * 
     * @return 介護認定審査会開催番号
     */
    public int getShinsakaiKaisaiNo() {
        return shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会開催番号のsetメソッドです。
     * 
     * @param shinsakaiKaisaiNo 介護認定審査会開催番号
     */
    public void setShinsakaiKaisaiNo(int shinsakaiKaisaiNo) {
        this.shinsakaiKaisaiNo = shinsakaiKaisaiNo;
    }

    /**
     * 介護認定審査会報酬税率のgetメソッドです。
     * 
     * @return 介護認定審査会報酬税率
     */
    public int getShinsakaiHoshuZeiritsu() {
        return shinsakaiHoshuZeiritsu;
    }

    /**
     * 介護認定審査会報酬税率のsetメソッドです。
     * 
     * @param shinsakaiHoshuZeiritsu 介護認定審査会報酬税率
     */
    public void setShinsakaiHoshuZeiritsu(int shinsakaiHoshuZeiritsu) {
        this.shinsakaiHoshuZeiritsu = shinsakaiHoshuZeiritsu;
    }

    /**
     * 介護認定審査報酬のgetメソッドです。
     * 
     * @return 介護認定審査報酬
     */
    public int getShinsakaiHoshu() {
        return shinsakaiHoshu;
    }

    /**
     * 介護認定審査報酬のsetメソッドです。
     * 
     * @param shinsakaiHoshu 介護認定審査報酬
     */
    public void setShinsakaiHoshu(int shinsakaiHoshu) {
        this.shinsakaiHoshu = shinsakaiHoshu;
    }

    /**
     * 介護認定審査その他報酬のgetメソッドです。
     * 
     * @return 介護認定審査その他報酬
     */
    public int getShinsakaiSonotaHoshu() {
        return shinsakaiSonotaHoshu;
    }

    /**
     * 介護認定審査その他報酬のsetメソッドです。
     * 
     * @param shinsakaiSonotaHoshu 介護認定審査その他報酬
     */
    public void setShinsakaiSonotaHoshu(int shinsakaiSonotaHoshu) {
        this.shinsakaiSonotaHoshu = shinsakaiSonotaHoshu;
    }

    /**
     * 介護認定審査交通費等のgetメソッドです。
     * 
     * @return 介護認定審査交通費等
     */
    public int getShinsakaiKotsuhi() {
        return shinsakaiKotsuhi;
    }

    /**
     * 介護認定審査交通費等のsetメソッドです。
     * 
     * @param shinsakaiKotsuhi 介護認定審査交通費等
     */
    public void setShinsakaiKotsuhi(int shinsakaiKotsuhi) {
        this.shinsakaiKotsuhi = shinsakaiKotsuhi;
    }

    /**
     * 介護認定審査控除税額のgetメソッドです。
     * 
     * @return 介護認定審査控除税額
     */
    public int getShinsakaiKojoZeigaku() {
        return shinsakaiKojoZeigaku;
    }

    /**
     * 介護認定審査控除税額のsetメソッドです。
     * 
     * @param shinsakaiKojoZeigaku 介護認定審査控除税額
     */
    public void setShinsakaiKojoZeigaku(int shinsakaiKojoZeigaku) {
        this.shinsakaiKojoZeigaku = shinsakaiKojoZeigaku;
    }

    /**
     * 介護認定審査報酬合計のgetメソッドです。
     * 
     * @return 介護認定審査報酬合計
     */
    public int getShinsakaiHoshuGokei() {
        return shinsakaiHoshuGokei;
    }

    /**
     * 介護認定審査報酬合計のsetメソッドです。
     * 
     * @param shinsakaiHoshuGokei 介護認定審査報酬合計
     */
    public void setShinsakaiHoshuGokei(int shinsakaiHoshuGokei) {
        this.shinsakaiHoshuGokei = shinsakaiHoshuGokei;
    }

    /**
     * 介護認定審査報酬支払年月日のgetメソッドです。
     * 
     * @return 介護認定審査報酬支払年月日
     */
    public FlexibleDate getHoshuShiharaiYMD() {
        return hoshuShiharaiYMD;
    }

    /**
     * 介護認定審査報酬支払年月日のsetメソッドです。
     * 
     * @param hoshuShiharaiYMD 介護認定審査報酬支払年月日
     */
    public void setHoshuShiharaiYMD(FlexibleDate hoshuShiharaiYMD) {
        this.hoshuShiharaiYMD = hoshuShiharaiYMD;
    }

    /**
     * 介護認定審査報酬支払メモのgetメソッドです。
     * 
     * @return 介護認定審査報酬支払メモ
     */
    public RString getHoshuShiharaiMemo() {
        return hoshuShiharaiMemo;
    }

    /**
     * 介護認定審査報酬支払メモのsetメソッドです。
     * 
     * @param hoshuShiharaiMemo 介護認定審査報酬支払メモ
     */
    public void setHoshuShiharaiMemo(RString hoshuShiharaiMemo) {
        this.hoshuShiharaiMemo = hoshuShiharaiMemo;
    }

    /**
     * 銀行振込出力フラグのgetメソッドです。
     * 
     * @return 銀行振込出力フラグ
     */
    public boolean getGinkoFurikomiShutsuryokuFlag() {
        return ginkoFurikomiShutsuryokuFlag;
    }

    /**
     * 銀行振込出力フラグのsetメソッドです。
     * 
     * @param ginkoFurikomiShutsuryokuFlag 銀行振込出力フラグ
     */
    public void setGinkoFurikomiShutsuryokuFlag(boolean ginkoFurikomiShutsuryokuFlag) {
        this.ginkoFurikomiShutsuryokuFlag = ginkoFurikomiShutsuryokuFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5603ShinsakaiIinHoshuJissekiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5603ShinsakaiIinHoshuJissekiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5603ShinsakaiIinHoshuJissekiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinHoshuKubun, other.shinsakaiIinHoshuKubun)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiYMD, other.shinsakaiKaisaiYMD)) {
            return false;
        }
        if (this.remban != other.remban) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5603ShinsakaiIinHoshuJissekiJohoEntity entity) {
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiIinHoshuKubun = entity.shinsakaiIinHoshuKubun;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.remban = entity.remban;
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiHoshuZeiritsu = entity.shinsakaiHoshuZeiritsu;
        this.shinsakaiHoshu = entity.shinsakaiHoshu;
        this.shinsakaiSonotaHoshu = entity.shinsakaiSonotaHoshu;
        this.shinsakaiKotsuhi = entity.shinsakaiKotsuhi;
        this.shinsakaiKojoZeigaku = entity.shinsakaiKojoZeigaku;
        this.shinsakaiHoshuGokei = entity.shinsakaiHoshuGokei;
        this.hoshuShiharaiYMD = entity.hoshuShiharaiYMD;
        this.hoshuShiharaiMemo = entity.hoshuShiharaiMemo;
        this.ginkoFurikomiShutsuryokuFlag = entity.ginkoFurikomiShutsuryokuFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiIinCode, shinsakaiIinHoshuKubun, shinsakaiKaisaiYMD, remban, shinsakaiKaisaiNo, shinsakaiHoshuZeiritsu, shinsakaiHoshu, shinsakaiSonotaHoshu, shinsakaiKotsuhi, shinsakaiKojoZeigaku, shinsakaiHoshuGokei, hoshuShiharaiYMD, hoshuShiharaiMemo, ginkoFurikomiShutsuryokuFlag);
    }

// </editor-fold>

}
