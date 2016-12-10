/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshoiraishokai;

import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼情報のパラメータクラス。
 *
 * @reamsid_L DBE-0200-030 zhangzhiming
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShujiiIkenshoMapperParameter {

    private final RString shinseishoKanriNo;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private ShujiiIkenshoMapperParameter(RString shinseishoKanriNo) {
        this.shinseishoKanriNo = shinseishoKanriNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 主治医意見書作成依頼情報パラメータ
     */
    public static ShujiiIkenshoMapperParameter createParam(RString shinseishoKanriNo) {
        return new ShujiiIkenshoMapperParameter(shinseishoKanriNo);
    }
}
