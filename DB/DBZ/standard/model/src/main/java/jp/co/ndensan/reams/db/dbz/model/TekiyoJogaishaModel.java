/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoJogaiTekiyoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.valueobject.code.KaigoJogaiKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 適用除外者のモデルクラスです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaishaModel implements Serializable {

    private DbT1002TekiyoJogaishaEntity entity;

    /**
     * コンストラクタです。
     */
    public TekiyoJogaishaModel() {
        entity = new DbT1002TekiyoJogaishaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1002TekiyoJogaishaEntity
     */
    public TekiyoJogaishaModel(DbT1002TekiyoJogaishaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1002TekiyoJogaishaEntityを返します。
     *
     * @return DbT1002TekiyoJogaishaEntity
     */
    public DbT1002TekiyoJogaishaEntity getEntity() {
        return entity;
    }

    /**
     * DbT1002TekiyoJogaishaEntityを設定します。
     *
     * @param entity DbT1002TekiyoJogaishaEntity
     */
    public void setEntity(DbT1002TekiyoJogaishaEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
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
     * 適用除外適用事由コードを返します。
     *
     * @return 適用除外適用事由コード
     */
    public KaigoJogaiTekiyoJiyu get適用除外適用事由コード() {
        return entity.getTekiyoJogaiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getTekiyoTodokedeYMD();
    }

    /**
     * 適用受付年月日を返します。
     *
     * @return 適用受付年月日
     */
    public FlexibleDate get適用受付年月日() {
        return entity.getTekiyoUketsukeYMD();
    }

    /**
     * 適用除外解除事由コードを返します。
     *
     * @return 適用除外解除事由コード
     */
    public KaigoJogaiKaijoJiyu get適用除外解除事由コード() {
        return entity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getKaijoTodokedeYMD();
    }

    /**
     * 解除受付年月日を返します。
     *
     * @return 解除受付年月日
     */
    public FlexibleDate get解除受付年月日() {
        return entity.getKaijoUketsukeYMD();
    }

    /**
     * 入所通知発行日を返します。
     *
     * @return 入所通知発行日
     */
    public FlexibleDate get入所通知発行日() {
        return entity.getNyushoTsuchiHakkoYMD();
    }

    /**
     * 退所通知発行日を返します。
     *
     * @return 退所通知発行日
     */
    public FlexibleDate get退所通知発行日() {
        return entity.getTaishoTsuchiHakkoYMD();
    }

    /**
     * 変更通知発行日を返します。
     *
     * @return 変更通知発行日
     */
    public FlexibleDate get変更通知発行日() {
        return entity.getHenkoTsuchiHakkoYMD();
    }

    /**
     * 市町村コードを設定します。
     *
     * @param 市町村コード 市町村コード
     */
    public void set市町村コード(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        entity.setShichosonCode(市町村コード);
    }

    /**
     * 識別コードを設定します。
     *
     * @param 識別コード 識別コード
     */
    public void set識別コード(ShikibetsuCode 識別コード) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        entity.setShikibetsuCode(識別コード);
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
     * 適用除外適用事由コードを設定します。
     *
     * @param 適用除外適用事由コード 適用除外適用事由コード
     */
    public void set適用除外適用事由コード(KaigoJogaiTekiyoJiyu 適用除外適用事由コード) {
        requireNonNull(適用除外適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外適用事由コード"));
        entity.setTekiyoJogaiTekiyoJiyuCode(適用除外適用事由コード);
    }

    /**
     * 適用年月日を設定します。
     *
     * @param 適用年月日 適用年月日
     */
    public void set適用年月日(FlexibleDate 適用年月日) {
        requireNonNull(適用年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用年月日"));
        entity.setTekiyoYMD(適用年月日);
    }

    /**
     * 適用届出年月日を設定します。
     *
     * @param 適用届出年月日 適用届出年月日
     */
    public void set適用届出年月日(FlexibleDate 適用届出年月日) {
        requireNonNull(適用届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用届出年月日"));
        entity.setTekiyoTodokedeYMD(適用届出年月日);
    }

    /**
     * 適用受付年月日を設定します。
     *
     * @param 適用受付年月日 適用受付年月日
     */
    public void set適用受付年月日(FlexibleDate 適用受付年月日) {
        requireNonNull(適用受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用受付年月日"));
        entity.setTekiyoUketsukeYMD(適用受付年月日);
    }

    /**
     * 適用除外解除事由コードを設定します。
     *
     * @param 適用除外解除事由コード 適用除外解除事由コード
     */
    public void set適用除外解除事由コード(KaigoJogaiKaijoJiyu 適用除外解除事由コード) {
        requireNonNull(適用除外解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外解除事由コード"));
        entity.setTekiyoJogaikaijokaijoJiyuCode(適用除外解除事由コード);
    }

    /**
     * 解除年月日を設定します。
     *
     * @param 解除年月日 解除年月日
     */
    public void set解除年月日(FlexibleDate 解除年月日) {
        requireNonNull(解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除年月日"));
        entity.setKaijoYMD(解除年月日);
    }

    /**
     * 解除届出年月日を設定します。
     *
     * @param 解除届出年月日 解除届出年月日
     */
    public void set解除届出年月日(FlexibleDate 解除届出年月日) {
        requireNonNull(解除届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除届出年月日"));
        entity.setKaijoTodokedeYMD(解除届出年月日);
    }

    /**
     * 解除受付年月日を設定します。
     *
     * @param 解除受付年月日 解除受付年月日
     */
    public void set解除受付年月日(FlexibleDate 解除受付年月日) {
        requireNonNull(解除受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("解除受付年月日"));
        entity.setKaijoUketsukeYMD(解除受付年月日);
    }

    /**
     * 入所通知発行日を設定します。
     *
     * @param 入所通知発行日 入所通知発行日
     */
    public void set入所通知発行日(FlexibleDate 入所通知発行日) {
        requireNonNull(入所通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所通知発行日"));
        entity.setNyushoTsuchiHakkoYMD(入所通知発行日);
    }

    /**
     * 退所通知発行日を設定します。
     *
     * @param 退所通知発行日 退所通知発行日
     */
    public void set退所通知発行日(FlexibleDate 退所通知発行日) {
        requireNonNull(退所通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所通知発行日"));
        entity.setTaishoTsuchiHakkoYMD(退所通知発行日);
    }

    /**
     * 変更通知発行日を設定します。
     *
     * @param 変更通知発行日 変更通知発行日
     */
    public void set変更通知発行日(FlexibleDate 変更通知発行日) {
        requireNonNull(変更通知発行日, UrSystemErrorMessages.値がnull.getReplacedMessage("変更通知発行日"));
        entity.setHenkoTsuchiHakkoYMD(変更通知発行日);
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
