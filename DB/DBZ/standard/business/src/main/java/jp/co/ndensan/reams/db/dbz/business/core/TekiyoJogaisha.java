/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1002TekiyoJogaishaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 適用除外者を管理するクラスです。
 */
public class TekiyoJogaisha extends ModelBase<TekiyoJogaishaIdentifier, DbT1002TekiyoJogaishaEntity, TekiyoJogaisha> implements Serializable {

    private final DbT1002TekiyoJogaishaEntity entity;
    private final TekiyoJogaishaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 適用除外者の新規作成時に使用します。
     *
     * @param 識別コード 識別コード
     * @param 異動日 異動日
     * @param 枝番 枝番
     */
    public TekiyoJogaisha(ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        this.entity = new DbT1002TekiyoJogaishaEntity();
        this.entity.setShikibetsuCode(識別コード);
        this.entity.setIdoYMD(異動日);
        this.entity.setEdaNo(枝番);
        this.id = new TekiyoJogaishaIdentifier(
                識別コード,
                異動日,
                枝番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1002TekiyoJogaishaEntity}より{@link TekiyoJogaisha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1002TekiyoJogaishaEntity}
     */
    public TekiyoJogaisha(DbT1002TekiyoJogaishaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("適用除外者"));
        this.id = new TekiyoJogaishaIdentifier(
                entity.getShikibetsuCode(),
                entity.getIdoYMD(),
                entity.getEdaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1002TekiyoJogaishaEntity}
     * @param id {@link TekiyoJogaishaIdentifier}
     */
    TekiyoJogaisha(
            DbT1002TekiyoJogaishaEntity entity,
            TekiyoJogaishaIdentifier id
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
     * 異動日を返します。
     *
     * @return 異動日
     */
    public FlexibleDate get異動日() {
        return entity.getIdoYMD();
    }

    /**
     * 枝番を返します。
     *
     * @return 枝番
     */
    public RString get枝番() {
        return entity.getEdaNo();
    }

    /**
     * 異動事由コードを返します。
     *
     * @return 異動事由コード
     */
    public RString get異動事由コード() {
        return entity.getIdoJiyuCode();
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
     * 適用除外適用事由コードを返します。
     *
     * @return 適用除外適用事由コード
     */
    public RString get適用除外適用事由コード() {
        return entity.getTekiyoJogaiTekiyoJiyuCode();
    }

    /**
     * 適用年月日を返します。
     *
     * @return 適用年月日
     */
    public FlexibleDate get適用年月日() {
        return entity.getTekiyoYMD();
    }

    /**
     * 適用届出年月日を返します。
     *
     * @return 適用届出年月日
     */
    public FlexibleDate get適用届出年月日() {
        return entity.getTekiyoTodokedeYMD();
    }

    /**
     * 適用受付年月日を返します。
     *
     * @return 適用受付年月日
     */
    public FlexibleDate get適用受付年月日() {
        return entity.getTekiyoUketsukeYMD();
    }

    /**
     * 適用除外解除事由コードを返します。
     *
     * @return 適用除外解除事由コード
     */
    public RString get適用除外解除事由コード() {
        return entity.getTekiyoJogaikaijokaijoJiyuCode();
    }

    /**
     * 解除年月日を返します。
     *
     * @return 解除年月日
     */
    public FlexibleDate get解除年月日() {
        return entity.getKaijoYMD();
    }

    /**
     * 解除届出年月日を返します。
     *
     * @return 解除届出年月日
     */
    public FlexibleDate get解除届出年月日() {
        return entity.getKaijoTodokedeYMD();
    }

    /**
     * 解除受付年月日を返します。
     *
     * @return 解除受付年月日
     */
    public FlexibleDate get解除受付年月日() {
        return entity.getKaijoUketsukeYMD();
    }

    /**
     * 入所通知発行日を返します。
     *
     * @return 入所通知発行日
     */
    public FlexibleDate get入所通知発行日() {
        return entity.getNyushoTsuchiHakkoYMD();
    }

    /**
     * 退所通知発行日を返します。
     *
     * @return 退所通知発行日
     */
    public FlexibleDate get退所通知発行日() {
        return entity.getTaishoTsuchiHakkoYMD();
    }

    /**
     * 変更通知発行日を返します。
     *
     * @return 変更通知発行日
     */
    public FlexibleDate get変更通知発行日() {
        return entity.getHenkoTsuchiHakkoYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT1002TekiyoJogaishaEntity}のクローンを返します。
     *
     * @return {@link DbT1002TekiyoJogaishaEntity}のクローン
     */
    @Override
    public DbT1002TekiyoJogaishaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 適用除外者の識別子{@link TekiyoJogaishaIdentifier}を返します。
     *
     * @return 適用除外者の識別子{@link TekiyoJogaishaIdentifier}
     */
    @Override
    public TekiyoJogaishaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する適用除外者を削除対象とします。<br/>
     * {@link DbT1002TekiyoJogaishaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TekiyoJogaisha}
     */
    @Override
    public TekiyoJogaisha deleted() {
        DbT1002TekiyoJogaishaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TekiyoJogaisha(deletedEntity, id);
    }

    /**
     * {@link TekiyoJogaisha}のシリアライズ形式を提供します。
     *
     * @return {@link TekiyoJogaisha}のシリアライズ形式
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

        private final DbT1002TekiyoJogaishaEntity entity;
        private final TekiyoJogaishaIdentifier id;

        private _SerializationProxy(DbT1002TekiyoJogaishaEntity entity, TekiyoJogaishaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TekiyoJogaisha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TekiyoJogaishaBuilder createBuilderForEdit() {
        return new TekiyoJogaishaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
