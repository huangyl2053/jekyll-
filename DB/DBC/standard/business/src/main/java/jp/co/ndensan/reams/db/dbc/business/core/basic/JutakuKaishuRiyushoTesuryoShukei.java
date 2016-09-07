/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 住宅改修理由書作成手数料請求集計を管理するクラスです。
 */
public class JutakuKaishuRiyushoTesuryoShukei
       extends ModelBase<JutakuKaishuRiyushoTesuryoShukeiIdentifier, DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity, JutakuKaishuRiyushoTesuryoShukei>
       implements Serializable {

    private final DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity;
    private final JutakuKaishuRiyushoTesuryoShukeiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 住宅改修理由書作成手数料請求集計の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 集計開始年月 集計開始年月
     * @param 履歴番号 履歴番号
     */
    public JutakuKaishuRiyushoTesuryoShukei(HokenshaNo 証記載保険者番号,
            FlexibleYearMonth 集計開始年月,
            Decimal 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(集計開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setShukeiKaishiYM(集計開始年月);
        this.entity.setRirekiNo(履歴番号.intValue());
        this.id = new JutakuKaishuRiyushoTesuryoShukeiIdentifier(
                証記載保険者番号,
                集計開始年月,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}より{@link JutakuKaishuRiyushoTesuryoShukei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}
     */
    public JutakuKaishuRiyushoTesuryoShukei(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求集計"));
        this.id = new JutakuKaishuRiyushoTesuryoShukeiIdentifier(
                entity.getShoKisaiHokenshaNo(),
                entity.getShukeiKaishiYM(),
                new Decimal(entity.getRirekiNo()));
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}
     * @param id {@link JutakuKaishuRiyushoTesuryoShukeiIdentifier}
     */
    JutakuKaishuRiyushoTesuryoShukei(
            DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity,
            JutakuKaishuRiyushoTesuryoShukeiIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
    }

    /**
     * 集計開始年月を返します。
     *
     * @return 集計開始年月
     */
    public FlexibleYearMonth get集計開始年月() {
        return entity.getShukeiKaishiYM();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return new Decimal(entity.getRirekiNo());
    }

    /**
     * 集計終了年月を返します。
     *
     * @return 集計終了年月
     */
    public FlexibleYearMonth get集計終了年月() {
        return entity.getShukeiShuryoYM();
    }

    /**
     * 介護住宅改修理由書作成事業者番号を返します。
     *
     * @return 介護住宅改修理由書作成事業者番号
     */
    public JigyoshaNo get介護住宅改修理由書作成事業者番号() {
        return entity.getRiyushoSakuseiJigyoshaNo();
    }

    /**
     * 介護住宅改修理由書作成件数を返します。
     *
     * @return 介護住宅改修理由書作成件数
     */
    public Decimal get介護住宅改修理由書作成件数() {
        return entity.getRiyushoSakuseiKensu();
    }

    /**
     * 介護住宅改修理由書作成単価を返します。
     *
     * @return 介護住宅改修理由書作成単価
     */
    public Decimal get介護住宅改修理由書作成単価() {
        return entity.getRiyushoSakuseiTanka();
    }

    /**
     * 介護住宅改修理由書作成請求金額を返します。
     *
     * @return 介護住宅改修理由書作成請求金額
     */
    public Decimal get介護住宅改修理由書作成請求金額() {
        return entity.getRiyushoSakuseiSeikyuKingaku();
    }

    /**
     * 介護住宅改修理由書作成申請年月日を返します。
     *
     * @return 介護住宅改修理由書作成申請年月日
     */
//    public FlexibleDate get介護住宅改修理由書作成申請年月日() {
//        return entity.getRiyushoSakuseiShinseiYMD();
//    }

    /**
     * 介護住宅改修理由書作成受付年月日を返します。
     *
     * @return 介護住宅改修理由書作成受付年月日
     */
//    public FlexibleDate get介護住宅改修理由書作成受付年月日() {
//        return entity.getRiyushoSakuseiUketsukeYMD();
//    }

    /**
     * 介護支払方法区分を返します。
     *
     * @return 介護支払方法区分
     */
    public RString get介護支払方法区分() {
        return entity.getShiharaiHohoKubun();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return entity.getShikibetsuNo();
    }

    /**
     * {@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}のクローンを返します。
     *
     * @return {@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}のクローン
     */
    @Override
    public DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 住宅改修理由書作成手数料請求集計の識別子{@link JutakuKaishuRiyushoTesuryoShukeiIdentifier}を返します。
     *
     * @return 住宅改修理由書作成手数料請求集計の識別子{@link JutakuKaishuRiyushoTesuryoShukeiIdentifier}
     */
    @Override
    public JutakuKaishuRiyushoTesuryoShukeiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する住宅改修理由書作成手数料請求集計を削除対象とします。<br/>
     * {@link DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link JutakuKaishuRiyushoTesuryoShukei}
     */
    @Override
    public JutakuKaishuRiyushoTesuryoShukei deleted() {
        DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new JutakuKaishuRiyushoTesuryoShukei(deletedEntity, id);
    }

    /**
     * {@link JutakuKaishuRiyushoTesuryoShukei}のシリアライズ形式を提供します。
     *
     * @return {@link JutakuKaishuRiyushoTesuryoShukei}のシリアライズ形式
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

        private final DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity;
        private final JutakuKaishuRiyushoTesuryoShukeiIdentifier id;

        private _SerializationProxy(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity, JutakuKaishuRiyushoTesuryoShukeiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new JutakuKaishuRiyushoTesuryoShukei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public JutakuKaishuRiyushoTesuryoShukeiBuilder createBuilderForEdit() {
        return new JutakuKaishuRiyushoTesuryoShukeiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
