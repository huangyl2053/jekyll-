/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3059KagoMoshitateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤申立を管理するクラスです。
 */
public class KagoMoshitate extends ModelBase<KagoMoshitateIdentifier, DbT3059KagoMoshitateEntity, KagoMoshitate> implements Serializable {

    private final DbT3059KagoMoshitateEntity entity;
    private final KagoMoshitateIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 過誤申立の新規作成時に使用します。
     *
     * @param 事業所番号 事業所番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 履歴番号 履歴番号
     */
    public KagoMoshitate(JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            int 履歴番号) {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3059KagoMoshitateEntity();
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KagoMoshitateIdentifier(
                事業所番号,
                被保険者番号,
                サービス提供年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3059KagoMoshitateEntity}より{@link KagoMoshitate}を生成します。
     *
     * @param entity DBより取得した{@link DbT3059KagoMoshitateEntity}
     */
    public KagoMoshitate(DbT3059KagoMoshitateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤申立"));
        this.id = new KagoMoshitateIdentifier(
                entity.getJigyoshoNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3059KagoMoshitateEntity}
     * @param id {@link KagoMoshitateIdentifier}
     */
    KagoMoshitate(
            DbT3059KagoMoshitateEntity entity,
            KagoMoshitateIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHiHokenshaNo();
    }

    /**
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
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
     * 申立年月日を返します。
     *
     * @return 申立年月日
     */
    public FlexibleDate get申立年月日() {
        return entity.getMoshitateYMD();
    }

    /**
     * 申立者区分コードを返します。
     *
     * @return 申立者区分コード
     */
    public RString get申立者区分コード() {
        return entity.getMoshitateshaKubunCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 申立事由コードを返します。
     *
     * @return 申立事由コード
     */
    public RString get申立事由コード() {
        return entity.getMoshitateJiyuCode();
    }

    /**
     * 国保連送付年月を返します。
     *
     * @return 国保連送付年月
     */
    public FlexibleYearMonth get国保連送付年月() {
        return entity.getKokuhorenSofuYM();
    }

    /**
     * 国保連再送付有フラグを返します。
     *
     * @return 国保連再送付有フラグ
     */
    public boolean is国保連再送付有フラグ() {
        return entity.getKokuhirenSaiSofuAriFlag();
    }

    /**
     * 同月審査有フラグを返します。
     *
     * @return 同月審査有フラグ
     */
    public boolean is同月審査有フラグ() {
        return entity.getDogetsuShinsaAriFlag();
    }

    /**
     * 申立書区分コードを返します。
     *
     * @return 申立書区分コード
     */
    public RString get申立書区分コード() {
        return entity.getMoshitateshoKubunCode();
    }

    /**
     * {@link DbT3059KagoMoshitateEntity}のクローンを返します。
     *
     * @return {@link DbT3059KagoMoshitateEntity}のクローン
     */
    @Override
    public DbT3059KagoMoshitateEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 過誤申立の識別子{@link KagoMoshitateIdentifier}を返します。
     *
     * @return 過誤申立の識別子{@link KagoMoshitateIdentifier}
     */
    @Override
    public KagoMoshitateIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する過誤申立を削除対象とします。<br/> {@link DbT3059KagoMoshitateEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KagoMoshitate}
     */
    @Override
    public KagoMoshitate deleted() {
        DbT3059KagoMoshitateEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KagoMoshitate(deletedEntity, id);
    }

    /**
     * {@link KagoMoshitate}のシリアライズ形式を提供します。
     *
     * @return {@link KagoMoshitate}のシリアライズ形式
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

        private final DbT3059KagoMoshitateEntity entity;
        private final KagoMoshitateIdentifier id;

        private _SerializationProxy(DbT3059KagoMoshitateEntity entity, KagoMoshitateIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KagoMoshitate(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KagoMoshitateBuilder createBuilderForEdit() {
        return new KagoMoshitateBuilder(entity, id);
    }

    /**
     * 主治医医療機関情報のみを変更対象とします。<br/> {@link DbT5911ShujiiIryoKikanJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIryoKikanJoho}
     */
    public KagoMoshitate modifiedModel() {
        DbT3059KagoMoshitateEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KagoMoshitate(
                modifiedEntity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
