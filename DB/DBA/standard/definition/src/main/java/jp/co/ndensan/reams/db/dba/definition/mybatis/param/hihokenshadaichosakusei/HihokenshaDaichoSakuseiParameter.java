/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 被保険者台帳パラメータクラスです。
 *
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaDaichoSakuseiParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final HihokenshaNo hihokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param shichonCode 識別コード
     * @param hihokenshaNo 被保険者番号
     *
     */
    private HihokenshaDaichoSakuseiParameter(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     * @return 被保険者台帳検索パラメータ
     */
    public static HihokenshaDaichoSakuseiParameter createSelectByKeyParam(
            ShikibetsuCode shikibetsuCode,
            HihokenshaNo hihokenshaNo) {
        return new HihokenshaDaichoSakuseiParameter(shikibetsuCode, hihokenshaNo);
    }
}
