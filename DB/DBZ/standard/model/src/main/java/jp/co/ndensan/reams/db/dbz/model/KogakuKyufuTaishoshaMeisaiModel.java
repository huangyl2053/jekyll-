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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費給付対象者明細のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuKyufuTaishoshaMeisaiModel implements Serializable {

    private DbT3054KogakuKyufuTaishoshaMeisaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaMeisaiModel() {
        entity = new DbT3054KogakuKyufuTaishoshaMeisaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3054KogakuKyufuTaishoshaMeisaiEntity
     */
    public KogakuKyufuTaishoshaMeisaiModel(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3054KogakuKyufuTaishoshaMeisaiEntityを返します。
     *
     * @return DbT3054KogakuKyufuTaishoshaMeisaiEntity
     */
    public DbT3054KogakuKyufuTaishoshaMeisaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3054KogakuKyufuTaishoshaMeisaiEntityを設定します。
     *
     * @param entity DbT3054KogakuKyufuTaishoshaMeisaiEntity
     */
    public void setEntity(DbT3054KogakuKyufuTaishoshaMeisaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
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
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
    }

    /**
     * サービス費用合計額を返します。
     *
     * @return サービス費用合計額
     */
    public Decimal getサービス費用合計額() {
        return entity.getServiceHiyoGokeiGaku();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 高額給付根拠を返します。
     *
     * @return 高額給付根拠
     */
    public RString get高額給付根拠() {
        return entity.getKogakuKyufuKonkyo();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
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
     * 事業者番号を設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set事業者番号(JigyoshaNo 事業者番号) {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        entity.setJigyoshaNo(事業者番号);
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
    }

    /**
     * サービス費用合計額を設定します。
     *
     * @param サービス費用合計額 サービス費用合計額
     */
    public void setサービス費用合計額(Decimal サービス費用合計額) {
        requireNonNull(サービス費用合計額, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス費用合計額"));
        entity.setServiceHiyoGokeiGaku(サービス費用合計額);
    }

    /**
     * 利用者負担額を設定します。
     *
     * @param 利用者負担額 利用者負担額
     */
    public void set利用者負担額(Decimal 利用者負担額) {
        requireNonNull(利用者負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額"));
        entity.setRiyoshaFutanGaku(利用者負担額);
    }

    /**
     * 高額給付根拠を設定します。
     *
     * @param 高額給付根拠 高額給付根拠
     */
    public void set高額給付根拠(RString 高額給付根拠) {
        requireNonNull(高額給付根拠, UrSystemErrorMessages.値がnull.getReplacedMessage("高額給付根拠"));
        entity.setKogakuKyufuKonkyo(高額給付根拠);
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
