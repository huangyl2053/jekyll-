/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaichosakusei;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * @author soft863
 */
@lombok.Getter
@lombok.Setter
public class HihokenshaDaichoSakuseiParameter {

    private ShikibetsuCode shikibetsuCode;
    private HihokenshaNo hihokenshaNo;

    /**
     * コンストラクタです。
     *
     * @param shichonCode shichonCode
     * @param usesshichonCode usesshichonCode
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private HihokenshaDaichoSakuseiParameter(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {

	this.shikibetsuCode = shikibetsuCode;
	this.hihokenshaNo = hihokenshaNo;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param shikibetsuCode
     * @param hihokenshaNo
     * @return 身体手帳検索パラメータ
     */
    public static HihokenshaDaichoSakuseiParameter createSelectByKeyParam(
	    ShikibetsuCode shikibetsuCode,
	    HihokenshaNo hihokenshaNo) {

	return new HihokenshaDaichoSakuseiParameter(shikibetsuCode,
		hihokenshaNo
	);
    }
}
