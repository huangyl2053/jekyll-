/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4018KaigoHokenFutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 介護保険負担限度額認定を管理するクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class FutanGendogakuNintei
        extends ParentModelBase<FutanGendogakuNinteiIdentifier, DbT4018KaigoHokenFutanGendogakuNinteiEntity, FutanGendogakuNintei>
        implements Serializable {

    private final DbT4018KaigoHokenFutanGendogakuNinteiEntity entity;
    private final FutanGendogakuNinteiIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 介護保険負担限度額認定の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public FutanGendogakuNintei(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4018KaigoHokenFutanGendogakuNinteiEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new FutanGendogakuNinteiIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link FutanGendogakuNinteiEntity}より{@link FutanGendogakuNintei}を生成します。
     *
     * @param entity DBより取得した{@link FutanGendogakuNinteiEntity}
     */
    public FutanGendogakuNintei(FutanGendogakuNinteiEntity entity) {
        this.entity = requireNonNull(entity.get介護保険負担限度額認定Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険負担限度額認定"));
        this.id = new FutanGendogakuNinteiIdentifier(
                entity.get介護保険負担限度額認定Entity().getShoKisaiHokenshaNo(),
                entity.get介護保険負担限度額認定Entity().getHihokenshaNo(),
                entity.get介護保険負担限度額認定Entity().getRirekiNo());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity shinseiEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(shinseiEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}
     * @param id {@link FutanGendogakuNinteiIdentifier}
     */
    FutanGendogakuNintei(
            DbT4018KaigoHokenFutanGendogakuNinteiEntity entity,
            FutanGendogakuNinteiIdentifier id,
            Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
    ) {
        this.entity = entity;
        this.id = id;
        this.gemmenGengakuShinsei = gemmenGengakuShinsei;
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
     * 履歴番号を返します。
     *
     * @return 履歴番号
     */
    public int get履歴番号() {
        return entity.getRirekiNo();
    }
    
    /**
     * 遺族年金受給申告を返します。
     *
     * @return 遺族年金受給申告
     */
    public boolean get遺族年金受給申告() {
        return entity.getIzokuNenkinJukyuFlag();
    }
 
    /**
     * 障害年金受給申告を返します。
     *
     * @return 障害年金受給申告
     */
    public boolean get障害年金受給申告() {
        return entity.getShogaiNenkinJukyuFlag();
    }

    /**
     * 旧措置者区分を返します。
     *
     * @return 旧措置者区分
     */
    public RString get旧措置者区分() {
        return entity.getKyusochishaKubun();
    }

    /**
     * 申請理由区分を返します。
     *
     * @return 申請理由区分
     */
    public RString get申請理由区分() {
        return entity.getShinseiRiyuKubun();
    }

    /**
     * 利用者負担段階を返します。
     *
     * @return 利用者負担段階
     */
    public RString get利用者負担段階() {
        return entity.getRiyoshaFutanDankai();
    }

    /**
     * 境界層該当者区分を返します。
     *
     * @return 境界層該当者区分
     */
    public boolean is境界層該当者区分() {
        return entity.getKyokaisoGaitoshaKubun();
    }

    /**
     * 激変緩和措置対象者区分を返します。
     *
     * @return 激変緩和措置対象者区分
     */
    public boolean is激変緩和措置対象者区分() {
        return entity.getGekihenKanwaSochiTaishoshaKubun();
    }

    /**
     * 居室種別を返します。
     *
     * @return 居室種別
     */
    public RString get居室種別() {
        return entity.getKyoshitsuShubetsu();
    }

    /**
     * 食費負担限度額を返します。
     *
     * @return 食費負担限度額
     */
    public Decimal get食費負担限度額() {
        return entity.getShokuhiFutanGendogaku();
    }

    /**
     * ユニット型個室を返します。
     *
     * @return ユニット型個室
     */
    public Decimal getユニット型個室() {
        return entity.getUnitTypeKoshitsu();
    }

    /**
     * ユニット型準個室を返します。
     *
     * @return ユニット型準個室
     */
    public Decimal getユニット型準個室() {
        return entity.getUnitTypeJunKoshitsu();
    }

    /**
     * 従来型個室（特養等）を返します。
     *
     * @return 従来型個室（特養等）
     */
    public Decimal get従来型個室_特養等() {
        return entity.getJuraiTypeKoshitsu_Tokuyo();
    }

    /**
     * 従来型個室（老健・療養等）を返します。
     *
     * @return 従来型個室（老健・療養等）
     */
    public Decimal get従来型個室_老健_療養等() {
        return entity.getJuraiTypeKoshitsu_Roken_Ryoyo();
    }

    /**
     * 多床室を返します。
     *
     * @return 多床室
     */
    public Decimal get多床室() {
        return entity.getTashoshitsu();
    }

    /**
     * 配偶者の有無を返します。
     *
     * @return 配偶者の有無
     */
    public boolean is配偶者の有無() {
        return entity.getHaigushaUmuFlag();
    }

    /**
     * 配偶者氏名を返します。
     *
     * @return 配偶者氏名
     */
    public AtenaMeisho get配偶者氏名() {
        return entity.getHaigushaShimei();
    }

    /**
     * 配偶者氏名カナを返します。
     *
     * @return 配偶者氏名カナ
     */
    public AtenaKanaMeisho get配偶者氏名カナ() {
        return entity.getHaigushaShimeiKana();
    }

    /**
     * 配偶者生年月日を返します。
     *
     * @return 配偶者生年月日
     */
    public FlexibleDate get配偶者生年月日() {
        return entity.getHaigushaSeinenGappiYMD();
    }

    /**
     * 配偶者住所を返します。
     *
     * @return 配偶者住所
     */
    public AtenaJusho get配偶者住所() {
        return entity.getHaigushaJusho();
    }

    /**
     * 配偶者連絡先を返します。
     *
     * @return 配偶者連絡先
     */
    public RString get配偶者連絡先() {
        return entity.getHaigushaRenrakusaki();
    }

    /**
     * 配偶者住所２を返します。
     *
     * @return 配偶者住所２
     */
    public AtenaJusho get配偶者住所２() {
        return entity.getHaigushaJusho2();
    }

    /**
     * 配偶者課税区分を返します。
     *
     * @return 配偶者課税区分
     */
    public RString get配偶者課税区分() {
        return entity.getHaigushaKazeiKubun();
    }

    /**
     * 配偶者識別コードを返します。
     *
     * @return 配偶者識別コード
     */
    public ShikibetsuCode get配偶者識別コード() {
        return entity.getHaigushaShikibetsuCd();
    }

    /**
     * 預貯金申告区分を返します。
     *
     * @return 預貯金申告区分
     */
    public RString get預貯金申告区分() {
        return entity.getYochokinShinkokuKubun();
    }

    /**
     * 預貯金額を返します。
     *
     * @return 預貯金額
     */
    public Decimal get預貯金額() {
        return entity.getYochokinGaku();
    }

    /**
     * 有価証券評価概算額を返します。
     *
     * @return 有価証券評価概算額
     */
    public Decimal get有価証券評価概算額() {
        return entity.getYukashoukenGaisangaku();
    }

    /**
     * その他金額を返します。
     *
     * @return その他金額
     */
    public Decimal getその他金額() {
        return entity.getSonotaKingaku();
    }

    /**
     * 一括認定処理日時を返します。
     *
     * @return 一括認定処理日時
     */
    public YMDHMS get一括認定処理日時() {
        return entity.getNinteiBatchExecutedTimestamp();
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
     * 遺族年金受給フラグを返します。
     *
     * @return 遺族年金受給フラグ
     */
    public boolean is遺族年金受給フラグ() {
        return entity.getIzokuNenkinJukyuFlag();
    }

    /**
     * 障害年金受給フラグを返します。
     *
     * @return 障害年金受給フラグ
     */
    public boolean is障害年金受給フラグ() {
        return entity.getShogaiNenkinJukyuFlag();
    }

    /**
     * {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}のクローンを返します。
     *
     * @return {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}のクローン
     */
    @Override
    public DbT4018KaigoHokenFutanGendogakuNinteiEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 介護保険負担限度額認定の識別子{@link FutanGendogakuNinteiIdentifier}を返します。
     *
     * @return 介護保険負担限度額認定の識別子{@link FutanGendogakuNinteiIdentifier}
     */
    @Override
    public FutanGendogakuNinteiIdentifier identifier() {
        return this.id;
    }

    /**
     * 介護保険負担限度額認定が保持する減免減額申請に対して、指定の識別子に該当する減免減額申請を返します。
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
     * 介護保険負担限度額認定が保持する減免減額申請をリストで返します。
     *
     * @return 減免減額申請リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());
    }

    /**
     * 介護保険負担限度額認定のみを変更対象とします。<br/> {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link FutanGendogakuNintei}
     */
    @Override
    public FutanGendogakuNintei modifiedModel() {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new FutanGendogakuNintei(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 保持する介護保険負担限度額認定を削除対象とします。<br/> {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FutanGendogakuNintei}
     */
    @Override
    public FutanGendogakuNintei deleted() {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FutanGendogakuNintei(deletedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 保持する介護保険負担限度額認定を削除対象とします。<br/> {@link DbT4018KaigoHokenFutanGendogakuNinteiEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link FutanGendogakuNintei}
     */
    public FutanGendogakuNintei added() {
        DbT4018KaigoHokenFutanGendogakuNinteiEntity addedEntity = this.toEntity();
        if (addedEntity.getState() != EntityDataState.Deleted) {
            addedEntity.setState(EntityDataState.Added);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new FutanGendogakuNintei(addedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * {@link FutanGendogakuNintei}のシリアライズ形式を提供します。
     *
     * @return {@link FutanGendogakuNintei}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmenGengakuShinsei);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4742535446808398293L;
        private final DbT4018KaigoHokenFutanGendogakuNinteiEntity entity;
        private final FutanGendogakuNinteiIdentifier id;
        private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

        private _SerializationProxy(DbT4018KaigoHokenFutanGendogakuNinteiEntity entity, FutanGendogakuNinteiIdentifier id,
                Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei) {
            this.entity = entity;
            this.id = id;
            this.gemmenGengakuShinsei = gemmenGengakuShinsei;
        }

        private Object readResolve() {
            return new FutanGendogakuNintei(this.entity, this.id, gemmenGengakuShinsei);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public FutanGendogakuNinteiBuilder createBuilderForEdit() {
        return new FutanGendogakuNinteiBuilder(entity, id, gemmenGengakuShinsei);
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
        final FutanGendogakuNintei other = (FutanGendogakuNintei) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
