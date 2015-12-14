/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2230001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoManager;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査督促状発行のHandlerクラスです。
 *
 */
public class NinteiChosaTokusokujoHakkoHandler {

    private final NinteiChosaTokusokujoHakkoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public NinteiChosaTokusokujoHakkoHandler(NinteiChosaTokusokujoHakkoDiv div) {
        this.div = div;
    }

    /**
     * サービスコード検索一覧初期化の設定します。
     *
     */
    public void onLoad() {
        setTemp();
    }

    /**
     * 「発行する」ボタンをクリックの設定します。
     *
     * @return 該当データ件数
     */
    public int hakkou() {
        int 該当データ件数 = 0;
        NinteiChosaTokusokujoHakkoManager manager = NinteiChosaTokusokujoHakkoManager.createInstance();
        if (new RString("1").equals(div.getTempData().getTemp_印刷書類区分())) {
            該当データ件数 = manager.countGaitouDataKenSu13(div.getTempData());
        } else if (new RString("2").equals(div.getTempData().getTemp_印刷書類区分())) {
            該当データ件数 = manager.countGaitouDataKenSu2(div.getTempData());
        }
        return 該当データ件数;
    }

    private void setTemp() {
        NinteiChosaTokusokujoHakkoTempData tempData = new NinteiChosaTokusokujoHakkoTempData();
        tempData.setTemp_保険者コード(div.getHakkoJoken().getDdlHokensha().getSelectedKey());
        tempData.setTemp_保険者名称(div.getHakkoJoken().getDdlHokensha().getSelectedValue());
        tempData.setTemp_認定調査委託先コード(div.getYokaigoNinteiChosaTokusokujo().getCcdItakusakiAndChosain().getChosaItakusakiCode());
        tempData.setTemp_認定調査員コード(div.getYokaigoNinteiChosaTokusokujo().getCcdItakusakiAndChosain().getChosain());
        tempData.setTemp_基準日(div.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay().getValue());
        tempData.setTemp_認定調査督促期限日数(div.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay().getValue());
        tempData.setTemp_要介護認定調査督促状(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(new RString("key0"))
                ? new RString("1") : new RString("0"));
        tempData.setTemp_認定調査督促対象者一覧表(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(new RString("key1"))
                ? new RString("1") : new RString("0"));
        tempData.setTemp_CSV出力(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().contains(new RString("key1"))
                ? new RString("1") : new RString("0"));
        tempData.setTemp_印刷済対象者(div.getYokaigoNinteiChosaTokusokujo().getChkInsatsuzumiTaisho().getSelectedKeys().contains(new RString("key0"))
                ? new RString("1") : new RString("0"));
        tempData.setTemp_発行履歴(div.getYokaigoNinteiChosaTokusokujo().getChkHakkoRireki().getSelectedKeys().contains(new RString("key0"))
                ? new RString("1") : new RString("0"));
        tempData.setTemp_督促方法(div.getYokaigoNinteiChosaTokusokujo().getRadTokusokuHoho().getSelectedIndex());
        tempData.setTemp_督促メモ(div.getYokaigoNinteiChosaTokusokujo().getTxtTokusokuMemo().getValue());
        tempData.setTemp_督促日(div.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay().getValue());
        tempData.setTemp_印刷期間開始日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue());
        tempData.setTemp_印刷期間終了日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue());
        tempData.setTemp_出力順(((ChohyoShutsuryokujunDiv) div.getCcdChohyoShutsuryokujun()).getTxtSort().getValue());
        tempData.setTemp_集計(((ChohyoShutsuryokujunDiv) div.getCcdChohyoShutsuryokujun()).getTxtShukei().getValue());
        tempData.setTemp_改頁(((ChohyoShutsuryokujunDiv) div.getCcdChohyoShutsuryokujun()).getTxtKaiPage().getValue());
        tempData.setTemp_印刷書類区分(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(new RString("key0"))
                ? new RString("1") : new RString("2"));
        div.setTempData(tempData);
    }
}
