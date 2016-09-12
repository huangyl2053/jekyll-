package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 * @reamsid_L DBE-3000-190 hezhenzhen
 */
public interface INinteiShinseishaKihonInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 共有子Divの初期化を行います。
     *
     * @param 申請書管理番号 申請書管理番号
     */
    void initialize(ShinseishoKanriNo 申請書管理番号);

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    RString get被保険者番号();
}
