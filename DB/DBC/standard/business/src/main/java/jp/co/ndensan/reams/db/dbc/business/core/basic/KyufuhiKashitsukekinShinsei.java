/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3086KyufuhiKashitsukekinShinseiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金申請を管理するクラスです。
 */
public class KyufuhiKashitsukekinShinsei extends ParentModelBase<KyufuhiKashitsukekinShinseiIdentifier, DbT3086KyufuhiKashitsukekinShinseiEntity, KyufuhiKashitsukekinShinsei> implements Serializable {

    private final DbT3086KyufuhiKashitsukekinShinseiEntity entity;
    private final KyufuhiKashitsukekinShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 借入申請年月日 借入申請年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukekinShinsei(HihokenshaNo 被保険者番号,
FlexibleDate 借入申請年月日,
Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3086KyufuhiKashitsukekinShinseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKariireShinseiYMD(借入申請年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukekinShinseiIdentifier(
        被保険者番号,
        借入申請年月日,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3086KyufuhiKashitsukekinShinseiEntity}より{@link KyufuhiKashitsukekinShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3086KyufuhiKashitsukekinShinseiEntity}
     */
    public KyufuhiKashitsukekinShinsei(DbT3086KyufuhiKashitsukekinShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金申請"));
        this.id = new KyufuhiKashitsukekinShinseiIdentifier(
                entity.getHihokenshaNo(),
                entity.getKariireShinseiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3086KyufuhiKashitsukekinShinseiEntity}
     * @param id {@link KyufuhiKashitsukekinShinseiIdentifier}
     */
    KyufuhiKashitsukekinShinsei(
            DbT3086KyufuhiKashitsukekinShinseiEntity entity,
            KyufuhiKashitsukekinShinseiIdentifier id
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
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaJusho();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public AtenaKanaMeisho get申請者氏名カナ() {
        return entity.getShinseishaShimeiKana();
    }

    /**
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public AtenaMeisho get申請者氏名() {
        return entity.getShinseishaShimei();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請者との関係を返します。
     *
     * @return 申請者との関係
     */
    public RString get申請者との関係() {
        return entity.getShinseishaKankei();
    }

    /**
     * 借入利用期間開始年月日を返します。
     *
     * @return 借入利用期間開始年月日
     */
    public FlexibleDate get借入利用期間開始年月日() {
        return entity.getKariireRiyoKaishiYMD();
    }

    /**
     * 借入利用期間終了年月日を返します。
     *
     * @return 借入利用期間終了年月日
     */
    public FlexibleDate get借入利用期間終了年月日() {
        return entity.getKariireRiyoShuryoYMD();
    }

    /**
     * 貸付対象・高額介護サービス費等有無を返します。
     *
     * @return 貸付対象・高額介護サービス費等有無
     */
    public RString get貸付対象・高額介護サービス費等有無() {
        return entity.getKashitsuke_KogakuUmu();
    }

    /**
     * 貸付対象・住宅改修費等有無を返します。
     *
     * @return 貸付対象・住宅改修費等有無
     */
    public RString get貸付対象・住宅改修費等有無() {
        return entity.getKashitsuke_JutakuKaishuUmu();
    }

    /**
     * 貸付対象・福祉用具購入費等有無を返します。
     *
     * @return 貸付対象・福祉用具購入費等有無
     */
    public RString get貸付対象・福祉用具購入費等有無() {
        return entity.getKahitsuke_YoguKonyuUmu();
    }

    /**
     * 貸付対象・特例介護サービス費等有無を返します。
     *
     * @return 貸付対象・特例介護サービス費等有無
     */
    public RString get貸付対象・特例介護サービス費等有無() {
        return entity.getKashitsuke_TokureiServiceUmu();
    }

    /**
     * 保証人氏名カナを返します。
     *
     * @return 保証人氏名カナ
     */
    public AtenaKanaMeisho get保証人氏名カナ() {
        return entity.getHoshonin_ShimeiKana();
    }

    /**
     * 保証人氏名を返します。
     *
     * @return 保証人氏名
     */
    public AtenaMeisho get保証人氏名() {
        return entity.getHoshonin_Shimei();
    }

    /**
     * 保証人生年月日を返します。
     *
     * @return 保証人生年月日
     */
    public FlexibleDate get保証人生年月日() {
        return entity.getHoshonin_UmareYMD();
    }

    /**
     * 保証人性別を返します。
     *
     * @return 保証人性別
     */
    public Code get保証人性別() {
        return entity.getHoshinin_SeibetsuCd();
    }

    /**
     * 保証人郵便番号を返します。
     *
     * @return 保証人郵便番号
     */
    public YubinNo get保証人郵便番号() {
        return entity.getHoshonin_YubinNo();
    }

    /**
     * 保証人住所を返します。
     *
     * @return 保証人住所
     */
    public RString get保証人住所() {
        return entity.getHoshonin_Jusho();
    }

    /**
     * 保証人電話番号を返します。
     *
     * @return 保証人電話番号
     */
    public TelNo get保証人電話番号() {
        return entity.getHoshonin_TelNo();
    }

    /**
     * 借入申請者との関係を返します。
     *
     * @return 借入申請者との関係
     */
    public RString get借入申請者との関係() {
        return entity.getKariireShinseishaKankei();
    }

    /**
     * 保証人勤務先名称を返します。
     *
     * @return 保証人勤務先名称
     */
    public AtenaMeisho get保証人勤務先名称() {
        return entity.getHoshonin_KinmusakiMeisho();
    }

    /**
     * 保証人勤務先郵便番号を返します。
     *
     * @return 保証人勤務先郵便番号
     */
    public YubinNo get保証人勤務先郵便番号() {
        return entity.getHoshonin_KinmusakiYubinNo();
    }

    /**
     * 保証人勤務先所在地を返します。
     *
     * @return 保証人勤務先所在地
     */
    public RString get保証人勤務先所在地() {
        return entity.getHoshonin_KinmusakiJusho();
    }

    /**
     * 保証人勤務先電話番号を返します。
     *
     * @return 保証人勤務先電話番号
     */
    public TelNo get保証人勤務先電話番号() {
        return entity.getHoshonin_KinmusakiTelNo();
    }

    /**
     * 請求書・領収書の有無を返します。
     *
     * @return 請求書・領収書の有無
     */
    public RString get請求書・領収書の有無() {
        return entity.getSeikyusho_RyoshushoUmu();
    }

    /**
     * 提出物管理番号を返します。
     *
     * @return 提出物管理番号
     */
    public Decimal get提出物管理番号() {
        return entity.getTeishutsubutsuKanriNo();
    }

    /**
     * {@link DbT3086KyufuhiKashitsukekinShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT3086KyufuhiKashitsukekinShinseiEntity}のクローン
     */
    @Override
    public DbT3086KyufuhiKashitsukekinShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金申請の識別子{@link KyufuhiKashitsukekinShinseiIdentifier}を返します。
     *
     * @return 給付費貸付金申請の識別子{@link KyufuhiKashitsukekinShinseiIdentifier}
     */
    @Override
    public KyufuhiKashitsukekinShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 給付費貸付金申請のみを変更対象とします。<br/>
     * {@link DbT3086KyufuhiKashitsukekinShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyufuhiKashitsukekinShinsei}
     */
    @Override
    public KyufuhiKashitsukekinShinsei modifiedModel() {
        DbT3086KyufuhiKashitsukekinShinseiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyufuhiKashitsukekinShinsei(
                modifiedEntity, id);
    }

    /**
     * 保持する給付費貸付金申請を削除対象とします。<br/>
     * {@link DbT3086KyufuhiKashitsukekinShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukekinShinsei}
     */
    @Override
    public KyufuhiKashitsukekinShinsei deleted() {
        DbT3086KyufuhiKashitsukekinShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukekinShinsei(deletedEntity, id);
    }
    /**
     * {@link KyufuhiKashitsukekinShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukekinShinsei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3086KyufuhiKashitsukekinShinseiEntity entity;
        private final KyufuhiKashitsukekinShinseiIdentifier id;

        private _SerializationProxy(DbT3086KyufuhiKashitsukekinShinseiEntity entity,KyufuhiKashitsukekinShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukekinShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukekinShinseiBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukekinShinseiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
