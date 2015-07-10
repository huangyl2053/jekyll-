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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績社会福祉法人軽減額のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyufuJissekiShakaiFukushiHojinKeigengakuModel implements Serializable {

    private DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity;

    /**
     * コンストラクタです。
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuModel() {
        entity = new DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity
     */
    public KyufuJissekiShakaiFukushiHojinKeigengakuModel(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityを返します。
     *
     * @return DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity
     */
    public DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity getEntity() {
        return entity;
    }

    /**
     * DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntityを設定します。
     *
     * @param entity DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity
     */
    public void setEntity(DbT3030KyufuJissekiShakaiFukushiHojinKeigengakuEntity entity) {
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
        return entity.getServiceSyuruiCode();
    }

    /**
     * 受領すべき利用者負担の総額を返します。
     *
     * @return 受領すべき利用者負担の総額
     */
    public int get受領すべき利用者負担の総額() {
        return entity.getRiyoshaFutanTotal();
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
     * 後_受領すべき利用者負担の総額を返します。
     *
     * @return 後_受領すべき利用者負担の総額
     */
    public int get後_受領すべき利用者負担の総額() {
        return entity.getAtoRiyoshaFutanTotal();
    }

    /**
     * 後_軽減額を返します。
     *
     * @return 後_軽減額
     */
    public int get後_軽減額() {
        return entity.getAtoKeigengaku();
    }

    /**
     * 後_軽減後利用者負担額を返します。
     *
     * @return 後_軽減後利用者負担額
     */
    public int get後_軽減後利用者負担額() {
        return entity.getAtoKeigengoRiyoshaFutangaku();
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
        entity.setServiceSyuruiCode(サービス種類コード);
    }

    /**
     * 受領すべき利用者負担の総額を設定します。
     *
     * @param 受領すべき利用者負担の総額 受領すべき利用者負担の総額
     */
    public void set受領すべき利用者負担の総額(int 受領すべき利用者負担の総額) {
        requireNonNull(受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("受領すべき利用者負担の総額"));
        entity.setRiyoshaFutanTotal(受領すべき利用者負担の総額);
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
     * 後_受領すべき利用者負担の総額を設定します。
     *
     * @param 後_受領すべき利用者負担の総額 後_受領すべき利用者負担の総額
     */
    public void set後_受領すべき利用者負担の総額(int 後_受領すべき利用者負担の総額) {
        requireNonNull(後_受領すべき利用者負担の総額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_受領すべき利用者負担の総額"));
        entity.setAtoRiyoshaFutanTotal(後_受領すべき利用者負担の総額);
    }

    /**
     * 後_軽減額を設定します。
     *
     * @param 後_軽減額 後_軽減額
     */
    public void set後_軽減額(int 後_軽減額) {
        requireNonNull(後_軽減額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_軽減額"));
        entity.setAtoKeigengaku(後_軽減額);
    }

    /**
     * 後_軽減後利用者負担額を設定します。
     *
     * @param 後_軽減後利用者負担額 後_軽減後利用者負担額
     */
    public void set後_軽減後利用者負担額(int 後_軽減後利用者負担額) {
        requireNonNull(後_軽減後利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("後_軽減後利用者負担額"));
        entity.setAtoKeigengoRiyoshaFutangaku(後_軽減後利用者負担額);
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
