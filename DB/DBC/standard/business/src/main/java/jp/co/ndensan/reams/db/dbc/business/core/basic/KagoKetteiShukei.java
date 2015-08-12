/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤決定集計を管理するクラスです。
 */
public class KagoKetteiShukei extends ModelBase<KagoKetteiShukeiIdentifier, DbT3060KagoKetteiShukeiEntity, KagoKetteiShukei> implements Serializable {

    private final DbT3060KagoKetteiShukeiEntity entity;
    private final KagoKetteiShukeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 過誤決定集計の新規作成時に使用します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     */
    public KagoKetteiShukei(FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3060KagoKetteiShukeiEntity();
        this.entity.setToriatsukaiYM(取扱年月);
        this.entity.setHokenshaKubun(保険者区分);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KagoKetteiShukeiIdentifier(
                取扱年月,
                保険者区分,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3060KagoKetteiShukeiEntity}より{@link KagoKetteiShukei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3060KagoKetteiShukeiEntity}
     */
    public KagoKetteiShukei(DbT3060KagoKetteiShukeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定集計"));
        this.id = new KagoKetteiShukeiIdentifier(
                entity.getToriatsukaiYM(),
                entity.getHokenshaKubun(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3060KagoKetteiShukeiEntity}
     * @param id {@link KagoKetteiShukeiIdentifier}
     */
    KagoKetteiShukei(
            DbT3060KagoKetteiShukeiEntity entity,
            KagoKetteiShukeiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 取扱年月を返します。
     *
     * @return 取扱年月
     */
    public FlexibleYearMonth get取扱年月() {
        return entity.getToriatsukaiYM();
    }

    /**
     * 保険者区分を返します。
     *
     * @return 保険者区分
     */
    public RString get保険者区分() {
        return entity.getHokenshaKubun();
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
     * 介護給付費件数を返します。
     *
     * @return 介護給付費件数
     */
    public int get介護給付費件数() {
        return entity.getKaigoKyufuhiKensu();
    }

    /**
     * 介護給付費単位数を返します。
     *
     * @return 介護給付費単位数
     */
    public Decimal get介護給付費単位数() {
        return entity.getKaigoKyufuhiTanisu();
    }

    /**
     * 介護給付費保険者負担額を返します。
     *
     * @return 介護給付費保険者負担額
     */
    public Decimal get介護給付費保険者負担額() {
        return entity.getKaigoKyufuhiFutangaku();
    }

    /**
     * 高額介護サービス費件数を返します。
     *
     * @return 高額介護サービス費件数
     */
    public int get高額介護サービス費件数() {
        return entity.getKogakuServicehiKensu();
    }

    /**
     * 高額介護サービス費単位数を返します。
     *
     * @return 高額介護サービス費単位数
     */
    public Decimal get高額介護サービス費単位数() {
        return entity.getKogakuServicehiTanisu();
    }

    /**
     * 高額介護サービス費保険者負担額を返します。
     *
     * @return 高額介護サービス費保険者負担額
     */
    public Decimal get高額介護サービス費保険者負担額() {
        return entity.getKogakuServicehiFutangaku();
    }

    /**
     * 特定入所者介護サービス費等件数を返します。
     *
     * @return 特定入所者介護サービス費等件数
     */
    public int get特定入所者介護サービス費等件数() {
        return entity.getTokuteiNyushoshaServicehiKensu();
    }

    /**
     * 特定入所者介護サービス費等費用額を返します。
     *
     * @return 特定入所者介護サービス費等費用額
     */
    public Decimal get特定入所者介護サービス費等費用額() {
        return entity.getTokuteiNyushoshaServicehiTanisu();
    }

    /**
     * 特定入所者介護サービス費等保険者負担額を返します。
     *
     * @return 特定入所者介護サービス費等保険者負担額
     */
    public Decimal get特定入所者介護サービス費等保険者負担額() {
        return entity.getTokuteiNyushoshaServicehiFutangaku();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohiFutanshaNo();
    }

    /**
     * 作成年月日を返します。
     *
     * @return 作成年月日
     */
    public FlexibleDate get作成年月日() {
        return entity.getSakuseiYMD();
    }

    /**
     * 取込年月を返します。
     *
     * @return 取込年月
     */
    public FlexibleYearMonth get取込年月() {
        return entity.getTorikomiYM();
    }

    /**
     * {@link DbT3060KagoKetteiShukeiEntity}のクローンを返します。
     *
     * @return {@link DbT3060KagoKetteiShukeiEntity}のクローン
     */
    @Override
    public DbT3060KagoKetteiShukeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 過誤決定集計の識別子{@link KagoKetteiShukeiIdentifier}を返します。
     *
     * @return 過誤決定集計の識別子{@link KagoKetteiShukeiIdentifier}
     */
    @Override
    public KagoKetteiShukeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する過誤決定集計を削除対象とします。<br/>
     * {@link DbT3060KagoKetteiShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KagoKetteiShukei}
     */
    @Override
    public KagoKetteiShukei deleted() {
        DbT3060KagoKetteiShukeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KagoKetteiShukei(deletedEntity, id);
    }

    /**
     * {@link KagoKetteiShukei}のシリアライズ形式を提供します。
     *
     * @return {@link KagoKetteiShukei}のシリアライズ形式
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

        private final DbT3060KagoKetteiShukeiEntity entity;
        private final KagoKetteiShukeiIdentifier id;

        private _SerializationProxy(DbT3060KagoKetteiShukeiEntity entity, KagoKetteiShukeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KagoKetteiShukei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KagoKetteiShukeiBuilder createBuilderForEdit() {
        return new KagoKetteiShukeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
