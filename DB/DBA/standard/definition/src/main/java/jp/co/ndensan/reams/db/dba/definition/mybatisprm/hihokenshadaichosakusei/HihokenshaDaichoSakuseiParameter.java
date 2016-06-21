/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 被保険者台帳パラメータクラスです。
 *
 * @reamsid_L DBA-0500-010 suguangjun
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class HihokenshaDaichoSakuseiParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final HihokenshaNo hihokenshaNo;
    private final boolean useshihokenshaNo;
    private final JigyoshaNo nyushoShisetsuCode;

    /**
     * コンストラクタです。
     *
     * @param shichonCode 識別コード
     * @param hihokenshaNo 被保険者番号
     *
     */
    private HihokenshaDaichoSakuseiParameter(ShikibetsuCode shikibetsuCode,
            HihokenshaNo hihokenshaNo,
            boolean useshihokenshaNo,
            JigyoshaNo nyushoShisetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
        this.hihokenshaNo = hihokenshaNo;
        this.useshihokenshaNo = useshihokenshaNo;
        this.nyushoShisetsuCode = nyushoShisetsuCode;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     * @param nyushoShisetsuCode 入所施設コード
     * @return 被保険者台帳検索パラメータ
     */
    public static HihokenshaDaichoSakuseiParameter createSelectByKeyParam(
            ShikibetsuCode shikibetsuCode,
            HihokenshaNo hihokenshaNo,
            JigyoshaNo... nyushoShisetsuCode
    ) {
        boolean useshihokenshaNo = false;
        if (hihokenshaNo != null && !hihokenshaNo.isEmpty()) {
            useshihokenshaNo = true;
        }
        JigyoshaNo jigyoshaNo = JigyoshaNo.EMPTY;
        if (nyushoShisetsuCode != null && nyushoShisetsuCode.length > 0) {
            jigyoshaNo = nyushoShisetsuCode[0];
        }

        return new HihokenshaDaichoSakuseiParameter(shikibetsuCode,
                hihokenshaNo,
                useshihokenshaNo,
                jigyoshaNo
        );
    }
}
