package jp.co.ndensan.reams.db.dba.divcontroller.controller.parentdiv.DBA6020011;

import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaDaichoIkkatsuSakusei;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA020010.DBA020010_HihokenshaDaichoIkkatsuParameter;
import jp.co.ndensan.reams.db.dba.definition.reportid.ReportIdDBA;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA6020011.HihokenshaDaichoIkkatsuHakkoPanelDiv;
import jp.co.ndensan.reams.ur.urz.business.UrControlDataFactory;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;

/**
 * 被保険者台帳発行のクラスです。
 *
 * @reamsid_L DBA-0510-050 wangxiaodong
 */
public class HihokenshaDaichoIkkatsuHakkoPanel {

    /**
     * 被保険者台帳発行を初期化染ます。
     *
     * @param div HihokenshaDaichoIchiranDiv
     * @return ResponseData<HihokenshaDaichoIchiranDiv>
     */
    public ResponseData<HihokenshaDaichoIkkatsuHakkoPanelDiv> onLoad(HihokenshaDaichoIkkatsuHakkoPanelDiv div) {
        div.getHihokenshaDaichoHakkoChushutsuJokenPanel().getRadChushutsuSoshitsusha().setSelectedIndex(0);
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, ReportIdDBA.DBA200002.getReportId());
        div.getHihokenshaDaichoHakkoListPanel().setIsPublish(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 被保険者台帳を実行するボタンを押下します。
     *
     * @param div 被保険者台帳発行
     * @return ResponseData<IkkatsuSakuseiBatchParameter>
     */
    public ResponseData<DBA020010_HihokenshaDaichoIkkatsuParameter> onClick_btnPublishHihokenshaDaicho(HihokenshaDaichoIkkatsuHakkoPanelDiv div) {
        DBA020010_HihokenshaDaichoIkkatsuParameter parameter = HihokenshaDaichoIkkatsuSakusei.createHihokenshaDaichoBatchParameter(
                div.getHihokenshaDaichoHakkoChushutsuJokenPanel().getRadChushutsuSoshitsusha().getSelectedIndex() == 0,
                div.getHihokenshaDaichoHakkoListPanel().isIsPublish(),
                div.getCcdChohyoShutsuryokujun().get出力順ID(),
                UrControlDataFactory.createInstance().getLoginInfo().getUserId());
        return ResponseData.of(parameter).respond();
    }
}
