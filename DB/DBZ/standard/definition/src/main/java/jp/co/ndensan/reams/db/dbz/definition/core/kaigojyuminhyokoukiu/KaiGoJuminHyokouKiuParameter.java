/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.kaigojyuminhyokoukiu;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 介護住民票個別事項連携情報作成【広域運用】のバッチのパラメータです。
 *
 * @reamsid_L DBU-0550-020 wanghui
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class KaiGoJuminHyokouKiuParameter {

    private final List<RString> 市町村コード;
    private final RString 被保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード List<RString>
     * @param 被保険者番号 RString
     */
    private KaiGoJuminHyokouKiuParameter(
            List<RString> 市町村コード,
            RString 被保険者番号) {

        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param 市町村コード List<RString>
     * @param 被保険者番号 RString
     * @return 広域運用識別コード情報の検索パラメータ
     */
    public static KaiGoJuminHyokouKiuParameter createParam_common(
            List<RString> 市町村コード,
            RString 被保険者番号) {
        return new KaiGoJuminHyokouKiuParameter(市町村コード, 被保険者番号);
    }

}
