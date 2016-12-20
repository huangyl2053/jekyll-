package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * その他機関情報テーブルのエンティティクラスです。
 */
public class DbT5914SonotaKikanJohoEntity extends DbTableEntityBase<DbT5914SonotaKikanJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5914SonotaKikanJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private RString sonotaKikanCode;
    private RString kikanMeisho;
    private RString kikanMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private RString jushoKana;
    private TelNo telNo;
    private RString chosaItakuKubun;
    private int waritsukeTeiin;
    private ChikuCode waritsukeChiku;
    private RString kikanKubun;
    private boolean haishiFlag;
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
     * 証記載保険者番号のgetメソッドです。
     * 
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * その他機関コードのgetメソッドです。
     * 
     * @return その他機関コード
     */
    public RString getSonotaKikanCode() {
        return sonotaKikanCode;
    }

    /**
     * その他機関コードのsetメソッドです。
     * 
     * @param sonotaKikanCode その他機関コード
     */
    public void setSonotaKikanCode(@Nonnull RString sonotaKikanCode) {
        this.sonotaKikanCode = sonotaKikanCode;
    }

    /**
     * 機関名称のgetメソッドです。
     * 
     * @return 機関名称
     */
    @CheckForNull
    public RString getKikanMeisho() {
        return kikanMeisho;
    }

    /**
     * 機関名称のsetメソッドです。
     * 
     * @param kikanMeisho 機関名称
     */
    public void setKikanMeisho(RString kikanMeisho) {
        this.kikanMeisho = kikanMeisho;
    }

    /**
     * 機関名称カナのgetメソッドです。
     * 
     * @return 機関名称カナ
     */
    @CheckForNull
    public RString getKikanMeishoKana() {
        return kikanMeishoKana;
    }

    /**
     * 機関名称カナのsetメソッドです。
     * 
     * @param kikanMeishoKana 機関名称カナ
     */
    public void setKikanMeishoKana(RString kikanMeishoKana) {
        this.kikanMeishoKana = kikanMeishoKana;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     * 
     * @return 住所
     */
    @CheckForNull
    public RString getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param jusho 住所
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * 住所カナのgetメソッドです。
     * 
     * @return 住所カナ
     */
    @CheckForNull
    public RString getJushoKana() {
        return jushoKana;
    }

    /**
     * 住所カナのsetメソッドです。
     * 
     * @param jushoKana 住所カナ
     */
    public void setJushoKana(RString jushoKana) {
        this.jushoKana = jushoKana;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 調査委託区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     * 
     * @return 調査委託区分
     */
    @CheckForNull
    public RString getChosaItakuKubun() {
        return chosaItakuKubun;
    }

    /**
     * 調査委託区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     * 
     * @param chosaItakuKubun 調査委託区分
     */
    public void setChosaItakuKubun(RString chosaItakuKubun) {
        this.chosaItakuKubun = chosaItakuKubun;
    }

    /**
     * 割付定員のgetメソッドです。
     * 
     * @return 割付定員
     */
    @CheckForNull
    public int getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    /**
     * 割付定員のsetメソッドです。
     * 
     * @param waritsukeTeiin 割付定員
     */
    public void setWaritsukeTeiin(int waritsukeTeiin) {
        this.waritsukeTeiin = waritsukeTeiin;
    }

    /**
     * 割付地区のgetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @return 割付地区
     */
    @CheckForNull
    public ChikuCode getWaritsukeChiku() {
        return waritsukeChiku;
    }

    /**
     * 割付地区のsetメソッドです。
     * <br/>
     * <br/>Code（DBE：5002）
     * 
     * @param waritsukeChiku 割付地区
     */
    public void setWaritsukeChiku(ChikuCode waritsukeChiku) {
        this.waritsukeChiku = waritsukeChiku;
    }

    /**
     * 機関の区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：機関の区分）
     * 
     * @return 機関の区分
     */
    @CheckForNull
    public RString getKikanKubun() {
        return kikanKubun;
    }

    /**
     * 機関の区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：機関の区分）
     * 
     * @param kikanKubun 機関の区分
     */
    public void setKikanKubun(RString kikanKubun) {
        this.kikanKubun = kikanKubun;
    }

    /**
     * 廃止フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：廃止フラグ）旧「状況フラグ」
     * 
     * @return 廃止フラグ
     */
    public boolean getHaishiFlag() {
        return haishiFlag;
    }

    /**
     * 廃止フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：廃止フラグ）旧「状況フラグ」
     * 
     * @param haishiFlag 廃止フラグ
     */
    public void setHaishiFlag(@Nonnull boolean haishiFlag) {
        this.haishiFlag = haishiFlag;
    }

    /**
     * 金融機関コードのgetメソッドです。
     * 
     * @return 金融機関コード
     */
    @CheckForNull
    public KinyuKikanCode getKinyuKikanCode() {
        return kinyuKikanCode;
    }

    /**
     * 金融機関コードのsetメソッドです。
     * 
     * @param kinyuKikanCode 金融機関コード
     */
    public void setKinyuKikanCode(KinyuKikanCode kinyuKikanCode) {
        this.kinyuKikanCode = kinyuKikanCode;
    }

    /**
     * 支店コードのgetメソッドです。
     * 
     * @return 支店コード
     */
    @CheckForNull
    public KinyuKikanShitenCode getKinyuKikanShitenCode() {
        return kinyuKikanShitenCode;
    }

    /**
     * 支店コードのsetメソッドです。
     * 
     * @param kinyuKikanShitenCode 支店コード
     */
    public void setKinyuKikanShitenCode(KinyuKikanShitenCode kinyuKikanShitenCode) {
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
    }

    /**
     * 預金種別のgetメソッドです。
     * 
     * @return 預金種別
     */
    @CheckForNull
    public RString getYokinShubetsu() {
        return yokinShubetsu;
    }

    /**
     * 預金種別のsetメソッドです。
     * 
     * @param yokinShubetsu 預金種別
     */
    public void setYokinShubetsu(RString yokinShubetsu) {
        this.yokinShubetsu = yokinShubetsu;
    }

    /**
     * 口座番号のgetメソッドです。
     * 
     * @return 口座番号
     */
    @CheckForNull
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * 口座番号のsetメソッドです。
     * 
     * @param kozaNo 口座番号
     */
    public void setKozaNo(RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * 口座名義人カナのgetメソッドです。
     * 
     * @return 口座名義人カナ
     */
    @CheckForNull
    public AtenaKanaMeisho getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * 口座名義人カナのsetメソッドです。
     * 
     * @param kozaMeigininKana 口座名義人カナ
     */
    public void setKozaMeigininKana(AtenaKanaMeisho kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * 口座名義人のgetメソッドです。
     * 
     * @return 口座名義人
     */
    @CheckForNull
    public AtenaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * 口座名義人のsetメソッドです。
     * 
     * @param kozaMeiginin 口座名義人
     */
    public void setKozaMeiginin(AtenaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5914SonotaKikanJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5914SonotaKikanJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5914SonotaKikanJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.sonotaKikanCode, other.sonotaKikanCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5914SonotaKikanJohoEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.sonotaKikanCode = entity.sonotaKikanCode;
        this.kikanMeisho = entity.kikanMeisho;
        this.kikanMeishoKana = entity.kikanMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.jushoKana = entity.jushoKana;
        this.telNo = entity.telNo;
        this.chosaItakuKubun = entity.chosaItakuKubun;
        this.waritsukeTeiin = entity.waritsukeTeiin;
        this.waritsukeChiku = entity.waritsukeChiku;
        this.kikanKubun = entity.kikanKubun;
        this.haishiFlag = entity.haishiFlag;
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
        return super.toMd5(shoKisaiHokenshaNo, sonotaKikanCode, kikanMeisho, kikanMeishoKana, yubinNo, jusho, jushoKana, telNo, chosaItakuKubun, waritsukeTeiin, waritsukeChiku, kikanKubun, haishiFlag, kinyuKikanCode, kinyuKikanShitenCode, yokinShubetsu, kozaNo, kozaMeigininKana, kozaMeiginin);
    }

// </editor-fold>


}
