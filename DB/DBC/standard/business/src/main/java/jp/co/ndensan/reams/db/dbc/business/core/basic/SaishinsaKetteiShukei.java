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
import jp.co.ndensan.reams.db.dbc.entity.db.basic.dbc.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 再審査決定集計を管理するクラスです。
 */
public class SaishinsaKetteiShukei extends ParentModelBase<SaishinsaKetteiShukeiIdentifier, DbT3063SaishinsaKetteiShukeiEntity, SaishinsaKetteiShukei> implements Serializable {

    private final DbT3063SaishinsaKetteiShukeiEntity entity;
    private final SaishinsaKetteiShukeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 再審査決定集計の新規作成時に使用します。
     *
     * @param 取扱年月 取扱年月
     * @param 保険者区分 保険者区分
     * @param 履歴番号 履歴番号
     */
    public SaishinsaKetteiShukei(FlexibleYearMonth 取扱年月,
RString 保険者区分,
Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3063SaishinsaKetteiShukeiEntity();
        this.entity.setToriatsukaiYM(取扱年月);
        this.entity.setHokenshaKubun(保険者区分);
        this.entity.setRirekiNo(履歴番号);
        this.id = new SaishinsaKetteiShukeiIdentifier(
        取扱年月,
        保険者区分,
        履歴番号
                );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3063SaishinsaKetteiShukeiEntity}より{@link SaishinsaKetteiShukei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3063SaishinsaKetteiShukeiEntity}
     */
    public SaishinsaKetteiShukei(DbT3063SaishinsaKetteiShukeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査決定集計"));
        this.id = new SaishinsaKetteiShukeiIdentifier(
                entity.getToriatsukaiYM(),
                entity.getHokenshaKubun(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3063SaishinsaKetteiShukeiEntity}
     * @param id {@link SaishinsaKetteiShukeiIdentifier}
     */
    SaishinsaKetteiShukei(
            DbT3063SaishinsaKetteiShukeiEntity entity,
            SaishinsaKetteiShukeiIdentifier id
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
     * 介護給付費・請求・件数を返します。
     *
     * @return 介護給付費・請求・件数
     */
    public int get介護給付費・請求・件数() {
        return entity.getKaigoKyufuhiSeikyuKensu();
    }

    /**
     * 介護給付費・請求・単位数を返します。
     *
     * @return 介護給付費・請求・単位数
     */
    public Decimal get介護給付費・請求・単位数() {
        return entity.getKaigoKyufuhiSeikyuTanisu();
    }

    /**
     * 介護給付費・請求・保険者負担額を返します。
     *
     * @return 介護給付費・請求・保険者負担額
     */
    public Decimal get介護給付費・請求・保険者負担額() {
        return entity.getKaigoKyufuhiSeikyuFutangaku();
    }

    /**
     * 介護給付費・決定・件数を返します。
     *
     * @return 介護給付費・決定・件数
     */
    public int get介護給付費・決定・件数() {
        return entity.getKaigoKyufuhiKetteiKensu();
    }

    /**
     * 介護給付費・決定・単位数を返します。
     *
     * @return 介護給付費・決定・単位数
     */
    public Decimal get介護給付費・決定・単位数() {
        return entity.getKaigoKyufuhiKetteiTanisu();
    }

    /**
     * 介護給付費・決定・保険者負担額を返します。
     *
     * @return 介護給付費・決定・保険者負担額
     */
    public Decimal get介護給付費・決定・保険者負担額() {
        return entity.getKaigoKyufuhiKetteiFutangaku();
    }

    /**
     * 介護給付費・調整・件数を返します。
     *
     * @return 介護給付費・調整・件数
     */
    public int get介護給付費・調整・件数() {
        return entity.getKaigoKyufuhiChoseiKensu();
    }

    /**
     * 介護給付費・調整・単位数を返します。
     *
     * @return 介護給付費・調整・単位数
     */
    public Decimal get介護給付費・調整・単位数() {
        return entity.getKaigoKyufuhiChoseiTanisu();
    }

    /**
     * 介護給付費・調整・保険者負担額を返します。
     *
     * @return 介護給付費・調整・保険者負担額
     */
    public Decimal get介護給付費・調整・保険者負担額() {
        return entity.getKaigoKyufuhiChoseiFutangaku();
    }

    /**
     * 高額介護サービス費・請求・件数を返します。
     *
     * @return 高額介護サービス費・請求・件数
     */
    public int get高額介護サービス費・請求・件数() {
        return entity.getKogakuKaigoServicehiSeikyuKensu();
    }

    /**
     * 高額介護サービス費・請求・単位数を返します。
     *
     * @return 高額介護サービス費・請求・単位数
     */
    public Decimal get高額介護サービス費・請求・単位数() {
        return entity.getKogakuKaigoServicehiSeikyuTanisu();
    }

    /**
     * 高額介護サービス費・請求・保険者負担額を返します。
     *
     * @return 高額介護サービス費・請求・保険者負担額
     */
    public Decimal get高額介護サービス費・請求・保険者負担額() {
        return entity.getKogakuKaigoServicehiSeikyuFutangaku();
    }

    /**
     * 高額介護サービス費・決定・件数を返します。
     *
     * @return 高額介護サービス費・決定・件数
     */
    public int get高額介護サービス費・決定・件数() {
        return entity.getKogakuKaigoServicehiKetteiKensu();
    }

    /**
     * 高額介護サービス費・決定・単位数を返します。
     *
     * @return 高額介護サービス費・決定・単位数
     */
    public Decimal get高額介護サービス費・決定・単位数() {
        return entity.getKogakuKaigoServicehiKetteiTanisu();
    }

    /**
     * 高額介護サービス費・決定・保険者負担額を返します。
     *
     * @return 高額介護サービス費・決定・保険者負担額
     */
    public Decimal get高額介護サービス費・決定・保険者負担額() {
        return entity.getKogakuKaigoServicehiKetteiFutangaku();
    }

    /**
     * 高額介護サービス費・調整・件数を返します。
     *
     * @return 高額介護サービス費・調整・件数
     */
    public int get高額介護サービス費・調整・件数() {
        return entity.getKogakuKaigoServicehiChoseiKensu();
    }

    /**
     * 高額介護サービス費・調整・単位数を返します。
     *
     * @return 高額介護サービス費・調整・単位数
     */
    public Decimal get高額介護サービス費・調整・単位数() {
        return entity.getKogakuKaigoServicehiChoseiTanisu();
    }

    /**
     * 高額介護サービス費・調整・保険者負担額を返します。
     *
     * @return 高額介護サービス費・調整・保険者負担額
     */
    public Decimal get高額介護サービス費・調整・保険者負担額() {
        return entity.getKogakuKaigoServicehiChoseiFutangaku();
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
     * 審査委員会名を返します。
     *
     * @return 審査委員会名
     */
    public RString get審査委員会名() {
        return entity.getSinsaiinkaiName();
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
     * {@link DbT3063SaishinsaKetteiShukeiEntity}のクローンを返します。
     *
     * @return {@link DbT3063SaishinsaKetteiShukeiEntity}のクローン
     */
    @Override
    public DbT3063SaishinsaKetteiShukeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 再審査決定集計の識別子{@link SaishinsaKetteiShukeiIdentifier}を返します。
     *
     * @return 再審査決定集計の識別子{@link SaishinsaKetteiShukeiIdentifier}
     */
    @Override
    public SaishinsaKetteiShukeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 再審査決定集計のみを変更対象とします。<br/>
     * {@link DbT3063SaishinsaKetteiShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link SaishinsaKetteiShukei}
     */
    @Override
    public SaishinsaKetteiShukei modifiedModel() {
        DbT3063SaishinsaKetteiShukeiEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new SaishinsaKetteiShukei(
                modifiedEntity, id);
    }

    /**
     * 保持する再審査決定集計を削除対象とします。<br/>
     * {@link DbT3063SaishinsaKetteiShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link SaishinsaKetteiShukei}
     */
    @Override
    public SaishinsaKetteiShukei deleted() {
        DbT3063SaishinsaKetteiShukeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new SaishinsaKetteiShukei(deletedEntity, id);
    }
    /**
     * {@link SaishinsaKetteiShukei}のシリアライズ形式を提供します。
     *
     * @return {@link SaishinsaKetteiShukei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = // TODO serialVersionUIDを生成してください
        private final DbT3063SaishinsaKetteiShukeiEntity entity;
        private final SaishinsaKetteiShukeiIdentifier id;

        private _SerializationProxy(DbT3063SaishinsaKetteiShukeiEntity entity,SaishinsaKetteiShukeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new SaishinsaKetteiShukei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public SaishinsaKetteiShukeiBuilder createBuilderForEdit() {
        return new SaishinsaKetteiShukeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
