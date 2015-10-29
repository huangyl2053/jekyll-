/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3098TandokuJoseikinKyufuShinseiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 市町村単独助成金給付申請を管理するクラスです。
 */
public class TandokuJoseikinKyufuShinsei 
extends ModelBase<TandokuJoseikinKyufuShinseiIdentifier, 
        DbT3098TandokuJoseikinKyufuShinseiEntity, 
        TandokuJoseikinKyufuShinsei> implements Serializable {

    private final DbT3098TandokuJoseikinKyufuShinseiEntity entity;
    private final TandokuJoseikinKyufuShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 市町村単独助成金給付申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     */
    public TandokuJoseikinKyufuShinsei(HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3098TandokuJoseikinKyufuShinseiEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setUketsukeYMD(受付年月日);
        this.entity.setRirekiNo(履歴番号);
        this.id = new TandokuJoseikinKyufuShinseiIdentifier(
                被保険者番号,
                受付年月日,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3098TandokuJoseikinKyufuShinseiEntity}より{@link TandokuJoseikinKyufuShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3098TandokuJoseikinKyufuShinseiEntity}
     */
    public TandokuJoseikinKyufuShinsei(DbT3098TandokuJoseikinKyufuShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村単独助成金給付申請"));
        this.id = new TandokuJoseikinKyufuShinseiIdentifier(
                entity.getHihokenshaNo(),
                entity.getUketsukeYMD(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3098TandokuJoseikinKyufuShinseiEntity}
     * @param id {@link TandokuJoseikinKyufuShinseiIdentifier}
     */
    TandokuJoseikinKyufuShinsei(
            DbT3098TandokuJoseikinKyufuShinseiEntity entity,
            TandokuJoseikinKyufuShinseiIdentifier id
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
     * 受付年月日を返します。
     *
     * @return 受付年月日
     */
    public FlexibleDate get受付年月日() {
        return entity.getUketsukeYMD();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
    }

    /**
     * 申請者区分を返します。
     *
     * @return 申請者区分
     */
    public RString get申請者区分() {
        return entity.getShinseishaKubun();
    }

    /**
     * 申請代行事業者番号を返します。
     *
     * @return 申請代行事業者番号
     */
    public JigyoshaNo get申請代行事業者番号() {
        return entity.getDaikoJigyoshaNo();
    }

    /**
     * 事業者区分を返します。
     *
     * @return 事業者区分
     */
    public RString get事業者区分() {
        return entity.getJigyoshaKubun();
    }

    /**
     * 申請者郵便番号を返します。
     *
     * @return 申請者郵便番号
     */
    public YubinNo get申請者郵便番号() {
        return entity.getShinseishaYubinNo();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaJusho();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
    }

    /**
     * 市町村単独助成種類を返します。
     *
     * @return 市町村単独助成種類
     */
    public RString get市町村単独助成種類() {
        return entity.getTandokuJoseiShuruiCode();
    }

    /**
     * {@link DbT3098TandokuJoseikinKyufuShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT3098TandokuJoseikinKyufuShinseiEntity}のクローン
     */
    @Override
    public DbT3098TandokuJoseikinKyufuShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 市町村単独助成金給付申請の識別子{@link TandokuJoseikinKyufuShinseiIdentifier}を返します。
     *
     * @return 市町村単独助成金給付申請の識別子{@link TandokuJoseikinKyufuShinseiIdentifier}
     */
    @Override
    public TandokuJoseikinKyufuShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する市町村単独助成金給付申請を削除対象とします。<br/>
     * {@link DbT3098TandokuJoseikinKyufuShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link TandokuJoseikinKyufuShinsei}
     */
    @Override
    public TandokuJoseikinKyufuShinsei deleted() {
        DbT3098TandokuJoseikinKyufuShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TandokuJoseikinKyufuShinsei(deletedEntity, id);
    }

    /**
     * {@link TandokuJoseikinKyufuShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link TandokuJoseikinKyufuShinsei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public TandokuJoseikinKyufuShinsei modifiedModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<TandokuJoseikinKyufuKettei> getTandokuJoseikinKyufuKetteiList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3098TandokuJoseikinKyufuShinseiEntity entity;
        private final TandokuJoseikinKyufuShinseiIdentifier id;

        private _SerializationProxy(DbT3098TandokuJoseikinKyufuShinseiEntity entity, TandokuJoseikinKyufuShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new TandokuJoseikinKyufuShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public TandokuJoseikinKyufuShinseiBuilder createBuilderForEdit() {
        return new TandokuJoseikinKyufuShinseiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
