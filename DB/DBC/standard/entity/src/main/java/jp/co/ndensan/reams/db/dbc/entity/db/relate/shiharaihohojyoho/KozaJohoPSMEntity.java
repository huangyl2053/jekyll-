package jp.co.ndensan.reams.db.dbc.entity.db.relate.shiharaihohojyoho;

import java.util.UUID;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 口座情報PSMのエンティティクラスです。
 */
public class KozaJohoPSMEntity implements IDbAccessable {

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private long kozaId;
    private ShikibetsuCode shikibetsuCode;
    private GyomuCode gyomuCode;
    private SubGyomuCode subGyomuCode;
    private KamokuCode kamokuCode;
    private RString gyomuKoyuKey;
    private Code yotoKubun;
    private RString yotoKubunMeisho;
    private KinyuKikanCode kinyuKikanCode;
    private RString kinyuKikanMeisho;
    private KinyuKikanShitenCode kinyuKikanShitenCode;
    private RString kinyuKikanShitenMeisho;
    private RString yokinShubetsu;
    private RString yokinShubetsuRyakusho;
    private RString kozaNo;
    private RString tsuchoKigo;
    private RString tsuchoNo;
    private ShikibetsuCode kozaMeigininShikibetsuCode;
    private AtenaKanaMeisho kozaMeiginin;
    private AtenaMeisho kozaMeigininKanji;
    private RDate kaishiYMD;
    private RDate shuryoYMD;
    private AtenaKanaMeisho kensakuyoMeiginin;
    private RString kozaHyojiKubun;
    private RString kozaTorokuNo;
    private Code kozaTorokuKubunCode;
    private RDate kozaKaishiUketsukeYMD;
    private RDate kozaShuryoUketsukeYMD;
    private RDate kozaTorokuYMD;
    private RString temban;

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
     * lastUpdateReamsLoginIdのsetメソッドです。
     *
     * @param lastUpdateReamsLoginId lastUpdateReamsLoginId
     */
    public void setLastUpdateReamsLoginId(RString lastUpdateReamsLoginId) {
        this.lastUpdateReamsLoginId = lastUpdateReamsLoginId;
    }

    /**
     * 口座IDのgetメソッドです。
     *
     * @return 口座ID
     */
    public long getKozaId() {
        return kozaId;
    }

    /**
     * 口座IDのsetメソッドです。
     *
     * @param kozaId 口座ID
     */
    public void setKozaId(@Nonnull long kozaId) {
        this.kozaId = kozaId;
    }

    /**
     * 識別コードのgetメソッドです。
     *
     * @return 識別コード
     */
    @CheckForNull
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
     * 業務コードのgetメソッドです。
     * <br/>
     * <br/>収納(還付)/国保/福祉/児童手当　等から選択する
     *
     * @return 業務コード
     */
    public GyomuCode getGyomuCode() {
        return gyomuCode;
    }

    /**
     * 業務コードのsetメソッドです。
     * <br/>
     * <br/>収納(還付)/国保/福祉/児童手当　等から選択する
     *
     * @param gyomuCode 業務コード
     */
    public void setGyomuCode(@Nonnull GyomuCode gyomuCode) {
        this.gyomuCode = gyomuCode;
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
     * 科目コードのgetメソッドです。
     * <br/>
     * <br/>＜サブ業務：URZ、種別：0369＞
     *
     * <br/>給付種別　等
     *
     * <br/>収納の場合：収納科目DBの科目コード
     *
     * <br/>収納以外の場合：振込口座管理する場合で業務内に区分がある場合は、業務内区分コードをセット
     *
     * @return 科目コード
     */
    @CheckForNull
    public KamokuCode getKamokuCode() {
        return kamokuCode;
    }

    /**
     * 科目コードのsetメソッドです。
     * <br/>
     * <br/>＜サブ業務：URZ、種別：0369＞
     *
     * <br/>給付種別　等
     *
     * <br/>収納の場合：収納科目DBの科目コード
     *
     * <br/>収納以外の場合：振込口座管理する場合で業務内に区分がある場合は、業務内区分コードをセット
     *
     * @param kamokuCode 科目コード
     */
    public void setKamokuCode(KamokuCode kamokuCode) {
        this.kamokuCode = kamokuCode;
    }

    /**
     * 業務固有キーのgetメソッドです。
     * <br/>
     * <br/>使用業務で任意の固有キーを設定可能
     *
     * @return 業務固有キー
     */
    @CheckForNull
    public RString getGyomuKoyuKey() {
        return gyomuKoyuKey;
    }

    /**
     * 業務固有キーのsetメソッドです。
     * <br/>
     * <br/>使用業務で任意の固有キーを設定可能
     *
     * @param gyomuKoyuKey 業務固有キー
     */
    public void setGyomuKoyuKey(RString gyomuKoyuKey) {
        this.gyomuKoyuKey = gyomuKoyuKey;
    }

    /**
     * 用途区分のgetメソッドです。
     * <br/>
     * <br/>＜サブ業務：URZ、種別：0087＞
     *
     * <br/>0：振替口座
     *
     * <br/>1：振込口座
     *
     * <br/>2：納税組合
     *
     * @return 用途区分
     */
    public Code getYotoKubun() {
        return yotoKubun;
    }

    /**
     * 用途区分のsetメソッドです。
     * <br/>
     * <br/>＜サブ業務：URZ、種別：0087＞
     *
     * <br/>0：振替口座
     *
     * <br/>1：振込口座
     *
     * <br/>2：納税組合
     *
     * @param yotoKubun 用途区分
     */
    public void setYotoKubun(@Nonnull Code yotoKubun) {
        this.yotoKubun = yotoKubun;
    }

    /**
     * 金融機関コードのgetメソッドです。
     *
     * @return 金融機関コード
     */
    public KinyuKikanCode getKinyuKikanCode() {
        return kinyuKikanCode;
    }

    /**
     * 金融機関コードのsetメソッドです。
     *
     * @param kinyuKikanCode 金融機関コード
     */
    public void setKinyuKikanCode(@Nonnull KinyuKikanCode kinyuKikanCode) {
        this.kinyuKikanCode = kinyuKikanCode;
    }

    /**
     * 支店コードのgetメソッドです。
     *
     * @return 支店コード
     */
    public KinyuKikanShitenCode getKinyuKikanShitenCode() {
        return kinyuKikanShitenCode;
    }

    /**
     * 支店コードのsetメソッドです。
     *
     * @param kinyuKikanShitenCode 支店コード
     */
    public void setKinyuKikanShitenCode(@Nonnull KinyuKikanShitenCode kinyuKikanShitenCode) {
        this.kinyuKikanShitenCode = kinyuKikanShitenCode;
    }

    /**
     * 預金種別のgetメソッドです。
     * <br/>
     * <br/>1:普通預金
     *
     * <br/>2:当座預金
     *
     * <br/>3:納税準備預金
     *
     * <br/>4:貯蓄預金
     *
     * <br/>9:その他
     *
     * @return 預金種別
     */
    public RString getYokinShubetsu() {
        return yokinShubetsu;
    }

    /**
     * 預金種別のsetメソッドです。
     * <br/>
     * <br/>1:普通預金
     *
     * <br/>2:当座預金
     *
     * <br/>3:納税準備預金
     *
     * <br/>4:貯蓄預金
     *
     * <br/>9:その他
     *
     * @param yokinShubetsu 預金種別
     */
    public void setYokinShubetsu(@Nonnull RString yokinShubetsu) {
        this.yokinShubetsu = yokinShubetsu;
    }

    /**
     * 口座番号のgetメソッドです。
     *
     * @return 口座番号
     */
    public RString getKozaNo() {
        return kozaNo;
    }

    /**
     * 口座番号のsetメソッドです。
     *
     * @param kozaNo 口座番号
     */
    public void setKozaNo(@Nonnull RString kozaNo) {
        this.kozaNo = kozaNo;
    }

    /**
     * 通帳記号のgetメソッドです。
     *
     * @return 通帳記号
     */
    public RString getTsuchoKigo() {
        return tsuchoKigo;
    }

    /**
     * 通帳記号のsetメソッドです。
     *
     * @param tsuchoKigo 通帳記号
     */
    public void setTsuchoKigo(@Nonnull RString tsuchoKigo) {
        this.tsuchoKigo = tsuchoKigo;
    }

    /**
     * 通帳番号のgetメソッドです。
     *
     * @return 通帳番号
     */
    public RString getTsuchoNo() {
        return tsuchoNo;
    }

    /**
     * 通帳番号のsetメソッドです。
     *
     * @param tsuchoNo 通帳番号
     */
    public void setTsuchoNo(@Nonnull RString tsuchoNo) {
        this.tsuchoNo = tsuchoNo;
    }

    /**
     * 口座名義人識別コードのgetメソッドです。
     * <br/>
     * <br/>口座名義人に識別コードが付与されている場合に任意で登録管理する
     *
     * @return 口座名義人識別コード
     */
    @CheckForNull
    public ShikibetsuCode getKozaMeigininShikibetsuCode() {
        return kozaMeigininShikibetsuCode;
    }

    /**
     * 口座名義人識別コードのsetメソッドです。
     * <br/>
     * <br/>口座名義人に識別コードが付与されている場合に任意で登録管理する
     *
     * @param kozaMeigininShikibetsuCode 口座名義人識別コード
     */
    public void setKozaMeigininShikibetsuCode(ShikibetsuCode kozaMeigininShikibetsuCode) {
        this.kozaMeigininShikibetsuCode = kozaMeigininShikibetsuCode;
    }

    /**
     * 口座名義人のgetメソッドです。
     *
     * @return 口座名義人
     */
    public AtenaKanaMeisho getKozaMeiginin() {
        return kozaMeiginin;
    }

    /**
     * 口座名義人のsetメソッドです。
     *
     * @param kozaMeiginin 口座名義人
     */
    public void setKozaMeiginin(@Nonnull AtenaKanaMeisho kozaMeiginin) {
        this.kozaMeiginin = kozaMeiginin;
    }

    /**
     * 口座名義人漢字のgetメソッドです。
     *
     * @return 口座名義人漢字
     */
    public AtenaMeisho getKozaMeigininKanji() {
        return kozaMeigininKanji;
    }

    /**
     * 口座名義人漢字のsetメソッドです。
     *
     * @param kozaMeigininKanji 口座名義人漢字
     */
    public void setKozaMeigininKanji(@Nonnull AtenaMeisho kozaMeigininKanji) {
        this.kozaMeigininKanji = kozaMeigininKanji;
    }

    /**
     * 開始年月日のgetメソッドです。
     *
     * @return 開始年月日
     */
    public RDate getKaishiYMD() {
        return kaishiYMD;
    }

    /**
     * 開始年月日のsetメソッドです。
     *
     * @param kaishiYMD 開始年月日
     */
    public void setKaishiYMD(@Nonnull RDate kaishiYMD) {
        this.kaishiYMD = kaishiYMD;
    }

    /**
     * 終了年月日のgetメソッドです。
     *
     * @return 終了年月日
     */
    public RDate getShuryoYMD() {
        return shuryoYMD;
    }

    /**
     * 終了年月日のsetメソッドです。
     *
     * @param shuryoYMD 終了年月日
     */
    public void setShuryoYMD(@Nonnull RDate shuryoYMD) {
        this.shuryoYMD = shuryoYMD;
    }

    /**
     * 検索用名義人のgetメソッドです。
     *
     * @return 検索用名義人
     */
    public AtenaKanaMeisho getKensakuyoMeiginin() {
        return kensakuyoMeiginin;
    }

    /**
     * 検索用名義人のsetメソッドです。
     *
     * @param kensakuyoMeiginin 検索用名義人
     */
    public void setKensakuyoMeiginin(@Nonnull AtenaKanaMeisho kensakuyoMeiginin) {
        this.kensakuyoMeiginin = kensakuyoMeiginin;
    }

    /**
     * 口座表示区分のgetメソッドです。
     * <br/>
     * <br/>業務の方針に従い表示するか、個別の表示設定を行うかを指定する。0：個別設定なし、1：マスクしない、2：表示しない
     *
     * @return 口座表示区分
     */
    public RString getKozaHyojiKubun() {
        return kozaHyojiKubun;
    }

    /**
     * 口座表示区分のsetメソッドです。
     * <br/>
     * <br/>業務の方針に従い表示するか、個別の表示設定を行うかを指定する。0：個別設定なし、1：マスクしない、2：表示しない
     *
     * @param kozaHyojiKubun 口座表示区分
     */
    public void setKozaHyojiKubun(@Nonnull RString kozaHyojiKubun) {
        this.kozaHyojiKubun = kozaHyojiKubun;
    }

    /**
     * 口座登録番号のgetメソッドです。
     *
     * @return 口座登録番号
     */
    public RString getKozaTorokuNo() {
        return kozaTorokuNo;
    }

    /**
     * 口座登録番号のsetメソッドです。
     *
     * @param kozaTorokuNo 口座登録番号
     */
    public void setKozaTorokuNo(@Nonnull RString kozaTorokuNo) {
        this.kozaTorokuNo = kozaTorokuNo;
    }

    /**
     * 口座登録区分コードのgetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：URZ、種別：0113＞
     *
     * <br/>0：仮登録
     *
     * <br/>1：本登録
     *
     * @return 口座登録区分コード
     */
    public Code getKozaTorokuKubunCode() {
        return kozaTorokuKubunCode;
    }

    /**
     * 口座登録区分コードのsetメソッドです。
     * <br/>
     * <br/>共通コード＜サブ業務：URZ、種別：0113＞
     *
     * <br/>0：仮登録
     *
     * <br/>1：本登録
     *
     * @param kozaTorokuKubunCode 口座登録区分コード
     */
    public void setKozaTorokuKubunCode(@Nonnull Code kozaTorokuKubunCode) {
        this.kozaTorokuKubunCode = kozaTorokuKubunCode;
    }

    /**
     * 口座開始受付年月日のgetメソッドです。
     *
     * @return 口座開始受付年月日
     */
    public RDate getKozaKaishiUketsukeYMD() {
        return kozaKaishiUketsukeYMD;
    }

    /**
     * 口座開始受付年月日のsetメソッドです。
     *
     * @param kozaKaishiUketsukeYMD 口座開始受付年月日
     */
    public void setKozaKaishiUketsukeYMD(@Nonnull RDate kozaKaishiUketsukeYMD) {
        this.kozaKaishiUketsukeYMD = kozaKaishiUketsukeYMD;
    }

    /**
     * 口座終了受付年月日のgetメソッドです。
     *
     * @return 口座終了受付年月日
     */
    public RDate getKozaShuryoUketsukeYMD() {
        return kozaShuryoUketsukeYMD;
    }

    /**
     * 口座終了受付年月日のsetメソッドです。
     *
     * @param kozaShuryoUketsukeYMD 口座終了受付年月日
     */
    public void setKozaShuryoUketsukeYMD(@Nonnull RDate kozaShuryoUketsukeYMD) {
        this.kozaShuryoUketsukeYMD = kozaShuryoUketsukeYMD;
    }

    /**
     * 口座登録年月日のgetメソッドです。
     *
     * @return 口座登録年月日
     */
    public RDate getKozaTorokuYMD() {
        return kozaTorokuYMD;
    }

    /**
     * 口座登録年月日のsetメソッドです。
     *
     * @param kozaTorokuYMD 口座登録年月日
     */
    public void setKozaTorokuYMD(@Nonnull RDate kozaTorokuYMD) {
        this.kozaTorokuYMD = kozaTorokuYMD;
    }

    /**
     * 店番のgetメソッドです。
     *
     * @return 店番
     */
    public RString getTemban() {
        return temban;
    }

    /**
     * 店番のsetメソッドです。
     *
     * @param temban 店番
     */
    public void setTemban(@Nonnull RString temban) {
        this.temban = temban;
    }

    /**
     * @return the yotoKubunMeisho
     */
    public RString getYotoKubunMeisho() {
        return yotoKubunMeisho;
    }

    /**
     * @return the kinyuKikanMeisho
     */
    public RString getKinyuKikanMeisho() {
        return kinyuKikanMeisho;
    }

    /**
     * @return the kinyuKikanShitenMeisho
     */
    public RString getKinyuKikanShitenMeisho() {
        return kinyuKikanShitenMeisho;
    }

    /**
     * @return the yokinShubetsuRyakusho
     */
    public RString getYokinShubetsuRyakusho() {
        return yokinShubetsuRyakusho;
    }

    /**
     * @return the insertTimestamp
     */
    public RDateTime getInsertTimestamp() {
        return insertTimestamp;
    }

    /**
     * @param insertTimestamp the insertTimestamp to set
     */
    public void setInsertTimestamp(RDateTime insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    /**
     * @return the insertReamsLoginId
     */
    public RString getInsertReamsLoginId() {
        return insertReamsLoginId;
    }

    /**
     * @param insertReamsLoginId the insertReamsLoginId to set
     */
    public void setInsertReamsLoginId(RString insertReamsLoginId) {
        this.insertReamsLoginId = insertReamsLoginId;
    }

    /**
     * @return the insertContextId
     */
    public UUID getInsertContextId() {
        return insertContextId;
    }

    /**
     * @param insertContextId the insertContextId to set
     */
    public void setInsertContextId(UUID insertContextId) {
        this.insertContextId = insertContextId;
    }

    /**
     * @return the updateCount
     */
    public int getUpdateCount() {
        return updateCount;
    }

    /**
     * @param updateCount the updateCount to set
     */
    public void setUpdateCount(int updateCount) {
        this.updateCount = updateCount;
    }

    /**
     * @return the lastUpdateTimestamp
     */
    public RDateTime getLastUpdateTimestamp() {
        return lastUpdateTimestamp;
    }

    /**
     * @param lastUpdateTimestamp the lastUpdateTimestamp to set
     */
    public void setLastUpdateTimestamp(RDateTime lastUpdateTimestamp) {
        this.lastUpdateTimestamp = lastUpdateTimestamp;
    }

    /**
     * @return the lastUpdateReamsLoginId
     */
    public RString getLastUpdateReamsLoginId() {
        return lastUpdateReamsLoginId;
    }

    /**
     * @param yotoKubunMeisho the yotoKubunMeisho to set
     */
    public void setYotoKubunMeisho(RString yotoKubunMeisho) {
        this.yotoKubunMeisho = yotoKubunMeisho;
    }

    /**
     * @param kinyuKikanMeisho the kinyuKikanMeisho to set
     */
    public void setKinyuKikanMeisho(RString kinyuKikanMeisho) {
        this.kinyuKikanMeisho = kinyuKikanMeisho;
    }

    /**
     * @param kinyuKikanShitenMeisho the kinyuKikanShitenMeisho to set
     */
    public void setKinyuKikanShitenMeisho(RString kinyuKikanShitenMeisho) {
        this.kinyuKikanShitenMeisho = kinyuKikanShitenMeisho;
    }

    /**
     * @param yokinShubetsuRyakusho the yokinShubetsuRyakusho to set
     */
    public void setYokinShubetsuRyakusho(RString yokinShubetsuRyakusho) {
        this.yokinShubetsuRyakusho = yokinShubetsuRyakusho;
    }
}
