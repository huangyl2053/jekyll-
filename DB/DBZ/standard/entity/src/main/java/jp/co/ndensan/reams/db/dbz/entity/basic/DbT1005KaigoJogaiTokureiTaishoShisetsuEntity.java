package jp.co.ndensan.reams.db.dbz.entity.basic;

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
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;

/**
 * DbT1005KaigoJogaiTokureiTaishoShisetsuの項目定義クラスです
 *
 */
public class DbT1005KaigoJogaiTokureiTaishoShisetsuEntity extends DbTableEntityBase<DbT1005KaigoJogaiTokureiTaishoShisetsuEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT1005KaigoJogaiTokureiTaishoShisetsu");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString jigyoshaShubetsu;
    @PrimaryKey
    private RString jigyoshaNo;
    @PrimaryKey
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
     * getJigyoshaShubetsu
     *
     * @return jigyoshaShubetsu
     */
    public RString getJigyoshaShubetsu() {
        return jigyoshaShubetsu;
    }

    /**
     * setJigyoshaShubetsu
     *
     * @param jigyoshaShubetsu jigyoshaShubetsu
     */
    public void setJigyoshaShubetsu(RString jigyoshaShubetsu) {
        this.jigyoshaShubetsu = jigyoshaShubetsu;
    }

    /**
     * getJigyoshaNo
     *
     * @return jigyoshaNo
     */
    public RString getJigyoshaNo() {
        return jigyoshaNo;
    }

    /**
     * setJigyoshaNo
     *
     * @param jigyoshaNo jigyoshaNo
     */
    public void setJigyoshaNo(RString jigyoshaNo) {
        this.jigyoshaNo = jigyoshaNo;
    }

    /**
     * getYukoKaishiYMD
     *
     * @return yukoKaishiYMD
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * setYukoKaishiYMD
     *
     * @param yukoKaishiYMD yukoKaishiYMD
     */
    public void setYukoKaishiYMD(FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * getYukoShuryoYMD
     *
     * @return yukoShuryoYMD
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * setYukoShuryoYMD
     *
     * @param yukoShuryoYMD yukoShuryoYMD
     */
    public void setYukoShuryoYMD(FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * getKannaiKangaiKubun
     *
     * @return kannaiKangaiKubun
     */
    public RString getKannaiKangaiKubun() {
        return kannaiKangaiKubun;
    }

    /**
     * setKannaiKangaiKubun
     *
     * @param kannaiKangaiKubun kannaiKangaiKubun
     */
    public void setKannaiKangaiKubun(RString kannaiKangaiKubun) {
        this.kannaiKangaiKubun = kannaiKangaiKubun;
    }

    /**
     * getJigyoshaMeisho
     *
     * @return jigyoshaMeisho
     */
    public AtenaMeisho getJigyoshaMeisho() {
        return jigyoshaMeisho;
    }

    /**
     * setJigyoshaMeisho
     *
     * @param jigyoshaMeisho jigyoshaMeisho
     */
    public void setJigyoshaMeisho(AtenaMeisho jigyoshaMeisho) {
        this.jigyoshaMeisho = jigyoshaMeisho;
    }

    /**
     * getJigyoshaKanaMeisho
     *
     * @return jigyoshaKanaMeisho
     */
    public AtenaKanaMeisho getJigyoshaKanaMeisho() {
        return jigyoshaKanaMeisho;
    }

    /**
     * setJigyoshaKanaMeisho
     *
     * @param jigyoshaKanaMeisho jigyoshaKanaMeisho
     */
    public void setJigyoshaKanaMeisho(AtenaKanaMeisho jigyoshaKanaMeisho) {
        this.jigyoshaKanaMeisho = jigyoshaKanaMeisho;
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
     * getJigyoshaJusho
     *
     * @return jigyoshaJusho
     */
    public RString getJigyoshaJusho() {
        return jigyoshaJusho;
    }

    /**
     * setJigyoshaJusho
     *
     * @param jigyoshaJusho jigyoshaJusho
     */
    public void setJigyoshaJusho(RString jigyoshaJusho) {
        this.jigyoshaJusho = jigyoshaJusho;
    }

    /**
     * getJigyoshaKanaJusho
     *
     * @return jigyoshaKanaJusho
     */
    public RString getJigyoshaKanaJusho() {
        return jigyoshaKanaJusho;
    }

    /**
     * setJigyoshaKanaJusho
     *
     * @param jigyoshaKanaJusho jigyoshaKanaJusho
     */
    public void setJigyoshaKanaJusho(RString jigyoshaKanaJusho) {
        this.jigyoshaKanaJusho = jigyoshaKanaJusho;
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
     * getFaxNo
     *
     * @return faxNo
     */
    public TelNo getFaxNo() {
        return faxNo;
    }

    /**
     * setFaxNo
     *
     * @param faxNo faxNo
     */
    public void setFaxNo(TelNo faxNo) {
        this.faxNo = faxNo;
    }

    /**
     * getIdoJiyuCode
     *
     * @return idoJiyuCode
     */
    public RString getIdoJiyuCode() {
        return idoJiyuCode;
    }

    /**
     * setIdoJiyuCode
     *
     * @param idoJiyuCode idoJiyuCode
     */
    public void setIdoJiyuCode(RString idoJiyuCode) {
        this.idoJiyuCode = idoJiyuCode;
    }

    /**
     * getIdoYMD
     *
     * @return idoYMD
     */
    public FlexibleDate getIdoYMD() {
        return idoYMD;
    }

    /**
     * setIdoYMD
     *
     * @param idoYMD idoYMD
     */
    public void setIdoYMD(FlexibleDate idoYMD) {
        this.idoYMD = idoYMD;
    }

    /**
     * getDaihyoshaMeisho
     *
     * @return daihyoshaMeisho
     */
    public AtenaMeisho getDaihyoshaMeisho() {
        return daihyoshaMeisho;
    }

    /**
     * setDaihyoshaMeisho
     *
     * @param daihyoshaMeisho daihyoshaMeisho
     */
    public void setDaihyoshaMeisho(AtenaMeisho daihyoshaMeisho) {
        this.daihyoshaMeisho = daihyoshaMeisho;
    }

    /**
     * getDaihyoshaKanaMeisho
     *
     * @return daihyoshaKanaMeisho
     */
    public AtenaKanaMeisho getDaihyoshaKanaMeisho() {
        return daihyoshaKanaMeisho;
    }

    /**
     * setDaihyoshaKanaMeisho
     *
     * @param daihyoshaKanaMeisho daihyoshaKanaMeisho
     */
    public void setDaihyoshaKanaMeisho(AtenaKanaMeisho daihyoshaKanaMeisho) {
        this.daihyoshaKanaMeisho = daihyoshaKanaMeisho;
    }

    /**
     * getYakushoku
     *
     * @return yakushoku
     */
    public RString getYakushoku() {
        return yakushoku;
    }

    /**
     * setYakushoku
     *
     * @param yakushoku yakushoku
     */
    public void setYakushoku(RString yakushoku) {
        this.yakushoku = yakushoku;
    }

    /**
     * getBiko
     *
     * @return biko
     */
    public RString getBiko() {
        return biko;
    }

    /**
     * setBiko
     *
     * @param biko biko
     */
    public void setBiko(RString biko) {
        this.biko = biko;
    }

    /**
     * getJigyoKaishiYMD
     *
     * @return jigyoKaishiYMD
     */
    public FlexibleDate getJigyoKaishiYMD() {
        return jigyoKaishiYMD;
    }

    /**
     * setJigyoKaishiYMD
     *
     * @param jigyoKaishiYMD jigyoKaishiYMD
     */
    public void setJigyoKaishiYMD(FlexibleDate jigyoKaishiYMD) {
        this.jigyoKaishiYMD = jigyoKaishiYMD;
    }

    /**
     * getJigyoKyushiYMD
     *
     * @return jigyoKyushiYMD
     */
    public FlexibleDate getJigyoKyushiYMD() {
        return jigyoKyushiYMD;
    }

    /**
     * setJigyoKyushiYMD
     *
     * @param jigyoKyushiYMD jigyoKyushiYMD
     */
    public void setJigyoKyushiYMD(FlexibleDate jigyoKyushiYMD) {
        this.jigyoKyushiYMD = jigyoKyushiYMD;
    }

    /**
     * getJigyoHaishiYMD
     *
     * @return jigyoHaishiYMD
     */
    public FlexibleDate getJigyoHaishiYMD() {
        return jigyoHaishiYMD;
    }

    /**
     * setJigyoHaishiYMD
     *
     * @param jigyoHaishiYMD jigyoHaishiYMD
     */
    public void setJigyoHaishiYMD(FlexibleDate jigyoHaishiYMD) {
        this.jigyoHaishiYMD = jigyoHaishiYMD;
    }

    /**
     * getJigyoSaikaiYMD
     *
     * @return jigyoSaikaiYMD
     */
    public FlexibleDate getJigyoSaikaiYMD() {
        return jigyoSaikaiYMD;
    }

    /**
     * setJigyoSaikaiYMD
     *
     * @param jigyoSaikaiYMD jigyoSaikaiYMD
     */
    public void setJigyoSaikaiYMD(FlexibleDate jigyoSaikaiYMD) {
        this.jigyoSaikaiYMD = jigyoSaikaiYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT1005KaigoJogaiTokureiTaishoShisetsuEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.jigyoshaShubetsu, other.jigyoshaShubetsu)) {
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
    public void shallowCopy(DbT1005KaigoJogaiTokureiTaishoShisetsuEntity entity) {
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(jigyoshaShubetsu, jigyoshaNo, yukoKaishiYMD, yukoShuryoYMD, kannaiKangaiKubun, jigyoshaMeisho, jigyoshaKanaMeisho, yubinNo, jigyoshaJusho, jigyoshaKanaJusho, telNo, faxNo, idoJiyuCode, idoYMD, daihyoshaMeisho, daihyoshaKanaMeisho, yakushoku, biko, jigyoKaishiYMD, jigyoKyushiYMD, jigyoHaishiYMD, jigyoSaikaiYMD);
    }

// </editor-fold>
}
