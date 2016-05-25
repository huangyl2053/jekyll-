package jp.co.ndensan.reams.db.dba.business.report.hihokenshadaichohakkoichiranhyo;

import java.util.List;
import lombok.Getter;

/**
 * 被保険者台帳一覧表情報クラスです。
 *
 * @reamsid_L DBA-0510-070 wangxiaodong
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class HihokenshaDaichoHakkoIchiranhyoJoho {

    private final HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem;
    private final List<HihokenshaDaichoHakkoIchiranhyoBodyItem> bodyItemList;

    /**
     * インスタンスを生成します。
     *
     * @param headerItem 被保険者台帳一覧表ボディーItemクラス
     * @param bodyItemList 被保険者台帳一覧表ボディーItemクラス
     */
    public HihokenshaDaichoHakkoIchiranhyoJoho(
            HihokenshaDaichoHakkoIchiranhyoHeaderItem headerItem,
            List<HihokenshaDaichoHakkoIchiranhyoBodyItem> bodyItemList
    ) {
        this.headerItem = headerItem;
        this.bodyItemList = bodyItemList;
    }
}
