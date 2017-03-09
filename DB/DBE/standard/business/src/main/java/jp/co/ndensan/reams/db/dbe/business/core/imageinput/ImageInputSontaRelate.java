/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.imageinput;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.RelatedDataBase;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.imageinput.ImageInputSontaRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * その他資料取込時に参照します。ひとつの申請に関連するデータを保持します。
 */
public class ImageInputSontaRelate extends RelatedDataBase {

    private static final RString IRAI_NAME = new RString("認定調査や、主治医意見書の作成");
    private final ImageInputSontaRelateEntity entity;

    /**
     * @param entity {@link ImageInputSontaRelateEntity}
     */
    public ImageInputSontaRelate(ImageInputSontaRelateEntity entity) {
        this.entity = entity;
    }

    @Override
    protected FlexibleDate get認定申請日() {
        return this.entity.getNinteiShinseiYMD();
    }

    @Override
    protected boolean matches指定申請日() {
        return this.entity.isMatchesShiteiShinseiYMD();
    }

    @Override
    protected KoroshoIfShikibetsuCode get厚労省IF識別コード() {
        return KoroshoIfShikibetsuCode.toValue(this.entity.getKoroshoIfShikibetsuCode());
    }

    @Override
    protected boolean had論理削除() {
        return this.entity.isLogicalDeletedFlag();
    }

    @Override
    protected boolean had一次判定() {
        return isFalse(this.entity.getKariIchijiHanteiKubun());
    }

    @Override
    protected boolean had二次判定() {
        return isValid(entity.getNinteiShinsakaiKanryoYMD());
    }

    @Override
    public RString get被保険者氏名() {
        return this.entity.getHihokenshaName();
    }

    @Override
    public RString get被保険者カナ() {
        return this.entity.getHihokenshaKana();
    }

    @Override
    protected boolean had依頼() {
        return isValid(this.entity.getIkenshoSakuseiIraiKanryoYMD()) || isValid(this.entity.getNinteichosaIraiKanryoYMD());
    }

    @Override
    protected RString get依頼名() {
        return IRAI_NAME;
    }

    /**
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return this.entity.getShinseishoKanriNo();
    }

    /**
     * @return 証記載保険者番号
     */
    public ShoKisaiHokenshaNo get証記載保険者番号() {
        return this.entity.getShoKisaiHokenshaNo();
    }

    /**
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return this.entity.getHihokenshaNo();
    }

    /**
     * @return 共有ファイルID. または、{@code null}
     */
    public RDateTime getSharedFileIDOrNull() {
        return this.entity.getImageSharedFileId();
    }

    /**
     * {@link ImageinputRelate}生成時の処理状況を持ちます。
     */
    @lombok.Getter
    public static final class Context implements RelatedDataBase.IContext {

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
