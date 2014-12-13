/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3025KyufujissekiKyotakuServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績居宅サービス計画費のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufujissekiKyotakuServiceModel implements Serializable {

    private DbT3025KyufujissekiKyotakuServiceEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKyotakuServiceModel() {
        entity = new DbT3025KyufujissekiKyotakuServiceEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3025KyufujissekiKyotakuServiceEntity
     */
    public KyufujissekiKyotakuServiceModel(DbT3025KyufujissekiKyotakuServiceEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3025KyufujissekiKyotakuServiceEntityを返します。
     *
     * @return DbT3025KyufujissekiKyotakuServiceEntity
     */
    public DbT3025KyufujissekiKyotakuServiceEntity getEntity() {
        return entity;
    }

    /**
     * DbT3025KyufujissekiKyotakuServiceEntityを設定します。
     *
     * @param entity DbT3025KyufujissekiKyotakuServiceEntity
     */
    public void setEntity(DbT3025KyufujissekiKyotakuServiceEntity entity) {
        this.entity = entity;
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
    }

    /**
     * サービス計画費明細行番号を返します。
     *
     * @return サービス計画費明細行番号
     */
    public RString getサービス計画費明細行番号() {
        return entity.getServicePlanhiMeisaiLineNo();
    }

    /**
     * 指定基準該当等事業所区分コードを返します。
     *
     * @return 指定基準該当等事業所区分コード
     */
    public RString get指定基準該当等事業所区分コード() {
        return entity.getShiteiKijunGaitoJigyoshaKubunCode();
    }

    /**
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTanisuTanka();
    }

    /**
     * 居宅サービス計画作成依頼届出年月日を返します。
     *
     * @return 居宅サービス計画作成依頼届出年月日
     */
    public FlexibleDate get居宅サービス計画作成依頼届出年月日() {
        return entity.getKyotakuServiceSakuseiIraiYMD();
    }

    /**
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public int get単位数() {
        return entity.getTanisu();
    }

    /**
     * 回数を返します。
     *
     * @return 回数
     */
    public int get回数() {
        return entity.getKaisu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * サービス単位数合計を返します。
     *
     * @return サービス単位数合計
     */
    public int getサービス単位数合計() {
        return entity.getServiceTanisuTotal();
    }

    /**
     * 請求金額を返します。
     *
     * @return 請求金額
     */
    public int get請求金額() {
        return entity.getSeikyuKingaku();
    }

    /**
     * 担当介護支援専門員番号を返します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return entity.getTantouKaigoShienSemmoninNo();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public int get後_単位数() {
        return entity.getAtoTanisu();
    }

    /**
     * 後_回数を返します。
     *
     * @return 後_回数
     */
    public int get後_回数() {
        return entity.getAtoKaisu();
    }

    /**
     * 後_サービス単位数を返します。
     *
     * @return 後_サービス単位数
     */
    public int get後_サービス単位数() {
        return entity.getAtoServiceTanisu();
    }

    /**
     * 後_サービス単位数合計を返します。
     *
     * @return 後_サービス単位数合計
     */
    public int get後_サービス単位数合計() {
        return entity.getAtoServiceTanisuTotal();
    }

    /**
     * 後_請求金額を返します。
     *
     * @return 後_請求金額
     */
    public int get後_請求金額() {
        return entity.getAtoSeikyuKingaku();
    }

    /**
     * 再審査回数を返します。
     *
     * @return 再審査回数
     */
    public int get再審査回数() {
        return entity.getSaishinsaKaisu();
    }

    /**
     * 過誤回数を返します。
     *
     * @return 過誤回数
     */
    public int get過誤回数() {
        return entity.getKagoKaisu();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * 交換情報識別番号を設定します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     */
    public void set交換情報識別番号(KokanShikibetsuNo 交換情報識別番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        entity.setKokanJohoShikibetsuNo(交換情報識別番号);
    }

    /**
     * 入力識別番号を設定します。
     *
     * @param 入力識別番号 入力識別番号
     */
    public void set入力識別番号(NyuryokuShikibetsuNo 入力識別番号) {
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        entity.setInputShikibetsuNo(入力識別番号);
    }

    /**
     * レコード種別コードを設定します。
     *
     * @param レコード種別コード レコード種別コード
     */
    public void setレコード種別コード(RString レコード種別コード) {
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        entity.setRecodeShubetsuCode(レコード種別コード);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(HokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShokisaiHokenshaNo(証記載保険者番号);
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHiHokenshaNo(被保険者番号);
    }

    /**
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
    }

    /**
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
    }

    /**
     * 通し番号を設定します。
     *
     * @param 通し番号 通し番号
     */
    public void set通し番号(RString 通し番号) {
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        entity.setToshiNo(通し番号);
    }

    /**
     * サービス計画費明細行番号を設定します。
     *
     * @param サービス計画費明細行番号 サービス計画費明細行番号
     */
    public void setサービス計画費明細行番号(RString サービス計画費明細行番号) {
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));
        entity.setServicePlanhiMeisaiLineNo(サービス計画費明細行番号);
    }

    /**
     * 指定基準該当等事業所区分コードを設定します。
     *
     * @param 指定基準該当等事業所区分コード 指定／基準該当等事業所区分コード
     */
    public void set指定基準該当等事業所区分コード(RString 指定基準該当等事業所区分コード) {
        requireNonNull(指定基準該当等事業所区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定基準該当等事業所区分コード")
        );
        entity.setShiteiKijunGaitoJigyoshaKubunCode(指定基準該当等事業所区分コード);
    }

    /**
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     */
    public void set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTanisuTanka(単位数単価);
    }

    /**
     * 居宅サービス計画作成依頼届出年月日を設定します。
     *
     * @param 居宅サービス計画作成依頼届出年月日 居宅サービス計画作成依頼届出年月日
     */
    public void set居宅サービス計画作成依頼届出年月日(FlexibleDate 居宅サービス計画作成依頼届出年月日) {
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        entity.setKyotakuServiceSakuseiIraiYMD(居宅サービス計画作成依頼届出年月日);
    }

    /**
     * サービスコードを設定します。
     *
     * @param サービスコード サービスコード
     */
    public void setサービスコード(ServiceCode サービスコード) {
        requireNonNull(サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービスコード"));
        entity.setServiceCode(サービスコード);
    }

    /**
     * 単位数を設定します。
     *
     * @param 単位数 単位数
     */
    public void set単位数(int 単位数) {
        requireNonNull(単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数"));
        entity.setTanisu(単位数);
    }

    /**
     * 回数を設定します。
     *
     * @param 回数 回数
     */
    public void set回数(int 回数) {
        requireNonNull(回数, UrSystemErrorMessages.値がnull.getReplacedMessage("回数"));
        entity.setKaisu(回数);
    }

    /**
     * サービス単位数を設定します。
     *
     * @param サービス単位数 サービス単位数
     */
    public void setサービス単位数(int サービス単位数) {
        requireNonNull(サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数"));
        entity.setServiceTanisu(サービス単位数);
    }

    /**
     * サービス単位数合計を設定します。
     *
     * @param サービス単位数合計 サービス単位数合計
     */
    public void setサービス単位数合計(int サービス単位数合計) {
        requireNonNull(サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス単位数合計"));
        entity.setServiceTanisuTotal(サービス単位数合計);
    }

    /**
     * 請求金額を設定します。
     *
     * @param 請求金額 請求金額
     */
    public void set請求金額(int 請求金額) {
        requireNonNull(請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求金額"));
        entity.setSeikyuKingaku(請求金額);
    }

    /**
     * 担当介護支援専門員番号を設定します。
     *
     * @param 担当介護支援専門員番号 担当介護支援専門員番号
     */
    public void set担当介護支援専門員番号(RString 担当介護支援専門員番号) {
        requireNonNull(担当介護支援専門員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("担当介護支援専門員番号"));
        entity.setTantouKaigoShienSemmoninNo(担当介護支援専門員番号);
    }

    /**
     * 摘要を設定します。
     *
     * @param 摘要 摘要
     */
    public void set摘要(RString 摘要) {
        requireNonNull(摘要, UrSystemErrorMessages.値がnull.getReplacedMessage("摘要"));
        entity.setTekiyo(摘要);
    }

    /**
     * 後_単位数を設定します。
     *
     * @param 後_単位数 後_単位数
     */
    public void set後_単位数(int 後_単位数) {
        requireNonNull(後_単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_単位数"));
        entity.setAtoTanisu(後_単位数);
    }

    /**
     * 後_回数を設定します。
     *
     * @param 後_回数 後_回数
     */
    public void set後_回数(int 後_回数) {
        requireNonNull(後_回数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_回数"));
        entity.setAtoKaisu(後_回数);
    }

    /**
     * 後_サービス単位数を設定します。
     *
     * @param 後_サービス単位数 後_サービス単位数
     */
    public void set後_サービス単位数(int 後_サービス単位数) {
        requireNonNull(後_サービス単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数"));
        entity.setAtoServiceTanisu(後_サービス単位数);
    }

    /**
     * 後_サービス単位数合計を設定します。
     *
     * @param 後_サービス単位数合計 後_サービス単位数合計
     */
    public void set後_サービス単位数合計(int 後_サービス単位数合計) {
        requireNonNull(後_サービス単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("後_サービス単位数合計"));
        entity.setAtoServiceTanisuTotal(後_サービス単位数合計);
    }

    /**
     * 後_請求金額を設定します。
     *
     * @param 後_請求金額 後_請求金額
     */
    public void set後_請求金額(int 後_請求金額) {
        requireNonNull(後_請求金額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_請求金額"));
        entity.setAtoSeikyuKingaku(後_請求金額);
    }

    /**
     * 再審査回数を設定します。
     *
     * @param 再審査回数 再審査回数
     */
    public void set再審査回数(int 再審査回数) {
        requireNonNull(再審査回数, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査回数"));
        entity.setSaishinsaKaisu(再審査回数);
    }

    /**
     * 過誤回数を設定します。
     *
     * @param 過誤回数 過誤回数
     */
    public void set過誤回数(int 過誤回数) {
        requireNonNull(過誤回数, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤回数"));
        entity.setKagoKaisu(過誤回数);
    }

    /**
     * 審査年月を設定します。
     *
     * @param 審査年月 審査年月
     */
    public void set審査年月(FlexibleYearMonth 審査年月) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        entity.setShinsaYM(審査年月);
    }

    /**
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNo(整理番号);
    }

    /**
     * 取込年月を設定します。
     *
     * @param 取込年月 取込年月
     */
    public void set取込年月(FlexibleYearMonth 取込年月) {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        entity.setTorikomiYM(取込年月);
    }

    /**
     * 状態に削除を設定します。
     *
     * @param deleteFlag deleteFlag
     */
    public void setDeletedState(boolean deleteFlag) {
        if (deleteFlag) {
            entity.setState(EntityDataState.Deleted);
        } else {
            entity.unsetState();
        }
    }

    /**
     * stateを返します。
     *
     * @return EntityDataState
     */
    public EntityDataState getState() {
        return entity.getState();
    }
}
