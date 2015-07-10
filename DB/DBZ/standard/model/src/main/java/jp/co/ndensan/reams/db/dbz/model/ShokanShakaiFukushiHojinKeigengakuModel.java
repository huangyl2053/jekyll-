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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3051ShokanShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求社会福祉法人軽減額のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanShakaiFukushiHojinKeigengakuModel implements Serializable {

    private DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanShakaiFukushiHojinKeigengakuModel() {
        entity = new DbT3051ShokanShakaiFukushiHojinKeigengakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3051ShokanShakaiFukushiHojinKeigengakuEntity
     */
    public ShokanShakaiFukushiHojinKeigengakuModel(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3051ShokanShakaiFukushiHojinKeigengakuEntityを返します。
     *
     * @return DbT3051ShokanShakaiFukushiHojinKeigengakuEntity
     */
    public DbT3051ShokanShakaiFukushiHojinKeigengakuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3051ShokanShakaiFukushiHojinKeigengakuEntityを設定します。
     *
     * @param entity DbT3051ShokanShakaiFukushiHojinKeigengakuEntity
     */
    public void setEntity(DbT3051ShokanShakaiFukushiHojinKeigengakuEntity entity) {
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
     * 軽減率を返します。
     *
     * @return 軽減率
     */
    public Decimal get軽減率() {
        return entity.getKeigenritsu();
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
     * 受領すべき利用者負担の総額を返します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public int get受領すべき利用者負担の総額() {
        return entity.getRiyoshaFutangakuTotal();
    }

    /**
     * 軽減額を返します。
     *
     * @return 軽減額
     */
    public int get軽減額() {
        return entity.getKeigengaku();
    }

    /**
     * 軽減後利用者負担額を返します。
     *
     * @return 軽減後利用者負担額
     */
    public int get軽減後利用者負担額() {
        return entity.getKeigengoRiyoshaFutangaku();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
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
     * 軽減率を設定します。
     *
     * @param 軽減率 軽減率
     */
    public void set軽減率(Decimal 軽減率) {
        requireNonNull(軽減率, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減率"));
        entity.setKeigenritsu(軽減率);
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
     * 受領すべき利用者負担の総額を設定します。
     *
     * @param 受領すべき利用者負担の総額 受領すべき利用者負担の総額
     */
    public void set受領すべき利用者負担の総額(int 受領すべき利用者負担の総額) {
        requireNonNull(受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("受領すべき利用者負担の総額"));
        entity.setRiyoshaFutangakuTotal(受領すべき利用者負担の総額);
    }

    /**
     * 軽減額を設定します。
     *
     * @param 軽減額 軽減額
     */
    public void set軽減額(int 軽減額) {
        requireNonNull(軽減額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減額"));
        entity.setKeigengaku(軽減額);
    }

    /**
     * 軽減後利用者負担額を設定します。
     *
     * @param 軽減後利用者負担額 軽減後利用者負担額
     */
    public void set軽減後利用者負担額(int 軽減後利用者負担額) {
        requireNonNull(軽減後利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("軽減後利用者負担額"));
        entity.setKeigengoRiyoshaFutangaku(軽減後利用者負担額);
    }

    /**
     * 備考を設定します。
     *
     * @param 備考 備考
     */
    public void set備考(RString 備考) {
        requireNonNull(備考, UrSystemErrorMessages.値がnull.getReplacedMessage("備考"));
        entity.setBiko(備考);
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
