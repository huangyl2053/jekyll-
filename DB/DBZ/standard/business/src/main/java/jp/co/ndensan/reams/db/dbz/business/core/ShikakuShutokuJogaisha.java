/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1009ShikakuShutokuJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 資格取得除外者を管理するクラスです。
 */
public class ShikakuShutokuJogaisha extends 
        ModelBase<ShikakuShutokuJogaishaIdentifier, 
        DbT1009ShikakuShutokuJogaishaEntity, 
        ShikakuShutokuJogaisha> implements Serializable {

    private final DbT1009ShikakuShutokuJogaishaEntity entity;
    private final ShikakuShutokuJogaishaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 資格取得除外者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     */
    public ShikakuShutokuJogaisha(ShikibetsuCode 識別コード,
            int 履歴番号) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT1009ShikakuShutokuJogaishaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShikakuShutokuJogaishaIdentifier(
                識別コード,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1009ShikakuShutokuJogaishaEntity}より{@link ShikakuShutokuJogaisha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1009ShikakuShutokuJogaishaEntity}
     */
    public ShikakuShutokuJogaisha(DbT1009ShikakuShutokuJogaishaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得除外者"));
        this.id = new ShikakuShutokuJogaishaIdentifier(
                entity.getShikibetsuCode(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1009ShikakuShutokuJogaishaEntity}
     * @param id {@link ShikakuShutokuJogaishaIdentifier}
     */
    ShikakuShutokuJogaisha(
            DbT1009ShikakuShutokuJogaishaEntity entity,
            ShikakuShutokuJogaishaIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
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
     * {@link DbT1009ShikakuShutokuJogaishaEntity}のクローンを返します。
     *
     * @return {@link DbT1009ShikakuShutokuJogaishaEntity}のクローン
     */
    @Override
    public DbT1009ShikakuShutokuJogaishaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 資格取得除外者の識別子{@link ShikakuShutokuJogaishaIdentifier}を返します。
     *
     * @return 資格取得除外者の識別子{@link ShikakuShutokuJogaishaIdentifier}
     */
    @Override
    public ShikakuShutokuJogaishaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する資格取得除外者を削除対象とします。<br/>
     * {@link DbT1009ShikakuShutokuJogaishaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShikakuShutokuJogaisha}
     */
    @Override
    public ShikakuShutokuJogaisha deleted() {
        DbT1009ShikakuShutokuJogaishaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShikakuShutokuJogaisha(deletedEntity, id);
    }

    /**
     * {@link ShikakuShutokuJogaisha}のシリアライズ形式を提供します。
     *
     * @return {@link ShikakuShutokuJogaisha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT1009ShikakuShutokuJogaishaEntity entity;
        private final ShikakuShutokuJogaishaIdentifier id;

        private _SerializationProxy(DbT1009ShikakuShutokuJogaishaEntity entity, ShikakuShutokuJogaishaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShikakuShutokuJogaisha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShikakuShutokuJogaishaBuilder createBuilderForEdit() {
        return new ShikakuShutokuJogaishaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
