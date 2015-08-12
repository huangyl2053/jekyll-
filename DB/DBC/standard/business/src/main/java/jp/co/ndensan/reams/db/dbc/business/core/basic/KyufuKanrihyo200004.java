/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.IModel;
import jp.co.ndensan.reams.db.dbc.business.core.fdz.uzclasskoho.Models;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3014KyufuKanrihyo200004Entity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 給付管理票200004を管理するクラスです。
 */
public class KyufuKanrihyo200004 extends ParentModelBase<KyufuKanrihyo200004Identifier, DbT3014KyufuKanrihyo200004Entity, KyufuKanrihyo200004> implements Serializable {

    private final DbT3014KyufuKanrihyo200004Entity entity;
    private final KyufuKanrihyo200004Identifier id;

    /**
     * コンストラクタです。<br/>
     * 給付管理票200004の新規作成時に使用します。
     *
     * @param 審査年月 審査年月
     * @param サービス提供年月 サービス提供年月
     * @param 証記載保険者番号 証記載保険者番号
     * @param 居宅支援事業所番号 居宅支援事業所番号
     * @param 給付管理票情報作成区分コード 給付管理票情報作成区分コード
     * @param 給付管理票作成年月日 給付管理票作成年月日
     * @param 給付管理票種別区分コード 給付管理票種別区分コード
     * @param 給付管理票明細行番号 給付管理票明細行番号
     */
    public KyufuKanrihyo200004(FlexibleYearMonth 審査年月,
FlexibleYearMonth サービス提供年月,
HokenshaNo 証記載保険者番号,
JigyoshaNo 居宅支援事業所番号,
RString 給付管理票情報作成区分コード,
FlexibleDate 給付管理票作成年月日,
RString 給付管理票種別区分コード,
RString 給付管理票明細行番号) {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(居宅支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅支援事業所番号"));
        requireNonNull(給付管理票情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票情報作成区分コード"));
        requireNonNull(給付管理票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票作成年月日"));
        requireNonNull(給付管理票種別区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票種別区分コード"));
        requireNonNull(給付管理票明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票明細行番号"));
        this.entity = new DbT3014KyufuKanrihyo200004Entity();
        this.entity.setShinsaYM(審査年月);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
        this.entity.setKyufuKanrihyoSakuseiKubunCode(給付管理票情報作成区分コード);
        this.entity.setKyufuKanrihyoSakuseiYMD(給付管理票作成年月日);
        this.entity.setKyufuKanrihyoShubetsuKubunCode(給付管理票種別区分コード);
        this.entity.setKyufuKanrihyoMeisaiLineNo(給付管理票明細行番号);
        this.id = new KyufuKanrihyo200004Identifier(
        審査年月,
        サービス提供年月,
        証記載保険者番号,
        居宅支援事業所番号,
        給付管理票情報作成区分コード,
        給付管理票作成年月日,
        給付管理票種別区分コード,
        給付管理票明細行番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3014KyufuKanrihyo200004Entity}より{@link KyufuKanrihyo200004}を生成します。
     *
     * @param entity DBより取得した{@link DbT3014KyufuKanrihyo200004Entity}
     */
    public KyufuKanrihyo200004(DbT3014KyufuKanrihyo200004Entity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票200004"));
        this.id = new KyufuKanrihyo200004Identifier(
                entity.getShinsaYM(),
                entity.getServiceTeikyoYM(),
                entity.getShokisaiHokenshaNo(),
                entity.getKyotakushienJigyoshoNo(),
                entity.getKyufuKanrihyoSakuseiKubunCode(),
                entity.getKyufuKanrihyoSakuseiYMD(),
                entity.getKyufuKanrihyoShubetsuKubunCode(),
                entity.getKyufuKanrihyoMeisaiLineNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3014KyufuKanrihyo200004Entity}
     * @param id {@link KyufuKanrihyo200004Identifier}
     */
    KyufuKanrihyo200004(
            DbT3014KyufuKanrihyo200004Entity entity,
            KyufuKanrihyo200004Identifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 審査年月を返します。
     *
     * @return 審査年月
     */
    public FlexibleYearMonth get審査年月() {
        return entity.getShinsaYM();
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShokisaiHokenshaNo();
    }

    /**
     * 居宅支援事業所番号を返します。
     *
     * @return 居宅支援事業所番号
     */
    public JigyoshaNo get居宅支援事業所番号() {
        return entity.getKyotakushienJigyoshoNo();
    }

    /**
     * 給付管理票情報作成区分コードを返します。
     *
     * @return 給付管理票情報作成区分コード
     */
    public RString get給付管理票情報作成区分コード() {
        return entity.getKyufuKanrihyoSakuseiKubunCode();
    }

    /**
     * 給付管理票作成年月日を返します。
     *
     * @return 給付管理票作成年月日
     */
    public FlexibleDate get給付管理票作成年月日() {
        return entity.getKyufuKanrihyoSakuseiYMD();
    }

    /**
     * 給付管理票種別区分コードを返します。
     *
     * @return 給付管理票種別区分コード
     */
    public RString get給付管理票種別区分コード() {
        return entity.getKyufuKanrihyoShubetsuKubunCode();
    }

    /**
     * 給付管理票明細行番号を返します。
     *
     * @return 給付管理票明細行番号
     */
    public RString get給付管理票明細行番号() {
        return entity.getKyufuKanrihyoMeisaiLineNo();
    }

    /**
     * 保険者番号を返します。
     *
     * @return 保険者番号
     */
    public HokenshaNo get保険者番号() {
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
     * 被保険者生年月日を返します。
     *
     * @return 被保険者生年月日
     */
    public FlexibleDate get被保険者生年月日() {
        return entity.getHiHokenshaUmareYMD();
    }

    /**
     * 性別コードを返します。
     *
     * @return 性別コード
     */
    public RString get性別コード() {
        return entity.getSeibetsuCode();
    }

    /**
     * 要介護状態区分コードを返します。
     *
     * @return 要介護状態区分コード
     */
    public RString get要介護状態区分コード() {
        return entity.getYoKaigoJotaiKubunCode();
    }

    /**
     * 限度額適用期間を返します。
     *
     * @return 限度額適用期間
     */
    public FlexibleYearMonth get限度額適用期間() {
        return entity.getGendogakuTekiyoKaishiYM();
    }

    /**
     * 限度額適用期間を返します。
     *
     * @return 限度額適用期間
     */
    public FlexibleYearMonth get限度額適用期間() {
        return entity.getGendogakuTekiyoShuryoYM();
    }

    /**
     * 居宅・介護予防支給限度額を返します。
     *
     * @return 居宅・介護予防支給限度額
     */
    public Decimal get居宅・介護予防支給限度額() {
        return entity.getKyotakuKaigoYoboShikyuGendogaku();
    }

    /**
     * 居宅サービス計画作成区分コードを返します。
     *
     * @return 居宅サービス計画作成区分コード
     */
    public RString get居宅サービス計画作成区分コード() {
        return entity.getKyotakuServicePlanSakuseiKubunCode();
    }

    /**
     * サービス事業所番号を返します。
     *
     * @return サービス事業所番号
     */
    public JigyoshaNo getサービス事業所番号() {
        return entity.getServiceJigyoshoNo();
    }

    /**
     * 指定/基準該当/地域密着型サービス識別コードを返します。
     *
     * @return 指定/基準該当/地域密着型サービス識別コード
     */
    public RString get指定/基準該当/地域密着型サービス識別コード() {
        return entity.getShiteiKijungaitoChiikimitchakuServiceShikibetsuCode();
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
     * 給付計画単位数／日数を返します。
     *
     * @return 給付計画単位数／日数
     */
    public Decimal get給付計画単位数／日数() {
        return entity.getKyufuKeikakuTanisuNissu();
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を返します。
     *
     * @return 限度額管理期間における前月までの給付計画日数
     */
    public Decimal get限度額管理期間における前月までの給付計画日数() {
        return entity.getKyufuKeikakuNissu();
    }

    /**
     * 指定サービス分小計を返します。
     *
     * @return 指定サービス分小計
     */
    public Decimal get指定サービス分小計() {
        return entity.getShiteiServiceSubTotal();
    }

    /**
     * 基準該当サービス分小計を返します。
     *
     * @return 基準該当サービス分小計
     */
    public Decimal get基準該当サービス分小計() {
        return entity.getKijyunGaitoServiceSubTotal();
    }

    /**
     * 給付計画合計単位数/日数を返します。
     *
     * @return 給付計画合計単位数/日数
     */
    public Decimal get給付計画合計単位数/日数() {
        return entity.getKyufuKeikakuTotalTanisuNissu();
    }

    /**
     * 当初登録年月日を返します。
     *
     * @return 当初登録年月日
     */
    public FlexibleDate get当初登録年月日() {
        return entity.getToshoTorokuYMD();
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
     * {@link DbT3014KyufuKanrihyo200004Entity}のクローンを返します。
     *
     * @return {@link DbT3014KyufuKanrihyo200004Entity}のクローン
     */
    @Override
    public DbT3014KyufuKanrihyo200004Entity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付管理票200004の識別子{@link KyufuKanrihyo200004Identifier}を返します。
     *
     * @return 給付管理票200004の識別子{@link KyufuKanrihyo200004Identifier}
     */
    @Override
    public KyufuKanrihyo200004Identifier identifier() {
        return this.id;
    }

    /**
     * 給付管理票200004のみを変更対象とします。<br/>
     * {@link DbT3014KyufuKanrihyo200004Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyufuKanrihyo200004}
     */
    @Override
    public KyufuKanrihyo200004 modifiedModel() {
        DbT3014KyufuKanrihyo200004Entity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyufuKanrihyo200004(
                modifiedEntity, id);
    }

    /**
     * 保持する給付管理票200004を削除対象とします。<br/>
     * {@link DbT3014KyufuKanrihyo200004Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuKanrihyo200004}
     */
    @Override
    public KyufuKanrihyo200004 deleted() {
        DbT3014KyufuKanrihyo200004Entity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuKanrihyo200004(deletedEntity, id);
    }
    /**
     * {@link KyufuKanrihyo200004}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuKanrihyo200004}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3014KyufuKanrihyo200004Entity entity;
        private final KyufuKanrihyo200004Identifier id;

        private _SerializationProxy(DbT3014KyufuKanrihyo200004Entity entity,KyufuKanrihyo200004Identifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuKanrihyo200004(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuKanrihyo200004Builder createBuilderForEdit() {
        return new KyufuKanrihyo200004Builder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
