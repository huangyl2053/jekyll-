/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.basic;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.ParentModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定主治医意見書情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-011 chengsanyuan
 */
public class DbT4302ShujiiIkenshoJoho extends
        ParentModelBase<DbT4302ShujiiIkenshoJohoIdentifier, DbT4302ShujiiIkenshoJohoEntity, DbT4302ShujiiIkenshoJoho>
        implements Serializable {

    private static final long serialVersionUID = 7130583994010708697L;
    private final DbT4302ShujiiIkenshoJohoEntity entity;
    private final DbT4302ShujiiIkenshoJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定主治医意見書情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     */
    public DbT4302ShujiiIkenshoJoho(ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));
        this.entity = new DbT4302ShujiiIkenshoJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.entity.setIkenshoIraiRirekiNo(主治医意見書作成依頼履歴番号);
        this.id = new DbT4302ShujiiIkenshoJohoIdentifier(
                申請書管理番号,
                主治医意見書作成依頼履歴番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT4302ShujiiIkenshoJohoEntity}より{@link DbT4302ShujiiIkenshoJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT4302ShujiiIkenshoJohoEntity}
     */
    public DbT4302ShujiiIkenshoJoho(DbT4302ShujiiIkenshoJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書情報"));
        this.id = new DbT4302ShujiiIkenshoJohoIdentifier(
                entity.getShinseishoKanriNo(),
                entity.getIkenshoIraiRirekiNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT4302ShujiiIkenshoJohoEntity}
     * @param id {@link DbT4302ShujiiIkenshoJohoIdentifier}
     */
    DbT4302ShujiiIkenshoJoho(
            DbT4302ShujiiIkenshoJohoEntity entity,
            DbT4302ShujiiIkenshoJohoIdentifier id
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
     * 主治医意見書読取年月日を返します。
     *
     * @return 主治医意見書読取年月日
     */
    public FlexibleDate get主治医意見書読取年月日() {
        return entity.getIkenshoReadYMD();
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
     * 在宅_施設区分を返します。
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
     * 意見書_診断名1を返します。
     *
     * @return 意見書_診断名1
     */
    public RString get意見書_診断名1() {
        return entity.getShindamMei1();
    }

    /**
     * 意見書_発症年月日1を返します。
     *
     * @return 意見書_発症年月日1
     */
    public RString get意見書_発症年月日1() {
        return entity.getHasshoYMD1();
    }

    /**
     * 意見書_診断名2を返します。
     *
     * @return 意見書_診断名2
     */
    public RString get意見書_診断名2() {
        return entity.getShindamMei2();
    }

    /**
     * 意見書_発症年月日2を返します。
     *
     * @return 意見書_発症年月日2
     */
    public RString get意見書_発症年月日2() {
        return entity.getHasshoYMD2();
    }

    /**
     * 意見書_診断名3を返します。
     *
     * @return 意見書_診断名3
     */
    public RString get意見書_診断名3() {
        return entity.getShindamMei3();
    }

    /**
     * 意見書_発症年月日3を返します。
     *
     * @return 意見書_発症年月日3
     */
    public RString get意見書_発症年月日3() {
        return entity.getHasshoYMD3();
    }

    /**
     * 意見書_症状としての安定性を返します。
     *
     * @return 意見書_症状としての安定性
     */
    public RString get意見書_症状としての安定性() {
        return entity.getAnteisei();
    }

    /**
     * 不安定状況を返します。
     *
     * @return 不安定状況
     */
    public RString get不安定状況() {
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
     * 認定審査会後の二次判定結果の連絡確認フラグを返します。
     *
     * @return 認定審査会後の二次判定結果の連絡確認フラグ
     */
    public boolean is認定審査会後の二次判定結果の連絡確認フラグ() {
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
     * {@link DbT4302ShujiiIkenshoJohoEntity}のクローンを返します。
     *
     * @return {@link DbT4302ShujiiIkenshoJohoEntity}のクローン
     */
    @Override
    public DbT4302ShujiiIkenshoJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定主治医意見書情報の識別子{@link DbT4302ShujiiIkenshoJohoIdentifier}を返します。
     *
     * @return 要介護認定主治医意見書情報の識別子{@link DbT4302ShujiiIkenshoJohoIdentifier}
     */
    @Override
    public DbT4302ShujiiIkenshoJohoIdentifier identifier() {
        return this.id;
    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    /**
     * 要介護認定主治医意見書情報のみを変更対象とします。<br/>
     * {@link DbT4302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link DbT4302ShujiiIkenshoJoho}
     */
    @Override
    public DbT4302ShujiiIkenshoJoho modifiedModel() {
        DbT4302ShujiiIkenshoJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new DbT4302ShujiiIkenshoJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定主治医意見書情報を削除対象とします。<br/>
     * {@link DbT4302ShujiiIkenshoJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link DbT4302ShujiiIkenshoJoho}
     */
    @Override
    public DbT4302ShujiiIkenshoJoho deleted() {
        DbT4302ShujiiIkenshoJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new DbT4302ShujiiIkenshoJoho(deletedEntity, id);
    }

    /**
     * {@link DbT4302ShujiiIkenshoJoho}のシリアライズ形式を提供します。
     *
     * @return {@link DbT4302ShujiiIkenshoJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT4302ShujiiIkenshoJohoEntity entity;
        private final DbT4302ShujiiIkenshoJohoIdentifier id;

        private _SerializationProxy(DbT4302ShujiiIkenshoJohoEntity entity, DbT4302ShujiiIkenshoJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new DbT4302ShujiiIkenshoJoho(this.entity, this.id);
        }
        private static final long serialVersionUID = -5594326639263967079L;
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public DbT4302ShujiiIkenshoJohoBuilder createBuilderForEdit() {
        return new DbT4302ShujiiIkenshoJohoBuilder(entity, id);
    }

//TODO これはあくまでも雛形によるクラス生成です、必要な業務ロジックの追加、ValueObjectの導出を行う必要があります。
}
