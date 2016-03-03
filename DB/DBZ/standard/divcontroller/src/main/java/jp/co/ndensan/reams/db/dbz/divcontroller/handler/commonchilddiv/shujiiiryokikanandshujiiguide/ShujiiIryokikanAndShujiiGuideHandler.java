/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.dgKensakuKekkaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医医療機関＆主治医ガイドのHandlerクラスです。
 */
public class ShujiiIryokikanAndShujiiGuideHandler {

    private final ShujiiIryokikanAndShujiiGuideDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShujiiIryokikanAndShujiiGuideHandler(ShujiiIryokikanAndShujiiGuideDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     */
    public void intialize() {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (dataPassModel != null) {
            div.getTxtHokensha().setValue(dataPassModel.get市町村コード());
            div.setHdnDatabaseSubGyomuCode(dataPassModel.getサブ業務コード());
        }
        div.getKensakuKekkaIchiran().setVisible(false);
        clear(div);
    }

    /**
     * 検索条件をクリアします。
     */
    public void btnClear() {
        clear(div);
    }

    /**
     * 主治医医療機関＆主治医情報gridエリア。
     *
     * @param list 情報gridエリア内容
     */
    public void setDataGrid(List<ShujiiIryokikanAndShujii> list) {
        List<dgKensakuKekkaIchiran_Row> kensakuKekkaIchiranGridList = new ArrayList<>();
        if (!list.isEmpty()) {
            div.getKensakuKekkaIchiran().setVisible(true);
            for (int i = 0; i < list.size(); i++) {
                ShujiiIryokikanAndShujii business = list.get(i);
                dgKensakuKekkaIchiran_Row kensakuKekkaIchiran_Row = new dgKensakuKekkaIchiran_Row();
                kensakuKekkaIchiran_Row.getIryoKikancode().setValue(nullToEmpty(business.get医療機関コード()));
                kensakuKekkaIchiran_Row.setIryoKikanMeisho(nullToEmpty(business.get主治医医療機関名称()));
                kensakuKekkaIchiran_Row.setIryoKikanKanaMeisho(nullToEmpty(business.get主治医医療機関カナ()));
                kensakuKekkaIchiran_Row.setIryoKikanjusho(nullToEmpty(business.get主治医医療機関情報_住所()));
                kensakuKekkaIchiran_Row.setIryoKikantelNo(nullToEmpty(business.get主治医医療機関情報_電話番号()));
                kensakuKekkaIchiran_Row.setIryoKikanJokyo(business.is主治医医療機関情報_状況フラグ()
                        ? new RString("有効") : new RString("無効"));
                kensakuKekkaIchiran_Row.getShujiiCode().setValue(nullToEmpty(business.get主治医コード()));
                kensakuKekkaIchiran_Row.setShujiiShimei(nullToEmpty(business.get主治医氏名()));
                kensakuKekkaIchiran_Row.setShujiiKanaMeisho(nullToEmpty(business.get主治医カナ()));
                kensakuKekkaIchiran_Row.setShujiiJoukyo(business.is主治医情報_状況フラグ()
                        ? new RString("有効") : new RString("無効"));
                if (!business.is主治医医療機関情報_状況フラグ() || !business.is主治医情報_状況フラグ()) {
                    kensakuKekkaIchiran_Row.setRowBgColor(DataGridCellBgColor.bgColorGray);
                }
                kensakuKekkaIchiranGridList.add(kensakuKekkaIchiran_Row);
            }
            div.getDgKensakuKekkaIchiran().setDataSource(kensakuKekkaIchiranGridList);
        } else {
            div.getKensakuKekkaIchiran().setVisible(false);
        }
    }

    /**
     * 対象モードを設定します。
     */
    public void setModes() {
        if (!div.getTxtShuijiiCodeFrom().getValue().isEmpty()
                || !div.getTxtShujiiCodeTo().getValue().isEmpty()
                || !div.getTxtShujiiShimei().getValue().isEmpty()
                || !div.getTxtShujiiKanaShimei().getValue().isEmpty()) {
            div.setMode_TaishoMode(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.ShujiiMode);
        } else {
            div.setMode_TaishoMode(ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode);
        }
    }

    /**
     * 選択ボタンを押下します。
     */
    public void onSelectbtn() {
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        dataPassModel.set市町村コード(div.getTxtHokensha().getValue());
        dataPassModel.setサブ業務コード(div.getHdnDatabaseSubGyomuCode());
        if (ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode.equals(div.getMode_TaishoMode())) {
            dataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikancode().getValue());
            dataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanMeisho());
        } else {
            dataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikancode().getValue());
            dataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanMeisho());
            dataPassModel.set主治医コード(div.getDgKensakuKekkaIchiran().getClickedItem().getShujiiCode().getValue());
            dataPassModel.set主治医氏名(div.getDgKensakuKekkaIchiran().getClickedItem().getShujiiShimei());
        }
        div.setHdnDataPass(DataPassingConverter.serialize(dataPassModel));
    }

    private void clear(ShujiiIryokikanAndShujiiGuideDiv div) {
        div.getTxtIryoKikanCodeFrom().clearValue();
        div.getTxtIryoKikanCodeTo().clearValue();
        div.getTxtIryoKikanName().clearValue();
        div.getTxtIryoKikanKanaMeisho().clearValue();
        div.getTxtShuijiiCodeFrom().clearValue();
        div.getTxtShujiiCodeTo().clearValue();
        div.getTxtShujiiShimei().clearValue();
        div.getTxtShujiiKanaShimei().clearValue();
        div.getTxtMaxKensu().clearValue();
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
