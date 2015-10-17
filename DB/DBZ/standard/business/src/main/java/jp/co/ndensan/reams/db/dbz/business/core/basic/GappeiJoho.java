/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7055GappeiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 合併情報を管理するクラスです。
 */
public class GappeiJoho extends ParentModelBase<GappeiJohoIdentifier, DbT7055GappeiJohoEntity, GappeiJoho> implements Serializable {

    private final DbT7055GappeiJohoEntity entity;
    private final GappeiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 合併情報の新規作成時に使用します。
     *
     * @param 合併年月日 合併年月日
     * @param 地域番号 地域番号
     */
    public GappeiJoho(FlexibleDate 合併年月日,
            RString 地域番号) {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        this.entity = new DbT7055GappeiJohoEntity();
        this.entity.setGappeiYMD(合併年月日);
        this.entity.setChiikiNo(地域番号);
        this.id = new GappeiJohoIdentifier(
                合併年月日,
                地域番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7055GappeiJohoEntity}より{@link GappeiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT7055GappeiJohoEntity}
     */
    public GappeiJoho(DbT7055GappeiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("合併情報"));
        this.id = new GappeiJohoIdentifier(
                entity.getGappeiYMD(),
                entity.getChiikiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7055GappeiJohoEntity}
     * @param id {@link GappeiJohoIdentifier}
     */
    GappeiJoho(
            DbT7055GappeiJohoEntity entity,
            GappeiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 合併年月日を返します。
     *
     * @return 合併年月日
     */
    public FlexibleDate get合併年月日() {
        return entity.getGappeiYMD();
    }

    /**
     * 地域番号を返します。
     *
     * @return 地域番号
     */
    public RString get地域番号() {
        return entity.getChiikiNo();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 合併種類を返します。
     *
     * @return 合併種類
     */
    public RString get合併種類() {
        return entity.getGappeiShurui();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 旧市町村情報付与終了年月日を返します。
     *
     * @return 旧市町村情報付与終了年月日
     */
    public FlexibleDate get旧市町村情報付与終了年月日() {
        return entity.getKyuJohoFuyoToYMD();
    }

    /**
     * 国保連データ連携開始年月日を返します。
     *
     * @return 国保連データ連携開始年月日
     */
    public FlexibleDate get国保連データ連携開始年月日() {
        return entity.getKokuhorenDataFromYMD();
    }

    /**
     * {@link DbT7055GappeiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT7055GappeiJohoEntity}のクローン
     */
    @Override
    public DbT7055GappeiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 合併情報の識別子{@link GappeiJohoIdentifier}を返します。
     *
     * @return 合併情報の識別子{@link GappeiJohoIdentifier}
     */
    @Override
    public GappeiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 合併情報のみを変更対象とします。<br/>
     * {@link DbT7055GappeiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link GappeiJoho}
     */
    @Override
    public GappeiJoho modifiedModel() {
        DbT7055GappeiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new GappeiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する合併情報を削除対象とします。<br/>
     * {@link DbT7055GappeiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link GappeiJoho}
     */
    @Override
    public GappeiJoho deleted() {
        DbT7055GappeiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new GappeiJoho(deletedEntity, id);
    }

    /**
     * {@link GappeiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link GappeiJoho}のシリアライズ形式
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
        private final DbT7055GappeiJohoEntity entity;
        private final GappeiJohoIdentifier id;

        private _SerializationProxy(DbT7055GappeiJohoEntity entity, GappeiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new GappeiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public GappeiJohoBuilder createBuilderForEdit() {
        return new GappeiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
