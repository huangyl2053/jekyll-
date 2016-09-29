/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定一次判定結果情報を管理するクラスです。
 */
public class IchijiHanteiKekkaJoho extends
        ParentModelBase<IchijiHanteiKekkaJohoIdentifier, DbT4116IchijiHanteiKekkaJohoEntity, IchijiHanteiKekkaJoho> implements Serializable {

    private final DbT4116IchijiHanteiKekkaJohoEntity entity;
    private final IchijiHanteiKekkaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定一次判定結果情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public IchijiHanteiKekkaJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT4116IchijiHanteiKekkaJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new IchijiHanteiKekkaJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4116IchijiHanteiKekkaJohoEntity}より{@link IchijiHanteiKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4116IchijiHanteiKekkaJohoEntity}
     */
    public IchijiHanteiKekkaJoho(DbT4116IchijiHanteiKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果情報"));
        this.id = new IchijiHanteiKekkaJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4116IchijiHanteiKekkaJohoEntity}
     * @param id {@link IchijiHanteiKekkaJohoIdentifier}
     */
    IchijiHanteiKekkaJoho(
            DbT4116IchijiHanteiKekkaJohoEntity entity,
            IchijiHanteiKekkaJohoIdentifier id
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
     * 仮一次判定区分を返します。
     *
     * @return 仮一次判定区分
     */
    public boolean is仮一次判定区分() {
        return entity.getKariIchijiHanteiKubun();
    }

    /**
     * 要介護認定一次判定年月日を返します。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
    }

    /**
     * 要介護認定一次判定結果コード_認知症加算を返します。
     *
     * @return 要介護認定一次判定結果コード_認知症加算
     */
    public Code get要介護認定一次判定結果コード_認知症加算() {
        return entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * {@link DbT4116IchijiHanteiKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4116IchijiHanteiKekkaJohoEntity}のクローン
     */
    @Override
    public DbT4116IchijiHanteiKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定一次判定結果情報の識別子{@link IchijiHanteiKekkaJohoIdentifier}を返します。
     *
     * @return 要介護認定一次判定結果情報の識別子{@link IchijiHanteiKekkaJohoIdentifier}
     */
    @Override
    public IchijiHanteiKekkaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定一次判定結果情報のみを変更対象とします。<br/>
     * {@link DbT4116IchijiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IchijiHanteiKekkaJoho}
     */
    @Override
    public IchijiHanteiKekkaJoho modifiedModel() {
        DbT4116IchijiHanteiKekkaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IchijiHanteiKekkaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定一次判定結果情報を削除対象とします。<br/>
     * {@link DbT4116IchijiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IchijiHanteiKekkaJoho}
     */
    @Override
    public IchijiHanteiKekkaJoho deleted() {
        DbT4116IchijiHanteiKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IchijiHanteiKekkaJoho(deletedEntity, id);
    }

    /**
     * {@link IchijiHanteiKekkaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link IchijiHanteiKekkaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT4116IchijiHanteiKekkaJohoEntity entity;
        private final IchijiHanteiKekkaJohoIdentifier id;

        private _SerializationProxy(DbT4116IchijiHanteiKekkaJohoEntity entity, IchijiHanteiKekkaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IchijiHanteiKekkaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IchijiHanteiKekkaJohoBuilder createBuilderForEdit() {
        return new IchijiHanteiKekkaJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
