/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3107ShokanMeisaiJushochiTokureiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払請求明細・住所地特例を管理するクラスです。
 */
public class ShokanMeisaiJushochiTokurei extends ModelBase<ShokanMeisaiJushochiTokureiIdentifier, DbT3107ShokanMeisaiJushochiTokureiEntity, ShokanMeisaiJushochiTokurei> implements Serializable {

    private final DbT3107ShokanMeisaiJushochiTokureiEntity entity;
    private final ShokanMeisaiJushochiTokureiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払請求明細・住所地特例の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 事業者番号 事業者番号
     * @param 様式番号 様式番号
     * @param 順次番号 順次番号
     * @param 履歴番号 履歴番号
     */
    public ShokanMeisaiJushochiTokurei(HihokenshaNo 被保険者番号,
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
        this.entity = new DbT3107ShokanMeisaiJushochiTokureiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNp(整理番号);
        this.entity.setJigyoshaNo(事業者番号);
        this.entity.setYoshikiNo(様式番号);
        this.entity.setJunjiNo(順次番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanMeisaiJushochiTokureiIdentifier(
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
     * DBより取得した{@link DbT3107ShokanMeisaiJushochiTokureiEntity}より{@link ShokanMeisaiJushochiTokurei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3107ShokanMeisaiJushochiTokureiEntity}
     */
    public ShokanMeisaiJushochiTokurei(DbT3107ShokanMeisaiJushochiTokureiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求明細・住所地特例"));
        this.id = new ShokanMeisaiJushochiTokureiIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNp(),
                entity.getJigyoshaNo(),
                entity.getYoshikiNo(),
                entity.getJunjiNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3107ShokanMeisaiJushochiTokureiEntity}
     * @param id {@link ShokanMeisaiJushochiTokureiIdentifier}
     */
    ShokanMeisaiJushochiTokurei(
            DbT3107ShokanMeisaiJushochiTokureiEntity entity,
            ShokanMeisaiJushochiTokureiIdentifier id
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
        return entity.getSeiriNp();
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
        return entity.getTanisu();
    }

    /**
     * 日数・回数を返します。
     *
     * @return 日数・回数
     */
    public Decimal get日数_回数() {
        return entity.getNissuKaisu();
    }

    /**
     * サービス単位数を返します。
     *
     * @return サービス単位数
     */
    public int getサービス単位数() {
        return entity.getServiceTanisu();
    }

    /**
     * 施設所在保険者番号を返します。
     *
     * @return 施設所在保険者番号
     */
    public ShoKisaiHokenshaNo get施設所在保険者番号() {
        return entity.getShisetsuShozaiHokenshaNo();
    }

    /**
     * 摘要を返します。
     *
     * @return 摘要
     */
    public RString get摘要() {
        return entity.getTekiyo();
    }

    /**
     * {@link DbT3107ShokanMeisaiJushochiTokureiEntity}のクローンを返します。
     *
     * @return {@link DbT3107ShokanMeisaiJushochiTokureiEntity}のクローン
     */
    @Override
    public DbT3107ShokanMeisaiJushochiTokureiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払請求明細・住所地特例の識別子{@link ShokanMeisaiJushochiTokureiIdentifier}を返します。
     *
     * @return 償還払請求明細・住所地特例の識別子{@link ShokanMeisaiJushochiTokureiIdentifier}
     */
    @Override
    public ShokanMeisaiJushochiTokureiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払請求明細・住所地特例を削除対象とします。<br/>
     * {@link DbT3107ShokanMeisaiJushochiTokureiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanMeisaiJushochiTokurei}
     */
    @Override
    public ShokanMeisaiJushochiTokurei deleted() {
        DbT3107ShokanMeisaiJushochiTokureiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanMeisaiJushochiTokurei(deletedEntity, id);
    }

    /**
     * {@link ShokanMeisaiJushochiTokurei}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanMeisaiJushochiTokurei}のシリアライズ形式
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

        private final DbT3107ShokanMeisaiJushochiTokureiEntity entity;
        private final ShokanMeisaiJushochiTokureiIdentifier id;

        private _SerializationProxy(DbT3107ShokanMeisaiJushochiTokureiEntity entity, ShokanMeisaiJushochiTokureiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanMeisaiJushochiTokurei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanMeisaiJushochiTokureiBuilder createBuilderForEdit() {
        return new ShokanMeisaiJushochiTokureiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
