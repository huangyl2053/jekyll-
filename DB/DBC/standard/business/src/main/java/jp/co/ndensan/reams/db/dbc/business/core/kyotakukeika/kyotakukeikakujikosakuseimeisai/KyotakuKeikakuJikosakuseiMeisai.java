/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseimeisai;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokei;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseigokei.KyotakuKeikakuJikoSakuseiGokeiIdentifier;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.kyotakukeikakujikosakuseitankinyushoriyonissu.KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kyotakukeika.kyotakukeikakujikosakuseimeisai.KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.Models;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 居宅給付計画自己作成明細を管理するクラスです。
 */
public class KyotakuKeikakuJikosakuseiMeisai
        extends ParentModelBase<KyotakuKeikakuJikosakuseiMeisaiIdentifier, DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity, KyotakuKeikakuJikosakuseiMeisai>
        implements Serializable {

    private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
    private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;
    private final Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei;
    private final Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;

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
        this.kyotakuKeikakuJikoSakuseiGokei = Models.create(new ArrayList<KyotakuKeikakuJikoSakuseiGokei>());
        this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu = Models.create(new ArrayList<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}より{@link KyotakuKeikakuJikosakuseiMeisai}を生成します。
     *
     * @param entity DBより取得した{@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     */
    public KyotakuKeikakuJikosakuseiMeisai(KyotakuKeikakuJikosakuseiMeisaiEntity entity) {
        this.entity = requireNonNull(entity.get居宅給付計画自己作成明細Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成明細"));
        this.id = new KyotakuKeikakuJikosakuseiMeisaiIdentifier(
                entity.get居宅給付計画自己作成明細Entity().getHihokenshaNo(),
                entity.get居宅給付計画自己作成明細Entity().getTaishoYM(),
                entity.get居宅給付計画自己作成明細Entity().getRirekiNo(),
                entity.get居宅給付計画自己作成明細Entity().getKyotakuServiceKubun(),
                entity.get居宅給付計画自己作成明細Entity().getServiceTeikyoJigyoshaNo(),
                entity.get居宅給付計画自己作成明細Entity().getServiceShuruiCode(),
                entity.get居宅給付計画自己作成明細Entity().getServiceKomokuCode());
        List<KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokeiList = new ArrayList<>();
        for (DbT3009KyotakuKeikakuJikoSakuseiGokeiEntity gokeiEntity : entity.get居宅給付計画自己作成合計Entity()) {
            kyotakuKeikakuJikoSakuseiGokeiList.add(new KyotakuKeikakuJikoSakuseiGokei(gokeiEntity));
        }
        this.kyotakuKeikakuJikoSakuseiGokei = Models.create(kyotakuKeikakuJikoSakuseiGokeiList);

        List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuList = new ArrayList<>();
        for (DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity riyoNissuEntity : entity.get居宅給付計画自己作成短期入所利用日数Entity()) {
            kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuList.add(new KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(riyoNissuEntity));
        }
        this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu = Models.create(kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}
     * @param id {@link KyotakuKeikakuJikosakuseiMeisaiIdentifier}
     */
    KyotakuKeikakuJikosakuseiMeisai(
            DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity,
            KyotakuKeikakuJikosakuseiMeisaiIdentifier id, Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei,
            Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
    ) {
        this.entity = entity;
        this.id = id;
        this.kyotakuKeikakuJikoSakuseiGokei = kyotakuKeikakuJikoSakuseiGokei;
        this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu = kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
    }

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
     * 居宅給付計画自己作成明細配下の要素を削除対象とします。<br/>
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 居宅給付計画自己作成明細配下の要素である居宅給付計画自己作成合計の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link KyotakuKeikakuJikosakuseiMeisai}を返します。
     *
     * @return 削除対象処理実施後の{@link KyotakuKeikakuJikosakuseiMeisai}
     * @throws IllegalStateException DbT3008KyotakuKeikakuJikosakuseiMeisaiEntityのデータ状態が変更の場合
     */
    @Override
    public KyotakuKeikakuJikosakuseiMeisai deleted() {
        DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyotakuKeikakuJikosakuseiMeisai(
                deletedEntity, id, kyotakuKeikakuJikoSakuseiGokei.deleted(), kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kyotakuKeikakuJikoSakuseiGokei.hasAnyChanged() || kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.hasAnyChanged();
    }

    /**
     * 居宅給付計画自己作成明細のみを変更対象とします。<br/>
     * {@link DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyotakuKeikakuJikosakuseiMeisai}
     */
    @Override
    public KyotakuKeikakuJikosakuseiMeisai modifiedModel() {
        DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyotakuKeikakuJikosakuseiMeisai(
                modifiedEntity, id, kyotakuKeikakuJikoSakuseiGokei, kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu);
    }

    /**
     * 居宅給付計画自己作成明細が保持する居宅給付計画自己作成合計に対して、指定の識別子に該当する居宅給付計画自己作成合計を返します。
     *
     * @param id 居宅給付計画自己作成合計の識別子
     * @return 居宅給付計画自己作成合計
     * @throws IllegalStateException 指定の識別子に該当する居宅給付計画自己作成合計がない場合
     */
    public KyotakuKeikakuJikoSakuseiGokei getKyotakuKeikakuJikoSakuseiGokei(KyotakuKeikakuJikoSakuseiGokeiIdentifier id) {
        if (kyotakuKeikakuJikoSakuseiGokei.contains(id)) {
            return kyotakuKeikakuJikoSakuseiGokei.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画自己作成明細が保持する居宅給付計画自己作成合計をリストで返します。
     *
     * @return 居宅給付計画自己作成合計リスト
     */
    public List<KyotakuKeikakuJikoSakuseiGokei> getKyotakuKeikakuJikoSakuseiGokeiList() {
        return new ArrayList<>(kyotakuKeikakuJikoSakuseiGokei.values());

    }

    /**
     * 居宅給付計画自己作成明細が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 届出者情報の識別子
     * @return 届出者情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu getKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu(KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier id) {
        if (kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.contains(id)) {
            return kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 居宅給付計画自己作成明細が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> getKyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuList() {
        return new ArrayList<>(kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu.values());
    }

    /**
     * {@link KyotakuKeikakuJikosakuseiMeisai}のシリアライズ形式を提供します。
     *
     * @return {@link KyotakuKeikakuJikosakuseiMeisai}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kyotakuKeikakuJikoSakuseiGokei, kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity;
        private final KyotakuKeikakuJikosakuseiMeisaiIdentifier id;
        private final Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei;
        private final Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;

        private _SerializationProxy(
                DbT3008KyotakuKeikakuJikosakuseiMeisaiEntity entity,
                KyotakuKeikakuJikosakuseiMeisaiIdentifier id,
                Models<KyotakuKeikakuJikoSakuseiGokeiIdentifier, KyotakuKeikakuJikoSakuseiGokei> kyotakuKeikakuJikoSakuseiGokei,
                Models<KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuIdentifier, KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu> kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu
        ) {
            this.entity = entity;
            this.id = id;
            this.kyotakuKeikakuJikoSakuseiGokei = kyotakuKeikakuJikoSakuseiGokei;
            this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu = kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu;
        }

        private Object readResolve() {
            return new KyotakuKeikakuJikosakuseiMeisai(this.entity, this.id, this.kyotakuKeikakuJikoSakuseiGokei, this.kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KyotakuKeikakuJikosakuseiMeisaiBuilder#build()}を使用してください。
     *
     * @return {@link KyotakuKeikakuJikosakuseiMeisaiBuilder}
     */
    public KyotakuKeikakuJikosakuseiMeisaiBuilder createBuilderForEdit() {
        return new KyotakuKeikakuJikosakuseiMeisaiBuilder(entity, id, kyotakuKeikakuJikoSakuseiGokei, kyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissu);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KyotakuKeikakuJikosakuseiMeisai other = (KyotakuKeikakuJikosakuseiMeisai) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
