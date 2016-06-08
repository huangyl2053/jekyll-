/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 利用者負担額減額を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class RiyoshaFutangakuGengaku
        extends ParentModelBase<RiyoshaFutangakuGengakuIdentifier, DbT4014RiyoshaFutangakuGengakuEntity, RiyoshaFutangakuGengaku>
        implements Serializable {

    private final DbT4014RiyoshaFutangakuGengakuEntity entity;
    private final RiyoshaFutangakuGengakuIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 利用者負担額減額の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public RiyoshaFutangakuGengaku(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4014RiyoshaFutangakuGengakuEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new RiyoshaFutangakuGengakuIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );

        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link RiyoshaFutangakuGengakuEntity}より{@link RiyoshaFutangakuGengaku}を生成します。
     *
     * @param entity DBより取得した{@link RiyoshaFutangakuGengakuEntity}
     */
    public RiyoshaFutangakuGengaku(RiyoshaFutangakuGengakuEntity entity) {
        this.entity = requireNonNull(entity.get利用者負担額減額Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額"));
        this.id = new RiyoshaFutangakuGengakuIdentifier(
                entity.get利用者負担額減額Entity().getShoKisaiHokenshaNo(),
                entity.get利用者負担額減額Entity().getHihokenshaNo(),
                entity.get利用者負担額減額Entity().getRirekiNo());

        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity shinseiEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(shinseiEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4014RiyoshaFutangakuGengakuEntity}
     * @param id {@link RiyoshaFutangakuGengakuIdentifier}
     * @param gemmenGengakuShinsei {@link GemmenGengakuShinsei}
     */
    RiyoshaFutangakuGengaku(
            DbT4014RiyoshaFutangakuGengakuEntity entity,
            RiyoshaFutangakuGengakuIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity;
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }

    /**
     * 旧措置者有無を返します。
     *
     * @return 旧措置者有無
     */
    public boolean is旧措置者有無() {
        return entity.getKyuSochishaUmu();
    }

    /**
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 給付率を返します。
     *
     * @return 給付率
     */
    public HokenKyufuRitsu get給付率() {
        return entity.getKyuhuritsu();
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
     * 決定年月日を返します。
     *
     * @return 決定年月日
     */
    public FlexibleDate get決定年月日() {
        return entity.getKetteiYMD();
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
     * 決定区分を返します。
     *
     * @return 決定区分
     */
    public RString get決定区分() {
        return entity.getKetteiKubun();
    }

    /**
     * 非承認理由を返します。
     *
     * @return 非承認理由
     */
    public RString get非承認理由() {
        return entity.getHiShoninRiyu();
    }

    /**
     * {@link DbT4014RiyoshaFutangakuGengakuEntity}のクローンを返します。
     *
     * @return {@link DbT4014RiyoshaFutangakuGengakuEntity}のクローン
     */
    @Override
    public DbT4014RiyoshaFutangakuGengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 利用者負担額減額の識別子{@link RiyoshaFutangakuGengakuIdentifier}を返します。
     *
     * @return 利用者負担額減額の識別子{@link RiyoshaFutangakuGengakuIdentifier}
     */
    @Override
    public RiyoshaFutangakuGengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 利用者負担額減額が保持する減免減額申請に対して、指定の識別子に該当する減免減額申請を返します。
     *
     * @param id 減免減額申請の識別子
     * @return 減免減額申請
     * @throws IllegalStateException 指定の識別子に該当する減免減額申請がない場合
     */
    public GemmenGengakuShinsei getGemmenGengakuShinsei(GemmenGengakuShinseiIdentifier id) {
        if (gemmenGengakuShinsei.contains(id)) {
            return gemmenGengakuShinsei.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 利用者負担額減額が保持する減免減額申請をリストで返します。
     *
     * @return 減免減額申請リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());
    }

    /**
     * 利用者負担額減額のみを変更対象とします。<br/> {@link DbT4014RiyoshaFutangakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link RiyoshaFutangakuGengaku}
     */
    @Override
    public RiyoshaFutangakuGengaku modifiedModel() {
        DbT4014RiyoshaFutangakuGengakuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new RiyoshaFutangakuGengaku(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 保持する利用者負担額減額を削除対象とします。<br/> {@link DbT4014RiyoshaFutangakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link RiyoshaFutangakuGengaku}
     */
    @Override
    public RiyoshaFutangakuGengaku deleted() {
        DbT4014RiyoshaFutangakuGengakuEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new RiyoshaFutangakuGengaku(deletedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * {@link RiyoshaFutangakuGengaku}のシリアライズ形式を提供します。
     *
     * @return {@link RiyoshaFutangakuGengaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmenGengakuShinsei);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -5566020783422482414L;
        private final DbT4014RiyoshaFutangakuGengakuEntity entity;
        private final RiyoshaFutangakuGengakuIdentifier id;
        private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

        private _SerializationProxy(DbT4014RiyoshaFutangakuGengakuEntity entity,
                RiyoshaFutangakuGengakuIdentifier id,
                Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei) {
            this.entity = entity;
            this.id = id;
            this.gemmenGengakuShinsei = gemmenGengakuShinsei;
        }

        private Object readResolve() {
            return new RiyoshaFutangakuGengaku(this.entity, this.id, this.gemmenGengakuShinsei);
        }

    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public RiyoshaFutangakuGengakuBuilder createBuilderForEdit() {
        return new RiyoshaFutangakuGengakuBuilder(entity, id, gemmenGengakuShinsei);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final RiyoshaFutangakuGengaku other = (RiyoshaFutangakuGengaku) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
