/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7109KubunShikyuGendoGakuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅サービス区分支給限度額を管理するクラスです。
 */
public class KubunShikyuGendoGaku extends
        ModelBase<KubunShikyuGendoGakuIdentifier, DbT7109KubunShikyuGendoGakuEntity, KubunShikyuGendoGaku>
        implements Serializable {

    private final DbT7109KubunShikyuGendoGakuEntity entity;
    private final KubunShikyuGendoGakuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅サービス区分支給限度額の新規作成時に使用します。
     *
     * @param 要介護状態区分 要介護状態区分
     * @param 適用開始年月 適用開始年月
     * @param 履歴番号 履歴番号
     */
    public KubunShikyuGendoGaku(RString 要介護状態区分,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) {
        requireNonNull(要介護状態区分, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護状態区分"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT7109KubunShikyuGendoGakuEntity();
        this.entity.setYoKaigoJotaiKubun(要介護状態区分);
        this.entity.setTekiyoKaishiYM(適用開始年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KubunShikyuGendoGakuIdentifier(
                要介護状態区分,
                適用開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT7109KubunShikyuGendoGakuEntity}より{@link KubunShikyuGendoGaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT7109KubunShikyuGendoGakuEntity}
     */
    public KubunShikyuGendoGaku(DbT7109KubunShikyuGendoGakuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分支給限度額"));
        this.id = new KubunShikyuGendoGakuIdentifier(
                entity.getYoKaigoJotaiKubun(),
                entity.getTekiyoKaishiYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT7109KubunShikyuGendoGakuEntity}
     * @param id {@link KubunShikyuGendoGakuIdentifier}
     */
    KubunShikyuGendoGaku(
            DbT7109KubunShikyuGendoGakuEntity entity,
            KubunShikyuGendoGakuIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 要介護状態区分を返します。
     *
     * @return 要介護状態区分
     */
    public RString get要介護状態区分() {
        return entity.getYoKaigoJotaiKubun();
    }

    /**
     * 適用開始年月を返します。
     *
     * @return 適用開始年月
     */
    public FlexibleYearMonth get適用開始年月() {
        return entity.getTekiyoKaishiYM();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 適用終了年月を返します。
     *
     * @return 適用終了年月
     */
    public FlexibleYearMonth get適用終了年月() {
        return entity.getTekiyoShuryoYM();
    }

    /**
     * 支給限度単位数を返します。
     *
     * @return 支給限度単位数
     */
    public Decimal get支給限度単位数() {
        return entity.getShikyuGendoTaniSu();
    }

    /**
     * {@link DbT7109KubunShikyuGendoGakuEntity}のクローンを返します。
     *
     * @return {@link DbT7109KubunShikyuGendoGakuEntity}のクローン
     */
    @Override
    public DbT7109KubunShikyuGendoGakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅サービス区分支給限度額の識別子{@link KubunShikyuGendoGakuIdentifier}を返します。
     *
     * @return 居宅サービス区分支給限度額の識別子{@link KubunShikyuGendoGakuIdentifier}
     */
    @Override
    public KubunShikyuGendoGakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する居宅サービス区分支給限度額を削除対象とします。<br/>
     * {@link DbT7109KubunShikyuGendoGakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KubunShikyuGendoGaku}
     */
    @Override
    public KubunShikyuGendoGaku deleted() {
        DbT7109KubunShikyuGendoGakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KubunShikyuGendoGaku(deletedEntity, id);
    }

    /**
     * {@link KubunShikyuGendoGaku}のシリアライズ形式を提供します。
     *
     * @return {@link KubunShikyuGendoGaku}のシリアライズ形式
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

        private final DbT7109KubunShikyuGendoGakuEntity entity;
        private final KubunShikyuGendoGakuIdentifier id;

        private _SerializationProxy(DbT7109KubunShikyuGendoGakuEntity entity, KubunShikyuGendoGakuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KubunShikyuGendoGaku(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KubunShikyuGendoGakuBuilder createBuilderForEdit() {
        return new KubunShikyuGendoGakuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
