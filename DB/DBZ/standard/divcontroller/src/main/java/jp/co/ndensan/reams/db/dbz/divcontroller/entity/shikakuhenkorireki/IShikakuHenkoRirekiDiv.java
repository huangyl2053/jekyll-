package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 共有子Div「資格変更履歴」において、配置先の親Divで実行可能な処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShikakuHenkoRirekiDiv {

    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、その結果をグリッドに設定します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     */
    void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号);

    /**
     * 資格変更異動について、グリッドの表示項目設定などの初期化処理を行います。
     */
    void initialize();

    /**
     * 入力明細エリアの情報を初期化します。
     */
    void clearInputData();

    /**
     * 共有子Divが持つ資格関連異動の履歴を取得する。
     *
     * @return 被保険者台帳List
     */
    IItemList<HihokenshaDaichoModel> get資格関連異動履歴();

    /**
     * 共有子Divに、資格関連異動の履歴を設定する。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    void set資格関連異動履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List);
}
