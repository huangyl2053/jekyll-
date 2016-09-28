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
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010.JizenShinsakaiShiryoPublicationDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
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
    private static final RString すべて選択_印刷一次判定_A4_両面 = new RString("1");
    private static final RString 個別設定_印刷特記事項_A3_片面 = new RString("2");
    private static final RString 印刷帳票_審査会開催通知書 = new RString("key0");
    private static final RString 印刷帳票_審査会資料 = new RString("key1");
    private static final RString 印刷帳票_予備判定記入表 = new RString("key2");
    private static final RString 印刷帳票_特記事項 = new RString("0");
    private static final RString 印刷帳票_主治医意見書 = new RString("3");
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
        RString 出力スタイル_印刷サイズddl = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料出力スタイル, 日期, SubGyomuCode.DBE認定支援);
        RString 出力スタイル_両面_片面印刷rad = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷タイプ, 日期, SubGyomuCode.DBE認定支援);
        RString 部数 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料部数_委員, 日期, SubGyomuCode.DBE認定支援);
        div.getPublishingCondition().getRadShutsuryokuStyleZenken().setSelectedKey(出力スタイル_両面_片面印刷rad);
        div.getPublishingCondition().getDdlShutsuryokuStyleZenken().setSelectedKey(出力スタイル_印刷サイズddl);
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getTxtCopyNumForShinsakaiIin1().setValue(new Decimal(部数.toString()));
        RString 印刷帳票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員, 日期, SubGyomuCode.DBE認定支援);
        if (個別設定_印刷特記事項_A3_片面.equals(印刷帳票)) {
            RString 審査会開催通知書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_開催通知書, 日期, SubGyomuCode.DBE認定支援);
            RString 審査会資料 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_審査会資料, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項, 日期, SubGyomuCode.DBE認定支援);
            RString 一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_一次判定結果票, 日期, SubGyomuCode.DBE認定支援);
            RString 特記事項_一次判定結果票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_特記事項_一次判定結果票, 日期,
                    SubGyomuCode.DBE認定支援);
            RString 主治医意見書 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_主治医意見書, 日期, SubGyomuCode.DBE認定支援);
            RString 予備判定記入票 = DbBusinessConfig.get(ConfigNameDBE.介護認定審査会資料印刷帳票_委員_予備判定記入表, 日期, SubGyomuCode.DBE認定支援);
            if (個別設定_印刷特記事項_A3_片面.equals(審査会開催通知書)) {
                印刷帳票chk.add(印刷帳票_審査会開催通知書);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(審査会資料)) {
                印刷帳票chk.add(印刷帳票_審査会資料);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(特記事項)) {
                印刷審査会資料chk.add(印刷帳票_特記事項);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(一次判定結果票)) {
                印刷審査会資料chk.add(すべて選択_印刷一次判定_A4_両面);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(特記事項_一次判定結果票)) {
                印刷審査会資料chk.add(個別設定_印刷特記事項_A3_片面);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(主治医意見書)) {
                印刷審査会資料chk.add(印刷帳票_主治医意見書);
            }
            if (個別設定_印刷特記事項_A3_片面.equals(予備判定記入票)) {
                印刷帳票chk.add(印刷帳票_予備判定記入表);
            }
        }
        if (すべて選択_印刷一次判定_A4_両面.equals(印刷帳票)) {
            印刷帳票chk.add(印刷帳票_審査会開催通知書);
            印刷帳票chk.add(印刷帳票_審査会資料);
            印刷審査会資料chk.add(印刷帳票_特記事項);
            印刷審査会資料chk.add(すべて選択_印刷一次判定_A4_両面);
            印刷審査会資料chk.add(個別設定_印刷特記事項_A3_片面);
            印刷審査会資料chk.add(印刷帳票_主治医意見書);
            印刷帳票chk.add(印刷帳票_予備判定記入表);
        }
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().setSelectedItemsByKey(印刷帳票chk);
        div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                .setSelectedItemsByKey(印刷審査会資料chk);
    }

    /**
     * 印刷審査会資料選択チェックボックスの使用可能・不可能を設定する。
     */
    public void set審査会資料選択chkの設定() {
        if (div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys()
                .contains(印刷帳票_審査会資料)) {
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setReadOnly(false);
        } else {
            div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin().setReadOnly(true);
        }
    }

    /**
     * バッチパラメータの設定について
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
        if (!div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().isEmpty()) {
            if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(すべて選択_印刷一次判定_A4_両面)) {
                batchParameter.setSyuturyokuStyle(すべて選択_印刷一次判定_A4_両面);
            } else if (div.getPublishingCondition().getDdlShutsuryokuStyleZenken().getSelectedKey().equals(個別設定_印刷特記事項_A3_片面)) {
                batchParameter.setSyuturyokuStyle(個別設定_印刷特記事項_A3_片面);
            }
        }
        if (!div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().isEmpty()) {
            if (div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().equals(すべて選択_印刷一次判定_A4_両面)) {
                batchParameter.setInsatuHouhou(すべて選択_印刷一次判定_A4_両面);
            } else if (div.getPublishingCondition().getRadShutsuryokuStyleZenken().getSelectedKey().equals(個別設定_印刷特記事項_A3_片面)) {
                batchParameter.setInsatuHouhou(個別設定_印刷特記事項_A3_片面);
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
        return batchParameter;
    }

    private void setバッチ(DBE526002_JIzenShinsakekkaTorokuSakuseiParameter batchParameter) {
        List<RString> 印刷帳票 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoIin().getSelectedKeys();
        List<RString> 印刷審査会資料 = div.getPublishingCondition().getPublishingConditionForShinsakaiIin().getChkPrintChohyoShinsakaiIin()
                .getSelectedKeys();
        if (印刷帳票.contains(印刷帳票_審査会開催通知書)) {
            batchParameter.setTuutiFlag(new RString("1"));
        } else {
            batchParameter.setTuutiFlag(new RString("0"));
        }
        if (印刷審査会資料.contains(印刷帳票_特記事項)) {
            batchParameter.setTokkiJikouFlag(new RString("1"));
        } else {
            batchParameter.setTokkiJikouFlag(new RString("0"));
        }
        if (印刷審査会資料.contains(すべて選択_印刷一次判定_A4_両面)) {
            batchParameter.setItiHenteiKekkaFlag(new RString("1"));
        } else {
            batchParameter.setItiHenteiKekkaFlag(new RString("0"));
        }
        if (印刷審査会資料.contains(個別設定_印刷特記事項_A3_片面)) {
            batchParameter.setTokkiPlusItiFlag(new RString("1"));
        } else {
            batchParameter.setTokkiPlusItiFlag(new RString("0"));
        }
        if (印刷審査会資料.contains(印刷帳票_主治医意見書)) {
            batchParameter.setIkensyoFlag(new RString("1"));
        } else {
            batchParameter.setIkensyoFlag(new RString("0"));
        }
        if (印刷帳票.contains(印刷帳票_予備判定記入表)) {
            batchParameter.setYobiHenteiFlag(new RString("1"));
        } else {
            batchParameter.setYobiHenteiFlag(new RString("0"));
        }
    }

    private RString dateFormat(FlexibleDate date) {
        if (date == null || date.isEmpty()) {
            return RString.EMPTY;
        }
        return date.wareki().toDateString();
    }
}
