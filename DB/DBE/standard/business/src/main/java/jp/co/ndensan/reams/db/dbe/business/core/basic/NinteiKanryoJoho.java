/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5105NinteiKanryoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定完了情報を管理するクラスです。
 */
public class NinteiKanryoJoho
        extends ModelBase<NinteiKanryoJohoIdentifier, DbT5105NinteiKanryoJohoEntity, NinteiKanryoJoho>
        implements Serializable {

    private final DbT5105NinteiKanryoJohoEntity entity;
    private final NinteiKanryoJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定完了情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public NinteiKanryoJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5105NinteiKanryoJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new NinteiKanryoJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5105NinteiKanryoJohoEntity}より{@link NinteiKanryoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5105NinteiKanryoJohoEntity}
     */
    public NinteiKanryoJoho(DbT5105NinteiKanryoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報"));
        this.id = new NinteiKanryoJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5105NinteiKanryoJohoEntity}
     * @param id {@link NinteiKanryoJohoIdentifier}
     */
    NinteiKanryoJoho(
            DbT5105NinteiKanryoJohoEntity entity,
            NinteiKanryoJohoIdentifier id
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
     * 認定申請情報登録完了年月日を返します。
     *
     * @return 認定申請情報登録完了年月日
     */
    public FlexibleDate get認定申請情報登録完了年月日() {
        return entity.getNinteiShinseiJohoTorokuKanryoYMD();
    }

    /**
     * 認定調査依頼完了年月日を返します。
     *
     * @return 認定調査依頼完了年月日
     */
    public FlexibleDate get認定調査依頼完了年月日() {
        return entity.getNinteichosaIraiKanryoYMD();
    }

    /**
     * 認定調査完了年月日を返します。
     *
     * @return 認定調査完了年月日
     */
    public FlexibleDate get認定調査完了年月日() {
        return entity.getNinteichosaKanryoYMD();
    }

    /**
     * 主治医意見書作成依頼完了年月日を返します。
     *
     * @return 主治医意見書作成依頼完了年月日
     */
    public FlexibleDate get主治医意見書作成依頼完了年月日() {
        return entity.getIkenshoSakuseiIraiKanryoYMD();
    }

    /**
     * 主治医意見書登録完了年月日を返します。
     *
     * @return 主治医意見書登録完了年月日
     */
    public FlexibleDate get主治医意見書登録完了年月日() {
        return entity.getIkenshoTorokuKanryoYMD();
    }

    /**
     * 要介護認定一次判定完了年月日を返します。
     *
     * @return 要介護認定一次判定完了年月日
     */
    public FlexibleDate get要介護認定一次判定完了年月日() {
        return entity.getIchijiHanteiKanryoYMD();
    }

    /**
     * マスキング完了年月日を返します。
     *
     * @return マスキング完了年月日
     */
    public FlexibleDate getマスキング完了年月日() {
        return entity.getMaskingKanryoYMD();
    }

    /**
     * 認定審査会割当完了年月日を返します。
     *
     * @return 認定審査会割当完了年月日
     */
    public FlexibleDate get認定審査会割当完了年月日() {
        return entity.getNinteiShinsakaiWariateKanryoYMD();
    }

    /**
     * 認定審査会完了年月日を返します。
     *
     * @return 認定審査会完了年月日
     */
    public FlexibleDate get認定審査会完了年月日() {
        return entity.getNinteiShinsakaiKanryoYMD();
    }

    /**
     * センター送信年月日を返します。
     *
     * @return センター送信年月日
     */
    public FlexibleDate getセンター送信年月日() {
        return entity.getCenterSoshinYMD();
    }

    /**
     * {@link DbT5105NinteiKanryoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5105NinteiKanryoJohoEntity}のクローン
     */
    @Override
    public DbT5105NinteiKanryoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定完了情報の識別子{@link NinteiKanryoJohoIdentifier}を返します。
     *
     * @return 要介護認定完了情報の識別子{@link NinteiKanryoJohoIdentifier}
     */
    @Override
    public NinteiKanryoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定完了情報のみを変更対象とします。<br/> {@link DbT5105NinteiKanryoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteiKanryoJoho}
     */
    public NinteiKanryoJoho modifiedModel() {
        DbT5105NinteiKanryoJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteiKanryoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定完了情報を削除対象とします。<br/> {@link DbT5105NinteiKanryoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NinteiKanryoJoho}
     */
    @Override
    public NinteiKanryoJoho deleted() {
        DbT5105NinteiKanryoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteiKanryoJoho(deletedEntity, id);
    }

    /**
     * {@link NinteiKanryoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link NinteiKanryoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -3807720800415690896L;
        private final DbT5105NinteiKanryoJohoEntity entity;
        private final NinteiKanryoJohoIdentifier id;

        private _SerializationProxy(DbT5105NinteiKanryoJohoEntity entity, NinteiKanryoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NinteiKanryoJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NinteiKanryoJohoBuilder createBuilderForEdit() {
        return new NinteiKanryoJohoBuilder(entity, id);
    }
}
