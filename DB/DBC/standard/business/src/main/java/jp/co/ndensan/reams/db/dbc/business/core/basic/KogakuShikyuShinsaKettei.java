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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 事業高額介護サービス費支給審査決定を管理するクラスです。
 */
public class KogakuShikyuShinsaKettei extends ParentModelBase<KogakuShikyuShinsaKetteiIdentifier, DbT3112KogakuShikyuShinsaKetteiEntity, KogakuShikyuShinsaKettei> implements Serializable {

    private final DbT3112KogakuShikyuShinsaKetteiEntity entity;
    private final KogakuShikyuShinsaKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額介護サービス費支給審査決定の新規作成時に使用します。
     *
     * @param 決定者受取年月 決定者受取年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 通知書番号 通知書番号
     */
    public KogakuShikyuShinsaKettei(FlexibleYearMonth 決定者受取年月,
HokenshaNo 証記載保険者番号,
HihokenshaNo 被保険者番号,
FlexibleYearMonth サービス提供年月,
RString 通知書番号) {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        this.entity = new DbT3112KogakuShikyuShinsaKetteiEntity();
        this.entity.setKetteishaUketoriYM(決定者受取年月);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setTsuchishoNo(通知書番号);
        this.id = new KogakuShikyuShinsaKetteiIdentifier(
        決定者受取年月,
        証記載保険者番号,
        被保険者番号,
        サービス提供年月,
        通知書番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3112KogakuShikyuShinsaKetteiEntity}より{@link KogakuShikyuShinsaKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3112KogakuShikyuShinsaKetteiEntity}
     */
    public KogakuShikyuShinsaKettei(DbT3112KogakuShikyuShinsaKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給審査決定"));
        this.id = new KogakuShikyuShinsaKetteiIdentifier(
                entity.getKetteishaUketoriYM(),
                entity.getShoKisaiHokenshaNo(),
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getTsuchishoNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3112KogakuShikyuShinsaKetteiEntity}
     * @param id {@link KogakuShikyuShinsaKetteiIdentifier}
     */
    KogakuShikyuShinsaKettei(
            DbT3112KogakuShikyuShinsaKetteiEntity entity,
            KogakuShikyuShinsaKetteiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 決定者受取年月を返します。
     *
     * @return 決定者受取年月
     */
    public FlexibleYearMonth get決定者受取年月() {
        return entity.getKetteishaUketoriYM();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * 通知書番号を返します。
     *
     * @return 通知書番号
     */
    public RString get通知書番号() {
        return entity.getTsuchishoNo();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public Decimal get利用者負担額() {
        return entity.getRiyoshaFutanGaku();
    }

    /**
     * 支給区分コードを返します。
     *
     * @return 支給区分コード
     */
    public RString get支給区分コード() {
        return entity.getShikyuKubunCode();
    }

    /**
     * 決定年月を返します。
     *
     * @return 決定年月
     */
    public FlexibleYearMonth get決定年月() {
        return entity.getKetteiYM();
    }

    /**
     * 事業高額支給額を返します。
     *
     * @return 事業高額支給額
     */
    public Decimal get事業高額支給額() {
        return entity.getJigyoKogakuShikyuGaku();
    }

    /**
     * {@link DbT3112KogakuShikyuShinsaKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3112KogakuShikyuShinsaKetteiEntity}のクローン
     */
    @Override
    public DbT3112KogakuShikyuShinsaKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額介護サービス費支給審査決定の識別子{@link KogakuShikyuShinsaKetteiIdentifier}を返します。
     *
     * @return 事業高額介護サービス費支給審査決定の識別子{@link KogakuShikyuShinsaKetteiIdentifier}
     */
    @Override
    public KogakuShikyuShinsaKetteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 事業高額介護サービス費支給審査決定のみを変更対象とします。<br/>
     * {@link DbT3112KogakuShikyuShinsaKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KogakuShikyuShinsaKettei}
     */
    @Override
    public KogakuShikyuShinsaKettei modifiedModel() {
        DbT3112KogakuShikyuShinsaKetteiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KogakuShikyuShinsaKettei(
                modifiedEntity, id);
    }

    /**
     * 保持する事業高額介護サービス費支給審査決定を削除対象とします。<br/>
     * {@link DbT3112KogakuShikyuShinsaKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuShikyuShinsaKettei}
     */
    @Override
    public KogakuShikyuShinsaKettei deleted() {
        DbT3112KogakuShikyuShinsaKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuShikyuShinsaKettei(deletedEntity, id);
    }
    /**
     * {@link KogakuShikyuShinsaKettei}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuShikyuShinsaKettei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3112KogakuShikyuShinsaKetteiEntity entity;
        private final KogakuShikyuShinsaKetteiIdentifier id;

        private _SerializationProxy(DbT3112KogakuShikyuShinsaKetteiEntity entity,KogakuShikyuShinsaKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuShikyuShinsaKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuShikyuShinsaKetteiBuilder createBuilderForEdit() {
        return new KogakuShikyuShinsaKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
