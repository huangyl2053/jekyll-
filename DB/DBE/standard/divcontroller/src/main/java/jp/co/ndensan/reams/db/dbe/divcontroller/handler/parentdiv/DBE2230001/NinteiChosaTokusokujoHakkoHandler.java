/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2230001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.DbeBusinessConfigKey;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 認定調査督促状発行のHandlerクラスです。
 *
 */
public class NinteiChosaTokusokujoHakkoHandler {

    private final NinteiChosaTokusokujoHakkoDiv div;
    private static final RString RADIOBUTTONKEY0 = new RString("key0");
    private static final RString RADIOBUTTONKEY1 = new RString("key1");
    private static final RString 未選択 = new RString("0");
    private static final RString 選択された = new RString("1");
    private static final RString 印刷書類区分_要介護認定調査督促状 = new RString("1");
    private static final RString 印刷書類区分_認定調査督促状対象者一覧 = new RString("2");

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
        initializtion();
        onChange_radChohyo();
    }

    /**
     * 該当データ件数取得。
     *
     * @param tempData tempData
     * @return 該当データ件数
     */
    public int 該当データ件数取得(NinteiChosaTokusokujoHakkoTempData tempData) {
        int 該当データ件数 = 0;
        NinteiChosaTokusokujoHakkoManager manager = NinteiChosaTokusokujoHakkoManager.createInstance();
        if (印刷書類区分_要介護認定調査督促状.equals(tempData.getTemp_印刷書類区分())) {
            該当データ件数 = manager.countGaitouDataKenSu13(tempData);
        } else if (印刷書類区分_認定調査督促状対象者一覧.equals(tempData.getTemp_印刷書類区分())) {
            該当データ件数 = manager.countGaitouDataKenSu2(tempData);
        }
        return 該当データ件数;
    }

    /**
     * 画面側からtempDataを取得
     *
     * @return tempData
     */
    public NinteiChosaTokusokujoHakkoTempData getTempData() {
        NinteiChosaTokusokujoHakkoTempData tempData = new NinteiChosaTokusokujoHakkoTempData();
        tempData.setTemp_保険者コード(div.getCcdHokensha().getSelectedItem().get保険者区分().getコード());
        tempData.setTemp_保険者名称(div.getCcdHokensha().getSelectedItem().get保険者区分().get名称());
        tempData.setTemp_認定調査委託先コード(div.getYokaigoNinteiChosaTokusokujo().getCcdItakusakiAndChosain().getChosaItakusakiCode());
        tempData.setTemp_認定調査員コード(div.getYokaigoNinteiChosaTokusokujo().getCcdItakusakiAndChosain().getChosain());
        tempData.setTemp_基準日(div.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay().getValue());
        tempData.setTemp_認定調査督促期限日数(div.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay().getValue());
        tempData.setTemp_要介護認定調査督促状(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_認定調査督促対象者一覧表(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_CSV出力(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().contains(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_印刷済対象者(div.getYokaigoNinteiChosaTokusokujo().getChkInsatsuzumiTaisho().getSelectedKeys().contains(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_発行履歴(div.getYokaigoNinteiChosaTokusokujo().getChkHakkoRireki().getSelectedKeys().contains(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_督促方法(div.getYokaigoNinteiChosaTokusokujo().getRadTokusokuHoho().getSelectedIndex());
        tempData.setTemp_督促メモ(div.getYokaigoNinteiChosaTokusokujo().getTxtTokusokuMemo().getValue());
        tempData.setTemp_督促日(div.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay().getValue());
        tempData.setTemp_印刷期間開始日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue());
        tempData.setTemp_印刷期間終了日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue());
        tempData.setTemp_印刷書類区分(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 印刷書類区分_要介護認定調査督促状 : 印刷書類区分_認定調査督促状対象者一覧);
        return tempData;
    }

    public void onChange_radChohyo() {
        if (RADIOBUTTONKEY0.equals(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey())) {
            div.getYokaigoNinteiChosaTokusokujo().setDisplayNone(false);
            div.getNinteiChosaTokusokuTaishoshaIchiranhyo().setDisplayNone(true);
        } else {
            div.getYokaigoNinteiChosaTokusokujo().setDisplayNone(true);
            div.getNinteiChosaTokusokuTaishoshaIchiranhyo().setDisplayNone(false);
        }
    }

    private void initializtion() {
        div.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay().setValue(FlexibleDate.getNowDate());
        RString 認定調査督促期限日数 = BusinessConfig.get(DbeBusinessConfigKey.認定調査督促期限日数, SubGyomuCode.DBE認定支援);
        if (Decimal.canConvert(認定調査督促期限日数)) {
            div.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay().setValue(new Decimal(認定調査督促期限日数.toString()));
        }
        div.getCcdHokensha().loadHokenshaList();
        div.getHakkoJoken().getRadChohyoSentaku().setSelectedKey(RADIOBUTTONKEY0);
        div.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay().setValue(FlexibleDate.getNowDate());
    }

}
