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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層保険料段階のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class KyokaisoHokenryoDankaiModel implements Serializable {

    private DbT1007KyokaisoHokenryoDankaiEntity entity;

    /**
     * コンストラクタです。
     */
    public KyokaisoHokenryoDankaiModel() {
        entity = new DbT1007KyokaisoHokenryoDankaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1007KyokaisoHokenryoDankaiEntity
     */
    public KyokaisoHokenryoDankaiModel(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1007KyokaisoHokenryoDankaiEntityを返します。
     *
     * @return DbT1007KyokaisoHokenryoDankaiEntity
     */
    public DbT1007KyokaisoHokenryoDankaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT1007KyokaisoHokenryoDankaiEntityを設定します。
     *
     * @param entity DbT1007KyokaisoHokenryoDankaiEntity
     */
    public void setEntity(DbT1007KyokaisoHokenryoDankaiEntity entity) {
        this.entity = entity;
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimeStamp();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * 保険料納付減額後保険料段階を返します。
     *
     * @return 保険料納付減額後保険料段階
     */
    public RString get保険料納付減額後保険料段階() {
        return entity.getGengakuGoHokenryoDankai();
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
     * 被保険者番号を設定します。
     *
     * @param 被保険者番号 被保険者番号
     */
    public void set被保険者番号(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        entity.setHihokenshaNo(被保険者番号);
    }

    /**
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimeStamp(処理日時);
    }

    /**
     * 適用開始年月を設定します。
     *
     * @param 適用開始年月 適用開始年月
     */
    public void set適用開始年月(FlexibleYearMonth 適用開始年月) {
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        entity.setTekiyoKaishiYM(適用開始年月);
    }

    /**
     * 適用終了年月を設定します。
     *
     * @param 適用終了年月 適用終了年月
     */
    public void set適用終了年月(FlexibleYearMonth 適用終了年月) {
        requireNonNull(適用終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用終了年月"));
        entity.setTekiyoShuryoYM(適用終了年月);
    }

    /**
     * 保険料納付減額後保険料段階を設定します。
     *
     * @param 保険料納付減額後保険料段階 保険料納付減額後保険料段階
     */
    public void set保険料納付減額後保険料段階(RString 保険料納付減額後保険料段階) {
        requireNonNull(保険料納付減額後保険料段階, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料納付減額後保険料段階"));
        entity.setGengakuGoHokenryoDankai(保険料納付減額後保険料段階);
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
