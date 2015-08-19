/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 過誤決定明細を管理するクラスです。
 */
public class KagoKetteiMeisai extends ModelBase<KagoKetteiMeisaiIdentifier, DbT3061KagoKetteiMeisaiEntity, KagoKetteiMeisai> implements Serializable {

    private final DbT3061KagoKetteiMeisaiEntity entity;
    private final KagoKetteiMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 過誤決定明細の新規作成時に使用します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     */
    public KagoKetteiMeisai(FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3061KagoKetteiMeisaiEntity();
        this.entity.setToriatsukaiYM(取扱年月);
        this.entity.setHokenshaKubun(保険者区分);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KagoKetteiMeisaiIdentifier(
                取扱年月,
                保険者区分,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3061KagoKetteiMeisaiEntity}より{@link KagoKetteiMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3061KagoKetteiMeisaiEntity}
     */
    public KagoKetteiMeisai(DbT3061KagoKetteiMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定明細"));
        this.id = new KagoKetteiMeisaiIdentifier(
                entity.getToriatsukaiYM(),
                entity.getHokenshaKubun(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3061KagoKetteiMeisaiEntity}
     * @param id {@link KagoKetteiMeisaiIdentifier}
     */
    KagoKetteiMeisai(
            DbT3061KagoKetteiMeisaiEntity entity,
            KagoKetteiMeisaiIdentifier id
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
     * 事業所番号を返します。
     *
     * @return 事業所番号
     */
    public JigyoshaNo get事業所番号() {
        return entity.getJigyoshoNo();
    }

    /**
     * 事業所名を返します。
     *
     * @return 事業所名
     */
    public RString get事業所名() {
        return entity.getJigyoshoName();
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
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohiJukyushaNo();
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
     * サービス提供年月を返します。
     *
     * @return サービス提供年月
     */
    public FlexibleYearMonth getサービス提供年月() {
        return entity.getServiceTeikyoYM();
    }

    /**
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * サービス種類名を返します。
     *
     * @return サービス種類名
     */
    public RString getサービス種類名() {
        return entity.getServiceShuruiName();
    }

    /**
     * 過誤申立事由コードを返します。
     *
     * @return 過誤申立事由コード
     */
    public Code get過誤申立事由コード() {
        return entity.getKagomoushitateJiyuCode();
    }

    /**
     * 過誤申立事由を返します。
     *
     * @return 過誤申立事由
     */
    public RString get過誤申立事由() {
        return entity.getKagomoushitateJiyu();
    }

    /**
     * 単位数（特定入所者介護費等）を返します。
     *
     * @return 単位数（特定入所者介護費等）
     */
    public Decimal get単位数_特定入所者介護費等() {
        return entity.getTanisu();
    }

    /**
     * 保険者負担額を返します。
     *
     * @return 保険者負担額
     */
    public Decimal get保険者負担額() {
        return entity.getHokenshaFutangaku();
    }

    /**
     * {@link DbT3061KagoKetteiMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3061KagoKetteiMeisaiEntity}のクローン
     */
    @Override
    public DbT3061KagoKetteiMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 過誤決定明細の識別子{@link KagoKetteiMeisaiIdentifier}を返します。
     *
     * @return 過誤決定明細の識別子{@link KagoKetteiMeisaiIdentifier}
     */
    @Override
    public KagoKetteiMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する過誤決定明細を削除対象とします。<br/>
     * {@link DbT3061KagoKetteiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KagoKetteiMeisai}
     */
    @Override
    public KagoKetteiMeisai deleted() {
        DbT3061KagoKetteiMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KagoKetteiMeisai(deletedEntity, id);
    }

    /**
     * {@link KagoKetteiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KagoKetteiMeisai}のシリアライズ形式
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

        private final DbT3061KagoKetteiMeisaiEntity entity;
        private final KagoKetteiMeisaiIdentifier id;

        private _SerializationProxy(DbT3061KagoKetteiMeisaiEntity entity, KagoKetteiMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KagoKetteiMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KagoKetteiMeisaiBuilder createBuilderForEdit() {
        return new KagoKetteiMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
