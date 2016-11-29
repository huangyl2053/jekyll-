/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7124KokiKoreishaInfoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 後期高齢者情報のクラスです。
 *
 * @reamsid_L DBD-5740-010 liuyl
 */
public class KokiKoreishaInfo extends
        ModelBase<KokiKoreishaInfoIdentifier, DbT7124KokiKoreishaInfoEntity, KokiKoreishaInfo>
        implements Serializable {

    private final DbT7124KokiKoreishaInfoEntity entity;
    private final KokiKoreishaInfoIdentifier id;

    /**
     * コンストラクタです。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RString
     */
    public KokiKoreishaInfo(ShikibetsuCode 識別コード, RString 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7124KokiKoreishaInfoEntity();
        this.entity.setShikibetsuCd(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KokiKoreishaInfoIdentifier(識別コード, 履歴番号);
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7124KokiKoreishaInfoEntity
     */
    public KokiKoreishaInfo(DbT7124KokiKoreishaInfoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("後期高齢者情報テーブル"));
        this.id = new KokiKoreishaInfoIdentifier(entity.getShikibetsuCd(), entity.getRirekiNo());
    }

    /**
     * コンストラクタです。
     *
     * @param entiy DbT7124KokiKoreishaInfoEntity
     * @param id KokiKoreishaInfoIdentifier
     */
    KokiKoreishaInfo(DbT7124KokiKoreishaInfoEntity entiy, KokiKoreishaInfoIdentifier id) {
        this.entity = entiy;
        this.id = id;
    }

    //TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 履歴番号を返します。
     *
     * @return RString
     */
    public RString get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 後期高齢保険者番号_市町村を返します。
     *
     * @return RString
     */
    public RString get後期高齢保険者番号_市町村() {
        return entity.getKokiHokenshaNoCity();
    }

    /**
     * 後期高齢被保険者番号を返します。
     *
     * @return RString
     */
    public RString get後期高齢被保険者番号() {
        return entity.getKokikoreiHihokenshaNo();
    }

    /**
     * 資格取得事由コードを返します。
     *
     * @return RString
     */
    public RString get資格取得事由コード() {
        return entity.getShikakuShutokuJiyuCode();
    }

    /**
     * 資格取得日を返します。
     *
     * @return RString
     */
    public RString get資格取得日() {
        return entity.getShikakuShutokuYMD();
    }

    /**
     * 資格喪失事由コードを返します。
     *
     * @return RString
     */
    public RString get資格喪失事由コード() {
        return entity.getShikakuSoshitsuJiyuCode();
    }

    /**
     * 資格喪失日を返します。
     *
     * @return RString
     */
    public RString get資格喪失日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 保険者適用開始日を返します。
     *
     * @return RString
     */
    public RString get保険者適用開始日() {
        return entity.getHokenshaKaishiYMD();
    }

    /**
     * 保険者適用終了日を返します。
     *
     * @return RString
     */
    public RString get保険者適用終了日() {
        return entity.getHokenshaShuryoYMD();
    }

    /**
     * 個人区分コードを返します。
     *
     * @return RString
     */
    public RString get個人区分コード() {
        return entity.getKojinKubunCode();
    }

    /**
     * 登録区分を返します。
     *
     * @return RString
     */
    public RString get登録区分() {
        return entity.getTorokuKubun();
    }

    /**
     * {@link DbT3104KokuhorenInterfaceKanriEntity}のクローンを返します。
     *
     * @return {@link DbT3104KokuhorenInterfaceKanriEntity}
     */
    @Override
    public DbT7124KokiKoreishaInfoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 後期高齢者情報{@link KokuhorenInterfaceKanriIdentifier}を返します。
     *
     * @return 後期高齢者情報{@link KokuhorenInterfaceKanriIdentifier}
     */
    @Override
    public KokiKoreishaInfoIdentifier identifier() {
        return this.id;
    }

    /**
     * 後期高齢者情報を削除対象とします。
     *
     * @return 削除対象処理実施後の{@link KokiKoreishaInfo}
     */
    @Override
    public KokiKoreishaInfo deleted() {
        DbT7124KokiKoreishaInfoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KokiKoreishaInfo(deletedEntity, id);
    }

    /**
     * {@link KokiKoreishaInfo}のシリアライズ形式を提供します。
     *
     * @return {@link KokiKoreishaInfo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new KokiKoreishaInfo._SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT7124KokiKoreishaInfoEntity entity;
        private final KokiKoreishaInfoIdentifier id;

        private _SerializationProxy(DbT7124KokiKoreishaInfoEntity entity, KokiKoreishaInfoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KokiKoreishaInfo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KokiKoreishaInfo.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KokiKoreishaInfoBuilder createBuilderForEdit() {
        return new KokiKoreishaInfoBuilder(entity, id);
    }
}
