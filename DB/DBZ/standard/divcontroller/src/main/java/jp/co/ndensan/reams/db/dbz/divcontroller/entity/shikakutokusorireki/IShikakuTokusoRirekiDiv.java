package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 共有子Div「資格得喪履歴Div」において、外部に公開する処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IShikakuTokusoRirekiDiv {

    /**
     * 引数から渡されたキーを元に被保険者台帳テーブルから情報を取得し、その情報をグリッドに表示します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     */
    void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード);

    /**
     * 引数から渡されたキーを元に被保険者台帳テーブルから情報を取得し、その情報をグリッドに表示します。
     *
     * @param 市町村コード 市町村コード
     * @param 被保険者番号 被保険者番号
     */
    void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号);

    /**
     * 共有子Divが保持している、被保険者台帳の情報を取得します。
     *
     * @return 被保険者台帳List
     */
    IItemList<HihokenshaDaichoModel> get資格得喪履歴();

    /**
     * 共有子Divに対して、被保険者台帳の情報を設定します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    void set資格得喪履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List);

    /**
     * 資格得喪履歴ListDivについて、グリッド表示項目などの項目について初期化処理を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モードの設定（所在保険者・措置元保険者・旧保険者項目の表示非表示）</li>
     * </ul>
     *
     * @param 市町村コード 市町村コード
     */
    void initialize(LasdecCode 市町村コード);
}
