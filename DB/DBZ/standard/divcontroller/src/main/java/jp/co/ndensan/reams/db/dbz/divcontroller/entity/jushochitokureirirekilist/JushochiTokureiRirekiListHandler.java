/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.ViewExecutionStatus;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.jushochitokureirirekilist.util.JushochiTokureiExecutionStatus;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoCondition;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.JushochiTokureiTekiyoDateCondition;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.model.util.function.ICondition;
import jp.co.ndensan.reams.db.dbz.model.util.optional.IOptional;
import jp.co.ndensan.reams.ur.urz.divcontroller.helper.PanelSessionAccessor;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 共有子Div「住所地特例履歴」の状態を変更するクラスです。
 *
 * @author n8178 城間篤人
 */
public class JushochiTokureiRirekiListHandler {

    private final JushochiTokureiRirekiListDiv jutokuRirekiDiv;
    private static final RString PANEL_SESSION_ACCESSOR_KEY = new RString("jushochiTokureiRireki");

    /**
     * コンストラクタです。
     *
     * @param jutokuRirekiDiv 住所地特例履歴ListDiv
     */
    public JushochiTokureiRirekiListHandler(JushochiTokureiRirekiListDiv jutokuRirekiDiv) {
        this.jutokuRirekiDiv = jutokuRirekiDiv;
    }

    /**
     * 共有子Divが持つ住所地特例処理モードを元に、適切な明細入力モードを設定します。
     */
    public void setMeisaiInputMode() {
        JushochiTokureiExecutionStatus jutokuExeStatus
                = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());

        switch (jutokuExeStatus) {
            case Tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoInput);
                break;
            case Kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoInput);
                break;
            case Teisei:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiInput);
                break;
        }
    }

    /**
     * 共有子Divが持つ住所地特例処理モードを元に、適切な明細照会モードを設定します。
     */
    public void setMeisaiShokaiMode() {
        JushochiTokureiExecutionStatus jutokuExeStatus
                = JushochiTokureiExecutionStatus.toValue(jutokuRirekiDiv.getJushochiTokureiExecutionState());

        switch (jutokuExeStatus) {
            case Tekiyo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.tekiyoShokai);
                break;
            case Kaijo:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.kaijoShokai);
                break;
            case Teisei:
                jutokuRirekiDiv.setMode_MeisaiDisplayMode(JushochiTokureiRirekiListDiv.MeisaiDisplayMode.teiseiShokai);
                break;
        }
    }

    /**
     * グリッド上から選択した住所地特例異動の情報を、明細エリアに表示します。
     */
    public void showSelectedData() {
        dgJutoku_Row row = jutokuRirekiDiv.getDgJutoku().getClickedItem();
        final HihokenshaDaichoModel conditionModel = new HihokenshaDaichoModel();
        conditionModel.set適用年月日(row.getTekiyoDate().getValue());
        ICondition condition = new JushochiTokureiTekiyoDateCondition(conditionModel);

        IItemList<HihokenshaDaichoModel> jutokuList = get被保険者台帳情報();
        IItemList<HihokenshaDaichoModel> jutokuTekiyoKikan = jutokuList.filter(condition);

    }

    /**
     * 引数から受け取るグリッドの1行分のデータを、明細エリアに対して設定します。
     *
     * @param row 明細エリアに表示したいグリッドの行
     */
    public void clearInputData(dgJutoku_Row row) {
    }

    /**
     * Divに登録されている被保険者台帳Listの情報を取得します。
     *
     * @return 被保険者台帳List
     */
    public IItemList<HihokenshaDaichoModel> get被保険者台帳情報() {
        IItemList<HihokenshaDaichoModel> 被保険者台帳List
                = ItemList.of(PanelSessionAccessor.get(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, ArrayList.class));
        return 被保険者台帳List;
    }

    /**
     * 引数から受け取った被保険者台帳Listの情報をDivに登録します。
     *
     * @param 被保険者台帳List 被保険者台帳List
     */
    public void set被保険者台帳情報(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        PanelSessionAccessor.put(jutokuRirekiDiv, PANEL_SESSION_ACCESSOR_KEY, (ArrayList) 被保険者台帳List.asList());
    }

    /**
     * Divに登録されている被保険者台帳情報から、住所地特例についての情報を抽出してグリッドにマッピングします。
     */
    public void mapping住所地特例履歴() {
        IItemList<HihokenshaDaichoModel> 被保険者台帳List = get被保険者台帳情報();
//        IItemList<HihokenshaDaichoModel> 住所地特例List = new HihokenshaDaichoList().get住所地特例List();

        List<dgJutoku_Row> dataSource = new ArrayList<>();
        for (HihokenshaDaichoModel model : 被保険者台帳List) {
            dgJutoku_Row row = new dgJutoku_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(),
                    RString.EMPTY, RString.EMPTY, new TextBoxFlexibleDate(), new TextBoxFlexibleDate(), RString.EMPTY,
                    RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxDate());

            row.setState(getModelStateValue(model));
            row.setShichosonCode(model.get市町村コード().getColumnValue());
            row.setHihokenshaNo(model.get被保険者番号().getColumnValue());
            row.setShoriTimestamp(model.get処理日時().toDateString());
            row.getTekiyoDate().setValue(model.get適用年月日());
            row.getTekiyoTodokedeDate().setValue(model.get適用届出年月日());
            row.setTekiyoJiyuKey(model.get住所地特例適用事由コード().getColumnValue().value());
            row.setTekiyoJiyu(model.get住所地特例適用事由コード().getRyakusho());
            row.getKaijoDate().setValue(FlexibleDate.MAX);
            row.getKaijoTodokedeDate().setValue(FlexibleDate.MAX);
            row.setKaijoJiyuKey(model.get住所地特例解除事由コード().getColumnValue().value());
            row.setKaijoJiyu(model.get住所地特例解除事由コード().getRyakusho());
            row.setSochimotoHokensha(model.get広住特措置元市町村コード().getColumnValue());
            row.setKyuHokensha(model.get旧市町村コード().getColumnValue());
            row.getShoriDate().setValue((model.getEntity().getLastUpdateTimestamp().getDate()));
            dataSource.add(row);
        }
        jutokuRirekiDiv.getDgJutoku().setDataSource(dataSource);
    }

    /**
     * 明細パネルに入力されている情報と、自身が持つ住所地特例情報の最新履歴を元に、登録データを生成します。
     *
     * @return 登録データ
     */
    public HihokenshaDaichoModel createEntryData() {
        //TODO #55852
        //1)、履歴の最新情報を元に、被保険者台帳Modelを作成する。
        //2)、明細に入力した内容で、1)で作成した被保険者台帳Modelを更新する。
        //3)、生成したModelを返却する。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private RString getModelStateValue(HihokenshaDaichoModel model) {
        switch (model.getState()) {
            case Added:
                return new RString("追加");
            case Modified:
                return new RString("修正");
            case Deleted:
                return new RString("削除");
            default:
                return new RString("");
        }
    }

    private void setTekiyoInputMeisai(HihokenshaDaichoModel model) {
        jutokuRirekiDiv.getTxtTekiyoDate().setValue(model.get適用年月日());
        jutokuRirekiDiv.getTxtTekiyoTodokedeDate().setValue(model.get適用届出年月日());
        jutokuRirekiDiv.getDdlTekiyoJiyu().setSelectedItem(model.get住所地特例適用事由コード().value().getColumnValue());
        jutokuRirekiDiv.getDdlTekiyojiSochimotoHokensha().setSelectedItem(model.get広住特措置元市町村コード().value());
        jutokuRirekiDiv.getDdlTekiyojiKyuHokensha().setSelectedItem(model.get旧市町村コード().value());
        //TODO n8178 城間篤人 宛名データの取得方を考える（DBから？宛名情報を引数から受け取って？）。とりあえず後で。 2014年12月11日まで
        jutokuRirekiDiv.getDdlTekiyojiJuminJoho();
    }

    private void setKaijoInputMeisai(HihokenshaDaichoModel model) {
        jutokuRirekiDiv.getTxtKaijoDate().setValue(model.get解除年月日());
        jutokuRirekiDiv.getTxtKaijoTodokedeDate().setValue(model.get解除届出年月日());
        jutokuRirekiDiv.getDdlKaijoJiyu().setSelectedItem(model.get住所地特例解除事由コード().value().getColumnValue());
        jutokuRirekiDiv.getDdlKaijojiSochimotoHokensha().setSelectedItem(model.get広住特措置元市町村コード().getColumnValue());
        jutokuRirekiDiv.getDdlKaijojiKyuHokensha().setSelectedItem(model.get旧市町村コード().getColumnValue());
        //TODO n8178 城間篤人 宛名データの取得方を考える（DBから？宛名情報を引数から受け取って？）。とりあえず後で。 2014年12月11日まで
        jutokuRirekiDiv.getDdlKaijojiJuminJono();
    }
}
