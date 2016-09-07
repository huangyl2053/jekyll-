package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 介護除外住所地特例対象施設・福祉Viewテーブルのエンティティクラスです。
 */
public class DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity extends DbTableEntityBase<DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV7505KaigoJogaiTokureiTaishoShisetsuFukushi");

    private RString jigyoshaShubetsu;
    private RString jigyoshaNo;
    private FlexibleDate yukoKaishiYMD;
    private FlexibleDate yukoShuryoYMD;
    private RString kannaiKangaiKubun;
    private AtenaMeisho jigyoshaMeisho;
    private AtenaKanaMeisho jigyoshaKanaMeisho;
    private YubinNo yubinNo;
    private RString jigyoshaJusho;
    private RString jigyoshaKanaJusho;
    private TelNo telNo;
    private TelNo faxNo;
    private RString idoJiyuCode;
    private FlexibleDate idoYMD;
    private AtenaMeisho daihyoshaMeisho;
    private AtenaKanaMeisho daihyoshaKanaMeisho;
    private RString yakushoku;
    private RString biko;
    private FlexibleDate jigyoKaishiYMD;
    private FlexibleDate jigyoKyushiYMD;
    private FlexibleDate jigyoHaishiYMD;
    private FlexibleDate jigyoSaikaiYMD;

    /**
     * jigyoshaShubetsuのgetメソッドです。
     * 
     * @return jigyoshaShubetsu
     */
    @CheckForNull
    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    /**
     * jigyoshaShubetsuのsetメソッドです。
     * 
     * @param jigyoshaShubetsu jigyoshaShubetsu
     */
    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    /**
     * jigyoshaNoのgetメソッドです。
     * 
     * @return jigyoshaNo
     */
    @CheckForNull
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * jigyoshaNoのsetメソッドです。
     * 
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
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
     * kannaiKangaiKubunのgetメソッドです。
     * 
     * @return kannaiKangaiKubun
     */
    @CheckForNull
    public RString getKannaiKangaiKubun() {
        return kannaiKangaiKubun;
    }

    /**
     * kannaiKangaiKubunのsetメソッドです。
     * 
     * @param kannaiKangaiKubun kannaiKangaiKubun
     */
    public void setKannaiKangaiKubun(RString kannaiKangaiKubun) {
        this.kannaiKangaiKubun = kannaiKangaiKubun;
    }

    /**
     * jigyoshaMeishoのgetメソッドです。
     * 
     * @return jigyoshaMeisho
     */
    @CheckForNull
    public AtenaMeisho getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * jigyoshaMeishoのsetメソッドです。
     * 
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    public void setJigyoshaMeisho(AtenaMeisho jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * jigyoshaKanaMeishoのgetメソッドです。
     * 
     * @return jigyoshaKanaMeisho
     */
    @CheckForNull
    public AtenaKanaMeisho getJigyoshaKanaMeisho() {
        return jigyoshaKanaMeisho;
    }

    /**
     * jigyoshaKanaMeishoのsetメソッドです。
     * 
     * @param jigyoshaKanaMeisho jigyoshaKanaMeisho
     */
    public void setJigyoshaKanaMeisho(AtenaKanaMeisho jigyoshaKanaMeisho) {
        this.jigyoshaKanaMeisho = jigyoshaKanaMeisho;
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
     * jigyoshaJushoのgetメソッドです。
     * 
     * @return jigyoshaJusho
     */
    @CheckForNull
    public RString getJigyoshaJusho() {
        return jigyoshaJusho;
    }

    /**
     * jigyoshaJushoのsetメソッドです。
     * 
     * @param jigyoshaJusho jigyoshaJusho
     */
    public void setJigyoshaJusho(RString jigyoshaJusho) {
        this.jigyoshaJusho = jigyoshaJusho;
    }

    /**
     * jigyoshaKanaJushoのgetメソッドです。
     * 
     * @return jigyoshaKanaJusho
     */
    @CheckForNull
    public RString getJigyoshaKanaJusho() {
        return jigyoshaKanaJusho;
    }

    /**
     * jigyoshaKanaJushoのsetメソッドです。
     * 
     * @param jigyoshaKanaJusho jigyoshaKanaJusho
     */
    public void setJigyoshaKanaJusho(RString jigyoshaKanaJusho) {
        this.jigyoshaKanaJusho = jigyoshaKanaJusho;
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
     * daihyoshaMeishoのgetメソッドです。
     * 
     * @return daihyoshaMeisho
     */
    @CheckForNull
    public AtenaMeisho getDaihyoshaMeisho() {
        return daihyoshaMeisho;
    }

    /**
     * daihyoshaMeishoのsetメソッドです。
     * 
     * @param daihyoshaMeisho daihyoshaMeisho
     */
    public void setDaihyoshaMeisho(AtenaMeisho daihyoshaMeisho) {
        this.daihyoshaMeisho = daihyoshaMeisho;
    }

    /**
     * daihyoshaKanaMeishoのgetメソッドです。
     * 
     * @return daihyoshaKanaMeisho
     */
    @CheckForNull
    public AtenaKanaMeisho getDaihyoshaKanaMeisho() {
        return daihyoshaKanaMeisho;
    }

    /**
     * daihyoshaKanaMeishoのsetメソッドです。
     * 
     * @param daihyoshaKanaMeisho daihyoshaKanaMeisho
     */
    public void setDaihyoshaKanaMeisho(AtenaKanaMeisho daihyoshaKanaMeisho) {
        this.daihyoshaKanaMeisho = daihyoshaKanaMeisho;
    }

    /**
     * yakushokuのgetメソッドです。
     * 
     * @return yakushoku
     */
    @CheckForNull
    public RString getYakushoku() {
        return yakushoku;
    }

    /**
     * yakushokuのsetメソッドです。
     * 
     * @param yakushoku yakushoku
     */
    public void setYakushoku(RString yakushoku) {
        this.yakushoku = yakushoku;
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
     * このエンティティの主キーが他の{@literal DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV7505KaigoJogaiTokureiTaishoShisetsuFukushiEntity entity) {
        this.jigyoshaShubetsu = entity.jigyoshaShubetsu;
        this.jigyoshaNo = entity.jigyoshaNo;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.kannaiKangaiKubun = entity.kannaiKangaiKubun;
        this.jigyoshaMeisho = entity.jigyoshaMeisho;
        this.jigyoshaKanaMeisho = entity.jigyoshaKanaMeisho;
        this.yubinNo = entity.yubinNo;
        this.jigyoshaJusho = entity.jigyoshaJusho;
        this.jigyoshaKanaJusho = entity.jigyoshaKanaJusho;
        this.telNo = entity.telNo;
        this.faxNo = entity.faxNo;
        this.idoJiyuCode = entity.idoJiyuCode;
        this.idoYMD = entity.idoYMD;
        this.daihyoshaMeisho = entity.daihyoshaMeisho;
        this.daihyoshaKanaMeisho = entity.daihyoshaKanaMeisho;
        this.yakushoku = entity.yakushoku;
        this.biko = entity.biko;
        this.jigyoKaishiYMD = entity.jigyoKaishiYMD;
        this.jigyoKyushiYMD = entity.jigyoKyushiYMD;
        this.jigyoHaishiYMD = entity.jigyoHaishiYMD;
        this.jigyoSaikaiYMD = entity.jigyoSaikaiYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaShubetsu, jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, kannaiKangaiKubun, jigyoshaMeisho, jigyoshaKanaMeisho, yubinNo, jigyoshaJusho, jigyoshaKanaJusho, telNo, faxNo, idoJiyuCode, idoYMD, daihyoshaMeisho, daihyoshaKanaMeisho, yakushoku, biko, jigyoKaishiYMD, jigyoKyushiYMD, jigyoHaishiYMD, jigyoSaikaiYMD);
    }

// </editor-fold>
}
