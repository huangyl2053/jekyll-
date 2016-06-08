package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 国保連インターフェース管理テーブルのエンティティクラスです。
 * <br/> 国保連インターフェース管理
 */
public class DbT3104KokuhorenInterfaceKanriEntity extends DbTableEntityBase<DbT3104KokuhorenInterfaceKanriEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
    private FlexibleYearMonth shoriYM;
    @PrimaryKey
    private RString kokanShikibetsuNo;
    private RString sofuTorikomiKubun;
    private RString shoriJotaiKubun;
    private YMDHMS shoriJisshiTimestamp;
    private YMDHMS chushutsuKaishiTimestamp;
    private YMDHMS chushutsuShuryoTimestamp;
    private boolean saiShoriKanoKubun;
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
    private FlexibleYearMonth ctrlShoriYM;
    private int kagoCtrlRecordKensu;
    private FlexibleYearMonth kagoCtrlShoriYM;
    private FlexibleYearMonth jissekiDataShinsaYM;

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
     * 処理年月のgetメソッドです。
     * 
     * @return 処理年月
     */
    public FlexibleYearMonth getShoriYM() {
        return shoriYM;
    }

    /**
     * 処理年月のsetメソッドです。
     * 
     * @param shoriYM 処理年月
     */
    public void setShoriYM(@Nonnull FlexibleYearMonth shoriYM) {
        this.shoriYM = shoriYM;
    }

    /**
     * 交換情報識別番号のgetメソッドです。
     * <br/>
     * <br/>交換情報識別番号の上3桁
     * 
     * @return 交換情報識別番号
     */
    public RString getKokanShikibetsuNo() {
        return kokanShikibetsuNo;
    }

    /**
     * 交換情報識別番号のsetメソッドです。
     * <br/>
     * <br/>交換情報識別番号の上3桁
     * 
     * @param kokanShikibetsuNo 交換情報識別番号
     */
    public void setKokanShikibetsuNo(@Nonnull RString kokanShikibetsuNo) {
        this.kokanShikibetsuNo = kokanShikibetsuNo;
    }

    /**
     * 送付取込区分のgetメソッドです。
     * <br/>
     * <br/>1:送付 2:取込 3:それ以外
     * 
     * @return 送付取込区分
     */
    public RString getSofuTorikomiKubun() {
        return sofuTorikomiKubun;
    }

    /**
     * 送付取込区分のsetメソッドです。
     * <br/>
     * <br/>1:送付 2:取込 3:それ以外
     * 
     * @param sofuTorikomiKubun 送付取込区分
     */
    public void setSofuTorikomiKubun(@Nonnull RString sofuTorikomiKubun) {
        this.sofuTorikomiKubun = sofuTorikomiKubun;
    }

    /**
     * 処理状態区分のgetメソッドです。
     * <br/>
     * <br/>1:処理前 2:起動 3:終了 9:処理なし
     * 
     * @return 処理状態区分
     */
    public RString getShoriJotaiKubun() {
        return shoriJotaiKubun;
    }

    /**
     * 処理状態区分のsetメソッドです。
     * <br/>
     * <br/>1:処理前 2:起動 3:終了 9:処理なし
     * 
     * @param shoriJotaiKubun 処理状態区分
     */
    public void setShoriJotaiKubun(@Nonnull RString shoriJotaiKubun) {
        this.shoriJotaiKubun = shoriJotaiKubun;
    }

    /**
     * 処理実施日時のgetメソッドです。
     * 
     * @return 処理実施日時
     */
    @CheckForNull
    public YMDHMS getShoriJisshiTimestamp() {
        return shoriJisshiTimestamp;
    }

    /**
     * 処理実施日時のsetメソッドです。
     * 
     * @param shoriJisshiTimestamp 処理実施日時
     */
    public void setShoriJisshiTimestamp(YMDHMS shoriJisshiTimestamp) {
        this.shoriJisshiTimestamp = shoriJisshiTimestamp;
    }

    /**
     * 抽出開始日時のgetメソッドです。
     * 
     * @return 抽出開始日時
     */
    @CheckForNull
    public YMDHMS getChushutsuKaishiTimestamp() {
        return chushutsuKaishiTimestamp;
    }

    /**
     * 抽出開始日時のsetメソッドです。
     * 
     * @param chushutsuKaishiTimestamp 抽出開始日時
     */
    public void setChushutsuKaishiTimestamp(YMDHMS chushutsuKaishiTimestamp) {
        this.chushutsuKaishiTimestamp = chushutsuKaishiTimestamp;
    }

    /**
     * 抽出終了日時のgetメソッドです。
     * 
     * @return 抽出終了日時
     */
    @CheckForNull
    public YMDHMS getChushutsuShuryoTimestamp() {
        return chushutsuShuryoTimestamp;
    }

    /**
     * 抽出終了日時のsetメソッドです。
     * 
     * @param chushutsuShuryoTimestamp 抽出終了日時
     */
    public void setChushutsuShuryoTimestamp(YMDHMS chushutsuShuryoTimestamp) {
        this.chushutsuShuryoTimestamp = chushutsuShuryoTimestamp;
    }

    /**
     * 再処理可能区分のgetメソッドです。
     * <br/>
     * <br/>True:再処理可能 False:再処理不可
     * 
     * @return 再処理可能区分
     */
    public boolean getSaiShoriKanoKubun() {
        return saiShoriKanoKubun;
    }

    /**
     * 再処理可能区分のsetメソッドです。
     * <br/>
     * <br/>True:再処理可能 False:再処理不可
     * 
     * @param saiShoriKanoKubun 再処理可能区分
     */
    public void setSaiShoriKanoKubun(@Nonnull boolean saiShoriKanoKubun) {
        this.saiShoriKanoKubun = saiShoriKanoKubun;
    }

    /**
     * 処理実行回数のgetメソッドです。
     * 
     * @return 処理実行回数
     */
    @CheckForNull
    public Decimal getShoriJikkoKaisu() {
        return shoriJikkoKaisu;
    }

    /**
     * 処理実行回数のsetメソッドです。
     * 
     * @param shoriJikkoKaisu 処理実行回数
     */
    public void setShoriJikkoKaisu(Decimal shoriJikkoKaisu) {
        this.shoriJikkoKaisu = shoriJikkoKaisu;
    }

    /**
     * ファイル名称１のgetメソッドです。
     * 
     * @return ファイル名称１
     */
    @CheckForNull
    public RString getFileName1() {
        return fileName1;
    }

    /**
     * ファイル名称１のsetメソッドです。
     * 
     * @param fileName1 ファイル名称１
     */
    public void setFileName1(RString fileName1) {
        this.fileName1 = fileName1;
    }

    /**
     * ファイル名称２のgetメソッドです。
     * 
     * @return ファイル名称２
     */
    @CheckForNull
    public RString getFileName2() {
        return fileName2;
    }

    /**
     * ファイル名称２のsetメソッドです。
     * 
     * @param fileName2 ファイル名称２
     */
    public void setFileName2(RString fileName2) {
        this.fileName2 = fileName2;
    }

    /**
     * ファイル名称３のgetメソッドです。
     * 
     * @return ファイル名称３
     */
    @CheckForNull
    public RString getFileName3() {
        return fileName3;
    }

    /**
     * ファイル名称３のsetメソッドです。
     * 
     * @param fileName3 ファイル名称３
     */
    public void setFileName3(RString fileName3) {
        this.fileName3 = fileName3;
    }

    /**
     * ファイル名称４のgetメソッドです。
     * 
     * @return ファイル名称４
     */
    @CheckForNull
    public RString getFileName4() {
        return fileName4;
    }

    /**
     * ファイル名称４のsetメソッドです。
     * 
     * @param fileName4 ファイル名称４
     */
    public void setFileName4(RString fileName4) {
        this.fileName4 = fileName4;
    }

    /**
     * ファイル名称５のgetメソッドです。
     * 
     * @return ファイル名称５
     */
    @CheckForNull
    public RString getFileName5() {
        return fileName5;
    }

    /**
     * ファイル名称５のsetメソッドです。
     * 
     * @param fileName5 ファイル名称５
     */
    public void setFileName5(RString fileName5) {
        this.fileName5 = fileName5;
    }

    /**
     * ファイル件数１のgetメソッドです。
     * 
     * @return ファイル件数１
     */
    @CheckForNull
    public int getFileKensu1() {
        return fileKensu1;
    }

    /**
     * ファイル件数１のsetメソッドです。
     * 
     * @param fileKensu1 ファイル件数１
     */
    public void setFileKensu1(int fileKensu1) {
        this.fileKensu1 = fileKensu1;
    }

    /**
     * ファイル件数２のgetメソッドです。
     * 
     * @return ファイル件数２
     */
    @CheckForNull
    public int getFileKensu2() {
        return fileKensu2;
    }

    /**
     * ファイル件数２のsetメソッドです。
     * 
     * @param fileKensu2 ファイル件数２
     */
    public void setFileKensu2(int fileKensu2) {
        this.fileKensu2 = fileKensu2;
    }

    /**
     * ファイル件数３のgetメソッドです。
     * 
     * @return ファイル件数３
     */
    @CheckForNull
    public int getFileKensu3() {
        return fileKensu3;
    }

    /**
     * ファイル件数３のsetメソッドです。
     * 
     * @param fileKensu3 ファイル件数３
     */
    public void setFileKensu3(int fileKensu3) {
        this.fileKensu3 = fileKensu3;
    }

    /**
     * ファイル件数４のgetメソッドです。
     * 
     * @return ファイル件数４
     */
    @CheckForNull
    public int getFileKensu4() {
        return fileKensu4;
    }

    /**
     * ファイル件数４のsetメソッドです。
     * 
     * @param fileKensu4 ファイル件数４
     */
    public void setFileKensu4(int fileKensu4) {
        this.fileKensu4 = fileKensu4;
    }

    /**
     * ファイル件数５のgetメソッドです。
     * 
     * @return ファイル件数５
     */
    @CheckForNull
    public int getFileKensu5() {
        return fileKensu5;
    }

    /**
     * ファイル件数５のsetメソッドです。
     * 
     * @param fileKensu5 ファイル件数５
     */
    public void setFileKensu5(int fileKensu5) {
        this.fileKensu5 = fileKensu5;
    }

    /**
     * 再処理設定不可区分のgetメソッドです。
     * <br/>
     * <br/>True:再処理設定不可 false:再処理設定可能
     * 
     * @return 再処理設定不可区分
     */
    public boolean getSaiShoriFukaKubun() {
        return saiShoriFukaKubun;
    }

    /**
     * 再処理設定不可区分のsetメソッドです。
     * <br/>
     * <br/>True:再処理設定不可 false:再処理設定可能
     * 
     * @param saiShoriFukaKubun 再処理設定不可区分
     */
    public void setSaiShoriFukaKubun(@Nonnull boolean saiShoriFukaKubun) {
        this.saiShoriFukaKubun = saiShoriFukaKubun;
    }

    /**
     * コントロール上レコード件数のgetメソッドです。
     * 
     * @return コントロール上レコード件数
     */
    @CheckForNull
    public int getCtrlRecordKensu() {
        return ctrlRecordKensu;
    }

    /**
     * コントロール上レコード件数のsetメソッドです。
     * 
     * @param ctrlRecordKensu コントロール上レコード件数
     */
    public void setCtrlRecordKensu(int ctrlRecordKensu) {
        this.ctrlRecordKensu = ctrlRecordKensu;
    }

    /**
     * コントロール上処理年月のgetメソッドです。
     * 
     * @return コントロール上処理年月
     */
    @CheckForNull
    public FlexibleYearMonth getCtrlShoriYM() {
        return ctrlShoriYM;
    }

    /**
     * コントロール上処理年月のsetメソッドです。
     * 
     * @param ctrlShoriYM コントロール上処理年月
     */
    public void setCtrlShoriYM(FlexibleYearMonth ctrlShoriYM) {
        this.ctrlShoriYM = ctrlShoriYM;
    }

    /**
     * 過誤コントロール上レコード件数のgetメソッドです。
     * 
     * @return 過誤コントロール上レコード件数
     */
    @CheckForNull
    public int getKagoCtrlRecordKensu() {
        return kagoCtrlRecordKensu;
    }

    /**
     * 過誤コントロール上レコード件数のsetメソッドです。
     * 
     * @param kagoCtrlRecordKensu 過誤コントロール上レコード件数
     */
    public void setKagoCtrlRecordKensu(int kagoCtrlRecordKensu) {
        this.kagoCtrlRecordKensu = kagoCtrlRecordKensu;
    }

    /**
     * 過誤コントロール上処理年月のgetメソッドです。
     * 
     * @return 過誤コントロール上処理年月
     */
    @CheckForNull
    public FlexibleYearMonth getKagoCtrlShoriYM() {
        return kagoCtrlShoriYM;
    }

    /**
     * 過誤コントロール上処理年月のsetメソッドです。
     * 
     * @param kagoCtrlShoriYM 過誤コントロール上処理年月
     */
    public void setKagoCtrlShoriYM(FlexibleYearMonth kagoCtrlShoriYM) {
        this.kagoCtrlShoriYM = kagoCtrlShoriYM;
    }

    /**
     * 実績データ上審査年月のgetメソッドです。
     * 
     * @return 実績データ上審査年月
     */
    @CheckForNull
    public FlexibleYearMonth getJissekiDataShinsaYM() {
        return jissekiDataShinsaYM;
    }

    /**
     * 実績データ上審査年月のsetメソッドです。
     * 
     * @param jissekiDataShinsaYM 実績データ上審査年月
     */
    public void setJissekiDataShinsaYM(FlexibleYearMonth jissekiDataShinsaYM) {
        this.jissekiDataShinsaYM = jissekiDataShinsaYM;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT3104KokuhorenInterfaceKanriEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT3104KokuhorenInterfaceKanriEntity}の場合{@literal true}、それ以外の場合は{@literal false}
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
        this.saiShoriKanoKubun = entity.saiShoriKanoKubun;
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
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoriYM, kokanShikibetsuNo, sofuTorikomiKubun, shoriJotaiKubun, shoriJisshiTimestamp, chushutsuKaishiTimestamp, chushutsuShuryoTimestamp, saiShoriKanoKubun, shoriJikkoKaisu, fileName1, fileName2, fileName3, fileName4, fileName5, fileKensu1, fileKensu2, fileKensu3, fileKensu4, fileKensu5, saiShoriFukaKubun, ctrlRecordKensu, ctrlShoriYM, kagoCtrlRecordKensu, kagoCtrlShoriYM, jissekiDataShinsaYM);
    }

// </editor-fold>

}
