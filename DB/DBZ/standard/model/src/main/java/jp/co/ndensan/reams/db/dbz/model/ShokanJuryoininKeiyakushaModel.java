/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還受領委任契約者のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class ShokanJuryoininKeiyakushaModel implements Serializable {

    private DbT3078ShokanJuryoininKeiyakushaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShokanJuryoininKeiyakushaModel() {
        entity = new DbT3078ShokanJuryoininKeiyakushaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3078ShokanJuryoininKeiyakushaEntity
     */
    public ShokanJuryoininKeiyakushaModel(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3078ShokanJuryoininKeiyakushaEntityを返します。
     *
     * @return DbT3078ShokanJuryoininKeiyakushaEntity
     */
    public DbT3078ShokanJuryoininKeiyakushaEntity getEntity() {
        return entity;
    }

    /**
     * DbT3078ShokanJuryoininKeiyakushaEntityを設定します。
     *
     * @param entity DbT3078ShokanJuryoininKeiyakushaEntity
     */
    public void setEntity(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
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
     * 事業者契約番号を返します。
     *
     * @return 事業者契約番号
     */
    public RString get事業者契約番号() {
        return entity.getJigyoshaKeiyakuNo();
    }

    /**
     * 契約サービス種類を返します。
     *
     * @return 契約サービス種類
     */
    public RString get契約サービス種類() {
        return entity.getKeiyakuServiceShurui();
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
     * 費用額合計を返します。
     *
     * @return 費用額合計
     */
    public Decimal get費用額合計() {
        return entity.getHiyoGakuGokei();
    }

    /**
     * 保険対象費用額を返します。
     *
     * @return 保険対象費用額
     */
    public Decimal get保険対象費用額() {
        return entity.getHokenTaishoHiyoGaku();
    }

    /**
     * 利用者自己負担額を返します。
     *
     * @return 利用者自己負担額
     */
    public Decimal get利用者自己負担額() {
        return entity.getRiyoshaJikoFutanGaku();
    }

    /**
     * 保険給付費額を返します。
     *
     * @return 保険給付費額
     */
    public Decimal get保険給付費額() {
        return entity.getHokenKyufuhiGaku();
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
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(ShoKisaiHokenshaNo 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
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
     * 事業者契約番号を設定します。
     *
     * @param 事業者契約番号 事業者契約番号
     */
    public void set事業者契約番号(RString 事業者契約番号) {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        entity.setJigyoshaKeiyakuNo(事業者契約番号);
    }

    /**
     * 契約サービス種類を設定します。
     *
     * @param 契約サービス種類 契約サービス種類
     */
    public void set契約サービス種類(RString 契約サービス種類) {
        requireNonNull(契約サービス種類, UrSystemErrorMessages.値がnull.getReplacedMessage("契約サービス種類"));
        entity.setKeiyakuServiceShurui(契約サービス種類);
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
     * 費用額合計を設定します。
     *
     * @param 費用額合計 費用額合計
     */
    public void set費用額合計(Decimal 費用額合計) {
        requireNonNull(費用額合計, UrSystemErrorMessages.値がnull.getReplacedMessage("費用額合計"));
        entity.setHiyoGakuGokei(費用額合計);
    }

    /**
     * 保険対象費用額を設定します。
     *
     * @param 保険対象費用額 保険対象費用額
     */
    public void set保険対象費用額(Decimal 保険対象費用額) {
        requireNonNull(保険対象費用額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険対象費用額"));
        entity.setHokenTaishoHiyoGaku(保険対象費用額);
    }

    /**
     * 利用者自己負担額を設定します。
     *
     * @param 利用者自己負担額 利用者自己負担額
     */
    public void set利用者自己負担額(Decimal 利用者自己負担額) {
        requireNonNull(利用者自己負担額, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者自己負担額"));
        entity.setRiyoshaJikoFutanGaku(利用者自己負担額);
    }

    /**
     * 保険給付費額を設定します。
     *
     * @param 保険給付費額 保険給付費額
     */
    public void set保険給付費額(Decimal 保険給付費額) {
        requireNonNull(保険給付費額, UrSystemErrorMessages.値がnull.getReplacedMessage("保険給付費額"));
        entity.setHokenKyufuhiGaku(保険給付費額);
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
