package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 住宅改修理由書作成手数料請求明細テーブルのエンティティクラスです。
 */
public class DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity extends DbTableEntityBase<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT3095JutakuKaishuRiyushoTesuryoMeisai");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private HokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private HihokenshaNo hihokenshaNo;
    @PrimaryKey
    private int rirekiNo;
    private ShikibetsuCode shikibetsuCode;
    private ServiceCode serviceCode;
    private AtenaMeisho jutakuKaishuJigyoshaMeisho;
    private FlexibleDate jutakuKaishuChakkoYMD;
    private AtenaMeisho jutakuKaishuJushoShozaisha;
    private RString kaishuTaishoJutakuJusho;
    private RString kaishuNaiyo_kasho_Kibo;
    private FlexibleDate riyushoSakuseiYMD;
    private JigyoshaNo riyushoSakuseiJigyoshaNo;
    private AtenaMeisho riyushoSakuseishaMei;
    private RString riyushoSakuseishaMeiKana;
    private FlexibleDate riyushoSakuseiShinseiYMD;
    private FlexibleDate riyushoSakuseiUketsukeYMD;
    private RString shukeiNo;
    private boolean TaishogaiFlag;
    private boolean shukeiFlag;

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
    public HokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     * 
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(@Nonnull HokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    @CheckForNull
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * サービスコードのgetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.サービスコード
     * 
     * @return サービスコード
     */
    @CheckForNull
    public ServiceCode getServiceCode() {
        return serviceCode;
    }

    /**
     * サービスコードのsetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.サービスコード
     * 
     * @param serviceCode サービスコード
     */
    public void setServiceCode(ServiceCode serviceCode) {
        this.serviceCode = serviceCode;
    }

    /**
     * 介護住宅改修事業者名称のgetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修事業者名
     * 
     * @return 介護住宅改修事業者名称
     */
    @CheckForNull
    public AtenaMeisho getJutakuKaishuJigyoshaMeisho() {
        return jutakuKaishuJigyoshaMeisho;
    }

    /**
     * 介護住宅改修事業者名称のsetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修事業者名
     * 
     * @param jutakuKaishuJigyoshaMeisho 介護住宅改修事業者名称
     */
    public void setJutakuKaishuJigyoshaMeisho(AtenaMeisho jutakuKaishuJigyoshaMeisho) {
        this.jutakuKaishuJigyoshaMeisho = jutakuKaishuJigyoshaMeisho;
    }

    /**
     * 介護住宅改修着工年月日のgetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修着工年月日
     * 
     * @return 介護住宅改修着工年月日
     */
    @CheckForNull
    public FlexibleDate getJutakuKaishuChakkoYMD() {
        return jutakuKaishuChakkoYMD;
    }

    /**
     * 介護住宅改修着工年月日のsetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修着工年月日
     * 
     * @param jutakuKaishuChakkoYMD 介護住宅改修着工年月日
     */
    public void setJutakuKaishuChakkoYMD(FlexibleDate jutakuKaishuChakkoYMD) {
        this.jutakuKaishuChakkoYMD = jutakuKaishuChakkoYMD;
    }

    /**
     * 介護住宅改修住宅所有者のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 住宅所有者
     * 
     * @return 介護住宅改修住宅所有者
     */
    @CheckForNull
    public AtenaMeisho getJutakuKaishuJushoShozaisha() {
        return jutakuKaishuJushoShozaisha;
    }

    /**
     * 介護住宅改修住宅所有者のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 住宅所有者
     * 
     * @param jutakuKaishuJushoShozaisha 介護住宅改修住宅所有者
     */
    public void setJutakuKaishuJushoShozaisha(AtenaMeisho jutakuKaishuJushoShozaisha) {
        this.jutakuKaishuJushoShozaisha = jutakuKaishuJushoShozaisha;
    }

    /**
     * 改修対象住宅住所のgetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修住宅住所
     * 
     * @return 改修対象住宅住所
     */
    @CheckForNull
    public RString getKaishuTaishoJutakuJusho() {
        return kaishuTaishoJutakuJusho;
    }

    /**
     * 改修対象住宅住所のsetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修住宅住所
     * 
     * @param kaishuTaishoJutakuJusho 改修対象住宅住所
     */
    public void setKaishuTaishoJutakuJusho(RString kaishuTaishoJutakuJusho) {
        this.kaishuTaishoJutakuJusho = kaishuTaishoJutakuJusho;
    }

    /**
     * 改修内容・箇所及び規模のgetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修内容
     * 
     * @return 改修内容・箇所及び規模
     */
    @CheckForNull
    public RString getKaishuNaiyo_kasho_Kibo() {
        return kaishuNaiyo_kasho_Kibo;
    }

    /**
     * 改修内容・箇所及び規模のsetメソッドです。
     * <br/>
     * <br/>償還払請求住宅改修TBL.住宅改修内容
     * 
     * @param kaishuNaiyo_kasho_Kibo 改修内容・箇所及び規模
     */
    public void setKaishuNaiyo_kasho_Kibo(RString kaishuNaiyo_kasho_Kibo) {
        this.kaishuNaiyo_kasho_Kibo = kaishuNaiyo_kasho_Kibo;
    }

    /**
     * 介護住宅改修理由書作成年月日のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成日
     * 
     * @return 介護住宅改修理由書作成年月日
     */
    @CheckForNull
    public FlexibleDate getRiyushoSakuseiYMD() {
        return riyushoSakuseiYMD;
    }

    /**
     * 介護住宅改修理由書作成年月日のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成日
     * 
     * @param riyushoSakuseiYMD 介護住宅改修理由書作成年月日
     */
    public void setRiyushoSakuseiYMD(FlexibleDate riyushoSakuseiYMD) {
        this.riyushoSakuseiYMD = riyushoSakuseiYMD;
    }

    /**
     * 介護住宅改修理由書作成事業者番号のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成事業者番号
     * 
     * @return 介護住宅改修理由書作成事業者番号
     */
    @CheckForNull
    public JigyoshaNo getRiyushoSakuseiJigyoshaNo() {
        return riyushoSakuseiJigyoshaNo;
    }

    /**
     * 介護住宅改修理由書作成事業者番号のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成事業者番号
     * 
     * @param riyushoSakuseiJigyoshaNo 介護住宅改修理由書作成事業者番号
     */
    public void setRiyushoSakuseiJigyoshaNo(JigyoshaNo riyushoSakuseiJigyoshaNo) {
        this.riyushoSakuseiJigyoshaNo = riyushoSakuseiJigyoshaNo;
    }

    /**
     * 介護住宅改修理由書作成者名のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成者
     * 
     * @return 介護住宅改修理由書作成者名
     */
    @CheckForNull
    public AtenaMeisho getRiyushoSakuseishaMei() {
        return riyushoSakuseishaMei;
    }

    /**
     * 介護住宅改修理由書作成者名のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成者
     * 
     * @param riyushoSakuseishaMei 介護住宅改修理由書作成者名
     */
    public void setRiyushoSakuseishaMei(AtenaMeisho riyushoSakuseishaMei) {
        this.riyushoSakuseishaMei = riyushoSakuseishaMei;
    }

    /**
     * 介護住宅改修理由書作成者名カナのgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成者カナ
     * 
     * @return 介護住宅改修理由書作成者名カナ
     */
    @CheckForNull
    public RString getRiyushoSakuseishaMeiKana() {
        return riyushoSakuseishaMeiKana;
    }

    /**
     * 介護住宅改修理由書作成者名カナのsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL. 理由書作成者カナ
     * 
     * @param riyushoSakuseishaMeiKana 介護住宅改修理由書作成者名カナ
     */
    public void setRiyushoSakuseishaMeiKana(RString riyushoSakuseishaMeiKana) {
        this.riyushoSakuseishaMeiKana = riyushoSakuseishaMeiKana;
    }

    /**
     * 介護住宅改修理由書作成申請年月日のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL.申請年月日
     * 
     * @return 介護住宅改修理由書作成申請年月日
     */
    @CheckForNull
    public FlexibleDate getRiyushoSakuseiShinseiYMD() {
        return riyushoSakuseiShinseiYMD;
    }

    /**
     * 介護住宅改修理由書作成申請年月日のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL.申請年月日
     * 
     * @param riyushoSakuseiShinseiYMD 介護住宅改修理由書作成申請年月日
     */
    public void setRiyushoSakuseiShinseiYMD(FlexibleDate riyushoSakuseiShinseiYMD) {
        this.riyushoSakuseiShinseiYMD = riyushoSakuseiShinseiYMD;
    }

    /**
     * 介護住宅改修理由書作成受付年月日のgetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL.受付年月日
     * 
     * @return 介護住宅改修理由書作成受付年月日
     */
    @CheckForNull
    public FlexibleDate getRiyushoSakuseiUketsukeYMD() {
        return riyushoSakuseiUketsukeYMD;
    }

    /**
     * 介護住宅改修理由書作成受付年月日のsetメソッドです。
     * <br/>
     * <br/>償還払支給申請TBL.受付年月日
     * 
     * @param riyushoSakuseiUketsukeYMD 介護住宅改修理由書作成受付年月日
     */
    public void setRiyushoSakuseiUketsukeYMD(FlexibleDate riyushoSakuseiUketsukeYMD) {
        this.riyushoSakuseiUketsukeYMD = riyushoSakuseiUketsukeYMD;
    }

    /**
     * 集計関連付け番号のgetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @return 集計関連付け番号
     */
    @CheckForNull
    public RString getShukeiNo() {
        return shukeiNo;
    }

    /**
     * 集計関連付け番号のsetメソッドです。
     * <br/>
     * <br/>連番
     * 
     * @param shukeiNo 集計関連付け番号
     */
    public void setShukeiNo(RString shukeiNo) {
        this.shukeiNo = shukeiNo;
    }

    /**
     * 対象外フラグのgetメソッドです。
     * <br/>
     * <br/>True：対象外、False：対象
     * 
     * @return 対象外フラグ
     */
    @CheckForNull
    public boolean getTaishogaiFlag() {
        return TaishogaiFlag;
    }

    /**
     * 対象外フラグのsetメソッドです。
     * <br/>
     * <br/>True：対象外、False：対象
     * 
     * @param TaishogaiFlag 対象外フラグ
     */
    public void setTaishogaiFlag(boolean TaishogaiFlag) {
        this.TaishogaiFlag = TaishogaiFlag;
    }

    /**
     * 集計フラグのgetメソッドです。
     * <br/>
     * <br/>True：集計済み、False：集計未
     * 
     * @return 集計フラグ
     */
    @CheckForNull
    public boolean getShukeiFlag() {
        return shukeiFlag;
    }

    /**
     * 集計フラグのsetメソッドです。
     * <br/>
     * <br/>True：集計済み、False：集計未
     * 
     * @param shukeiFlag 集計フラグ
     */
    public void setShukeiFlag(boolean shukeiFlag) {
        this.shukeiFlag = shukeiFlag;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
            return false;
        }
        if (!Objects.equals(this.hihokenshaNo, other.hihokenshaNo)) {
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
    public void shallowCopy(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.serviceCode = entity.serviceCode;
        this.jutakuKaishuJigyoshaMeisho = entity.jutakuKaishuJigyoshaMeisho;
        this.jutakuKaishuChakkoYMD = entity.jutakuKaishuChakkoYMD;
        this.jutakuKaishuJushoShozaisha = entity.jutakuKaishuJushoShozaisha;
        this.kaishuTaishoJutakuJusho = entity.kaishuTaishoJutakuJusho;
        this.kaishuNaiyo_kasho_Kibo = entity.kaishuNaiyo_kasho_Kibo;
        this.riyushoSakuseiYMD = entity.riyushoSakuseiYMD;
        this.riyushoSakuseiJigyoshaNo = entity.riyushoSakuseiJigyoshaNo;
        this.riyushoSakuseishaMei = entity.riyushoSakuseishaMei;
        this.riyushoSakuseishaMeiKana = entity.riyushoSakuseishaMeiKana;
        this.riyushoSakuseiShinseiYMD = entity.riyushoSakuseiShinseiYMD;
        this.riyushoSakuseiUketsukeYMD = entity.riyushoSakuseiUketsukeYMD;
        this.shukeiNo = entity.shukeiNo;
        this.TaishogaiFlag = entity.TaishogaiFlag;
        this.shukeiFlag = entity.shukeiFlag;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, hihokenshaNo, rirekiNo, shikibetsuCode, serviceCode, jutakuKaishuJigyoshaMeisho, jutakuKaishuChakkoYMD, jutakuKaishuJushoShozaisha, kaishuTaishoJutakuJusho, kaishuNaiyo_kasho_Kibo, riyushoSakuseiYMD, riyushoSakuseiJigyoshaNo, riyushoSakuseishaMei, riyushoSakuseishaMeiKana, riyushoSakuseiShinseiYMD, riyushoSakuseiUketsukeYMD, shukeiNo, TaishogaiFlag, shukeiFlag);
    }

// </editor-fold>


}
