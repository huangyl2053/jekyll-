package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 要介護認定一次判定結果情報テーブルのエンティティクラスです。
 */
public class DbT5116IchijiHanteiKekkaJohoEntity extends DbTableEntityBase<DbT5116IchijiHanteiKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5116IchijiHanteiKekkaJoho");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private ShinseishoKanriNo shinseishoKanriNo;
    private boolean kariIchijiHanteiKubun;
    private FlexibleDate ichijiHanteiYMD;
    private Code ichijiHanteiKekkaCode;
    private Code ichijiHanteiKekkaNinchishoKasanCode;
    private int kijunJikan;
    private int kijunJikanShokuji;
    private int kijunJikanHaisetsu;
    private int kijunJikanIdo;
    private int kijunJikanSeiketsuHoji;
    private int kijunJikanKansetsuCare;
    private int kijunJikanBPSDKanren;
    private int kijunJikanKinoKunren;
    private int kijunJikanIryoKanren;
    private int kijunJikanNinchishoKasan;
    private int chukanHyokaKomoku1gun;
    private int chukanHyokaKomoku2gun;
    private int chukanHyokaKomoku3gun;
    private int chukanHyokaKomoku4gun;
    private int chukanHyokaKomoku5gun;
    private int chukanHyokaKomoku6gun;
    private int chukanHyokaKomoku7gun;
    private RString ichijiHnateiKeikokuCode;
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;
    private Code ninchishoKoreishaShihyoCode;
    private int jiritsudoKumiawase1;
    private int jiritsudoKumiawase2;
    private int jiritsudoKumiawase3;
    private int jiritsudoKumiawase4;
    private int jiritsudoKumiawase5;
    private int jiritsudoKumiawase6;
    private int jiritsudoKumiawase7;
    private Code gaizenseiHyokaCode;
    private int gaizenseiHyokaPercent;
    private RString ichijiHanteiSofuKubun;
    private FlexibleDate ichijiHanteiKekkaSofuYMD;
    private RString chert;
    private RString jotaizo;

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
     * 仮一次判定区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：仮一次判定区分）
     *
     * @return 仮一次判定区分
     */
    public boolean getKariIchijiHanteiKubun() {
        return kariIchijiHanteiKubun;
    }

    /**
     * 仮一次判定区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：仮一次判定区分）
     *
     * @param kariIchijiHanteiKubun 仮一次判定区分
     */
    public void setKariIchijiHanteiKubun(@Nonnull boolean kariIchijiHanteiKubun) {
        this.kariIchijiHanteiKubun = kariIchijiHanteiKubun;
    }

    /**
     * 要介護認定一次判定年月日のgetメソッドです。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    /**
     * 要介護認定一次判定年月日のsetメソッドです。
     *
     * @param ichijiHanteiYMD 要介護認定一次判定年月日
     */
    public void setIchijiHanteiYMD(@Nonnull FlexibleDate ichijiHanteiYMD) {
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    /**
     * 要介護認定一次判定結果コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    /**
     * 要介護認定一次判定結果コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @param ichijiHanteiKekkaCode 要介護認定一次判定結果コード
     */
    public void setIchijiHanteiKekkaCode(@Nonnull Code ichijiHanteiKekkaCode) {
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * 要介護認定一次判定結果コード（認知症加算）のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     *
     * @return 要介護認定一次判定結果コード（認知症加算）
     */
    public Code getIchijiHanteiKekkaNinchishoKasanCode() {
        return ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * 要介護認定一次判定結果コード（認知症加算）のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     *
     * @param ichijiHanteiKekkaNinchishoKasanCode 要介護認定一次判定結果コード（認知症加算）
     */
    public void setIchijiHanteiKekkaNinchishoKasanCode(@Nonnull Code ichijiHanteiKekkaNinchishoKasanCode) {
        this.ichijiHanteiKekkaNinchishoKasanCode = ichijiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * 要介護認定等基準時間のgetメソッドです。
     *
     * @return 要介護認定等基準時間
     */
    @CheckForNull
    public int getKijunJikan() {
        return kijunJikan;
    }

    /**
     * 要介護認定等基準時間のsetメソッドです。
     *
     * @param kijunJikan 要介護認定等基準時間
     */
    public void setKijunJikan(int kijunJikan) {
        this.kijunJikan = kijunJikan;
    }

    /**
     * 要介護認定等基準時間（食事）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（食事）
     */
    @CheckForNull
    public int getKijunJikanShokuji() {
        return kijunJikanShokuji;
    }

    /**
     * 要介護認定等基準時間（食事）のsetメソッドです。
     *
     * @param kijunJikanShokuji 要介護認定等基準時間（食事）
     */
    public void setKijunJikanShokuji(int kijunJikanShokuji) {
        this.kijunJikanShokuji = kijunJikanShokuji;
    }

    /**
     * 要介護認定等基準時間（排泄）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（排泄）
     */
    @CheckForNull
    public int getKijunJikanHaisetsu() {
        return kijunJikanHaisetsu;
    }

    /**
     * 要介護認定等基準時間（排泄）のsetメソッドです。
     *
     * @param kijunJikanHaisetsu 要介護認定等基準時間（排泄）
     */
    public void setKijunJikanHaisetsu(int kijunJikanHaisetsu) {
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
    }

    /**
     * 要介護認定等基準時間（移動）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（移動）
     */
    @CheckForNull
    public int getKijunJikanIdo() {
        return kijunJikanIdo;
    }

    /**
     * 要介護認定等基準時間（移動）のsetメソッドです。
     *
     * @param kijunJikanIdo 要介護認定等基準時間（移動）
     */
    public void setKijunJikanIdo(int kijunJikanIdo) {
        this.kijunJikanIdo = kijunJikanIdo;
    }

    /**
     * 要介護認定等基準時間（清潔保持）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（清潔保持）
     */
    @CheckForNull
    public int getKijunJikanSeiketsuHoji() {
        return kijunJikanSeiketsuHoji;
    }

    /**
     * 要介護認定等基準時間（清潔保持）のsetメソッドです。
     *
     * @param kijunJikanSeiketsuHoji 要介護認定等基準時間（清潔保持）
     */
    public void setKijunJikanSeiketsuHoji(int kijunJikanSeiketsuHoji) {
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
    }

    /**
     * 要介護認定等基準時間（間接ケア）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（間接ケア）
     */
    @CheckForNull
    public int getKijunJikanKansetsuCare() {
        return kijunJikanKansetsuCare;
    }

    /**
     * 要介護認定等基準時間（間接ケア）のsetメソッドです。
     *
     * @param kijunJikanKansetsuCare 要介護認定等基準時間（間接ケア）
     */
    public void setKijunJikanKansetsuCare(int kijunJikanKansetsuCare) {
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
    }

    /**
     * 要介護認定等基準時間（BPSD関連）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（BPSD関連）
     */
    @CheckForNull
    public int getKijunJikanBPSDKanren() {
        return kijunJikanBPSDKanren;
    }

    /**
     * 要介護認定等基準時間（BPSD関連）のsetメソッドです。
     *
     * @param kijunJikanBPSDKanren 要介護認定等基準時間（BPSD関連）
     */
    public void setKijunJikanBPSDKanren(int kijunJikanBPSDKanren) {
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
    }

    /**
     * 要介護認定等基準時間（機能訓練）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（機能訓練）
     */
    @CheckForNull
    public int getKijunJikanKinoKunren() {
        return kijunJikanKinoKunren;
    }

    /**
     * 要介護認定等基準時間（機能訓練）のsetメソッドです。
     *
     * @param kijunJikanKinoKunren 要介護認定等基準時間（機能訓練）
     */
    public void setKijunJikanKinoKunren(int kijunJikanKinoKunren) {
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
    }

    /**
     * 要介護認定等基準時間（医療関連）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（医療関連）
     */
    @CheckForNull
    public int getKijunJikanIryoKanren() {
        return kijunJikanIryoKanren;
    }

    /**
     * 要介護認定等基準時間（医療関連）のsetメソッドです。
     *
     * @param kijunJikanIryoKanren 要介護認定等基準時間（医療関連）
     */
    public void setKijunJikanIryoKanren(int kijunJikanIryoKanren) {
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
    }

    /**
     * 要介護認定等基準時間（認知症加算）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（認知症加算）
     */
    @CheckForNull
    public int getKijunJikanNinchishoKasan() {
        return kijunJikanNinchishoKasan;
    }

    /**
     * 要介護認定等基準時間（認知症加算）のsetメソッドです。
     *
     * @param kijunJikanNinchishoKasan 要介護認定等基準時間（認知症加算）
     */
    public void setKijunJikanNinchishoKasan(int kijunJikanNinchishoKasan) {
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
    }

    /**
     * 中間評価項目得点第1群のgetメソッドです。
     *
     * @return 中間評価項目得点第1群
     */
    @CheckForNull
    public int getChukanHyokaKomoku1gun() {
        return chukanHyokaKomoku1gun;
    }

    /**
     * 中間評価項目得点第1群のsetメソッドです。
     *
     * @param chukanHyokaKomoku1gun 中間評価項目得点第1群
     */
    public void setChukanHyokaKomoku1gun(int chukanHyokaKomoku1gun) {
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
    }

    /**
     * 中間評価項目得点第2群のgetメソッドです。
     *
     * @return 中間評価項目得点第2群
     */
    @CheckForNull
    public int getChukanHyokaKomoku2gun() {
        return chukanHyokaKomoku2gun;
    }

    /**
     * 中間評価項目得点第2群のsetメソッドです。
     *
     * @param chukanHyokaKomoku2gun 中間評価項目得点第2群
     */
    public void setChukanHyokaKomoku2gun(int chukanHyokaKomoku2gun) {
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
    }

    /**
     * 中間評価項目得点第3群のgetメソッドです。
     *
     * @return 中間評価項目得点第3群
     */
    @CheckForNull
    public int getChukanHyokaKomoku3gun() {
        return chukanHyokaKomoku3gun;
    }

    /**
     * 中間評価項目得点第3群のsetメソッドです。
     *
     * @param chukanHyokaKomoku3gun 中間評価項目得点第3群
     */
    public void setChukanHyokaKomoku3gun(int chukanHyokaKomoku3gun) {
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
    }

    /**
     * 中間評価項目得点第4群のgetメソッドです。
     *
     * @return 中間評価項目得点第4群
     */
    @CheckForNull
    public int getChukanHyokaKomoku4gun() {
        return chukanHyokaKomoku4gun;
    }

    /**
     * 中間評価項目得点第4群のsetメソッドです。
     *
     * @param chukanHyokaKomoku4gun 中間評価項目得点第4群
     */
    public void setChukanHyokaKomoku4gun(int chukanHyokaKomoku4gun) {
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
    }

    /**
     * 中間評価項目得点第5群のgetメソッドです。
     *
     * @return 中間評価項目得点第5群
     */
    @CheckForNull
    public int getChukanHyokaKomoku5gun() {
        return chukanHyokaKomoku5gun;
    }

    /**
     * 中間評価項目得点第5群のsetメソッドです。
     *
     * @param chukanHyokaKomoku5gun 中間評価項目得点第5群
     */
    public void setChukanHyokaKomoku5gun(int chukanHyokaKomoku5gun) {
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
    }

    /**
     * 中間評価項目得点第6群のgetメソッドです。
     *
     * @return 中間評価項目得点第6群
     */
    @CheckForNull
    public int getChukanHyokaKomoku6gun() {
        return chukanHyokaKomoku6gun;
    }

    /**
     * 中間評価項目得点第6群のsetメソッドです。
     *
     * @param chukanHyokaKomoku6gun 中間評価項目得点第6群
     */
    public void setChukanHyokaKomoku6gun(int chukanHyokaKomoku6gun) {
        this.chukanHyokaKomoku6gun = chukanHyokaKomoku6gun;
    }

    /**
     * 中間評価項目得点第7群のgetメソッドです。
     *
     * @return 中間評価項目得点第7群
     */
    @CheckForNull
    public int getChukanHyokaKomoku7gun() {
        return chukanHyokaKomoku7gun;
    }

    /**
     * 中間評価項目得点第7群のsetメソッドです。
     *
     * @param chukanHyokaKomoku7gun 中間評価項目得点第7群
     */
    public void setChukanHyokaKomoku7gun(int chukanHyokaKomoku7gun) {
        this.chukanHyokaKomoku7gun = chukanHyokaKomoku7gun;
    }

    /**
     * 要介護認定一次判定警告コードのgetメソッドです。
     *
     * @return 要介護認定一次判定警告コード
     */
    @CheckForNull
    public RString getIchijiHnateiKeikokuCode() {
        return ichijiHnateiKeikokuCode;
    }

    /**
     * 要介護認定一次判定警告コードのsetメソッドです。
     *
     * @param ichijiHnateiKeikokuCode 要介護認定一次判定警告コード
     */
    public void setIchijiHnateiKeikokuCode(RString ichijiHnateiKeikokuCode) {
        this.ichijiHnateiKeikokuCode = ichijiHnateiKeikokuCode;
    }

    /**
     * 要介護認定状態の安定性コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護認定状態の安定性コード）
     *
     * @return 要介護認定状態の安定性コード
     */
    @CheckForNull
    public Code getJotaiAnteiseiCode() {
        return jotaiAnteiseiCode;
    }

    /**
     * 要介護認定状態の安定性コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護認定状態の安定性コード）
     *
     * @param jotaiAnteiseiCode 要介護認定状態の安定性コード
     */
    public void setJotaiAnteiseiCode(Code jotaiAnteiseiCode) {
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性のgetメソッドです。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    @CheckForNull
    public Decimal getNinchishoJiritsudoIIijoNoGaizensei() {
        return ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性のsetメソッドです。
     *
     * @param ninchishoJiritsudoIIijoNoGaizensei 認知症自立度Ⅱ以上の蓋然性
     */
    public void setNinchishoJiritsudoIIijoNoGaizensei(Decimal ninchishoJiritsudoIIijoNoGaizensei) {
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知機能及び状態安定性から推定される給付区分コード）
     *
     * @return 認知機能及び状態安定性から推定される給付区分コード
     */
    @CheckForNull
    public Code getSuiteiKyufuKubunCode() {
        return suiteiKyufuKubunCode;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知機能及び状態安定性から推定される給付区分コード）
     *
     * @param suiteiKyufuKubunCode 認知機能及び状態安定性から推定される給付区分コード
     */
    public void setSuiteiKyufuKubunCode(Code suiteiKyufuKubunCode) {
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：運動能力の低下していない認知症高齢者の指標コード）
     *
     * @return 運動能力の低下していない認知症高齢者の指標コード
     */
    @CheckForNull
    public Code getNinchishoKoreishaShihyoCode() {
        return ninchishoKoreishaShihyoCode;
    }

    /**
     * 運動能力の低下していない認知症高齢者の指標コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：運動能力の低下していない認知症高齢者の指標コード）
     *
     * @param ninchishoKoreishaShihyoCode 運動能力の低下していない認知症高齢者の指標コード
     */
    public void setNinchishoKoreishaShihyoCode(Code ninchishoKoreishaShihyoCode) {
        this.ninchishoKoreishaShihyoCode = ninchishoKoreishaShihyoCode;
    }

    /**
     * 日常生活自立度の組み合わせ（自立）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（自立）
     */
    @CheckForNull
    public int getJiritsudoKumiawase1() {
        return jiritsudoKumiawase1;
    }

    /**
     * 日常生活自立度の組み合わせ（自立）のsetメソッドです。
     *
     * @param jiritsudoKumiawase1 日常生活自立度の組み合わせ（自立）
     */
    public void setJiritsudoKumiawase1(int jiritsudoKumiawase1) {
        this.jiritsudoKumiawase1 = jiritsudoKumiawase1;
    }

    /**
     * 日常生活自立度の組み合わせ（要支援）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要支援）
     */
    @CheckForNull
    public int getJiritsudoKumiawase2() {
        return jiritsudoKumiawase2;
    }

    /**
     * 日常生活自立度の組み合わせ（要支援）のsetメソッドです。
     *
     * @param jiritsudoKumiawase2 日常生活自立度の組み合わせ（要支援）
     */
    public void setJiritsudoKumiawase2(int jiritsudoKumiawase2) {
        this.jiritsudoKumiawase2 = jiritsudoKumiawase2;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護１）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要介護１）
     */
    @CheckForNull
    public int getJiritsudoKumiawase3() {
        return jiritsudoKumiawase3;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護１）のsetメソッドです。
     *
     * @param jiritsudoKumiawase3 日常生活自立度の組み合わせ（要介護１）
     */
    public void setJiritsudoKumiawase3(int jiritsudoKumiawase3) {
        this.jiritsudoKumiawase3 = jiritsudoKumiawase3;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護２）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要介護２）
     */
    @CheckForNull
    public int getJiritsudoKumiawase4() {
        return jiritsudoKumiawase4;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護２）のsetメソッドです。
     *
     * @param jiritsudoKumiawase4 日常生活自立度の組み合わせ（要介護２）
     */
    public void setJiritsudoKumiawase4(int jiritsudoKumiawase4) {
        this.jiritsudoKumiawase4 = jiritsudoKumiawase4;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護３）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要介護３）
     */
    @CheckForNull
    public int getJiritsudoKumiawase5() {
        return jiritsudoKumiawase5;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護３）のsetメソッドです。
     *
     * @param jiritsudoKumiawase5 日常生活自立度の組み合わせ（要介護３）
     */
    public void setJiritsudoKumiawase5(int jiritsudoKumiawase5) {
        this.jiritsudoKumiawase5 = jiritsudoKumiawase5;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護４）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要介護４）
     */
    @CheckForNull
    public int getJiritsudoKumiawase6() {
        return jiritsudoKumiawase6;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護４）のsetメソッドです。
     *
     * @param jiritsudoKumiawase6 日常生活自立度の組み合わせ（要介護４）
     */
    public void setJiritsudoKumiawase6(int jiritsudoKumiawase6) {
        this.jiritsudoKumiawase6 = jiritsudoKumiawase6;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護５）のgetメソッドです。
     *
     * @return 日常生活自立度の組み合わせ（要介護５）
     */
    @CheckForNull
    public int getJiritsudoKumiawase7() {
        return jiritsudoKumiawase7;
    }

    /**
     * 日常生活自立度の組み合わせ（要介護５）のsetメソッドです。
     *
     * @param jiritsudoKumiawase7 日常生活自立度の組み合わせ（要介護５）
     */
    public void setJiritsudoKumiawase7(int jiritsudoKumiawase7) {
        this.jiritsudoKumiawase7 = jiritsudoKumiawase7;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者の日常生活自立度の蓋然性評価コード）
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価コード
     */
    @CheckForNull
    public Code getGaizenseiHyokaCode() {
        return gaizenseiHyokaCode;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知症高齢者の日常生活自立度の蓋然性評価コード）
     *
     * @param gaizenseiHyokaCode 認知症高齢者の日常生活自立度の蓋然性評価コード
     */
    public void setGaizenseiHyokaCode(Code gaizenseiHyokaCode) {
        this.gaizenseiHyokaCode = gaizenseiHyokaCode;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価％のgetメソッドです。
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価％
     */
    @CheckForNull
    public int getGaizenseiHyokaPercent() {
        return gaizenseiHyokaPercent;
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価％のsetメソッドです。
     *
     * @param gaizenseiHyokaPercent 認知症高齢者の日常生活自立度の蓋然性評価％
     */
    public void setGaizenseiHyokaPercent(int gaizenseiHyokaPercent) {
        this.gaizenseiHyokaPercent = gaizenseiHyokaPercent;
    }

    /**
     * 一次判定結果送付区分のgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：一次判定結果送付区分）
     *
     * @return 一次判定結果送付区分
     */
    @CheckForNull
    public RString getIchijiHanteiSofuKubun() {
        return ichijiHanteiSofuKubun;
    }

    /**
     * 一次判定結果送付区分のsetメソッドです。
     * <br/>
     * <br/>Enum（DBE：一次判定結果送付区分）
     *
     * @param ichijiHanteiSofuKubun 一次判定結果送付区分
     */
    public void setIchijiHanteiSofuKubun(RString ichijiHanteiSofuKubun) {
        this.ichijiHanteiSofuKubun = ichijiHanteiSofuKubun;
    }

    /**
     * 一次判定結果送付年月日のgetメソッドです。
     *
     * @return 一次判定結果送付年月日
     */
    @CheckForNull
    public FlexibleDate getIchijiHanteiKekkaSofuYMD() {
        return ichijiHanteiKekkaSofuYMD;
    }

    /**
     * 一次判定結果送付年月日のsetメソッドです。
     *
     * @param ichijiHanteiKekkaSofuYMD 一次判定結果送付年月日
     */
    public void setIchijiHanteiKekkaSofuYMD(FlexibleDate ichijiHanteiKekkaSofuYMD) {
        this.ichijiHanteiKekkaSofuYMD = ichijiHanteiKekkaSofuYMD;
    }

    /**
     * チャートのgetメソッドです。
     *
     * @return チャート
     */
    @CheckForNull
    public RString getChert() {
        return chert;
    }

    /**
     * チャートのsetメソッドです。
     *
     * @param chert チャート
     */
    public void setChert(RString chert) {
        this.chert = chert;
    }

    /**
     * 状態像のgetメソッドです。
     *
     * @return 状態像
     */
    @CheckForNull
    public RString getJotaizo() {
        return jotaizo;
    }

    /**
     * 状態像のsetメソッドです。
     *
     * @param jotaizo 状態像
     */
    public void setJotaizo(RString jotaizo) {
        this.jotaizo = jotaizo;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5116IchijiHanteiKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return
     * 比較するエンティティが同じ主キーを持つ{@literal DbT5116IchijiHanteiKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5116IchijiHanteiKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT5116IchijiHanteiKekkaJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.kariIchijiHanteiKubun = entity.kariIchijiHanteiKubun;
        this.ichijiHanteiYMD = entity.ichijiHanteiYMD;
        this.ichijiHanteiKekkaCode = entity.ichijiHanteiKekkaCode;
        this.ichijiHanteiKekkaNinchishoKasanCode = entity.ichijiHanteiKekkaNinchishoKasanCode;
        this.kijunJikan = entity.kijunJikan;
        this.kijunJikanShokuji = entity.kijunJikanShokuji;
        this.kijunJikanHaisetsu = entity.kijunJikanHaisetsu;
        this.kijunJikanIdo = entity.kijunJikanIdo;
        this.kijunJikanSeiketsuHoji = entity.kijunJikanSeiketsuHoji;
        this.kijunJikanKansetsuCare = entity.kijunJikanKansetsuCare;
        this.kijunJikanBPSDKanren = entity.kijunJikanBPSDKanren;
        this.kijunJikanKinoKunren = entity.kijunJikanKinoKunren;
        this.kijunJikanIryoKanren = entity.kijunJikanIryoKanren;
        this.kijunJikanNinchishoKasan = entity.kijunJikanNinchishoKasan;
        this.chukanHyokaKomoku1gun = entity.chukanHyokaKomoku1gun;
        this.chukanHyokaKomoku2gun = entity.chukanHyokaKomoku2gun;
        this.chukanHyokaKomoku3gun = entity.chukanHyokaKomoku3gun;
        this.chukanHyokaKomoku4gun = entity.chukanHyokaKomoku4gun;
        this.chukanHyokaKomoku5gun = entity.chukanHyokaKomoku5gun;
        this.chukanHyokaKomoku6gun = entity.chukanHyokaKomoku6gun;
        this.chukanHyokaKomoku7gun = entity.chukanHyokaKomoku7gun;
        this.ichijiHnateiKeikokuCode = entity.ichijiHnateiKeikokuCode;
        this.jotaiAnteiseiCode = entity.jotaiAnteiseiCode;
        this.ninchishoJiritsudoIIijoNoGaizensei = entity.ninchishoJiritsudoIIijoNoGaizensei;
        this.suiteiKyufuKubunCode = entity.suiteiKyufuKubunCode;
        this.ninchishoKoreishaShihyoCode = entity.ninchishoKoreishaShihyoCode;
        this.jiritsudoKumiawase1 = entity.jiritsudoKumiawase1;
        this.jiritsudoKumiawase2 = entity.jiritsudoKumiawase2;
        this.jiritsudoKumiawase3 = entity.jiritsudoKumiawase3;
        this.jiritsudoKumiawase4 = entity.jiritsudoKumiawase4;
        this.jiritsudoKumiawase5 = entity.jiritsudoKumiawase5;
        this.jiritsudoKumiawase6 = entity.jiritsudoKumiawase6;
        this.jiritsudoKumiawase7 = entity.jiritsudoKumiawase7;
        this.gaizenseiHyokaCode = entity.gaizenseiHyokaCode;
        this.gaizenseiHyokaPercent = entity.gaizenseiHyokaPercent;
        this.ichijiHanteiSofuKubun = entity.ichijiHanteiSofuKubun;
        this.ichijiHanteiKekkaSofuYMD = entity.ichijiHanteiKekkaSofuYMD;
        this.chert = entity.chert;
        this.jotaizo = entity.jotaizo;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, kariIchijiHanteiKubun, ichijiHanteiYMD, ichijiHanteiKekkaCode, ichijiHanteiKekkaNinchishoKasanCode, kijunJikan, kijunJikanShokuji, kijunJikanHaisetsu, kijunJikanIdo, kijunJikanSeiketsuHoji, kijunJikanKansetsuCare, kijunJikanBPSDKanren, kijunJikanKinoKunren, kijunJikanIryoKanren, kijunJikanNinchishoKasan, chukanHyokaKomoku1gun, chukanHyokaKomoku2gun, chukanHyokaKomoku3gun, chukanHyokaKomoku4gun, chukanHyokaKomoku5gun, chukanHyokaKomoku6gun, chukanHyokaKomoku7gun, ichijiHnateiKeikokuCode, jotaiAnteiseiCode, ninchishoJiritsudoIIijoNoGaizensei, suiteiKyufuKubunCode, ninchishoKoreishaShihyoCode, jiritsudoKumiawase1, jiritsudoKumiawase2, jiritsudoKumiawase3, jiritsudoKumiawase4, jiritsudoKumiawase5, jiritsudoKumiawase6, jiritsudoKumiawase7, gaizenseiHyokaCode, gaizenseiHyokaPercent, ichijiHanteiSofuKubun, ichijiHanteiKekkaSofuYMD, chert, jotaizo);
    }

// </editor-fold>
}
