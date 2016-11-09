/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity;
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
 * 事業高額合算自己負担額証明書明細を管理するクラスです。
 *
 * @reamsid_L DBC-4820-010 sunhaidi
 */
public class JigyoKogakuGassanJikoFutanGakuShomeishoMeisai
        extends ModelBase<JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier,
        DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity, JigyoKogakuGassanJikoFutanGakuShomeishoMeisai>
        implements Serializable {

    private final DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity;
    private final JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 事業高額合算自己負担額証明書明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 証記載保険者番号 証記載保険者番号
     * @param 支給申請書整理番号 支給申請書整理番号
     * @param 転入前保険者番号 転入前保険者番号
     * @param 履歴番号 履歴番号
     * @param 対象月 対象月
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            HokenshaNo 転入前保険者番号,
            int 履歴番号,
            RString 対象月) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(転入前保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("転入前保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(対象月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象月"));
        this.entity = new DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(証記載保険者番号);
        this.entity.setShikyuShinseishoSeiriNo(支給申請書整理番号);
        this.entity.setTennyumaeHokenshaNo(転入前保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setTaishoM(対象月);
        this.id = new JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier(
                被保険者番号,
                対象年度,
                証記載保険者番号,
                支給申請書整理番号,
                転入前保険者番号,
                履歴番号,
                対象月
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}より{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額合算自己負担額証明書明細"));
        this.id = new JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getShikyuShinseishoSeiriNo(),
                entity.getTennyumaeHokenshaNo(),
                entity.getRirekiNo(),
                entity.getTaishoM());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}
     * @param id {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier}
     */
    JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(
            DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity,
            JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
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
     * 転入前保険者番号を返します。
     *
     * @return 転入前保険者番号
     */
    public HokenshaNo get転入前保険者番号() {
        return entity.getTennyumaeHokenshaNo();
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
     * 対象月を返します。
     *
     * @return 対象月
     */
    public RString get対象月() {
        return entity.getTaishoM();
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
     * 70-74自己負担額（内数）を返します。
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
     * 70-74高額支給額を返します。
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
     * {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}のクローン
     */
    @Override
    public DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 事業高額合算自己負担額証明書明細の識別子{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier}を返します。
     *
     * @return 事業高額合算自己負担額証明書明細の識別子{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier}
     */
    @Override
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 事業高額合算自己負担額証明書明細のみを変更対象とします。<br/>
     * {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisai modifiedModel() {
        DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(
                modifiedEntity, id);
    }

    /**
     * 保持する事業高額合算自己負担額証明書明細を削除対象とします。<br/>
     * {@link DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}
     */
    @Override
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisai deleted() {
        DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(deletedEntity, id);
    }

    /**
     * {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link JigyoKogakuGassanJikoFutanGakuShomeishoMeisai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -1497787164979473452L;
        private final DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity;
        private final JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id;

        private _SerializationProxy(DbT3181JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiEntity entity,
                JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JigyoKogakuGassanJikoFutanGakuShomeishoMeisai(this.entity, this.id);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder createBuilderForEdit() {
        return new JigyoKogakuGassanJikoFutanGakuShomeishoMeisaiBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final JigyoKogakuGassanJikoFutanGakuShomeishoMeisai other = (JigyoKogakuGassanJikoFutanGakuShomeishoMeisai) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
