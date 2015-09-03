/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額受領委任契約事業者のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuJuryoininKeiyakuJigyoshaModel implements Serializable {

    private DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuJuryoininKeiyakuJigyoshaModel() {
        entity = new DbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3076KogakuJuryoininKeiyakuJigyoshaEntity
     */
    public KogakuJuryoininKeiyakuJigyoshaModel(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3076KogakuJuryoininKeiyakuJigyoshaEntityを返します。
     *
     * @return DbT3076KogakuJuryoininKeiyakuJigyoshaEntity
     */
    public DbT3076KogakuJuryoininKeiyakuJigyoshaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3076KogakuJuryoininKeiyakuJigyoshaEntityを設定します。
     *
     * @param entity DbT3076KogakuJuryoininKeiyakuJigyoshaEntity
     */
    public void setEntity(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
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
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 承認結果区分を返します。
     *
     * @return 承認結果区分
     */
    public RString get承認結果区分() {
        return entity.getShoninKekkaKubun();
    }

    /**
     * 受領委任払適用開始年月日を返します。
     *
     * @return 受領委任払適用開始年月日
     */
    public FlexibleDate get受領委任払適用開始年月日() {
        return entity.getJuryoininKaishiYMD();
    }

    /**
     * 受領委任払適用終了年月日を返します。
     *
     * @return 受領委任払適用終了年月日
     */
    public FlexibleDate get受領委任払適用終了年月日() {
        return entity.getJuryoininShuryoYMD();
    }

    /**
     * 契約番号を返します。
     *
     * @return 契約番号
     */
    public RString get契約番号() {
        return entity.getKeiyakuNo();
    }

    /**
     * 不承認理由を返します。
     *
     * @return 不承認理由
     */
    public RString get不承認理由() {
        return entity.getFuShoninRiyu();
    }

    /**
     * 利用者負担上限額を返します。
     *
     * @return 利用者負担上限額
     */
    public Decimal get利用者負担上限額() {
        return entity.getRiyoshaFutanJogenGaku();
    }

    /**
     * 承認結果通知書作成日を返します。
     *
     * @return 承認結果通知書作成日
     */
    public FlexibleDate get承認結果通知書作成日() {
        return entity.getShoninKekkaTsuchiSakuseiYMD();
    }

    /**
     * 承認結果通知書再発行区分を返します。
     *
     * @return 承認結果通知書再発行区分
     */
    public RString get承認結果通知書再発行区分() {
        return entity.getShoninKekkaTsuchiSaiHakkoKubun();
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
     * 受付年月日を設定します。
     *
     * @param 受付年月日 受付年月日
     */
    public void set受付年月日(FlexibleDate 受付年月日) {
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        entity.setUketsukeYMD(受付年月日);
    }

    /**
     * 申請年月日を設定します。
     *
     * @param 申請年月日 申請年月日
     */
    public void set申請年月日(FlexibleDate 申請年月日) {
        requireNonNull(申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請年月日"));
        entity.setShinseiYMD(申請年月日);
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
     * 決定年月日を設定します。
     *
     * @param 決定年月日 決定年月日
     */
    public void set決定年月日(FlexibleDate 決定年月日) {
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        entity.setKetteiYMD(決定年月日);
    }

    /**
     * 承認結果区分を設定します。
     *
     * @param 承認結果区分 承認結果区分
     */
    public void set承認結果区分(RString 承認結果区分) {
        requireNonNull(承認結果区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果区分"));
        entity.setShoninKekkaKubun(承認結果区分);
    }

    /**
     * 受領委任払適用開始年月日を設定します。
     *
     * @param 受領委任払適用開始年月日 受領委任払適用開始年月日
     */
    public void set受領委任払適用開始年月日(FlexibleDate 受領委任払適用開始年月日) {
        requireNonNull(受領委任払適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任払適用開始年月日"));
        entity.setJuryoininKaishiYMD(受領委任払適用開始年月日);
    }

    /**
     * 受領委任払適用終了年月日を設定します。
     *
     * @param 受領委任払適用終了年月日 受領委任払適用終了年月日
     */
    public void set受領委任払適用終了年月日(FlexibleDate 受領委任払適用終了年月日) {
        requireNonNull(受領委任払適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任払適用終了年月日"));
        entity.setJuryoininShuryoYMD(受領委任払適用終了年月日);
    }

    /**
     * 契約番号を設定します。
     *
     * @param 契約番号 契約番号
     */
    public void set契約番号(RString 契約番号) {
        requireNonNull(契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("契約番号"));
        entity.setKeiyakuNo(契約番号);
    }

    /**
     * 不承認理由を設定します。
     *
     * @param 不承認理由 不承認理由
     */
    public void set不承認理由(RString 不承認理由) {
        requireNonNull(不承認理由, UrSystemErrorMessages.値がnull.getReplacedMessage("不承認理由"));
        entity.setFuShoninRiyu(不承認理由);
    }

    /**
     * 利用者負担上限額を設定します。
     *
     * @param 利用者負担上限額 利用者負担上限額
     */
    public void set利用者負担上限額(Decimal 利用者負担上限額) {
        requireNonNull(利用者負担上限額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担上限額"));
        entity.setRiyoshaFutanJogenGaku(利用者負担上限額);
    }

    /**
     * 承認結果通知書作成日を設定します。
     *
     * @param 承認結果通知書作成日 承認結果通知書作成日
     */
    public void set承認結果通知書作成日(FlexibleDate 承認結果通知書作成日) {
        requireNonNull(承認結果通知書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果通知書作成日"));
        entity.setShoninKekkaTsuchiSakuseiYMD(承認結果通知書作成日);
    }

    /**
     * 承認結果通知書再発行区分を設定します。
     *
     * @param 承認結果通知書再発行区分 承認結果通知書再発行区分
     */
    public void set承認結果通知書再発行区分(RString 承認結果通知書再発行区分) {
        requireNonNull(承認結果通知書再発行区分, UrSystemErrorMessages.値がnull.getReplacedMessage("承認結果通知書再発行区分"));
        entity.setShoninKekkaTsuchiSaiHakkoKubun(承認結果通知書再発行区分);
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
