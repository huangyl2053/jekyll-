/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.ShiharaiHohoHenkoGengakuIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitome;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.sashitome.ShiharaiHohoHenkoSashitomeIdentifier;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTaino;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.taino.ShiharaiHohoHenkoTainoIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4022ShiharaiHohoHenkoTainoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4024ShiharaiHohoHenkoSashitomeEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenko
        extends ParentModelBase<ShiharaiHohoHenkoIdentifier, DbT4021ShiharaiHohoHenkoEntity, ShiharaiHohoHenko> implements Serializable {

    private final DbT4021ShiharaiHohoHenkoEntity entity;
    private final ShiharaiHohoHenkoIdentifier id;
    private final Models<ShiharaiHohoHenkoTainoIdentifier, ShiharaiHohoHenkoTaino> shiharaiHohoHenkoTaino;
    private final Models<ShiharaiHohoHenkoSashitomeIdentifier, ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitome;
    private final Models<ShiharaiHohoHenkoGengakuIdentifier, ShiharaiHohoHenkoGengaku> shiharaiHohoHenkoGengaku;

    /**
     * コンストラクタです。<br/>
     * 支払方法変更の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     */
    public ShiharaiHohoHenko(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4021ShiharaiHohoHenkoEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriKubun(管理区分);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShiharaiHohoHenkoIdentifier(
                証記載保険者番号,
                被保険者番号,
                管理区分,
                履歴番号
        );
        this.shiharaiHohoHenkoTaino = Models.create(new ArrayList<ShiharaiHohoHenkoTaino>());
        this.shiharaiHohoHenkoSashitome = Models.create(new ArrayList<ShiharaiHohoHenkoSashitome>());
        this.shiharaiHohoHenkoGengaku = Models.create(new ArrayList<ShiharaiHohoHenkoGengaku>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4021ShiharaiHohoHenkoEntity}より{@link ShiharaiHohoHenko}を生成します。
     *
     * @param entity DBより取得した{@link DbT4021ShiharaiHohoHenkoEntity}
     */
    public ShiharaiHohoHenko(ShiharaiHohoHenkoEntity entity) {
        this.entity = requireNonNull(entity.get支払方法変更Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更"));
        this.id = new ShiharaiHohoHenkoIdentifier(
                entity.get支払方法変更Entity().getShoKisaiHokenshaNo(),
                entity.get支払方法変更Entity().getHihokenshaNo(),
                entity.get支払方法変更Entity().getKanriKubun(),
                entity.get支払方法変更Entity().getRirekiNo());
        List<ShiharaiHohoHenkoTaino> shiharaiHohoHenkoTainoList = new ArrayList<>();
        for (DbT4022ShiharaiHohoHenkoTainoEntity niniEntity : entity.get支払方法変更滞納Entity()) {
            shiharaiHohoHenkoTainoList.add(new ShiharaiHohoHenkoTaino(niniEntity));
        }
        this.shiharaiHohoHenkoTaino = Models.create(shiharaiHohoHenkoTainoList);

        List<ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitomeList = new ArrayList<>();
        for (DbT4024ShiharaiHohoHenkoSashitomeEntity todokedeshaEntity : entity.get支払方法変更差止Entity()) {
            shiharaiHohoHenkoSashitomeList.add(new ShiharaiHohoHenkoSashitome(todokedeshaEntity));
        }
        this.shiharaiHohoHenkoSashitome = Models.create(shiharaiHohoHenkoSashitomeList);

        List<ShiharaiHohoHenkoGengaku> shiharaiHohoHenkoGengakuList = new ArrayList<>();
        for (ShiharaiHohoHenkoGengakuEntity todokedeshaEntity : entity.get支払方法変更減額Entity()) {
            shiharaiHohoHenkoGengakuList.add(new ShiharaiHohoHenkoGengaku(todokedeshaEntity));
        }
        this.shiharaiHohoHenkoGengaku = Models.create(shiharaiHohoHenkoGengakuList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4021ShiharaiHohoHenkoEntity}
     * @param id {@link ShiharaiHohoHenkoIdentifier}
     */
    ShiharaiHohoHenko(
            DbT4021ShiharaiHohoHenkoEntity entity,
            ShiharaiHohoHenkoIdentifier id,
            Models<ShiharaiHohoHenkoTainoIdentifier, ShiharaiHohoHenkoTaino> shiharaiHohoHenkoTaino,
            Models<ShiharaiHohoHenkoSashitomeIdentifier, ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitome,
            Models<ShiharaiHohoHenkoGengakuIdentifier, ShiharaiHohoHenkoGengaku> shiharaiHohoHenkoGengaku
    ) {
        this.entity = entity;
        this.id = id;
        this.shiharaiHohoHenkoTaino = shiharaiHohoHenkoTaino;
        this.shiharaiHohoHenkoSashitome = shiharaiHohoHenkoSashitome;
        this.shiharaiHohoHenkoGengaku = shiharaiHohoHenkoGengaku;
    }

    /**
     * エンティティのデータ状態を取得します。
     *
     * @return エンティティのデータ状態
     */
    public EntityDataState getState() {
        return entity.getState();
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
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 管理区分を返します。
     *
     * @return 管理区分
     */
    public RString get管理区分() {
        return entity.getKanriKubun();
    }

    /**
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 登録区分を返します。
     *
     * @return 登録区分
     */
    public RString get登録区分() {
        return entity.getTorokuKubun();
    }

    /**
     * 適用開始年月日を返します。
     *
     * @return 適用開始年月日
     */
    public FlexibleDate get適用開始年月日() {
        return entity.getTekiyoKaishiYMD();
    }

    /**
     * 適用終了年月日を返します。
     *
     * @return 適用終了年月日
     */
    public FlexibleDate get適用終了年月日() {
        return entity.getTekiyoShuryoYMD();
    }

    /**
     * 終了区分を返します。
     *
     * @return 終了区分
     */
    public RString get終了区分() {
        return entity.getShuryoKubun();
    }

    /**
     * 予告登録年月日を返します。
     *
     * @return 予告登録年月日
     */
    public FlexibleDate get予告登録年月日() {
        return entity.getYokoku_TorokuYMD();
    }

    /**
     * 差止依頼書受理年月日を返します。
     *
     * @return 差止依頼書受理年月日
     */
    public FlexibleDate get差止依頼書受理年月日() {
        return entity.getSashitome_IraiJuriYMD();
    }

    /**
     * 予告通知書発行年月日を返します。
     *
     * @return 予告通知書発行年月日
     */
    public FlexibleDate get予告通知書発行年月日() {
        return entity.getYokoku_TsuchiHakkoYMD();
    }

    /**
     * 予告通知書再発行フラグを返します。
     *
     * @return 予告通知書再発行フラグ
     */
    public boolean is予告通知書再発行フラグ() {
        return entity.getYokoku_TsuchiSaiHakkoFlag();
    }

    /**
     * 弁明書提出期限を返します。
     *
     * @return 弁明書提出期限
     */
    public FlexibleDate get弁明書提出期限() {
        return entity.getBemmei_TeishutsuYMD();
    }

    /**
     * 弁明書受付年月日を返します。
     *
     * @return 弁明書受付年月日
     */
    public FlexibleDate get弁明書受付年月日() {
        return entity.getBemmei_UketsukeYMD();
    }

    /**
     * 弁明理由コードを返します。
     *
     * @return 弁明理由コード
     */
    public RString get弁明理由コード() {
        return entity.getBemmei_RiyuCode();
    }

    /**
     * 弁明審査決定年月日を返します。
     *
     * @return 弁明審査決定年月日
     */
    public FlexibleDate get弁明審査決定年月日() {
        return entity.getBemmei_ShinsaKetteiYMD();
    }

    /**
     * 弁明審査結果区分を返します。
     *
     * @return 弁明審査結果区分
     */
    public RString get弁明審査結果区分() {
        return entity.getBemmei_ShinsaKekkaKubun();
    }

    /**
     * 償還払化決定年月日を返します。
     *
     * @return 償還払化決定年月日
     */
    public FlexibleDate get償還払化決定年月日() {
        return entity.getShokan_KetteiYMD();
    }

    /**
     * 償還払化通知書発行年月日を返します。
     *
     * @return 償還払化通知書発行年月日
     */
    public FlexibleDate get償還払化通知書発行年月日() {
        return entity.getShokan_TsuchiHakkoYMD();
    }

    /**
     * 償還払化通知書再発行フラグを返します。
     *
     * @return 償還払化通知書再発行フラグ
     */
    public boolean is償還払化通知書再発行フラグ() {
        return entity.getShokan_TsuchiSaiHakkoFlag();
    }

    /**
     * 被保険者証提出期限を返します。
     *
     * @return 被保険者証提出期限
     */
    public FlexibleDate get被保険者証提出期限() {
        return entity.getHihokenshaShoTeishutsuYMD();
    }

    /**
     * 差止対象フラグを返します。
     *
     * @return 差止対象フラグ
     */
    public boolean is差止対象フラグ() {
        return entity.getSashitome_Flag();
    }

    /**
     * 差止対象決定年月日を返します。
     *
     * @return 差止対象決定年月日
     */
    public FlexibleDate get差止対象決定年月日() {
        return entity.getSashitome_KetteiYMD();
    }

    /**
     * 差止対象解除年月日を返します。
     *
     * @return 差止対象解除年月日
     */
    public FlexibleDate get差止対象解除年月日() {
        return entity.getSashitome_KaijoYMD();
    }

    /**
     * 減額決定年月日を返します。
     *
     * @return 減額決定年月日
     */
    public FlexibleDate get減額決定年月日() {
        return entity.getGemmen_KetteiYMD();
    }

    /**
     * 減額通知書発行年月日を返します。
     *
     * @return 減額通知書発行年月日
     */
    public FlexibleDate get減額通知書発行年月日() {
        return entity.getGemmen_TsuchiHakkoYMD();
    }

    /**
     * 減額通知書再発行フラグを返します。
     *
     * @return 減額通知書再発行フラグ
     */
    public boolean is減額通知書再発行フラグ() {
        return entity.getGemmen_TsuchiSaiHakkoFlag();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyufuRitsu();
    }

    /**
     * 終了申請書受付年月日を返します。
     *
     * @return 終了申請書受付年月日
     */
    public FlexibleDate get終了申請書受付年月日() {
        return entity.getShuryoShinsei_UketsukeYMD();
    }

    /**
     * 終了申請年月日を返します。
     *
     * @return 終了申請年月日
     */
    public FlexibleDate get終了申請年月日() {
        return entity.getShuryoShinsei_YMD();
    }

    /**
     * 終了申請理由コードを返します。
     *
     * @return 終了申請理由コード
     */
    public RString get終了申請理由コード() {
        return entity.getShuryoShinsei_RiyuCode();
    }

    /**
     * 終了申請審査決定年月日を返します。
     *
     * @return 終了申請審査決定年月日
     */
    public FlexibleDate get終了申請審査決定年月日() {
        return entity.getShuryoShinsei_ShinsaKetteiYMD();
    }

    /**
     * 終了申請審査結果区分を返します。
     *
     * @return 終了申請審査結果区分
     */
    public RString get終了申請審査結果区分() {
        return entity.getShuryoShinsei_ShinsaKekkaKubun();
    }

    /**
     * 無効区分を返します。
     *
     * @return 無効区分
     */
    public RString get無効区分() {
        return entity.getMukoKubun();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean is論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT4021ShiharaiHohoHenkoEntity}のクローンを返します。
     *
     * @return {@link DbT4021ShiharaiHohoHenkoEntity}のクローン
     */
    @Override
    public DbT4021ShiharaiHohoHenkoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 支払方法変更の識別子{@link ShiharaiHohoHenkoIdentifier}を返します。
     *
     * @return 支払方法変更の識別子{@link ShiharaiHohoHenkoIdentifier}
     */
    @Override
    public ShiharaiHohoHenkoIdentifier identifier() {
        return this.id;
    }

    /**
     * 支払方法変更配下の要素を削除対象とします。<br/> {@link DbT4021ShiharaiHohoHenkoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 支払方法変更配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link ShiharaiHohoHenko}を返します。
     *
     * @return 削除対象処理実施後の{@link ShiharaiHohoHenko}
     * @throws IllegalStateException DbT4021ShiharaiHohoHenkoEntityのデータ状態が変更の場合
     */
    @Override
    public ShiharaiHohoHenko deleted() {
        DbT4021ShiharaiHohoHenkoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShiharaiHohoHenko(
                deletedEntity, id, shiharaiHohoHenkoTaino.deleted(), shiharaiHohoHenkoSashitome.deleted(), shiharaiHohoHenkoGengaku.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shiharaiHohoHenkoTaino.hasAnyChanged()
                || shiharaiHohoHenkoSashitome.hasAnyChanged() || shiharaiHohoHenkoGengaku.hasAnyChanged();
    }

    /**
     * 支払方法変更のみを変更対象とします。<br/> {@link DbT4021ShiharaiHohoHenkoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShiharaiHohoHenko}
     */
    @Override
    public ShiharaiHohoHenko modifiedModel() {
        DbT4021ShiharaiHohoHenkoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShiharaiHohoHenko(
                modifiedEntity, id, shiharaiHohoHenkoTaino, shiharaiHohoHenkoSashitome, shiharaiHohoHenkoGengaku);
    }

    /**
     * 支払方法変更が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 支払方法変更の識別子
     * @return 支払方法変更
     * @throws IllegalStateException 指定の識別子に該当する支払方法変更がない場合
     */
    public ShiharaiHohoHenkoTaino getShiharaiHohoHenkoTaino(ShiharaiHohoHenkoTainoIdentifier id) {
        if (shiharaiHohoHenkoTaino.contains(id)) {
            return shiharaiHohoHenkoTaino.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 支払方法変更が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精払方法変更情報リスト
     */
    public List<ShiharaiHohoHenkoTaino> getShiharaiHohoHenkoTainoList() {
        return new ArrayList<>(shiharaiHohoHenkoTaino.values());

    }

    /**
     * 支払方法変更が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 届出者情報の識別子
     * @return 届出者情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public ShiharaiHohoHenkoSashitome getShiharaiHohoHenkoSashitome(ShiharaiHohoHenkoSashitomeIdentifier id) {
        if (shiharaiHohoHenkoSashitome.contains(id)) {
            return shiharaiHohoHenkoSashitome.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 支払方法変更が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<ShiharaiHohoHenkoSashitome> getShiharaiHohoHenkoSashitomeList() {
        return new ArrayList<>(shiharaiHohoHenkoSashitome.values());
    }

    /**
     * 支払方法変更が保持する届出者情報に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 届出者情報の識別子
     * @return 届出者情報
     * @throws IllegalStateException 指定の識別子に該当する届出者情報がない場合
     */
    public ShiharaiHohoHenkoGengaku getShiharaiHohoHenkoGengaku(ShiharaiHohoHenkoGengakuIdentifier id) {
        if (shiharaiHohoHenkoGengaku.contains(id)) {
            return shiharaiHohoHenkoGengaku.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 支払方法変更が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<ShiharaiHohoHenkoGengaku> getShiharaiHohoHenkoGengakuList() {
        return new ArrayList<>(shiharaiHohoHenkoGengaku.values());
    }

    /**
     * {@link ShiharaiHohoHenko}のシリアライズ形式を提供します。
     *
     * @return {@link ShiharaiHohoHenko}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shiharaiHohoHenkoTaino, shiharaiHohoHenkoSashitome, shiharaiHohoHenkoGengaku);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT4021ShiharaiHohoHenkoEntity entity;
        private final ShiharaiHohoHenkoIdentifier id;
        private final Models<ShiharaiHohoHenkoTainoIdentifier, ShiharaiHohoHenkoTaino> shiharaiHohoHenkoTaino;
        private final Models<ShiharaiHohoHenkoSashitomeIdentifier, ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitome;
        private final Models<ShiharaiHohoHenkoGengakuIdentifier, ShiharaiHohoHenkoGengaku> shiharaiHohoHenkoGengaku;

        private _SerializationProxy(
                DbT4021ShiharaiHohoHenkoEntity entity,
                ShiharaiHohoHenkoIdentifier id,
                Models<ShiharaiHohoHenkoTainoIdentifier, ShiharaiHohoHenkoTaino> shiharaiHohoHenkoTaino,
                Models<ShiharaiHohoHenkoSashitomeIdentifier, ShiharaiHohoHenkoSashitome> shiharaiHohoHenkoSashitome,
                Models<ShiharaiHohoHenkoGengakuIdentifier, ShiharaiHohoHenkoGengaku> shiharaiHohoHenkoGengaku
        ) {
            this.entity = entity;
            this.id = id;
            this.shiharaiHohoHenkoTaino = shiharaiHohoHenkoTaino;
            this.shiharaiHohoHenkoSashitome = shiharaiHohoHenkoSashitome;
            this.shiharaiHohoHenkoGengaku = shiharaiHohoHenkoGengaku;
        }

        private Object readResolve() {
            return new ShiharaiHohoHenko(
                    this.entity, this.id, this.shiharaiHohoHenkoTaino, this.shiharaiHohoHenkoSashitome, this.shiharaiHohoHenkoGengaku);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShiharaiHohoHenkoBuilder#build()}を使用してください。
     *
     * @return {@link ShiharaiHohoHenkoBuilder}
     */
    public ShiharaiHohoHenkoBuilder createBuilderForEdit() {
        return new ShiharaiHohoHenkoBuilder(entity, id, shiharaiHohoHenkoTaino, shiharaiHohoHenkoSashitome, shiharaiHohoHenkoGengaku);
    }
}
