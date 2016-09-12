/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.definition.batchprm.idochecklist;

import jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist.IdoCheckListGetDataProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.idochecklist.UpdShoriDataKanriProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.BatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchParameterBase;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 異動チェックリストバッチのパラメータクラスです。
 *
 * @reamsid_L DBA-0530-010 chengsanyuan
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class IdoCheckListBatchParameter extends BatchParameterBase {

    private static final long serialVersionUID = 5232153252218964198L;

    private static final String KEY_ZENKAI_KAISHI = "zenkaiKaishi";
    private static final String KEY_ZENKAI_SHURYO = "zenkaiShuryo";
    private static final String KEY_KONKAI_KAISHI = "konkaiKaishi";
    private static final String KEY_KONKAI_SHURYO = "konkaiShuryo";
    private static final String KEY_HIHOKENSHA_DAICHOU_FLAG = "hihokenshaDaichouFlag";
    private static final String KEY_JUSHOCHI_TOKUREI_FLAG = "jushochiTokureiKanriFlag";
    private static final String KEY_TEKIYO_JOGAISHA_FLAG = "tekiyoJogaishaDaichouFlag";
    private static final String KEY_SEIKATSUHOGO_FLAG = "seikatsuHogoFlag";
    private static final String KEY_ROREI_FUKUSHI_NENKIN_FLAG = "roreiFukushiNenkinFlag";
    private static final String KEY_SHUTURYOKU_JUN_ID = "shuturyokuJunId";

    @BatchParameter(key = KEY_ZENKAI_KAISHI, name = "前回開始日時")
    private RDateTime zenkaiKaishi;
    @BatchParameter(key = KEY_ZENKAI_SHURYO, name = "前回終了日時")
    private RDateTime zenkaiShuryo;
    @BatchParameter(key = KEY_KONKAI_KAISHI, name = "今回開始日時")
    private RDateTime konkaiKaishi;
    @BatchParameter(key = KEY_KONKAI_SHURYO, name = "今回終了日時")
    private RDateTime konkaiShuryo;
    @BatchParameter(key = KEY_HIHOKENSHA_DAICHOU_FLAG, name = "被保険者台帳フラグ")
    private boolean hihokenshaDaichouFlag;
    @BatchParameter(key = KEY_JUSHOCHI_TOKUREI_FLAG, name = "他住所地特例者管理フラグ")
    private boolean jushochiTokureiKanriFlag;
    @BatchParameter(key = KEY_TEKIYO_JOGAISHA_FLAG, name = "適用除外者台帳フラグ")
    private boolean tekiyoJogaishaDaichouFlag;
    @BatchParameter(key = KEY_SEIKATSUHOGO_FLAG, name = "生活保護フラグ")
    private boolean seikatsuHogoFlag;
    @BatchParameter(key = KEY_ROREI_FUKUSHI_NENKIN_FLAG, name = "老齢福祉年金フラグ")
    private boolean roreiFukushiNenkinFlag;
    @BatchParameter(key = KEY_SHUTURYOKU_JUN_ID, name = "出力順ID")
    private Long shuturyokuJunId;

    /**
     * 異動チェックリスト帳票データ作成のパラメータを作成します。
     *
     * @return IdoCheckListGetDataProcessParameter
     */
    public IdoCheckListGetDataProcessParameter toIdoCheckListGetDataProcessParameter() {
        return new IdoCheckListGetDataProcessParameter(
                konkaiKaishi, konkaiShuryo, hihokenshaDaichouFlag,
                jushochiTokureiKanriFlag, tekiyoJogaishaDaichouFlag,
                seikatsuHogoFlag, roreiFukushiNenkinFlag, shuturyokuJunId);
    }

    /**
     * 処理日付管理マスタのパラメータを作成します。
     *
     * @return UpdShoriDataKanriProcessParameter
     */
    public UpdShoriDataKanriProcessParameter toUpdShoriDataKanriProcessParameter() {
        return new UpdShoriDataKanriProcessParameter(
                zenkaiKaishi, zenkaiShuryo, konkaiKaishi, konkaiShuryo);
    }
}
