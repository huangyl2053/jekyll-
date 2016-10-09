/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額受領委任契約事業者を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 yuqingzhang
 */
public class KogakuJuryoininKeiyakuJigyosha
        extends ModelBase<KogakuJuryoininKeiyakuJigyoshaIdentifier, DbT3076KogakuJuryoininKeiyakuJigyoshaEntity, KogakuJuryoininKeiyakuJigyosha>
        implements Serializable {

    private final DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity;
    private final KogakuJuryoininKeiyakuJigyoshaIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額受領委任契約事業者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public KogakuJuryoininKeiyakuJigyosha(HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3076KogakuJuryoininKeiyakuJigyoshaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuJuryoininKeiyakuJigyoshaIdentifier(
                被保険者番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}より{@link KogakuJuryoininKeiyakuJigyosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}
     */
    public KogakuJuryoininKeiyakuJigyosha(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額受領委任契約事業者"));
        this.id = new KogakuJuryoininKeiyakuJigyoshaIdentifier(
                entity.getHihokenshaNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}
     * @param id {@link KogakuJuryoininKeiyakuJigyoshaIdentifier}
     */
    KogakuJuryoininKeiyakuJigyosha(
            DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity,
            KogakuJuryoininKeiyakuJigyoshaIdentifier id
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
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
     * 承認結果区分を返します。
     *
     * @return 承認結果区分
     */
    public RString get承認結果区分() {
        return entity.getShoninKekkaKubun();
    }

    /**
     * 受領委任払適用開始年月日を返します。
     *
     * @return 受領委任払適用開始年月日
     */
    public FlexibleDate get受領委任払適用開始年月日() {
        return entity.getJuryoininKaishiYMD();
    }

    /**
     * 受領委任払適用終了年月日を返します。
     *
     * @return 受領委任払適用終了年月日
     */
    public FlexibleDate get受領委任払適用終了年月日() {
        return entity.getJuryoininShuryoYMD();
    }

    /**
     * 契約番号を返します。
     *
     * @return 契約番号
     */
    public RString get契約番号() {
        return entity.getKeiyakuNo();
    }

    /**
     * 不承認理由を返します。
     *
     * @return 不承認理由
     */
    public RString get不承認理由() {
        return entity.getFuShoninRiyu();
    }

    /**
     * 利用者負担上限額を返します。
     *
     * @return 利用者負担上限額
     */
    public Decimal get利用者負担上限額() {
        return entity.getRiyoshaFutanJogenGaku();
    }

    /**
     * 承認結果通知書作成日を返します。
     *
     * @return 承認結果通知書作成日
     */
    public FlexibleDate get承認結果通知書作成日() {
        return entity.getShoninKekkaTsuchiSakuseiYMD();
    }

    /**
     * 承認結果通知書再発行区分を返します。
     *
     * @return 承認結果通知書再発行区分
     */
    public RString get承認結果通知書再発行区分() {
        return entity.getShoninKekkaTsuchiSaiHakkoKubun();
    }

    /**
     * {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}のクローンを返します。
     *
     * @return {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}のクローン
     */
    @Override
    public DbT3076KogakuJuryoininKeiyakuJigyoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額受領委任契約事業者の識別子{@link KogakuJuryoininKeiyakuJigyoshaIdentifier}を返します。
     *
     * @return 高額受領委任契約事業者の識別子{@link KogakuJuryoininKeiyakuJigyoshaIdentifier}
     */
    @Override
    public KogakuJuryoininKeiyakuJigyoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額受領委任契約事業者を削除対象とします。<br/> {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuJuryoininKeiyakuJigyosha}
     */
    @Override
    public KogakuJuryoininKeiyakuJigyosha deleted() {
        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity deletedEntity = this.toEntity();
        deletedEntity.setState(EntityDataState.Deleted);
        return new KogakuJuryoininKeiyakuJigyosha(deletedEntity, id);
    }

    /**
     * 保持する高額受領委任契約事業者を修正対象とします。<br/> {@link DbT3076KogakuJuryoininKeiyakuJigyoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば修正状態にします。
     *
     * @return 修正対象処理実施後の{@link KogakuJuryoininKeiyakuJigyosha}
     */
    public KogakuJuryoininKeiyakuJigyosha modified() {
        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new KogakuJuryoininKeiyakuJigyosha(modifiedEntity, id);
    }

    /**
     * {@link KogakuJuryoininKeiyakuJigyosha}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuJuryoininKeiyakuJigyosha}のシリアライズ形式
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

        private final DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity;
        private final KogakuJuryoininKeiyakuJigyoshaIdentifier id;

        private _SerializationProxy(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity, KogakuJuryoininKeiyakuJigyoshaIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuJuryoininKeiyakuJigyosha(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuJuryoininKeiyakuJigyoshaBuilder createBuilderForEdit() {
        return new KogakuJuryoininKeiyakuJigyoshaBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
