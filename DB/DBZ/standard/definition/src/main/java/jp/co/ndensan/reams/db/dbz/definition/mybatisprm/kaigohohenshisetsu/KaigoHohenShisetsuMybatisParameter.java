/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigohohenshisetsu;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 施設情報の検索条件。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KaigoHohenShisetsuMybatisParameter {

    private final ShikibetsuCode shikibetsuCode;
    private final RString 入所施設種類;
    private final RString 入所施設コード;
    private final int 履歴番号;
    
    /**
     * コンストラクタです。
     *
     * @param shikibetsuCode 識別コード
     * @param 入所施設種類 入所施設種類
     * @param 入所施設コード 入所施設コード
     * @param 履歴番号 履歴番号
     */
    public KaigoHohenShisetsuMybatisParameter(ShikibetsuCode shikibetsuCode, RString 入所施設種類, RString 入所施設コード, int 履歴番号) {
        this.shikibetsuCode = shikibetsuCode;
        this.入所施設種類 = 入所施設種類;
        this.入所施設コード = 入所施設コード;
        this.履歴番号 = 履歴番号;
    }
}
