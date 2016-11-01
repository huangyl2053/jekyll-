package jp.co.ndensan.reams.db.dbc.entity.db.relate.kaishuriyushoshikyuketteitsuchisho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;

/**
 * 請求明細一時テーブルのエンティティクラスです。
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity extends
        DbTableEntityBase<DbWT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> implements IDbAccessable {

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
    private boolean shukeiFlag;

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
    public void setRirekiNo(int rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
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
     * 集計フラグのgetメソッドです。
     * <br/>
     * <br/>True：集計済み、False：集計未
     *
     * @return 集計フラグ
     */
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
}
