/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteichosakekkatorikomiocr;

import jp.co.ndensan.reams.db.dbe.business.core.ocr.IProcessingResult;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiMessages;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.ProcessingResultFactory;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosakekkatorikomiocr.NinteiChosaKekkaTorikomiOcrRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.KoroshoIfShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査結果取込み関連データのビジネスクラスです。
 *
 * @reamsid_L DBE-1540-010 dongyabin
 */
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiOcrRelate {

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
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * @return 被保険者カナ
     */
    public RString get被保険者カナ() {
        return entity.get被保険者カナ();
    }

    /**
     * @return 論理削除済みの場合、{@code true}.
     */
    public boolean has論理削除() {
        return entity.is論理削除フラグ();
    }

    /**
     * @return 検索時に指定した申請日と合致する場合、{@code true}.それ以外の場合、{@code false}.
     */
    public boolean matches指定申請日() {
        return entity.isMatches指定申請日();
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.get保険者();
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
     * 厚労省IF識別コードを取得します。
     *
     * @return 厚労省IF識別コード
     */
    public KoroshoIfShikibetsuCode get厚労省IF識別コード() {
        return KoroshoIfShikibetsuCode.toValue(entity.get厚労省IF識別コード());
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
     * @return {@link IProcessingResult}
     */
    public IProcessingResult validate() {
        if (get厚労省IF識別コード() == KoroshoIfShikibetsuCode.認定ｿﾌﾄ2009_SP3) {
            return ProcessingResultFactory.error(OcrTorikomiMessages.過去制度での申請);
        }
        if (!matches指定申請日()) {
            if (has論理削除()) {
                return ProcessingResultFactory.error(OcrTorikomiMessages.有効な要介護認定申請なし);
            }
            return ProcessingResultFactory.error(
                    OcrTorikomiMessages.申請日一致なし_直近申請日提示.replaced(
                            entity.get認定申請日().seireki().toDateString().toString()
                    )
            );
        }
        if (has論理削除()) {
            return ProcessingResultFactory.error(OcrTorikomiMessages.削除された申請);
        }
        return ProcessingResultFactory.success();
    }
}
