package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 償還払支給住宅改修事前申請テーブルのエンティティクラスです。
 */
public class DbT3035ShokanJutakuKaishuJizenShinseiEntity extends DbTableEntityBase<DbT3035ShokanJutakuKaishuJizenShinseiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3035ShokanJutakuKaishuJizenShinsei");

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
    private RString shinseishaJusho;
    private TelNo shinseishaTelNo;
    private JigyoshaNo shinseiJigyoshaNo;
    private FlexibleDate riyushoSakuseiYMD;
    private RString riyushoSakuseishaName;
    private RString riyushoSakuseishaKanaName;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    private RString shiharaiHohoKubunCode;
    private RString shiharaiBasho;
    private FlexibleDate shiharaiKaishiYMD;
    private FlexibleDate shiharaiShuryoYMD;
    private RString shiharaiKaishiTime;
    private RString shiharaiShuryoTime;
    private long kozaID;
    private RString juryoininKeiyakuNo;
    private ServiceShuruiCode serviceShuruiCode;
    private RString jutakuShoyusha;
    private RString hihokenshaKankei;
    private boolean yokaigo3DankaiHenko;
    private boolean jutakuJushoHenko;
    private FlexibleDate hanteiKetteiYMD;
    private RString hanteiKubun;
    private RString shoninJoken;
    private RString fushoninRiyu;
    private int kyufugakuHiyogakuTotal;
    private int kyufugakuHokenTaishoHiyogaku;
    private int kyufugakuRiyoshaJikofutangaku;
    private int kyufugakuHokenkyufuhigaku;
    private FlexibleDate ketteitsuchishoHakkoYMD;
    private RString kaishushinseiKubun;
    private RString kaishuShinseiTorikeshijiyuCode;
    private HokenKyufuRitsu hokenKyufuritsu;
    private FlexibleDate sekoKanryoYoteiYMD;

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
    @CheckForNull
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
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
     *
     * @return 申請年月日
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 申請年月日のsetメソッドです。
     * <br/>
     * <br/>1:本人,2:代理人,3:受領委任事業者
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
     *
     * @return 申請者区分
     */
    @CheckForNull
    public RString getShinseishaKubun() {
        return shinseishaKubun;
    }

    /**
     * 申請者区分のsetメソッドです。
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
    public RString getShinseishaJusho() {
        return shinseishaJusho;
    }

    /**
     * 申請者住所のsetメソッドです。
     *
     * @param shinseishaJusho 申請者住所
     */
    public void setShinseishaJusho(RString shinseishaJusho) {
        this.shinseishaJusho = shinseishaJusho;
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
     * サービス種類コードのgetメソッドです。
     *
     * @return サービス種類コード
     */
    @CheckForNull
    public ServiceShuruiCode getServiceShuruiCode() {
        return serviceShuruiCode;
    }

    /**
     * サービス種類コードのsetメソッドです。
     *
     * @param serviceShuruiCode サービス種類コード
     */
    public void setServiceShuruiCode(ServiceShuruiCode serviceShuruiCode) {
        this.serviceShuruiCode = serviceShuruiCode;
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
     * 判定決定年月日のgetメソッドです。
     *
     * @return 判定決定年月日
     */
    @CheckForNull
    public FlexibleDate getHanteiKetteiYMD() {
        return hanteiKetteiYMD;
    }

    /**
     * 判定決定年月日のsetメソッドです。
     *
     * @param hanteiKetteiYMD 判定決定年月日
     */
    public void setHanteiKetteiYMD(FlexibleDate hanteiKetteiYMD) {
        this.hanteiKetteiYMD = hanteiKetteiYMD;
    }

    /**
     * 判定区分のgetメソッドです。
     *
     * @return 判定区分
     */
    @CheckForNull
    public RString getHanteiKubun() {
        return hanteiKubun;
    }

    /**
     * 判定区分のsetメソッドです。
     *
     * @param hanteiKubun 判定区分
     */
    public void setHanteiKubun(RString hanteiKubun) {
        this.hanteiKubun = hanteiKubun;
    }

    /**
     * 承認条件のgetメソッドです。
     *
     * @return 承認条件
     */
    @CheckForNull
    public RString getShoninJoken() {
        return shoninJoken;
    }

    /**
     * 承認条件のsetメソッドです。
     *
     * @param shoninJoken 承認条件
     */
    public void setShoninJoken(RString shoninJoken) {
        this.shoninJoken = shoninJoken;
    }

    /**
     * 不承認理由のgetメソッドです。
     *
     * @return 不承認理由
     */
    @CheckForNull
    public RString getFushoninRiyu() {
        return fushoninRiyu;
    }

    /**
     * 不承認理由のsetメソッドです。
     *
     * @param fushoninRiyu 不承認理由
     */
    public void setFushoninRiyu(RString fushoninRiyu) {
        this.fushoninRiyu = fushoninRiyu;
    }

    /**
     * 給付額等・費用額合計のgetメソッドです。
     *
     * @return 給付額等・費用額合計
     */
    @CheckForNull
    public int getKyufugakuHiyogakuTotal() {
        return kyufugakuHiyogakuTotal;
    }

    /**
     * 給付額等・費用額合計のsetメソッドです。
     *
     * @param kyufugakuHiyogakuTotal 給付額等・費用額合計
     */
    public void setKyufugakuHiyogakuTotal(int kyufugakuHiyogakuTotal) {
        this.kyufugakuHiyogakuTotal = kyufugakuHiyogakuTotal;
    }

    /**
     * 給付額等・保険対象費用額のgetメソッドです。
     *
     * @return 給付額等・保険対象費用額
     */
    @CheckForNull
    public int getKyufugakuHokenTaishoHiyogaku() {
        return kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * 給付額等・保険対象費用額のsetメソッドです。
     *
     * @param kyufugakuHokenTaishoHiyogaku 給付額等・保険対象費用額
     */
    public void setKyufugakuHokenTaishoHiyogaku(int kyufugakuHokenTaishoHiyogaku) {
        this.kyufugakuHokenTaishoHiyogaku = kyufugakuHokenTaishoHiyogaku;
    }

    /**
     * 給付額等・利用者自己負担額のgetメソッドです。
     *
     * @return 給付額等・利用者自己負担額
     */
    @CheckForNull
    public int getKyufugakuRiyoshaJikofutangaku() {
        return kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * 給付額等・利用者自己負担額のsetメソッドです。
     *
     * @param kyufugakuRiyoshaJikofutangaku 給付額等・利用者自己負担額
     */
    public void setKyufugakuRiyoshaJikofutangaku(int kyufugakuRiyoshaJikofutangaku) {
        this.kyufugakuRiyoshaJikofutangaku = kyufugakuRiyoshaJikofutangaku;
    }

    /**
     * 給付額等・保険給付費額のgetメソッドです。
     *
     * @return 給付額等・保険給付費額
     */
    @CheckForNull
    public int getKyufugakuHokenkyufuhigaku() {
        return kyufugakuHokenkyufuhigaku;
    }

    /**
     * 給付額等・保険給付費額のsetメソッドです。
     *
     * @param kyufugakuHokenkyufuhigaku 給付額等・保険給付費額
     */
    public void setKyufugakuHokenkyufuhigaku(int kyufugakuHokenkyufuhigaku) {
        this.kyufugakuHokenkyufuhigaku = kyufugakuHokenkyufuhigaku;
    }

    /**
     * 事前申請決定通知発行日のgetメソッドです。
     *
     * @return 事前申請決定通知発行日
     */
    @CheckForNull
    public FlexibleDate getKetteitsuchishoHakkoYMD() {
        return ketteitsuchishoHakkoYMD;
    }

    /**
     * 事前申請決定通知発行日のsetメソッドです。
     *
     * @param ketteitsuchishoHakkoYMD 事前申請決定通知発行日
     */
    public void setKetteitsuchishoHakkoYMD(FlexibleDate ketteitsuchishoHakkoYMD) {
        this.ketteitsuchishoHakkoYMD = ketteitsuchishoHakkoYMD;
    }

    /**
     * 住宅改修申請区分のgetメソッドです。
     * <br/>
     * <br/>(DBC)Enum住宅改修申請区分
     *
     * @return 住宅改修申請区分
     */
    @CheckForNull
    public RString getKaishushinseiKubun() {
        return kaishushinseiKubun;
    }

    /**
     * 住宅改修申請区分のsetメソッドです。
     * <br/>
     * <br/>(DBC)Enum住宅改修申請区分
     *
     * @param kaishushinseiKubun 住宅改修申請区分
     */
    public void setKaishushinseiKubun(RString kaishushinseiKubun) {
        this.kaishushinseiKubun = kaishushinseiKubun;
    }

    /**
     * 住宅改修申請取消事由コードのgetメソッドです。
     * <br/>
     * <br/>(DBC)コードマスタ：0028
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
     * <br/>(DBC)コードマスタ：0028
     *
     * @param kaishuShinseiTorikeshijiyuCode 住宅改修申請取消事由コード
     */
    public void setKaishuShinseiTorikeshijiyuCode(RString kaishuShinseiTorikeshijiyuCode) {
        this.kaishuShinseiTorikeshijiyuCode = kaishuShinseiTorikeshijiyuCode;
    }

    /**
     * 保険給付率のgetメソッドです。
     *
     * @return 保険給付率
     */
    @CheckForNull
    public HokenKyufuRitsu getHokenKyufuritsu() {
        return hokenKyufuritsu;
    }

    /**
     * 保険給付率のsetメソッドです。
     *
     * @param hokenKyufuritsu 保険給付率
     */
    public void setHokenKyufuritsu(HokenKyufuRitsu hokenKyufuritsu) {
        this.hokenKyufuritsu = hokenKyufuritsu;
    }

    /**
     * 施工完了予定年月日のgetメソッドです。
     *
     * @return 施工完了予定年月日
     */
    @CheckForNull
    public FlexibleDate getSekoKanryoYoteiYMD() {
        return sekoKanryoYoteiYMD;
    }

    /**
     * 施工完了予定年月日のsetメソッドです。
     *
     * @param sekoKanryoYoteiYMD 施工完了予定年月日
     */
    public void setSekoKanryoYoteiYMD(FlexibleDate sekoKanryoYoteiYMD) {
        this.sekoKanryoYoteiYMD = sekoKanryoYoteiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3035ShokanJutakuKaishuJizenShinseiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3035ShokanJutakuKaishuJizenShinseiEntity other) {
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
    public void shallowCopy(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
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
        this.shinseishaJusho = entity.shinseishaJusho;
        this.shinseishaTelNo = entity.shinseishaTelNo;
        this.shinseiJigyoshaNo = entity.shinseiJigyoshaNo;
        this.riyushoSakuseiYMD = entity.riyushoSakuseiYMD;
        this.riyushoSakuseishaName = entity.riyushoSakuseishaName;
        this.riyushoSakuseishaKanaName = entity.riyushoSakuseishaKanaName;
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.shiharaiHohoKubunCode = entity.shiharaiHohoKubunCode;
        this.shiharaiBasho = entity.shiharaiBasho;
        this.shiharaiKaishiYMD = entity.shiharaiKaishiYMD;
        this.shiharaiShuryoYMD = entity.shiharaiShuryoYMD;
        this.shiharaiKaishiTime = entity.shiharaiKaishiTime;
        this.shiharaiShuryoTime = entity.shiharaiShuryoTime;
        this.kozaID = entity.kozaID;
        this.juryoininKeiyakuNo = entity.juryoininKeiyakuNo;
        this.serviceShuruiCode = entity.serviceShuruiCode;
        this.jutakuShoyusha = entity.jutakuShoyusha;
        this.hihokenshaKankei = entity.hihokenshaKankei;
        this.yokaigo3DankaiHenko = entity.yokaigo3DankaiHenko;
        this.jutakuJushoHenko = entity.jutakuJushoHenko;
        this.hanteiKetteiYMD = entity.hanteiKetteiYMD;
        this.hanteiKubun = entity.hanteiKubun;
        this.shoninJoken = entity.shoninJoken;
        this.fushoninRiyu = entity.fushoninRiyu;
        this.kyufugakuHiyogakuTotal = entity.kyufugakuHiyogakuTotal;
        this.kyufugakuHokenTaishoHiyogaku = entity.kyufugakuHokenTaishoHiyogaku;
        this.kyufugakuRiyoshaJikofutangaku = entity.kyufugakuRiyoshaJikofutangaku;
        this.kyufugakuHokenkyufuhigaku = entity.kyufugakuHokenkyufuhigaku;
        this.ketteitsuchishoHakkoYMD = entity.ketteitsuchishoHakkoYMD;
        this.kaishushinseiKubun = entity.kaishushinseiKubun;
        this.kaishuShinseiTorikeshijiyuCode = entity.kaishuShinseiTorikeshijiyuCode;
        this.hokenKyufuritsu = entity.hokenKyufuritsu;
        this.sekoKanryoYoteiYMD = entity.sekoKanryoYoteiYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(hiHokenshaNo, serviceTeikyoYM, seiriNo, shoKisaiHokenshaNo, uketsukeYMD, shinseiYMD, shinseiRiyu, shinseishaKubun, shinseishaNameKanji, shinseishaNameKana, shinseishaYubinNo, shinseishaJusho, shinseishaTelNo, shinseiJigyoshaNo, riyushoSakuseiYMD, riyushoSakuseishaName, riyushoSakuseishaKanaName, riyushoSakuseiJigyoshaNo, shiharaiHohoKubunCode, shiharaiBasho, shiharaiKaishiYMD, shiharaiShuryoYMD, shiharaiKaishiTime, shiharaiShuryoTime, kozaID, juryoininKeiyakuNo, serviceShuruiCode, jutakuShoyusha, hihokenshaKankei, yokaigo3DankaiHenko, jutakuJushoHenko, hanteiKetteiYMD, hanteiKubun, shoninJoken, fushoninRiyu, kyufugakuHiyogakuTotal, kyufugakuHokenTaishoHiyogaku, kyufugakuRiyoshaJikofutangaku, kyufugakuHokenkyufuhigaku, ketteitsuchishoHakkoYMD, kaishushinseiKubun, kaishuShinseiTorikeshijiyuCode, hokenKyufuritsu, sekoKanryoYoteiYMD);
    }

// </editor-fold>
}
