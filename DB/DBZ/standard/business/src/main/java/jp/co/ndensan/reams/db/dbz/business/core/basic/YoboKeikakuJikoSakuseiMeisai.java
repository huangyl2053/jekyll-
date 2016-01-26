/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3011YoboKeikakuJikoSakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 予防給付計画自己作成明細を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiMeisai extends
        ModelBase<YoboKeikakuJikoSakuseiMeisaiIdentifier, DbT3011YoboKeikakuJikoSakuseiMeisaiEntity, YoboKeikakuJikoSakuseiMeisai> implements Serializable {

    private final DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity;
    private final YoboKeikakuJikoSakuseiMeisaiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 予防給付計画自己作成明細の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 居宅サービス区分 居宅サービス区分
     * @param サービス提供事業者番号 サービス提供事業者番号
     * @param サービス種類コード サービス種類コード
     * @param サービス項目コード サービス項目コード
     */
    public YoboKeikakuJikoSakuseiMeisai(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Integer 履歴番号,
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
        this.entity = new DbT3011YoboKeikakuJikoSakuseiMeisaiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setKyotakuServiceKubun(居宅サービス区分);
        this.entity.setServiceTeikyoJigyoshaNo(サービス提供事業者番号);
        this.entity.setServiceShuruiCode(サービス種類コード);
        this.entity.setServiceKomokuCode(サービス項目コード);
        this.id = new YoboKeikakuJikoSakuseiMeisaiIdentifier(
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
     * DBより取得した{@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}より{@link YoboKeikakuJikoSakuseiMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}
     */
    public YoboKeikakuJikoSakuseiMeisai(DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成明細"));
        this.id = new YoboKeikakuJikoSakuseiMeisaiIdentifier(
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
     * @param entity {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}
     * @param id {@link YoboKeikakuJikoSakuseiMeisaiIdentifier}
     */
    YoboKeikakuJikoSakuseiMeisai(
            DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity,
            YoboKeikakuJikoSakuseiMeisaiIdentifier id
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
    public Integer get履歴番号() {
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
     * @return 回数・日数
     */
    public Decimal get回数_日数() {
        return entity.getKaisu_Nissu();
    }

    /**
     * 種類限度内単位数・日数を返します。
     *
     * @return 種類限度内単位数・日数
     */
    public Decimal get種類限度内単位数_日数() {
        return entity.getShuruiGendoNaiTaniSu_Nissu();
    }

    /**
     * 種類限度超過単位数・日数を返します。
     *
     * @return 種類限度超過単位数・日数
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
     * 定額利用者負担単価金額を返します。
     *
     * @return 定額利用者負担単価金額
     */
    public Decimal get定額利用者負担単価金額() {
        return entity.getTeigakuRiyoshaFutanTankaKingaku();
    }

    /**
     * {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}のクローンを返します。
     *
     * @return {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}のクローン
     */
    @Override
    public DbT3011YoboKeikakuJikoSakuseiMeisaiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 予防給付計画自己作成明細の識別子{@link YoboKeikakuJikoSakuseiMeisaiIdentifier}を返します。
     *
     * @return 予防給付計画自己作成明細の識別子{@link YoboKeikakuJikoSakuseiMeisaiIdentifier}
     */
    @Override
    public YoboKeikakuJikoSakuseiMeisaiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する予防給付計画自己作成明細を削除対象とします。<br/>
     * {@link DbT3011YoboKeikakuJikoSakuseiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link YoboKeikakuJikoSakuseiMeisai}
     */
    @Override
    public YoboKeikakuJikoSakuseiMeisai deleted() {
        DbT3011YoboKeikakuJikoSakuseiMeisaiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new YoboKeikakuJikoSakuseiMeisai(deletedEntity, id);
    }

    /**
     * {@link YoboKeikakuJikoSakuseiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link YoboKeikakuJikoSakuseiMeisai}のシリアライズ形式
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

        private final DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity;
        private final YoboKeikakuJikoSakuseiMeisaiIdentifier id;

        private _SerializationProxy(DbT3011YoboKeikakuJikoSakuseiMeisaiEntity entity, YoboKeikakuJikoSakuseiMeisaiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new YoboKeikakuJikoSakuseiMeisai(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public YoboKeikakuJikoSakuseiMeisaiBuilder createBuilderForEdit() {
        return new YoboKeikakuJikoSakuseiMeisaiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
