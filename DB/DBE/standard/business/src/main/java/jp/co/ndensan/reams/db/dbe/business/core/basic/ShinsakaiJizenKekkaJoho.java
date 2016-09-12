/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5508ShinsakaiJizenKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護認定審査会事前審査結果情報を管理するクラスです。
 */
public class ShinsakaiJizenKekkaJoho
        extends ParentModelBase<ShinsakaiJizenKekkaJohoIdentifier, DbT5508ShinsakaiJizenKekkaJohoEntity, ShinsakaiJizenKekkaJoho>
        implements Serializable {

    private final DbT5508ShinsakaiJizenKekkaJohoEntity entity;
    private final ShinsakaiJizenKekkaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 介護認定審査会事前審査結果情報の新規作成時に使用します。
     *
     * @param 介護認定審査会開催番号 介護認定審査会開催番号
     * @param 介護認定審査会委員コード 介護認定審査会委員コード
     * @param 介護認定審査会審査順 介護認定審査会審査順
     */
    public ShinsakaiJizenKekkaJoho(RString 介護認定審査会開催番号,
            RString 介護認定審査会委員コード,
            int 介護認定審査会審査順) {
        requireNonNull(介護認定審査会開催番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催番号"));
        requireNonNull(介護認定審査会委員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員コード"));
        requireNonNull(介護認定審査会審査順, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会審査順"));
        this.entity = new DbT5508ShinsakaiJizenKekkaJohoEntity();
        this.entity.setShinsakaiKaisaiNo(介護認定審査会開催番号);
        this.entity.setShinsakaiIinCode(介護認定審査会委員コード);
        this.entity.setShinsakaiOrder(介護認定審査会審査順);
        this.id = new ShinsakaiJizenKekkaJohoIdentifier(
                介護認定審査会開催番号,
                介護認定審査会委員コード,
                介護認定審査会審査順
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5508ShinsakaiJizenKekkaJohoEntity}より{@link ShinsakaiJizenKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5508ShinsakaiJizenKekkaJohoEntity}
     */
    public ShinsakaiJizenKekkaJoho(DbT5508ShinsakaiJizenKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会事前審査結果情報"));
        this.id = new ShinsakaiJizenKekkaJohoIdentifier(
                entity.getShinsakaiKaisaiNo(),
                entity.getShinsakaiIinCode(),
                entity.getShinsakaiOrder());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5508ShinsakaiJizenKekkaJohoEntity}
     * @param id {@link ShinsakaiJizenKekkaJohoIdentifier}
     */
    ShinsakaiJizenKekkaJoho(
            DbT5508ShinsakaiJizenKekkaJohoEntity entity,
            ShinsakaiJizenKekkaJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 介護認定審査会開催番号を返します。
     *
     * @return 介護認定審査会開催番号
     */
    public RString get介護認定審査会開催番号() {
        return entity.getShinsakaiKaisaiNo();
    }

    /**
     * 介護認定審査会委員コードを返します。
     *
     * @return 介護認定審査会委員コード
     */
    public RString get介護認定審査会委員コード() {
        return entity.getShinsakaiIinCode();
    }

    /**
     * 介護認定審査会審査順を返します。
     *
     * @return 介護認定審査会審査順
     */
    public int get介護認定審査会審査順() {
        return entity.getShinsakaiOrder();
    }

    /**
     * 有効期間を返します。
     *
     * @return 有効期間
     */
    public int get有効期間() {
        return entity.getYukokikan();
    }

    /**
     * 二次判定結果コードを返します。
     *
     * @return 二次判定結果コード
     */
    public Code get二次判定結果コード() {
        return entity.getNijiHanteiKekkaCode();
    }

    /**
     * {@link DbT5508ShinsakaiJizenKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5508ShinsakaiJizenKekkaJohoEntity}のクローン
     */
    @Override
    public DbT5508ShinsakaiJizenKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護認定審査会事前審査結果情報の識別子{@link ShinsakaiJizenKekkaJohoIdentifier}を返します。
     *
     * @return 介護認定審査会事前審査結果情報の識別子{@link ShinsakaiJizenKekkaJohoIdentifier}
     */
    @Override
    public ShinsakaiJizenKekkaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護認定審査会事前審査結果情報のみを変更対象とします。<br/>
     * {@link DbT5508ShinsakaiJizenKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShinsakaiJizenKekkaJoho}
     */
    @Override
    public ShinsakaiJizenKekkaJoho modifiedModel() {
        DbT5508ShinsakaiJizenKekkaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShinsakaiJizenKekkaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する介護認定審査会事前審査結果情報を削除対象とします。<br/>
     * {@link DbT5508ShinsakaiJizenKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShinsakaiJizenKekkaJoho}
     */
    @Override
    public ShinsakaiJizenKekkaJoho deleted() {
        DbT5508ShinsakaiJizenKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShinsakaiJizenKekkaJoho(deletedEntity, id);
    }

    /**
     * {@link ShinsakaiJizenKekkaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShinsakaiJizenKekkaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L; // TODO serialVersionUIDを生成してください
        private final DbT5508ShinsakaiJizenKekkaJohoEntity entity;
        private final ShinsakaiJizenKekkaJohoIdentifier id;

        private _SerializationProxy(DbT5508ShinsakaiJizenKekkaJohoEntity entity, ShinsakaiJizenKekkaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShinsakaiJizenKekkaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShinsakaiJizenKekkaJohoBuilder createBuilderForEdit() {
        return new ShinsakaiJizenKekkaJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
