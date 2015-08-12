/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
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
 * 給付費貸付金償還期限変更を管理するクラスです。
 */
public class KyufuhiKashitsukekinShokanKigenHenko extends ModelBase<KyufuhiKashitsukekinShokanKigenHenkoIdentifier, DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity, KyufuhiKashitsukekinShokanKigenHenko> implements Serializable {

    private final DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity;
    private final KyufuhiKashitsukekinShokanKigenHenkoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金償還期限変更の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 貸付管理番号 貸付管理番号
     * @param 償還期限延長受付年月日 償還期限延長受付年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukekinShokanKigenHenko(HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            FlexibleDate 償還期限延長受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKashitsukeKanriNo(貸付管理番号);
        this.entity.setShokanKigenEnchoUketsukeYMD(償還期限延長受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukekinShokanKigenHenkoIdentifier(
                被保険者番号,
                貸付管理番号,
                償還期限延長受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}より{@link KyufuhiKashitsukekinShokanKigenHenko}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}
     */
    public KyufuhiKashitsukekinShokanKigenHenko(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金償還期限変更"));
        this.id = new KyufuhiKashitsukekinShokanKigenHenkoIdentifier(
                entity.getHihokenshaNo(),
                entity.getKashitsukeKanriNo(),
                entity.getShokanKigenEnchoUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}
     * @param id {@link KyufuhiKashitsukekinShokanKigenHenkoIdentifier}
     */
    KyufuhiKashitsukekinShokanKigenHenko(
            DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity,
            KyufuhiKashitsukekinShokanKigenHenkoIdentifier id
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
     * 貸付管理番号を返します。
     *
     * @return 貸付管理番号
     */
    public RString get貸付管理番号() {
        return entity.getKashitsukeKanriNo();
    }

    /**
     * 償還期限延長受付年月日を返します。
     *
     * @return 償還期限延長受付年月日
     */
    public FlexibleDate get償還期限延長受付年月日() {
        return entity.getShokanKigenEnchoUketsukeYMD();
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
     * 償還期限延長申請年月日を返します。
     *
     * @return 償還期限延長申請年月日
     */
    public FlexibleDate get償還期限延長申請年月日() {
        return entity.getShokanKigenEnchoShinseiYMD();
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
     * 未償還金額を返します。
     *
     * @return 未償還金額
     */
    public Decimal get未償還金額() {
        return entity.getMiShokanKingaku();
    }

    /**
     * 償還期限延長希望期間開始年月日を返します。
     *
     * @return 償還期限延長希望期間開始年月日
     */
    public FlexibleDate get償還期限延長希望期間開始年月日() {
        return entity.getEnchoKiboKaishiYMD();
    }

    /**
     * 償還期限延長希望期間終了年月日を返します。
     *
     * @return 償還期限延長希望期間終了年月日
     */
    public FlexibleDate get償還期限延長希望期間終了年月日() {
        return entity.getEnchoKiboShuryoYMD();
    }

    /**
     * 償還期限延長理由等を返します。
     *
     * @return 償還期限延長理由等
     */
    public RString get償還期限延長理由等() {
        return entity.getEnchoRiyu();
    }

    /**
     * 償還期限変更決定年月日を返します。
     *
     * @return 償還期限変更決定年月日
     */
    public FlexibleDate get償還期限変更決定年月日() {
        return entity.getHenkoKetteiYMD();
    }

    /**
     * 償還期限変更承認・不承認区分を返します。
     *
     * @return 償還期限変更承認・不承認区分
     */
    public RString get償還期限変更承認_不承認区分() {
        return entity.getHenkoShonin_FuShoninKubun();
    }

    /**
     * 変更後償還期限を返します。
     *
     * @return 変更後償還期限
     */
    public FlexibleDate get変更後償還期限() {
        return entity.getHenkoGoShokanKigenYMD();
    }

    /**
     * 償還期限変更不承認理由を返します。
     *
     * @return 償還期限変更不承認理由
     */
    public RString get償還期限変更不承認理由() {
        return entity.getHenkoFuShoninRiyu();
    }

    /**
     * {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}のクローンを返します。
     *
     * @return {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}のクローン
     */
    @Override
    public DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金償還期限変更の識別子{@link KyufuhiKashitsukekinShokanKigenHenkoIdentifier}を返します。
     *
     * @return
     * 給付費貸付金償還期限変更の識別子{@link KyufuhiKashitsukekinShokanKigenHenkoIdentifier}
     */
    @Override
    public KyufuhiKashitsukekinShokanKigenHenkoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付費貸付金償還期限変更を削除対象とします。<br/>
     * {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukekinShokanKigenHenko}
     */
    @Override
    public KyufuhiKashitsukekinShokanKigenHenko deleted() {
        DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukekinShokanKigenHenko(deletedEntity, id);
    }

    /**
     * {@link KyufuhiKashitsukekinShokanKigenHenko}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukekinShokanKigenHenko}のシリアライズ形式
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

        private final DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity;
        private final KyufuhiKashitsukekinShokanKigenHenkoIdentifier id;

        private _SerializationProxy(DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity, KyufuhiKashitsukekinShokanKigenHenkoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukekinShokanKigenHenko(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukekinShokanKigenHenkoBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukekinShokanKigenHenkoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
