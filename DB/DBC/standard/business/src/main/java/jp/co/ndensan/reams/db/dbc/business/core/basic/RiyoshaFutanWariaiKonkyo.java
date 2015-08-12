/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担割合世帯員を管理するクラスです。
 */
public class RiyoshaFutanWariaiKonkyo extends ParentModelBase<RiyoshaFutanWariaiKonkyoIdentifier, DbT3115RiyoshaFutanWariaiKonkyoEntity, RiyoshaFutanWariaiKonkyo> implements Serializable {

    private final DbT3115RiyoshaFutanWariaiKonkyoEntity entity;
    private final RiyoshaFutanWariaiKonkyoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 利用者負担割合世帯員の新規作成時に使用します。
     *
     * @param 年度 年度
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param 枝番号 枝番号
     * @param 世帯員被保険者番号 世帯員被保険者番号
     */
    public RiyoshaFutanWariaiKonkyo(FlexibleYear 年度,
HihokenshaNo 被保険者番号,
Decimal 履歴番号,
Decimal 枝番号,
HihokenshaNo 世帯員被保険者番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        requireNonNull(世帯員被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員被保険者番号"));
        this.entity = new DbT3115RiyoshaFutanWariaiKonkyoEntity();
        this.entity.setNendo(年度);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setEdaNo(枝番号);
        this.entity.setSetaiinHihokenshaNo(世帯員被保険者番号);
        this.id = new RiyoshaFutanWariaiKonkyoIdentifier(
        年度,
        被保険者番号,
        履歴番号,
        枝番号,
        世帯員被保険者番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3115RiyoshaFutanWariaiKonkyoEntity}より{@link RiyoshaFutanWariaiKonkyo}を生成します。
     *
     * @param entity DBより取得した{@link DbT3115RiyoshaFutanWariaiKonkyoEntity}
     */
    public RiyoshaFutanWariaiKonkyo(DbT3115RiyoshaFutanWariaiKonkyoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合世帯員"));
        this.id = new RiyoshaFutanWariaiKonkyoIdentifier(
                entity.getNendo(),
                entity.getHihokenshaNo(),
                entity.getRirekiNo(),
                entity.getEdaNo(),
                entity.getSetaiinHihokenshaNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}
     * @param id {@link RiyoshaFutanWariaiKonkyoIdentifier}
     */
    RiyoshaFutanWariaiKonkyo(
            DbT3115RiyoshaFutanWariaiKonkyoEntity entity,
            RiyoshaFutanWariaiKonkyoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 年度を返します。
     *
     * @return 年度
     */
    public FlexibleYear get年度() {
        return entity.getNendo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 枝番号を返します。
     *
     * @return 枝番号
     */
    public Decimal get枝番号() {
        return entity.getEdaNo();
    }

    /**
     * 世帯員被保険者番号を返します。
     *
     * @return 世帯員被保険者番号
     */
    public HihokenshaNo get世帯員被保険者番号() {
        return entity.getSetaiinHihokenshaNo();
    }

    /**
     * 世帯員所得履歴番号を返します。
     *
     * @return 世帯員所得履歴番号
     */
    public Decimal get世帯員所得履歴番号() {
        return entity.getSetaiinShotokuRirekiNo();
    }

    /**
     * {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}のクローンを返します。
     *
     * @return {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}のクローン
     */
    @Override
    public DbT3115RiyoshaFutanWariaiKonkyoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 利用者負担割合世帯員の識別子{@link RiyoshaFutanWariaiKonkyoIdentifier}を返します。
     *
     * @return 利用者負担割合世帯員の識別子{@link RiyoshaFutanWariaiKonkyoIdentifier}
     */
    @Override
    public RiyoshaFutanWariaiKonkyoIdentifier identifier() {
        return this.id;
    }

    /**
     * 利用者負担割合世帯員のみを変更対象とします。<br/>
     * {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RiyoshaFutanWariaiKonkyo}
     */
    @Override
    public RiyoshaFutanWariaiKonkyo modifiedModel() {
        DbT3115RiyoshaFutanWariaiKonkyoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RiyoshaFutanWariaiKonkyo(
                modifiedEntity, id);
    }

    /**
     * 保持する利用者負担割合世帯員を削除対象とします。<br/>
     * {@link DbT3115RiyoshaFutanWariaiKonkyoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RiyoshaFutanWariaiKonkyo}
     */
    @Override
    public RiyoshaFutanWariaiKonkyo deleted() {
        DbT3115RiyoshaFutanWariaiKonkyoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RiyoshaFutanWariaiKonkyo(deletedEntity, id);
    }
    /**
     * {@link RiyoshaFutanWariaiKonkyo}のシリアライズ形式を提供します。
     *
     * @return {@link RiyoshaFutanWariaiKonkyo}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3115RiyoshaFutanWariaiKonkyoEntity entity;
        private final RiyoshaFutanWariaiKonkyoIdentifier id;

        private _SerializationProxy(DbT3115RiyoshaFutanWariaiKonkyoEntity entity,RiyoshaFutanWariaiKonkyoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new RiyoshaFutanWariaiKonkyo(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RiyoshaFutanWariaiKonkyoBuilder createBuilderForEdit() {
        return new RiyoshaFutanWariaiKonkyoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
