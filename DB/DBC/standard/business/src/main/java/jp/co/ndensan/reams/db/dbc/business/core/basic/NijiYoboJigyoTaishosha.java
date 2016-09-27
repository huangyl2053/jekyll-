/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 二次予防事業対象者を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class NijiYoboJigyoTaishosha
        extends ModelBase<NijiYoboJigyoTaishoshaIdentifier, DbT3100NijiYoboJigyoTaishoshaEntity, NijiYoboJigyoTaishosha> implements Serializable {

    private final DbT3100NijiYoboJigyoTaishoshaEntity entity;
    private final NijiYoboJigyoTaishoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 二次予防事業対象者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public NijiYoboJigyoTaishosha(
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3100NijiYoboJigyoTaishoshaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new NijiYoboJigyoTaishoshaIdentifier(
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3100NijiYoboJigyoTaishoshaEntity}より{@link NijiYoboJigyoTaishosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3100NijiYoboJigyoTaishoshaEntity}
     */
    public NijiYoboJigyoTaishosha(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者"));
        this.id = new NijiYoboJigyoTaishoshaIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3100NijiYoboJigyoTaishoshaEntity}
     * @param id {@link NijiYoboJigyoTaishoshaIdentifier}
     */
    NijiYoboJigyoTaishosha(
            DbT3100NijiYoboJigyoTaishoshaEntity entity,
            NijiYoboJigyoTaishoshaIdentifier id
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 調査実施日を返します。
     *
     * @return 調査実施日
     */
    public FlexibleDate get調査実施日() {
        return entity.getChosaJisshiYMD();
    }

    /**
     * {@link DbT3100NijiYoboJigyoTaishoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3100NijiYoboJigyoTaishoshaEntity}のクローン
     */
    @Override
    public DbT3100NijiYoboJigyoTaishoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 二次予防事業対象者の識別子{@link NijiYoboJigyoTaishoshaIdentifier}を返します。
     *
     * @return 二次予防事業対象者の識別子{@link NijiYoboJigyoTaishoshaIdentifier}
     */
    @Override
    public NijiYoboJigyoTaishoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する二次予防事業対象者を削除対象とします。<br/> {@link DbT3100NijiYoboJigyoTaishoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link NijiYoboJigyoTaishosha}
     */
    @Override
    public NijiYoboJigyoTaishosha deleted() {
        DbT3100NijiYoboJigyoTaishoshaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NijiYoboJigyoTaishosha(deletedEntity, id);
    }

    /**
     * {@link NijiYoboJigyoTaishosha}のシリアライズ形式を提供します。
     *
     * @return {@link NijiYoboJigyoTaishosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * modifiedModel
     *
     * @return 二次予防事業対象者を管理するクラス
     */
    public NijiYoboJigyoTaishosha modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * getNijiYoboKihonCheckListList
     *
     * @return 二次予防事業対象者を管理するクラスList
     */
    public List<NijiYoboKihonCheckList> getNijiYoboKihonCheckListList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3100NijiYoboJigyoTaishoshaEntity entity;
        private final NijiYoboJigyoTaishoshaIdentifier id;

        private _SerializationProxy(DbT3100NijiYoboJigyoTaishoshaEntity entity, NijiYoboJigyoTaishoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new NijiYoboJigyoTaishosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public NijiYoboJigyoTaishoshaBuilder createBuilderForEdit() {
        return new NijiYoboJigyoTaishoshaBuilder(entity, id);
    }

}
