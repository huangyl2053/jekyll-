package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 共有子Div「住所地特例履歴List」において、配置先の親Divで実行可能な処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IJushochiTokureiRirekiListDiv {

    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、検索結果をグリッドに設定する。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     */
    void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号);

    /**
     * 住所地特例履歴Listが持つ、被保険者台帳情報を取得します。
     *
     * @return 被保険者台帳履歴List
     */
    IItemList<HihokenshaDaichoModel> get住所地特例異動履歴();

    /**
     * 住所地特例履歴Listに対して、引数から被保険者台帳情報を設定します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    void set住所地特例異動履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List);

    /**
     * 入力明細エリアを初期化します。
     */
    void clearInputData();

    /**
     * 住所地特例履歴Listについて、グリッド表示項目の設定などの初期設定を行います。
     *
     * @param 市町村コード 市町村コード
     */
    void initialize(LasdecCode 市町村コード);
}
