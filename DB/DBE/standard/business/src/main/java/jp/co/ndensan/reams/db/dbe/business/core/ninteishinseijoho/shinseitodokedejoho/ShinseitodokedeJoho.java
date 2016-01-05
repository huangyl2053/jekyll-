/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinseitodokedejoho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5120ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 申請届出情報を管理するクラスです。
 */
public class ShinseitodokedeJoho extends ModelBase<ShinseitodokedeJohoIdentifier, DbT5120ShinseitodokedeJohoEntity, ShinseitodokedeJoho> implements Serializable {

    private final DbT5120ShinseitodokedeJohoEntity entity;
    private final ShinseitodokedeJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 申請届出情報の新規作成時に使用します。
     *
     * @param 申請書管理番号
     */
    public ShinseitodokedeJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5120ShinseitodokedeJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new ShinseitodokedeJohoIdentifier(申請書管理番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5120ShinseitodokedeJohoEntity}より{@link ShinseitodokedeJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5120ShinseitodokedeJohoEntity}
     */
    public ShinseitodokedeJoho(DbT5120ShinseitodokedeJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出情報"));
        this.id = new ShinseitodokedeJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5120ShinseitodokedeJohoEntity}
     * @param id {@link ShinseitodokedeJohoIdentifier}
     */
    ShinseitodokedeJoho(
            DbT5120ShinseitodokedeJohoEntity entity,
            ShinseitodokedeJohoIdentifier id
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
     * 申請届出者続柄コードを返します。
     *
     * @return 申請届出者続柄コード
     */
    public RString get申請届出者続柄コード() {
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
     * {@link DbT5120ShinseitodokedeJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5120ShinseitodokedeJohoEntity}のクローン
     */
    @Override
    public DbT5120ShinseitodokedeJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 申請届出情報の識別子{@link ShinseitodokedeJohoIdentifier}を返します。
     *
     * @return 申請届出情報の識別子{@link ShinseitodokedeJohoIdentifier}
     */
    @Override
    public ShinseitodokedeJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 申請届出情報のみを変更対象とします。<br/>
     * {@link DbT5120ShinseitodokedeJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinseitodokedeJoho}
     */
    public ShinseitodokedeJoho modifiedModel() {
        DbT5120ShinseitodokedeJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinseitodokedeJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する申請届出情報を削除対象とします。<br/>
     * {@link DbT5120ShinseitodokedeJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinseitodokedeJoho}
     */
    @Override
    public ShinseitodokedeJoho deleted() {
        DbT5120ShinseitodokedeJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinseitodokedeJoho(deletedEntity, id);
    }

    /**
     * {@link ShinseitodokedeJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinseitodokedeJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5120ShinseitodokedeJohoEntity entity;
        private final ShinseitodokedeJohoIdentifier id;

        private _SerializationProxy(DbT5120ShinseitodokedeJohoEntity entity, ShinseitodokedeJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinseitodokedeJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinseitodokedeJohoBuilder createBuilderForEdit() {
        return new ShinseitodokedeJohoBuilder(entity, id);
    }

}
