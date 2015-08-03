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
import java.util.Objects;

/**
 * 介護認定審査会委員報酬実績情報テーブルのエンティティクラスです。
 */
public class DbT5113ShinsakaiIinHoshuJissekiJohoEntity extends DbTableEntityBase<DbT5113ShinsakaiIinHoshuJissekiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5113ShinsakaiIinHoshuJissekiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private int gogitaiNo;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private DbUDD004JigyoshaNo shinsakaiIinShozokuKikanCode;
    private int shinsakaiKaisaiNo;
    @PrimaryKey
    private FlexibleDate shinsakaiKaisaiYMD;
    private RString shinsakaiKaishiTime;
    private RString shinsakaiShuryoTime;
    private boolean isShusseki;
    private RString shussekiTime;
    private RString taisekiTime;
    private Code gogitaichoKubunCode;
    private int shinsakaiHoshuZeiritsu;
    private int shinsakaiHoshu;
    private int shinsakaiSonotaHoshu;
    private int shinsakaiKotsuhi;
    private int shinsakaiKojoZeigaku;
    private int shinsakaiHoshuGokei;
    private FlexibleDate hoshuShiharaiYMD;
    private RString hoshushiharaiMemo;
    private boolean isGinkoFurikomiShutsuryokuZumi;

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
     * 合議体番号のgetメソッドです。
     * 
     * @return 合議体番号
     */
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * 合議体番号のsetメソッドです。
     * 
     * @param gogitaiNo 合議体番号
     */
    public void setGogitaiNo(int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
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
     * 介護認定審査会委員所属機関コードのgetメソッドです。
     * 
     * @return 介護認定審査会委員所属機関コード
     */
    public DbUDD004JigyoshaNo getShinsakaiIinShozokuKikanCode() {
        return shinsakaiIinShozokuKikanCode;
    }

    /**
     * 介護認定審査会委員所属機関コードのsetメソッドです。
     * 
     * @param shinsakaiIinShozokuKikanCode 介護認定審査会委員所属機関コード
     */
    public void setShinsakaiIinShozokuKikanCode(DbUDD004JigyoshaNo shinsakaiIinShozokuKikanCode) {
        this.shinsakaiIinShozokuKikanCode = shinsakaiIinShozokuKikanCode;
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
    public void setShinsakaiKaisaiYMD(FlexibleDate shinsakaiKaisaiYMD) {
        this.shinsakaiKaisaiYMD = shinsakaiKaisaiYMD;
    }

    /**
     * 介護認定審査会開始時間のgetメソッドです。
     * 
     * @return 介護認定審査会開始時間
     */
    public RString getShinsakaiKaishiTime() {
        return shinsakaiKaishiTime;
    }

    /**
     * 介護認定審査会開始時間のsetメソッドです。
     * 
     * @param shinsakaiKaishiTime 介護認定審査会開始時間
     */
    public void setShinsakaiKaishiTime(RString shinsakaiKaishiTime) {
        this.shinsakaiKaishiTime = shinsakaiKaishiTime;
    }

    /**
     * 介護認定審査会終了時間のgetメソッドです。
     * 
     * @return 介護認定審査会終了時間
     */
    public RString getShinsakaiShuryoTime() {
        return shinsakaiShuryoTime;
    }

    /**
     * 介護認定審査会終了時間のsetメソッドです。
     * 
     * @param shinsakaiShuryoTime 介護認定審査会終了時間
     */
    public void setShinsakaiShuryoTime(RString shinsakaiShuryoTime) {
        this.shinsakaiShuryoTime = shinsakaiShuryoTime;
    }

    /**
     * 委員出席のgetメソッドです。
     * 
     * @return 委員出席
     */
    public boolean getIsShusseki() {
        return isShusseki;
    }

    /**
     * 委員出席のsetメソッドです。
     * 
     * @param isShusseki 委員出席
     */
    public void setIsShusseki(boolean isShusseki) {
        this.isShusseki = isShusseki;
    }

    /**
     * 委員出席時間のgetメソッドです。
     * 
     * @return 委員出席時間
     */
    public RString getShussekiTime() {
        return shussekiTime;
    }

    /**
     * 委員出席時間のsetメソッドです。
     * 
     * @param shussekiTime 委員出席時間
     */
    public void setShussekiTime(RString shussekiTime) {
        this.shussekiTime = shussekiTime;
    }

    /**
     * 委員退席時間のgetメソッドです。
     * 
     * @return 委員退席時間
     */
    public RString getTaisekiTime() {
        return taisekiTime;
    }

    /**
     * 委員退席時間のsetメソッドです。
     * 
     * @param taisekiTime 委員退席時間
     */
    public void setTaisekiTime(RString taisekiTime) {
        this.taisekiTime = taisekiTime;
    }

    /**
     * 合議体長区分コードのgetメソッドです。
     * 
     * @return 合議体長区分コード
     */
    public Code getGogitaichoKubunCode() {
        return gogitaichoKubunCode;
    }

    /**
     * 合議体長区分コードのsetメソッドです。
     * 
     * @param gogitaichoKubunCode 合議体長区分コード
     */
    public void setGogitaichoKubunCode(Code gogitaichoKubunCode) {
        this.gogitaichoKubunCode = gogitaichoKubunCode;
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
    public RString getHoshushiharaiMemo() {
        return hoshushiharaiMemo;
    }

    /**
     * 介護認定審査報酬支払メモのsetメソッドです。
     * 
     * @param hoshushiharaiMemo 介護認定審査報酬支払メモ
     */
    public void setHoshushiharaiMemo(RString hoshushiharaiMemo) {
        this.hoshushiharaiMemo = hoshushiharaiMemo;
    }

    /**
     * 銀行振込出力済フラグのgetメソッドです。
     * 
     * @return 銀行振込出力済フラグ
     */
    public boolean getIsGinkoFurikomiShutsuryokuZumi() {
        return isGinkoFurikomiShutsuryokuZumi;
    }

    /**
     * 銀行振込出力済フラグのsetメソッドです。
     * 
     * @param isGinkoFurikomiShutsuryokuZumi 銀行振込出力済フラグ
     */
    public void setIsGinkoFurikomiShutsuryokuZumi(boolean isGinkoFurikomiShutsuryokuZumi) {
        this.isGinkoFurikomiShutsuryokuZumi = isGinkoFurikomiShutsuryokuZumi;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5113ShinsakaiIinHoshuJissekiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5113ShinsakaiIinHoshuJissekiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5113ShinsakaiIinHoshuJissekiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiKaisaiYMD, other.shinsakaiKaisaiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5113ShinsakaiIinHoshuJissekiJohoEntity entity) {
        this.gogitaiNo = entity.gogitaiNo;
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiIinShozokuKikanCode = entity.shinsakaiIinShozokuKikanCode;
        this.shinsakaiKaisaiNo = entity.shinsakaiKaisaiNo;
        this.shinsakaiKaisaiYMD = entity.shinsakaiKaisaiYMD;
        this.shinsakaiKaishiTime = entity.shinsakaiKaishiTime;
        this.shinsakaiShuryoTime = entity.shinsakaiShuryoTime;
        this.isShusseki = entity.isShusseki;
        this.shussekiTime = entity.shussekiTime;
        this.taisekiTime = entity.taisekiTime;
        this.gogitaichoKubunCode = entity.gogitaichoKubunCode;
        this.shinsakaiHoshuZeiritsu = entity.shinsakaiHoshuZeiritsu;
        this.shinsakaiHoshu = entity.shinsakaiHoshu;
        this.shinsakaiSonotaHoshu = entity.shinsakaiSonotaHoshu;
        this.shinsakaiKotsuhi = entity.shinsakaiKotsuhi;
        this.shinsakaiKojoZeigaku = entity.shinsakaiKojoZeigaku;
        this.shinsakaiHoshuGokei = entity.shinsakaiHoshuGokei;
        this.hoshuShiharaiYMD = entity.hoshuShiharaiYMD;
        this.hoshushiharaiMemo = entity.hoshushiharaiMemo;
        this.isGinkoFurikomiShutsuryokuZumi = entity.isGinkoFurikomiShutsuryokuZumi;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(gogitaiNo, shinsakaiIinCode, shinsakaiIinShozokuKikanCode, shinsakaiKaisaiNo, shinsakaiKaisaiYMD, shinsakaiKaishiTime, shinsakaiShuryoTime, isShusseki, shussekiTime, taisekiTime, gogitaichoKubunCode, shinsakaiHoshuZeiritsu, shinsakaiHoshu, shinsakaiSonotaHoshu, shinsakaiKotsuhi, shinsakaiKojoZeigaku, shinsakaiHoshuGokei, hoshuShiharaiYMD, hoshushiharaiMemo, isGinkoFurikomiShutsuryokuZumi);
    }

// </editor-fold>
}
