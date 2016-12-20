/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2230001;

import jp.co.ndensan.reams.db.dbe.definition.core.chosa.DbeBusinessConfigKey;
import jp.co.ndensan.reams.db.dbe.definition.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoTempData;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2230001.NinteiChosaTokusokujoHakkoDiv;
import jp.co.ndensan.reams.db.dbe.service.core.ninteichosatokusokujohakko.NinteiChosaTokusokujoHakkoManager;
import jp.co.ndensan.reams.db.dbx.business.core.hokenshalist.HokenshaSummary;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 認定調査督促状発行のHandlerクラスです。
 *
 * @reamsid_L DBE-0030-010 liangbc
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
     * @param div NinteiChosaTokusokujoHakkoDiv
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
        changeHokensha();
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
        tempData.setTemp_保険者コード(div.getCcdHokensha().getSelectedItem().get証記載保険者番号().getColumnValue());
        tempData.setTemp_保険者名称(div.getCcdHokensha().getSelectedItem().get市町村名称());
        tempData.setTemp_認定調査委託先コード(div.getYokaigoNinteiChosaTokusokujo()
                .getCcdItakusakiAndChosain().getTxtChosaItakusakiCode().getValue());
        tempData.setTemp_認定調査員コード(div.getYokaigoNinteiChosaTokusokujo()
                .getCcdItakusakiAndChosain().getTxtChosainCode().getValue());
        FlexibleDate txtKijunDay = new FlexibleDate(div.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay().getValue().toString());
        if (!txtKijunDay.isEmpty()) {
            tempData.setTemp_基準日(txtKijunDay);
        }
        tempData.setTemp_認定調査督促期限日数(div.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay().getValue());
        tempData.setTemp_要介護認定調査督促状(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_認定調査督促対象者一覧表(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_CSV出力(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getChkCSVShutsuryoku().getSelectedKeys().contains(RADIOBUTTONKEY1)
                ? 選択された : 未選択);
        tempData.setTemp_印刷済対象者(div.getYokaigoNinteiChosaTokusokujo().getChkInsatsuzumiTaisho().getSelectedKeys().contains(RADIOBUTTONKEY0)
                ? 選択された : 未選択);
        tempData.setTemp_督促方法(div.getYokaigoNinteiChosaTokusokujo().getRadTokusokuHoho().getSelectedIndex());
        tempData.setTemp_督促メモ(div.getYokaigoNinteiChosaTokusokujo().getTxtTokusokuMemo().getValue());
        FlexibleDate txtHakkoDay = new FlexibleDate(div.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay().getValue().toString());
        if (!txtHakkoDay.isEmpty()) {
            tempData.setTemp_督促日(txtHakkoDay);
        }
        tempData.setTemp_印刷期間開始日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue() == null
                ? null : new FlexibleDate(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getFromValue().toString()));
        tempData.setTemp_印刷期間終了日(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue() == null
                ? null : new FlexibleDate(div.getNinteiChosaTokusokuTaishoshaIchiranhyo().getTxtInsatsuKikan().getToValue().toString()));
        tempData.setTemp_印刷書類区分(div.getHakkoJoken().getRadChohyoSentaku().getSelectedKey().equals(RADIOBUTTONKEY0)
                ? 印刷書類区分_要介護認定調査督促状 : 印刷書類区分_認定調査督促状対象者一覧);
        return tempData;
    }

    /**
     * 印刷書類区分を選択します。
     *
     */
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
        div.getYokaigoNinteiChosaTokusokujo().getTxtKijunDay().setValue(RDate.getNowDate());
        RString 認定調査督促期限日数 = DbBusinessConfig.get(DbeBusinessConfigKey.認定調査督促期限日数, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
        if (Decimal.canConvert(認定調査督促期限日数)) {
            div.getYokaigoNinteiChosaTokusokujo().getTxtOverChosaIraiDay().setValue(new Decimal(認定調査督促期限日数.toString()));
        }
        div.getCcdHokensha().loadHokenshaList(GyomuBunrui.介護認定);
        div.getHakkoJoken().getRadChohyoSentaku().setSelectedKey(RADIOBUTTONKEY0);
        div.getYokaigoNinteiChosaTokusokujo().getTxtHakkoDay().setValue(RDate.getNowDate());
    }

    /**
     * 保険者の変更に伴う画面の変更です。
     */
    public void changeHokensha() {
        boolean is全市町村 = HokenshaSummary.EMPTY.equals(div.getCcdHokensha().getSelectedItem());
        div.getCcdItakusakiAndChosain().setDisabled(is全市町村);
        div.getCcdItakusakiAndChosain().clear();
        div.getCcdItakusakiAndChosain().setHdnShinseishoKanriNo(ShinseishoKanriNo.EMPTY.value());
        div.getCcdItakusakiAndChosain().setHdnShichosonCode(div.getCcdHokensha().getSelectedItem().get市町村コード().value());
    }
}
