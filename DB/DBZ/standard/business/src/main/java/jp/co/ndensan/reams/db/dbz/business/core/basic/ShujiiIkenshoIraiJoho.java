/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5301ShujiiIkenshoIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 */
public class ShujiiIkenshoIraiJoho extends
        ModelBase<ShujiiIkenshoIraiJohoIdentifier, DbT5301ShujiiIkenshoIraiJohoEntity, ShujiiIkenshoIraiJoho> implements Serializable {

    private final DbT5301ShujiiIkenshoIraiJohoEntity entity;
    private final ShujiiIkenshoIraiJohoIdentifier id;

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
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5301ShujiiIkenshoIraiJohoEntity}より{@link ShujiiIkenshoIraiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5301ShujiiIkenshoIraiJohoEntity}
     */
    public ShujiiIkenshoIraiJoho(DbT5301ShujiiIkenshoIraiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報"));
        this.id = new ShujiiIkenshoIraiJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5301ShujiiIkenshoIraiJohoEntity}
     * @param id {@link ShujiiIkenshoIraiJohoIdentifier}
     */
    ShujiiIkenshoIraiJoho(
            DbT5301ShujiiIkenshoIraiJohoEntity entity,
            ShujiiIkenshoIraiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
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
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.getIkenshoIraiRirekiNo();
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
    public boolean is認定情報提供希望フラグ() {
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
    public boolean is論理削除フラグ() {
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
     * 主治医意見書作成依頼情報のみを変更対象とします。<br/> {@link DbT5301ShujiiIkenshoIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoIraiJoho}
     */
    public ShujiiIkenshoIraiJoho modifiedModel() {
        DbT5301ShujiiIkenshoIraiJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoIraiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する主治医意見書作成依頼情報を削除対象とします。<br/> {@link DbT5301ShujiiIkenshoIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoIraiJoho}
     */
    @Override
    public ShujiiIkenshoIraiJoho deleted() {
        DbT5301ShujiiIkenshoIraiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoIraiJoho(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoIraiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoIraiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5301ShujiiIkenshoIraiJohoEntity entity;
        private final ShujiiIkenshoIraiJohoIdentifier id;

        private _SerializationProxy(DbT5301ShujiiIkenshoIraiJohoEntity entity, ShujiiIkenshoIraiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoIraiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoIraiJohoBuilder createBuilderForEdit() {
        return new ShujiiIkenshoIraiJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.id);
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
