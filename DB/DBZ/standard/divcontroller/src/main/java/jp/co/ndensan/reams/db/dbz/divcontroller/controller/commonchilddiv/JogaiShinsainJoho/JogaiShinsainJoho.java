/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.JogaiShinsainJoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiran;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinItiranData;
import jp.co.ndensan.reams.db.dbz.business.core.jogaishinsainjoho.ShinsakaiIinRelateJoho;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.JogaiShinsainJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShinsakaiIinIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.JogaiShinsainJoho.JogaiShinsainJoho.dgShozokuKikanIchiran_Row;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.parentdiv.JogaiShinsainJoho.JogaiShinsainJohoHandler;
import jp.co.ndensan.reams.db.dbz.service.core.jogaishinsainjoho.JogaiShinsainJohoFinder;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPair;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 除外審査員情報の画面処理クラスです。
 *
 * @reamsid_L DBE-1300-040 dongyabin
 */
public class JogaiShinsainJoho {

    private static final RString 追加 = new RString("追加");
    private static final RString 選択 = new RString("選択");
    private static final RString 所属機関_TMP = new RString("・");

    /**
     * 画面項目の初期化を行します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onLoad(JogaiShinsainJohoDiv div) {
        getHandler(div).画面項目にセットされている値をクリア();
        set画面情報(div);
        return ResponseData.of(div).respond();
    }

    /**
     * 新規追加します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClick_btnShinkiTsuika(JogaiShinsainJohoDiv div) {
        div.getShinsakaiIinJoho().setReadOnly(false);
        div.setHdnModel(追加);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員コードをBlurします。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onBlur_txtShinsakaiIinCode(JogaiShinsainJohoDiv div) {
        set所属機関一覧(div.getTxtShinsakaiIinCode().getValue(), div, true);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Grid選択ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onSelect_ShinsakaiIinIchiran(JogaiShinsainJohoDiv div) {
        div.setHdnModel(選択);
        RString 審査会委員コード = div.getDgShinsakaiIinIchiran().getActiveRow().getShinsakaiIinCode();
        set所属機関一覧(審査会委員コード, div, true);
        div.getTxtShinsakaiIinCode().setValue(審査会委員コード);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧Grid削除ボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClick_btnDelete(JogaiShinsainJohoDiv div) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getDgShinsakaiIinIchiran().getDataSource();
        rowList.remove(div.getDgShinsakaiIinIchiran().getClickedRowId());
        div.getDgShinsakaiIinIchiran().setDataSource(rowList);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員ガイドボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClose_btnShinsakaiIinGuide(JogaiShinsainJohoDiv div) {
        set所属機関一覧(div.getHdnShinsakaiIinCode(), div, false);
        div.getTxtShinsakaiIinName().setValue(div.getHdnShinsakaiIinName());
        return ResponseData.of(div).respond();
    }

    /**
     * 登録するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClick_btnToroku(JogaiShinsainJohoDiv div) {
        if (RString.isNullOrEmpty(div.getTxtShinsakaiIinCode().getValue())) {
            ValidationMessageControlPairs controlPairs = new ValidationMessageControlPairs();
            controlPairs.add(new ValidationMessageControlPair(JogaiShinsainJohoHandler.RRVMessages.未入力));
            return ResponseData.of(div).addValidationMessages(controlPairs).respond();
        }
        getHandler(div).onClick_btnToroku();
        return ResponseData.of(div).respond();
    }

    /**
     * 確定するボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClick_btnKakutei(JogaiShinsainJohoDiv div) {
        List<dgShinsakaiIinIchiran_Row> rowList = div.getDgShinsakaiIinIchiran().getDataSource();
        List<ShinsakaiIinItiran> shinsakaiIinItiranList = new ArrayList<>();
        for (dgShinsakaiIinIchiran_Row row : rowList) {
            ShinsakaiIinItiran shinsakaiIinItiran = new ShinsakaiIinItiran();
            shinsakaiIinItiran.setShimei(row.getShimei());
            shinsakaiIinItiran.setShinsakaiIinCode(row.getShinsakaiIinCode());
            shinsakaiIinItiran.setShozokuKikan(row.getShozokuKikan());
            shinsakaiIinItiranList.add(shinsakaiIinItiran);
        }
        ShinsakaiIinItiranData shinsakaiIinItiranBusiness = new ShinsakaiIinItiranData();
        shinsakaiIinItiranBusiness.setShinsakaiIinItiranList(shinsakaiIinItiranList);
        div.setHdnShinsakaiIinItiran(DataPassingConverter.serialize(shinsakaiIinItiranBusiness));
        return ResponseData.of(div).dialogOKClose();
    }

    /**
     * 戻るボタンを押します。
     *
     * @param div 画面情報
     * @return ResponseData<JogaiShinsainJohoDiv>
     */
    public ResponseData<JogaiShinsainJohoDiv> onClick_btnModoru(JogaiShinsainJohoDiv div) {
        return ResponseData.of(div).dialogNGClose();
    }

    private void set所属機関一覧(RString 審査会委員コード, JogaiShinsainJohoDiv div, boolean 氏名Flag) {
        List<ShinsakaiIinRelateJoho> johoList = getService().get審査会委員コードより審査会委員情報(審査会委員コード).records();
        List<dgShozokuKikanIchiran_Row> rowList = new ArrayList<>();
        RString 審査会委員氏名 = RString.EMPTY;
        div.getTxtShinsakaiIinCode().setValue(審査会委員コード);
        for (ShinsakaiIinRelateJoho joho : johoList) {
            審査会委員氏名 = joho.get介護認定審査会委員氏名().getColumnValue();
            RString 市町村コード = joho.get市町村コード();
            RString 市町村名称 = getService().get市町村名称(joho.get証記載保険者番号());
            RString 主治医医療機関コード = joho.get主治医医療機関コード();
            if (!RString.isNullOrEmpty(主治医医療機関コード)) {
                rowList.add(new dgShozokuKikanIchiran_Row(市町村名称, 主治医医療機関コード,
                        getService().get医療機関名称(市町村コード, 主治医医療機関コード)));
            }
            RString 認定調査委託先コード = joho.get認定調査委託先コード();
            if (!RString.isNullOrEmpty(認定調査委託先コード)) {
                rowList.add(new dgShozokuKikanIchiran_Row(市町村名称, 認定調査委託先コード,
                        getService().get事業者名称(市町村コード, 認定調査委託先コード)));
            }
            RString その他機関コード = joho.getその他機関コード();
            if (!RString.isNullOrEmpty(その他機関コード)) {
                rowList.add(new dgShozokuKikanIchiran_Row(市町村名称, その他機関コード,
                        getService().get機関名称(joho.get証記載保険者番号(), その他機関コード)));
            }
        }
        if (氏名Flag) {
            div.getTxtShinsakaiIinName().setValue(審査会委員氏名);
        }
        div.getDgShozokuKikanIchiran().setDataSource(rowList);
    }

    private void set画面情報(JogaiShinsainJohoDiv div) {
        RString 申請書管理番号 = div.getHdnShinseishoKanriNo();
        List<ShinsakaiIinRelateJoho> johoList = getService().get審査会委員一覧検索して審査会委員情報(申請書管理番号).records();
        List<dgShinsakaiIinIchiran_Row> rowList = new ArrayList<>();
        for (ShinsakaiIinRelateJoho joho : johoList) {
            RStringBuilder 所属機関 = new RStringBuilder();
            所属機関 = nullToEmpty(所属機関, getService().get医療機関名称(joho.get市町村コード(), joho.get主治医医療機関コード()));
            所属機関 = nullToEmpty(所属機関, getService().get事業者名称(joho.get市町村コード(), joho.get主治医医療機関コード()));
            所属機関 = nullToEmpty(所属機関, getService().get機関名称(joho.get証記載保険者番号(), joho.get主治医医療機関コード()));
            rowList.add(new dgShinsakaiIinIchiran_Row(joho.get介護認定審査会委員コード(), 申請書管理番号, 所属機関.toRString()));
        }
        div.getDgShinsakaiIinIchiran().setDataSource(rowList);
    }

    private RStringBuilder nullToEmpty(RStringBuilder 所属機関, RString 名称) {
        RStringBuilder sb = new RStringBuilder();
        if (!RString.isNullOrEmpty(名称)) {
            if (RString.isNullOrEmpty(所属機関.toRString())) {
                sb.append(名称);
            } else {
                sb.append(所属機関_TMP);
                sb.append(名称);
            }
        }
        return sb;
    }

    private JogaiShinsainJohoHandler getHandler(JogaiShinsainJohoDiv div) {
        return new JogaiShinsainJohoHandler(div);
    }

    private JogaiShinsainJohoFinder getService() {
        return JogaiShinsainJohoFinder.createInstance();
    }

}
