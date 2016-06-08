/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinsei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shinsei.GemmenGengakuShinseiIdentifier;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmenEntity;
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
 * 特別地域加算減免を管理するクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class TokubetsuchiikiKasanGemmen extends
        ParentModelBase<TokubetsuchiikiKasanGemmenIdentifier, DbT4020TokubetsuchiikiKasanGemmenEntity, TokubetsuchiikiKasanGemmen>
        implements Serializable {

    private final DbT4020TokubetsuchiikiKasanGemmenEntity entity;
    private final TokubetsuchiikiKasanGemmenIdentifier id;
    private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

    /**
     * コンストラクタです。<br/>
     * 特別地域加算減免の新規作成時に使用します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     */
    public TokubetsuchiikiKasanGemmen(ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        this.entity = new DbT4020TokubetsuchiikiKasanGemmenEntity();
        this.entity.setShoKisaiHokenshaNo(証記載保険者番号);
        this.entity.setHihokenshaNo(被保険者番号);
        this.entity.setRirekiNo(履歴番号);
        this.id = new TokubetsuchiikiKasanGemmenIdentifier(
                証記載保険者番号,
                被保険者番号,
                履歴番号
        );
        this.gemmenGengakuShinsei = Models.create(new ArrayList<GemmenGengakuShinsei>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4020TokubetsuchiikiKasanGemmenEntity}より{@link TokubetsuchiikiKasanGemmen}を生成します。
     *
     * @param entity DBより取得した{@link DbT4020TokubetsuchiikiKasanGemmenEntity}
     */
    public TokubetsuchiikiKasanGemmen(TokubetsuchiikiKasanGemmenEntity entity) {
        this.entity = requireNonNull(entity.get特別地域加算減免Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算減免"));
        this.id = new TokubetsuchiikiKasanGemmenIdentifier(
                entity.get特別地域加算減免Entity().getShoKisaiHokenshaNo(),
                entity.get特別地域加算減免Entity().getHihokenshaNo(),
                entity.get特別地域加算減免Entity().getRirekiNo());
        List<GemmenGengakuShinsei> gemmenGengakuShinseiList = new ArrayList<>();
        for (DbT4010GemmenGengakuShinseiEntity niniEntity : entity.get減免減額申請Entity()) {
            gemmenGengakuShinseiList.add(new GemmenGengakuShinsei(niniEntity));
        }
        this.gemmenGengakuShinsei = Models.create(gemmenGengakuShinseiList);

    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4020TokubetsuchiikiKasanGemmenEntity}
     * @param id {@link TokubetsuchiikiKasanGemmenIdentifier}
     */
    TokubetsuchiikiKasanGemmen(
            DbT4020TokubetsuchiikiKasanGemmenEntity entity,
            TokubetsuchiikiKasanGemmenIdentifier id,
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
     * 減額率を返します。
     *
     * @return 減額率
     */
    public HokenKyufuRitsu get減額率() {
        return entity.getKeigenritsu();
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
     * {@link DbT4020TokubetsuchiikiKasanGemmenEntity}のクローンを返します。
     *
     * @return {@link DbT4020TokubetsuchiikiKasanGemmenEntity}のクローン
     */
    @Override
    public DbT4020TokubetsuchiikiKasanGemmenEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 特別地域加算減免の識別子{@link TokubetsuchiikiKasanGemmenIdentifier}を返します。
     *
     * @return 特別地域加算減免の識別子{@link TokubetsuchiikiKasanGemmenIdentifier}
     */
    @Override
    public TokubetsuchiikiKasanGemmenIdentifier identifier() {
        return this.id;
    }

    /**
     * 特別地域加算減免配下の要素を削除対象とします。<br/> {@link DbT4020TokubetsuchiikiKasanGemmenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 特別地域加算減免配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。 削除処理結果となる{@link TokubetsuchiikiKasanGemmen}を返します。
     *
     * @return 削除対象処理実施後の{@link TokubetsuchiikiKasanGemmen}
     * @throws IllegalStateException DbT4020TokubetsuchiikiKasanGemmenEntityのデータ状態が変更の場合
     */
    @Override
    public TokubetsuchiikiKasanGemmen deleted() {
        DbT4020TokubetsuchiikiKasanGemmenEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new TokubetsuchiikiKasanGemmen(
                deletedEntity, id, gemmenGengakuShinsei.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || gemmenGengakuShinsei.hasAnyChanged();
    }

    /**
     * 特別地域加算減免のみを変更対象とします。<br/> {@link DbT4020TokubetsuchiikiKasanGemmenEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link TokubetsuchiikiKasanGemmen}
     */
    @Override
    public TokubetsuchiikiKasanGemmen modifiedModel() {
        DbT4020TokubetsuchiikiKasanGemmenEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new TokubetsuchiikiKasanGemmen(
                modifiedEntity, id, gemmenGengakuShinsei);
    }

    /**
     * 特別地域加算減免が保持する減免減額申請情報に対して、指定の識別子に該当する精神手帳任意項目情報を返します。
     *
     * @param id 減免減額申請情報の識別子
     * @return 減免減額申請情報
     * @throws IllegalStateException 指定の識別子に該当する減免減額申請情報がない場合
     */
    public GemmenGengakuShinsei getGemmenGengakuShinsei(GemmenGengakuShinseiIdentifier id) {
        if (gemmenGengakuShinsei.contains(id)) {
            return gemmenGengakuShinsei.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 特別地域加算減免が保持する減免減額申請情報情報をリストで返します。
     *
     * @return 減免減額申請情報リスト
     */
    public List<GemmenGengakuShinsei> getGemmenGengakuShinseiList() {
        return new ArrayList<>(gemmenGengakuShinsei.values());

    }

    /**
     * {@link TokubetsuchiikiKasanGemmen}のシリアライズ形式を提供します。
     *
     * @return {@link TokubetsuchiikiKasanGemmen}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, gemmenGengakuShinsei);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 4377904594812838994L;
        private final DbT4020TokubetsuchiikiKasanGemmenEntity entity;
        private final TokubetsuchiikiKasanGemmenIdentifier id;
        private final Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei;

        private _SerializationProxy(
                DbT4020TokubetsuchiikiKasanGemmenEntity entity,
                TokubetsuchiikiKasanGemmenIdentifier id,
                Models<GemmenGengakuShinseiIdentifier, GemmenGengakuShinsei> gemmenGengakuShinsei
        ) {
            this.entity = entity;
            this.id = id;
            this.gemmenGengakuShinsei = gemmenGengakuShinsei;
        }

        private Object readResolve() {
            return new TokubetsuchiikiKasanGemmen(this.entity, this.id, this.gemmenGengakuShinsei);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.entity);
        hash = 29 * hash + Objects.hashCode(this.id);
        hash = 29 * hash + Objects.hashCode(this.gemmenGengakuShinsei);
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
        final TokubetsuchiikiKasanGemmen other = (TokubetsuchiikiKasanGemmen) obj;
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
     * 編集後のインスタンスを取得する場合は{@link TokubetsuchiikiKasanGemmenBuilder#build()}を使用してください。
     *
     * @return {@link TokubetsuchiikiKasanGemmenBuilder}
     */
    public TokubetsuchiikiKasanGemmenBuilder createBuilderForEdit() {
        return new TokubetsuchiikiKasanGemmenBuilder(entity, id, gemmenGengakuShinsei);
    }
}
