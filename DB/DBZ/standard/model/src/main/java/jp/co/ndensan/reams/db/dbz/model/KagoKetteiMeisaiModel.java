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
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤決定明細のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KagoKetteiMeisaiModel implements Serializable {

    private DbT3061KagoKetteiMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KagoKetteiMeisaiModel() {
        entity = new DbT3061KagoKetteiMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3061KagoKetteiMeisaiEntity
     */
    public KagoKetteiMeisaiModel(DbT3061KagoKetteiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3061KagoKetteiMeisaiEntityを返します。
     *
     * @return DbT3061KagoKetteiMeisaiEntity
     */
    public DbT3061KagoKetteiMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3061KagoKetteiMeisaiEntityを設定します。
     *
     * @param entity DbT3061KagoKetteiMeisaiEntity
     */
    public void setEntity(DbT3061KagoKetteiMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 取扱年月を返します。
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth get取扱年月() {
        return entity.getToriatsukaiYM();
    }

    /**
     * 保険者区分を返します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.getHokenshaKubun();
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 事業所名を返します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return entity.getJigyoshoName();
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
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohiJukyushaNo();
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
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
     * サービス種類名を返します。
     *
     * @return サービス種類名
     */
    public RString getサービス種類名() {
        return entity.getServiceShuruiName();
    }

    /**
     * 過誤申立事由コードを返します。
     *
     * @return 過誤申立事由コード
     */
    public Code get過誤申立事由コード() {
        return entity.getKagomoushitateJiyuCode();
    }

    /**
     * 過誤申立事由を返します。
     *
     * @return 過誤申立事由
     */
    public RString get過誤申立事由() {
        return entity.getKagomoushitateJiyu();
    }

    /**
     * 単位数_特定入所者介護費等を返します。
     *
     * @return 単位数_特定入所者介護費等
     */
    public Decimal get単位数_特定入所者介護費等() {
        return entity.getTanisu();
    }

    /**
     * 保険者負担額を返します。
     *
     * @return 保険者負担額
     */
    public Decimal get保険者負担額() {
        return entity.getHokenshaFutangaku();
    }

    /**
     * 取扱年月を設定します。
     *
     * @param 取扱年月 取扱年月
     */
    public void set取扱年月(FlexibleYearMonth 取扱年月) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        entity.setToriatsukaiYM(取扱年月);
    }

    /**
     * 保険者区分を設定します。
     *
     * @param 保険者区分 保険者区分
     */
    public void set保険者区分(RString 保険者区分) {
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        entity.setHokenshaKubun(保険者区分);
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
     * 事業所番号を設定します。
     *
     * @param 事業所番号 事業所番号
     */
    public void set事業所番号(JigyoshaNo 事業所番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        entity.setJigyoshoNo(事業所番号);
    }

    /**
     * 事業所名を設定します。
     *
     * @param 事業所名 事業所名
     */
    public void set事業所名(RString 事業所名) {
        requireNonNull(事業所名, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所名"));
        entity.setJigyoshoName(事業所名);
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
     * 公費受給者番号を設定します。
     *
     * @param 公費受給者番号 公費受給者番号
     */
    public void set公費受給者番号(RString 公費受給者番号) {
        requireNonNull(公費受給者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("公費受給者番号"));
        entity.setKohiJukyushaNo(公費受給者番号);
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
     * サービス提供年月を設定します。
     *
     * @param サービス提供年月 サービス提供年月
     */
    public void setサービス提供年月(FlexibleYearMonth サービス提供年月) {
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        entity.setServiceTeikyoYM(サービス提供年月);
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
     * サービス種類名を設定します。
     *
     * @param サービス種類名 サービス種類名
     */
    public void setサービス種類名(RString サービス種類名) {
        requireNonNull(サービス種類名, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類名"));
        entity.setServiceShuruiName(サービス種類名);
    }

    /**
     * 過誤申立事由コードを設定します。
     *
     * @param 過誤申立事由コード 過誤申立事由コード
     */
    public void set過誤申立事由コード(Code 過誤申立事由コード) {
        requireNonNull(過誤申立事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立事由コード"));
        entity.setKagomoushitateJiyuCode(過誤申立事由コード);
    }

    /**
     * 過誤申立事由を設定します。
     *
     * @param 過誤申立事由 過誤申立事由
     */
    public void set過誤申立事由(RString 過誤申立事由) {
        requireNonNull(過誤申立事由, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立事由"));
        entity.setKagomoushitateJiyu(過誤申立事由);
    }

    /**
     * 単位数_特定入所者介護費等を設定します。
     *
     * @param 単位数_特定入所者介護費等 単位数_特定入所者介護費等
     */
    public void set単位数_特定入所者介護費等(Decimal 単位数_特定入所者介護費等) {
        requireNonNull(単位数_特定入所者介護費等, UrSystemErrorMessages.値がnull.getReplacedMessage("単位数_特定入所者介護費等"));
        entity.setTanisu(単位数_特定入所者介護費等);
    }

    /**
     * 保険者負担額を設定します。
     *
     * @param 保険者負担額 保険者負担額
     */
    public void set保険者負担額(Decimal 保険者負担額) {
        requireNonNull(保険者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者負担額"));
        entity.setHokenshaFutangaku(保険者負担額);
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
