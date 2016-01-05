package jp.co.ndensan.reams.db.dbc.entity.db.basic;

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
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 受領委任契約事業者テーブルのエンティティクラスです。
 */
public class DbT3077JuryoininKeiyakuJigyoshaEntity extends DbTableEntityBase<DbT3077JuryoininKeiyakuJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3077JuryoininKeiyakuJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString keiyakuJigyoshaNo;
    private FlexibleDate kaishiYMD;
    private FlexibleDate shuryoYMD;
    private RString keiyakuShurui;
    private AtenaMeisho keiyakuJigyoshaName;
    private AtenaKanaMeisho keiyakuJigyoshaKanaName;
    private YubinNo keiyakuJigyoshaYubinNo;
    private AtenaJusho keiyakuJigyoshaJusho;
    private AtenaMeisho keiyakuDaihyoshaName;
    private TelNo keiyakuJigyoshaTelNo;
    private TelNo keiyakuJigyoshaFaxNo;
    private YubinNo sofusakiYubinNo;
    private AtenaJusho sofusakiJusho;
    private RString sofusakiBusho;
    private AtenaMeisho sofusakiJigyoshaName;
    private AtenaKanaMeisho sofusakiJigyoshaKanaName;
    private KinyuKikanCode kinyuKikanCode;
    private KinyuKikanShitenCode shitenCode;
    private RString kozaShubetsu;
    private RString kozaNo;
    private AtenaMeisho kozaMeiginin;
    private AtenaKanaMeisho kozaMeigininKana;

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
     * 契約事業者番号のgetメソッドです。
     * <br/>
     * <br/>1からの連番付番
     * 
     * @return 契約事業者番号
     */
    public RString getKeiyakuJigyoshaNo() {
        return keiyakuJigyoshaNo;
    }

    /**
     * 契約事業者番号のsetメソッドです。
     * <br/>
     * <br/>1からの連番付番
     * 
     * @param keiyakuJigyoshaNo 契約事業者番号
     */
    public void setKeiyakuJigyoshaNo(@Nonnull RString keiyakuJigyoshaNo) {
        this.keiyakuJigyoshaNo = keiyakuJigyoshaNo;
    }

    /**
     * 開始年月日のgetメソッドです。
     * 
     * @return 開始年月日
     */
    public FlexibleDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     * 
     * @param kaishiYMD 開始年月日
     */
    public void setKaishiYMD(@Nonnull FlexibleDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * 終了年月日のgetメソッドです。
     * <br/>
     * <br/>未設定時は最大日付
     * 
     * @return 終了年月日
     */
    public FlexibleDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * 終了年月日のsetメソッドです。
     * <br/>
     * <br/>未設定時は最大日付
     * 
     * @param shuryoYMD 終了年月日
     */
    public void setShuryoYMD(@Nonnull FlexibleDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * 契約種類のgetメソッドです。
     * <br/>
     * <br/>01：住宅改修、02：福祉用具、03：住宅改修／福祉用具、11：償還払給付、21：高額給付費
     * 
     * @return 契約種類
     */
    public RString getKeiyakuShurui() {
        return keiyakuShurui;
    }

    /**
     * 契約種類のsetメソッドです。
     * <br/>
     * <br/>01：住宅改修、02：福祉用具、03：住宅改修／福祉用具、11：償還払給付、21：高額給付費
     * 
     * @param keiyakuShurui 契約種類
     */
    public void setKeiyakuShurui(@Nonnull RString keiyakuShurui) {
        this.keiyakuShurui = keiyakuShurui;
    }

    /**
     * 契約事業者名称のgetメソッドです。
     * 
     * @return 契約事業者名称
     */
    @CheckForNull
    public AtenaMeisho getKeiyakuJigyoshaName() {
        return keiyakuJigyoshaName;
    }

    /**
     * 契約事業者名称のsetメソッドです。
     * 
     * @param keiyakuJigyoshaName 契約事業者名称
     */
    public void setKeiyakuJigyoshaName(AtenaMeisho keiyakuJigyoshaName) {
        this.keiyakuJigyoshaName = keiyakuJigyoshaName;
    }

    /**
     * 契約事業者カナ名称のgetメソッドです。
     * 
     * @return 契約事業者カナ名称
     */
    @CheckForNull
    public AtenaKanaMeisho getKeiyakuJigyoshaKanaName() {
        return keiyakuJigyoshaKanaName;
    }

    /**
     * 契約事業者カナ名称のsetメソッドです。
     * 
     * @param keiyakuJigyoshaKanaName 契約事業者カナ名称
     */
    public void setKeiyakuJigyoshaKanaName(AtenaKanaMeisho keiyakuJigyoshaKanaName) {
        this.keiyakuJigyoshaKanaName = keiyakuJigyoshaKanaName;
    }

    /**
     * 契約事業者郵便番号のgetメソッドです。
     * 
     * @return 契約事業者郵便番号
     */
    @CheckForNull
    public YubinNo getKeiyakuJigyoshaYubinNo() {
        return keiyakuJigyoshaYubinNo;
    }

    /**
     * 契約事業者郵便番号のsetメソッドです。
     * 
     * @param keiyakuJigyoshaYubinNo 契約事業者郵便番号
     */
    public void setKeiyakuJigyoshaYubinNo(YubinNo keiyakuJigyoshaYubinNo) {
        this.keiyakuJigyoshaYubinNo = keiyakuJigyoshaYubinNo;
    }

    /**
     * 契約事業者住所のgetメソッドです。
     * 
     * @return 契約事業者住所
     */
    @CheckForNull
    public AtenaJusho getKeiyakuJigyoshaJusho() {
        return keiyakuJigyoshaJusho;
    }

    /**
     * 契約事業者住所のsetメソッドです。
     * 
     * @param keiyakuJigyoshaJusho 契約事業者住所
     */
    public void setKeiyakuJigyoshaJusho(AtenaJusho keiyakuJigyoshaJusho) {
        this.keiyakuJigyoshaJusho = keiyakuJigyoshaJusho;
    }

    /**
     * 契約代表者氏名のgetメソッドです。
     * 
     * @return 契約代表者氏名
     */
    @CheckForNull
    public AtenaMeisho getKeiyakuDaihyoshaName() {
        return keiyakuDaihyoshaName;
    }

    /**
     * 契約代表者氏名のsetメソッドです。
     * 
     * @param keiyakuDaihyoshaName 契約代表者氏名
     */
    public void setKeiyakuDaihyoshaName(AtenaMeisho keiyakuDaihyoshaName) {
        this.keiyakuDaihyoshaName = keiyakuDaihyoshaName;
    }

    /**
     * 契約事業者電話番号のgetメソッドです。
     * 
     * @return 契約事業者電話番号
     */
    @CheckForNull
    public TelNo getKeiyakuJigyoshaTelNo() {
        return keiyakuJigyoshaTelNo;
    }

    /**
     * 契約事業者電話番号のsetメソッドです。
     * 
     * @param keiyakuJigyoshaTelNo 契約事業者電話番号
     */
    public void setKeiyakuJigyoshaTelNo(TelNo keiyakuJigyoshaTelNo) {
        this.keiyakuJigyoshaTelNo = keiyakuJigyoshaTelNo;
    }

    /**
     * 契約事業者FAX番号のgetメソッドです。
     * 
     * @return 契約事業者FAX番号
     */
    @CheckForNull
    public TelNo getKeiyakuJigyoshaFaxNo() {
        return keiyakuJigyoshaFaxNo;
    }

    /**
     * 契約事業者FAX番号のsetメソッドです。
     * 
     * @param keiyakuJigyoshaFaxNo 契約事業者FAX番号
     */
    public void setKeiyakuJigyoshaFaxNo(TelNo keiyakuJigyoshaFaxNo) {
        this.keiyakuJigyoshaFaxNo = keiyakuJigyoshaFaxNo;
    }

    /**
     * 送付先郵便番号のgetメソッドです。
     * 
     * @return 送付先郵便番号
     */
    @CheckForNull
    public YubinNo getSofusakiYubinNo() {
        return sofusakiYubinNo;
    }

    /**
     * 送付先郵便番号のsetメソッドです。
     * 
     * @param sofusakiYubinNo 送付先郵便番号
     */
    public void setSofusakiYubinNo(YubinNo sofusakiYubinNo) {
        this.sofusakiYubinNo = sofusakiYubinNo;
    }

    /**
     * 送付先住所のgetメソッドです。
     * 
     * @return 送付先住所
     */
    @CheckForNull
    public AtenaJusho getSofusakiJusho() {
        return sofusakiJusho;
    }

    /**
     * 送付先住所のsetメソッドです。
     * 
     * @param sofusakiJusho 送付先住所
     */
    public void setSofusakiJusho(AtenaJusho sofusakiJusho) {
        this.sofusakiJusho = sofusakiJusho;
    }

    /**
     * 送付先部署のgetメソッドです。
     * 
     * @return 送付先部署
     */
    @CheckForNull
    public RString getSofusakiBusho() {
        return sofusakiBusho;
    }

    /**
     * 送付先部署のsetメソッドです。
     * 
     * @param sofusakiBusho 送付先部署
     */
    public void setSofusakiBusho(RString sofusakiBusho) {
        this.sofusakiBusho = sofusakiBusho;
    }

    /**
     * 送付先事業者名称のgetメソッドです。
     * 
     * @return 送付先事業者名称
     */
    @CheckForNull
    public AtenaMeisho getSofusakiJigyoshaName() {
        return sofusakiJigyoshaName;
    }

    /**
     * 送付先事業者名称のsetメソッドです。
     * 
     * @param sofusakiJigyoshaName 送付先事業者名称
     */
    public void setSofusakiJigyoshaName(AtenaMeisho sofusakiJigyoshaName) {
        this.sofusakiJigyoshaName = sofusakiJigyoshaName;
    }

    /**
     * 送付先事業者カナ名称のgetメソッドです。
     * 
     * @return 送付先事業者カナ名称
     */
    @CheckForNull
    public AtenaKanaMeisho getSofusakiJigyoshaKanaName() {
        return sofusakiJigyoshaKanaName;
    }

    /**
     * 送付先事業者カナ名称のsetメソッドです。
     * 
     * @param sofusakiJigyoshaKanaName 送付先事業者カナ名称
     */
    public void setSofusakiJigyoshaKanaName(AtenaKanaMeisho sofusakiJigyoshaKanaName) {
        this.sofusakiJigyoshaKanaName = sofusakiJigyoshaKanaName;
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
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * 支店コードのsetメソッドです。
     * 
     * @param shitenCode 支店コード
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * 口座種別のgetメソッドです。
     * 
     * @return 口座種別
     */
    @CheckForNull
    public RString getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * 口座種別のsetメソッドです。
     * 
     * @param kozaShubetsu 口座種別
     */
    public void setKozaShubetsu(RString kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
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
     * このエンティティの主キーが他の{@literal DbT3077JuryoininKeiyakuJigyoshaEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3077JuryoininKeiyakuJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3077JuryoininKeiyakuJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.keiyakuJigyoshaNo, other.keiyakuJigyoshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        this.keiyakuJigyoshaNo = entity.keiyakuJigyoshaNo;
        this.kaishiYMD = entity.kaishiYMD;
        this.shuryoYMD = entity.shuryoYMD;
        this.keiyakuShurui = entity.keiyakuShurui;
        this.keiyakuJigyoshaName = entity.keiyakuJigyoshaName;
        this.keiyakuJigyoshaKanaName = entity.keiyakuJigyoshaKanaName;
        this.keiyakuJigyoshaYubinNo = entity.keiyakuJigyoshaYubinNo;
        this.keiyakuJigyoshaJusho = entity.keiyakuJigyoshaJusho;
        this.keiyakuDaihyoshaName = entity.keiyakuDaihyoshaName;
        this.keiyakuJigyoshaTelNo = entity.keiyakuJigyoshaTelNo;
        this.keiyakuJigyoshaFaxNo = entity.keiyakuJigyoshaFaxNo;
        this.sofusakiYubinNo = entity.sofusakiYubinNo;
        this.sofusakiJusho = entity.sofusakiJusho;
        this.sofusakiBusho = entity.sofusakiBusho;
        this.sofusakiJigyoshaName = entity.sofusakiJigyoshaName;
        this.sofusakiJigyoshaKanaName = entity.sofusakiJigyoshaKanaName;
        this.kinyuKikanCode = entity.kinyuKikanCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(keiyakuJigyoshaNo, kaishiYMD, shuryoYMD, keiyakuShurui, keiyakuJigyoshaName, keiyakuJigyoshaKanaName, keiyakuJigyoshaYubinNo, keiyakuJigyoshaJusho, keiyakuDaihyoshaName, keiyakuJigyoshaTelNo, keiyakuJigyoshaFaxNo, sofusakiYubinNo, sofusakiJusho, sofusakiBusho, sofusakiJigyoshaName, sofusakiJigyoshaKanaName, kinyuKikanCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana);
    }

// </editor-fold>

}
