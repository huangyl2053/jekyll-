/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3120YoboKeikakuJikoSakuseiKanriEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 予防給付計画自己作成管理を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 cuilin
 */
public class YoboKeikakuJikoSakuseiKanri extends
        ModelBase<YoboKeikakuJikoSakuseiKanriIdentifier, DbT3120YoboKeikakuJikoSakuseiKanriEntity, YoboKeikakuJikoSakuseiKanri>
        implements Serializable {

    private final DbT3120YoboKeikakuJikoSakuseiKanriEntity entity;
    private final YoboKeikakuJikoSakuseiKanriIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 予防給付計画自己作成管理の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @param 利用年月 利用年月
     * @param 居宅サービス区分 居宅サービス区分
     * @param 明細番号 明細番号
     */
    public YoboKeikakuJikoSakuseiKanri(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            FlexibleYearMonth 利用年月,
            RString 居宅サービス区分,
            int 明細番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(利用年月, UrSystemErrorMessages.値がnull.getReplacedMessage("利用年月"));
        requireNonNull(居宅サービス区分, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス区分"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        this.entity = new DbT3120YoboKeikakuJikoSakuseiKanriEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoYM(対象年月);
        this.entity.setRirekiNo(履歴番号);
        this.entity.setRiyoYM(利用年月);
        this.entity.setKyotakuServiceKubun(居宅サービス区分);
        this.entity.setMeisaiNo(明細番号);
        this.id = new YoboKeikakuJikoSakuseiKanriIdentifier(
                被保険者番号,
                対象年月,
                履歴番号,
                利用年月,
                居宅サービス区分,
                明細番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}より{@link YoboKeikakuJikoSakuseiKanri}を生成します。
     *
     * @param entity DBより取得した{@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}
     */
    public YoboKeikakuJikoSakuseiKanri(DbT3120YoboKeikakuJikoSakuseiKanriEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成管理"));
        this.id = new YoboKeikakuJikoSakuseiKanriIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoYM(),
                entity.getRirekiNo(),
                entity.getRiyoYM(),
                entity.getKyotakuServiceKubun(),
                entity.getMeisaiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}
     * @param id {@link YoboKeikakuJikoSakuseiKanriIdentifier}
     */
    YoboKeikakuJikoSakuseiKanri(
            DbT3120YoboKeikakuJikoSakuseiKanriEntity entity,
            YoboKeikakuJikoSakuseiKanriIdentifier id
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
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 利用年月を返します。
     *
     * @return 利用年月
     */
    public FlexibleYearMonth get利用年月() {
        return entity.getRiyoYM();
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
     * 明細番号を返します。
     *
     * @return 明細番号
     */
    public int get明細番号() {
        return entity.getMeisaiNo();
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
     * 合計明細フラグを返します。
     *
     * @return 合計明細フラグ
     */
    public boolean is合計明細フラグ() {
        return entity.getGoukeiFlag();
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
     * @return 区分限度内単位数_日数
     */
    public Decimal get区分限度内単位数_日数() {
        return entity.getKubunGendoNaiTaniSu_Nissu();
    }

    /**
     * 区分限度超過単位数・日数を返します。
     *
     * @return 区分限度超過単位数_日数
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
     * 給付計画単位数を返します。
     *
     * @return 給付計画単位数
     */
    public Decimal get給付計画単位数() {
        return entity.getKeikakuTaniSu();
    }

    /**
     * {@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}のクローンを返します。
     *
     * @return {@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}のクローン
     */
    @Override
    public DbT3120YoboKeikakuJikoSakuseiKanriEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 予防給付計画自己作成管理の識別子{@link YoboKeikakuJikoSakuseiKanriIdentifier}を返します。
     *
     * @return 予防給付計画自己作成管理の識別子{@link YoboKeikakuJikoSakuseiKanriIdentifier}
     */
    @Override
    public YoboKeikakuJikoSakuseiKanriIdentifier identifier() {
        return this.id;
    }

    /**
     * 予防給付計画自己作成管理を削除対象とします。<br/>
     * {@link DbT3120YoboKeikakuJikoSakuseiKanriEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ChiikiMitchakuServiceCode}
     */
    @Override
    public YoboKeikakuJikoSakuseiKanri deleted() {
        DbT3120YoboKeikakuJikoSakuseiKanriEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new YoboKeikakuJikoSakuseiKanri(deletedEntity, id);
    }

    /**
     * {@link YoboKeikakuJikoSakuseiKanri}のシリアライズ形式を提供します。
     *
     * @return {@link YoboKeikakuJikoSakuseiKanri}のシリアライズ形式
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

        private final DbT3120YoboKeikakuJikoSakuseiKanriEntity entity;
        private final YoboKeikakuJikoSakuseiKanriIdentifier id;

        private _SerializationProxy(DbT3120YoboKeikakuJikoSakuseiKanriEntity entity, YoboKeikakuJikoSakuseiKanriIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new YoboKeikakuJikoSakuseiKanri(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public YoboKeikakuJikoSakuseiKanriBuilder createBuilderForEdit() {
        return new YoboKeikakuJikoSakuseiKanriBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
