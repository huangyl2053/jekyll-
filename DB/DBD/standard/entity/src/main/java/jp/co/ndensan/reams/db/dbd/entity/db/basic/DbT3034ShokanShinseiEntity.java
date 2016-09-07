package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 償還払支給申請テーブルのエンティティクラスです。
 */
public class DbT3034ShokanShinseiEntity extends DbTableEntityBase<DbT3034ShokanShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3034ShokanShinsei");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HihokenshaNo hiHokenshaNo;
    @PrimaryKey
    private FlexibleYearMonth serviceTeikyoYM;
    @PrimaryKey
    private RString seiriNo;
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    private FlexibleDate uketsukeYMD;
    private FlexibleDate shinseiYMD;
    private RString shinseiRiyu;
    private RString shinseishaKubun;
    private RString shinseishaNameKanji;
    private RString shinseishaNameKana;
    private YubinNo shinseishaYubinNo;
    private RString shinseishaAddress;
    private TelNo shinseishaTelNo;
    private JigyoshaNo shinseiJigyoshaNo;
    private FlexibleDate riyushoSakuseiYMD;
    private RString riyushoSakuseishaName;
    private RString riyushoSakuseishaKanaName;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    private Decimal shiharaiKingakuTotal;
    private Decimal hokenTaishoHiyogaku;
    private int hokenKyufugaku;
    private int riyoshaFutangaku;
    private RString shikyuShinseiShinsaKubun;
    private RString shinsaHohoKubun;
    private RString sofuKubun;
    private FlexibleYearMonth sofuYM;
    private boolean kokuhorenSaisofuFlag;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString juryoininKeiyakuNo;
    private RString jutakuShoyusha;
    private RString hihokenshaKankei;
    private boolean yokaigo3DankaiHenko;
    private boolean jutakuJushoHenko;
    private FlexibleDate shinsaYMD;
    private RString shinsaKekka;
    private FlexibleYearMonth jizenServiceTeikyoYM;
    private RString jizenSeiriNo;
    private RString kaishuShinseiKubun;
    private RString kaishuShinseiTorikeshijiyuCode;
    private FlexibleDate ryoshuYMD;

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
    public HihokenshaNo getHiHokenshaNo() {
        return hiHokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     *
     * @param hiHokenshaNo 被保険者番号
     */
    public void setHiHokenshaNo(@Nonnull HihokenshaNo hiHokenshaNo) {
        this.hiHokenshaNo = hiHokenshaNo;
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
    public void setServiceTeikyoYM(@Nonnull FlexibleYearMonth serviceTeikyoYM) {
        this.serviceTeikyoYM = serviceTeikyoYM;
    }

    /**
     * 整理番号のgetメソッドです。
     *
     * @return 整理番号
     */
    public RString getSeiriNo() {
        return seiriNo;
    }

    /**
     * 整理番号のsetメソッドです。
     *
     * @param seiriNo 整理番号
     */
    public void setSeiriNo(@Nonnull RString seiriNo) {
        this.seiriNo = seiriNo;
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
    public void setUketsukeYMD(@Nonnull FlexibleDate uketsukeYMD) {
        this.uketsukeYMD = uketsukeYMD;
    }

    /**
     * 申請年月日のgetメソッドです。
     *
     * @return 申請年月日
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     *
     * @return 申請者氏名
     */
    @CheckForNull
    public RString getShinseishaNameKanji() {
        return shinseishaNameKanji;
    }

    /**
     * 申請者氏名のsetメソッドです。
     *
     * @param shinseishaNameKanji 申請者氏名
     */
    public void setShinseishaNameKanji(RString shinseishaNameKanji) {
        this.shinseishaNameKanji = shinseishaNameKanji;
    }

    /**
     * 申請者氏名カナのgetメソッドです。
     *
     * @return 申請者氏名カナ
     */
    @CheckForNull
    public RString getShinseishaNameKana() {
        return shinseishaNameKana;
    }

    /**
     * 申請者氏名カナのsetメソッドです。
     *
     * @param shinseishaNameKana 申請者氏名カナ
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
    public RString getShinseishaAddress() {
        return shinseishaAddress;
    }

    /**
     * 申請者住所のsetメソッドです。
     *
     * @param shinseishaAddress 申請者住所
     */
    public void setShinseishaAddress(RString shinseishaAddress) {
        this.shinseishaAddress = shinseishaAddress;
    }

    /**
     * 申請者電話番号のgetメソッドです。
     *
     * @return 申請者電話番号
     */
    @CheckForNull
    public TelNo getShinseishaTelNo() {
        return shinseishaTelNo;
    }

    /**
     * 申請者電話番号のsetメソッドです。
     *
     * @param shinseishaTelNo 申請者電話番号
     */
    public void setShinseishaTelNo(TelNo shinseishaTelNo) {
        this.shinseishaTelNo = shinseishaTelNo;
    }

    /**
     * 申請事業者番号のgetメソッドです。
     *
     * @return 申請事業者番号
     */
    @CheckForNull
    public JigyoshaNo getShinseiJigyoshaNo() {
        return shinseiJigyoshaNo;
    }

    /**
     * 申請事業者番号のsetメソッドです。
     *
     * @param shinseiJigyoshaNo 申請事業者番号
     */
    public void setShinseiJigyoshaNo(JigyoshaNo shinseiJigyoshaNo) {
        this.shinseiJigyoshaNo = shinseiJigyoshaNo;
    }

    /**
     * 理由書作成日のgetメソッドです。
     *
     * @return 理由書作成日
     */
    @CheckForNull
    public FlexibleDate getRiyushoSakuseiYMD() {
        return riyushoSakuseiYMD;
    }

    /**
     * 理由書作成日のsetメソッドです。
     *
     * @param riyushoSakuseiYMD 理由書作成日
     */
    public void setRiyushoSakuseiYMD(FlexibleDate riyushoSakuseiYMD) {
        this.riyushoSakuseiYMD = riyushoSakuseiYMD;
    }

    /**
     * 理由書作成者のgetメソッドです。
     *
     * @return 理由書作成者
     */
    @CheckForNull
    public RString getRiyushoSakuseishaName() {
        return riyushoSakuseishaName;
    }

    /**
     * 理由書作成者のsetメソッドです。
     *
     * @param riyushoSakuseishaName 理由書作成者
     */
    public void setRiyushoSakuseishaName(RString riyushoSakuseishaName) {
        this.riyushoSakuseishaName = riyushoSakuseishaName;
    }

    /**
     * 理由書作成者カナのgetメソッドです。
     *
     * @return 理由書作成者カナ
     */
    @CheckForNull
    public RString getRiyushoSakuseishaKanaName() {
        return riyushoSakuseishaKanaName;
    }

    /**
     * 理由書作成者カナのsetメソッドです。
     *
     * @param riyushoSakuseishaKanaName 理由書作成者カナ
     */
    public void setRiyushoSakuseishaKanaName(RString riyushoSakuseishaKanaName) {
        this.riyushoSakuseishaKanaName = riyushoSakuseishaKanaName;
    }

    /**
     * 理由書作成事業者番号のgetメソッドです。
     *
     * @return 理由書作成事業者番号
     */
    @CheckForNull
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * 理由書作成事業者番号のsetメソッドです。
     *
     * @param riyushoSakuseiJigyoshaNo 理由書作成事業者番号
     */
    public void setRiyushoSakuseiJigyoshaNo(JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * 支払金額合計のgetメソッドです。
     *
     * @return 支払金額合計
     */
    @CheckForNull
    public Decimal getShiharaiKingakuTotal() {
        return shiharaiKingakuTotal;
    }

    /**
     * 支払金額合計のsetメソッドです。
     *
     * @param shiharaiKingakuTotal 支払金額合計
     */
    public void setShiharaiKingakuTotal(Decimal shiharaiKingakuTotal) {
        this.shiharaiKingakuTotal = shiharaiKingakuTotal;
    }

    /**
     * 保険対象費用額のgetメソッドです。
     *
     * @return 保険対象費用額
     */
    @CheckForNull
    public Decimal getHokenTaishoHiyogaku() {
        return hokenTaishoHiyogaku;
    }

    /**
     * 保険対象費用額のsetメソッドです。
     *
     * @param hokenTaishoHiyogaku 保険対象費用額
     */
    public void setHokenTaishoHiyogaku(Decimal hokenTaishoHiyogaku) {
        this.hokenTaishoHiyogaku = hokenTaishoHiyogaku;
    }

    /**
     * 保険給付額のgetメソッドです。
     *
     * @return 保険給付額
     */
    @CheckForNull
    public int getHokenKyufugaku() {
        return hokenKyufugaku;
    }

    /**
     * 保険給付額のsetメソッドです。
     *
     * @param hokenKyufugaku 保険給付額
     */
    public void setHokenKyufugaku(int hokenKyufugaku) {
        this.hokenKyufugaku = hokenKyufugaku;
    }

    /**
     * 利用者負担額のgetメソッドです。
     *
     * @return 利用者負担額
     */
    @CheckForNull
    public int getRiyoshaFutangaku() {
        return riyoshaFutangaku;
    }

    /**
     * 利用者負担額のsetメソッドです。
     *
     * @param riyoshaFutangaku 利用者負担額
     */
    public void setRiyoshaFutangaku(int riyoshaFutangaku) {
        this.riyoshaFutangaku = riyoshaFutangaku;
    }

    /**
     * 支給申請審査区分のgetメソッドです。
     * <br/>
     * <br/>1:未審査、2:審査済み
     *
     * @return 支給申請審査区分
     */
    @CheckForNull
    public RString getShikyuShinseiShinsaKubun() {
        return shikyuShinseiShinsaKubun;
    }

    /**
     * 支給申請審査区分のsetメソッドです。
     * <br/>
     * <br/>1:未審査、2:審査済み
     *
     * @param shikyuShinseiShinsaKubun 支給申請審査区分
     */
    public void setShikyuShinseiShinsaKubun(RString shikyuShinseiShinsaKubun) {
        this.shikyuShinseiShinsaKubun = shikyuShinseiShinsaKubun;
    }

    /**
     * 審査方法区分のgetメソッドです。
     * <br/>
     * <br/>1:審査依頼,2:審査済み
     *
     * @return 審査方法区分
     */
    public RString getShinsaHohoKubun() {
        return shinsaHohoKubun;
    }

    /**
     * 審査方法区分のsetメソッドです。
     * <br/>
     * <br/>1:審査依頼,2:審査済み
     *
     * @param shinsaHohoKubun 審査方法区分
     */
    public void setShinsaHohoKubun(@Nonnull RString shinsaHohoKubun) {
        this.shinsaHohoKubun = shinsaHohoKubun;
    }

    /**
     * 送付区分のgetメソッドです。
     * <br/>
     * <br/>1:送付済（１回送付済になるとクリアされない）
     *
     * @return 送付区分
     */
    @CheckForNull
    public RString getSofuKubun() {
        return sofuKubun;
    }

    /**
     * 送付区分のsetメソッドです。
     * <br/>
     * <br/>1:送付済（１回送付済になるとクリアされない）
     *
     * @param sofuKubun 送付区分
     */
    public void setSofuKubun(RString sofuKubun) {
        this.sofuKubun = sofuKubun;
    }

    /**
     * 送付年月のgetメソッドです。
     *
     * @return 送付年月
     */
    @CheckForNull
    public FlexibleYearMonth getSofuYM() {
        return sofuYM;
    }

    /**
     * 送付年月のsetメソッドです。
     *
     * @param sofuYM 送付年月
     */
    public void setSofuYM(FlexibleYearMonth sofuYM) {
        this.sofuYM = sofuYM;
    }

    /**
     * 国保連再送付フラグのgetメソッドです。
     * <br/>
     * <br/>True：再送付する、False：再送付しない
     *
     * @return 国保連再送付フラグ
     */
    @CheckForNull
    public boolean getKokuhorenSaisofuFlag() {
        return kokuhorenSaisofuFlag;
    }

    /**
     * 国保連再送付フラグのsetメソッドです。
     * <br/>
     * <br/>True：再送付する、False：再送付しない
     *
     * @param kokuhorenSaisofuFlag 国保連再送付フラグ
     */
    public void setKokuhorenSaisofuFlag(boolean kokuhorenSaisofuFlag) {
        this.kokuhorenSaisofuFlag = kokuhorenSaisofuFlag;
    }

    /**
     * 支払方法区分コードのgetメソッドです。
     *
     * @return 支払方法区分コード
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * 支払窓口開始時間のgetメソッドです。
     *
     * @return 支払窓口開始時間
     */
    @CheckForNull
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
    @CheckForNull
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
     *
     * @return 口座ID
     */
    @CheckForNull
    public long getKozaID() {
        return kozaID;
    }

    /**
     * 口座IDのsetメソッドです。
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
    @CheckForNull
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
     * 住宅所有者のgetメソッドです。
     *
     * @return 住宅所有者
     */
    @CheckForNull
    public RString getJutakuShoyusha() {
        return jutakuShoyusha;
    }

    /**
     * 住宅所有者のsetメソッドです。
     *
     * @param jutakuShoyusha 住宅所有者
     */
    public void setJutakuShoyusha(RString jutakuShoyusha) {
        this.jutakuShoyusha = jutakuShoyusha;
    }

    /**
     * 被保険者との関係のgetメソッドです。
     *
     * @return 被保険者との関係
     */
    @CheckForNull
    public RString getHihokenshaKankei() {
        return hihokenshaKankei;
    }

    /**
     * 被保険者との関係のsetメソッドです。
     *
     * @param hihokenshaKankei 被保険者との関係
     */
    public void setHihokenshaKankei(RString hihokenshaKankei) {
        this.hihokenshaKankei = hihokenshaKankei;
    }

    /**
     * 要介護状態３段階変更のgetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @return 要介護状態３段階変更
     */
    @CheckForNull
    public boolean getYokaigo3DankaiHenko() {
        return yokaigo3DankaiHenko;
    }

    /**
     * 要介護状態３段階変更のsetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @param yokaigo3DankaiHenko 要介護状態３段階変更
     */
    public void setYokaigo3DankaiHenko(boolean yokaigo3DankaiHenko) {
        this.yokaigo3DankaiHenko = yokaigo3DankaiHenko;
    }

    /**
     * 住宅住所変更のgetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @return 住宅住所変更
     */
    @CheckForNull
    public boolean getJutakuJushoHenko() {
        return jutakuJushoHenko;
    }

    /**
     * 住宅住所変更のsetメソッドです。
     * <br/>
     * <br/>True：変更する、False：変更無し
     *
     * @param jutakuJushoHenko 住宅住所変更
     */
    public void setJutakuJushoHenko(boolean jutakuJushoHenko) {
        this.jutakuJushoHenko = jutakuJushoHenko;
    }

    /**
     * 審査年月日のgetメソッドです。
     *
     * @return 審査年月日
     */
    @CheckForNull
    public FlexibleDate getShinsaYMD() {
        return shinsaYMD;
    }

    /**
     * 審査年月日のsetメソッドです。
     *
     * @param shinsaYMD 審査年月日
     */
    public void setShinsaYMD(FlexibleDate shinsaYMD) {
        this.shinsaYMD = shinsaYMD;
    }

    /**
     * 審査結果のgetメソッドです。
     *
     * @return 審査結果
     */
    @CheckForNull
    public RString getShinsaKekka() {
        return shinsaKekka;
    }

    /**
     * 審査結果のsetメソッドです。
     *
     * @param shinsaKekka 審査結果
     */
    public void setShinsaKekka(RString shinsaKekka) {
        this.shinsaKekka = shinsaKekka;
    }

    /**
     * 事前申請サービス提供年月のgetメソッドです。
     *
     * @return 事前申請サービス提供年月
     */
    @CheckForNull
    public FlexibleYearMonth getJizenServiceTeikyoYM() {
        return jizenServiceTeikyoYM;
    }

    /**
     * 事前申請サービス提供年月のsetメソッドです。
     *
     * @param jizenServiceTeikyoYM 事前申請サービス提供年月
     */
    public void setJizenServiceTeikyoYM(FlexibleYearMonth jizenServiceTeikyoYM) {
        this.jizenServiceTeikyoYM = jizenServiceTeikyoYM;
    }

    /**
     * 事前申請整理番号のgetメソッドです。
     *
     * @return 事前申請整理番号
     */
    @CheckForNull
    public RString getJizenSeiriNo() {
        return jizenSeiriNo;
    }

    /**
     * 事前申請整理番号のsetメソッドです。
     *
     * @param jizenSeiriNo 事前申請整理番号
     */
    public void setJizenSeiriNo(RString jizenSeiriNo) {
        this.jizenSeiriNo = jizenSeiriNo;
    }

    /**
     * 住宅改修申請区分のgetメソッドです。
     * <br/>
     * <br/>(DBC)Enum住宅改修申請区分
     *
     * @return 住宅改修申請区分
     */
    @CheckForNull
    public RString getKaishuShinseiKubun() {
        return kaishuShinseiKubun;
    }

    /**
     * 住宅改修申請区分のsetメソッドです。
     * <br/>
     * <br/>(DBC)Enum住宅改修申請区分
     *
     * @param kaishuShinseiKubun 住宅改修申請区分
     */
    public void setKaishuShinseiKubun(RString kaishuShinseiKubun) {
        this.kaishuShinseiKubun = kaishuShinseiKubun;
    }

    /**
     * 住宅改修申請取消事由コードのgetメソッドです。
     * <br/>
     * <br/>(DBC)コードマスタ:0028
     *
     * @return 住宅改修申請取消事由コード
     */
    @CheckForNull
    public RString getKaishuShinseiTorikeshijiyuCode() {
        return kaishuShinseiTorikeshijiyuCode;
    }

    /**
     * 住宅改修申請取消事由コードのsetメソッドです。
     * <br/>
     * <br/>(DBC)コードマスタ:0028
     *
     * @param kaishuShinseiTorikeshijiyuCode 住宅改修申請取消事由コード
     */
    public void setKaishuShinseiTorikeshijiyuCode(RString kaishuShinseiTorikeshijiyuCode) {
        this.kaishuShinseiTorikeshijiyuCode = kaishuShinseiTorikeshijiyuCode;
    }

    /**
     * 領収年月日のgetメソッドです。
     *
     * @return 領収年月日
     */
    @CheckForNull
    public FlexibleDate getRyoshuYMD() {
        return ryoshuYMD;
    }

    /**
     * 領収年月日のsetメソッドです。
     *
     * @param ryoshuYMD 領収年月日
     */
    public void setRyoshuYMD(FlexibleDate ryoshuYMD) {
        this.ryoshuYMD = ryoshuYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3034ShokanShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3034ShokanShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3034ShokanShinseiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.hiHokenshaNo, other.hiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.serviceTeikyoYM, other.serviceTeikyoYM)) {
            return false;
        }
        if (!Objects.equals(this.seiriNo, other.seiriNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT3034ShokanShinseiEntity entity) {
        this.hiHokenshaNo = entity.hiHokenshaNo;
        this.serviceTeikyoYM = entity.serviceTeikyoYM;
        this.seiriNo = entity.seiriNo;
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.uketsukeYMD = entity.uketsukeYMD;
        this.shinseiYMD = entity.shinseiYMD;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKubun = entity.shinseishaKubun;
        this.shinseishaNameKanji = entity.shinseishaNameKanji;
        this.shinseishaNameKana = entity.shinseishaNameKana;
        this.shinseishaYubinNo = entity.shinseishaYubinNo;
        this.shinseishaAddress = entity.shinseishaAddress;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiJigyoshaNo = entity.shinseiJigyoshaNo;
        this.riyushoSakuseiYMD = entity.riyushoSakuseiYMD;
        this.riyushoSakuseishaName = entity.riyushoSakuseishaName;
        this.riyushoSakuseishaKanaName = entity.riyushoSakuseishaKanaName;
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.shiharaiKingakuTotal = entity.shiharaiKingakuTotal;
        this.hokenTaishoHiyogaku = entity.hokenTaishoHiyogaku;
        this.hokenKyufugaku = entity.hokenKyufugaku;
        this.riyoshaFutangaku = entity.riyoshaFutangaku;
        this.shikyuShinseiShinsaKubun = entity.shikyuShinseiShinsaKubun;
        this.shinsaHohoKubun = entity.shinsaHohoKubun;
        this.sofuKubun = entity.sofuKubun;
        this.sofuYM = entity.sofuYM;
        this.kokuhorenSaisofuFlag = entity.kokuhorenSaisofuFlag;
        this.shiharaiHohoKubunCode = entity.shiharaiHohoKubunCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.kozaID = entity.kozaID;
        this.juryoininKeiyakuNo = entity.juryoininKeiyakuNo;
        this.jutakuShoyusha = entity.jutakuShoyusha;
        this.hihokenshaKankei = entity.hihokenshaKankei;
        this.yokaigo3DankaiHenko = entity.yokaigo3DankaiHenko;
        this.jutakuJushoHenko = entity.jutakuJushoHenko;
        this.shinsaYMD = entity.shinsaYMD;
        this.shinsaKekka = entity.shinsaKekka;
        this.jizenServiceTeikyoYM = entity.jizenServiceTeikyoYM;
        this.jizenSeiriNo = entity.jizenSeiriNo;
        this.kaishuShinseiKubun = entity.kaishuShinseiKubun;
        this.kaishuShinseiTorikeshijiyuCode = entity.kaishuShinseiTorikeshijiyuCode;
        this.ryoshuYMD = entity.ryoshuYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, shinseiRiyu, shinseishaKubun, shinseishaNameKanji, shinseishaNameKana, shinseishaYubinNo, shinseishaAddress, shinseishaTelNo, shinseiJigyoshaNo, riyushoSakuseiYMD, riyushoSakuseishaName, riyushoSakuseishaKanaName, riyushoSakuseiJigyoshaNo, shiharaiKingakuTotal, hokenTaishoHiyogaku, hokenKyufugaku, riyoshaFutangaku, shikyuShinseiShinsaKubun, shinsaHohoKubun, sofuKubun, sofuYM, kokuhorenSaisofuFlag, shiharaiHohoKubunCode, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, shiharaiKaishiTime, shiharaiShuryoTime, kozaID, juryoininKeiyakuNo, jutakuShoyusha, hihokenshaKankei, yokaigo3DankaiHenko, jutakuJushoHenko, shinsaYMD, shinsaKekka, jizenServiceTeikyoYM, jizenSeiriNo, kaishuShinseiKubun, kaishuShinseiTorikeshijiyuCode, ryoshuYMD);
    }

// </editor-fold>
}
