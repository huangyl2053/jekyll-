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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求集計のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanShukeiModel implements Serializable {

    private DbT3053ShokanShukeiEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanShukeiModel() {
        entity = new DbT3053ShokanShukeiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3053ShokanShukeiEntity
     */
    public ShokanShukeiModel(DbT3053ShokanShukeiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3053ShokanShukeiEntityを返します。
     *
     * @return DbT3053ShokanShukeiEntity
     */
    public DbT3053ShokanShukeiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3053ShokanShukeiEntityを設定します。
     *
     * @param entity DbT3053ShokanShukeiEntity
     */
    public void setEntity(DbT3053ShokanShukeiEntity entity) {
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
        return entity.getSeiriNo();
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
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス実日数を返します。
     *
     * @return サービス実日数
     */
    public int getサービス実日数() {
        return entity.getServiceJitsunissu();
    }

    /**
     * 計画単位数を返します。
     *
     * @return 計画単位数
     */
    public int get計画単位数() {
        return entity.getPlanTanisu();
    }

    /**
     * 限度額管理対象単位数を返します。
     *
     * @return 限度額管理対象単位数
     */
    public int get限度額管理対象単位数() {
        return entity.getGendogakuKanriTaishoTanisu();
    }

    /**
     * 限度額管理対象外単位数を返します。
     *
     * @return 限度額管理対象外単位数
     */
    public int get限度額管理対象外単位数() {
        return entity.getGendogakuKanriTaishogaiTanisu();
    }

    /**
     * 短期入所計画日数を返します。
     *
     * @return 短期入所計画日数
     */
    public int get短期入所計画日数() {
        return entity.getTankiNyushoPlanNissu();
    }

    /**
     * 短期入所実日数を返します。
     *
     * @return 短期入所実日数
     */
    public int get短期入所実日数() {
        return entity.getTankiNyushoJitsunissu();
    }

    /**
     * 単位数合計を返します。
     *
     * @return 単位数合計
     */
    public int get単位数合計() {
        return entity.getTanisuTotal();
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
     * 請求額を返します。
     *
     * @return 請求額
     */
    public Decimal get請求額() {
        return entity.getSeikyugaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 出来高医療費単位数合計を返します。
     *
     * @return 出来高医療費単位数合計
     */
    public int get出来高医療費単位数合計() {
        return entity.getDekidakaIryohiTanisuTotal();
    }

    /**
     * 出来高医療費請求額を返します。
     *
     * @return 出来高医療費請求額
     */
    public Decimal get出来高医療費請求額() {
        return entity.getDekidakaIryohiSeikyugaku();
    }

    /**
     * 出来高医療費利用者負担額を返します。
     *
     * @return 出来高医療費利用者負担額
     */
    public Decimal get出来高医療費利用者負担額() {
        return entity.getDekidakaIryohiRiyoshaFutangaku();
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
     * 支払金額を返します。
     *
     * @return 支払金額
     */
    public int get支払金額() {
        return entity.getShikyuKingaku();
    }

    /**
     * 増減点を返します。
     *
     * @return 増減点
     */
    public int get増減点() {
        return entity.getZougenten();
    }

    /**
     * 請求額差額金額を返します。
     *
     * @return 請求額差額金額
     */
    public int get請求額差額金額() {
        return entity.getSeikyugakuSagakuKingaku();
    }

    /**
     * 出来高請求額差額金額を返します。
     *
     * @return 出来高請求額差額金額
     */
    public int get出来高請求額差額金額() {
        return entity.getDekidakaSeikyugakuSagaku();
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
        return entity.getHushikyuRiyu();
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
        entity.setSeiriNo(整理番号);
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
     * 順次番号を設定します。
     *
     * @param 順次番号 順次番号
     */
    public void set順次番号(RString 順次番号) {
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        entity.setJunjiNo(順次番号);
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
     * サービス種類コードを設定します。
     *
     * @param サービス種類コード サービス種類コード
     */
    public void setサービス種類コード(ServiceShuruiCode サービス種類コード) {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        entity.setServiceShuruiCode(サービス種類コード);
    }

    /**
     * サービス実日数を設定します。
     *
     * @param サービス実日数 サービス実日数
     */
    public void setサービス実日数(int サービス実日数) {
        requireNonNull(サービス実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス実日数"));
        entity.setServiceJitsunissu(サービス実日数);
    }

    /**
     * 計画単位数を設定します。
     *
     * @param 計画単位数 計画単位数
     */
    public void set計画単位数(int 計画単位数) {
        requireNonNull(計画単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("計画単位数"));
        entity.setPlanTanisu(計画単位数);
    }

    /**
     * 限度額管理対象単位数を設定します。
     *
     * @param 限度額管理対象単位数 限度額管理対象単位数
     */
    public void set限度額管理対象単位数(int 限度額管理対象単位数) {
        requireNonNull(限度額管理対象単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象単位数"));
        entity.setGendogakuKanriTaishoTanisu(限度額管理対象単位数);
    }

    /**
     * 限度額管理対象外単位数を設定します。
     *
     * @param 限度額管理対象外単位数 限度額管理対象外単位数
     */
    public void set限度額管理対象外単位数(int 限度額管理対象外単位数) {
        requireNonNull(限度額管理対象外単位数, UrSystemErrorMessages.値がnull.getReplacedMessage("限度額管理対象外単位数"));
        entity.setGendogakuKanriTaishogaiTanisu(限度額管理対象外単位数);
    }

    /**
     * 短期入所計画日数を設定します。
     *
     * @param 短期入所計画日数 短期入所計画日数
     */
    public void set短期入所計画日数(int 短期入所計画日数) {
        requireNonNull(短期入所計画日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所計画日数"));
        entity.setTankiNyushoPlanNissu(短期入所計画日数);
    }

    /**
     * 短期入所実日数を設定します。
     *
     * @param 短期入所実日数 短期入所実日数
     */
    public void set短期入所実日数(int 短期入所実日数) {
        requireNonNull(短期入所実日数, UrSystemErrorMessages.値がnull.getReplacedMessage("短期入所実日数"));
        entity.setTankiNyushoJitsunissu(短期入所実日数);
    }

    /**
     * 単位数合計を設定します。
     *
     * @param 単位数合計 単位数合計
     */
    public void set単位数合計(int 単位数合計) {
        requireNonNull(単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数合計"));
        entity.setTanisuTotal(単位数合計);
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
     * 請求額を設定します。
     *
     * @param 請求額 請求額
     */
    public void set請求額(Decimal 請求額) {
        requireNonNull(請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求額"));
        entity.setSeikyugaku(請求額);
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(int 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutangaku(利用者負担額);
    }

    /**
     * 出来高医療費単位数合計を設定します。
     *
     * @param 出来高医療費単位数合計 出来高医療費単位数合計
     */
    public void set出来高医療費単位数合計(int 出来高医療費単位数合計) {
        requireNonNull(出来高医療費単位数合計, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高医療費単位数合計"));
        entity.setDekidakaIryohiTanisuTotal(出来高医療費単位数合計);
    }

    /**
     * 出来高医療費請求額を設定します。
     *
     * @param 出来高医療費請求額 出来高医療費請求額
     */
    public void set出来高医療費請求額(Decimal 出来高医療費請求額) {
        requireNonNull(出来高医療費請求額, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高医療費請求額"));
        entity.setDekidakaIryohiSeikyugaku(出来高医療費請求額);
    }

    /**
     * 出来高医療費利用者負担額を設定します。
     *
     * @param 出来高医療費利用者負担額 出来高医療費利用者負担額
     */
    public void set出来高医療費利用者負担額(Decimal 出来高医療費利用者負担額) {
        requireNonNull(出来高医療費利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高医療費利用者負担額"));
        entity.setDekidakaIryohiRiyoshaFutangaku(出来高医療費利用者負担額);
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
     * 支払金額を設定します。
     *
     * @param 支払金額 支払金額
     */
    public void set支払金額(int 支払金額) {
        requireNonNull(支払金額, UrSystemErrorMessages.値がnull.getReplacedMessage("支払金額"));
        entity.setShikyuKingaku(支払金額);
    }

    /**
     * 増減点を設定します。
     *
     * @param 増減点 増減点
     */
    public void set増減点(int 増減点) {
        requireNonNull(増減点, UrSystemErrorMessages.値がnull.getReplacedMessage("増減点"));
        entity.setZougenten(増減点);
    }

    /**
     * 請求額差額金額を設定します。
     *
     * @param 請求額差額金額 請求額差額金額
     */
    public void set請求額差額金額(int 請求額差額金額) {
        requireNonNull(請求額差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("請求額差額金額"));
        entity.setSeikyugakuSagakuKingaku(請求額差額金額);
    }

    /**
     * 出来高請求額差額金額を設定します。
     *
     * @param 出来高請求額差額金額 出来高請求額差額金額
     */
    public void set出来高請求額差額金額(int 出来高請求額差額金額) {
        requireNonNull(出来高請求額差額金額, UrSystemErrorMessages.値がnull.getReplacedMessage("出来高請求額差額金額"));
        entity.setDekidakaSeikyugakuSagaku(出来高請求額差額金額);
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
        entity.setHushikyuRiyu(不支給理由等);
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
