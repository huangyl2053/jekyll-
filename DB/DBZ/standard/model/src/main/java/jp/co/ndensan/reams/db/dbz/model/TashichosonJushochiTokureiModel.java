/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokureiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoTatokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.code.KaigoTatokuKaijoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 他市町村住所地特例のモデルクラスです。
 *
 * @author n8178 城間篤人
 */
public class TashichosonJushochiTokureiModel implements Serializable {

    private DbT1003TashichosonJushochiTokureiEntity entity;

    /**
     * コンストラクタです。
     */
    public TashichosonJushochiTokureiModel() {
        entity = new DbT1003TashichosonJushochiTokureiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1003TashichosonJushochiTokureiEntity
     */
    public TashichosonJushochiTokureiModel(DbT1003TashichosonJushochiTokureiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1003TashichosonJushochiTokureiEntityを返します。
     *
     * @return DbT1003TashichosonJushochiTokureiEntity
     */
    public DbT1003TashichosonJushochiTokureiEntity getEntity() {
        return entity;
    }

    /**
     * DbT1003TashichosonJushochiTokureiEntityを設定します。
     *
     * @param entity DbT1003TashichosonJushochiTokureiEntity
     */
    public void setEntity(DbT1003TashichosonJushochiTokureiEntity entity) {
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
     * 他市町村住所地特例適用事由コードを返します。
     *
     * @return 他市町村住所地特例適用事由コード
     */
    public KaigoTatokuTekiyoJiyu get他市町村住所地特例適用事由コード() {
        return entity.getTekiyoJiyuCode();
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
     * 他市町村住所地特例解除事由コードを返します。
     *
     * @return 他市町村住所地特例解除事由コード
     */
    public KaigoTatokuKaijoJiyu get他市町村住所地特例解除事由コード() {
        return entity.getKaijoJiyuCode();
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
     * 措置保険者番号を返します。
     *
     * @return 措置保険者番号
     */
    public LasdecCode get措置保険者番号() {
        return entity.getSochiHokenshaNo();
    }

    /**
     * 措置被保険者番号を返します。
     *
     * @return 措置被保険者番号
     */
    public HihokenshaNo get措置被保険者番号() {
        return entity.getSochiHihokenshaNo();
    }

    /**
     * 他特例連絡票発行年月日を返します。
     *
     * @return 他特例連絡票発行年月日
     */
    public FlexibleDate get他特例連絡票発行年月日() {
        return entity.getTatokuRenrakuhyoHakkoYMD();
    }

    /**
     * 施設退所通知発行年月日を返します。
     *
     * @return 施設退所通知発行年月日
     */
    public FlexibleDate get施設退所通知発行年月日() {
        return entity.getShisetsuTaishoTsuchiHakkoYMD();
    }

    /**
     * 施設変更通知発行年月日を返します。
     *
     * @return 施設変更通知発行年月日
     */
    public FlexibleDate get施設変更通知発行年月日() {
        return entity.getShisetsuHenkoTsuchiHakkoYMD();
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
     * 他市町村住所地特例適用事由コードを設定します。
     *
     * @param 他市町村住所地特例適用事由コード 他市町村住所地特例適用事由コード
     */
    public void set他市町村住所地特例適用事由コード(KaigoTatokuTekiyoJiyu 他市町村住所地特例適用事由コード) {
        requireNonNull(他市町村住所地特例適用事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例適用事由コード"));
        entity.setTekiyoJiyuCode(他市町村住所地特例適用事由コード);
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
     * 他市町村住所地特例解除事由コードを設定します。
     *
     * @param 他市町村住所地特例解除事由コード 他市町村住所地特例解除事由コード
     */
    public void set他市町村住所地特例解除事由コード(KaigoTatokuKaijoJiyu 他市町村住所地特例解除事由コード) {
        requireNonNull(他市町村住所地特例解除事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("他市町村住所地特例解除事由コード"));
        entity.setKaijoJiyuCode(他市町村住所地特例解除事由コード);
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
     * 措置保険者番号を設定します。
     *
     * @param 措置保険者番号 措置保険者番号
     */
    public void set措置保険者番号(LasdecCode 措置保険者番号) {
        requireNonNull(措置保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置保険者番号"));
        entity.setSochiHokenshaNo(措置保険者番号);
    }

    /**
     * 措置被保険者番号を設定します。
     *
     * @param 措置被保険者番号 措置被保険者番号
     */
    public void set措置被保険者番号(HihokenshaNo 措置被保険者番号) {
        requireNonNull(措置被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("措置被保険者番号"));
        entity.setSochiHihokenshaNo(措置被保険者番号);
    }

    /**
     * 他特例連絡票発行年月日を設定します。
     *
     * @param 他特例連絡票発行年月日 他特例連絡票発行年月日
     */
    public void set他特例連絡票発行年月日(FlexibleDate 他特例連絡票発行年月日) {
        requireNonNull(他特例連絡票発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("他特例連絡票発行年月日"));
        entity.setTatokuRenrakuhyoHakkoYMD(他特例連絡票発行年月日);
    }

    /**
     * 施設退所通知発行年月日を設定します。
     *
     * @param 施設退所通知発行年月日 施設退所通知発行年月日
     */
    public void set施設退所通知発行年月日(FlexibleDate 施設退所通知発行年月日) {
        requireNonNull(施設退所通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設退所通知発行年月日"));
        entity.setShisetsuTaishoTsuchiHakkoYMD(施設退所通知発行年月日);
    }

    /**
     * 施設変更通知発行年月日を設定します。
     *
     * @param 施設変更通知発行年月日 施設変更通知発行年月日
     */
    public void set施設変更通知発行年月日(FlexibleDate 施設変更通知発行年月日) {
        requireNonNull(施設変更通知発行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("施設変更通知発行年月日"));
        entity.setShisetsuHenkoTsuchiHakkoYMD(施設変更通知発行年月日);
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
