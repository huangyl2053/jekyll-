/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku;

import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoChosaItem;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser07;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser10;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser12;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser17;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser21;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku05;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenKomoku14;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 一次判定データ出力Businessです。
 *
 * @reamsid_L DBE-1610-010 wanghui
 */
public class IchijiHanteizumiDataShutsuryoku {

    private static final RString 認定ｿﾌﾄ99 = new RString("99A");
    private static final RString 認定ｿﾌﾄ2002 = new RString("02A");
    private static final RString 認定ｿﾌﾄ2006 = new RString("06A");
    private static final RString 認定ｿﾌﾄ2009_A = new RString("09A");
    private static final RString 認定ｿﾌﾄ2009_B = new RString("09B");
    private static final RString 回月 = new RString("回 /月");
    private static final RString 日月 = new RString("日 /月");
    private static final RString 住宅改修 = new RString("住宅改修                                           ：");
    private static final RString 介護サービス状況リスト = new RString("(介護サービス状況リスト)");
    private static final RString 訪問介護_ホームヘルプサービス = new RString("訪問介護（ホームヘルプサービス）            ：");
    private static final RString 訪問入浴介護 = new RString("訪問入浴介護                                ：");
    private static final RString 訪問看護 = new RString("訪問看護                                    ：");
    private static final RString 訪問リハビリテーション = new RString("訪問リハビリテーション                      ：");
    private static final RString 居宅療養管理指導 = new RString("居宅療養管理指導                            ：");
    private static final RString 通所介護_デイサービス = new RString("通所介護（デイサービス）                    ：");
    private static final RString 通所リハビリテーション = new RString("通所リハビリテーション                      ：");
    private static final RString 短期入所生活介護 = new RString("短期入所生活介護（ショートステイ）          ：");
    private static final RString 短期入所療養介護 = new RString("短期入所療養介護                            ：");
    private static final RString 特定施設入居者生活介護 = new RString("特定施設入居者生活介護                      ：");
    private static final RString 福祉用具貸与 = new RString("福祉用具貸与                                ：");
    private static final RString 品目 = new RString("品目");
    private static final RString 特定福祉用具販売 = new RString("特定福祉用具販売                            ：");
    private static final RString 夜間対応型訪問介護 = new RString("夜間対応型訪問介護                          ：");
    private static final RString 認知症対応型通所介護 = new RString("認知症対応型通所介護                        ：");
    private static final RString 小規模多機能型住宅介護 = new RString("小規模多機能型住宅介護                      ：");
    private static final RString 認知症対応型共同生活介護 = new RString("認知症対応型共同生活介護（グループホーム）　：");
    private static final RString 地域密着型特定施設入所者生活介護 = new RString("地域密着型特定施設入所者生活介護　          ：");
    private static final RString 地域密着型介護老人福祉施設入所者生活介護 = new RString("地域密着型介護老人福祉施設入所者生活介護    ：");
    private static final RString 定期巡回_随時対応型訪問介護看護 = new RString("定期巡回・随時対応型訪問介護看護　　　　　　：");
    private static final RString 看護小規模多機能型居宅介護 = new RString("看護小規模多機能型居宅介護　　　　　　　　　：");
    private static final RString 予防サービス状況リスト = new RString("(予防サービス状況リスト)");
    private static final RString 介護予防訪問介護 = new RString("介護予防訪問介護（ホームヘルプ）・訪問型サービス   ：");
    private static final RString 介護予防訪問入浴介護 = new RString("介護予防訪問入浴介護                               ：");
    private static final RString 介護予防訪問看護 = new RString("介護予防訪問看護                                   ：");
    private static final RString 介護予防訪問リハビリテーション = new RString("介護予防訪問リハビリテーション                     ：");
    private static final RString 介護予防居宅療養管理指導 = new RString("介護予防居宅療養管理指導                           ：");
    private static final RString 介護予防通所介護 = new RString("介護予防通所介護（デイサービス）・通所型サービス   ：");
    private static final RString 介護予防通所リハビリテーション = new RString("介護予防通所リハビリテーション                     ：");
    private static final RString 介護予防短期入所生活介護 = new RString("介護予防短期入所生活介護（ショートステイ）         ：");
    private static final RString 介護予防短期入所療養介護 = new RString("介護予防短期入所療養介護                           ：");
    private static final RString 介護予防特定施設入居者生活介護 = new RString("介護予防特定施設入居者生活介護                     ：");
    private static final RString 介護予防福祉用具貸与 = new RString("介護予防福祉用具貸与                               ：");
    private static final RString 特定介護予防福祉用具販売 = new RString("特定介護予防福祉用具販売                           ：");
    private static final RString 介護予防小規模多機能型居宅介護 = new RString("介護予防小規模多機能型居宅介護                     ：");
    private static final RString 介護予防認知症対応型共同生活介護 = new RString("介護予防認知症対応型共同生活介護（グループホーム） ：");
    private static final RString 品目_6月間 = new RString("品目/6月間");
    private static final RString 識別コード09B = new RString("09B");
    private static final RString 識別コード06A = new RString("06A");
    private static final RString 識別コード02A = new RString("02A");
    private static final RString 識別コード09A = new RString("09A");
    private static final RString 識別コード99A = new RString("99A");
    private static final RString 印刷する = new RString("1");
    private static final RString 印刷しない = new RString("2");
    private static final RString 差分のみ印刷 = new RString("3");
    private static final int 連番1 = 1;
    private static final int 連番2 = 2;
    private static final int 連番3 = 3;
    private static final int 連番4 = 4;
    private static final int 連番5 = 5;
    private static final int 連番6 = 6;
    private static final int 連番7 = 7;
    private static final int 連番8 = 8;
    private static final int 連番9 = 9;
    private static final int 連番10 = 10;
    private static final int 連番11 = 11;
    private static final int 連番12 = 12;
    private static final int 連番13 = 13;
    private static final int 連番14 = 14;
    private static final int 連番15 = 15;
    private static final int 連番16 = 16;
    private static final int 連番17 = 17;
    private static final int 連番18 = 18;
    private static final int 連番19 = 19;
    private static final int 連番20 = 20;
    private static final int 連番21 = 21;
    private static final int 連番31 = 31;
    private static final int 連番34 = 34;
    private static final int 連番35 = 35;
    private static final int 連番36 = 36;
    private static final int 連番37 = 37;
    private static final int 連番38 = 38;
    private static final int 連番39 = 39;
    private static final int 連番40 = 40;
    private static final int 連番41 = 41;
    private static final int 連番42 = 42;
    private static final int 連番43 = 43;
    private static final int 連番44 = 44;
    private static final int 連番45 = 45;
    private static final int 連番46 = 46;
    private static final int 連番47 = 47;
    private static final int 連番48 = 48;
    private static final int 連番49 = 49;
    private static final int 連番50 = 50;
    private static final int 連番51 = 51;
    private static final int 連番52 = 52;
    private static final int 連番53 = 53;
    private static final int 連番54 = 54;
    private static final int 連番55 = 55;
    private static final int 連番56 = 56;
    private static final int 連番57 = 57;
    private static final int 連番58 = 58;
    private static final int 連番59 = 59;
    private static final int 連番60 = 60;
    private static final int 連番61 = 61;
    private static final int 連番62 = 62;
    private static final int 連番63 = 63;
    private static final int 連番64 = 64;
    private static final int 連番66 = 66;
    private static final int 連番67 = 67;
    private static final int 連番68 = 67;
    private static final int 連番69 = 69;

    /**
     * 調査員一覧のパラメタ編集です。
     *
     * @param 区分コード RString
     * @param 一次判定結果コード RString
     * @return RString
     */
    public RString set要介護状態区分コード(RString 区分コード, RString 一次判定結果コード) {
        if (認定ｿﾌﾄ99.equals(区分コード)) {
            return 要介護認定一次判定結果コード99の名称(一次判定結果コード);
        } else if (認定ｿﾌﾄ2002.equals(区分コード)) {
            return 要介護認定一次判定結果コード02の名称(一次判定結果コード);
        } else if (認定ｿﾌﾄ2006.equals(区分コード)) {
            return 要介護認定一次判定結果コード06の名称(一次判定結果コード);
        } else if (認定ｿﾌﾄ2009_A.equals(区分コード)
                || 認定ｿﾌﾄ2009_B.equals(区分コード)) {
            return 要介護認定一次判定結果コード09の名称(一次判定結果コード);
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード99の名称(RString 一次判定結果コード) {
        if (IchijiHanteiKekkaCode99.みなし要支援.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.みなし要支援.get名称();
        } else if (IchijiHanteiKekkaCode99.みなし非該当.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.みなし非該当.get名称();
        } else if (IchijiHanteiKekkaCode99.経過的要介護.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.経過的要介護.get名称();
        } else if (IchijiHanteiKekkaCode99.要介護1.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.要介護1.get名称();
        } else if (IchijiHanteiKekkaCode99.要介護2.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.要介護2.get名称();
        } else if (IchijiHanteiKekkaCode99.要介護3.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.要介護3.get名称();
        } else if (IchijiHanteiKekkaCode99.要介護4.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.要介護4.get名称();
        } else if (IchijiHanteiKekkaCode99.要介護5.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.要介護5.get名称();
        } else if (IchijiHanteiKekkaCode99.非該当.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode99.非該当.get名称();
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード02の名称(RString 一次判定結果コード) {
        if (IchijiHanteiKekkaCode02.要介護1.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要介護1.get名称();
        } else if (IchijiHanteiKekkaCode02.要介護2.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要介護2.get名称();
        } else if (IchijiHanteiKekkaCode02.要介護3.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要介護3.get名称();
        } else if (IchijiHanteiKekkaCode02.要介護4.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要介護4.get名称();
        } else if (IchijiHanteiKekkaCode02.要介護5.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要介護5.get名称();
        } else if (IchijiHanteiKekkaCode02.要支援.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.要支援.get名称();
        } else if (IchijiHanteiKekkaCode02.非該当.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode02.非該当.get名称();
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード06の名称(RString 一次判定結果コード) {
        if (IchijiHanteiKekkaCode06.要介護1.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.要介護1.get名称();
        } else if (IchijiHanteiKekkaCode06.要介護2.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.要介護2.get名称();
        } else if (IchijiHanteiKekkaCode06.要介護3.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.要介護3.get名称();
        } else if (IchijiHanteiKekkaCode06.要介護4.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.要介護4.get名称();
        } else if (IchijiHanteiKekkaCode06.要介護5.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.要介護5.get名称();
        } else if (IchijiHanteiKekkaCode06.経過的要介護.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.経過的要介護.get名称();
        } else if (IchijiHanteiKekkaCode06.非該当.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode06.非該当.get名称();
        }
        return RString.EMPTY;
    }

    private RString 要介護認定一次判定結果コード09の名称(RString 一次判定結果コード) {
        if (IchijiHanteiKekkaCode09.要介護1.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要介護1.get名称();
        } else if (IchijiHanteiKekkaCode09.要介護2.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要介護2.get名称();
        } else if (IchijiHanteiKekkaCode09.要介護3.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要介護3.get名称();
        } else if (IchijiHanteiKekkaCode09.要介護4.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要介護4.get名称();
        } else if (IchijiHanteiKekkaCode09.要介護5.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要介護5.get名称();
        } else if (IchijiHanteiKekkaCode09.非該当.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.非該当.get名称();
        } else if (IchijiHanteiKekkaCode09.要支援2.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.要支援2.get名称();
        }
        return RString.EMPTY;
    }

    /**
     * サービス状況を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 認定調査票概況調査リスト List<NinteichosahyoServiceJokyo>
     * @param 認定調査票フラグリスト List<NinteichosahyoServiceJokyoFlag>
     * @return サービス状況
     */
    public RString setサービス状況(IchijiHanteizumiDataBusiness business, List<NinteichosahyoServiceJokyo> 認定調査票概況調査リスト,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票フラグリスト) {
        RStringBuilder builder = new RStringBuilder();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード))) {
            builder.append(予防サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 0));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問入浴介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番1));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問看護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番2));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番3));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防居宅療養管理指導);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番4));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番5));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番6));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番7));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所療養介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番8));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防特定施設入居者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番9));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防福祉用具貸与);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番10));
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番11));
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (認定調査票フラグリスト != null && !認定調査票フラグリスト.isEmpty() && 認定調査票フラグリスト.get(0).isサービスの状況フラグ()) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番13));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防小規模多機能型居宅介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番14));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防認知症対応型共同生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番15));
            builder.append(日月);
        }
        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード))) {
            builder.append(予防サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 0));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問入浴介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番1));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問看護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番2));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番3));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防居宅療養管理指導);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番4));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番5));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番6));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番8));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所療養介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番9));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防特定施設入居者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番11));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防福祉用具貸与);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番7));
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(RString.EMPTY);
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (認定調査票フラグリスト != null && !認定調査票フラグリスト.isEmpty() && 認定調査票フラグリスト.get(0).isサービスの状況フラグ()) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防小規模多機能型居宅介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防認知症対応型共同生活介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
        }
        builder.append(getサービス状況(business, 認定調査票概況調査リスト, 認定調査票フラグリスト));
        builder.append(getサービス状況01(business, 認定調査票概況調査リスト, 認定調査票フラグリスト));
        return builder.toRString();
    }

    private static RString getサービス状況(IchijiHanteizumiDataBusiness business, List<NinteichosahyoServiceJokyo> 認定調査票概況調査リスト,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票フラグリスト) {
        RStringBuilder builder = new RStringBuilder();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (!ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && !ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())) {
            return new RString("                                      (なし)");
        }
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード))) {
            builder.append(介護サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(訪問介護_ホームヘルプサービス);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 0));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問入浴介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番1));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問看護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番2));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番3));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(居宅療養管理指導);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番4));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所介護_デイサービス);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番5));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番6));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(短期入所生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番7));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(短期入所療養介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番8));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(特定施設入居者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番9));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(福祉用具貸与);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番10));
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定福祉用具販売);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番11));
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (認定調査票フラグリスト != null && !認定調査票フラグリスト.isEmpty() && 認定調査票フラグリスト.get(0).isサービスの状況フラグ()) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(夜間対応型訪問介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番12));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型通所介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番13));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(小規模多機能型住宅介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番14));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型共同生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番15));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型特定施設入所者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番16));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型介護老人福祉施設入所者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番17));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(定期巡回_随時対応型訪問介護看護);
            if (識別コード09B.equals(厚労省IF識別コード)) {
                builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番18));
                builder.append(回月);
                builder.append(System.lineSeparator());
                builder.append(看護小規模多機能型居宅介護);
                builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番19));
                builder.append(日月);
            }
            if (識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                builder.append(RString.EMPTY);
                builder.append(回月);
                builder.append(System.lineSeparator());
                builder.append(看護小規模多機能型居宅介護);
                builder.append(RString.EMPTY);
                builder.append(日月);
            }
        }
        return builder.toRString();
    }

    private static RString getサービス状況01(IchijiHanteizumiDataBusiness business, List<NinteichosahyoServiceJokyo> 認定調査票概況調査リスト,
            List<NinteichosahyoServiceJokyoFlag> 認定調査票フラグリスト) {
        RStringBuilder builder = new RStringBuilder();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード))) {
            builder.append(介護サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(訪問介護_ホームヘルプサービス);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 0));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問入浴介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番1));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問看護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番2));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番3));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(居宅療養管理指導);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番4));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所介護_デイサービス);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番5));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所リハビリテーション);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番6));
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(短期入所生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番8));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(短期入所療養介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番9));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(特定施設入居者生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番11));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(福祉用具貸与);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番7));
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定福祉用具販売);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番12));
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (認定調査票フラグリスト != null && !認定調査票フラグリスト.isEmpty() && 認定調査票フラグリスト.get(0).isサービスの状況フラグ()) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(夜間対応型訪問介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型通所介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(小規模多機能型住宅介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型共同生活介護);
            builder.append(getサービス連番の状況(認定調査票概況調査リスト, 連番10));
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型特定施設入所者生活介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型介護老人福祉施設入所者生活介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(定期巡回_随時対応型訪問介護看護);
            builder.append(RString.EMPTY);
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(看護小規模多機能型居宅介護);
            builder.append(RString.EMPTY);
            builder.append(日月);
        }
        return builder.toRString();
    }

    /**
     * 精神_行動障害を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 認定調査票調査項目リスト List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害4リスト(IchijiHanteizumiDataBusiness business,
            List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 精神機能(business, 認定調査票調査項目リスト, 前回調査項目);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
            精神_行動障害4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード)
                    || 識別コード09A.equals(厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番41));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番42));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番43));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番44));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番45));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番46));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番47));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番48));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番49));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番50));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番51));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番52));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番53));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番54));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番55));
            }
            if (識別コード06A.equals(厚労省IF識別コード)
                    || 識別コード02A.equals(厚労省IF識別コード)
                    || 識別コード99A.equals(厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番48));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番49));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番51));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番52));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番54));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番55));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番56));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番58));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番60));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番61));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番63));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番66));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番54));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番55));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番57));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番58));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番60));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番61));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番62));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番64));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番66));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番67));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番69));
                精神_行動障害4リスト.add(get名称16(認定調査票調査項目リスト, 連番42));
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
                精神_行動障害4リスト.add(RString.EMPTY);
            }
        }
        return 精神_行動障害4リスト;
    }

    /**
     * 精神_行動障害を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害3リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 精神_行動障害3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番41));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番43));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番46));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番47));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番50));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番53));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番48));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番49));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番51));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番52));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番56));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番63));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番66));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番54));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番55));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番62));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番64));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番66));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番67));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番69));
            精神_行動障害3リスト.add(get状況結果(調査項目, 前回調査項目, 連番42));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        return 精神_行動障害3リスト;
    }

    /**
     * 精神_行動障害を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 精神_行動障害2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番41));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番43));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番46));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番47));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番50));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番53));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番48));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番49));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番51));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番52));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番56));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番63));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番54));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番55));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番62));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番64));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番66));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番67));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番69));
            精神_行動障害2リスト.add(get調査連番(調査項目, 前回調査項目, 連番42));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        return 精神_行動障害2リスト;
    }

    /**
     * 精神_行動障害を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目) {
        List<RString> 精神_行動障害1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード)
                || 識別コード09A.equals(厚労省IF識別コード)) {
            精神_行動障害1リスト.add(get名称16(調査項目, 連番41));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番42));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番43));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番44));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番45));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番46));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番47));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番48));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番49));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番50));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番51));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番52));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番53));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番54));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番55));
        }
        if (識別コード06A.equals(厚労省IF識別コード)
                || 識別コード02A.equals(厚労省IF識別コード)
                || 識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害1リスト.add(get名称16(調査項目, 連番48));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番49));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番51));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番52));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番54));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番55));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番56));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番58));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番60));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番61));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番63));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番66));
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            精神_行動障害1リスト.add(get名称16(調査項目, 連番54));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番55));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番57));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番58));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番60));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番61));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番62));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番64));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番66));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番67));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番69));
            精神_行動障害1リスト.add(get名称16(調査項目, 連番42));
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
        }
        return 精神_行動障害1リスト;
    }

    private static RString get名称16(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser16.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private RString get調査連番(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 状況改善 = RString.EMPTY;
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査)) {
            return 状況改善;
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) < Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▽");
        }
        if ((RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) > Integer.parseInt(前回調査.toString())) {
            状況改善 = new RString("▲");
        }
        return 状況改善;
    }

    private RString get状況結果(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get調査項目())) {
            今回調査 = 調査項目.get(連番).get調査項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get調査項目())) {
            前回調査 = 前回調査項目.get(連番).get調査項目();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査) || RString.isNullOrEmpty(今回調査)) {
            return RString.EMPTY;
        }
        return new RString(abs((Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString())));
    }

    private List<RString> 精神機能(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            return set精神機能差分09B(調査項目, dbt5211Entity);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            return set精神機能差分99A(調査項目, dbt5211Entity);
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            return set精神機能差分02A(調査項目, dbt5211Entity);
        }
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分09B(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番41).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番41));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番42));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番43).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番43));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番44));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番45));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番46).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番46));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番47).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番47));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番48));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番49));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番50).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番50));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番51));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番52));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番53).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番53));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分99A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番57).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番57));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番58).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番58));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番60).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番60));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番61).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番61));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番62).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番62));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番64).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番64));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番66).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番66));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番67).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番67));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番69).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番69));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番42).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番42));
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分02A(List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番48).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番48));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番49).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番49));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番51).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番51));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番52).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番52));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番54).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番54));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番55).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番55));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番56));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番58).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番58));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番60).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番60));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番61).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番61));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番63).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番63));
        精神_行動障害4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番66).isEmpty() ? RString.EMPTY : get名称16(dbt5211Entity, 連番66));
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        return 精神_行動障害4リスト;
    }

    private RString 機能差分結果(List<NinteichosahyoChosaItem> 意見書項目,
            List<NinteichosahyoChosaItem> 前回意見書項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get調査項目())) {
            今回調査 = 意見書項目.get(連番).get調査項目();
        }
        if (連番 < 前回意見書項目.size() && !RString.isNullOrEmpty(前回意見書項目.get(連番).get調査項目())) {
            RString 前回調査 = 前回意見書項目.get(連番).get調査項目();
            if (!今回調査.equals(前回調査)) {
                return 前回調査;
            }
        }
        return RString.EMPTY;
    }

    /**
     * 身体機能起居動作1リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 認定調査票調査項目リスト List<NinteichosahyoChosaItem>
     * @return 身体機能起居動作1リスト
     */
    public List<RString> set身体機能_起居動作1リスト(IchijiHanteizumiDataBusiness business,
            List<NinteichosahyoChosaItem> 認定調査票調査項目リスト) {
        List<RString> 身体機能_起居動作1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 0));
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番1));
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番2));
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番3));
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番4));
        身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番6));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番7));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番8));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番9));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番10));
            身体機能_起居動作1リスト.add(get名称03(認定調査票調査項目リスト, 連番11));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番12));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番13));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番14));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番15));
            身体機能_起居動作1リスト.add(get名称06(認定調査票調査項目リスト, 連番16));
            身体機能_起居動作1リスト.add(get名称07(認定調査票調査項目リスト, 連番17));
            身体機能_起居動作1リスト.add(get名称08(認定調査票調査項目リスト, 連番18));
            身体機能_起居動作1リスト.add(get名称09(認定調査票調査項目リスト, 連番19));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番7));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番8));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番10));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番11));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番12));
            身体機能_起居動作1リスト.add(get名称03(認定調査票調査項目リスト, 連番13));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番14));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番15));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番18));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番19));
            身体機能_起居動作1リスト.add(get名称21(認定調査票調査項目リスト, 連番20));
            身体機能_起居動作1リスト.add(get名称22(認定調査票調査項目リスト, 連番31));
            身体機能_起居動作1リスト.add(get名称08(認定調査票調査項目リスト, 連番38));
            身体機能_起居動作1リスト.add(get名称09(認定調査票調査項目リスト, 連番39));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番7));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番8));
            身体機能_起居動作1リスト.add(get名称01(認定調査票調査項目リスト, 連番10));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番11));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番12));
            身体機能_起居動作1リスト.add(get名称03(認定調査票調査項目リスト, 連番13));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番15));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番16));
            身体機能_起居動作1リスト.add(get名称02(認定調査票調査項目リスト, 連番18));
            身体機能_起居動作1リスト.add(get名称04(認定調査票調査項目リスト, 連番19));
            身体機能_起居動作1リスト.add(get名称21(認定調査票調査項目リスト, 連番21));
            身体機能_起居動作1リスト.add(get名称22(認定調査票調査項目リスト, 連番34));
            身体機能_起居動作1リスト.add(get名称08(認定調査票調査項目リスト, 連番44));
            身体機能_起居動作1リスト.add(get名称09(認定調査票調査項目リスト, 連番45));
        }
        return 身体機能_起居動作1リスト;
    }

    /**
     * 身体機能起居動作2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem> 調査項目
     * @param 前回調査項目 List<NinteichosahyoChosaItem> 前回調査項目
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set身体機能_起居動作2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 身体機能_起居動作2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 0));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番6));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番9));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番17));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番20));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番31));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番38));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番39));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番21));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番44));
            身体機能_起居動作2リスト.add(get調査連番(調査項目, 前回調査項目, 連番45));
        }
        return 身体機能_起居動作2リスト;
    }

    /**
     * 身体機能起居動作3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set身体機能_起居動作3リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 身体機能_起居動作3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 0));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番1));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番2));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番3));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番4));
        身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番6));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番9));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番17));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番14));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番20));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番31));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番38));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番39));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番7));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番8));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番10));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番11));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番12));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番13));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番15));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番16));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番18));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番19));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番21));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番44));
            身体機能_起居動作3リスト.add(get状況結果(調査項目, 前回調査項目, 連番45));
        }
        return 身体機能_起居動作3リスト;
    }

    /**
     * 身体機能_起居動作4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 身体機能_起居動作4リスト
     */
    public List<RString> set身体機能_起居動作4リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        RString 結果印刷有無 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate());
        if (差分のみ印刷.equals(結果印刷有無)) {
            return 身体機能(business, 調査項目, 前回調査項目);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
            身体機能_起居動作4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            身体機能_起居動作4リスト.add(get名称01(調査項目, 0));
            身体機能_起居動作4リスト.add(get名称01(調査項目, 連番1));
            身体機能_起居動作4リスト.add(get名称01(調査項目, 連番2));
            身体機能_起居動作4リスト.add(get名称01(調査項目, 連番3));
            身体機能_起居動作4リスト.add(get名称01(調査項目, 連番4));
            身体機能_起居動作4リスト.add(get名称01(調査項目, 連番5));
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番6));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番7));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番8));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番9));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番10));
                身体機能_起居動作4リスト.add(get名称03(調査項目, 連番11));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番12));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番13));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番14));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番15));
                身体機能_起居動作4リスト.add(get名称06(調査項目, 連番16));
                身体機能_起居動作4リスト.add(get名称07(調査項目, 連番17));
                身体機能_起居動作4リスト.add(get名称08(調査項目, 連番18));
                身体機能_起居動作4リスト.add(get名称09(調査項目, 連番19));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番7));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番8));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番10));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番11));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番12));
                身体機能_起居動作4リスト.add(get名称03(調査項目, 連番13));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番14));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番15));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番18));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番19));
                身体機能_起居動作4リスト.add(get名称21(調査項目, 連番20));
                身体機能_起居動作4リスト.add(get名称22(調査項目, 連番31));
                身体機能_起居動作4リスト.add(get名称08(調査項目, 連番38));
                身体機能_起居動作4リスト.add(get名称09(調査項目, 連番39));
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番7));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番8));
                身体機能_起居動作4リスト.add(get名称01(調査項目, 連番10));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番11));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番12));
                身体機能_起居動作4リスト.add(get名称03(調査項目, 連番13));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番15));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番16));
                身体機能_起居動作4リスト.add(get名称02(調査項目, 連番18));
                身体機能_起居動作4リスト.add(get名称04(調査項目, 連番19));
                身体機能_起居動作4リスト.add(get名称21(調査項目, 連番21));
                身体機能_起居動作4リスト.add(get名称22(調査項目, 連番34));
                身体機能_起居動作4リスト.add(get名称08(調査項目, 連番44));
                身体機能_起居動作4リスト.add(get名称09(調査項目, 連番45));
            }
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> 身体機能(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 0).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 0));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番1).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番1));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番2).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番2));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番3).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番3));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番4).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番4));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番5).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番5));
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            身体機能_起居動作4リスト.addAll(get身体機能09B(調査項目, dbt5211Entity));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード06A.equals(厚労省IF識別コード)) {
            身体機能_起居動作4リスト.addAll(get身体機能02A(調査項目, dbt5211Entity));
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            身体機能_起居動作4リスト.addAll(get身体機能99A(調査項目, dbt5211Entity));
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> get身体機能09B(List<NinteichosahyoChosaItem> 調査項目, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番6).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番6));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番9).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番9));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番10));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番11));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番12));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番13));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番14).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番14));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番15));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称06(dbt5211Entity, 連番16));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番17).isEmpty() ? RString.EMPTY : get名称07(dbt5211Entity, 連番17));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番18));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番19));
        return 身体機能_起居動作4リスト;
    }

    private List<RString> get身体機能02A(List<NinteichosahyoChosaItem> 調査項目, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番10));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番11));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番12));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番13));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番14).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番14));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番15));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番18));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番19));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番20).isEmpty() ? RString.EMPTY : get名称21(dbt5211Entity, 連番20));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番31).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番31));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番38).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番38));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番39).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番39));
        return 身体機能_起居動作4リスト;
    }

    private List<RString> get身体機能99A(List<NinteichosahyoChosaItem> 調査項目, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番7).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番7));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番8).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番8));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番10).isEmpty() ? RString.EMPTY : get名称01(dbt5211Entity, 連番10));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番11).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番11));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番12).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番12));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番13).isEmpty() ? RString.EMPTY : get名称03(dbt5211Entity, 連番13));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番15).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番15));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番16).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番16));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番18).isEmpty() ? RString.EMPTY : get名称02(dbt5211Entity, 連番18));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番19).isEmpty() ? RString.EMPTY : get名称04(dbt5211Entity, 連番19));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番21).isEmpty() ? RString.EMPTY : get名称21(dbt5211Entity, 連番21));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番34));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番44).isEmpty() ? RString.EMPTY : get名称08(dbt5211Entity, 連番44));
        身体機能_起居動作4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番45).isEmpty() ? RString.EMPTY : get名称09(dbt5211Entity, 連番45));
        return 身体機能_起居動作4リスト;
    }

    /**
     * 社会生活への適応4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param dbt5211Entity List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 社会生活への適応4リスト
     */
    public List<RString> set社会生活への適応4リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> dbt5211Entity,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 社会生活機能(dbt5211Entity, 前回調査項目, business);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番56));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番57));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番58));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番59));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番60));
                社会生活への適応4リスト.add(get名称12(dbt5211Entity, 連番61));
            }
            if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番34));
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番35));
                社会生活への適応4リスト.add(get名称17(dbt5211Entity, 連番37));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
            if (識別コード99A.equals(厚労省IF識別コード)) {
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番40));
                社会生活への適応4リスト.add(get名称22(dbt5211Entity, 連番41));
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
                社会生活への適応4リスト.add(RString.EMPTY);
            }
        }
        return 社会生活への適応4リスト;
    }

    private List<RString> 社会生活機能(List<NinteichosahyoChosaItem> 調査項目, List<NinteichosahyoChosaItem> dbt5211Entity,
            IchijiHanteizumiDataBusiness business) {
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        List<RString> 社会生活への適応4リスト = new ArrayList<>();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番56));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番57));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番58));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番59));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番60));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番56).isEmpty() ? RString.EMPTY : get名称12(dbt5211Entity, 連番61));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番34).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番34));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番35).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番35));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番37).isEmpty() ? RString.EMPTY : get名称17(dbt5211Entity, 連番37));
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番40).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番40));
            社会生活への適応4リスト.add(機能差分結果(調査項目, dbt5211Entity, 連番41).isEmpty() ? RString.EMPTY : get名称22(dbt5211Entity, 連番41));
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
            社会生活への適応4リスト.add(RString.EMPTY);
        }
        return 社会生活への適応4リスト;
    }

    /**
     * 社会生活への適応3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 社会生活への適応3リスト
     */
    public List<RString> set社会生活への適応3リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 社会生活への適応3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番56));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番57));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番58));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番59));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番60));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番61));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番34));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番35));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番37));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番40));
            社会生活への適応3リスト.add(get状況結果(調査項目, 前回調査項目, 連番41));
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
            社会生活への適応3リスト.add(RString.EMPTY);
        }
        return 社会生活への適応3リスト;
    }

    /**
     * 社会生活への適応2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 調査項目 List<NinteichosahyoChosaItem>
     * @param 前回調査項目 List<NinteichosahyoChosaItem>
     * @return 社会生活への適応2リスト
     */
    public List<RString> set社会生活への適応2リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> 調査項目,
            List<NinteichosahyoChosaItem> 前回調査項目) {
        List<RString> 社会生活への適応2リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番56));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番57));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番58));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番59));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番60));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番61));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番34));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番35));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番36));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番37));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番40));
            社会生活への適応2リスト.add(get調査連番(調査項目, 前回調査項目, 連番41));
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
            社会生活への適応2リスト.add(RString.EMPTY);
        }
        return 社会生活への適応2リスト;
    }

    /**
     * 社会生活への適応1リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param dbt5211Entity List<NinteichosahyoChosaItem>
     * @return 社会生活への適応1リスト
     */
    public List<RString> set社会生活への適応1リスト(IchijiHanteizumiDataBusiness business, List<NinteichosahyoChosaItem> dbt5211Entity) {
        List<RString> 社会生活への適応1リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称12(dbt5211Entity, 連番56));
            社会生活への適応1リスト.add(get名称12(dbt5211Entity, 連番57));
            社会生活への適応1リスト.add(get名称17(dbt5211Entity, 連番58));
            社会生活への適応1リスト.add(get名称16(dbt5211Entity, 連番59));
            社会生活への適応1リスト.add(get名称10(dbt5211Entity, 連番60));
            社会生活への適応1リスト.add(get名称10(dbt5211Entity, 連番61));
        }
        if (識別コード06A.equals(厚労省IF識別コード) || 識別コード02A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番34));
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番35));
            社会生活への適応1リスト.add(get名称17(dbt5211Entity, 連番37));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(厚労省IF識別コード)) {
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番40));
            社会生活への適応1リスト.add(get名称22(dbt5211Entity, 連番41));
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
            社会生活への適応1リスト.add(RString.EMPTY);
        }
        return 社会生活への適応1リスト;
    }

    /**
     * 主治医意見書項目3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 意見書項目 List<ShujiiIkenshoIkenItem>
     * @param 前回意見書項目 List<ShujiiIkenshoIkenItem>
     * @return 社会生活への適応1リスト
     */
    public List<RString> set主治医意見書項目3リスト(IchijiHanteizumiDataBusiness business, List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目) {
        List<RString> 主治医意見書項目3リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番13));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番68));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番14));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番15));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番16));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番17));
            主治医意見書項目3リスト.add(get意見書状況結果(意見書項目, 前回意見書項目, 連番18));
        }
        return 主治医意見書項目3リスト;
    }

    private static RString get意見書状況結果(List<ShujiiIkenshoIkenItem> 調査項目,
            List<ShujiiIkenshoIkenItem> 前回調査項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        RString 前回調査 = RString.EMPTY;
        if (連番 < 調査項目.size() && !RString.isNullOrEmpty(調査項目.get(連番).get意見項目())) {
            今回調査 = 調査項目.get(連番).get意見項目();
        }
        if (連番 < 前回調査項目.size() && !RString.isNullOrEmpty(前回調査項目.get(連番).get意見項目())) {
            前回調査 = 前回調査項目.get(連番).get意見項目();
        }
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    /**
     * 主治医意見書項目3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @param 意見書項目 List<ShujiiIkenshoIkenItem>
     * @param dbt5304Entity ist<ShujiiIkenshoIkenItem>
     * @return 社会生活への適応1リスト
     */
    public List<RString> set主治医意見書項目4リスト(IchijiHanteizumiDataBusiness business, List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> dbt5304Entity) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 主治医差分(意見書項目, dbt5304Entity, business);
        }
        if (印刷しない.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
            主治医意見書項目4リスト.add(RString.EMPTY);
        }
        if (印刷する.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                    || 識別コード06A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番13));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番68));
            }
            if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
                主治医意見書項目4リスト.add(get意見書名称03(dbt5304Entity, 連番14));
                主治医意見書項目4リスト.add(get意見書名称04(dbt5304Entity, 連番15));
                主治医意見書項目4リスト.add(get意見書名称05(dbt5304Entity, 連番16));
                主治医意見書項目4リスト.add(get意見書名称06(dbt5304Entity, 連番17));
                主治医意見書項目4リスト.add(get意見書名称14(dbt5304Entity, 連番18));
            }
        }
        return 主治医意見書項目4リスト;
    }

    private List<RString> 主治医差分(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> dbt5304Entity, IchijiHanteizumiDataBusiness business) {
        List<RString> 主治医意見書項目4リスト = new ArrayList<>();
        RString 厚労省IF識別コード = business.get一次判定結果情報().get厚労省IF識別コード();
        if (識別コード09B.equals(厚労省IF識別コード) || 識別コード09A.equals(厚労省IF識別コード)
                || 識別コード06A.equals(厚労省IF識別コード)) {
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番13).isEmpty() ? RString.EMPTY : get意見書名称03(dbt5304Entity, 連番13));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16).isEmpty() ? RString.EMPTY : get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番68).isEmpty() ? RString.EMPTY : get意見書名称14(dbt5304Entity, 連番68));
        }
        if (識別コード02A.equals(厚労省IF識別コード) || 識別コード99A.equals(厚労省IF識別コード)) {
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番14).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番14));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番15).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番15));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番16).isEmpty() ? RString.EMPTY : get意見書名称06(dbt5304Entity, 連番16));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番17).isEmpty() ? RString.EMPTY : get意見書名称04(dbt5304Entity, 連番17));
            主治医意見書項目4リスト.add(差分結果(意見書項目, dbt5304Entity, 連番18).isEmpty() ? RString.EMPTY : get意見書名称05(dbt5304Entity, 連番18));
        }
        return 主治医意見書項目4リスト;
    }

    private static RString get名称04(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser04.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称22(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser22.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称12(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser12.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称17(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser17.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称03(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser03.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称02(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser02.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称01(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser01.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称10(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser10.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称21(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser21.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称09(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser09.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称08(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser08.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称07(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser07.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get名称06(List<NinteichosahyoChosaItem> 認定調査票調査項目リスト, int 連番) {
        if (連番 < 認定調査票調査項目リスト.size()) {
            if (RString.isNullOrEmpty(認定調査票調査項目リスト.get(連番).get調査項目())) {
                return RString.EMPTY;
            }
            return ChosaAnser06.toValue(認定調査票調査項目リスト.get(連番).get調査項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString getサービス連番の状況(List<NinteichosahyoServiceJokyo> dbt5207Entity, int 連番) {
        if (連番 < dbt5207Entity.size()) {
            return new RString(dbt5207Entity.get(連番).getサービスの状況());
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称03(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku03.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称14(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku14.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称06(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku06.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称05(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku05.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString get意見書名称04(List<ShujiiIkenshoIkenItem> dbt5304Entity, int 連番) {
        if (連番 < dbt5304Entity.size()) {
            if (RString.isNullOrEmpty(dbt5304Entity.get(連番).get意見項目())) {
                return RString.EMPTY;
            }
            return IkenKomoku04.toValue(dbt5304Entity.get(連番).get意見項目()).get名称();
        }
        return RString.EMPTY;
    }

    private static RString 差分結果(List<ShujiiIkenshoIkenItem> 意見書項目,
            List<ShujiiIkenshoIkenItem> 前回意見書項目, int 連番) {
        RString 今回調査 = RString.EMPTY;
        if (連番 < 意見書項目.size() && !RString.isNullOrEmpty(意見書項目.get(連番).get意見項目())) {
            今回調査 = 意見書項目.get(連番).get意見項目();
        }
        if (連番 < 前回意見書項目.size() && !RString.isNullOrEmpty(前回意見書項目.get(連番).get意見項目())) {
            RString 前回調査 = 前回意見書項目.get(連番).get意見項目();
            if (!今回調査.equals(前回調査)) {
                return 前回調査;
            }
        }
        return RString.EMPTY;
    }
}
