package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 認定調査票（概況調査）06Aテーブルのエンティティクラスです。
 */
public class DbT5202NinteichosahyoGaikyoChosa06AEntity extends DbTableEntityBase<DbT5202NinteichosahyoGaikyoChosa06AEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT5202NinteichosahyoGaikyoChosa06A");

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
    @PrimaryKey
    private RString gaikyoChosaTextImageKubun;
    private Code koroshoIfShikibetsuCode;
    private Code ninteichousaIraiKubunCode;
    private int ninteichosaIraiKaisu;
    private FlexibleDate ninteichosaJisshiYMD;
    private FlexibleDate ninteichosaJuryoYMD;
    private Code ninteiChosaKubunCode;
    private JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private Code chosaJisshiBashoCode;
    private RString chosaJisshiBashoMeisho;
    private Code serviceKubunCode;
    private RString riyoShisetsuShimei;
    private RString riyoShisetsuJusho;
    private RString riyoShisetsuTelNo;
    private YubinNo riyoShisetsuYubinNo;
    private RString tokki;
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
     * gaikyoChosaTextImageKubunのgetメソッドです。
     * 
     * @return gaikyoChosaTextImageKubun
     */
    public RString getGaikyoChosaTextImageKubun() {
        return gaikyoChosaTextImageKubun;
    }

    /**
     * gaikyoChosaTextImageKubunのsetメソッドです。
     * 
     * @param gaikyoChosaTextImageKubun gaikyoChosaTextImageKubun
     */
    public void setGaikyoChosaTextImageKubun(@Nonnull RString gaikyoChosaTextImageKubun) {
        this.gaikyoChosaTextImageKubun = gaikyoChosaTextImageKubun;
    }

    /**
     * koroshoIfShikibetsuCodeのgetメソッドです。
     * 
     * @return koroshoIfShikibetsuCode
     */
    public Code getKoroshoIfShikibetsuCode() {
        return koroshoIfShikibetsuCode;
    }

    /**
     * koroshoIfShikibetsuCodeのsetメソッドです。
     * 
     * @param koroshoIfShikibetsuCode koroshoIfShikibetsuCode
     */
    public void setKoroshoIfShikibetsuCode(@Nonnull Code koroshoIfShikibetsuCode) {
        this.koroshoIfShikibetsuCode = koroshoIfShikibetsuCode;
    }

    /**
     * ninteichousaIraiKubunCodeのgetメソッドです。
     * 
     * @return ninteichousaIraiKubunCode
     */
    public Code getNinteichousaIraiKubunCode() {
        return ninteichousaIraiKubunCode;
    }

    /**
     * ninteichousaIraiKubunCodeのsetメソッドです。
     * 
     * @param ninteichousaIraiKubunCode ninteichousaIraiKubunCode
     */
    public void setNinteichousaIraiKubunCode(@Nonnull Code ninteichousaIraiKubunCode) {
        this.ninteichousaIraiKubunCode = ninteichousaIraiKubunCode;
    }

    /**
     * ninteichosaIraiKaisuのgetメソッドです。
     * 
     * @return ninteichosaIraiKaisu
     */
    public int getNinteichosaIraiKaisu() {
        return ninteichosaIraiKaisu;
    }

    /**
     * ninteichosaIraiKaisuのsetメソッドです。
     * 
     * @param ninteichosaIraiKaisu ninteichosaIraiKaisu
     */
    public void setNinteichosaIraiKaisu(@Nonnull int ninteichosaIraiKaisu) {
        this.ninteichosaIraiKaisu = ninteichosaIraiKaisu;
    }

    /**
     * ninteichosaJisshiYMDのgetメソッドです。
     * 
     * @return ninteichosaJisshiYMD
     */
    public FlexibleDate getNinteichosaJisshiYMD() {
        return ninteichosaJisshiYMD;
    }

    /**
     * ninteichosaJisshiYMDのsetメソッドです。
     * 
     * @param ninteichosaJisshiYMD ninteichosaJisshiYMD
     */
    public void setNinteichosaJisshiYMD(@Nonnull FlexibleDate ninteichosaJisshiYMD) {
        this.ninteichosaJisshiYMD = ninteichosaJisshiYMD;
    }

    /**
     * ninteichosaJuryoYMDのgetメソッドです。
     * 
     * @return ninteichosaJuryoYMD
     */
    public FlexibleDate getNinteichosaJuryoYMD() {
        return ninteichosaJuryoYMD;
    }

    /**
     * ninteichosaJuryoYMDのsetメソッドです。
     * 
     * @param ninteichosaJuryoYMD ninteichosaJuryoYMD
     */
    public void setNinteichosaJuryoYMD(@Nonnull FlexibleDate ninteichosaJuryoYMD) {
        this.ninteichosaJuryoYMD = ninteichosaJuryoYMD;
    }

    /**
     * ninteiChosaKubunCodeのgetメソッドです。
     * 
     * @return ninteiChosaKubunCode
     */
    public Code getNinteiChosaKubunCode() {
        return ninteiChosaKubunCode;
    }

    /**
     * ninteiChosaKubunCodeのsetメソッドです。
     * 
     * @param ninteiChosaKubunCode ninteiChosaKubunCode
     */
    public void setNinteiChosaKubunCode(@Nonnull Code ninteiChosaKubunCode) {
        this.ninteiChosaKubunCode = ninteiChosaKubunCode;
    }

    /**
     * chosaItakusakiCodeのgetメソッドです。
     * 
     * @return chosaItakusakiCode
     */
    public JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * chosaItakusakiCodeのsetメソッドです。
     * 
     * @param chosaItakusakiCode chosaItakusakiCode
     */
    public void setChosaItakusakiCode(@Nonnull JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * chosainCodeのgetメソッドです。
     * 
     * @return chosainCode
     */
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * chosainCodeのsetメソッドです。
     * 
     * @param chosainCode chosainCode
     */
    public void setChosainCode(@Nonnull RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * chosaJisshiBashoCodeのgetメソッドです。
     * 
     * @return chosaJisshiBashoCode
     */
    public Code getChosaJisshiBashoCode() {
        return chosaJisshiBashoCode;
    }

    /**
     * chosaJisshiBashoCodeのsetメソッドです。
     * 
     * @param chosaJisshiBashoCode chosaJisshiBashoCode
     */
    public void setChosaJisshiBashoCode(@Nonnull Code chosaJisshiBashoCode) {
        this.chosaJisshiBashoCode = chosaJisshiBashoCode;
    }

    /**
     * chosaJisshiBashoMeishoのgetメソッドです。
     * 
     * @return chosaJisshiBashoMeisho
     */
    @CheckForNull
    public RString getChosaJisshiBashoMeisho() {
        return chosaJisshiBashoMeisho;
    }

    /**
     * chosaJisshiBashoMeishoのsetメソッドです。
     * 
     * @param chosaJisshiBashoMeisho chosaJisshiBashoMeisho
     */
    public void setChosaJisshiBashoMeisho(RString chosaJisshiBashoMeisho) {
        this.chosaJisshiBashoMeisho = chosaJisshiBashoMeisho;
    }

    /**
     * serviceKubunCodeのgetメソッドです。
     * 
     * @return serviceKubunCode
     */
    public Code getServiceKubunCode() {
        return serviceKubunCode;
    }

    /**
     * serviceKubunCodeのsetメソッドです。
     * 
     * @param serviceKubunCode serviceKubunCode
     */
    public void setServiceKubunCode(@Nonnull Code serviceKubunCode) {
        this.serviceKubunCode = serviceKubunCode;
    }

    /**
     * riyoShisetsuShimeiのgetメソッドです。
     * 
     * @return riyoShisetsuShimei
     */
    @CheckForNull
    public RString getRiyoShisetsuShimei() {
        return riyoShisetsuShimei;
    }

    /**
     * riyoShisetsuShimeiのsetメソッドです。
     * 
     * @param riyoShisetsuShimei riyoShisetsuShimei
     */
    public void setRiyoShisetsuShimei(RString riyoShisetsuShimei) {
        this.riyoShisetsuShimei = riyoShisetsuShimei;
    }

    /**
     * riyoShisetsuJushoのgetメソッドです。
     * 
     * @return riyoShisetsuJusho
     */
    @CheckForNull
    public RString getRiyoShisetsuJusho() {
        return riyoShisetsuJusho;
    }

    /**
     * riyoShisetsuJushoのsetメソッドです。
     * 
     * @param riyoShisetsuJusho riyoShisetsuJusho
     */
    public void setRiyoShisetsuJusho(RString riyoShisetsuJusho) {
        this.riyoShisetsuJusho = riyoShisetsuJusho;
    }

    /**
     * riyoShisetsuTelNoのgetメソッドです。
     * 
     * @return riyoShisetsuTelNo
     */
    @CheckForNull
    public RString getRiyoShisetsuTelNo() {
        return riyoShisetsuTelNo;
    }

    /**
     * riyoShisetsuTelNoのsetメソッドです。
     * 
     * @param riyoShisetsuTelNo riyoShisetsuTelNo
     */
    public void setRiyoShisetsuTelNo(RString riyoShisetsuTelNo) {
        this.riyoShisetsuTelNo = riyoShisetsuTelNo;
    }

    /**
     * riyoShisetsuYubinNoのgetメソッドです。
     * 
     * @return riyoShisetsuYubinNo
     */
    @CheckForNull
    public YubinNo getRiyoShisetsuYubinNo() {
        return riyoShisetsuYubinNo;
    }

    /**
     * riyoShisetsuYubinNoのsetメソッドです。
     * 
     * @param riyoShisetsuYubinNo riyoShisetsuYubinNo
     */
    public void setRiyoShisetsuYubinNo(YubinNo riyoShisetsuYubinNo) {
        this.riyoShisetsuYubinNo = riyoShisetsuYubinNo;
    }

    /**
     * tokkiのgetメソッドです。
     * 
     * @return tokki
     */
    @CheckForNull
    public RString getTokki() {
        return tokki;
    }

    /**
     * tokkiのsetメソッドです。
     * 
     * @param tokki tokki
     */
    public void setTokki(RString tokki) {
        this.tokki = tokki;
    }

    /**
     * tokkijikoUketsukeYMDのgetメソッドです。
     * 
     * @return tokkijikoUketsukeYMD
     */
    @CheckForNull
    public FlexibleDate getTokkijikoUketsukeYMD() {
        return tokkijikoUketsukeYMD;
    }

    /**
     * tokkijikoUketsukeYMDのsetメソッドです。
     * 
     * @param tokkijikoUketsukeYMD tokkijikoUketsukeYMD
     */
    public void setTokkijikoUketsukeYMD(FlexibleDate tokkijikoUketsukeYMD) {
        this.tokkijikoUketsukeYMD = tokkijikoUketsukeYMD;
    }

    /**
     * tokkijikoJuryoYMDのgetメソッドです。
     * 
     * @return tokkijikoJuryoYMD
     */
    @CheckForNull
    public FlexibleDate getTokkijikoJuryoYMD() {
        return tokkijikoJuryoYMD;
    }

    /**
     * tokkijikoJuryoYMDのsetメソッドです。
     * 
     * @param tokkijikoJuryoYMD tokkijikoJuryoYMD
     */
    public void setTokkijikoJuryoYMD(FlexibleDate tokkijikoJuryoYMD) {
        this.tokkijikoJuryoYMD = tokkijikoJuryoYMD;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5202NinteichosahyoGaikyoChosa06AEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5202NinteichosahyoGaikyoChosa06AEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5202NinteichosahyoGaikyoChosa06AEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
            return false;
        }
        if (this.ninteichosaRirekiNo != other.ninteichosaRirekiNo) {
            return false;
        }
        if (!Objects.equals(this.gaikyoChosaTextImageKubun, other.gaikyoChosaTextImageKubun)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5202NinteichosahyoGaikyoChosa06AEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ninteichosaRirekiNo = entity.ninteichosaRirekiNo;
        this.gaikyoChosaTextImageKubun = entity.gaikyoChosaTextImageKubun;
        this.koroshoIfShikibetsuCode = entity.koroshoIfShikibetsuCode;
        this.ninteichousaIraiKubunCode = entity.ninteichousaIraiKubunCode;
        this.ninteichosaIraiKaisu = entity.ninteichosaIraiKaisu;
        this.ninteichosaJisshiYMD = entity.ninteichosaJisshiYMD;
        this.ninteichosaJuryoYMD = entity.ninteichosaJuryoYMD;
        this.ninteiChosaKubunCode = entity.ninteiChosaKubunCode;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.chosaJisshiBashoCode = entity.chosaJisshiBashoCode;
        this.chosaJisshiBashoMeisho = entity.chosaJisshiBashoMeisho;
        this.serviceKubunCode = entity.serviceKubunCode;
        this.riyoShisetsuShimei = entity.riyoShisetsuShimei;
        this.riyoShisetsuJusho = entity.riyoShisetsuJusho;
        this.riyoShisetsuTelNo = entity.riyoShisetsuTelNo;
        this.riyoShisetsuYubinNo = entity.riyoShisetsuYubinNo;
        this.tokki = entity.tokki;
        this.tokkijikoUketsukeYMD = entity.tokkijikoUketsukeYMD;
        this.tokkijikoJuryoYMD = entity.tokkijikoJuryoYMD;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ninteichosaRirekiNo, gaikyoChosaTextImageKubun, koroshoIfShikibetsuCode, ninteichousaIraiKubunCode, ninteichosaIraiKaisu, ninteichosaJisshiYMD, ninteichosaJuryoYMD, ninteiChosaKubunCode, chosaItakusakiCode, chosainCode, chosaJisshiBashoCode, chosaJisshiBashoMeisho, serviceKubunCode, riyoShisetsuShimei, riyoShisetsuJusho, riyoShisetsuTelNo, riyoShisetsuYubinNo, tokki, tokkijikoUketsukeYMD, tokkijikoJuryoYMD);
    }

// </editor-fold>
}
