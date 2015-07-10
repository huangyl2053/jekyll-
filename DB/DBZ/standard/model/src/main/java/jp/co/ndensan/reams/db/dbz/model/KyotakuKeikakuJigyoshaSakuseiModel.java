/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画事業者作成のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyotakuKeikakuJigyoshaSakuseiModel implements Serializable {

    private DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyotakuKeikakuJigyoshaSakuseiModel() {
        entity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     */
    public KyotakuKeikakuJigyoshaSakuseiModel(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3006KyotakuKeikakuJigyoshaSakuseiEntityを返します。
     *
     * @return DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     */
    public DbT3006KyotakuKeikakuJigyoshaSakuseiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3006KyotakuKeikakuJigyoshaSakuseiEntityを設定します。
     *
     * @param entity DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     */
    public void setEntity(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        this.entity = entity;
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshano();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
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
     * 計画事業者番号を返します。
     *
     * @return 計画事業者番号
     */
    public RString get計画事業者番号() {
        return entity.getKeikakuJigyoshaNo();
    }

    /**
     * 委託先事業者番号を返します。
     *
     * @return 委託先事業者番号
     */
    public RString get委託先事業者番号() {
        return entity.getItakusakiJigyoshaNo();
    }

    /**
     * 事業者変更年月日を返します。
     *
     * @return 事業者変更年月日
     */
    public FlexibleDate get事業者変更年月日() {
        return entity.getJigyoshaHenkoYMD();
    }

    /**
     * 事業者変更事由を返します。
     *
     * @return 事業者変更事由
     */
    public RString get事業者変更事由() {
        return entity.getJigyoshaHenkoJiyu();
    }

    /**
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(RString 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshano(被保険者番号);
    }

    /**
     * 証記載保険者番号を設定します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     */
    public void set証記載保険者番号(RString 証記載保険者番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        entity.setShoKisaiHokenshaNo(証記載保険者番号);
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
     * 対象年月を設定します。
     *
     * @param 対象年月 対象年月
     */
    public void set対象年月(FlexibleYearMonth 対象年月) {
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        entity.setTaishoYM(対象年月);
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
     * 計画事業者番号を設定します。
     *
     * @param 計画事業者番号 計画事業者番号
     */
    public void set計画事業者番号(RString 計画事業者番号) {
        requireNonNull(計画事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("計画事業者番号"));
        entity.setKeikakuJigyoshaNo(計画事業者番号);
    }

    /**
     * 委託先事業者番号を設定します。
     *
     * @param 委託先事業者番号 委託先事業者番号
     */
    public void set委託先事業者番号(RString 委託先事業者番号) {
        requireNonNull(委託先事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("委託先事業者番号"));
        entity.setItakusakiJigyoshaNo(委託先事業者番号);
    }

    /**
     * 事業者変更年月日を設定します。
     *
     * @param 事業者変更年月日 事業者変更年月日
     */
    public void set事業者変更年月日(FlexibleDate 事業者変更年月日) {
        requireNonNull(事業者変更年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者変更年月日"));
        entity.setJigyoshaHenkoYMD(事業者変更年月日);
    }

    /**
     * 事業者変更事由を設定します。
     *
     * @param 事業者変更事由 事業者変更事由
     */
    public void set事業者変更事由(RString 事業者変更事由) {
        requireNonNull(事業者変更事由, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者変更事由"));
        entity.setJigyoshaHenkoJiyu(事業者変更事由);
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
