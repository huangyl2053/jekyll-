/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.view;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbV3016KyufujissekiShuruiDetailEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付実績種類詳細を管理するクラスです。
 */
public class KyufujissekiShuruiDetail extends ParentModelBase<KyufujissekiShuruiDetailIdentifier, DbV3016KyufujissekiShuruiDetailEntity, KyufujissekiShuruiDetail> implements Serializable {

    private final DbV3016KyufujissekiShuruiDetailEntity entity;
    private final KyufujissekiShuruiDetailIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 給付実績種類詳細の新規作成時に使用します。
     *
     * @param 交換情報識別番号 交換情報識別番号
     * @param 入力識別番号 入力識別番号
     * @param レコード種別コード レコード種別コード
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 事業所番号 事業所番号
     * @param 通し番号 通し番号
     */
    public KyufujissekiShuruiDetail(ShikibetsuCode 交換情報識別番号,
            ShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        this.entity = new DbV3016KyufujissekiShuruiDetailEntity();
        this.entity.setKokanShikibetsuNo(交換情報識別番号);
        this.entity.setInputShikibetsuNo(入力識別番号);
        this.entity.setRecodeShubetsuCode(レコード種別コード);
        this.entity.setHokenshaNo(証記載保険者番号);
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setJigyoshoNo(事業所番号);
        this.entity.setToshiNo(通し番号);
        this.id = new KyufujissekiShuruiDetailIdentifier(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                通し番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbV3016KyufujissekiShuruiDetailEntity}より{@link KyufujissekiShuruiDetail}を生成します。
     *
     * @param entity DBより取得した{@link DbV3016KyufujissekiShuruiDetailEntity}
     */
    public KyufujissekiShuruiDetail(DbV3016KyufujissekiShuruiDetailEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績種類詳細"));
        this.id = new KyufujissekiShuruiDetailIdentifier(
                entity.getKokanShikibetsuNo(),
                entity.getInputShikibetsuNo(),
                entity.getRecodeShubetsuCode(),
                entity.getHokenshaNo(),
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getJigyoshoNo(),
                entity.getToshiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbV3016KyufujissekiShuruiDetailEntity}
     * @param id {@link KyufujissekiShuruiDetailIdentifier}
     */
    KyufujissekiShuruiDetail(
            DbV3016KyufujissekiShuruiDetailEntity entity,
            KyufujissekiShuruiDetailIdentifier id
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
    public ShikibetsuCode get交換情報識別番号() {
        return entity.getKokanShikibetsuNo();
    }

    /**
     * 入力識別番号を返します。
     *
     * @return 入力識別番号
     */
    public ShikibetsuCode get入力識別番号() {
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
        return entity.getHokenshaNo();
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceSyuruiCode();
    }

    /**
     * 保険_利用者負担額を返します。
     *
     * @return 保険_利用者負担額
     */
    public int get保険_利用者負担額() {
        return entity.getHokenRiyoshaFutangaku();
    }

    /**
     * 後_単位数合計を返します。
     *
     * @return 後_単位数合計
     */
    public int get後_単位数合計() {
        return entity.getAtoHokenTanisuTotal();
    }

    /**
     * 後_保険請求分請求額を返します。
     *
     * @return 後_保険請求分請求額
     */
    public RString get後_保険請求分請求額() {
        return entity.getAtoHokenSeikyugaku();
    }

    /**
     * 後_保険_出来高単位数合計を返します。
     *
     * @return 後_保険_出来高単位数合計
     */
    public int get後_保険_出来高単位数合計() {
        return entity.getAtoHokenDekidakaTanisuTotal();
    }

    /**
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 後_サービス単位数合計を返します。
     *
     * @return 後_サービス単位数合計
     */
    public int get後_サービス単位数合計() {
        return entity.getAtoServiceTanisuTotal();
    }

    /**
     * 後_単位数を返します。
     *
     * @return 後_単位数
     */
    public int get後_単位数() {
        return entity.getAtotanisu();
    }

    /**
     * {@link DbV3016KyufujissekiShuruiDetailEntity}のクローンを返します。
     *
     * @return {@link DbV3016KyufujissekiShuruiDetailEntity}のクローン
     */
    @Override
    public DbV3016KyufujissekiShuruiDetailEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付実績種類詳細の識別子{@link KyufujissekiShuruiDetailIdentifier}を返します。
     *
     * @return 給付実績種類詳細の識別子{@link KyufujissekiShuruiDetailIdentifier}
     */
    @Override
    public KyufujissekiShuruiDetailIdentifier identifier() {
        return this.id;
    }

    /**
     * 給付実績種類詳細のみを変更対象とします。<br/>
     * {@link DbV3016KyufujissekiShuruiDetailEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyufujissekiShuruiDetail}
     */
    @Override
    public KyufujissekiShuruiDetail modifiedModel() {
        DbV3016KyufujissekiShuruiDetailEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyufujissekiShuruiDetail(
                modifiedEntity, id);
    }

    /**
     * 保持する給付実績種類詳細を削除対象とします。<br/>
     * {@link DbV3016KyufujissekiShuruiDetailEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufujissekiShuruiDetail}
     */
    @Override
    public KyufujissekiShuruiDetail deleted() {
        DbV3016KyufujissekiShuruiDetailEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufujissekiShuruiDetail(deletedEntity, id);
    }

    /**
     * {@link KyufujissekiShuruiDetail}のシリアライズ形式を提供します。
     *
     * @return {@link KyufujissekiShuruiDetail}のシリアライズ形式
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
        private final DbV3016KyufujissekiShuruiDetailEntity entity;
        private final KyufujissekiShuruiDetailIdentifier id;

        private _SerializationProxy(DbV3016KyufujissekiShuruiDetailEntity entity, KyufujissekiShuruiDetailIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufujissekiShuruiDetail(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufujissekiShuruiDetailBuilder createBuilderForEdit() {
        return new KyufujissekiShuruiDetailBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
