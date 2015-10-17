/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付費貸付金決定を管理するクラスです。
 */
public class KyufuhiKashitsukeKinKettei extends ModelBase<KyufuhiKashitsukeKinKetteiIdentifier, DbT3087KyufuhiKashitsukeKinKetteiEntity, KyufuhiKashitsukeKinKettei> implements Serializable {

    private final DbT3087KyufuhiKashitsukeKinKetteiEntity entity;
    private final KyufuhiKashitsukeKinKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付費貸付金決定の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 借入申請年月日 借入申請年月日
     * @param 履歴番号 履歴番号
     */
    public KyufuhiKashitsukeKinKettei(HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3087KyufuhiKashitsukeKinKetteiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKariireShinseiYMD(借入申請年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KyufuhiKashitsukeKinKetteiIdentifier(
                被保険者番号,
                借入申請年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3087KyufuhiKashitsukeKinKetteiEntity}より{@link KyufuhiKashitsukeKinKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3087KyufuhiKashitsukeKinKetteiEntity}
     */
    public KyufuhiKashitsukeKinKettei(DbT3087KyufuhiKashitsukeKinKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金決定"));
        this.id = new KyufuhiKashitsukeKinKetteiIdentifier(
                entity.getHihokenshaNo(),
                entity.getKariireShinseiYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}
     * @param id {@link KyufuhiKashitsukeKinKetteiIdentifier}
     */
    KyufuhiKashitsukeKinKettei(
            DbT3087KyufuhiKashitsukeKinKetteiEntity entity,
            KyufuhiKashitsukeKinKetteiIdentifier id
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
     * 貸付審査決定年月日を返します。
     *
     * @return 貸付審査決定年月日
     */
    public FlexibleDate get貸付審査決定年月日() {
        return entity.getKashitsukeShinsaKetteiYMD();
    }

    /**
     * 貸付承認・不承認区分を返します。
     *
     * @return 貸付承認・不承認区分
     */
    public RString get貸付承認_不承認区分() {
        return entity.getKashitsukeShonin_FuShoninKubun();
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
     * 貸付金額を返します。
     *
     * @return 貸付金額
     */
    public Decimal get貸付金額() {
        return entity.getKashitsukeKingaku();
    }

    /**
     * 償還方法を返します。
     *
     * @return 償還方法
     */
    public RString get償還方法() {
        return entity.getShokanHoho();
    }

    /**
     * 償還期限を返します。
     *
     * @return 償還期限
     */
    public FlexibleDate get償還期限() {
        return entity.getShokanKigenYMD();
    }

    /**
     * 貸付年月日を返します。
     *
     * @return 貸付年月日
     */
    public FlexibleDate get貸付年月日() {
        return entity.getKashitsukeYMD();
    }

    /**
     * 貸付支払方法を返します。
     *
     * @return 貸付支払方法
     */
    public RString get貸付支払方法() {
        return entity.getKashitsukeShiharaiHoho();
    }

    /**
     * 貸付窓口支払場所を返します。
     *
     * @return 貸付窓口支払場所
     */
    public RString get貸付窓口支払場所() {
        return entity.getKashitsukeMadoguchiShiharaiBasho();
    }

    /**
     * 貸付窓口開始年月日を返します。
     *
     * @return 貸付窓口開始年月日
     */
    public FlexibleDate get貸付窓口開始年月日() {
        return entity.getKashitsukeMadoguchiKaishiYMD();
    }

    /**
     * 貸付窓口終了年月日を返します。
     *
     * @return 貸付窓口終了年月日
     */
    public FlexibleDate get貸付窓口終了年月日() {
        return entity.getKashitsukeMadoguchiShuryoYMD();
    }

    /**
     * 貸付窓口閉庁内容を返します。
     *
     * @return 貸付窓口閉庁内容
     */
    public RString get貸付窓口閉庁内容() {
        return entity.getKashitsukeMadoguchiHeichoNaiyo();
    }

    /**
     * 貸付窓口開始時間を返します。
     *
     * @return 貸付窓口開始時間
     */
    public RString get貸付窓口開始時間() {
        return entity.getKashitsukeMadoguchiKaishiTime();
    }

    /**
     * 貸付窓口終了時間を返します。
     *
     * @return 貸付窓口終了時間
     */
    public RString get貸付窓口終了時間() {
        return entity.getKashitsukeMadoguchiShuryoTime();
    }

    /**
     * 貸付不承認理由を返します。
     *
     * @return 貸付不承認理由
     */
    public RString get貸付不承認理由() {
        return entity.getKashitsukeFuShoninRiyu();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuCode();
    }

    /**
     * {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}のクローン
     */
    @Override
    public DbT3087KyufuhiKashitsukeKinKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付費貸付金決定の識別子{@link KyufuhiKashitsukeKinKetteiIdentifier}を返します。
     *
     * @return 給付費貸付金決定の識別子{@link KyufuhiKashitsukeKinKetteiIdentifier}
     */
    @Override
    public KyufuhiKashitsukeKinKetteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付費貸付金決定を削除対象とします。<br/>
     * {@link DbT3087KyufuhiKashitsukeKinKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuhiKashitsukeKinKettei}
     */
    @Override
    public KyufuhiKashitsukeKinKettei deleted() {
        DbT3087KyufuhiKashitsukeKinKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuhiKashitsukeKinKettei(deletedEntity, id);
    }

    /**
     * {@link KyufuhiKashitsukeKinKettei}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuhiKashitsukeKinKettei}のシリアライズ形式
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

        private final DbT3087KyufuhiKashitsukeKinKetteiEntity entity;
        private final KyufuhiKashitsukeKinKetteiIdentifier id;

        private _SerializationProxy(DbT3087KyufuhiKashitsukeKinKetteiEntity entity, KyufuhiKashitsukeKinKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuhiKashitsukeKinKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuhiKashitsukeKinKetteiBuilder createBuilderForEdit() {
        return new KyufuhiKashitsukeKinKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
