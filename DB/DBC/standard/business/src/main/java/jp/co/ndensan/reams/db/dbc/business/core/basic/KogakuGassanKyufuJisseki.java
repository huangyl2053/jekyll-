/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算給付実績を管理するクラスです。
 */
public class KogakuGassanKyufuJisseki extends ModelBase<KogakuGassanKyufuJissekiIdentifier, DbT3075KogakuGassanKyufuJissekiEntity, KogakuGassanKyufuJisseki> implements Serializable {

    private final DbT3075KogakuGassanKyufuJissekiEntity entity;
    private final KogakuGassanKyufuJissekiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算給付実績の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 被保険者番号 被保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanKyufuJisseki(KokanShikibetsuNo 交換情報識別番号,
            HihokenshaNo 被保険者番号,
            RString 支給申請書整理番号,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3075KogakuGassanKyufuJissekiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setShikyuShinseiSeiriNo(支給申請書整理番号);
        this.entity.setSeiriNo(整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanKyufuJissekiIdentifier(
                交換情報識別番号,
                被保険者番号,
                支給申請書整理番号,
                整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3075KogakuGassanKyufuJissekiEntity}より{@link KogakuGassanKyufuJisseki}を生成します。
     *
     * @param entity DBより取得した{@link DbT3075KogakuGassanKyufuJissekiEntity}
     */
    public KogakuGassanKyufuJisseki(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算給付実績"));
        this.id = new KogakuGassanKyufuJissekiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getHihokenshaNo(),
                entity.getShikyuShinseiSeiriNo(),
                entity.getSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3075KogakuGassanKyufuJissekiEntity}
     * @param id {@link KogakuGassanKyufuJissekiIdentifier}
     */
    KogakuGassanKyufuJisseki(
            DbT3075KogakuGassanKyufuJissekiEntity entity,
            KogakuGassanKyufuJissekiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
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
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseiSeiriNo();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
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
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanSeiriNo();
    }

    /**
     * 保険制度コードを返します。
     *
     * @return 保険制度コード
     */
    public RString get保険制度コード() {
        return entity.getHokenSeidoCode();
    }

    /**
     * 給付実績作成区分コードを返します。
     *
     * @return 給付実績作成区分コード
     */
    public RString get給付実績作成区分コード() {
        return entity.getKyufuJissekiSakuseiKubunCode();
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
     * 国保 被保険者証記号を返します。
     *
     * @return 国保 被保険者証記号
     */
    public RString get国保_被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
    }

    /**
     * 自己負担総額を返します。
     *
     * @return 自己負担総額
     */
    public Decimal get自己負担総額() {
        return entity.getJikoFutanSogaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public Decimal get支給額() {
        return entity.getShikyuGaku();
    }

    /**
     * 処理年月を返します。
     *
     * @return 処理年月
     */
    public FlexibleYearMonth get処理年月() {
        return entity.getShoriYM();
    }

    /**
     * 受取年月を返します。
     *
     * @return 受取年月
     */
    public FlexibleYearMonth get受取年月() {
        return entity.getUketoriYM();
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
     * データ区分を返します。
     *
     * @return データ区分
     */
    public RString getデータ区分() {
        return entity.getDataKubun();
    }

    /**
     * {@link DbT3075KogakuGassanKyufuJissekiEntity}のクローンを返します。
     *
     * @return {@link DbT3075KogakuGassanKyufuJissekiEntity}のクローン
     */
    @Override
    public DbT3075KogakuGassanKyufuJissekiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算給付実績の識別子{@link KogakuGassanKyufuJissekiIdentifier}を返します。
     *
     * @return 高額合算給付実績の識別子{@link KogakuGassanKyufuJissekiIdentifier}
     */
    @Override
    public KogakuGassanKyufuJissekiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算給付実績を削除対象とします。<br/>
     * {@link DbT3075KogakuGassanKyufuJissekiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanKyufuJisseki}
     */
    @Override
    public KogakuGassanKyufuJisseki deleted() {
        DbT3075KogakuGassanKyufuJissekiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanKyufuJisseki(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanKyufuJisseki}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanKyufuJisseki}のシリアライズ形式
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

        private final DbT3075KogakuGassanKyufuJissekiEntity entity;
        private final KogakuGassanKyufuJissekiIdentifier id;

        private _SerializationProxy(DbT3075KogakuGassanKyufuJissekiEntity entity, KogakuGassanKyufuJissekiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanKyufuJisseki(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanKyufuJissekiBuilder createBuilderForEdit() {
        return new KogakuGassanKyufuJissekiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
