package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import java.util.UUID;
import java.util.Objects;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * DbT3104KokuhorenInterfaceKanriの項目定義クラスです
 *
 */
@OnNextSchema("rgdb")
public class DbT3104KokuhorenInterfaceKanriEntity extends DbTableEntityBase<DbT3104KokuhorenInterfaceKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT3104KokuhorenInterfaceKanri");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private RYearMonth shoriYM;
    @PrimaryKey
    private RString kokanShikibetsuNo;
    private RString sofuTorikomiKubun;
    private RString shoriJotaiKubun;
    private YMDHMS shoriJisshiTimestamp;
    private YMDHMS chushutsuKaishiTimestamp;
    private YMDHMS chushutsuShuryoTimestamp;
    private boolean saiShoriKahiKubun;
    private Decimal shoriJikkoKaisu;
    private RString fileName1;
    private RString fileName2;
    private RString fileName3;
    private RString fileName4;
    private RString fileName5;
    private int fileKensu1;
    private int fileKensu2;
    private int fileKensu3;
    private int fileKensu4;
    private int fileKensu5;
    private boolean saiShoriFukaKubun;
    private int ctrlRecordKensu;
    private RYearMonth ctrlShoriYM;
    private int kagoCtrlRecordKensu;
    private RYearMonth kagoCtrlShoriYM;
    private RYearMonth jissekiDataShinsaYM;

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
     * getShoriYM
     *
     * @return shoriYM
     */
    public RYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * setShoriYM
     *
     * @param shoriYM shoriYM
     */
    public void setShoriYM(RYearMonth shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * getKokanShikibetsuNo
     *
     * @return kokanShikibetsuNo
     */
    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * setKokanShikibetsuNo
     *
     * @param kokanShikibetsuNo kokanShikibetsuNo
     */
    public void setKokanShikibetsuNo(RString kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * getSofuTorikomiKubun
     *
     * @return sofuTorikomiKubun
     */
    public RString getSofuTorikomiKubun() {
        return sofuTorikomiKubun;
    }

    /**
     * setSofuTorikomiKubun
     *
     * @param sofuTorikomiKubun sofuTorikomiKubun
     */
    public void setSofuTorikomiKubun(RString sofuTorikomiKubun) {
        this.sofuTorikomiKubun = sofuTorikomiKubun;
    }

    /**
     * getShoriJotaiKubun
     *
     * @return shoriJotaiKubun
     */
    public RString getShoriJotaiKubun() {
        return shoriJotaiKubun;
    }

    /**
     * setShoriJotaiKubun
     *
     * @param shoriJotaiKubun shoriJotaiKubun
     */
    public void setShoriJotaiKubun(RString shoriJotaiKubun) {
        this.shoriJotaiKubun = shoriJotaiKubun;
    }

    /**
     * getShoriJisshiTimestamp
     *
     * @return shoriJisshiTimestamp
     */
    public YMDHMS getShoriJisshiTimestamp() {
        return shoriJisshiTimestamp;
    }

    /**
     * setShoriJisshiTimestamp
     *
     * @param shoriJisshiTimestamp shoriJisshiTimestamp
     */
    public void setShoriJisshiTimestamp(YMDHMS shoriJisshiTimestamp) {
        this.shoriJisshiTimestamp = shoriJisshiTimestamp;
    }

    /**
     * getChushutsuKaishiTimestamp
     *
     * @return chushutsuKaishiTimestamp
     */
    public YMDHMS getChushutsuKaishiTimestamp() {
        return chushutsuKaishiTimestamp;
    }

    /**
     * setChushutsuKaishiTimestamp
     *
     * @param chushutsuKaishiTimestamp chushutsuKaishiTimestamp
     */
    public void setChushutsuKaishiTimestamp(YMDHMS chushutsuKaishiTimestamp) {
        this.chushutsuKaishiTimestamp = chushutsuKaishiTimestamp;
    }

    /**
     * getChushutsuShuryoTimestamp
     *
     * @return chushutsuShuryoTimestamp
     */
    public YMDHMS getChushutsuShuryoTimestamp() {
        return chushutsuShuryoTimestamp;
    }

    /**
     * setChushutsuShuryoTimestamp
     *
     * @param chushutsuShuryoTimestamp chushutsuShuryoTimestamp
     */
    public void setChushutsuShuryoTimestamp(YMDHMS chushutsuShuryoTimestamp) {
        this.chushutsuShuryoTimestamp = chushutsuShuryoTimestamp;
    }

    /**
     * getSaiShoriKahiKubun
     *
     * @return saiShoriKahiKubun
     */
    public boolean getSaiShoriKahiKubun() {
        return saiShoriKahiKubun;
    }

    /**
     * setSaiShoriKahiKubun
     *
     * @param saiShoriKahiKubun saiShoriKahiKubun
     */
    public void setSaiShoriKahiKubun(boolean saiShoriKahiKubun) {
        this.saiShoriKahiKubun = saiShoriKahiKubun;
    }

    /**
     * getShoriJikkoKaisu
     *
     * @return shoriJikkoKaisu
     */
    public Decimal getShoriJikkoKaisu() {
        return shoriJikkoKaisu;
    }

    /**
     * setShoriJikkoKaisu
     *
     * @param shoriJikkoKaisu shoriJikkoKaisu
     */
    public void setShoriJikkoKaisu(Decimal shoriJikkoKaisu) {
        this.shoriJikkoKaisu = shoriJikkoKaisu;
    }

    /**
     * getFileName1
     *
     * @return fileName1
     */
    public RString getFileName1() {
        return fileName1;
    }

    /**
     * setFileName1
     *
     * @param fileName1 fileName1
     */
    public void setFileName1(RString fileName1) {
        this.fileName1 = fileName1;
    }

    /**
     * getFileName2
     *
     * @return fileName2
     */
    public RString getFileName2() {
        return fileName2;
    }

    /**
     * setFileName2
     *
     * @param fileName2 fileName2
     */
    public void setFileName2(RString fileName2) {
        this.fileName2 = fileName2;
    }

    /**
     * getFileName3
     *
     * @return fileName3
     */
    public RString getFileName3() {
        return fileName3;
    }

    /**
     * setFileName3
     *
     * @param fileName3 fileName3
     */
    public void setFileName3(RString fileName3) {
        this.fileName3 = fileName3;
    }

    /**
     * getFileName4
     *
     * @return fileName4
     */
    public RString getFileName4() {
        return fileName4;
    }

    /**
     * setFileName4
     *
     * @param fileName4 fileName4
     */
    public void setFileName4(RString fileName4) {
        this.fileName4 = fileName4;
    }

    /**
     * getFileName5
     *
     * @return fileName5
     */
    public RString getFileName5() {
        return fileName5;
    }

    /**
     * setFileName5
     *
     * @param fileName5 fileName5
     */
    public void setFileName5(RString fileName5) {
        this.fileName5 = fileName5;
    }

    /**
     * getFileKensu1
     *
     * @return fileKensu1
     */
    public int getFileKensu1() {
        return fileKensu1;
    }

    /**
     * setFileKensu1
     *
     * @param fileKensu1 fileKensu1
     */
    public void setFileKensu1(int fileKensu1) {
        this.fileKensu1 = fileKensu1;
    }

    /**
     * getFileKensu2
     *
     * @return fileKensu2
     */
    public int getFileKensu2() {
        return fileKensu2;
    }

    /**
     * setFileKensu2
     *
     * @param fileKensu2 fileKensu2
     */
    public void setFileKensu2(int fileKensu2) {
        this.fileKensu2 = fileKensu2;
    }

    /**
     * getFileKensu3
     *
     * @return fileKensu3
     */
    public int getFileKensu3() {
        return fileKensu3;
    }

    /**
     * setFileKensu3
     *
     * @param fileKensu3 fileKensu3
     */
    public void setFileKensu3(int fileKensu3) {
        this.fileKensu3 = fileKensu3;
    }

    /**
     * getFileKensu4
     *
     * @return fileKensu4
     */
    public int getFileKensu4() {
        return fileKensu4;
    }

    /**
     * setFileKensu4
     *
     * @param fileKensu4 fileKensu4
     */
    public void setFileKensu4(int fileKensu4) {
        this.fileKensu4 = fileKensu4;
    }

    /**
     * getFileKensu5
     *
     * @return fileKensu5
     */
    public int getFileKensu5() {
        return fileKensu5;
    }

    /**
     * setFileKensu5
     *
     * @param fileKensu5 fileKensu5
     */
    public void setFileKensu5(int fileKensu5) {
        this.fileKensu5 = fileKensu5;
    }

    /**
     * getSaiShoriFukaKubun
     *
     * @return saiShoriFukaKubun
     */
    public boolean getSaiShoriFukaKubun() {
        return saiShoriFukaKubun;
    }

    /**
     * setSaiShoriFukaKubun
     *
     * @param saiShoriFukaKubun saiShoriFukaKubun
     */
    public void setSaiShoriFukaKubun(boolean saiShoriFukaKubun) {
        this.saiShoriFukaKubun = saiShoriFukaKubun;
    }

    /**
     * getCtrlRecordKensu
     *
     * @return ctrlRecordKensu
     */
    public int getCtrlRecordKensu() {
        return ctrlRecordKensu;
    }

    /**
     * setCtrlRecordKensu
     *
     * @param ctrlRecordKensu ctrlRecordKensu
     */
    public void setCtrlRecordKensu(int ctrlRecordKensu) {
        this.ctrlRecordKensu = ctrlRecordKensu;
    }

    /**
     * getCtrlShoriYM
     *
     * @return ctrlShoriYM
     */
    public RYearMonth getCtrlShoriYM() {
        return ctrlShoriYM;
    }

    /**
     * setCtrlShoriYM
     *
     * @param ctrlShoriYM ctrlShoriYM
     */
    public void setCtrlShoriYM(RYearMonth ctrlShoriYM) {
        this.ctrlShoriYM = ctrlShoriYM;
    }

    /**
     * getKagoCtrlRecordKensu
     *
     * @return kagoCtrlRecordKensu
     */
    public int getKagoCtrlRecordKensu() {
        return kagoCtrlRecordKensu;
    }

    /**
     * setKagoCtrlRecordKensu
     *
     * @param kagoCtrlRecordKensu kagoCtrlRecordKensu
     */
    public void setKagoCtrlRecordKensu(int kagoCtrlRecordKensu) {
        this.kagoCtrlRecordKensu = kagoCtrlRecordKensu;
    }

    /**
     * getKagoCtrlShoriYM
     *
     * @return kagoCtrlShoriYM
     */
    public RYearMonth getKagoCtrlShoriYM() {
        return kagoCtrlShoriYM;
    }

    /**
     * setKagoCtrlShoriYM
     *
     * @param kagoCtrlShoriYM kagoCtrlShoriYM
     */
    public void setKagoCtrlShoriYM(RYearMonth kagoCtrlShoriYM) {
        this.kagoCtrlShoriYM = kagoCtrlShoriYM;
    }

    /**
     * getJissekiDataShinsaYM
     *
     * @return jissekiDataShinsaYM
     */
    public RYearMonth getJissekiDataShinsaYM() {
        return jissekiDataShinsaYM;
    }

    /**
     * setJissekiDataShinsaYM
     *
     * @param jissekiDataShinsaYM jissekiDataShinsaYM
     */
    public void setJissekiDataShinsaYM(RYearMonth jissekiDataShinsaYM) {
        this.jissekiDataShinsaYM = jissekiDataShinsaYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3104KokuhorenInterfaceKanriEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @@return 比較するエンティティが同じ主キーを持つ{@literal DbT3104KokuhorenInterfaceKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT3104KokuhorenInterfaceKanriEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoriYM, other.shoriYM)) {
            return false;
        }
        if (!Objects.equals(this.kokanShikibetsuNo, other.kokanShikibetsuNo)) {
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
    public void shallowCopy(DbT3104KokuhorenInterfaceKanriEntity entity) {
        this.shoriYM = entity.shoriYM;
        this.kokanShikibetsuNo = entity.kokanShikibetsuNo;
        this.sofuTorikomiKubun = entity.sofuTorikomiKubun;
        this.shoriJotaiKubun = entity.shoriJotaiKubun;
        this.shoriJisshiTimestamp = entity.shoriJisshiTimestamp;
        this.chushutsuKaishiTimestamp = entity.chushutsuKaishiTimestamp;
        this.chushutsuShuryoTimestamp = entity.chushutsuShuryoTimestamp;
        this.saiShoriKahiKubun = entity.saiShoriKahiKubun;
        this.shoriJikkoKaisu = entity.shoriJikkoKaisu;
        this.fileName1 = entity.fileName1;
        this.fileName2 = entity.fileName2;
        this.fileName3 = entity.fileName3;
        this.fileName4 = entity.fileName4;
        this.fileName5 = entity.fileName5;
        this.fileKensu1 = entity.fileKensu1;
        this.fileKensu2 = entity.fileKensu2;
        this.fileKensu3 = entity.fileKensu3;
        this.fileKensu4 = entity.fileKensu4;
        this.fileKensu5 = entity.fileKensu5;
        this.saiShoriFukaKubun = entity.saiShoriFukaKubun;
        this.ctrlRecordKensu = entity.ctrlRecordKensu;
        this.ctrlShoriYM = entity.ctrlShoriYM;
        this.kagoCtrlRecordKensu = entity.kagoCtrlRecordKensu;
        this.kagoCtrlShoriYM = entity.kagoCtrlShoriYM;
        this.jissekiDataShinsaYM = entity.jissekiDataShinsaYM;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriYM, kokanShikibetsuNo, sofuTorikomiKubun, shoriJotaiKubun, shoriJisshiTimestamp, chushutsuKaishiTimestamp, chushutsuShuryoTimestamp, saiShoriKahiKubun, shoriJikkoKaisu, fileName1, fileName2, fileName3, fileName4, fileName5, fileKensu1, fileKensu2, fileKensu3, fileKensu4, fileKensu5, saiShoriFukaKubun, ctrlRecordKensu, ctrlShoriYM, kagoCtrlRecordKensu, kagoCtrlShoriYM, jissekiDataShinsaYM);
    }

// </editor-fold>
}
