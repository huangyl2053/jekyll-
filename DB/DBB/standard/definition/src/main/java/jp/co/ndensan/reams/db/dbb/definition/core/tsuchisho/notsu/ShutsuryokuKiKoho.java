package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 出力期候補クラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShutsuryokuKiKoho {

    private Kitsuki 期月;
    private RString 表示文字列;
    private List<Kitsuki> 出力期リスト;
}
