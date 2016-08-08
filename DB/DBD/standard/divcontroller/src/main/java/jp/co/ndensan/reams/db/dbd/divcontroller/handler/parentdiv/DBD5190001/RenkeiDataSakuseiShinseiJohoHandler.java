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
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.RenkeiDataSakuseiShinseiJohoDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5190001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbd.service.core.dbd5190001.RenkeiDataSakuseiShinseiJohoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBD;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
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
            if (outPutHistory.getDataOutputKaishiYMDHM() != null) {
                zenkaikaishiday = outPutHistory.getDataOutputKaishiYMDHM().getDate();
                zenkaikaishitime = outPutHistory.getDataOutputKaishiYMDHM().getTime();
            }
            if (outPutHistory.getDataOutputShuryoYMDHM() != null) {
                zenkaishuryoday = outPutHistory.getDataOutputShuryoYMDHM().getDate();
                zenkaishuryotime = outPutHistory.getDataOutputShuryoYMDHM().getTime();
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
            div.getTxtHihokenshaNo().setDisabled(true);
            div.getBtnhihokensha().setDisabled(true);
            div.getTxtKonkaiKaishiDay().setDisabled(false);
            div.getTxtKonkaiKaishiTime().setDisabled(false);
            div.getTxtKonkaiShuryoDay().setDisabled(false);
            div.getTxtKonkaiShuryoTime().setDisabled(false);
            div.getBtnhihokensha().setDisabled(true);
        }
        if (radChushutsu.equals(被保険者番号)) {
            div.getTxtHihokenshaNo().clearValue();
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
     * 対象者一覧情報初期化
     *
     * @param shoKisaiHokenshaNo RString
     * @param konkaikaishiTimestamp RString
     * @param konkaisyuryoTimestamp RString
     * @param hihokenshaNo RString
     * @param saidaikensu RString
     * @param div RenkeiDataSakuseiShinseiJohoDiv
     */
    public void 対象者一覧情報初期化(RString shoKisaiHokenshaNo,
            RDateTime konkaikaishiTimestamp,
            RDateTime konkaisyuryoTimestamp,
            RString hihokenshaNo,
            RString saidaikensu,
            RenkeiDataSakuseiShinseiJohoDiv div) {
        List<NinteiShinseiJohoBusiness> ninteishinseijohos = get検索対象者一覧情報(shoKisaiHokenshaNo,
                konkaikaishiTimestamp, konkaisyuryoTimestamp, hihokenshaNo, saidaikensu);
        取得の処理(ninteishinseijohos, div);
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

    private void set検索対象者一覧情報(List<NinteiShinseiJohoBusiness> johos, RenkeiDataSakuseiShinseiJohoDiv div) {
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
        div.getHanteiIraiIchiranhyo().setIsOpen(true);
        div.getHanteiIraiIchiranhyo().getTxtInsatsuDay().setValue(new RString(FlexibleDate.getNowDate().toString()));
    }

    private void 取得の処理(List<NinteiShinseiJohoBusiness> johos, RenkeiDataSakuseiShinseiJohoDiv div) {
        if (johos == null || johos.isEmpty()) {
            div.getTaishoshaIchiran().setIsOpen(false);
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage().evaluate());
        } else {
            set検索対象者一覧情報(johos, div);
        }
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
