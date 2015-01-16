/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3047ShokanServicePlan200904Entity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求サービス計画200904のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanServicePlan200904Model implements Serializable {

    private DbT3047ShokanServicePlan200904Entity entity;

    /**
     * コンストラクタです。
     */
    public ShokanServicePlan200904Model() {
        entity = new DbT3047ShokanServicePlan200904Entity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3047ShokanServicePlan200904Entity
     */
    public ShokanServicePlan200904Model(DbT3047ShokanServicePlan200904Entity entity) {
        this.entity = entity;
    }

    /**
     * DbT3047ShokanServicePlan200904Entityを返します。
     *
     * @return DbT3047ShokanServicePlan200904Entity
     */
    public DbT3047ShokanServicePlan200904Entity getEntity() {
        return entity;
    }

    /**
     * DbT3047ShokanServicePlan200904Entityを設定します。
     *
     * @param entity DbT3047ShokanServicePlan200904Entity
     */
    public void setEntity(DbT3047ShokanServicePlan200904Entity entity) {
        this.entity = entity;
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNp();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * 指定基準該当事業者区分コードを返します。
     *
     * @return 指定基準該当事業者区分コード
     */
    public RString get指定基準該当事業者区分コード() {
        return entity.getShiteiKijunGaitoJigyoshaKubunCode();
    }

    /**
     * 明細行番号を返します。
     *
     * @return 明細行番号
     */
    public RString get明細行番号() {
        return entity.getMeisaiLineNo();
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
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTanisuTanka();
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
        return entity.getTantokangoshienSemmoninNo();
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
     * 審査方法区分コードを返します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity.getShinsaHohoKubunCode();
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
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShikyuKubunCode();
    }

    /**
     * 点数金額を返します。
     *
     * @return 点数金額
     */
    public int get点数金額() {
        return entity.getTensuKingaku();
    }

    /**
     * 支給金額を返します。
     *
     * @return 支給金額
     */
    public int get支給金額() {
        return entity.getShikyuKingaku();
    }

    /**
     * 増減点を返します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity.getZougenTen();
    }

    /**
     * 差額金額を返します。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return entity.getSagakuKingaku();
    }

    /**
     * 増減理由等を返します。
     *
     * @return 増減理由等
     */
    public RString get増減理由等() {
        return entity.getZougenRiyu();
    }

    /**
     * 不支給理由等を返します。
     *
     * @return 不支給理由等
     */
    public RString get不支給理由等() {
        return entity.getFushikyuRiyu();
    }

    /**
     * 購入_改修履歴等を返します。
     *
     * @return 購入_改修履歴等
     */
    public RString get購入_改修履歴等() {
        return entity.getKounyuKaishuRireki();
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
     * 整理番号を設定します。
     *
     * @param 整理番号 整理番号
     */
    public void set整理番号(RString 整理番号) {
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        entity.setSeiriNp(整理番号);
    }

    /**
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
    }

    /**
     * 様式番号を設定します。
     *
     * @param 様式番号 様式番号
     */
    public void set様式番号(RString 様式番号) {
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        entity.setYoshikiNo(様式番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * 指定基準該当事業者区分コードを設定します。
     *
     * @param 指定基準該当事業者区分コード 指定基準該当事業者区分コード
     */
    public void set指定基準該当事業者区分コード(RString 指定基準該当事業者区分コード) {
        requireNonNull(指定基準該当事業者区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定基準該当事業者区分コード")
        );
        entity.setShiteiKijunGaitoJigyoshaKubunCode(指定基準該当事業者区分コード
        );
    }

    /**
     * 明細行番号を設定します。
     *
     * @param 明細行番号 明細行番号
     */
    public void set明細行番号(RString 明細行番号) {
        requireNonNull(明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細行番号"));
        entity.setMeisaiLineNo(明細行番号);
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
     * 単位数単価を設定します。
     *
     * @param 単位数単価 単位数単価
     */
    public void set単位数単価(Decimal 単位数単価) {
        requireNonNull(単位数単価, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数単価"));
        entity.setTanisuTanka(単位数単価);
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
        entity.setTantokangoshienSemmoninNo(担当介護支援専門員番号);
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
     * 審査方法区分コードを設定します。
     *
     * @param 審査方法区分コード 審査方法区分コード
     */
    public void set審査方法区分コード(RString 審査方法区分コード) {
        requireNonNull(審査方法区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("審査方法区分コード"));
        entity.setShinsaHohoKubunCode(審査方法区分コード);
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
     * 支給区分コードを設定します。
     *
     * @param 支給区分コード 支給区分コード
     */
    public void set支給区分コード(RString 支給区分コード) {
        requireNonNull(支給区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支給区分コード"));
        entity.setShikyuKubunCode(支給区分コード);
    }

    /**
     * 点数金額を設定します。
     *
     * @param 点数金額 点数金額
     */
    public void set点数金額(int 点数金額) {
        requireNonNull(点数金額, UrSystemErrorMessages.値がnull.getReplacedMessage("点数金額")
        );
        entity.setTensuKingaku(点数金額
        );
    }

    /**
     * 支給金額を設定します。
     *
     * @param 支給金額 支給金額
     */
    public void set支給金額(int 支給金額) {
        requireNonNull(支給金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支給金額"));
        entity.setShikyuKingaku(支給金額);
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     */
    public void set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenTen(増減点);
    }

    /**
     * 差額金額を設定します。
     *
     * @param 差額金額 差額金額
     */
    public void set差額金額(int 差額金額) {
        requireNonNull(差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("差額金額"));
        entity.setSagakuKingaku(差額金額);
    }

    /**
     * 増減理由等を設定します。
     *
     * @param 増減理由等 増減理由等
     */
    public void set増減理由等(RString 増減理由等) {
        requireNonNull(増減理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("増減理由等"));
        entity.setZougenRiyu(増減理由等);
    }

    /**
     * 不支給理由等を設定します。
     *
     * @param 不支給理由等 不支給理由等
     */
    public void set不支給理由等(RString 不支給理由等) {
        requireNonNull(不支給理由等, UrSystemErrorMessages.値がnull.getReplacedMessage("不支給理由等"));
        entity.setFushikyuRiyu(不支給理由等);
    }

    /**
     * 購入_改修履歴等を設定します。
     *
     * @param 購入_改修履歴等 購入_改修履歴等
     */
    public void set購入_改修履歴等(RString 購入_改修履歴等) {
        requireNonNull(購入_改修履歴等, UrSystemErrorMessages.値がnull.getReplacedMessage("購入_改修履歴等"));
        entity.setKounyuKaishuRireki(購入_改修履歴等);
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
