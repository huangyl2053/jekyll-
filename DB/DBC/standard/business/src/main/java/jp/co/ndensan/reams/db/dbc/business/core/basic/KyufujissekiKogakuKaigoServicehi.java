/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績高額介護サービス費を管理するクラスです。
 *
 * @reamsid_L DBC-9999-070 quxiaodong
 */
public class KyufujissekiKogakuKaigoServicehi
        extends ModelBase<KyufujissekiKogakuKaigoServicehiIdentifier, DbT3028KyufujissekiKogakuKaigoServicehiEntity, KyufujissekiKogakuKaigoServicehi>
        implements Serializable {

    private final DbT3028KyufujissekiKogakuKaigoServicehiEntity entity;
    private final KyufujissekiKogakuKaigoServicehiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績高額介護サービス費の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 通し番号 通し番号
     * @param 給付実績情報作成区分コード 給付実績情報作成区分コード
     * @param 給付実績区分コード 給付実績区分コード
     */
    public KyufujissekiKogakuKaigoServicehi(KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通し番号,
            RString 給付実績情報作成区分コード,
            RString 給付実績区分コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        this.entity = new DbT3028KyufujissekiKogakuKaigoServicehiEntity();
        this.entity.setKokanJohoShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setToshiNo(通し番号);
        this.entity.setKyufuSakuseiKubunCode(給付実績情報作成区分コード);
        this.entity.setKyufuJissekiKubunCode(給付実績区分コード);
        this.id = new KyufujissekiKogakuKaigoServicehiIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                通し番号,
                給付実績情報作成区分コード,
                給付実績区分コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}より{@link KyufujissekiKogakuKaigoServicehi}を生成します。
     *
     * @param entity DBより取得した{@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}
     */
    public KyufujissekiKogakuKaigoServicehi(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績高額介護サービス費"));
        this.id = new KyufujissekiKogakuKaigoServicehiIdentifier(
                entity.getKokanJohoShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getShokisaiHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getToshiNo(),
                entity.getKyufuSakuseiKubunCode(),
                entity.getKyufuJissekiKubunCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}
     * @param id {@link KyufujissekiKogakuKaigoServicehiIdentifier}
     */
    KyufujissekiKogakuKaigoServicehi(
            DbT3028KyufujissekiKogakuKaigoServicehiEntity entity,
            KyufujissekiKogakuKaigoServicehiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 交換情報識別番号を返します。
     *
     * @return 交換情報識別番号
     */
    public KokanShikibetsuNo get交換情報識別番号() {
        return entity.getKokanJohoShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public NyuryokuShikibetsuNo get入力識別番号() {
        return entity.getInputShikibetsuNo();
    }

    /**
     * レコード種別コードを返します。
     *
     * @return レコード種別コード
     */
    public RString getレコード種別コード() {
        return entity.getRecodeShubetsuCode();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
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
     * 通し番号を返します。
     *
     * @return 通し番号
     */
    public RString get通し番号() {
        return entity.getToshiNo();
    }

    /**
     * 給付実績情報作成区分コードを返します。
     *
     * @return 給付実績情報作成区分コード
     */
    public RString get給付実績情報作成区分コード() {
        return entity.getKyufuSakuseiKubunCode();
    }

    /**
     * 給付実績区分コードを返します。
     *
     * @return 給付実績区分コード
     */
    public RString get給付実績区分コード() {
        return entity.getKyufuJissekiKubunCode();
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
     * 公費１負担番号を返します。
     *
     * @return 公費１負担番号
     */
    public RString get公費１負担番号() {
        return entity.getKohi1FutanNo();
    }

    /**
     * 公費２負担番号を返します。
     *
     * @return 公費２負担番号
     */
    public RString get公費２負担番号() {
        return entity.getKohi2FutanNo();
    }

    /**
     * 公費３負担番号を返します。
     *
     * @return 公費３負担番号
     */
    public RString get公費３負担番号() {
        return entity.getKohi3FutanNo();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 公費１負担額を返します。
     *
     * @return 公費１負担額
     */
    public int get公費１負担額() {
        return entity.getKohi1Futangaku();
    }

    /**
     * 公費２負担額を返します。
     *
     * @return 公費２負担額
     */
    public int get公費２負担額() {
        return entity.getKohi2Futangaku();
    }

    /**
     * 公費３負担額を返します。
     *
     * @return 公費３負担額
     */
    public int get公費３負担額() {
        return entity.getKohi3Futangaku();
    }

    /**
     * 支給額を返します。
     *
     * @return 支給額
     */
    public int get支給額() {
        return entity.getShikyugaku();
    }

    /**
     * 公費１支給額を返します。
     *
     * @return 公費１支給額
     */
    public int get公費１支給額() {
        return entity.getKohi1Shikyugaku();
    }

    /**
     * 公費２支給額を返します。
     *
     * @return 公費２支給額
     */
    public int get公費２支給額() {
        return entity.getKohi2Shikyugaku();
    }

    /**
     * 公費３支給額を返します。
     *
     * @return 公費３支給額
     */
    public int get公費３支給額() {
        return entity.getKohi3Shikyugaku();
    }

    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
    }

    /**
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
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
     * 作成区分を返します。
     *
     * @return 作成区分
     */
    public RString get作成区分() {
        return entity.getSakuseiKubun();
    }

    /**
     * 管理番号を返します。
     *
     * @return 管理番号
     */
    public RString get管理番号() {
        return entity.getKanriNo();
    }

    /**
     * 保険者保有給付実績情報削除済フラグを返します。
     *
     * @return 保険者保有給付実績情報削除済フラグ
     */
    public boolean is保険者保有給付実績情報削除済フラグ() {
        return entity.getHokenshaHoyuKyufujissekiJohoSakujoZumiFlag();
    }

    /**
     * {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}のクローンを返します。
     *
     * @return {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}のクローン
     */
    @Override
    public DbT3028KyufujissekiKogakuKaigoServicehiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績高額介護サービス費の識別子{@link KyufujissekiKogakuKaigoServicehiIdentifier}を返します。
     *
     * @return 給付実績高額介護サービス費の識別子{@link KyufujissekiKogakuKaigoServicehiIdentifier}
     */
    @Override
    public KyufujissekiKogakuKaigoServicehiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付実績高額介護サービス費を削除対象とします。<br/>
     * {@link DbT3028KyufujissekiKogakuKaigoServicehiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiKogakuKaigoServicehi}
     */
    @Override
    public KyufujissekiKogakuKaigoServicehi deleted() {
        DbT3028KyufujissekiKogakuKaigoServicehiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiKogakuKaigoServicehi(deletedEntity, id);
    }

    /**
     * add ShokanMeisaiJushochiTokurei
     *
     * @return ShokanMeisaiJushochiTokurei {@link ShokanMeisai}のクローン
     */
    public KyufujissekiKogakuKaigoServicehi added() {
        DbT3028KyufujissekiKogakuKaigoServicehiEntity addedEntity = this.toEntity();
        addedEntity.setState(EntityDataState.Added);
        //TODO メッセージの検討
        return new KyufujissekiKogakuKaigoServicehi(addedEntity, id);
    }

    /**
     * {@link KyufujissekiKogakuKaigoServicehi}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiKogakuKaigoServicehi}のシリアライズ形式
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

        private final DbT3028KyufujissekiKogakuKaigoServicehiEntity entity;
        private final KyufujissekiKogakuKaigoServicehiIdentifier id;

        private _SerializationProxy(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity, KyufujissekiKogakuKaigoServicehiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiKogakuKaigoServicehi(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiKogakuKaigoServicehiBuilder createBuilderForEdit() {
        return new KyufujissekiKogakuKaigoServicehiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
