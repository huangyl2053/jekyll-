/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5510IchiGojiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.business.core.uzclasses.ModelBase;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定1.5次判定結果情報を管理するクラスです。
 */
public class IchiGojiHanteiKekkaJoho extends ModelBase<IchiGojiHanteiKekkaJohoIdentifier, DbT5510IchiGojiHanteiKekkaJohoEntity, IchiGojiHanteiKekkaJoho> implements Serializable {

    private final DbT5510IchiGojiHanteiKekkaJohoEntity entity;
    private final IchiGojiHanteiKekkaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定1.5次判定結果情報の新規作成時に使用します。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public IchiGojiHanteiKekkaJoho(ShinseishoKanriNo 申請書管理番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        this.entity = new DbT5510IchiGojiHanteiKekkaJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new IchiGojiHanteiKekkaJohoIdentifier(
                申請書管理番号
        );
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5510IchiGojiHanteiKekkaJohoEntity}より{@link IchiGojiHanteiKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5510IchiGojiHanteiKekkaJohoEntity}
     */
    public IchiGojiHanteiKekkaJoho(DbT5510IchiGojiHanteiKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1.5次判定結果情報"));
        this.id = new IchiGojiHanteiKekkaJohoIdentifier(
                entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5510IchiGojiHanteiKekkaJohoEntity}
     * @param id {@link IchiGojiHanteiKekkaJohoIdentifier}
     */
    IchiGojiHanteiKekkaJoho(
            DbT5510IchiGojiHanteiKekkaJohoEntity entity,
            IchiGojiHanteiKekkaJohoIdentifier id
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
     * 要介護認定1.5次判定年月日を返します。
     *
     * @return 要介護認定1.5次判定年月日
     */
    public FlexibleDate get要介護認定1_5次判定年月日() {
        return entity.getIchiGojiHanteiYMD();
    }

    /**
     * 要介護認定1.5次判定結果コードを返します。
     *
     * @return 要介護認定1.5次判定結果コード
     */
    public Code get要介護認定1_5次判定結果コード() {
        return entity.getIchiGojiHanteiKekkaCode();
    }

    /**
     * 要介護認定1.5次判定結果コード_認知症加算_を返します。
     *
     * @return 要介護認定1.5次判定結果コード_認知症加算_
     */
    public Code get要介護認定1_5次判定結果コード_認知症加算_() {
        return entity.getIchiGojiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 要介護認定等基準時間を返します。
     *
     * @return 要介護認定等基準時間
     */
    public int get要介護認定等基準時間() {
        return entity.getKijunJikan();
    }

    /**
     * 要介護認定等基準時間_食事_を返します。
     *
     * @return 要介護認定等基準時間_食事_
     */
    public int get要介護認定等基準時間_食事_() {
        return entity.getKijunJikanShokuji();
    }

    /**
     * 要介護認定等基準時間_排泄_を返します。
     *
     * @return 要介護認定等基準時間_排泄_
     */
    public int get要介護認定等基準時間_排泄_() {
        return entity.getKijunJikanHaisetsu();
    }

    /**
     * 要介護認定等基準時間_移動_を返します。
     *
     * @return 要介護認定等基準時間_移動_
     */
    public int get要介護認定等基準時間_移動_() {
        return entity.getKijunJikanIdo();
    }

    /**
     * 要介護認定等基準時間_清潔保持_を返します。
     *
     * @return 要介護認定等基準時間_清潔保持_
     */
    public int get要介護認定等基準時間_清潔保持_() {
        return entity.getKijunJikanSeiketsuHoji();
    }

    /**
     * 要介護認定等基準時間_間接ケア_を返します。
     *
     * @return 要介護認定等基準時間_間接ケア_
     */
    public int get要介護認定等基準時間_間接ケア_() {
        return entity.getKijunJikanKansetsuCare();
    }

    /**
     * 要介護認定等基準時間_BPSD関連_を返します。
     *
     * @return 要介護認定等基準時間_BPSD関連_
     */
    public int get要介護認定等基準時間_BPSD関連_() {
        return entity.getKijunJikanBPSDKanren();
    }

    /**
     * 要介護認定等基準時間_機能訓練_を返します。
     *
     * @return 要介護認定等基準時間_機能訓練_
     */
    public int get要介護認定等基準時間_機能訓練_() {
        return entity.getKijunJikanKinoKunren();
    }

    /**
     * 要介護認定等基準時間_医療関連_を返します。
     *
     * @return 要介護認定等基準時間_医療関連_
     */
    public int get要介護認定等基準時間_医療関連_() {
        return entity.getKijunJikanIryoKanren();
    }

    /**
     * 要介護認定等基準時間_認知症加算_を返します。
     *
     * @return 要介護認定等基準時間_認知症加算_
     */
    public int get要介護認定等基準時間_認知症加算_() {
        return entity.getKijunJikanNinchishoKasan();
    }

    /**
     * 中間評価項目得点第1群を返します。
     *
     * @return 中間評価項目得点第1群
     */
    public int get中間評価項目得点第1群() {
        return entity.getChukanHyokaKomoku1gun();
    }

    /**
     * 中間評価項目得点第2群を返します。
     *
     * @return 中間評価項目得点第2群
     */
    public int get中間評価項目得点第2群() {
        return entity.getChukanHyokaKomoku2gun();
    }

    /**
     * 中間評価項目得点第3群を返します。
     *
     * @return 中間評価項目得点第3群
     */
    public int get中間評価項目得点第3群() {
        return entity.getChukanHyokaKomoku3gun();
    }

    /**
     * 中間評価項目得点第4群を返します。
     *
     * @return 中間評価項目得点第4群
     */
    public int get中間評価項目得点第4群() {
        return entity.getChukanHyokaKomoku4gun();
    }

    /**
     * 中間評価項目得点第5群を返します。
     *
     * @return 中間評価項目得点第5群
     */
    public int get中間評価項目得点第5群() {
        return entity.getChukanHyokaKomoku5gun();
    }

    /**
     * 要介護認定1.5次判定警告コードを返します。
     *
     * @return 要介護認定1.5次判定警告コード
     */
    public Code get要介護認定1_5次判定警告コード() {
        return entity.getIchiGojiHnateiKeikokuCode();
    }

    /**
     * 要介護認定状態の安定性コードを返します。
     *
     * @return 要介護認定状態の安定性コード
     */
    public Code get要介護認定状態の安定性コード() {
        return entity.getJotaiAnteiseiCode();
    }

    /**
     * 認知症自立度Ⅱ以上の蓋然性を返します。
     *
     * @return 認知症自立度Ⅱ以上の蓋然性
     */
    public Decimal get認知症自立度Ⅱ以上の蓋然性() {
        return entity.getNinchishoJiritsudoIIijoNoGaizensei();
    }

    /**
     * 認知機能及び状態安定性から推定される給付区分コードを返します。
     *
     * @return 認知機能及び状態安定性から推定される給付区分コード
     */
    public Code get認知機能及び状態安定性から推定される給付区分コード() {
        return entity.getSuiteiKyufuKubunCode();
    }

    /**
     * {@link DbT5510IchiGojiHanteiKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5510IchiGojiHanteiKekkaJohoEntity}のクローン
     */
    @Override
    public DbT5510IchiGojiHanteiKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定1.5次判定結果情報の識別子{@link IchiGojiHanteiKekkaJohoIdentifier}を返します。
     *
     * @return 要介護認定1.5次判定結果情報の識別子{@link IchiGojiHanteiKekkaJohoIdentifier}
     */
    @Override
    public IchiGojiHanteiKekkaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定1.5次判定結果情報のみを変更対象とします。<br/>
     * {@link DbT5510IchiGojiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IchiGojiHanteiKekkaJoho}
     */
    public IchiGojiHanteiKekkaJoho modifiedModel() {
        DbT5510IchiGojiHanteiKekkaJohoEntity modifiedEntity = entity.clone();
        if (modifiedEntity.getState().equals(EntityDataState.Unchanged)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IchiGojiHanteiKekkaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定1.5次判定結果情報を削除対象とします。<br/>
     * {@link DbT5510IchiGojiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IchiGojiHanteiKekkaJoho}
     */
    @Override
    public IchiGojiHanteiKekkaJoho deleted() {
        DbT5510IchiGojiHanteiKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IchiGojiHanteiKekkaJoho(deletedEntity, id);
    }

    /**
     * {@link IchiGojiHanteiKekkaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link IchiGojiHanteiKekkaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5510IchiGojiHanteiKekkaJohoEntity entity;
        private final IchiGojiHanteiKekkaJohoIdentifier id;

        private _SerializationProxy(DbT5510IchiGojiHanteiKekkaJohoEntity entity, IchiGojiHanteiKekkaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IchiGojiHanteiKekkaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IchiGojiHanteiKekkaJohoBuilder createBuilderForEdit() {
        return new IchiGojiHanteiKekkaJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final IchiGojiHanteiKekkaJoho other = (IchiGojiHanteiKekkaJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
