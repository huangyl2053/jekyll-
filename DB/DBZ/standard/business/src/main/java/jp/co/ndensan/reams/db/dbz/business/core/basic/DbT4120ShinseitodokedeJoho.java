/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請届出情報を管理するクラスです。
 */
public class DbT4120ShinseitodokedeJoho extends ParentModelBase<DbT4120ShinseitodokedeJohoIdentifier,
        DbT4120ShinseitodokedeJohoEntity, DbT4120ShinseitodokedeJoho> implements Serializable {

    private static final long serialVersionUID = -1196816268885746094L;
    private final DbT4120ShinseitodokedeJohoEntity entity;
    private final DbT4120ShinseitodokedeJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 申請届出情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public DbT4120ShinseitodokedeJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT4120ShinseitodokedeJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new DbT4120ShinseitodokedeJohoIdentifier(
        申請書管理番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4120ShinseitodokedeJohoEntity}より{@link DbT4120ShinseitodokedeJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4120ShinseitodokedeJohoEntity}
     */
    public DbT4120ShinseitodokedeJoho(DbT4120ShinseitodokedeJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出情報"));
        this.id = new DbT4120ShinseitodokedeJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4120ShinseitodokedeJohoEntity}
     * @param id {@link DbT4120ShinseitodokedeJohoIdentifier}
     */
    DbT4120ShinseitodokedeJoho(
            DbT4120ShinseitodokedeJohoEntity entity,
            DbT4120ShinseitodokedeJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 申請届出代行区分コードを返します。
     *
     * @return 申請届出代行区分コード
     */
    public Code get申請届出代行区分コード() {
        return entity.getShinseiTodokedeDaikoKubunCode();
    }

    /**
     * 申請届出者氏名を返します。
     *
     * @return 申請届出者氏名
     */
    public RString get申請届出者氏名() {
        return entity.getShinseiTodokedeshaShimei();
    }

    /**
     * 申請届出者氏名カナを返します。
     *
     * @return 申請届出者氏名カナ
     */
    public RString get申請届出者氏名カナ() {
        return entity.getShinseiTodokedeshaKanaShimei();
    }

    /**
     * 申請届出者続柄を返します。
     *
     * @return 申請届出者続柄
     */
    public RString get申請届出者続柄() {
        return entity.getShinseiTodokedeshaTsuzukigara();
    }

    /**
     * 申請届出代行事業者番号を返します。
     *
     * @return 申請届出代行事業者番号
     */
    public JigyoshaNo get申請届出代行事業者番号() {
        return entity.getShinseiTodokedeDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請届出者郵便番号を返します。
     *
     * @return 申請届出者郵便番号
     */
    public YubinNo get申請届出者郵便番号() {
        return entity.getShinseiTodokedeshaYubinNo();
    }

    /**
     * 申請届出者住所を返します。
     *
     * @return 申請届出者住所
     */
    public RString get申請届出者住所() {
        return entity.getShinseiTodokedeshaJusho();
    }

    /**
     * 申請届出者電話番号を返します。
     *
     * @return 申請届出者電話番号
     */
    public TelNo get申請届出者電話番号() {
        return entity.getShinseiTodokedeshaTelNo();
    }

    /**
     * {@link DbT4120ShinseitodokedeJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4120ShinseitodokedeJohoEntity}のクローン
     */
    @Override
    public DbT4120ShinseitodokedeJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 申請届出情報の識別子{@link DbT4120ShinseitodokedeJohoIdentifier}を返します。
     *
     * @return 申請届出情報の識別子{@link DbT4120ShinseitodokedeJohoIdentifier}
     */
    @Override
    public DbT4120ShinseitodokedeJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請届出情報のみを変更対象とします。<br/>
     * {@link DbT4120ShinseitodokedeJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4120ShinseitodokedeJoho}
     */
    @Override
    public DbT4120ShinseitodokedeJoho modifiedModel() {
        DbT4120ShinseitodokedeJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4120ShinseitodokedeJoho(
                modifiedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する申請届出情報を削除対象とします。<br/>
     * {@link DbT4120ShinseitodokedeJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4120ShinseitodokedeJoho}
     */
    @Override
    public DbT4120ShinseitodokedeJoho deleted() {
        DbT4120ShinseitodokedeJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4120ShinseitodokedeJoho(deletedEntity, id);
    }
    /**
     * {@link DbT4120ShinseitodokedeJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4120ShinseitodokedeJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4120ShinseitodokedeJohoEntity entity;
        private final DbT4120ShinseitodokedeJohoIdentifier id;

        private _SerializationProxy(DbT4120ShinseitodokedeJohoEntity entity, DbT4120ShinseitodokedeJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4120ShinseitodokedeJoho(this.entity, this.id);
        }
        private static final long serialVersionUID = -3136020887647135414L;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4120ShinseitodokedeJohoBuilder createBuilderForEdit() {
        return new DbT4120ShinseitodokedeJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。

}
