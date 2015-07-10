/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model.fuka;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.DankaiIndex;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.RankKubun;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;

/**
 * 保険料段階のモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class HokenryoDankaiModel implements Serializable {

    private DbT2013HokenryoDankaiEntity entity;

    /**
     * コンストラクタです。
     */
    public HokenryoDankaiModel() {
        entity = new DbT2013HokenryoDankaiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT2013HokenryoDankaiEntity
     */
    public HokenryoDankaiModel(DbT2013HokenryoDankaiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT2013HokenryoDankaiEntityを返します。
     *
     * @return DbT2013HokenryoDankaiEntity
     */
    public DbT2013HokenryoDankaiEntity getEntity() {
        return entity;
    }

    /**
     * DbT2013HokenryoDankaiEntityを設定します。
     *
     * @param entity DbT2013HokenryoDankaiEntity
     */
    public void setEntity(DbT2013HokenryoDankaiEntity entity) {
        this.entity = entity;
    }

    /**
     * 賦課年度を返します。
     *
     * @return 賦課年度
     */
    public FukaNendo get賦課年度() {
        return new FukaNendo(entity.getFukaNendo());
    }

    /**
     * 段階インデックスを返します。
     *
     * @return 段階インデックス
     */
    public DankaiIndex get段階インデックス() {
        return entity.getDankaiIndex();
    }

    /**
     * ランク区分を返します。
     *
     * @return ランク区分
     */
    public RankKubun getランク区分() {
        return entity.getRankuKubun();
    }

    /**
     * 段階区分を返します。
     *
     * @return 段階区分
     */
    public RString get段階区分() {
        return entity.getDankaiKubun();
    }

    /**
     * 保険料率を返します。
     *
     * @return 保険料率
     */
    public Decimal get保険料率() {
        return entity.getHokenryoRitsu();
    }

    /**
     * 特例表記を返します。
     *
     * @return 特例表記
     */
    public RString get特例表記() {
        return entity.getTokureiHyoki();
    }

    /**
     * 賦課年度を設定します。
     *
     * @param 賦課年度 賦課年度
     */
    public void set賦課年度(FukaNendo 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        entity.setFukaNendo(賦課年度.value());
    }

    /**
     * 段階インデックスを設定します。
     *
     * @param 段階インデックス 段階インデックス
     */
    public void set段階インデックス(DankaiIndex 段階インデックス) {
        requireNonNull(段階インデックス, UrSystemErrorMessages.値がnull.getReplacedMessage("段階インデックス"));
        entity.setDankaiIndex(段階インデックス);
    }

    /**
     * ランク区分を設定します。
     *
     * @param ランク区分 ランク区分
     */
    public void setランク区分(RankKubun ランク区分) {
        requireNonNull(ランク区分, UrSystemErrorMessages.値がnull.getReplacedMessage("ランク区分"));
        entity.setRankuKubun(ランク区分);
    }

    /**
     * 段階区分を設定します。
     *
     * @param 段階区分 段階区分
     */
    public void set段階区分(RString 段階区分) {
        requireNonNull(段階区分, UrSystemErrorMessages.値がnull.getReplacedMessage("段階区分"));
        entity.setDankaiKubun(段階区分);
    }

    /**
     * 保険料率を設定します。
     *
     * @param 保険料率 保険料率
     */
    public void set保険料率(Decimal 保険料率) {
        requireNonNull(保険料率, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料率"));
        entity.setHokenryoRitsu(保険料率);
    }

    /**
     * 特例表記を設定します。
     *
     * @param 特例表記 特例表記
     */
    public void set特例表記(RString 特例表記) {
        requireNonNull(特例表記, UrSystemErrorMessages.値がnull.getReplacedMessage("特例表記"));
        entity.setTokureiHyoki(特例表記);
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
