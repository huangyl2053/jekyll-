/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 審査会資料に作成に関連する情報を保持します。
 *
 * 全ページ共通のパラメータとして渡すので、クラス拡張時にセッターを設けないこと。
 * (処理途中で値が変更されると予期せぬ不具合になりかねません。)
 */
public final class ShinsakaiShiryoContext {

    private static final RString PRINT_IIN_GAIKYO_TOKKI = new RString("1");
    private final boolean printsGaikyoTokkiIin;

    /**
     * インスタンスを生成します。関連する業務コンフィグがあれば取得します。
     */
    public ShinsakaiShiryoContext() {
        this.printsGaikyoTokkiIin = PRINT_IIN_GAIKYO_TOKKI.equals(
                BusinessConfig.get(
                        ConfigNameDBE.介護認定審査会資料_委員用_概況特記出力有無,
                        SubGyomuCode.DBE認定支援)
        );
    }

    /**
     * @return 委員用概況特記を出力する場合、{@code true}
     */
    public boolean prints委員用概況特記() {
        return this.printsGaikyoTokkiIin;
    }

}
