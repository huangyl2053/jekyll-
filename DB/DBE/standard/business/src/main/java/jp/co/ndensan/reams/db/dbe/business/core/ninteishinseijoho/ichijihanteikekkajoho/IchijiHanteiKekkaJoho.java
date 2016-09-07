/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho;

import java.io.Serializable;
import java.util.Objects;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5116IchijiHanteiKekkaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.ModelBase;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;

/**
 * 要介護認定一次判定結果情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class IchijiHanteiKekkaJoho
        extends ModelBase<IchijiHanteiKekkaJohoIdentifier, DbT5116IchijiHanteiKekkaJohoEntity, IchijiHanteiKekkaJoho>
        implements Serializable {

    private final DbT5116IchijiHanteiKekkaJohoEntity entity;
    private final IchijiHanteiKekkaJohoIdentifier id;

    /**
     * コンストラクタです。<br/>
     * 要介護認定一次判定結果情報の新規作成時に使用します。
     *
     *
     * @param 申請書管理番号 申請書管理番号
     */
    public IchijiHanteiKekkaJoho(ShinseishoKanriNo 申請書管理番号) {

        this.entity = new DbT5116IchijiHanteiKekkaJohoEntity();
        this.entity.setShinseishoKanriNo(申請書管理番号);
        this.id = new IchijiHanteiKekkaJohoIdentifier(申請書管理番号);
    }

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link DbT5116IchijiHanteiKekkaJohoEntity}より{@link IchijiHanteiKekkaJoho}を生成します。
     *
     * @param entity DBより取得した{@link DbT5116IchijiHanteiKekkaJohoEntity}
     */
    public IchijiHanteiKekkaJoho(DbT5116IchijiHanteiKekkaJohoEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定一次判定結果情報"));
        this.id = new IchijiHanteiKekkaJohoIdentifier(entity.getShinseishoKanriNo());
    }

    /**
     * シリアライズ、ビルダー用コンストラクタです。
     *
     * @param entity {@link DbT5116IchijiHanteiKekkaJohoEntity}
     * @param id {@link IchijiHanteiKekkaJohoIdentifier}
     */
    IchijiHanteiKekkaJoho(
            DbT5116IchijiHanteiKekkaJohoEntity entity,
            IchijiHanteiKekkaJohoIdentifier id
    ) {
        this.entity = entity;
        this.id = id;
    }

    /**
     * 要介護認定一次判定年月日を返します。
     *
     * @return 要介護認定一次判定年月日
     */
    public FlexibleDate get要介護認定一次判定年月日() {
        return entity.getIchijiHanteiYMD();
    }

    /**
     * 要介護認定一次判定結果コード_認知症加算を返します。
     *
     * @return 要介護認定一次判定結果コード_認知症加算
     */
    public Code get要介護認定一次判定結果コード_認知症加算() {
        return entity.getIchijiHanteiKekkaNinchishoKasanCode();
    }

    /**
     * 要介護認定一次判定結果コードを返します。
     *
     * @return 要介護認定一次判定結果コード
     */
    public Code get要介護認定一次判定結果コード() {
        return entity.getIchijiHanteiKekkaCode();
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
     * 要介護認定等基準時間_食事を返します。
     *
     * @return 要介護認定等基準時間_食事
     */
    public int get要介護認定等基準時間_食事() {
        return entity.getKijunJikanShokuji();
    }

    /**
     * 要介護認定等基準時間_排泄を返します。
     *
     * @return 要介護認定等基準時間_排泄
     */
    public int get要介護認定等基準時間_排泄() {
        return entity.getKijunJikanHaisetsu();
    }

    /**
     * 要介護認定等基準時間_移動を返します。
     *
     * @return 要介護認定等基準時間_移動
     */
    public int get要介護認定等基準時間_移動() {
        return entity.getKijunJikanIdo();
    }

    /**
     * 要介護認定等基準時間_清潔保持を返します。
     *
     * @return 要介護認定等基準時間_清潔保持
     */
    public int get要介護認定等基準時間_清潔保持() {
        return entity.getKijunJikanSeiketsuHoji();
    }

    /**
     * 要介護認定等基準時間_間接ケアを返します。
     *
     * @return 要介護認定等基準時間_間接ケア
     */
    public int get要介護認定等基準時間_間接ケア() {
        return entity.getKijunJikanKansetsuCare();
    }

    /**
     * 要介護認定等基準時間_BPSD関連を返します。
     *
     * @return 要介護認定等基準時間_BPSD関連
     */
    public int get要介護認定等基準時間_BPSD関連() {
        return entity.getKijunJikanBPSDKanren();
    }

    /**
     * 要介護認定等基準時間_機能訓練を返します。
     *
     * @return 要介護認定等基準時間_機能訓練
     */
    public int get要介護認定等基準時間_機能訓練() {
        return entity.getKijunJikanKinoKunren();
    }

    /**
     * 要介護認定等基準時間_医療関連を返します。
     *
     * @return 要介護認定等基準時間_医療関連
     */
    public int get要介護認定等基準時間_医療関連() {
        return entity.getKijunJikanIryoKanren();
    }

    /**
     * 要介護認定等基準時間_認知症加算を返します。
     *
     * @return 要介護認定等基準時間_認知症加算
     */
    public int get要介護認定等基準時間_認知症加算() {
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
     * 中間評価項目得点第6群を返します。
     *
     * @return 中間評価項目得点第6群
     */
    public int get中間評価項目得点第6群() {
        return entity.getChukanHyokaKomoku6gun();
    }

    /**
     * 中間評価項目得点第7群を返します。
     *
     * @return 中間評価項目得点第7群
     */
    public int get中間評価項目得点第7群() {
        return entity.getChukanHyokaKomoku7gun();
    }

    /**
     * 要介護認定一次判定警告コードを返します。
     *
     * @return 要介護認定一次判定警告コード
     */
    public RString get要介護認定一次判定警告コード() {
        return entity.getIchijiHnateiKeikokuCode();
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
     * 運動能力の低下していない認知症高齢者の指標コードを返します。
     *
     * @return 運動能力の低下していない認知症高齢者の指標コード
     */
    public Code get運動能力の低下していない認知症高齢者の指標コード() {
        return entity.getNinchishoKoreishaShihyoCode();
    }

    /**
     * 日常生活自立度の組み合わせ_自立を返します。
     *
     * @return 日常生活自立度の組み合わせ_自立
     */
    public int get日常生活自立度の組み合わせ_自立() {
        return entity.getJiritsudoKumiawase1();
    }

    /**
     * 日常生活自立度の組み合わせ_要支援を返します。
     *
     * @return 日常生活自立度の組み合わせ_要支援
     */
    public int get日常生活自立度の組み合わせ_要支援() {
        return entity.getJiritsudoKumiawase2();
    }

    /**
     * 日常生活自立度の組み合わせ_要介護１を返します。
     *
     * @return 日常生活自立度の組み合わせ_要介護１
     */
    public int get日常生活自立度の組み合わせ_要介護１() {
        return entity.getJiritsudoKumiawase3();
    }

    /**
     * 日常生活自立度の組み合わせ_要介護２を返します。
     *
     * @return 日常生活自立度の組み合わせ_要介護２
     */
    public int get日常生活自立度の組み合わせ_要介護２() {
        return entity.getJiritsudoKumiawase4();
    }

    /**
     * 日常生活自立度の組み合わせ_要介護３を返します。
     *
     * @return 日常生活自立度の組み合わせ_要介護３
     */
    public int get日常生活自立度の組み合わせ_要介護３() {
        return entity.getJiritsudoKumiawase5();
    }

    /**
     * 日常生活自立度の組み合わせ_要介護４を返します。
     *
     * @return 日常生活自立度の組み合わせ_要介護４
     */
    public int get日常生活自立度の組み合わせ_要介護４() {
        return entity.getJiritsudoKumiawase6();
    }

    /**
     * 日常生活自立度の組み合わせ_要介護５を返します。
     *
     * @return 日常生活自立度の組み合わせ_要介護５
     */
    public int get日常生活自立度の組み合わせ_要介護５() {
        return entity.getJiritsudoKumiawase7();
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価コードを返します。
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価コード
     */
    public Code get認知症高齢者の日常生活自立度の蓋然性評価コード() {
        return entity.getGaizenseiHyokaCode();
    }

    /**
     * 認知症高齢者の日常生活自立度の蓋然性評価を返します。
     *
     * @return 認知症高齢者の日常生活自立度の蓋然性評価
     */
    public int get認知症高齢者の日常生活自立度の蓋然性評価() {
        return entity.getGaizenseiHyokaPercent();
    }

    /**
     * 一次判定結果送付区分を返します。
     *
     * @return 一次判定結果送付区分
     */
    public RString get一次判定結果送付区分() {
        return entity.getIchijiHanteiSofuKubun();
    }

    /**
     * 一次判定結果送付年月日を返します。
     *
     * @return 一次判定結果送付年月日
     */
    public FlexibleDate get一次判定結果送付年月日() {
        return entity.getIchijiHanteiKekkaSofuYMD();
    }

    /**
     * チャートを返します。
     *
     * @return チャート
     */
    public RString getチャート() {
        return entity.getChert();
    }

    /**
     * 状態像を返します。
     *
     * @return 状態像
     */
    public RString get状態像() {
        return entity.getJotaizo();
    }

    /**
     * {@link DbT5116IchijiHanteiKekkaJohoEntity}のクローンを返します。
     *
     * @return {@link DbT5116IchijiHanteiKekkaJohoEntity}のクローン
     */
    @Override
    public DbT5116IchijiHanteiKekkaJohoEntity toEntity() {
        return this.entity.clone();
    }

    /**
     * 要介護認定一次判定結果情報の識別子{@link IchijiHanteiKekkaJohoIdentifier}を返します。
     *
     * @return 要介護認定一次判定結果情報の識別子{@link IchijiHanteiKekkaJohoIdentifier}
     */
    @Override
    public IchijiHanteiKekkaJohoIdentifier identifier() {
        return this.id;
    }

    /**
     * 要介護認定一次判定結果情報のみを変更対象とします。<br/>
     * {@link DbT5116IchijiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば変更状態にします。
     *
     * @return 変更対象処理実施後の{@link IchijiHanteiKekkaJoho}
     */
    public IchijiHanteiKekkaJoho modifiedModel() {
        DbT5116IchijiHanteiKekkaJohoEntity modifiedEntity = this.toEntity();
        if (!modifiedEntity.getState().equals(EntityDataState.Added)) {
            modifiedEntity.setState(EntityDataState.Modified);
        }
        return new IchijiHanteiKekkaJoho(
                modifiedEntity, id);
    }

    /**
     * 保持する要介護認定一次判定結果情報を削除対象とします。<br/>
     * {@link DbT5116IchijiHanteiKekkaJohoEntity}の{@link EntityDataState}がすでにDBへ永続化されている物であれば削除状態にします。
     *
     * @return 削除対象処理実施後の{@link IchijiHanteiKekkaJoho}
     */
    @Override
    public IchijiHanteiKekkaJoho deleted() {
        DbT5116IchijiHanteiKekkaJohoEntity deletedEntity = this.toEntity();
        if (deletedEntity.getState() != EntityDataState.Added) {
            deletedEntity.setState(EntityDataState.Deleted);
        } else {
            //TODO メッセージの検討
            throw new IllegalStateException(UrErrorMessages.不正.toString());
        }
        return new IchijiHanteiKekkaJoho(deletedEntity, id);
    }

    /**
     * {@link IchijiHanteiKekkaJoho}のシリアライズ形式を提供します。
     *
     * @return {@link IchijiHanteiKekkaJoho}のシリアライズ形式
     */
    protected Object writeReplace() {
        return new _SerializationProxy(entity, id);

    }

    @Override
    public boolean hasChanged() {
        return hasChangedEntity();
    }

    private static final class _SerializationProxy implements Serializable {

        private final DbT5116IchijiHanteiKekkaJohoEntity entity;
        private final IchijiHanteiKekkaJohoIdentifier id;

        private _SerializationProxy(DbT5116IchijiHanteiKekkaJohoEntity entity, IchijiHanteiKekkaJohoIdentifier id) {
            this.entity = entity;
            this.id = id;
        }

        private Object readResolve() {
            return new IchijiHanteiKekkaJoho(this.entity, this.id);
        }
    }

    /**
     * このクラスの編集を行うBuilderを取得します。<br/>
     * 編集後のインスタンスを取得する場合は{@link SeishinTechoNini.createBuilderForEdit#build()}を使用してください。
     *
     * @return Builder
     */
    public IchijiHanteiKekkaJohoBuilder createBuilderForEdit() {
        return new IchijiHanteiKekkaJohoBuilder(entity, id);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final IchijiHanteiKekkaJoho other = (IchijiHanteiKekkaJoho) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

}
