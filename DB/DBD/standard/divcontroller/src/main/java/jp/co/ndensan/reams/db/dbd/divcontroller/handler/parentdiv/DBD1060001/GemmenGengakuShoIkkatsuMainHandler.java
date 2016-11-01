/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1060001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103010.DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103020.DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.common.KyusochishaKubun;
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
        FlexibleDate 発行日 = FlexibleDate.getNowDate();
        負担画面の表示(div, 発行日);
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().setValue(FlexibleDate.getNowDate());
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().setValue(FlexibleDate.getNowDate());
        div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().setValue(FlexibleDate.getNowDate());
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
     * 「負担条件を保存する」ボタンの押下処理です。
     *
     * @return BatchParameterMap
     */
    public BatchParameterMap onClick_btnBatchFutanParameterSave() {
        return new BatchParameterMap(onClick_btnJikkouFtanSave());
    }

    /**
     * 「社会条件を保存する」ボタンの押下処理です。
     *
     * @return BatchParameterMap
     */
    public BatchParameterMap onClick_btnBatchShakaiParameterSave() {
        return new BatchParameterMap(onClick_btnJikkouSkaiSave());
    }

    /**
     * バッチパラメータの復元と負担画面の表示。
     *
     * @param div GemmenGengakuShoIkkatsuMainDiv
     * @param hakkohi FlexibleDate
     */
    public void 負担画面の表示(GemmenGengakuShoIkkatsuMainDiv div, FlexibleDate hakkohi) {
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
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().initialize(負担帳票のID, hakkohi);
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
        if (減免減額種類.equals(負担限度額認定)) {
            負担画面の表示(div, FlexibleDate.getNowDate());
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
    public DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter onClick_btnJikkouFtanSave() {
        RString 単票発行区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuTanpyoHakkoKubun().getSelectedValue();
        RString 旧措置者区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuKyusochishaKubun().getSelectedValue();
        RString 対象区分 = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getRadFutanGendogakuJoken().getSelectedValue();
        boolean 認定証発行フラグ = div.getFutanGendogaku().getFutanGendogakuNinteisho().isIsPublish();
        boolean 通知書発行フラグ = div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().isIsPublish();
        FlexibleDate nendoYMDFrom = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoFrom().getValue();
        FlexibleDate nendoYMDTo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuNendoTo().getValue();
        FlexibleDate taishoYMDFrom = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdFrom().getValue();
        FlexibleDate taishoYMDTo = div.getFutanGendogaku().getFutanGendogakuChushutsuJoken().getTxtFutanGendogakuKonkaiTaishoYmdTo().getValue();
        FlexibleDate ninteishoKofuYMD = div.getFutanGendogaku().getFutanGendogakuNinteisho().getTxtFutanGendogakuNinteishoKofuYmd().getValue();
        FlexibleDate tsuchishoHakkoYMD = div.getFutanGendogaku()
                .getFutanGendogakuKetteiTsuchisho().getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().getValue();
        RString 通知書の文書番号 = div.getFutanGendogaku()
                .getFutanGendogakuKetteiTsuchisho().getCcdFutanGendogakuKetteiTsuchishoBunshoNo().get文書番号();
        DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter futanParameter = new DBD103010_FutanGendoGakuNinteiIkkatsuHakkoParameter();
        futanParameter.set単票発行区分(TanpyoHakkoKubun.出力しない);
        futanParameter.set旧措置者区分(KyusochishaKubun.旧措置者以外);
        Long 改頁ID = div.getFutanGendogaku().getCcdFutanGendogakuShutsuryokuJun().get出力順ID();
        if (単票発行区分.equals(TanpyoHakkoKubun.出力する.get名称())) {
            futanParameter.set単票発行区分(TanpyoHakkoKubun.出力する);
        }
        if (旧措置者区分.equals(KyusochishaKubun.旧措置者.get名称())) {
            futanParameter.set旧措置者区分(KyusochishaKubun.旧措置者);
        }
        if (対象区分.equals(TaishoKubun.決定日.get名称())) {
            futanParameter.set対象区分(TaishoKubun.決定日);
        }
        if (対象区分.equals(TaishoKubun.申請日.get名称())) {
            futanParameter.set対象区分(TaishoKubun.申請日);
        }
        futanParameter.set年度開始日(nendoYMDFrom);
        futanParameter.set年度終了日(nendoYMDTo);
        futanParameter.set対象日FROM(taishoYMDFrom);
        futanParameter.set対象日TO(taishoYMDTo);
        futanParameter.set認定証発行フラグ(認定証発行フラグ);
        futanParameter.set認定証の交付日(ninteishoKofuYMD);
        futanParameter.set通知書発行フラグ(通知書発行フラグ);
        futanParameter.set通知書の交付日(tsuchishoHakkoYMD);
        futanParameter.set通知書の文書番号(通知書の文書番号);
        futanParameter.set改頁出力順ID(改頁ID);
        return futanParameter;
    }

    /**
     * 実行ボタンを押下する場合、画面項目会福祉法人等利用者負担軽減の設定値をバッチパラメータに設定、更新する。
     *
     * @return FutanGendogakuIkkatsuHakkoBatchParameter
     */
    public DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter onClick_btnJikkouSkaiSave() {
        RString 単票発行区分 = div.getShafukuKeigen().getShafukuKeigenChushutsuJoken().getRadShafukuKeigenTanpyoHakkoKubun().getSelectedValue();
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
        Long 改頁ID = div.getShafukuKeigen().getCcdShafukuKeigenShutsuryokuJun().get出力順ID();
        DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter shaParameter = new DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter();
        shaParameter.set単票発行区分(TanpyoHakkoKubun.出力しない);

        if (単票発行区分.equals(TanpyoHakkoKubun.出力する.get名称())) {
            shaParameter.set単票発行区分(TanpyoHakkoKubun.出力する);
        }
        shaParameter.set年度開始日(nendoYMDFrom);
        shaParameter.set年度終了日(nendoYMDTo);
        shaParameter.set対象日FROM(ketteiYMDFrom);
        shaParameter.set対象日TO(ketteiYMDTo);
        shaParameter.set認定証発行フラグ(認定証発行フラグ);
        shaParameter.set認定証の交付日(ninteishoKofuYMD);
        shaParameter.set通知書発行フラグ(通知書発行フラグ);
        shaParameter.set通知書の発行日(tsuchishoHakkoYMD);
        shaParameter.set通知書の文書番号(通知書の文書番号);
        shaParameter.set改頁出力順ID(改頁ID);
        return shaParameter;
    }

    /**
     * 「負担条件を復元する」ボタンの押下処理です。
     *
     * @return MemoListOutputDiv
     */
    public GemmenGengakuShoIkkatsuMainDiv onClick_btnBatchFutanParameterRestore() {
        BatchParameterMap map = div.getBtnFutanGendogakuParameterRestore().getRestoreBatchParameterMap();
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getRadFutanGendogakuTanpyoHakkoKubun().setSelectedValue(map.getParameterValue(RString.class, new RString("単票発行区分")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getRadFutanGendogakuKyusochishaKubun().setSelectedValue(map.getParameterValue(RString.class, new RString("旧措置者区分")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getTxtFutanGendogakuNendoFrom().setValue(map.getParameterValue(FlexibleDate.class, new RString("年度開始日")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getTxtFutanGendogakuNendoTo().setValue(map.getParameterValue(FlexibleDate.class, new RString("年度終了日")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getRadFutanGendogakuJoken().setSelectedValue(map.getParameterValue(RString.class, new RString("対象区分")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getTxtFutanGendogakuKonkaiTaishoYmdFrom().setValue(map.getParameterValue(FlexibleDate.class, new RString("対象日FROM")));
        div.getFutanGendogaku().getFutanGendogakuChushutsuJoken()
                .getTxtFutanGendogakuKonkaiTaishoYmdTo().setValue(map.getParameterValue(FlexibleDate.class, new RString("対象日TO")));
        boolean ninteihakoFlag = map.getParameterValue(boolean.class, new RString("認定証発行フラグ"));
        boolean tsuchishohakoFlag = map.getParameterValue(boolean.class, new RString("通知書発行フラグ"));
        if (ninteihakoFlag) {
            div.getFutanGendogaku().getFutanGendogakuNinteisho().setIsPublish(true);
            div.getFutanGendogaku().getFutanGendogakuNinteisho().setIsOpen(true);
        } else {
            div.getFutanGendogaku().getFutanGendogakuNinteisho().setIsPublish(false);
            div.getFutanGendogaku().getFutanGendogakuNinteisho().setIsOpen(false);
        }
        div.getFutanGendogaku().getFutanGendogakuNinteisho()
                .getTxtFutanGendogakuNinteishoKofuYmd().setValue(map.getParameterValue(FlexibleDate.class, new RString("認定証の交付日")));
        if (tsuchishohakoFlag) {
            div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().setIsPublish(true);
            div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().setIsOpen(true);
        } else {
            div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().setIsPublish(false);
            div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho().setIsOpen(false);
        }
        div.getFutanGendogaku().getFutanGendogakuKetteiTsuchisho()
                .getTxtFutanGendogakuKetteiTsuchishoHakkoYmd().setValue(map.getParameterValue(FlexibleDate.class, new RString("通知書の交付日")));
        return div;
    }

    /**
     * 「社会条件を復元する」ボタンの押下処理です。
     *
     * @return MemoListOutputDiv
     */
    public GemmenGengakuShoIkkatsuMainDiv onClick_btnBatchShakaiParameterRestore() {
        BatchParameterMap map = div.getBtnShafukuParameterRestore().getRestoreBatchParameterMap();
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken()
                .getRadShafukuKeigenTanpyoHakkoKubun().setSelectedValue(map.getParameterValue(RString.class, new RString("単票発行区分")));
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken()
                .getTxtShafukuKeigenNendoFrom().setValue(map.getParameterValue(FlexibleDate.class, new RString("年度開始日")));
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken()
                .getTxtShafukuKeigenNendoTo().setValue(map.getParameterValue(FlexibleDate.class, new RString("年度終了日")));
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken()
                .getTxtShafukuKeigenKonkaiTaishoYmdFrom().setValue(map.getParameterValue(FlexibleDate.class, new RString("対象日FROM")));
        div.getShafukuKeigen().getShafukuKeigenChushutsuJoken()
                .getTxtShafukuKeigenKonkaiTaishoYmdTo().setValue(map.getParameterValue(FlexibleDate.class, new RString("対象日TO")));
        boolean ninteihakoFlag = map.getParameterValue(boolean.class, new RString("認定証発行フラグ"));
        boolean tsuchishohakoFlag = map.getParameterValue(boolean.class, new RString("通知書発行フラグ"));
        if (ninteihakoFlag) {
            div.getShafukuKeigen().getShafukuKeigenKakuninSho().setIsPublish(true);
            div.getShafukuKeigen().getShafukuKeigenKakuninSho().setIsOpen(true);
        } else {
            div.getShafukuKeigen().getShafukuKeigenKakuninSho().setIsPublish(false);
            div.getShafukuKeigen().getShafukuKeigenKakuninSho().setIsOpen(false);
        }
        div.getShafukuKeigen().getShafukuKeigenKakuninSho()
                .getTxtShafukuKeigenKakuninShoKofuYmd().setValue(map.getParameterValue(FlexibleDate.class, new RString("認定証の交付日")));
        if (tsuchishohakoFlag) {
            div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().setIsPublish(true);
            div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().setIsOpen(true);
        } else {
            div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().setIsPublish(false);
            div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho().setIsOpen(false);
        }
        div.getShafukuKeigen().getShafukuKeigenKetteiTsuchisho()
                .getTxtShafukuKeigenKetteiTsuchishoHakkoYmd().setValue(map.getParameterValue(FlexibleDate.class, new RString("通知書の発行日")));
        return div;
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
