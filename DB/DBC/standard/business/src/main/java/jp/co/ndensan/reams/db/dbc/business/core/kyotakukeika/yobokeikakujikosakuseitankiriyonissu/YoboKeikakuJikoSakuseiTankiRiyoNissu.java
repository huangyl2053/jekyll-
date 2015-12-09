/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 予防給付計画自己作成短期利用日数を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiTankiRiyoNissu
        extends ModelBase<YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier, DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity, YoboKeikakuJikoSakuseiTankiRiyoNissu>
        implements Serializable {

    private final DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity;
    private final YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 予防給付計画自己作成短期利用日数の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}より{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}を生成します。
     *
     * @param entity DBより取得した{@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissu(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成短期利用日数"));
        this.id = new YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}
     * @param id {@link YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier}
     */
    YoboKeikakuJikoSakuseiTankiRiyoNissu(
            DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity,
            YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id
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
     * 前回迄利用日数を返します。
     *
     * @return 前回迄利用日数
     */
    public Decimal get前回迄利用日数() {
        return entity.getZenkaiRiyoNissu();
    }

    /**
     * 今回計画利用日数を返します。
     *
     * @return 今回計画利用日数
     */
    public Decimal get今回計画利用日数() {
        return entity.getKonkaiKeikakuRiyoNissu();
    }

    /**
     * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}のクローンを返します。
     *
     * @return {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}のクローン
     */
    @Override
    public DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 予防給付計画自己作成短期利用日数の識別子{@link YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier}を返します。
     *
     * @return 予防給付計画自己作成短期利用日数の識別子{@link YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier}
     */
    @Override
    public YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier identifier() {
        return this.id;
    }

    /**
     * 予防給付計画自己作成短期利用日数のみを変更対象とします。<br/>
     * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissu modifiedModel() {
        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new YoboKeikakuJikoSakuseiTankiRiyoNissu(
                modifiedEntity, id);
    }

    /**
     * 保持する予防給付計画自己作成短期利用日数を削除対象とします。<br/>
     * {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}
     */
    @Override
    public YoboKeikakuJikoSakuseiTankiRiyoNissu deleted() {
        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new YoboKeikakuJikoSakuseiTankiRiyoNissu(deletedEntity, id);
    }

    /**
     * {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}のシリアライズ形式を提供します。
     *
     * @return {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -4345397884219421196L;
        private final DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity;
        private final YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id;

        private _SerializationProxy(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity, YoboKeikakuJikoSakuseiTankiRiyoNissuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new YoboKeikakuJikoSakuseiTankiRiyoNissu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder createBuilderForEdit() {
        return new YoboKeikakuJikoSakuseiTankiRiyoNissuBuilder(entity, id);
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
        final YoboKeikakuJikoSakuseiTankiRiyoNissu other = (YoboKeikakuJikoSakuseiTankiRiyoNissu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
