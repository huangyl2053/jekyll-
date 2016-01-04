/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5592ShinsakaiKaisaiBashoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会開催場所情報を管理するクラスです。
 */
public class ShinsakaiKaisaiBashoJoho 
                extends ModelBase<ShinsakaiKaisaiBashoJohoIdentifier, 
                                  DbT5592ShinsakaiKaisaiBashoJohoEntity, 
                                  ShinsakaiKaisaiBashoJoho> 
                implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT5592ShinsakaiKaisaiBashoJohoEntity entity;
    private final ShinsakaiKaisaiBashoJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会開催場所情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催場所コード 介護認定審査会開催場所コード
     */
    public ShinsakaiKaisaiBashoJoho(RString 介護認定審査会開催場所コード) {
        requireNonNull(介護認定審査会開催場所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所コード"));
        this.entity = new DbT5592ShinsakaiKaisaiBashoJohoEntity();
        this.entity.setShinsakaiKaisaiBashoCode(介護認定審査会開催場所コード);
        this.id = new ShinsakaiKaisaiBashoJohoIdentifier(
                介護認定審査会開催場所コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5592ShinsakaiKaisaiBashoJohoEntity}より{@link ShinsakaiKaisaiBashoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5592ShinsakaiKaisaiBashoJohoEntity}
     */
    public ShinsakaiKaisaiBashoJoho(DbT5592ShinsakaiKaisaiBashoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        this.id = new ShinsakaiKaisaiBashoJohoIdentifier(
                entity.getShinsakaiKaisaiBashoCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}
     * @param id {@link ShinsakaiKaisaiBashoJohoIdentifier}
     */
    ShinsakaiKaisaiBashoJoho(
            DbT5592ShinsakaiKaisaiBashoJohoEntity entity,
            ShinsakaiKaisaiBashoJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 介護認定審査会開催場所コードを返します。
     *
     * @return 介護認定審査会開催場所コード
     */
    public RString get介護認定審査会開催場所コード() {
        return entity.getShinsakaiKaisaiBashoCode();
    }

    /**
     * 介護認定審査会開催場所名称を返します。
     *
     * @return 介護認定審査会開催場所名称
     */
    public RString get介護認定審査会開催場所名称() {
        return entity.getShinsakaiKaisaiBashoName();
    }

    /**
     * 介護認定審査会開催地区コードを返します。
     *
     * @return 介護認定審査会開催地区コード
     */
    public Code get介護認定審査会開催地区コード() {
        return entity.getShinsakaiKaisaiChikuCode();
    }

    /**
     * 介護認定審査会開催場所住所を返します。
     *
     * @return 介護認定審査会開催場所住所
     */
    public RString get介護認定審査会開催場所住所() {
        return entity.getShinsakaiKaisaiBashoJusho();
    }

    /**
     * 介護認定審査会開催場所電話番号を返します。
     *
     * @return 介護認定審査会開催場所電話番号
     */
    public TelNo get介護認定審査会開催場所電話番号() {
        return entity.getShinsakaiKaisaiBashoTelNo();
    }

    /**
     * 介護認定審査会開催場所状況を返します。
     *
     * @return 介護認定審査会開催場所状況
     */
    public boolean get介護認定審査会開催場所状況() {
        return entity.getShinsakaiKaisaiBashoJokyo();
    }

    /**
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}のクローン
     */
    @Override
    public DbT5592ShinsakaiKaisaiBashoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会開催場所情報の識別子{@link ShinsakaiKaisaiBashoJohoIdentifier}を返します。
     *
     * @return 介護認定審査会開催場所情報の識別子{@link ShinsakaiKaisaiBashoJohoIdentifier}
     */
    @Override
    public ShinsakaiKaisaiBashoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会開催場所情報のみを変更対象とします。<br/>
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiKaisaiBashoJoho}
     */
    public ShinsakaiKaisaiBashoJoho modifiedModel() {
        DbT5592ShinsakaiKaisaiBashoJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiKaisaiBashoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会開催場所情報を削除対象とします。<br/>
     * {@link DbT5592ShinsakaiKaisaiBashoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiKaisaiBashoJoho}
     */
    @Override
    public ShinsakaiKaisaiBashoJoho deleted() {
        DbT5592ShinsakaiKaisaiBashoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiKaisaiBashoJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiKaisaiBashoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiKaisaiBashoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -6133277873893208856L;
        private final DbT5592ShinsakaiKaisaiBashoJohoEntity entity;
        private final ShinsakaiKaisaiBashoJohoIdentifier id;

        private _SerializationProxy(DbT5592ShinsakaiKaisaiBashoJohoEntity entity, ShinsakaiKaisaiBashoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiKaisaiBashoJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiKaisaiBashoJohoBuilder createBuilderForEdit() {
        return new ShinsakaiKaisaiBashoJohoBuilder(entity, id);
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final ShinsakaiKaisaiBashoJoho other = (ShinsakaiKaisaiBashoJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
