/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 給付管理票200604を管理するクラスです。
 */
public class KyufuKanrihyo200604
extends ModelBase<KyufuKanrihyo200604Identifier, 
        DbT3015KyufuKanrihyo200604Entity,
        KyufuKanrihyo200604> implements Serializable {

    private final DbT3015KyufuKanrihyo200604Entity entity;
    private final KyufuKanrihyo200604Identifier id;

    /**
     * コンストラクタです。<br/>
     * 給付管理票200604の新規作成時に使用します。
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
    public KyufuKanrihyo200604(FlexibleYearMonth 審査年月,
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
        this.entity = new DbT3015KyufuKanrihyo200604Entity();
        this.entity.setShinsaYM(審査年月);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setShokisaiHokenshaNo(証記載保険者番号);
        this.entity.setKyotakushienJigyoshoNo(居宅支援事業所番号);
        this.entity.setKyufuSakuseiKubunCode(給付管理票情報作成区分コード);
        this.entity.setKyufuSakuseiYMD(給付管理票作成年月日);
        this.entity.setKyufuShubetsuKubunCode(給付管理票種別区分コード);
        this.entity.setKyufuMeisaiLineNo(給付管理票明細行番号);
        this.id = new KyufuKanrihyo200604Identifier(
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
     * DBより取得した{@link DbT3015KyufuKanrihyo200604Entity}より{@link KyufuKanrihyo200604}を生成します。
     *
     * @param entity DBより取得した{@link DbT3015KyufuKanrihyo200604Entity}
     */
    public KyufuKanrihyo200604(DbT3015KyufuKanrihyo200604Entity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票200604"));
        this.id = new KyufuKanrihyo200604Identifier(
                entity.getShinsaYM(),
                entity.getServiceTeikyoYM(),
                entity.getShokisaiHokenshaNo(),
                entity.getKyotakushienJigyoshoNo(),
                entity.getKyufuSakuseiKubunCode(),
                entity.getKyufuSakuseiYMD(),
                entity.getKyufuShubetsuKubunCode(),
                entity.getKyufuMeisaiLineNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3015KyufuKanrihyo200604Entity}
     * @param id {@link KyufuKanrihyo200604Identifier}
     */
    KyufuKanrihyo200604(
            DbT3015KyufuKanrihyo200604Entity entity,
            KyufuKanrihyo200604Identifier id
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
        return entity.getKyufuSakuseiKubunCode();
    }

    /**
     * 給付管理票作成年月日を返します。
     *
     * @return 給付管理票作成年月日
     */
    public FlexibleDate get給付管理票作成年月日() {
        return entity.getKyufuSakuseiYMD();
    }

    /**
     * 給付管理票種別区分コードを返します。
     *
     * @return 給付管理票種別区分コード
     */
    public RString get給付管理票種別区分コード() {
        return entity.getKyufuShubetsuKubunCode();
    }

    /**
     * 給付管理票明細行番号を返します。
     *
     * @return 給付管理票明細行番号
     */
    public RString get給付管理票明細行番号() {
        return entity.getKyufuMeisaiLineNo();
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
     * 限度額適用開始年月を返します。
     *
     * @return 限度額適用開始年月
     */
    public FlexibleYearMonth get限度額適用開始年月() {
        return entity.getGendogakuTekiyoKaishiYM();
    }

    /**
     * 限度額適用終了年月を返します。
     *
     * @return 限度額適用終了年月
     */
    public FlexibleYearMonth get限度額適用終了年月() {
        return entity.getGendogakuTekiyoShuryoYM();
    }

    /**
     * 居宅・介護予防支給限度額を返します。
     *
     * @return 居宅・介護予防支給限度額
     */
    public int get居宅_介護予防支給限度額() {
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
    public RString get指定_基準該当_地域密着型サービス識別コード() {
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
    public int get給付計画単位数_日数() {
        return entity.getKyufuKeikakuTanisuNissu();
    }

    /**
     * 限度額管理期間における前月までの給付計画日数を返します。
     *
     * @return 限度額管理期間における前月までの給付計画日数
     */
    public int get限度額管理期間における前月までの給付計画日数() {
        return entity.getKyufuKeikakuNissu();
    }

    /**
     * 指定サービス分小計を返します。
     *
     * @return 指定サービス分小計
     */
    public int get指定サービス分小計() {
        return entity.getShiteiServiceSubTotal();
    }

    /**
     * 基準該当サービス分小計を返します。
     *
     * @return 基準該当サービス分小計
     */
    public int get基準該当サービス分小計() {
        return entity.getKijyunGaitoServiceSubTotal();
    }

    /**
     * 給付計画合計単位数/日数を返します。
     *
     * @return 給付計画合計単位数/日数
     */
    public int get給付計画合計単位数_日数() {
        return entity.getKyufuKeikakuTotalTanisuNissu();
    }

    /**
     * 担当介護支援専門員番号を返します。
     *
     * @return 担当介護支援専門員番号
     */
    public RString get担当介護支援専門員番号() {
        return entity.getTantoKaigoShienSemmoninNo();
    }

    /**
     * 委託先の居宅介護支援事業所番号を返します。
     *
     * @return 委託先の居宅介護支援事業所番号
     */
    public JigyoshaNo get委託先の居宅介護支援事業所番号() {
        return entity.getKaigoShienJigyoshaNo();
    }

    /**
     * 委託先の担当介護支援専門員番号を返します。
     *
     * @return 委託先の担当介護支援専門員番号
     */
    public RString get委託先の担当介護支援専門員番号() {
        return entity.getItakusakiTantoKaigoShienSemmoninNo();
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
     * {@link DbT3015KyufuKanrihyo200604Entity}のクローンを返します。
     *
     * @return {@link DbT3015KyufuKanrihyo200604Entity}のクローン
     */
    @Override
    public DbT3015KyufuKanrihyo200604Entity toEntity() {
        return this.entity.clone();
    }

    /**
     * 給付管理票200604の識別子{@link KyufuKanrihyo200604Identifier}を返します。
     *
     * @return 給付管理票200604の識別子{@link KyufuKanrihyo200604Identifier}
     */
    @Override
    public KyufuKanrihyo200604Identifier identifier() {
        return this.id;
    }

    /**
     * 保持する給付管理票200604を削除対象とします。<br/>
     * {@link DbT3015KyufuKanrihyo200604Entity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KyufuKanrihyo200604}
     */
    @Override
    public KyufuKanrihyo200604 deleted() {
        DbT3015KyufuKanrihyo200604Entity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyufuKanrihyo200604(deletedEntity, id);
    }

    /**
     * {@link KyufuKanrihyo200604}のシリアライズ形式を提供します。
     *
     * @return {@link KyufuKanrihyo200604}のシリアライズ形式
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

        private final DbT3015KyufuKanrihyo200604Entity entity;
        private final KyufuKanrihyo200604Identifier id;

        private _SerializationProxy(DbT3015KyufuKanrihyo200604Entity entity, KyufuKanrihyo200604Identifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KyufuKanrihyo200604(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KyufuKanrihyo200604Builder createBuilderForEdit() {
        return new KyufuKanrihyo200604Builder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
