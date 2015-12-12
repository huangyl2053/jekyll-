package jp.co.ndensan.reams.db.dbc.entity.db.basic.kogakushinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額介護サービス費支給申請テーブルのエンティティクラスです。
 */
public class DbT3056KogakuShikyuShinseiEntity extends DbTableEntityBase<DbT3056KogakuShikyuShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3056KogakuShikyuShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private Decimal rirekiNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private RString shinseiRiyu;
    private RString shinseishaKubun;
    private AtenaMeisho shinseishaShimei;
    private AtenaKanaMeisho shinseishaShimeiKana;
    private RString shinseishaJusho;
    private TelNo shinseishaTelNo;
    private JigyoshaNo shinseiJigyoshaNo;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString heichoNaiyo;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString juryoininKeiyakuNo;

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
     * 被保険者番号のgetメソッドです。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * サービス提供年月のgetメソッドです。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getServiceTeikyoYM() {
        return serviceTeikyoYM;
    }

    /**
     * サービス提供年月のsetメソッドです。
     *
     * @param serviceTeikyoYM サービス提供年月
     */
    public void setServiceTeikyoYM(FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public Decimal getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(Decimal rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 受付年月日のgetメソッドです。
     *
     * @return 受付年月日
     */
    public FlexibleDate getUketsukeYMD() {
        return uketsukeYMD;
    }

    /**
     * 受付年月日のsetメソッドです。
     *
     * @param uketsukeYMD 受付年月日
     */
    public void setUketsukeYMD(FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     *
     * @param shinseiYMD 申請年月日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 申請理由のgetメソッドです。
     *
     * @return 申請理由
     */
    public RString getShinseiRiyu() {
        return shinseiRiyu;
    }

    /**
     * 申請理由のsetメソッドです。
     *
     * @param shinseiRiyu 申請理由
     */
    public void setShinseiRiyu(RString shinseiRiyu) {
        this.shinseiRiyu = shinseiRiyu;
    }

    /**
     * 申請者区分のgetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @return 申請者区分
     */
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * 申請者区分のsetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @param shinseishaKubun 申請者区分
     */
    public void setShinseishaKubun(RString shinseishaKubun) {
        this.shinseishaKubun = shinseishaKubun;
    }

    /**
     * 申請者氏名のgetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @return 申請者氏名
     */
    public AtenaMeisho getShinseishaShimei() {
        return shinseishaShimei;
    }

    /**
     * 申請者氏名のsetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @param shinseishaShimei 申請者氏名
     */
    public void setShinseishaShimei(AtenaMeisho shinseishaShimei) {
        this.shinseishaShimei = shinseishaShimei;
    }

    /**
     * 申請者氏名カナのgetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho getShinseishaShimeiKana() {
        return shinseishaShimeiKana;
    }

    /**
     * 申請者氏名カナのsetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @param shinseishaShimeiKana 申請者氏名カナ
     */
    public void setShinseishaShimeiKana(AtenaKanaMeisho shinseishaShimeiKana) {
        this.shinseishaShimeiKana = shinseishaShimeiKana;
    }

    /**
     * 申請者住所のgetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @return 申請者住所
     */
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * 申請者住所のsetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @param shinseishaJusho 申請者住所
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @return 申請者電話番号
     */
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合、設定不要
     *
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請事業者番号のgetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合のみ、設定
     *
     * @return 申請事業者番号
     */
    public JigyoshaNo getShinseiJigyoshaNo() {
        return shinseiJigyoshaNo;
    }

    /**
     * 申請事業者番号のsetメソッドです。
     * <br/>
     * <br/>申請者区分が”3”の場合のみ、設定
     *
     * @param shinseiJigyoshaNo 申請事業者番号
     */
    public void setShinseiJigyoshaNo(JigyoshaNo shinseiJigyoshaNo) {
        this.shinseiJigyoshaNo = shinseiJigyoshaNo;
    }

    /**
     * 支払方法区分コードのgetメソッドです。
     *
     * @return 支払方法区分コード
     */
    public RString getShiharaiHohoKubunCode() {
        return shiharaiHohoKubunCode;
    }

    /**
     * 支払方法区分コードのsetメソッドです。
     *
     * @param shiharaiHohoKubunCode 支払方法区分コード
     */
    public void setShiharaiHohoKubunCode(RString shiharaiHohoKubunCode) {
        this.shiharaiHohoKubunCode = shiharaiHohoKubunCode;
    }

    /**
     * 支払場所のgetメソッドです。
     *
     * @return 支払場所
     */
    public RString getShiharaiBasho() {
        return shiharaiBasho;
    }

    /**
     * 支払場所のsetメソッドです。
     *
     * @param shiharaiBasho 支払場所
     */
    public void setShiharaiBasho(RString shiharaiBasho) {
        this.shiharaiBasho = shiharaiBasho;
    }

    /**
     * 支払期間開始年月日のgetメソッドです。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate getShiharaiKaishiYMD() {
        return shiharaiKaishiYMD;
    }

    /**
     * 支払期間開始年月日のsetメソッドです。
     *
     * @param shiharaiKaishiYMD 支払期間開始年月日
     */
    public void setShiharaiKaishiYMD(FlexibleDate shiharaiKaishiYMD) {
        this.shiharaiKaishiYMD = shiharaiKaishiYMD;
    }

    /**
     * 支払期間終了年月日のgetメソッドです。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate getShiharaiShuryoYMD() {
        return shiharaiShuryoYMD;
    }

    /**
     * 支払期間終了年月日のsetメソッドです。
     *
     * @param shiharaiShuryoYMD 支払期間終了年月日
     */
    public void setShiharaiShuryoYMD(FlexibleDate shiharaiShuryoYMD) {
        this.shiharaiShuryoYMD = shiharaiShuryoYMD;
    }

    /**
     * 閉庁内容のgetメソッドです。
     *
     * @return 閉庁内容
     */
    public RString getHeichoNaiyo() {
        return heichoNaiyo;
    }

    /**
     * 閉庁内容のsetメソッドです。
     *
     * @param heichoNaiyo 閉庁内容
     */
    public void setHeichoNaiyo(RString heichoNaiyo) {
        this.heichoNaiyo = heichoNaiyo;
    }

    /**
     * 支払窓口開始時間のgetメソッドです。
     *
     * @return 支払窓口開始時間
     */
    public RString getShiharaiKaishiTime() {
        return shiharaiKaishiTime;
    }

    /**
     * 支払窓口開始時間のsetメソッドです。
     *
     * @param shiharaiKaishiTime 支払窓口開始時間
     */
    public void setShiharaiKaishiTime(RString shiharaiKaishiTime) {
        this.shiharaiKaishiTime = shiharaiKaishiTime;
    }

    /**
     * 支払窓口終了時間のgetメソッドです。
     *
     * @return 支払窓口終了時間
     */
    public RString getShiharaiShuryoTime() {
        return shiharaiShuryoTime;
    }

    /**
     * 支払窓口終了時間のsetメソッドです。
     *
     * @param shiharaiShuryoTime 支払窓口終了時間
     */
    public void setShiharaiShuryoTime(RString shiharaiShuryoTime) {
        this.shiharaiShuryoTime = shiharaiShuryoTime;
    }

    /**
     * 口座IDのgetメソッドです。
     * <br/>
     * <br/>口座テーブルとのリンクキー
     *
     * @return 口座ID
     */
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
     * <br/>
     * <br/>口座テーブルとのリンクキー
     *
     * @param kozaID 口座ID
     */
    public void setKozaID(long kozaID) {
        this.kozaID = kozaID;
    }

    /**
     * 受領委任契約番号のgetメソッドです。
     *
     * @return 受領委任契約番号
     */
    public RString getJuryoininKeiyakuNo() {
        return juryoininKeiyakuNo;
    }

    /**
     * 受領委任契約番号のsetメソッドです。
     *
     * @param juryoininKeiyakuNo 受領委任契約番号
     */
    public void setJuryoininKeiyakuNo(RString juryoininKeiyakuNo) {
        this.juryoininKeiyakuNo = juryoininKeiyakuNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3056KogakuShikyuShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3056KogakuShikyuShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3056KogakuShikyuShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
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
    public void shallowCopy(DbT3056KogakuShikyuShinseiEntity entity) {
        this.hihokenshaNo = entity.hihokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKubun = entity.shinseishaKubun;
        this.shinseishaShimei = entity.shinseishaShimei;
        this.shinseishaShimeiKana = entity.shinseishaShimeiKana;
        this.shinseishaJusho = entity.shinseishaJusho;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiJigyoshaNo = entity.shinseiJigyoshaNo;
        this.shiharaiHohoKubunCode = entity.shiharaiHohoKubunCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.heichoNaiyo = entity.heichoNaiyo;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.kozaID = entity.kozaID;
        this.juryoininKeiyakuNo = entity.juryoininKeiyakuNo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hihokenshaNo, serviceTeikyoYM, shoKisaiHokenshaNo, rirekiNo, uketsukeYMD, shinseiYMD, shinseiRiyu, shinseishaKubun, shinseishaShimei, shinseishaShimeiKana, shinseishaJusho, shinseishaTelNo, shinseiJigyoshaNo, shiharaiHohoKubunCode, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, heichoNaiyo, shiharaiKaishiTime, shiharaiShuryoTime, kozaID, juryoininKeiyakuNo);
    }

// </editor-fold>
}
