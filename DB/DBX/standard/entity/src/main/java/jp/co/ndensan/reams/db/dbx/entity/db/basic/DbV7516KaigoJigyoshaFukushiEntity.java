package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import javax.annotation.CheckForNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;

/**
 * 介護事業者・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7516KaigoJigyoshaFukushiEntity extends DbTableEntityBase<DbV7516KaigoJigyoshaFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7516KaigoJigyoshaFukushi");

    private JigyoshaNo jigyoshaNo;
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
     * jigyoshaNoのgetメソッドです。
     * 
     * @return jigyoshaNo
     */
    @CheckForNull
    public JigyoshaNo getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * jigyoshaNoのsetメソッドです。
     * 
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(JigyoshaNo jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * yukoKaishiYMDのgetメソッドです。
     * 
     * @return yukoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * yukoKaishiYMDのsetメソッドです。
     * 
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * yukoShuryoYMDのgetメソッドです。
     * 
     * @return yukoShuryoYMD
     */
    @CheckForNull
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * yukoShuryoYMDのsetメソッドです。
     * 
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * idoYMDのgetメソッドです。
     * 
     * @return idoYMD
     */
    @CheckForNull
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * idoYMDのsetメソッドです。
     * 
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * idoJiyuCodeのgetメソッドです。
     * 
     * @return idoJiyuCode
     */
    @CheckForNull
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * idoJiyuCodeのsetメソッドです。
     * 
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * jigyoKaishiYMDのgetメソッドです。
     * 
     * @return jigyoKaishiYMD
     */
    @CheckForNull
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * jigyoKaishiYMDのsetメソッドです。
     * 
     * @param jigyoKaishiYMD jigyoKaishiYMD
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * jigyoKyushiYMDのgetメソッドです。
     * 
     * @return jigyoKyushiYMD
     */
    @CheckForNull
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * jigyoKyushiYMDのsetメソッドです。
     * 
     * @param jigyoKyushiYMD jigyoKyushiYMD
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * jigyoSaikaiYMDのgetメソッドです。
     * 
     * @return jigyoSaikaiYMD
     */
    @CheckForNull
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * jigyoSaikaiYMDのsetメソッドです。
     * 
     * @param jigyoSaikaiYMD jigyoSaikaiYMD
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * jigyoHaishiYMDのgetメソッドです。
     * 
     * @return jigyoHaishiYMD
     */
    @CheckForNull
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * jigyoHaishiYMDのsetメソッドです。
     * 
     * @param jigyoHaishiYMD jigyoHaishiYMD
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * jigyoshaNameのgetメソッドです。
     * 
     * @return jigyoshaName
     */
    @CheckForNull
    public AtenaMeisho getJigyoshaName() {
        return jigyoshaName;
    }

    /**
     * jigyoshaNameのsetメソッドです。
     * 
     * @param jigyoshaName jigyoshaName
     */
    public void setJigyoshaName(AtenaMeisho jigyoshaName) {
        this.jigyoshaName = jigyoshaName;
    }

    /**
     * jigyoshaNameKanaのgetメソッドです。
     * 
     * @return jigyoshaNameKana
     */
    @CheckForNull
    public AtenaKanaMeisho getJigyoshaNameKana() {
        return jigyoshaNameKana;
    }

    /**
     * jigyoshaNameKanaのsetメソッドです。
     * 
     * @param jigyoshaNameKana jigyoshaNameKana
     */
    public void setJigyoshaNameKana(AtenaKanaMeisho jigyoshaNameKana) {
        this.jigyoshaNameKana = jigyoshaNameKana;
    }

    /**
     * yubinNoのgetメソッドです。
     * 
     * @return yubinNo
     */
    @CheckForNull
    public YubinNo getYubinNo() {
        return yubinNo;
    }

    /**
     * yubinNoのsetメソッドです。
     * 
     * @param yubinNo yubinNo
     */
    public void setYubinNo(YubinNo yubinNo) {
        this.yubinNo = yubinNo;
    }

    /**
     * jigyoshaAddressのgetメソッドです。
     * 
     * @return jigyoshaAddress
     */
    @CheckForNull
    public AtenaJusho getJigyoshaAddress() {
        return jigyoshaAddress;
    }

    /**
     * jigyoshaAddressのsetメソッドです。
     * 
     * @param jigyoshaAddress jigyoshaAddress
     */
    public void setJigyoshaAddress(AtenaJusho jigyoshaAddress) {
        this.jigyoshaAddress = jigyoshaAddress;
    }

    /**
     * jigyoshaKanaAddressのgetメソッドです。
     * 
     * @return jigyoshaKanaAddress
     */
    @CheckForNull
    public RString getJigyoshaKanaAddress() {
        return jigyoshaKanaAddress;
    }

    /**
     * jigyoshaKanaAddressのsetメソッドです。
     * 
     * @param jigyoshaKanaAddress jigyoshaKanaAddress
     */
    public void setJigyoshaKanaAddress(RString jigyoshaKanaAddress) {
        this.jigyoshaKanaAddress = jigyoshaKanaAddress;
    }

    /**
     * telNoのgetメソッドです。
     * 
     * @return telNo
     */
    @CheckForNull
    public TelNo getTelNo() {
        return telNo;
    }

    /**
     * telNoのsetメソッドです。
     * 
     * @param telNo telNo
     */
    public void setTelNo(TelNo telNo) {
        this.telNo = telNo;
    }

    /**
     * faxNoのgetメソッドです。
     * 
     * @return faxNo
     */
    @CheckForNull
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * faxNoのsetメソッドです。
     * 
     * @param faxNo faxNo
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * atesakiBushoのgetメソッドです。
     * 
     * @return atesakiBusho
     */
    @CheckForNull
    public RString getAtesakiBusho() {
        return atesakiBusho;
    }

    /**
     * atesakiBushoのsetメソッドです。
     * 
     * @param atesakiBusho atesakiBusho
     */
    public void setAtesakiBusho(RString atesakiBusho) {
        this.atesakiBusho = atesakiBusho;
    }

    /**
     * atesakininNameのgetメソッドです。
     * 
     * @return atesakininName
     */
    @CheckForNull
    public AtenaMeisho getAtesakininName() {
        return atesakininName;
    }

    /**
     * atesakininNameのsetメソッドです。
     * 
     * @param atesakininName atesakininName
     */
    public void setAtesakininName(AtenaMeisho atesakininName) {
        this.atesakininName = atesakininName;
    }

    /**
     * atesakininNamekanaのgetメソッドです。
     * 
     * @return atesakininNamekana
     */
    @CheckForNull
    public AtenaKanaMeisho getAtesakininNamekana() {
        return atesakininNamekana;
    }

    /**
     * atesakininNamekanaのsetメソッドです。
     * 
     * @param atesakininNamekana atesakininNamekana
     */
    public void setAtesakininNamekana(AtenaKanaMeisho atesakininNamekana) {
        this.atesakininNamekana = atesakininNamekana;
    }

    /**
     * shiteiKijungaitoJigyoshaKubunのgetメソッドです。
     * 
     * @return shiteiKijungaitoJigyoshaKubun
     */
    @CheckForNull
    public Code getShiteiKijungaitoJigyoshaKubun() {
        return shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * shiteiKijungaitoJigyoshaKubunのsetメソッドです。
     * 
     * @param shiteiKijungaitoJigyoshaKubun shiteiKijungaitoJigyoshaKubun
     */
    public void setShiteiKijungaitoJigyoshaKubun(Code shiteiKijungaitoJigyoshaKubun) {
        this.shiteiKijungaitoJigyoshaKubun = shiteiKijungaitoJigyoshaKubun;
    }

    /**
     * shozaiShichosonのgetメソッドです。
     * 
     * @return shozaiShichoson
     */
    @CheckForNull
    public RString getShozaiShichoson() {
        return shozaiShichoson;
    }

    /**
     * shozaiShichosonのsetメソッドです。
     * 
     * @param shozaiShichoson shozaiShichoson
     */
    public void setShozaiShichoson(RString shozaiShichoson) {
        this.shozaiShichoson = shozaiShichoson;
    }

    /**
     * serviceJisshiChiikiのgetメソッドです。
     * 
     * @return serviceJisshiChiiki
     */
    @CheckForNull
    public RString getServiceJisshiChiiki() {
        return serviceJisshiChiiki;
    }

    /**
     * serviceJisshiChiikiのsetメソッドです。
     * 
     * @param serviceJisshiChiiki serviceJisshiChiiki
     */
    public void setServiceJisshiChiiki(RString serviceJisshiChiiki) {
        this.serviceJisshiChiiki = serviceJisshiChiiki;
    }

    /**
     * hojinShubetsuのgetメソッドです。
     * 
     * @return hojinShubetsu
     */
    @CheckForNull
    public Code getHojinShubetsu() {
        return hojinShubetsu;
    }

    /**
     * hojinShubetsuのsetメソッドです。
     * 
     * @param hojinShubetsu hojinShubetsu
     */
    public void setHojinShubetsu(Code hojinShubetsu) {
        this.hojinShubetsu = hojinShubetsu;
    }

    /**
     * bedSuのgetメソッドです。
     * 
     * @return bedSu
     */
    @CheckForNull
    public int getBedSu() {
        return bedSu;
    }

    /**
     * bedSuのsetメソッドです。
     * 
     * @param bedSu bedSu
     */
    public void setBedSu(int bedSu) {
        this.bedSu = bedSu;
    }

    /**
     * shozokuNinzuのgetメソッドです。
     * 
     * @return shozokuNinzu
     */
    @CheckForNull
    public int getShozokuNinzu() {
        return shozokuNinzu;
    }

    /**
     * shozokuNinzuのsetメソッドです。
     * 
     * @param shozokuNinzu shozokuNinzu
     */
    public void setShozokuNinzu(int shozokuNinzu) {
        this.shozokuNinzu = shozokuNinzu;
    }

    /**
     * riyoshaSuのgetメソッドです。
     * 
     * @return riyoshaSu
     */
    @CheckForNull
    public int getRiyoshaSu() {
        return riyoshaSu;
    }

    /**
     * riyoshaSuのsetメソッドです。
     * 
     * @param riyoshaSu riyoshaSu
     */
    public void setRiyoshaSu(int riyoshaSu) {
        this.riyoshaSu = riyoshaSu;
    }

    /**
     * bikoのgetメソッドです。
     * 
     * @return biko
     */
    @CheckForNull
    public RString getBiko() {
        return biko;
    }

    /**
     * bikoのsetメソッドです。
     * 
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * このエンティティの主キーが他の{@literal DbV7516KaigoJigyoshaFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7516KaigoJigyoshaFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7516KaigoJigyoshaFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7516KaigoJigyoshaFukushiEntity entity) {
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, idoYMD, idoJiyuCode, jigyoKaishiYMD, jigyoKyushiYMD, jigyoSaikaiYMD, jigyoHaishiYMD, jigyoshaName, jigyoshaNameKana, yubinNo, jigyoshaAddress, jigyoshaKanaAddress, telNo, faxNo, atesakiBusho, atesakininName, atesakininNamekana, shiteiKijungaitoJigyoshaKubun, shozaiShichoson, serviceJisshiChiiki, hojinShubetsu, bedSu, shozokuNinzu, riyoshaSu, biko);
    }

// </editor-fold>
}
