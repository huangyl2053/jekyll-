package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;

/**
 * 要介護認定1.5次判定結果情報テーブルのエンティティクラスです。
 */
@OnNextSchema("rgdb")
public class DbT5510IchiGojiHanteiKekkaJohoEntity extends DbTableEntityBase<DbT5510IchiGojiHanteiKekkaJohoEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    @TableName
    public static final RString TABLE_NAME = new RString("DbT5510IchiGojiHanteiKekkaJoho");

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
    private FlexibleDate ichiGojiHanteiYMD;
    private Code ichiGojiHanteiKekkaCode;
    private Code ichiGojiHanteiKekkaNinchishoKasanCode;
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
    private Code ichiGojiHnateiKeikokuCode;
    private Code jotaiAnteiseiCode;
    private Decimal ninchishoJiritsudoIIijoNoGaizensei;
    private Code suiteiKyufuKubunCode;

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
     * 要介護認定1.5次判定年月日のgetメソッドです。
     *
     * @return 要介護認定1.5次判定年月日
     */
    public FlexibleDate getIchiGojiHanteiYMD() {
        return ichiGojiHanteiYMD;
    }

    /**
     * 要介護認定1.5次判定年月日のsetメソッドです。
     *
     * @param ichiGojiHanteiYMD 要介護認定1.5次判定年月日
     */
    public void setIchiGojiHanteiYMD(@Nonnull FlexibleDate ichiGojiHanteiYMD) {
        this.ichiGojiHanteiYMD = ichiGojiHanteiYMD;
    }

    /**
     * 要介護認定1.5次判定結果コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @return 要介護認定1.5次判定結果コード
     */
    public Code getIchiGojiHanteiKekkaCode() {
        return ichiGojiHanteiKekkaCode;
    }

    /**
     * 要介護認定1.5次判定結果コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     *
     * @param ichiGojiHanteiKekkaCode 要介護認定1.5次判定結果コード
     */
    public void setIchiGojiHanteiKekkaCode(@Nonnull Code ichiGojiHanteiKekkaCode) {
        this.ichiGojiHanteiKekkaCode = ichiGojiHanteiKekkaCode;
    }

    /**
     * 要介護認定1.5次判定結果コード（認知症加算）のgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））
     *
     * @return 要介護認定1.5次判定結果コード（認知症加算）
     */
    public Code getIchiGojiHanteiKekkaNinchishoKasanCode() {
        return ichiGojiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * 要介護認定1.5次判定結果コード（認知症加算）のsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））
     *
     * @param ichiGojiHanteiKekkaNinchishoKasanCode 要介護認定1.5次判定結果コード（認知症加算）
     */
    public void setIchiGojiHanteiKekkaNinchishoKasanCode(@Nonnull Code ichiGojiHanteiKekkaNinchishoKasanCode) {
        this.ichiGojiHanteiKekkaNinchishoKasanCode = ichiGojiHanteiKekkaNinchishoKasanCode;
    }

    /**
     * 要介護認定等基準時間のgetメソッドです。
     *
     * @return 要介護認定等基準時間
     */
    public int getKijunJikan() {
        return kijunJikan;
    }

    /**
     * 要介護認定等基準時間のsetメソッドです。
     *
     * @param kijunJikan 要介護認定等基準時間
     */
    public void setKijunJikan(@Nonnull int kijunJikan) {
        this.kijunJikan = kijunJikan;
    }

    /**
     * 要介護認定等基準時間（食事）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（食事）
     */
    public int getKijunJikanShokuji() {
        return kijunJikanShokuji;
    }

    /**
     * 要介護認定等基準時間（食事）のsetメソッドです。
     *
     * @param kijunJikanShokuji 要介護認定等基準時間（食事）
     */
    public void setKijunJikanShokuji(@Nonnull int kijunJikanShokuji) {
        this.kijunJikanShokuji = kijunJikanShokuji;
    }

    /**
     * 要介護認定等基準時間（排泄）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（排泄）
     */
    public int getKijunJikanHaisetsu() {
        return kijunJikanHaisetsu;
    }

    /**
     * 要介護認定等基準時間（排泄）のsetメソッドです。
     *
     * @param kijunJikanHaisetsu 要介護認定等基準時間（排泄）
     */
    public void setKijunJikanHaisetsu(@Nonnull int kijunJikanHaisetsu) {
        this.kijunJikanHaisetsu = kijunJikanHaisetsu;
    }

    /**
     * 要介護認定等基準時間（移動）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（移動）
     */
    public int getKijunJikanIdo() {
        return kijunJikanIdo;
    }

    /**
     * 要介護認定等基準時間（移動）のsetメソッドです。
     *
     * @param kijunJikanIdo 要介護認定等基準時間（移動）
     */
    public void setKijunJikanIdo(@Nonnull int kijunJikanIdo) {
        this.kijunJikanIdo = kijunJikanIdo;
    }

    /**
     * 要介護認定等基準時間（清潔保持）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（清潔保持）
     */
    public int getKijunJikanSeiketsuHoji() {
        return kijunJikanSeiketsuHoji;
    }

    /**
     * 要介護認定等基準時間（清潔保持）のsetメソッドです。
     *
     * @param kijunJikanSeiketsuHoji 要介護認定等基準時間（清潔保持）
     */
    public void setKijunJikanSeiketsuHoji(@Nonnull int kijunJikanSeiketsuHoji) {
        this.kijunJikanSeiketsuHoji = kijunJikanSeiketsuHoji;
    }

    /**
     * 要介護認定等基準時間（間接ケア）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（間接ケア）
     */
    public int getKijunJikanKansetsuCare() {
        return kijunJikanKansetsuCare;
    }

    /**
     * 要介護認定等基準時間（間接ケア）のsetメソッドです。
     *
     * @param kijunJikanKansetsuCare 要介護認定等基準時間（間接ケア）
     */
    public void setKijunJikanKansetsuCare(@Nonnull int kijunJikanKansetsuCare) {
        this.kijunJikanKansetsuCare = kijunJikanKansetsuCare;
    }

    /**
     * 要介護認定等基準時間（BPSD関連）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（BPSD関連）
     */
    public int getKijunJikanBPSDKanren() {
        return kijunJikanBPSDKanren;
    }

    /**
     * 要介護認定等基準時間（BPSD関連）のsetメソッドです。
     *
     * @param kijunJikanBPSDKanren 要介護認定等基準時間（BPSD関連）
     */
    public void setKijunJikanBPSDKanren(@Nonnull int kijunJikanBPSDKanren) {
        this.kijunJikanBPSDKanren = kijunJikanBPSDKanren;
    }

    /**
     * 要介護認定等基準時間（機能訓練）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（機能訓練）
     */
    public int getKijunJikanKinoKunren() {
        return kijunJikanKinoKunren;
    }

    /**
     * 要介護認定等基準時間（機能訓練）のsetメソッドです。
     *
     * @param kijunJikanKinoKunren 要介護認定等基準時間（機能訓練）
     */
    public void setKijunJikanKinoKunren(@Nonnull int kijunJikanKinoKunren) {
        this.kijunJikanKinoKunren = kijunJikanKinoKunren;
    }

    /**
     * 要介護認定等基準時間（医療関連）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（医療関連）
     */
    public int getKijunJikanIryoKanren() {
        return kijunJikanIryoKanren;
    }

    /**
     * 要介護認定等基準時間（医療関連）のsetメソッドです。
     *
     * @param kijunJikanIryoKanren 要介護認定等基準時間（医療関連）
     */
    public void setKijunJikanIryoKanren(@Nonnull int kijunJikanIryoKanren) {
        this.kijunJikanIryoKanren = kijunJikanIryoKanren;
    }

    /**
     * 要介護認定等基準時間（認知症加算）のgetメソッドです。
     *
     * @return 要介護認定等基準時間（認知症加算）
     */
    public int getKijunJikanNinchishoKasan() {
        return kijunJikanNinchishoKasan;
    }

    /**
     * 要介護認定等基準時間（認知症加算）のsetメソッドです。
     *
     * @param kijunJikanNinchishoKasan 要介護認定等基準時間（認知症加算）
     */
    public void setKijunJikanNinchishoKasan(@Nonnull int kijunJikanNinchishoKasan) {
        this.kijunJikanNinchishoKasan = kijunJikanNinchishoKasan;
    }

    /**
     * 中間評価項目得点第1群のgetメソッドです。
     *
     * @return 中間評価項目得点第1群
     */
    public int getChukanHyokaKomoku1gun() {
        return chukanHyokaKomoku1gun;
    }

    /**
     * 中間評価項目得点第1群のsetメソッドです。
     *
     * @param chukanHyokaKomoku1gun 中間評価項目得点第1群
     */
    public void setChukanHyokaKomoku1gun(@Nonnull int chukanHyokaKomoku1gun) {
        this.chukanHyokaKomoku1gun = chukanHyokaKomoku1gun;
    }

    /**
     * 中間評価項目得点第2群のgetメソッドです。
     *
     * @return 中間評価項目得点第2群
     */
    public int getChukanHyokaKomoku2gun() {
        return chukanHyokaKomoku2gun;
    }

    /**
     * 中間評価項目得点第2群のsetメソッドです。
     *
     * @param chukanHyokaKomoku2gun 中間評価項目得点第2群
     */
    public void setChukanHyokaKomoku2gun(@Nonnull int chukanHyokaKomoku2gun) {
        this.chukanHyokaKomoku2gun = chukanHyokaKomoku2gun;
    }

    /**
     * 中間評価項目得点第3群のgetメソッドです。
     *
     * @return 中間評価項目得点第3群
     */
    public int getChukanHyokaKomoku3gun() {
        return chukanHyokaKomoku3gun;
    }

    /**
     * 中間評価項目得点第3群のsetメソッドです。
     *
     * @param chukanHyokaKomoku3gun 中間評価項目得点第3群
     */
    public void setChukanHyokaKomoku3gun(@Nonnull int chukanHyokaKomoku3gun) {
        this.chukanHyokaKomoku3gun = chukanHyokaKomoku3gun;
    }

    /**
     * 中間評価項目得点第4群のgetメソッドです。
     *
     * @return 中間評価項目得点第4群
     */
    public int getChukanHyokaKomoku4gun() {
        return chukanHyokaKomoku4gun;
    }

    /**
     * 中間評価項目得点第4群のsetメソッドです。
     *
     * @param chukanHyokaKomoku4gun 中間評価項目得点第4群
     */
    public void setChukanHyokaKomoku4gun(@Nonnull int chukanHyokaKomoku4gun) {
        this.chukanHyokaKomoku4gun = chukanHyokaKomoku4gun;
    }

    /**
     * 中間評価項目得点第5群のgetメソッドです。
     *
     * @return 中間評価項目得点第5群
     */
    public int getChukanHyokaKomoku5gun() {
        return chukanHyokaKomoku5gun;
    }

    /**
     * 中間評価項目得点第5群のsetメソッドです。
     *
     * @param chukanHyokaKomoku5gun 中間評価項目得点第5群
     */
    public void setChukanHyokaKomoku5gun(@Nonnull int chukanHyokaKomoku5gun) {
        this.chukanHyokaKomoku5gun = chukanHyokaKomoku5gun;
    }

    /**
     * 要介護認定1.5次判定警告コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBD：一次判定警告コード09）
     *
     * @return 要介護認定1.5次判定警告コード
     */
    public Code getIchiGojiHnateiKeikokuCode() {
        return ichiGojiHnateiKeikokuCode;
    }

    /**
     * 要介護認定1.5次判定警告コードのsetメソッドです。
     * <br/>
     * <br/>Enum（DBD：一次判定警告コード09）
     *
     * @param ichiGojiHnateiKeikokuCode 要介護認定1.5次判定警告コード
     */
    public void setIchiGojiHnateiKeikokuCode(@Nonnull Code ichiGojiHnateiKeikokuCode) {
        this.ichiGojiHnateiKeikokuCode = ichiGojiHnateiKeikokuCode;
    }

    /**
     * 要介護認定状態の安定性コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：要介護認定状態の安定性コード）
     *
     * @return 要介護認定状態の安定性コード
     */
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
    public void setJotaiAnteiseiCode(@Nonnull Code jotaiAnteiseiCode) {
        this.jotaiAnteiseiCode = jotaiAnteiseiCode;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性のgetメソッドです。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    public Decimal getNinchishoJiritsudoIIijoNoGaizensei() {
        return ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性のsetメソッドです。
     *
     * @param ninchishoJiritsudoIIijoNoGaizensei 認知症自立度Ⅱ以上の蓋然性
     */
    public void setNinchishoJiritsudoIIijoNoGaizensei(@Nonnull Decimal ninchishoJiritsudoIIijoNoGaizensei) {
        this.ninchishoJiritsudoIIijoNoGaizensei = ninchishoJiritsudoIIijoNoGaizensei;
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードのgetメソッドです。
     * <br/>
     * <br/>Enum（DBE：認知機能及び状態安定性から推定される給付区分コード）
     *
     * @return 認知機能及び状態安定性から推定される給付区分コード
     */
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
    public void setSuiteiKyufuKubunCode(@Nonnull Code suiteiKyufuKubunCode) {
        this.suiteiKyufuKubunCode = suiteiKyufuKubunCode;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT5510IchiGojiHanteiKekkaJohoEntity}と等しいか判定します。
     *
     * @param other 比較するエンティティ
     * @return 比較するエンティティが同じ主キーを持つ{@literal DbT5510IchiGojiHanteiKekkaJohoEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT5510IchiGojiHanteiKekkaJohoEntity other) {
        if (other == null) {
            return false;
        }
        if (!Objects.equals(this.shinseishoKanriNo, other.shinseishoKanriNo)) {
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
    public void shallowCopy(DbT5510IchiGojiHanteiKekkaJohoEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.ichiGojiHanteiYMD = entity.ichiGojiHanteiYMD;
        this.ichiGojiHanteiKekkaCode = entity.ichiGojiHanteiKekkaCode;
        this.ichiGojiHanteiKekkaNinchishoKasanCode = entity.ichiGojiHanteiKekkaNinchishoKasanCode;
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
        this.ichiGojiHnateiKeikokuCode = entity.ichiGojiHnateiKeikokuCode;
        this.jotaiAnteiseiCode = entity.jotaiAnteiseiCode;
        this.ninchishoJiritsudoIIijoNoGaizensei = entity.ninchishoJiritsudoIIijoNoGaizensei;
        this.suiteiKyufuKubunCode = entity.suiteiKyufuKubunCode;
    }

    /**
     * {@inheritDoc}
     *
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, ichiGojiHanteiYMD, ichiGojiHanteiKekkaCode, ichiGojiHanteiKekkaNinchishoKasanCode, kijunJikan, kijunJikanShokuji, kijunJikanHaisetsu, kijunJikanIdo, kijunJikanSeiketsuHoji, kijunJikanKansetsuCare, kijunJikanBPSDKanren, kijunJikanKinoKunren, kijunJikanIryoKanren, kijunJikanNinchishoKasan, chukanHyokaKomoku1gun, chukanHyokaKomoku2gun, chukanHyokaKomoku3gun, chukanHyokaKomoku4gun, chukanHyokaKomoku5gun, ichiGojiHnateiKeikokuCode, jotaiAnteiseiCode, ninchishoJiritsudoIIijoNoGaizensei, suiteiKyufuKubunCode);
    }

// </editor-fold>
}
