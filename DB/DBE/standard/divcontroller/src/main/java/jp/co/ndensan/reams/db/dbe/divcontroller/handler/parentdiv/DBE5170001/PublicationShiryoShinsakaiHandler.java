
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KaisaiYoteiJohoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shiryoshinsakai.ShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.shinsakai.IsShiryoSakuseiZumi;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会資料作成のコントローラです。
 *
 * @reamsid_L DBE-0150-010 linghuhang
 */
public class PublicationShiryoShinsakaiHandler {

    private final RString 個別設定 = new RString("2");
    private final RString 選択 = new RString("1");
    private final RString 作成条件_全件 = new RString("key0");
    private final RString 作成条件_範囲指定 = new RString("key1");
    private final RString 印刷帳票_すべて選択 = new RString("0");
    private final RString 印刷帳票_審査会資料 = new RString("1");
    private final RString 印刷帳票_審査会対象者一覧 = new RString("0");
    private final RString 印刷帳票_特記事項 = new RString("1");
    private final RString 印刷帳票_一次判定結果票 = new RString("2");
    private final RString 印刷帳票_特記事項_一次判定 = new RString("3");
    private final RString 印刷帳票_主治医意見書 = new RString("4");
    private final RString 印刷帳票_その他資料 = new RString("5");
    private final RString 印刷帳票_概況特記 = new RString("2");
    private final RString 印刷帳票_予備判定記入票 = new RString("3");
    private final RString 印刷帳票_概況特記一覧 = new RString("4");
    private final PublicationShiryoShinsakaiDiv div;
    private static final int INT_4 = 4;
    private static final int INT_0 = 0;
    private static final int INT_2 = 2;

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会資料作成Div
     */
    public PublicationShiryoShinsakaiHandler(PublicationShiryoShinsakaiDiv div) {
        this.div = div;
    }

    /**
     * 介護認定審査会資料作成の初期化を設定します。
     *
     * @param 開催予定情報 開催予定情報
     */
    public void onLoad(KaisaiYoteiJohoBusiness 開催予定情報) {
        if (開催予定情報 != null) {
            div.getTxtShinsakaiYoteiDate().setValue(to日期転換(開催予定情報.get予定年月日()));
            div.getTxtShinsakaiKaijo().setValue(to転換(開催予定情報.get開催場所名称()));
            if (!RString.isNullOrEmpty(開催予定情報.get開始予定時刻())) {
                RString 開始予定時刻 = 開催予定情報.get開始予定時刻().padZeroToLeft(INT_4);
                div.getTxtShinsakaiKaishiYoteiTime().setValue(RTime.of(Integer.parseInt(開始予定時刻.substring(INT_0, INT_2).toString()),
                        Integer.parseInt(開始予定時刻.substring(INT_2).toString())));
            }
            div.getTxtShiryoSakusei().setValue(IsShiryoSakuseiZumi.toValue(開催予定情報.is資料作成済フラグ()).get名称());
            div.getTxtGogitaiNo().setValue(new RString(開催予定情報.get合議体番号()));
            div.getTxtGogitaiName().setValue(to転換(開催予定情報.get合議体名称()));
            div.getTxtYoteiTeiin().setValue(new Decimal(開催予定情報.get予定定員()));
            div.getTxtWariateNinzu().setValue(new Decimal(開催予定情報.get割当済み人数()));
            div.getTxtOperationDate().setValue(to日期転換(開催予定情報.get資料作成年月日()));
        }
        出力条件の設定();
        set審査会資料選択可能の設定();
        List<RString> 事務 = new ArrayList<>();
        事務.add(印刷帳票_概況特記);
        List<RString> 事務_審査会資料 = new ArrayList<>();
        List<RString> 委員_審査会資料 = new ArrayList<>();
        事務_審査会資料.add(印刷帳票_特記事項_一次判定);
        委員_審査会資料.add(印刷帳票_特記事項_一次判定);
        div.getChkPrintChoyoJimu2().setDisabledItemsByKey(事務);
        div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(事務_審査会資料);
        div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(委員_審査会資料);
        div.getTxtShiryoNoStart().setDisabled(true);
        div.getTxtSiryoNoEnd().setDisabled(true);
    }

    /**
     * 作成条件ラジオボタンを変更する場合、表示項目を変更する。
     */
    public void 活性と非活性設定() {
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        List<RString> 事務 = new ArrayList<>();
        List<RString> 委員 = new ArrayList<>();
        if (作成条件_全件.equals(作成条件)) {
            事務.add(印刷帳票_概況特記);
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().clearValue();
            div.getTxtSiryoNoEnd().clearValue();
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        } else if (作成条件_範囲指定.equals(作成条件)) {
            事務.add(印刷帳票_予備判定記入票);
            委員.add(印刷帳票_予備判定記入票);
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().setDisabled(false);
            div.getTxtSiryoNoEnd().setDisabled(false);
        } else {
            事務.add(印刷帳票_予備判定記入票);
            委員.add(印刷帳票_予備判定記入票);
            div.getChkPrintChoyoJimu2().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoIin2().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().clearValue();
            div.getTxtSiryoNoEnd().clearValue();
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        }
        div.getChkPrintChohyoShinsakaiIin().setDisabled(false);
        div.getChkPrintChohyoShinsakaiJimu().setDisabled(false);
    }

    /**
     * 出力スタイルを変更する場合、表示項目を変更する。
     */
    public void onClick_syutuHeDa() {
        List<RString> 印刷帳票_事務局審査会資料 = new ArrayList<>();
        List<RString> 印刷帳票_委員審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
                印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        if (!div.getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
                印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(印刷帳票_事務局審査会資料);
        div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(印刷帳票_委員審査会資料);
    }

    /**
     * 事務局用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClick_chkPrintChoyoJimu() {
        List<RString> 印刷帳票_事務局審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
                印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(印刷帳票_事務局審査会資料);
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClick_chkPrintChohyoIin() {
        List<RString> 印刷帳票_委員審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
        } else {
            if (選択.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            } else {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
                印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            }
        }
        div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(印刷帳票_委員審査会資料);
    }

    /**
     * バッチパラメータを設定します。
     *
     * @return ShiryoShinsakaiBatchParameter
     */
    public ShiryoShinsakaiBatchParameter onClick_btnKogakuParamSave() {

        RString 事務局審査会対象者一覧フラグ = new RString("0");
        RString 事務局特記事項フラグ = new RString("0");
        RString 事務局一次判定結果票フラグ = new RString("0");
        RString 事務局特記事項_一次判定フラグ = new RString("0");
        RString 事務局主治医意見書フラグ = new RString("0");
        RString 事務局その他資料フラグ = new RString("0");
        RString 事務局概況特記フラグ = new RString("0");
        RString 事務局予備判定記入表フラグ = new RString("0");
        RString 事務局概況特記一覧フラグ = new RString("0");
        RString 委員用審査会対象者一覧フラグ = new RString("0");
        RString 委員用特記事項フラグ = new RString("0");
        RString 委員用一次判定結果票フラグ = new RString("0");
        RString 委員用特記事項_一次判定フラグ = new RString("0");
        RString 委員用主治医意見書フラグ = new RString("0");
        RString 委員用その他資料フラグ = new RString("0");
        RString 委員用審査会開催通知書フラグ = new RString("0");
        RString 委員用予備判定記入表フラグ = new RString("0");

        List<RString> 事務用出力条件帳票 = div.getChkPrintChoyoJimu2().getSelectedKeys();
        List<RString> 事務用出力条件資料 = div.getChkPrintChohyoShinsakaiJimu().getSelectedKeys();
        List<RString> 委員用出力条件帳票 = div.getChkPrintChohyoIin2().getSelectedKeys();
        List<RString> 委員用出力条件資料 = div.getChkPrintChohyoShinsakaiIin().getSelectedKeys();
        if (事務用出力条件帳票.contains(印刷帳票_概況特記)) {
            事務局概況特記フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(印刷帳票_予備判定記入票)) {
            事務局予備判定記入表フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(印刷帳票_概況特記一覧)) {
            事務局概況特記一覧フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_審査会対象者一覧)) {
            事務局審査会対象者一覧フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_特記事項)) {
            事務局特記事項フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_一次判定結果票)) {
            事務局一次判定結果票フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_特記事項_一次判定)) {
            事務局特記事項_一次判定フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_主治医意見書)) {
            事務局主治医意見書フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_その他資料)) {
            事務局その他資料フラグ = new RString("1");
        }

        if (委員用出力条件帳票.contains(印刷帳票_概況特記)) {
            委員用審査会開催通知書フラグ = new RString("1");
        }
        if (委員用出力条件帳票.contains(印刷帳票_予備判定記入票)) {
            委員用予備判定記入表フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_審査会対象者一覧)) {
            委員用審査会対象者一覧フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_特記事項)) {
            委員用特記事項フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(印刷帳票_一次判定結果票)) {
            委員用一次判定結果票フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_特記事項_一次判定)) {
            委員用特記事項_一次判定フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_主治医意見書)) {
            委員用主治医意見書フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(印刷帳票_その他資料)) {
            委員用その他資料フラグ = new RString("1");
        }
        return set項目(事務局審査会対象者一覧フラグ,
                事務局特記事項フラグ,
                事務局一次判定結果票フラグ,
                事務局特記事項_一次判定フラグ,
                事務局主治医意見書フラグ,
                事務局その他資料フラグ,
                事務局概況特記フラグ,
                事務局予備判定記入表フラグ,
                事務局概況特記一覧フラグ,
                委員用審査会対象者一覧フラグ,
                委員用特記事項フラグ,
                委員用一次判定結果票フラグ,
                委員用特記事項_一次判定フラグ,
                委員用主治医意見書フラグ,
                委員用その他資料フラグ,
                委員用審査会開催通知書フラグ,
                委員用予備判定記入表フラグ);
    }

    private ShiryoShinsakaiBatchParameter set項目(
            RString 事務局審査会対象者一覧フラグ,
            RString 事務局特記事項フラグ,
            RString 事務局一次判定結果票フラグ,
            RString 事務局特記事項_一次判定フラグ,
            RString 事務局主治医意見書フラグ,
            RString 事務局その他資料フラグ,
            RString 事務局概況特記フラグ,
            RString 事務局予備判定記入表フラグ,
            RString 事務局概況特記一覧フラグ,
            RString 委員用審査会対象者一覧フラグ,
            RString 委員用特記事項フラグ,
            RString 委員用一次判定結果票フラグ,
            RString 委員用特記事項_一次判定フラグ,
            RString 委員用主治医意見書フラグ,
            RString 委員用その他資料フラグ,
            RString 委員用審査会開催通知書フラグ,
            RString 委員用予備判定記入表フラグ) {
        return new ShiryoShinsakaiBatchParameter(
                div.getTxtShinsakaiKaisaiNo().getValue(),
                div.getTxtShinsakaiYoteiDate().getValue(),
                new RString(div.getTxtShinsakaiKaishiYoteiTime().getValue().toString()),
                div.getTxtGogitaiNo() == null || RString.isNullOrEmpty(div.getTxtGogitaiNo().getValue())
                ? 0 : Integer.parseInt(div.getTxtGogitaiNo().getValue().toString()),
                div.getTxtGogitaiName().getValue(),
                div.getTxtShutsuryokuJun().getValue(),
                div.getDdlShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadSakuseiJokenType().getSelectedValue(),
                div.getTxtShiryoNoStart() == null || div.getTxtShiryoNoStart().getValue() == null
                ? 0 : div.getTxtShiryoNoStart().getValue().intValue(),
                div.getTxtSiryoNoEnd() == null || div.getTxtSiryoNoEnd().getValue() == null
                ? 0 : div.getTxtSiryoNoEnd().getValue().intValue(),
                事務局審査会対象者一覧フラグ,
                事務局特記事項フラグ,
                事務局一次判定結果票フラグ,
                事務局特記事項_一次判定フラグ,
                事務局主治医意見書フラグ,
                事務局その他資料フラグ,
                事務局概況特記フラグ,
                事務局予備判定記入表フラグ,
                事務局概況特記一覧フラグ,
                委員用審査会対象者一覧フラグ,
                委員用特記事項フラグ,
                委員用一次判定結果票フラグ,
                委員用特記事項_一次判定フラグ,
                委員用主治医意見書フラグ,
                委員用その他資料フラグ,
                委員用審査会開催通知書フラグ,
                委員用予備判定記入表フラグ);
    }

    private void 出力条件の設定() {
        List<RString> 事務局_印刷帳票 = new ArrayList<>();
        List<RString> 事務局_概況特記 = new ArrayList<>();
        List<RString> 印刷帳票_事務局審査会資料 = new ArrayList<>();

        List<RString> 委員_印刷帳票 = new ArrayList<>();
        List<RString> 委員_概況特記 = new ArrayList<>();
        List<RString> 印刷帳票_委員審査会資料 = new ArrayList<>();

        RDate 日期 = RDate.getNowDate();
        RString 出力順 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力順, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力スタイル, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷タイプ, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷帳票_事務局 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷帳票_委員 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員, 日期, SubGyomuCode.DBE認定支援);
        div.getTxtShutsuryokuJun().setValue(出力順);
        div.getDdlShutsuryokuStyleZenken().setSelectedKey(出力スタイル);
        div.getRadShutsuryokuStyleZenken().setSelectedKey(印刷タイプ);
        if (個別設定.equals(印刷帳票_事務局)) {
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            RString 概況特記一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_概況特記一覧, 日期, SubGyomuCode.DBE認定支援);
            if (is事務局項目を選択(予備判定記入票)) {
                事務局_概況特記.add(印刷帳票_予備判定記入票);
            }
            if (is事務局項目を選択(概況特記一覧)) {
                事務局_概況特記.add(印刷帳票_概況特記一覧);
            }
            事務局用の審査会資料設定(事務局_印刷帳票, 印刷帳票_事務局審査会資料);
        } else {
            事務局_印刷帳票.add(印刷帳票_すべて選択);
            事務局_印刷帳票.add(印刷帳票_審査会資料);

            事務局_概況特記.add(印刷帳票_概況特記);
            事務局_概況特記.add(印刷帳票_予備判定記入票);
            事務局_概況特記.add(印刷帳票_概況特記一覧);

            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
        }
        div.getChkPrintChoyoJimu().setSelectedItemsByKey(事務局_印刷帳票);
        div.getChkPrintChohyoShinsakaiJimu().setSelectedItemsByKey(印刷帳票_事務局審査会資料);
        div.getChkPrintChoyoJimu2().setSelectedItemsByKey(事務局_概況特記);

        if (個別設定.equals(印刷帳票_委員)) {
            RString 審査会開催通知書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_開催通知書, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            if (is事務局項目を選択(審査会開催通知書)) {
                委員_概況特記.add(印刷帳票_概況特記);
            }
            if (is事務局項目を選択(予備判定記入票)) {
                委員_概況特記.add(印刷帳票_予備判定記入票);
            }
            委員の審査会資料設定(委員_印刷帳票, 印刷帳票_委員審査会資料);
        } else {
            委員_印刷帳票.add(印刷帳票_すべて選択);
            委員_印刷帳票.add(印刷帳票_審査会資料);

            委員_概況特記.add(印刷帳票_概況特記);
            委員_概況特記.add(印刷帳票_予備判定記入票);

            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
        }
        div.getChkPrintChohyoIin().setSelectedItemsByKey(委員_印刷帳票);
        div.getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(印刷帳票_委員審査会資料);
        div.getChkPrintChohyoIin2().setSelectedItemsByKey(委員_概況特記);
    }

    private void 事務局用の審査会資料設定(List<RString> 事務局_印刷帳票, List<RString> 印刷帳票_事務局審査会資料) {
        RDate 日期 = RDate.getNowDate();
        RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会資料, 日期, SubGyomuCode.DBE認定支援);
        RString 審査会対象者一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会対象者一覧, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_特記事項, 日期, SubGyomuCode.DBE認定支援);
        RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
        RString その他資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_その他資料, 日期, SubGyomuCode.DBE認定支援);
        if (個別設定.equals(審査会資料)) {
            if (is事務局項目を選択(審査会対象者一覧)) {
                印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            }
            if (is事務局項目を選択(特記事項)) {
                印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            }
            if (is事務局項目を選択(一次判定結果票)) {
                印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            }
            if (is事務局項目を選択(主治医意見書)) {
                印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            }
            if (is事務局項目を選択(その他資料)) {
                印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
            }
        } else {
            事務局_印刷帳票.add(印刷帳票_審査会資料);

            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);

        }
    }

    private void 委員の審査会資料設定(List<RString> 委員_印刷帳票, List<RString> 印刷帳票_委員審査会資料) {
        RDate 日期 = RDate.getNowDate();
        RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会資料, 日期, SubGyomuCode.DBE認定支援);
        RString 審査会対象者一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会対象者一覧, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項, 日期, SubGyomuCode.DBE認定支援);
        RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
        RString その他資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_その他資料, 日期, SubGyomuCode.DBE認定支援);
        if (個別設定.equals(審査会資料)) {
            if (is事務局項目を選択(審査会対象者一覧)) {
                印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            }
            if (is事務局項目を選択(特記事項)) {
                印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            }
            if (is事務局項目を選択(一次判定結果票)) {
                印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            }
            if (is事務局項目を選択(主治医意見書)) {
                印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            }
            if (is事務局項目を選択(その他資料)) {
                印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
            }
        } else {
            委員_印刷帳票.add(印刷帳票_審査会資料);

            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
        }
    }

    private boolean is事務局項目を選択(RString 項目) {
        return 選択.equals(項目);
    }

    private RString to転換(RString 項目) {
        if (!RString.isNullOrEmpty(項目)) {
            return 項目;
        }
        return RString.EMPTY;
    }

    private FlexibleDate to日期転換(FlexibleDate 項目) {
        if (項目 != null && !項目.isEmpty()) {
            return 項目;
        }
        return FlexibleDate.EMPTY;
    }

    private void set審査会資料選択可能の設定() {
        List<RString> 印刷帳票_事務局審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChoyoJimu().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_事務局審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項);
            印刷帳票_事務局審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_事務局審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_事務局審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_事務局審査会資料.add(印刷帳票_その他資料);
            div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(印刷帳票_事務局審査会資料);
        }

        List<RString> 印刷帳票_委員審査会資料 = new ArrayList<>();
        if (!div.getChkPrintChohyoIin().getSelectedKeys().contains(印刷帳票_審査会資料)) {
            印刷帳票_委員審査会資料.add(印刷帳票_審査会対象者一覧);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項);
            印刷帳票_委員審査会資料.add(印刷帳票_一次判定結果票);
            印刷帳票_委員審査会資料.add(印刷帳票_特記事項_一次判定);
            印刷帳票_委員審査会資料.add(印刷帳票_主治医意見書);
            印刷帳票_委員審査会資料.add(印刷帳票_その他資料);
            div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(印刷帳票_委員審査会資料);
        }
    }
}
