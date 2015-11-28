/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoChohyoShutsuryokujun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護帳票出力順の共有子Divのハンドルクラスです。
 */
public class KaigoChohyoShutsuryokujunHandler {

    private final KaigoChohyoShutsuryokujunDiv div;
    private static final RString 出力順 = new RString("出力順");
    private static final RString 改頁 = new RString("改頁");

    /**
     * コンストラクタです。
     *
     * @param div 介護帳票出力順の共有子Divのコントロール
     */
    KaigoChohyoShutsuryokujunHandler(KaigoChohyoShutsuryokujunDiv div) {
        this.div = div;
    }

    /**
     * 帳票出力順の初期化を行います。
     *
     * @param subGyomuCode サブ業務コード
     * @param reportId 帳票ID
     * @param displayNone 表示モード
     */
    public void load(SubGyomuCode subGyomuCode, ReportId reportId, DisplayNone displayNone) {
        this.div.getKaigoChohyoShutsuryokujun().setMode_Grid(ChohyoShutsuryokujunDiv.Grid.G12);
        this.div.getKaigoChohyoShutsuryokujun().setMode_DisplayNone(displayNone);
        this.div.getKaigoChohyoShutsuryokujun().load(subGyomuCode, reportId);
    }

    /**
     * 入力データチェックです。
     */
    public void checkInput() {
        if (this.div.getKaigoChohyoShutsuryokujun().getTxtSort().getValue() == null
                || this.div.getKaigoChohyoShutsuryokujun().getTxtSort().getValue().isEmpty()) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(出力順.toString()));
        }
        if ((this.div.getKaigoChohyoShutsuryokujun().getMode_DisplayNone().equals(ChohyoShutsuryokujunDiv.DisplayNone.ALL)
                || this.div.getKaigoChohyoShutsuryokujun().getMode_DisplayNone().equals(ChohyoShutsuryokujunDiv.DisplayNone.SHUKEI_NONE))
                && ((this.div.getKaigoChohyoShutsuryokujun().getTxtKaiPage().getValue() == null
                || this.div.getKaigoChohyoShutsuryokujun().getTxtKaiPage().getValue().isEmpty())
                && (this.div.getKaigoChohyoShutsuryokujun().getTxtShukeiNoneKaiPage().getValue() == null
                || this.div.getKaigoChohyoShutsuryokujun().getTxtShukeiNoneKaiPage().getValue().isEmpty()))) {
            throw new ApplicationException(UrErrorMessages.必須項目_追加メッセージあり.getMessage().replace(改頁.toString()));
        }
    }
}
