/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給住宅改修事前申請を管理するクラスです。
 */
public class ShokanJutakuKaishuJizenShinsei extends ModelBase<ShokanJutakuKaishuJizenShinseiIdentifier, DbT3035ShokanJutakuKaishuJizenShinseiEntity, ShokanJutakuKaishuJizenShinsei> implements Serializable {

    private final DbT3035ShokanJutakuKaishuJizenShinseiEntity entity;
    private final ShokanJutakuKaishuJizenShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払支給住宅改修事前申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public ShokanJutakuKaishuJizenShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanJutakuKaishuJizenShinseiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}より{@link ShokanJutakuKaishuJizenShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}
     */
    public ShokanJutakuKaishuJizenShinsei(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給住宅改修事前申請"));
        this.id = new ShokanJutakuKaishuJizenShinseiIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}
     * @param id {@link ShokanJutakuKaishuJizenShinseiIdentifier}
     */
    ShokanJutakuKaishuJizenShinsei(
            DbT3035ShokanJutakuKaishuJizenShinseiEntity entity,
            ShokanJutakuKaishuJizenShinseiIdentifier id
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public Decimal get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public HokenshaNo get証記載保険者番号() {
        return entity.getShoKisaiHokenshaNo();
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
     * 申請年月日を返します。
     *
     * @return 申請年月日
     */
    public FlexibleDate get申請年月日() {
        return entity.getShinseiYMD();
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
     * 事業者名称を返します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.getJigyoshaNameKanji();
    }

    /**
     * 事業者名称カナを返します。
     *
     * @return 事業者名称カナ
     */
    public RString get事業者名称カナ() {
        return entity.getJigyoshaNameKana();
    }

    /**
     * 事業者郵便番号を返します。
     *
     * @return 事業者郵便番号
     */
    public YubinNo get事業者郵便番号() {
        return entity.getJigyoshaYubunNo();
    }

    /**
     * 事業者住所を返します。
     *
     * @return 事業者住所
     */
    public RString get事業者住所() {
        return entity.getJigyoshaAddress();
    }

    /**
     * 事業者電話番号を返します。
     *
     * @return 事業者電話番号
     */
    public RString get事業者電話番号() {
        return entity.getJigyoshaTelNo();
    }

    /**
     * 事業者ＦＡＸ番号を返します。
     *
     * @return 事業者ＦＡＸ番号
     */
    public RString get事業者ＦＡＸ番号() {
        return entity.getJigyoshaFaxNo();
    }

    /**
     * 理由書作成者を返します。
     *
     * @return 理由書作成者
     */
    public RString get理由書作成者() {
        return entity.getRiyushoSakuseishaKanji();
    }

    /**
     * 理由書作成者カナを返します。
     *
     * @return 理由書作成者カナ
     */
    public RString get理由書作成者カナ() {
        return entity.getRiyushoSakuseishaKana();
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
     * 契約決定年月日を返します。
     *
     * @return 契約決定年月日
     */
    public FlexibleDate get契約決定年月日() {
        return entity.getKeiyakuKetteiYMD();
    }

    /**
     * 承認区分を返します。
     *
     * @return 承認区分
     */
    public RString get承認区分() {
        return entity.getShoninKubun();
    }

    /**
     * 不承認の理由を返します。
     *
     * @return 不承認の理由
     */
    public RString get不承認の理由() {
        return entity.getFushoninRiyu();
    }

    /**
     * 給付額等_費用額合計を返します。
     *
     * @return 給付額等_費用額合計
     */
    public int get給付額等_費用額合計() {
        return entity.getKyufugakuHiyogakuTotal();
    }

    /**
     * 給付額等_保険対象費用額を返します。
     *
     * @return 給付額等_保険対象費用額
     */
    public int get給付額等_保険対象費用額() {
        return entity.getKyufugakuHokenTaishoHiyogaku();
    }

    /**
     * 給付額等_利用者自己負担額を返します。
     *
     * @return 給付額等_利用者自己負担額
     */
    public int get給付額等_利用者自己負担額() {
        return entity.getKyufugakuRiyoshaJikofutangaku();
    }

    /**
     * 給付額等_保険給付費額を返します。
     *
     * @return 給付額等_保険給付費額
     */
    public int get給付額等_保険給付費額() {
        return entity.getKyufugakuHokenkyufuhigaku();
    }

    /**
     * 施工完了予定年月日を返します。
     *
     * @return 施工完了予定年月日
     */
    public FlexibleDate get施工完了予定年月日() {
        return entity.getSekoKanryoYoteiYMD();
    }

    /**
     * 申請取消事由コードを返します。
     *
     * @return 申請取消事由コード
     */
    public RString get申請取消事由コード() {
        return entity.getShinseiTorikeshiJiyuCode();
    }

    /**
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}のクローン
     */
    @Override
    public DbT3035ShokanJutakuKaishuJizenShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払支給住宅改修事前申請の識別子{@link ShokanJutakuKaishuJizenShinseiIdentifier}を返します。
     *
     * @return 償還払支給住宅改修事前申請の識別子{@link ShokanJutakuKaishuJizenShinseiIdentifier}
     */
    @Override
    public ShokanJutakuKaishuJizenShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払支給住宅改修事前申請を削除対象とします。<br/>
     * {@link DbT3035ShokanJutakuKaishuJizenShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanJutakuKaishuJizenShinsei}
     */
    @Override
    public ShokanJutakuKaishuJizenShinsei deleted() {
        DbT3035ShokanJutakuKaishuJizenShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanJutakuKaishuJizenShinsei(deletedEntity, id);
    }

    /**
     * {@link ShokanJutakuKaishuJizenShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanJutakuKaishuJizenShinsei}のシリアライズ形式
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

        private final DbT3035ShokanJutakuKaishuJizenShinseiEntity entity;
        private final ShokanJutakuKaishuJizenShinseiIdentifier id;

        private _SerializationProxy(DbT3035ShokanJutakuKaishuJizenShinseiEntity entity, ShokanJutakuKaishuJizenShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanJutakuKaishuJizenShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanJutakuKaishuJizenShinseiBuilder createBuilderForEdit() {
        return new ShokanJutakuKaishuJizenShinseiBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
