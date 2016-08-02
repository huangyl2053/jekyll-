/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SeikatsuhogoDetail;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.seikatsuhogorireki.SeikaatsuhogoDataModel;
import jp.co.ndensan.reams.ur.urz.definition.core.codemaster.URZCodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 生活保護明細のhandlerクラスです。
 *
 * @reamsid_L DBZ-4510-010 xuyannan
 */
public class SeikatsuhogoDetailHandler {

    private static final RString 表示モード_新規 = new RString("新規");
    private static final RString 表示モード_修正 = new RString("修正");
    private static final RString 表示モード_削除 = new RString("削除");
    private static final RString 表示モード_照会 = new RString("照会");
    private static final RString 介護保険料代理納付区分 = new RString("代理納付有");
    private static final RString 該当 = new RString("gaito");
    private static final RString 非該当 = new RString("higaito");
    private static final RString 入退所区分_未該当 = new RString("未該当");
    private static final RString 入退所区分_入所 = new RString("入所");
    private static final RString 入退所区分_退所 = new RString("退所");
    private static final RString 状態 = new RString("txtJotai");
    private static final RString 受給停止開始日 = new RString("txtTeishiKaishiYMD");
    private static final RString 受給停止終了日 = new RString("txtTeishiShuryoYMD");
    private static final String 連結 = "／";
    private static final String カラ = "～";
    private final SeikatsuhogoDetailDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 生活保護明細div
     */
    public SeikatsuhogoDetailHandler(SeikatsuhogoDetailDiv div) {
        this.div = div;
    }

    /**
     * 生活保護明細ダイアログを表示します。
     *
     * @param 生活保護受給Object 生活保護受給情報
     */
    public void onLoad(SeikaatsuhogoDataModel 生活保護受給Object) {
        set初期化状態(生活保護受給Object.get表示モード());
        div.getTxtJukyushaNo().setValue(nullTOEmpty(生活保護受給Object.get受給者番号()));
        div.getTxtJukyuKaishiYMD().setValue(生活保護受給Object.get受給開始日());
        div.getTxtJukyuHaishiYMD().setValue(生活保護受給Object.get受給廃止日());
        div.getRadDairinofuKubun().setSelectedKey(介護保険料代理納付区分.equals(生活保護受給Object.get納付区分())
                ? 該当 : 非該当);
        div.getTxtDainoNofuYM().setValue(生活保護受給Object.get納付年月());
        if (!RString.isNullOrEmpty(生活保護受給Object.get入退所区分())) {
            if (入退所区分_未該当.equals(生活保護受給Object.get入退所区分())) {
                div.getRadNyutaishoKubun().setSelectedValue(入退所区分_未該当);
            } else {
                div.getRadNyutaishoKubun().setSelectedValue(生活保護受給Object.get入退所区分());
            }
        }
        if (生活保護受給Object.get入所日() == null || RString.isNullOrEmpty(生活保護受給Object.get入所日().toDateString())) {
            div.getTxtNyutaishoYMD().setValue(生活保護受給Object.get退所日());
        } else {
            div.getTxtNyutaishoYMD().setValue(生活保護受給Object.get入所日());
        }
        RString 扶助種類コード = 生活保護受給Object.get扶助種類コード();
        if (!RString.isNullOrEmpty(扶助種類コード)) {
            List<RString> 無連結扶助種類コード = 扶助種類コード.split(連結);
            List<RString> 扶助種類KEY = new ArrayList<>();
            for (KeyValueDataSource dataSource : div.getChkFujoShurui().getDataSource()) {
                for (RString コード : 無連結扶助種類コード) {
                    if (dataSource.getValue().equals(CodeMaster.getCodeMeisho(SubGyomuCode.URZ業務共通_共通系,
                            URZCodeShubetsu.扶助種類コード.getCodeShubetsu(), new Code(コード),
                            new FlexibleDate(RDate.getNowDate().toDateString())))) {
                        扶助種類KEY.add(dataSource.getKey());
                        break;
                    }
                }
                div.getChkFujoShurui().setSelectedItemsByKey(扶助種類KEY);
            }
        }
        if (!RString.isNullOrEmpty(生活保護受給Object.get受給停止期間())
                && !new RString(カラ).equals(生活保護受給Object.get受給停止期間())) {
            List<RString> 受給停止期間 = 生活保護受給Object.get受給停止期間().split(連結);
            List<RString> 停止終了日 = new ArrayList<>();
            boolean 識別 = true;
            for (RString 停止期間 : 受給停止期間) {
                dgTeishiRireki_Row dataRow = new dgTeishiRireki_Row();
                if (識別) {
                    if (停止期間.contains(カラ)) {
                        dataRow.getTxtTeishiKaishiYMD().setValue(new RDate(停止期間.split(カラ).get(0).toString()));
                        停止終了日.add(停止期間.split(カラ).get(1));
                        識別 = false;
                    } else {
                        dataRow.getTxtTeishiKaishiYMD().setValue(new RDate(停止期間.toString()));
                    }
                    div.getDgTeishiRireki().getDataSource().add(dataRow);
                } else {
                    停止終了日.add(停止期間);
                }
            }
            for (int i = 0; i < div.getDgTeishiRireki().getDataSource().size(); i++) {
                div.getDgTeishiRireki().getDataSource().get(i).getTxtTeishiShuryoYMD().setValue(new RDate(停止終了日.get(i).toString()));
            }
        }
    }

    /**
     * 生活保護停止期間明細エリアのテータを編集します。
     *
     * @param 表示モード 表示モード
     */
    public void データ編集(RString 表示モード) {
        if (表示モード_新規.equals(表示モード)) {
            div.getTeishiKikanInput().setDisabled(false);
            div.setHdnHyoujiMode(表示モード);
        } else if (表示モード_照会.equals(表示モード)) {
            set編集(表示モード);
        } else if (表示モード_修正.equals(表示モード)) {
            div.getTeishiKikanInput().setDisabled(false);
            set編集(表示モード);
        } else {
            set編集(表示モード);
        }
    }

    /**
     * 「明細を取消する」を押します。
     */
    public void onbtn_DetailAirCancel() {
        div.getTxtJukyushaNo().clearValue();
        div.getTxtJukyuKaishiYMD().clearValue();
        div.getTxtJukyuHaishiYMD().clearValue();
        div.getRadDairinofuKubun().clearSelectedItem();
        div.getTxtDainoNofuYM().clearValue();
        div.getRadNyutaishoKubun().clearSelectedItem();
        div.getTxtNyutaishoYMD().clearValue();
        div.getChkFujoShurui().getSelectedItems().clear();
        div.setHdnHyoujiMode(RString.EMPTY);
        div.getTxtTeishiKaishiYMD().clearValue();
        div.getTxtTeishiShuryoYMD().clearValue();
    }

    /**
     * 「明細を確定する」を押します。
     */
    public void onbtn_DetailAirOK() {
        SeikaatsuhogoDataModel dataModel = new SeikaatsuhogoDataModel();
        dataModel.set表示モード(div.getHdnMainHyoujiMode());
        dataModel.set受給者番号(div.getTxtJukyushaNo().getValue());
        dataModel.set受給開始日(div.getTxtJukyuKaishiYMD().getValue());
        dataModel.set受給廃止日(div.getTxtJukyuHaishiYMD().getValue());
        dataModel.set納付区分(div.getRadDairinofuKubun().getSelectedValue());
        dataModel.set納付年月(div.getTxtDainoNofuYM().getValue());
        dataModel.set入退所区分(div.getRadNyutaishoKubun().getSelectedValue());
        if (入退所区分_入所.equals(div.getRadNyutaishoKubun().getSelectedValue())) {
            dataModel.set入所日(div.getTxtNyutaishoYMD().getValue());
        } else if (入退所区分_退所.equals(div.getRadNyutaishoKubun().getSelectedValue())) {
            dataModel.set退所日(div.getTxtNyutaishoYMD().getValue());
        }
        RStringBuilder shuruiCode = new RStringBuilder();
        RStringBuilder shurui = new RStringBuilder();
        for (KeyValueDataSource dataSource : div.getChkFujoShurui().getSelectedItems()) {
            shuruiCode.append(dataSource.getKey());
            shuruiCode.append(連結);
            shurui.append(dataSource.getValue());
            shurui.append(連結);
        }
        dataModel.set扶助種類(shurui.toRString().remove(shurui.length() - 1));
        dataModel.set扶助種類コード(shuruiCode.toRString().remove(shurui.length() - 1));
        div.setHdnDataPass(DataPassingConverter.serialize(dataModel));
    }

    /**
     * （生活保護停止期間明細エリア）取消する」を押します。
     */
    public void onbtn_Cancel() {
        div.getTxtTeishiKaishiYMD().clearValue();
        div.getTxtTeishiShuryoYMD().clearValue();
        div.getTeishiKikanInput().setDisabled(true);
    }

    /**
     * 「（生活保護停止期間明細エリア）確定する」を押します。
     *
     * @param 表示モード 表示モード
     */
    public void onbtn_OK(RString 表示モード) {
        if (表示モード_新規.equals(表示モード)) {
            dgTeishiRireki_Row row = new dgTeishiRireki_Row();
            row.setTxtJotai(div.getHdnHyoujiMode());
            row.getTxtTeishiKaishiYMD().setValue(div.getTxtTeishiKaishiYMD().getValue());
            row.getTxtTeishiShuryoYMD().setValue(div.getTxtTeishiShuryoYMD().getValue());
            div.getDgTeishiRireki().getDataSource().add(row);
            onbtn_Cancel();
        } else if (表示モード_修正.equals(表示モード)) {
            div.getDgTeishiRireki().getClickedItem().setTxtJotai(表示モード);
            div.getDgTeishiRireki().getClickedItem().getTxtTeishiKaishiYMD().setValue(div.getTxtTeishiKaishiYMD().getValue());
            div.getDgTeishiRireki().getClickedItem().getTxtTeishiShuryoYMD().setValue(div.getTxtTeishiShuryoYMD().getValue());
            onbtn_Cancel();
        } else if (表示モード_削除.equals(表示モード)) {
            div.getDgTeishiRireki().getDataSource().remove(div.getDgTeishiRireki().getClickedRowId());
            onbtn_Cancel();
        }
    }

    private void set編集(RString 表示モード) {
        div.setHdnHyoujiMode(表示モード);
        div.getTxtTeishiKaishiYMD().setValue(div.getDgTeishiRireki().getClickedItem().getTxtTeishiKaishiYMD().getValue());
        div.getTxtTeishiShuryoYMD().setValue(div.getDgTeishiRireki().getClickedItem().getTxtTeishiShuryoYMD().getValue());
    }

    private void set初期化状態(RString 表示モード) {
        div.setHdnMainHyoujiMode(表示モード);
        if (表示モード_新規.equals(表示モード) || 表示モード_修正.equals(表示モード)) {
            if (表示モード_修正.equals(表示モード)) {
                div.getTxtJukyuKaishiYMD().setDisabled(true);
            }
            div.getDgTeishiRireki().getGridSetting().setIsShowSelectButtonColumn(false);
        } else if (表示モード_削除.equals(表示モード) || 表示モード_照会.equals(表示モード)) {
            div.getJukyuKikan().setDisabled(true);
            div.getHokenryoDairinofu().setDisabled(true);
            div.getKyugoShisetsu().setDisabled(true);
            div.getChkFujoShurui().setDisabled(true);
            if (表示モード_削除.equals(表示モード)) {
                div.getBtnTeishiRirekiAdd().setDisabled(true);
            } else {
                div.getBtnTeishiRirekiAdd().setVisible(false);
            }
            div.getDgTeishiRireki().getGridSetting().setIsShowModifyButtonColumn(false);
            div.getDgTeishiRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
            div.getDgTeishiRireki().getGridSetting().getColumn(状態).setVisible(false);
            div.getDgTeishiRireki().getGridSetting().getColumn(受給停止開始日).getCellDetails().setDisabled(true);
            div.getDgTeishiRireki().getGridSetting().getColumn(受給停止終了日).getCellDetails().setDisabled(true);
        }
        div.getTeishiKikanInput().setDisabled(true);
    }

    private RString nullTOEmpty(RString 項目) {
        if (RString.isNullOrEmpty(項目)) {
            return RString.EMPTY;
        }
        return 項目;
    }
}
