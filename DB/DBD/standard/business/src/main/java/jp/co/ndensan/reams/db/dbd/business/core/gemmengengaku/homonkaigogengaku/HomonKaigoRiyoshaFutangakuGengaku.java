/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengakuEntity;
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
 * 訪問介護利用者負担額減額を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class HomonKaigoRiyoshaFutangakuGengaku extends ParentModelBase<
        HomonKaigoRiyoshaFutangakuGengakuIdentifier, DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity, HomonKaigoRiyoshaFutangakuGengaku>
        implements Serializable {

    private final DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity;
    private final HomonKaigoRiyoshaFutangakuGengakuIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 訪問介護利用者負担額減額の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public HomonKaigoRiyoshaFutangakuGengaku(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new HomonKaigoRiyoshaFutangakuGengakuIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}より{@link HomonKaigoRiyoshaFutangakuGengaku}を生成します。
     *
     * @param entity DBより取得した{@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}
     */
    public HomonKaigoRiyoshaFutangakuGengaku(HomonKaigoRiyoshaFutangakuGengakuEntity entity) {
        this.entity = requireNonNull(entity.get訪問介護利用者負担額減額Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("訪問介護利用者負担額減額"));
        this.id = new HomonKaigoRiyoshaFutangakuGengakuIdentifier(
                entity.get訪問介護利用者負担額減額Entity().getShoKisaiHokenshaNo(),
                entity.get訪問介護利用者負担額減額Entity().getHihokenshaNo(),
                entity.get訪問介護利用者負担額減額Entity().getRirekiNo());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity niniEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(niniEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);

    }

    // </editor-fold>
    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}
     * @param id {@link HomonKaigoRiyoshaFutangakuGengakuIdentifier}
     */
    HomonKaigoRiyoshaFutangakuGengaku(
            DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity,
            HomonKaigoRiyoshaFutangakuGengakuIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity;
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * 法別区分を返します。
     *
     * @return 法別区分
     */
    public RString get法別区分() {
        return entity.getHobetsuKubun();
    }

    /**
     * 障害者手帳有無を返します。
     *
     * @return 障害者手帳有無
     */
    public boolean is障害者手帳有無() {
        return entity.getShogaishaTechoUmu();
    }

    /**
     * 障害者手帳等級を返します。
     *
     * @return 障害者手帳等級
     */
    public RString get障害者手帳等級() {
        return entity.getShogaishaTechoTokyu();
    }

    /**
     * 障害者手帳番号を返します。
     *
     * @return 障害者手帳番号
     */
    public RString get障害者手帳番号() {
        return entity.getShogaishaTechoNo();
    }

    /**
     * 障害者手帳交付年月日を返します。
     *
     * @return 障害者手帳交付年月日
     */
    public FlexibleDate get障害者手帳交付年月日() {
        return entity.getShogaishaTechoKofuYMD();
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
        return entity.getKyufuritsu();
    }

    /**
     * 公費負担者番号を返します。
     *
     * @return 公費負担者番号
     */
    public RString get公費負担者番号() {
        return entity.getKohiFutanshaNo();
    }

    /**
     * 公費受給者番号を返します。
     *
     * @return 公費受給者番号
     */
    public RString get公費受給者番号() {
        return entity.getKohiJukyushaNo();
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
     * {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}のクローンを返します。
     *
     * @return {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}のクローン
     */
    @Override
    public DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 訪問介護利用者負担額減額の識別子{@link HomonKaigoRiyoshaFutangakuGengakuIdentifier}を返します。
     *
     * @return 訪問介護利用者負担額減額の識別子{@link HomonKaigoRiyoshaFutangakuGengakuIdentifier}
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengakuIdentifier identifier() {
        return this.id;
    }

    /**
     * 訪問介護利用者負担額減額配下の要素を削除対象とします。<br/> {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 訪問介護利用者負担額減額配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link HomonKaigoRiyoshaFutangakuGengaku}を返します。
     *
     * @return 削除対象処理実施後の{@link HomonKaigoRiyoshaFutangakuGengaku}
     * @throws IllegalStateException DbT4016HomonKaigoRiyoshaFutangakuGengakuEntityのデータ状態が変更の場合
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengaku deleted() {
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new HomonKaigoRiyoshaFutangakuGengaku(
                deletedEntity, id, gemmenGengakuShinsei.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    /**
     * 訪問介護利用者負担額減額のみを変更対象とします。<br/> {@link DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link HomonKaigoRiyoshaFutangakuGengaku}
     */
    @Override
    public HomonKaigoRiyoshaFutangakuGengaku modifiedModel() {
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new HomonKaigoRiyoshaFutangakuGengaku(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 訪問介護利用者負担額減額のみを変更対象とします。
     *
     * @return 変更対象処理実施後の{@link HomonKaigoRiyoshaFutangakuGengaku}
     */
    public HomonKaigoRiyoshaFutangakuGengaku updateModel() {
        DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity modifiedEntity = entity.clone();
        modifiedEntity.setState(EntityDataState.Modified);
        return new HomonKaigoRiyoshaFutangakuGengaku(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 訪問介護利用者負担額減額が保持する精神手帳任意項目情報に対して、指定の識別子に該当する減免減額申請情報を返します。
     *
     * @param id 減免減額申請情報の識別子
     * @return 減免減額申請情報
     * @throws IllegalStateException 指定の識別子に該当する減免減額申請情報がない場合
     */
    public GemmenGengakuShinsei getSeishinTechoNini(GemmenGengakuShinseiIdentifier id) {
        if (gemmenGengakuShinsei.contains(id)) {
            return gemmenGengakuShinsei.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 訪問介護利用者負担額減額が保持する精神手帳任意項目情報をリストで返します。
     *
     * @return 精神手帳任意項目情報リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());

    }

    /**
     * {@link HomonKaigoRiyoshaFutangakuGengaku}のシリアライズ形式を提供します。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengaku}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmenGengakuShinsei);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity;
        private final HomonKaigoRiyoshaFutangakuGengakuIdentifier id;
        private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

        private _SerializationProxy(
                DbT4016HomonKaigoRiyoshaFutangakuGengakuEntity entity,
                HomonKaigoRiyoshaFutangakuGengakuIdentifier id,
                Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
        ) {
            this.entity = entity;
            this.id = id;
            this.gemmenGengakuShinsei = gemmenGengakuShinsei;
        }

        private Object readResolve() {
            return new HomonKaigoRiyoshaFutangakuGengaku(this.entity, this.id, this.gemmenGengakuShinsei);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.entity);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.gemmenGengakuShinsei);
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
        final HomonKaigoRiyoshaFutangakuGengaku other = (HomonKaigoRiyoshaFutangakuGengaku) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.gemmenGengakuShinsei, other.gemmenGengakuShinsei)) {
            return false;
        }
        return true;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link HomonKaigoRiyoshaFutangakuGengakuBuilder#build()}を使用してください。
     *
     * @return {@link HomonKaigoRiyoshaFutangakuGengakuBuilder}
     */
    public HomonKaigoRiyoshaFutangakuGengakuBuilder createBuilderForEdit() {
        return new HomonKaigoRiyoshaFutangakuGengakuBuilder(entity, id, gemmenGengakuShinsei);
    }
}
