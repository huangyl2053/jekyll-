/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成合計を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakuseiGokei
        extends ModelBase<KyotakuKeikakuJikoSakuseiGokeiIdentifier, DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity, KyotakuKeikakuJikoSakuseiGokei>
        implements Serializable {

    private final DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity;
    private final KyotakuKeikakuJikoSakuseiGokeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画自己作成合計の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     */
    public KyotakuKeikakuJikoSakuseiGokei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        this.entity = new DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setKyotakuServiceKubun(居宅サービス区分);
        this.entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.id = new KyotakuKeikakuJikoSakuseiGokeiIdentifier(
                被保険者番号,
                対象年月,
                履歴番号,
                居宅サービス区分,
                サービス提供事業者番号,
                サービス種類コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}より{@link KyotakuKeikakuJikoSakuseiGokei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}
     */
    public KyotakuKeikakuJikoSakuseiGokei(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成合計"));
        this.id = new KyotakuKeikakuJikoSakuseiGokeiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo(),
                entity.getKyotakuServiceKubun(),
                entity.getServiceTeikyoJigyoshaNo(),
                entity.getServiceShuruiCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiGokeiIdentifier}
     */
    KyotakuKeikakuJikoSakuseiGokei(
            DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity,
            KyotakuKeikakuJikoSakuseiGokeiIdentifier id
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
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 居宅サービス区分を返します。
     *
     * @return 居宅サービス区分
     */
    public RString get居宅サービス区分() {
        return entity.getKyotakuServiceKubun();
    }

    /**
     * サービス提供事業者番号を返します。
     *
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getサービス提供事業者番号() {
        return entity.getServiceTeikyoJigyoshaNo();
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
     * 給付計画単位数を返します。
     *
     * @return 給付計画単位数
     */
    public Decimal get給付計画単位数() {
        return entity.getKyufuKeikakuTaniSu();
    }

    /**
     * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}のクローンを返します。
     *
     * @return {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}のクローン
     */
    @Override
    public DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画自己作成合計の識別子{@link KyotakuKeikakuJikoSakuseiGokeiIdentifier}を返します。
     *
     * @return 居宅給付計画自己作成合計の識別子{@link KyotakuKeikakuJikoSakuseiGokeiIdentifier}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiGokeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 居宅給付計画自己作成合計のみを変更対象とします。<br/>
     * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuJikoSakuseiGokei}
     */
    public KyotakuKeikakuJikoSakuseiGokei modifiedModel() {
        DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuJikoSakuseiGokei(
                modifiedEntity, id);
    }

    /**
     * 保持する居宅給付計画自己作成合計を削除対象とします。<br/>
     * {@link DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJikoSakuseiGokei}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiGokei deleted() {
        DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJikoSakuseiGokei(deletedEntity, id);
    }

    /**
     * {@link KyotakuKeikakuJikoSakuseiGokei}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiGokei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -8445548362966281844L;
        private final DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity;
        private final KyotakuKeikakuJikoSakuseiGokeiIdentifier id;

        private _SerializationProxy(DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity entity, KyotakuKeikakuJikoSakuseiGokeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJikoSakuseiGokei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyotakuKeikakuJikoSakuseiGokeiBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJikoSakuseiGokeiBuilder(entity, id);
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
        final KyotakuKeikakuJikoSakuseiGokei other = (KyotakuKeikakuJikoSakuseiGokei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
