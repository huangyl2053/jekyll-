/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.KaigoChohyoShutsuryokujun;

import jp.co.ndensan.reams.db.dba.service.kaigochohyoshutsuryokujun.KaigoChohyoShutsuryokujun;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv.DisplayNone;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護帳票出力順の共有子Divのハンドルクラスです。
 */
public class KaigoChohyoShutsuryokujunHandler {

    private final KaigoChohyoShutsuryokujunDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 介護帳票出力順の共有子Divのコントロール
     */
    public KaigoChohyoShutsuryokujunHandler(KaigoChohyoShutsuryokujunDiv div) {
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
        div.getCcdChohyoShutsuryokujun().setMode_Grid(ChohyoShutsuryokujunDiv.Grid.G12);
        div.getCcdChohyoShutsuryokujun().setMode_DisplayNone(displayNone);
        div.getCcdChohyoShutsuryokujun().load(subGyomuCode, reportId);
    }

    /**
     * 入力データチェックです。
     */
    public void checkInput() {
        KaigoChohyoShutsuryokujun shutsuryokujun = new KaigoChohyoShutsuryokujun();
        shutsuryokujun.checkInput(div.getCcdChohyoShutsuryokujun().getTxtSort().getValue(),
                new RString(div.getCcdChohyoShutsuryokujun().getMode_DisplayNone().toString()),
                div.getCcdChohyoShutsuryokujun().getTxtKaiPage().getValue(),
                div.getCcdChohyoShutsuryokujun().getTxtShukeiNoneKaiPage().getValue());
    }
}
