/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC4510011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.KubunShikyuGendogakuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4510011.dgServiceShurui_Row;
import jp.co.ndensan.reams.db.dbx.business.core.kaigoserviceshurui.kaigoserviceshurui.KaigoServiceShurui;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * サービス種類登録Handlerです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuHandler {

    private final KubunShikyuGendogakuDiv div;

    private KubunShikyuGendogakuHandler(KubunShikyuGendogakuDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div div
     * @return DvNinkaShisetsuJigyoshoDaichoHandler
     */
    public static KubunShikyuGendogakuHandler of(KubunShikyuGendogakuDiv div) {
        return new KubunShikyuGendogakuHandler(div);
    }

    /**
     * 画面初期化処理です。
     *
     * @param businessList businessList
     */
    public void initializeDgList(List<KaigoServiceShurui> businessList) {
        List<dgServiceShurui_Row> lists = new ArrayList<>();
        for (KaigoServiceShurui result : businessList) {
            dgServiceShurui_Row row = new dgServiceShurui_Row();
            row.setDefaultDataName1(result.toEntity().getServiceShuruiCd().getColumnValue());
            if (result.toEntity().getTeikyoKaishiYM() != null) {
                row.setDefaultDataName2(result.toEntity().getTeikyoKaishiYM().wareki()
                        .firstYear(FirstYear.ICHI_NEN).toDateString());
            }
            if (result.toEntity().getTeikyoshuryoYM() != null) {
                row.setDefaultDataName3(result.toEntity().getTeikyoshuryoYM().wareki()
                        .firstYear(FirstYear.ICHI_NEN).toDateString());
            }
            if (result.toEntity().getServiceShuruiMeisho() != null) {
                row.setDefaultDataName4(result.toEntity().getServiceShuruiMeisho());
            }
            row.setDefaultDataName5(result.toEntity().getServiceShuruiRyakusho());
            row.setDefaultDataName6(result.toEntity().getServiceBunrruicode().getColumnValue().concat(RString.EMPTY));
            lists.add(row);
        }
        div.getDgServiceShurui().setDataSource(lists);
    }

    /**
     * Dgdの修正ボタンの選択された内容処理です。
     *
     * @param row dgServiceShurui_Row
     */
    public void modify(dgServiceShurui_Row row) {
        div.getServiceShuruiShousai().getTxtServiceCode().setValue(row.getDefaultDataName1());
        div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().setValue(new RDate(row.getDefaultDataName2().toString()));
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setValue(new RDate(row.getDefaultDataName3().toString()));
        div.getServiceShuruiShousai().getTxtServiceMeisho().setValue(row.getDefaultDataName4());
        div.getServiceShuruiShousai().getTxtServiceRyakusho().setValue(row.getDefaultDataName5());
        //div.getServiceShuruiShousai().getDdlServiceBunruiCode().setSelectedKey(row.getDefaultDataName6().substring(0, 2));
    }

    /**
     * DgdのボタンクリックDisable。
     *
     */
    public void setDisable() {
        div.getBtnTsuika().setDisabled(true);
        List<dgServiceShurui_Row> dataSource = div.getDgServiceShurui().getDataSource();
        for (dgServiceShurui_Row row : dataSource) {
            row.setDeleteButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
        }
    }

    /**
     * DgdのボタンクリックEnabled。
     *
     */
    public void setEnable() {
        div.getBtnTsuika().setDisabled(false);
        List<dgServiceShurui_Row> dataSource = div.getDgServiceShurui().getDataSource();
        for (dgServiceShurui_Row row : dataSource) {
            row.setDeleteButtonState(DataGridButtonState.Enabled);
            row.setModifyButtonState(DataGridButtonState.Enabled);
        }
    }

    /**
     * 画面初期化のメソッドます。
     *
     * @param boo Boolean
     */
    public void setServiceShuruiShousaiEnable(boolean boo) {
        div.getServiceShuruiShousai().getTxtServiceCode().setDisabled(boo);
        div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().setDisabled(boo);
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setDisabled(boo);
        div.getServiceShuruiShousai().getTxtServiceMeisho().setDisabled(boo);
        div.getServiceShuruiShousai().getTxtServiceRyakusho().setDisabled(boo);
        div.getServiceShuruiShousai().getDdlServiceBunruiCode().setDisabled(boo);
    }

    /**
     * 画面初期化のメソッドます。
     *
     */
    public void clearValue() {
        div.getServiceShuruiShousai().getTxtServiceCode().clearValue();
        div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().clearValue();
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().clearValue();
        div.getServiceShuruiShousai().getTxtServiceMeisho().clearValue();
        div.getServiceShuruiShousai().getTxtServiceRyakusho().clearValue();
        div.getServiceShuruiShousai().getDdlServiceBunruiCode().setSelectedIndex(0);
    }

}
