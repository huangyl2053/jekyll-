/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5190001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.NinteiShinseiJohoBusiness;
import jp.co.ndensan.reams.db.dbd.business.core.ninteishinseijoho.YokaigoNinteiGaibuDataOutputHistory;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD519001.DBD519001_NinteishinseiInfoIfParameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5190001.RenkeiDataSakuseiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.core.ui.response.ResponseData;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 要介護認定申請連携データ作成のハンドラークラスです。
 *
 * @reamsid_L DBD-1480-010 zhuxiaojun
 */
public class RenkeiDataSakuseiShinseiJohoHandler {

    private final RenkeiDataSakuseiShinseiJohoDiv div;

    /**
     * コンストラクタです。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     */
    public RenkeiDataSakuseiShinseiJohoHandler(RenkeiDataSakuseiShinseiJohoDiv div) {
        this.div = div;
    }

    /**
     * 保険者リスト取得
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     * @param dataKubun Code
     *
     */
    public void get保険者リスト取得(RenkeiDataSakuseiShinseiJohoDiv div, Code dataKubun) {
        div.getCommonChildDiv1().loadHokenshaList();
        YokaigoNinteiGaibuDataOutputHistory outPutHistory = get介護認定外部データ出力履歴(dataKubun);
        RDate zenkaikaishiday = null;
        RTime zenkaikaishitime = null;
        RDate zenkaishuryoday = null;
        RTime zenkaishuryotime = null;
        RString 新ファイル名 = get要介護認定申請連携データ送信ファイル名();
        RString 最大表示件数 = get最大表示件数();
        Decimal saidikensu = new Decimal(最大表示件数.toString());
        if (outPutHistory != null) {
            if (outPutHistory.getDataOutputKaishiYMDHMS() != null) {
                zenkaikaishiday = outPutHistory.getDataOutputKaishiYMDHMS().getDate();
                zenkaikaishitime = outPutHistory.getDataOutputKaishiYMDHMS().getRDateTime().getTime();
            }
            if (outPutHistory.getDataOutputShuryoYMDHMS() != null) {
                zenkaishuryoday = outPutHistory.getDataOutputShuryoYMDHMS().getDate();
                zenkaishuryotime = outPutHistory.getDataOutputShuryoYMDHMS().getRDateTime().getTime();
            }
            if (zenkaikaishiday != null) {
                div.getTxtZenkaiKaishiDay().setValue(zenkaikaishiday);
                div.getTxtKonkaiKaishiDay().setValue(zenkaikaishiday);
            }
            if (zenkaikaishitime != null) {
                div.getTxtZenkaiKaishiTime().setValue(zenkaikaishitime);
                div.getTxtKonkaiKaishiTime().setValue(zenkaikaishitime.plusSeconds(1));
            }
            if (zenkaishuryoday != null) {
                div.getTxtZenkaiShuryoDay().setValue(zenkaishuryoday);
            }
            if (zenkaishuryotime != null) {
                div.getTxtZenkaiShuryoTime().setValue(zenkaishuryotime);
            }
            if (zenkaikaishiday == null) {
                div.getTxtKonkaiKaishiDay().setValue(RDate.getNowDate());
            }
            if (zenkaikaishitime == null) {
                div.getTxtKonkaiKaishiTime().setValue(RTime.now());
            }
            if (zenkaikaishiday != null && zenkaikaishitime.toString().equals("23:59:59")) {
                div.getTxtKonkaiKaishiDay().setValue(zenkaikaishiday.plusDay(1));
            }
            div.getTxtKonkaiShuryoDay().setValue(RDate.getNowDate());
            div.getTxtKonkaiShuryoTime().setValue(RTime.now());
        } else {
            div.getTxtKonkaiKaishiDay().setValue(RDate.getNowDate());
            div.getTxtKonkaiKaishiTime().setValue(RTime.now());
            div.getTxtKonkaiShuryoDay().setValue(RDate.getNowDate());
            div.getTxtKonkaiShuryoTime().setValue(RTime.now());

        }

        div.getTxtMaxKensu().setValue(saidikensu);
        div.getTxtNewFileName().setValue(新ファイル名);
        div.getDgTaishoshaIchiran().getGridSetting().setLimitRowCount(saidikensu.intValue());
        div.getTaishoshaIchiran().setIsOpen(false);
        div.getHanteiIraiIchiranhyo().setIsOpen(false);

    }

    private YokaigoNinteiGaibuDataOutputHistory get介護認定外部データ出力履歴(Code dataKubun) {
        RenkeiDataSakuseiShinseiJohoManager nManager = new RenkeiDataSakuseiShinseiJohoManager();
        return nManager.get介護認定外部データ出力履歴(dataKubun);

    }

    /**
     * radiobuttonChange対象期間radio事件と被保険者番号radio期間
     *
     */
    public void checkRadioButton() {
        RString radChushutsu = div.getChushutsuJoken().getRadChushutsuJoken().getSelectedValue();
        RString 対象期間 = new RString("対象期間");
        RString 被保険者番号 = new RString("被保険者番号");
        if (radChushutsu.equals(対象期間)) {
            div.getTxtHihokenshaNo().clearValue();
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getBtnhihokensha().setDisabled(true);
            div.getTxtKonkaiKaishiDay().clearValue();
            div.getTxtKonkaiKaishiTime().clearValue();
            div.getTxtKonkaiShuryoDay().clearValue();
            div.getTxtKonkaiShuryoTime().clearValue();
            div.getTxtKonkaiKaishiDay().setDisabled(false);
            div.getTxtKonkaiKaishiTime().setDisabled(false);
            div.getTxtKonkaiShuryoDay().setDisabled(false);
            div.getTxtKonkaiShuryoTime().setDisabled(false);
            div.getBtnhihokensha().setDisabled(true);
        }
        if (radChushutsu.equals(被保険者番号)) {
            div.getTxtHihokenshaNo().clearValue();
            div.getTxtKonkaiKaishiDay().clearValue();
            div.getTxtKonkaiKaishiTime().clearValue();
            div.getTxtKonkaiShuryoDay().clearValue();
            div.getTxtKonkaiShuryoTime().clearValue();
            div.getTxtKonkaiKaishiDay().setDisabled(true);
            div.getTxtKonkaiKaishiTime().setDisabled(true);
            div.getTxtKonkaiShuryoDay().setDisabled(true);
            div.getTxtKonkaiShuryoTime().setDisabled(true);
            div.getTxtHihokenshaNo().setDisabled(false);
            div.getBtnhihokensha().setDisabled(false);
            div.getBtnhihokensha().setDisabled(false);
        }
    }

    /**
     * バッチパラメターを保存処理です。
     *
     * @return バッチパラメター
     */
    public DBD519001_NinteishinseiInfoIfParameter batchParameterSave() {
        DBD519001_NinteishinseiInfoIfParameter parameter = new DBD519001_NinteishinseiInfoIfParameter();
        RDate fromdate = RDate.getNowDate();
        RDate todate = RDate.getNowDate().plusDay(1);
        RTime fromtime = RTime.of(0, 0, 0);
        RTime totime = RTime.of(0, 0, 0);
        if (div.getTxtKonkaiKaishiDay().getValue() != null) {
            fromdate = div.getTxtKonkaiKaishiDay().getValue();
        }
        if (div.getTxtKonkaiShuryoDay().getValue() != null) {
            todate = div.getTxtKonkaiShuryoDay().getValue();
        }
        if (div.getTxtKonkaiKaishiTime().getValue() != null) {
            fromtime = div.getTxtKonkaiKaishiTime().getValue();
        }
        if (div.getTxtKonkaiShuryoTime().getValue() != null) {
            totime = div.getTxtKonkaiShuryoTime().getValue();
        }
        RDateTime konkaikaishiFrom = RDateTime.of(fromdate.getYearValue(), fromdate.getMonthValue(), fromdate.getDayValue(),
                fromtime.getHour(), fromtime.getMinute(), fromtime.getSecond());
        RDateTime konkaikaishiTo = RDateTime.of(todate.getYearValue(), todate.getMonthValue(), todate.getDayValue(),
                totime.getHour(), totime.getMinute(), totime.getSecond());
        parameter.set証記載保険者番号(div.getCommonChildDiv1().getSelectedItem().get証記載保険者番号().value());
        parameter.set市町村コード(div.getCommonChildDiv1().getSelectedItem().get市町村コード());
        parameter.set被保険者番号(new HihokenshaNo(div.getTxtHihokenshaNo().getValue()));
        parameter.set今回開始期間FROM(konkaikaishiFrom);
        parameter.set今回開始期間TO(konkaikaishiTo);
        parameter.set新ファイル名(div.getTxtNewFileName().getValue());
        List<HihokenshaNo> hihokenshaNoList = getHihokenshaNoList(div);
        parameter.set対象外被保険者番号リスト(hihokenshaNoList);
        return parameter;
    }

    /**
     * 対象者一覧情報初期化
     *
     * @param shoKisaiHokenshaNo RString
     * @param konkaikaishiTimestamp RString
     * @param konkaisyuryoTimestamp RString
     * @param hihokenshaNo RString
     * @param saidaikensu RString
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return div ResponseData<RenkeiDataSakuseiShinseiJohoDiv>
     */
    public ResponseData<RenkeiDataSakuseiShinseiJohoDiv> 対象者一覧情報初期化(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu,
            RenkeiDataSakuseiShinseiJohoDiv div) {
        RString saidaikensuall = new RString("");
        List<NinteiShinseiJohoBusiness> ninteishinseijohos = get検索対象者一覧情報(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensu);
        List<NinteiShinseiJohoBusiness> johosCount = get全部対象者一覧情報(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensuall);
        取得の処理(ninteishinseijohos, johosCount, div);
        return ResponseData.of(div).respond();
    }

    /**
     * get対象者一覧情報
     *
     * @param shoKisaiHokenshaNo RString
     * @param konkaikaishiTimestamp RString
     * @param konkaisyuryoTimestamp RString
     * @param hihokenshaNo RString
     * @param saidaikensu RString
     *
     * @return ninteishinseijohos List<NinteiShinseiJohoBusiness>
     */
    public List<NinteiShinseiJohoBusiness> getNinteishinseijohos(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu) {
        List<NinteiShinseiJohoBusiness> ninteishinseijohos = get検索対象者一覧情報(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensu);
        return ninteishinseijohos;

    }

    /**
     * 条件をクリアする
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     */
    public void 条件をクリア(RenkeiDataSakuseiShinseiJohoDiv div) {
        if (div.getChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(new RString("key0"))) {
            div.getTxtKonkaiShuryoDay().clearValue();
            div.getTxtKonkaiShuryoTime().clearValue();
        }
        if (div.getChushutsuJoken().getRadChushutsuJoken().getSelectedKey().equals(new RString("key1"))) {
            div.getTxtHihokenshaNo().clearValue();
        }
    }

    /**
     * 被保険者番号の取得。
     *
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     *
     * @return List<HihokenshaNo>
     */
    public List<HihokenshaNo> getHihokenshaNoList(RenkeiDataSakuseiShinseiJohoDiv div) {
        List<dgTaishoshaIchiran_Row> taishoList = div.getDgTaishoshaIchiran().getDataSource();
        List<HihokenshaNo> hihokenshaNoList = new ArrayList<>();
        for (dgTaishoshaIchiran_Row row : taishoList) {
            HihokenshaNo hihokenshano = new HihokenshaNo(row.getHihokenshaNo());
            hihokenshaNoList.add(hihokenshano);
        }
        return hihokenshaNoList;
    }

    private List<NinteiShinseiJohoBusiness> get検索対象者一覧情報(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu) {
        RenkeiDataSakuseiShinseiJohoManager nManager = RenkeiDataSakuseiShinseiJohoManager.createInstance();
        List<NinteiShinseiJohoBusiness> ninteishiinseijohos = nManager.get対象者一覧情報の検索(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensu).records();
        if (!ninteishiinseijohos.isEmpty()) {
            for (NinteiShinseiJohoBusiness joho : ninteishiinseijohos) {
                PersonalData personlData = toPersonalData(joho);
                AccessLogger.log(AccessLogType.照会, personlData);
            }
        }
        return ninteishiinseijohos;
    }

    private List<NinteiShinseiJohoBusiness> get全部対象者一覧情報(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensuall) {
        RenkeiDataSakuseiShinseiJohoManager nManager = RenkeiDataSakuseiShinseiJohoManager.createInstance();
        List<NinteiShinseiJohoBusiness> johosCount = nManager.get対象者一覧情報の検索(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensuall).records();
        return johosCount;
    }

    private void set検索対象者一覧情報(List<NinteiShinseiJohoBusiness> johos,
            List<NinteiShinseiJohoBusiness> johosCount, RenkeiDataSakuseiShinseiJohoDiv div) {
        div.getTaishoshaIchiran().setIsOpen(true);
        List<dgTaishoshaIchiran_Row> rowList = new ArrayList<>();
        dgTaishoshaIchiran_Row row;
        if (!(johos.isEmpty())) {
            for (NinteiShinseiJohoBusiness joho : johos) {
                row = new dgTaishoshaIchiran_Row();
                row.setSelected(Boolean.TRUE);
                row.setHihokenshaNo(joho.get被保険者番号());
                row.setHihokenshaKanaShimei(joho.get被保険者カナ().value());
                row.setHihokenshaShimei(joho.get被保険者名前().value());
                row.getBirthYMD().setValue(new RDate(joho.get生年月日().toString()));
                row.setSeibetsu(Seibetsu.toValue(joho.get性別().value()).get名称());
                row.getShinseiDay().setValue(new RDate(joho.get認定申請年月日().toString()));
                row.setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode.toValue(joho.get認定申請区分申請時コード()
                        .value()).get名称());
                rowList.add(row);
            }
        }
        div.getDgTaishoshaIchiran().setDataSource(rowList);
        div.getDgTaishoshaIchiran().getGridSetting().setLimitRowCount(johos.size());
        div.getDgTaishoshaIchiran().getGridSetting().setSelectedRowCount(johosCount.size());
        div.getHanteiIraiIchiranhyo().setIsOpen(true);
        div.getHanteiIraiIchiranhyo().getTxtInsatsuDay().setValue(new RString(FlexibleDate.getNowDate().toString()));
    }

    private void 取得の処理(List<NinteiShinseiJohoBusiness> johos,
            List<NinteiShinseiJohoBusiness> johosCount, RenkeiDataSakuseiShinseiJohoDiv div) {
        set検索対象者一覧情報(johos, johosCount, div);
    }

    private PersonalData toPersonalData(NinteiShinseiJohoBusiness ninteishinseijoho) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("被保険者番号"), new RString("0003"), ninteishinseijoho.get被保険者番号());
        return PersonalData.of(ShikibetsuCode.EMPTY, expandedInfo);

    }

    private RString get要介護認定申請連携データ送信ファイル名() {
        return DbBusinessConfig.get(ConfigNameDBD.要介護認定申請連携データ送信ファイル名, RDate.getNowDate(), SubGyomuCode.DBD介護受給);
    }

    private RString get最大表示件数() {
        return DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告);
    }
}
