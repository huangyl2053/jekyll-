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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3043ShokanShokujiHiyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求食事費用のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanShokujiHiyoModel implements Serializable {

    private DbT3043ShokanShokujiHiyoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanShokujiHiyoModel() {
        entity = new DbT3043ShokanShokujiHiyoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3043ShokanShokujiHiyoEntity
     */
    public ShokanShokujiHiyoModel(DbT3043ShokanShokujiHiyoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3043ShokanShokujiHiyoEntityを返します。
     *
     * @return DbT3043ShokanShokujiHiyoEntity
     */
    public DbT3043ShokanShokujiHiyoEntity getEntity() {
        return entity;
    }

    /**
     * DbT3043ShokanShokujiHiyoEntityを設定します。
     *
     * @param entity DbT3043ShokanShokujiHiyoEntity
     */
    public void setEntity(DbT3043ShokanShokujiHiyoEntity entity) {
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
     * 基本提供日数を返します。
     *
     * @return 基本提供日数
     */
    public int get基本提供日数() {
        return entity.getKihonTeikyoNissu();
    }

    /**
     * 基本提供単価を返します。
     *
     * @return 基本提供単価
     */
    public int get基本提供単価() {
        return entity.getKihonTeikyoTanka();
    }

    /**
     * 基本提供金額を返します。
     *
     * @return 基本提供金額
     */
    public int get基本提供金額() {
        return entity.getKihonTeikyoKingaku();
    }

    /**
     * 特別提供日数を返します。
     *
     * @return 特別提供日数
     */
    public int get特別提供日数() {
        return entity.getTokubetsuTeikyoNissu();
    }

    /**
     * 特別提供単価を返します。
     *
     * @return 特別提供単価
     */
    public int get特別提供単価() {
        return entity.getTokubetsuTeikyoTanka();
    }

    /**
     * 特別提供金額を返します。
     *
     * @return 特別提供金額
     */
    public int get特別提供金額() {
        return entity.getTokubetsuTeikyoKingaku();
    }

    /**
     * 食事提供延べ日数を返します。
     *
     * @return 食事提供延べ日数
     */
    public int get食事提供延べ日数() {
        return entity.getShokujiTeikyoTotalNissu();
    }

    /**
     * 食事提供費合計を返します。
     *
     * @return 食事提供費合計
     */
    public int get食事提供費合計() {
        return entity.getShokujiTeikyohiTotal();
    }

    /**
     * 標準負担額_月額を返します。
     *
     * @return 標準負担額_月額
     */
    public int get標準負担額_月額() {
        return entity.getGetsugakuHyojunFutangaku();
    }

    /**
     * 食事提供費請求額を返します。
     *
     * @return 食事提供費請求額
     */
    public int get食事提供費請求額() {
        return entity.getShokujiTeikyohiSeikyugaku();
    }

    /**
     * 標準負担額_日額を返します。
     *
     * @return 標準負担額_日額
     */
    public int get標準負担額_日額() {
        return entity.getNichigakuHyojunFutangaku();
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
     * 基本提供日数を設定します。
     *
     * @param 基本提供日数 基本提供日数
     */
    public void set基本提供日数(int 基本提供日数) {
        requireNonNull(基本提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供日数"));
        entity.setKihonTeikyoNissu(基本提供日数);
    }

    /**
     * 基本提供単価を設定します。
     *
     * @param 基本提供単価 基本提供単価
     */
    public void set基本提供単価(int 基本提供単価) {
        requireNonNull(基本提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供単価"));
        entity.setKihonTeikyoTanka(基本提供単価);
    }

    /**
     * 基本提供金額を設定します。
     *
     * @param 基本提供金額 基本提供金額
     */
    public void set基本提供金額(int 基本提供金額) {
        requireNonNull(基本提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("基本提供金額"));
        entity.setKihonTeikyoKingaku(基本提供金額);
    }

    /**
     * 特別提供日数を設定します。
     *
     * @param 特別提供日数 特別提供日数
     */
    public void set特別提供日数(int 特別提供日数) {
        requireNonNull(特別提供日数, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供日数"));
        entity.setTokubetsuTeikyoNissu(特別提供日数);
    }

    /**
     * 特別提供単価を設定します。
     *
     * @param 特別提供単価 特別提供単価
     */
    public void set特別提供単価(int 特別提供単価) {
        requireNonNull(特別提供単価, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供単価"));
        entity.setTokubetsuTeikyoTanka(特別提供単価);
    }

    /**
     * 特別提供金額を設定します。
     *
     * @param 特別提供金額 特別提供金額
     */
    public void set特別提供金額(int 特別提供金額) {
        requireNonNull(特別提供金額, UrSystemErrorMessages.値がnull.getReplacedMessage("特別提供金額"));
        entity.setTokubetsuTeikyoKingaku(特別提供金額);
    }

    /**
     * 食事提供延べ日数を設定します。
     *
     * @param 食事提供延べ日数 食事提供延べ日数
     */
    public void set食事提供延べ日数(int 食事提供延べ日数) {
        requireNonNull(食事提供延べ日数, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供延べ日数"));
        entity.setShokujiTeikyoTotalNissu(食事提供延べ日数);
    }

    /**
     * 食事提供費合計を設定します。
     *
     * @param 食事提供費合計 食事提供費合計
     */
    public void set食事提供費合計(int 食事提供費合計) {
        requireNonNull(食事提供費合計, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費合計"));
        entity.setShokujiTeikyohiTotal(食事提供費合計);
    }

    /**
     * 標準負担額_月額を設定します。
     *
     * @param 標準負担額_月額 標準負担額_月額
     */
    public void set標準負担額_月額(int 標準負担額_月額) {
        requireNonNull(標準負担額_月額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_月額"));
        entity.setGetsugakuHyojunFutangaku(標準負担額_月額);
    }

    /**
     * 食事提供費請求額を設定します。
     *
     * @param 食事提供費請求額 食事提供費請求額
     */
    public void set食事提供費請求額(int 食事提供費請求額) {
        requireNonNull(食事提供費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("食事提供費請求額"));
        entity.setShokujiTeikyohiSeikyugaku(食事提供費請求額);
    }

    /**
     * 標準負担額_日額を設定します。
     *
     * @param 標準負担額_日額 標準負担額_日額
     */
    public void set標準負担額_日額(int 標準負担額_日額) {
        requireNonNull(標準負担額_日額, UrSystemErrorMessages.値がnull.getReplacedMessage("標準負担額_日額"));
        entity.setNichigakuHyojunFutangaku(標準負担額_日額);
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
