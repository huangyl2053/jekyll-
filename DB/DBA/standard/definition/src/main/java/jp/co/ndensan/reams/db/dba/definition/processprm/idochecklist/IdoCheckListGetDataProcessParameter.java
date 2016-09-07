/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist;

import jp.co.ndensan.reams.db.dba.definition.mybatisprm.idochecklist.IdoCheckListGetDataParameter;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IBatchProcessParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 異動チェックリストのパラメータクラスです。
 *
 * @reamsid_L DBA-0530-020 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoCheckListGetDataProcessParameter implements IBatchProcessParameter {

    private boolean hihokenshaDaichouFlag;
    private boolean jushochiTokureiKanriFlag;
    private boolean tekiyoJogaishaDaichouFlag;
    private boolean seikatsuHogoFlag;
    private boolean roreiFukushiNenkinFlag;
    private Long shuturyokuJunId;
    private RDateTime konkaiKaishi;
    private RDateTime konkaiShuryo;

    /**
     * コンストラクタです。
     *
     * @param konkaiKaishi 今回開始日時
     * @param konkaiShuryo 今回終了日時
     * @param hihokenshaDaichouFlag 被保険者台帳フラグ
     * @param jushochiTokureiKanriFlag 他住所地特例者管理フラグ
     * @param tekiyoJogaishaDaichouFlag 適用除外者台帳フラグ
     * @param seikatsuHogoFlag 生活保護フラグ
     * @param roreiFukushiNenkinFlag 老齢福祉年金フラグ
     * @param shuturyokuJunId 出力順ID
     */
    public IdoCheckListGetDataProcessParameter(
            RDateTime konkaiKaishi, RDateTime konkaiShuryo,
            boolean hihokenshaDaichouFlag, boolean jushochiTokureiKanriFlag,
            boolean tekiyoJogaishaDaichouFlag, boolean seikatsuHogoFlag,
            boolean roreiFukushiNenkinFlag, Long shuturyokuJunId) {
        this.konkaiKaishi = konkaiKaishi;
        this.konkaiShuryo = konkaiShuryo;
        this.hihokenshaDaichouFlag = hihokenshaDaichouFlag;
        this.jushochiTokureiKanriFlag = jushochiTokureiKanriFlag;
        this.tekiyoJogaishaDaichouFlag = tekiyoJogaishaDaichouFlag;
        this.seikatsuHogoFlag = seikatsuHogoFlag;
        this.roreiFukushiNenkinFlag = roreiFukushiNenkinFlag;
        this.shuturyokuJunId = shuturyokuJunId;
    }

    /**
     * 異動チェックリストのパラメータをを作成します。
     *
     * @return IdoCheckListGetDataParameter
     */
    public IdoCheckListGetDataParameter toIdoCheckListGetDataParameter() {
        return IdoCheckListGetDataParameter.createIdoCheckListGetDataParameter(
                konkaiKaishi,
                konkaiShuryo,
                RString.HALF_SPACE,
                ShikibetsuCode.EMPTY,
                GyomuCode.EMPTY,
                FlexibleDate.EMPTY);
    }
}
