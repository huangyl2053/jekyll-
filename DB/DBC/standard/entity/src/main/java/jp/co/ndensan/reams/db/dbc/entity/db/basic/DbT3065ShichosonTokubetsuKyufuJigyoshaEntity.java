package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 市町村特別給付サービス事業者テーブルのエンティティクラスです。
 */
public class DbT3065ShichosonTokubetsuKyufuJigyoshaEntity extends DbTableEntityBase<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3065ShichosonTokubetsuKyufuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private JigyoshaNo jigyoshaNo;
    @PrimaryKey
    private ServiceCode serviceCode;
    @PrimaryKey
    private int rirekiNo;
    private RString idoKubun;
    private FlexibleDate idoYMD;
    private RString hojinShubetsu;
    private RString shinseishaNameKanji;
    private RString shinseishaNameKana;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaAddressKanji;
    private RString shinseishaAddressKana;
    private RString shinseishaTelNo;
    private RString shinseishaFaxNo;
    private RString jigyoshoDaihyoshaYakushoku;
    private RString jigyoshoDaihyoshaNameKanji;
    private RString jigyoshoDaihyoshaNameKana;
    private YubinNo jigyoshoDaihyoshaYubinNo;
    private RString jigyoshoDaihyoshaAddressKanji;
    private RString jigyoshoDaihyoshaAddressKana;
    private RString jigyoshoKanrishaNameKanji;
    private RString jigyoshoKanrishaNameKana;
    private YubinNo jigyoshoKanrishaYubinNo;
    private RString jigyoshoKanrishaAddressKanji;
    private RString jigyoshoKanrishaAddressKana;
    private RString serviceJigyoshoNameKanji;
    private RString serviceJigyoshoNameKana;
    private YubinNo serviceJigyoshoYubinNo;
    private RString serviceJigyoshoAddressKanji;
    private RString serviceJigyoshoAddressKana;
    private RString serviceJigyoshoTelNo;
    private RString serviceJigyoshoFaxNo;
    private FlexibleDate serviceJigyoshoJigyoKaisiYMD;
    private FlexibleDate serviceJigyoshoJigyoKyushiYMD;
    private FlexibleDate serviceJigyoshoJigyoHaishiYMD;
    private FlexibleDate serviceJigyoshoJigyoSaikaiYMD;
    private RString juryoIninKubu;
    private FlexibleDate torokuKaishiYMD;
    private FlexibleDate torokuShuryoYMD;
    private boolean seikatsuhogoShiteiFlag;
    private boolean logicalDeletedFlag;

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
     * 市町村特別給付用事業者番号のgetメソッドです。
     *
     * @return 市町村特別給付用事業者番号
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 市町村特別給付用事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 市町村特別給付用事業者番号
     */
    public void setJigyoshaNo(@Nonnull JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 市町村特別給付用サービスコードのgetメソッドです。
     *
     * @return 市町村特別給付用サービスコード
     */
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * 市町村特別給付用サービスコードのsetメソッドです。
     *
     * @param serviceCode 市町村特別給付用サービスコード
     */
    public void setServiceCode(@Nonnull ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public int getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 介護国保連ＩＦ異動区分のgetメソッドです。
     *
     * @return 介護国保連ＩＦ異動区分
     */
    public RString getIdoKubun() {
        return idoKubun;
    }

    /**
     * 介護国保連ＩＦ異動区分のsetメソッドです。
     *
     * @param idoKubun 介護国保連ＩＦ異動区分
     */
    public void setIdoKubun(@Nonnull RString idoKubun) {
        this.idoKubun = idoKubun;
    }

    /**
     * 介護国保連ＩＦ異動年月日のgetメソッドです。
     *
     * @return 介護国保連ＩＦ異動年月日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 介護国保連ＩＦ異動年月日のsetメソッドです。
     *
     * @param idoYMD 介護国保連ＩＦ異動年月日
     */
    public void setIdoYMD(@Nonnull FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 介護国保連ＩＦ法人種別のgetメソッドです。
     *
     * @return 介護国保連ＩＦ法人種別
     */
    @CheckForNull
    public RString getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * 介護国保連ＩＦ法人種別のsetメソッドです。
     *
     * @param hojinShubetsu 介護国保連ＩＦ法人種別
     */
    public void setHojinShubetsu(RString hojinShubetsu) {
        this.hojinShubetsu = hojinShubetsu;
    }

    /**
     * 申請者氏名（漢字）のgetメソッドです。
     *
     * @return 申請者氏名（漢字）
     */
    public RString getShinseishaNameKanji() {
        return shinseishaNameKanji;
    }

    /**
     * 申請者氏名（漢字）のsetメソッドです。
     *
     * @param shinseishaNameKanji 申請者氏名（漢字）
     */
    public void setShinseishaNameKanji(@Nonnull RString shinseishaNameKanji) {
        this.shinseishaNameKanji = shinseishaNameKanji;
    }

    /**
     * 申請者氏名（カナ）のgetメソッドです。
     *
     * @return 申請者氏名（カナ）
     */
    @CheckForNull
    public RString getShinseishaNameKana() {
        return shinseishaNameKana;
    }

    /**
     * 申請者氏名（カナ）のsetメソッドです。
     *
     * @param shinseishaNameKana 申請者氏名（カナ）
     */
    public void setShinseishaNameKana(RString shinseishaNameKana) {
        this.shinseishaNameKana = shinseishaNameKana;
    }

    /**
     * 申請者郵便番号のgetメソッドです。
     *
     * @return 申請者郵便番号
     */
    @CheckForNull
    public YubinNo getShinseishaYubinNo() {
        return shinseishaYubinNo;
    }

    /**
     * 申請者郵便番号のsetメソッドです。
     *
     * @param shinseishaYubinNo 申請者郵便番号
     */
    public void setShinseishaYubinNo(YubinNo shinseishaYubinNo) {
        this.shinseishaYubinNo = shinseishaYubinNo;
    }

    /**
     * 申請者住所のgetメソッドです。
     *
     * @return 申請者住所
     */
    @CheckForNull
    public RString getShinseishaAddressKanji() {
        return shinseishaAddressKanji;
    }

    /**
     * 申請者住所のsetメソッドです。
     *
     * @param shinseishaAddressKanji 申請者住所
     */
    public void setShinseishaAddressKanji(RString shinseishaAddressKanji) {
        this.shinseishaAddressKanji = shinseishaAddressKanji;
    }

    /**
     * 申請者住所（カナ）のgetメソッドです。
     *
     * @return 申請者住所（カナ）
     */
    @CheckForNull
    public RString getShinseishaAddressKana() {
        return shinseishaAddressKana;
    }

    /**
     * 申請者住所（カナ）のsetメソッドです。
     *
     * @param shinseishaAddressKana 申請者住所（カナ）
     */
    public void setShinseishaAddressKana(RString shinseishaAddressKana) {
        this.shinseishaAddressKana = shinseishaAddressKana;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     *
     * @return 申請者電話番号
     */
    @CheckForNull
    public RString getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     *
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(RString shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請者FAX番号のgetメソッドです。
     *
     * @return 申請者FAX番号
     */
    @CheckForNull
    public RString getShinseishaFaxNo() {
        return shinseishaFaxNo;
    }

    /**
     * 申請者FAX番号のsetメソッドです。
     *
     * @param shinseishaFaxNo 申請者FAX番号
     */
    public void setShinseishaFaxNo(RString shinseishaFaxNo) {
        this.shinseishaFaxNo = shinseishaFaxNo;
    }

    /**
     * 事業所代表者役職のgetメソッドです。
     *
     * @return 事業所代表者役職
     */
    @CheckForNull
    public RString getJigyoshoDaihyoshaYakushoku() {
        return jigyoshoDaihyoshaYakushoku;
    }

    /**
     * 事業所代表者役職のsetメソッドです。
     *
     * @param jigyoshoDaihyoshaYakushoku 事業所代表者役職
     */
    public void setJigyoshoDaihyoshaYakushoku(RString jigyoshoDaihyoshaYakushoku) {
        this.jigyoshoDaihyoshaYakushoku = jigyoshoDaihyoshaYakushoku;
    }

    /**
     * 事業所代表者氏名のgetメソッドです。
     *
     * @return 事業所代表者氏名
     */
    public RString getJigyoshoDaihyoshaNameKanji() {
        return jigyoshoDaihyoshaNameKanji;
    }

    /**
     * 事業所代表者氏名のsetメソッドです。
     *
     * @param jigyoshoDaihyoshaNameKanji 事業所代表者氏名
     */
    public void setJigyoshoDaihyoshaNameKanji(@Nonnull RString jigyoshoDaihyoshaNameKanji) {
        this.jigyoshoDaihyoshaNameKanji = jigyoshoDaihyoshaNameKanji;
    }

    /**
     * 事業所代表者氏名カナのgetメソッドです。
     *
     * @return 事業所代表者氏名カナ
     */
    @CheckForNull
    public RString getJigyoshoDaihyoshaNameKana() {
        return jigyoshoDaihyoshaNameKana;
    }

    /**
     * 事業所代表者氏名カナのsetメソッドです。
     *
     * @param jigyoshoDaihyoshaNameKana 事業所代表者氏名カナ
     */
    public void setJigyoshoDaihyoshaNameKana(RString jigyoshoDaihyoshaNameKana) {
        this.jigyoshoDaihyoshaNameKana = jigyoshoDaihyoshaNameKana;
    }

    /**
     * 事業所代表者郵便番号のgetメソッドです。
     *
     * @return 事業所代表者郵便番号
     */
    @CheckForNull
    public YubinNo getJigyoshoDaihyoshaYubinNo() {
        return jigyoshoDaihyoshaYubinNo;
    }

    /**
     * 事業所代表者郵便番号のsetメソッドです。
     *
     * @param jigyoshoDaihyoshaYubinNo 事業所代表者郵便番号
     */
    public void setJigyoshoDaihyoshaYubinNo(YubinNo jigyoshoDaihyoshaYubinNo) {
        this.jigyoshoDaihyoshaYubinNo = jigyoshoDaihyoshaYubinNo;
    }

    /**
     * 事業所代表者住所のgetメソッドです。
     *
     * @return 事業所代表者住所
     */
    @CheckForNull
    public RString getJigyoshoDaihyoshaAddressKanji() {
        return jigyoshoDaihyoshaAddressKanji;
    }

    /**
     * 事業所代表者住所のsetメソッドです。
     *
     * @param jigyoshoDaihyoshaAddressKanji 事業所代表者住所
     */
    public void setJigyoshoDaihyoshaAddressKanji(RString jigyoshoDaihyoshaAddressKanji) {
        this.jigyoshoDaihyoshaAddressKanji = jigyoshoDaihyoshaAddressKanji;
    }

    /**
     * 事業所代表者住所カナのgetメソッドです。
     *
     * @return 事業所代表者住所カナ
     */
    @CheckForNull
    public RString getJigyoshoDaihyoshaAddressKana() {
        return jigyoshoDaihyoshaAddressKana;
    }

    /**
     * 事業所代表者住所カナのsetメソッドです。
     *
     * @param jigyoshoDaihyoshaAddressKana 事業所代表者住所カナ
     */
    public void setJigyoshoDaihyoshaAddressKana(RString jigyoshoDaihyoshaAddressKana) {
        this.jigyoshoDaihyoshaAddressKana = jigyoshoDaihyoshaAddressKana;
    }

    /**
     * 事業所管理者氏名のgetメソッドです。
     *
     * @return 事業所管理者氏名
     */
    public RString getJigyoshoKanrishaNameKanji() {
        return jigyoshoKanrishaNameKanji;
    }

    /**
     * 事業所管理者氏名のsetメソッドです。
     *
     * @param jigyoshoKanrishaNameKanji 事業所管理者氏名
     */
    public void setJigyoshoKanrishaNameKanji(@Nonnull RString jigyoshoKanrishaNameKanji) {
        this.jigyoshoKanrishaNameKanji = jigyoshoKanrishaNameKanji;
    }

    /**
     * 事業所管理者氏名カナのgetメソッドです。
     *
     * @return 事業所管理者氏名カナ
     */
    @CheckForNull
    public RString getJigyoshoKanrishaNameKana() {
        return jigyoshoKanrishaNameKana;
    }

    /**
     * 事業所管理者氏名カナのsetメソッドです。
     *
     * @param jigyoshoKanrishaNameKana 事業所管理者氏名カナ
     */
    public void setJigyoshoKanrishaNameKana(RString jigyoshoKanrishaNameKana) {
        this.jigyoshoKanrishaNameKana = jigyoshoKanrishaNameKana;
    }

    /**
     * 事業所管理者郵便番号のgetメソッドです。
     *
     * @return 事業所管理者郵便番号
     */
    @CheckForNull
    public YubinNo getJigyoshoKanrishaYubinNo() {
        return jigyoshoKanrishaYubinNo;
    }

    /**
     * 事業所管理者郵便番号のsetメソッドです。
     *
     * @param jigyoshoKanrishaYubinNo 事業所管理者郵便番号
     */
    public void setJigyoshoKanrishaYubinNo(YubinNo jigyoshoKanrishaYubinNo) {
        this.jigyoshoKanrishaYubinNo = jigyoshoKanrishaYubinNo;
    }

    /**
     * 事業所管理者住所のgetメソッドです。
     *
     * @return 事業所管理者住所
     */
    @CheckForNull
    public RString getJigyoshoKanrishaAddressKanji() {
        return jigyoshoKanrishaAddressKanji;
    }

    /**
     * 事業所管理者住所のsetメソッドです。
     *
     * @param jigyoshoKanrishaAddressKanji 事業所管理者住所
     */
    public void setJigyoshoKanrishaAddressKanji(RString jigyoshoKanrishaAddressKanji) {
        this.jigyoshoKanrishaAddressKanji = jigyoshoKanrishaAddressKanji;
    }

    /**
     * 事業所管理者住所カナのgetメソッドです。
     *
     * @return 事業所管理者住所カナ
     */
    @CheckForNull
    public RString getJigyoshoKanrishaAddressKana() {
        return jigyoshoKanrishaAddressKana;
    }

    /**
     * 事業所管理者住所カナのsetメソッドです。
     *
     * @param jigyoshoKanrishaAddressKana 事業所管理者住所カナ
     */
    public void setJigyoshoKanrishaAddressKana(RString jigyoshoKanrishaAddressKana) {
        this.jigyoshoKanrishaAddressKana = jigyoshoKanrishaAddressKana;
    }

    /**
     * サービス事業所名のgetメソッドです。
     *
     * @return サービス事業所名
     */
    public RString getServiceJigyoshoNameKanji() {
        return serviceJigyoshoNameKanji;
    }

    /**
     * サービス事業所名のsetメソッドです。
     *
     * @param serviceJigyoshoNameKanji サービス事業所名
     */
    public void setServiceJigyoshoNameKanji(@Nonnull RString serviceJigyoshoNameKanji) {
        this.serviceJigyoshoNameKanji = serviceJigyoshoNameKanji;
    }

    /**
     * サービス事業所名カナのgetメソッドです。
     *
     * @return サービス事業所名カナ
     */
    @CheckForNull
    public RString getServiceJigyoshoNameKana() {
        return serviceJigyoshoNameKana;
    }

    /**
     * サービス事業所名カナのsetメソッドです。
     *
     * @param serviceJigyoshoNameKana サービス事業所名カナ
     */
    public void setServiceJigyoshoNameKana(RString serviceJigyoshoNameKana) {
        this.serviceJigyoshoNameKana = serviceJigyoshoNameKana;
    }

    /**
     * サービス事業所郵便番号のgetメソッドです。
     *
     * @return サービス事業所郵便番号
     */
    @CheckForNull
    public YubinNo getServiceJigyoshoYubinNo() {
        return serviceJigyoshoYubinNo;
    }

    /**
     * サービス事業所郵便番号のsetメソッドです。
     *
     * @param serviceJigyoshoYubinNo サービス事業所郵便番号
     */
    public void setServiceJigyoshoYubinNo(YubinNo serviceJigyoshoYubinNo) {
        this.serviceJigyoshoYubinNo = serviceJigyoshoYubinNo;
    }

    /**
     * サービス事業所住所のgetメソッドです。
     *
     * @return サービス事業所住所
     */
    @CheckForNull
    public RString getServiceJigyoshoAddressKanji() {
        return serviceJigyoshoAddressKanji;
    }

    /**
     * サービス事業所住所のsetメソッドです。
     *
     * @param serviceJigyoshoAddressKanji サービス事業所住所
     */
    public void setServiceJigyoshoAddressKanji(RString serviceJigyoshoAddressKanji) {
        this.serviceJigyoshoAddressKanji = serviceJigyoshoAddressKanji;
    }

    /**
     * サービス事業所住所カナのgetメソッドです。
     *
     * @return サービス事業所住所カナ
     */
    @CheckForNull
    public RString getServiceJigyoshoAddressKana() {
        return serviceJigyoshoAddressKana;
    }

    /**
     * サービス事業所住所カナのsetメソッドです。
     *
     * @param serviceJigyoshoAddressKana サービス事業所住所カナ
     */
    public void setServiceJigyoshoAddressKana(RString serviceJigyoshoAddressKana) {
        this.serviceJigyoshoAddressKana = serviceJigyoshoAddressKana;
    }

    /**
     * サービス事業所電話番号のgetメソッドです。
     *
     * @return サービス事業所電話番号
     */
    @CheckForNull
    public RString getServiceJigyoshoTelNo() {
        return serviceJigyoshoTelNo;
    }

    /**
     * サービス事業所電話番号のsetメソッドです。
     *
     * @param serviceJigyoshoTelNo サービス事業所電話番号
     */
    public void setServiceJigyoshoTelNo(RString serviceJigyoshoTelNo) {
        this.serviceJigyoshoTelNo = serviceJigyoshoTelNo;
    }

    /**
     * サービス事業所FAX番号のgetメソッドです。
     *
     * @return サービス事業所FAX番号
     */
    @CheckForNull
    public RString getServiceJigyoshoFaxNo() {
        return serviceJigyoshoFaxNo;
    }

    /**
     * サービス事業所FAX番号のsetメソッドです。
     *
     * @param serviceJigyoshoFaxNo サービス事業所FAX番号
     */
    public void setServiceJigyoshoFaxNo(RString serviceJigyoshoFaxNo) {
        this.serviceJigyoshoFaxNo = serviceJigyoshoFaxNo;
    }

    /**
     * サービス事業所事業開始年月日のgetメソッドです。
     *
     * @return サービス事業所事業開始年月日
     */
    public FlexibleDate getServiceJigyoshoJigyoKaisiYMD() {
        return serviceJigyoshoJigyoKaisiYMD;
    }

    /**
     * サービス事業所事業開始年月日のsetメソッドです。
     *
     * @param serviceJigyoshoJigyoKaisiYMD サービス事業所事業開始年月日
     */
    public void setServiceJigyoshoJigyoKaisiYMD(@Nonnull FlexibleDate serviceJigyoshoJigyoKaisiYMD) {
        this.serviceJigyoshoJigyoKaisiYMD = serviceJigyoshoJigyoKaisiYMD;
    }

    /**
     * サービス事業所事業休止年月日のgetメソッドです。
     *
     * @return サービス事業所事業休止年月日
     */
    @CheckForNull
    public FlexibleDate getServiceJigyoshoJigyoKyushiYMD() {
        return serviceJigyoshoJigyoKyushiYMD;
    }

    /**
     * サービス事業所事業休止年月日のsetメソッドです。
     *
     * @param serviceJigyoshoJigyoKyushiYMD サービス事業所事業休止年月日
     */
    public void setServiceJigyoshoJigyoKyushiYMD(FlexibleDate serviceJigyoshoJigyoKyushiYMD) {
        this.serviceJigyoshoJigyoKyushiYMD = serviceJigyoshoJigyoKyushiYMD;
    }

    /**
     * サービス事業所事業廃止年月日のgetメソッドです。
     *
     * @return サービス事業所事業廃止年月日
     */
    @CheckForNull
    public FlexibleDate getServiceJigyoshoJigyoHaishiYMD() {
        return serviceJigyoshoJigyoHaishiYMD;
    }

    /**
     * サービス事業所事業廃止年月日のsetメソッドです。
     *
     * @param serviceJigyoshoJigyoHaishiYMD サービス事業所事業廃止年月日
     */
    public void setServiceJigyoshoJigyoHaishiYMD(FlexibleDate serviceJigyoshoJigyoHaishiYMD) {
        this.serviceJigyoshoJigyoHaishiYMD = serviceJigyoshoJigyoHaishiYMD;
    }

    /**
     * サービス事業所事業再開年月日のgetメソッドです。
     *
     * @return サービス事業所事業再開年月日
     */
    @CheckForNull
    public FlexibleDate getServiceJigyoshoJigyoSaikaiYMD() {
        return serviceJigyoshoJigyoSaikaiYMD;
    }

    /**
     * サービス事業所事業再開年月日のsetメソッドです。
     *
     * @param serviceJigyoshoJigyoSaikaiYMD サービス事業所事業再開年月日
     */
    public void setServiceJigyoshoJigyoSaikaiYMD(FlexibleDate serviceJigyoshoJigyoSaikaiYMD) {
        this.serviceJigyoshoJigyoSaikaiYMD = serviceJigyoshoJigyoSaikaiYMD;
    }

    /**
     * 受領委任区分のgetメソッドです。
     *
     * @return 受領委任区分
     */
    public RString getJuryoIninKubu() {
        return juryoIninKubu;
    }

    /**
     * 受領委任区分のsetメソッドです。
     *
     * @param juryoIninKubu 受領委任区分
     */
    public void setJuryoIninKubu(@Nonnull RString juryoIninKubu) {
        this.juryoIninKubu = juryoIninKubu;
    }

    /**
     * 市町村特別給付登録開始年月日のgetメソッドです。
     *
     * @return 市町村特別給付登録開始年月日
     */
    public FlexibleDate getTorokuKaishiYMD() {
        return torokuKaishiYMD;
    }

    /**
     * 市町村特別給付登録開始年月日のsetメソッドです。
     *
     * @param torokuKaishiYMD 市町村特別給付登録開始年月日
     */
    public void setTorokuKaishiYMD(@Nonnull FlexibleDate torokuKaishiYMD) {
        this.torokuKaishiYMD = torokuKaishiYMD;
    }

    /**
     * 市町村特別給付登録終了年月日のgetメソッドです。
     *
     * @return 市町村特別給付登録終了年月日
     */
    @CheckForNull
    public FlexibleDate getTorokuShuryoYMD() {
        return torokuShuryoYMD;
    }

    /**
     * 市町村特別給付登録終了年月日のsetメソッドです。
     *
     * @param torokuShuryoYMD 市町村特別給付登録終了年月日
     */
    public void setTorokuShuryoYMD(FlexibleDate torokuShuryoYMD) {
        this.torokuShuryoYMD = torokuShuryoYMD;
    }

    /**
     * 生活保護法による指定の有のgetメソッドです。
     *
     * @return 生活保護法による指定の有
     */
    public boolean getSeikatsuhogoShiteiFlag() {
        return seikatsuhogoShiteiFlag;
    }

    /**
     * 生活保護法による指定の有のsetメソッドです。
     *
     * @param seikatsuhogoShiteiFlag 生活保護法による指定の有
     */
    public void setSeikatsuhogoShiteiFlag(@Nonnull boolean seikatsuhogoShiteiFlag) {
        this.seikatsuhogoShiteiFlag = seikatsuhogoShiteiFlag;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     *
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     *
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3065ShichosonTokubetsuKyufuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceCode, other.serviceCode)) {
            return false;
        }
        if (this.rirekiNo != other.rirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.serviceCode = entity.serviceCode;
        this.rirekiNo = entity.rirekiNo;
        this.idoKubun = entity.idoKubun;
        this.idoYMD = entity.idoYMD;
        this.hojinShubetsu = entity.hojinShubetsu;
        this.shinseishaNameKanji = entity.shinseishaNameKanji;
        this.shinseishaNameKana = entity.shinseishaNameKana;
        this.shinseishaYubinNo = entity.shinseishaYubinNo;
        this.shinseishaAddressKanji = entity.shinseishaAddressKanji;
        this.shinseishaAddressKana = entity.shinseishaAddressKana;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseishaFaxNo = entity.shinseishaFaxNo;
        this.jigyoshoDaihyoshaYakushoku = entity.jigyoshoDaihyoshaYakushoku;
        this.jigyoshoDaihyoshaNameKanji = entity.jigyoshoDaihyoshaNameKanji;
        this.jigyoshoDaihyoshaNameKana = entity.jigyoshoDaihyoshaNameKana;
        this.jigyoshoDaihyoshaYubinNo = entity.jigyoshoDaihyoshaYubinNo;
        this.jigyoshoDaihyoshaAddressKanji = entity.jigyoshoDaihyoshaAddressKanji;
        this.jigyoshoDaihyoshaAddressKana = entity.jigyoshoDaihyoshaAddressKana;
        this.jigyoshoKanrishaNameKanji = entity.jigyoshoKanrishaNameKanji;
        this.jigyoshoKanrishaNameKana = entity.jigyoshoKanrishaNameKana;
        this.jigyoshoKanrishaYubinNo = entity.jigyoshoKanrishaYubinNo;
        this.jigyoshoKanrishaAddressKanji = entity.jigyoshoKanrishaAddressKanji;
        this.jigyoshoKanrishaAddressKana = entity.jigyoshoKanrishaAddressKana;
        this.serviceJigyoshoNameKanji = entity.serviceJigyoshoNameKanji;
        this.serviceJigyoshoNameKana = entity.serviceJigyoshoNameKana;
        this.serviceJigyoshoYubinNo = entity.serviceJigyoshoYubinNo;
        this.serviceJigyoshoAddressKanji = entity.serviceJigyoshoAddressKanji;
        this.serviceJigyoshoAddressKana = entity.serviceJigyoshoAddressKana;
        this.serviceJigyoshoTelNo = entity.serviceJigyoshoTelNo;
        this.serviceJigyoshoFaxNo = entity.serviceJigyoshoFaxNo;
        this.serviceJigyoshoJigyoKaisiYMD = entity.serviceJigyoshoJigyoKaisiYMD;
        this.serviceJigyoshoJigyoKyushiYMD = entity.serviceJigyoshoJigyoKyushiYMD;
        this.serviceJigyoshoJigyoHaishiYMD = entity.serviceJigyoshoJigyoHaishiYMD;
        this.serviceJigyoshoJigyoSaikaiYMD = entity.serviceJigyoshoJigyoSaikaiYMD;
        this.juryoIninKubu = entity.juryoIninKubu;
        this.torokuKaishiYMD = entity.torokuKaishiYMD;
        this.torokuShuryoYMD = entity.torokuShuryoYMD;
        this.seikatsuhogoShiteiFlag = entity.seikatsuhogoShiteiFlag;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, serviceCode, rirekiNo, idoKubun, idoYMD, hojinShubetsu, shinseishaNameKanji, shinseishaNameKana, shinseishaYubinNo, shinseishaAddressKanji, shinseishaAddressKana, shinseishaTelNo, shinseishaFaxNo, jigyoshoDaihyoshaYakushoku, jigyoshoDaihyoshaNameKanji, jigyoshoDaihyoshaNameKana, jigyoshoDaihyoshaYubinNo, jigyoshoDaihyoshaAddressKanji, jigyoshoDaihyoshaAddressKana, jigyoshoKanrishaNameKanji, jigyoshoKanrishaNameKana, jigyoshoKanrishaYubinNo, jigyoshoKanrishaAddressKanji, jigyoshoKanrishaAddressKana, serviceJigyoshoNameKanji, serviceJigyoshoNameKana, serviceJigyoshoYubinNo, serviceJigyoshoAddressKanji, serviceJigyoshoAddressKana, serviceJigyoshoTelNo, serviceJigyoshoFaxNo, serviceJigyoshoJigyoKaisiYMD, serviceJigyoshoJigyoKyushiYMD, serviceJigyoshoJigyoHaishiYMD, serviceJigyoshoJigyoSaikaiYMD, juryoIninKubu, torokuKaishiYMD, torokuShuryoYMD, seikatsuhogoShiteiFlag, logicalDeletedFlag);
    }

// </editor-fold>
}
