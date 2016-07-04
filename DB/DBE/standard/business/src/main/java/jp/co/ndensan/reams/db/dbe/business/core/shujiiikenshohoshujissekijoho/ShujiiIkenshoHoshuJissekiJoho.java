/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shujiiikenshohoshujissekijoho;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 主治医意見書作成報酬実績情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 xuyannan
 */
public class ShujiiIkenshoHoshuJissekiJoho
        extends ParentModelBase<ShujiiIkenshoHoshuJissekiJohoIdentifier, DbT5602ShujiiIkenshoHoshuJissekiJohoEntity, ShujiiIkenshoHoshuJissekiJoho>
        implements Serializable {

//TODO NetBeansの機能を使って必ずequalsとhashCodeを追加してください。
    private final DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity;
    private final ShujiiIkenshoHoshuJissekiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 主治医意見書作成報酬実績情報の新規作成時に使用します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public ShujiiIkenshoHoshuJissekiJoho(
            RString 主治医医療機関コード,
            RString 主治医コード,
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        this.entity = new DbT5602ShujiiIkenshoHoshuJissekiJohoEntity();
        this.entity.setShujiiIryoKikanCode(主治医医療機関コード);
        this.entity.setShujiiCode(主治医コード);
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.id = new ShujiiIkenshoHoshuJissekiJohoIdentifier(
                主治医医療機関コード,
                主治医コード,
                申請書管理番号,
                主治医意見書作成依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}より{@link ShujiiIkenshoHoshuJissekiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}
     */
    public ShujiiIkenshoHoshuJissekiJoho(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成報酬実績情報"));
        this.id = new ShujiiIkenshoHoshuJissekiJohoIdentifier(
                entity.getShujiiIryoKikanCode(),
                entity.getShujiiCode(),
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}
     * @param id {@link ShujiiIkenshoHoshuJissekiJohoIdentifier}
     */
    ShujiiIkenshoHoshuJissekiJoho(
            DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity,
            ShujiiIkenshoHoshuJissekiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
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
     * 主治医意見書作成依頼年月日を返します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIraishoSakuseiIraiYMD();
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
     * 主治医意見書受領年月日を返します。
     *
     * @return 主治医意見書受領年月日
     */
    public FlexibleDate get主治医意見書受領年月日() {
        return entity.getIkenshoJuryoYMD();
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
     * 主治医意見書作成料を返します。
     *
     * @return 主治医意見書作成料
     */
    public int get主治医意見書作成料() {
        return entity.getIkenshoSakuseiryo();
    }

    /**
     * 主治医意見書別途診療費を返します。
     *
     * @return 主治医意見書別途診療費
     */
    public int get主治医意見書別途診療費() {
        return entity.getIkenshoBettoShinryohi();
    }

    /**
     * 主治医意見書報酬を返します。
     *
     * @return 主治医意見書報酬
     */
    public int get主治医意見書報酬() {
        return entity.getIkenshoHoshu();
    }

    /**
     * 主治医意見書報酬支払年月日を返します。
     *
     * @return 主治医意見書報酬支払年月日
     */
    public FlexibleDate get主治医意見書報酬支払年月日() {
        return entity.getHoshuShiharaiYMD();
    }

    /**
     * 主治医意見書報酬支払メモを返します。
     *
     * @return 主治医意見書報酬支払メモ
     */
    public RString get主治医意見書報酬支払メモ() {
        return entity.getHoshuShiharaiMemo();
    }

    /**
     * 銀行振込出力フラグを返します。
     *
     * @return 銀行振込出力フラグ
     */
    public boolean is銀行振込出力フラグ() {
        return entity.isGinkoFurikomiShutsuryokuFlag();
    }

    /**
     * {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}のクローン
     */
    @Override
    public DbT5602ShujiiIkenshoHoshuJissekiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 主治医意見書作成報酬実績情報の識別子{@link ShujiiIkenshoHoshuJissekiJohoIdentifier}を返します。
     *
     * @return 主治医意見書作成報酬実績情報の識別子{@link ShujiiIkenshoHoshuJissekiJohoIdentifier}
     */
    @Override
    public ShujiiIkenshoHoshuJissekiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 主治医意見書作成報酬実績情報のみを変更対象とします。<br/>
     * {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoHoshuJissekiJoho}
     */
    @Override
    public ShujiiIkenshoHoshuJissekiJoho modifiedModel() {
        DbT5602ShujiiIkenshoHoshuJissekiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoHoshuJissekiJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する主治医意見書作成報酬実績情報を削除対象とします。<br/>
     * {@link DbT5602ShujiiIkenshoHoshuJissekiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoHoshuJissekiJoho}
     */
    @Override
    public ShujiiIkenshoHoshuJissekiJoho deleted() {
        DbT5602ShujiiIkenshoHoshuJissekiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoHoshuJissekiJoho(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoHoshuJissekiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoHoshuJissekiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return !toEntity().getState().equals(EntityDataState.Unchanged);
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity;
        private final ShujiiIkenshoHoshuJissekiJohoIdentifier id;

        private _SerializationProxy(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity, ShujiiIkenshoHoshuJissekiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoHoshuJissekiJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoHoshuJissekiJohoBuilder createBuilderForEdit() {
        return new ShujiiIkenshoHoshuJissekiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
