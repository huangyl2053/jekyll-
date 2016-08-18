/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeika;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成短期入所利用日数を管理するクラスです。
 *
 * @reamsid_L DBC-9999-011 sunhaidi
 */
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu extends
        ModelBase<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier,
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity,
        KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu>
        implements Serializable {

    private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity;
    private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画自己作成短期入所利用日数の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 利用年月 利用年月
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(利用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("利用年月"));
        this.entity = new DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setRiyoYM(利用年月);
        this.id = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier(
                被保険者番号,
                対象年月,
                履歴番号,
                利用年月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}より{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}を生成します。
     *
     * @param entity DBより取得した{@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成短期入所利用日数"));
        this.id = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo(),
                entity.getRiyoYM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}
     */
    KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity,
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id
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
     * 利用年月を返します。
     *
     * @return 利用年月
     */
    public FlexibleYearMonth get利用年月() {
        return entity.getRiyoYM();
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
     * 暫定区分を返します。
     *
     * @return 暫定区分
     */
    public RString get暫定区分() {
        return entity.getZanteiKubun();
    }

    /**
     * 更新区分を返します。
     *
     * @return 更新区分
     */
    public RString get更新区分() {
        return entity.getKoshinKubun();
    }

    /**
     * 更新年月日を返します。
     *
     * @return 更新年月日
     */
    public FlexibleDate get更新年月日() {
        return entity.getKoshinYMD();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}のクローンを返します。
     *
     * @return {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}のクローン
     */
    @Override
    public DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数の識別子{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}を返します。
     *
     * @return 居宅給付計画自己作成短期入所利用日数の識別子{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier identifier() {
        return this.id;
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数のみを変更対象とします。<br/>
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu modifiedModel() {
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(
                modifiedEntity, id);
    }

    /**
     * 保持する居宅給付計画自己作成短期入所利用日数を削除対象とします。<br/>
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu deleted() {
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(deletedEntity, id);
    }

    /**
     * {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 2421431021674102544L;
        private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity;
        private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id;

        private _SerializationProxy(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity,
                KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuBuilder(entity, id);
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
        final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu other = (KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
