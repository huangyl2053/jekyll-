package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;

/**
 * 不服審査申立情報テーブルのエンティティクラスです。
 * <br/> 不服申立情報を管理する
 */
public class DbT7001FufukuMoshitateEntity extends DbTableEntityBase<DbT7001FufukuMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7001FufukuMoshitate");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo genshobunsHihokennshaNo;
    @PrimaryKey
    private FlexibleDate shinsaSeikyuTodokedeYMD;
    private LasdecCode shichosonCode;
    private YubinNo shinsaSeikyuninYubinNo;
    private AtenaJusho shinsaSeikyuninJusho;
    private AtenaMeisho shinsaSeikyuninShimei;
    private TelNo shinsaSeikyuninTelNo;
    private RString hihokenshaTonoKankeiCode;
    private RString hihokenshaTonoKankei;
    private YubinNo dairininYubinNo;
    private AtenaJusho dairininJusho;
    private AtenaMeisho dairininShimei;
    private TelNo dairininTelNo;
    private RString shobunCho;
    private FlexibleDate shobunYMD;
    private RString shobunShuruiCode;
    private FlexibleDate shobunKakuninYMD;
    private RString shinsaSeikyuRiyu;
    private RString shobunChoKyojiNaiyo;
    private boolean tempuShoruiTo;
    private FlexibleDate shinsaSeikyuTorisageYMD;
    private boolean bemmeishoTorokuFlag;
    private FlexibleDate bemmeishoSakuseiYMD;
    private FlexibleDate saiketsuYMD;
    private RString saiketsuKekka;
    private RString saiketsuRiyu;

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
     * 識別コードのgetメソッドです。
     * 
     * @return 識別コード
     */
    public ShikibetsuCode getShikibetsuCode() {
        return shikibetsuCode;
    }

    /**
     * 識別コードのsetメソッドです。
     * 
     * @param shikibetsuCode 識別コード
     */
    public void setShikibetsuCode(@Nonnull ShikibetsuCode shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /**
     * 原処分被保険者番号のgetメソッドです。
     * 
     * @return 原処分被保険者番号
     */
    public HihokenshaNo getGenshobunsHihokennshaNo() {
        return genshobunsHihokennshaNo;
    }

    /**
     * 原処分被保険者番号のsetメソッドです。
     * 
     * @param genshobunsHihokennshaNo 原処分被保険者番号
     */
    public void setGenshobunsHihokennshaNo(@Nonnull HihokenshaNo genshobunsHihokennshaNo) {
        this.genshobunsHihokennshaNo = genshobunsHihokennshaNo;
    }

    /**
     * 審査請求届出日のgetメソッドです。
     * 
     * @return 審査請求届出日
     */
    public FlexibleDate getShinsaSeikyuTodokedeYMD() {
        return shinsaSeikyuTodokedeYMD;
    }

    /**
     * 審査請求届出日のsetメソッドです。
     * 
     * @param shinsaSeikyuTodokedeYMD 審査請求届出日
     */
    public void setShinsaSeikyuTodokedeYMD(@Nonnull FlexibleDate shinsaSeikyuTodokedeYMD) {
        this.shinsaSeikyuTodokedeYMD = shinsaSeikyuTodokedeYMD;
    }

    /**
     * 市町村コードのgetメソッドです。
     * 
     * @return 市町村コード
     */
    @CheckForNull
    public LasdecCode getShichosonCode() {
        return shichosonCode;
    }

    /**
     * 市町村コードのsetメソッドです。
     * 
     * @param shichosonCode 市町村コード
     */
    public void setShichosonCode(LasdecCode shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /**
     * 審査請求人郵便番号のgetメソッドです。
     * 
     * @return 審査請求人郵便番号
     */
    @CheckForNull
    public YubinNo getShinsaSeikyuninYubinNo() {
        return shinsaSeikyuninYubinNo;
    }

    /**
     * 審査請求人郵便番号のsetメソッドです。
     * 
     * @param shinsaSeikyuninYubinNo 審査請求人郵便番号
     */
    public void setShinsaSeikyuninYubinNo(YubinNo shinsaSeikyuninYubinNo) {
        this.shinsaSeikyuninYubinNo = shinsaSeikyuninYubinNo;
    }

    /**
     * 審査請求人住所のgetメソッドです。
     * 
     * @return 審査請求人住所
     */
    @CheckForNull
    public AtenaJusho getShinsaSeikyuninJusho() {
        return shinsaSeikyuninJusho;
    }

    /**
     * 審査請求人住所のsetメソッドです。
     * 
     * @param shinsaSeikyuninJusho 審査請求人住所
     */
    public void setShinsaSeikyuninJusho(AtenaJusho shinsaSeikyuninJusho) {
        this.shinsaSeikyuninJusho = shinsaSeikyuninJusho;
    }

    /**
     * 審査請求人氏名のgetメソッドです。
     * 
     * @return 審査請求人氏名
     */
    @CheckForNull
    public AtenaMeisho getShinsaSeikyuninShimei() {
        return shinsaSeikyuninShimei;
    }

    /**
     * 審査請求人氏名のsetメソッドです。
     * 
     * @param shinsaSeikyuninShimei 審査請求人氏名
     */
    public void setShinsaSeikyuninShimei(AtenaMeisho shinsaSeikyuninShimei) {
        this.shinsaSeikyuninShimei = shinsaSeikyuninShimei;
    }

    /**
     * 審査請求人電話番号のgetメソッドです。
     * 
     * @return 審査請求人電話番号
     */
    @CheckForNull
    public TelNo getShinsaSeikyuninTelNo() {
        return shinsaSeikyuninTelNo;
    }

    /**
     * 審査請求人電話番号のsetメソッドです。
     * 
     * @param shinsaSeikyuninTelNo 審査請求人電話番号
     */
    public void setShinsaSeikyuninTelNo(TelNo shinsaSeikyuninTelNo) {
        this.shinsaSeikyuninTelNo = shinsaSeikyuninTelNo;
    }

    /**
     * 被保険者との関係コードのgetメソッドです。
     * 
     * @return 被保険者との関係コード
     */
    @CheckForNull
    public RString getHihokenshaTonoKankeiCode() {
        return hihokenshaTonoKankeiCode;
    }

    /**
     * 被保険者との関係コードのsetメソッドです。
     * 
     * @param hihokenshaTonoKankeiCode 被保険者との関係コード
     */
    public void setHihokenshaTonoKankeiCode(RString hihokenshaTonoKankeiCode) {
        this.hihokenshaTonoKankeiCode = hihokenshaTonoKankeiCode;
    }

    /**
     * 被保険者との関係のgetメソッドです。
     * 
     * @return 被保険者との関係
     */
    @CheckForNull
    public RString getHihokenshaTonoKankei() {
        return hihokenshaTonoKankei;
    }

    /**
     * 被保険者との関係のsetメソッドです。
     * 
     * @param hihokenshaTonoKankei 被保険者との関係
     */
    public void setHihokenshaTonoKankei(RString hihokenshaTonoKankei) {
        this.hihokenshaTonoKankei = hihokenshaTonoKankei;
    }

    /**
     * 代理人郵便番号のgetメソッドです。
     * 
     * @return 代理人郵便番号
     */
    @CheckForNull
    public YubinNo getDairininYubinNo() {
        return dairininYubinNo;
    }

    /**
     * 代理人郵便番号のsetメソッドです。
     * 
     * @param dairininYubinNo 代理人郵便番号
     */
    public void setDairininYubinNo(YubinNo dairininYubinNo) {
        this.dairininYubinNo = dairininYubinNo;
    }

    /**
     * 代理人住所のgetメソッドです。
     * 
     * @return 代理人住所
     */
    @CheckForNull
    public AtenaJusho getDairininJusho() {
        return dairininJusho;
    }

    /**
     * 代理人住所のsetメソッドです。
     * 
     * @param dairininJusho 代理人住所
     */
    public void setDairininJusho(AtenaJusho dairininJusho) {
        this.dairininJusho = dairininJusho;
    }

    /**
     * 代理人氏名のgetメソッドです。
     * 
     * @return 代理人氏名
     */
    @CheckForNull
    public AtenaMeisho getDairininShimei() {
        return dairininShimei;
    }

    /**
     * 代理人氏名のsetメソッドです。
     * 
     * @param dairininShimei 代理人氏名
     */
    public void setDairininShimei(AtenaMeisho dairininShimei) {
        this.dairininShimei = dairininShimei;
    }

    /**
     * 代理人電話番号のgetメソッドです。
     * 
     * @return 代理人電話番号
     */
    @CheckForNull
    public TelNo getDairininTelNo() {
        return dairininTelNo;
    }

    /**
     * 代理人電話番号のsetメソッドです。
     * 
     * @param dairininTelNo 代理人電話番号
     */
    public void setDairininTelNo(TelNo dairininTelNo) {
        this.dairininTelNo = dairininTelNo;
    }

    /**
     * 処分庁のgetメソッドです。
     * 
     * @return 処分庁
     */
    @CheckForNull
    public RString getShobunCho() {
        return shobunCho;
    }

    /**
     * 処分庁のsetメソッドです。
     * 
     * @param shobunCho 処分庁
     */
    public void setShobunCho(RString shobunCho) {
        this.shobunCho = shobunCho;
    }

    /**
     * 処分日のgetメソッドです。
     * 
     * @return 処分日
     */
    @CheckForNull
    public FlexibleDate getShobunYMD() {
        return shobunYMD;
    }

    /**
     * 処分日のsetメソッドです。
     * 
     * @param shobunYMD 処分日
     */
    public void setShobunYMD(FlexibleDate shobunYMD) {
        this.shobunYMD = shobunYMD;
    }

    /**
     * 処分種類コードのgetメソッドです。
     * 
     * @return 処分種類コード
     */
    @CheckForNull
    public RString getShobunShuruiCode() {
        return shobunShuruiCode;
    }

    /**
     * 処分種類コードのsetメソッドです。
     * 
     * @param shobunShuruiCode 処分種類コード
     */
    public void setShobunShuruiCode(RString shobunShuruiCode) {
        this.shobunShuruiCode = shobunShuruiCode;
    }

    /**
     * 処分があったことを知った日のgetメソッドです。
     * 
     * @return 処分があったことを知った日
     */
    @CheckForNull
    public FlexibleDate getShobunKakuninYMD() {
        return shobunKakuninYMD;
    }

    /**
     * 処分があったことを知った日のsetメソッドです。
     * 
     * @param shobunKakuninYMD 処分があったことを知った日
     */
    public void setShobunKakuninYMD(FlexibleDate shobunKakuninYMD) {
        this.shobunKakuninYMD = shobunKakuninYMD;
    }

    /**
     * 審査請求の理由のgetメソッドです。
     * 
     * @return 審査請求の理由
     */
    @CheckForNull
    public RString getShinsaSeikyuRiyu() {
        return shinsaSeikyuRiyu;
    }

    /**
     * 審査請求の理由のsetメソッドです。
     * 
     * @param shinsaSeikyuRiyu 審査請求の理由
     */
    public void setShinsaSeikyuRiyu(RString shinsaSeikyuRiyu) {
        this.shinsaSeikyuRiyu = shinsaSeikyuRiyu;
    }

    /**
     * 処分庁教示の有無及び教示の内容のgetメソッドです。
     * 
     * @return 処分庁教示の有無及び教示の内容
     */
    @CheckForNull
    public RString getShobunChoKyojiNaiyo() {
        return shobunChoKyojiNaiyo;
    }

    /**
     * 処分庁教示の有無及び教示の内容のsetメソッドです。
     * 
     * @param shobunChoKyojiNaiyo 処分庁教示の有無及び教示の内容
     */
    public void setShobunChoKyojiNaiyo(RString shobunChoKyojiNaiyo) {
        this.shobunChoKyojiNaiyo = shobunChoKyojiNaiyo;
    }

    /**
     * 添付書類等のgetメソッドです。
     * 
     * @return 添付書類等
     */
    @CheckForNull
    public boolean getTempuShoruiTo() {
        return tempuShoruiTo;
    }

    /**
     * 添付書類等のsetメソッドです。
     * 
     * @param tempuShoruiTo 添付書類等
     */
    public void setTempuShoruiTo(boolean tempuShoruiTo) {
        this.tempuShoruiTo = tempuShoruiTo;
    }

    /**
     * 審査請求取下日のgetメソッドです。
     * 
     * @return 審査請求取下日
     */
    @CheckForNull
    public FlexibleDate getShinsaSeikyuTorisageYMD() {
        return shinsaSeikyuTorisageYMD;
    }

    /**
     * 審査請求取下日のsetメソッドです。
     * 
     * @param shinsaSeikyuTorisageYMD 審査請求取下日
     */
    public void setShinsaSeikyuTorisageYMD(FlexibleDate shinsaSeikyuTorisageYMD) {
        this.shinsaSeikyuTorisageYMD = shinsaSeikyuTorisageYMD;
    }

    /**
     * 弁明書登録フラグのgetメソッドです。
     * 
     * @return 弁明書登録フラグ
     */
    @CheckForNull
    public boolean getBemmeishoTorokuFlag() {
        return bemmeishoTorokuFlag;
    }

    /**
     * 弁明書登録フラグのsetメソッドです。
     * 
     * @param bemmeishoTorokuFlag 弁明書登録フラグ
     */
    public void setBemmeishoTorokuFlag(boolean bemmeishoTorokuFlag) {
        this.bemmeishoTorokuFlag = bemmeishoTorokuFlag;
    }

    /**
     * 弁明書作成日のgetメソッドです。
     * 
     * @return 弁明書作成日
     */
    @CheckForNull
    public FlexibleDate getBemmeishoSakuseiYMD() {
        return bemmeishoSakuseiYMD;
    }

    /**
     * 弁明書作成日のsetメソッドです。
     * 
     * @param bemmeishoSakuseiYMD 弁明書作成日
     */
    public void setBemmeishoSakuseiYMD(FlexibleDate bemmeishoSakuseiYMD) {
        this.bemmeishoSakuseiYMD = bemmeishoSakuseiYMD;
    }

    /**
     * 裁決日のgetメソッドです。
     * 
     * @return 裁決日
     */
    @CheckForNull
    public FlexibleDate getSaiketsuYMD() {
        return saiketsuYMD;
    }

    /**
     * 裁決日のsetメソッドです。
     * 
     * @param saiketsuYMD 裁決日
     */
    public void setSaiketsuYMD(FlexibleDate saiketsuYMD) {
        this.saiketsuYMD = saiketsuYMD;
    }

    /**
     * 裁決結果のgetメソッドです。
     * 
     * @return 裁決結果
     */
    @CheckForNull
    public RString getSaiketsuKekka() {
        return saiketsuKekka;
    }

    /**
     * 裁決結果のsetメソッドです。
     * 
     * @param saiketsuKekka 裁決結果
     */
    public void setSaiketsuKekka(RString saiketsuKekka) {
        this.saiketsuKekka = saiketsuKekka;
    }

    /**
     * 裁決理由のgetメソッドです。
     * 
     * @return 裁決理由
     */
    @CheckForNull
    public RString getSaiketsuRiyu() {
        return saiketsuRiyu;
    }

    /**
     * 裁決理由のsetメソッドです。
     * 
     * @param saiketsuRiyu 裁決理由
     */
    public void setSaiketsuRiyu(RString saiketsuRiyu) {
        this.saiketsuRiyu = saiketsuRiyu;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7001FufukuMoshitateEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7001FufukuMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7001FufukuMoshitateEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shikibetsuCode, other.shikibetsuCode)) {
            return false;
        }
        if (!Objects.equals(this.genshobunsHihokennshaNo, other.genshobunsHihokennshaNo)) {
            return false;
        }
        if (!Objects.equals(this.shinsaSeikyuTodokedeYMD, other.shinsaSeikyuTodokedeYMD)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7001FufukuMoshitateEntity entity) {
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunsHihokennshaNo = entity.genshobunsHihokennshaNo;
        this.shinsaSeikyuTodokedeYMD = entity.shinsaSeikyuTodokedeYMD;
        this.shichosonCode = entity.shichosonCode;
        this.shinsaSeikyuninYubinNo = entity.shinsaSeikyuninYubinNo;
        this.shinsaSeikyuninJusho = entity.shinsaSeikyuninJusho;
        this.shinsaSeikyuninShimei = entity.shinsaSeikyuninShimei;
        this.shinsaSeikyuninTelNo = entity.shinsaSeikyuninTelNo;
        this.hihokenshaTonoKankeiCode = entity.hihokenshaTonoKankeiCode;
        this.hihokenshaTonoKankei = entity.hihokenshaTonoKankei;
        this.dairininYubinNo = entity.dairininYubinNo;
        this.dairininJusho = entity.dairininJusho;
        this.dairininShimei = entity.dairininShimei;
        this.dairininTelNo = entity.dairininTelNo;
        this.shobunCho = entity.shobunCho;
        this.shobunYMD = entity.shobunYMD;
        this.shobunShuruiCode = entity.shobunShuruiCode;
        this.shobunKakuninYMD = entity.shobunKakuninYMD;
        this.shinsaSeikyuRiyu = entity.shinsaSeikyuRiyu;
        this.shobunChoKyojiNaiyo = entity.shobunChoKyojiNaiyo;
        this.tempuShoruiTo = entity.tempuShoruiTo;
        this.shinsaSeikyuTorisageYMD = entity.shinsaSeikyuTorisageYMD;
        this.bemmeishoTorokuFlag = entity.bemmeishoTorokuFlag;
        this.bemmeishoSakuseiYMD = entity.bemmeishoSakuseiYMD;
        this.saiketsuYMD = entity.saiketsuYMD;
        this.saiketsuKekka = entity.saiketsuKekka;
        this.saiketsuRiyu = entity.saiketsuRiyu;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shikibetsuCode, genshobunsHihokennshaNo, shinsaSeikyuTodokedeYMD, shichosonCode, shinsaSeikyuninYubinNo, shinsaSeikyuninJusho, shinsaSeikyuninShimei, shinsaSeikyuninTelNo, hihokenshaTonoKankeiCode, hihokenshaTonoKankei, dairininYubinNo, dairininJusho, dairininShimei, dairininTelNo, shobunCho, shobunYMD, shobunShuruiCode, shobunKakuninYMD, shinsaSeikyuRiyu, shobunChoKyojiNaiyo, tempuShoruiTo, shinsaSeikyuTorisageYMD, bemmeishoTorokuFlag, bemmeishoSakuseiYMD, saiketsuYMD, saiketsuKekka, saiketsuRiyu);
    }

// </editor-fold>

}
