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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyotakuKeikakuJikoSakuseiModel implements Serializable {

    private DbT3007KyotakuKeikakuJikoSakuseiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJikoSakuseiModel() {
        entity = new DbT3007KyotakuKeikakuJikoSakuseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3007KyotakuKeikakuJikoSakuseiEntity
     */
    public KyotakuKeikakuJikoSakuseiModel(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3007KyotakuKeikakuJikoSakuseiEntityを返します。
     *
     * @return DbT3007KyotakuKeikakuJikoSakuseiEntity
     */
    public DbT3007KyotakuKeikakuJikoSakuseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3007KyotakuKeikakuJikoSakuseiEntityを設定します。
     *
     * @param entity DbT3007KyotakuKeikakuJikoSakuseiEntity
     */
    public void setEntity(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
    }

    /**
     * 居宅_総合事業区分を返します。
     *
     * @return 居宅_総合事業区分
     */
    public RString get居宅_総合事業区分() {
        return entity.getKyotaku_SogoJigyoKubun();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 計画作成年月日を返します。
     *
     * @return 計画作成年月日
     */
    public FlexibleDate get計画作成年月日() {
        return entity.getKeikakuSakuseiYMD();
    }

    /**
     * 計画変更年月日を返します。
     *
     * @return 計画変更年月日
     */
    public FlexibleDate get計画変更年月日() {
        return entity.getKeikakuHenkoYMD();
    }

    /**
     * 計画変更事由を返します。
     *
     * @return 計画変更事由
     */
    public RString get計画変更事由() {
        return entity.getKeikakuHenkoJiyu();
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
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     */
    public void set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
    }

    /**
     * 居宅_総合事業区分を設定します。
     *
     * @param 居宅_総合事業区分 居宅_総合事業区分
     */
    public void set居宅_総合事業区分(RString 居宅_総合事業区分) {
        requireNonNull(居宅_総合事業区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅_総合事業区分"));
        entity.setKyotaku_SogoJigyoKubun(居宅_総合事業区分);
    }

    /**
     * 適用開始年月日を設定します。
     *
     * @param 適用開始年月日 適用開始年月日
     */
    public void set適用開始年月日(FlexibleDate 適用開始年月日) {
        requireNonNull(適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月日"));
        entity.setTekiyoKaishiYMD(適用開始年月日);
    }

    /**
     * 適用終了年月日を設定します。
     *
     * @param 適用終了年月日 適用終了年月日
     */
    public void set適用終了年月日(FlexibleDate 適用終了年月日) {
        requireNonNull(適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月日"));
        entity.setTekiyoShuryoYMD(適用終了年月日);
    }

    /**
     * 計画作成年月日を設定します。
     *
     * @param 計画作成年月日 計画作成年月日
     */
    public void set計画作成年月日(FlexibleDate 計画作成年月日) {
        requireNonNull(計画作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("計画作成年月日"));
        entity.setKeikakuSakuseiYMD(計画作成年月日);
    }

    /**
     * 計画変更年月日を設定します。
     *
     * @param 計画変更年月日 計画変更年月日
     */
    public void set計画変更年月日(FlexibleDate 計画変更年月日) {
        requireNonNull(計画変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("計画変更年月日"));
        entity.setKeikakuHenkoYMD(計画変更年月日);
    }

    /**
     * 計画変更事由を設定します。
     *
     * @param 計画変更事由 計画変更事由
     */
    public void set計画変更事由(RString 計画変更事由) {
        requireNonNull(計画変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("計画変更事由"));
        entity.setKeikakuHenkoJiyu(計画変更事由);
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
