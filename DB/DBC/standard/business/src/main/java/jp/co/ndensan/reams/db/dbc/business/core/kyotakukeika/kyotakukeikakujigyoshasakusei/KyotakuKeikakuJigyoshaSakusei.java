/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujigyoshasakusei;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画事業者作成を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJigyoshaSakusei
        extends ModelBase<KyotakuKeikakuJigyoshaSakuseiIdentifier, DbT3006KyotakuKeikakuJigyoshaSakuseiEntity, KyotakuKeikakuJigyoshaSakusei>
        implements Serializable {

    private final DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity;
    private final KyotakuKeikakuJigyoshaSakuseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画事業者作成の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuJigyoshaSakusei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyotakuKeikakuJigyoshaSakuseiIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}より{@link KyotakuKeikakuJigyoshaSakusei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}
     */
    public KyotakuKeikakuJigyoshaSakusei(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画事業者作成"));
        this.id = new KyotakuKeikakuJigyoshaSakuseiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}
     * @param id {@link KyotakuKeikakuJigyoshaSakuseiIdentifier}
     */
    KyotakuKeikakuJigyoshaSakusei(
            DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity,
            KyotakuKeikakuJigyoshaSakuseiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
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
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 作成区分コードを返します。
     *
     * @return 作成区分コード
     */
    public RString get作成区分コード() {
        return entity.getSakuseiKubunCode();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 計画事業者番号を返します。
     *
     * @return 計画事業者番号
     */
    public JigyoshaNo get計画事業者番号() {
        return entity.getKeikakuJigyoshaNo();
    }

    /**
     * 委託先事業者番号を返します。
     *
     * @return 委託先事業者番号
     */
    public JigyoshaNo get委託先事業者番号() {
        return entity.getItakusakiJigyoshaNo();
    }

    /**
     * 事業者変更年月日を返します。
     *
     * @return 事業者変更年月日
     */
    public FlexibleDate get事業者変更年月日() {
        return entity.getJigyoshaHenkoYMD();
    }

    /**
     * 事業者変更事由を返します。
     *
     * @return 事業者変更事由
     */
    public RString get事業者変更事由() {
        return entity.getJigyoshaHenkoJiyu();
    }

    /**
     * {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}のクローンを返します。
     *
     * @return {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}のクローン
     */
    @Override
    public DbT3006KyotakuKeikakuJigyoshaSakuseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画事業者作成の識別子{@link KyotakuKeikakuJigyoshaSakuseiIdentifier}を返します。
     *
     * @return 居宅給付計画事業者作成の識別子{@link KyotakuKeikakuJigyoshaSakuseiIdentifier}
     */
    @Override
    public KyotakuKeikakuJigyoshaSakuseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 居宅給付計画事業者作成のみを変更対象とします。<br/>
     * {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuJigyoshaSakusei}
     */
    public KyotakuKeikakuJigyoshaSakusei modifiedModel() {
        DbT3006KyotakuKeikakuJigyoshaSakuseiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuJigyoshaSakusei(
                modifiedEntity, id);
    }

    /**
     * 保持する居宅給付計画事業者作成を削除対象とします。<br/>
     * {@link DbT3006KyotakuKeikakuJigyoshaSakuseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJigyoshaSakusei}
     */
    @Override
    public KyotakuKeikakuJigyoshaSakusei deleted() {
        DbT3006KyotakuKeikakuJigyoshaSakuseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJigyoshaSakusei(deletedEntity, id);
    }

    /**
     * {@link KyotakuKeikakuJigyoshaSakusei}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJigyoshaSakusei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 3149178731670083994L;
        private final DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity;
        private final KyotakuKeikakuJigyoshaSakuseiIdentifier id;

        private _SerializationProxy(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity entity, KyotakuKeikakuJigyoshaSakuseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJigyoshaSakusei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyotakuKeikakuJigyoshaSakuseiBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJigyoshaSakuseiBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KyotakuKeikakuJigyoshaSakusei other = (KyotakuKeikakuJigyoshaSakusei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
