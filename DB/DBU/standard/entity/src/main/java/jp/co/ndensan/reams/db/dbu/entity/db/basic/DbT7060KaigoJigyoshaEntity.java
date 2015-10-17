package jp.co.ndensan.reams.db.dbu.entity.db.basic;

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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;

/**
 * 介護事業者テーブルのエンティティクラスです。
 * <br/> 介護事業者を管理する。
 */
public class DbT7060KaigoJigyoshaEntity extends DbTableEntityBase<DbT7060KaigoJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT7060KaigoJigyosha");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private KaigoJigyoshaNo jigyoshaNo;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private FlexibleDate idoYMD;
    private RString idoJiyuCode;
    private FlexibleDate jigyoKaishiYMD;
    private FlexibleDate jigyoKyushiYMD;
    private FlexibleDate jigyoSaikaiYMD;
    private FlexibleDate jigyoHaishiYMD;
    private AtenaMeisho jigyoshaName;
    private AtenaKanaMeisho jigyoshaNameKana;
    private YubinNo yubinNo;
    private AtenaJusho jigyoshaAddress;
    private RString jigyoshaKanaAddress;
    private TelNo telNo;
    private TelNo faxNo;
    private RString atesakiBusho;
    private AtenaMeisho atesakininName;
    private AtenaKanaMeisho atesakininNamekana;
    private KinyuKikanCode ginkoCode;
    private KinyuKikanShitenCode shitenCode;
    private Code kozaShubetsu;
    private RString kozaNo;
    private AtenaMeisho kozaMeiginin;
    private AtenaKanaMeisho kozaMeigininKana;
    private Code shiteiKijungaitoJigyoshaKubun;
    private RString shozaiShichoson;
    private RString serviceJisshiChiiki;
    private Code hojinShubetsu;
    private int bedSu;
    private int shozokuNinzu;
    private int riyoshaSu;
    private RString biko;

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
     * 事業者番号のgetメソッドです。
     *
     * @return 事業者番号
     */
    public KaigoJigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * 事業者番号のsetメソッドです。
     *
     * @param jigyoshaNo 事業者番号
     */
    public void setJigyoshaNo(KaigoJigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * 有効開始日のgetメソッドです。
     *
     * @return 有効開始日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始日のsetメソッドです。
     *
     * @param yukoKaishiYMD 有効開始日
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了日のgetメソッドです。
     *
     * @return 有効終了日
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * 有効終了日のsetメソッドです。
     *
     * @param yukoShuryoYMD 有効終了日
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * 異動日のgetメソッドです。
     *
     * @return 異動日
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * 異動日のsetメソッドです。
     *
     * @param idoYMD 異動日
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * 異動事由のgetメソッドです。
     *
     * @return 異動事由
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由のsetメソッドです。
     *
     * @param idoJiyuCode 異動事由
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * 事業開始日のgetメソッドです。
     *
     * @return 事業開始日
     */
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * 事業開始日のsetメソッドです。
     *
     * @param jigyoKaishiYMD 事業開始日
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * 事業休止日のgetメソッドです。
     *
     * @return 事業休止日
     */
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * 事業休止日のsetメソッドです。
     *
     * @param jigyoKyushiYMD 事業休止日
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * 事業再開日のgetメソッドです。
     *
     * @return 事業再開日
     */
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * 事業再開日のsetメソッドです。
     *
     * @param jigyoSaikaiYMD 事業再開日
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * 事業廃止日のgetメソッドです。
     *
     * @return 事業廃止日
     */
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * 事業廃止日のsetメソッドです。
     *
     * @param jigyoHaishiYMD 事業廃止日
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * 事業者名称のgetメソッドです。
     *
     * @return 事業者名称
     */
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * 事業者名称のsetメソッドです。
     *
     * @param jigyoshaName 事業者名称
     */
    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    /**
     * 事業者名称カナのgetメソッドです。
     *
     * @return 事業者名称カナ
     */
    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * 事業者名称カナのsetメソッドです。
     *
     * @param jigyoshaNameKana 事業者名称カナ
     */
    public void setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
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
     * 事業者住所のgetメソッドです。
     *
     * @return 事業者住所
     */
    public AtenaJusho getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * 事業者住所のsetメソッドです。
     *
     * @param jigyoshaAddress 事業者住所
     */
    public void setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * 事業者住所カナのgetメソッドです。
     *
     * @return 事業者住所カナ
     */
    public RString getJigyoshaKanaAddress() {
        return jigyoshaKanaAddress;
    }

    /**
     * 事業者住所カナのsetメソッドです。
     *
     * @param jigyoshaKanaAddress 事業者住所カナ
     */
    public void setJigyoshaKanaAddress(RString jigyoshaKanaAddress) {
        this.jigyoshaKanaAddress = jigyoshaKanaAddress;
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
     * FAX番号のgetメソッドです。
     *
     * @return FAX番号
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * FAX番号のsetメソッドです。
     *
     * @param faxNo FAX番号
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * 宛先部署のgetメソッドです。
     *
     * @return 宛先部署
     */
    public RString getAtesakiBusho() {
        return atesakiBusho;
    }

    /**
     * 宛先部署のsetメソッドです。
     *
     * @param atesakiBusho 宛先部署
     */
    public void setAtesakiBusho(RString atesakiBusho) {
        this.atesakiBusho = atesakiBusho;
    }

    /**
     * 宛先人名のgetメソッドです。
     *
     * @return 宛先人名
     */
    public AtenaMeisho getAtesakininName() {
        return atesakininName;
    }

    /**
     * 宛先人名のsetメソッドです。
     *
     * @param atesakininName 宛先人名
     */
    public void setAtesakininName(AtenaMeisho atesakininName) {
        this.atesakininName = atesakininName;
    }

    /**
     * 宛先人名カナのgetメソッドです。
     *
     * @return 宛先人名カナ
     */
    public AtenaKanaMeisho getAtesakininNamekana() {
        return atesakininNamekana;
    }

    /**
     * 宛先人名カナのsetメソッドです。
     *
     * @param atesakininNamekana 宛先人名カナ
     */
    public void setAtesakininNamekana(AtenaKanaMeisho atesakininNamekana) {
        this.atesakininNamekana = atesakininNamekana;
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
     * 指定／基準該当等事業所区分のgetメソッドです。
     *
     * @return 指定／基準該当等事業所区分
     */
    public Code getShiteiKijungaitoJigyoshaKubun() {
        return shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * 指定／基準該当等事業所区分のsetメソッドです。
     *
     * @param shiteiKijungaitoJigyoshaKubun 指定／基準該当等事業所区分
     */
    public void setShiteiKijungaitoJigyoshaKubun(Code shiteiKijungaitoJigyoshaKubun) {
        this.shiteiKijungaitoJigyoshaKubun = shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * 所在市町村のgetメソッドです。
     *
     * @return 所在市町村
     */
    public RString getShozaiShichoson() {
        return shozaiShichoson;
    }

    /**
     * 所在市町村のsetメソッドです。
     *
     * @param shozaiShichoson 所在市町村
     */
    public void setShozaiShichoson(RString shozaiShichoson) {
        this.shozaiShichoson = shozaiShichoson;
    }

    /**
     * サービス実施地域のgetメソッドです。
     *
     * @return サービス実施地域
     */
    public RString getServiceJisshiChiiki() {
        return serviceJisshiChiiki;
    }

    /**
     * サービス実施地域のsetメソッドです。
     *
     * @param serviceJisshiChiiki サービス実施地域
     */
    public void setServiceJisshiChiiki(RString serviceJisshiChiiki) {
        this.serviceJisshiChiiki = serviceJisshiChiiki;
    }

    /**
     * 法人等種別のgetメソッドです。
     *
     * @return 法人等種別
     */
    public Code getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * 法人等種別のsetメソッドです。
     *
     * @param hojinShubetsu 法人等種別
     */
    public void setHojinShubetsu(Code hojinShubetsu) {
        this.hojinShubetsu = hojinShubetsu;
    }

    /**
     * ベッド数のgetメソッドです。
     *
     * @return ベッド数
     */
    public int getBedSu() {
        return bedSu;
    }

    /**
     * ベッド数のsetメソッドです。
     *
     * @param bedSu ベッド数
     */
    public void setBedSu(int bedSu) {
        this.bedSu = bedSu;
    }

    /**
     * 所属人数のgetメソッドです。
     *
     * @return 所属人数
     */
    public int getShozokuNinzu() {
        return shozokuNinzu;
    }

    /**
     * 所属人数のsetメソッドです。
     *
     * @param shozokuNinzu 所属人数
     */
    public void setShozokuNinzu(int shozokuNinzu) {
        this.shozokuNinzu = shozokuNinzu;
    }

    /**
     * 利用者数のgetメソッドです。
     *
     * @return 利用者数
     */
    public int getRiyoshaSu() {
        return riyoshaSu;
    }

    /**
     * 利用者数のsetメソッドです。
     *
     * @param riyoshaSu 利用者数
     */
    public void setRiyoshaSu(int riyoshaSu) {
        this.riyoshaSu = riyoshaSu;
    }

    /**
     * 備考のgetメソッドです。
     *
     * @return 備考
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * 備考のsetメソッドです。
     *
     * @param biko 備考
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7060KaigoJigyoshaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7060KaigoJigyoshaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7060KaigoJigyoshaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaNo, other.jigyoshaNo)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7060KaigoJigyoshaEntity entity) {
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.idoYMD = entity.idoYMD;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.jigyoKaishiYMD = entity.jigyoKaishiYMD;
        this.jigyoKyushiYMD = entity.jigyoKyushiYMD;
        this.jigyoSaikaiYMD = entity.jigyoSaikaiYMD;
        this.jigyoHaishiYMD = entity.jigyoHaishiYMD;
        this.jigyoshaName = entity.jigyoshaName;
        this.jigyoshaNameKana = entity.jigyoshaNameKana;
        this.yubinNo = entity.yubinNo;
        this.jigyoshaAddress = entity.jigyoshaAddress;
        this.jigyoshaKanaAddress = entity.jigyoshaKanaAddress;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.atesakiBusho = entity.atesakiBusho;
        this.atesakininName = entity.atesakininName;
        this.atesakininNamekana = entity.atesakininNamekana;
        this.ginkoCode = entity.ginkoCode;
        this.shitenCode = entity.shitenCode;
        this.kozaShubetsu = entity.kozaShubetsu;
        this.kozaNo = entity.kozaNo;
        this.kozaMeiginin = entity.kozaMeiginin;
        this.kozaMeigininKana = entity.kozaMeigininKana;
        this.shiteiKijungaitoJigyoshaKubun = entity.shiteiKijungaitoJigyoshaKubun;
        this.shozaiShichoson = entity.shozaiShichoson;
        this.serviceJisshiChiiki = entity.serviceJisshiChiiki;
        this.hojinShubetsu = entity.hojinShubetsu;
        this.bedSu = entity.bedSu;
        this.shozokuNinzu = entity.shozokuNinzu;
        this.riyoshaSu = entity.riyoshaSu;
        this.biko = entity.biko;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyuCode, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, yubinNo, jigyoshaAddress, jigyoshaKanaAddress, telNo, faxNo, atesakiBusho, atesakininName, atesakininNamekana, ginkoCode, shitenCode, kozaShubetsu, kozaNo, kozaMeiginin, kozaMeigininKana, shiteiKijungaitoJigyoshaKubun, shozaiShichoson, serviceJisshiChiiki, hojinShubetsu, bedSu, shozokuNinzu, riyoshaSu, biko);
    }

// </editor-fold>
}
