/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoIdentifier;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoIraiJoho.ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikensho.shujiiIkenshoJoho.ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 */
public class ShujiiIkenshoIraiJoho extends ModelBase<ShujiiIkenshoIraiJohoIdentifier, DbT5301ShujiiIkenshoIraiJohoEntity, ShujiiIkenshoIraiJoho> implements Serializable {

    private static final long serialVersionUID = 4590222643412347242L;

    private final DbT5301ShujiiIkenshoIraiJohoEntity entity;
    private final ShujiiIkenshoIraiJohoIdentifier id;
    private final Models<ShujiiIkenshoJohoIdentifier, ShujiiIkenshoJoho> shujiiIkenshoJoho;

    /**
     * コンストラクタです。<br/>
     * 主治医意見書作成依頼情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public ShujiiIkenshoIraiJoho(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        this.entity = new DbT5301ShujiiIkenshoIraiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.id = new ShujiiIkenshoIraiJohoIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号
        );
        this.shujiiIkenshoJoho = Models.create(new ArrayList<ShujiiIkenshoJoho>());

    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5301ShujiiIkenshoIraiJohoEntity}より{@link ShujiiIkenshoIraiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5301ShujiiIkenshoIraiJohoEntity}
     */
    public ShujiiIkenshoIraiJoho(ShujiiIkenshoIraiJohoEntity entity) {
        this.entity = requireNonNull(entity.get主治医意見書作成依頼情報Entity(), UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報"));
        this.id = new ShujiiIkenshoIraiJohoIdentifier(
                entity.get主治医意見書作成依頼情報Entity().getShinseishoKanriNo(),
                entity.get主治医意見書作成依頼情報Entity().getIkenshoIraiRirekiNo());
        List<ShujiiIkenshoJoho> shujiiIkenshoJohoList = new ArrayList<>();
        for (ShujiiIkenshoJohoEntity shujiiIkenshoJohoEntity : entity.get要介護認定主治医意見書情報Entity()) {
            shujiiIkenshoJohoList.add(new ShujiiIkenshoJoho(shujiiIkenshoJohoEntity));
        }
        this.shujiiIkenshoJoho = Models.create(shujiiIkenshoJohoList);

    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5301ShujiiIkenshoIraiJohoEntity}
     * @param id {@link ShujiiIkenshoIraiJohoIdentifier}
     */
    ShujiiIkenshoIraiJoho(
            DbT5301ShujiiIkenshoIraiJohoEntity entity,
            ShujiiIkenshoIraiJohoIdentifier id,
            Models<ShujiiIkenshoJohoIdentifier, ShujiiIkenshoJoho> shujiiIkenshoJoho
    ) {
        this.entity = entity;
        this.id = id;
        this.shujiiIkenshoJoho = shujiiIkenshoJoho;
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
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
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
     * 主治医意見書依頼区分を返します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.getIkenshoIraiKubun();
    }

    /**
     * 主治医意見書作成回数を返します。
     *
     * @return 主治医意見書作成回数
     */
    public int get主治医意見書作成回数() {
        return entity.getIkenshoIraiKaisu();
    }

    /**
     * 医師区分コードを返します。
     *
     * @return 医師区分コード
     */
    public Code get医師区分コード() {
        return entity.getIshiKubunCode();
    }

    /**
     * 主治医意見書作成依頼年月日を返します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 主治医意見書作成期限年月日を返します。
     *
     * @return 主治医意見書作成期限年月日
     */
    public FlexibleDate get主治医意見書作成期限年月日() {
        return entity.getIkenshoSakuseiKigenYMD();
    }

    /**
     * 依頼書出力年月日を返します。
     *
     * @return 依頼書出力年月日
     */
    public FlexibleDate get依頼書出力年月日() {
        return entity.getIraishoShutsuryokuYMD();
    }

    /**
     * 意見書出力年月日を返します。
     *
     * @return 意見書出力年月日
     */
    public FlexibleDate get意見書出力年月日() {
        return entity.getIkenshoShutsuryokuYMD();
    }

    /**
     * 請求書出力年月日を返します。
     *
     * @return 請求書出力年月日
     */
    public FlexibleDate get請求書出力年月日() {
        return entity.getSeikyushoShutsuryokuYMD();
    }

    /**
     * 作成料請求区分を返します。
     *
     * @return 作成料請求区分
     */
    public Code get作成料請求区分() {
        return entity.getSakuseiryoSeikyuKubun();
    }

    /**
     * 主治医意見書作成督促年月日を返します。
     *
     * @return 主治医意見書作成督促年月日
     */
    public FlexibleDate get主治医意見書作成督促年月日() {
        return entity.getIkenshoSakuseiTokusokuYMD();
    }

    /**
     * 主治医意見書作成督促方法を返します。
     *
     * @return 主治医意見書作成督促方法
     */
    public RString get主治医意見書作成督促方法() {
        return entity.getIkenshoSakuseiTokusokuHoho();
    }

    /**
     * 主治医意見書作成督促回数を返します。
     *
     * @return 主治医意見書作成督促回数
     */
    public int get主治医意見書作成督促回数() {
        return entity.getIkenshoTokusokuKaisu();
    }

    /**
     * 主治医意見書作成督促メモを返します。
     *
     * @return 主治医意見書作成督促メモ
     */
    public RString get主治医意見書作成督促メモ() {
        return entity.getIkenshoTokusokuMemo();
    }

    /**
     * 認定情報提供希望フラグを返します。
     *
     * @return 認定情報提供希望フラグ
     */
    public boolean get認定情報提供希望フラグ() {
        return entity.getNinteiJohoTeikyoKiboFlag();
    }

    /**
     * 認定状況提供年月日を返します。
     *
     * @return 認定状況提供年月日
     */
    public FlexibleDate get認定状況提供年月日() {
        return entity.getNinteiJohoTeikyoYMD();
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
     * {@link DbT5301ShujiiIkenshoIraiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5301ShujiiIkenshoIraiJohoEntity}のクローン
     */
    @Override
    public DbT5301ShujiiIkenshoIraiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 主治医意見書作成依頼情報の識別子{@link ShujiiIkenshoIraiJohoIdentifier}を返します。
     *
     * @return 主治医意見書作成依頼情報の識別子{@link ShujiiIkenshoIraiJohoIdentifier}
     */
    @Override
    public ShujiiIkenshoIraiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 主治医意見書作成依頼情報配下の要素を削除対象とします。<br/>
     * {@link DbT5301ShujiiIkenshoIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     * 主治医意見書作成依頼情報配下の要素である要介護認定主治医意見書情報の{@link Models#deleteOrRemoveAll() }を実行します。
     * 削除処理結果となる{@link ShujiiIkenshoIraiJoho}を返します。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoIraiJoho}
     * @throws IllegalStateException
     * DbT5301ShujiiIkenshoIraiJohoEntityのデータ状態が変更の場合
     */
    @Override
    public ShujiiIkenshoIraiJoho deleted() {
        DbT5301ShujiiIkenshoIraiJohoEntity deletedEntity = this.toEntity();
        if (!deletedEntity.getState().equals(EntityDataState.Added)) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoIraiJoho(
                deletedEntity, id, shujiiIkenshoJoho.deleted());
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity() || shujiiIkenshoJoho.hasAnyChanged();
    }

    /**
     * 主治医意見書作成依頼情報のみを変更対象とします。<br/>
     * {@link DbT5301ShujiiIkenshoIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoIraiJoho}
     */
    public ShujiiIkenshoIraiJoho modifiedModel() {
        DbT5301ShujiiIkenshoIraiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoIraiJoho(
                modifiedEntity, id, shujiiIkenshoJoho);
    }

    /**
     * 主治医意見書作成依頼情報が保持する要介護認定主治医意見書情報に対して、指定の識別子に該当する要介護認定主治医意見書情報を返します。
     *
     * @param id 要介護認定主治医意見書情報の識別子
     * @return 要介護認定主治医意見書情報
     * @throws IllegalStateException 指定の識別子に該当する要介護認定主治医意見書情報がない場合
     */
    public ShujiiIkenshoJoho getSeishinTechoNini(ShujiiIkenshoJohoIdentifier id) {
        if (shujiiIkenshoJoho.contains(id)) {
            return shujiiIkenshoJoho.clone().get(id);
        }
        throw new IllegalArgumentException(UrErrorMessages.不正.toString());
    }

    /**
     * 主治医意見書作成依頼情報が保持する要介護認定主治医意見書情報をリストで返します。
     *
     * @return 要介護認定主治医意見書情報リスト
     */
    public List<ShujiiIkenshoJoho> getShujiiIkenshoJohoList() {
        return new ArrayList<>(shujiiIkenshoJoho.values());

    }

    /**
     * {@link ShujiiIkenshoIraiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoIraiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id, shujiiIkenshoJoho);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = -710031961519711799L;
        private final DbT5301ShujiiIkenshoIraiJohoEntity entity;
        private final ShujiiIkenshoIraiJohoIdentifier id;
        private final Models<ShujiiIkenshoJohoIdentifier, ShujiiIkenshoJoho> shujiiIkenshoJoho;

        private _SerializationProxy(
                DbT5301ShujiiIkenshoIraiJohoEntity entity,
                ShujiiIkenshoIraiJohoIdentifier id,
                Models<ShujiiIkenshoJohoIdentifier, ShujiiIkenshoJoho> shujiiIkenshoJoho
        ) {
            this.entity = entity;
            this.id = id;
            this.shujiiIkenshoJoho = shujiiIkenshoJoho;
        }

        private Object readResolve() {
            return new ShujiiIkenshoIraiJoho(this.entity, this.id, this.shujiiIkenshoJoho);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link ShujiiIkenshoIraiJohoBuilder#build()}を使用してください。
     *
     * @return {@link ShujiiIkenshoIraiJohoBuilder}
     */
    public ShujiiIkenshoIraiJohoBuilder createBuilderForEdit() {
        return new ShujiiIkenshoIraiJohoBuilder(entity, id, shujiiIkenshoJoho);
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
        final ShujiiIkenshoIraiJoho other = (ShujiiIkenshoIraiJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
