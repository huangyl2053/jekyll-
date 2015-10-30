/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 審査会委員除外情報を管理するクラスです。
 */
public class ShinsakaiIinJogaiJoho extends ModelBase<ShinsakaiIinJogaiJohoIdentifier, DbT5590ShinsakaiIinJogaiJohoEntity, ShinsakaiIinJogaiJoho> implements Serializable {

    private final DbT5590ShinsakaiIinJogaiJohoEntity entity;
    private final ShinsakaiIinJogaiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 審査会委員除外情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 連番 連番
     */
    public ShinsakaiIinJogaiJoho(ShinseishoKanriNo 申請書管理番号,
            int 連番) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));
        this.entity = new DbT5590ShinsakaiIinJogaiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setRenban(連番);
        this.id = new ShinsakaiIinJogaiJohoIdentifier(
                申請書管理番号,
                連番
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5590ShinsakaiIinJogaiJohoEntity}より{@link ShinsakaiIinJogaiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5590ShinsakaiIinJogaiJohoEntity}
     */
    public ShinsakaiIinJogaiJoho(DbT5590ShinsakaiIinJogaiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員除外情報"));
        this.id = new ShinsakaiIinJogaiJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getRenban());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5590ShinsakaiIinJogaiJohoEntity}
     * @param id {@link ShinsakaiIinJogaiJohoIdentifier}
     */
    ShinsakaiIinJogaiJoho(
            DbT5590ShinsakaiIinJogaiJohoEntity entity,
            ShinsakaiIinJogaiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public int get連番() {
        return entity.getRenban();
    }

    /**
     * 除外対象審査会委員コードを返します。
     *
     * @return 除外対象審査会委員コード
     */
    public RString get除外対象審査会委員コード() {
        return entity.getJogaiTaishoShinsakaiIinCode();
    }

    /**
     * {@link DbT5590ShinsakaiIinJogaiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5590ShinsakaiIinJogaiJohoEntity}のクローン
     */
    @Override
    public DbT5590ShinsakaiIinJogaiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 審査会委員除外情報の識別子{@link ShinsakaiIinJogaiJohoIdentifier}を返します。
     *
     * @return 審査会委員除外情報の識別子{@link ShinsakaiIinJogaiJohoIdentifier}
     */
    @Override
    public ShinsakaiIinJogaiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 審査会委員除外情報のみを変更対象とします。<br/>
     * {@link DbT5590ShinsakaiIinJogaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiIinJogaiJoho}
     */
    public ShinsakaiIinJogaiJoho modifiedModel() {
        DbT5590ShinsakaiIinJogaiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiIinJogaiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する審査会委員除外情報を削除対象とします。<br/>
     * {@link DbT5590ShinsakaiIinJogaiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiIinJogaiJoho}
     */
    @Override
    public ShinsakaiIinJogaiJoho deleted() {
        DbT5590ShinsakaiIinJogaiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiIinJogaiJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiIinJogaiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiIinJogaiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5590ShinsakaiIinJogaiJohoEntity entity;
        private final ShinsakaiIinJogaiJohoIdentifier id;

        private _SerializationProxy(DbT5590ShinsakaiIinJogaiJohoEntity entity, ShinsakaiIinJogaiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiIinJogaiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiIinJogaiJohoBuilder createBuilderForEdit() {
        return new ShinsakaiIinJogaiJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShinsakaiIinJogaiJoho other = (ShinsakaiIinJogaiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
