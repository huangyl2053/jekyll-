/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 高額合算申請書を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class KogakuGassanShinseisho
        extends ModelBase<KogakuGassanShinseishoIdentifier, DbT3068KogakuGassanShinseishoEntity, KogakuGassanShinseisho>
        implements Serializable {

    private final DbT3068KogakuGassanShinseishoEntity entity;
    private final KogakuGassanShinseishoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 高額合算申請書の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年度 対象年度
     * @param 保険者番号 保険者番号
     * @param 整理番号 整理番号
     * @param 履歴番号 履歴番号
     */
    public KogakuGassanShinseisho(HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT3068KogakuGassanShinseishoEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setTaishoNendo(対象年度);
        this.entity.setHokenshaNo(保険者番号);
        this.entity.setSeiriNo(整理番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new KogakuGassanShinseishoIdentifier(
                被保険者番号,
                対象年度,
                保険者番号,
                整理番号,
                履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT3068KogakuGassanShinseishoEntity}より{@link KogakuGassanShinseisho}を生成します。
     *
     * @param entity DBより取得した{@link DbT3068KogakuGassanShinseishoEntity}
     */
    public KogakuGassanShinseisho(DbT3068KogakuGassanShinseishoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算申請書"));
        this.id = new KogakuGassanShinseishoIdentifier(
                entity.getHihokenshaNo(),
                entity.getTaishoNendo(),
                entity.getHokenshaNo(),
                entity.getSeiriNo(),
                entity.getRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT3068KogakuGassanShinseishoEntity}
     * @param id {@link KogakuGassanShinseishoIdentifier}
     */
    KogakuGassanShinseisho(
            DbT3068KogakuGassanShinseishoEntity entity,
            KogakuGassanShinseishoIdentifier id
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
     * 対象年度を返します。
     *
     * @return 対象年度
     */
    public FlexibleYear get対象年度() {
        return entity.getTaishoNendo();
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
     * 申請状況区分を返します。
     *
     * @return 申請状況区分
     */
    public RString get申請状況区分() {
        return entity.getShinseiJokyoKubun();
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
     * 支給申請書整理番号を返します。
     *
     * @return 支給申請書整理番号
     */
    public RString get支給申請書整理番号() {
        return entity.getShikyuShinseishoSeiriNo();
    }

    /**
     * 国保支給申請書整理番号を返します。
     *
     * @return 国保支給申請書整理番号
     */
    public RString get国保支給申請書整理番号() {
        return entity.getKokuhoShikyuShinseishoSeiriNo();
    }

    /**
     * 支給申請区分を返します。
     *
     * @return 支給申請区分
     */
    public RString get支給申請区分() {
        return entity.getShikyuShinseiKubun();
    }

    /**
     * 対象計算期間開始年月日を返します。
     *
     * @return 対象計算期間開始年月日
     */
    public FlexibleDate get対象計算期間開始年月日() {
        return entity.getTaishoKeisanKaishiYMD();
    }

    /**
     * 対象計算期間終了年月日を返します。
     *
     * @return 対象計算期間終了年月日
     */
    public FlexibleDate get対象計算期間終了年月日() {
        return entity.getTaishoKeisanShuryoYMD();
    }

    /**
     * 支給申請形態を返します。
     *
     * @return 支給申請形態
     */
    public RString get支給申請形態() {
        return entity.getShikyuShinseiKeitai();
    }

    /**
     * 自己負担額証明書交付申請の有無を返します。
     *
     * @return 自己負担額証明書交付申請の有無
     */
    public RString get自己負担額証明書交付申請の有無() {
        return entity.getJikoFutanKofuUmu();
    }

    /**
     * 申請代表者氏名を返します。
     *
     * @return 申請代表者氏名
     */
    public AtenaMeisho get申請代表者氏名() {
        return entity.getShinseiDaihyoshaShimei();
    }

    /**
     * 申請代表者郵便番号を返します。
     *
     * @return 申請代表者郵便番号
     */
    public YubinNo get申請代表者郵便番号() {
        return entity.getShinseiDaihyoshaYubinNo();
    }

    /**
     * 申請代表者住所を返します。
     *
     * @return 申請代表者住所
     */
    public RString get申請代表者住所() {
        return entity.getShinseiDaihyoshaJusho();
    }

    /**
     * 申請代表者電話番号を返します。
     *
     * @return 申請代表者電話番号
     */
    public TelNo get申請代表者電話番号() {
        return entity.getShinseiDaihyoshaTelNo();
    }

    /**
     * 所得区分を返します。
     *
     * @return 所得区分
     */
    public RString get所得区分() {
        return entity.getShotokuKubun();
    }

    /**
     * 70歳以上の者に係る所得区分を返します。
     *
     * @return 70歳以上の者に係る所得区分
     */
    public RString get所得区分_70歳以上の者に係る() {
        return entity.getOver70_ShotokuKubun();
    }

    /**
     * 資格喪失年月日を返します。
     *
     * @return 資格喪失年月日
     */
    public FlexibleDate get資格喪失年月日() {
        return entity.getShikakuSoshitsuYMD();
    }

    /**
     * 資格喪失事由を返します。
     *
     * @return 資格喪失事由
     */
    public RString get資格喪失事由() {
        return entity.getShikakuSoshitsuJiyu();
    }

    /**
     * 加入期間開始年月日を返します。
     *
     * @return 加入期間開始年月日
     */
    public FlexibleDate get加入期間開始年月日() {
        return entity.getKanyuKaishiYMD();
    }

    /**
     * 加入期間終了年月日を返します。
     *
     * @return 加入期間終了年月日
     */
    public FlexibleDate get加入期間終了年月日() {
        return entity.getKanyuShuryoYMD();
    }

    /**
     * 国保保険者番号を返します。
     *
     * @return 国保保険者番号
     */
    public RString get国保保険者番号() {
        return entity.getKokuho_HokenshaNo();
    }

    /**
     * 国保保険者名称を返します。
     *
     * @return 国保保険者名称
     */
    public RString get国保保険者名称() {
        return entity.getKokuho_HokenshaMeisho();
    }

    /**
     * 国保被保険者証記号を返します。
     *
     * @return 国保被保険者証記号
     */
    public RString get国保被保険者証記号() {
        return entity.getKokuho_HihokenshaShoKigo();
    }

    /**
     * 国保被保険者証番号を返します。
     *
     * @return 国保被保険者証番号
     */
    public RString get国保被保険者証番号() {
        return entity.getKokuho_HihokenshaShoNo();
    }

    /**
     * 国保世帯番号を返します。
     *
     * @return 国保世帯番号
     */
    public RString get国保世帯番号() {
        return entity.getKokuho_SetaiNo();
    }

    /**
     * 国保続柄を返します。
     *
     * @return 国保続柄
     */
    public RString get国保続柄() {
        return entity.getKokuho_Zokugara();
    }

    /**
     * 国保加入期間開始年月日を返します。
     *
     * @return 国保加入期間開始年月日
     */
    public FlexibleDate get国保加入期間開始年月日() {
        return entity.getKokuho_KanyuKaishiYMD();
    }

    /**
     * 国保加入期間終了年月日を返します。
     *
     * @return 国保加入期間終了年月日
     */
    public FlexibleDate get国保加入期間終了年月日() {
        return entity.getKokuho_KanyuShuryoYMD();
    }

    /**
     * 後期保険者番号を返します。
     *
     * @return 後期保険者番号
     */
    public RString get後期保険者番号() {
        return entity.getKoki_HokenshaNo();
    }

    /**
     * 後期広域連合名称を返します。
     *
     * @return 後期広域連合名称
     */
    public RString get後期広域連合名称() {
        return entity.getKoki_KoikiRengoMeisho();
    }

    /**
     * 後期被保険者番号を返します。
     *
     * @return 後期被保険者番号
     */
    public RString get後期被保険者番号() {
        return entity.getKoki_HihokenshaNo();
    }

    /**
     * 後期加入期間開始年月日を返します。
     *
     * @return 後期加入期間開始年月日
     */
    public FlexibleDate get後期加入期間開始年月日() {
        return entity.getKoki_KanyuKaishiYMD();
    }

    /**
     * 後期加入期間終了年月日を返します。
     *
     * @return 後期加入期間終了年月日
     */
    public FlexibleDate get後期加入期間終了年月日() {
        return entity.getKoki_KanyuShuryoYMD();
    }

    /**
     * 支払方法区分を返します。
     *
     * @return 支払方法区分
     */
    public RString get支払方法区分() {
        return entity.getShiharaiHohoKubun();
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
     * 支払期間開始時間を返します。
     *
     * @return 支払期間開始時間
     */
    public RString get支払期間開始時間() {
        return entity.getShiharaiKaishiTime();
    }

    /**
     * 支払期間終了時間を返します。
     *
     * @return 支払期間終了時間
     */
    public RString get支払期間終了時間() {
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
     * 備考を返します。
     *
     * @return 備考
     */
    public RString get備考() {
        return entity.getBiko();
    }

    /**
     * 支給申請書情報送付年月を返します。
     *
     * @return 支給申請書情報送付年月
     */
    public FlexibleYearMonth get支給申請書情報送付年月() {
        return entity.getShikyuShinseisho_SofuYM();
    }

    /**
     * 再送フラグを返します。
     *
     * @return 再送フラグ
     */
    public RString get再送フラグ() {
        return entity.getSaiSofuFlag();
    }

    /**
     * 自己負担額計算年月を返します。
     *
     * @return 自己負担額計算年月
     */
    public FlexibleYearMonth get自己負担額計算年月() {
        return entity.getJikoFutan_KeisanYM();
    }

    /**
     * 再計算区分を返します。
     *
     * @return 再計算区分
     */
    public RString get再計算区分() {
        return entity.getSaiKeisanKubun();
    }

    /**
     * {@link DbT3068KogakuGassanShinseishoEntity}のクローンを返します。
     *
     * @return {@link DbT3068KogakuGassanShinseishoEntity}のクローン
     */
    @Override
    public DbT3068KogakuGassanShinseishoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 高額合算申請書の識別子{@link KogakuGassanShinseishoIdentifier}を返します。
     *
     * @return 高額合算申請書の識別子{@link KogakuGassanShinseishoIdentifier}
     */
    @Override
    public KogakuGassanShinseishoIdentifier identifier() {
        return this.id;
    }

    /**
     * 保持する高額合算申請書を削除対象とします。<br/>
     * {@link DbT3068KogakuGassanShinseishoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link KogakuGassanShinseisho}
     */
    @Override
    public KogakuGassanShinseisho deleted() {
        DbT3068KogakuGassanShinseishoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KogakuGassanShinseisho(deletedEntity, id);
    }

    /**
     * {@link KogakuGassanShinseisho}のシリアライズ形式を提供します。
     *
     * @return {@link KogakuGassanShinseisho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;

        private final DbT3068KogakuGassanShinseishoEntity entity;
        private final KogakuGassanShinseishoIdentifier id;

        private _SerializationProxy(DbT3068KogakuGassanShinseishoEntity entity, KogakuGassanShinseishoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new KogakuGassanShinseisho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public KogakuGassanShinseishoBuilder createBuilderForEdit() {
        return new KogakuGassanShinseishoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
