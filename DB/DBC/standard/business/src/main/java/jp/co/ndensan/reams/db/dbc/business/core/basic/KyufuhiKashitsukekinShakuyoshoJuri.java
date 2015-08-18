/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金借用書受理を管理するクラスです。
 */
public class KyufuhiKashitsukekinShakuyoshoJuri extends ModelBase<KyufuhiKashitsukekinShakuyoshoJuriIdentifier, DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity, KyufuhiKashitsukekinShakuyoshoJuri> implements Serializable {

    private final DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity;
    private final KyufuhiKashitsukekinShakuyoshoJuriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金借用書受理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 借入申請年月日 借入申請年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukekinShakuyoshoJuri(HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKariireShinseiYMD(借入申請年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukekinShakuyoshoJuriIdentifier(
                被保険者番号,
                借入申請年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}より{@link KyufuhiKashitsukekinShakuyoshoJuri}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}
     */
    public KyufuhiKashitsukekinShakuyoshoJuri(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金借用書受理"));
        this.id = new KyufuhiKashitsukekinShakuyoshoJuriIdentifier(
                entity.getHihokenshaNo(),
                entity.getKariireShinseiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}
     * @param id {@link KyufuhiKashitsukekinShakuyoshoJuriIdentifier}
     */
    KyufuhiKashitsukekinShakuyoshoJuri(
            DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity,
            KyufuhiKashitsukekinShakuyoshoJuriIdentifier id
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
     * 借入申請年月日を返します。
     *
     * @return 借入申請年月日
     */
    public FlexibleDate get借入申請年月日() {
        return entity.getKariireShinseiYMD();
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
     * 借受年月日を返します。
     *
     * @return 借受年月日
     */
    public FlexibleDate get借受年月日() {
        return entity.getKariukeYMD();
    }

    /**
     * 借受人郵便番号を返します。
     *
     * @return 借受人郵便番号
     */
    public YubinNo get借受人郵便番号() {
        return entity.getKariukeninYubinNo();
    }

    /**
     * 借受人住所を返します。
     *
     * @return 借受人住所
     */
    public RString get借受人住所() {
        return entity.getKariukeninJusho();
    }

    /**
     * 借受人氏名カナを返します。
     *
     * @return 借受人氏名カナ
     */
    public AtenaKanaMeisho get借受人氏名カナ() {
        return entity.getKariukeninShimeiKana();
    }

    /**
     * 借受人氏名を返します。
     *
     * @return 借受人氏名
     */
    public AtenaMeisho get借受人氏名() {
        return entity.getKariukeninShimei();
    }

    /**
     * 借受人電話番号を返します。
     *
     * @return 借受人電話番号
     */
    public TelNo get借受人電話番号() {
        return entity.getKariukeninTelNo();
    }

    /**
     * 保証人氏名カナを返します。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho get保証人氏名カナ() {
        return entity.getHoshoninShimeiKana();
    }

    /**
     * 保証人氏名を返します。
     *
     * @return 保証人氏名
     */
    public AtenaKanaMeisho get保証人氏名() {
        return entity.getHoshoninShimei();
    }

    /**
     * 保証人郵便番号を返します。
     *
     * @return 保証人郵便番号
     */
    public YubinNo get保証人郵便番号() {
        return entity.getHoshoninYubinNo();
    }

    /**
     * 保証人住所を返します。
     *
     * @return 保証人住所
     */
    public RString get保証人住所() {
        return entity.getHoshoninJusho();
    }

    /**
     * 保証人電話番号を返します。
     *
     * @return 保証人電話番号
     */
    public TelNo get保証人電話番号() {
        return entity.getHoshoninTelNo();
    }

    /**
     * {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}のクローンを返します。
     *
     * @return {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}のクローン
     */
    @Override
    public DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金借用書受理の識別子{@link KyufuhiKashitsukekinShakuyoshoJuriIdentifier}を返します。
     *
     * @return
     * 給付費貸付金借用書受理の識別子{@link KyufuhiKashitsukekinShakuyoshoJuriIdentifier}
     */
    @Override
    public KyufuhiKashitsukekinShakuyoshoJuriIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付費貸付金借用書受理を削除対象とします。<br/>
     * {@link DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukekinShakuyoshoJuri}
     */
    @Override
    public KyufuhiKashitsukekinShakuyoshoJuri deleted() {
        DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukekinShakuyoshoJuri(deletedEntity, id);
    }

    /**
     * {@link KyufuhiKashitsukekinShakuyoshoJuri}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukekinShakuyoshoJuri}のシリアライズ形式
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

        private final DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity;
        private final KyufuhiKashitsukekinShakuyoshoJuriIdentifier id;

        private _SerializationProxy(DbT3088KyufuhiKashitsukekinShakuyoshoJuriEntity entity, KyufuhiKashitsukekinShakuyoshoJuriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukekinShakuyoshoJuri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukekinShakuyoshoJuriBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukekinShakuyoshoJuriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
