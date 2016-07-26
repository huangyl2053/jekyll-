/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.DBB0310001;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.honsanteifuka.HonsanteifukaBatchParameter;
import static jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.DBB0310001TransitionEventName.打ち分け方法確認;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001.HonsanteiFukaKeisanTotalDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.handler.parentdiv.DBB0310001.HonsanteiFukaKeisanTotalHandler;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 本算定賦課計算クラスです。
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonsanteiFukaKeisanTotal {

    private static final RString 本算定賦課メニュー = new RString("DBBMN43001");
    private static final RString 本算定通知書作成メニュー = new RString("DBBMN43002");
    private static final RString 本算定賦課_帳票グループコード = new RString("DBB0310001");
    private static final RString 本算定通知書作成_帳票グループコード = new RString("DBB0310003");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");

    /**
     * コントロールdivが「生成」された際の処理です。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return ResponseData
     */
    public ResponseData<HonsanteiFukaKeisanTotalDiv> onLoad(HonsanteiFukaKeisanTotalDiv div) {

        RString 遷移元区分 = RString.EMPTY;
        if (本算定賦課メニュー.equals(ResponseHolder.getMenuID())) {
            遷移元区分 = 遷移元区分_0;
        } else if (本算定通知書作成メニュー.equals(ResponseHolder.getMenuID())) {
            遷移元区分 = 遷移元区分_1;
        }
        ViewStateHolder.put(ViewStateKeys.遷移元区分, 遷移元区分);
        RString 年度 = DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度, RDate.getNowDate(),
                SubGyomuCode.DBB介護賦課);
        ViewStateHolder.put(ViewStateKeys.調定年度, 年度);
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtChoteiNendo().setValue(new FlexibleYear(年度.toString()).wareki().toDateString());
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtFukaNendo().setValue(new FlexibleYear(年度.toString()).wareki().toDateString());
        List<Kitsuki> 期月リスト = new FuchoKiUtil().get期月リスト().filtered本算定期間().toList();
        Kitsuki 更正月 = 期月リスト.get(0);
        RString 算定期 = 更正月.get期();
        ViewStateHolder.put(ViewStateKeys.算定期, 算定期);
        int 期 = 更正月.get期AsInt();
        RString 調定期 = 更正月.get表記().asX期括弧X月();
        getKanendoFukaKakuteiHandler(div).set調定期(更正月);
        RDate システム日付 = RDate.getNowDate();
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShotokuKijunYMD().setValue(システム日付);
        div.getShoriJokyo().getHonsanteiShoriNaiyo().getTxtShikakuKijunYMD().setValue(システム日付);
        getKanendoFukaKakuteiHandler(div).set処理状態(遷移元区分, new FlexibleYear(年度));
        getKanendoFukaKakuteiHandler(div).set管理情報(new FlexibleYear(年度));
        if (遷移元区分_0.equals(遷移元区分)) {
            div.getHonsanteiChohyoHakko2().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 本算定賦課_帳票グループコード);
        } else if (遷移元区分_1.equals(遷移元区分)) {
            div.getHonsanteiChohyoHakko2().getCcdChohyoIchiran().load(SubGyomuCode.DBB介護賦課, 本算定通知書作成_帳票グループコード);
        }
        getKanendoFukaKakuteiHandler(div).set帳票作成個別情報(期, 調定期, 算定期, 遷移元区分, new FlexibleYear(年度));

        return ResponseData.of(div).respond();
    }

    /**
     * 打分け方法確認画面へ遷移
     *
     * @param div HonsanteiFukaKeisanTotalDiv
     * @return ResponseData<HonsanteiFukaKeisanTotalDiv>
     */
    public ResponseData<HonsanteiFukaKeisanTotalDiv> onClick_btnKetteiTsuchiYousikiSettei2(HonsanteiFukaKeisanTotalDiv div) {
        return ResponseData.of(div).forwardWithEventName(打ち分け方法確認).respond();
    }

    /**
     * 実行チェックの処理です
     *
     * @param div HonsanteiFukaKeisanTotalDiv
     * @return ResponseData<HonsanteiFukaKeisanTotalDiv>
     */
    public ResponseData<HonsanteiFukaKeisanTotalDiv> onClick_btnSanteiCheck(HonsanteiFukaKeisanTotalDiv div) {
        ValidationMessageControlPairs pairs = getKanendoFukaKakuteiHandler(div).set入力チェック();
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 本算定賦課計算メニューからの場合、実行するの処理です
     *
     * @param div HonsanteiFukaKeisanTotalDiv
     * @return ResponseData<HonsanteiFukaKeisanTotalDiv>
     */
    public ResponseData<HonsanteifukaBatchParameter> onClick_btnSantei(HonsanteiFukaKeisanTotalDiv div) {
        HonsanteifukaBatchParameter parameter = getKanendoFukaKakuteiHandler(div)
                .setバッチパラメータ(ViewStateHolder.get(ViewStateKeys.調定年度, RString.class),
                        ViewStateHolder.get(ViewStateKeys.算定期, RString.class),
                        ViewStateHolder.get(ViewStateKeys.遷移元区分, RString.class));
        return ResponseData.of(parameter).respond();
    }

    /**
     * 本算定通知書作成メニューからの場合、実行するの処理です
     *
     * @param div HonsanteiFukaKeisanTotalDiv
     * @return ResponseData<HonsanteiFukaKeisanTotalDiv>
     */
    public ResponseData<HonsanteifukaBatchParameter> onClick_btnTsuchishoSakusei(HonsanteiFukaKeisanTotalDiv div) {
        HonsanteifukaBatchParameter parameter = getKanendoFukaKakuteiHandler(div)
                .setバッチパラメータ(ViewStateHolder.get(ViewStateKeys.調定年度, RString.class),
                        ViewStateHolder.get(ViewStateKeys.算定期, RString.class),
                        ViewStateHolder.get(ViewStateKeys.遷移元区分, RString.class));
        return ResponseData.of(parameter).respond();
    }

    /**
     * handlerの取得を実行する
     *
     * @param div HonsanteiFukaKeisanTotalDiv
     * @return HonsanteiFukaKeisanTotalHandler
     */
    private HonsanteiFukaKeisanTotalHandler getKanendoFukaKakuteiHandler(HonsanteiFukaKeisanTotalDiv div) {
        return new HonsanteiFukaKeisanTotalHandler(div);
    }
}
