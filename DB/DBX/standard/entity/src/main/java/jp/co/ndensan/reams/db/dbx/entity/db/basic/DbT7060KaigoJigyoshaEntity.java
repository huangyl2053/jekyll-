package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 介護事業者テーブルのエンティティクラスです。
 * <br/> 介護事業者を管理します。
 */
public class DbT7060KaigoJigyoshaEntity extends DbTableEntityBase<DbT7060KaigoJigyoshaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
    public void setJigyoshaNo(@Nonnull KaigoJigyoshaNo jigyoshaNo) {
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
    public void setYukoKaishiYMD(@Nonnull FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了日のgetメソッドです。
     *
     * @return 有効終了日
     */
    @CheckForNull
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
    @CheckForNull
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
     * <br/>
     * <br/>＜Enumで管理＞
     * <br/>01：固定値
     *
     * @return 異動事由
     */
    @CheckForNull
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * 異動事由のsetメソッドです。
     * <br/>
     * <br/>＜Enumで管理＞
     * <br/>01：固定値
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    public void setJigyoshaName(@Nonnull AtenaMeisho jigyoshaName) {
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
    public void setJigyoshaNameKana(@Nonnull AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * 郵便番号のgetメソッドです。
     *
     * @return 郵便番号
     */
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * 指定／基準該当等事業所区分のgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0009＞
     * <br/>1:指定事業所
     * <br/>2:基準該当事業所
     * <br/>3:相当サービス事業所（地域密着型事業所も含む）
     * <br/>4:その他
     * <br/>5:地域密着型事業所
     * <br/>6:混在型事業所Ⅰ
     * <br/>7:混在型事業所Ⅱ
     * <br/>8:介護予防・日常生活支援総合事業事業所
     *
     * @return 指定／基準該当等事業所区分
     */
    @CheckForNull
    public Code getShiteiKijungaitoJigyoshaKubun() {
        return shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * 指定／基準該当等事業所区分のsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0009＞
     * <br/>1:指定事業所
     * <br/>2:基準該当事業所
     * <br/>3:相当サービス事業所（地域密着型事業所も含む）
     * <br/>4:その他
     * <br/>5:地域密着型事業所
     * <br/>6:混在型事業所Ⅰ
     * <br/>7:混在型事業所Ⅱ
     * <br/>8:介護予防・日常生活支援総合事業事業所
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
    @CheckForNull
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
    @CheckForNull
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
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0241＞
     * <br/>01:社会福祉法人（社協以外）
     * <br/>02:社会福祉法人（社協）
     * <br/>03:医療法人
     * <br/>04:民法法人（社団・財団）
     * <br/>05:営利法人
     * <br/>06:非営利法人（ＮＰＯ）
     * <br/>07:農協
     * <br/>08:生協
     * <br/>09:その他法人
     * <br/>10:地方公共団体（都道府県）
     * <br/>11:地方公共団体（市町村）
     * <br/>12:地方公共団体（広域連合・一部事務組合等）
     * <br/>13:非法人
     * <br/>99:その他
     *
     * @return 法人等種別
     */
    @CheckForNull
    public Code getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * 法人等種別のsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：DBZ、種別：0241＞
     * <br/>01:社会福祉法人（社協以外）
     * <br/>02:社会福祉法人（社協）
     * <br/>03:医療法人
     * <br/>04:民法法人（社団・財団）
     * <br/>05:営利法人
     * <br/>06:非営利法人（ＮＰＯ）
     * <br/>07:農協
     * <br/>08:生協
     * <br/>09:その他法人
     * <br/>10:地方公共団体（都道府県）
     * <br/>11:地方公共団体（市町村）
     * <br/>12:地方公共団体（広域連合・一部事務組合等）
     * <br/>13:非法人
     * <br/>99:その他
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
    @CheckForNull
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
     * @return
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
     *
     * @param entity
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
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyuCode, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, yubinNo, jigyoshaAddress, jigyoshaKanaAddress, telNo, faxNo, atesakiBusho, atesakininName, atesakininNamekana, shiteiKijungaitoJigyoshaKubun, shozaiShichoson, serviceJisshiChiiki, hojinShubetsu, bedSu, shozokuNinzu, riyoshaSu, biko);
    }

// </editor-fold>
}
