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

/**
 * 他市町村住所地特例者台帳管理Aliveテーブルのエンティティクラスです。
 */
public class DbV1005KaigoJogaiTokureiTaishoShisetsuEntity extends DbTableEntityBase<DbV1005KaigoJogaiTokureiTaishoShisetsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbV1005KaigoJogaiTokureiTaishoShisetsu");

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
     * このエンティティの主キーが他の{@literal DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbV1005KaigoJogaiTokureiTaishoShisetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbV1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
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
