/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.chosahyojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.chosahyojissekiichiran.ChosahyoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票出力用認定調査実績集計表のReportSourceクラスです。
 *
 * @reamsid_L DBE-1691-010 dangjingjing
 */
public class ChosahyoJissekiIchiran {

    private final ChosahyoJissekiIchiranRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 帳票出力用認定調査実績集計表情報
     */
    public ChosahyoJissekiIchiran(ChosahyoJissekiIchiranRelateEntity entity) {
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
     * 調査委託先コードを取得します。
     *
     * @return 調査委託先コード
     */
    public RString get調査委託先コード() {
        return entity.get調査委託先コード();
    }

    /**
     * 事業者名称を取得します。
     *
     * @return 事業者名称
     */
    public RString get事業者名称() {
        return entity.get事業者名称();
    }

    /**
     * 調査員コードを取得します。
     *
     * @return 調査員コード
     */
    public RString get調査員コード() {
        return entity.get調査員コード();
    }

    /**
     * 調査員氏名を取得します。
     *
     * @return 調査員氏名
     */
    public RString get調査員氏名() {
        return entity.get調査員氏名();
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
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.get被保険者氏名();
    }

    /**
     * 認定調査実施年月日を取得します。
     *
     * @return 認定調査実施年月日
     */
    public RString get認定調査実施年月日() {
        return entity.get認定調査実施年月日();
    }

    /**
     * 認定調査区分コードを取得します。
     *
     * @return 認定調査区分コード
     */
    public RString get認定調査区分コード() {
        return entity.get認定調査区分コード();
    }

    /**
     * 認定調査実施場所名称を取得します。
     *
     * @return 認定調査実施場所名称
     */
    public RString get認定調査実施場所名称() {
        return entity.get認定調査実施場所名称();
    }

    /**
     * 認定調査依頼区分コードを取得します。
     *
     * @return 認定調査依頼区分コード
     */
    public RString get認定調査依頼区分コード() {
        return entity.get認定調査依頼区分コード();
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
     * 認定調査依頼履歴番号を取得します。
     *
     * @return 認定調査依頼履歴番号
     */
    public RString get認定調査依頼履歴番号() {
        return entity.get認定調査依頼履歴番号();
    }

}
