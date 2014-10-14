package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.DbeShubetsuKey;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.JigyoshaNo;

/**
 * DbT5102ShinsakaiIinJohoの項目定義クラスです
 *
 * @author n8178 城間篤人
 */
public class DbT5102ShinsakaiIinJohoEntity implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5102ShinsakaiIinJoho");
    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shinsakaiIinCode;
    private FlexibleDate shinsakaiIinKaishiYMD;
    private FlexibleDate shinsakaiIinShuryoYMD;
    private boolean shinsakaiIinJokyo;
    private RString jigyoshaKubun;
    private JigyoshaNo jigyoshaNo;
    private AtenaMeisho shinsakaiIinShimei;
    private AtenaKanaMeisho ShinsakaiIinKanaShimei;
    private RString seibetsu;
    private Code shinsakaiIinShikakuCode;
    private RString shinsainYusoKubun;
    private YubinNo yubinNo;
    private AtenaJusho Jusho;
    private TelNo telNo;
    private KinyuKikanCode kinyuKikanCode;
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString KozaShubetsu;
    private RString KozaMeigi;
    private RString KozaMeigiKana;
    private RString KozaNo;

    /**
     * getInsertDantaiCd
     *
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     *
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     *
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     *
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * setLastUpdateReamsLoginId
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShinsakaiIinCode
     *
     * @return shinsakaiIinCode
     */
    public RString getShinsakaiIinCode() {
        return shinsakaiIinCode;
    }

    /**
     * setShinsakaiIinCode
     *
     * @param shinsakaiIinCode shinsakaiIinCode
     */
    public void setShinsakaiIinCode(RString shinsakaiIinCode) {
        this.shinsakaiIinCode = shinsakaiIinCode;
    }

    /**
     * getShinsakaiIinKaishiYMD
     *
     * @return shinsakaiIinKaishiYMD
     */
    public FlexibleDate getShinsakaiIinKaishiYMD() {
        return shinsakaiIinKaishiYMD;
    }

    /**
     * setShinsakaiIinKaishiYMD
     *
     * @param shinsakaiIinKaishiYMD shinsakaiIinKaishiYMD
     */
    public void setShinsakaiIinKaishiYMD(FlexibleDate shinsakaiIinKaishiYMD) {
        this.shinsakaiIinKaishiYMD = shinsakaiIinKaishiYMD;
    }

    /**
     * getShinsakaiIinShuryoYMD
     *
     * @return shinsakaiIinShuryoYMD
     */
    public FlexibleDate getShinsakaiIinShuryoYMD() {
        return shinsakaiIinShuryoYMD;
    }

    /**
     * setShinsakaiIinShuryoYMD
     *
     * @param shinsakaiIinShuryoYMD shinsakaiIinShuryoYMD
     */
    public void setShinsakaiIinShuryoYMD(FlexibleDate shinsakaiIinShuryoYMD) {
        this.shinsakaiIinShuryoYMD = shinsakaiIinShuryoYMD;
    }

    /**
     * getShinsakaiIinJokyo
     *
     * @return shinsakaiIinJokyo
     */
    public boolean getShinsakaiIinJokyo() {
        return shinsakaiIinJokyo;
    }

    /**
     * setShinsakaiIinJokyo
     *
     * @param shinsakaiIinJokyo shinsakaiIinJokyo
     */
    public void setShinsakaiIinJokyo(boolean shinsakaiIinJokyo) {
        this.shinsakaiIinJokyo = shinsakaiIinJokyo;
    }

    /**
     * getJigyoshaKubun
     *
     * @return jigyoshaKubun
     */
    public RString getJigyoshaKubun() {
        return jigyoshaKubun;
    }

    /**
     * setJigyoshaKubun
     *
     * @param jigyoshaKubun jigyoshaKubun
     */
    public void setJigyoshaKubun(RString jigyoshaKubun) {
        this.jigyoshaKubun = jigyoshaKubun;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getShinsakaiIinShimei
     *
     * @return shinsakaiIinShimei
     */
    public AtenaMeisho getShinsakaiIinShimei() {
        return shinsakaiIinShimei;
    }

    /**
     * setShinsakaiIinShimei
     *
     * @param shinsakaiIinShimei shinsakaiIinShimei
     */
    public void setShinsakaiIinShimei(AtenaMeisho shinsakaiIinShimei) {
        this.shinsakaiIinShimei = shinsakaiIinShimei;
    }

    /**
     * getShinsakaiIinKanaShimei
     *
     * @return ShinsakaiIinKanaShimei
     */
    public AtenaKanaMeisho getShinsakaiIinKanaShimei() {
        return ShinsakaiIinKanaShimei;
    }

    /**
     * setShinsakaiIinKanaShimei
     *
     * @param ShinsakaiIinKanaShimei ShinsakaiIinKanaShimei
     */
    public void setShinsakaiIinKanaShimei(AtenaKanaMeisho ShinsakaiIinKanaShimei) {
        this.ShinsakaiIinKanaShimei = ShinsakaiIinKanaShimei;
    }

    /**
     * getSeibetsu
     *
     * @return seibetsu
     */
    public RString getSeibetsu() {
        return seibetsu;
    }

    /**
     * setSeibetsu
     *
     * @param seibetsu seibetsu
     */
    public void setSeibetsu(RString seibetsu) {
        this.seibetsu = seibetsu;
    }

    /**
     * getShinsakaiIinShikakuCode
     *
     * @return shinsakaiIinShikakuCode
     */
    public Code getShinsakaiIinShikakuCode() {
        return shinsakaiIinShikakuCode;
    }

    /**
     * setShinsakaiIinShikakuCode
     *
     * @param shinsakaiIinShikakuCode shinsakaiIinShikakuCode
     */
    public void setShinsakaiIinShikakuCode(Code shinsakaiIinShikakuCode) {
        this.shinsakaiIinShikakuCode = shinsakaiIinShikakuCode;
    }

    /**
     * getShinsakaiIinShikakuCodeMeisho
     *
     * @return Meisho
     */
    public RString getShinsakaiIinShikakuCodeMeisho() {
        return RString.EMPTY;
        //TODO n8178 城間篤人 コードマスタから値が取得できなかったため一時的にコメントアウト 2014年9月
//        return CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.資格, shinsakaiIinShikakuCode);
    }

    /**
     * getShinsakaiIinShikakuCodeRyakusho
     *
     * @return Ryakusho
     */
    public RString getShinsakaiIinShikakuCodeRyakusho() {
        return RString.EMPTY;
        //TODO n8178 城間篤人 コードマスタから値が取得できなかったため一時的にコメントアウト 2014年9月
//        return CodeMaster.getCodeRyakusho(SubGyomuCode.DBE認定支援, DbeShubetsuKey.資格, shinsakaiIinShikakuCode);
    }

    /**
     * getShinsainYusoKubun
     *
     * @return shinsainYusoKubun
     */
    public RString getShinsainYusoKubun() {
        return shinsainYusoKubun;
    }

    /**
     * setShinsainYusoKubun
     *
     * @param shinsainYusoKubun shinsainYusoKubun
     */
    public void setShinsainYusoKubun(RString shinsainYusoKubun) {
        this.shinsainYusoKubun = shinsainYusoKubun;
    }

    /**
     * getYubinNo
     *
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     *
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJusho
     *
     * @return Jusho
     */
    public AtenaJusho getJusho() {
        return Jusho;
    }

    /**
     * setJusho
     *
     * @param Jusho Jusho
     */
    public void setJusho(AtenaJusho Jusho) {
        this.Jusho = Jusho;
    }

    /**
     * getTelNo
     *
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     *
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getKinyuKikanCode
     *
     * @return kinyuKikanCode
     */
    public KinyuKikanCode getKinyuKikanCode() {
        return kinyuKikanCode;
    }

    /**
     * setKinyuKikanCode
     *
     * @param kinyuKikanCode kinyuKikanCode
     */
    public void setKinyuKikanCode(KinyuKikanCode kinyuKikanCode) {
        this.kinyuKikanCode = kinyuKikanCode;
    }

    /**
     * getKinyuKikanShitenCode
     *
     * @return kinyuKikanShitenCode
     */
    public KinyuKikanShitenCode getKinyuKikanShitenCode() {
        return kinyuKikanShitenCode;
    }

    /**
     * setKinyuKikanShitenCode
     *
     * @param kinyuKikanShitenCode kinyuKikanShitenCode
     */
    public void setKinyuKikanShitenCode(KinyuKikanShitenCode kinyuKikanShitenCode) {
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
    }

    /**
     * getKozaShubetsu
     *
     * @return KozaShubetsu
     */
    public RString getKozaShubetsu() {
        return KozaShubetsu;
    }

    /**
     * setKozaShubetsu
     *
     * @param KozaShubetsu KozaShubetsu
     */
    public void setKozaShubetsu(RString KozaShubetsu) {
        this.KozaShubetsu = KozaShubetsu;
    }

    /**
     * getKozaMeigi
     *
     * @return KozaMeigi
     */
    public RString getKozaMeigi() {
        return KozaMeigi;
    }

    /**
     * setKozaMeigi
     *
     * @param KozaMeigi KozaMeigi
     */
    public void setKozaMeigi(RString KozaMeigi) {
        this.KozaMeigi = KozaMeigi;
    }

    /**
     * getKozaMeigiKana
     *
     * @return KozaMeigiKana
     */
    public RString getKozaMeigiKana() {
        return KozaMeigiKana;
    }

    /**
     * setKozaMeigiKana
     *
     * @param KozaMeigiKana KozaMeigiKana
     */
    public void setKozaMeigiKana(RString KozaMeigiKana) {
        this.KozaMeigiKana = KozaMeigiKana;
    }

    /**
     * getKozaNo
     *
     * @return KozaNo
     */
    public RString getKozaNo() {
        return KozaNo;
    }

    /**
     * setKozaNo
     *
     * @param KozaNo KozaNo
     */
    public void setKozaNo(RString KozaNo) {
        this.KozaNo = KozaNo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5102ShinsakaiIinJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5102ShinsakaiIinJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    public boolean equalsPrimaryKeys(DbT5102ShinsakaiIinJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinsakaiIinCode, other.shinsakaiIinCode)) {
            return false;
        }
        return true;
    }
// </editor-fold>
}
