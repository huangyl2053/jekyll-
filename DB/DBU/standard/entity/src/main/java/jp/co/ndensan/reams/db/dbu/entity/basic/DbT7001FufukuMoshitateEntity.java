package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;

/**
 * 不服審査申立情報テーブルのエンティティクラスです。
 * <br/> 不服申立情報を管理する
 */
public class DbT7001FufukuMoshitateEntity extends DbTableEntityBase<DbT7001FufukuMoshitateEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">

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
    private ShoKisaiHokenshaNo shoKisaiHokenshaNo;
    @PrimaryKey
    private ShikibetsuCode shikibetsuCode;
    @PrimaryKey
    private HihokenshaNo genshobunsHihokennshaNo;
    @PrimaryKey
    private FlexibleDate shinsaSeikyuTodokedeYMD;
    private YubinNo genshobunHihokenshaYubinNo;
    private AtenaJusho genshobunHihokenshaJusho;
    private AtenaMeisho genshobunHihokenshaShimei;
    private TelNo genshobunHihokenshaTelNo;
    private FlexibleDate genshobunHihokenshaBirthYMD;
    private YubinNo shinsaSeikyuninYubinNo;
    private AtenaJusho shinsaSeikyuninJusho;
    private AtenaMeisho shinsaSeikyuninShimei;
    private TelNo shinsaSeikyuninTelNo;
    private Code hihokenshaTonoKankeiCode;
    private YubinNo dairininYubinNo;
    private AtenaJusho dairininJusho;
    private AtenaMeisho dairininShimei;
    private TelNo dairininTelNo;
    private RString shobunCho;
    private FlexibleDate shobunYMD;
    private Code shobunShuruiCode;
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
     * 証記載保険者番号のgetメソッドです。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo getShoKisaiHokenshaNo() {
        return shoKisaiHokenshaNo;
    }

    /**
     * 証記載保険者番号のsetメソッドです。
     *
     * @param shoKisaiHokenshaNo 証記載保険者番号
     */
    public void setShoKisaiHokenshaNo(ShoKisaiHokenshaNo shoKisaiHokenshaNo) {
        this.shoKisaiHokenshaNo = shoKisaiHokenshaNo;
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
    public void setShikibetsuCode(ShikibetsuCode shikibetsuCode) {
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
    public void setGenshobunsHihokennshaNo(HihokenshaNo genshobunsHihokennshaNo) {
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
    public void setShinsaSeikyuTodokedeYMD(FlexibleDate shinsaSeikyuTodokedeYMD) {
        this.shinsaSeikyuTodokedeYMD = shinsaSeikyuTodokedeYMD;
    }

    /**
     * 原処分被保険者郵便番号のgetメソッドです。
     *
     * @return 原処分被保険者郵便番号
     */
    public YubinNo getGenshobunHihokenshaYubinNo() {
        return genshobunHihokenshaYubinNo;
    }

    /**
     * 原処分被保険者郵便番号のsetメソッドです。
     *
     * @param genshobunHihokenshaYubinNo 原処分被保険者郵便番号
     */
    public void setGenshobunHihokenshaYubinNo(YubinNo genshobunHihokenshaYubinNo) {
        this.genshobunHihokenshaYubinNo = genshobunHihokenshaYubinNo;
    }

    /**
     * 原処分被保険者住所のgetメソッドです。
     *
     * @return 原処分被保険者住所
     */
    public AtenaJusho getGenshobunHihokenshaJusho() {
        return genshobunHihokenshaJusho;
    }

    /**
     * 原処分被保険者住所のsetメソッドです。
     *
     * @param genshobunHihokenshaJusho 原処分被保険者住所
     */
    public void setGenshobunHihokenshaJusho(AtenaJusho genshobunHihokenshaJusho) {
        this.genshobunHihokenshaJusho = genshobunHihokenshaJusho;
    }

    /**
     * 原処分被保険者氏名のgetメソッドです。
     *
     * @return 原処分被保険者氏名
     */
    public AtenaMeisho getGenshobunHihokenshaShimei() {
        return genshobunHihokenshaShimei;
    }

    /**
     * 原処分被保険者氏名のsetメソッドです。
     *
     * @param genshobunHihokenshaShimei 原処分被保険者氏名
     */
    public void setGenshobunHihokenshaShimei(AtenaMeisho genshobunHihokenshaShimei) {
        this.genshobunHihokenshaShimei = genshobunHihokenshaShimei;
    }

    /**
     * 原処分被保険者電話番号のgetメソッドです。
     *
     * @return 原処分被保険者電話番号
     */
    public TelNo getGenshobunHihokenshaTelNo() {
        return genshobunHihokenshaTelNo;
    }

    /**
     * 原処分被保険者電話番号のsetメソッドです。
     *
     * @param genshobunHihokenshaTelNo 原処分被保険者電話番号
     */
    public void setGenshobunHihokenshaTelNo(TelNo genshobunHihokenshaTelNo) {
        this.genshobunHihokenshaTelNo = genshobunHihokenshaTelNo;
    }

    /**
     * 原処分被保険者生年月日のgetメソッドです。
     *
     * @return 原処分被保険者生年月日
     */
    public FlexibleDate getGenshobunHihokenshaBirthYMD() {
        return genshobunHihokenshaBirthYMD;
    }

    /**
     * 原処分被保険者生年月日のsetメソッドです。
     *
     * @param genshobunHihokenshaBirthYMD 原処分被保険者生年月日
     */
    public void setGenshobunHihokenshaBirthYMD(FlexibleDate genshobunHihokenshaBirthYMD) {
        this.genshobunHihokenshaBirthYMD = genshobunHihokenshaBirthYMD;
    }

    /**
     * 審査請求人郵便番号のgetメソッドです。
     *
     * @return 審査請求人郵便番号
     */
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
    public Code getHihokenshaTonoKankeiCode() {
        return hihokenshaTonoKankeiCode;
    }

    /**
     * 被保険者との関係コードのsetメソッドです。
     *
     * @param hihokenshaTonoKankeiCode 被保険者との関係コード
     */
    public void setHihokenshaTonoKankeiCode(Code hihokenshaTonoKankeiCode) {
        this.hihokenshaTonoKankeiCode = hihokenshaTonoKankeiCode;
    }

    /**
     * 代理人郵便番号のgetメソッドです。
     *
     * @return 代理人郵便番号
     */
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
    public Code getShobunShuruiCode() {
        return shobunShuruiCode;
    }

    /**
     * 処分種類コードのsetメソッドです。
     *
     * @param shobunShuruiCode 処分種類コード
     */
    public void setShobunShuruiCode(Code shobunShuruiCode) {
        this.shobunShuruiCode = shobunShuruiCode;
    }

    /**
     * 処分があったことを知った日のgetメソッドです。
     *
     * @return 処分があったことを知った日
     */
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
     * @@return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7001FufukuMoshitateEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7001FufukuMoshitateEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shoKisaiHokenshaNo, other.shoKisaiHokenshaNo)) {
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
        this.shoKisaiHokenshaNo = entity.shoKisaiHokenshaNo;
        this.shikibetsuCode = entity.shikibetsuCode;
        this.genshobunsHihokennshaNo = entity.genshobunsHihokennshaNo;
        this.shinsaSeikyuTodokedeYMD = entity.shinsaSeikyuTodokedeYMD;
        this.genshobunHihokenshaYubinNo = entity.genshobunHihokenshaYubinNo;
        this.genshobunHihokenshaJusho = entity.genshobunHihokenshaJusho;
        this.genshobunHihokenshaShimei = entity.genshobunHihokenshaShimei;
        this.genshobunHihokenshaTelNo = entity.genshobunHihokenshaTelNo;
        this.genshobunHihokenshaBirthYMD = entity.genshobunHihokenshaBirthYMD;
        this.shinsaSeikyuninYubinNo = entity.shinsaSeikyuninYubinNo;
        this.shinsaSeikyuninJusho = entity.shinsaSeikyuninJusho;
        this.shinsaSeikyuninShimei = entity.shinsaSeikyuninShimei;
        this.shinsaSeikyuninTelNo = entity.shinsaSeikyuninTelNo;
        this.hihokenshaTonoKankeiCode = entity.hihokenshaTonoKankeiCode;
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
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shoKisaiHokenshaNo, shikibetsuCode, genshobunsHihokennshaNo, shinsaSeikyuTodokedeYMD, genshobunHihokenshaYubinNo, genshobunHihokenshaJusho, genshobunHihokenshaShimei, genshobunHihokenshaTelNo, genshobunHihokenshaBirthYMD, shinsaSeikyuninYubinNo, shinsaSeikyuninJusho, shinsaSeikyuninShimei, shinsaSeikyuninTelNo, hihokenshaTonoKankeiCode, dairininYubinNo, dairininJusho, dairininShimei, dairininTelNo, shobunCho, shobunYMD, shobunShuruiCode, shobunKakuninYMD, shinsaSeikyuRiyu, shobunChoKyojiNaiyo, tempuShoruiTo, shinsaSeikyuTorisageYMD, bemmeishoTorokuFlag, bemmeishoSakuseiYMD, saiketsuYMD, saiketsuKekka, saiketsuRiyu);
    }

// </editor-fold>
}
