/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbV3104KokuhorenTorikomiJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 国保連取り込み情報を管理するクラスです。
 */
public class KokuhorenTorikomiJoho extends ParentModelBase<KokuhorenTorikomiJohoIdentifier, DbV3104KokuhorenTorikomiJohoEntity, KokuhorenTorikomiJoho> implements Serializable {

    private final DbV3104KokuhorenTorikomiJohoEntity entity;
    private final KokuhorenTorikomiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 国保連取り込み情報の新規作成時に使用します。
     *
     * @param 処理年月 処理年月
     * @param 交換情報識別番号 交換情報識別番号
     */
    public KokuhorenTorikomiJoho(FlexibleYearMonth 処理年月,
            RString 交換情報識別番号) {
        requireNonNull(処理年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年月"));
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        this.entity = new DbV3104KokuhorenTorikomiJohoEntity();
        this.entity.setShoriYM(処理年月);
        this.entity.setKokanShikibetsuNo(交換情報識別番号);
        this.id = new KokuhorenTorikomiJohoIdentifier(
                処理年月,
                交換情報識別番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV3104KokuhorenTorikomiJohoEntity}より{@link KokuhorenTorikomiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbV3104KokuhorenTorikomiJohoEntity}
     */
    public KokuhorenTorikomiJoho(DbV3104KokuhorenTorikomiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("国保連取り込み情報"));
        this.id = new KokuhorenTorikomiJohoIdentifier(
                entity.getShoriYM(),
                entity.getKokanShikibetsuNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV3104KokuhorenTorikomiJohoEntity}
     * @param id {@link KokuhorenTorikomiJohoIdentifier}
     */
    KokuhorenTorikomiJoho(
            DbV3104KokuhorenTorikomiJohoEntity entity,
            KokuhorenTorikomiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public RString get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 処理状態区分を返します。
     *
     * @return 処理状態区分
     */
    public RString get処理状態区分() {
        return entity.getShoriJotaiKubun();
    }

    /**
     * 前_処理状態区分を返します。
     *
     * @return 前_処理状態区分
     */
    public RString get前_処理状態区分() {
        return entity.getZen_shorijotaikubun();
    }

    /**
     * 前々_処理状態区分を返します。
     *
     * @return 前々_処理状態区分
     */
    public RString get前々_処理状態区分() {
        return entity.getZenzen_shorijotaikubun();
    }

    /**
     * 処理実施日時を返します。
     *
     * @return 処理実施日時
     */
    public YMDHMS get処理実施日時() {
        return entity.getTougetsushoridate();
    }

    /**
     * 再処理可能区分を返します。
     *
     * @return 再処理可能区分
     */
    public boolean get再処理可能区分() {
        return entity.getSaiShoriKahiKubun();
    }

    /**
     * {@link DbV3104KokuhorenTorikomiJohoEntity}のクローンを返します。
     *
     * @return {@link DbV3104KokuhorenTorikomiJohoEntity}のクローン
     */
    @Override
    public DbV3104KokuhorenTorikomiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 国保連取り込み情報の識別子{@link KokuhorenTorikomiJohoIdentifier}を返します。
     *
     * @return 国保連取り込み情報の識別子{@link KokuhorenTorikomiJohoIdentifier}
     */
    @Override
    public KokuhorenTorikomiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 国保連取り込み情報のみを変更対象とします。<br/>
     * {@link DbV3104KokuhorenTorikomiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KokuhorenTorikomiJoho}
     */
    @Override
    public KokuhorenTorikomiJoho modifiedModel() {
        DbV3104KokuhorenTorikomiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KokuhorenTorikomiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する国保連取り込み情報を削除対象とします。<br/>
     * {@link DbV3104KokuhorenTorikomiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KokuhorenTorikomiJoho}
     */
    @Override
    public KokuhorenTorikomiJoho deleted() {
        DbV3104KokuhorenTorikomiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KokuhorenTorikomiJoho(deletedEntity, id);
    }

    /**
     * {@link KokuhorenTorikomiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link KokuhorenTorikomiJoho}のシリアライズ形式
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
        private final DbV3104KokuhorenTorikomiJohoEntity entity;
        private final KokuhorenTorikomiJohoIdentifier id;

        private _SerializationProxy(DbV3104KokuhorenTorikomiJohoEntity entity, KokuhorenTorikomiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KokuhorenTorikomiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KokuhorenTorikomiJohoBuilder createBuilderForEdit() {
        return new KokuhorenTorikomiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
