/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shujiiikenshoiraishokai;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
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

    private final HihokenshaNo hihokenshaNo;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private ShujiiIkenshoMapperParameter(HihokenshaNo hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param hihokenshaNo HihokenshaNo
     * @return 主治医意見書作成依頼情報パラメータ
     */
    public static ShujiiIkenshoMapperParameter createParam(HihokenshaNo hihokenshaNo) {
        return new ShujiiIkenshoMapperParameter(hihokenshaNo);
    }
}
