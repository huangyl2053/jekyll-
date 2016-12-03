/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.shujiiiryokikanandshujiiguide;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiguide.ShujiiIryokikanAndShujii;
import jp.co.ndensan.reams.db.dbz.business.core.shujiiiryokikanandshujiiinput.ShujiiIryokikanandshujiiDataPassModel;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanAndShujiiGuide.ShujiiIryokikanAndShujiiGuide.dgKensakuKekkaIchiran_Row;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 主治医医療機関＆主治医ガイドのHandlerクラスです。
 *
 * @reamsid_L DBZ-1300-130 xuyannan
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
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (dataPassModel != null) {
            div.setHdnDatabaseSubGyomuCode(dataPassModel.getサブ業務コード());
        }
        div.getKensakuKekkaIchiran().getDgKensakuKekkaIchiran().setDataSource(null);
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
            for (int i = 0; i < list.size(); i++) {
                ShujiiIryokikanAndShujii business = list.get(i);
                dgKensakuKekkaIchiran_Row kensakuKekkaIchiran_Row = new dgKensakuKekkaIchiran_Row();
                kensakuKekkaIchiran_Row.getIryoKikancode().setValue(nullToEmpty(business.get主治医医療機関コード()));
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
                kensakuKekkaIchiran_Row.setIryoKikanYubinBango(business.get主治医医療機関情報_郵便番号());               
                kensakuKekkaIchiranGridList.add(kensakuKekkaIchiran_Row);
            }
        }
        div.getDgKensakuKekkaIchiran().setDataSource(kensakuKekkaIchiranGridList);
    }

    /**
     * 選択ボタンを押下します。
     */
    public void onSelectbtn() {
        RString model = new RString("");
        RString 市町村コード = new RString("");
        ShujiiIryokikanandshujiiDataPassModel dataPassModel = DataPassingConverter.deserialize(
                div.getHdnDataPass(), ShujiiIryokikanandshujiiDataPassModel.class);
        if (dataPassModel != null) {
            if (RString.isNullOrEmpty(dataPassModel.get市町村コード())) {
                市町村コード = div.getHokenshaList().getSelectedItem().get市町村コード().value();
            } else {
                市町村コード = dataPassModel.get市町村コード();
            }
            model = nullToEmpty(dataPassModel.get対象モード());
        }
        ShujiiIryokikanandshujiiDataPassModel newDataPassModel = new ShujiiIryokikanandshujiiDataPassModel();
        newDataPassModel.set市町村コード(市町村コード);
        newDataPassModel.setサブ業務コード(div.getHdnDatabaseSubGyomuCode());
        if (ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.IryoKikanMode.toString().equals(model.toString())) {
            newDataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikancode().getValue());
            newDataPassModel.set主治医医療機関名称(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanMeisho());
        } else if (ShujiiIryokikanAndShujiiGuideDiv.TaishoMode.ShujiiMode.toString().equals(model.toString())) {
            newDataPassModel.set主治医医療機関コード(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikancode().getValue());
            newDataPassModel.set主治医医療機関名称(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanMeisho());
            newDataPassModel.set主治医コード(div.getDgKensakuKekkaIchiran().getClickedItem().getShujiiCode().getValue());
            newDataPassModel.set主治医氏名(div.getDgKensakuKekkaIchiran().getClickedItem().getShujiiShimei());
        }
        newDataPassModel.set郵便番号(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanYubinBango());
        newDataPassModel.set住所(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikanjusho());
        newDataPassModel.set電話番号(div.getDgKensakuKekkaIchiran().getClickedItem().getIryoKikantelNo());
        
        div.setHdnDataPass(DataPassingConverter.serialize(newDataPassModel));
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
        div.getRadIryoKikanJokyo().setSelectedIndex(0);
        div.getRadShujiiJokyo().setSelectedIndex(0);
        div.getHokenshaList().loadHokenshaList(GyomuBunrui.介護認定);
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.
                get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
    }

    private RString nullToEmpty(RString obj) {
        if (obj == null) {
            return RString.EMPTY;
        }
        return obj;
    }
}
