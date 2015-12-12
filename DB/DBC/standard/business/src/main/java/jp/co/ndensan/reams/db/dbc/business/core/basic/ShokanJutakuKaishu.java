/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3049ShokanJutakuKaishuEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求住宅改修を管理するクラスです。
 */
public class ShokanJutakuKaishu
extends ModelBase<ShokanJutakuKaishuIdentifier,
        DbT3049ShokanJutakuKaishuEntity, 
        ShokanJutakuKaishu> implements Serializable {

    private final DbT3049ShokanJutakuKaishuEntity entity;
    private final ShokanJutakuKaishuIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求住宅改修の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 順次番号 順次番号
     * @param 履歴番号 履歴番号
     */
    public ShokanJutakuKaishu(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 順次番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3049ShokanJutakuKaishuEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setJunjiNo(順次番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanJutakuKaishuIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                順次番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3049ShokanJutakuKaishuEntity}より{@link ShokanJutakuKaishu}を生成します。
     *
     * @param entity DBより取得した{@link DbT3049ShokanJutakuKaishuEntity}
     */
    public ShokanJutakuKaishu(DbT3049ShokanJutakuKaishuEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求住宅改修"));
        this.id = new ShokanJutakuKaishuIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getJunjiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3049ShokanJutakuKaishuEntity}
     * @param id {@link ShokanJutakuKaishuIdentifier}
     */
    ShokanJutakuKaishu(
            DbT3049ShokanJutakuKaishuEntity entity,
            ShokanJutakuKaishuIdentifier id
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
     * 整理番号を返します。
     *
     * @return 整理番号
     */
    public RString get整理番号() {
        return entity.getSeiriNo();
    }

    /**
     * 事業者番号を返します。
     *
     * @return 事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getJigyoshaNo();
    }

    /**
     * 様式番号を返します。
     *
     * @return 様式番号
     */
    public RString get様式番号() {
        return entity.getYoshikiNo();
    }

    /**
     * 順次番号を返します。
     *
     * @return 順次番号
     */
    public RString get順次番号() {
        return entity.getJunjiNo();
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
     * サービスコードを返します。
     *
     * @return サービスコード
     */
    public ServiceCode getサービスコード() {
        return entity.getServiceCode();
    }

    /**
     * 住宅改修着工年月日を返します。
     *
     * @return 住宅改修着工年月日
     */
    public FlexibleDate get住宅改修着工年月日() {
        return entity.getJutakuKaishuChakkoYMD();
    }

    /**
     * 住宅改修事業者名を返します。
     *
     * @return 住宅改修事業者名
     */
    public RString get住宅改修事業者名() {
        return entity.getJutakuKaishuJigyoshaName();
    }

    /**
     * 住宅改修住宅住所を返します。
     *
     * @return 住宅改修住宅住所
     */
    public RString get住宅改修住宅住所() {
        return entity.getJutakuKaishuJutakuAddress();
    }

    /**
     * 改修金額を返します。
     *
     * @return 改修金額
     */
    public int get改修金額() {
        return entity.getKaishuKingaku();
    }

    /**
     * 審査方法区分コードを返します。
     *
     * @return 審査方法区分コード
     */
    public RString get審査方法区分コード() {
        return entity.getShinsaHohoKubunCode();
    }

    /**
     * 住宅改修完成年月日を返します。
     *
     * @return 住宅改修完成年月日
     */
    public FlexibleDate get住宅改修完成年月日() {
        return entity.getJutakuKaishuKanseiYMD();
    }

    /**
     * 差額金額を返します。
     *
     * @return 差額金額
     */
    public int get差額金額() {
        return entity.getSagakuKingaku();
    }

    /**
     * {@link DbT3049ShokanJutakuKaishuEntity}のクローンを返します。
     *
     * @return {@link DbT3049ShokanJutakuKaishuEntity}のクローン
     */
    @Override
    public DbT3049ShokanJutakuKaishuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求住宅改修の識別子{@link ShokanJutakuKaishuIdentifier}を返します。
     *
     * @return 償還払請求住宅改修の識別子{@link ShokanJutakuKaishuIdentifier}
     */
    @Override
    public ShokanJutakuKaishuIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求住宅改修を削除対象とします。<br/>
     * {@link DbT3049ShokanJutakuKaishuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanJutakuKaishu}
     */
    @Override
    public ShokanJutakuKaishu deleted() {
        DbT3049ShokanJutakuKaishuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanJutakuKaishu(deletedEntity, id);
    }

    /**
     * {@link ShokanJutakuKaishu}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanJutakuKaishu}のシリアライズ形式
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

        private final DbT3049ShokanJutakuKaishuEntity entity;
        private final ShokanJutakuKaishuIdentifier id;

        private _SerializationProxy(DbT3049ShokanJutakuKaishuEntity entity, ShokanJutakuKaishuIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanJutakuKaishu(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanJutakuKaishuBuilder createBuilderForEdit() {
        return new ShokanJutakuKaishuBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
