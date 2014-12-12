/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 資格取得除外者のモデルクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class ShikakuShutokuJogaishaModel implements Serializable {

    private DbT1009ShikakuShutokuJogaishaEntity entity;

    /**
     * コンストラクタです。
     */
    public ShikakuShutokuJogaishaModel() {
        entity = new DbT1009ShikakuShutokuJogaishaEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT1009ShikakuShutokuJogaishaEntity
     */
    public ShikakuShutokuJogaishaModel(DbT1009ShikakuShutokuJogaishaEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT1009ShikakuShutokuJogaishaEntityを返します。
     *
     * @return DbT1009ShikakuShutokuJogaishaEntity
     */
    public DbT1009ShikakuShutokuJogaishaEntity getEntity() {
        return entity;
    }

    /**
     * DbT1009ShikakuShutokuJogaishaEntityを設定します。
     *
     * @param entity DbT1009ShikakuShutokuJogaishaEntity
     */
    public void setEntity(DbT1009ShikakuShutokuJogaishaEntity entity) {
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
        return entity.getShoriTimeStamp();
    }

    /**
     * 資格取得除外理由を返します。
     *
     * @return 資格取得除外理由
     */
    public RString get資格取得除外理由() {
        return entity.getShikakuShutokuJogaiRiyu();
    }

    /**
     * 資格取得除外年月日を返します。
     *
     * @return 資格取得除外年月日
     */
    public FlexibleDate get資格取得除外年月日() {
        return entity.getShikakuShutokuJogaiYMD();
    }

    /**
     * 資格取得除外解除年月日を返します。
     *
     * @return 資格取得除外解除年月日
     */
    public FlexibleDate get資格取得除外解除年月日() {
        return entity.getShikakuShutokuJogaiKaijoYMD();
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
        entity.setShoriTimeStamp(処理日時);
    }

    /**
     * 資格取得除外理由を設定します。
     *
     * @param 資格取得除外理由 資格取得除外理由
     */
    public void set資格取得除外理由(RString 資格取得除外理由) {
        requireNonNull(資格取得除外理由, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外理由"));
        entity.setShikakuShutokuJogaiRiyu(資格取得除外理由);
    }

    /**
     * 資格取得除外年月日を設定します。
     *
     * @param 資格取得除外年月日 資格取得除外年月日
     */
    public void set資格取得除外年月日(FlexibleDate 資格取得除外年月日) {
        requireNonNull(資格取得除外年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外年月日"));
        entity.setShikakuShutokuJogaiYMD(資格取得除外年月日);
    }

    /**
     * 資格取得除外解除年月日を設定します。
     *
     * @param 資格取得除外解除年月日 資格取得除外解除年月日
     */
    public void set資格取得除外解除年月日(FlexibleDate 資格取得除外解除年月日) {
        requireNonNull(資格取得除外解除年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外解除年月日"));
        entity.setShikakuShutokuJogaiKaijoYMD(資格取得除外解除年月日);
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
