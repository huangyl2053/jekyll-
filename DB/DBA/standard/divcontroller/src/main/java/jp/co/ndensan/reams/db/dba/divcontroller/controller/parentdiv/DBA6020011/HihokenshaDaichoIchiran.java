package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA6020011;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaDaichoIkkatsuSakusei;
import jp.co.ndensan.reams.db.dba.definition.batchprm.hihokenshadaicho.IkkatsuSakuseiBatchParameter;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6020011.HihokenshaDaichoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者台帳発行のクラスです。QA1001最大MainPanelない、Panel「ChohyoShutsuryokujun」と共通子DIV「URZ.ChohyoShutsuryokujun」のnameは一致
 *
 * @reamsid_L DBA-0510-050 wangxiaodong
 */
public class HihokenshaDaichoIchiran {

    private static final ReportId 帳票ID = new ReportId("DBA200002_HihokenshaDaichoHakkoIchiranhyo");

    /**
     * 被保険者台帳発行を初期化染ます。
     *
     * @param div HihokenshaDaichoIchiranDiv
     * @return ResponseData<HihokenshaDaichoIchiranDiv>
     */
    public ResponseData<HihokenshaDaichoIchiranDiv> onLoad(HihokenshaDaichoIchiranDiv div) {
        div.getHihokenshaDaichoHakko().getRadChushutsuSoshitsusha().setSelectedIndex(0);
        div.getChohyoShutsuryokujunOya().getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, 帳票ID);
        div.getHihokenshaDaichoHakkoList().setIsPublish(false);
//      TODO 帳票出力順 技術点No.15
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者台帳を実行するボタンを押下します。
     *
     * @param div 被保険者台帳発行
     * @return ResponseData<IkkatsuSakuseiBatchParameter>
     */
    public ResponseData<IkkatsuSakuseiBatchParameter> onClick_btnPublishHihokenshaDaicho(HihokenshaDaichoIchiranDiv div) {
        IkkatsuSakuseiBatchParameter parameter = HihokenshaDaichoIkkatsuSakusei.createHihokenshaDaichoBatchParameter(
                div.getHihokenshaDaichoHakko().getRadChushutsuSoshitsusha().getSelectedIndex() == 0,
                div.getHihokenshaDaichoHakkoList().isIsPublish(),
                new RString(String.valueOf(div.getChohyoShutsuryokujunOya().getCcdChohyoShutsuryokujun().get出力順ID())));
        return ResponseData.of(parameter).respond();
    }
}
