/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.RelatedDataBase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageinputRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * イメージ取込み関連データのビジネスクラスです。
 *
 * @reamsid_L DBE-1580-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class ImageinputRelate extends RelatedDataBase {

    private static final RString IRAI_NAME = new RString("主治医意見書の作成");
    private final ImageinputRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity イメージ取込み関連データRelateEntity
     */
    public ImageinputRelate(ImageinputRelateEntity entity) {
        this.entity = entity;
    }

    @Override
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    @Override
    public RString get被保険者カナ() {
        return entity.get被保険者カナ();
    }

    /**
     * 証記載保険者番号を返します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 施設入所の有無を返します。
     *
     * @return 施設入所の有無
     */
    public boolean has施設入所() {
        return entity.is施設入所の有無();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号Value() {
        return entity.get申請書管理番号();
    }

    /**
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return new ShinseishoKanriNo(get申請書管理番号Value());
    }

    /**
     * @return 申請に紐付く九共有ファイルID. もしくは、{@code null}.
     */
    public RDateTime getSharedFileIDOrNull() {
        return this.entity.getイメージ共有ファイルID();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.get主治医医療機関コード();
    }

    /**
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 意見書作成依頼日を返します。
     *
     * @return 意見書作成依頼日
     */
    public FlexibleDate get意見書作成依頼日() {
        return entity.get主治医意見書作成依頼年月日();
    }

    /**
     * 主治医意見書依頼区分を返します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.get主治医意見書依頼区分();
    }

    /**
     * 主治医意見書作成依頼履歴番号を返します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public int get主治医意見書作成依頼履歴番号() {
        return entity.get主治医意見書作成依頼履歴番号();
    }

    /**
     * 主治医意見書情報を返します。
     *
     * @return 主治医意見書情報
     */
    public List<DbT5302ShujiiIkenshoJohoEntity> get主治医意見書情報() {
        return new ArrayList<>(entity.get主治医意見書情報());
    }

    @Override
    public FlexibleDate get認定申請日() {
        return entity.get認定申請年月日();
    }

    @Override
    public boolean matches指定申請日() {
        return entity.isMatches指定申請日();
    }

    @Override
    public KoroshoIfShikibetsuCode get厚労省IF識別コード() {
        return KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード());
    }

    @Override
    public boolean had論理削除() {
        return entity.is論理削除フラグ();
    }

    @Override
    public boolean had一次判定() {
        return isTrue(entity.get仮一次判定区分());
    }

    @Override
    protected boolean had依頼() {
        return isValid(entity.get意見書作成依頼完了日());
    }

    @Override
    protected RString get依頼名() {
        return IRAI_NAME;
    }

    /**
     * {@link ImageinputRelate}生成時の処理状況を持ちます。
     */
    @lombok.Getter
    public static class Context implements RelatedDataBase.IContext {

        private final List<IOcrData> ocrData;
        private final TreatmentWhenIchijiHanteiZumi 一次判定済時処理;

        /**
         * @param ocrData 対応する{@link IOcrData}すべて
         * @param 一次判定済時処理 {@link TreatmentWhenIchijiHanteiZumi}
         */
        public Context(Collection<? extends IOcrData> ocrData, TreatmentWhenIchijiHanteiZumi 一次判定済時処理) {
            this.ocrData = Collections.unmodifiableList(new ArrayList<>(ocrData));
            this.一次判定済時処理 = 一次判定済時処理;
        }
    }

    /**
     * @param context {@link Context}
     * @return {@link IProcessingResults}
     */
    public IProcessingResults validate(Context context) {
        return super.validate(context);
    }
}
