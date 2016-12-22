package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護認定審査会委員情報テーブルのエンティティクラスです。
 */
public class DbT5594ShinsakaiIinJohoEntity extends DbTableEntityBase<DbT5594ShinsakaiIinJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5594ShinsakaiIinJoho");

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
    private FlexibleDate shinsakaiIinKaishiYMD;
    private FlexibleDate shinsakaiIinShuryoYMD;
    private AtenaMeisho shinsakaiIinShimei;
    private AtenaKanaMeisho shinsakaiIinKanaShimei;
    private RString seibetsu;
    private Code shinsakaiIinShikakuCode;
    private RString shinsainYusoKubun;
    private ChikuCode tantoChikuCode;
    private YubinNo yubinNo;
    private AtenaJusho Jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private FlexibleDate seinengappiYMD;
    private RString biko;
    private boolean haishiFlag;
    private FlexibleDate haishiYMD;
    private KinyuKikanCode kinyuKikanCode;
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString yokinShubetsu;
    private RString kozaNo;
    private AtenaKanaMeisho kozaMeigininKana;
    private AtenaMeisho kozaMeiginin;

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
    public void setShinsakaiIinCode(@Nonnull RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * 介護認定審査会委員開始年月日のgetメソッドです。
     * 
     * @return 介護認定審査会委員開始年月日
     */
    public FlexibleDate getShinsakaiIinKaishiYMD() {
        return shinsakaiIinKaishiYMD;
    }

    /**
     * 介護認定審査会委員開始年月日のsetメソッドです。
     * 
     * @param shinsakaiIinKaishiYMD 介護認定審査会委員開始年月日
     */
    public void setShinsakaiIinKaishiYMD(@Nonnull FlexibleDate shinsakaiIinKaishiYMD) {
        this.shinsakaiIinKaishiYMD = shinsakaiIinKaishiYMD;
    }

    /**
     * 介護認定審査会委員終了年月日のgetメソッドです。
     * 
     * @return 介護認定審査会委員終了年月日
     */
    public FlexibleDate getShinsakaiIinShuryoYMD() {
        return shinsakaiIinShuryoYMD;
    }

    /**
     * 介護認定審査会委員終了年月日のsetメソッドです。
     * 
     * @param shinsakaiIinShuryoYMD 介護認定審査会委員終了年月日
     */
    public void setShinsakaiIinShuryoYMD(@Nonnull FlexibleDate shinsakaiIinShuryoYMD) {
        this.shinsakaiIinShuryoYMD = shinsakaiIinShuryoYMD;
    }

    /**
     * 介護認定審査会委員氏名のgetメソッドです。
     * 
     * @return 介護認定審査会委員氏名
     */
    public AtenaMeisho getShinsakaiIinShimei() {
        return shinsakaiIinShimei;
    }

    /**
     * 介護認定審査会委員氏名のsetメソッドです。
     * 
     * @param shinsakaiIinShimei 介護認定審査会委員氏名
     */
    public void setShinsakaiIinShimei(@Nonnull AtenaMeisho shinsakaiIinShimei) {
        this.shinsakaiIinShimei = shinsakaiIinShimei;
    }

    /**
     * 介護認定審査会委員氏名カナのgetメソッドです。
     * 
     * @return 介護認定審査会委員氏名カナ
     */
    public AtenaKanaMeisho getShinsakaiIinKanaShimei() {
        return shinsakaiIinKanaShimei;
    }

    /**
     * 介護認定審査会委員氏名カナのsetメソッドです。
     * 
     * @param shinsakaiIinKanaShimei 介護認定審査会委員氏名カナ
     */
    public void setShinsakaiIinKanaShimei(@Nonnull AtenaKanaMeisho shinsakaiIinKanaShimei) {
        this.shinsakaiIinKanaShimei = shinsakaiIinKanaShimei;
    }

    /**
     * 性別のgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     * 
     * @return 性別
     */
    public RString getSeibetsu() {
        return seibetsu;
    }

    /**
     * 性別のsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：性別コード）
     * 
     * @param seibetsu 性別
     */
    public void setSeibetsu(@Nonnull RString seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * 介護認定審査員資格コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE:資格コード）
     * 
     * @return 介護認定審査員資格コード
     */
    public Code getShinsakaiIinShikakuCode() {
        return shinsakaiIinShikakuCode;
    }

    /**
     * 介護認定審査員資格コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE:資格コード）
     * 
     * @param shinsakaiIinShikakuCode 介護認定審査員資格コード
     */
    public void setShinsakaiIinShikakuCode(@Nonnull Code shinsakaiIinShikakuCode) {
        this.shinsakaiIinShikakuCode = shinsakaiIinShikakuCode;
    }

    /**
     * 審査員郵送区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE:審査員郵送区分）
     * 
     * @return 審査員郵送区分
     */
    public RString getShinsainYusoKubun() {
        return shinsainYusoKubun;
    }

    /**
     * 審査員郵送区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE:審査員郵送区分）
     * 
     * @param shinsainYusoKubun 審査員郵送区分
     */
    public void setShinsainYusoKubun(@Nonnull RString shinsainYusoKubun) {
        this.shinsainYusoKubun = shinsainYusoKubun;
    }

    /**
     * 担当地区コードのgetメソッドです。
     * <br/>
     * <br/>Code（DBE:5001）
     * 
     * @return 担当地区コード
     */
    @CheckForNull
    public ChikuCode getTantoChikuCode() {
        return tantoChikuCode;
    }

    /**
     * 担当地区コードのsetメソッドです。
     * <br/>
     * <br/>Code（DBE:5001）
     * 
     * @param tantoChikuCode 担当地区コード
     */
    public void setTantoChikuCode(ChikuCode tantoChikuCode) {
        this.tantoChikuCode = tantoChikuCode;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(@Nonnull YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     * 
     * @return 住所
     */
    public AtenaJusho getJusho() {
        return Jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param Jusho 住所
     */
    public void setJusho(@Nonnull AtenaJusho Jusho) {
        this.Jusho = Jusho;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(@Nonnull TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * FAX番号のgetメソッドです。
     * 
     * @return FAX番号
     */
    @CheckForNull
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     * 
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 生年月日のgetメソッドです。
     * 
     * @return 生年月日
     */
    @CheckForNull
    public FlexibleDate getSeinengappiYMD() {
        return seinengappiYMD;
    }

    /**
     * 生年月日のsetメソッドです。
     * 
     * @param seinengappiYMD 生年月日
     */
    public void setSeinengappiYMD(FlexibleDate seinengappiYMD) {
        this.seinengappiYMD = seinengappiYMD;
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
     * 廃止フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：廃止フラグ）True：有効　False：無効
     * 
     * @return 廃止フラグ
     */
    public boolean getHaishiFlag() {
        return haishiFlag;
    }

    /**
     * 廃止フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：廃止フラグ）True：有効　False：無効
     * 
     * @param haishiFlag 廃止フラグ
     */
    public void setHaishiFlag(@Nonnull boolean haishiFlag) {
        this.haishiFlag = haishiFlag;
    }

    /**
     * 廃止年月日のgetメソッドです。
     * 
     * @return 廃止年月日
     */
    @CheckForNull
    public FlexibleDate getHaishiYMD() {
        return haishiYMD;
    }

    /**
     * 廃止年月日のsetメソッドです。
     * 
     * @param haishiYMD 廃止年月日
     */
    public void setHaishiYMD(FlexibleDate haishiYMD) {
        this.haishiYMD = haishiYMD;
    }

    /**
     * kinyuKikanCodeのgetメソッドです。
     * 
     * @return kinyuKikanCode
     */
    @CheckForNull
    public KinyuKikanCode getKinyuKikanCode() {
        return kinyuKikanCode;
    }

    /**
     * kinyuKikanCodeのsetメソッドです。
     * 
     * @param kinyuKikanCode kinyuKikanCode
     */
    public void setKinyuKikanCode(KinyuKikanCode kinyuKikanCode) {
        this.kinyuKikanCode = kinyuKikanCode;
    }

    /**
     * kinyuKikanShitenCodeのgetメソッドです。
     * 
     * @return kinyuKikanShitenCode
     */
    @CheckForNull
    public KinyuKikanShitenCode getKinyuKikanShitenCode() {
        return kinyuKikanShitenCode;
    }

    /**
     * kinyuKikanShitenCodeのsetメソッドです。
     * 
     * @param kinyuKikanShitenCode kinyuKikanShitenCode
     */
    public void setKinyuKikanShitenCode(KinyuKikanShitenCode kinyuKikanShitenCode) {
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
    }

    /**
     * yokinShubetsuのgetメソッドです。
     * 
     * @return yokinShubetsu
     */
    @CheckForNull
    public RString getYokinShubetsu() {
        return yokinShubetsu;
    }

    /**
     * yokinShubetsuのsetメソッドです。
     * 
     * @param yokinShubetsu yokinShubetsu
     */
    public void setYokinShubetsu(RString yokinShubetsu) {
        this.yokinShubetsu = yokinShubetsu;
    }

    /**
     * kozaNoのgetメソッドです。
     * 
     * @return kozaNo
     */
    @CheckForNull
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * kozaNoのsetメソッドです。
     * 
     * @param kozaNo kozaNo
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * kozaMeigininKanaのgetメソッドです。
     * 
     * @return kozaMeigininKana
     */
    @CheckForNull
    public AtenaKanaMeisho getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * kozaMeigininKanaのsetメソッドです。
     * 
     * @param kozaMeigininKana kozaMeigininKana
     */
    public void setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * kozaMeigininのgetメソッドです。
     * 
     * @return kozaMeiginin
     */
    @CheckForNull
    public AtenaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * kozaMeigininのsetメソッドです。
     * 
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(AtenaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5594ShinsakaiIinJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5594ShinsakaiIinJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5594ShinsakaiIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5594ShinsakaiIinJohoEntity entity) {
        this.shinsakaiIinCode = entity.shinsakaiIinCode;
        this.shinsakaiIinKaishiYMD = entity.shinsakaiIinKaishiYMD;
        this.shinsakaiIinShuryoYMD = entity.shinsakaiIinShuryoYMD;
        this.shinsakaiIinShimei = entity.shinsakaiIinShimei;
        this.shinsakaiIinKanaShimei = entity.shinsakaiIinKanaShimei;
        this.seibetsu = entity.seibetsu;
        this.shinsakaiIinShikakuCode = entity.shinsakaiIinShikakuCode;
        this.shinsainYusoKubun = entity.shinsainYusoKubun;
        this.tantoChikuCode = entity.tantoChikuCode;
        this.yubinNo = entity.yubinNo;
        this.Jusho = entity.Jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.seinengappiYMD = entity.seinengappiYMD;
        this.biko = entity.biko;
        this.haishiFlag = entity.haishiFlag;
        this.haishiYMD = entity.haishiYMD;
        this.kinyuKikanCode = entity.kinyuKikanCode;
        this.kinyuKikanShitenCode = entity.kinyuKikanShitenCode;
        this.yokinShubetsu = entity.yokinShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.kozaMeiginin = entity.kozaMeiginin;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinsakaiIinCode, shinsakaiIinKaishiYMD, shinsakaiIinShuryoYMD, shinsakaiIinShimei, shinsakaiIinKanaShimei, seibetsu, shinsakaiIinShikakuCode, shinsainYusoKubun, tantoChikuCode, yubinNo, Jusho, telNo, faxNo, seinengappiYMD, biko, haishiFlag, haishiYMD, kinyuKikanCode, kinyuKikanShitenCode, yokinShubetsu, kozaNo, kozaMeigininKana, kozaMeiginin);
    }

// </editor-fold>



}
