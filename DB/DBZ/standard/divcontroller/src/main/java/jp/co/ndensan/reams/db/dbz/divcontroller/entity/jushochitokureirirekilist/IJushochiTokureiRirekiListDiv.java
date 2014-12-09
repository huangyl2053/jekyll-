package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;

/**
 * 共有子Div「住所地特例履歴」において、配置先の親Divで実行可能な処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 */
public interface IJushochiTokureiRirekiListDiv {

    /**
     * 住所地特例履歴が持つ、被保険者台帳情報を取得します。
     *
     * @return 被保険者台帳履歴List
     */
    IItemList<HihokenshaDaichoModel> get住所地特例異動履歴();

    /**
     * 住所地特例履歴に対して、引数から被保険者台帳情報を設定します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    void set住所地特例異動履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List);

    /**
     * 入力明細エリアを初期化します。
     */
    void clearInputData();

    /**
     * 住所地特例履歴Divについて、市町村情報が「単一市町村/合併無し」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）ににTanitsuGappeiNashiを設定</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     */
    void initializeTanitsuGappeiNashi();

    /**
     * 住所地特例履歴Divについて、市町村情報が「単一市町村/合併有り」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）にTanitshGappeiAriを設定</li>
     * <li>旧保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     */
    void initializeTanitsuGappeiAri();

    /**
     * 住所地特例履歴Divについて、市町村情報が「広域/合併無し」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）にKoikiGappeiNashiを設定</li>
     * <li>措置元保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     */
    void initializeKoikiGappeiNashi();

    /**
     * 住所地特例履歴Divについて、市町村情報が「広域/合併有り」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）にKoikiGappeiAriを設定</li>
     * <li>措置元保険者DDL・旧保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     */
    void initializeKoikiGappeiAri();

    /**
     * 明細パネルが変更されたかどうかを判定します。 <br/>
     * 追加を行う場合は、明細行の内容が全て空白で無ければtrueを返します。<br/>
     * 修正を行う場合は、明細行の内容が書き換えられている場合にtrueを返します。
     *
     * @return 明細パネルの内容が変更されていたらtrue
     */
    boolean isChangedMeisai();

    /**
     * 明細パネルに入力されている情報と、自身が持つ住所地特例情報の最新履歴を元に、登録データを生成します。
     *
     * @return 登録データ
     */
    HihokenshaDaichoModel createEntryData();
}
