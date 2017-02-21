/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.RelatedDataBase;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IOcrData;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResults;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.TreatmentWhenIchijiHanteiZumi;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果取込み関連データのビジネスクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiOcrRelate extends RelatedDataBase {

    private static final RString IRAI_NAME = new RString("認定調査");
    private final NinteiChosaKekkaTorikomiOcrRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity イメージ取込み関連データRelateEntity
     */
    public NinteiOcrRelate(NinteiChosaKekkaTorikomiOcrRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return entity.get証記載保険者番号();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.get被保険者番号();
    }

    /**
     * 申請区分を取得します。
     *
     * @return 申請区分
     */
    public RString get申請区分() {
        return entity.get申請区分();
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.get申請書管理番号();
    }

    /**
     * 申請書翰林番号を{@link ShinseishoKanriNo}型で返します。
     *
     * @return 申請書翰林番号({@link ShinseishoKanriNo}型)
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return new ShinseishoKanriNo(get申請書管理番号());
    }

    /**
     * 認定調査依頼履歴番号を取得します。
     *
     * @return 認定調査依頼履歴番号
     */
    public int get認定調査依頼履歴番号() {
        return entity.get認定調査依頼履歴番号();
    }

    /**
     * イメージ共有ファイルIDを取得します。
     *
     * @return イメージ共有ファイルID
     */
    public RDateTime getイメージ共有ファイルID() {
        if (entity.getイメージ共有ファイルID() != null) {
            return entity.getイメージ共有ファイルID();
        } else {
            return RDateTime.MIN;
        }
    }

    /**
     * @return イメージ共有ファイルID.もしくは{@code null}.
     */
    public RDateTime getImageSharedFileIDOrNull() {
        return entity.getイメージ共有ファイルID();
    }

    /**
     * イメージ情報が存在する場合{@code true}、しない場合{@code false}を返します。
     *
     * @return イメージ情報が存在する場合{@code true}、しない場合{@code false}.
     */
    public boolean hasイメージ情報() {
        return entity.getイメージ共有ファイルID() != null;
    }

    /**
     * 認定調査委託先コードを取得します。
     *
     * @return 認定調査委託先コード
     */
    public RString get認定調査委託先コード() {
        return entity.get認定調査委託先コード();
    }

    /**
     * 認定調査員コードを取得します。
     *
     * @return 認定調査員コード
     */
    public RString get認定調査員コード() {
        return entity.get認定調査員コード();
    }

    /**
     * 認定調査依頼区分コードを取得します。
     *
     * @return 認定調査依頼区分コード
     */
    public Code get認定調査依頼区分コード() {
        return entity.get認定調査依頼区分コード();
    }

    /**
     * 認定調査回数を取得します。
     *
     * @return 認定調査回数
     */
    public int get認定調査回数() {
        return entity.get認定調査回数();
    }

    /**
     * @return 認定調査の依頼日
     */
    public FlexibleDate get調査依頼日() {
        return entity.get認定調査依頼日();
    }

    @Override
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    @Override
    public RString get被保険者カナ() {
        return entity.get被保険者カナ();
    }

    @Override
    protected FlexibleDate get認定申請日() {
        return entity.get認定申請日();
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
        return isFalse(entity.get仮一次判定区分());
    }

    @Override
    protected boolean had依頼() {
        return isValid(entity.get認定調査依頼完了日());
    }

    @Override
    protected RString get依頼名() {
        return IRAI_NAME;
    }

    /**
     * {@link NinteiOcrRelate}生成時の処理状況を持ちます。
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
