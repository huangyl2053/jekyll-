/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給住宅改修事前申請を管理するクラスです。
 */
public class ShokanJutakuKaishuJizenShinsei
        extends ModelBase<ShokanJutakuKaishuJizenShinseiIdentifier, DbT3035ShokanJutakuKaishuJizenShinseiEntity, ShokanJutakuKaishuJizenShinsei> implements Serializable {

    private final DbT3035ShokanJutakuKaishuJizenShinseiEntity entity;
    private final ShokanJutakuKaishuJizenShinseiIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 償還払支給住宅改修事前申請の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param サービス提供年月 サービス提供年月
     * @param 整理番号 整理番号
     */
    public ShokanJutakuKaishuJizenShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        this.entity = new DbT3035ShokanJutakuKaishuJizenShinseiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
        this.id = new ShokanJutakuKaishuJizenShinseiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号
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
                entity.getSeiriNo());
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
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
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
     * 申請事業者番号を返します。
     *
     * @return 申請事業者番号
     */
    public JigyoshaNo get事業者番号() {
        return entity.getShinseiJigyoshaNo();
    }

    /**
     * 理由書作成日を返します。
     *
     * @return 理由書作成日
     */
    public FlexibleDate get理由書作成日() {
        return entity.getRiyushoSakuseiYMD();
    }

    /**
     * 理由書作成者を返します。
     *
     * @return 理由書作成者
     */
    public RString get理由書作成者() {
        return entity.getRiyushoSakuseishaName();
    }

    /**
     * 理由書作成者カナを返します。
     *
     * @return 理由書作成者カナ
     */
    public RString get理由書作成者カナ() {
        return entity.getRiyushoSakuseishaKanaName();
    }

    /**
     * 理由書作成事業者番号を返します。
     *
     * @return 理由書作成事業者番号
     */
    public JigyoshaNo get理由書作成事業者番号() {
        return entity.getRiyushoSakuseiJigyoshaNo();
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
     * 支払窓口開始時間を返します。
     *
     * @return 支払窓口開始時間
     */
    public RString get支払窓口開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払窓口終了時間を返します。
     *
     * @return 支払窓口終了時間
     */
    public RString get支払窓口終了時間() {
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
     * サービス種類コードを返します。
     *
     * @return サービス種類コード
     */
    public ServiceShuruiCode getサービス種類コード() {
        return entity.getServiceShuruiCode();
    }

    /**
     * 住宅所有者を返します。
     *
     * @return 住宅所有者
     */
    public RString get住宅所有者() {
        return entity.getJutakuShoyusha();
    }

    /**
     * 被保険者との関係を返します。
     *
     * @return 被保険者との関係
     */
    public RString get被保険者との関係() {
        return entity.getHihokenshaKankei();
    }

    /**
     * 要介護状態３段階変更を返します。
     *
     * @return 要介護状態３段階変更
     */
    public boolean get要介護状態３段階変更() {
        return entity.getYokaigo3DankaiHenko();
    }

    /**
     * 住宅住所変更を返します。
     *
     * @return 住宅住所変更
     */
    public boolean get住宅住所変更() {
        return entity.getJutakuJushoHenko();
    }

    /**
     * 判定決定年月日を返します。
     *
     * @return 判定決定年月日
     */
    public FlexibleDate get判定決定年月日() {
        return entity.getHanteiKetteiYMD();
    }

    /**
     * 判定区分を返します。
     *
     * @return 判定区分
     */
    public FlexibleDate get判定区分() {
        return entity.getHanteiKetteiYMD();
    }

    /**
     * 承認条件を返します。
     *
     * @return 承認条件
     */
    public RString get承認条件() {
        return entity.getShoninJoken();
    }

    /**
     * 不承認理由を返します。
     *
     * @return 不承認理由
     */
    public RString get不承認理由() {
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
     * 事前申請決定通知発行日を返します。
     *
     * @return 事前申請決定通知発行日
     */
    public FlexibleDate get事前申請決定通知発行日() {
        return entity.getKetteitsuchishoHakkoYMD();
    }

    /**
     * 住宅改修申請区分を返します。
     *
     * @return 住宅改修申請区分
     */
    public RString get住宅改修申請区分() {
        return entity.getKaishushinseiKubun();
    }

    /**
     * 住宅改修申請取消事由コードを返します。
     *
     * @return 住宅改修申請取消事由コード
     */
    public RString get住宅改修申請取消事由コード() {
        return entity.getKaishuShinseiTorikeshijiyuCode();
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
     * 保険給付率を返します。
     *
     * @return 保険給付率
     */
    public HokenKyufuRitsu get保険給付率() {
        return entity.getHokenKyufuritsu();
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
