/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD1090002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.homonkaigogengaku.HomonKaigoRiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.riyoshafutangengaku.RiyoshaFutangakuGengaku;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.shafukukeigen.ShakaifukuRiyoshaFutanKeigen;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.tokubetsuchikikasangemmen.TokubetsuchiikiKasanGemmen;
import jp.co.ndensan.reams.db.dbd.business.report.GemmenGengakuNinteishoKetteiTsuchisho;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100018.HakkoRirekiKoyuJohoDBD100018;
import jp.co.ndensan.reams.db.dbd.business.report.dbd100020.HakkoRirekiKoyuJohoDBD100020;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.DBD1090002StateName;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1090002.dgChohyoSentaku_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainHandler.GemmenGengakuShoHakkoEnum;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090002.GemmenGengakuShoHakkoMainValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 * 減免減額認定証・決定通知書個別発行のクラスです。
 *
 * @reamsid_L DBD-3540-010 xuyue
 */
public class GemmenGengakuShoHakkoMain {

    /**
     * 初期化処理です。
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onLoad(GemmenGengakuShoHakkoMainDiv div) {
        viewStateKeyの廃棄();
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();

        div.getCcdHakkoTaishosaInfo().initialize(識別コード);
        div.getHihokenshashoHakkoTaishoshaJoho().getCcdHakkoTaishoshaShikaku().initialize(被保険者番号);

        div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().setDisplayNone(true);
        div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().setDisplayNone(true);
        div.getRiyoshaFutangakuGenmen().setDisplayNone(true);
        div.getFutanGendogakuNintei().setDisplayNone(true);
        div.getHomonKaigoRiyoshaFutangakuGengaku().setDisplayNone(true);
        div.getShafukuHojinToRiyushaFutanKeigen().setDisplayNone(true);
        div.getTokubetsuChilkiKasanGenmen().setDisplayNone(true);

        boolean is利用者負担額減免の情報存在 = getHandler(div).is利用者負担額減免の情報存在(被保険者番号);
        boolean is負担限度額認定の情報存在 = getHandler(div).is負担限度額認定の情報存在(被保険者番号);
        boolean is社会福祉法人等利用者負担軽減の情報存在 = getHandler(div).is社会福祉法人等利用者負担軽減の情報存在(被保険者番号);
        boolean is訪問介護利用者負担額減額の情報存在 = getHandler(div).is訪問介護利用者負担額減額の情報存在(被保険者番号);
        boolean is特別地域加算減免の情報存在 = getHandler(div).is特別地域加算減免の情報存在(被保険者番号);

        List<dgChohyoSentaku_Row> rowList = new ArrayList<>();
        if (is利用者負担額減免の情報存在) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(GemmenGengakuShurui.利用者負担額減額.get名称());
            row.setSelected(true);
            rowList.add(row);
        }
        if (is負担限度額認定の情報存在) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(GemmenGengakuShurui.負担限度額認定.get名称());
            row.setSelected(true);
            rowList.add(row);
        }
        if (is社会福祉法人等利用者負担軽減の情報存在) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称());
            row.setSelected(true);
            rowList.add(row);
        }
        if (is訪問介護利用者負担額減額の情報存在) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(GemmenGengakuShurui.訪問介護利用者負担額減額.get名称());
            row.setSelected(true);
            rowList.add(row);
        }
        if (is特別地域加算減免の情報存在) {
            dgChohyoSentaku_Row row = new dgChohyoSentaku_Row();
            row.setTxtChohyoSentaku(GemmenGengakuShurui.特別地域加算減免.get名称());
            row.setSelected(true);
            rowList.add(row);
        }
        div.getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().setDataSource(rowList);

        if (is利用者負担額減免の情報存在) {
            ArrayList<RiyoshaFutangakuGengaku> list = getHandler(div).get利用者負担額減免の情報(被保険者番号);
            getHandler(div).利用者負担額減額を選択する場合の設定(list, 被保険者番号);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.利用者負担額減額List, list);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, GemmenGengakuShurui.利用者負担額減額.get名称());

        } else if (is負担限度額認定の情報存在) {
            ArrayList<FutanGendogakuNintei> list = getHandler(div).get負担限度額認定の情報(被保険者番号);
            getHandler(div).負担限度額認定を選択する場合の設定(list, 被保険者番号);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.負担限度額認定List, list);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, GemmenGengakuShurui.負担限度額認定.get名称());

        } else if (is社会福祉法人等利用者負担軽減の情報存在) {
            ArrayList<ShakaifukuRiyoshaFutanKeigen> list = getHandler(div).get社会福祉法人等利用者負担軽減の情報(被保険者番号);
            getHandler(div).社会福祉法人等利用者負担軽減を選択する場合の設定(list, 被保険者番号);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, list);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称());

        } else if (is訪問介護利用者負担額減額の情報存在) {
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> list = getHandler(div).get訪問介護利用者負担額減額の情報(被保険者番号);
            getHandler(div).訪問介護利用者負担額減額を選択する場合の設定(list, 被保険者番号);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, list);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, GemmenGengakuShurui.訪問介護利用者負担額減額.get名称());

        } else if (is特別地域加算減免の情報存在) {
            ArrayList<TokubetsuchiikiKasanGemmen> list = getHandler(div).get特別地域加算減免の情報(被保険者番号);
            getHandler(div).特別地域加算減免を選択する場合の設定(list, 被保険者番号);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.特別地域加算減免List, list);
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, GemmenGengakuShurui.特別地域加算減免.get名称());
        } else if (!ResponseHolder.isReRequest()) {
            CommonButtonHolder.setDisabledByCommonButtonFieldName(new RString("btnPrint"), true);
            return ResponseData.of(div).addMessage(DbdInformationMessages.減免減額_発行可能通知書_認定証なし.getMessage()).respond();
        }

        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), 被保険者番号.value());
        PersonalData personalData = PersonalData.of(識別コード, expandedInfo);
        AccessLogger.log(AccessLogType.照会, personalData);
        return ResponseData.of(div).setState(DBD1090002StateName.Default);
    }

    /**
     * 世帯情報を表示するボタンをクッリク
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_btnOutputSetaiJoho(
            GemmenGengakuShoHakkoMainDiv div) {
        if (ViewStateHolder.get(GemmenGengakuShoHakkoEnum.is世帯初期化, Boolean.class) == null
                || !ViewStateHolder.get(GemmenGengakuShoHakkoEnum.is世帯初期化, Boolean.class)) {
            ShikibetsuCode 識別コード = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class).get識別コード();
            div.getSetaiShotokuShokai().getSetaiJoho().getCcdSetaiShotokuIchiran().
                    initialize(識別コード, FlexibleDate.getNowDate(), new HizukeConfig().get所得年度(), YMDHMS.now());
            ViewStateHolder.put(GemmenGengakuShoHakkoEnum.is世帯初期化, true);
        }

        return ResponseData.of(div).setState(DBD1090002StateName.setaiInfo);
    }

    /**
     * 帳票発行へ戻るボタンをクッリク
     *
     * @param div コントロールdiv
     * @return レスポンスデータ
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_btnReturnChohyoHakko(
            GemmenGengakuShoHakkoMainDiv div) {
        return ResponseData.of(div).setState(DBD1090002StateName.Default);
    }

    /**
     * 発行帳票グリッドを選択する処理です。
     *
     * @param div GemmenGengakuShoHakkoEnumJohoDiv
     * @return レスポンスデータ
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_dgChohyoSentaku(GemmenGengakuShoHakkoMainDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();

        RString 表示名 = div.getHakkoChohyoSentaku().getTsuchishoSakuseiKobetsu().getDgChohyoSentaku().getActiveRow().getTxtChohyoSentaku();
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, 表示名);
        if (GemmenGengakuShurui.利用者負担額減額.get名称().equals(表示名)) {
            ArrayList<RiyoshaFutangakuGengaku> list
                    = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.利用者負担額減額List, ArrayList.class);
            if (list == null) {
                list = getHandler(div).get利用者負担額減免の情報(被保険者番号);
                ViewStateHolder.put(GemmenGengakuShoHakkoEnum.利用者負担額減額List, list);
            }
            getHandler(div).利用者負担額減額を選択する場合の設定(list, 被保険者番号);
        } else if (GemmenGengakuShurui.負担限度額認定.get名称().equals(表示名)) {
            ArrayList<FutanGendogakuNintei> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.負担限度額認定List, ArrayList.class);
            if (list == null) {
                list = getHandler(div).get負担限度額認定の情報(被保険者番号);
                ViewStateHolder.put(GemmenGengakuShoHakkoEnum.負担限度額認定List, list);
            }
            getHandler(div).負担限度額認定を選択する場合の設定(list, 被保険者番号);
        } else if (GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称().equals(表示名)) {
            ArrayList<ShakaifukuRiyoshaFutanKeigen> list
                    = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, ArrayList.class);
            if (list == null) {
                list = getHandler(div).get社会福祉法人等利用者負担軽減の情報(被保険者番号);
                ViewStateHolder.put(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, list);
            }
            getHandler(div).社会福祉法人等利用者負担軽減を選択する場合の設定(list, 被保険者番号);
        } else if (GemmenGengakuShurui.訪問介護利用者負担額減額.get名称().equals(表示名)) {
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> list
                    = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, ArrayList.class);
            if (list == null) {
                list = getHandler(div).get訪問介護利用者負担額減額の情報(被保険者番号);
                ViewStateHolder.put(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, list);
            }
            getHandler(div).訪問介護利用者負担額減額を選択する場合の設定(list, 被保険者番号);
        } else if (GemmenGengakuShurui.特別地域加算減免.get名称().equals(表示名)) {
            ArrayList<TokubetsuchiikiKasanGemmen> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.特別地域加算減免List, ArrayList.class);
            if (list == null) {
                list = getHandler(div).get特別地域加算減免の情報(被保険者番号);
                ViewStateHolder.put(GemmenGengakuShoHakkoEnum.特別地域加算減免List, list);
            }
            getHandler(div).特別地域加算減免を選択する場合の設定(list, 被保険者番号);
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「前履歴を表示する」ボタンをクリックする
     *
     * @param div FutanGendogakuNinteiKousinTsuchisyoKobetHakkoDiv
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_btnZenrireki(GemmenGengakuShoHakkoMainDiv div) {

        div.getBtnOutputAtoRireki().setDisabled(false);

        RString 表示名 = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.減免減額種類, RString.class);
        if (GemmenGengakuShurui.利用者負担額減額.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getRiyoshaFutanGenmenInfoIndex().toString()) - 1;
            if (listIndex == 0) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
            div.setRiyoshaFutanGenmenInfoIndex(new RString(listIndex));
            ArrayList<RiyoshaFutangakuGengaku> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.利用者負担額減額List, ArrayList.class);

            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("利用者負担額減額・免除等認定証"));
            getHandler(div).set利用者負担額減免エリア(list.get(listIndex));

        } else if (GemmenGengakuShurui.負担限度額認定.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getFutanGendogakuNinteiIndex().toString()) - 1;
            if (listIndex == 0) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
            div.setFutanGendogakuNinteiIndex(new RString(listIndex));
            ArrayList<FutanGendogakuNintei> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.負担限度額認定List, ArrayList.class);

            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("負担限度額認定証"));
            getHandler(div).set負担限度額認定エリア(list.get(listIndex));
        } else if (GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getShafukuHojinToRiyushaFutanKeigenIndex().toString()) - 1;
            if (listIndex == 0) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
            div.setShafukuHojinToRiyushaFutanKeigenIndex(new RString(listIndex));
            ArrayList<ShakaifukuRiyoshaFutanKeigen> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, ArrayList.class);

            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("社会福祉法人等利用者負担軽減確認証"));
            getHandler(div).set社会福祉法人等利用者負担軽減エリア(list.get(listIndex));

        } else if (GemmenGengakuShurui.訪問介護利用者負担額減額.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getHomonKaigoRiyoshaFutangakuGengakuIndex().toString()) - 1;
            if (listIndex == 0) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
            div.setHomonKaigoRiyoshaFutangakuGengakuIndex(new RString(listIndex));
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, ArrayList.class);

            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("訪問介護等利用者負担額減額認定証"));
            getHandler(div).set訪問介護利用者負担額減額エリア(list.get(listIndex));
        } else if (GemmenGengakuShurui.特別地域加算減免.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getTokubetsuChilkiKasanGenmenIndex().toString()) - 1;
            if (listIndex == 0) {
                div.getBtnOutputMaeRireki().setDisabled(true);
            }
            div.setTokubetsuChilkiKasanGenmenIndex(new RString(listIndex));
            ArrayList<TokubetsuchiikiKasanGemmen> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.特別地域加算減免List, ArrayList.class);

            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("特別地域加算に係る訪問介護利用者負担減額確認証"));
            getHandler(div).set特別地域加算減免エリア(list.get(listIndex));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「後履歴を表示する」ボタンをクリックする
     *
     * @param div GemmenGengakuShoHakkoEnumJohoDiv
     * @return ResponseData
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_btnGorireki(GemmenGengakuShoHakkoMainDiv div) {

        div.getBtnOutputMaeRireki().setDisabled(false);

        RString 表示名 = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.減免減額種類, RString.class);
        if (GemmenGengakuShurui.利用者負担額減額.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getRiyoshaFutanGenmenInfoIndex().toString()) + 1;
            ArrayList<RiyoshaFutangakuGengaku> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.利用者負担額減額List, ArrayList.class);
            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("利用者負担額減額・免除等認定証"));
            getHandler(div).set利用者負担額減免エリア(list.get(listIndex));

            if (listIndex == list.size() - 1) {
                div.getBtnOutputAtoRireki().setDisabled(true);
            }
            div.setRiyoshaFutanGenmenInfoIndex(new RString(listIndex));
        } else if (GemmenGengakuShurui.負担限度額認定.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getFutanGendogakuNinteiIndex().toString()) + 1;
            ArrayList<FutanGendogakuNintei> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.負担限度額認定List, ArrayList.class);
            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("負担限度額認定証"));
            getHandler(div).set負担限度額認定エリア(list.get(listIndex));

            if (listIndex == list.size() - 1) {
                div.getBtnOutputAtoRireki().setDisabled(true);
            }
            div.setFutanGendogakuNinteiIndex(new RString(listIndex));
        } else if (GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getShafukuHojinToRiyushaFutanKeigenIndex().toString()) + 1;
            ArrayList<ShakaifukuRiyoshaFutanKeigen> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, ArrayList.class);
            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("社会福祉法人等利用者負担軽減確認証"));
            getHandler(div).set社会福祉法人等利用者負担軽減エリア(list.get(listIndex));

            if (listIndex == list.size() - 1) {
                div.getBtnOutputAtoRireki().setDisabled(true);
            }
            div.setShafukuHojinToRiyushaFutanKeigenIndex(new RString(listIndex));
        } else if (GemmenGengakuShurui.訪問介護利用者負担額減額.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getHomonKaigoRiyoshaFutangakuGengakuIndex().toString()) + 1;
            ArrayList<HomonKaigoRiyoshaFutangakuGengaku> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, ArrayList.class);
            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("訪問介護等利用者負担額減額認定証"));
            getHandler(div).set訪問介護利用者負担額減額エリア(list.get(listIndex));

            if (listIndex == list.size() - 1) {
                div.getBtnOutputAtoRireki().setDisabled(true);
            }
            div.setHomonKaigoRiyoshaFutangakuGengakuIndex(new RString(listIndex));
        } else if (GemmenGengakuShurui.特別地域加算減免.get名称().equals(表示名)) {
            int listIndex = Integer.valueOf(div.getTokubetsuChilkiKasanGenmenIndex().toString()) + 1;
            ArrayList<TokubetsuchiikiKasanGemmen> list = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.特別地域加算減免List, ArrayList.class);
            getHandler(div).set認定証(list.get(listIndex).get決定区分(), new RString("特別地域加算に係る訪問介護利用者負担減額確認証"));
            getHandler(div).set特別地域加算減免エリア(list.get(listIndex));

            if (listIndex == list.size() - 1) {
                div.getBtnOutputAtoRireki().setDisabled(true);
            }
            div.setTokubetsuChilkiKasanGenmenIndex(new RString(listIndex));
        }

        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタン実行前、必須入力チェックを行います。
     *
     * @param div GemmenGengakuShoHakkoEnumJohoDiv
     * @return レスポンスデータ
     */
    public ResponseData<GemmenGengakuShoHakkoMainDiv> onClick_validate(GemmenGengakuShoHakkoMainDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        getValidationHandler().validateFor出力チェックボックス(pairs, div);
        getValidationHandler().validateFor申請情報の存在(pairs, div);

        if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
            getValidationHandler().validateFor交付日の必須入力(pairs, div);
        }
        if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
            getValidationHandler().validateFor発行日の必須入力(pairs, div);
            getValidationHandler().validateFor文書番号の必須入力(pairs, div);
        }

        if (pairs.iterator().hasNext()) {
            return ResponseData.of(div).addValidationMessages(pairs).respond();
        }
        return ResponseData.of(div).respond();
    }

    /**
     * 「発行」ボタンをクリックする
     *
     * @param div GemmenGengakuShoHakkoEnumJohoDiv
     * @return レスポンスデータ
     */
    public ResponseData<SourceDataCollection> onClick_btnPublish(GemmenGengakuShoHakkoMainDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();

        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();

        RDate 交付日 = null;
        if (!div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().getValue().isEmpty()) {
            交付日 = new RDate(div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().getTxtKetteiTsuchiHakkoYMD().getValue().toString());
        }
        RDate 発行日 = null;
        if (!div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue().isEmpty()) {
            発行日 = new RDate(div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getTxtHenkoTsuchiHakkoYMD().getValue().toString());
        }

        RString 減免減額種類 = RString.EMPTY;
        List<RString> 帳票タイプリスト = new ArrayList<>();
        HashMap<Code, RString> hashMap = new HashMap();
        RString 表示名 = ViewStateHolder.get(GemmenGengakuShoHakkoEnum.減免減額種類, RString.class);
        if (GemmenGengakuShurui.利用者負担額減額.get名称().equals(表示名)) {
            減免減額種類 = GemmenGengakuShurui.利用者負担額減額.get名称();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), 被保険者番号.getColumnValue());

            if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除等認定証.get名称());
            }
            if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.利用者負担額減額_免除決定通知書.get名称());
            }
        } else if (GemmenGengakuShurui.負担限度額認定.get名称().equals(表示名)) {
            減免減額種類 = GemmenGengakuShurui.負担限度額認定.get名称();
            hashMap.put(new Code(HakkoRirekiKoyuJohoDBD100020.被保番号.get名称()), 被保険者番号.getColumnValue());
            hashMap.put(new Code(HakkoRirekiKoyuJohoDBD100020.減免適用開始日.get名称()),
                    new RString(div.getFutanGendogakuNintei().getTxtFutanGendogakuNinteiTekiyobi().getValue().toString()));

            if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.負担限度額認定証.get名称());
            }
            if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.負担限度額決定通知書.get名称());
            }
        } else if (GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称().equals(表示名)) {
            減免減額種類 = GemmenGengakuShurui.社会福祉法人等利用者負担軽減.get名称();
            hashMap.put(new Code(HakkoRirekiKoyuJohoDBD100018.被保番号.get名称()), 被保険者番号.getColumnValue());
            hashMap.put(new Code(HakkoRirekiKoyuJohoDBD100018.減免適用開始日.get名称()),
                    new RString(div.getShafukuHojinToRiyushaFutanKeigen().getTxtShafukuHojinToRiyushaFutanKeigenTekiyobi().getValue().toString()));

            if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減対象確認証.get名称());
            }
            if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.社会福祉法人等利用者負担軽減決定通知書.get名称());
            }
        } else if (GemmenGengakuShurui.訪問介護利用者負担額減額.get名称().equals(表示名)) {
            減免減額種類 = GemmenGengakuShurui.訪問介護利用者負担額減額.get名称();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), 被保険者番号.getColumnValue());

            if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.訪問介護利用者負担額減額認定証.get名称());
            }
            if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.訪問介護等利用者負担額減額決定通知書.get名称());
            }
        } else if (GemmenGengakuShurui.特別地域加算減免.get名称().equals(表示名)) {
            減免減額種類 = GemmenGengakuShurui.特別地域加算減免.get名称();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), 被保険者番号.getColumnValue());

            if (div.getTsuchishoSakuseiKobetsu().getNinteiShoKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算に係る訪問介護利用者負担減額確認証.get名称());
            }
            if (div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().isIsPublish()) {
                帳票タイプリスト.add(GemmenGengakuNinteishoKetteiTsuchisho.特別地域加算減免_訪問介護利用者負担減額決定通知書.get名称());
            }
        }
        GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko service = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance();
        try (ReportManager reportManager = new ReportManager()) {
            service.publish(帳票タイプリスト, 被保険者番号, 識別コード, Integer.valueOf(div.getHiddenRirekiNo().toString()),
                    減免減額種類, 交付日, 発行日,
                    div.getTsuchishoSakuseiKobetsu().getHenkoTsuchiKobetsu().getCcdBunshoNo().get文書番号(), reportManager);

            SourceDataCollection collection = reportManager.publish();
            for (SourceData data : collection) {
                service.insert発行履歴(data, 発行日, 識別コード, hashMap);
            }
            response.data = collection;
        }

        return response;
    }

    private void viewStateKeyの廃棄() {
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.is世帯初期化, false);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.減免減額種類, null);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.利用者負担額減額List, null);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.負担限度額認定List, null);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.社会福祉法人等利用者負担軽減List, null);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.訪問介護利用者負担額減額List, null);
        ViewStateHolder.put(GemmenGengakuShoHakkoEnum.特別地域加算減免List, null);
    }

    private GemmenGengakuShoHakkoMainHandler getHandler(GemmenGengakuShoHakkoMainDiv div) {
        return new GemmenGengakuShoHakkoMainHandler(div);
    }

    private GemmenGengakuShoHakkoMainValidationHandler getValidationHandler() {
        return new GemmenGengakuShoHakkoMainValidationHandler();
    }

}
