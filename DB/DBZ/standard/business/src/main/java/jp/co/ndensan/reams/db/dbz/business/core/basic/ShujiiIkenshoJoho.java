/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ParentModelBase;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書情報を管理するクラスです。
 */
public class ShujiiIkenshoJoho extends
        ParentModelBase<ShujiiIkenshoJohoIdentifier, DbT5302ShujiiIkenshoJohoEntity, ShujiiIkenshoJoho> implements Serializable {

    private final DbT5302ShujiiIkenshoJohoEntity entity;
    private final ShujiiIkenshoJohoIdentifier id;

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
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5302ShujiiIkenshoJohoEntity}より{@link ShujiiIkenshoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5302ShujiiIkenshoJohoEntity}
     */
    public ShujiiIkenshoJoho(DbT5302ShujiiIkenshoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報"));
        this.id = new ShujiiIkenshoJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5302ShujiiIkenshoJohoEntity}
     * @param id {@link ShujiiIkenshoJohoIdentifier}
     */
    ShujiiIkenshoJoho(
            DbT5302ShujiiIkenshoJohoEntity entity,
            ShujiiIkenshoJohoIdentifier id
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
     * @return 在宅／施設区分
     */
    public Code get在宅_施設区分() {
        return entity.getZaitakuShisetsuKubun();
    }

    /**
     * 意見書同意フラグを返します。
     *
     * @return 意見書同意フラグ
     */
    public boolean is意見書同意フラグ() {
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
    public boolean is他科受診の有無() {
        return entity.getExistTakaJushinFlag();
    }

    /**
     * 内科受診の有無を返します。
     *
     * @return 内科受診の有無
     */
    public boolean is内科受診の有無() {
        return entity.getExistNaikaJushinFlag();
    }

    /**
     * 精神科受診の有無を返します。
     *
     * @return 精神科受診の有無
     */
    public boolean is精神科受診の有無() {
        return entity.getExistSeishinkaJushinFlag();
    }

    /**
     * 外科受診の有無を返します。
     *
     * @return 外科受診の有無
     */
    public boolean is外科受診の有無() {
        return entity.getExistGekaJushinFlag();
    }

    /**
     * 整形外科受診の有無を返します。
     *
     * @return 整形外科受診の有無
     */
    public boolean is整形外科受診の有無() {
        return entity.getExistSeikeigekaJushinFlag();
    }

    /**
     * 脳神経外科の有無を返します。
     *
     * @return 脳神経外科の有無
     */
    public boolean is脳神経外科の有無() {
        return entity.getExistNoshinkeigekaJushinFlag();
    }

    /**
     * 皮膚科受診の有無を返します。
     *
     * @return 皮膚科受診の有無
     */
    public boolean is皮膚科受診の有無() {
        return entity.getExistHifukaJushinFlag();
    }

    /**
     * 泌尿器科受診の有無を返します。
     *
     * @return 泌尿器科受診の有無
     */
    public boolean is泌尿器科受診の有無() {
        return entity.getExistHinyokikaJushinFlag();
    }

    /**
     * 婦人科受診の有無を返します。
     *
     * @return 婦人科受診の有無
     */
    public boolean is婦人科受診の有無() {
        return entity.getExistFujinkaJushinFlag();
    }

    /**
     * 耳鼻咽喉科受診の有無を返します。
     *
     * @return 耳鼻咽喉科受診の有無
     */
    public boolean is耳鼻咽喉科受診の有無() {
        return entity.getExistJibiinkokaJushinFlag();
    }

    /**
     * リハビリテーション科受診の有無を返します。
     *
     * @return リハビリテーション科受診の有無
     */
    public boolean isリハビリテーション科受診の有無() {
        return entity.getExistRehabilitationkaJushinFlag();
    }

    /**
     * 歯科受診の有無を返します。
     *
     * @return 歯科受診の有無
     */
    public boolean is歯科受診の有無() {
        return entity.getExistShikaJushinFlag();
    }

    /**
     * 眼科の有無を返します。
     *
     * @return 眼科の有無
     */
    public boolean is眼科の有無() {
        return entity.getExistGankaJushinFlag();
    }

    /**
     * その他受診科の有無を返します。
     *
     * @return その他受診科の有無
     */
    public boolean isその他受診科の有無() {
        return entity.getExistSonotaJushinkaFlag();
    }

    /**
     * その他受診科名を返します。
     *
     * @return その他受診科名
     */
    public RString getその他受診科名() {
        return entity.getSonotaJushinKaMei();
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
     * 要介護認定主治医意見書情報のみを変更対象とします。<br/>
     * {@link DbT5302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link ShujiiIkenshoJoho}
     */
    @Override
    public ShujiiIkenshoJoho modifiedModel() {
        DbT5302ShujiiIkenshoJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new ShujiiIkenshoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定主治医意見書情報を削除対象とします。<br/>
     * {@link DbT5302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link ShujiiIkenshoJoho}
     */
    @Override
    public ShujiiIkenshoJoho deleted() {
        DbT5302ShujiiIkenshoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new ShujiiIkenshoJoho(deletedEntity, id);
    }

    /**
     * {@link ShujiiIkenshoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link ShujiiIkenshoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static final class _SerializationProxy implements Serializable {

        private static final long serialVersionUID = 1L;
        private final DbT5302ShujiiIkenshoJohoEntity entity;
        private final ShujiiIkenshoJohoIdentifier id;

        private _SerializationProxy(DbT5302ShujiiIkenshoJohoEntity entity, ShujiiIkenshoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new ShujiiIkenshoJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public ShujiiIkenshoJohoBuilder createBuilderForEdit() {
        return new ShujiiIkenshoJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
