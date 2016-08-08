/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1060001.FutanGendogakuIkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd1060001.ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TaishoKubun;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.chohyoikkatsu.TanpyoHakkoKubun;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.DBD1060001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1060001.GemmenGengakuShoIkkatsuMainDiv;
import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.GemmenNendoResearcher;
import jp.co.ndensan.reams.db.dbx.business.config.jukyu.gemmenkigen.INendo;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.ur.urz.business.core.bunshono.BunshoNo;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.IBunshoNoFinder;
import jp.co.ndensan.reams.uz.uza.batch.api.parameter.BatchParameterManager;
import jp.co.ndensan.reams.uz.uza.batch.parameter.BatchParameterMap;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額帳票一括のハンドラークラスです。
 *
 * @reamsid_L DBD-3981-010 zhuxiaojun
 */
public class GemmenGengakuShoIkkatsuMainHandler {

    private final GemmenGengakuShoIkkatsuMainDiv div;
    private final RString 負担のBATCH_ID = new RString("DBD103010_FutanGendoGakuNinteiIkkatsuHakko");
    private final ReportId 負担帳票のID = new ReportId("DBD100013_FutanGendogakuKetteiTsuchisho");
    private final ReportId 負担出力帳票ID = new ReportId("DBD100020_FutanGendogakuNinteisho");
    private final RString 負担対象FROM = new RString("taishoYMDFrom");
    private final RString 負担対象TO = new RString("taishoYMDTo");
    private final RString 負担対象KUBUN = new RString("taishoKubun");
    private final RString 社会福祉のBATCH_ID = new RString("DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakko");
    private final RString 社会福祉対象FROM = new RString("ketteiYMDFrom");
    private final RString 社会福祉対象TO = new RString("ketteiYMDTo");
    private final ReportId 社会福祉帳票のID = new ReportId("DBD100012_ShakaiFukushiHojinRiyoshaFutanKeigenKetteiTsuchisho");
    private final ReportId 社会福祉出力帳票ID = new ReportId("DBD100018_ShafukuRiyoshaFutanKeigenTaishoKakuninsho");
//    private final RString A場合 = new RString("1");
//    private final RString B場合 = new RString("2");
//    private final RString 決定日 = new RString("決定日");
//    private final RString 申請日 = new RString("申請日");
    //private final RString 負担限度額認定 = new RString("負担限度額認定");
    private final RString 社会福祉法人等利用者負担軽減 = new RString("社会福祉法人等利用者負担軽減");

    /**
     * コンストラクタです。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public GemmenGengakuShoIkkatsuMainHandler(GemmenGengakuShoIkkatsuMainDiv div) {
        this.div = div;
    }

    /**
     * バッチパラメータの復元と初期化画面の表示。
     *
     */
    public void 初期化画面の表示() {
        RString 減免減額種類 = GemmenGengakuShurui.負担限度額認定.get名称();
        div.getSakuseiTaisho().getDdlGemmenGengakuShurui().setSelectedValue(減免減額種類);
        BatchParameterManager batchParameterManager = new BatchParameterManager(SubGyomuCode.DBD介護受給, 負担のBATCH_ID);
        BatchParameterMap batchMap = batchParameterManager.getParameterByBatch();
        FlexibleDate 前回対象日From = batchMap.getParameterValue(FlexibleDate.class, 負担対象FROM);
        FlexibleDate 前回対象日To = batchMap.getParameterValue(FlexibleDate.class, 負担対象TO);
        RString 対象区分 = batchMap.getParameterValue(RString.class, 負担対象KUBUN);
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuTanpyoHakkoKubun()
                .setSelectedValue(TanpyoHakkoKubun.出力しない.get名称());
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuKyusochishaKubun()
                .setSelectedValue(KyusochishaKubun.旧措置者以外.get名称());
        if (前回対象日From != null) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdFrom().setValue(前回対象日From);
        } else {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdFrom().clearValue();
        }
        if (前回対象日To != null) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdTo().setValue(前回対象日To);
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().setValue(前回対象日To.plusDay(1));
        } else {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdTo().clearValue();
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().clearValue();
        }
        if (対象区分 != null) {
            if (対象区分.equals(TaishoKubun.決定日.getコード())) {
                div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.決定日.get名称());
            }
            if (対象区分.equals(TaishoKubun.申請日.getコード())) {
                div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.申請日.get名称());
            }
        }
        if (対象区分 == null || 対象区分.isEmpty()) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.決定日.get名称());
        }
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().setValue(FlexibleDate.getNowDate());
        div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().setValue(FlexibleDate.getNowDate());
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().setValue(FlexibleDate.getNowDate());
        FlexibleDate 発行日 = div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().getValue();
        div.getFutanGendogaku().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().initialize(負担帳票のID, 発行日);
        div.getFutanGendogaku().getCcdFutanGendogakuShutsuryokuJun().load(SubGyomuCode.DBD介護受給, 負担出力帳票ID);
    }

    /**
     * バッチパラメータの復元と社会画面の表示。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void 社会画面の表示(GemmenGengakuShoIkkatsuMainDiv div) {
        BatchParameterManager batchParameterManager = new BatchParameterManager(SubGyomuCode.DBD介護受給, 社会福祉のBATCH_ID);
        BatchParameterMap batchMap = batchParameterManager.getParameterByBatch();
        FlexibleDate 前回対象日From = batchMap.getParameterValue(FlexibleDate.class, 社会福祉対象FROM);
        FlexibleDate 前回対象日To = batchMap.getParameterValue(FlexibleDate.class, 社会福祉対象TO);
        //div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuKyusochishaKubun().setVisible(false);
        //div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setVisible(false);
        if (前回対象日From != null) {
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenZenkaiTaishoYmdFrom().setValue(前回対象日From);
        } else {
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenZenkaiTaishoYmdFrom().clearValue();
        }
        if (前回対象日To != null) {
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenZenkaiTaishoYmdTo().setValue(前回対象日To);
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().setValue(前回対象日To.plusDay(1));
        } else {
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenZenkaiTaishoYmdTo().clearValue();
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().clearValue();
        }
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdTo().setValue(FlexibleDate.getNowDate());
        div.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd().clearValue();
        div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd().clearValue();
        div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getCcdShafukuKeigenKetteiTsuchishoBunshoNo().initialize(社会福祉帳票のID);
        div.getShafukuKeigen().getCcdShafukuKeigenShutsuryokuJun().load(SubGyomuCode.DBD介護受給, 社会福祉出力帳票ID);
    }

    /**
     * バッチパラメータの復元と負担画面の表示。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void 負担画面の表示(GemmenGengakuShoIkkatsuMainDiv div) {
        BatchParameterManager batchParameterManager = new BatchParameterManager(SubGyomuCode.DBD介護受給, 負担のBATCH_ID);
        BatchParameterMap batchMap = batchParameterManager.getParameterByBatch();
        FlexibleDate 前回対象日From = batchMap.getParameterValue(FlexibleDate.class, 負担対象FROM);
        FlexibleDate 前回対象日To = batchMap.getParameterValue(FlexibleDate.class, 負担対象TO);
        RString 対象区分 = batchMap.getParameterValue(RString.class, 負担対象KUBUN);
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuTanpyoHakkoKubun()
                .setSelectedValue(TanpyoHakkoKubun.出力しない.get名称());
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuKyusochishaKubun()
                .setSelectedValue(KyusochishaKubun.旧措置者以外.get名称());
        if (前回対象日From != null) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdFrom().setValue(前回対象日From);
        } else {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdFrom().clearValue();
        }
        if (前回対象日To != null) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdTo().setValue(前回対象日To);
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().setValue(前回対象日To.plusDay(1));
        } else {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdTo().clearValue();
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().clearValue();
        }
        if (対象区分 != null) {
            if (対象区分.equals(TaishoKubun.決定日.getコード())) {
                div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.決定日.get名称());
            }
            if (対象区分.equals(TaishoKubun.申請日.getコード())) {
                div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.申請日.get名称());
            }
        }
        if (対象区分 == null || 対象区分.isEmpty()) {
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().setSelectedValue(TaishoKubun.決定日.get名称());
        }
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().setValue(FlexibleDate.getNowDate());
        div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().clearValue();
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().clearValue();
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().initialize(負担帳票のID);
        div.getFutanGendogaku().getCcdFutanGendogakuShutsuryokuJun().load(SubGyomuCode.DBD介護受給, 負担出力帳票ID);
    }

    /**
     * 作成対象の選択。
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public ResponseData<GemmenGengakuShoIkkatsuMainDiv> 作成対象の選択() {
        RString 減免減額種類 = div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue();
        RString 負担限度額認定 = GemmenGengakuShurui.負担限度額認定.get名称();
        if (減免減額種類.equals(社会福祉法人等利用者負担軽減)) {
            減免減額種類 = new RString("社会福祉法人等軽減");
        }
        //RString 社会福祉法人等利用者負担軽 = GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称();
        if (減免減額種類.equals(負担限度額認定)) {
            負担画面の表示(div);
            return ResponseData.of(div).setState(DBD1060001StateName.負担限度額認定);
        }
        if (減免減額種類.equals(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称())) {
            社会画面の表示(div);
            return ResponseData.of(div).setState(DBD1060001StateName.社福軽減);
        }
        return ResponseData.of(div).setState(DBD1060001StateName.NoChange);
    }

    /**
     * 文書番号チェックの方法。
     *
     * @return ResponseData<GemmenGengakuShoIkkatsuMainDiv>
     */
    public RString 文書番号チェック() {
        RString 文書番号発番方法 = new RString("");
        RString 減免減額種類 = div.getSakuseiTaisho().getDdlGemmenGengakuShurui().getSelectedValue();
        if (減免減額種類.equals(社会福祉法人等利用者負担軽減)) {
            減免減額種類 = new RString("社会福祉法人等軽減");
        }
        if (減免減額種類.equals(GemmenGengakuShurui.負担限度額認定.get名称())) {
            FlexibleDate 基準日 = div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().getValue();
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            BunshoNo bunshoNo = finder.get文書番号管理(負担帳票のID, 基準日);
            文書番号発番方法 = bunshoNo.get文書番号発番方法();
            return 文書番号発番方法;
        }
        if (減免減額種類.equals(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称())) {
            FlexibleDate 基準日 = div.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd().getValue();
            IBunshoNoFinder finder = BunshoNoFinderFactory.createInstance();
            BunshoNo bunshoNo = finder.get文書番号管理(社会福祉帳票のID, 基準日);
            文書番号発番方法 = bunshoNo.get文書番号発番方法();
            return 文書番号発番方法;
        }
        return 文書番号発番方法;

    }

    /**
     * 実行ボタンを押下する場合、画面項目負担限度額認定の設定値をバッチパラメータに設定、更新する。
     *
     * @return FutanGendogakuIkkatsuHakkoBatchParameter
     */
    public FutanGendogakuIkkatsuHakkoBatchParameter onClick_btnJikkouFtanSave() {
        RString 単票発行区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuTanpyoHakkoKubun().getSelectedValue();
        RString 旧措置者区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuKyusochishaKubun().getSelectedValue();
        RString 対象区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().getSelectedValue();
        boolean tanpyokubun = false;
        boolean kyusochikubun = false;
        boolean 認定証発行フラグ = div.getFutanGendogaku().getFutanGendogakuNinteisho().isIsPublish();
        boolean 通知書発行フラグ = div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().isIsPublish();
        FlexibleDate nendoYMDFrom = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoFrom().getValue();
        FlexibleDate nendoYMDTo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoTo().getValue();
        FlexibleDate taishoYMDFrom = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().getValue();
        FlexibleDate taishoYMDTo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuZenkaiTaishoYmdTo().getValue();
        FlexibleDate ninteishoKofuYMD = div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().getValue();
        FlexibleDate tsuchishoHakkoYMD = div.getFutanGendogaku()
                .getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().getValue();
        RString 通知書の文書番号 = div.getFutanGendogaku()
                .getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().get文書番号();
        RString 改頁出力順ID = new RString("");
        if (div.getFutanGendogaku().getCcdFutanGendogakuShutsuryokuJun().isSelected()) {
            改頁出力順ID = div.getShafukuKeigen().getCcdShafukuKeigenShutsuryokuJun().getSelected出力順().get改頁項目ID();
        }
        if (単票発行区分.equals(TanpyoHakkoKubun.出力する.get名称())) {
            tanpyokubun = true;
        }
        if (旧措置者区分.equals(KyusochishaKubun.旧措置者.get名称())) {
            kyusochikubun = true;
        }
        if (対象区分.equals(TaishoKubun.決定日.get名称())) {
            対象区分 = new RString("1");
        }
        if (対象区分.equals(TaishoKubun.申請日.get名称())) {
            対象区分 = new RString("2");
        }

        return new FutanGendogakuIkkatsuHakkoBatchParameter(tanpyokubun, kyusochikubun, nendoYMDFrom, nendoYMDTo, 対象区分, taishoYMDFrom,
                taishoYMDTo, 認定証発行フラグ, ninteishoKofuYMD, 通知書発行フラグ, tsuchishoHakkoYMD, 通知書の文書番号, 改頁出力順ID);
    }

    /**
     * 実行ボタンを押下する場合、画面項目会福祉法人等利用者負担軽減の設定値をバッチパラメータに設定、更新する。
     *
     * @return FutanGendogakuIkkatsuHakkoBatchParameter
     */
    public ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter onClick_btnJikkouSkaiSave() {
        RString 単票発行区分 = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getRadShafukuKeigenTanpyoHakkoKubun().getSelectedValue();
        boolean tanpyokubun = false;
        boolean 認定証発行フラグ = div.getShafukuKeigen().getShafukuKeigenKakuninSho().isIsPublish();
        boolean 通知書発行フラグ = div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().isIsPublish();
        FlexibleDate nendoYMDFrom = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoFrom().getValue();
        FlexibleDate nendoYMDTo = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoTo().getValue();
        FlexibleDate ketteiYMDFrom = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdFrom().getValue();
        FlexibleDate ketteiYMDTo = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenKonkaiTaishoYmdTo().getValue();
        FlexibleDate ninteishoKofuYMD = div.getShafukuKeigen().getShafukuKeigenKakuninSho().getTxtShafukuKeigenKakuninShoKofuYmd().getValue();
        FlexibleDate tsuchishoHakkoYMD = div.getShafukuKeigen()
                .getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd().getValue();
        RString 通知書の文書番号 = div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getCcdShafukuKeigenKetteiTsuchishoBunshoNo().get文書番号();
        RString 改頁出力順ID = new RString("");
        if (div.getShafukuKeigen().getCcdShafukuKeigenShutsuryokuJun().isSelected()) {
            改頁出力順ID = div.getShafukuKeigen().getCcdShafukuKeigenShutsuryokuJun().getSelected出力順().get改頁項目ID();
        }
        if (単票発行区分.equals(TanpyoHakkoKubun.出力する.get名称())) {
            tanpyokubun = true;
        }

        return new ShakaiFukushiHojinKeigenIkkatsuHakkoBatchParameter(tanpyokubun, nendoYMDFrom, nendoYMDTo, ketteiYMDFrom,
                ketteiYMDTo, 認定証発行フラグ, ninteishoKofuYMD, 通知書発行フラグ, tsuchishoHakkoYMD, 通知書の文書番号, 改頁出力順ID);
    }

    /**
     * 負担限度額認定の年度設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void geFuTanNendo(GemmenGengakuShoIkkatsuMainDiv div) {
        FlexibleYear nendo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendo().getDomain();
        if (nendo != null) {
            INendo getNendo = GemmenNendoResearcher.createInstance(GemmenGengakuShurui.負担限度額認定).find年度(nendo);
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoFrom().setValue(getNendo.get開始日());
            div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoTo().setValue(getNendo.get終了日());
        }
    }

    /**
     * 社会福祉法人等利用者負担軽減の年度設定、更新する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void getShakaiNendo(GemmenGengakuShoIkkatsuMainDiv div) {
        FlexibleYear nendo = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendo().getDomain();
        if (nendo != null) {
            INendo getNendo = GemmenNendoResearcher.createInstance(GemmenGengakuShurui.負担限度額認定).find年度(nendo);
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoFrom().setValue(getNendo.get開始日());
            div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getTxtShafukuKeigenNendoTo().setValue(getNendo.get終了日());
        }
    }

    /**
     * 負担限度額認定の文書番号入力を再生成する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void futanBunshoSaiseisei(GemmenGengakuShoIkkatsuMainDiv div) {
        FlexibleDate 基準日 = div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().getValue();
        div.getFutanGendogaku().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().initialize(負担帳票のID, 基準日);
    }

    /**
     * 社会福祉法人等利用者負担軽減の文書番号入力を再生成する。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     */
    public void shakaiBunshoSaiseisei(GemmenGengakuShoIkkatsuMainDiv div) {
        FlexibleDate 基準日 = div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getTxtShafukuKeigenKetteiTsuchishoHakkoYmd().getValue();
        div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().getCcdShafukuKeigenKetteiTsuchishoBunshoNo().initialize(社会福祉帳票のID, 基準日);
    }

    /**
     * 減免・減額種類選択のKEY。
     *
     */
    public enum SelectKey {

        /**
         * 負担限度額認定 key0
         */
        key0(new RString("key0")),
        /**
         * 社会福祉法人等利用者負担軽減 key1
         */
        key1(new RString("key1"));

        private final RString value;

        private SelectKey(RString value) {
            this.value = value;
        }

        /**
         * valueを返します
         *
         * @return value
         */
        public RString getValue() {
            return value;
        }
    }

}
