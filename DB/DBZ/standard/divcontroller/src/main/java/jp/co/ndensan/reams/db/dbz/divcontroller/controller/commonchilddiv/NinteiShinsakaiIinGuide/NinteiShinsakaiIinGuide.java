/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.controller.commonchilddiv.NinteiShinsakaiIinGuide;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideResult;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideMapperParameter;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuide.NinteiShinsakaiIinGuideDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideHandler;
import jp.co.ndensan.reams.db.dbz.service.core.ninteishinsakaiiinguide.NinteiShinsakaiIinGuideManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 認定審査会委員ガイドのDivControllerです
 *
 * @reamsid_L DBE-3000-030 lijia
 *
 */
public class NinteiShinsakaiIinGuide {

    private static final RString DATE_SOURCE_KEY0 = new RString("key0");
    private static final RString DATE_SOURCE_KEY1 = new RString("key1");

    /**
     * 介護宛名基本情報の初期化です。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onLoad(NinteiShinsakaiIinGuideDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 条件クリアボタンを押した時の処理をします。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onClick_btnClear(NinteiShinsakaiIinGuideDiv div) {
        getHandler(div).onLoad();
        return ResponseData.of(div).respond();
    }

    /**
     * 検索するボタンを押した時の処理を表します。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onClick_btnKensakku(NinteiShinsakaiIinGuideDiv div) {
        RString shinsakaiIinCodeFrom = div.getKensakuJoken().getTxtShinsakaiIinCodeFrom().getValue();
        RString shinsakaiIinCodeTo = div.getKensakuJoken().getTxtShinsakaiIinCodeTo().getValue();
        if (!shinsakaiIinCodeFrom.isEmpty() && !shinsakaiIinCodeTo.isEmpty() && shinsakaiIinCodeFrom.compareTo(shinsakaiIinCodeTo) > 0) {
            return ResponseData.of(div).addValidationMessages(getHandler(div).onClick_btnKensakku()).respond();
        }
        RString shinsakaiIinName = div.getKensakuJoken().getTxtShinsakaiIinName().getValue();
        RString seibetsu = div.getKensakuJoken().getDdlSeibetsu().getSelectedKey();
        ShoKisaiHokenshaNo hokensha = div.getKensakuJoken().getCcdHokensha().getSelectedItem().get証記載保険者番号();
        RString shinsainShikakuCode = div.getKensakuJoken().getDdlShinsainShikakuCode().getSelectedKey();
        RString iryoKikan = div.getKensakuJoken().getShosaiJoken().getDdlIryoKikan().getSelectedKey();
        RString kaigoJigyosha = div.getKensakuJoken().getShosaiJoken().getDdlKaigoJigyosha().getSelectedKey();
        RString sonotaJigyosha = div.getKensakuJoken().getShosaiJoken().getDdlSonotaJigyosha().getSelectedKey();
        Decimal maxKensu = div.getKensakuJoken().getTxtMaxKensu().getValue();
        if (maxKensu.intValue() > get最大取得件数上限().intValue()) {
            throw new ApplicationException("最大取得件数上限が超過しています。最大取得件数上限(" + get最大取得件数上限().intValue() + ")以下に調整してください。");
        }
        RString kikenFlag = getChkFlag(div.getKensakuJoken().getShosaiJoken().getChkKiken().getSelectedKeys());
        RString haishiFlag = getChkFlag(div.getKensakuJoken().getShosaiJoken().getChkHaishi().getSelectedKeys());
        NinteiShinsakaiIinGuideMapperParameter parameter;
        parameter = NinteiShinsakaiIinGuideMapperParameter.createSelectByKeyParam(
                shinsakaiIinCodeFrom,
                shinsakaiIinCodeTo,
                shinsakaiIinName == null ? AtenaMeisho.EMPTY : new AtenaMeisho(shinsakaiIinName),
                seibetsu,
                shinsainShikakuCode == null ? Code.EMPTY : new Code(shinsainShikakuCode),
                iryoKikan,
                kaigoJigyosha,
                sonotaJigyosha,
                kikenFlag,
                haishiFlag,
                maxKensu,
                hokensha,
                new FlexibleDate(RDate.getNowDate().toDateString())
        );
        List<NinteiShinsakaiIinGuideResult> 審査会委員一覧リスト = NinteiShinsakaiIinGuideManager.createInstance().
                get審査会委員一覧情報(parameter).records();
        if (審査会委員一覧リスト.isEmpty()) {
            div.getDgShinsakaiIinIchiran().getDataSource().clear();
            return ResponseData.of(div).addValidationMessages(getHandler(div).data_Nasi()).respond();
        }
        getHandler(div).審査会委員一覧情報の設定(審査会委員一覧リスト);
        div.getKensakuJoken().setIsOpen(false);
        div.getShinsakaiIinIchiran().setIsOpen(true);
        div.getBtnSaikensaku().setVisible(true);
        return ResponseData.of(div).respond();
    }

    /**
     * 保険者を選択した時の処理をします。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onChange_HokenshaList(NinteiShinsakaiIinGuideDiv div) {
        getHandler(div).set保険者選択();
        return ResponseData.of(div).respond();
    }

    /**
     * 再検索するボタンを押した時の処理をします。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onClick_btnSaikensaku(NinteiShinsakaiIinGuideDiv div) {
        div.getKensakuJoken().setIsOpen(true);
        div.getShosaiJoken().setIsOpen(false);
        div.getShinsakaiIinIchiran().setIsOpen(false);
        div.getBtnSaikensaku().setVisible(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 審査会委員一覧の選択ボタンを押したまたは審査会委員一覧行をダブルクリック時の処理をします。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onClick_ShinsakaiIinIchiranDate(NinteiShinsakaiIinGuideDiv div) {
        RString 介護認定審査会委員コード = div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().getClickedItem().getCode();
        RString 審査会委員名称 = div.getShinsakaiIinIchiran().getDgShinsakaiIinIchiran().getClickedItem().getShinsakaiIinName();
        div.setHdnShinsakaiIinCode(介護認定審査会委員コード);
        div.setHdnShinsakaiIinName(審査会委員名称);
        ViewStateHolder.put(ViewStateKeys.介護認定審査会委員コード, 介護認定審査会委員コード);
        ViewStateHolder.put(ViewStateKeys.審査会委員名称, 審査会委員名称);
        return ResponseData.of(div).respond();
    }

    /**
     * 戻るボタンを押した時の処理をします。
     *
     * @param div 認定審査会委員ガイドDiv
     * @return ResponseData<NinteiShinsakaiIinGuideDiv>
     */
    public ResponseData<NinteiShinsakaiIinGuideDiv> onClick_btnModoru(NinteiShinsakaiIinGuideDiv div) {
        return ResponseData.of(div).respond();
    }

    private Decimal get最大取得件数上限() {
        Decimal 最大取得件数上限 = new Decimal(0);
        if (DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告) != null) {
            最大取得件数上限 = new Decimal(DbBusinessConfig.get(
                    ConfigNameDBU.検索制御_最大取得件数,
                    RDate.getNowDate(),
                    SubGyomuCode.DBU介護統計報告).toString());
        }
        return 最大取得件数上限;
    }

    private RString getChkFlag(List<RString> listRSt) {
        RString chkFlag = RString.EMPTY;
        if (listRSt.size() == 1) {
            if (listRSt.contains(DATE_SOURCE_KEY0)) {
                chkFlag = new RString("1");
            }
            if (listRSt.contains(DATE_SOURCE_KEY1)) {
                chkFlag = new RString("2");
            }
        }
        return chkFlag;
    }

    @JsonIgnore
    private NinteiShinsakaiIinGuideHandler getHandler(NinteiShinsakaiIinGuideDiv div) {
        return new NinteiShinsakaiIinGuideHandler(div);
    }
}
