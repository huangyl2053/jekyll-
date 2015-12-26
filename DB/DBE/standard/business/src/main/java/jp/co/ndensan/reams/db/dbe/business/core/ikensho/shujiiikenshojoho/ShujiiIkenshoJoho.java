/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItemIdentifier;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItemIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書情報を管理するクラスです。
 */
public class ShujiiIkenshoJoho extends ModelBase<ShujiiIkenshoJohoIdentifier, DbT5302ShujiiIkenshoJohoEntity, ShujiiIkenshoJoho> implements Serializable {

    private static final long serialVersionUID = -2535465454451217924L;

    private final DbT5302ShujiiIkenshoJohoEntity entity;
    private final ShujiiIkenshoJohoIdentifier id;
    private final Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem;
    private final Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem;

    /**
     * コンストラクタです。<br/>
     * 要介護認定主治医意見書情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public ShujiiIkenshoJoho(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        this.entity = new DbT5302ShujiiIkenshoJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.id = new ShujiiIkenshoJohoIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号
        );
        this.shujiiIkenshoKinyuItem = Models.create(new ArrayList<ShujiiIkenshoKinyuItem>());
        this.shujiiIkenshoIkenItem = Models.create(new ArrayList<ShujiiIkenshoIkenItem>());
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShujiiIkenshoJohoEntity}より{@link ShujiiIkenshoJoho}を生成します。
     *
     * @param entity DBより取得した{@link ShujiiIkenshoJohoEntity}
     */
    public ShujiiIkenshoJoho(ShujiiIkenshoJohoEntity entity) {
        this.entity = requireNonNull(entity.get要介護認定主治医意見書情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報"));
        this.id = new ShujiiIkenshoJohoIdentifier(
                entity.get要介護認定主治医意見書情報Entity().getShinseishoKanriNo(),
                entity.get要介護認定主治医意見書情報Entity().getIkenshoIraiRirekiNo());
        List<ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItemList = new ArrayList<>();
        for (DbT5303ShujiiIkenshoKinyuItemEntity shujiiIkenshoKinyuItemEntity : entity.get要介護認定主治医意見書記入項目Entity()) {
            shujiiIkenshoKinyuItemList.add(new ShujiiIkenshoKinyuItem(shujiiIkenshoKinyuItemEntity));
        }
        this.shujiiIkenshoKinyuItem = Models.create(shujiiIkenshoKinyuItemList);

        List<ShujiiIkenshoIkenItem> shujiiIkenshoIkenItemList = new ArrayList<>();
        for (DbT5304ShujiiIkenshoIkenItemEntity shujiiIkenshoIkenItemEntity : entity.get要介護認定主治医意見書意見項目Entity()) {
            shujiiIkenshoIkenItemList.add(new ShujiiIkenshoIkenItem(shujiiIkenshoIkenItemEntity));
        }
        this.shujiiIkenshoIkenItem = Models.create(shujiiIkenshoIkenItemList);
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5302ShujiiIkenshoJohoEntity}
     * @param id {@link ShujiiIkenshoJohoIdentifier}
     */
    ShujiiIkenshoJoho(
            DbT5302ShujiiIkenshoJohoEntity entity,
            ShujiiIkenshoJohoIdentifier id,
            Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem,
            Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem) {
        this.entity = entity;
        this.id = id;
        this.shujiiIkenshoKinyuItem = shujiiIkenshoKinyuItem;
        this.shujiiIkenshoIkenItem = shujiiIkenshoIkenItem;
    }

    /**
     * 厚労省IF識別コードを返します。
     *
     * @return 厚労省IF識別コード
     */
    public RString get厚労省IF識別コード() {
        return entity.getKoroshoIfShikibetsuCode();
    }

    /**
     * 主治医意見書依頼区分を返します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryoKikanCode();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医意見書受領年月日を返します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
    }

    /**
     * 主治医意見書記入年月日を返します。
     *
     * @return 主治医意見書記入年月日
     */
    public FlexibleDate get主治医意見書記入年月日() {
        return entity.getIkenshoKinyuYMD();
    }

    /**
     * 意見書作成回数区分を返します。
     *
     * @return 意見書作成回数区分
     */
    public Code get意見書作成回数区分() {
        return entity.getIkenshoSakuseiKaisuKubun();
    }

    /**
     * 在宅／施設区分を返します。
     *
     * @return 在宅_施設区分
     */
    public Code get在宅_施設区分() {
        return entity.getZaitakuShisetsuKubun();
    }

    /**
     * 意見書同意フラグを返します。
     *
     * @return 意見書同意フラグ
     */
    public boolean get意見書同意フラグ() {
        return entity.getIkenshoDoiFlag();
    }

    /**
     * 最終診療日を返します。
     *
     * @return 最終診療日
     */
    public FlexibleDate get最終診療日() {
        return entity.getSaishuShinryoYMD();
    }

    /**
     * 他科受診の有無を返します。
     *
     * @return 他科受診の有無
     */
    public boolean get他科受診の有無() {
        return entity.getExistTakaJushinFlag();
    }

    /**
     * 内科受診の有無を返します。
     *
     * @return 内科受診の有無
     */
    public boolean get内科受診の有無() {
        return entity.getExistNaikaJushinFlag();
    }

    /**
     * 精神科受診の有無を返します。
     *
     * @return 精神科受診の有無
     */
    public boolean get精神科受診の有無() {
        return entity.getExistSeishinkaJushinFlag();
    }

    /**
     * 外科受診の有無を返します。
     *
     * @return 外科受診の有無
     */
    public boolean get外科受診の有無() {
        return entity.getExistGekaJushinFlag();
    }

    /**
     * 整形外科受診の有無を返します。
     *
     * @return 整形外科受診の有無
     */
    public boolean get整形外科受診の有無() {
        return entity.getExistSeikeigekaJushinFlag();
    }

    /**
     * 脳神経外科の有無を返します。
     *
     * @return 脳神経外科の有無
     */
    public boolean get脳神経外科の有無() {
        return entity.getExistNoshinkeigekaJushinFlag();
    }

    /**
     * 皮膚科受診の有無を返します。
     *
     * @return 皮膚科受診の有無
     */
    public boolean get皮膚科受診の有無() {
        return entity.getExistHifukaJushinFlag();
    }

    /**
     * 泌尿器科受診の有無を返します。
     *
     * @return 泌尿器科受診の有無
     */
    public boolean get泌尿器科受診の有無() {
        return entity.getExistHinyokikaJushinFlag();
    }

    /**
     * 婦人科受診の有無を返します。
     *
     * @return 婦人科受診の有無
     */
    public boolean get婦人科受診の有無() {
        return entity.getExistFujinkaJushinFlag();
    }

    /**
     * 耳鼻咽喉科受診の有無を返します。
     *
     * @return 耳鼻咽喉科受診の有無
     */
    public boolean get耳鼻咽喉科受診の有無() {
        return entity.getExistJibiinkokaJushinFlag();
    }

    /**
     * リハビリテーション科受診の有無を返します。
     *
     * @return リハビリテーション科受診の有無
     */
    public boolean getリハビリテーション科受診の有無() {
        return entity.getExistRehabilitationkaJushinFlag();
    }

    /**
     * 歯科受診の有無を返します。
     *
     * @return 歯科受診の有無
     */
    public boolean get歯科受診の有無() {
        return entity.getExistShikaJushinFlag();
    }

    /**
     * 眼科の有無を返します。
     *
     * @return 眼科の有無
     */
    public boolean get眼科の有無() {
        return entity.getExistGankaJushinFlag();
    }

    /**
     * その他受診科の有無を返します。
     *
     * @return その他受診科の有無
     */
    public boolean getその他受診科の有無() {
        return entity.getExistSonotaJushinkaFlag();
    }

    /**
     * その他受診科名を返します。
     *
     * @return その他受診科名
     */
    public RString getその他受診科名() {
        return entity.getSonotaJushinKaShimei();
    }

    /**
     * 意見書・診断名1を返します。
     *
     * @return 意見書_診断名1
     */
    public RString get意見書_診断名1() {
        return entity.getShindamMei1();
    }

    /**
     * 意見書・発症年月日1を返します。
     *
     * @return 意見書_発症年月日1
     */
    public FlexibleDate get意見書_発症年月日1() {
        return entity.getHasshoYMD1();
    }

    /**
     * 意見書・診断名2を返します。
     *
     * @return 意見書_診断名2
     */
    public RString get意見書_診断名2() {
        return entity.getShindamMei2();
    }

    /**
     * 意見書・発症年月日2を返します。
     *
     * @return 意見書_発症年月日2
     */
    public FlexibleDate get意見書_発症年月日2() {
        return entity.getHasshoYMD2();
    }

    /**
     * 意見書・診断名3を返します。
     *
     * @return 意見書_診断名3
     */
    public RString get意見書_診断名3() {
        return entity.getShindamMei3();
    }

    /**
     * 意見書・発症年月日3を返します。
     *
     * @return 意見書_発症年月日3
     */
    public FlexibleDate get意見書_発症年月日3() {
        return entity.getHasshoYMD3();
    }

    /**
     * 意見書・症状としての安定性を返します。
     *
     * @return 意見書_症状としての安定性
     */
    public RString get意見書_症状としての安定性() {
        return entity.getAnteisei();
    }

    /**
     * 意見書・症状としての安定性　不安定状況を返します。
     *
     * @return 意見書_症状としての安定性_不安定状況
     */
    public RString get意見書_症状としての安定性_不安定状況() {
        return entity.getFuanteiJokyo();
    }

    /**
     * 治療内容を返します。
     *
     * @return 治療内容
     */
    public RString get治療内容() {
        return entity.getChiryoNaiyo();
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return entity.getTokkiJiko();
    }

    /**
     * 特記事項イメージ共有ファイルIDを返します。
     *
     * @return 特記事項イメージ共有ファイルID
     */
    public RDateTime get特記事項イメージ共有ファイルID() {
        return entity.getTokkiJikoImageSharedFileId();
    }

    /**
     * 認定審査会後の二次判定結果の連絡確認フラグを返します。
     *
     * @return 認定審査会後の二次判定結果の連絡確認フラグ
     */
    public boolean get認定審査会後の二次判定結果の連絡確認フラグ() {
        return entity.getNijiHanteiKekkaRenrakuFlag();
    }

    /**
     * 意見書メモを返します。
     *
     * @return 意見書メモ
     */
    public RString get意見書メモ() {
        return entity.getIkenshoMemo();
    }

    /**
     * {@link DbT5302ShujiiIkenshoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5302ShujiiIkenshoJohoEntity}のクローン
     */
    @Override
    public DbT5302ShujiiIkenshoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定主治医意見書情報の識別子{@link ShujiiIkenshoJohoIdentifier}を返します。
     *
     * @return 要介護認定主治医意見書情報の識別子{@link ShujiiIkenshoJohoIdentifier}
     */
    @Override
    public ShujiiIkenshoJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定主治医意見書情報配下の要素を削除対象とします。<br/>
     * {@link DbT5302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 要介護認定主治医意見書情報配下の要素である要介護認定主治医意見書記入項目の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ShujiiIkenshoJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoJoho}
     * @throws IllegalStateException DbT5302ShujiiIkenshoJohoEntityのデータ状態が変更の場合
     */
    @Override
    public ShujiiIkenshoJoho deleted() {
        DbT5302ShujiiIkenshoJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoJoho(
                deletedEntity, id, shujiiIkenshoKinyuItem.deleted(), shujiiIkenshoIkenItem.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shujiiIkenshoKinyuItem.hasAnyChanged() || shujiiIkenshoIkenItem.hasAnyChanged();
    }

    /**
     * 要介護認定主治医意見書情報のみを変更対象とします。<br/>
     * {@link DbT5302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoJoho}
     */
    public ShujiiIkenshoJoho modifiedModel() {
        DbT5302ShujiiIkenshoJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoJoho(
                modifiedEntity, id, shujiiIkenshoKinyuItem, shujiiIkenshoIkenItem);
    }

    /**
     * 要介護認定主治医意見書情報が保持する要介護認定主治医意見書記入項目に対して、指定の識別子に該当する要介護認定主治医意見書記入項目を返します。
     *
     * @param id 要介護認定主治医意見書記入項目の識別子
     * @return 要介護認定主治医意見書記入項目
     * @throws IllegalStateException 指定の識別子に該当する要介護認定主治医意見書記入項目がない場合
     */
    public ShujiiIkenshoKinyuItem getShujiiIkenshoKinyuItem(ShujiiIkenshoKinyuItemIdentifier id) {
        if (shujiiIkenshoKinyuItem.contains(id)) {
            return shujiiIkenshoKinyuItem.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定主治医意見書情報が保持する要介護認定主治医意見書記入項目をリストで返します。
     *
     * @return 要介護認定主治医意見書記入項目リスト
     */
    public List<ShujiiIkenshoKinyuItem> getShujiiIkenshoKinyuItemList() {
        return new ArrayList<>(shujiiIkenshoKinyuItem.values());

    }

    /**
     * 要介護認定主治医意見書情報が保持する届出者情報に対して、指定の識別子に該当する要介護認定主治医意見書意見項目を返します。
     *
     * @param id 要介護認定主治医意見書意見項目の識別子
     * @return 要介護認定主治医意見書意見項目
     * @throws IllegalStateException 指定の識別子に該当する要介護認定主治医意見書意見項目がない場合
     */
    public ShujiiIkenshoIkenItem getShujiiIkenshoIkenItem(ShujiiIkenshoIkenItemIdentifier id) {
        if (shujiiIkenshoIkenItem.contains(id)) {
            return shujiiIkenshoIkenItem.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 要介護認定主治医意見書情報が保持する要介護認定主治医意見書意見項目をリストで返します。
     *
     * @return 要介護認定主治医意見書意見項目リスト
     */
    public List<ShujiiIkenshoIkenItem> getShujiiIkenshoIkenItemList() {
        return new ArrayList<>(shujiiIkenshoIkenItem.values());
    }

    /**
     * {@link ShujiiIkenshoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shujiiIkenshoKinyuItem, shujiiIkenshoIkenItem);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5302ShujiiIkenshoJohoEntity entity;
        private final ShujiiIkenshoJohoIdentifier id;
        private final Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem;
        private final Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem;

        private _SerializationProxy(
                DbT5302ShujiiIkenshoJohoEntity entity,
                ShujiiIkenshoJohoIdentifier id,
                Models<ShujiiIkenshoKinyuItemIdentifier, ShujiiIkenshoKinyuItem> shujiiIkenshoKinyuItem,
                Models<ShujiiIkenshoIkenItemIdentifier, ShujiiIkenshoIkenItem> shujiiIkenshoIkenItem
        ) {
            this.entity = entity;
            this.id = id;
            this.shujiiIkenshoKinyuItem = shujiiIkenshoKinyuItem;
            this.shujiiIkenshoIkenItem = shujiiIkenshoIkenItem;
        }

        private Object readResolve() {
            return new ShujiiIkenshoJoho(this.entity, this.id, this.shujiiIkenshoKinyuItem, this.shujiiIkenshoIkenItem);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShujiiIkenshoJohoBuilder#build()}を使用してください。
     *
     * @return {@link ShujiiIkenshoJohoBuilder}
     */
    public ShujiiIkenshoJohoBuilder createBuilderForEdit() {
        return new ShujiiIkenshoJohoBuilder(entity, id, shujiiIkenshoKinyuItem, shujiiIkenshoIkenItem);
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
        final ShujiiIkenshoJoho other = (ShujiiIkenshoJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
