/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD5710001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD571001.DBD571001_JukyushaDaichoParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5710001.JyukyushaDaichoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5710001.JyukyushaDaichoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5710001.JyukyushaDaichoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri.JyukyushaDaichoshoridatekanriService;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.KaigoDonyuKubun;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 受給者台帳画面のDivControllerです。
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public class JyukyushaDaicho {

    private static final RString 対象期間 = new RString("1");
    private LasdecCode 市町村コード;
    private JyukyushaDaichoshoridatekanriService jyukyushoriDateKanriService;

    /**
     * 画面初期化処理です。
     *
     * @param div JyukyushaDaichoDiv
     * @return ResponseData<JyukyushaDaichoDiv>
     */
    public ResponseData<JyukyushaDaichoDiv> onLoad(JyukyushaDaichoDiv div) {
        ShichosonSecurityJoho shichosonSecurityJoho = ShichosonSecurityJohoFinder.createInstance().getShichosonSecurityJoho(
                GyomuBunrui.介護事務);
        ShoriDateKanri shoriDateKanri = null;
        if (shichosonSecurityJoho != null && !KaigoDonyuKubun.未導入.code().equals(shichosonSecurityJoho.get介護導入区分().code())) {
            市町村コード = shichosonSecurityJoho.get市町村情報().get市町村コード();
            jyukyushoriDateKanriService = JyukyushaDaichoshoridatekanriService.createInstance();
            shoriDateKanri = jyukyushoriDateKanriService.get一件取得(市町村コード);
            ViewStateHolder.put(ViewStateKeys.受給者台帳情報, shoriDateKanri);
        }
        creatJyukyushaDaichoHandler(div).onLoad(shoriDateKanri);
        div.getShutsuryokuSort().load(SubGyomuCode.DBD介護受給, ReportIdDBD.DBD100026.getReportId());
        return ResponseData.of(div).respond();
    }

    /**
     * 「抽出条件設定」ラジオボタン
     *
     * @param div JyukyushaDaichoDiv
     * @return ResponseData<JyukyushaDaichoDiv>
     */
    public ResponseData<JyukyushaDaichoDiv> radChushutsuJyouken_onChange(JyukyushaDaichoDiv div) {
        ShoriDateKanri shoriDateKanri = ViewStateHolder.get(ViewStateKeys.受給者台帳情報, ShoriDateKanri.class);
        creatJyukyushaDaichoHandler(div).radChushutsuJyouken_onChange(shoriDateKanri);
        return ResponseData.of(div).respond();
    }

    /**
     * 実行するボタンを押下のチェック処理します。
     *
     * @param div ChushutuJokenDiv のクラスファイル
     * @return ResponseData
     */
    public ResponseData<JyukyushaDaichoDiv> onClick_btnCheck(JyukyushaDaichoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (対象期間.equals(div.getChushutsuJyouken().getRadChushutsuJyouken().getSelectedKey())) {
            getValidationHandler().validateFor今回抽出対象期間今回の日付が非空(pairs, div);
            getValidationHandler().validateFor今回抽出対象終了日付が開始日付以前チェック(pairs, div);
        } else {
            getValidationHandler().validateFor被保険者番号非空チェック(pairs, div);
            getValidationHandler().validateFor被保険者番号ToがFrom以前チェック(pairs, div);
        }
        getValidationHandler().validateFor異動抽出対象一つでも選択していない場合チェック(pairs, div);
        getValidationHandler().validateFor出力順未指定チェック(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「リスト作成を実行する」ボタンを押下のバッチパラメータ作成。
     *
     * @param div JyukyushaDaichoDiv
     * @return ResponseData<DBD571001Parameter>
     */
    public ResponseData<DBD571001_JukyushaDaichoParameter> onCilck_btnBatchRegister(JyukyushaDaichoDiv div) {
        DBD571001_JukyushaDaichoParameter parameter = new DBD571001_JukyushaDaichoParameter();
        ShoriDateKanri shoriDateKanri = ViewStateHolder.get(ViewStateKeys.受給者台帳情報, ShoriDateKanri.class);
        creatJyukyushaDaichoHandler(div).onCilck_btnBatchRegister(div, parameter, shoriDateKanri);
        return ResponseData.of(parameter).respond();
    }

    private JyukyushaDaichoHandler creatJyukyushaDaichoHandler(JyukyushaDaichoDiv div) {
        return new JyukyushaDaichoHandler(div);
    }

    private JyukyushaDaichoValidationHandler getValidationHandler() {
        return new JyukyushaDaichoValidationHandler();
    }

}
