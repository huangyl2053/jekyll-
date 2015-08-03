package jp.co.ndensan.reams.db.dbu.entity.basic;

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
 * 認定調査委託先情報　継承テーブルのエンティティクラスです。
 */
public class DbT7010NinteichosaItakusakiJohoEntity extends DbTableEntityBase<DbT7010NinteichosaItakusakiJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 介護事業者番号のgetメソッドです。
     * 
     * @return 介護事業者番号
     */
    public RString getKaigoJigyoshaNo() {
        return kaigoJigyoshaNo;
    }

    /**
     * 介護事業者番号のsetメソッドです。
     * 
     * @param kaigoJigyoshaNo 介護事業者番号
     */
    public void setKaigoJigyoshaNo(RString kaigoJigyoshaNo) {
        this.kaigoJigyoshaNo = kaigoJigyoshaNo;
    }

    /**
     * 事業者番号のgetメソッドです。
     * 
     * @return 事業者番号
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     * 
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 介護事業者状況のgetメソッドです。
     * 
     * @return 介護事業者状況
     */
    public RString getKaigoJigyoshaJokyo() {
        return kaigoJigyoshaJokyo;
    }

    /**
     * 介護事業者状況のsetメソッドです。
     * 
     * @param kaigoJigyoshaJokyo 介護事業者状況
     */
    public void setKaigoJigyoshaJokyo(RString kaigoJigyoshaJokyo) {
        this.kaigoJigyoshaJokyo = kaigoJigyoshaJokyo;
    }

    /**
     * 事業者名称のgetメソッドです。
     * 
     * @return 事業者名称
     */
    public RString getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * 事業者名称のsetメソッドです。
     * 
     * @param jigyoshaMeisho 事業者名称
     */
    public void setJigyoshaMeisho(RString jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     * 
     * @return 事業者名称カナ
     */
    public RString getJigyoshaMeishoKana() {
        return jigyoshaMeishoKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     * 
     * @param jigyoshaMeishoKana 事業者名称カナ
     */
    public void setJigyoshaMeishoKana(RString jigyoshaMeishoKana) {
        this.jigyoshaMeishoKana = jigyoshaMeishoKana;
    }

    /**
     * 郵便番号のgetメソッドです。
     * 
     * @return 郵便番号
     */
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * 郵便番号のsetメソッドです。
     * 
     * @param yubinNo 郵便番号
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * 住所のgetメソッドです。
     * 
     * @return 住所
     */
    public RString getJusho() {
        return jusho;
    }

    /**
     * 住所のsetメソッドです。
     * 
     * @param jusho 住所
     */
    public void setJusho(RString jusho) {
        this.jusho = jusho;
    }

    /**
     * 住所カナのgetメソッドです。
     * 
     * @return 住所カナ
     */
    public RString getJushoKana() {
        return jushoKana;
    }

    /**
     * 住所カナのsetメソッドです。
     * 
     * @param jushoKana 住所カナ
     */
    public void setJushoKana(RString jushoKana) {
        this.jushoKana = jushoKana;
    }

    /**
     * 電話番号のgetメソッドです。
     * 
     * @return 電話番号
     */
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * 電話番号のsetメソッドです。
     * 
     * @param telNo 電話番号
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * 銀行コードのgetメソッドです。
     * 
     * @return 銀行コード
     */
    public KinyuKikanCode getGinkoCode() {
        return ginkoCode;
    }

    /**
     * 銀行コードのsetメソッドです。
     * 
     * @param ginkoCode 銀行コード
     */
    public void setGinkoCode(KinyuKikanCode ginkoCode) {
        this.ginkoCode = ginkoCode;
    }

    /**
     * 支店コードのgetメソッドです。
     * 
     * @return 支店コード
     */
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
    public Code getKozaShubetsu() {
        return kozaShubetsu;
    }

    /**
     * 口座種別のsetメソッドです。
     * 
     * @param kozaShubetsu 口座種別
     */
    public void setKozaShubetsu(Code kozaShubetsu) {
        this.kozaShubetsu = kozaShubetsu;
    }

    /**
     * 口座番号のgetメソッドです。
     * 
     * @return 口座番号
     */
    public Code getKozaNo() {
        return kozaNo;
    }

    /**
     * 口座番号のsetメソッドです。
     * 
     * @param kozaNo 口座番号
     */
    public void setKozaNo(Code kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * 口座名義人のgetメソッドです。
     * 
     * @return 口座名義人
     */
    public RString getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * 口座名義人のsetメソッドです。
     * 
     * @param kozaMeiginin 口座名義人
     */
    public void setKozaMeiginin(RString kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * 口座名義人カナのgetメソッドです。
     * 
     * @return 口座名義人カナ
     */
    public RString getKozaMeigininKana() {
        return kozaMeigininKana;
    }

    /**
     * 口座名義人カナのsetメソッドです。
     * 
     * @param kozaMeigininKana 口座名義人カナ
     */
    public void setKozaMeigininKana(RString kozaMeigininKana) {
        this.kozaMeigininKana = kozaMeigininKana;
    }

    /**
     * 調査委託区分コードのgetメソッドです。
     * 
     * @return 調査委託区分コード
     */
    public Code getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    /**
     * 調査委託区分コードのsetメソッドです。
     * 
     * @param chosaItakuKubunCode 調査委託区分コード
     */
    public void setChosaItakuKubunCode(Code chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    /**
     * 割付定員のgetメソッドです。
     * 
     * @return 割付定員
     */
    public int getWaritsukeTeiin() {
        return waritsukeTeiin;
    }

    /**
     * 割付定員のsetメソッドです。
     * 
     * @param waritsukeTeiin 割付定員
     */
    public void setWaritsukeTeiin(int waritsukeTeiin) {
        this.waritsukeTeiin = waritsukeTeiin;
    }

    /**
     * 割付地区のgetメソッドです。
     * 
     * @return 割付地区
     */
    public ChikuCode getWaritsukeChiku() {
        return waritsukeChiku;
    }

    /**
     * 割付地区のsetメソッドです。
     * 
     * @param waritsukeChiku 割付地区
     */
    public void setWaritsukeChiku(ChikuCode waritsukeChiku) {
        this.waritsukeChiku = waritsukeChiku;
    }

    /**
     * 機関の区分コードのgetメソッドです。
     * 
     * @return 機関の区分コード
     */
    public Code getKikanKubunCode() {
        return kikanKubunCode;
    }

    /**
     * 機関の区分コードのsetメソッドです。
     * 
     * @param kikanKubunCode 機関の区分コード
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
