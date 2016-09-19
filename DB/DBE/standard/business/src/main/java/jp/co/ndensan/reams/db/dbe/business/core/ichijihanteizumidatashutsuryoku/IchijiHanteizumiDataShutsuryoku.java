/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ichijihanteizumidatashutsuryoku;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser01;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser03;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser04;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser08;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser16;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ChosaAnser22;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
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
    private static final RString 介護予防認知症対応型通所介護 = new RString("介護予防認知症対応型通所介護                     ：");
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
        } else if (IchijiHanteiKekkaCode09.送付済.getコード().equals(一次判定結果コード)) {
            return IchijiHanteiKekkaCode09.送付済.get名称();
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
     * @return サービス状況
     */
    public RString setサービス状況(IchijiHanteizumiDataBusiness business) {
        RStringBuilder builder = new RStringBuilder();
        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード()) || 識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード()))) {
            builder.append(予防サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問介護);
            builder.append(business.get一次判定結果情報().get訪問介護ホームヘルプ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問入浴介護);
            builder.append(business.get一次判定結果情報().get訪問入浴介護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問看護);
            builder.append(business.get一次判定結果情報().get訪問看護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問リハビリテーション);
            builder.append(business.get一次判定結果情報().get訪問リハビリテーション());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防居宅療養管理指導);
            builder.append(business.get一次判定結果情報().get居宅療養管理指導());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所介護);
            builder.append(business.get一次判定結果情報().get通所介護デイサービス());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所リハビリテーション);
            builder.append(business.get一次判定結果情報().get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝﾃﾞｲｹｱ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所生活介護);
            builder.append(business.get一次判定結果情報().get短期入所生活介護ショートステイ());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所療養介護);
            builder.append(business.get一次判定結果情報().get短期入所療養介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防特定施設入居者生活介護);
            builder.append(business.get一次判定結果情報().get特定施設入居者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防福祉用具貸与);
            builder.append(business.get一次判定結果情報().get福祉用具貸与());
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(business.get一次判定結果情報().get特定福祉用具販売());
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (business.get一次判定結果情報().get住宅改修() != null) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(介護予防認知症対応型通所介護);
            builder.append(business.get一次判定結果情報().get認知症対応型通所介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防小規模多機能型居宅介護);
            builder.append(business.get一次判定結果情報().get小規模多機能型居宅介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防認知症対応型共同生活介護);
            builder.append(business.get一次判定結果情報().get認知症対応型共同生活介護グループホーム());
            builder.append(日月);
        }
        if (ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード()))) {
            builder.append(予防サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問介護);
            builder.append(business.get一次判定結果情報().get訪問介護ホームヘルプ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問入浴介護);
            builder.append(business.get一次判定結果情報().get訪問入浴介護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問看護);
            builder.append(business.get一次判定結果情報().get訪問看護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防訪問リハビリテーション);
            builder.append(business.get一次判定結果情報().get訪問リハビリテーション());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防居宅療養管理指導);
            builder.append(business.get一次判定結果情報().get居宅療養管理指導());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所介護);
            builder.append(business.get一次判定結果情報().get通所介護デイサービス());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防通所リハビリテーション);
            builder.append(business.get一次判定結果情報().get通所介護ﾃﾞｲｻｰﾋﾞｽ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所生活介護);
            builder.append(business.get一次判定結果情報().get短期入所生活介護ショートステイ());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防短期入所療養介護);
            builder.append(business.get一次判定結果情報().get短期入所療養介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防特定施設入居者生活介護);
            builder.append(business.get一次判定結果情報().get特定施設入居者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(介護予防福祉用具貸与);
            builder.append(business.get一次判定結果情報().get福祉用具貸与());
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定介護予防福祉用具販売);
            builder.append(RString.EMPTY);
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (business.get一次判定結果情報().get住宅改修() != null) {
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
        builder.append(getサービス状況(business));
        builder.append(getサービス状況01(business));
        return builder.toRString();
    }

    private static RString getサービス状況(IchijiHanteizumiDataBusiness business) {
        RStringBuilder builder = new RStringBuilder();
        if (!ServiceKubunCode.予防給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && !ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())) {
            return new RString("                                      (なし)");
        }
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード()))) {
            builder.append(介護サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(訪問介護_ホームヘルプサービス);
            builder.append(business.get一次判定結果情報().get訪問介護ホームヘルプ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問入浴介護);
            builder.append(business.get一次判定結果情報().get訪問入浴介護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問看護);
            builder.append(business.get一次判定結果情報().get訪問看護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問リハビリテーション);
            builder.append(business.get一次判定結果情報().get訪問リハビリテーション());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(居宅療養管理指導);
            builder.append(business.get一次判定結果情報().get居宅療養管理指導());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所介護_デイサービス);
            builder.append(business.get一次判定結果情報().get通所介護デイサービス());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所リハビリテーション);
            builder.append(business.get一次判定結果情報().get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝﾃﾞｲｹｱ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(短期入所生活介護);
            builder.append(business.get一次判定結果情報().get短期入所生活介護ショートステイ());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(短期入所療養介護);
            builder.append(business.get一次判定結果情報().get短期入所療養介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(特定施設入居者生活介護);
            builder.append(business.get一次判定結果情報().get特定施設入居者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(福祉用具貸与);
            builder.append(business.get一次判定結果情報().get福祉用具貸与());
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定福祉用具販売);
            builder.append(business.get一次判定結果情報().get特定福祉用具販売());
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (business.get一次判定結果情報().get住宅改修() != null) {
                builder.append(new RString("1"));
            } else {
                builder.append(new RString("0"));
            }
            builder.append(System.lineSeparator());
            builder.append(夜間対応型訪問介護);
            builder.append(business.get一次判定結果情報().get夜間対応型訪問介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型通所介護);
            builder.append(business.get一次判定結果情報().get認知症対応型共同生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(小規模多機能型住宅介護);
            builder.append(business.get一次判定結果情報().get小規模多機能型居宅介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(認知症対応型共同生活介護);
            builder.append(business.get一次判定結果情報().get認知症対応型共同生活介護グループホーム());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型特定施設入所者生活介護);
            builder.append(business.get一次判定結果情報().get地域密着型特定施設入居者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(地域密着型介護老人福祉施設入所者生活介護);
            builder.append(business.get一次判定結果情報().get地域密着型介護老人福祉施設入所者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(定期巡回_随時対応型訪問介護看護);
            if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
                builder.append(business.get一次判定結果情報().get定期巡回随時対応型訪問介護看護());
                builder.append(回月);
                builder.append(System.lineSeparator());
                builder.append(看護小規模多機能型居宅介護);
                builder.append(business.get一次判定結果情報().get看護小規模多機能型居宅介護());
                builder.append(日月);
            }
            if (識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                    || 識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
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

    private static RString getサービス状況01(IchijiHanteizumiDataBusiness business) {
        RStringBuilder builder = new RStringBuilder();
        if (ServiceKubunCode.介護給付サービス.getコード().equals(business.get一次判定結果情報().getサービス区分コード())
                && (識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード()))) {
            builder.append(介護サービス状況リスト);
            builder.append(System.lineSeparator());
            builder.append(訪問介護_ホームヘルプサービス);
            builder.append(business.get一次判定結果情報().get訪問介護ホームヘルプ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問入浴介護);
            builder.append(business.get一次判定結果情報().get訪問入浴介護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問看護);
            builder.append(business.get一次判定結果情報().get訪問看護());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(訪問リハビリテーション);
            builder.append(business.get一次判定結果情報().get訪問リハビリテーション());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(居宅療養管理指導);
            builder.append(business.get一次判定結果情報().get居宅療養管理指導());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所介護_デイサービス);
            builder.append(business.get一次判定結果情報().get通所介護デイサービス());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(通所リハビリテーション);
            builder.append(business.get一次判定結果情報().get通所ﾘﾊﾋﾞﾘﾃｰｼｮﾝﾃﾞｲｹｱ());
            builder.append(回月);
            builder.append(System.lineSeparator());
            builder.append(短期入所生活介護);
            builder.append(business.get一次判定結果情報().get短期入所生活介護ショートステイ());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(短期入所療養介護);
            builder.append(business.get一次判定結果情報().get短期入所療養介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(特定施設入居者生活介護);
            builder.append(business.get一次判定結果情報().get特定施設入居者生活介護());
            builder.append(日月);
            builder.append(System.lineSeparator());
            builder.append(福祉用具貸与);
            builder.append(business.get一次判定結果情報().get福祉用具貸与());
            builder.append(品目);
            builder.append(System.lineSeparator());
            builder.append(特定福祉用具販売);
            builder.append(business.get一次判定結果情報().get特定福祉用具販売());
            builder.append(品目_6月間);
            builder.append(System.lineSeparator());
            builder.append(住宅改修);
            if (business.get一次判定結果情報().get住宅改修() != null) {
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
            builder.append(business.get一次判定結果情報().get認知症対応型共同生活介護グループホーム());
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
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (差分のみ印刷.equals(DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate(), SubGyomuCode.DBE認定支援))) {
            return 精神機能(business);
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
            if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                    || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get被害的()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get作話()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get感情が不安定()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get昼夜逆転()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get同じ話をする()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get大声を出す()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get介護に抵抗()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get落ち着きなし()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get一人で出たがる()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get収集癖()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get物や衣類を壊す()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().getひどい物忘れ()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get独り言独り笑い()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get自分勝手に行動する()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get話がまとまらない()));
            }
            if (識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                    || 識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                    || 識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get被害的()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get作話()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get感情が不安定()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get昼夜逆転()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get同じ話をする()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get大声を出す()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get介護に抵抗()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get落ち着きなし()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get一人で出たがる()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get収集癖()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().get物や衣類を壊す()));
                精神_行動障害4リスト.add(get名称16(business.get一次判定結果情報().getひどい物忘れ()));
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
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害3リスト = new ArrayList<>();
        if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get独り言独り笑い(), business.get一次判定結果情報().get前回独り言独り笑い()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get自分勝手に行動する(), business.get一次判定結果情報().get前回自分勝手に行動する()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get話がまとまらない(), business.get一次判定結果情報().get前回話がまとまらない()));
        }
        if (識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
            精神_行動障害3リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害3リスト.add(get意見書状況結果(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
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
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害2リスト = new ArrayList<>();
        if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get独り言独り笑い(), business.get一次判定結果情報().get前回独り言独り笑い()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get自分勝手に行動する(), business.get一次判定結果情報().get前回自分勝手に行動する()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get話がまとまらない(), business.get一次判定結果情報().get前回話がまとまらない()));
        }
        if (識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
            精神_行動障害2リスト.add(RString.EMPTY);
        }
        if (識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()));
            精神_行動障害2リスト.add(get状況改善(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()));
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
     * @return 精神_行動障害
     */
    public List<RString> set精神_行動障害1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害1リスト = new ArrayList<>();
        if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get被害的()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get作話()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get感情が不安定()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get昼夜逆転()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get同じ話をする()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get大声を出す()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get介護に抵抗()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get落ち着きなし()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get一人で出たがる()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get収集癖()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get物や衣類を壊す()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().getひどい物忘れ()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get独り言独り笑い()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get自分勝手に行動する()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get話がまとまらない()));
        }
        if (識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get被害的()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get作話()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get感情が不安定()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get昼夜逆転()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get同じ話をする()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get大声を出す()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get介護に抵抗()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get落ち着きなし()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get一人で出たがる()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get収集癖()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().get物や衣類を壊す()));
            精神_行動障害1リスト.add(get名称16(business.get一次判定結果情報().getひどい物忘れ()));
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
            精神_行動障害1リスト.add(RString.EMPTY);
        }
        return 精神_行動障害1リスト;
    }

    /**
     * 精神_行動障害を設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 精神_行動障害
     */
    public List<RString> 精神機能(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            return set精神機能差分09B(business);
        }
        if (識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード99A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            return set精神機能差分02A(business);
        }
        return 精神_行動障害4リスト;
    }

    private static RString get名称16(RString 名称16) {

        if (RString.isNullOrEmpty(名称16)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser16.toValue(名称16).get名称();
        }
    }

    private static RString get状況改善(RString 今回調査, RString 前回調査) {
        今回調査 = RString.EMPTY;
        前回調査 = RString.EMPTY;
        RString 状況改善 = RString.EMPTY;
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

    private static RString get意見書状況結果(RString 今回調査, RString 前回調査) {
        if (RString.isNullOrEmpty(前回調査) || 今回調査.equals(前回調査)) {
            return RString.EMPTY;
        }
        int 結果 = (RString.isNullOrEmpty(今回調査) ? 0 : Integer.parseInt(今回調査.toString())) - Integer.parseInt(前回調査.toString());
        if (結果 < 0) {
            return new RString(結果).substring(1);
        }
        return new RString(結果);
    }

    private List<RString> set精神機能差分09B(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回被害的()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回作話()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回感情が不安定()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回昼夜逆転()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回同じ話をする()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回大声を出す()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回介護に抵抗()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回落ち着きなし()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回一人で出たがる()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回収集癖()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回物や衣類を壊す()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()).isEmpty()
                ? RString.EMPTY : business.get一次判定結果情報().get前回ひどい物忘れ());
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get独り言独り笑い(), business.get一次判定結果情報().get前回独り言独り笑い()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回独り言独り笑い()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get自分勝手に行動する(), business.get一次判定結果情報().get前回自分勝手に行動する()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回自分勝手に行動する()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get話がまとまらない(), business.get一次判定結果情報().get前回話がまとまらない()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回話がまとまらない()));
        return 精神_行動障害4リスト;
    }

    private List<RString> set精神機能差分02A(IchijiHanteizumiDataBusiness business) {
        List<RString> 精神_行動障害4リスト = new ArrayList<>();
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get被害的(), business.get一次判定結果情報().get前回被害的()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回被害的()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get作話(), business.get一次判定結果情報().get前回作話()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回作話()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get感情が不安定(), business.get一次判定結果情報().get前回感情が不安定()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回感情が不安定()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get昼夜逆転(), business.get一次判定結果情報().get前回昼夜逆転()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回昼夜逆転()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get同じ話をする(), business.get一次判定結果情報().get前回同じ話をする()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回同じ話をする()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get大声を出す(), business.get一次判定結果情報().get前回大声を出す()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回大声を出す()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get介護に抵抗(), business.get一次判定結果情報().get前回介護に抵抗()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回介護に抵抗()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get落ち着きなし(), business.get一次判定結果情報().get前回落ち着きなし()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回落ち着きなし()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get一人で出たがる(), business.get一次判定結果情報().get前回一人で出たがる()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回一人で出たがる()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get収集癖(), business.get一次判定結果情報().get前回収集癖()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回収集癖()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().get物や衣類を壊す(), business.get一次判定結果情報().get前回物や衣類を壊す()).isEmpty()
                ? RString.EMPTY : get名称16(business.get一次判定結果情報().get前回物や衣類を壊す()));
        精神_行動障害4リスト.add(差分結果(business.get一次判定結果情報().getひどい物忘れ(), business.get一次判定結果情報().get前回ひどい物忘れ()).isEmpty()
                ? RString.EMPTY : business.get一次判定結果情報().get前回ひどい物忘れ());
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        精神_行動障害4リスト.add(RString.EMPTY);
        return 精神_行動障害4リスト;
    }

    private static RString 差分結果(RString 今回調査, RString 前回調査) {
        if (RString.isNullOrEmpty(今回調査) || RString.isNullOrEmpty(前回調査)) {
            return RString.EMPTY;
        }
        if (!今回調査.equals(前回調査)) {
            return 前回調査;
        }
        return RString.EMPTY;
    }

    /**
     * 身体機能起居動作1リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 身体機能起居動作1リスト
     */
    public List<RString> set身体機能_起居動作1リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作1リスト = new ArrayList<>();
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get麻痺左上肢()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get麻痺左下肢()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get麻痺右上肢()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get麻痺右下肢()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get麻痺その他()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get拘縮肩関節()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get拘縮股関節()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get拘縮膝関節()));
        身体機能_起居動作1リスト.add(get名称01(business.get一次判定結果情報().get拘縮その他()));
        身体機能_起居動作1リスト.add(get名称02(business.get一次判定結果情報().get寝返り()));
        身体機能_起居動作1リスト.add(get名称02(business.get一次判定結果情報().get起き上がり()));
        身体機能_起居動作1リスト.add(get名称03(business.get一次判定結果情報().get座位保持()));
        身体機能_起居動作1リスト.add(get名称04(business.get一次判定結果情報().get両足での立位()));
        身体機能_起居動作1リスト.add(get名称02(business.get一次判定結果情報().get歩行()));
        身体機能_起居動作1リスト.add(get名称02(business.get一次判定結果情報().get立ち上がり()));
        身体機能_起居動作1リスト.add(get名称04(business.get一次判定結果情報().get片足での立位()));
        身体機能_起居動作1リスト.add(get名称08(business.get一次判定結果情報().get視力()));
        身体機能_起居動作1リスト.add(get名称09(business.get一次判定結果情報().get聴力()));
        if (識別コード09B.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード09A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            身体機能_起居動作1リスト.add(get名称06(business.get一次判定結果情報().get洗身()));
            身体機能_起居動作1リスト.add(get名称06(business.get一次判定結果情報().getつめ切り()));
        }
        if (識別コード02A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())
                || 識別コード06A.equals(business.get一次判定結果情報().get厚労省IF識別コード())) {
            身体機能_起居動作1リスト.add(get名称22(business.get一次判定結果情報().get洗身()));
            身体機能_起居動作1リスト.add(get名称22(business.get一次判定結果情報().getつめ切り()));

        }
        return 身体機能_起居動作1リスト;
    }

    /**
     * 身体機能起居動作2リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set身体機能_起居動作2リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作2リスト = new ArrayList<>();
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get麻痺左上肢(),
                business.get一次判定結果情報().get前回麻痺左上肢()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get麻痺左下肢(),
                business.get一次判定結果情報().get前回麻痺左下肢()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get麻痺右上肢(),
                business.get一次判定結果情報().get前回麻痺右上肢()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get麻痺右下肢(),
                business.get一次判定結果情報().get前回麻痺右下肢()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get麻痺その他(),
                business.get一次判定結果情報().get前回麻痺その他()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get拘縮肩関節(),
                business.get一次判定結果情報().get前回拘縮肩関節()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get拘縮股関節(),
                business.get一次判定結果情報().get前回拘縮股関節()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get拘縮膝関節(),
                business.get一次判定結果情報().get前回拘縮膝関節()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get拘縮その他(),
                business.get一次判定結果情報().get前回拘縮その他()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get寝返り(),
                business.get一次判定結果情報().get前回寝返り()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get起き上がり(),
                business.get一次判定結果情報().get前回起き上がり()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get座位保持(),
                business.get一次判定結果情報().get前回座位保持()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get両足での立位(),
                business.get一次判定結果情報().get前回両足での立位()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get歩行(),
                business.get一次判定結果情報().get前回歩行()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get立ち上がり(),
                business.get一次判定結果情報().get前回立ち上がり()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get片足での立位(),
                business.get一次判定結果情報().get前回片足での立位()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get視力(),
                business.get一次判定結果情報().get前回視力()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get聴力(),
                business.get一次判定結果情報().get前回聴力()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().get洗身(),
                business.get一次判定結果情報().get前回洗身()));
        身体機能_起居動作2リスト.add(get状況改善(business.get一次判定結果情報().getつめ切り(),
                business.get一次判定結果情報().getつめ切り()));
        return 身体機能_起居動作2リスト;
    }

    /**
     * 身体機能起居動作3リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 主治医意見書項目2リスト
     */
    public List<RString> set身体機能_起居動作3リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作3リスト = new ArrayList<>();
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get麻痺左上肢(),
                business.get一次判定結果情報().get前回麻痺左上肢()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get麻痺左下肢(),
                business.get一次判定結果情報().get前回麻痺左下肢()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get麻痺右上肢(),
                business.get一次判定結果情報().get前回麻痺右上肢()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get麻痺右下肢(),
                business.get一次判定結果情報().get前回麻痺右下肢()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get麻痺その他(),
                business.get一次判定結果情報().get前回麻痺その他()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get拘縮肩関節(),
                business.get一次判定結果情報().get前回拘縮肩関節()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get拘縮股関節(),
                business.get一次判定結果情報().get前回拘縮股関節()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get拘縮膝関節(),
                business.get一次判定結果情報().get前回拘縮膝関節()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get拘縮その他(),
                business.get一次判定結果情報().get前回拘縮その他()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get寝返り(),
                business.get一次判定結果情報().get前回寝返り()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get起き上がり(),
                business.get一次判定結果情報().get前回起き上がり()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get座位保持(),
                business.get一次判定結果情報().get前回座位保持()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get両足での立位(),
                business.get一次判定結果情報().get前回両足での立位()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get歩行(),
                business.get一次判定結果情報().get前回歩行()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get立ち上がり(),
                business.get一次判定結果情報().get前回立ち上がり()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get片足での立位(),
                business.get一次判定結果情報().get前回片足での立位()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get洗身(), business.get一次判定結果情報().get前回洗身()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().getつめ切り(), business.get一次判定結果情報().get前回つめ切り()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get視力(), business.get一次判定結果情報().get前回視力()));
        身体機能_起居動作3リスト.add(get意見書状況結果(business.get一次判定結果情報().get聴力(), business.get一次判定結果情報().get前回聴力()));
        return 身体機能_起居動作3リスト;
    }

    /**
     * 身体機能_起居動作4リストを設定します。
     *
     * @param business IchijiHanteizumiDataBusiness
     * @return 身体機能_起居動作4リスト
     */
    public List<RString> set身体機能_起居動作4リスト(IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        RString 結果印刷有無 = DbBusinessConfig.get(ConfigNameDBE.認定調査前回結果印刷有無, RDate.getNowDate());
        if (差分のみ印刷.equals(結果印刷有無)) {
            return 身体機能差分(business);
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
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回麻痺左上肢()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回麻痺左下肢()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回麻痺右上肢()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回麻痺右下肢()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回麻痺その他()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回拘縮肩関節()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回拘縮股関節()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回拘縮膝関節()));
            身体機能_起居動作4リスト.add(get名称01(business.get一次判定結果情報().get前回拘縮その他()));
            身体機能_起居動作4リスト.add(get名称02(business.get一次判定結果情報().get前回寝返り()));
            身体機能_起居動作4リスト.add(get名称02(business.get一次判定結果情報().get前回起き上がり()));
            身体機能_起居動作4リスト.add(get名称03(business.get一次判定結果情報().get前回座位保持()));
            身体機能_起居動作4リスト.add(get名称04(business.get一次判定結果情報().get前回両足での立位()));
            身体機能_起居動作4リスト.add(get名称02(business.get一次判定結果情報().get前回歩行()));
            身体機能_起居動作4リスト.add(get名称02(business.get一次判定結果情報().get前回立ち上がり()));
            身体機能_起居動作4リスト.add(get名称04(business.get一次判定結果情報().get前回片足での立位()));
            身体機能_起居動作4リスト.add(get名称04(business.get一次判定結果情報().get前回片足での立位()));
            身体機能_起居動作4リスト.add(get名称04(business.get一次判定結果情報().get前回洗身()));
            身体機能_起居動作4リスト.add(get名称08(business.get一次判定結果情報().get前回つめ切り()));
            身体機能_起居動作4リスト.add(get名称09(business.get一次判定結果情報().get前回視力()));
            身体機能_起居動作4リスト.add(get名称09(business.get一次判定結果情報().get前回聴力()));
        }
        return 身体機能_起居動作4リスト;
    }

    private List<RString> 身体機能差分(IchijiHanteizumiDataBusiness business) {
        List<RString> 身体機能_起居動作4リスト = new ArrayList<>();
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get麻痺左上肢(),
                business.get一次判定結果情報().get前回麻痺左上肢()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回麻痺左上肢()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get麻痺左下肢(),
                business.get一次判定結果情報().get前回麻痺左下肢()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回麻痺左下肢()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get麻痺右上肢(),
                business.get一次判定結果情報().get前回麻痺右上肢()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回麻痺右上肢()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get麻痺右下肢(),
                business.get一次判定結果情報().get前回麻痺右下肢()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回麻痺右下肢()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get麻痺その他(),
                business.get一次判定結果情報().get前回麻痺その他()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回麻痺その他()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get拘縮肩関節(),
                business.get一次判定結果情報().get前回拘縮肩関節()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回拘縮肩関節()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get拘縮股関節(),
                business.get一次判定結果情報().get前回拘縮股関節()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回拘縮股関節()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get拘縮膝関節(),
                business.get一次判定結果情報().get前回拘縮膝関節()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回拘縮膝関節()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get拘縮その他(),
                business.get一次判定結果情報().get前回拘縮その他()).isEmpty() ? RString.EMPTY
                : get名称01(business.get一次判定結果情報().get前回拘縮その他()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get寝返り(),
                business.get一次判定結果情報().get前回寝返り()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get前回寝返り()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get起き上がり(),
                business.get一次判定結果情報().get前回起き上がり()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get前回起き上がり()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get座位保持(),
                business.get一次判定結果情報().get前回座位保持()).isEmpty() ? RString.EMPTY
                : get名称03(business.get一次判定結果情報().get前回座位保持()));
        set身体機能差分1(身体機能_起居動作4リスト, business);
        return 身体機能_起居動作4リスト;
    }

    private void set身体機能差分1(List<RString> 身体機能_起居動作4リスト, IchijiHanteizumiDataBusiness business) {
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get歩行(),
                business.get一次判定結果情報().get前回歩行()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get前回歩行()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get立ち上がり(),
                business.get一次判定結果情報().get前回立ち上がり()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get前回立ち上がり()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get片足での立位(),
                business.get一次判定結果情報().get前回片足での立位()).isEmpty() ? RString.EMPTY
                : get名称04(business.get一次判定結果情報().get前回片足での立位()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get洗身(),
                business.get一次判定結果情報().get前回洗身()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get洗身()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().getつめ切り(),
                business.get一次判定結果情報().get前回つめ切り()).isEmpty() ? RString.EMPTY
                : get名称04(business.get一次判定結果情報().get前回つめ切り()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get視力(),
                business.get一次判定結果情報().get前回視力()).isEmpty() ? RString.EMPTY
                : get名称02(business.get一次判定結果情報().get前回視力()));
        身体機能_起居動作4リスト.add(差分結果(business.get一次判定結果情報().get聴力(),
                business.get一次判定結果情報().get前回聴力()).isEmpty() ? RString.EMPTY
                : get名称04(business.get一次判定結果情報().get前回聴力()));
    }

    private static RString get名称01(RString 名称01) {

        if (RString.isNullOrEmpty(名称01)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser01.toValue(名称01).get名称();
        }
    }

    private static RString get名称02(RString 名称02) {

        if (RString.isNullOrEmpty(名称02)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser02.toValue(名称02).get名称();
        }
    }

    private static RString get名称03(RString 名称03) {

        if (RString.isNullOrEmpty(名称03)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser03.toValue(名称03).get名称();
        }
    }

    private static RString get名称04(RString 名称04) {

        if (RString.isNullOrEmpty(名称04)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser04.toValue(名称04).get名称();
        }
    }

    private static RString get名称06(RString 名称06) {

        if (RString.isNullOrEmpty(名称06)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser06.toValue(名称06).get名称();
        }
    }

    private static RString get名称22(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser22.toValue(名称22).get名称();
        }
    }

    private static RString get名称08(RString 名称07) {

        if (RString.isNullOrEmpty(名称07)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser08.toValue(名称07).get名称();
        }
    }

    private static RString get名称09(RString 名称22) {

        if (RString.isNullOrEmpty(名称22)) {
            return RString.EMPTY;
        } else {
            return ChosaAnser09.toValue(名称22).get名称();
        }
    }
}
