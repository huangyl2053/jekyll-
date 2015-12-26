/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成短期入所利用日数を管理するクラスです。
 */
public class KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu extends 
        ModelBase<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, 
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity, 
        KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> implements Serializable {

    private final DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity;
    private final KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画自己作成短期入所利用日数の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier(
                被保険者番号,
                対象年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}より{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成短期入所利用日数"));
        this.id = new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}
     * @param id {@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}
     */
    KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(
            DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity,
            KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id
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
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}のクローンを返します。
     *
     * @return
     * {@link DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity}のクローン
     */
    @Override
    public DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画自己作成短期入所利用日数の識別子{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}を返します。
     *
     * @return
     * 居宅給付計画自己作成短期入所利用日数の識別子{@link KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier}
     */
    @Override
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier identifier() {
        return this.id;
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
            //TODO メッセージの検討
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

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

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
