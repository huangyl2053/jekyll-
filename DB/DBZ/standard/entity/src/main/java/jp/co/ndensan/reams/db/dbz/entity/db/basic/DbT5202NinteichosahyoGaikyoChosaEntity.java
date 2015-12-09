package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況調査）（子）テーブルのエンティティクラスです。
 */
public class DbT5202NinteichosahyoGaikyoChosaEntity extends DbTableEntityBase<DbT5202NinteichosahyoGaikyoChosaEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5202NinteichosahyoGaikyoChosa");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShinseishoKanriNo shinseishoKanriNo;
    @PrimaryKey
    private int ninteichosaRirekiNo;
    private Code koroshoIfShikibetsuCode;
    private Code ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code chosaItakuKubunCode;
    private Code ninteiChosaKubunCode;
    private JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private RDateTime jisshiBashoImageSharedFileId;
    private Code serviceKubunCode;
    private RString riyoShisetsuShimei;
    private AtenaJusho riyoShisetsuJusho;
    private TelNo riyoShisetsuTelNo;
    private YubinNo riyoShisetsuYubinNo;
    private RDateTime riyoShisetsuNameImageSharedFileId;
    private RDateTime riyoShisetsuJushoImageSharedFileId;
    private RDateTime riyoShisetsuTelNoImageSharedFileId;
    private RString tokki;
    private RDateTime tokkiImageSharedFileId;
    private FlexibleDate tokkijikoUketsukeYMD;
    private FlexibleDate tokkijikoJuryoYMD;

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
     * 申請書管理番号のgetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * <br/>
     * <br/>要介護認定申請情報
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(@Nonnull ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 認定調査依頼履歴番号のgetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     *
     * @return 認定調査依頼履歴番号
     */
    public int getNinteichosaRirekiNo() {
        return ninteichosaRirekiNo;
    }

    /**
     * 認定調査依頼履歴番号のsetメソッドです。
     * <br/>
     * <br/>認定調査依頼情報
     *
     * @param ninteichosaRirekiNo 認定調査依頼履歴番号
     */
    public void setNinteichosaRirekiNo(@Nonnull int ninteichosaRirekiNo) {
        this.ninteichosaRirekiNo = ninteichosaRirekiNo;
    }

    /**
     * 厚労省IF識別コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     *
     * @return 厚労省IF識別コード
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * 厚労省IF識別コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）パーティショニングのCheck項目
     *
     * @param koroshoIfShikibetsuCode 厚労省IF識別コード
     */
    public void setKoroshoIfShikibetsuCode(@Nonnull Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * 認定調査依頼区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）
     *
     * @return 認定調査依頼区分コード
     */
    public Code getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査依頼区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認定調査依頼区分コード）
     *
     * @param ninteichousaIraiKubunCode 認定調査依頼区分コード
     */
    public void setNinteichousaIraiKubunCode(@Nonnull Code ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    /**
     * 認定調査回数のgetメソッドです。
     *
     * @return 認定調査回数
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * 認定調査回数のsetメソッドです。
     *
     * @param ninteichosaIraiKaisu 認定調査回数
     */
    public void setNinteichosaIraiKaisu(@Nonnull int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * 認定調査実施年月日のgetメソッドです。
     *
     * @return 認定調査実施年月日
     */
    public FlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    /**
     * 認定調査実施年月日のsetメソッドです。
     *
     * @param ninteichosaJisshiYMD 認定調査実施年月日
     */
    public void setNinteichosaJisshiYMD(@Nonnull FlexibleDate ninteichosaJisshiYMD) {
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    /**
     * 認定調査受領年月日のgetメソッドです。
     *
     * @return 認定調査受領年月日
     */
    public FlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    /**
     * 認定調査受領年月日のsetメソッドです。
     *
     * @param ninteichosaJuryoYMD 認定調査受領年月日
     */
    public void setNinteichosaJuryoYMD(@Nonnull FlexibleDate ninteichosaJuryoYMD) {
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    /**
     * 調査委託区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     *
     * @return 調査委託区分コード
     */
    public Code getChosaItakuKubunCode() {
        return chosaItakuKubunCode;
    }

    /**
     * 調査委託区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査委託区分）
     *
     * @param chosaItakuKubunCode 調査委託区分コード
     */
    public void setChosaItakuKubunCode(@Nonnull Code chosaItakuKubunCode) {
        this.chosaItakuKubunCode = chosaItakuKubunCode;
    }

    /**
     * 認定調査区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査区分）
     *
     * @return 認定調査区分コード
     */
    public Code getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    /**
     * 認定調査区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査区分）
     *
     * @param ninteiChosaKubunCode 認定調査区分コード
     */
    public void setNinteiChosaKubunCode(@Nonnull Code ninteiChosaKubunCode) {
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    /**
     * 認定調査委託先コードのgetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * 認定調査委託先コードのsetメソッドです。
     * <br/>
     * <br/>認定調査委託先情報
     *
     * @param chosaItakusakiCode 認定調査委託先コード
     */
    public void setChosaItakusakiCode(@Nonnull JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * 認定調査員コードのgetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     *
     * @return 認定調査員コード
     */
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * 認定調査員コードのsetメソッドです。
     * <br/>
     * <br/>認定調査員情報
     *
     * @param chosainCode 認定調査員コード
     */
    public void setChosainCode(@Nonnull RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * 認定調査実施場所コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査実施場所コード）
     *
     * @return 認定調査実施場所コード
     */
    public Code getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    /**
     * 認定調査実施場所コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：調査実施場所コード）
     *
     * @param chosaJisshiBashoCode 認定調査実施場所コード
     */
    public void setChosaJisshiBashoCode(@Nonnull Code chosaJisshiBashoCode) {
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    /**
     * 認定調査実施場所名称のgetメソッドです。
     *
     * @return 認定調査実施場所名称
     */
    @CheckForNull
    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    /**
     * 認定調査実施場所名称のsetメソッドです。
     *
     * @param chosaJisshiBashoMeisho 認定調査実施場所名称
     */
    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    /**
     * 実施場所イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 実施場所イメージ共有ファイルID
     */
    @CheckForNull
    public RDateTime getJisshiBashoImageSharedFileId() {
        return jisshiBashoImageSharedFileId;
    }

    /**
     * 実施場所イメージ共有ファイルIDのsetメソッドです。
     *
     * @param jisshiBashoImageSharedFileId 実施場所イメージ共有ファイルID
     */
    public void setJisshiBashoImageSharedFileId(RDateTime jisshiBashoImageSharedFileId) {
        this.jisshiBashoImageSharedFileId = jisshiBashoImageSharedFileId;
    }

    /**
     * 認定調査・サービス区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在のサービス区分コード）
     *
     * @return 認定調査・サービス区分コード
     */
    public Code getServiceKubunCode() {
        return serviceKubunCode;
    }

    /**
     * 認定調査・サービス区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：現在のサービス区分コード）
     *
     * @param serviceKubunCode 認定調査・サービス区分コード
     */
    public void setServiceKubunCode(@Nonnull Code serviceKubunCode) {
        this.serviceKubunCode = serviceKubunCode;
    }

    /**
     * 利用施設名のgetメソッドです。
     *
     * @return 利用施設名
     */
    @CheckForNull
    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    /**
     * 利用施設名のsetメソッドです。
     *
     * @param riyoShisetsuShimei 利用施設名
     */
    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    /**
     * 利用施設住所のgetメソッドです。
     *
     * @return 利用施設住所
     */
    @CheckForNull
    public AtenaJusho getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    /**
     * 利用施設住所のsetメソッドです。
     *
     * @param riyoShisetsuJusho 利用施設住所
     */
    public void setRiyoShisetsuJusho(AtenaJusho riyoShisetsuJusho) {
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    /**
     * 利用施設電話番号のgetメソッドです。
     *
     * @return 利用施設電話番号
     */
    @CheckForNull
    public TelNo getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    /**
     * 利用施設電話番号のsetメソッドです。
     *
     * @param riyoShisetsuTelNo 利用施設電話番号
     */
    public void setRiyoShisetsuTelNo(TelNo riyoShisetsuTelNo) {
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    /**
     * 利用施設郵便番号のgetメソッドです。
     *
     * @return 利用施設郵便番号
     */
    @CheckForNull
    public YubinNo getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    /**
     * 利用施設郵便番号のsetメソッドです。
     *
     * @param riyoShisetsuYubinNo 利用施設郵便番号
     */
    public void setRiyoShisetsuYubinNo(YubinNo riyoShisetsuYubinNo) {
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    /**
     * 利用施設名イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 利用施設名イメージ共有ファイルID
     */
    @CheckForNull
    public RDateTime getRiyoShisetsuNameImageSharedFileId() {
        return riyoShisetsuNameImageSharedFileId;
    }

    /**
     * 利用施設名イメージ共有ファイルIDのsetメソッドです。
     *
     * @param riyoShisetsuNameImageSharedFileId 利用施設名イメージ共有ファイルID
     */
    public void setRiyoShisetsuNameImageSharedFileId(RDateTime riyoShisetsuNameImageSharedFileId) {
        this.riyoShisetsuNameImageSharedFileId = riyoShisetsuNameImageSharedFileId;
    }

    /**
     * 利用施設住所イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 利用施設住所イメージ共有ファイルID
     */
    @CheckForNull
    public RDateTime getRiyoShisetsuJushoImageSharedFileId() {
        return riyoShisetsuJushoImageSharedFileId;
    }

    /**
     * 利用施設住所イメージ共有ファイルIDのsetメソッドです。
     *
     * @param riyoShisetsuJushoImageSharedFileId 利用施設住所イメージ共有ファイルID
     */
    public void setRiyoShisetsuJushoImageSharedFileId(RDateTime riyoShisetsuJushoImageSharedFileId) {
        this.riyoShisetsuJushoImageSharedFileId = riyoShisetsuJushoImageSharedFileId;
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 利用施設電話番号イメージ共有ファイルID
     */
    @CheckForNull
    public RDateTime getRiyoShisetsuTelNoImageSharedFileId() {
        return riyoShisetsuTelNoImageSharedFileId;
    }

    /**
     * 利用施設電話番号イメージ共有ファイルIDのsetメソッドです。
     *
     * @param riyoShisetsuTelNoImageSharedFileId 利用施設電話番号イメージ共有ファイルID
     */
    public void setRiyoShisetsuTelNoImageSharedFileId(RDateTime riyoShisetsuTelNoImageSharedFileId) {
        this.riyoShisetsuTelNoImageSharedFileId = riyoShisetsuTelNoImageSharedFileId;
    }

    /**
     * 特記のgetメソッドです。
     *
     * @return 特記
     */
    public RString getTokki() {
        return tokki;
    }

    /**
     * 特記のsetメソッドです。
     *
     * @param tokki 特記
     */
    public void setTokki(@Nonnull RString tokki) {
        this.tokki = tokki;
    }

    /**
     * 特記イメージ共有ファイルIDのgetメソッドです。
     *
     * @return 特記イメージ共有ファイルID
     */
    @CheckForNull
    public RDateTime getTokkiImageSharedFileId() {
        return tokkiImageSharedFileId;
    }

    /**
     * 特記イメージ共有ファイルIDのsetメソッドです。
     *
     * @param tokkiImageSharedFileId 特記イメージ共有ファイルID
     */
    public void setTokkiImageSharedFileId(RDateTime tokkiImageSharedFileId) {
        this.tokkiImageSharedFileId = tokkiImageSharedFileId;
    }

    /**
     * 認定調査特記事項受付年月日のgetメソッドです。
     *
     * @return 認定調査特記事項受付年月日
     */
    @CheckForNull
    public FlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    /**
     * 認定調査特記事項受付年月日のsetメソッドです。
     *
     * @param tokkijikoUketsukeYMD 認定調査特記事項受付年月日
     */
    public void setTokkijikoUketsukeYMD(FlexibleDate tokkijikoUketsukeYMD) {
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    /**
     * 認定調査特記事項受領年月日のgetメソッドです。
     *
     * @return 認定調査特記事項受領年月日
     */
    @CheckForNull
    public FlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    /**
     * 認定調査特記事項受領年月日のsetメソッドです。
     *
     * @param tokkijikoJuryoYMD 認定調査特記事項受領年月日
     */
    public void setTokkijikoJuryoYMD(FlexibleDate tokkijikoJuryoYMD) {
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5202NinteichosahyoGaikyoChosaEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5202NinteichosahyoGaikyoChosaEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5202NinteichosahyoGaikyoChosaEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5202NinteichosahyoGaikyoChosaEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninteichousaIraiKubunCode = entity.ninteichousaIraiKubunCode;
        this.ninteichosaIraiKaisu = entity.ninteichosaIraiKaisu;
        this.ninteichosaJisshiYMD = entity.ninteichosaJisshiYMD;
        this.ninteichosaJuryoYMD = entity.ninteichosaJuryoYMD;
        this.chosaItakuKubunCode = entity.chosaItakuKubunCode;
        this.ninteiChosaKubunCode = entity.ninteiChosaKubunCode;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.chosaJisshiBashoCode = entity.chosaJisshiBashoCode;
        this.chosaJisshiBashoMeisho = entity.chosaJisshiBashoMeisho;
        this.jisshiBashoImageSharedFileId = entity.jisshiBashoImageSharedFileId;
        this.serviceKubunCode = entity.serviceKubunCode;
        this.riyoShisetsuShimei = entity.riyoShisetsuShimei;
        this.riyoShisetsuJusho = entity.riyoShisetsuJusho;
        this.riyoShisetsuTelNo = entity.riyoShisetsuTelNo;
        this.riyoShisetsuYubinNo = entity.riyoShisetsuYubinNo;
        this.riyoShisetsuNameImageSharedFileId = entity.riyoShisetsuNameImageSharedFileId;
        this.riyoShisetsuJushoImageSharedFileId = entity.riyoShisetsuJushoImageSharedFileId;
        this.riyoShisetsuTelNoImageSharedFileId = entity.riyoShisetsuTelNoImageSharedFileId;
        this.tokki = entity.tokki;
        this.tokkiImageSharedFileId = entity.tokkiImageSharedFileId;
        this.tokkijikoUketsukeYMD = entity.tokkijikoUketsukeYMD;
        this.tokkijikoJuryoYMD = entity.tokkijikoJuryoYMD;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, koroshoIfShikibetsuCode, ninteichousaIraiKubunCode, ninteichosaIraiKaisu, ninteichosaJisshiYMD, ninteichosaJuryoYMD, chosaItakuKubunCode, ninteiChosaKubunCode, chosaItakusakiCode, chosainCode, chosaJisshiBashoCode, chosaJisshiBashoMeisho, jisshiBashoImageSharedFileId, serviceKubunCode, riyoShisetsuShimei, riyoShisetsuJusho, riyoShisetsuTelNo, riyoShisetsuYubinNo, riyoShisetsuNameImageSharedFileId, riyoShisetsuJushoImageSharedFileId, riyoShisetsuTelNoImageSharedFileId, tokki, tokkiImageSharedFileId, tokkijikoUketsukeYMD, tokkijikoJuryoYMD);
    }

// </editor-fold>
}
