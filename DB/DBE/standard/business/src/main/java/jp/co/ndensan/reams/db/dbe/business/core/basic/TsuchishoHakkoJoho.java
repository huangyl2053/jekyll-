/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5122TsuchishoHakkoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 通知書発行情報を管理するクラスです。
 */
public class TsuchishoHakkoJoho extends ParentModelBase<TsuchishoHakkoJohoIdentifier, DbT5122TsuchishoHakkoJohoEntity, TsuchishoHakkoJoho> implements Serializable {

    private final DbT5122TsuchishoHakkoJohoEntity entity;
    private final TsuchishoHakkoJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 通知書発行情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public TsuchishoHakkoJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5122TsuchishoHakkoJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new TsuchishoHakkoJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5122TsuchishoHakkoJohoEntity}より{@link TsuchishoHakkoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5122TsuchishoHakkoJohoEntity}
     */
    public TsuchishoHakkoJoho(DbT5122TsuchishoHakkoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書発行情報"));
        this.id = new TsuchishoHakkoJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5122TsuchishoHakkoJohoEntity}
     * @param id {@link TsuchishoHakkoJohoIdentifier}
     */
    TsuchishoHakkoJoho(
            DbT5122TsuchishoHakkoJohoEntity entity,
            TsuchishoHakkoJohoIdentifier id
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
     * 通知区分を返します。
     *
     * @return 通知区分
     */
    public Code get通知区分() {
        return entity.getTsuchiKubun();
    }

    /**
     * 通知理由を返します。
     *
     * @return 通知理由
     */
    public RString get通知理由() {
        return entity.getTsuchiRiyu();
    }

    /**
     * 通知年月日を返します。
     *
     * @return 通知年月日
     */
    public FlexibleDate get通知年月日() {
        return entity.getTsuchiYMD();
    }

    /**
     * 通知開始年月日を返します。
     *
     * @return 通知開始年月日
     */
    public FlexibleDate get通知開始年月日() {
        return entity.getTsuchiKaishiYMD();
    }

    /**
     * 通知終了年月日を返します。
     *
     * @return 通知終了年月日
     */
    public FlexibleDate get通知終了年月日() {
        return entity.getTsuchiShuryoYMD();
    }

    /**
     * 通知区分期限を返します。
     *
     * @return 通知区分期限
     */
    public FlexibleDate get通知区分期限() {
        return entity.getTsuchiKubunKigenYMD();
    }

    /**
     * 通知完了年月日を返します。
     *
     * @return 通知完了年月日
     */
    public FlexibleDate get通知完了年月日() {
        return entity.getTsuchiKanryoYMD();
    }

    /**
     * {@link DbT5122TsuchishoHakkoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5122TsuchishoHakkoJohoEntity}のクローン
     */
    @Override
    public DbT5122TsuchishoHakkoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 通知書発行情報の識別子{@link TsuchishoHakkoJohoIdentifier}を返します。
     *
     * @return 通知書発行情報の識別子{@link TsuchishoHakkoJohoIdentifier}
     */
    @Override
    public TsuchishoHakkoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 通知書発行情報のみを変更対象とします。<br/>
     * {@link DbT5122TsuchishoHakkoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TsuchishoHakkoJoho}
     */
    @Override
    public TsuchishoHakkoJoho modifiedModel() {
        DbT5122TsuchishoHakkoJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TsuchishoHakkoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する通知書発行情報を削除対象とします。<br/>
     * {@link DbT5122TsuchishoHakkoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TsuchishoHakkoJoho}
     */
    @Override
    public TsuchishoHakkoJoho deleted() {
        DbT5122TsuchishoHakkoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TsuchishoHakkoJoho(deletedEntity, id);
    }

    /**
     * {@link TsuchishoHakkoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link TsuchishoHakkoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbT5122TsuchishoHakkoJohoEntity entity;
        private final TsuchishoHakkoJohoIdentifier id;

        private _SerializationProxy(DbT5122TsuchishoHakkoJohoEntity entity, TsuchishoHakkoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TsuchishoHakkoJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TsuchishoHakkoJohoBuilder createBuilderForEdit() {
        return new TsuchishoHakkoJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
