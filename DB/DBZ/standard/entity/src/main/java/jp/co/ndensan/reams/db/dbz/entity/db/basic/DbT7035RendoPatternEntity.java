package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 連動パターンテーブルのエンティティクラスです。
 */
public class DbT7035RendoPatternEntity extends DbTableEntityBase<DbT7035RendoPatternEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7035RendoPattern");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private LasdecCode motoShichosonCode;
    @PrimaryKey
    private LasdecCode sakiShichosonCode;
    @PrimaryKey
    private RString shubetsu;
    @PrimaryKey
    private FlexibleDate yukoKaishiYMD;
    @PrimaryKey
    private FlexibleDate yukoShuryoYMD;
    private RString rendoKeitaiCode;
    private RString motoFormatVersion;
    private RString motoEncodeKeitai;
    private RString sakiFormatVersion;
    private RString sakiEncodeKeitai;
    private RString codeHenkanKubun;
    private RString gaijiHenkanKubun;
    private RString zenkenRendoKubun;
    private RString rendoKubun;
    private RString renkeiFileName;

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
     * 送信元市町村コードのgetメソッドです。
     * 
     * @return 送信元市町村コード
     */
    public LasdecCode getMotoShichosonCode() {
        return motoShichosonCode;
    }

    /**
     * 送信元市町村コードのsetメソッドです。
     * 
     * @param motoShichosonCode 送信元市町村コード
     */
    public void setMotoShichosonCode(@Nonnull LasdecCode motoShichosonCode) {
        this.motoShichosonCode = motoShichosonCode;
    }

    /**
     * 送信先市町村コードのgetメソッドです。
     * 
     * @return 送信先市町村コード
     */
    public LasdecCode getSakiShichosonCode() {
        return sakiShichosonCode;
    }

    /**
     * 送信先市町村コードのsetメソッドです。
     * 
     * @param sakiShichosonCode 送信先市町村コード
     */
    public void setSakiShichosonCode(@Nonnull LasdecCode sakiShichosonCode) {
        this.sakiShichosonCode = sakiShichosonCode;
    }

    /**
     * 種別のgetメソッドです。
     * 
     * @return 種別
     */
    public RString getShubetsu() {
        return shubetsu;
    }

    /**
     * 種別のsetメソッドです。
     * 
     * @param shubetsu 種別
     */
    public void setShubetsu(@Nonnull RString shubetsu) {
        this.shubetsu = shubetsu;
    }

    /**
     * 有効開始年月日のgetメソッドです。
     * 
     * @return 有効開始年月日
     */
    public FlexibleDate getYukoKaishiYMD() {
        return yukoKaishiYMD;
    }

    /**
     * 有効開始年月日のsetメソッドです。
     * 
     * @param yukoKaishiYMD 有効開始年月日
     */
    public void setYukoKaishiYMD(@Nonnull FlexibleDate yukoKaishiYMD) {
        this.yukoKaishiYMD = yukoKaishiYMD;
    }

    /**
     * 有効終了年月日のgetメソッドです。
     * 
     * @return 有効終了年月日
     */
    public FlexibleDate getYukoShuryoYMD() {
        return yukoShuryoYMD;
    }

    /**
     * 有効終了年月日のsetメソッドです。
     * 
     * @param yukoShuryoYMD 有効終了年月日
     */
    public void setYukoShuryoYMD(@Nonnull FlexibleDate yukoShuryoYMD) {
        this.yukoShuryoYMD = yukoShuryoYMD;
    }

    /**
     * 連動形態コードのgetメソッドです。
     * 
     * @return 連動形態コード
     */
    public RString getRendoKeitaiCode() {
        return rendoKeitaiCode;
    }

    /**
     * 連動形態コードのsetメソッドです。
     * 
     * @param rendoKeitaiCode 連動形態コード
     */
    public void setRendoKeitaiCode(@Nonnull RString rendoKeitaiCode) {
        this.rendoKeitaiCode = rendoKeitaiCode;
    }

    /**
     * 送信元フォーマットバージョンのgetメソッドです。
     * 
     * @return 送信元フォーマットバージョン
     */
    @CheckForNull
    public RString getMotoFormatVersion() {
        return motoFormatVersion;
    }

    /**
     * 送信元フォーマットバージョンのsetメソッドです。
     * 
     * @param motoFormatVersion 送信元フォーマットバージョン
     */
    public void setMotoFormatVersion(RString motoFormatVersion) {
        this.motoFormatVersion = motoFormatVersion;
    }

    /**
     * 送信元エンコーディングのgetメソッドです。
     * 
     * @return 送信元エンコーディング
     */
    @CheckForNull
    public RString getMotoEncodeKeitai() {
        return motoEncodeKeitai;
    }

    /**
     * 送信元エンコーディングのsetメソッドです。
     * 
     * @param motoEncodeKeitai 送信元エンコーディング
     */
    public void setMotoEncodeKeitai(RString motoEncodeKeitai) {
        this.motoEncodeKeitai = motoEncodeKeitai;
    }

    /**
     * 送信先フォーマットバージョンのgetメソッドです。
     * 
     * @return 送信先フォーマットバージョン
     */
    @CheckForNull
    public RString getSakiFormatVersion() {
        return sakiFormatVersion;
    }

    /**
     * 送信先フォーマットバージョンのsetメソッドです。
     * 
     * @param sakiFormatVersion 送信先フォーマットバージョン
     */
    public void setSakiFormatVersion(RString sakiFormatVersion) {
        this.sakiFormatVersion = sakiFormatVersion;
    }

    /**
     * 送信先エンコーディングのgetメソッドです。
     * 
     * @return 送信先エンコーディング
     */
    @CheckForNull
    public RString getSakiEncodeKeitai() {
        return sakiEncodeKeitai;
    }

    /**
     * 送信先エンコーディングのsetメソッドです。
     * 
     * @param sakiEncodeKeitai 送信先エンコーディング
     */
    public void setSakiEncodeKeitai(RString sakiEncodeKeitai) {
        this.sakiEncodeKeitai = sakiEncodeKeitai;
    }

    /**
     * コード変換区分のgetメソッドです。
     * 
     * @return コード変換区分
     */
    @CheckForNull
    public RString getCodeHenkanKubun() {
        return codeHenkanKubun;
    }

    /**
     * コード変換区分のsetメソッドです。
     * 
     * @param codeHenkanKubun コード変換区分
     */
    public void setCodeHenkanKubun(RString codeHenkanKubun) {
        this.codeHenkanKubun = codeHenkanKubun;
    }

    /**
     * 外字変換区分のgetメソッドです。
     * 
     * @return 外字変換区分
     */
    @CheckForNull
    public RString getGaijiHenkanKubun() {
        return gaijiHenkanKubun;
    }

    /**
     * 外字変換区分のsetメソッドです。
     * 
     * @param gaijiHenkanKubun 外字変換区分
     */
    public void setGaijiHenkanKubun(RString gaijiHenkanKubun) {
        this.gaijiHenkanKubun = gaijiHenkanKubun;
    }

    /**
     * 全件連動区分のgetメソッドです。
     * 
     * @return 全件連動区分
     */
    @CheckForNull
    public RString getZenkenRendoKubun() {
        return zenkenRendoKubun;
    }

    /**
     * 全件連動区分のsetメソッドです。
     * 
     * @param zenkenRendoKubun 全件連動区分
     */
    public void setZenkenRendoKubun(RString zenkenRendoKubun) {
        this.zenkenRendoKubun = zenkenRendoKubun;
    }

    /**
     * 連携区分のgetメソッドです。
     * 
     * @return 連携区分
     */
    @CheckForNull
    public RString getRendoKubun() {
        return rendoKubun;
    }

    /**
     * 連携区分のsetメソッドです。
     * 
     * @param rendoKubun 連携区分
     */
    public void setRendoKubun(RString rendoKubun) {
        this.rendoKubun = rendoKubun;
    }

    /**
     * 連携ファイル名のgetメソッドです。
     * <br/>
     * <br/>連携するファイル名称を拡張子付きで定義する。
     * <br/>編集書式：
     * <br/> @日時@　・・・ 年月日時分秒（14桁）
     * <br/> @市町村コード@　・・・　市町村コード（6桁）
     * 
     * @return 連携ファイル名
     */
    @CheckForNull
    public RString getRenkeiFileName() {
        return renkeiFileName;
    }

    /**
     * 連携ファイル名のsetメソッドです。
     * <br/>
     * <br/>連携するファイル名称を拡張子付きで定義する。
     * <br/>編集書式：
     * <br/> @日時@　・・・ 年月日時分秒（14桁）
     * <br/> @市町村コード@　・・・　市町村コード（6桁）
     * 
     * @param renkeiFileName 連携ファイル名
     */
    public void setRenkeiFileName(RString renkeiFileName) {
        this.renkeiFileName = renkeiFileName;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7035RendoPatternEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7035RendoPatternEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7035RendoPatternEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.motoShichosonCode, other.motoShichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.sakiShichosonCode, other.sakiShichosonCode)) {
            return false;
        }
        if (!Objects.equals(this.shubetsu, other.shubetsu)) {
            return false;
        }
        if (!Objects.equals(this.yukoKaishiYMD, other.yukoKaishiYMD)) {
            return false;
        }
        if (!Objects.equals(this.yukoShuryoYMD, other.yukoShuryoYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7035RendoPatternEntity entity) {
        this.motoShichosonCode = entity.motoShichosonCode;
        this.sakiShichosonCode = entity.sakiShichosonCode;
        this.shubetsu = entity.shubetsu;
        this.yukoKaishiYMD = entity.yukoKaishiYMD;
        this.yukoShuryoYMD = entity.yukoShuryoYMD;
        this.rendoKeitaiCode = entity.rendoKeitaiCode;
        this.motoFormatVersion = entity.motoFormatVersion;
        this.motoEncodeKeitai = entity.motoEncodeKeitai;
        this.sakiFormatVersion = entity.sakiFormatVersion;
        this.sakiEncodeKeitai = entity.sakiEncodeKeitai;
        this.codeHenkanKubun = entity.codeHenkanKubun;
        this.gaijiHenkanKubun = entity.gaijiHenkanKubun;
        this.zenkenRendoKubun = entity.zenkenRendoKubun;
        this.rendoKubun = entity.rendoKubun;
        this.renkeiFileName = entity.renkeiFileName;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(motoShichosonCode, sakiShichosonCode, shubetsu, yukoKaishiYMD, yukoShuryoYMD, rendoKeitaiCode, motoFormatVersion, motoEncodeKeitai, sakiFormatVersion, sakiEncodeKeitai, codeHenkanKubun, gaijiHenkanKubun, zenkenRendoKubun, rendoKubun, renkeiFileName);
    }

// </editor-fold>
}
