/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 償還払支給申請を管理するクラスです。
 */
public class ShokanShinsei extends ModelBase<ShokanShinseiIdentifier, DbT3034ShokanShinseiEntity, ShokanShinsei> implements Serializable {

    private final DbT3034ShokanShinseiEntity entity;
    private final ShokanShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払支給申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public ShokanShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3034ShokanShinseiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanShinseiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3034ShokanShinseiEntity}より{@link ShokanShinsei}を生成します。
     *
     * @param entity DBより取得した{@link DbT3034ShokanShinseiEntity}
     */
    public ShokanShinsei(DbT3034ShokanShinseiEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給申請"));
        this.id = new ShokanShinseiIdentifier(
                entity.getHiHokenshaNo(),
                entity.getServiceTeikyoYM(),
                entity.getSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3034ShokanShinseiEntity}
     * @param id {@link ShokanShinseiIdentifier}
     */
    ShokanShinsei(
            DbT3034ShokanShinseiEntity entity,
            ShokanShinseiIdentifier id
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
     * 申請理由を返します。
     *
     * @return 申請理由
     */
    public RString get申請理由() {
        return entity.getShinseiRiyu();
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
     * 申請者氏名を返します。
     *
     * @return 申請者氏名
     */
    public RString get申請者氏名() {
        return entity.getShinseishaNameKanji();
    }

    /**
     * 申請者氏名カナを返します。
     *
     * @return 申請者氏名カナ
     */
    public RString get申請者氏名カナ() {
        return entity.getShinseishaNameKana();
    }

    /**
     * 申請者住所を返します。
     *
     * @return 申請者住所
     */
    public RString get申請者住所() {
        return entity.getShinseishaAddress();
    }

    /**
     * 申請者電話番号を返します。
     *
     * @return 申請者電話番号
     */
    public RString get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請事業者コードを返します。
     *
     * @return 申請事業者コード
     */
    public RString get申請事業者コード() {
        return entity.getShinseiJigyoshaCode();
    }

    /**
     * 支払金額合計を返します。
     *
     * @return 支払金額合計
     */
    public Decimal get支払金額合計() {
        return entity.getShiharaiKingakuTotal();
    }

    /**
     * 保険給付額を返します。
     *
     * @return 保険給付額
     */
    public int get保険給付額() {
        return entity.getHokenKyufuritsu();
    }

    /**
     * 利用者負担額を返します。
     *
     * @return 利用者負担額
     */
    public int get利用者負担額() {
        return entity.getRiyoshaFutangaku();
    }

    /**
     * 支給申請審査区分を返します。
     *
     * @return 支給申請審査区分
     */
    public RString get支給申請審査区分() {
        return entity.getShikyuShinseiShinsaKubun();
    }

    /**
     * 審査方法区分を返します。
     *
     * @return 審査方法区分
     */
    public RString get審査方法区分() {
        return entity.getShinsaHohoKubun();
    }

    /**
     * 送付年月を返します。
     *
     * @return 送付年月
     */
    public FlexibleYearMonth get送付年月() {
        return entity.getSofuYM();
    }

    /**
     * 支払方法区分コードを返します。
     *
     * @return 支払方法区分コード
     */
    public RString get支払方法区分コード() {
        return entity.getShiharaiHohoKubunCode();
    }

    /**
     * 支払場所を返します。
     *
     * @return 支払場所
     */
    public RString get支払場所() {
        return entity.getShiharaiBasho();
    }

    /**
     * 支払期間開始年月日を返します。
     *
     * @return 支払期間開始年月日
     */
    public FlexibleDate get支払期間開始年月日() {
        return entity.getShiharaiKaishiYMD();
    }

    /**
     * 支払期間終了年月日を返します。
     *
     * @return 支払期間終了年月日
     */
    public FlexibleDate get支払期間終了年月日() {
        return entity.getShiharaiShuryoYMD();
    }

    /**
     * 閉庁内容を返します。
     *
     * @return 閉庁内容
     */
    public RString get閉庁内容() {
        return entity.getHeichoNaiyo();
    }

    /**
     * 支払窓口開始時間を返します。
     *
     * @return 支払窓口開始時間
     */
    public RString get支払窓口開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払窓口終了期間を返します。
     *
     * @return 支払窓口終了期間
     */
    public RString get支払窓口終了期間() {
        return entity.getShiharaiShuryoTime();
    }

    /**
     * 口座IDを返します。
     *
     * @return 口座ID
     */
    public long get口座ID() {
        return entity.getKozaID();
    }

    /**
     * 受領委任契約番号を返します。
     *
     * @return 受領委任契約番号
     */
    public RString get受領委任契約番号() {
        return entity.getJuryoininKeiyakuNo();
    }

    /**
     * {@link DbT3034ShokanShinseiEntity}のクローンを返します。
     *
     * @return {@link DbT3034ShokanShinseiEntity}のクローン
     */
    @Override
    public DbT3034ShokanShinseiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 償還払支給申請の識別子{@link ShokanShinseiIdentifier}を返します。
     *
     * @return 償還払支給申請の識別子{@link ShokanShinseiIdentifier}
     */
    @Override
    public ShokanShinseiIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する償還払支給申請を削除対象とします。<br/>
     * {@link DbT3034ShokanShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShokanShinsei}
     */
    @Override
    public ShokanShinsei deleted() {
        DbT3034ShokanShinseiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShokanShinsei(deletedEntity, id);
    }

    /**
     * {@link ShokanShinsei}のシリアライズ形式を提供します。
     *
     * @return {@link ShokanShinsei}のシリアライズ形式
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

        private final DbT3034ShokanShinseiEntity entity;
        private final ShokanShinseiIdentifier id;

        private _SerializationProxy(DbT3034ShokanShinseiEntity entity, ShokanShinseiIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShokanShinsei(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShokanShinseiBuilder createBuilderForEdit() {
        return new ShokanShinseiBuilder(entity, id);
    }
//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。

}
