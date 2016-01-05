package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 帳票制御共通コントロールテーブルのエンティティクラスです。
 * <br/> 帳票制御共通項目について、使用状況を管理します。
     * <br/>共通の帳票制御メンテナンス画面への表示にも使用します。
 */
public class DbT7066ChohyoSeigyoKyotsuControlEntity extends DbTableEntityBase<DbT7066ChohyoSeigyoKyotsuControlEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT7066ChohyoSeigyoKyotsuControl");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    @PrimaryKey
    private SubGyomuCode subGyomuCode;
    @PrimaryKey
    private ReportId chohyoBunruiID;
    private boolean kyotsuGamenShiyoUmu;
    private RString bunshoNoShiyoKubun;
    private RString tsuchishoTeikeibunShiyoKubun;
    private RString ninshoshaShiyoKubun;
    private RString chohyoShuturyokujunShiyoKubun;
    private RString chohyoShuturyokujunHyojiHohho;
    private RString kaigoToiawasesakiShiyoKubun;
    private RString jushoHenshuShiyoKubun;
    private RString setainushiHyojiShiyoKubun;
    private RString dainoninHyojiShiyoKubun;
    private RString customerBarCodeShiyoKubun;
    private RString gaibuChohyoMojigireSeigyoShiyoKubun;
    private RString naibuChohyoMojigireSeigyoShiyoKubun;
    private RString mojigireBunriSeigyoShiyoKubun;
    private RString teikeibunMojiSizeShiyoKubun;
    private RString kozaMaskShiyoKubun;
    private RString kozaMeigininKanaYusenShiyoKubun;
    private RString daikoPrintShiyoKubun;
    private RString chikuhyojiShiyoKubun;

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
     * サブ業務コードのgetメソッドです。
     * 
     * @return サブ業務コード
     */
    public SubGyomuCode getSubGyomuCode() {
        return subGyomuCode;
    }

    /**
     * サブ業務コードのsetメソッドです。
     * 
     * @param subGyomuCode サブ業務コード
     */
    public void setSubGyomuCode(@Nonnull SubGyomuCode subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /**
     * 帳票分類IDのgetメソッドです。
     * 
     * @return 帳票分類ID
     */
    public ReportId getChohyoBunruiID() {
        return chohyoBunruiID;
    }

    /**
     * 帳票分類IDのsetメソッドです。
     * 
     * @param chohyoBunruiID 帳票分類ID
     */
    public void setChohyoBunruiID(@Nonnull ReportId chohyoBunruiID) {
        this.chohyoBunruiID = chohyoBunruiID;
    }

    /**
     * 共通画面使用有無のgetメソッドです。
     * 
     * @return 共通画面使用有無
     */
    public boolean getKyotsuGamenShiyoUmu() {
        return kyotsuGamenShiyoUmu;
    }

    /**
     * 共通画面使用有無のsetメソッドです。
     * 
     * @param kyotsuGamenShiyoUmu 共通画面使用有無
     */
    public void setKyotsuGamenShiyoUmu(@Nonnull boolean kyotsuGamenShiyoUmu) {
        this.kyotsuGamenShiyoUmu = kyotsuGamenShiyoUmu;
    }

    /**
     * 文書番号使用区分のgetメソッドです。
     * <br/>
     * <br/>UR文書番号管理の使用状況を管理　
     * <br/>0：使用しない　
     * <br/>1：画面表示不可（使用はする）　
     * <br/>2：画面表示可
     * 
     * @return 文書番号使用区分
     */
    @CheckForNull
    public RString getBunshoNoShiyoKubun() {
        return bunshoNoShiyoKubun;
    }

    /**
     * 文書番号使用区分のsetメソッドです。
     * <br/>
     * <br/>UR文書番号管理の使用状況を管理　
     * <br/>0：使用しない　
     * <br/>1：画面表示不可（使用はする）　
     * <br/>2：画面表示可
     * 
     * @param bunshoNoShiyoKubun 文書番号使用区分
     */
    public void setBunshoNoShiyoKubun(RString bunshoNoShiyoKubun) {
        this.bunshoNoShiyoKubun = bunshoNoShiyoKubun;
    }

    /**
     * 通知書定型文使用区分のgetメソッドです。
     * <br/>
     * <br/>UR通知書定型文の使用状況を管理
     * 
     * @return 通知書定型文使用区分
     */
    @CheckForNull
    public RString getTsuchishoTeikeibunShiyoKubun() {
        return tsuchishoTeikeibunShiyoKubun;
    }

    /**
     * 通知書定型文使用区分のsetメソッドです。
     * <br/>
     * <br/>UR通知書定型文の使用状況を管理
     * 
     * @param tsuchishoTeikeibunShiyoKubun 通知書定型文使用区分
     */
    public void setTsuchishoTeikeibunShiyoKubun(RString tsuchishoTeikeibunShiyoKubun) {
        this.tsuchishoTeikeibunShiyoKubun = tsuchishoTeikeibunShiyoKubun;
    }

    /**
     * 認証者使用区分のgetメソッドです。
     * <br/>
     * <br/>UR認証者の使用状況を管理
     * 
     * @return 認証者使用区分
     */
    @CheckForNull
    public RString getNinshoshaShiyoKubun() {
        return ninshoshaShiyoKubun;
    }

    /**
     * 認証者使用区分のsetメソッドです。
     * <br/>
     * <br/>UR認証者の使用状況を管理
     * 
     * @param ninshoshaShiyoKubun 認証者使用区分
     */
    public void setNinshoshaShiyoKubun(RString ninshoshaShiyoKubun) {
        this.ninshoshaShiyoKubun = ninshoshaShiyoKubun;
    }

    /**
     * 帳票出力順使用区分のgetメソッドです。
     * <br/>
     * <br/>UR帳票出力順の使用状況を管理
     * 
     * @return 帳票出力順使用区分
     */
    @CheckForNull
    public RString getChohyoShuturyokujunShiyoKubun() {
        return chohyoShuturyokujunShiyoKubun;
    }

    /**
     * 帳票出力順使用区分のsetメソッドです。
     * <br/>
     * <br/>UR帳票出力順の使用状況を管理
     * 
     * @param chohyoShuturyokujunShiyoKubun 帳票出力順使用区分
     */
    public void setChohyoShuturyokujunShiyoKubun(RString chohyoShuturyokujunShiyoKubun) {
        this.chohyoShuturyokujunShiyoKubun = chohyoShuturyokujunShiyoKubun;
    }

    /**
     * 帳票出力順表示方法のgetメソッドです。
     * <br/>
     * <br/>UR帳票出力順を使用する場合のモード
     * <br/>1：ALL（すべてを表示）
     * <br/>2：SORT_ONLY（出力順のみ表示）
     * <br/>3：SHUKEI_NONE（出力順、改頁を表示）
     * <br/>4：KAIPEJIJOKEN_NONE（出力順、集計を表示）
     * 
     * @return 帳票出力順表示方法
     */
    @CheckForNull
    public RString getChohyoShuturyokujunHyojiHohho() {
        return chohyoShuturyokujunHyojiHohho;
    }

    /**
     * 帳票出力順表示方法のsetメソッドです。
     * <br/>
     * <br/>UR帳票出力順を使用する場合のモード
     * <br/>1：ALL（すべてを表示）
     * <br/>2：SORT_ONLY（出力順のみ表示）
     * <br/>3：SHUKEI_NONE（出力順、改頁を表示）
     * <br/>4：KAIPEJIJOKEN_NONE（出力順、集計を表示）
     * 
     * @param chohyoShuturyokujunHyojiHohho 帳票出力順表示方法
     */
    public void setChohyoShuturyokujunHyojiHohho(RString chohyoShuturyokujunHyojiHohho) {
        this.chohyoShuturyokujunHyojiHohho = chohyoShuturyokujunHyojiHohho;
    }

    /**
     * 介護問合せ先使用区分のgetメソッドです。
     * <br/>
     * <br/>介護問合せ先の使用状況を管理
     * 
     * @return 介護問合せ先使用区分
     */
    @CheckForNull
    public RString getKaigoToiawasesakiShiyoKubun() {
        return kaigoToiawasesakiShiyoKubun;
    }

    /**
     * 介護問合せ先使用区分のsetメソッドです。
     * <br/>
     * <br/>介護問合せ先の使用状況を管理
     * 
     * @param kaigoToiawasesakiShiyoKubun 介護問合せ先使用区分
     */
    public void setKaigoToiawasesakiShiyoKubun(RString kaigoToiawasesakiShiyoKubun) {
        this.kaigoToiawasesakiShiyoKubun = kaigoToiawasesakiShiyoKubun;
    }

    /**
     * 住所編集使用区分のgetメソッドです。
     * <br/>
     * <br/>住所編集都道府県名表示有無　
     * <br/>住所編集郡名表示有無　
     * <br/>住所編集市町村名表示有無　
     * <br/>住所編集町域編集方法　
     * <br/>住所編集方書表示有無
     * 
     * @return 住所編集使用区分
     */
    @CheckForNull
    public RString getJushoHenshuShiyoKubun() {
        return jushoHenshuShiyoKubun;
    }

    /**
     * 住所編集使用区分のsetメソッドです。
     * <br/>
     * <br/>住所編集都道府県名表示有無　
     * <br/>住所編集郡名表示有無　
     * <br/>住所編集市町村名表示有無　
     * <br/>住所編集町域編集方法　
     * <br/>住所編集方書表示有無
     * 
     * @param jushoHenshuShiyoKubun 住所編集使用区分
     */
    public void setJushoHenshuShiyoKubun(RString jushoHenshuShiyoKubun) {
        this.jushoHenshuShiyoKubun = jushoHenshuShiyoKubun;
    }

    /**
     * 世帯主表示使用区分のgetメソッドです。
     * 
     * @return 世帯主表示使用区分
     */
    @CheckForNull
    public RString getSetainushiHyojiShiyoKubun() {
        return setainushiHyojiShiyoKubun;
    }

    /**
     * 世帯主表示使用区分のsetメソッドです。
     * 
     * @param setainushiHyojiShiyoKubun 世帯主表示使用区分
     */
    public void setSetainushiHyojiShiyoKubun(RString setainushiHyojiShiyoKubun) {
        this.setainushiHyojiShiyoKubun = setainushiHyojiShiyoKubun;
    }

    /**
     * 代納人表示使用区分のgetメソッドです。
     * 
     * @return 代納人表示使用区分
     */
    @CheckForNull
    public RString getDainoninHyojiShiyoKubun() {
        return dainoninHyojiShiyoKubun;
    }

    /**
     * 代納人表示使用区分のsetメソッドです。
     * 
     * @param dainoninHyojiShiyoKubun 代納人表示使用区分
     */
    public void setDainoninHyojiShiyoKubun(RString dainoninHyojiShiyoKubun) {
        this.dainoninHyojiShiyoKubun = dainoninHyojiShiyoKubun;
    }

    /**
     * カスタマバーコード使用区分のgetメソッドです。
     * <br/>
     * <br/>カスタマバーコード使用有無、
     * <br/>カスタマバーコード変換エラー編集方法
     * 
     * @return カスタマバーコード使用区分
     */
    @CheckForNull
    public RString getCustomerBarCodeShiyoKubun() {
        return customerBarCodeShiyoKubun;
    }

    /**
     * カスタマバーコード使用区分のsetメソッドです。
     * <br/>
     * <br/>カスタマバーコード使用有無、
     * <br/>カスタマバーコード変換エラー編集方法
     * 
     * @param customerBarCodeShiyoKubun カスタマバーコード使用区分
     */
    public void setCustomerBarCodeShiyoKubun(RString customerBarCodeShiyoKubun) {
        this.customerBarCodeShiyoKubun = customerBarCodeShiyoKubun;
    }

    /**
     * 外部帳票文字切れ制御使用区分のgetメソッドです。
     * 
     * @return 外部帳票文字切れ制御使用区分
     */
    @CheckForNull
    public RString getGaibuChohyoMojigireSeigyoShiyoKubun() {
        return gaibuChohyoMojigireSeigyoShiyoKubun;
    }

    /**
     * 外部帳票文字切れ制御使用区分のsetメソッドです。
     * 
     * @param gaibuChohyoMojigireSeigyoShiyoKubun 外部帳票文字切れ制御使用区分
     */
    public void setGaibuChohyoMojigireSeigyoShiyoKubun(RString gaibuChohyoMojigireSeigyoShiyoKubun) {
        this.gaibuChohyoMojigireSeigyoShiyoKubun = gaibuChohyoMojigireSeigyoShiyoKubun;
    }

    /**
     * 内部帳票文字切れ制御使用区分のgetメソッドです。
     * 
     * @return 内部帳票文字切れ制御使用区分
     */
    @CheckForNull
    public RString getNaibuChohyoMojigireSeigyoShiyoKubun() {
        return naibuChohyoMojigireSeigyoShiyoKubun;
    }

    /**
     * 内部帳票文字切れ制御使用区分のsetメソッドです。
     * 
     * @param naibuChohyoMojigireSeigyoShiyoKubun 内部帳票文字切れ制御使用区分
     */
    public void setNaibuChohyoMojigireSeigyoShiyoKubun(RString naibuChohyoMojigireSeigyoShiyoKubun) {
        this.naibuChohyoMojigireSeigyoShiyoKubun = naibuChohyoMojigireSeigyoShiyoKubun;
    }

    /**
     * 文字切れ分離制御使用区分のgetメソッドです。
     * 
     * @return 文字切れ分離制御使用区分
     */
    @CheckForNull
    public RString getMojigireBunriSeigyoShiyoKubun() {
        return mojigireBunriSeigyoShiyoKubun;
    }

    /**
     * 文字切れ分離制御使用区分のsetメソッドです。
     * 
     * @param mojigireBunriSeigyoShiyoKubun 文字切れ分離制御使用区分
     */
    public void setMojigireBunriSeigyoShiyoKubun(RString mojigireBunriSeigyoShiyoKubun) {
        this.mojigireBunriSeigyoShiyoKubun = mojigireBunriSeigyoShiyoKubun;
    }

    /**
     * 定型文文字サイズ使用区分のgetメソッドです。
     * 
     * @return 定型文文字サイズ使用区分
     */
    @CheckForNull
    public RString getTeikeibunMojiSizeShiyoKubun() {
        return teikeibunMojiSizeShiyoKubun;
    }

    /**
     * 定型文文字サイズ使用区分のsetメソッドです。
     * 
     * @param teikeibunMojiSizeShiyoKubun 定型文文字サイズ使用区分
     */
    public void setTeikeibunMojiSizeShiyoKubun(RString teikeibunMojiSizeShiyoKubun) {
        this.teikeibunMojiSizeShiyoKubun = teikeibunMojiSizeShiyoKubun;
    }

    /**
     * 口座マスク使用区分のgetメソッドです。
     * 
     * @return 口座マスク使用区分
     */
    @CheckForNull
    public RString getKozaMaskShiyoKubun() {
        return kozaMaskShiyoKubun;
    }

    /**
     * 口座マスク使用区分のsetメソッドです。
     * 
     * @param kozaMaskShiyoKubun 口座マスク使用区分
     */
    public void setKozaMaskShiyoKubun(RString kozaMaskShiyoKubun) {
        this.kozaMaskShiyoKubun = kozaMaskShiyoKubun;
    }

    /**
     * 口座名義人カナ優先使用区分のgetメソッドです。
     * 
     * @return 口座名義人カナ優先使用区分
     */
    @CheckForNull
    public RString getKozaMeigininKanaYusenShiyoKubun() {
        return kozaMeigininKanaYusenShiyoKubun;
    }

    /**
     * 口座名義人カナ優先使用区分のsetメソッドです。
     * 
     * @param kozaMeigininKanaYusenShiyoKubun 口座名義人カナ優先使用区分
     */
    public void setKozaMeigininKanaYusenShiyoKubun(RString kozaMeigininKanaYusenShiyoKubun) {
        this.kozaMeigininKanaYusenShiyoKubun = kozaMeigininKanaYusenShiyoKubun;
    }

    /**
     * 代行プリント使用区分のgetメソッドです。
     * 
     * @return 代行プリント使用区分
     */
    @CheckForNull
    public RString getDaikoPrintShiyoKubun() {
        return daikoPrintShiyoKubun;
    }

    /**
     * 代行プリント使用区分のsetメソッドです。
     * 
     * @param daikoPrintShiyoKubun 代行プリント使用区分
     */
    public void setDaikoPrintShiyoKubun(RString daikoPrintShiyoKubun) {
        this.daikoPrintShiyoKubun = daikoPrintShiyoKubun;
    }

    /**
     * 地区表示使用区分のgetメソッドです。
     * <br/>
     * <br/>地区表示１　
     * <br/>地区表示２　
     * <br/>地区表示３
     * 
     * @return 地区表示使用区分
     */
    @CheckForNull
    public RString getChikuhyojiShiyoKubun() {
        return chikuhyojiShiyoKubun;
    }

    /**
     * 地区表示使用区分のsetメソッドです。
     * <br/>
     * <br/>地区表示１　
     * <br/>地区表示２　
     * <br/>地区表示３
     * 
     * @param chikuhyojiShiyoKubun 地区表示使用区分
     */
    public void setChikuhyojiShiyoKubun(RString chikuhyojiShiyoKubun) {
        this.chikuhyojiShiyoKubun = chikuhyojiShiyoKubun;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT7066ChohyoSeigyoKyotsuControlEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT7066ChohyoSeigyoKyotsuControlEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT7066ChohyoSeigyoKyotsuControlEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.subGyomuCode, other.subGyomuCode)) {
            return false;
        }
        if (!Objects.equals(this.chohyoBunruiID, other.chohyoBunruiID)) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT7066ChohyoSeigyoKyotsuControlEntity entity) {
        this.subGyomuCode = entity.subGyomuCode;
        this.chohyoBunruiID = entity.chohyoBunruiID;
        this.kyotsuGamenShiyoUmu = entity.kyotsuGamenShiyoUmu;
        this.bunshoNoShiyoKubun = entity.bunshoNoShiyoKubun;
        this.tsuchishoTeikeibunShiyoKubun = entity.tsuchishoTeikeibunShiyoKubun;
        this.ninshoshaShiyoKubun = entity.ninshoshaShiyoKubun;
        this.chohyoShuturyokujunShiyoKubun = entity.chohyoShuturyokujunShiyoKubun;
        this.chohyoShuturyokujunHyojiHohho = entity.chohyoShuturyokujunHyojiHohho;
        this.kaigoToiawasesakiShiyoKubun = entity.kaigoToiawasesakiShiyoKubun;
        this.jushoHenshuShiyoKubun = entity.jushoHenshuShiyoKubun;
        this.setainushiHyojiShiyoKubun = entity.setainushiHyojiShiyoKubun;
        this.dainoninHyojiShiyoKubun = entity.dainoninHyojiShiyoKubun;
        this.customerBarCodeShiyoKubun = entity.customerBarCodeShiyoKubun;
        this.gaibuChohyoMojigireSeigyoShiyoKubun = entity.gaibuChohyoMojigireSeigyoShiyoKubun;
        this.naibuChohyoMojigireSeigyoShiyoKubun = entity.naibuChohyoMojigireSeigyoShiyoKubun;
        this.mojigireBunriSeigyoShiyoKubun = entity.mojigireBunriSeigyoShiyoKubun;
        this.teikeibunMojiSizeShiyoKubun = entity.teikeibunMojiSizeShiyoKubun;
        this.kozaMaskShiyoKubun = entity.kozaMaskShiyoKubun;
        this.kozaMeigininKanaYusenShiyoKubun = entity.kozaMeigininKanaYusenShiyoKubun;
        this.daikoPrintShiyoKubun = entity.daikoPrintShiyoKubun;
        this.chikuhyojiShiyoKubun = entity.chikuhyojiShiyoKubun;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(subGyomuCode, chohyoBunruiID, kyotsuGamenShiyoUmu, bunshoNoShiyoKubun, tsuchishoTeikeibunShiyoKubun, ninshoshaShiyoKubun, chohyoShuturyokujunShiyoKubun, chohyoShuturyokujunHyojiHohho, kaigoToiawasesakiShiyoKubun, jushoHenshuShiyoKubun, setainushiHyojiShiyoKubun, dainoninHyojiShiyoKubun, customerBarCodeShiyoKubun, gaibuChohyoMojigireSeigyoShiyoKubun, naibuChohyoMojigireSeigyoShiyoKubun, mojigireBunriSeigyoShiyoKubun, teikeibunMojiSizeShiyoKubun, kozaMaskShiyoKubun, kozaMeigininKanaYusenShiyoKubun, daikoPrintShiyoKubun, chikuhyojiShiyoKubun);
    }

// </editor-fold>

}
