package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * DbTKyufuInCtrlTempTableの項目定義クラスです
 *
 */
public class DbTKyufuInCtrlTempTableEntity extends DbTableEntityBase<DbTKyufuInCtrlTempTableEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbTKyufuInCtrlTempTable");

    private RString recordShubetsu;
    private RString recordNo;
    private RString volumeRenban;
    private RString recordKensu;
    private RString dataShubetsu;
    private RString fukushijimushoTokuteiNo;
    private RString hokenshaNo;
    private RString jigyoshoNo;
    private RString todofukenNo;
    private RString baitaiKubun;
    private RString shoriTaishoYM;
    private RString fileKanriNo;
    private RString fileBunruiCode;
    private RString jissekiDataShinsaYM;

    /**
     * getRecordShubetsu
     *
     * @return recordShubetsu
     */
    public RString getRecordShubetsu() {
        return recordShubetsu;
    }

    /**
     * setRecordShubetsu
     *
     * @param recordShubetsu recordShubetsu
     */
    public void setRecordShubetsu(RString recordShubetsu) {
        this.recordShubetsu = recordShubetsu;
    }

    /**
     * getRecordNo
     *
     * @return recordNo
     */
    public RString getRecordNo() {
        return recordNo;
    }

    /**
     * setRecordNo
     *
     * @param recordNo recordNo
     */
    public void setRecordNo(RString recordNo) {
        this.recordNo = recordNo;
    }

    /**
     * getVolumeRenban
     *
     * @return volumeRenban
     */
    public RString getVolumeRenban() {
        return volumeRenban;
    }

    /**
     * setVolumeRenban
     *
     * @param volumeRenban volumeRenban
     */
    public void setVolumeRenban(RString volumeRenban) {
        this.volumeRenban = volumeRenban;
    }

    /**
     * getRecordKensu
     *
     * @return recordKensu
     */
    public RString getRecordKensu() {
        return recordKensu;
    }

    /**
     * setRecordKensu
     *
     * @param recordKensu recordKensu
     */
    public void setRecordKensu(RString recordKensu) {
        this.recordKensu = recordKensu;
    }

    /**
     * getDataShubetsu
     *
     * @return dataShubetsu
     */
    public RString getDataShubetsu() {
        return dataShubetsu;
    }

    /**
     * setDataShubetsu
     *
     * @param dataShubetsu dataShubetsu
     */
    public void setDataShubetsu(RString dataShubetsu) {
        this.dataShubetsu = dataShubetsu;
    }

    /**
     * getFukushijimushoTokuteiNo
     *
     * @return fukushijimushoTokuteiNo
     */
    public RString getFukushijimushoTokuteiNo() {
        return fukushijimushoTokuteiNo;
    }

    /**
     * setFukushijimushoTokuteiNo
     *
     * @param fukushijimushoTokuteiNo fukushijimushoTokuteiNo
     */
    public void setFukushijimushoTokuteiNo(RString fukushijimushoTokuteiNo) {
        this.fukushijimushoTokuteiNo = fukushijimushoTokuteiNo;
    }

    /**
     * getHokenshaNo
     *
     * @return hokenshaNo
     */
    public RString getHokenshaNo() {
        return hokenshaNo;
    }

    /**
     * setHokenshaNo
     *
     * @param hokenshaNo hokenshaNo
     */
    public void setHokenshaNo(RString hokenshaNo) {
        this.hokenshaNo = hokenshaNo;
    }

    /**
     * getJigyoshoNo
     *
     * @return jigyoshoNo
     */
    public RString getJigyoshoNo() {
        return jigyoshoNo;
    }

    /**
     * setJigyoshoNo
     *
     * @param jigyoshoNo jigyoshoNo
     */
    public void setJigyoshoNo(RString jigyoshoNo) {
        this.jigyoshoNo = jigyoshoNo;
    }

    /**
     * getTodofukenNo
     *
     * @return todofukenNo
     */
    public RString getTodofukenNo() {
        return todofukenNo;
    }

    /**
     * setTodofukenNo
     *
     * @param todofukenNo todofukenNo
     */
    public void setTodofukenNo(RString todofukenNo) {
        this.todofukenNo = todofukenNo;
    }

    /**
     * getBaitaiKubun
     *
     * @return baitaiKubun
     */
    public RString getBaitaiKubun() {
        return baitaiKubun;
    }

    /**
     * setBaitaiKubun
     *
     * @param baitaiKubun baitaiKubun
     */
    public void setBaitaiKubun(RString baitaiKubun) {
        this.baitaiKubun = baitaiKubun;
    }

    /**
     * getShoriTaishoYM
     *
     * @return shoriTaishoYM
     */
    public RString getShoriTaishoYM() {
        return shoriTaishoYM;
    }

    /**
     * setShoriTaishoYM
     *
     * @param shoriTaishoYM shoriTaishoYM
     */
    public void setShoriTaishoYM(RString shoriTaishoYM) {
        this.shoriTaishoYM = shoriTaishoYM;
    }

    /**
     * getFileKanriNo
     *
     * @return fileKanriNo
     */
    public RString getFileKanriNo() {
        return fileKanriNo;
    }

    /**
     * setFileKanriNo
     *
     * @param fileKanriNo fileKanriNo
     */
    public void setFileKanriNo(RString fileKanriNo) {
        this.fileKanriNo = fileKanriNo;
    }

    /**
     * getFileBunruiCode
     *
     * @return fileBunruiCode
     */
    public RString getFileBunruiCode() {
        return fileBunruiCode;
    }

    /**
     * setFileBunruiCode
     *
     * @param fileBunruiCode fileBunruiCode
     */
    public void setFileBunruiCode(RString fileBunruiCode) {
        this.fileBunruiCode = fileBunruiCode;
    }

    /**
     * getJissekiDataShinsaYM
     *
     * @return jissekiDataShinsaYM
     */
    public RString getJissekiDataShinsaYM() {
        return jissekiDataShinsaYM;
    }

    /**
     * setJissekiDataShinsaYM
     *
     * @param jissekiDataShinsaYM jissekiDataShinsaYM
     */
    public void setJissekiDataShinsaYM(RString jissekiDataShinsaYM) {
        this.jissekiDataShinsaYM = jissekiDataShinsaYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbTKyufuInCtrlTempTableEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbTKyufuInCtrlTempTableEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbTKyufuInCtrlTempTableEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbTKyufuInCtrlTempTableEntity entity) {
        this.recordShubetsu = entity.recordShubetsu;
        this.recordNo = entity.recordNo;
        this.volumeRenban = entity.volumeRenban;
        this.recordKensu = entity.recordKensu;
        this.dataShubetsu = entity.dataShubetsu;
        this.fukushijimushoTokuteiNo = entity.fukushijimushoTokuteiNo;
        this.hokenshaNo = entity.hokenshaNo;
        this.jigyoshoNo = entity.jigyoshoNo;
        this.todofukenNo = entity.todofukenNo;
        this.baitaiKubun = entity.baitaiKubun;
        this.shoriTaishoYM = entity.shoriTaishoYM;
        this.fileKanriNo = entity.fileKanriNo;
        this.fileBunruiCode = entity.fileBunruiCode;
        this.jissekiDataShinsaYM = entity.jissekiDataShinsaYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(recordShubetsu, recordNo, volumeRenban, recordKensu, dataShubetsu, fukushijimushoTokuteiNo, hokenshaNo, jigyoshoNo, todofukenNo, baitaiKubun, shoriTaishoYM, fileKanriNo, fileBunruiCode, jissekiDataShinsaYM);
    }

// </editor-fold>
}
