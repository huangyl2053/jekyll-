/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1090001;

import java.util.ArrayList;
import java.util.HashMap;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100008.HakkoRirekiKoyuJohoDBD100008;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.RiyoshaFutanDankai;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.KyuSochishaKubun;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.futangendogakunintei.ShinseiRiyuKubun;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.DBD1090001StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.DBD1090001TransitionEventName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001.FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.report.futangendogakunintei.FutanGendogakuNinteiKanshoTsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行のクラスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
public class FutanGendogakuNinteiKousinTsuchisyoKobetHakko {

    /**
     * 負担限度額認定更新のお知らせ通知書個別発行の初期化。(オンロード)<br/>
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onLoad(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        div.getCcdKaigoAtenaInfoDiv().initialize(識別コード);

        if (new RString(DbdInformationMessages.受給共通_被保データなし.getMessage().getCode())
                .equals(ResponseHolder.getMessageCode())) {
            return ResponseData.of(div).respond();
        }
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            getHandler().setアクセスログ(被保険者番号, 識別コード);

            div.getBtnZenRireki().setDisabled(true);
            div.getBtnShotaiJohou().setDisabled(true);
            div.getBtnGoRireki().setDisabled(true);

            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        } else {
            div.getCcdKaigoShikakuKihonDiv().initialize(被保険者番号);
        }

        div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getCcdBunshoBangoInputDiv()
                .initialize(ReportIdDBD.DBDPR12002_1_1.getReportId());

        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList = getHandler().get介護負担限度額認定(被保険者番号, 識別コード);
        ViewStateHolder.put(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.KgHoukenFutanGendogakuNintei.リストキー, futanGendogakuNinteiList);
        if (!futanGendogakuNinteiList.isEmpty()) {
            set負担限度額認定エリア(div, futanGendogakuNinteiList.get(0));
            div.setListIndex(new RString(Integer.toString(0)));
            div.getBtnGoRireki().setDisabled(true);
            if (1 == futanGendogakuNinteiList.size()) {
                div.getBtnZenRireki().setDisabled(true);
            }
        } else {
            div.setListIndex(new RString("0"));
            div.getBtnZenRireki().setDisabled(true);
            div.getBtnGoRireki().setDisabled(true);
        }
        getHandler().setアクセスログ(被保険者番号, 識別コード);

        div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD()
                .setValue(RDate.getNowDate());

        return ResponseData.of(div).respond();
    }

    /**
     * 世帯情報を表示するボタンをクッリク
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnShotaiJohou(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
        div.getCcdSetaiShotokuIchiran().initialize(識別コード, FlexibleDate.getNowDate(), new HizukeConfig().get所得年度(), YMDHMS.now());
        div.getBtnShotaiJohou().setDisplayNone(true);
        div.getBtnReturnChohyoHakko().setDisplayNone(false);
        return ResponseData.of(div).setState(DBD1090001StateName.世帯所得一覧);
    }

    /**
     * 世帯情報を表示するボタンをクッリク
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnReturnChohyoHakko(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        div.getBtnShotaiJohou().setDisplayNone(false);
        div.getBtnReturnChohyoHakko().setDisplayNone(true);
        return ResponseData.of(div).setState(DBD1090001StateName.負担限度額認定);
    }

    private FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler getHandler() {
        return new FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler();
    }

    private FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler getValidationHandler() {
        return new FutanGendogakuNinteiKousinTsuchisyoKobetHakkoValidationHandler();
    }

    private void set負担限度額認定エリア(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div, FutanGendogakuNintei futanGendogakuNintei) {
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtKeqteiKubunn().setValue(
                futanGendogakuNintei.get決定区分() == null || futanGendogakuNintei.get決定区分().isEmpty()
                ? RString.EMPTY : KetteiKubun.toValue(futanGendogakuNintei.get決定区分()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtSinnseiRiyuu().setValue(
                futanGendogakuNintei.get申請理由区分() == null || futanGendogakuNintei.get申請理由区分().isEmpty()
                ? RString.EMPTY : ShinseiRiyuKubun.toValue(futanGendogakuNintei.get申請理由区分()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtFutanDankai().setValue(
                futanGendogakuNintei.get利用者負担段階() == null || futanGendogakuNintei.get利用者負担段階().isEmpty()
                ? RString.EMPTY : RiyoshaFutanDankai.toValue(futanGendogakuNintei.get利用者負担段階()).get名称());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyusoti().setValue(
                futanGendogakuNintei.get旧措置者区分() == null || futanGendogakuNintei.get旧措置者区分().isEmpty()
                ? RString.EMPTY : KyuSochishaKubun.toValue(futanGendogakuNintei.get旧措置者区分()).get名称());
        if (futanGendogakuNintei.is境界層該当者区分()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyoukaiso().setValue(new RString("該当"));
        } else {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtKyoukaiso().setValue(new RString("非該当"));
        }
        if (futanGendogakuNintei.is激変緩和措置対象者区分()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtGekihenKanwa().setValue(new RString("対象者"));
        } else {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtGekihenKanwa().setValue(new RString("対象者以外"));
        }
        if (!futanGendogakuNintei.get申請年月日().isEmpty()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtSinnseiDate().setValue(new RDate(futanGendogakuNintei.get申請年月日().toString()));
        }
        if (!futanGendogakuNintei.get決定年月日().isEmpty()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtKeqteiDate().setValue(new RDate(futanGendogakuNintei.get決定年月日().toString()));
        }
        if (!futanGendogakuNintei.get適用開始年月日().isEmpty()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtTekiyouDate().setValue(new RDate(futanGendogakuNintei.get適用開始年月日().toString()));
        }
        if (!futanGendogakuNintei.get適用終了年月日().isEmpty()) {
            div.getHihokenshashoHakkoTaishoshaJoho().getTxtYuukouKigenDate().setValue(new RDate(futanGendogakuNintei.get適用終了年月日().toString()));
        }
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtShokuhiNum().setValue(futanGendogakuNintei.get食費負担限度額());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtYunittoketaKoshitsuNum().setValue(futanGendogakuNintei.getユニット型個室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtYunittoketaJyunKoshitsuNum().setValue(futanGendogakuNintei.getユニット型準個室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtJuuraiKoshitsuLNum().setValue(futanGendogakuNintei.get従来型個室_老健_療養等());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtJuuraiKoshitsuTNum().setValue(futanGendogakuNintei.get従来型個室_特養等());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtTkutokosituNum().setValue(futanGendogakuNintei.get多床室());
        div.getHihokenshashoHakkoTaishoshaJoho().getTxtFushouninRiyuLine().setValue(futanGendogakuNintei.get非承認理由());
        div.setRirekiNo(new RString(futanGendogakuNintei.get履歴番号()));
    }

    /**
     * 「前履歴を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnZenrireki(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        div.getBtnGoRireki().setDisabled(false);
        int listIndex = Integer.valueOf(div.getListIndex().toString());
        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList
                = ViewStateHolder.get(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.KgHoukenFutanGendogakuNintei.リストキー, ArrayList.class);
        set負担限度額認定エリア(div, futanGendogakuNinteiList.get(listIndex + 1));
        div.setListIndex(new RString(listIndex + 1));
        if (Integer.valueOf(div.getListIndex().toString()) == (futanGendogakuNinteiList.size() - 1)) {
            div.getBtnZenRireki().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「後履歴を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnGorireki(
            FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {

        int listIndex = Integer.valueOf(div.getListIndex().toString());
        ArrayList<FutanGendogakuNintei> futanGendogakuNinteiList
                = ViewStateHolder.get(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler.KgHoukenFutanGendogakuNintei.リストキー, ArrayList.class);
        set負担限度額認定エリア(div, futanGendogakuNinteiList.get(listIndex - 1));
        div.getBtnZenRireki().setDisabled(false);
        div.setListIndex(new RString(listIndex - 1));
        if (Integer.valueOf(div.getListIndex().toString()) == 0) {
            div.getBtnGoRireki().setDisabled(true);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタン実行前、必須入力チェックを行います。
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_validate(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力チェックボックス(pairs, div);
        getValidationHandler().validateFor発行日の必須入力(pairs, div);
        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        RDate 発行日 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu()
                .getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue();
        RString 文書番号 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu()
                .getHenkoTsuchiKobetsu().getCcdBunshoBangoInputDiv().get文書番号();
        boolean お知らせ通知書 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish();
        boolean 申請書 = div.getHihokenshashoHakkoTaishoshaJoho().getTsuchishoSakuseiKobetsu().getFutanGendogakuNinteiHeddaXinseiSyo().isIsPublish();

        FutanGendogakuNinteiKanshoTsuchisho tsuchisho = FutanGendogakuNinteiKanshoTsuchisho.createInstance();
        int rirekiNo = div.getRirekiNo().isEmpty() ? 0 : Integer.valueOf(div.getRirekiNo().toString());
        try (ReportManager reportManager = new ReportManager()) {
            tsuchisho.publish(被保険者番号, 識別コード, rirekiNo, 発行日, 文書番号, お知らせ通知書, 申請書, reportManager);
            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(HakkoRirekiKoyuJohoDBD100008.被保番号.getコード(), 被保険者番号.getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            for (SourceData data : collection) {
                if (data.getReportId().equals(ReportIdDBD.DBDPR12002_1_1.getReportId().value())) {
                    tsuchisho.insert発行履歴(data, 発行日, 識別コード, hashMap);
                }
            }
            response.data = collection;
        }
        return response;
    }

    /**
     * 「検索結果一覧へ」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnReturn(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD1090001TransitionEventName.検索に戻る).respond();
    }

    /**
     * 「再検索する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv> onClick_btnReSearch(FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv div) {
        return ResponseData.of(div).forwardWithEventName(DBD1090001TransitionEventName.再検索する).respond();
    }
}
