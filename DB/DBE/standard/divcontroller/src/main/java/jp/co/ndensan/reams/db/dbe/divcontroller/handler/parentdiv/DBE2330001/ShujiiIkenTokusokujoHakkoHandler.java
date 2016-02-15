/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2330001;

import jp.co.ndensan.reams.db.dbe.definition.core.valueobject.shujiiikentokusokujohakko.ShujiiIkenTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2330001.ShujiiIkenTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.service.core.shujiiikentokusokujo.ShujiiIkenTokusokujoFinder;
import jp.co.ndensan.reams.db.dbz.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * 主治医意見書督促状発行のHandlerクラスです。
 *
 */
public class ShujiiIkenTokusokujoHakkoHandler {

    private final ShujiiIkenTokusokujoHakkoDiv div;
    private static final RString RADIOBUTTONKEY0 = new RString("key0");
    private static final RString RADIOBUTTONKEY1 = new RString("key1");
    private static final RString 未選択 = new RString("0");
    private static final RString 選択された = new RString("1");
    private static final RString 印刷書類区分_主治医意見書提出督促状 = new RString("1");
    private static final RString 印刷書類区分_主治医意見書督促対象者一覧表 = new RString("2");

    /**
     * コンストラクタです。
     *
     * @param div
     */
    public ShujiiIkenTokusokujoHakkoHandler(ShujiiIkenTokusokujoHakkoDiv div) {
        this.div = div;
    }

    /**
     * 初期化の設定します。
     *
     */
    public void onLoad() {
        initializtion();
        onChange_radChohyo();
    }

    /**
     * 印刷書類区分の設定します。
     *
     */
    public void onChange_radChohyo() {
        if (RADIOBUTTONKEY0.equals(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey())) {
            div.getShujiiIkenshoTokusokujo().setDisplayNone(false);
            div.getNinteiChosaTokusokuTaishoshaIchiranhyo().setDisplayNone(true);
        } else {
            div.getShujiiIkenshoTokusokujo().setDisplayNone(true);
            div.getNinteiChosaTokusokuTaishoshaIchiranhyo().setDisplayNone(false);
        }
    }

    private void initializtion() {
        div.getHakkoJoken().getTxtKijunDay().setValue(FlexibleDate.getNowDate());
        RString 主治医意見書督促期限日数 = BusinessConfig.get(ConfigNameDBE.主治医意見書督促期限日数, SubGyomuCode.DBE認定支援);
        if (Decimal.canConvert(主治医意見書督促期限日数)) {
            div.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay().setValue(new Decimal(主治医意見書督促期限日数.toString()));
        }
        //TODO QA607(保険者取得)
        // div.getCcdHokensha().loadHokenshaList();
        div.getHakkoJoken().getRadChohyoSentaku().setSelectedKey(RADIOBUTTONKEY0);
        div.getShujiiIkenshoTokusokujo().getTxtHakkoDay().setValue(FlexibleDate.getNowDate());
    }

    /**
     * 該当データ件数取得。
     *
     * @param tempData tempData
     * @return 該当データ件数
     */
    public int 該当データ件数取得(ShujiiIkenTokusokujoHakkoTempData tempData) {
        int 該当データ件数 = 0;
        ShujiiIkenTokusokujoFinder manager = ShujiiIkenTokusokujoFinder.createInstance();
        if (印刷書類区分_主治医意見書提出督促状.equals(tempData.getTemp_印刷書類区分())) {
            該当データ件数 = manager.get督促状件数(tempData);
        } else if (印刷書類区分_主治医意見書督促対象者一覧表.equals(tempData.getTemp_印刷書類区分())) {
            該当データ件数 = manager.get督促状対象者件数(tempData);
        }
        return 該当データ件数;
    }

    /**
     * 画面側からtempDataを取得。
     *
     * @return tempData
     */
    public ShujiiIkenTokusokujoHakkoTempData getTempData() {
        ShujiiIkenTokusokujoHakkoTempData tempData = new ShujiiIkenTokusokujoHakkoTempData();
        //TODO QA607(保険者取得)
//        tempData.setTemp_保険者コード(div.getCcdHokensha().getSelectedItem().get保険者区分().getコード());
//        tempData.setTemp_保険者名称(div.getCcdHokensha().getSelectedItem().get保険者区分().get名称());
        tempData.setTemp_主治医医療機関コード(div.getShujiiIkenshoTokusokujo().getCCDIryokikanShujii().getIryoKikanCode());
        tempData.setTemp_主治医コード(div.getShujiiIkenshoTokusokujo().getCCDIryokikanShujii().getShujiiCode());
        tempData.setTemp_基準日(div.getHakkoJoken().getTxtKijunDay().getValue());
        tempData.setTemp_主治医意見書督促期限日数(div.getShujiiIkenshoTokusokujo().getTxtOverChosaIraiDay().getValue());
        tempData.setTemp_主治医意見書督促状(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_主治医意見書督促対象者一覧表(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_CSV出力(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkInsatsuChohyo().getSelectedKeys().contains(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_印刷済対象者(div.getShujiiIkenshoTokusokujo().getChkInsatsuzumiTaisho().getSelectedKeys().contains(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_発行履歴(div.getShujiiIkenshoTokusokujo().getChkHakkoRireki().getSelectedKeys().contains(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_督促方法(div.getShujiiIkenshoTokusokujo().getRadTokusokuHoho().getSelectedIndex());
        tempData.setTemp_督促メモ(div.getShujiiIkenshoTokusokujo().getTxtTokusokuMemo().getValue());
        tempData.setTemp_督促日(div.getShujiiIkenshoTokusokujo().getTxtHakkoDay().getValue());
        tempData.setTemp_印刷期間開始日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue());
        tempData.setTemp_印刷期間終了日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue());
        tempData.setTemp_印刷書類区分(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 印刷書類区分_主治医意見書提出督促状 : 印刷書類区分_主治医意見書督促対象者一覧表);
        return tempData;
    }
}
