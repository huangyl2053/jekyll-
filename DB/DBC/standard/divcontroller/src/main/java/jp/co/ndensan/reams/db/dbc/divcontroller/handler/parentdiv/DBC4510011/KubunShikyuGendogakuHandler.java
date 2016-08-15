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
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * サービス種類登録Handlerです。
 *
 * @reamsid_L DBC-3350-010 jiangzongyue
 */
public class KubunShikyuGendogakuHandler {

    private final KubunShikyuGendogakuDiv div;
    private static final RString 入力前の状態に戻る = new RString("btnReset");

    /**
     * コンストラクタです。
     *
     * @param div KubunShikyuGendogakuDiv
     */
    public KubunShikyuGendogakuHandler(KubunShikyuGendogakuDiv div) {
        this.div = div;
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
            FlexibleYearMonth teikyoshuryoYM = result.toEntity().getTeikyoshuryoYM();
            if (teikyoshuryoYM != null) {
                row.setDefaultDataName3(teikyoshuryoYM.wareki()
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
        if (!row.getDefaultDataName3().isNullOrEmpty()) {
            div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setValue(new RDate(row.getDefaultDataName3().toString()));
        }
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
     * @param flag Boolean
     */
    public void setServiceShuruiShousaiEnable(boolean flag) {
        div.getServiceShuruiShousai().getTxtServiceCode().setDisabled(flag);
        div.getServiceShuruiShousai().getTxtTeikyoKaishiYM().setDisabled(flag);
        div.getServiceShuruiShousai().getTxtTeikyoShuryoYM().setDisabled(flag);
        div.getServiceShuruiShousai().getTxtServiceMeisho().setDisabled(flag);
        div.getServiceShuruiShousai().getTxtServiceRyakusho().setDisabled(flag);
        div.getServiceShuruiShousai().getDdlServiceBunruiCode().setDisabled(flag);
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

    /**
     * 画面初期化のメソッドます。
     *
     * @param flag boolean
     */
    public void setCommonButtonVisible(boolean flag) {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(入力前の状態に戻る, flag);
    }

    /**
     * 追加のメソッドます。
     *
     * @param result KaigoServiceShurui
     * @return KaigoServiceShurui
     */
    public KaigoServiceShurui setResult追加(KaigoServiceShurui result) {
        return result.createBuilderForEdit()
                .setサービス種類名称(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue())
                .setサービス分類コード(Code.EMPTY)
                .setサービス種類略称(div.getServiceShuruiShousai().getTxtServiceRyakusho().getValue())
                .set提供終了年月(new FlexibleYearMonth(div.getServiceShuruiShousai()
                                .getTxtTeikyoShuryoYM().getValue().getYearMonth().toDateString()))
                .set居宅サービス区分(RString.EMPTY)
                .set基準該当サービス区分(RString.EMPTY)
                .set限度額区分(RString.EMPTY)
                .set指定サービス区分(RString.EMPTY)
                .setIsDeleted(false)
                .build();
    }

    /**
     * 修正のメソッドます。
     *
     * @param result KaigoServiceShurui
     * @return KaigoServiceShurui
     */
    public KaigoServiceShurui setResult修正(KaigoServiceShurui result) {
        return result.createBuilderForEdit()
                .setサービス種類名称(div.getServiceShuruiShousai().getTxtServiceMeisho().getValue())
                .setサービス分類コード(Code.EMPTY)
                .setサービス種類略称(div.getServiceShuruiShousai().getTxtServiceRyakusho().getValue())
                .set提供終了年月(new FlexibleYearMonth(div.getServiceShuruiShousai()
                                .getTxtTeikyoShuryoYM().getValue().getYearMonth().toDateString()))
                .setIsDeleted(false)
                .build();
    }

}
