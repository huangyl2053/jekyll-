/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisai;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.gengaku.meisai.ShiharaiHohoHenkoGengakuMeisaiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4025ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shiharaihohohenko.ShiharaiHohoHenkoGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 支払方法変更減額を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class ShiharaiHohoHenkoGengaku
        extends ModelBase<ShiharaiHohoHenkoGengakuIdentifier, DbT4025ShiharaiHohoHenkoGengakuEntity, ShiharaiHohoHenkoGengaku>
        implements Serializable {

    private final DbT4025ShiharaiHohoHenkoGengakuEntity entity;
    private final ShiharaiHohoHenkoGengakuIdentifier id;
    private final Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai;

    /**
     * コンストラクタです。<br/>
     * 支払方法変更減額の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 管理区分 管理区分
     * @param 履歴番号 履歴番号
     */
    public ShiharaiHohoHenkoGengaku(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 管理区分,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(管理区分, UrSystemErrorMessages.値がnull.getReplacedMessage("管理区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4025ShiharaiHohoHenkoGengakuEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setKanriKubun(管理区分);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShiharaiHohoHenkoGengakuIdentifier(
                証記載保険者番号,
                被保険者番号,
                管理区分,
                履歴番号
        );
        this.shiharaiHohoHenkoGengakuMeisai = Models.create(new ArrayList<ShiharaiHohoHenkoGengakuMeisai>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4025ShiharaiHohoHenkoGengakuEntity}より{@link ShiharaiHohoHenkoGengaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT4025ShiharaiHohoHenkoGengakuEntity}
     */
    public ShiharaiHohoHenkoGengaku(ShiharaiHohoHenkoGengakuEntity entity) {
        this.entity = requireNonNull(entity.get支払方法変更減額Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更減額"));
        this.id = new ShiharaiHohoHenkoGengakuIdentifier(
                entity.get支払方法変更減額Entity().getShoKisaiHokenshaNo(),
                entity.get支払方法変更減額Entity().getHihokenshaNo(),
                entity.get支払方法変更減額Entity().getKanriKubun(),
                entity.get支払方法変更減額Entity().getRirekiNo());
        List<ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisaiList = new ArrayList<>();
        for (DbT4026ShiharaiHohoHenkoGengakuMeisaiEntity niniEntity : entity.get支払方法変更減額明細Entity()) {
            shiharaiHohoHenkoGengakuMeisaiList.add(new ShiharaiHohoHenkoGengakuMeisai(niniEntity));
        }
        this.shiharaiHohoHenkoGengakuMeisai = Models.create(shiharaiHohoHenkoGengakuMeisaiList);
    }

    // </editor-fold>
    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4025ShiharaiHohoHenkoGengakuEntity}
     * @param id {@link ShiharaiHohoHenkoGengakuIdentifier}
     */
    ShiharaiHohoHenkoGengaku(
            DbT4025ShiharaiHohoHenkoGengakuEntity entity,
            ShiharaiHohoHenkoGengakuIdentifier id,
            Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai
    ) {
        this.entity = entity;
        this.id = id;
        this.shiharaiHohoHenkoGengakuMeisai = shiharaiHohoHenkoGengakuMeisai;
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
     * 滞納判定年月日を返します。
     *
     * @return 滞納判定年月日
     */
    public FlexibleDate get滞納判定年月日() {
        return entity.getTainoHanteiYMD();
    }

    /**
     * 判定基準年月日を返します。
     *
     * @return 判定基準年月日
     */
    public FlexibleDate get判定基準年月日() {
        return entity.getHanteiKijunYMD();
    }

    /**
     * 徴収権消滅期間を返します。
     *
     * @return 徴収権消滅期間
     */
    public Decimal get徴収権消滅期間() {
        return entity.getChoshukenShometsuKikan();
    }

    /**
     * 納付済期間を返します。
     *
     * @return 納付済期間
     */
    public Decimal get納付済期間() {
        return entity.getNofusumiKikan();
    }

    /**
     * 納付済減額期間を返します。
     *
     * @return 納付済減額期間
     */
    public Decimal get納付済減額期間() {
        return entity.getNofusumiGengakuKikan();
    }

    /**
     * 確定減額期間開始年月日を返します。
     *
     * @return 確定減額期間開始年月日
     */
    public FlexibleDate get確定減額期間開始年月日() {
        return entity.getKakutei_GengakuKaishiYMD();
    }

    /**
     * 確定減額期間終了年月日を返します。
     *
     * @return 確定減額期間終了年月日
     */
    public FlexibleDate get確定減額期間終了年月日() {
        return entity.getKakutei_GengakuShuryoYMD();
    }

    /**
     * 論理削除フラグを返します。
     *
     * @return 論理削除フラグ
     */
    public boolean get論理削除フラグ() {
        return entity.getLogicalDeletedFlag();
    }

    /**
     * {@link DbT4025ShiharaiHohoHenkoGengakuEntity}のクローンを返します。
     *
     * @return {@link DbT4025ShiharaiHohoHenkoGengakuEntity}のクローン
     */
    @Override
    public DbT4025ShiharaiHohoHenkoGengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 支払方法変更減額の識別子{@link ShiharaiHohoHenkoGengakuIdentifier}を返します。
     *
     * @return 支払方法変更減額の識別子{@link ShiharaiHohoHenkoGengakuIdentifier}
     */
    @Override
    public ShiharaiHohoHenkoGengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 支払方法変更減額配下の要素を削除対象とします。<br/> {@link DbT4025ShiharaiHohoHenkoGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 支払方法変更減額配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link ShiharaiHohoHenkoGengaku}を返します。
     *
     * @return 削除対象処理実施後の{@link ShiharaiHohoHenkoGengaku}
     * @throws IllegalStateException DbT4025ShiharaiHohoHenkoGengakuEntityのデータ状態が変更の場合
     */
    @Override
    public ShiharaiHohoHenkoGengaku deleted() {
        DbT4025ShiharaiHohoHenkoGengakuEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShiharaiHohoHenkoGengaku(
                deletedEntity, id, shiharaiHohoHenkoGengakuMeisai.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shiharaiHohoHenkoGengakuMeisai.hasAnyChanged();
    }

    /**
     * 支払方法変更減額のみを変更対象とします。<br/> {@link DbT4025ShiharaiHohoHenkoGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShiharaiHohoHenkoGengaku}
     */
    public ShiharaiHohoHenkoGengaku modifiedModel() {
        DbT4025ShiharaiHohoHenkoGengakuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShiharaiHohoHenkoGengaku(
                modifiedEntity, id, shiharaiHohoHenkoGengakuMeisai);
    }

    /**
     * 支払方法変更減額が保持する精神手帳任意項目情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 精神手帳任意項目情報の識別子
     * @return 精神手帳任意項目情報
     * @throws IllegalStateException 指定の識別子に該当する精神手帳任意項目情報がない場合
     */
    public ShiharaiHohoHenkoGengakuMeisai getShiharaiHohoHenkoGengakuMeisai(ShiharaiHohoHenkoGengakuMeisaiIdentifier id) {
        if (shiharaiHohoHenkoGengakuMeisai.contains(id)) {
            return shiharaiHohoHenkoGengakuMeisai.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 支払方法変更減額が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<ShiharaiHohoHenkoGengakuMeisai> getShiharaiHohoHenkoGengakuMeisaiList() {
        return new ArrayList<>(shiharaiHohoHenkoGengakuMeisai.values());

    }

    /**
     * {@link ShiharaiHohoHenkoGengaku}のシリアライズ形式を提供します。
     *
     * @return {@link ShiharaiHohoHenkoGengaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shiharaiHohoHenkoGengakuMeisai);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT4025ShiharaiHohoHenkoGengakuEntity entity;
        private final ShiharaiHohoHenkoGengakuIdentifier id;
        private final Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai;

        private _SerializationProxy(
                DbT4025ShiharaiHohoHenkoGengakuEntity entity,
                ShiharaiHohoHenkoGengakuIdentifier id,
                Models<ShiharaiHohoHenkoGengakuMeisaiIdentifier, ShiharaiHohoHenkoGengakuMeisai> shiharaiHohoHenkoGengakuMeisai
        ) {
            this.entity = entity;
            this.id = id;
            this.shiharaiHohoHenkoGengakuMeisai = shiharaiHohoHenkoGengakuMeisai;
        }

        private Object readResolve() {
            return new ShiharaiHohoHenkoGengaku(this.entity, this.id, this.shiharaiHohoHenkoGengakuMeisai);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShiharaiHohoHenkoGengakuBuilder#build()}を使用してください。
     *
     * @return {@link ShiharaiHohoHenkoGengakuBuilder}
     */
    public ShiharaiHohoHenkoGengakuBuilder createBuilderForEdit() {
        return new ShiharaiHohoHenkoGengakuBuilder(entity, id, shiharaiHohoHenkoGengakuMeisai);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.entity);
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.shiharaiHohoHenkoGengakuMeisai);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ShiharaiHohoHenkoGengaku other = (ShiharaiHohoHenkoGengaku) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.shiharaiHohoHenkoGengakuMeisai, other.shiharaiHohoHenkoGengakuMeisai)) {
            return false;
        }
        return true;
    }

}
