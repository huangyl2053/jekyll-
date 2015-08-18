/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成明細を管理するクラスです。
 */
public class KyotakuKeikakuJikosakuseiMeisai extends ModelBase<KyotakuKeikakuJikosakuseiMeisaiIdentifier, DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity, KyotakuKeikakuJikosakuseiMeisai> implements Serializable {

    private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
    private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 居宅給付計画自己作成明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     */
    public KyotakuKeikakuJikosakuseiMeisai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号,
            RString 居宅サービス区分,
            JigyoshaNo サービス提供事業者番号,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(サービス提供事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        this.entity = new DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setKyotakuServiceKubun(居宅サービス区分);
        this.entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.id = new KyotakuKeikakuJikosakuseiMeisaiIdentifier(
                被保険者番号,
                対象年月,
                履歴番号,
                居宅サービス区分,
                サービス提供事業者番号,
                サービス種類コード,
                サービス項目コード
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}より{@link KyotakuKeikakuJikosakuseiMeisai}を生成します。
     *
     * @param entity
     * DBより取得した{@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     */
    public KyotakuKeikakuJikosakuseiMeisai(DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成明細"));
        this.id = new KyotakuKeikakuJikosakuseiMeisaiIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo(),
                entity.getKyotakuServiceKubun(),
                entity.getServiceTeikyoJigyoshaNo(),
                entity.getServiceShuruiCode(),
                entity.getServiceKomokuCode());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     * @param id {@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}
     */
    KyotakuKeikakuJikosakuseiMeisai(
            DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity,
            KyotakuKeikakuJikosakuseiMeisaiIdentifier id
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
     * 対象年月を返します。
     *
     * @return 対象年月
     */
    public FlexibleYearMonth get対象年月() {
        return entity.getTaishoYM();
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
     * 居宅サービス区分を返します。
     *
     * @return 居宅サービス区分
     */
    public RString get居宅サービス区分() {
        return entity.getKyotakuServiceKubun();
    }

    /**
     * サービス提供事業者番号を返します。
     *
     * @return サービス提供事業者番号
     */
    public JigyoshaNo getサービス提供事業者番号() {
        return entity.getServiceTeikyoJigyoshaNo();
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
     * サービス項目コードを返します。
     *
     * @return サービス項目コード
     */
    public ServiceKomokuCode getサービス項目コード() {
        return entity.getServiceKomokuCode();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public Decimal get単位数() {
        return entity.getTaniSu();
    }

    /**
     * 回数・日数を返します。
     *
     * @return 回数_日数
     */
    public Decimal get回数_日数() {
        return entity.getKaisu_Nissu();
    }

    /**
     * 種類限度内単位数・日数を返します。
     *
     * @return 種類限度内単位数_日数
     */
    public Decimal get種類限度内単位数_日数() {
        return entity.getShuruiGendoNaiTaniSu_Nissu();
    }

    /**
     * 種類限度超過単位数・日数を返します。
     *
     * @return 種類限度超過単位数_日数
     */
    public Decimal get種類限度超過単位数_日数() {
        return entity.getShuruiGendoChokaTaniSu_Nissu();
    }

    /**
     * 区分限度内単位数・日数を返します。
     *
     * @return 区分限度内単位数・日数
     */
    public Decimal get区分限度内単位数_日数() {
        return entity.getKubunGendoNaiTaniSu_Nissu();
    }

    /**
     * 区分限度超過単位数・日数を返します。
     *
     * @return 区分限度超過単位数・日数
     */
    public Decimal get区分限度超過単位数_日数() {
        return entity.getKubunGendoChokaTaniSu_Nissu();
    }

    /**
     * 単位数単価を返します。
     *
     * @return 単位数単価
     */
    public Decimal get単位数単価() {
        return entity.getTaniSuTanka();
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
     * 割引後適用率を返します。
     *
     * @return 割引後適用率
     */
    public HokenKyufuRitsu get割引後適用率() {
        return entity.getWaribikiGoTekiyoRitsu();
    }

    /**
     * 割引後適用単位数を返します。
     *
     * @return 割引後適用単位数
     */
    public Decimal get割引後適用単位数() {
        return entity.getWaribikiGoTekiyoTaniSu();
    }

    /**
     * 給付対象日数を返します。
     *
     * @return 給付対象日数
     */
    public Decimal get給付対象日数() {
        return entity.getKyufuTaishoNissu();
    }

    /**
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}のクローン
     */
    @Override
    public DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 居宅給付計画自己作成明細の識別子{@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}を返します。
     *
     * @return 居宅給付計画自己作成明細の識別子{@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}
     */
    @Override
    public KyotakuKeikakuJikosakuseiMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する居宅給付計画自己作成明細を削除対象とします。<br/>
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJikosakuseiMeisai}
     */
    @Override
    public KyotakuKeikakuJikosakuseiMeisai deleted() {
        DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJikosakuseiMeisai(deletedEntity, id);
    }

    /**
     * {@link KyotakuKeikakuJikosakuseiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJikosakuseiMeisai}のシリアライズ形式
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

        private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
        private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;

        private _SerializationProxy(DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity, KyotakuKeikakuJikosakuseiMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJikosakuseiMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJikosakuseiMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
