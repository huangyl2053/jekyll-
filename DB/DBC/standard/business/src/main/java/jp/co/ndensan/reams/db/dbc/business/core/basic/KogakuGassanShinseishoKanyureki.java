/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3069KogakuGassanShinseishoKanyurekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算申請書加入歴を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class KogakuGassanShinseishoKanyureki
        extends ModelBase<KogakuGassanShinseishoKanyurekiIdentifier, DbT3069KogakuGassanShinseishoKanyurekiEntity, KogakuGassanShinseishoKanyureki>
        implements Serializable {

    private final DbT3069KogakuGassanShinseishoKanyurekiEntity entity;
    private final KogakuGassanShinseishoKanyurekiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算申請書加入歴の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 整理番号 整理番号
     * @param 加入歴番号 加入歴番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanShinseishoKanyureki(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            RString 加入歴番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(加入歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("加入歴番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3069KogakuGassanShinseishoKanyurekiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(保険者番号);
        this.entity.setSeiriNo(整理番号);
        this.entity.setKanyurekiNo(加入歴番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanShinseishoKanyurekiIdentifier(
                被保険者番号,
                対象年度,
                保険者番号,
                整理番号,
                加入歴番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3069KogakuGassanShinseishoKanyurekiEntity}より{@link KogakuGassanShinseishoKanyureki}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3069KogakuGassanShinseishoKanyurekiEntity}
     */
    public KogakuGassanShinseishoKanyureki(DbT3069KogakuGassanShinseishoKanyurekiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算申請書加入歴"));
        this.id = new KogakuGassanShinseishoKanyurekiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getSeiriNo(),
                entity.getKanyurekiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}
     * @param id {@link KogakuGassanShinseishoKanyurekiIdentifier}
     */
    KogakuGassanShinseishoKanyureki(
            DbT3069KogakuGassanShinseishoKanyurekiEntity entity,
            KogakuGassanShinseishoKanyurekiIdentifier id
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 加入歴番号を返します。
     *
     * @return 加入歴番号
     */
    public RString get加入歴番号() {
        return entity.getKanyurekiNo();
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
     * 保険者名を返します。
     *
     * @return 保険者名
     */
    public RString get保険者名() {
        return entity.getHokenshaMei();
    }

    /**
     * 加入期間開始年月日を返します。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate get加入期間開始年月日() {
        return entity.getKanyuKaishiYMD();
    }

    /**
     * 加入期間終了年月日を返します。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate get加入期間終了年月日() {
        return entity.getKanyuShuryoYMD();
    }

    /**
     * 自己負担額証明書整理番号を返します。
     *
     * @return 自己負担額証明書整理番号
     */
    public RString get自己負担額証明書整理番号() {
        return entity.getJikoFutanShomeisho_SeiriNo();
    }

    /**
     * {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}のクローンを返します。
     *
     * @return {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}のクローン
     */
    @Override
    public DbT3069KogakuGassanShinseishoKanyurekiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算申請書加入歴の識別子{@link KogakuGassanShinseishoKanyurekiIdentifier}を返します。
     *
     * @return 高額合算申請書加入歴の識別子{@link KogakuGassanShinseishoKanyurekiIdentifier}
     */
    @Override
    public KogakuGassanShinseishoKanyurekiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算申請書加入歴を削除対象とします。<br/>
     * {@link DbT3069KogakuGassanShinseishoKanyurekiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanShinseishoKanyureki}
     */
    @Override
    public KogakuGassanShinseishoKanyureki deleted() {
        DbT3069KogakuGassanShinseishoKanyurekiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanShinseishoKanyureki(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanShinseishoKanyureki}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanShinseishoKanyureki}のシリアライズ形式
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

        private final DbT3069KogakuGassanShinseishoKanyurekiEntity entity;
        private final KogakuGassanShinseishoKanyurekiIdentifier id;

        private _SerializationProxy(DbT3069KogakuGassanShinseishoKanyurekiEntity entity, KogakuGassanShinseishoKanyurekiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanShinseishoKanyureki(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanShinseishoKanyurekiBuilder createBuilderForEdit() {
        return new KogakuGassanShinseishoKanyurekiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
