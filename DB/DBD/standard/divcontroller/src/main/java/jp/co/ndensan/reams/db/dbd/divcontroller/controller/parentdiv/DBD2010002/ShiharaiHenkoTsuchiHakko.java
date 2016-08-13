/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.controller.parentdiv.DBD2010002;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenkoIndex;
import jp.co.ndensan.reams.db.dbd.business.report.ShiharaiHohoHenkoTsuchisho;
import jp.co.ndensan.reams.db.dbd.definition.message.DbdInformationMessages;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002.ShiharaiHenkoTsuchiHakkoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2010002.dgShiharaiHohoHenkoRireki_Row;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010002.ShiharaiHenkoTsuchiHakkoHandler;
import jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010002.ShiharaiHenkoTsuchiHakkoValidationHandler;
import jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko.BunsyubanngaouList;
import jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko.HakouichiList;
import jp.co.ndensan.reams.db.dbd.service.report.shiharaihohohenkotsuchishohakko.ShiharaiHohoHenkoTsuchishoHakkoService;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.report.hakkorireki.GyomuKoyuJoho;
import jp.co.ndensan.reams.db.dbz.definition.core.jukyu.shiharaihohohenko.KanriKubun;
import jp.co.ndensan.reams.db.dbz.service.TaishoshaKey;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.SourceData;
import jp.co.ndensan.reams.uz.uza.report.SourceDataCollection;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;

/**
 *
 * 支払方法変更管理各種通知書発行クラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class ShiharaiHenkoTsuchiHakko {

    /**
     * 初期表示です。
     *
     *
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHenkoTsuchiHakkoDiv> onLoad(ShiharaiHenkoTsuchiHakkoDiv div) {
        TaishoshaKey taishoshaKey = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = taishoshaKey.get被保険者番号();
        ShikibetsuCode 識別コード = taishoshaKey.get識別コード();
        div.getCcdAtenaInfo().initialize(識別コード);
        if (被保険者番号 == null || 被保険者番号.isEmpty()) {
            div.getDgShiharaiHohoHenkoRireki().setDataSource(null);
            return ResponseData.of(div).addMessage(DbdInformationMessages.受給共通_被保データなし.getMessage()).respond();
        } else {
            ArrayList<ShiharaiHohoHenko> shiharaiHohoHenkoEntityList = getHandler().get支払方法変更の情報(被保険者番号);
            ArrayList<ShiharaiHohoHenkoIndex> shiharaiHohoHenkoIndexList = crateshiharaiHohoHenkonoIndexList(shiharaiHohoHenkoEntityList);
            div.getDgShiharaiHohoHenkoRireki().setDataSource(creatDateSource(shiharaiHohoHenkoIndexList));
            div.getDgShiharaiHohoHenkoRireki().getGridSetting().setSelectedRowCount(shiharaiHohoHenkoIndexList.size());
            ViewStateHolder.put(ShiharaiHenkoTsuchiHakkoHandler.ShiharaiHenkoTsuchiHakkoEnum.リストキー, shiharaiHohoHenkoIndexList);
            div.getCcdKaigoShikakuKihon().initialize(被保険者番号);
            getHandler().setアクセスログ(被保険者番号, 識別コード);
        }
        div.getYokokuTsuchisho().setDisplayNone(true);
        div.getYokokuTsuchisho().setIsPublish(false);
        div.getHenkoTsuchisho().setDisplayNone(true);
        div.getHenkoTsuchisho().setIsPublish(false);
        div.getKojoTsuchisho().setDisplayNone(true);
        div.getKojoTsuchisho().setIsPublish(false);
        div.getSashitomeTsuchisho().setDisplayNone(true);
        div.getSashitomeTsuchisho().setIsPublish(false);
        div.getGengakuTsuchisho().setDisplayNone(true);
        div.getGengakuTsuchisho().setIsPublish(false);
        return ResponseData.of(div).respond();
    }

    /**
     * 変更履歴一覧の行選択処理です。
     *
     *
     * @param div ShiharaiHenkoTsuchiHakkoDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHenkoTsuchiHakkoDiv> selectedItem(ShiharaiHenkoTsuchiHakkoDiv div) {
        int index = div.getDgShiharaiHohoHenkoRireki().getClickedRowId();
        div.setKey_Index(new RString(String.valueOf(index)));
        ShiharaiHohoHenko 取得された支払方法変更管理情報 = get帳票情報(index);
        if (!(取得された支払方法変更管理情報.get予告登録年月日() == null || 取得された支払方法変更管理情報.get予告登録年月日().isEmpty())) {
            div.getYokokuTsuchisho().setDisplayNone(false);
            div.getYokokuTsuchisho().setDisabled(false);
            div.getYokokuTsuchisho().setIsPublish(true);
            div.getYokokuTsuchisho().getTxtYokokuTsuchishoHakkoDate().setValue(RDate.getNowDate());
            ReportId repotId;
            if (!取得された支払方法変更管理情報.get管理区分().equals(KanriKubun.ニ号差止.code())) {
                repotId = ReportIdDBD.DBD100001.getReportId();
            } else {
                repotId = ReportIdDBD.DBD100006.getReportId();
            }
            div.getCcdYokokuTsuchishoBunshoNo().initialize(repotId);
        }
        if (!(取得された支払方法変更管理情報.get償還払化決定年月日() == null || 取得された支払方法変更管理情報.get償還払化決定年月日().isEmpty())) {
            div.getHenkoTsuchisho().setDisplayNone(false);
            div.getHenkoTsuchisho().setDisabled(false);
            div.getHenkoTsuchisho().setIsPublish(true);
            div.getHenkoTsuchisho().getTxtHenkoTsuchishoHakkoDate().setValue(RDate.getNowDate());
            ReportId repotId = ReportIdDBD.DBD100002.getReportId();
            div.getCcdHenkoTsuchishoBunshoNo().initialize(repotId);
        }
        // TODO 支払方法変更差止の取得方法
        if (!(取得された支払方法変更管理情報.getShiharaiHohoHenkoSashitomeList().get(0).get差止決定年月日() == null
                || 取得された支払方法変更管理情報.getShiharaiHohoHenkoSashitomeList().get(0).get差止決定年月日().isEmpty())) {
            div.getSashitomeTsuchisho().setDisplayNone(false);
            div.getSashitomeTsuchisho().setDisabled(false);
            div.getSashitomeTsuchisho().setIsPublish(true);
            div.getSashitomeTsuchisho().getTxtSashitomeTsuchishoHakkoDate().setValue(RDate.getNowDate());
            ReportId repotId;
            if (!取得された支払方法変更管理情報.get管理区分().equals(KanriKubun.ニ号差止.code())) {
                repotId = ReportIdDBD.DBD100003.getReportId();
            } else {
                repotId = ReportIdDBD.DBD100007.getReportId();
            }
            div.getCcdSashitomeTsuchishoBunshoNo().initialize(repotId);
        }
        // TODO 支払方法変更差止の取得方法
        if (!(取得された支払方法変更管理情報.getShiharaiHohoHenkoSashitomeList().get(0).get控除決定年月日() == null
                || 取得された支払方法変更管理情報.getShiharaiHohoHenkoSashitomeList().get(0).get控除決定年月日().isEmpty())) {
            div.getKojoTsuchisho().setDisplayNone(false);
            div.getKojoTsuchisho().setDisabled(false);
            div.getKojoTsuchisho().setIsPublish(true);
            div.getKojoTsuchisho().getTxtKojoTsuchishoHakkoDate().setValue(RDate.getNowDate());
            ReportId repotId = ReportIdDBD.DBD100004.getReportId();
            div.getCcdHenkoTsuchishoBunshoNo().initialize(repotId);
        }
        if (!(取得された支払方法変更管理情報.get減額決定年月日() == null || 取得された支払方法変更管理情報.get減額決定年月日().isEmpty())) {
            div.getGengakuTsuchisho().setDisplayNone(false);
            div.getGengakuTsuchisho().setDisabled(false);
            div.getGengakuTsuchisho().setIsPublish(true);
            div.getGengakuTsuchisho().getTxtGengakuTsuchishoHakkoDate().setValue(RDate.getNowDate());
            ReportId repotId = ReportIdDBD.DBD100005.getReportId();
            div.getCcdHenkoTsuchishoBunshoNo().initialize(repotId);
        }
        return ResponseData.of(div).respond();

    }

    /**
     * 「発行」ボタン実行前、必須入力チェックを行います。
     *
     * @param div HihokenshashoHakkoTaishoshaJohoDiv
     * @return レスポンスデータ
     */
    public ResponseData<ShiharaiHenkoTsuchiHakkoDiv> onClick_validate(ShiharaiHenkoTsuchiHakkoDiv div) {
        ValidationMessageControlPairs pairs = new ValidationMessageControlPairs();
        if (div.getYokokuTsuchisho().isIsPublish()) {
            getValidationHandler().validateFor予告発行日(pairs, div);
            getValidationHandler().validateFor予告文書番号(pairs, div);
        }
        if (div.getHenkoTsuchisho().isIsPublish()) {
            getValidationHandler().validateFor変更発行日(pairs, div);
            getValidationHandler().validateFor変更文書番号(pairs, div);
        }
        if (div.getKojoTsuchisho().isIsPublish()) {
            getValidationHandler().validateFor控除発行日(pairs, div);
            getValidationHandler().validateFor控除文書番号(pairs, div);
        }
        if (div.getSashitomeTsuchisho().isIsPublish()) {
            getValidationHandler().validateFor差止発行日(pairs, div);
            getValidationHandler().validateFor差止文書番号(pairs, div);
        }
        if (div.getGengakuTsuchisho().isIsPublish()) {
            getValidationHandler().validateFor減額発行日(pairs, div);
            getValidationHandler().validateFor減額文書番号(pairs, div);
        }
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
    public ResponseData<SourceDataCollection> onClick_btnPublish(ShiharaiHenkoTsuchiHakkoDiv div) {
        ResponseData<SourceDataCollection> response = new ResponseData<>();
        TaishoshaKey 資格対象者 = ViewStateHolder.get(ViewStateKeys.資格対象者, TaishoshaKey.class);
        HihokenshaNo 被保険者番号 = 資格対象者.get被保険者番号();
        ShikibetsuCode 識別コード = 資格対象者.get識別コード();
        List<RString> 帳票タイプリスト = new ArrayList<>();
        BunsyubanngaouList 文書番号リスト = new BunsyubanngaouList();
        HakouichiList 発行日リスト = new HakouichiList();
        ShiharaiHohoHenko 帳票情報 = get帳票情報(Integer.parseInt(div.getKey_Index().toString()));
        if (div.getYokokuTsuchisho().isIsPublish()) {
            文書番号リスト.set予告文書番号(div.getYokokuTsuchisho().getCcdYokokuTsuchishoBunshoNo().get文書番号());
            発行日リスト.set予告通知書発行年月日(div.getYokokuTsuchisho().getTxtYokokuTsuchishoHakkoDate().getValue());
            if (!帳票情報.get管理区分().equals(KanriKubun.ニ号差止.code())) {
                帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.支払方法変更予告通知書.get名称());
            } else {
                帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.差止予告通知書_２号用.get名称());
            }
        }
        if (div.getHenkoTsuchisho().isIsPublish()) {
            文書番号リスト.set償還払化文書番号(div.getHenkoTsuchisho().getCcdHenkoTsuchishoBunshoNo().get文書番号());
            発行日リスト.set償還払化通知書発行年月日(div.getHenkoTsuchisho().getTxtHenkoTsuchishoHakkoDate().getValue());
            帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.支払方法変更通知書.get名称());
        }
        if (div.getSashitomeTsuchisho().isIsPublish()) {
            文書番号リスト.set差止文書番号(div.getSashitomeTsuchisho().getCcdSashitomeTsuchishoBunshoNo().get文書番号());
            発行日リスト.set差止通知書発行年月日(div.getSashitomeTsuchisho().getTxtSashitomeTsuchishoHakkoDate().getValue());
            if (!帳票情報.get管理区分().equals(KanriKubun.ニ号差止.code())) {
                帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.支払一時差止通知書.get名称());
            } else {
                帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.差止処分通知書_２号用.get名称());
            }
        }
        if (div.getKojoTsuchisho().isIsPublish()) {
            文書番号リスト.set控除文書番号(div.getKojoTsuchisho().getCcdKojoTsuchishoBunshoNo().get文書番号());
            発行日リスト.set控除通知書発行年月日(div.getKojoTsuchisho().getTxtKojoTsuchishoHakkoDate().getValue());
            帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.滞納保険料控除通知書.get名称());
        }
        if (div.getGengakuTsuchisho().isIsPublish()) {
            文書番号リスト.set減額文書番号(div.getGengakuTsuchisho().getCcdGengakuTsuchishoBunshoNo().get文書番号());
            発行日リスト.set減額通知書発行年月日(div.getGengakuTsuchisho().getTxtGengakuTsuchishoHakkoDate().getValue());
            帳票タイプリスト.add(ShiharaiHohoHenkoTsuchisho.給付額減額通知書.get名称());
        }
        ShiharaiHohoHenkoTsuchishoHakkoService service = ShiharaiHohoHenkoTsuchishoHakkoService.createInstance();
        try (ReportManager reportManager = new ReportManager()) {
            service.pntShiharaiHohoHenkoKanriKakusyu(帳票タイプリスト, 帳票情報, 発行日リスト, 文書番号リスト, 識別コード, reportManager);
            HashMap<Code, RString> hashMap = new HashMap();
            hashMap.put(new Code(GyomuKoyuJoho.被保番号.getコード()), 被保険者番号.getColumnValue());
            SourceDataCollection collection = reportManager.publish();
            for (SourceData data : collection) {
                if (data.getReportId().equals(ReportIdDBD.DBD100001.getReportId().value()) || data.getReportId().equals(ReportIdDBD.DBD100006.getReportId().value())) {
                    service.insert発行履歴(data, 発行日リスト.get予告通知書発行年月日(), 識別コード, hashMap);
                } else if (data.getReportId().equals(ReportIdDBD.DBD100002.getReportId().value())) {
                    service.insert発行履歴(data, 発行日リスト.get償還払化通知書発行年月日(), 識別コード, hashMap);
                } else if (data.getReportId().equals(ReportIdDBD.DBD100003.getReportId().value()) || data.getReportId().equals(ReportIdDBD.DBD100007.getReportId().value())) {
                    service.insert発行履歴(data, 発行日リスト.get差止通知書発行年月日(), 識別コード, hashMap);
                } else if (data.getReportId().equals(ReportIdDBD.DBD100004.getReportId().value())) {
                    service.insert発行履歴(data, 発行日リスト.get控除通知書発行年月日(), 識別コード, hashMap);
                } else if (data.getReportId().equals(ReportIdDBD.DBD100005.getReportId().value())) {
                    service.insert発行履歴(data, 発行日リスト.get減額通知書発行年月日(), 識別コード, hashMap);
                }
            }
            response.data = collection;
        }
        return response;
    }

    private ShiharaiHenkoTsuchiHakkoHandler getHandler() {
        return new ShiharaiHenkoTsuchiHakkoHandler();
    }

    private ShiharaiHenkoTsuchiHakkoValidationHandler getValidationHandler() {
        return new ShiharaiHenkoTsuchiHakkoValidationHandler();
    }

    // TODO 支払方法変更差止.差止通知書発行年月日  と支払方法変更差止.控除通知書発行年月日　の取得方法不知
    private List<dgShiharaiHohoHenkoRireki_Row> creatDateSource(ArrayList<ShiharaiHohoHenkoIndex> shiharaiHohoHenkonoJouhouList) {
        List<dgShiharaiHohoHenkoRireki_Row> rowList = new ArrayList();
        dgShiharaiHohoHenkoRireki_Row row = new dgShiharaiHohoHenkoRireki_Row();
        for (int i = 0; i < shiharaiHohoHenkonoJouhouList.size(); i++) {
            row.setTxtTorokuJokyo(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get登録区分());
            row.setTxtShuryoJokyo(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get終了区分());
            row.getTxtTekiyoKaishi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get適用開始年月日().toString()));
            row.getTxtTekiyoShuryo().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get適用終了年月日().toString()));
            row.getTxtYokokuTsuchi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get予告通知書発行年月日().toString()));
            row.getTxtHenkoTshuchi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get償還払化通知書発行年月日().toString()));
            row.getTxtSashitomeTsuchi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().getShiharaiHohoHenkoSashitomeList().get(0).get差止通知書発行年月日().toString()));
            row.getTxtKojoTsuchi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().getShiharaiHohoHenkoSashitomeList().get(0).get控除通知書発行年月日().toString()));
            row.getTxtGengakuTsuchi().setValue(new RDate(shiharaiHohoHenkonoJouhouList.get(i).getShiharaiHohoHenko().get減額通知書発行年月日().toString()));
            row.setId(i);
            rowList.add(row);
        }
        return rowList;
    }

    private ArrayList<ShiharaiHohoHenkoIndex> crateshiharaiHohoHenkonoIndexList(ArrayList<ShiharaiHohoHenko> shiharaiHohoHenkonoList) {
        ArrayList<ShiharaiHohoHenkoIndex> indexList = new ArrayList();
        for (int i = 0; i < shiharaiHohoHenkonoList.size(); i++) {
            ShiharaiHohoHenkoIndex shiharaiHohoHenkonoIndex = new ShiharaiHohoHenkoIndex();
            shiharaiHohoHenkonoIndex.setShiharaiHohoHenko(shiharaiHohoHenkonoList.get(i));
            shiharaiHohoHenkonoIndex.setIndex(i);
            indexList.add(shiharaiHohoHenkonoIndex);
        }
        return indexList;
    }

    private ShiharaiHohoHenko get帳票情報(int index) {
        ShiharaiHohoHenko shiharaiHohoHenkono = null;
        ArrayList<ShiharaiHohoHenkoIndex> shiharaiHohoHenkonoIndexList = ViewStateHolder.get(ShiharaiHenkoTsuchiHakkoHandler.ShiharaiHenkoTsuchiHakkoEnum.リストキー, ArrayList.class);
        for (ShiharaiHohoHenkoIndex shiharaiHohoHenkonoIndex : shiharaiHohoHenkonoIndexList) {
            if (shiharaiHohoHenkonoIndex.getIndex() == index) {
                shiharaiHohoHenkono = shiharaiHohoHenkonoIndex.getShiharaiHohoHenko();
                break;
            }
        }
        return shiharaiHohoHenkono;
    }
}
