/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4201NinteichosaIraiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 認定調査依頼情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
public class DbT4201NinteichosaIraiJoho extends
        ParentModelBase<DbT4201NinteichosaIraiJohoIdentifier, DbT4201NinteichosaIraiJohoEntity, DbT4201NinteichosaIraiJoho>
        implements Serializable {

    private static final long serialVersionUID = -7165920514169325497L;
    private final DbT4201NinteichosaIraiJohoEntity entity;
    private final DbT4201NinteichosaIraiJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 認定調査依頼情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     */
    public DbT4201NinteichosaIraiJoho(ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼履歴番号"));
        this.entity = new DbT4201NinteichosaIraiJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setNinteichosaIraiRirekiNo(認定調査依頼履歴番号);
        this.id = new DbT4201NinteichosaIraiJohoIdentifier(
                申請書管理番号,
                認定調査依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4201NinteichosaIraiJohoEntity}より{@link DbT4201NinteichosaIraiJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4201NinteichosaIraiJohoEntity}
     */
    public DbT4201NinteichosaIraiJoho(DbT4201NinteichosaIraiJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報"));
        this.id = new DbT4201NinteichosaIraiJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getNinteichosaIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4201NinteichosaIraiJohoEntity}
     * @param id {@link DbT4201NinteichosaIraiJohoIdentifier}
     */
    DbT4201NinteichosaIraiJoho(
            DbT4201NinteichosaIraiJohoEntity entity,
            DbT4201NinteichosaIraiJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

//TODO getterを見直してください。意味のある単位でValueObjectを作成して公開してください。
    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.getNinteichosaIraiRirekiNo();
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
     * 認定調査委託先コードを返します。
     *
     * @return 認定調査委託先コード
     */
    public JigyoshaNo get認定調査委託先コード() {
        return entity.getNinteichosaItakusakiCode();
    }

    /**
     * 認定調査員コードを返します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.getNinteiChosainCode();
    }

    /**
     * 認定調査依頼区分コードを返します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.getNinteichosaIraiKubunCode();
    }

    /**
     * 認定調査回数を返します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return entity.getNinteichosaIraiKaisu();
    }

    /**
     * 認定調査依頼年月日を返します。
     *
     * @return 認定調査依頼年月日
     */
    public FlexibleDate get認定調査依頼年月日() {
        return entity.getNinteichosaIraiYMD();
    }

    /**
     * 認定調査期限年月日を返します。
     *
     * @return 認定調査期限年月日
     */
    public FlexibleDate get認定調査期限年月日() {
        return entity.getNinteichosaKigenYMD();
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
     * 調査票等出力年月日を返します。
     *
     * @return 調査票等出力年月日
     */
    public FlexibleDate get調査票等出力年月日() {
        return entity.getChosahyoTouShutsuryokuYMD();
    }

    /**
     * モバイルデータ出力済フラグを返します。
     *
     * @return モバイルデータ出力済フラグ
     */
    public boolean getモバイルデータ出力済フラグ() {
        return entity.getMobileDataShutsuryokuZumiFlag();
    }

    /**
     * 事前調査フラグを返します。
     *
     * @return 事前調査フラグ
     */
    public boolean get事前調査フラグ() {
        return entity.getJizenChosaFlag();
    }

    /**
     * 認定調査督促年月日を返します。
     *
     * @return 認定調査督促年月日
     */
    public FlexibleDate get認定調査督促年月日() {
        return entity.getNinteichosaTokusokuYMD();
    }

    /**
     * 認定調査督促方法を返します。
     *
     * @return 認定調査督促方法
     */
    public RString get認定調査督促方法() {
        return entity.getNinteichosaTokusokuHoho();
    }

    /**
     * 認定調査督促回数を返します。
     *
     * @return 認定調査督促回数
     */
    public int get認定調査督促回数() {
        return entity.getNinteichosaTokusokuKaisu();
    }

    /**
     * 認定調査督促メモを返します。
     *
     * @return 認定調査督促メモ
     */
    public RString get認定調査督促メモ() {
        return entity.getNinteichosaTokusokuMemo();
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
     * {@link DbT4201NinteichosaIraiJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4201NinteichosaIraiJohoEntity}のクローン
     */
    @Override
    public DbT4201NinteichosaIraiJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 認定調査依頼情報の識別子{@link DbT4201NinteichosaIraiJohoIdentifier}を返します。
     *
     * @return 認定調査依頼情報の識別子{@link DbT4201NinteichosaIraiJohoIdentifier}
     */
    @Override
    public DbT4201NinteichosaIraiJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 認定調査依頼情報のみを変更対象とします。<br/>
     * {@link DbT4201NinteichosaIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4201NinteichosaIraiJoho}
     */
    @Override
    public DbT4201NinteichosaIraiJoho modifiedModel() {
        DbT4201NinteichosaIraiJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4201NinteichosaIraiJoho(
                modifiedEntity, id);
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 保持する認定調査依頼情報を削除対象とします。<br/>
     * {@link DbT4201NinteichosaIraiJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4201NinteichosaIraiJoho}
     */
    @Override
    public DbT4201NinteichosaIraiJoho deleted() {
        DbT4201NinteichosaIraiJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4201NinteichosaIraiJoho(deletedEntity, id);
    }

    /**
     * {@link DbT4201NinteichosaIraiJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4201NinteichosaIraiJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4201NinteichosaIraiJohoEntity entity;
        private final DbT4201NinteichosaIraiJohoIdentifier id;

        private _SerializationProxy(DbT4201NinteichosaIraiJohoEntity entity, DbT4201NinteichosaIraiJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4201NinteichosaIraiJoho(this.entity, this.id);
        }
        private static final long serialVersionUID = -8101529524852487664L;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4201NinteichosaIraiJohoBuilder createBuilderForEdit() {
        return new DbT4201NinteichosaIraiJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
