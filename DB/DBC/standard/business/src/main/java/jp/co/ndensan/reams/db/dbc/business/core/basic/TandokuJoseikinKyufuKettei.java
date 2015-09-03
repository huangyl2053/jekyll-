/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3097TandokuJoseikinKyufuKetteiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成金給付決定を管理するクラスです。
 */
public class TandokuJoseikinKyufuKettei extends ModelBase<TandokuJoseikinKyufuKetteiIdentifier, DbT3097TandokuJoseikinKyufuKetteiEntity, TandokuJoseikinKyufuKettei> implements Serializable {

    private final DbT3097TandokuJoseikinKyufuKetteiEntity entity;
    private final TandokuJoseikinKyufuKetteiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 市町村単独助成金給付決定の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public TandokuJoseikinKyufuKettei(HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3097TandokuJoseikinKyufuKetteiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new TandokuJoseikinKyufuKetteiIdentifier(
                被保険者番号,
                受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3097TandokuJoseikinKyufuKetteiEntity}より{@link TandokuJoseikinKyufuKettei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3097TandokuJoseikinKyufuKetteiEntity}
     */
    public TandokuJoseikinKyufuKettei(DbT3097TandokuJoseikinKyufuKetteiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付決定"));
        this.id = new TandokuJoseikinKyufuKetteiIdentifier(
                entity.getHihokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3097TandokuJoseikinKyufuKetteiEntity}
     * @param id {@link TandokuJoseikinKyufuKetteiIdentifier}
     */
    TandokuJoseikinKyufuKettei(
            DbT3097TandokuJoseikinKyufuKetteiEntity entity,
            TandokuJoseikinKyufuKetteiIdentifier id
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
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
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
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 有効期限を返します。
     *
     * @return 有効期限
     */
    public FlexibleDate get有効期限() {
        return entity.getYukoKigenYMD();
    }

    /**
     * 利用者負担・決定区分を返します。
     *
     * @return 利用者負担・決定区分
     */
    public RString get利用者負担_決定区分() {
        return entity.getRiyoshaFutan_KetteiKubun();
    }

    /**
     * 利用者負担・不承認理由を返します。
     *
     * @return 利用者負担・不承認理由
     */
    public RString get利用者負担_不承認理由() {
        return entity.getRiyoshaFutan_FuShoninRiyu();
    }

    /**
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohi_JukyushaNo();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohi_FutanshaNo();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 受給者番号を返します。
     *
     * @return 受給者番号
     */
    public RString get受給者番号() {
        return entity.getJukyushaNo();
    }

    /**
     * 経過措置を返します。
     *
     * @return 経過措置
     */
    public RString get経過措置() {
        return entity.getKeikaSochiKubun();
    }

    /**
     * 国軽減を返します。
     *
     * @return 国軽減
     */
    public RString get国軽減() {
        return entity.getKuniKeigenKubun();
    }

    /**
     * 社会福祉法人軽減を返します。
     *
     * @return 社会福祉法人軽減
     */
    public RString get社会福祉法人軽減() {
        return entity.getShakaiFukushiHojinKeigenKubun();
    }

    /**
     * 特別地域加算を返します。
     *
     * @return 特別地域加算
     */
    public RString get特別地域加算() {
        return entity.getTokubetsuChiikiKasanKubun();
    }

    /**
     * 保留区分・滞納を返します。
     *
     * @return 保留区分・滞納
     */
    public RString get保留区分_滞納() {
        return entity.getTaino_HoryuKubun();
    }

    /**
     * 保留区分・認定申請中を返します。
     *
     * @return 保留区分・認定申請中
     */
    public RString get保留区分_認定申請中() {
        return entity.getNinteiShinseichu_HoryuKubun();
    }

    /**
     * 保留区分・認定有効期限切れを返します。
     *
     * @return 保留区分・認定有効期限切れ
     */
    public RString get保留区分_認定有効期限切れ() {
        return entity.getNinteiKigenGire_HoryuKubun();
    }

    /**
     * {@link DbT3097TandokuJoseikinKyufuKetteiEntity}のクローンを返します。
     *
     * @return {@link DbT3097TandokuJoseikinKyufuKetteiEntity}のクローン
     */
    @Override
    public DbT3097TandokuJoseikinKyufuKetteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 市町村単独助成金給付決定の識別子{@link TandokuJoseikinKyufuKetteiIdentifier}を返します。
     *
     * @return 市町村単独助成金給付決定の識別子{@link TandokuJoseikinKyufuKetteiIdentifier}
     */
    @Override
    public TandokuJoseikinKyufuKetteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村単独助成金給付決定を削除対象とします。<br/>
     * {@link DbT3097TandokuJoseikinKyufuKetteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TandokuJoseikinKyufuKettei}
     */
    @Override
    public TandokuJoseikinKyufuKettei deleted() {
        DbT3097TandokuJoseikinKyufuKetteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TandokuJoseikinKyufuKettei(deletedEntity, id);
    }

    /**
     * {@link TandokuJoseikinKyufuKettei}のシリアライズ形式を提供します。
     *
     * @return {@link TandokuJoseikinKyufuKettei}のシリアライズ形式
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

        private final DbT3097TandokuJoseikinKyufuKetteiEntity entity;
        private final TandokuJoseikinKyufuKetteiIdentifier id;

        private _SerializationProxy(DbT3097TandokuJoseikinKyufuKetteiEntity entity, TandokuJoseikinKyufuKetteiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TandokuJoseikinKyufuKettei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TandokuJoseikinKyufuKetteiBuilder createBuilderForEdit() {
        return new TandokuJoseikinKyufuKetteiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
