/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshojissekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojissekiichiran.IkenshoJissekiIchiranRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成実績集計表のビジネスクラスです。
 *
 * @reamsid_L DBE-1690-010 dongyabin
 */
public class IkenshoJissekiIchiran {

    private final IkenshoJissekiIchiranRelateEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書作成実績集計表情報
     */
    public IkenshoJissekiIchiran(IkenshoJissekiIchiranRelateEntity entity) {
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
     * 医療機関コードを取得します。
     *
     * @return 医療機関コード
     */
    public RString get医療機関コード() {
        return entity.get医療機関コード();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.get医療機関名称();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.get主治医氏名();
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
     * 申請者氏名を取得します。
     *
     * @return 申請者氏名
     */
    public RString get申請者氏名() {
        return entity.get申請者氏名();
    }

    /**
     * 記入日を取得します。
     *
     * @return 記入日
     */
    public RString get記入日() {
        return entity.get記入日();
    }

    /**
     * 入手日を取得します。
     *
     * @return 入手日
     */
    public RString get入手日() {
        return entity.get入手日();
    }

    /**
     * 在宅_施設区分を取得します。
     *
     * @return 在宅_施設区分
     */
    public RString get在宅_施設区分() {
        return entity.get在宅_施設区分();
    }

    /**
     * 主治医意見書依頼区分を取得します。
     *
     * @return 主治医意見書依頼区分
     */
    public RString get主治医意見書依頼区分() {
        return entity.get主治医意見書依頼区分();
    }

    /**
     * 医師区分コードを取得します。
     *
     * @return 医師区分コード
     */
    public RString get医師区分コード() {
        return entity.get医師区分コード();
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
     * 主治医意見書作成依頼履歴番号を取得します。
     *
     * @return 主治医意見書作成依頼履歴番号
     */
    public RString get主治医意見書作成依頼履歴番号() {
        return entity.get主治医意見書作成依頼履歴番号();
    }

    /**
     * 主治医コードを取得します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.get主治医コード();
    }

}
