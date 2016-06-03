/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.shafukukeigen.ShafukuRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 社会福祉法人等利用者負担軽減を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class ShakaifukuRiyoshaFutanKeigen
        extends ParentModelBase<ShakaifukuRiyoshaFutanKeigenIdentifier,
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity,
            ShakaifukuRiyoshaFutanKeigen>
        implements Serializable {

    private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
    private final ShakaifukuRiyoshaFutanKeigenIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 社会福祉法人等利用者負担軽減の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public ShakaifukuRiyoshaFutanKeigen(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new ShakaifukuRiyoshaFutanKeigenIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShafukuRiyoshaFutanKeigenEntity}より{@link ShakaifukuRiyoshaFutanKeigen}を生成します。
     *
     * @param entity DBより取得した{@link ShafukuRiyoshaFutanKeigenEntity}
     */
    public ShakaifukuRiyoshaFutanKeigen(ShafukuRiyoshaFutanKeigenEntity entity) {
        this.entity = requireNonNull(entity.get社会福祉法人等利用者負担軽減Entity(),
                UrSystemErrorMessages.値がnull.getReplacedMessage("社会福祉法人等利用者負担軽減"));
        this.id = new ShakaifukuRiyoshaFutanKeigenIdentifier(
                entity.get社会福祉法人等利用者負担軽減Entity().getShoKisaiHokenshaNo(),
                entity.get社会福祉法人等利用者負担軽減Entity().getHihokenshaNo(),
                entity.get社会福祉法人等利用者負担軽減Entity().getRirekiNo());

        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity shinseiEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(shinseiEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}
     * @param id {@link ShakaifukuRiyoshaFutanKeigenIdentifier}
     * @param gemmenGengakuShinsei {@link GemmenGengakuShinsei}
     */
    ShakaifukuRiyoshaFutanKeigen(
            DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity,
            ShakaifukuRiyoshaFutanKeigenIdentifier id,
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
     * 申請事由を返します。
     *
     * @return 申請事由
     */
    public RString get申請事由() {
        return entity.getShinseiJiyu();
    }

    /**
     * 生活保護受給有無を返します。
     *
     * @return 生活保護受給有無
     */
    public boolean is生活保護受給有無() {
        return entity.getSeihoJukyuUmu();
    }

    /**
     * 老齢福祉年金受給有無を返します。
     *
     * @return 老齢福祉年金受給有無
     */
    public boolean is老齢福祉年金受給有無() {
        return entity.getRoreiFukushiNenkinJukyuUmu();
    }

    /**
     * 生保扶助見直し特例有無を返します。
     *
     * @return 生保扶助見直し特例有無
     */
    public boolean is生保扶助見直し特例有無() {
        return entity.getSeihoFujoMinaoshiTokureiUmu();
    }

    /**
     * 軽減率（分子）を返します。
     *
     * @return 軽減率（分子）
     */
    public Decimal get軽減率_分子() {
        return entity.getKeigenritsu_Bunshi();
    }

    /**
     * 軽減率（分母）を返します。
     *
     * @return 軽減率（分母）
     */
    public Decimal get軽減率_分母() {
        return entity.getKeigenritsu_Bumbo();
    }

    /**
     * 居宅サービス限定を返します。
     *
     * @return 居宅サービス限定
     */
    public boolean is居宅サービス限定() {
        return entity.getKyotakuServiceGentei();
    }

    /**
     * 居住費・食費のみを返します。
     *
     * @return 居住費・食費のみ
     */
    public boolean is居住費_食費のみ() {
        return entity.getKyojuhiShokuhiNomi();
    }

    /**
     * 旧措置者ユニット型個室のみを返します。
     *
     * @return 旧措置者ユニット型個室のみ
     */
    public boolean is旧措置者ユニット型個室のみ() {
        return entity.getKyusochishaUnitTypeKoshitsuNomi();
    }

    /**
     * 確認番号を返します。
     *
     * @return 確認番号
     */
    public RString get確認番号() {
        return entity.getKakuninNo();
    }

    /**
     * 減免区分を返します。
     *
     * @return 減免区分
     */
    public RString get減免区分() {
        return entity.getGemmenKubun();
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
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}のクローンを返します。
     *
     * @return {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}のクローン
     */
    @Override
    public DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 社会福祉法人等利用者負担軽減の識別子{@link ShakaifukuRiyoshaFutanKeigenIdentifier}を返します。
     *
     * @return 社会福祉法人等利用者負担軽減の識別子{@link ShakaifukuRiyoshaFutanKeigenIdentifier}
     */
    @Override
    public ShakaifukuRiyoshaFutanKeigenIdentifier identifier() {
        return this.id;
    }

    /**
     * 社会福祉法人等利用者負担軽減のみを変更対象とします。<br/> {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShakaifukuRiyoshaFutanKeigen}
     */
    @Override
    public ShakaifukuRiyoshaFutanKeigen modifiedModel() {
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShakaifukuRiyoshaFutanKeigen(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 保持する社会福祉法人等利用者負担軽減を削除対象とします。<br/>
     * {@link DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShakaifukuRiyoshaFutanKeigen}
     */
    @Override
    public ShakaifukuRiyoshaFutanKeigen deleted() {
        DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShakaifukuRiyoshaFutanKeigen(deletedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * {@link ShakaifukuRiyoshaFutanKeigen}のシリアライズ形式を提供します。
     *
     * @return {@link ShakaifukuRiyoshaFutanKeigen}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmenGengakuShinsei);

    }

    /**
     * 社会福祉法人等利用者負担軽減が保持する減免減額申請に対して、指定の識別子に該当する減免減額申請を返します。
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
     * 社会福祉法人等利用者負担軽減が保持する減免減額申請をリストで返します。
     *
     * @return 減免減額申請リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 9201814642119932401L;
        private final DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity;
        private final ShakaifukuRiyoshaFutanKeigenIdentifier id;
        private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

        private _SerializationProxy(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity,
                ShakaifukuRiyoshaFutanKeigenIdentifier id,
                Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei) {
            this.entity = entity;
            this.id = id;
            this.gemmenGengakuShinsei = gemmenGengakuShinsei;
        }

        private Object readResolve() {
            return new ShakaifukuRiyoshaFutanKeigen(this.entity, this.id, gemmenGengakuShinsei);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShakaifukuRiyoshaFutanKeigenBuilder createBuilderForEdit() {
        return new ShakaifukuRiyoshaFutanKeigenBuilder(entity, id, gemmenGengakuShinsei);
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
        final ShakaifukuRiyoshaFutanKeigen other = (ShakaifukuRiyoshaFutanKeigen) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
