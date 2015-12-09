/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItemIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（基本調査素点）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScore extends ModelBase<NinteichosahyoKihonChosaScoreIdentifier, DbT5204NinteichosahyoKihonChosaScoreEntity, NinteichosahyoKihonChosaScore> implements Serializable {

    private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
    private final NinteichosahyoKihonChosaScoreIdentifier id;
    private final Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（基本調査素点）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     */
    public NinteichosahyoKihonChosaScore(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        this.entity = new DbT5204NinteichosahyoKihonChosaScoreEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.id = new NinteichosahyoKihonChosaScoreIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号
        );
        this.ninteichosahyoKihonChosaScoreItem = Models.create(new ArrayList<NinteichosahyoKihonChosaScoreItem>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5204NinteichosahyoKihonChosaScoreEntity}より{@link NinteichosahyoKihonChosaScore}を生成します。
     *
     * @param entity DBより取得した{@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     */
    public NinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreEntity entity) {
        this.entity = requireNonNull(entity.get認定調査票_基本調査素点Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点）"));
        this.id = new NinteichosahyoKihonChosaScoreIdentifier(
                entity.get認定調査票_基本調査素点Entity().getShinseishoKanriNo(),
                entity.get認定調査票_基本調査素点Entity().getNinteichosaRirekiNo());
        List<NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItemList = new ArrayList<>();
        for (DbT5212NinteichosahyoKihonChosaScoreItemEntity niniEntity : entity.get認定調査票_基本調査素点項目Entity()) {
            ninteichosahyoKihonChosaScoreItemList.add(new NinteichosahyoKihonChosaScoreItem(niniEntity));
        }
        this.ninteichosahyoKihonChosaScoreItem = Models.create(ninteichosahyoKihonChosaScoreItemList);

    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5204NinteichosahyoKihonChosaScoreEntity}
     * @param id {@link NinteichosahyoKihonChosaScoreIdentifier}
     */
    NinteichosahyoKihonChosaScore(
            DbT5204NinteichosahyoKihonChosaScoreEntity entity,
            NinteichosahyoKihonChosaScoreIdentifier id,
            Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem
    ) {
        this.entity = entity;
        this.id = id;
        this.ninteichosahyoKihonChosaScoreItem = ninteichosahyoKihonChosaScoreItem;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 要介護認定調査履歴番号を返します。
     *
     * @return 要介護認定調査履歴番号
     */
    public int get要介護認定調査履歴番号() {
        return entity.getNinteichosaRirekiNo();
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public Code get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 素点合計　第１郡を返します。
     *
     * @return 素点合計_第１郡
     */
    public int get素点合計_第１郡() {
        return entity.getTokutenTotal1gun();
    }

    /**
     * 素点合計　第２郡を返します。
     *
     * @return 素点合計_第２郡
     */
    public int get素点合計_第２郡() {
        return entity.getTokutenTotal2gun();
    }

    /**
     * 素点合計　第３郡を返します。
     *
     * @return 素点合計_第３郡
     */
    public int get素点合計_第３郡() {
        return entity.getTokutenTotal3gun();
    }

    /**
     * 素点合計　第４郡を返します。
     *
     * @return 素点合計_第４郡
     */
    public int get素点合計_第４郡() {
        return entity.getTokutenTotal4gun();
    }

    /**
     * 素点合計　第５郡を返します。
     *
     * @return 素点合計_第５郡
     */
    public int get素点合計_第５郡() {
        return entity.getTokutenTotal5gun();
    }

    /**
     * 素点合計　第６郡を返します。
     *
     * @return 素点合計_第６郡
     */
    public int get素点合計_第６郡() {
        return entity.getTokutenTotal6gun();
    }

    /**
     * 素点合計　第７郡を返します。
     *
     * @return 素点合計_第７郡
     */
    public int get素点合計_第７郡() {
        return entity.getTokutenTotal7gun();
    }

    /**
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}のクローンを返します。
     *
     * @return {@link DbT5204NinteichosahyoKihonChosaScoreEntity}のクローン
     */
    @Override
    public DbT5204NinteichosahyoKihonChosaScoreEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（基本調査素点）の識別子{@link NinteichosahyoKihonChosaScoreIdentifier}を返します。
     *
     * @return 認定調査票（基本調査素点）の識別子{@link NinteichosahyoKihonChosaScoreIdentifier}
     */
    @Override
    public NinteichosahyoKihonChosaScoreIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（基本調査素点）配下の要素を削除対象とします。<br/>
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 認定調査票（基本調査素点）配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link NinteichosahyoKihonChosaScore}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKihonChosaScore}
     * @throws IllegalStateException
     * DbT5204NinteichosahyoKihonChosaScoreEntityのデータ状態が変更の場合
     */
    @Override
    public NinteichosahyoKihonChosaScore deleted() {
        DbT5204NinteichosahyoKihonChosaScoreEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKihonChosaScore(
                deletedEntity, id, ninteichosahyoKihonChosaScoreItem.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || ninteichosahyoKihonChosaScoreItem.hasAnyChanged();
    }

    /**
     * 認定調査票（基本調査素点）のみを変更対象とします。<br/>
     * {@link DbT5204NinteichosahyoKihonChosaScoreEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKihonChosaScore}
     */
    public NinteichosahyoKihonChosaScore modifiedModel() {
        DbT5204NinteichosahyoKihonChosaScoreEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKihonChosaScore(
                modifiedEntity, id, ninteichosahyoKihonChosaScoreItem);
    }

    /**
     * 認定調査票（基本調査素点）が保持する精認定調査票（基本調査素点項目）項目情報に対して、指定の識別子に該当する認定調査票（基本調査素点項目）項目情報を返します。
     *
     * @param id 認定調査票（基本調査素点項目）の識別子
     * @return 認定調査票（基本調査素点項目）項目情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（基本調査素点項目）項目情報がない場合
     */
    public NinteichosahyoKihonChosaScoreItem getNinteichosahyoKihonChosaScoreItem(NinteichosahyoKihonChosaScoreItemIdentifier id) {
        if (ninteichosahyoKihonChosaScoreItem.contains(id)) {
            return ninteichosahyoKihonChosaScoreItem.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（基本調査素点）が保持する認定調査票（基本調査素点項目）項目情報をリストで返します。
     *
     * @return 認定調査票（基本調査素点項目）項目情報リスト
     */
    public List<NinteichosahyoKihonChosaScoreItem> getNinteichosahyoKihonChosaScoreItemList() {
        return new ArrayList<>(ninteichosahyoKihonChosaScoreItem.values());

    }

    /**
     * {@link NinteichosahyoKihonChosaScore}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKihonChosaScore}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, ninteichosahyoKihonChosaScoreItem);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5204NinteichosahyoKihonChosaScoreEntity entity;
        private final NinteichosahyoKihonChosaScoreIdentifier id;
        private final Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem;

        private _SerializationProxy(
                DbT5204NinteichosahyoKihonChosaScoreEntity entity,
                NinteichosahyoKihonChosaScoreIdentifier id,
                Models<NinteichosahyoKihonChosaScoreItemIdentifier, NinteichosahyoKihonChosaScoreItem> ninteichosahyoKihonChosaScoreItem
        ) {
            this.entity = entity;
            this.id = id;
            this.ninteichosahyoKihonChosaScoreItem = ninteichosahyoKihonChosaScoreItem;
        }

        private Object readResolve() {
            return new NinteichosahyoKihonChosaScore(this.entity, this.id, this.ninteichosahyoKihonChosaScoreItem);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosahyoKihonChosaScoreBuilder#build()}を使用してください。
     *
     * @return {@link NinteichosahyoKihonChosaScoreBuilder}
     */
    public NinteichosahyoKihonChosaScoreBuilder createBuilderForEdit() {
        return new NinteichosahyoKihonChosaScoreBuilder(entity, id, ninteichosahyoKihonChosaScoreItem);
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
        final NinteichosahyoKihonChosaScore other = (NinteichosahyoKihonChosaScore) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
