/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5210010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.jizenshinsakaishiryopublication.JizenShinsakaiShiryoPublicationBusiness;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE526002.DBE526002_JIzenShinsakekkaTorokuSakuseiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010.JizenShinsakaiShiryoPublicationDiv;
import jp.co.ndensan.reams.db.dbx.business.core.shichosonsecurity.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.DonyuKeitaiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurity.ShichosonSecurityJohoFinder;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護認定審査会委員事前審査 のコントローラです。
 *
 * @reamsid_L DBE-1630-010 dangjingjing
 */
public class JizenShinsakaiShiryoPublicationHandler {

    private final JizenShinsakaiShiryoPublicationDiv div;
    private static final RString すべて選択_印刷一次判定_A4_両面_1 = new RString("1");
    private static final RString 個別設定_印刷特記事項_A3_片面_2 = new RString("2");
    private static final RString 印刷帳票_審査会開催のお知らせ = new RString("key0");
    private static final RString 印刷帳票_審査会資料 = new RString("key1");
    private static final RString 印刷帳票_予備判定記入表 = new RString("key2");
    private static final RString 印刷帳票_特記事項_0 = new RString("0");
    private static final RString 印刷帳票_主治医意見書_3 = new RString("3");
    private final RDate 日期 = RDate.getNowDate();

    /**
     * コンストラクタです。
     *
     * @param div 介護認定審査会委員事前審査Div
     */
    public JizenShinsakaiShiryoPublicationHandler(JizenShinsakaiShiryoPublicationDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理です。
     *
     * @param 対象審査会情報 対象審査会情報
     * @param 審査会開催番号 審査会開催番号
     */
    public void onLoad(JizenShinsakaiShiryoPublicationBusiness 対象審査会情報, RString 審査会開催番号) {
        if (対象審査会情報 != null) {
            set画面を表示する(対象審査会情報, 審査会開催番号);
            set出力条件の設定();
        }
    }

    private void set画面を表示する(JizenShinsakaiShiryoPublicationBusiness 対象審査会情報, RString 審査会開催番号) {
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().setValue(審査会開催番号);
        div.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate().setValue(new FlexibleDate(対象審査会情報.get介護認定審査会開催予定年月日()));
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaijo().setValue(対象審査会情報.get介護認定審査会開催場所名称());
        div.getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime().setValue(new RTime(対象審査会情報.get介護認定審査会開始予定時刻()));
        div.getPublicationTargetShinsakai().getTxtShiryoSakusei().setValue(dateFormat(new FlexibleDate(対象審査会情報.get介護認定審査会資料作成年月日())));
        div.getPublicationTargetShinsakai().getTxtGogitaiNo().setValue(対象審査会情報.get合議体番号());
        div.getPublicationTargetShinsakai().getTxtGogitaiName().setValue(対象審査会情報.get合議体名称());
        div.getPublicationTargetShinsakai().getTxtYoteiTeiin().setValue(new Decimal(対象審査会情報.get介護認定審査会予定定員().toString()));
        div.getPublicationTargetShinsakai().getTxtWariateNinzu().setValue(new Decimal(対象審査会情報.get介護認定審査会割当済み人数().toString()));
    }

    private void set出力条件の設定() {
        List<RString> 印刷帳票chk = new ArrayList<>();
        List<RString> 印刷審査会資料chk = new ArrayList<>();
        RString 出力順 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力順, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル_印刷サイズddl = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力スタイル, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル_両面_片面印刷rad = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷タイプ, 日期, SubGyomuCode.DBE認定支援);
        RString 部数 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料部数_委員, 日期, SubGyomuCode.DBE認定支援);
        div.getPublishingCondition().getTxtShutsuryokuJun().setValue(出力順);
        div.getPublishingCondition().getRadShutsuryokuStyleZenken().setSelectedKey(出力スタイル_両面_片面印刷rad);
        div.getPublishingCondition().getDdlShutsuryokuStyleZenken().setSelectedKey(出力スタイル_印刷サイズddl);
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getTxtCopyNumForShinsakaiIin1().setValue(new Decimal(部数.toString()));
        RString 印刷帳票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員, 日期, SubGyomuCode.DBE認定支援);
        if (すべて選択_印刷一次判定_A4_両面_1.equals(印刷帳票)) {
            RString 審査会開催通知書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_開催通知書, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会資料, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項, 日期, SubGyomuCode.DBE認定支援);
            RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項_一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項_一次判定結果票, 日期,
                    SubGyomuCode.DBE認定支援);
            RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            if (個別設定_印刷特記事項_A3_片面_2.equals(審査会開催通知書)) {
                印刷帳票chk.add(印刷帳票_審査会開催のお知らせ);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(審査会資料)) {
                印刷帳票chk.add(印刷帳票_審査会資料);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(特記事項)) {
                印刷審査会資料chk.add(印刷帳票_特記事項_0);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(一次判定結果票)) {
                印刷審査会資料chk.add(すべて選択_印刷一次判定_A4_両面_1);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(特記事項_一次判定結果票)) {
                印刷審査会資料chk.add(個別設定_印刷特記事項_A3_片面_2);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(主治医意見書)) {
                印刷審査会資料chk.add(印刷帳票_主治医意見書_3);
            }
            if (個別設定_印刷特記事項_A3_片面_2.equals(予備判定記入票)) {
                印刷帳票chk.add(印刷帳票_予備判定記入表);
            }
        }
        if (すべて選択_印刷一次判定_A4_両面_1.equals(印刷帳票)) {
            印刷帳票chk.add(印刷帳票_審査会開催のお知らせ);
            印刷帳票chk.add(印刷帳票_審査会資料);
            印刷審査会資料chk.add(印刷帳票_特記事項_0);
            印刷審査会資料chk.add(すべて選択_印刷一次判定_A4_両面_1);
            印刷審査会資料chk.add(個別設定_印刷特記事項_A3_片面_2);
            印刷審査会資料chk.add(印刷帳票_主治医意見書_3);
            印刷帳票chk.add(印刷帳票_予備判定記入表);
        }
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().setSelectedItemsByKey(印刷帳票chk);
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                .setSelectedItemsByKey(印刷審査会資料chk);
        div.getPublishingCondition().getCcdBunshoNoInput().initialize(ReportIdDBE.DBE515001.getReportId());
//        ShichosonSecurityJohoFinder 市町村セキュリティFinder = ShichosonSecurityJohoFinder.createInstance();
//        ShichosonSecurityJoho 市町村セキュリティ情報 = 市町村セキュリティFinder.getShichosonSecurityJoho(GyomuBunrui.介護認定);
//        if (市町村セキュリティ情報 != null && 市町村セキュリティ情報.get導入形態コード() != null) {
//            if (DonyuKeitaiCode.認定広域.getCode().equals(市町村セキュリティ情報.get導入形態コード().getCode())) {
//                div.getPublishingCondition().getCcdBunshoNoInput().initialize(new ReportId(ReportIdDBE.DBE515001.getReportId().value().concat("_")
//                        .concat(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))));
//            } else {
//                div.getPublishingCondition().getCcdBunshoNoInput().initialize(ReportIdDBE.DBE515001.getReportId());
//            }
//        } else {
//            div.getPublishingCondition().getCcdBunshoNoInput().initialize(ReportIdDBE.DBE515001.getReportId());
//        }
    }

    /**
     * 印刷審査会資料選択チェックボックスの使用可能・不可能を設定でし。
     */
    public void set審査会資料選択chkの設定() {
        if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys()
                .contains(印刷帳票_審査会資料)) {
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabled(false);
            set選択chk();
        } else {
            List<RString> keys = new ArrayList<>();
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(keys);
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(keys);
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabled(true);
        }
        if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys()
                .contains(印刷帳票_審査会開催のお知らせ)) {
            div.getPublishingCondition().getCcdBunshoNoInput().setDisabled(false);
        } else {
            div.getPublishingCondition().getCcdBunshoNoInput().setDisabled(true);
        }
    }

    private void set選択chk() {
        if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(個別設定_印刷特記事項_A3_片面_2)) {
            List<RString> keys_se = new ArrayList<>();
            if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                    .getSelectedKeys().contains(個別設定_印刷特記事項_A3_片面_2)) {
                keys_se.add(個別設定_印刷特記事項_A3_片面_2);
            }
            if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                    .getSelectedKeys().contains(印刷帳票_主治医意見書_3)) {
                keys_se.add(印刷帳票_主治医意見書_3);
            }
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(keys_se);
            List<RString> keys = new ArrayList<>();
            keys.add(印刷帳票_特記事項_0);
            keys.add(すべて選択_印刷一次判定_A4_両面_1);
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(keys);
        } else if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(すべて選択_印刷一次判定_A4_両面_1)) {
            List<RString> keys_se = new ArrayList<>();
            if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                    .getSelectedKeys().contains(印刷帳票_特記事項_0)) {
                keys_se.add(印刷帳票_特記事項_0);
            }
            if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                    .getSelectedKeys().contains(すべて選択_印刷一次判定_A4_両面_1)) {
                keys_se.add(すべて選択_印刷一次判定_A4_両面_1);
            }
            if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                    .getSelectedKeys().contains(印刷帳票_主治医意見書_3)) {
                keys_se.add(印刷帳票_主治医意見書_3);
            }
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setSelectedItemsByKey(keys_se);
            List<RString> keys = new ArrayList<>();
            keys.add(個別設定_印刷特記事項_A3_片面_2);
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setDisabledItemsByKey(keys);
        }
    }

    /**
     * バッチパラメータの設定します。
     *
     * @return DBE526002_JIzenShinsakekkaTorokuSakuseiParameter
     */
    public DBE526002_JIzenShinsakekkaTorokuSakuseiParameter setバッチパラメータの設定() {
        DBE526002_JIzenShinsakekkaTorokuSakuseiParameter batchParameter = new DBE526002_JIzenShinsakekkaTorokuSakuseiParameter();
        if (!div.getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().getValue().isEmpty()) {
            batchParameter.setShinsakaiKaisaiNo(div.getPublicationTargetShinsakai().getTxtShinsakaiKaisaiNo().getValue());
        }
        if (!div.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate().getValue().isEmpty()) {
            batchParameter.setShinsakaiKaisaiYoteiYMD(div.getPublicationTargetShinsakai().getTxtShinsakaiYoteiDate().getValue());
        }
        if (!new RString(div.getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime().getValue().toString()).isEmpty()) {
            batchParameter.setShinsakaiKaishiYoteiTime(new RString(div.getPublicationTargetShinsakai().getTxtShinsakaiKaishiYoteiTime()
                    .getValue().toString()));
        }
        if (!div.getPublicationTargetShinsakai().getTxtShinsakaiKaijo().getValue().isEmpty()) {
            batchParameter.setShinsakaiKaisaiBashoName(div.getPublicationTargetShinsakai().getTxtShinsakaiKaijo().getValue());
        }
        if (!div.getPublicationTargetShinsakai().getTxtGogitaiNo().getValue().toString().isEmpty()) {
            batchParameter.setGogitaiNo(Integer.valueOf(div.getPublicationTargetShinsakai().getTxtGogitaiNo().getValue().toString()));
        }
        if (!div.getPublicationTargetShinsakai().getTxtGogitaiName().getValue().isEmpty()) {
            batchParameter.setGogitaiMei(div.getPublicationTargetShinsakai().getTxtGogitaiName().getValue());
        }
        if (div.getPublicationTargetShinsakai().getTxtYoteiTeiin().getValue() != null) {
            batchParameter.setSyuturyokuJun(new RString(div.getPublicationTargetShinsakai().getTxtYoteiTeiin().getValue().toString()));
        }
        if (div.getPublishingCondition().getTxtShutsuryokuJun().getValue() != null) {
            batchParameter.setSyuturyokuJun(new RString(div.getPublishingCondition().getTxtShutsuryokuJun().getValue().toString()));
        }
        if (!div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().isEmpty()) {
            if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(すべて選択_印刷一次判定_A4_両面_1)) {
                batchParameter.setSyuturyokuStyle(すべて選択_印刷一次判定_A4_両面_1);
            } else if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(個別設定_印刷特記事項_A3_片面_2)) {
                batchParameter.setSyuturyokuStyle(個別設定_印刷特記事項_A3_片面_2);
            }
        }
        if (!div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().isEmpty()) {
            if (div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().equals(すべて選択_印刷一次判定_A4_両面_1)) {
                batchParameter.setInsatuHouhou(すべて選択_印刷一次判定_A4_両面_1);
            } else if (div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().equals(個別設定_印刷特記事項_A3_片面_2)) {
                batchParameter.setInsatuHouhou(個別設定_印刷特記事項_A3_片面_2);
            }
        }
        batchParameter.setSakuseiJyoken(new RString("全件"));
        batchParameter.setKaishisiyoBangou(RString.EMPTY);
        batchParameter.setShuryosiyoBangou(RString.EMPTY);
        if (!new RString(div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getTxtCopyNumForShinsakaiIin1().getValue()
                .toString()).isEmpty()) {
            batchParameter.setIinyoFusuu(new RString(div.getPublishingCondition().getPublishingConditionForShinsakaiIin()
                    .getTxtCopyNumForShinsakaiIin1().getValue().toString()));
        }
        setバッチ(batchParameter);
        batchParameter.setBunshoKanriNo(div.getPublishingCondition().getCcdBunshoNoInput().get文書番号());
        return batchParameter;
    }

    private void setバッチ(DBE526002_JIzenShinsakekkaTorokuSakuseiParameter batchParameter) {
        List<RString> 印刷帳票 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys();
        List<RString> 印刷審査会資料 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                .getSelectedKeys();
        if (印刷帳票.contains(印刷帳票_審査会開催のお知らせ)) {
            batchParameter.setTuutiFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setTuutiFlag(印刷帳票_特記事項_0);
        }
        if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().isAllSelected()) {
            batchParameter.setKumiawaseFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setKumiawaseFlag(印刷帳票_特記事項_0);
        }
        if (印刷審査会資料.contains(印刷帳票_特記事項_0)) {
            batchParameter.setTokkiJikouFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setTokkiJikouFlag(印刷帳票_特記事項_0);
        }
        if (印刷審査会資料.contains(すべて選択_印刷一次判定_A4_両面_1)) {
            batchParameter.setItiHenteiKekkaFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setItiHenteiKekkaFlag(印刷帳票_特記事項_0);
        }
        if (印刷審査会資料.contains(個別設定_印刷特記事項_A3_片面_2)) {
            batchParameter.setTokkiPlusItiFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setTokkiPlusItiFlag(印刷帳票_特記事項_0);
        }
        if (印刷審査会資料.contains(印刷帳票_主治医意見書_3)) {
            batchParameter.setIkensyoFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setIkensyoFlag(印刷帳票_特記事項_0);
        }
        if (印刷帳票.contains(印刷帳票_予備判定記入表)) {
            batchParameter.setYobiHenteiFlag(すべて選択_印刷一次判定_A4_両面_1);
        } else {
            batchParameter.setYobiHenteiFlag(印刷帳票_特記事項_0);
        }
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
