/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 償還払支給申請を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
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
     * @param 整理番号 整理番号 // * @param 履歴番号 履歴番号
     */
    public ShokanShinsei(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号
    //            Decimal 履歴番号
    ) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
//        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3034ShokanShinseiEntity();
        this.entity.setHiHokenshaNo(被保険者番号);
        this.entity.setServiceTeikyoYM(サービス提供年月);
        this.entity.setSeiriNo(整理番号);
//        this.entity.setRirekiNo(履歴番号);
        this.id = new ShokanShinseiIdentifier(
                被保険者番号,
                サービス提供年月,
                整理番号
        //                履歴番号
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
                entity.getSeiriNo()
        //                entity.getRirekiNo()
        );
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
     * 保険対象費用額を返します。
     *
     * @return 保険対象費用額
     */
    public Decimal get保険対象費用額() {
        return entity.getHokenTaishoHiyogaku();
    }

    /**
     * 国保連再送付フラグを返します。
     *
     * @return 国保連再送付フラグ
     */
    public boolean is国保連再送付フラグ() {
        return entity.getKokuhorenSaisofuFlag();
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
     * 審査年月日を返します。
     *
     * @return 審査年月日
     */
    public FlexibleDate get審査年月日() {
        return entity.getShinsaYMD();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
//    public Decimal get履歴番号() {
//        return entity.getRirekiNo();
//    }
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
     * 領収年月日を返します。
     *
     * @return 領収年月日
     */
    public FlexibleDate get領収年月日() {
        return entity.getRyoshuYMD();
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
     * 住宅住所変更を返します。
     *
     * @return 住宅住所変更
     */
    public boolean is住宅住所変更() {
        return entity.getJutakuJushoHenko();
    }

    /**
     * 要介護状態３段階変更を返します。
     *
     * @return 要介護状態３段階変更
     */
    public boolean is要介護状態３段階変更() {
        return entity.getYokaigo3DankaiHenko();
    }

    /**
     * 審査結果を返します。
     *
     * @return 審査結果
     */
    public RString get審査結果() {
        return entity.getShinsaKekka();
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
    public TelNo get申請者電話番号() {
        return entity.getShinseishaTelNo();
    }

    /**
     * 申請事業者コードを返します。
     *
     * @return 申請事業者コード
     */
    public JigyoshaNo get申請事業者コード() {
        return entity.getShinseiJigyoshaNo();
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
        return entity.getHokenKyufugaku();
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
//    public RString get閉庁内容() {
//        return entity.getHeichoNaiyo();
//    }
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
     * 保持する償還払支給申請を削除対象とします。<br/> {@link DbT3034ShokanShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
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
     * 住宅改修申請取消事由コードを返します。
     *
     * @return 住宅改修申請取消事由コード
     */
    public RString get住宅改修申請取消事由コード() {
        return entity.getKaishuShinseiTorikeshijiyuCode();
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
     * 理由書作成日を返します。
     *
     * @return 理由書作成日
     */
    public FlexibleDate get理由書作成日() {
        return entity.getRiyushoSakuseiYMD();
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
     * 理由書作成者を返します。
     *
     * @return 理由書作成者
     */
    public RString get理由書作成者() {
        return entity.getRiyushoSakuseishaName();
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
     * 事前申請サービス提供年月を返します。
     *
     * @return 事前申請サービス提供年月
     */
    public FlexibleYearMonth get事前申請サービス提供年月() {
        return entity.getJizenServiceTeikyoYM();
    }

    /**
     * 事前申請整理番号を返します。
     *
     * @return 事前申請整理番号
     */
    public RString get事前申請整理番号() {
        return entity.getJizenSeiriNo();
    }

    /**
     * 償還払支給申請のみを変更対象とします。<br/> {@link DbT3034ShokanShinseiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShokanShinsei}
     */
    public ShokanShinsei modifiedModel() {
        DbT3034ShokanShinseiEntity modifiedEntity = this.toEntity();
        modifiedEntity.setState(EntityDataState.Modified);
        return new ShokanShinsei(modifiedEntity, id);
    }
}
