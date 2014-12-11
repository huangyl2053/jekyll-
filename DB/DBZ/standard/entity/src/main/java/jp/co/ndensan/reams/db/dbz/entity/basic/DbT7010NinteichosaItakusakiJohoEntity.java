package jp.co.ndensan.reams.db.dbz.entity.basic;

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
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ChikuCode;
import java.util.Objects;

/**
 * DbT7010NinteichosaItakusakiJohoの項目定義クラスです
 *
 */
public class DbT7010NinteichosaItakusakiJohoEntity extends DbTableEntityBase<DbT7010NinteichosaItakusakiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7010NinteichosaItakusakiJoho");

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
    private RString kaigoJigyoshaNo;
    private RString jigyoshaNo;
    private RString kaigoJigyoshaJokyo;
    private RString jigyoshaMeisho;
    private RString jigyoshaMeishoKana;
    private YubinNo yubinNo;
    private RString jusho;
    private RString jushoKana;
    private TelNo telNo;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private Code kozaShubetsu;
    private Code kozaNo;
    private RString kozaMeiginin;
    private RString kozaMeigininKana;
    private Code chosaItakuKubunCode;
    private int waritsukeTeiin;
    private ChikuCode waritsukeChiku;
    private Code kikanKubunCode;

    /**
     * getInsertDantaiCd
     * @return insertDantaiCd
     */
    public RString getInsertDantaiCd() {
        return insertDantaiCd;
    }

    /**
     * setInsertDantaiCd
     * @param insertDantaiCd insertDantaiCd
     */
    public void setInsertDantaiCd(RString insertDantaiCd) {
        this.insertDantaiCd = insertDantaiCd;
    }

    /**
     * getIsDeleted
     * @return isDeleted
     */
    public boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * setIsDeleted
     * @param isDeleted isDeleted
     */
    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


    /**
     * setLastUpdateReamsLoginId
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * getShichosonCode
     * @return shichosonCode
     */
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * setShichosonCode
     * @param shichosonCode shichosonCode
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * getKaigoJigyoshaNo
     * @return kaigoJigyoshaNo
     */
    public RString getKaigoJigyoshaNo() {
        return kaigoJigyoshaNo;
    }

    /**
     * setKaigoJigyoshaNo
     * @param kaigoJigyoshaNo kaigoJigyoshaNo
     */
    public void setKaigoJigyoshaNo(RString kaigoJigyoshaNo) {
        this.kaigoJigyoshaNo = kaigoJigyoshaNo;
    }

    /**
     * getJigyoshaNo
     * @return jigyoshaNo
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getKaigoJigyoshaJokyo
     * @return kaigoJigyoshaJokyo
     */
    public RString getKaigoJigyoshaJokyo() {
        return kaigoJigyoshaJokyo;
    }

    /**
     * setKaigoJigyoshaJokyo
     * @param kaigoJigyoshaJokyo kaigoJigyoshaJokyo
     */
    public void setKaigoJigyoshaJokyo(RString kaigoJigyoshaJokyo) {
        this.kaigoJigyoshaJokyo = kaigoJigyoshaJokyo;
    }

    /**
     * getJigyoshaMeisho
     * @return jigyoshaMeisho
     */
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * setJigyoshaMeisho
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * getJigyoshaMeishoKana
     * @return jigyoshaMeishoKana
     */
    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    /**
     * setJigyoshaMeishoKana
     * @param jigyoshaMeishoKana jigyoshaMeishoKana
     */
    public void setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
    }

    /**
     * getYubinNo
     * @return yubinNo
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * setYubinNo
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * getJusho
     * @return jusho
     */
    public RString getJusho() {
        return jusho;
    }

    /**
     * setJusho
     * @param jusho jusho
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * getJushoKana
     * @return jushoKana
     */
    public RString getJushoKana() {
        return jushoKana;
    }

    /**
     * setJushoKana
     * @param jushoKana jushoKana
     */
    public void setJushoKana(RString jushoKana) {
        this.jushoKana = jushoKana;
    }

    /**
     * getTelNo
     * @return telNo
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * setTelNo
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * getGinkoCode
     * @return ginkoCode
     */
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * setGinkoCode
     * @param ginkoCode ginkoCode
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * getShitenCode
     * @return shitenCode
     */
    public KinyuKikanShitenCode getShitenCode() {
        return shitenCode;
    }

    /**
     * setShitenCode
     * @param shitenCode shitenCode
     */
    public void setShitenCode(KinyuKikanShitenCode shitenCode) {
        this.shitenCode = shitenCode;
    }

    /**
     * getKozaShubetsu
     * @return kozaShubetsu
     */
    public Code getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * setKozaShubetsu
     * @param kozaShubetsu kozaShubetsu
     */
    public void setKozaShubetsu(Code kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * getKozaNo
     * @return kozaNo
     */
    public Code getKozaNo() {
        return kozaNo;
    }

    /**
     * setKozaNo
     * @param kozaNo kozaNo
     */
    public void setKozaNo(Code kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * getKozaMeiginin
     * @return kozaMeiginin
     */
    public RString getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * setKozaMeiginin
     * @param kozaMeiginin kozaMeiginin
     */
    public void setKozaMeiginin(RString kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * getKozaMeigininKana
     * @return kozaMeigininKana
     */
    public RString getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * setKozaMeigininKana
     * @param kozaMeigininKana kozaMeigininKana
     */
    public void setKozaMeigininKana(RString kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * getChosaItakuKubunCode
     * @return chosaItakuKubunCode
     */
    public Code getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    /**
     * setChosaItakuKubunCode
     * @param chosaItakuKubunCode chosaItakuKubunCode
     */
    public void setChosaItakuKubunCode(Code chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    /**
     * getWaritsukeTeiin
     * @return waritsukeTeiin
     */
    public int getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    /**
     * setWaritsukeTeiin
     * @param waritsukeTeiin waritsukeTeiin
     */
    public void setWaritsukeTeiin(int waritsukeTeiin) {
        this.waritsukeTeiin = waritsukeTeiin;
    }

    /**
     * getWaritsukeChiku
     * @return waritsukeChiku
     */
    public ChikuCode getWaritsukeChiku() {
        return waritsukeChiku;
    }

    /**
     * setWaritsukeChiku
     * @param waritsukeChiku waritsukeChiku
     */
    public void setWaritsukeChiku(ChikuCode waritsukeChiku) {
        this.waritsukeChiku = waritsukeChiku;
    }

    /**
     * getKikanKubunCode
     * @return kikanKubunCode
     */
    public Code getKikanKubunCode() {
        return kikanKubunCode;
    }

    /**
     * setKikanKubunCode
     * @param kikanKubunCode kikanKubunCode
     */
    public void setKikanKubunCode(Code kikanKubunCode) {
        this.kikanKubunCode = kikanKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7010NinteichosaItakusakiJohoEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7010NinteichosaItakusakiJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7010NinteichosaItakusakiJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shichosonCode, other.shichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.kaigoJigyoshaNo, other.kaigoJigyoshaNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7010NinteichosaItakusakiJohoEntity entity) {
        this.shichosonCode = entity.shichosonCode;
        this.kaigoJigyoshaNo = entity.kaigoJigyoshaNo;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.kaigoJigyoshaJokyo = entity.kaigoJigyoshaJokyo;
        this.jigyoshaMeisho = entity.jigyoshaMeisho;
        this.jigyoshaMeishoKana = entity.jigyoshaMeishoKana;
        this.yubinNo = entity.yubinNo;
        this.jusho = entity.jusho;
        this.jushoKana = entity.jushoKana;
        this.telNo = entity.telNo;
        this.ginkoCode = entity.ginkoCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.chosaItakuKubunCode = entity.chosaItakuKubunCode;
        this.waritsukeTeiin = entity.waritsukeTeiin;
        this.waritsukeChiku = entity.waritsukeChiku;
        this.kikanKubunCode = entity.kikanKubunCode;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shichosonCode, kaigoJigyoshaNo, jigyoshaNo, kaigoJigyoshaJokyo, jigyoshaMeisho, jigyoshaMeishoKana, yubinNo, jusho, jushoKana, telNo, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, chosaItakuKubunCode, waritsukeTeiin, waritsukeChiku, kikanKubunCode);
    }

// </editor-fold>


}
