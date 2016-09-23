/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4123NinteiKeikakuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定計画情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
public class DbT4123NinteiKeikakuJoho extends
        ParentModelBase<DbT4123NinteiKeikakuJohoIdentifier, DbT4123NinteiKeikakuJohoEntity, DbT4123NinteiKeikakuJoho>
        implements Serializable {

    private static final long serialVersionUID = 3652134541226565259L;
    private final DbT4123NinteiKeikakuJohoEntity entity;
    private final DbT4123NinteiKeikakuJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定計画情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public DbT4123NinteiKeikakuJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT4123NinteiKeikakuJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new DbT4123NinteiKeikakuJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4123NinteiKeikakuJohoEntity}より{@link DbT4123NinteiKeikakuJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4123NinteiKeikakuJohoEntity}
     */
    public DbT4123NinteiKeikakuJoho(DbT4123NinteiKeikakuJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定計画情報"));
        this.id = new DbT4123NinteiKeikakuJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4123NinteiKeikakuJohoEntity}
     * @param id {@link DbT4123NinteiKeikakuJohoIdentifier}
     */
    DbT4123NinteiKeikakuJoho(
            DbT4123NinteiKeikakuJohoEntity entity,
            DbT4123NinteiKeikakuJohoIdentifier id
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
     * 認定調査依頼予定年月日を返します。
     *
     * @return 認定調査依頼予定年月日
     */
    public FlexibleDate get認定調査依頼予定年月日() {
        return entity.getNinteichosaIraiYoteiYMD();
    }

    /**
     * 認定調査予定年月日を返します。
     *
     * @return 認定調査予定年月日
     */
    public FlexibleDate get認定調査予定年月日() {
        return entity.getNinteichosaYoteiYMD();
    }

    /**
     * 主治医意見書作成依頼予定年月日を返します。
     *
     * @return 主治医意見書作成依頼予定年月日
     */
    public FlexibleDate get主治医意見書作成依頼予定年月日() {
        return entity.getIkenshoSakuseiIraiYoteiYMD();
    }

    /**
     * 主治医意見書登録予定年月日を返します。
     *
     * @return 主治医意見書登録予定年月日
     */
    public FlexibleDate get主治医意見書登録予定年月日() {
        return entity.getIkenshoTorokuYoteiYMD();
    }

    /**
     * 要介護認定一次判定予定年月日を返します。
     *
     * @return 要介護認定一次判定予定年月日
     */
    public FlexibleDate get要介護認定一次判定予定年月日() {
        return entity.getIchijiHanteiYoteiYMD();
    }

    /**
     * 認定審査会割当予定年月日を返します。
     *
     * @return 認定審査会割当予定年月日
     */
    public FlexibleDate get認定審査会割当予定年月日() {
        return entity.getNinteiShinsakaiWariateYoteiYMD();
    }

    /**
     * 認定審査会予定年月日を返します。
     *
     * @return 認定審査会予定年月日
     */
    public FlexibleDate get認定審査会予定年月日() {
        return entity.getNinteiShinsakaiYoteiYMD();
    }

    /**
     * センター送信予定年月日を返します。
     *
     * @return センター送信予定年月日
     */
    public FlexibleDate getセンター送信予定年月日() {
        return entity.getCenterSoshinYoteiYMD();
    }

    /**
     * {@link DbT4123NinteiKeikakuJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4123NinteiKeikakuJohoEntity}のクローン
     */
    @Override
    public DbT4123NinteiKeikakuJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定計画情報の識別子{@link DbT4123NinteiKeikakuJohoIdentifier}を返します。
     *
     * @return 要介護認定計画情報の識別子{@link DbT4123NinteiKeikakuJohoIdentifier}
     */
    @Override
    public DbT4123NinteiKeikakuJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定計画情報のみを変更対象とします。<br/>
     * {@link DbT4123NinteiKeikakuJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4123NinteiKeikakuJoho}
     */
    @Override
    public DbT4123NinteiKeikakuJoho modifiedModel() {
        DbT4123NinteiKeikakuJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4123NinteiKeikakuJoho(
                modifiedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する要介護認定計画情報を削除対象とします。<br/>
     * {@link DbT4123NinteiKeikakuJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4123NinteiKeikakuJoho}
     */
    @Override
    public DbT4123NinteiKeikakuJoho deleted() {
        DbT4123NinteiKeikakuJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4123NinteiKeikakuJoho(deletedEntity, id);
    }

    /**
     * {@link DbT4123NinteiKeikakuJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4123NinteiKeikakuJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4123NinteiKeikakuJohoEntity entity;
        private final DbT4123NinteiKeikakuJohoIdentifier id;

        private _SerializationProxy(DbT4123NinteiKeikakuJohoEntity entity, DbT4123NinteiKeikakuJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4123NinteiKeikakuJoho(this.entity, this.id);
        }
        private static final long serialVersionUID = -6568617313939526805L;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4123NinteiKeikakuJohoBuilder createBuilderForEdit() {
        return new DbT4123NinteiKeikakuJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
