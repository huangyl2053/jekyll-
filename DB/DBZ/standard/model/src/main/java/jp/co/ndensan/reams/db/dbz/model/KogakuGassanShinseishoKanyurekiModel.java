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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算申請書加入歴のモデルクラスです。
 *
 * @author LDNS 周杏月
 */
public class KogakuGassanShinseishoKanyurekiModel implements Serializable {

    private DbT3069KogakuGassanShinseishoKanyurekiEntity entity;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShinseishoKanyurekiModel() {
        entity = new DbT3069KogakuGassanShinseishoKanyurekiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3069KogakuGassanShinseishoKanyurekiEntity
     */
    public KogakuGassanShinseishoKanyurekiModel(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3069KogakuGassanShinseishoKanyurekiEntityを返します。
     *
     * @return DbT3069KogakuGassanShinseishoKanyurekiEntity
     */
    public DbT3069KogakuGassanShinseishoKanyurekiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3069KogakuGassanShinseishoKanyurekiEntityを設定します。
     *
     * @param entity DbT3069KogakuGassanShinseishoKanyurekiEntity
     */
    public void setEntity(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
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
     * 加入歴番号を返します。
     *
     * @return 加入歴番号
     */
    public RString get加入歴番号() {
        return entity.getKanyurekiNo();
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
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaMei();
    }

    /**
     * 加入期間開始年月日を返します。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate get加入期間開始年月日() {
        return entity.getKanyuKaishiYMD();
    }

    /**
     * 加入期間終了年月日を返します。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate get加入期間終了年月日() {
        return entity.getKanyuShuryoYMD();
    }

    /**
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanShomeisho_SeiriNo();
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
     * 対象年度を設定します。
     *
     * @param 対象年度 対象年度
     */
    public void set対象年度(FlexibleYear 対象年度) {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        entity.setTaishoNendo(対象年度);
    }

    /**
     * 保険者番号を設定します。
     *
     * @param 保険者番号 保険者番号
     */
    public void set保険者番号(HokenshaNo 保険者番号) {
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        entity.setHokenshaNo(保険者番号);
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
     * 加入歴番号を設定します。
     *
     * @param 加入歴番号 加入歴番号
     */
    public void set加入歴番号(RString 加入歴番号) {
        requireNonNull(加入歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加入歴番号"));
        entity.setKanyurekiNo(加入歴番号);
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
     * 保険者名を設定します。
     *
     * @param 保険者名 保険者名
     */
    public void set保険者名(RString 保険者名) {
        requireNonNull(保険者名, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者名"));
        entity.setHokenshaMei(保険者名);
    }

    /**
     * 加入期間開始年月日を設定します。
     *
     * @param 加入期間開始年月日 加入期間開始年月日
     */
    public void set加入期間開始年月日(FlexibleDate 加入期間開始年月日) {
        requireNonNull(加入期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間開始年月日"));
        entity.setKanyuKaishiYMD(加入期間開始年月日);
    }

    /**
     * 加入期間終了年月日を設定します。
     *
     * @param 加入期間終了年月日 加入期間終了年月日
     */
    public void set加入期間終了年月日(FlexibleDate 加入期間終了年月日) {
        requireNonNull(加入期間終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("加入期間終了年月日"));
        entity.setKanyuShuryoYMD(加入期間終了年月日);
    }

    /**
     * 自己負担額証明書整理番号を設定します。
     *
     * @param 自己負担額証明書整理番号 自己負担額証明書整理番号
     */
    public void set自己負担額証明書整理番号(RString 自己負担額証明書整理番号) {
        requireNonNull(自己負担額証明書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("自己負担額証明書整理番号"));
        entity.setJikoFutanShomeisho_SeiriNo(自己負担額証明書整理番号);
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
