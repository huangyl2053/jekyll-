/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7908KaigoDonyuKeitaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護導入形態を管理するクラスです。
 */
public class KaigoDonyuKeitai extends ModelBase<KaigoDonyuKeitaiIdentifier, DbT7908KaigoDonyuKeitaiEntity, KaigoDonyuKeitai> implements Serializable {

    private final DbT7908KaigoDonyuKeitaiEntity entity;
    private final KaigoDonyuKeitaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護導入形態の新規作成時に使用します。
     *
     * @param 業務分類 業務分類
     * @param 導入形態コード 導入形態コード
     */
    public KaigoDonyuKeitai(RString 業務分類,
            Code 導入形態コード) {
        requireNonNull(業務分類, UrSystemErrorMessages.値がnull.getReplacedMessage("業務分類"));
        requireNonNull(導入形態コード, UrSystemErrorMessages.値がnull.getReplacedMessage("導入形態コード"));
        this.entity = new DbT7908KaigoDonyuKeitaiEntity();
        this.entity.setGyomuBunrui(業務分類);
        this.entity.setDonyuKeitaiCode(導入形態コード);
        this.id = new KaigoDonyuKeitaiIdentifier(
                業務分類,
                導入形態コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7908KaigoDonyuKeitaiEntity}より{@link KaigoDonyuKeitai}を生成します。
     *
     * @param entity DBより取得した{@link DbT7908KaigoDonyuKeitaiEntity}
     */
    public KaigoDonyuKeitai(DbT7908KaigoDonyuKeitaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護導入形態"));
        this.id = new KaigoDonyuKeitaiIdentifier(
                entity.getGyomuBunrui(),
                entity.getDonyuKeitaiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7908KaigoDonyuKeitaiEntity}
     * @param id {@link KaigoDonyuKeitaiIdentifier}
     */
    KaigoDonyuKeitai(
            DbT7908KaigoDonyuKeitaiEntity entity,
            KaigoDonyuKeitaiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 業務分類を返します。
     *
     * @return 業務分類
     */
    public RString get業務分類() {
        return entity.getGyomuBunrui();
    }

    /**
     * 導入形態コードを返します。
     *
     * @return 導入形態コード
     */
    public Code get導入形態コード() {
        return entity.getDonyuKeitaiCode();
    }

    /**
     * 支所管理有無フラグを返します。
     *
     * @return 支所管理有無フラグ
     */
    public boolean get支所管理有無フラグ() {
        return entity.getShishoKanriUmuFlag();
    }

    /**
     * {@link DbT7908KaigoDonyuKeitaiEntity}のクローンを返します。
     *
     * @return {@link DbT7908KaigoDonyuKeitaiEntity}のクローン
     */
    @Override
    public DbT7908KaigoDonyuKeitaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護導入形態の識別子{@link KaigoDonyuKeitaiIdentifier}を返します。
     *
     * @return 介護導入形態の識別子{@link KaigoDonyuKeitaiIdentifier}
     */
    @Override
    public KaigoDonyuKeitaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する介護導入形態を削除対象とします。<br/>
     * {@link DbT7908KaigoDonyuKeitaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KaigoDonyuKeitai}
     */
    @Override
    public KaigoDonyuKeitai deleted() {
        DbT7908KaigoDonyuKeitaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KaigoDonyuKeitai(deletedEntity, id);
    }

    /**
     * {@link KaigoDonyuKeitai}のシリアライズ形式を提供します。
     *
     * @return {@link KaigoDonyuKeitai}のシリアライズ形式
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

        private final DbT7908KaigoDonyuKeitaiEntity entity;
        private final KaigoDonyuKeitaiIdentifier id;

        private _SerializationProxy(DbT7908KaigoDonyuKeitaiEntity entity, KaigoDonyuKeitaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KaigoDonyuKeitai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KaigoDonyuKeitaiBuilder createBuilderForEdit() {
        return new KaigoDonyuKeitaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
