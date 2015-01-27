package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;

import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv.BtnDisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv.DisplayType;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.JushochiTokureiRirekiListDiv.MeisaiDisplayMode;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IAtenaShokaiSimpleDiv;

/**
 * 共有子Div「住所地特例履歴」において、配置先の親Divで実行可能な処理を定義したインターフェースです。
 *
 * @author n8178 城間篤人
 *
 */
public interface IJushochiTokureiRirekiListDiv {

    /**
     * 住所地特例履歴によって更新された、被保険者台帳情報を取得します。
     *
     * @return 被保険者台帳履歴List
     */
    IItemList<HihokenshaDaichoModel> get被保険者台帳情報();

    /**
     * 住所地特例履歴に対して、引数から被保険者台帳情報を設定します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    void set被保険者台帳情報(IItemList<HihokenshaDaichoModel> 被保険者台帳List);

    /**
     * 共有子Divに登録された被保険者台帳情報から、住所地特例情報を抽出してグリッドに対してマッピングします。
     */
    void mapping住所地特例履歴();

    /**
     * 入力明細エリアを初期化します。
     */
    void clearInputData();

    /**
     * 住所地特例履歴Divについて、市町村情報が「広域/合併有り」である場合の初期設定を行います。<br/>
     * 初期設定を行う項目は以下のとおりです。
     * <ul>
     * <li>保険者情報表示モード（HikenshaJohoDisplayMode）に引数から指定した項目を設定</li>
     * <li>措置元保険者DDL・旧保険者DDLの選択項目の設定（選択項目の候補を市町村情報から取得）</li>
     * <li>適用事由DDL・解除事由DDLの選択項目の設定（コードマスタからの取得）</li>
     * </ul>
     *
     * @param mode 保険者情報表示モード
     */
    void initialize(JushochiTokureiRirekiListDiv.HokenshaJohoDisplayMode mode);

    /**
     * 明細パネルが変更されたかどうかを判定します。 <br/>
     * 追加を行う場合は、明細行の内容が全て空白で無ければtrueを返します。<br/>
     * 修正を行う場合は、明細行の内容が書き換えられている場合にtrueを返します。
     *
     * @return 明細パネルの内容が変更されていたらtrue
     */
    boolean hasChangedInMeisai();

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
    void setMeisaiDisplayMode(MeisaiDisplayMode displayMode);

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
    void setAddButtonDisplay(BtnDisplayMode displayMode);

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
    void setDisplayType(DisplayType displayType);

    /**
     * 住所地特例履歴Listが内部で保持している履歴情報が、変更されているかどうかを返します。
     *
     * @return 履歴情報が変更されている場合はtrue、されていない場合はfalse
     */
    boolean hasChanged();

}
