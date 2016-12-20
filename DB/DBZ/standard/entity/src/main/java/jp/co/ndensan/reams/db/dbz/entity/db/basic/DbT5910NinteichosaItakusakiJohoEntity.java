package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
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
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;

/**
 * 認定調査委託先情報テーブルのエンティティクラスです。
 */
public class DbT5910NinteichosaItakusakiJohoEntity extends DbTableEntityBase<DbT5910NinteichosaItakusakiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5910NinteichosaItakusakiJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode shichosonCode;
    @PrimaryKey
    private RString ninteichosaItakusakiCode;
    private JigyoshaNo jigyoshaNo;
    private RString jigyoshaMeisho;
    private RString jigyoshaMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString daihyoshaName;
    private RString daihyoshaNameKana;
    private RString chosaItakuKubun;
    private boolean tokuteiChosainDisplayFlag;
    private int waritsukeTeiin;
    private ChikuCode waritsukeChiku;
    private boolean autoWaritsukeFlag;
    private RString kikanKubun;
    private boolean jokyoFlag;
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
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(@Nonnull LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
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
    public void setNinteichosaItakusakiCode(@Nonnull RString ninteichosaItakusakiCode) {
        this.ninteichosaItakusakiCode = ninteichosaItakusakiCode;
    }

    /**
     * 事業者番号のgetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     * 
     * @return 事業者番号
     */
    @CheckForNull
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * <br/>
     * <br/>URを参照する場合のみ設定
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 事業者名称のgetメソッドです。
     * 
     * @return 事業者名称
     */
    @CheckForNull
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * 事業者名称のsetメソッドです。
     * 
     * @param jigyoshaMeisho 事業者名称
     */
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     * 
     * @return 事業者名称カナ
     */
    @CheckForNull
    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     * 
     * @param jigyoshaMeishoKana 事業者名称カナ
     */
    public void setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
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
     * 代表者名のgetメソッドです。
     * 
     * @return 代表者名
     */
    @CheckForNull
    public RString getDaihyoshaName() {
        return daihyoshaName;
    }

    /**
     * 代表者名のsetメソッドです。
     * 
     * @param daihyoshaName 代表者名
     */
    public void setDaihyoshaName(RString daihyoshaName) {
        this.daihyoshaName = daihyoshaName;
    }

    /**
     * 代表者名カナのgetメソッドです。
     * 
     * @return 代表者名カナ
     */
    @CheckForNull
    public RString getDaihyoshaNameKana() {
        return daihyoshaNameKana;
    }

    /**
     * 代表者名カナのsetメソッドです。
     * 
     * @param daihyoshaNameKana 代表者名カナ
     */
    public void setDaihyoshaNameKana(RString daihyoshaNameKana) {
        this.daihyoshaNameKana = daihyoshaNameKana;
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
     * 特定調査員表示フラグのgetメソッドです。
     * 
     * @return 特定調査員表示フラグ
     */
    @CheckForNull
    public boolean getTokuteiChosainDisplayFlag() {
        return tokuteiChosainDisplayFlag;
    }

    /**
     * 特定調査員表示フラグのsetメソッドです。
     * 
     * @param tokuteiChosainDisplayFlag 特定調査員表示フラグ
     */
    public void setTokuteiChosainDisplayFlag(boolean tokuteiChosainDisplayFlag) {
        this.tokuteiChosainDisplayFlag = tokuteiChosainDisplayFlag;
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
     * 自動割付フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自動割付フラグ）
     * 
     * @return 自動割付フラグ
     */
    @CheckForNull
    public boolean getAutoWaritsukeFlag() {
        return autoWaritsukeFlag;
    }

    /**
     * 自動割付フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：自動割付フラグ）
     * 
     * @param autoWaritsukeFlag 自動割付フラグ
     */
    public void setAutoWaritsukeFlag(boolean autoWaritsukeFlag) {
        this.autoWaritsukeFlag = autoWaritsukeFlag;
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
     * 状況フラグのgetメソッドです。
     * <br/>
     * <br/>True：有効　False：無効
     * 
     * @return 状況フラグ
     */
    public boolean getJokyoFlag() {
        return jokyoFlag;
    }

    /**
     * 状況フラグのsetメソッドです。
     * <br/>
     * <br/>True：有効　False：無効
     * 
     * @param jokyoFlag 状況フラグ
     */
    public void setJokyoFlag(@Nonnull boolean jokyoFlag) {
        this.jokyoFlag = jokyoFlag;
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
     * このエンティティの主キーが他の{@literal DbT5910NinteichosaItakusakiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5910NinteichosaItakusakiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5910NinteichosaItakusakiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.ninteichosaItakusakiCode, other.ninteichosaItakusakiCode)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5910NinteichosaItakusakiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.ninteichosaItakusakiCode = entity.ninteichosaItakusakiCode;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.jigyoshaMeisho = entity.jigyoshaMeisho;
        this.jigyoshaMeishoKana = entity.jigyoshaMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.daihyoshaName = entity.daihyoshaName;
        this.daihyoshaNameKana = entity.daihyoshaNameKana;
        this.chosaItakuKubun = entity.chosaItakuKubun;
        this.tokuteiChosainDisplayFlag = entity.tokuteiChosainDisplayFlag;
        this.waritsukeTeiin = entity.waritsukeTeiin;
        this.waritsukeChiku = entity.waritsukeChiku;
        this.autoWaritsukeFlag = entity.autoWaritsukeFlag;
        this.kikanKubun = entity.kikanKubun;
        this.jokyoFlag = entity.jokyoFlag;
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
        return super.toMd5(shichosonCode, ninteichosaItakusakiCode, jigyoshaNo, jigyoshaMeisho, jigyoshaMeishoKana, yubinNo, jusho, telNo, faxNo, daihyoshaName, daihyoshaNameKana, chosaItakuKubun, tokuteiChosainDisplayFlag, waritsukeTeiin, waritsukeChiku, autoWaritsukeFlag, kikanKubun, jokyoFlag, kinyuKikanCode, kinyuKikanShitenCode, yokinShubetsu, kozaNo, kozaMeigininKana, kozaMeiginin);
    }

// </editor-fold>


}
