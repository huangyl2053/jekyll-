/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;

/**
 * 認定調査特記事項を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijiko {

    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
    private final RString 認定調査特記事項番号;
    private final RString 特記事項;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 特記事項 特記事項
     * @throws NullPointerException 申請書管理番号、認定調査依頼履歴番号、認定調査特記事項番号にnullが渡されたとき
     */
    public NinteichosaTokkijiko(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号, RString 認定調査特記事項番号, RString 特記事項)
            throws NullPointerException {
        requireNonNull(申請書管理番号, Messages.E00003.replace("申請書管理番号", getClass().getName()).getMessage());
        requireNonNull(認定調査依頼履歴番号, Messages.E00003.replace("認定調査依頼履歴番号", getClass().getName()).getMessage());
        requireNonNull(認定調査特記事項番号, Messages.E00003.replace("認定調査特記事項番号", getClass().getName()).getMessage());

        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.認定調査特記事項番号 = 認定調査特記事項番号;
        this.特記事項 = 特記事項;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return 申請書管理番号;
    }

    /**
     * 認定調査依頼履歴番号を返します。
     *
     * @return 認定調査依頼履歴番号
     */
    public NinteichosaIraiRirekiNo get認定調査依頼履歴番号() {
        return 認定調査依頼履歴番号;
    }

    /**
     * 認定調査特記事項番号を返します。
     *
     * @return 認定調査特記事項番号
     */
    public RString get認定調査特記事項番号() {
        return 認定調査特記事項番号;
    }

    /**
     * 特記事項を返します。
     *
     * @return 特記事項
     */
    public RString get特記事項() {
        return 特記事項;
    }
}
