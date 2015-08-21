/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.definition.valueobject.NinteichosaIraiRirekiNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査特記事項を表すクラスです。
 *
 * @author n8178 城間篤人
 */
public class NinteichosaTokkijiko {

    private final ShinseishoKanriNo 申請書管理番号;
    private final NinteichosaIraiRirekiNo 認定調査依頼履歴番号;
    //TODO n8178 城間篤人 認定調査項目を表すクラスが実装された後、それと置き換え予定 2014年2月末
    private final RString 認定調査特記事項番号;
    private final Code 原本マスク区分;
    private final RString 特記事項;

    /**
     * 引数からメンバを受け取るコンストラクタです。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 原本マスク区分 原本マスク区分
     * @param 特記事項 特記事項
     * @throws NullPointerException 申請書管理番号、認定調査依頼履歴番号、認定調査特記事項番号にnullが渡されたとき
     */
    public NinteichosaTokkijiko(ShinseishoKanriNo 申請書管理番号, NinteichosaIraiRirekiNo 認定調査依頼履歴番号, RString 認定調査特記事項番号,
            Code 原本マスク区分, RString 特記事項)
            throws NullPointerException {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("申請書管理番号", getClass().getName()));
        requireNonNull(認定調査依頼履歴番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査依頼履歴番号", getClass().getName()));
        requireNonNull(認定調査特記事項番号, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("認定調査特記事項番号", getClass().getName()));
        requireNonNull(原本マスク区分, UrSystemErrorMessages.引数がnullのため生成不可.getReplacedMessage("原本マスク区分", getClass().getName()));

        this.申請書管理番号 = 申請書管理番号;
        this.認定調査依頼履歴番号 = 認定調査依頼履歴番号;
        this.認定調査特記事項番号 = 認定調査特記事項番号;
        this.原本マスク区分 = 原本マスク区分;
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
     * 原本マスク区分を返します。
     *
     * @return 原本マスク区分
     */
    public Code get原本マスク区分() {
        return 原本マスク区分;
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
