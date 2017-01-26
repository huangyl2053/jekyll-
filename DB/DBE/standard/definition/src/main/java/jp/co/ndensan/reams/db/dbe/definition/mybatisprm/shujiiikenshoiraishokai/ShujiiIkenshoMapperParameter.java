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

    private final RString hihokenshaNo;
    private final RString shokisaiHokenshaNo;
    private final RString 通常 = ShoriJotaiKubun.通常.getコード();
    private final RString 延期 = ShoriJotaiKubun.延期.getコード();

    private ShujiiIkenshoMapperParameter(RString hihokenshaNo, RString shokisaiHokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
        this.shokisaiHokenshaNo = shokisaiHokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param shokisaiHokenshaNo 証記載保険者番号
     * @return 主治医意見書作成依頼情報パラメータ
     */
    public static ShujiiIkenshoMapperParameter createParam(RString hihokenshaNo, RString shokisaiHokenshaNo) {
        return new ShujiiIkenshoMapperParameter(hihokenshaNo, shokisaiHokenshaNo);
    }
}
