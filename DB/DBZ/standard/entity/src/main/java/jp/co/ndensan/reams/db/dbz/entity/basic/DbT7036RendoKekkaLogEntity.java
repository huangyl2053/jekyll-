package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHM;
import java.util.Objects;

/**
 * DbT7036RendoKekkaLogの項目定義クラスです
 *
 */
public class DbT7036RendoKekkaLogEntity extends DbTableEntityBase<DbT7036RendoKekkaLogEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7036RendoKekkaLog");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RString shoriNo;
    private RString shubetsu;
    private RString shoriID;
    private LasdecCode motoShichosonCode;
    private LasdecCode sakiShichosonCode;
    private RString kekkaKubun;
    private RString kakuninKubun;
    private YMDHM ShoriKaishiTimestamp;
    private YMDHM shoriShuryoTimestamp;
    private RString logFileMei;
    private RString hyojiJoken;
    private RString messeage;
    private RString rendoKeitai;
    private RString upLoad_JushinKekkaKubun;
    private RString upLoad_MojiCodeHenkanKekkaKubun;
    private RString upLoad_Shori1KekkaKubun;
    private RString upLoad_Shori2kekkaKubun;
    private RString upLoad_Shori3KekkaKubun;
    private RString downLoad_Shori1KekkaKubun;
    private RString downLoad_CodeHenkanKekkaKubun;
    private RString downLoad_MojiCodeHenkanKekkaKubun;
    private RString downLoad_Soshin1KekkaKubun;
    private RString downLoad_shori2KekkaKubun;
    private RString downLoad_Jushon1KekkaKubun;
    private RString shoriMessage1;
    private RString shoriMessage2;

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
     * getShoriNo
     * @return shoriNo
     */
    public RString getShoriNo() {
        return shoriNo;
    }

    /**
     * setShoriNo
     * @param shoriNo shoriNo
     */
    public void setShoriNo(RString shoriNo) {
        this.shoriNo = shoriNo;
    }

    /**
     * getShubetsu
     * @return shubetsu
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * setShubetsu
     * @param shubetsu shubetsu
     */
    public void setShubetsu(RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * getShoriID
     * @return shoriID
     */
    public RString getShoriID() {
        return shoriID;
    }

    /**
     * setShoriID
     * @param shoriID shoriID
     */
    public void setShoriID(RString shoriID) {
        this.shoriID = shoriID;
    }

    /**
     * getMotoShichosonCode
     * @return motoShichosonCode
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * setMotoShichosonCode
     * @param motoShichosonCode motoShichosonCode
     */
    public void setMotoShichosonCode(LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * getSakiShichosonCode
     * @return sakiShichosonCode
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * setSakiShichosonCode
     * @param sakiShichosonCode sakiShichosonCode
     */
    public void setSakiShichosonCode(LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * getKekkaKubun
     * @return kekkaKubun
     */
    public RString getKekkaKubun() {
        return kekkaKubun;
    }

    /**
     * setKekkaKubun
     * @param kekkaKubun kekkaKubun
     */
    public void setKekkaKubun(RString kekkaKubun) {
        this.kekkaKubun = kekkaKubun;
    }

    /**
     * getKakuninKubun
     * @return kakuninKubun
     */
    public RString getKakuninKubun() {
        return kakuninKubun;
    }

    /**
     * setKakuninKubun
     * @param kakuninKubun kakuninKubun
     */
    public void setKakuninKubun(RString kakuninKubun) {
        this.kakuninKubun = kakuninKubun;
    }

    /**
     * getShoriKaishiTimestamp
     * @return ShoriKaishiTimestamp
     */
    public YMDHM getShoriKaishiTimestamp() {
        return ShoriKaishiTimestamp;
    }

    /**
     * setShoriKaishiTimestamp
     * @param ShoriKaishiTimestamp ShoriKaishiTimestamp
     */
    public void setShoriKaishiTimestamp(YMDHM ShoriKaishiTimestamp) {
        this.ShoriKaishiTimestamp = ShoriKaishiTimestamp;
    }

    /**
     * getShoriShuryoTimestamp
     * @return shoriShuryoTimestamp
     */
    public YMDHM getShoriShuryoTimestamp() {
        return shoriShuryoTimestamp;
    }

    /**
     * setShoriShuryoTimestamp
     * @param shoriShuryoTimestamp shoriShuryoTimestamp
     */
    public void setShoriShuryoTimestamp(YMDHM shoriShuryoTimestamp) {
        this.shoriShuryoTimestamp = shoriShuryoTimestamp;
    }

    /**
     * getLogFileMei
     * @return logFileMei
     */
    public RString getLogFileMei() {
        return logFileMei;
    }

    /**
     * setLogFileMei
     * @param logFileMei logFileMei
     */
    public void setLogFileMei(RString logFileMei) {
        this.logFileMei = logFileMei;
    }

    /**
     * getHyojiJoken
     * @return hyojiJoken
     */
    public RString getHyojiJoken() {
        return hyojiJoken;
    }

    /**
     * setHyojiJoken
     * @param hyojiJoken hyojiJoken
     */
    public void setHyojiJoken(RString hyojiJoken) {
        this.hyojiJoken = hyojiJoken;
    }

    /**
     * getMesseage
     * @return messeage
     */
    public RString getMesseage() {
        return messeage;
    }

    /**
     * setMesseage
     * @param messeage messeage
     */
    public void setMesseage(RString messeage) {
        this.messeage = messeage;
    }

    /**
     * getRendoKeitai
     * @return rendoKeitai
     */
    public RString getRendoKeitai() {
        return rendoKeitai;
    }

    /**
     * setRendoKeitai
     * @param rendoKeitai rendoKeitai
     */
    public void setRendoKeitai(RString rendoKeitai) {
        this.rendoKeitai = rendoKeitai;
    }

    /**
     * getUpLoad_JushinKekkaKubun
     * @return upLoad_JushinKekkaKubun
     */
    public RString getUpLoad_JushinKekkaKubun() {
        return upLoad_JushinKekkaKubun;
    }

    /**
     * setUpLoad_JushinKekkaKubun
     * @param upLoad_JushinKekkaKubun upLoad_JushinKekkaKubun
     */
    public void setUpLoad_JushinKekkaKubun(RString upLoad_JushinKekkaKubun) {
        this.upLoad_JushinKekkaKubun = upLoad_JushinKekkaKubun;
    }

    /**
     * getUpLoad_MojiCodeHenkanKekkaKubun
     * @return upLoad_MojiCodeHenkanKekkaKubun
     */
    public RString getUpLoad_MojiCodeHenkanKekkaKubun() {
        return upLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * setUpLoad_MojiCodeHenkanKekkaKubun
     * @param upLoad_MojiCodeHenkanKekkaKubun upLoad_MojiCodeHenkanKekkaKubun
     */
    public void setUpLoad_MojiCodeHenkanKekkaKubun(RString upLoad_MojiCodeHenkanKekkaKubun) {
        this.upLoad_MojiCodeHenkanKekkaKubun = upLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * getUpLoad_Shori1KekkaKubun
     * @return upLoad_Shori1KekkaKubun
     */
    public RString getUpLoad_Shori1KekkaKubun() {
        return upLoad_Shori1KekkaKubun;
    }

    /**
     * setUpLoad_Shori1KekkaKubun
     * @param upLoad_Shori1KekkaKubun upLoad_Shori1KekkaKubun
     */
    public void setUpLoad_Shori1KekkaKubun(RString upLoad_Shori1KekkaKubun) {
        this.upLoad_Shori1KekkaKubun = upLoad_Shori1KekkaKubun;
    }

    /**
     * getUpLoad_Shori2kekkaKubun
     * @return upLoad_Shori2kekkaKubun
     */
    public RString getUpLoad_Shori2kekkaKubun() {
        return upLoad_Shori2kekkaKubun;
    }

    /**
     * setUpLoad_Shori2kekkaKubun
     * @param upLoad_Shori2kekkaKubun upLoad_Shori2kekkaKubun
     */
    public void setUpLoad_Shori2kekkaKubun(RString upLoad_Shori2kekkaKubun) {
        this.upLoad_Shori2kekkaKubun = upLoad_Shori2kekkaKubun;
    }

    /**
     * getUpLoad_Shori3KekkaKubun
     * @return upLoad_Shori3KekkaKubun
     */
    public RString getUpLoad_Shori3KekkaKubun() {
        return upLoad_Shori3KekkaKubun;
    }

    /**
     * setUpLoad_Shori3KekkaKubun
     * @param upLoad_Shori3KekkaKubun upLoad_Shori3KekkaKubun
     */
    public void setUpLoad_Shori3KekkaKubun(RString upLoad_Shori3KekkaKubun) {
        this.upLoad_Shori3KekkaKubun = upLoad_Shori3KekkaKubun;
    }

    /**
     * getDownLoad_Shori1KekkaKubun
     * @return downLoad_Shori1KekkaKubun
     */
    public RString getDownLoad_Shori1KekkaKubun() {
        return downLoad_Shori1KekkaKubun;
    }

    /**
     * setDownLoad_Shori1KekkaKubun
     * @param downLoad_Shori1KekkaKubun downLoad_Shori1KekkaKubun
     */
    public void setDownLoad_Shori1KekkaKubun(RString downLoad_Shori1KekkaKubun) {
        this.downLoad_Shori1KekkaKubun = downLoad_Shori1KekkaKubun;
    }

    /**
     * getDownLoad_CodeHenkanKekkaKubun
     * @return downLoad_CodeHenkanKekkaKubun
     */
    public RString getDownLoad_CodeHenkanKekkaKubun() {
        return downLoad_CodeHenkanKekkaKubun;
    }

    /**
     * setDownLoad_CodeHenkanKekkaKubun
     * @param downLoad_CodeHenkanKekkaKubun downLoad_CodeHenkanKekkaKubun
     */
    public void setDownLoad_CodeHenkanKekkaKubun(RString downLoad_CodeHenkanKekkaKubun) {
        this.downLoad_CodeHenkanKekkaKubun = downLoad_CodeHenkanKekkaKubun;
    }

    /**
     * getDownLoad_MojiCodeHenkanKekkaKubun
     * @return downLoad_MojiCodeHenkanKekkaKubun
     */
    public RString getDownLoad_MojiCodeHenkanKekkaKubun() {
        return downLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * setDownLoad_MojiCodeHenkanKekkaKubun
     * @param downLoad_MojiCodeHenkanKekkaKubun downLoad_MojiCodeHenkanKekkaKubun
     */
    public void setDownLoad_MojiCodeHenkanKekkaKubun(RString downLoad_MojiCodeHenkanKekkaKubun) {
        this.downLoad_MojiCodeHenkanKekkaKubun = downLoad_MojiCodeHenkanKekkaKubun;
    }

    /**
     * getDownLoad_Soshin1KekkaKubun
     * @return downLoad_Soshin1KekkaKubun
     */
    public RString getDownLoad_Soshin1KekkaKubun() {
        return downLoad_Soshin1KekkaKubun;
    }

    /**
     * setDownLoad_Soshin1KekkaKubun
     * @param downLoad_Soshin1KekkaKubun downLoad_Soshin1KekkaKubun
     */
    public void setDownLoad_Soshin1KekkaKubun(RString downLoad_Soshin1KekkaKubun) {
        this.downLoad_Soshin1KekkaKubun = downLoad_Soshin1KekkaKubun;
    }

    /**
     * getDownLoad_shori2KekkaKubun
     * @return downLoad_shori2KekkaKubun
     */
    public RString getDownLoad_shori2KekkaKubun() {
        return downLoad_shori2KekkaKubun;
    }

    /**
     * setDownLoad_shori2KekkaKubun
     * @param downLoad_shori2KekkaKubun downLoad_shori2KekkaKubun
     */
    public void setDownLoad_shori2KekkaKubun(RString downLoad_shori2KekkaKubun) {
        this.downLoad_shori2KekkaKubun = downLoad_shori2KekkaKubun;
    }

    /**
     * getDownLoad_Jushon1KekkaKubun
     * @return downLoad_Jushon1KekkaKubun
     */
    public RString getDownLoad_Jushon1KekkaKubun() {
        return downLoad_Jushon1KekkaKubun;
    }

    /**
     * setDownLoad_Jushon1KekkaKubun
     * @param downLoad_Jushon1KekkaKubun downLoad_Jushon1KekkaKubun
     */
    public void setDownLoad_Jushon1KekkaKubun(RString downLoad_Jushon1KekkaKubun) {
        this.downLoad_Jushon1KekkaKubun = downLoad_Jushon1KekkaKubun;
    }

    /**
     * getShoriMessage1
     * @return shoriMessage1
     */
    public RString getShoriMessage1() {
        return shoriMessage1;
    }

    /**
     * setShoriMessage1
     * @param shoriMessage1 shoriMessage1
     */
    public void setShoriMessage1(RString shoriMessage1) {
        this.shoriMessage1 = shoriMessage1;
    }

    /**
     * getShoriMessage2
     * @return shoriMessage2
     */
    public RString getShoriMessage2() {
        return shoriMessage2;
    }

    /**
     * setShoriMessage2
     * @param shoriMessage2 shoriMessage2
     */
    public void setShoriMessage2(RString shoriMessage2) {
        this.shoriMessage2 = shoriMessage2;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7036RendoKekkaLogEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @@return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7036RendoKekkaLogEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7036RendoKekkaLogEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriNo, other.shoriNo)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7036RendoKekkaLogEntity entity) {
        this.shoriNo = entity.shoriNo;
        this.shubetsu = entity.shubetsu;
        this.shoriID = entity.shoriID;
        this.motoShichosonCode = entity.motoShichosonCode;
        this.sakiShichosonCode = entity.sakiShichosonCode;
        this.kekkaKubun = entity.kekkaKubun;
        this.kakuninKubun = entity.kakuninKubun;
        this.ShoriKaishiTimestamp = entity.ShoriKaishiTimestamp;
        this.shoriShuryoTimestamp = entity.shoriShuryoTimestamp;
        this.logFileMei = entity.logFileMei;
        this.hyojiJoken = entity.hyojiJoken;
        this.messeage = entity.messeage;
        this.rendoKeitai = entity.rendoKeitai;
        this.upLoad_JushinKekkaKubun = entity.upLoad_JushinKekkaKubun;
        this.upLoad_MojiCodeHenkanKekkaKubun = entity.upLoad_MojiCodeHenkanKekkaKubun;
        this.upLoad_Shori1KekkaKubun = entity.upLoad_Shori1KekkaKubun;
        this.upLoad_Shori2kekkaKubun = entity.upLoad_Shori2kekkaKubun;
        this.upLoad_Shori3KekkaKubun = entity.upLoad_Shori3KekkaKubun;
        this.downLoad_Shori1KekkaKubun = entity.downLoad_Shori1KekkaKubun;
        this.downLoad_CodeHenkanKekkaKubun = entity.downLoad_CodeHenkanKekkaKubun;
        this.downLoad_MojiCodeHenkanKekkaKubun = entity.downLoad_MojiCodeHenkanKekkaKubun;
        this.downLoad_Soshin1KekkaKubun = entity.downLoad_Soshin1KekkaKubun;
        this.downLoad_shori2KekkaKubun = entity.downLoad_shori2KekkaKubun;
        this.downLoad_Jushon1KekkaKubun = entity.downLoad_Jushon1KekkaKubun;
        this.shoriMessage1 = entity.shoriMessage1;
        this.shoriMessage2 = entity.shoriMessage2;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriNo, shubetsu, shoriID, motoShichosonCode, sakiShichosonCode, kekkaKubun, kakuninKubun, ShoriKaishiTimestamp, shoriShuryoTimestamp, logFileMei, hyojiJoken, messeage, rendoKeitai, upLoad_JushinKekkaKubun, upLoad_MojiCodeHenkanKekkaKubun, upLoad_Shori1KekkaKubun, upLoad_Shori2kekkaKubun, upLoad_Shori3KekkaKubun, downLoad_Shori1KekkaKubun, downLoad_CodeHenkanKekkaKubun, downLoad_MojiCodeHenkanKekkaKubun, downLoad_Soshin1KekkaKubun, downLoad_shori2KekkaKubun, downLoad_Jushon1KekkaKubun, shoriMessage1, shoriMessage2);
    }

// </editor-fold>



}
