package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.DbTableEntityBase;
import jp.co.ndensan.reams.uz.uza.util.db.PrimaryKey;
import jp.co.ndensan.reams.uz.uza.util.db.TableName;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import java.util.UUID;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

/**
 * 要介護認定インターフェース情報テーブルのエンティティクラスです。
 */
public class DbT4003YokaigoNinteiInterfaceEntity extends DbTableEntityBase<DbT4003YokaigoNinteiInterfaceEntity> implements IDbAccessable {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    @TableName
    public static final RString TABLE_NAME = new RString("DbT4003YokaigoNinteiInterface");

    private RString insertDantaiCd;
    private RDateTime insertTimestamp;
    private RString insertReamsLoginId;
    private UUID insertContextId;
    private boolean isDeleted = false;
    private int updateCount = 0;
    private RDateTime lastUpdateTimestamp;
    private RString lastUpdateReamsLoginId;
    private ShinseishoKanriNo shinseishoKanriNo;
    private HihokenshaNo hihokenshaNo;
    private RString rirekiNo;
    private YMDHMS torikomiTimestamp;
    private RString torikomiKubun;
    private RString shinseiShubetsuCode;
    private RString torisageKubunCode;
    private FlexibleDate shinseiYMD;
    private RString iryoKikanCode;
    private RString shujiiCode;
    private FlexibleDate ikenshoIraiYMD;
    private FlexibleDate ikenshoToriyoseYMD;
    private FlexibleDate chosaItakuYMD;
    private FlexibleDate chosaShuryoYMD;
    private JigyoshaNo chosaItakusakiCode;
    private RString chosainCode;
    private FlexibleDate ichijiHanteiYMD;
    private RString ichijiHanteiKekkaCode;
    private RString ichijiHanteiKekkaKasanCode;
    private FlexibleDate shinsakaiShiryoSakuseiYMD;
    private FlexibleDate shinsakaiYoteiYMD;
    private int gogitaiNo;
    private FlexibleDate nijiHanteiYMD;
    private RString nijiHanteiKekkaCode;
    private FlexibleDate ninteiYukoKikanStart;
    private FlexibleDate ninteiYukoKikanEnd;
    private RString serviceHenkoRiyuCode;
    private RString tokuteiShippeiCode;
    private RString shogaiKoreiJiritsudo;
    private RString ninchishoKoreiJiritsudo;
    private RString shinsakaiIken;
    private RString versionNo;
    private RString ichijiHanteiNaiyo;
    private RString ichijiHanteiNaiyo2;
    private YMDHMS zenTorikomiTimestamp;
    private RString keshikomiFlag;
    private YMDHMS keshikomiTimestamp;
    private RString yobiKomoku1;
    private RString yobiKomoku2;
    private RString yobiKomoku3;
    private RString yobiKomoku4;
    private RString yobiKomoku5;
    private RString yobiKubun1;
    private RString yobiKubun2;
    private RString yobiKubun3;
    private RString yobiKubun4;
    private RString yobiKubun5;
    private RString reserve;

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
     * 
     * @return 申請書管理番号
     */
    @CheckForNull
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 申請書管理番号のsetメソッドです。
     * 
     * @param shinseishoKanriNo 申請書管理番号
     */
    public void setShinseishoKanriNo(ShinseishoKanriNo shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * 被保険者番号のgetメソッドです。
     * 
     * @return 被保険者番号
     */
    @CheckForNull
    public HihokenshaNo getHihokenshaNo() {
        return hihokenshaNo;
    }

    /**
     * 被保険者番号のsetメソッドです。
     * 
     * @param hihokenshaNo 被保険者番号
     */
    public void setHihokenshaNo(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * 履歴番号のgetメソッドです。
     * 
     * @return 履歴番号
     */
    @CheckForNull
    public RString getRirekiNo() {
        return rirekiNo;
    }

    /**
     * 履歴番号のsetメソッドです。
     * 
     * @param rirekiNo 履歴番号
     */
    public void setRirekiNo(RString rirekiNo) {
        this.rirekiNo = rirekiNo;
    }

    /**
     * 取込日時のgetメソッドです。
     * 
     * @return 取込日時
     */
    @CheckForNull
    public YMDHMS getTorikomiTimestamp() {
        return torikomiTimestamp;
    }

    /**
     * 取込日時のsetメソッドです。
     * 
     * @param torikomiTimestamp 取込日時
     */
    public void setTorikomiTimestamp(YMDHMS torikomiTimestamp) {
        this.torikomiTimestamp = torikomiTimestamp;
    }

    /**
     * 取込区分のgetメソッドです。
     * 
     * @return 取込区分
     */
    @CheckForNull
    public RString getTorikomiKubun() {
        return torikomiKubun;
    }

    /**
     * 取込区分のsetメソッドです。
     * 
     * @param torikomiKubun 取込区分
     */
    public void setTorikomiKubun(RString torikomiKubun) {
        this.torikomiKubun = torikomiKubun;
    }

    /**
     * 申請種別コードのgetメソッドです。
     * 
     * @return 申請種別コード
     */
    @CheckForNull
    public RString getShinseiShubetsuCode() {
        return shinseiShubetsuCode;
    }

    /**
     * 申請種別コードのsetメソッドです。
     * 
     * @param shinseiShubetsuCode 申請種別コード
     */
    public void setShinseiShubetsuCode(RString shinseiShubetsuCode) {
        this.shinseiShubetsuCode = shinseiShubetsuCode;
    }

    /**
     * 取下区分コードのgetメソッドです。
     * 
     * @return 取下区分コード
     */
    @CheckForNull
    public RString getTorisageKubunCode() {
        return torisageKubunCode;
    }

    /**
     * 取下区分コードのsetメソッドです。
     * 
     * @param torisageKubunCode 取下区分コード
     */
    public void setTorisageKubunCode(RString torisageKubunCode) {
        this.torisageKubunCode = torisageKubunCode;
    }

    /**
     * 認定申請日のgetメソッドです。
     * 
     * @return 認定申請日
     */
    @CheckForNull
    public FlexibleDate getShinseiYMD() {
        return shinseiYMD;
    }

    /**
     * 認定申請日のsetメソッドです。
     * 
     * @param shinseiYMD 認定申請日
     */
    public void setShinseiYMD(FlexibleDate shinseiYMD) {
        this.shinseiYMD = shinseiYMD;
    }

    /**
     * 医療機関コードのgetメソッドです。
     * 
     * @return 医療機関コード
     */
    @CheckForNull
    public RString getIryoKikanCode() {
        return iryoKikanCode;
    }

    /**
     * 医療機関コードのsetメソッドです。
     * 
     * @param iryoKikanCode 医療機関コード
     */
    public void setIryoKikanCode(RString iryoKikanCode) {
        this.iryoKikanCode = iryoKikanCode;
    }

    /**
     * 主治医コードのgetメソッドです。
     * 
     * @return 主治医コード
     */
    @CheckForNull
    public RString getShujiiCode() {
        return shujiiCode;
    }

    /**
     * 主治医コードのsetメソッドです。
     * 
     * @param shujiiCode 主治医コード
     */
    public void setShujiiCode(RString shujiiCode) {
        this.shujiiCode = shujiiCode;
    }

    /**
     * 意見書依頼年月日のgetメソッドです。
     * 
     * @return 意見書依頼年月日
     */
    @CheckForNull
    public FlexibleDate getIkenshoIraiYMD() {
        return ikenshoIraiYMD;
    }

    /**
     * 意見書依頼年月日のsetメソッドです。
     * 
     * @param ikenshoIraiYMD 意見書依頼年月日
     */
    public void setIkenshoIraiYMD(FlexibleDate ikenshoIraiYMD) {
        this.ikenshoIraiYMD = ikenshoIraiYMD;
    }

    /**
     * 意見書取寄せ年月日のgetメソッドです。
     * 
     * @return 意見書取寄せ年月日
     */
    @CheckForNull
    public FlexibleDate getIkenshoToriyoseYMD() {
        return ikenshoToriyoseYMD;
    }

    /**
     * 意見書取寄せ年月日のsetメソッドです。
     * 
     * @param ikenshoToriyoseYMD 意見書取寄せ年月日
     */
    public void setIkenshoToriyoseYMD(FlexibleDate ikenshoToriyoseYMD) {
        this.ikenshoToriyoseYMD = ikenshoToriyoseYMD;
    }

    /**
     * 調査委託年月日のgetメソッドです。
     * 
     * @return 調査委託年月日
     */
    @CheckForNull
    public FlexibleDate getChosaItakuYMD() {
        return chosaItakuYMD;
    }

    /**
     * 調査委託年月日のsetメソッドです。
     * 
     * @param chosaItakuYMD 調査委託年月日
     */
    public void setChosaItakuYMD(FlexibleDate chosaItakuYMD) {
        this.chosaItakuYMD = chosaItakuYMD;
    }

    /**
     * 調査終了年月日のgetメソッドです。
     * 
     * @return 調査終了年月日
     */
    @CheckForNull
    public FlexibleDate getChosaShuryoYMD() {
        return chosaShuryoYMD;
    }

    /**
     * 調査終了年月日のsetメソッドです。
     * 
     * @param chosaShuryoYMD 調査終了年月日
     */
    public void setChosaShuryoYMD(FlexibleDate chosaShuryoYMD) {
        this.chosaShuryoYMD = chosaShuryoYMD;
    }

    /**
     * 調査委託先コードのgetメソッドです。
     * 
     * @return 調査委託先コード
     */
    @CheckForNull
    public JigyoshaNo getChosaItakusakiCode() {
        return chosaItakusakiCode;
    }

    /**
     * 調査委託先コードのsetメソッドです。
     * 
     * @param chosaItakusakiCode 調査委託先コード
     */
    public void setChosaItakusakiCode(JigyoshaNo chosaItakusakiCode) {
        this.chosaItakusakiCode = chosaItakusakiCode;
    }

    /**
     * 調査員コードのgetメソッドです。
     * 
     * @return 調査員コード
     */
    @CheckForNull
    public RString getChosainCode() {
        return chosainCode;
    }

    /**
     * 調査員コードのsetメソッドです。
     * 
     * @param chosainCode 調査員コード
     */
    public void setChosainCode(RString chosainCode) {
        this.chosainCode = chosainCode;
    }

    /**
     * 一次判定日のgetメソッドです。
     * 
     * @return 一次判定日
     */
    @CheckForNull
    public FlexibleDate getIchijiHanteiYMD() {
        return ichijiHanteiYMD;
    }

    /**
     * 一次判定日のsetメソッドです。
     * 
     * @param ichijiHanteiYMD 一次判定日
     */
    public void setIchijiHanteiYMD(FlexibleDate ichijiHanteiYMD) {
        this.ichijiHanteiYMD = ichijiHanteiYMD;
    }

    /**
     * 一次判定結果のgetメソッドです。
     * 
     * @return 一次判定結果
     */
    @CheckForNull
    public RString getIchijiHanteiKekkaCode() {
        return ichijiHanteiKekkaCode;
    }

    /**
     * 一次判定結果のsetメソッドです。
     * 
     * @param ichijiHanteiKekkaCode 一次判定結果
     */
    public void setIchijiHanteiKekkaCode(RString ichijiHanteiKekkaCode) {
        this.ichijiHanteiKekkaCode = ichijiHanteiKekkaCode;
    }

    /**
     * 一次判定結果（認知症加算）のgetメソッドです。
     * 
     * @return 一次判定結果（認知症加算）
     */
    @CheckForNull
    public RString getIchijiHanteiKekkaKasanCode() {
        return ichijiHanteiKekkaKasanCode;
    }

    /**
     * 一次判定結果（認知症加算）のsetメソッドです。
     * 
     * @param ichijiHanteiKekkaKasanCode 一次判定結果（認知症加算）
     */
    public void setIchijiHanteiKekkaKasanCode(RString ichijiHanteiKekkaKasanCode) {
        this.ichijiHanteiKekkaKasanCode = ichijiHanteiKekkaKasanCode;
    }

    /**
     * 審査会資料作成年月日のgetメソッドです。
     * 
     * @return 審査会資料作成年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiShiryoSakuseiYMD() {
        return shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 審査会資料作成年月日のsetメソッドです。
     * 
     * @param shinsakaiShiryoSakuseiYMD 審査会資料作成年月日
     */
    public void setShinsakaiShiryoSakuseiYMD(FlexibleDate shinsakaiShiryoSakuseiYMD) {
        this.shinsakaiShiryoSakuseiYMD = shinsakaiShiryoSakuseiYMD;
    }

    /**
     * 審査会予定年月日のgetメソッドです。
     * 
     * @return 審査会予定年月日
     */
    @CheckForNull
    public FlexibleDate getShinsakaiYoteiYMD() {
        return shinsakaiYoteiYMD;
    }

    /**
     * 審査会予定年月日のsetメソッドです。
     * 
     * @param shinsakaiYoteiYMD 審査会予定年月日
     */
    public void setShinsakaiYoteiYMD(FlexibleDate shinsakaiYoteiYMD) {
        this.shinsakaiYoteiYMD = shinsakaiYoteiYMD;
    }

    /**
     * 合議体番号のgetメソッドです。
     * 
     * @return 合議体番号
     */
    @CheckForNull
    public int getGogitaiNo() {
        return gogitaiNo;
    }

    /**
     * 合議体番号のsetメソッドです。
     * 
     * @param gogitaiNo 合議体番号
     */
    public void setGogitaiNo(int gogitaiNo) {
        this.gogitaiNo = gogitaiNo;
    }

    /**
     * 二次判定日のgetメソッドです。
     * 
     * @return 二次判定日
     */
    @CheckForNull
    public FlexibleDate getNijiHanteiYMD() {
        return nijiHanteiYMD;
    }

    /**
     * 二次判定日のsetメソッドです。
     * 
     * @param nijiHanteiYMD 二次判定日
     */
    public void setNijiHanteiYMD(FlexibleDate nijiHanteiYMD) {
        this.nijiHanteiYMD = nijiHanteiYMD;
    }

    /**
     * 二次判定結果のgetメソッドです。
     * 
     * @return 二次判定結果
     */
    @CheckForNull
    public RString getNijiHanteiKekkaCode() {
        return nijiHanteiKekkaCode;
    }

    /**
     * 二次判定結果のsetメソッドです。
     * 
     * @param nijiHanteiKekkaCode 二次判定結果
     */
    public void setNijiHanteiKekkaCode(RString nijiHanteiKekkaCode) {
        this.nijiHanteiKekkaCode = nijiHanteiKekkaCode;
    }

    /**
     * 認定有効開始年月日のgetメソッドです。
     * 
     * @return 認定有効開始年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanStart() {
        return ninteiYukoKikanStart;
    }

    /**
     * 認定有効開始年月日のsetメソッドです。
     * 
     * @param ninteiYukoKikanStart 認定有効開始年月日
     */
    public void setNinteiYukoKikanStart(FlexibleDate ninteiYukoKikanStart) {
        this.ninteiYukoKikanStart = ninteiYukoKikanStart;
    }

    /**
     * 認定有効終了年月日のgetメソッドです。
     * 
     * @return 認定有効終了年月日
     */
    @CheckForNull
    public FlexibleDate getNinteiYukoKikanEnd() {
        return ninteiYukoKikanEnd;
    }

    /**
     * 認定有効終了年月日のsetメソッドです。
     * 
     * @param ninteiYukoKikanEnd 認定有効終了年月日
     */
    public void setNinteiYukoKikanEnd(FlexibleDate ninteiYukoKikanEnd) {
        this.ninteiYukoKikanEnd = ninteiYukoKikanEnd;
    }

    /**
     * サービス変更理由コードのgetメソッドです。
     * 
     * @return サービス変更理由コード
     */
    @CheckForNull
    public RString getServiceHenkoRiyuCode() {
        return serviceHenkoRiyuCode;
    }

    /**
     * サービス変更理由コードのsetメソッドです。
     * 
     * @param serviceHenkoRiyuCode サービス変更理由コード
     */
    public void setServiceHenkoRiyuCode(RString serviceHenkoRiyuCode) {
        this.serviceHenkoRiyuCode = serviceHenkoRiyuCode;
    }

    /**
     * 特定疾病コードのgetメソッドです。
     * 
     * @return 特定疾病コード
     */
    @CheckForNull
    public RString getTokuteiShippeiCode() {
        return tokuteiShippeiCode;
    }

    /**
     * 特定疾病コードのsetメソッドです。
     * 
     * @param tokuteiShippeiCode 特定疾病コード
     */
    public void setTokuteiShippeiCode(RString tokuteiShippeiCode) {
        this.tokuteiShippeiCode = tokuteiShippeiCode;
    }

    /**
     * 障害高齢者自立度のgetメソッドです。
     * 
     * @return 障害高齢者自立度
     */
    @CheckForNull
    public RString getShogaiKoreiJiritsudo() {
        return shogaiKoreiJiritsudo;
    }

    /**
     * 障害高齢者自立度のsetメソッドです。
     * 
     * @param shogaiKoreiJiritsudo 障害高齢者自立度
     */
    public void setShogaiKoreiJiritsudo(RString shogaiKoreiJiritsudo) {
        this.shogaiKoreiJiritsudo = shogaiKoreiJiritsudo;
    }

    /**
     * 認知症高齢者自立度のgetメソッドです。
     * 
     * @return 認知症高齢者自立度
     */
    @CheckForNull
    public RString getNinchishoKoreiJiritsudo() {
        return ninchishoKoreiJiritsudo;
    }

    /**
     * 認知症高齢者自立度のsetメソッドです。
     * 
     * @param ninchishoKoreiJiritsudo 認知症高齢者自立度
     */
    public void setNinchishoKoreiJiritsudo(RString ninchishoKoreiJiritsudo) {
        this.ninchishoKoreiJiritsudo = ninchishoKoreiJiritsudo;
    }

    /**
     * 審査会意見のgetメソッドです。
     * 
     * @return 審査会意見
     */
    @CheckForNull
    public RString getShinsakaiIken() {
        return shinsakaiIken;
    }

    /**
     * 審査会意見のsetメソッドです。
     * 
     * @param shinsakaiIken 審査会意見
     */
    public void setShinsakaiIken(RString shinsakaiIken) {
        this.shinsakaiIken = shinsakaiIken;
    }

    /**
     * 版番号のgetメソッドです。
     * 
     * @return 版番号
     */
    @CheckForNull
    public RString getVersionNo() {
        return versionNo;
    }

    /**
     * 版番号のsetメソッドです。
     * 
     * @param versionNo 版番号
     */
    public void setVersionNo(RString versionNo) {
        this.versionNo = versionNo;
    }

    /**
     * 一次判定内容のgetメソッドです。
     * 
     * @return 一次判定内容
     */
    @CheckForNull
    public RString getIchijiHanteiNaiyo() {
        return ichijiHanteiNaiyo;
    }

    /**
     * 一次判定内容のsetメソッドです。
     * 
     * @param ichijiHanteiNaiyo 一次判定内容
     */
    public void setIchijiHanteiNaiyo(RString ichijiHanteiNaiyo) {
        this.ichijiHanteiNaiyo = ichijiHanteiNaiyo;
    }

    /**
     * 一次判定内容２のgetメソッドです。
     * 
     * @return 一次判定内容２
     */
    @CheckForNull
    public RString getIchijiHanteiNaiyo2() {
        return ichijiHanteiNaiyo2;
    }

    /**
     * 一次判定内容２のsetメソッドです。
     * 
     * @param ichijiHanteiNaiyo2 一次判定内容２
     */
    public void setIchijiHanteiNaiyo2(RString ichijiHanteiNaiyo2) {
        this.ichijiHanteiNaiyo2 = ichijiHanteiNaiyo2;
    }

    /**
     * 前回取込日時のgetメソッドです。
     * 
     * @return 前回取込日時
     */
    @CheckForNull
    public YMDHMS getZenTorikomiTimestamp() {
        return zenTorikomiTimestamp;
    }

    /**
     * 前回取込日時のsetメソッドです。
     * 
     * @param zenTorikomiTimestamp 前回取込日時
     */
    public void setZenTorikomiTimestamp(YMDHMS zenTorikomiTimestamp) {
        this.zenTorikomiTimestamp = zenTorikomiTimestamp;
    }

    /**
     * 消し込みフラグのgetメソッドです。
     * 
     * @return 消し込みフラグ
     */
    @CheckForNull
    public RString getKeshikomiFlag() {
        return keshikomiFlag;
    }

    /**
     * 消し込みフラグのsetメソッドです。
     * 
     * @param keshikomiFlag 消し込みフラグ
     */
    public void setKeshikomiFlag(RString keshikomiFlag) {
        this.keshikomiFlag = keshikomiFlag;
    }

    /**
     * 消し込み日時のgetメソッドです。
     * 
     * @return 消し込み日時
     */
    @CheckForNull
    public YMDHMS getKeshikomiTimestamp() {
        return keshikomiTimestamp;
    }

    /**
     * 消し込み日時のsetメソッドです。
     * 
     * @param keshikomiTimestamp 消し込み日時
     */
    public void setKeshikomiTimestamp(YMDHMS keshikomiTimestamp) {
        this.keshikomiTimestamp = keshikomiTimestamp;
    }

    /**
     * 予備項目１のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備項目１
     */
    @CheckForNull
    public RString getYobiKomoku1() {
        return yobiKomoku1;
    }

    /**
     * 予備項目１のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKomoku1 予備項目１
     */
    public void setYobiKomoku1(RString yobiKomoku1) {
        this.yobiKomoku1 = yobiKomoku1;
    }

    /**
     * 予備項目２のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備項目２
     */
    @CheckForNull
    public RString getYobiKomoku2() {
        return yobiKomoku2;
    }

    /**
     * 予備項目２のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKomoku2 予備項目２
     */
    public void setYobiKomoku2(RString yobiKomoku2) {
        this.yobiKomoku2 = yobiKomoku2;
    }

    /**
     * 予備項目３のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備項目３
     */
    @CheckForNull
    public RString getYobiKomoku3() {
        return yobiKomoku3;
    }

    /**
     * 予備項目３のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKomoku3 予備項目３
     */
    public void setYobiKomoku3(RString yobiKomoku3) {
        this.yobiKomoku3 = yobiKomoku3;
    }

    /**
     * 予備項目４のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備項目４
     */
    @CheckForNull
    public RString getYobiKomoku4() {
        return yobiKomoku4;
    }

    /**
     * 予備項目４のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKomoku4 予備項目４
     */
    public void setYobiKomoku4(RString yobiKomoku4) {
        this.yobiKomoku4 = yobiKomoku4;
    }

    /**
     * 予備項目５のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備項目５
     */
    @CheckForNull
    public RString getYobiKomoku5() {
        return yobiKomoku5;
    }

    /**
     * 予備項目５のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKomoku5 予備項目５
     */
    public void setYobiKomoku5(RString yobiKomoku5) {
        this.yobiKomoku5 = yobiKomoku5;
    }

    /**
     * 予備区分１のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備区分１
     */
    @CheckForNull
    public RString getYobiKubun1() {
        return yobiKubun1;
    }

    /**
     * 予備区分１のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKubun1 予備区分１
     */
    public void setYobiKubun1(RString yobiKubun1) {
        this.yobiKubun1 = yobiKubun1;
    }

    /**
     * 予備区分２のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備区分２
     */
    @CheckForNull
    public RString getYobiKubun2() {
        return yobiKubun2;
    }

    /**
     * 予備区分２のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKubun2 予備区分２
     */
    public void setYobiKubun2(RString yobiKubun2) {
        this.yobiKubun2 = yobiKubun2;
    }

    /**
     * 予備区分３のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備区分３
     */
    @CheckForNull
    public RString getYobiKubun3() {
        return yobiKubun3;
    }

    /**
     * 予備区分３のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKubun3 予備区分３
     */
    public void setYobiKubun3(RString yobiKubun3) {
        this.yobiKubun3 = yobiKubun3;
    }

    /**
     * 予備区分４のgetメソッドです。
     * <br/>
     * <br/>申請区分（法令）コード
     * 
     * @return 予備区分４
     */
    @CheckForNull
    public RString getYobiKubun4() {
        return yobiKubun4;
    }

    /**
     * 予備区分４のsetメソッドです。
     * <br/>
     * <br/>申請区分（法令）コード
     * 
     * @param yobiKubun4 予備区分４
     */
    public void setYobiKubun4(RString yobiKubun4) {
        this.yobiKubun4 = yobiKubun4;
    }

    /**
     * 予備区分５のgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return 予備区分５
     */
    @CheckForNull
    public RString getYobiKubun5() {
        return yobiKubun5;
    }

    /**
     * 予備区分５のsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param yobiKubun5 予備区分５
     */
    public void setYobiKubun5(RString yobiKubun5) {
        this.yobiKubun5 = yobiKubun5;
    }

    /**
     * リザーブのgetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @return リザーブ
     */
    @CheckForNull
    public RString getReserve() {
        return reserve;
    }

    /**
     * リザーブのsetメソッドです。
     * <br/>
     * <br/>未使用
     * 
     * @param reserve リザーブ
     */
    public void setReserve(RString reserve) {
        this.reserve = reserve;
    }

    /**
     * このエンティティの主キーが他の{@literal DbT4003YokaigoNinteiInterfaceEntity}と等しいか判定します。
     * 
     * @param other 比較するエンティティ
     * @return 
     * 比較するエンティティが同じ主キーを持つ{@literal DbT4003YokaigoNinteiInterfaceEntity}の場合{@literal true}、それ以外の場合は{@literal false}
     */
    @Override
    public boolean equalsPrimaryKeys(DbT4003YokaigoNinteiInterfaceEntity other) {
        if (other == null) {
            return false;
        }
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void shallowCopy(DbT4003YokaigoNinteiInterfaceEntity entity) {
        this.shinseishoKanriNo = entity.shinseishoKanriNo;
        this.hihokenshaNo = entity.hihokenshaNo;
        this.rirekiNo = entity.rirekiNo;
        this.torikomiTimestamp = entity.torikomiTimestamp;
        this.torikomiKubun = entity.torikomiKubun;
        this.shinseiShubetsuCode = entity.shinseiShubetsuCode;
        this.torisageKubunCode = entity.torisageKubunCode;
        this.shinseiYMD = entity.shinseiYMD;
        this.iryoKikanCode = entity.iryoKikanCode;
        this.shujiiCode = entity.shujiiCode;
        this.ikenshoIraiYMD = entity.ikenshoIraiYMD;
        this.ikenshoToriyoseYMD = entity.ikenshoToriyoseYMD;
        this.chosaItakuYMD = entity.chosaItakuYMD;
        this.chosaShuryoYMD = entity.chosaShuryoYMD;
        this.chosaItakusakiCode = entity.chosaItakusakiCode;
        this.chosainCode = entity.chosainCode;
        this.ichijiHanteiYMD = entity.ichijiHanteiYMD;
        this.ichijiHanteiKekkaCode = entity.ichijiHanteiKekkaCode;
        this.ichijiHanteiKekkaKasanCode = entity.ichijiHanteiKekkaKasanCode;
        this.shinsakaiShiryoSakuseiYMD = entity.shinsakaiShiryoSakuseiYMD;
        this.shinsakaiYoteiYMD = entity.shinsakaiYoteiYMD;
        this.gogitaiNo = entity.gogitaiNo;
        this.nijiHanteiYMD = entity.nijiHanteiYMD;
        this.nijiHanteiKekkaCode = entity.nijiHanteiKekkaCode;
        this.ninteiYukoKikanStart = entity.ninteiYukoKikanStart;
        this.ninteiYukoKikanEnd = entity.ninteiYukoKikanEnd;
        this.serviceHenkoRiyuCode = entity.serviceHenkoRiyuCode;
        this.tokuteiShippeiCode = entity.tokuteiShippeiCode;
        this.shogaiKoreiJiritsudo = entity.shogaiKoreiJiritsudo;
        this.ninchishoKoreiJiritsudo = entity.ninchishoKoreiJiritsudo;
        this.shinsakaiIken = entity.shinsakaiIken;
        this.versionNo = entity.versionNo;
        this.ichijiHanteiNaiyo = entity.ichijiHanteiNaiyo;
        this.ichijiHanteiNaiyo2 = entity.ichijiHanteiNaiyo2;
        this.zenTorikomiTimestamp = entity.zenTorikomiTimestamp;
        this.keshikomiFlag = entity.keshikomiFlag;
        this.keshikomiTimestamp = entity.keshikomiTimestamp;
        this.yobiKomoku1 = entity.yobiKomoku1;
        this.yobiKomoku2 = entity.yobiKomoku2;
        this.yobiKomoku3 = entity.yobiKomoku3;
        this.yobiKomoku4 = entity.yobiKomoku4;
        this.yobiKomoku5 = entity.yobiKomoku5;
        this.yobiKubun1 = entity.yobiKubun1;
        this.yobiKubun2 = entity.yobiKubun2;
        this.yobiKubun3 = entity.yobiKubun3;
        this.yobiKubun4 = entity.yobiKubun4;
        this.yobiKubun5 = entity.yobiKubun5;
        this.reserve = entity.reserve;
    }

    /**
     * {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    public RString getMd5() {
        return super.toMd5(shinseishoKanriNo, hihokenshaNo, rirekiNo, torikomiTimestamp, torikomiKubun, shinseiShubetsuCode, torisageKubunCode, shinseiYMD, iryoKikanCode, shujiiCode, ikenshoIraiYMD, ikenshoToriyoseYMD, chosaItakuYMD, chosaShuryoYMD, chosaItakusakiCode, chosainCode, ichijiHanteiYMD, ichijiHanteiKekkaCode, ichijiHanteiKekkaKasanCode, shinsakaiShiryoSakuseiYMD, shinsakaiYoteiYMD, gogitaiNo, nijiHanteiYMD, nijiHanteiKekkaCode, ninteiYukoKikanStart, ninteiYukoKikanEnd, serviceHenkoRiyuCode, tokuteiShippeiCode, shogaiKoreiJiritsudo, ninchishoKoreiJiritsudo, shinsakaiIken, versionNo, ichijiHanteiNaiyo, ichijiHanteiNaiyo2, zenTorikomiTimestamp, keshikomiFlag, keshikomiTimestamp, yobiKomoku1, yobiKomoku2, yobiKomoku3, yobiKomoku4, yobiKomoku5, yobiKubun1, yobiKubun2, yobiKubun3, yobiKubun4, yobiKubun5, reserve);
    }

// </editor-fold>
}
