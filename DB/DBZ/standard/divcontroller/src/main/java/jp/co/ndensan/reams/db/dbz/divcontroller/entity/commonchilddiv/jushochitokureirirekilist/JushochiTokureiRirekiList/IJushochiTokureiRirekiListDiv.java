package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.jushochitokureirirekilist.JushochiTokureiRirekiList;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 */
public interface IJushochiTokureiRirekiListDiv extends ICommonChildDivBaseProperties {

    /**
     * 入力明細エリアを初期化します。
     */
    void clearInputData();

    /**
     * 住所地特例履歴Divについて、市町村情報が「広域/合併有り」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>処理ステータスの設定</li>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）に引数から指定した項目を設定</li>
     * <li>措置元保険者DDL・旧保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     *
     * @param 被保険者番号
     * @param 識別コード
     * @param 取得日
     */
    void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日);

    /**
     * 住所地特例履歴Divについて、市町村情報が「広域/合併有り」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>処理ステータスの設定</li>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）に引数から指定した項目を設定</li>
     * <li>措置元保険者DDL・旧保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     *
     * @param dataSource
     */
    void initialize(List<dgJutoku_Row> dataSource);

    /**
     * 明細パネルの表示モードを設定します。<br/>
     * 以下のモードが設定できます。
     * <ul>
     * <li>適用・照会 : tekiyoShokai</li>
     * <li>解除・照会 : kaijoShokai</li>
     * <li>訂正・照会 : teiseiShokai</li>
     * <li>適用・登録 : tekiyoInput</li>
     * <li>解除・登録 : kaijoInput</li>
     * <li>訂正・登録 : teiseiInput</li>
     * <li>非表示 : displayNone</li>
     * </ul>
     *
     * @param displayMode MeisaiDisplayMode
     */
    void setMeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode displayMode);

    /**
     * 追加ボタンの表示/非表示を設定します。<br/>
     * 以下のモードが設定できます。
     * <ul>
     * <li>表示 : SetDisplay</li>
     * <li>非表示 : SetDisplayNone</li>
     * </ul>
     *
     * @param displayMode BtnDisplayMode
     */
    void setAddButtonDisplay(JushochiTokureiRirekiListDiv.BtnDisplayMode displayMode);

    /**
     * 共有子Divの表示タイプを設定します。<br/>
     * 以下のモードが設定できます。
     * <ul>
     * <li>照会 : shokai</li>
     * <li>登録 : toroku</li>
     * <li>訂正登録 : teiseitoroku</li>
     * </ul>
     *
     * @param displayType DisplayType
     */
    void setDisplayType(JushochiTokureiRirekiListDiv.DisplayType displayType);

    /**
     * 住所地特例履歴Listが内部で保持している履歴情報が、変更されているかどうかを返します。
     *
     * @return 履歴情報が変更されている場合はtrue、されていない場合はfalse
     */
    boolean hasChanged();

    JutokuInputDiv getJutokuInput();

    /**
     * 住所地特例グリッド上を返す。
     *
     * @return 住所地特定グリッド
     */
    DataGrid<dgJutoku_Row> getDgJutoku();

    List<HihokenshaDaicho> getDataList();
}
