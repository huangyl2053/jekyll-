/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3071KogakuGassanJikoFutanGakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算自己負担額明細を管理するクラスです。
 */
public class KogakuGassanJikoFutanGakuMeisai
        extends ModelBase<KogakuGassanJikoFutanGakuMeisaiIdentifier, DbT3071KogakuGassanJikoFutanGakuMeisaiEntity, KogakuGassanJikoFutanGakuMeisai>
        implements Serializable {

    private final DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity;
    private final KogakuGassanJikoFutanGakuMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算自己負担額明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 対象月 対象月
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanJikoFutanGakuMeisai(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            RString 対象月,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3071KogakuGassanJikoFutanGakuMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setTaishoM(対象月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanJikoFutanGakuMeisaiIdentifier(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                対象月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}より{@link KogakuGassanJikoFutanGakuMeisai}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}
     */
    public KogakuGassanJikoFutanGakuMeisai(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算自己負担額明細"));
        this.id = new KogakuGassanJikoFutanGakuMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getTaishoM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}
     * @param id {@link KogakuGassanJikoFutanGakuMeisaiIdentifier}
     */
    KogakuGassanJikoFutanGakuMeisai(
            DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity,
            KogakuGassanJikoFutanGakuMeisaiIdentifier id
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
        return entity.getHokenshaNo();
    }

    /**
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 対象月を返します。
     *
     * @return 対象月
     */
    public RString get対象月() {
        return entity.getTaishoM();
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
     * 自己負担額を返します。
     *
     * @return 自己負担額
     */
    public Decimal get自己負担額() {
        return entity.getJikoFutanGaku();
    }

    /**
     * 70_74自己負担額_内数を返します。
     *
     * @return 70_74自己負担額_内数
     */
    public Decimal get70_74自己負担額_内数() {
        return entity.getUchisu_70_74JikoFutanGaku();
    }

    /**
     * 70未満高額支給額を返します。
     *
     * @return 70未満高額支給額
     */
    public Decimal get70未満高額支給額() {
        return entity.getUnder_70KogakuShikyuGaku();
    }

    /**
     * 70_74高額支給額を返します。
     *
     * @return 70_74高額支給額
     */
    public Decimal get70_74高額支給額() {
        return entity.getOver_70_74KogakuShikyuGaku();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * 補正済_自己負担額を返します。
     *
     * @return 補正済_自己負担額
     */
    public Decimal get補正済_自己負担額() {
        return entity.getSumi_JikoFutanGaku();
    }

    /**
     * 補正済_70_74自己負担額_内数を返します。
     *
     * @return 補正済_70_74自己負担額_内数
     */
    public Decimal get補正済_70_74自己負担額_内数() {
        return entity.getSumi_70_74JikoFutanGaku();
    }

    /**
     * 補正済_70未満高額支給額を返します。
     *
     * @return 補正済_70未満高額支給額
     */
    public Decimal get補正済_70未満高額支給額() {
        return entity.getSumi_under_70KogakuShikyuGaku();
    }

    /**
     * 補正済_70_74高額支給額を返します。
     *
     * @return 補正済_70_74高額支給額
     */
    public Decimal get補正済_70_74高額支給額() {
        return entity.getSumi_70_74KogakuShikyuGaku();
    }

    /**
     * 補正済_摘要を返します。
     *
     * @return 補正済_摘要
     */
    public RString get補正済_摘要() {
        return entity.getSumi_Tekiyo();
    }

    /**
     * {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}のクローン
     */
    @Override
    public DbT3071KogakuGassanJikoFutanGakuMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算自己負担額明細の識別子{@link KogakuGassanJikoFutanGakuMeisaiIdentifier}を返します。
     *
     * @return 高額合算自己負担額明細の識別子{@link KogakuGassanJikoFutanGakuMeisaiIdentifier}
     */
    @Override
    public KogakuGassanJikoFutanGakuMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算自己負担額明細を削除対象とします。<br/>
     * {@link DbT3071KogakuGassanJikoFutanGakuMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanJikoFutanGakuMeisai}
     */
    @Override
    public KogakuGassanJikoFutanGakuMeisai deleted() {
        DbT3071KogakuGassanJikoFutanGakuMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanJikoFutanGakuMeisai(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanJikoFutanGakuMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanJikoFutanGakuMeisai}のシリアライズ形式
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

        private final DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity;
        private final KogakuGassanJikoFutanGakuMeisaiIdentifier id;

        private _SerializationProxy(DbT3071KogakuGassanJikoFutanGakuMeisaiEntity entity, KogakuGassanJikoFutanGakuMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanJikoFutanGakuMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanJikoFutanGakuMeisaiBuilder createBuilderForEdit() {
        return new KogakuGassanJikoFutanGakuMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
