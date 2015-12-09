/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyochosaitem.NinteichosahyoChosaItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScore;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosa.NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosahyo.ninteichosahyokihonchosascore.NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査票（基本調査）を管理するクラスです。
 */
public class NinteichosahyoKihonChosa extends ModelBase<NinteichosahyoKihonChosaIdentifier, DbT5203NinteichosahyoKihonChosaEntity, NinteichosahyoKihonChosa> implements Serializable {

    private final DbT5203NinteichosahyoKihonChosaEntity entity;
    private final NinteichosahyoKihonChosaIdentifier id;
    private final Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem;
    private final Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore;

    /**
     * コンストラクタです。<br/>
     * 認定調査票（基本調査）の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 要介護認定調査履歴番号 要介護認定調査履歴番号
     */
    public NinteichosahyoKihonChosa(ShinseishoKanriNo 申請書管理番号,
            int 要介護認定調査履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(要介護認定調査履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定調査履歴番号"));
        this.entity = new DbT5203NinteichosahyoKihonChosaEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaRirekiNo(要介護認定調査履歴番号);
        this.id = new NinteichosahyoKihonChosaIdentifier(
                申請書管理番号,
                要介護認定調査履歴番号
        );
        this.ninteichosahyoChosaItem = Models.create(new ArrayList<NinteichosahyoChosaItem>());
        this.ninteichosahyoKihonChosaScore = Models.create(new ArrayList<NinteichosahyoKihonChosaScore>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5203NinteichosahyoKihonChosaEntity}より{@link NinteichosahyoKihonChosa}を生成します。
     *
     * @param entity DBより取得した{@link DbT5203NinteichosahyoKihonChosaEntity}
     */
    public NinteichosahyoKihonChosa(NinteichosahyoKihonChosaEntity entity) {
        this.entity = requireNonNull(entity.get認定調査票_基本調査Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査）"));
        this.id = new NinteichosahyoKihonChosaIdentifier(
                entity.get認定調査票_基本調査Entity().getShinseishoKanriNo(),
                entity.get認定調査票_基本調査Entity().getNinteichosaRirekiNo());
        List<NinteichosahyoChosaItem> ninteichosahyoChosaItemList = new ArrayList<>();
        for (DbT5211NinteichosahyoChosaItemEntity niniEntity : entity.get認定調査票_基本調査_調査項目Entity()) {
            ninteichosahyoChosaItemList.add(new NinteichosahyoChosaItem(niniEntity));
        }
        this.ninteichosahyoChosaItem = Models.create(ninteichosahyoChosaItemList);

        List<NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScoreList = new ArrayList<>();
        for (NinteichosahyoKihonChosaScoreEntity todokedeshaEntity : entity.get認定調査票_基本調査素点Entity()) {
            ninteichosahyoKihonChosaScoreList.add(new NinteichosahyoKihonChosaScore(todokedeshaEntity));
        }
        this.ninteichosahyoKihonChosaScore = Models.create(ninteichosahyoKihonChosaScoreList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5203NinteichosahyoKihonChosaEntity}
     * @param id {@link NinteichosahyoKihonChosaIdentifier}
     */
    NinteichosahyoKihonChosa(
            DbT5203NinteichosahyoKihonChosaEntity entity,
            NinteichosahyoKihonChosaIdentifier id,
            Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem,
            Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore
    ) {
        this.entity = entity;
        this.id = id;
        this.ninteichosahyoChosaItem = ninteichosahyoChosaItem;
        this.ninteichosahyoKihonChosaScore = ninteichosahyoKihonChosaScore;
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
     * 認定調査・認知症高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査_認知症高齢者の日常生活自立度コード
     */
    public Code get認定調査_認知症高齢者の日常生活自立度コード() {
        return entity.getNinchishoNichijoSeikatsuJiritsudoCode();
    }

    /**
     * 認定調査・障害高齢者の日常生活自立度コードを返します。
     *
     * @return 認定調査_障害高齢者の日常生活自立度コード
     */
    public Code get認定調査_障害高齢者の日常生活自立度コード() {
        return entity.getShogaiNichijoSeikatsuJiritsudoCode();
    }

    /**
     * {@link DbT5203NinteichosahyoKihonChosaEntity}のクローンを返します。
     *
     * @return {@link DbT5203NinteichosahyoKihonChosaEntity}のクローン
     */
    @Override
    public DbT5203NinteichosahyoKihonChosaEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査票（基本調査）の識別子{@link NinteichosahyoKihonChosaIdentifier}を返します。
     *
     * @return 認定調査票（基本調査）の識別子{@link NinteichosahyoKihonChosaIdentifier}
     */
    @Override
    public NinteichosahyoKihonChosaIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査票（基本調査）配下の要素を削除対象とします。<br/>
     * {@link DbT5203NinteichosahyoKihonChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 認定調査票（基本調査）配下の要素である精神手帳任意項目情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link NinteichosahyoKihonChosa}を返します。
     *
     * @return 削除対象処理実施後の{@link NinteichosahyoKihonChosa}
     * @throws IllegalStateException
     * DbT5203NinteichosahyoKihonChosaEntityのデータ状態が変更の場合
     */
    @Override
    public NinteichosahyoKihonChosa deleted() {
        DbT5203NinteichosahyoKihonChosaEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new NinteichosahyoKihonChosa(
                deletedEntity, id, ninteichosahyoChosaItem.deleted(), ninteichosahyoKihonChosaScore.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || ninteichosahyoChosaItem.hasAnyChanged() || ninteichosahyoKihonChosaScore.hasAnyChanged();
    }

    /**
     * 認定調査票（基本調査）のみを変更対象とします。<br/>
     * {@link DbT5203NinteichosahyoKihonChosaEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link NinteichosahyoKihonChosa}
     */
    public NinteichosahyoKihonChosa modifiedModel() {
        DbT5203NinteichosahyoKihonChosaEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new NinteichosahyoKihonChosa(
                modifiedEntity, id, ninteichosahyoChosaItem, ninteichosahyoKihonChosaScore);
    }

    /**
     * 認定調査票（基本調査）が保持する認定調査票（基本調査）調査項目情報に対して、指定の識別子に該当する認定調査票（基本調査）調査項目情報を返します。
     *
     * @param id 認定調査票（基本調査）調査項目情報の識別子
     * @return 認定調査票（基本調査）調査項目情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（基本調査）調査項目情報がない場合
     */
    public NinteichosahyoChosaItem getNinteichosahyoChosaItem(NinteichosahyoChosaItemIdentifier id) {
        if (ninteichosahyoChosaItem.contains(id)) {
            return ninteichosahyoChosaItem.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（基本調査）が保持する認定調査票（基本調査）調査項目情報をリストで返します。
     *
     * @return 認定調査票（基本調査）調査項目情報リスト
     */
    public List<NinteichosahyoChosaItem> getNinteichosahyoChosaItemList() {
        return new ArrayList<>(ninteichosahyoChosaItem.values());

    }

    /**
     * 認定調査票（基本調査）が保持する認定調査票（基本調査素点）情報に対して、指定の識別子に該当する認定調査票（基本調査素点）情報を返します。
     *
     * @param id 認定調査票（基本調査素点）情報の識別子
     * @return 認定調査票（基本調査素点）情報
     * @throws IllegalStateException 指定の識別子に該当する認定調査票（基本調査素点）情報がない場合
     */
    public NinteichosahyoKihonChosaScore getNinteichosahyoKihonChosaScore(NinteichosahyoKihonChosaScoreIdentifier id) {
        if (ninteichosahyoKihonChosaScore.contains(id)) {
            return ninteichosahyoKihonChosaScore.clone().get(id);
        }
        //TODO メッセージの検討
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 認定調査票（基本調査）が保持する認定調査票（基本調査素点）情報をリストで返します。
     *
     * @return 認定調査票（基本調査素点）情報リスト
     */
    public List<NinteichosahyoKihonChosaScore> getNinteichosahyoKihonChosaScoreList() {
        return new ArrayList<>(ninteichosahyoKihonChosaScore.values());
    }

    /**
     * {@link NinteichosahyoKihonChosa}のシリアライズ形式を提供します。
     *
     * @return {@link NinteichosahyoKihonChosa}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, ninteichosahyoChosaItem, ninteichosahyoKihonChosaScore);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5203NinteichosahyoKihonChosaEntity entity;
        private final NinteichosahyoKihonChosaIdentifier id;
        private final Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem;
        private final Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore;

        private _SerializationProxy(
                DbT5203NinteichosahyoKihonChosaEntity entity,
                NinteichosahyoKihonChosaIdentifier id,
                Models<NinteichosahyoChosaItemIdentifier, NinteichosahyoChosaItem> ninteichosahyoChosaItem,
                Models<NinteichosahyoKihonChosaScoreIdentifier, NinteichosahyoKihonChosaScore> ninteichosahyoKihonChosaScore
        ) {
            this.entity = entity;
            this.id = id;
            this.ninteichosahyoChosaItem = ninteichosahyoChosaItem;
            this.ninteichosahyoKihonChosaScore = ninteichosahyoKihonChosaScore;
        }

        private Object readResolve() {
            return new NinteichosahyoKihonChosa(this.entity, this.id, this.ninteichosahyoChosaItem, this.ninteichosahyoKihonChosaScore);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link NinteichosahyoKihonChosaBuilder#build()}を使用してください。
     *
     * @return {@link NinteichosahyoKihonChosaBuilder}
     */
    public NinteichosahyoKihonChosaBuilder createBuilderForEdit() {
        return new NinteichosahyoKihonChosaBuilder(entity, id, ninteichosahyoChosaItem, ninteichosahyoKihonChosaScore);
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
        final NinteichosahyoKihonChosa other = (NinteichosahyoKihonChosa) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
