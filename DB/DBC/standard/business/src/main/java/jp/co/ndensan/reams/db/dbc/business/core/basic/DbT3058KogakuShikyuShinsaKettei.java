/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3058KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額介護サービス費支給審査決定を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 quxiaodong
 */
public class DbT3058KogakuShikyuShinsaKettei
        extends ParentModelBase<DbT3058KogakuShikyuShinsaKetteiIdentifier, DbT3058KogakuShikyuShinsaKetteiEntity, DbT3058KogakuShikyuShinsaKettei>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT3058KogakuShikyuShinsaKetteiEntity entity;
    private final DbT3058KogakuShikyuShinsaKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額介護サービス費支給審査決定の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 履歴番号 履歴番号
     */
    public DbT3058KogakuShikyuShinsaKettei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3058KogakuShikyuShinsaKetteiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new DbT3058KogakuShikyuShinsaKetteiIdentifier(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3058KogakuShikyuShinsaKetteiEntity}より{@link DbT3058KogakuShikyuShinsaKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3058KogakuShikyuShinsaKetteiEntity}
     */
    public DbT3058KogakuShikyuShinsaKettei(DbT3058KogakuShikyuShinsaKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費支給審査決定"));
        this.id = new DbT3058KogakuShikyuShinsaKetteiIdentifier(
                entity.getHihokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getShoKisaiHokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3058KogakuShikyuShinsaKetteiEntity}
     * @param id {@link DbT3058KogakuShikyuShinsaKetteiIdentifier}
     */
    DbT3058KogakuShikyuShinsaKettei(
            DbT3058KogakuShikyuShinsaKetteiEntity entity,
            DbT3058KogakuShikyuShinsaKetteiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 決定者受取年月を返します。
     *
     * @return 決定者受取年月
     */
    public FlexibleYearMonth get決定者受取年月() {
        return entity.getKetteishaUketoriYM();
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
     * 高額支給額を返します。
     *
     * @return 高額支給額
     */
    public Decimal get高額支給額() {
        return entity.getKogakuShikyuGaku();
    }

    /**
     * {@link DbT3058KogakuShikyuShinsaKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3058KogakuShikyuShinsaKetteiEntity}のクローン
     */
    @Override
    public DbT3058KogakuShikyuShinsaKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額介護サービス費支給審査決定の識別子{@link DbT3058KogakuShikyuShinsaKetteiIdentifier}を返します。
     *
     * @return 高額介護サービス費支給審査決定の識別子{@link DbT3058KogakuShikyuShinsaKetteiIdentifier}
     */
    @Override
    public DbT3058KogakuShikyuShinsaKetteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 高額介護サービス費支給審査決定のみを変更対象とします。<br/>
     * {@link DbT3058KogakuShikyuShinsaKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT3058KogakuShikyuShinsaKettei}
     */
    @Override
    public DbT3058KogakuShikyuShinsaKettei modifiedModel() {
        DbT3058KogakuShikyuShinsaKetteiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT3058KogakuShikyuShinsaKettei(
                modifiedEntity, id);
    }

    /**
     * 保持する高額介護サービス費支給審査決定を削除対象とします。<br/>
     * {@link DbT3058KogakuShikyuShinsaKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT3058KogakuShikyuShinsaKettei}
     */
    @Override
    public DbT3058KogakuShikyuShinsaKettei deleted() {
        DbT3058KogakuShikyuShinsaKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT3058KogakuShikyuShinsaKettei(deletedEntity, id);
    }

    /**
     * {@link DbT3058KogakuShikyuShinsaKettei}のシリアライズ形式を提供します。
     *
     * @return {@link DbT3058KogakuShikyuShinsaKettei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT3058KogakuShikyuShinsaKetteiEntity entity;
        private final DbT3058KogakuShikyuShinsaKetteiIdentifier id;

        private _SerializationProxy(DbT3058KogakuShikyuShinsaKetteiEntity entity, DbT3058KogakuShikyuShinsaKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT3058KogakuShikyuShinsaKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT3058KogakuShikyuShinsaKetteiBuilder createBuilderForEdit() {
        return new DbT3058KogakuShikyuShinsaKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
