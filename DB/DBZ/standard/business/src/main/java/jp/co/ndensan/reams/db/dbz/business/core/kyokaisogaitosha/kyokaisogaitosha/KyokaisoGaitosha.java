/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisogaitosha;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisohokenryodankai.KyokaisoHokenryoDankai;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisohokenryodankai.KyokaisoHokenryoDankaiIdentifier;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisosochishinsei.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbz.business.core.kyokaisogaitosha.kyokaisosochishinsei.KyokaisoSochiShinseiIdentifier;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1007KyokaisoHokenryoDankaiEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.kyokaisogaitosha.KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 境界層該当者を管理するクラスです。
 *
 * @reamsid_L DBA-9999-013 huangh
 */
public class KyokaisoGaitosha extends ParentModelBase<KyokaisoGaitoshaIdentifier, DbT1006KyokaisoGaitoshaEntity, KyokaisoGaitosha>
        implements Serializable {

    private final DbT1006KyokaisoGaitoshaEntity entity;
    private final KyokaisoGaitoshaIdentifier id;
    private final Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> kyokaisoSochiShinsei;
    private final Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> kyokaisoHokenryoDankai;

    /**
     * コンストラクタです。<br/>
     * 境界層該当者の新規作成時に使用します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @param リンク番号 リンク番号
     */
    public KyokaisoGaitosha(HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal リンク番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(リンク番号, UrSystemErrorMessages.値がnull.getReplacedMessage("リンク番号"));
        this.entity = new DbT1006KyokaisoGaitoshaEntity();
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号.intValue());
        this.entity.setLinkNo(リンク番号.intValue());
        this.id = new KyokaisoGaitoshaIdentifier(
                被保険者番号,
                履歴番号,
                リンク番号
        );
        this.kyokaisoSochiShinsei = Models.create(new ArrayList<KyokaisoSochiShinsei>());
        this.kyokaisoHokenryoDankai = Models.create(new ArrayList<KyokaisoHokenryoDankai>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT1006KyokaisoGaitoshaEntity}より{@link KyokaisoGaitosha}を生成します。
     *
     * @param entity DBより取得した{@link DbT1006KyokaisoGaitoshaEntity}
     */
    public KyokaisoGaitosha(KyokaisoGaitoshaEntity entity) {
        this.entity = requireNonNull(entity.get境界層該当者Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者"));
        this.id = new KyokaisoGaitoshaIdentifier(
                entity.get境界層該当者Entity().getHihokenshaNo(),
                new Decimal(entity.get境界層該当者Entity().getRirekiNo()),
                new Decimal(entity.get境界層該当者Entity().getLinkNo()));
        List<KyokaisoHokenryoDankai> kyokaisoHokenryoDankaiList = new ArrayList<>();
        for (DbT1007KyokaisoHokenryoDankaiEntity niniEntity : entity.get境界層保険料段階Entity()) {
            kyokaisoHokenryoDankaiList.add(new KyokaisoHokenryoDankai(niniEntity));
        }

        this.kyokaisoHokenryoDankai = Models.create(kyokaisoHokenryoDankaiList);

        List<KyokaisoSochiShinsei> kyokaisoSochiShinseiList = new ArrayList<>();
        kyokaisoSochiShinseiList.add(new KyokaisoSochiShinsei(entity.get境界層措置申請Entity()));
        this.kyokaisoSochiShinsei = Models.create(kyokaisoSochiShinseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT1006KyokaisoGaitoshaEntity}
     * @param id {@link KyokaisoGaitoshaIdentifier}
     */
    KyokaisoGaitosha(
            DbT1006KyokaisoGaitoshaEntity entity,
            KyokaisoGaitoshaIdentifier id,
            Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> kyokaisoSochiShinsei,
            Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> kyokaisoHokenryoDankai) {

        this.entity = entity;
        this.id = id;
        this.kyokaisoSochiShinsei = kyokaisoSochiShinsei;
        this.kyokaisoHokenryoDankai = kyokaisoHokenryoDankai;

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
     * リンク番号を返します。
     *
     * @return リンク番号
     */
    public int getリンク番号() {
        return entity.getLinkNo();
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
     * 境界層措置決定年月日を返します。
     *
     * @return 境界層措置決定年月日
     */
    public FlexibleDate get境界層措置決定年月日() {
        return entity.getKyokaisoSochiKetteiYMD();
    }

    /**
     * 給付額減額記載解除フラグを返します。
     *
     * @return 給付額減額記載解除フラグ
     */
    public RString get給付額減額記載解除フラグ() {
        return entity.getKyuufugakuGengakuKisaiKiajoFlag();
    }

    /**
     * 標準負担額額該当フラグを返します。
     *
     * @return 標準負担額額該当フラグ
     */
    public RString get標準負担額額該当フラグ() {
        return entity.getHyojunFutanGengakuGaitoFlag();
    }

    /**
     * 標準負担軽減後負担額を返します。
     *
     * @return 標準負担軽減後負担額
     */
    public Decimal get標準負担軽減後負担額() {
        return entity.getHyojunFutanKeigengoFutangaku();
    }

    /**
     * 居住費等負担額減額該当フラグを返します。
     *
     * @return 居住費等負担額減額該当フラグ
     */
    public RString get居住費等負担額減額該当フラグ() {
        return entity.getKyojuhinadoFutangakugengakuGaitoFlag();
    }

    /**
     * 居住費軽減後居室種類コードを返します。
     *
     * @return 居住費軽減後居室種類コード
     */
    public RString get居住費軽減後居室種類コード() {
        return entity.getKyojuhiKeigengoKyoshitsuShuruiCode();
    }

    /**
     * 居住費軽減後負担額を返します。
     *
     * @return 居住費軽減後負担額
     */
    public Decimal get居住費軽減後負担額() {
        return entity.getKyojuhiKeigengoHutangaku();
    }

    /**
     * 食費負担額減額該当フラグを返します。
     *
     * @return 食費負担額減額該当フラグ
     */
    public RString get食費負担額減額該当フラグ() {
        return entity.getShokuhiKeigengoHutangakuGaitoFlag();
    }

    /**
     * 食費軽減後負担額を返します。
     *
     * @return 食費軽減後負担額
     */
    public Decimal get食費軽減後負担額() {
        return entity.getShokuhiKeigengoHutangaku();
    }

    /**
     * 高額ｻｰﾋﾞｽ費上限額減額該当フラグを返します。
     *
     * @return 高額ｻｰﾋﾞｽ費上限額減額該当フラグ
     */
    public RString get高額ｻｰﾋﾞｽ費上限額減額該当フラグ() {
        return entity.getKogakuServicehiJogengakuGengakuGaitoFlag();
    }

    /**
     * 高額ｻｰﾋﾞｽ費減額後上限額を返します。
     *
     * @return 高額ｻｰﾋﾞｽ費減額後上限額
     */
    public Decimal get高額ｻｰﾋﾞｽ費減額後上限額() {
        return entity.getKogakuServicehiJogengakuGengakugoJogengaku();
    }

    /**
     * 保険料納付減額フラグを返します。
     *
     * @return 保険料納付減額フラグ
     */
    public RString get保険料納付減額フラグ() {
        return entity.getHokenryoNofuGengakuFlag();
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
     * {@link DbT1006KyokaisoGaitoshaEntity}のクローンを返します。
     *
     * @return {@link DbT1006KyokaisoGaitoshaEntity}のクローン
     */
    @Override
    public DbT1006KyokaisoGaitoshaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 境界層該当者の識別子{@link KyokaisoGaitoshaIdentifier}を返します。
     *
     * @return 境界層該当者の識別子{@link KyokaisoGaitoshaIdentifier}
     */
    @Override
    public KyokaisoGaitoshaIdentifier identifier() {
        return this.id;
    }

    /**
     * 境界層該当者配下の要素を削除対象とします。<br/> {@link DbT1006KyokaisoGaitoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 境界層該当者配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link KyokaisoGaitosha}を返します。
     *
     * @return 削除対象処理実施後の{@link KyokaisoGaitosha}
     * @throws IllegalStateException DbT1006KyokaisoGaitoshaEntityのデータ状態が変更の場合
     */
    @Override
    public KyokaisoGaitosha deleted() {
        DbT1006KyokaisoGaitoshaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new KyokaisoGaitosha(
                deletedEntity, id, kyokaisoSochiShinsei.deleted(), kyokaisoHokenryoDankai.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || kyokaisoSochiShinsei.hasAnyChanged() || kyokaisoHokenryoDankai.hasAnyChanged();
    }

    /**
     * 境界層該当者のみを変更対象とします。<br/> {@link DbT1006KyokaisoGaitoshaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link KyokaisoGaitosha}
     */
    @Override
    public KyokaisoGaitosha modifiedModel() {
        DbT1006KyokaisoGaitoshaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new KyokaisoGaitosha(
                modifiedEntity, id, kyokaisoSochiShinsei, kyokaisoHokenryoDankai);
    }

    /**
     * 境界層該当者が保持する境界層措置申請情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 境界層措置申請情報の識別子
     * @return 境界層措置申請情報
     * @throws IllegalStateException 指定の識別子に該当する境界層措置申請情報がない場合
     */
    public KyokaisoSochiShinsei getKyokaisoSochiShinsei(KyokaisoSochiShinseiIdentifier id) {
        if (kyokaisoSochiShinsei.contains(id)) {
            return kyokaisoSochiShinsei.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 境界層該当者が保持する境界層措置申請情報をリストで返します。
     *
     * @return 境界層措置申請情報リスト
     */
    public List<KyokaisoSochiShinsei> getKyokaisoSochiShinseiList() {
        return new ArrayList<>(kyokaisoSochiShinsei.values());

    }

    /**
     * 境界層該当者が保持する境界層保険料段階に対して、指定の識別子に該当する届出者情報を返します。
     *
     * @param id 境界層保険料段階の識別子
     * @return 境界層保険料段階
     * @throws IllegalStateException 指定の識別子に該当する境界層保険料段階がない場合
     */
    public KyokaisoHokenryoDankai getKyokaisoHokenryoDankai(KyokaisoHokenryoDankaiIdentifier id) {
        if (kyokaisoHokenryoDankai.contains(id)) {
            return kyokaisoHokenryoDankai.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 境界層該当者が保持する届出者情報をリストで返します。
     *
     * @return 届出者情報リスト
     */
    public List<KyokaisoHokenryoDankai> getKyokaisoHokenryoDankaiList() {
        return new ArrayList<>(kyokaisoHokenryoDankai.values());
    }

    /**
     * {@link KyokaisoGaitosha}のシリアライズ形式を提供します。
     *
     * @return {@link KyokaisoGaitosha}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, kyokaisoSochiShinsei, kyokaisoHokenryoDankai);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT1006KyokaisoGaitoshaEntity entity;
        private final KyokaisoGaitoshaIdentifier id;
        private final Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> kyokaisoSochiShinsei;
        private final Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> kyokaisoHokenryoDankai;

        private _SerializationProxy(
                DbT1006KyokaisoGaitoshaEntity entity,
                KyokaisoGaitoshaIdentifier id,
                Models<KyokaisoSochiShinseiIdentifier, KyokaisoSochiShinsei> kyokaisoSochiShinsei,
                Models<KyokaisoHokenryoDankaiIdentifier, KyokaisoHokenryoDankai> kyokaisoHokenryoDankai
        ) {
            this.entity = entity;
            this.id = id;
            this.kyokaisoSochiShinsei = kyokaisoSochiShinsei;
            this.kyokaisoHokenryoDankai = kyokaisoHokenryoDankai;
        }

        private Object readResolve() {
            return new KyokaisoGaitosha(this.entity, this.id, this.kyokaisoSochiShinsei, this.kyokaisoHokenryoDankai);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link KyokaisoGaitoshaBuilder#build()}を使用してください。
     *
     * @return {@link KyokaisoGaitoshaBuilder}
     */
    public KyokaisoGaitoshaBuilder createBuilderForEdit() {
        return new KyokaisoGaitoshaBuilder(entity, id, kyokaisoSochiShinsei, kyokaisoHokenryoDankai);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.entity);
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.kyokaisoSochiShinsei);
        hash = 79 * hash + Objects.hashCode(this.kyokaisoHokenryoDankai);
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
        final KyokaisoGaitosha other = (KyokaisoGaitosha) obj;
        if (!Objects.equals(this.entity, other.entity)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.kyokaisoSochiShinsei, other.kyokaisoSochiShinsei)) {
            return false;
        }
        if (!Objects.equals(this.kyokaisoHokenryoDankai, other.kyokaisoHokenryoDankai)) {
            return false;
        }
        return true;
    }
}
