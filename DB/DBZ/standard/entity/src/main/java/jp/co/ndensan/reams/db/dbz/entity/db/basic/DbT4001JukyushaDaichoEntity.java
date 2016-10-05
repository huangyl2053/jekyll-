package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 受給者台帳テーブルのエンティティクラスです。
 */
public class DbT4001JukyushaDaichoEntity extends DbTableEntityBase<DbT4001JukyushaDaichoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT4001JukyushaDaicho");

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
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private RString rirekiNo;
    @PrimaryKey
    private RString edaban;
    private ShinseishoKanriNo shinseishoKanriNo;
    private RString shinseiJokyoKubun;
    private RString shishoCode;
    private boolean chokkinFlag;
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private Code jukyuShinseiJiyu;
    private RString shinseiRiyu;
    private Code shinseishaKankeiCode;
    private RString homninKankei;
    private FlexibleDate jukyuShinseiYMD;
    private Code nigoTokuteiShippeiCode;
    private FlexibleDate shinsakaiIraiYMD;
    private Code yokaigoJotaiKubunCode;
    private FlexibleDate ninteiYukoKikanKaishiYMD;
    private FlexibleDate ninteiYukoKikanShuryoYMD;
    private FlexibleDate ninteiYMD;
    private Code minashiCode;
    private ServiceShuruiCode shiteiServiceShurui01;
    private ServiceShuruiCode shiteiServiceShurui02;
    private ServiceShuruiCode shiteiServiceShurui03;
    private ServiceShuruiCode shiteiServiceShurui04;
    private ServiceShuruiCode shiteiServiceShurui05;
    private ServiceShuruiCode shiteiServiceShurui06;
    private ServiceShuruiCode shiteiServiceShurui07;
    private ServiceShuruiCode shiteiServiceShurui08;
    private ServiceShuruiCode shiteiServiceShurui09;
    private ServiceShuruiCode shiteiServiceShurui10;
    private ServiceShuruiCode shiteiServiceShurui11;
    private ServiceShuruiCode shiteiServiceShurui12;
    private ServiceShuruiCode shiteiServiceShurui13;
    private ServiceShuruiCode shiteiServiceShurui14;
    private ServiceShuruiCode shiteiServiceShurui15;
    private ServiceShuruiCode shiteiServiceShurui16;
    private ServiceShuruiCode shiteiServiceShurui17;
    private ServiceShuruiCode shiteiServiceShurui18;
    private ServiceShuruiCode shiteiServiceShurui19;
    private ServiceShuruiCode shiteiServiceShurui20;
    private ServiceShuruiCode shiteiServiceShurui21;
    private ServiceShuruiCode shiteiServiceShurui22;
    private ServiceShuruiCode shiteiServiceShurui23;
    private ServiceShuruiCode shiteiServiceShurui24;
    private ServiceShuruiCode shiteiServiceShurui25;
    private ServiceShuruiCode shiteiServiceShurui26;
    private ServiceShuruiCode shiteiServiceShurui27;
    private ServiceShuruiCode shiteiServiceShurui28;
    private ServiceShuruiCode shiteiServiceShurui29;
    private ServiceShuruiCode shiteiServiceShurui30;
    private FlexibleDate soshitsuYMD;
    private FlexibleDate chokkinIdoYMD;
    private Code chokkinIdoJiyuCode;
    private Code yukoMukoKubun;
    private Code dataKubun;
    private RString remban;
    private RString idoRiyu;
    private Code shinseishoKubun;
    private Code sakujoJiyuCode;
    private boolean yoshienshaNinteiShinseiFlag;
    private Decimal shikyuGendoTanisu;
    private FlexibleDate shikyuGendoKaishiYMD;
    private FlexibleDate shikyuGendoShuryoYMD;
    private int tankiSikyuGendoNissu;
    private FlexibleDate tankiShikyuGendoKaishiYMD;
    private FlexibleDate tankiShikyuGendoShuryoYMD;
    private FlexibleDate toshoNinteiYukoKaishiYMD;
    private FlexibleDate toshoNinteiYukoShuryoYMD;
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD1;
    private FlexibleDate jukyuShikakuShomeishoHakkoYMD2;
    private FlexibleDate shindanMeireishoHakkoYMD;
    private FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD;
    private FlexibleDate ninteiKekkaTsuchishoHakkoYMD;
    private FlexibleDate kubunHenkoTsuchishoHakkoYMD;
    private FlexibleDate serviceHenkoTsuchishoHakkoYMD;
    private FlexibleDate ninteiKyakkaTsuchishoHakkoYMD;
    private FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD;
    private boolean shikakuShutokuMaeShinseiFlag;
    private boolean kyuSochishaFlag;
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
    public void setHihokenshaNo(@Nonnull HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     *
     * @return 履歴番号
     */
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     *
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(@Nonnull RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 枝番のgetメソッドです。
     *
     * @return 枝番
     */
    public RString getEdaban() {
        return edaban;
    }

    /**
     * 枝番のsetメソッドです。
     *
     * @param edaban 枝番
     */
    public void setEdaban(@Nonnull RString edaban) {
        this.edaban = edaban;
    }

    /**
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 申請状況区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請状況区分）0：申請中、１：認定完了
     *
     * @return 申請状況区分
     */
    public RString getShinseiJokyoKubun() {
        return shinseiJokyoKubun;
    }

    /**
     * 申請状況区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請状況区分）0：申請中、１：認定完了
     *
     * @param shinseiJokyoKubun 申請状況区分
     */
    public void setShinseiJokyoKubun(@Nonnull RString shinseiJokyoKubun) {
        this.shinseiJokyoKubun = shinseiJokyoKubun;
    }

    /**
     * 支所コードのgetメソッドです。
     *
     * @return 支所コード
     */
    public RString getShishoCode() {
        return shishoCode;
    }

    /**
     * 支所コードのsetメソッドです。
     *
     * @param shishoCode 支所コード
     */
    public void setShishoCode(@Nonnull RString shishoCode) {
        this.shishoCode = shishoCode;
    }

    /**
     * 直近フラグのgetメソッドです。
     * <br/>
     * <br/>True:直近情報、False:履歴情報
     *
     * @return 直近フラグ
     */
    public boolean getChokkinFlag() {
        return chokkinFlag;
    }

    /**
     * 直近フラグのsetメソッドです。
     * <br/>
     * <br/>True:直近情報、False:履歴情報
     *
     * @param chokkinFlag 直近フラグ
     */
    public void setChokkinFlag(@Nonnull boolean chokkinFlag) {
        this.chokkinFlag = chokkinFlag;
    }

    /**
     * 識別コードのgetメソッドです。
     * <br/>
     * <br/>旧「住民コード」
     *
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * <br/>
     * <br/>旧「住民コード」
     *
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 受給申請事由のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：受給申請事由）1：初回申請、2：再申請（有効期限内）、3：再申請（有効期限外）、4：要介護度変更申請、5：指定サービス種類変更申請、6：申請（法施行前）、7：追加（申請なしの追加（転入））
     *
     * @return 受給申請事由
     */
    public Code getJukyuShinseiJiyu() {
        return jukyuShinseiJiyu;
    }

    /**
     * 受給申請事由のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：受給申請事由）1：初回申請、2：再申請（有効期限内）、3：再申請（有効期限外）、4：要介護度変更申請、5：指定サービス種類変更申請、6：申請（法施行前）、7：追加（申請なしの追加（転入））
     *
     * @param jukyuShinseiJiyu 受給申請事由
     */
    public void setJukyuShinseiJiyu(@Nonnull Code jukyuShinseiJiyu) {
        this.jukyuShinseiJiyu = jukyuShinseiJiyu;
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
     * （届出者）申請者関係コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請者関係コード）
     *
     * @return （届出者）申請者関係コード
     */
    @CheckForNull
    public Code getShinseishaKankeiCode() {
        return shinseishaKankeiCode;
    }

    /**
     * （届出者）申請者関係コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：申請者関係コード）
     *
     * @param shinseishaKankeiCode （届出者）申請者関係コード
     */
    public void setShinseishaKankeiCode(Code shinseishaKankeiCode) {
        this.shinseishaKankeiCode = shinseishaKankeiCode;
    }

    /**
     * （届出者）本人との関係のgetメソッドです。
     *
     * @return （届出者）本人との関係
     */
    @CheckForNull
    public RString getHomninKankei() {
        return homninKankei;
    }

    /**
     * （届出者）本人との関係のsetメソッドです。
     *
     * @param homninKankei （届出者）本人との関係
     */
    public void setHomninKankei(RString homninKankei) {
        this.homninKankei = homninKankei;
    }

    /**
     * 受給申請年月日のgetメソッドです。
     *
     * @return 受給申請年月日
     */
    @CheckForNull
    public FlexibleDate getJukyuShinseiYMD() {
        return jukyuShinseiYMD;
    }

    /**
     * 受給申請年月日のsetメソッドです。
     *
     * @param jukyuShinseiYMD 受給申請年月日
     */
    public void setJukyuShinseiYMD(FlexibleDate jukyuShinseiYMD) {
        this.jukyuShinseiYMD = jukyuShinseiYMD;
    }

    /**
     * ２号特定疾病コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：特定疾病コード）
     *
     * @return ２号特定疾病コード
     */
    @CheckForNull
    public Code getNigoTokuteiShippeiCode() {
        return nigoTokuteiShippeiCode;
    }

    /**
     * ２号特定疾病コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：特定疾病コード）
     *
     * @param nigoTokuteiShippeiCode ２号特定疾病コード
     */
    public void setNigoTokuteiShippeiCode(Code nigoTokuteiShippeiCode) {
        this.nigoTokuteiShippeiCode = nigoTokuteiShippeiCode;
    }

    /**
     * 審査会依頼年月日のgetメソッドです。
     *
     * @return 審査会依頼年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiIraiYMD() {
        return shinsakaiIraiYMD;
    }

    /**
     * 審査会依頼年月日のsetメソッドです。
     *
     * @param shinsakaiIraiYMD 審査会依頼年月日
     */
    public void setShinsakaiIraiYMD(FlexibleDate shinsakaiIraiYMD) {
        this.shinsakaiIraiYMD = shinsakaiIraiYMD;
    }

    /**
     * 要介護認定状態区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード99）
     *
     * @return 要介護認定状態区分コード
     */
    @CheckForNull
    public Code getYokaigoJotaiKubunCode() {
        return yokaigoJotaiKubunCode;
    }

    /**
     * 要介護認定状態区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBZ：要介護状態区分コード99）
     *
     * @param yokaigoJotaiKubunCode 要介護認定状態区分コード
     */
    public void setYokaigoJotaiKubunCode(Code yokaigoJotaiKubunCode) {
        this.yokaigoJotaiKubunCode = yokaigoJotaiKubunCode;
    }

    /**
     * 認定有効期間開始年月日のgetメソッドです。
     *
     * @return 認定有効期間開始年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanKaishiYMD() {
        return ninteiYukoKikanKaishiYMD;
    }

    /**
     * 認定有効期間開始年月日のsetメソッドです。
     *
     * @param ninteiYukoKikanKaishiYMD 認定有効期間開始年月日
     */
    public void setNinteiYukoKikanKaishiYMD(FlexibleDate ninteiYukoKikanKaishiYMD) {
        this.ninteiYukoKikanKaishiYMD = ninteiYukoKikanKaishiYMD;
    }

    /**
     * 認定有効期間終了年月日のgetメソッドです。
     *
     * @return 認定有効期間終了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        return ninteiYukoKikanShuryoYMD;
    }

    /**
     * 認定有効期間終了年月日のsetメソッドです。
     *
     * @param ninteiYukoKikanShuryoYMD 認定有効期間終了年月日
     */
    public void setNinteiYukoKikanShuryoYMD(FlexibleDate ninteiYukoKikanShuryoYMD) {
        this.ninteiYukoKikanShuryoYMD = ninteiYukoKikanShuryoYMD;
    }

    /**
     * 認定年月日のgetメソッドです。
     * <br/>
     * <br/>認定年月日、却下年月日
     *
     * @return 認定年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYMD() {
        return ninteiYMD;
    }

    /**
     * 認定年月日のsetメソッドです。
     * <br/>
     * <br/>認定年月日、却下年月日
     *
     * @param ninteiYMD 認定年月日
     */
    public void setNinteiYMD(FlexibleDate ninteiYMD) {
        this.ninteiYMD = ninteiYMD;
    }

    /**
     * みなし要介護区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：みなし要介護区分コード）
     *
     * @return みなし要介護区分コード
     */
    @CheckForNull
    public Code getMinashiCode() {
        return minashiCode;
    }

    /**
     * みなし要介護区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：みなし要介護区分コード）
     *
     * @param minashiCode みなし要介護区分コード
     */
    public void setMinashiCode(Code minashiCode) {
        this.minashiCode = minashiCode;
    }

    /**
     * 指定サービス種類01のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類01
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui01() {
        return shiteiServiceShurui01;
    }

    /**
     * 指定サービス種類01のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui01 指定サービス種類01
     */
    public void setShiteiServiceShurui01(ServiceShuruiCode shiteiServiceShurui01) {
        this.shiteiServiceShurui01 = shiteiServiceShurui01;
    }

    /**
     * 指定サービス種類02のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類02
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui02() {
        return shiteiServiceShurui02;
    }

    /**
     * 指定サービス種類02のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui02 指定サービス種類02
     */
    public void setShiteiServiceShurui02(ServiceShuruiCode shiteiServiceShurui02) {
        this.shiteiServiceShurui02 = shiteiServiceShurui02;
    }

    /**
     * 指定サービス種類03のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類03
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui03() {
        return shiteiServiceShurui03;
    }

    /**
     * 指定サービス種類03のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui03 指定サービス種類03
     */
    public void setShiteiServiceShurui03(ServiceShuruiCode shiteiServiceShurui03) {
        this.shiteiServiceShurui03 = shiteiServiceShurui03;
    }

    /**
     * 指定サービス種類04のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類04
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui04() {
        return shiteiServiceShurui04;
    }

    /**
     * 指定サービス種類04のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui04 指定サービス種類04
     */
    public void setShiteiServiceShurui04(ServiceShuruiCode shiteiServiceShurui04) {
        this.shiteiServiceShurui04 = shiteiServiceShurui04;
    }

    /**
     * 指定サービス種類05のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類05
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui05() {
        return shiteiServiceShurui05;
    }

    /**
     * 指定サービス種類05のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui05 指定サービス種類05
     */
    public void setShiteiServiceShurui05(ServiceShuruiCode shiteiServiceShurui05) {
        this.shiteiServiceShurui05 = shiteiServiceShurui05;
    }

    /**
     * 指定サービス種類06のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類06
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui06() {
        return shiteiServiceShurui06;
    }

    /**
     * 指定サービス種類06のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui06 指定サービス種類06
     */
    public void setShiteiServiceShurui06(ServiceShuruiCode shiteiServiceShurui06) {
        this.shiteiServiceShurui06 = shiteiServiceShurui06;
    }

    /**
     * 指定サービス種類07のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類07
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui07() {
        return shiteiServiceShurui07;
    }

    /**
     * 指定サービス種類07のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui07 指定サービス種類07
     */
    public void setShiteiServiceShurui07(ServiceShuruiCode shiteiServiceShurui07) {
        this.shiteiServiceShurui07 = shiteiServiceShurui07;
    }

    /**
     * 指定サービス種類08のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類08
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui08() {
        return shiteiServiceShurui08;
    }

    /**
     * 指定サービス種類08のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui08 指定サービス種類08
     */
    public void setShiteiServiceShurui08(ServiceShuruiCode shiteiServiceShurui08) {
        this.shiteiServiceShurui08 = shiteiServiceShurui08;
    }

    /**
     * 指定サービス種類09のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類09
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui09() {
        return shiteiServiceShurui09;
    }

    /**
     * 指定サービス種類09のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui09 指定サービス種類09
     */
    public void setShiteiServiceShurui09(ServiceShuruiCode shiteiServiceShurui09) {
        this.shiteiServiceShurui09 = shiteiServiceShurui09;
    }

    /**
     * 指定サービス種類10のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類10
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui10() {
        return shiteiServiceShurui10;
    }

    /**
     * 指定サービス種類10のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui10 指定サービス種類10
     */
    public void setShiteiServiceShurui10(ServiceShuruiCode shiteiServiceShurui10) {
        this.shiteiServiceShurui10 = shiteiServiceShurui10;
    }

    /**
     * 指定サービス種類11のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類11
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui11() {
        return shiteiServiceShurui11;
    }

    /**
     * 指定サービス種類11のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui11 指定サービス種類11
     */
    public void setShiteiServiceShurui11(ServiceShuruiCode shiteiServiceShurui11) {
        this.shiteiServiceShurui11 = shiteiServiceShurui11;
    }

    /**
     * 指定サービス種類12のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類12
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui12() {
        return shiteiServiceShurui12;
    }

    /**
     * 指定サービス種類12のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui12 指定サービス種類12
     */
    public void setShiteiServiceShurui12(ServiceShuruiCode shiteiServiceShurui12) {
        this.shiteiServiceShurui12 = shiteiServiceShurui12;
    }

    /**
     * 指定サービス種類13のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類13
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui13() {
        return shiteiServiceShurui13;
    }

    /**
     * 指定サービス種類13のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui13 指定サービス種類13
     */
    public void setShiteiServiceShurui13(ServiceShuruiCode shiteiServiceShurui13) {
        this.shiteiServiceShurui13 = shiteiServiceShurui13;
    }

    /**
     * 指定サービス種類14のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類14
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui14() {
        return shiteiServiceShurui14;
    }

    /**
     * 指定サービス種類14のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui14 指定サービス種類14
     */
    public void setShiteiServiceShurui14(ServiceShuruiCode shiteiServiceShurui14) {
        this.shiteiServiceShurui14 = shiteiServiceShurui14;
    }

    /**
     * 指定サービス種類15のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類15
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui15() {
        return shiteiServiceShurui15;
    }

    /**
     * 指定サービス種類15のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui15 指定サービス種類15
     */
    public void setShiteiServiceShurui15(ServiceShuruiCode shiteiServiceShurui15) {
        this.shiteiServiceShurui15 = shiteiServiceShurui15;
    }

    /**
     * 指定サービス種類16のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類16
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui16() {
        return shiteiServiceShurui16;
    }

    /**
     * 指定サービス種類16のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui16 指定サービス種類16
     */
    public void setShiteiServiceShurui16(ServiceShuruiCode shiteiServiceShurui16) {
        this.shiteiServiceShurui16 = shiteiServiceShurui16;
    }

    /**
     * 指定サービス種類17のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類17
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui17() {
        return shiteiServiceShurui17;
    }

    /**
     * 指定サービス種類17のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui17 指定サービス種類17
     */
    public void setShiteiServiceShurui17(ServiceShuruiCode shiteiServiceShurui17) {
        this.shiteiServiceShurui17 = shiteiServiceShurui17;
    }

    /**
     * 指定サービス種類18のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類18
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui18() {
        return shiteiServiceShurui18;
    }

    /**
     * 指定サービス種類18のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui18 指定サービス種類18
     */
    public void setShiteiServiceShurui18(ServiceShuruiCode shiteiServiceShurui18) {
        this.shiteiServiceShurui18 = shiteiServiceShurui18;
    }

    /**
     * 指定サービス種類19のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類19
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui19() {
        return shiteiServiceShurui19;
    }

    /**
     * 指定サービス種類19のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui19 指定サービス種類19
     */
    public void setShiteiServiceShurui19(ServiceShuruiCode shiteiServiceShurui19) {
        this.shiteiServiceShurui19 = shiteiServiceShurui19;
    }

    /**
     * 指定サービス種類20のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類20
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui20() {
        return shiteiServiceShurui20;
    }

    /**
     * 指定サービス種類20のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui20 指定サービス種類20
     */
    public void setShiteiServiceShurui20(ServiceShuruiCode shiteiServiceShurui20) {
        this.shiteiServiceShurui20 = shiteiServiceShurui20;
    }

    /**
     * 指定サービス種類21のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類21
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui21() {
        return shiteiServiceShurui21;
    }

    /**
     * 指定サービス種類21のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui21 指定サービス種類21
     */
    public void setShiteiServiceShurui21(ServiceShuruiCode shiteiServiceShurui21) {
        this.shiteiServiceShurui21 = shiteiServiceShurui21;
    }

    /**
     * 指定サービス種類22のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類22
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui22() {
        return shiteiServiceShurui22;
    }

    /**
     * 指定サービス種類22のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui22 指定サービス種類22
     */
    public void setShiteiServiceShurui22(ServiceShuruiCode shiteiServiceShurui22) {
        this.shiteiServiceShurui22 = shiteiServiceShurui22;
    }

    /**
     * 指定サービス種類23のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類23
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui23() {
        return shiteiServiceShurui23;
    }

    /**
     * 指定サービス種類23のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui23 指定サービス種類23
     */
    public void setShiteiServiceShurui23(ServiceShuruiCode shiteiServiceShurui23) {
        this.shiteiServiceShurui23 = shiteiServiceShurui23;
    }

    /**
     * 指定サービス種類24のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類24
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui24() {
        return shiteiServiceShurui24;
    }

    /**
     * 指定サービス種類24のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui24 指定サービス種類24
     */
    public void setShiteiServiceShurui24(ServiceShuruiCode shiteiServiceShurui24) {
        this.shiteiServiceShurui24 = shiteiServiceShurui24;
    }

    /**
     * 指定サービス種類25のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類25
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui25() {
        return shiteiServiceShurui25;
    }

    /**
     * 指定サービス種類25のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui25 指定サービス種類25
     */
    public void setShiteiServiceShurui25(ServiceShuruiCode shiteiServiceShurui25) {
        this.shiteiServiceShurui25 = shiteiServiceShurui25;
    }

    /**
     * 指定サービス種類26のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類26
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui26() {
        return shiteiServiceShurui26;
    }

    /**
     * 指定サービス種類26のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui26 指定サービス種類26
     */
    public void setShiteiServiceShurui26(ServiceShuruiCode shiteiServiceShurui26) {
        this.shiteiServiceShurui26 = shiteiServiceShurui26;
    }

    /**
     * 指定サービス種類27のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類27
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui27() {
        return shiteiServiceShurui27;
    }

    /**
     * 指定サービス種類27のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui27 指定サービス種類27
     */
    public void setShiteiServiceShurui27(ServiceShuruiCode shiteiServiceShurui27) {
        this.shiteiServiceShurui27 = shiteiServiceShurui27;
    }

    /**
     * 指定サービス種類28のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類28
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui28() {
        return shiteiServiceShurui28;
    }

    /**
     * 指定サービス種類28のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui28 指定サービス種類28
     */
    public void setShiteiServiceShurui28(ServiceShuruiCode shiteiServiceShurui28) {
        this.shiteiServiceShurui28 = shiteiServiceShurui28;
    }

    /**
     * 指定サービス種類29のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類29
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui29() {
        return shiteiServiceShurui29;
    }

    /**
     * 指定サービス種類29のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui29 指定サービス種類29
     */
    public void setShiteiServiceShurui29(ServiceShuruiCode shiteiServiceShurui29) {
        this.shiteiServiceShurui29 = shiteiServiceShurui29;
    }

    /**
     * 指定サービス種類30のgetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @return 指定サービス種類30
     */
    @CheckForNull
    public ServiceShuruiCode getShiteiServiceShurui30() {
        return shiteiServiceShurui30;
    }

    /**
     * 指定サービス種類30のsetメソッドです。
     * <br/>
     * <br/>Code（DBD：0002）
     *
     * @param shiteiServiceShurui30 指定サービス種類30
     */
    public void setShiteiServiceShurui30(ServiceShuruiCode shiteiServiceShurui30) {
        this.shiteiServiceShurui30 = shiteiServiceShurui30;
    }

    /**
     * 喪失年月日のgetメソッドです。
     * <br/>
     * <br/>職権取消での喪失日
     *
     * @return 喪失年月日
     */
    @CheckForNull
    public FlexibleDate getSoshitsuYMD() {
        return soshitsuYMD;
    }

    /**
     * 喪失年月日のsetメソッドです。
     * <br/>
     * <br/>職権取消での喪失日
     *
     * @param soshitsuYMD 喪失年月日
     */
    public void setSoshitsuYMD(FlexibleDate soshitsuYMD) {
        this.soshitsuYMD = soshitsuYMD;
    }

    /**
     * 直近異動年月日のgetメソッドです。
     * <br/>
     * <br/>直近の異動年月日
     *
     * @return 直近異動年月日
     */
    @CheckForNull
    public FlexibleDate getChokkinIdoYMD() {
        return chokkinIdoYMD;
    }

    /**
     * 直近異動年月日のsetメソッドです。
     * <br/>
     * <br/>直近の異動年月日
     *
     * @param chokkinIdoYMD 直近異動年月日
     */
    public void setChokkinIdoYMD(FlexibleDate chokkinIdoYMD) {
        this.chokkinIdoYMD = chokkinIdoYMD;
    }

    /**
     * 直近異動事由コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：直近異動事由コード）
     *
     * @return 直近異動事由コード
     */
    @CheckForNull
    public Code getChokkinIdoJiyuCode() {
        return chokkinIdoJiyuCode;
    }

    /**
     * 直近異動事由コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：直近異動事由コード）
     *
     * @param chokkinIdoJiyuCode 直近異動事由コード
     */
    public void setChokkinIdoJiyuCode(Code chokkinIdoJiyuCode) {
        this.chokkinIdoJiyuCode = chokkinIdoJiyuCode;
    }

    /**
     * 有効無効区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：有効無効区分）0：申請中、1：有効、2：無効
     *
     * @return 有効無効区分
     */
    @CheckForNull
    public Code getYukoMukoKubun() {
        return yukoMukoKubun;
    }

    /**
     * 有効無効区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：有効無効区分）0：申請中、1：有効、2：無効
     *
     * @param yukoMukoKubun 有効無効区分
     */
    public void setYukoMukoKubun(Code yukoMukoKubun) {
        this.yukoMukoKubun = yukoMukoKubun;
    }

    /**
     * データ区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：データ区分）
     *
     * @return データ区分
     */
    @CheckForNull
    public Code getDataKubun() {
        return dataKubun;
    }

    /**
     * データ区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：データ区分）
     *
     * @param dataKubun データ区分
     */
    public void setDataKubun(Code dataKubun) {
        this.dataKubun = dataKubun;
    }

    /**
     * 同一連番のgetメソッドです。
     *
     * @return 同一連番
     */
    @CheckForNull
    public RString getRemban() {
        return remban;
    }

    /**
     * 同一連番のsetメソッドです。
     *
     * @param remban 同一連番
     */
    public void setRemban(RString remban) {
        this.remban = remban;
    }

    /**
     * 異動理由のgetメソッドです。
     * <br/>
     * <br/>認定理由、却下理由、職権理由
     *
     * @return 異動理由
     */
    @CheckForNull
    public RString getIdoRiyu() {
        return idoRiyu;
    }

    /**
     * 異動理由のsetメソッドです。
     * <br/>
     * <br/>認定理由、却下理由、職権理由
     *
     * @param idoRiyu 異動理由
     */
    public void setIdoRiyu(RString idoRiyu) {
        this.idoRiyu = idoRiyu;
    }

    /**
     * 申請書区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：認定支援申請区分）旧「認定支援申請区分」　0：要介護申請、1：要支援申請
     *
     * @return 申請書区分
     */
    @CheckForNull
    public Code getShinseishoKubun() {
        return shinseishoKubun;
    }

    /**
     * 申請書区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：認定支援申請区分）旧「認定支援申請区分」　0：要介護申請、1：要支援申請
     *
     * @param shinseishoKubun 申請書区分
     */
    public void setShinseishoKubun(Code shinseishoKubun) {
        this.shinseishoKubun = shinseishoKubun;
    }

    /**
     * 削除事由コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：削除事由コード）
     *
     * @return 削除事由コード
     */
    @CheckForNull
    public Code getSakujoJiyuCode() {
        return sakujoJiyuCode;
    }

    /**
     * 削除事由コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：削除事由コード）
     *
     * @param sakujoJiyuCode 削除事由コード
     */
    public void setSakujoJiyuCode(Code sakujoJiyuCode) {
        this.sakujoJiyuCode = sakujoJiyuCode;
    }

    /**
     * 要支援者認定申請区分のgetメソッドです。
     * <br/>
     * <br/>True:要支援者の要介護認定申請、False:それ以外
     *
     * @return 要支援者認定申請区分
     */
    @CheckForNull
    public boolean getYoshienshaNinteiShinseiFlag() {
        return yoshienshaNinteiShinseiFlag;
    }

    /**
     * 要支援者認定申請区分のsetメソッドです。
     * <br/>
     * <br/>True:要支援者の要介護認定申請、False:それ以外
     *
     * @param yoshienshaNinteiShinseiFlag 要支援者認定申請区分
     */
    public void setYoshienshaNinteiShinseiFlag(boolean yoshienshaNinteiShinseiFlag) {
        this.yoshienshaNinteiShinseiFlag = yoshienshaNinteiShinseiFlag;
    }

    /**
     * 支給限度単位数のgetメソッドです。
     *
     * @return 支給限度単位数
     */
    @CheckForNull
    public Decimal getShikyuGendoTanisu() {
        return shikyuGendoTanisu;
    }

    /**
     * 支給限度単位数のsetメソッドです。
     *
     * @param shikyuGendoTanisu 支給限度単位数
     */
    public void setShikyuGendoTanisu(Decimal shikyuGendoTanisu) {
        this.shikyuGendoTanisu = shikyuGendoTanisu;
    }

    /**
     * 支給限度有効開始年月日のgetメソッドです。
     *
     * @return 支給限度有効開始年月日
     */
    @CheckForNull
    public FlexibleDate getShikyuGendoKaishiYMD() {
        return shikyuGendoKaishiYMD;
    }

    /**
     * 支給限度有効開始年月日のsetメソッドです。
     *
     * @param shikyuGendoKaishiYMD 支給限度有効開始年月日
     */
    public void setShikyuGendoKaishiYMD(FlexibleDate shikyuGendoKaishiYMD) {
        this.shikyuGendoKaishiYMD = shikyuGendoKaishiYMD;
    }

    /**
     * 支給限度有効終了年月日のgetメソッドです。
     *
     * @return 支給限度有効終了年月日
     */
    @CheckForNull
    public FlexibleDate getShikyuGendoShuryoYMD() {
        return shikyuGendoShuryoYMD;
    }

    /**
     * 支給限度有効終了年月日のsetメソッドです。
     *
     * @param shikyuGendoShuryoYMD 支給限度有効終了年月日
     */
    public void setShikyuGendoShuryoYMD(FlexibleDate shikyuGendoShuryoYMD) {
        this.shikyuGendoShuryoYMD = shikyuGendoShuryoYMD;
    }

    /**
     * 短期入所支給限度日数のgetメソッドです。
     *
     * @return 短期入所支給限度日数
     */
    @CheckForNull
    public int getTankiSikyuGendoNissu() {
        return tankiSikyuGendoNissu;
    }

    /**
     * 短期入所支給限度日数のsetメソッドです。
     *
     * @param tankiSikyuGendoNissu 短期入所支給限度日数
     */
    public void setTankiSikyuGendoNissu(int tankiSikyuGendoNissu) {
        this.tankiSikyuGendoNissu = tankiSikyuGendoNissu;
    }

    /**
     * 短期入所支給限度開始年月日のgetメソッドです。
     *
     * @return 短期入所支給限度開始年月日
     */
    @CheckForNull
    public FlexibleDate getTankiShikyuGendoKaishiYMD() {
        return tankiShikyuGendoKaishiYMD;
    }

    /**
     * 短期入所支給限度開始年月日のsetメソッドです。
     *
     * @param tankiShikyuGendoKaishiYMD 短期入所支給限度開始年月日
     */
    public void setTankiShikyuGendoKaishiYMD(FlexibleDate tankiShikyuGendoKaishiYMD) {
        this.tankiShikyuGendoKaishiYMD = tankiShikyuGendoKaishiYMD;
    }

    /**
     * 短期入所支給限度終了年月日のgetメソッドです。
     *
     * @return 短期入所支給限度終了年月日
     */
    @CheckForNull
    public FlexibleDate getTankiShikyuGendoShuryoYMD() {
        return tankiShikyuGendoShuryoYMD;
    }

    /**
     * 短期入所支給限度終了年月日のsetメソッドです。
     *
     * @param tankiShikyuGendoShuryoYMD 短期入所支給限度終了年月日
     */
    public void setTankiShikyuGendoShuryoYMD(FlexibleDate tankiShikyuGendoShuryoYMD) {
        this.tankiShikyuGendoShuryoYMD = tankiShikyuGendoShuryoYMD;
    }

    /**
     * 当初認定有効開始年月日のgetメソッドです。
     *
     * @return 当初認定有効開始年月日
     */
    @CheckForNull
    public FlexibleDate getToshoNinteiYukoKaishiYMD() {
        return toshoNinteiYukoKaishiYMD;
    }

    /**
     * 当初認定有効開始年月日のsetメソッドです。
     *
     * @param toshoNinteiYukoKaishiYMD 当初認定有効開始年月日
     */
    public void setToshoNinteiYukoKaishiYMD(FlexibleDate toshoNinteiYukoKaishiYMD) {
        this.toshoNinteiYukoKaishiYMD = toshoNinteiYukoKaishiYMD;
    }

    /**
     * 当初認定有効終了年月日のgetメソッドです。
     *
     * @return 当初認定有効終了年月日
     */
    @CheckForNull
    public FlexibleDate getToshoNinteiYukoShuryoYMD() {
        return toshoNinteiYukoShuryoYMD;
    }

    /**
     * 当初認定有効終了年月日のsetメソッドです。
     *
     * @param toshoNinteiYukoShuryoYMD 当初認定有効終了年月日
     */
    public void setToshoNinteiYukoShuryoYMD(FlexibleDate toshoNinteiYukoShuryoYMD) {
        this.toshoNinteiYukoShuryoYMD = toshoNinteiYukoShuryoYMD;
    }

    /**
     * 受給資格証明書発行年月日１のgetメソッドです。
     *
     * @return 受給資格証明書発行年月日１
     */
    @CheckForNull
    public FlexibleDate getJukyuShikakuShomeishoHakkoYMD1() {
        return jukyuShikakuShomeishoHakkoYMD1;
    }

    /**
     * 受給資格証明書発行年月日１のsetメソッドです。
     *
     * @param jukyuShikakuShomeishoHakkoYMD1 受給資格証明書発行年月日１
     */
    public void setJukyuShikakuShomeishoHakkoYMD1(FlexibleDate jukyuShikakuShomeishoHakkoYMD1) {
        this.jukyuShikakuShomeishoHakkoYMD1 = jukyuShikakuShomeishoHakkoYMD1;
    }

    /**
     * 受給資格証明書発行年月日２のgetメソッドです。
     *
     * @return 受給資格証明書発行年月日２
     */
    @CheckForNull
    public FlexibleDate getJukyuShikakuShomeishoHakkoYMD2() {
        return jukyuShikakuShomeishoHakkoYMD2;
    }

    /**
     * 受給資格証明書発行年月日２のsetメソッドです。
     *
     * @param jukyuShikakuShomeishoHakkoYMD2 受給資格証明書発行年月日２
     */
    public void setJukyuShikakuShomeishoHakkoYMD2(FlexibleDate jukyuShikakuShomeishoHakkoYMD2) {
        this.jukyuShikakuShomeishoHakkoYMD2 = jukyuShikakuShomeishoHakkoYMD2;
    }

    /**
     * 診断命令書発行年月日のgetメソッドです。
     *
     * @return 診断命令書発行年月日
     */
    @CheckForNull
    public FlexibleDate getShindanMeireishoHakkoYMD() {
        return shindanMeireishoHakkoYMD;
    }

    /**
     * 診断命令書発行年月日のsetメソッドです。
     *
     * @param shindanMeireishoHakkoYMD 診断命令書発行年月日
     */
    public void setShindanMeireishoHakkoYMD(FlexibleDate shindanMeireishoHakkoYMD) {
        this.shindanMeireishoHakkoYMD = shindanMeireishoHakkoYMD;
    }

    /**
     * ２号申請受理通知書発行年月日のgetメソッドです。
     *
     * @return ２号申請受理通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getNigoShinseiJuriTsuchishoHakkoYMD() {
        return nigoShinseiJuriTsuchishoHakkoYMD;
    }

    /**
     * ２号申請受理通知書発行年月日のsetメソッドです。
     *
     * @param nigoShinseiJuriTsuchishoHakkoYMD ２号申請受理通知書発行年月日
     */
    public void setNigoShinseiJuriTsuchishoHakkoYMD(FlexibleDate nigoShinseiJuriTsuchishoHakkoYMD) {
        this.nigoShinseiJuriTsuchishoHakkoYMD = nigoShinseiJuriTsuchishoHakkoYMD;
    }

    /**
     * 認定結果通知書発行年月日のgetメソッドです。
     *
     * @return 認定結果通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiKekkaTsuchishoHakkoYMD() {
        return ninteiKekkaTsuchishoHakkoYMD;
    }

    /**
     * 認定結果通知書発行年月日のsetメソッドです。
     *
     * @param ninteiKekkaTsuchishoHakkoYMD 認定結果通知書発行年月日
     */
    public void setNinteiKekkaTsuchishoHakkoYMD(FlexibleDate ninteiKekkaTsuchishoHakkoYMD) {
        this.ninteiKekkaTsuchishoHakkoYMD = ninteiKekkaTsuchishoHakkoYMD;
    }

    /**
     * 区分変更通知書発行年月日のgetメソッドです。
     *
     * @return 区分変更通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getKubunHenkoTsuchishoHakkoYMD() {
        return kubunHenkoTsuchishoHakkoYMD;
    }

    /**
     * 区分変更通知書発行年月日のsetメソッドです。
     *
     * @param kubunHenkoTsuchishoHakkoYMD 区分変更通知書発行年月日
     */
    public void setKubunHenkoTsuchishoHakkoYMD(FlexibleDate kubunHenkoTsuchishoHakkoYMD) {
        this.kubunHenkoTsuchishoHakkoYMD = kubunHenkoTsuchishoHakkoYMD;
    }

    /**
     * サービス変更通知書発行年月日のgetメソッドです。
     *
     * @return サービス変更通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getServiceHenkoTsuchishoHakkoYMD() {
        return serviceHenkoTsuchishoHakkoYMD;
    }

    /**
     * サービス変更通知書発行年月日のsetメソッドです。
     *
     * @param serviceHenkoTsuchishoHakkoYMD サービス変更通知書発行年月日
     */
    public void setServiceHenkoTsuchishoHakkoYMD(FlexibleDate serviceHenkoTsuchishoHakkoYMD) {
        this.serviceHenkoTsuchishoHakkoYMD = serviceHenkoTsuchishoHakkoYMD;
    }

    /**
     * 認定却下通知書発行年月日のgetメソッドです。
     *
     * @return 認定却下通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiKyakkaTsuchishoHakkoYMD() {
        return ninteiKyakkaTsuchishoHakkoYMD;
    }

    /**
     * 認定却下通知書発行年月日のsetメソッドです。
     *
     * @param ninteiKyakkaTsuchishoHakkoYMD 認定却下通知書発行年月日
     */
    public void setNinteiKyakkaTsuchishoHakkoYMD(FlexibleDate ninteiKyakkaTsuchishoHakkoYMD) {
        this.ninteiKyakkaTsuchishoHakkoYMD = ninteiKyakkaTsuchishoHakkoYMD;
    }

    /**
     * 認定取消通知書発行年月日のgetメソッドです。
     *
     * @return 認定取消通知書発行年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiTorikeshiTsuchishoHakkoYMD() {
        return ninteiTorikeshiTsuchishoHakkoYMD;
    }

    /**
     * 認定取消通知書発行年月日のsetメソッドです。
     *
     * @param ninteiTorikeshiTsuchishoHakkoYMD 認定取消通知書発行年月日
     */
    public void setNinteiTorikeshiTsuchishoHakkoYMD(FlexibleDate ninteiTorikeshiTsuchishoHakkoYMD) {
        this.ninteiTorikeshiTsuchishoHakkoYMD = ninteiTorikeshiTsuchishoHakkoYMD;
    }

    /**
     * 資格取得前申請フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：資格取得前申請区分）
     *
     * @return 資格取得前申請フラグ
     */
    @CheckForNull
    public boolean getShikakuShutokuMaeShinseiFlag() {
        return shikakuShutokuMaeShinseiFlag;
    }

    /**
     * 資格取得前申請フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：資格取得前申請区分）
     *
     * @param shikakuShutokuMaeShinseiFlag 資格取得前申請フラグ
     */
    public void setShikakuShutokuMaeShinseiFlag(boolean shikakuShutokuMaeShinseiFlag) {
        this.shikakuShutokuMaeShinseiFlag = shikakuShutokuMaeShinseiFlag;
    }

    /**
     * 旧措置者フラグのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：旧措置適用フラグ）
     *
     * @return 旧措置者フラグ
     */
    @CheckForNull
    public boolean getKyuSochishaFlag() {
        return kyuSochishaFlag;
    }

    /**
     * 旧措置者フラグのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：旧措置適用フラグ）
     *
     * @param kyuSochishaFlag 旧措置者フラグ
     */
    public void setKyuSochishaFlag(boolean kyuSochishaFlag) {
        this.kyuSochishaFlag = kyuSochishaFlag;
    }

    /**
     * 論理削除フラグのgetメソッドです。
     * <br/>
     * <br/>True：論理削除　False：未削除
     *
     * @return 論理削除フラグ
     */
    @CheckForNull
    public boolean getLogicalDeletedFlag() {
        return logicalDeletedFlag;
    }

    /**
     * 論理削除フラグのsetメソッドです。
     * <br/>
     * <br/>True：論理削除　False：未削除
     *
     * @param logicalDeletedFlag 論理削除フラグ
     */
    public void setLogicalDeletedFlag(boolean logicalDeletedFlag) {
        this.logicalDeletedFlag = logicalDeletedFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4001JukyushaDaichoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT4001JukyushaDaichoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4001JukyushaDaichoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.rirekiNo, other.rirekiNo)) {
            return false;
        }
        if (!Objects.equals(this.edaban, other.edaban)) {
            return false;
        }
        if (!Objects.equals(this.jukyuShinseiJiyu, other.jukyuShinseiJiyu)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4001JukyushaDaichoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.edaban = entity.edaban;
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.shinseiJokyoKubun = entity.shinseiJokyoKubun;
        this.shishoCode = entity.shishoCode;
        this.chokkinFlag = entity.chokkinFlag;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.jukyuShinseiJiyu = entity.jukyuShinseiJiyu;
        this.shinseiRiyu = entity.shinseiRiyu;
        this.shinseishaKankeiCode = entity.shinseishaKankeiCode;
        this.homninKankei = entity.homninKankei;
        this.jukyuShinseiYMD = entity.jukyuShinseiYMD;
        this.nigoTokuteiShippeiCode = entity.nigoTokuteiShippeiCode;
        this.shinsakaiIraiYMD = entity.shinsakaiIraiYMD;
        this.yokaigoJotaiKubunCode = entity.yokaigoJotaiKubunCode;
        this.ninteiYukoKikanKaishiYMD = entity.ninteiYukoKikanKaishiYMD;
        this.ninteiYukoKikanShuryoYMD = entity.ninteiYukoKikanShuryoYMD;
        this.ninteiYMD = entity.ninteiYMD;
        this.minashiCode = entity.minashiCode;
        this.shiteiServiceShurui01 = entity.shiteiServiceShurui01;
        this.shiteiServiceShurui02 = entity.shiteiServiceShurui02;
        this.shiteiServiceShurui03 = entity.shiteiServiceShurui03;
        this.shiteiServiceShurui04 = entity.shiteiServiceShurui04;
        this.shiteiServiceShurui05 = entity.shiteiServiceShurui05;
        this.shiteiServiceShurui06 = entity.shiteiServiceShurui06;
        this.shiteiServiceShurui07 = entity.shiteiServiceShurui07;
        this.shiteiServiceShurui08 = entity.shiteiServiceShurui08;
        this.shiteiServiceShurui09 = entity.shiteiServiceShurui09;
        this.shiteiServiceShurui10 = entity.shiteiServiceShurui10;
        this.shiteiServiceShurui11 = entity.shiteiServiceShurui11;
        this.shiteiServiceShurui12 = entity.shiteiServiceShurui12;
        this.shiteiServiceShurui13 = entity.shiteiServiceShurui13;
        this.shiteiServiceShurui14 = entity.shiteiServiceShurui14;
        this.shiteiServiceShurui15 = entity.shiteiServiceShurui15;
        this.shiteiServiceShurui16 = entity.shiteiServiceShurui16;
        this.shiteiServiceShurui17 = entity.shiteiServiceShurui17;
        this.shiteiServiceShurui18 = entity.shiteiServiceShurui18;
        this.shiteiServiceShurui19 = entity.shiteiServiceShurui19;
        this.shiteiServiceShurui20 = entity.shiteiServiceShurui20;
        this.shiteiServiceShurui21 = entity.shiteiServiceShurui21;
        this.shiteiServiceShurui22 = entity.shiteiServiceShurui22;
        this.shiteiServiceShurui23 = entity.shiteiServiceShurui23;
        this.shiteiServiceShurui24 = entity.shiteiServiceShurui24;
        this.shiteiServiceShurui25 = entity.shiteiServiceShurui25;
        this.shiteiServiceShurui26 = entity.shiteiServiceShurui26;
        this.shiteiServiceShurui27 = entity.shiteiServiceShurui27;
        this.shiteiServiceShurui28 = entity.shiteiServiceShurui28;
        this.shiteiServiceShurui29 = entity.shiteiServiceShurui29;
        this.shiteiServiceShurui30 = entity.shiteiServiceShurui30;
        this.soshitsuYMD = entity.soshitsuYMD;
        this.chokkinIdoYMD = entity.chokkinIdoYMD;
        this.chokkinIdoJiyuCode = entity.chokkinIdoJiyuCode;
        this.yukoMukoKubun = entity.yukoMukoKubun;
        this.dataKubun = entity.dataKubun;
        this.remban = entity.remban;
        this.idoRiyu = entity.idoRiyu;
        this.shinseishoKubun = entity.shinseishoKubun;
        this.sakujoJiyuCode = entity.sakujoJiyuCode;
        this.yoshienshaNinteiShinseiFlag = entity.yoshienshaNinteiShinseiFlag;
        this.shikyuGendoTanisu = entity.shikyuGendoTanisu;
        this.shikyuGendoKaishiYMD = entity.shikyuGendoKaishiYMD;
        this.shikyuGendoShuryoYMD = entity.shikyuGendoShuryoYMD;
        this.tankiSikyuGendoNissu = entity.tankiSikyuGendoNissu;
        this.tankiShikyuGendoKaishiYMD = entity.tankiShikyuGendoKaishiYMD;
        this.tankiShikyuGendoShuryoYMD = entity.tankiShikyuGendoShuryoYMD;
        this.toshoNinteiYukoKaishiYMD = entity.toshoNinteiYukoKaishiYMD;
        this.toshoNinteiYukoShuryoYMD = entity.toshoNinteiYukoShuryoYMD;
        this.jukyuShikakuShomeishoHakkoYMD1 = entity.jukyuShikakuShomeishoHakkoYMD1;
        this.jukyuShikakuShomeishoHakkoYMD2 = entity.jukyuShikakuShomeishoHakkoYMD2;
        this.shindanMeireishoHakkoYMD = entity.shindanMeireishoHakkoYMD;
        this.nigoShinseiJuriTsuchishoHakkoYMD = entity.nigoShinseiJuriTsuchishoHakkoYMD;
        this.ninteiKekkaTsuchishoHakkoYMD = entity.ninteiKekkaTsuchishoHakkoYMD;
        this.kubunHenkoTsuchishoHakkoYMD = entity.kubunHenkoTsuchishoHakkoYMD;
        this.serviceHenkoTsuchishoHakkoYMD = entity.serviceHenkoTsuchishoHakkoYMD;
        this.ninteiKyakkaTsuchishoHakkoYMD = entity.ninteiKyakkaTsuchishoHakkoYMD;
        this.ninteiTorikeshiTsuchishoHakkoYMD = entity.ninteiTorikeshiTsuchishoHakkoYMD;
        this.shikakuShutokuMaeShinseiFlag = entity.shikakuShutokuMaeShinseiFlag;
        this.kyuSochishaFlag = entity.kyuSochishaFlag;
        this.logicalDeletedFlag = entity.logicalDeletedFlag;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, hihokenshaNo, rirekiNo, edaban, shinseishoKanriNo, shinseiJokyoKubun, shishoCode, chokkinFlag, shikibetsuCode, jukyuShinseiJiyu, shinseiRiyu, shinseishaKankeiCode, homninKankei, jukyuShinseiYMD, nigoTokuteiShippeiCode, shinsakaiIraiYMD, yokaigoJotaiKubunCode, ninteiYukoKikanKaishiYMD, ninteiYukoKikanShuryoYMD, ninteiYMD, minashiCode, shiteiServiceShurui01, shiteiServiceShurui02, shiteiServiceShurui03, shiteiServiceShurui04, shiteiServiceShurui05, shiteiServiceShurui06, shiteiServiceShurui07, shiteiServiceShurui08, shiteiServiceShurui09, shiteiServiceShurui10, shiteiServiceShurui11, shiteiServiceShurui12, shiteiServiceShurui13, shiteiServiceShurui14, shiteiServiceShurui15, shiteiServiceShurui16, shiteiServiceShurui17, shiteiServiceShurui18, shiteiServiceShurui19, shiteiServiceShurui20, shiteiServiceShurui21, shiteiServiceShurui22, shiteiServiceShurui23, shiteiServiceShurui24, shiteiServiceShurui25, shiteiServiceShurui26, shiteiServiceShurui27, shiteiServiceShurui28, shiteiServiceShurui29, shiteiServiceShurui30, soshitsuYMD, chokkinIdoYMD, chokkinIdoJiyuCode, yukoMukoKubun, dataKubun, remban, idoRiyu, shinseishoKubun, sakujoJiyuCode, yoshienshaNinteiShinseiFlag, shikyuGendoTanisu, shikyuGendoKaishiYMD, shikyuGendoShuryoYMD, tankiSikyuGendoNissu, tankiShikyuGendoKaishiYMD, tankiShikyuGendoShuryoYMD, toshoNinteiYukoKaishiYMD, toshoNinteiYukoShuryoYMD, jukyuShikakuShomeishoHakkoYMD1, jukyuShikakuShomeishoHakkoYMD2, shindanMeireishoHakkoYMD, nigoShinseiJuriTsuchishoHakkoYMD, ninteiKekkaTsuchishoHakkoYMD, kubunHenkoTsuchishoHakkoYMD, serviceHenkoTsuchishoHakkoYMD, ninteiKyakkaTsuchishoHakkoYMD, ninteiTorikeshiTsuchishoHakkoYMD, shikakuShutokuMaeShinseiFlag, kyuSochishaFlag, logicalDeletedFlag);
    }

// </editor-fold>
    /**
     * @return the lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * @param lastUpdateTimestamp the lastUpdateTimestamp to set
     */
    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    /**
     * @return the insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * @param insertTimestamp the insertTimestamp to set
     */
    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }
}
