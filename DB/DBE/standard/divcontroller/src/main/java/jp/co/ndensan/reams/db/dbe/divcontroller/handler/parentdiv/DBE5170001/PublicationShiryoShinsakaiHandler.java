/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5170001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.publicationshiryoshinsakai.PublicationShiryoShinsakaiBatchParameter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5170001.PublicationShiryoShinsakaiDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
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
    private final RString 事務用出力条件_概況特記 = new RString("key2");
    private final RString 事務用出力条件_予備判定記入表 = new RString("key3");
    private final RString 事務用出力条件_概況特記一覧 = new RString("key4");
    private final RString 出力条件_特記事項_一次判定結果票 = new RString("key2");
    private final RString 出力条件_主治医意見書 = new RString("key3");
    private final RString 委員用出力条件_予備判定記入表 = new RString("key2");
    private final RString 出力スタイル_A4 = new RString("1");
    private final PublicationShiryoShinsakaiDiv div;

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
     */
    public void onLoad() {
        出力条件の設定();
        List<RString> 事務 = new ArrayList<>();
        事務.add(事務用出力条件_概況特記);
        div.getChkPrintChoyoJimu().setDisabledItemsByKey(事務);
    }

    /**
     * 作成条件ラジオボタンを変更する場合、表示項目を変更する。
     */
    public void 活性と非活性設定() {
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        List<RString> 事務 = new ArrayList<>();
        List<RString> 事務_審査会資料 = new ArrayList<>();
        List<RString> 委員 = new ArrayList<>();
        if (作成条件_全件.equals(作成条件)) {
            事務.add(事務用出力条件_概況特記);
            div.getChkPrintChoyoJimu().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoIin().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        } else if (作成条件_範囲指定.equals(作成条件)) {
            事務.add(作成条件_全件);
            事務.add(事務用出力条件_予備判定記入表);
            事務.add(事務用出力条件_概況特記一覧);
            事務_審査会資料.add(作成条件_全件);
            事務_審査会資料.add(作成条件_範囲指定);
            事務_審査会資料.add(出力条件_特記事項_一次判定結果票);
            事務_審査会資料.add(出力条件_主治医意見書);
            委員.add(委員用出力条件_予備判定記入表);
            div.getChkPrintChoyoJimu().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(事務_審査会資料);
            div.getChkPrintChohyoIin().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().setDisabled(false);
            div.getTxtSiryoNoEnd().setDisabled(false);
        } else {
            事務.add(作成条件_全件);
            事務.add(事務用出力条件_予備判定記入表);
            事務.add(事務用出力条件_概況特記一覧);
            事務_審査会資料.add(作成条件_全件);
            事務_審査会資料.add(作成条件_範囲指定);
            事務_審査会資料.add(出力条件_特記事項_一次判定結果票);
            事務_審査会資料.add(出力条件_主治医意見書);
            委員.add(委員用出力条件_予備判定記入表);
            div.getChkPrintChoyoJimu().setDisabledItemsByKey(事務);
            div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(事務_審査会資料);
            div.getChkPrintChohyoIin().setDisabledItemsByKey(委員);
            div.getTxtShiryoNoStart().setDisabled(true);
            div.getTxtSiryoNoEnd().setDisabled(true);
        }
    }

    /**
     * 事務局用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClick_chkPrintChoyoJimu() {
        List<RString> 事務_審査会資料 = new ArrayList<>();
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        if (作成条件_全件.equals(作成条件)) {
            if (!div.getChkPrintChoyoJimu().getSelectedKeys().contains(作成条件_範囲指定)) {
                事務_審査会資料.add(作成条件_全件);
                事務_審査会資料.add(作成条件_範囲指定);
                事務_審査会資料.add(出力条件_特記事項_一次判定結果票);
                事務_審査会資料.add(出力条件_主治医意見書);
            } else {
                if (出力スタイル_A4.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                    事務_審査会資料.add(出力条件_特記事項_一次判定結果票);
                } else {
                    事務_審査会資料.add(作成条件_全件);
                    事務_審査会資料.add(作成条件_範囲指定);
                }
            }
            div.getChkPrintChohyoShinsakaiJimu().setDisabledItemsByKey(事務_審査会資料);
        }
    }

    /**
     * 審査会委員用印刷帳票チェックボックスを変更する場合、表示項目を変更する。
     */
    public void onClick_chkPrintChohyoIin() {
        List<RString> 委員_審査会資料 = new ArrayList<>();
        RString 作成条件 = div.getRadSakuseiJokenType().getSelectedKey();
        if (作成条件_全件.equals(作成条件)) {
            if (!div.getChkPrintChohyoIin().getSelectedKeys().contains(作成条件_範囲指定)) {
                委員_審査会資料.add(作成条件_全件);
                委員_審査会資料.add(作成条件_範囲指定);
                委員_審査会資料.add(出力条件_特記事項_一次判定結果票);
                委員_審査会資料.add(出力条件_主治医意見書);
            } else {
                if (出力スタイル_A4.equals(div.getDdlShutsuryokuStyleZenken().getSelectedKey())) {
                    委員_審査会資料.add(出力条件_特記事項_一次判定結果票);
                } else {
                    委員_審査会資料.add(作成条件_全件);
                    委員_審査会資料.add(作成条件_範囲指定);
                }
            }
            div.getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(委員_審査会資料);
        }
    }

    /**
     * バッチパラメータを設定します。
     *
     * @return PublicationShiryoShinsakaiBatchParameter
     */
    public PublicationShiryoShinsakaiBatchParameter onClick_btnKogakuParamSave() {

        RString 事務_審査会開催通知書フラグ = new RString("0");
        RString 事務_特記事項フラグ = new RString("0");
        RString 事務_一次判定結果票フラグ = new RString("0");
        RString 事務_特記事項_一次判定フラグ = new RString("0");
        RString 事務_主治医意見書フラグ = new RString("0");
        RString 事務_概況特記フラグ = new RString("0");
        RString 事務_予備判定記入表フラグ = new RString("0");
        RString 事務_概況特記一覧フラグ = new RString("0");
        RString 委員_審査会開催通知書フラグ = new RString("0");
        RString 委員_特記事項フラグ = new RString("0");
        RString 委員_一次判定結果票フラグ = new RString("0");
        RString 委員_特記事項_一次判定フラグ = new RString("0");
        RString 委員_主治医意見書フラグ = new RString("0");
        RString 委員_予備判定記入表フラグ = new RString("0");
        List<RString> 事務用出力条件帳票 = div.getChkPrintChoyoJimu().getSelectedKeys();
        List<RString> 事務用出力条件資料 = div.getChkPrintChohyoShinsakaiJimu().getSelectedKeys();
        List<RString> 委員用出力条件帳票 = div.getChkPrintChohyoIin().getSelectedKeys();
        List<RString> 委員用出力条件資料 = div.getChkPrintChohyoShinsakaiIin().getSelectedKeys();
        if (事務用出力条件帳票.contains(作成条件_全件)) {
            事務_審査会開催通知書フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(作成条件_全件)) {
            事務_特記事項フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(作成条件_範囲指定)) {
            事務_一次判定結果票フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(出力条件_特記事項_一次判定結果票)) {
            事務_特記事項_一次判定フラグ = new RString("1");
        }
        if (事務用出力条件資料.contains(出力条件_主治医意見書)) {
            事務_主治医意見書フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(事務用出力条件_概況特記)) {
            事務_概況特記フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(事務用出力条件_予備判定記入表)) {
            事務_予備判定記入表フラグ = new RString("1");
        }
        if (事務用出力条件帳票.contains(事務用出力条件_概況特記一覧)) {
            事務_概況特記一覧フラグ = new RString("1");
        }
        if (委員用出力条件帳票.contains(作成条件_全件)) {
            委員_審査会開催通知書フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(作成条件_全件)) {
            委員_特記事項フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(作成条件_範囲指定)) {
            委員_一次判定結果票フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(出力条件_特記事項_一次判定結果票)) {
            委員_特記事項_一次判定フラグ = new RString("1");
        }
        if (委員用出力条件資料.contains(出力条件_主治医意見書)) {
            委員_主治医意見書フラグ = new RString("1");
        }
        if (委員用出力条件帳票.contains(委員用出力条件_予備判定記入表)) {
            委員_予備判定記入表フラグ = new RString("1");
        }
        return new PublicationShiryoShinsakaiBatchParameter(
                div.getTxtShinsakaiKaisaiNo().getValue(),
                div.getTxtShinsakaiYoteiDate().getValue(),
                new RString(div.getTxtShinsakaiKaishiYoteiTime().getValue().toString()),
                div.getTxtShinsakaiKaijo().getValue(),
                div.getTxtGogitaiNo().getValue(),
                div.getTxtGogitaiName().getValue(),
                div.getTxtShutsuryokuJun().getValue(),
                div.getDdlShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadShutsuryokuStyleZenken().getSelectedKey(),
                div.getRadSakuseiJokenType().getSelectedValue(),
                new RString(div.getTxtShiryoNoStart().getValue().toString()),
                new RString(div.getTxtSiryoNoEnd().getValue().toString()),
                new RString(div.getTxtCopyNumForJimukyoku1().getValue().toString()),
                new RString(div.getTxtCopyNumForShinsakaiIin1().getValue().toString()),
                事務_審査会開催通知書フラグ,
                事務_特記事項フラグ,
                事務_一次判定結果票フラグ,
                事務_特記事項_一次判定フラグ,
                事務_主治医意見書フラグ,
                事務_概況特記フラグ,
                事務_予備判定記入表フラグ,
                事務_概況特記一覧フラグ,
                委員_審査会開催通知書フラグ,
                委員_特記事項フラグ,
                委員_一次判定結果票フラグ,
                委員_特記事項_一次判定フラグ,
                委員_主治医意見書フラグ,
                委員_予備判定記入表フラグ);
    }

    private void 出力条件の設定() {
        List<RString> 印刷帳票_事務局リスト = new ArrayList<>();
        List<RString> 印刷帳票_委員リスト = new ArrayList<>();
        RDate 日期 = RDate.getNowDate();
        RString 出力順 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力順, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力スタイル, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷タイプ = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷タイプ, 日期, SubGyomuCode.DBE認定支援);
        RString 部数_事務局 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料部数_事務局, 日期, SubGyomuCode.DBE認定支援);
        RString 部数_委員 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料部数_委員, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷帳票_事務局 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局, 日期, SubGyomuCode.DBE認定支援);
        RString 印刷帳票_委員 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員, 日期, SubGyomuCode.DBE認定支援);
        div.getTxtShutsuryokuJun().setValue(出力順);
        div.getDdlShutsuryokuStyleZenken().setSelectedKey(出力スタイル);
        div.getRadShutsuryokuStyleZenken().setSelectedKey(印刷タイプ);
        div.getTxtCopyNumForJimukyoku1().setValue(new Decimal(部数_事務局.toString()));
        div.getTxtCopyNumForShinsakaiIin1().setValue(new Decimal(部数_委員.toString()));
        if (個別設定.equals(印刷帳票_事務局)) {
            RString 審査会対象者一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会対象者一覧, 日期, SubGyomuCode.DBE認定支援);
            RString 概況特記 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_概況特記, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            RString 概況特記一覧 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_概況特記一覧, 日期, SubGyomuCode.DBE認定支援);
            事務局用の審査会資料設定();
            if (is事務局項目を選択(審査会対象者一覧)) {
                印刷帳票_事務局リスト.add(作成条件_全件);
            }
            if (is事務局項目を選択(概況特記)) {
                印刷帳票_事務局リスト.add(事務用出力条件_概況特記);
            }
            if (is事務局項目を選択(予備判定記入票)) {
                印刷帳票_事務局リスト.add(事務用出力条件_予備判定記入表);
            }
            if (is事務局項目を選択(概況特記一覧)) {
                印刷帳票_事務局リスト.add(事務用出力条件_概況特記一覧);
            }
        } else {
            印刷帳票_事務局リスト.add(作成条件_全件);
            印刷帳票_事務局リスト.add(事務用出力条件_概況特記);
            印刷帳票_事務局リスト.add(事務用出力条件_予備判定記入表);
            印刷帳票_事務局リスト.add(事務用出力条件_概況特記一覧);
        }
        印刷帳票_事務局リスト.add(作成条件_範囲指定);
        div.getChkPrintChoyoJimu().setSelectedItemsByKey(印刷帳票_事務局リスト);
        if (個別設定.equals(印刷帳票_委員)) {
            RString 審査会開催通知書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_開催通知書, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            委員の審査会資料設定();
            if (is事務局項目を選択(審査会開催通知書)) {
                印刷帳票_委員リスト.add(作成条件_全件);
            }
            if (is事務局項目を選択(予備判定記入票)) {
                印刷帳票_委員リスト.add(委員用出力条件_予備判定記入表);
            }
        } else {
            印刷帳票_委員リスト.add(作成条件_全件);
            印刷帳票_委員リスト.add(委員用出力条件_予備判定記入表);
        }
        印刷帳票_委員リスト.add(作成条件_範囲指定);
        div.getChkPrintChohyoIin().setSelectedItemsByKey(印刷帳票_委員リスト);
    }

    private void 事務局用の審査会資料設定() {
        RDate 日期 = RDate.getNowDate();
        List<RString> 審査会資料リスト = new ArrayList<>();
        RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_審査会資料, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_特記事項, 日期, SubGyomuCode.DBE認定支援);
        RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項_一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_特記事項_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_事務局_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
        if (個別設定.equals(審査会資料)) {
            if (is事務局項目を選択(特記事項)) {
                審査会資料リスト.add(作成条件_全件);
            }
            if (is事務局項目を選択(一次判定結果票)) {
                審査会資料リスト.add(作成条件_範囲指定);
            }
            if (is事務局項目を選択(特記事項_一次判定結果票)) {
                審査会資料リスト.add(出力条件_特記事項_一次判定結果票);
            }
            if (is事務局項目を選択(主治医意見書)) {
                審査会資料リスト.add(出力条件_主治医意見書);
            }
        } else {
            審査会資料リスト.add(作成条件_全件);
            審査会資料リスト.add(作成条件_範囲指定);
            審査会資料リスト.add(出力条件_特記事項_一次判定結果票);
            審査会資料リスト.add(出力条件_主治医意見書);
        }
        div.getChkPrintChohyoShinsakaiJimu().setSelectedItemsByKey(審査会資料リスト);
    }

    private void 委員の審査会資料設定() {
        RDate 日期 = RDate.getNowDate();
        List<RString> 審査会資料リスト = new ArrayList<>();
        RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会資料, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項, 日期, SubGyomuCode.DBE認定支援);
        RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 特記事項_一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
        RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
        if (個別設定.equals(審査会資料)) {
            if (is事務局項目を選択(特記事項)) {
                審査会資料リスト.add(作成条件_全件);
            }
            if (is事務局項目を選択(一次判定結果票)) {
                審査会資料リスト.add(作成条件_範囲指定);
            }
            if (is事務局項目を選択(特記事項_一次判定結果票)) {
                審査会資料リスト.add(出力条件_特記事項_一次判定結果票);
            }
            if (is事務局項目を選択(主治医意見書)) {
                審査会資料リスト.add(出力条件_主治医意見書);
            }
        } else {
            審査会資料リスト.add(作成条件_全件);
            審査会資料リスト.add(作成条件_範囲指定);
            審査会資料リスト.add(出力条件_特記事項_一次判定結果票);
            審査会資料リスト.add(出力条件_主治医意見書);
        }
        div.getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(審査会資料リスト);
    }

    private boolean is事務局項目を選択(RString 項目) {
        return 選択.equals(項目);
    }
}
