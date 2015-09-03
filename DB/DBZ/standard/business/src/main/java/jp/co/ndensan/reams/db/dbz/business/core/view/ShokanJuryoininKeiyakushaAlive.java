/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 還受領委任契約者Aliveを管理するクラスです。
 */
public class ShokanJuryoininKeiyakushaAlive extends ParentModelBase<ShokanJuryoininKeiyakushaAliveIdentifier, DbV3078ShokanJuryoininKeiyakushaEntity, ShokanJuryoininKeiyakushaAlive> implements Serializable {

    private final DbV3078ShokanJuryoininKeiyakushaEntity entity;
    private final ShokanJuryoininKeiyakushaAliveIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 還受領委任契約者Aliveの新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public ShokanJuryoininKeiyakushaAlive(HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbV3078ShokanJuryoininKeiyakushaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanJuryoininKeiyakushaAliveIdentifier(
                被保険者番号,
                証記載保険者番号,
                受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV3078ShokanJuryoininKeiyakushaEntity}より{@link ShokanJuryoininKeiyakushaAlive}を生成します。
     *
     * @param entity DBより取得した{@link DbV3078ShokanJuryoininKeiyakushaEntity}
     */
    public ShokanJuryoininKeiyakushaAlive(DbV3078ShokanJuryoininKeiyakushaEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("還受領委任契約者Alive"));
        this.id = new ShokanJuryoininKeiyakushaAliveIdentifier(
                entity.getHihokenshaNo(),
                entity.getShoKisaiHokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV3078ShokanJuryoininKeiyakushaEntity}
     * @param id {@link ShokanJuryoininKeiyakushaAliveIdentifier}
     */
    ShokanJuryoininKeiyakushaAlive(
            DbV3078ShokanJuryoininKeiyakushaEntity entity,
            ShokanJuryoininKeiyakushaAliveIdentifier id
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 事業者契約番号を返します。
     *
     * @return 事業者契約番号
     */
    public RString get事業者契約番号() {
        return entity.getJigyoshaKeiyakuNo();
    }

    /**
     * 契約サービス種類を返します。
     *
     * @return 契約サービス種類
     */
    public RString get契約サービス種類() {
        return entity.getKeiyakuServiceShurui();
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
     * 費用額合計を返します。
     *
     * @return 費用額合計
     */
    public Decimal get費用額合計() {
        return entity.getHiyoGakuGokei();
    }

    /**
     * 保険対象費用額を返します。
     *
     * @return 保険対象費用額
     */
    public Decimal get保険対象費用額() {
        return entity.getHokenTaishoHiyoGaku();
    }

    /**
     * 利用者自己負担額を返します。
     *
     * @return 利用者自己負担額
     */
    public Decimal get利用者自己負担額() {
        return entity.getRiyoshaJikoFutanGaku();
    }

    /**
     * 保険給付費額を返します。
     *
     * @return 保険給付費額
     */
    public Decimal get保険給付費額() {
        return entity.getHokenKyufuhiGaku();
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
     * {@link DbV3078ShokanJuryoininKeiyakushaEntity}のクローンを返します。
     *
     * @return {@link DbV3078ShokanJuryoininKeiyakushaEntity}のクローン
     */
    @Override
    public DbV3078ShokanJuryoininKeiyakushaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 還受領委任契約者Aliveの識別子{@link ShokanJuryoininKeiyakushaAliveIdentifier}を返します。
     *
     * @return 還受領委任契約者Aliveの識別子{@link ShokanJuryoininKeiyakushaAliveIdentifier}
     */
    @Override
    public ShokanJuryoininKeiyakushaAliveIdentifier identifier() {
        return this.id;
    }

    /**
     * 還受領委任契約者Aliveのみを変更対象とします。<br/>
     * {@link DbV3078ShokanJuryoininKeiyakushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanJuryoininKeiyakushaAlive}
     */
    @Override
    public ShokanJuryoininKeiyakushaAlive modifiedModel() {
        DbV3078ShokanJuryoininKeiyakushaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShokanJuryoininKeiyakushaAlive(
                modifiedEntity, id);
    }

    /**
     * 保持する還受領委任契約者Aliveを削除対象とします。<br/>
     * {@link DbV3078ShokanJuryoininKeiyakushaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanJuryoininKeiyakushaAlive}
     */
    @Override
    public ShokanJuryoininKeiyakushaAlive deleted() {
        DbV3078ShokanJuryoininKeiyakushaEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanJuryoininKeiyakushaAlive(deletedEntity, id);
    }

    /**
     * {@link ShokanJuryoininKeiyakushaAlive}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanJuryoininKeiyakushaAlive}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;// TODO serialVersionUIDを生成してください
        private final DbV3078ShokanJuryoininKeiyakushaEntity entity;
        private final ShokanJuryoininKeiyakushaAliveIdentifier id;

        private _SerializationProxy(DbV3078ShokanJuryoininKeiyakushaEntity entity, ShokanJuryoininKeiyakushaAliveIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanJuryoininKeiyakushaAlive(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanJuryoininKeiyakushaAliveBuilder createBuilderForEdit() {
        return new ShokanJuryoininKeiyakushaAliveBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
