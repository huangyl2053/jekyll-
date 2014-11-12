/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1004ShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険施設入退所のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class ShisetsuNyutaishoModel implements Serializable {

    private DbT1004ShisetsuNyutaishoEntity entity;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoModel() {
        entity = new DbT1004ShisetsuNyutaishoEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     */
    public ShisetsuNyutaishoModel(DbT1004ShisetsuNyutaishoEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを返します。
     *
     * @return DbT1004ShisetsuNyutaishoEntity
     */
    public DbT1004ShisetsuNyutaishoEntity getEntity() {
        return entity;
    }

    /**
     * DbT1004ShisetsuNyutaishoEntityを設定します。
     *
     * @param entity DbT1004ShisetsuNyutaishoEntity
     */
    public void setEntity(DbT1004ShisetsuNyutaishoEntity entity) {
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
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    public RString get台帳種別() {
        return entity.getDaichoShubetsu();
    }

    /**
     * 入所施設種類を返します。
     *
     * @return 入所施設種類
     */
    public RString get入所施設種類() {
        return entity.getNyushoShisetsuShurui();
    }

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    public RString get入所施設コード() {
        return entity.getNyushoShisetsuCode();
    }

    /**
     * 入所年月日を返します。
     *
     * @return 入所年月日
     */
    public FlexibleDate get入所年月日() {
        return entity.getNyushoYMD();
    }

    /**
     * 退所年月日を返します。
     *
     * @return 退所年月日
     */
    public FlexibleDate get退所年月日() {
        return entity.getTaishoYMD();
    }

    /**
     * 入所処理年月日を返します。
     *
     * @return 入所処理年月日
     */
    public FlexibleDate get入所処理年月日() {
        return entity.getNyushoShoriYMD();
    }

    /**
     * 退所処理年月日を返します。
     *
     * @return 退所処理年月日
     */
    public FlexibleDate get退所処理年月日() {
        return entity.getTaishoShoriYMD();
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
     * 台帳種別を設定します。
     *
     * @param 台帳種別 台帳種別
     */
    public void set台帳種別(RString 台帳種別) {
        requireNonNull(台帳種別, UrSystemErrorMessages.値がnull.getReplacedMessage("台帳種別"));
        entity.setDaichoShubetsu(台帳種別);
    }

    /**
     * 入所施設種類を設定します。
     *
     * @param 入所施設種類 入所施設種類
     */
    public void set入所施設種類(RString 入所施設種類) {
        requireNonNull(入所施設種類, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設種類"));
        entity.setNyushoShisetsuShurui(入所施設種類);
    }

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     */
    public void set入所施設コード(RString 入所施設コード) {
        requireNonNull(入所施設コード, UrSystemErrorMessages.値がnull.getReplacedMessage("入所施設コード"));
        entity.setNyushoShisetsuCode(入所施設コード);
    }

    /**
     * 入所年月日を設定します。
     *
     * @param 入所年月日 入所年月日
     */
    public void set入所年月日(FlexibleDate 入所年月日) {
        requireNonNull(入所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所年月日"));
        entity.setNyushoYMD(入所年月日);
    }

    /**
     * 退所年月日を設定します。
     *
     * @param 退所年月日 退所年月日
     */
    public void set退所年月日(FlexibleDate 退所年月日) {
        requireNonNull(退所年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所年月日"));
        entity.setTaishoYMD(退所年月日);
    }

    /**
     * 入所処理年月日を設定します。
     *
     * @param 入所処理年月日 入所処理年月日
     */
    public void set入所処理年月日(FlexibleDate 入所処理年月日) {
        requireNonNull(入所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("入所処理年月日"));
        entity.setNyushoShoriYMD(入所処理年月日);
    }

    /**
     * 退所処理年月日を設定します。
     *
     * @param 退所処理年月日 退所処理年月日
     */
    public void set退所処理年月日(FlexibleDate 退所処理年月日) {
        requireNonNull(退所処理年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("退所処理年月日"));
        entity.setTaishoShoriYMD(退所処理年月日);
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
