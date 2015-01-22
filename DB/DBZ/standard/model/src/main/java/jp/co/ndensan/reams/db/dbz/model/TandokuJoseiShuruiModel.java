/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3099TandokuJoseiShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成種類のモデルクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class TandokuJoseiShuruiModel implements Serializable {

    private DbT3099TandokuJoseiShuruiEntity entity;

    /**
     * コンストラクタです。
     */
    public TandokuJoseiShuruiModel() {
        entity = new DbT3099TandokuJoseiShuruiEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT3099TandokuJoseiShuruiEntity
     */
    public TandokuJoseiShuruiModel(DbT3099TandokuJoseiShuruiEntity entity) {
        this.entity = entity;
    }

    /**
     * DbT3099TandokuJoseiShuruiEntityを返します。
     *
     * @return DbT3099TandokuJoseiShuruiEntity
     */
    public DbT3099TandokuJoseiShuruiEntity getEntity() {
        return entity;
    }

    /**
     * DbT3099TandokuJoseiShuruiEntityを設定します。
     *
     * @param entity DbT3099TandokuJoseiShuruiEntity
     */
    public void setEntity(DbT3099TandokuJoseiShuruiEntity entity) {
        this.entity = entity;
    }

    /**
     * 市町村単独助成種類を返します。
     *
     * @return 市町村単独助成種類
     */
    public RString get市町村単独助成種類() {
        return entity.getTandokuJoseiShuruiCode();
    }

    /**
     * 助成サービス種類コードを返します。
     *
     * @return 助成サービス種類コード
     */
    public ServiceShuruiCode get助成サービス種類コード() {
        return entity.getJoseiServiceShuruiCode();
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
     * 処理日時を返します。
     *
     * @return 処理日時
     */
    public YMDHMS get処理日時() {
        return entity.getShoriTimestamp();
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
     * 助成サービス種類名称を返します。
     *
     * @return 助成サービス種類名称
     */
    public RString get助成サービス種類名称() {
        return entity.getJoseiServiceShuriMeisho();
    }

    /**
     * 市町村単独助成単位を返します。
     *
     * @return 市町村単独助成単位
     */
    public Decimal get市町村単独助成単位() {
        return entity.getJoseiTani();
    }

    /**
     * 市町村単独助成内容を返します。
     *
     * @return 市町村単独助成内容
     */
    public RString get市町村単独助成内容() {
        return entity.getJoseiNaiyo();
    }

    /**
     * 市町村単独助成種類を設定します。
     *
     * @param 市町村単独助成種類 市町村単独助成種類
     */
    public void set市町村単独助成種類(RString 市町村単独助成種類) {
        requireNonNull(市町村単独助成種類, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成種類"));
        entity.setTandokuJoseiShuruiCode(市町村単独助成種類);
    }

    /**
     * 助成サービス種類コードを設定します。
     *
     * @param 助成サービス種類コード 助成サービス種類コード
     */
    public void set助成サービス種類コード(ServiceShuruiCode 助成サービス種類コード) {
        requireNonNull(助成サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類コード"));
        entity.setJoseiServiceShuruiCode(助成サービス種類コード);
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
     * 処理日時を設定します。
     *
     * @param 処理日時 処理日時
     */
    public void set処理日時(YMDHMS 処理日時) {
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        entity.setShoriTimestamp(処理日時);
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
     * 助成サービス種類名称を設定します。
     *
     * @param 助成サービス種類名称 助成サービス種類名称
     */
    public void set助成サービス種類名称(RString 助成サービス種類名称) {
        requireNonNull(助成サービス種類名称, UrSystemErrorMessages.値がnull.getReplacedMessage("助成サービス種類名称"));
        entity.setJoseiServiceShuriMeisho(助成サービス種類名称);
    }

    /**
     * 市町村単独助成単位を設定します。
     *
     * @param 市町村単独助成単位 市町村単独助成単位
     */
    public void set市町村単独助成単位(Decimal 市町村単独助成単位) {
        requireNonNull(市町村単独助成単位, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成単位"));
        entity.setJoseiTani(市町村単独助成単位);
    }

    /**
     * 市町村単独助成内容を設定します。
     *
     * @param 市町村単独助成内容 市町村単独助成内容
     */
    public void set市町村単独助成内容(RString 市町村単独助成内容) {
        requireNonNull(市町村単独助成内容, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成内容"));
        entity.setJoseiNaiyo(市町村単独助成内容);
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
