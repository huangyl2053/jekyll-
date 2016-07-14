/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBECodeShubetsu;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.CyoSaiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.GeTuReiSyoRiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IChiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IKnSyoiRaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.IkenSyoNyuSyuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.KoShiTaisyoBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.MaSuKinGuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.NiJiHanTeiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShiSeiKeTuKeBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKaiToRoKuBusiness;
import jp.co.ndensan.reams.db.dbz.business.core.yokaigoninteitasklist.ShinSaKeTuKeBusiness;
import jp.co.ndensan.reams.db.dbz.definition.core.dokuji.NijiHanteiKekkaInputHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteiChousaIraiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.NinteichosaTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKeikoku;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ichijihantei.IchijiHanteiKekkaCode99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiTokusokuHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShinsakaiYusenWaritsukeKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.yokaigoninteitasklist.YokaigoNinteiTaskListParameter;
import jp.co.ndensan.reams.db.dbz.service.core.yokaigoninteitasklist.YokaigoNinteiTaskListFinder;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;

/**
 * タスク一覧共有画面のDivControllerです。
 *
 * @reamsid_L DBE-3000-160 houtianpeng
 */
public class YokaigoNinteiTaskListHandler {

    private final YokaigoNinteiTaskListDiv div;

    private static final RString 更新対象モード = new RString("更新対象モード");
    private static final RString 申請受付モード = new RString("申請受付モード");
    private static final RString 調査依頼モード = new RString("調査依頼モード");
    private static final RString 意見書依頼モード = new RString("意見書依頼モード");
    private static final RString 調査入手モード = new RString("調査入手モード");
    private static final RString 意見書入手モード = new RString("意見書入手モード");
    private static final RString 一次判定モード = new RString("一次判定モード");
    private static final RString マスキングモード = new RString("マスキングモード");
    private static final RString 審査会登録モード = new RString("審査会登録モード");
    private static final RString 二次判定モード = new RString("二次判定モード");
    private static final RString 月例処理モード = new RString("月例処理モード");
    private static final RString 審査受付モード = new RString("審査受付モード");
    private static final Code 認定ｿﾌﾄ99 = new Code(new RString("99A"));
    private static final Code 認定ｿﾌﾄ2002 = new Code(new RString("02A"));
    private static final Code 認定ｿﾌﾄ2006 = new Code(new RString("06A"));
    private static final Code 認定ｿﾌﾄ2009_A = new Code(new RString("09A"));
    private static final Code 認定ｿﾌﾄ2009_B = new Code(new RString("09B"));
    private static final RString 調査票イメージ = new RString("C0007_BAK.PNG");
    private static final RString 調査票特記イメージ_C4101 = new RString("C4101_BAK.PNG");
    private static final RString 調査票特記イメージ_C4102 = new RString("C4102_BAK.PNG");
    private static final RString 調査票特記イメージ_C4103 = new RString("C4103_BAK.PNG");
    private static final RString 調査票特記イメージ_C4104 = new RString("C4104_BAK.PNG");
    private static final RString 調査票特記イメージ_C4105 = new RString("C4105_BAK.PNG");
    private static final RString 調査票特記イメージ_C4106 = new RString("C4106_BAK.PNG");
    private static final RString 主治医意見書イメージ_E0001 = new RString("E0001_BAK.PNG");
    private static final RString 主治医意見書イメージ_E0002 = new RString("E0002_BAK.PNG");
    private static final RString その他資料イメージ_F1401A01 = new RString("F1401A01_BAK.PNG");
    private static final RString その他資料イメージ_F1401B02 = new RString("F1401B02_BAK.PNG");
    private static final RString その他資料イメージ_F1401C03 = new RString("F1401C03_BAK.PNG");
    private static final RString その他資料イメージ_F1401D04 = new RString("F1401D04_BAK.PNG");
    private static final RString その他資料イメージ_F1401E05 = new RString("F1401E05_BAK.PNG");
    private static final RString その他資料イメージ_F1401F06 = new RString("F1401F06_BAK.PNG");
    private static final int インデックス_0 = 0;
    private static final int インデックス_1 = 1;
    private static final int インデックス_2 = 2;
    private static final int インデックス_3 = 3;
    private static final int インデックス_4 = 4;
    private static final int インデックス_5 = 5;
    private static final int インデックス_6 = 6;
    private static final int インデックス_7 = 7;
    private static final int インデックス_8 = 8;
    private static final int インデックス_9 = 9;
    private static final int インデックス_10 = 10;
    private static final int インデックス_11 = 11;
    private static final int インデックス_12 = 12;
    private static final int インデックス_13 = 13;
    private static final int インデックス_14 = 14;
    private static final int インデックス_15 = 15;
    private static final int インデックス_16 = 16;
    private static final int インデックス_17 = 17;
    private static final int インデックス_18 = 18;
    private static final int インデックス_19 = 19;
    private static final int インデックス_20 = 20;
    private static final int インデックス_21 = 21;
    private static final int インデックス_22 = 22;
    private static final int インデックス_23 = 23;
    private static final int インデックス_24 = 24;
    private static final int インデックス_25 = 25;
    private static final int インデックス_26 = 26;
    private static final int インデックス_27 = 27;
    private static final int インデックス_28 = 28;
    private static final int インデックス_29 = 29;
    private static final int インデックス_30 = 30;
    private static final int インデックス_31 = 31;
    private static final int インデックス_32 = 32;
    private static final int インデックス_33 = 33;
    private static final int インデックス_34 = 34;
    private static final int インデックス_35 = 35;
    private static final int インデックス_36 = 36;
    private static final int インデックス_37 = 37;
    private static final int インデックス_38 = 38;
    private static final int インデックス_39 = 39;
    private static final int インデックス_40 = 40;
    private static final int インデックス_41 = 41;
    private static final int インデックス_42 = 42;
    private static final int インデックス_43 = 43;
    private static final int インデックス_44 = 44;
    private static final int インデックス_45 = 45;
    private static final int インデックス_46 = 46;
    private static final int インデックス_47 = 47;
    private static final int インデックス_48 = 48;
    private static final int インデックス_49 = 49;
    private static final int インデックス_50 = 50;
    private static final int インデックス_51 = 51;
    private static final int インデックス_52 = 52;
    private static final int インデックス_53 = 53;
    private static final int インデックス_54 = 54;
    private static final int インデックス_55 = 55;
    private static final int インデックス_56 = 56;
    private static final int インデックス_57 = 57;
    private static final int インデックス_58 = 58;
    private static final int インデックス_59 = 59;
    private static final int インデックス_60 = 60;
    private static final int インデックス_61 = 61;
    private static final int インデックス_62 = 62;
    private static final int インデックス_63 = 63;
    private static final int インデックス_64 = 64;
    private static final int インデックス_65 = 65;
    private static final int インデックス_66 = 66;
    private static final int インデックス_67 = 67;
    private static final int インデックス_68 = 68;
    private static final int インデックス_69 = 69;
    private static final int インデックス_70 = 70;
    private static final int インデックス_71 = 71;
    private static final int インデックス_72 = 72;
    private static final int インデックス_73 = 73;
    private static final int インデックス_74 = 74;
    private static final int インデックス_75 = 75;
    private static final int インデックス_82 = 82;
    private static final int インデックス_83 = 83;
    private static final int インデックス_84 = 84;
    private static final int インデックス_85 = 85;

    /**
     * コンストラクタです。
     *
     * @param div 調査委託先/調査員入力共有子のエンティティ
     */
    public YokaigoNinteiTaskListHandler(YokaigoNinteiTaskListDiv div) {
        this.div = div;
    }

    /**
     * 画面の初期化をします。
     *
     * @param モード モード
     */
    public void initialize(RString モード) {
        共通状態();
        if (更新対象モード.equals(モード)) {
            List<KoShiTaisyoBusiness> 更新対象List = YokaigoNinteiTaskListFinder.
                    createInstance().get更新対象モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            更新対象モード(更新対象List);
        }
        if (申請受付モード.equals(モード)) {

            List<ShiSeiKeTuKeBusiness> 申請受付List = YokaigoNinteiTaskListFinder.createInstance().
                    get申請受付モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            申請受付モード(申請受付List);
        }
        if (調査依頼モード.equals(モード)) {

            List<CyoSaiRaiBusiness> 調査依頼List = YokaigoNinteiTaskListFinder.createInstance().
                    get調査依頼モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!調査依頼List.isEmpty()) {
                ShinSaKaiBusiness 前調査依頼Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前調査依頼モード(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前調査依頼Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            調査依頼モード(調査依頼List);
        }
        if (意見書依頼モード.equals(モード)) {

            List<IKnSyoiRaiBusiness> 意見書依頼List = YokaigoNinteiTaskListFinder.createInstance().
                    get意見書依頼モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!意見書依頼List.isEmpty()) {
                ShinSaKaiBusiness 前意見書依頼Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前意見書依頼(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前意見書依頼Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            意見書依頼モード(意見書依頼List);
        }
        if (調査入手モード.equals(モード)) {
            List<CyoSaNyuSyuBusiness> 調査入手List = YokaigoNinteiTaskListFinder.createInstance().
                    get調査入手モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!調査入手List.isEmpty()) {
                ShinSaKaiBusiness 前調査入手Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前調査入手モード(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前調査入手Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            調査入手モード(調査入手List);
        }
        if (意見書入手モード.equals(モード)) {
            List<IkenSyoNyuSyuBusiness> 意見書入手List = YokaigoNinteiTaskListFinder.createInstance().
                    get意見書入手モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!意見書入手List.isEmpty()) {
                ShinSaKaiBusiness 前意見書入手Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前意見書入手(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前意見書入手Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            意見書入手モード(意見書入手List);
        }

        if (一次判定モード.equals(モード)) {
            List<IChiJiHanTeiBusiness> 一次判定List = YokaigoNinteiTaskListFinder.createInstance().
                    get一次判定モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!一次判定List.isEmpty()) {
                ShinSaKaiBusiness 前一次判定Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前一次判定(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前一次判定Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            一次判定モード(一次判定List);
        }
        if (マスキングモード.equals(モード)) {
            List<MaSuKinGuBusiness> マスキングList = YokaigoNinteiTaskListFinder.createInstance().
                    getマスキングモード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!マスキングList.isEmpty()) {
                ShinSaKaiBusiness 前マスキングModel = YokaigoNinteiTaskListFinder.createInstance().
                        get前マスキング(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前マスキングModel.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            マスキングモード(マスキングList);
        }
        if (審査会登録モード.equals(モード)) {
            List<ShinSaKaiToRoKuBusiness> 審査会登録List = YokaigoNinteiTaskListFinder.createInstance().
                    get審査会登録モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!審査会登録List.isEmpty()) {
                ShinSaKaiBusiness 前審査会登録Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前審査会登録(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前審査会登録Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            審査会登録モード(審査会登録List);
        }
        if (二次判定モード.equals(モード)) {
            List<NiJiHanTeiBusiness> 二次判定List = YokaigoNinteiTaskListFinder.createInstance().
                    get二次判定モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!二次判定List.isEmpty()) {
                ShinSaKaiBusiness 前二次判定Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前二次判定(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前二次判定Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            二次判定モード(二次判定List);
        }
        if (月例処理モード.equals(モード)) {
            List<GeTuReiSyoRiBusiness> 月例処理List = YokaigoNinteiTaskListFinder.createInstance().
                    get月例処理モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!月例処理List.isEmpty()) {
                ShinSaKaiBusiness 前月例処理Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前月例処理(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前月例処理Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            月例処理モード(月例処理List);
        }
        if (審査受付モード.equals(モード)) {
            List<ShinSaKeTuKeBusiness> 審査受付List = YokaigoNinteiTaskListFinder.createInstance().
                    get審査受付モード(YokaigoNinteiTaskListParameter.
                            createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード())).records();
            if (!審査受付List.isEmpty()) {
                ShinSaKaiBusiness 前審査受付Model = YokaigoNinteiTaskListFinder.createInstance().
                        get前審査受付(YokaigoNinteiTaskListParameter.
                                createParameter(ShoriJotaiKubun.通常.getコード(), ShoriJotaiKubun.延期.getコード()));
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(前審査受付Model.get要介護認定完了情報Lsit()));
            } else {
                ViewStateHolder.put(ViewStateKeys.タスク一覧_要介護認定完了情報, Models.create(new ArrayList()));
            }
            審査受付モード(審査受付List);
        }
    }

    private void 更新対象モード(List<KoShiTaisyoBusiness> 更新対象List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_6).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_7).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (KoShiTaisyoBusiness business : 更新対象List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            if (business.get更新通知発行完了年月日() != null && !business.get更新通知発行完了年月日().isEmpty()) {
                row.getKoshinKanryoDay().setValue(new RDate(business.get更新通知発行完了年月日().toString()));
                completeCount++;
            }
            if (business.get更新通知発行年月日() != null && !business.get更新通知発行年月日().isEmpty()) {
                row.getKoshinTsuchiYMD().setValue(new RDate(business.get更新通知発行年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(更新対象List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 申請受付モード(List<ShiSeiKeTuKeBusiness> 申請受付List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_8).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_11).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_13).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (ShiSeiKeTuKeBusiness business : 申請受付List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get認定申請情報登録完了年月日() != null && !business.get認定申請情報登録完了年月日().isEmpty()) {
                completeCount++;
                row.getKoshinTsuchiYMD().setValue(new RDate(business.get認定申請情報登録完了年月日().toString()));
            }
            if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
                row.getChosaIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
            }
            if (business.get調査票等出力年月日() != null && !business.get調査票等出力年月日().isEmpty()) {
                row.getChosaIraiDataShutsuryokuDay().setValue(new RDate(business.get調査票等出力年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));

            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(申請受付List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 調査依頼モード(List<CyoSaiRaiBusiness> 調査依頼List) {
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_9).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_10).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_11).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_12).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_13).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_14).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_15).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_16).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_17).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_18).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_19).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_20).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_21).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_22).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_38).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_39).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_40).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_41).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_42).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_43).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_44).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_45).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (CyoSaiRaiBusiness business : 調査依頼List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            row.getChosaIraiSaichosaCount().setValue(new Decimal(business.get再調査依頼回数()));
            if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
                completeCount++;
                row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
            }
            row.setChosaIraiKubun(business.get認定調査依頼区分コード() == null ? RString.EMPTY
                    : NinteiChousaIraiKubunCode.toValue(business.get認定調査依頼区分コード().getKey()).get名称());
            row.setKonkaiChosaItakusaki(business.get今回調査委託先() == null ? RString.EMPTY : business.get今回調査委託先());
            row.setKonkaiChosain(business.get今回調査員氏名() == null ? RString.EMPTY : business.get今回調査員氏名());
            row.getKonkaiChosaCount().setValue(new Decimal(business.get今回調査調査回数()));
            row.setZenkaiChosaItakusaki(business.get前回調査委託先() == null ? RString.EMPTY : business.get前回調査委託先());
            row.setZenkaiChosain(business.get前回調査員氏名() == null ? RString.EMPTY : business.get前回調査員氏名());
            row.setZenzenkaiChosaItakusaki(business.get前前回調査委託先() == null ? RString.EMPTY : business.get前前回調査委託先());
            row.setZenzenkaiChosain(business.get前前回調査員氏名() == null ? RString.EMPTY : business.get前前回調査員氏名());
            row.setYubinNumber(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().value());
            row.setJusho(business.get住所() == null ? RString.EMPTY : business.get住所().value());
            row.setNyushoShisetsu(business.get入所施設() == null ? RString.EMPTY : business.get入所施設().value());
            row.setChosaTokusokuHoho(business.get認定調査督促方法() == null ? RString.EMPTY
                    : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
            row.getChosaTokusokuCount().setValue(new Decimal(business.get認定調査督促回数()));
            row.setChikuCode(RString.isNullOrEmpty(business.get地区コード()) ? RString.EMPTY : business.get地区コード());
            row.setChosaTokusokuChiku(business.get地区コード() == null ? RString.EMPTY
                    : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                            DBECodeShubetsu.調査地区コード.getコード(),
                            new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
            row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード() == null ? RString.EMPTY : business.get厚労省IF識別コード().value());
            調査依頼モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(調査依頼List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 調査依頼モードの日付設定(dgNinteiTaskList_Row row, CyoSaiRaiBusiness business) {

        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }

        if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
            row.getChosaIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
        }
        if (business.get調査票等出力年月日() != null && !business.get調査票等出力年月日().isEmpty()) {
            row.getChousahyoOutput().setValue(new RDate(business.get調査票等出力年月日().toString()));
            row.getChosaIraiDataShutsuryokuDay().setValue(new RDate(business.get調査票等出力年月日().toString()));
        }
        if (business.get認定調査期限年月日() != null && !business.get認定調査期限年月日().isEmpty()) {
            row.getChosaIraiKigen().setValue(new RDate(business.get認定調査期限年月日().toString()));
        }
        if (business.get認定調査督促年月日() != null && !business.get認定調査督促年月日().isEmpty()) {
            row.getChosaTokusokuHakkoDay().setValue(new RDate(business.get認定調査督促年月日().toString()));
        }
    }

    private void 意見書依頼モード(List<IKnSyoiRaiBusiness> 意見書依頼List) {
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_25).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_26).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_27).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_28).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_29).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_30).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_33).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_34).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_35).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_36).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_37).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_38).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_39).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_40).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_46).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_47).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_48).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_49).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_72).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (IKnSyoiRaiBusiness business : 意見書依頼List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoIraiKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
            }
            row.getIkenshoIraiIkenCount().setValue(new Decimal(business.get再作成依頼回数()));
            row.setIkenshoIraiShokai(business.get意見書作成回数区分() == null
                    ? RString.EMPTY : IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数区分().getKey()).get名称());
            row.setKonkaiShujiiIryokikan(business.get今回医療機関() == null ? RString.EMPTY : business.get今回医療機関());
            row.setKonkaiShujii(business.get今回主治医() == null ? RString.EMPTY : business.get今回主治医());
            row.setZenkaiIryokikan(business.get前回医療機関() == null ? RString.EMPTY : business.get前回医療機関());
            row.setZenkaiShujii(business.get前回主治医() == null ? RString.EMPTY : business.get前回主治医());
            row.setYubinNumber(business.get郵便番号() == null ? RString.EMPTY : business.get郵便番号().value());
            row.setJusho(business.get住所() == null ? RString.EMPTY : business.get住所().value());
            row.setNyushoShisetsu(business.get入所施設() == null ? RString.EMPTY : business.get入所施設().value());
            row.setIkenshoTokusokuHoho(business.get主治医意見書作成督促方法() == null
                    ? RString.EMPTY : IkenshoSakuseiTokusokuHoho.toValue(business.get主治医意見書作成督促方法()).get名称());
            row.getIkenshoTokusokuCount().setValue(new Decimal(business.get主治医意見書作成督促回数()));
            row.setNyushoShisetsuCode(business.get入所施設コード() == null ? RString.EMPTY : business.get入所施設コード().value());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            意見書依頼モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(意見書依頼List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 意見書依頼モードの日付設定(dgNinteiTaskList_Row row, IKnSyoiRaiBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            row.getKeikaNissu().setValue(new Decimal(FlexibleDate.getNowDate().getBetweenDays(business.get認定申請年月日())));
        }
        if (business.get主治医意見書作成依頼年月日() != null && !business.get主治医意見書作成依頼年月日().isEmpty()) {
            row.getIkenshoIraiDay().setValue(new RDate(business.get主治医意見書作成依頼年月日().toString()));
        }
        if (business.get依頼書出力年月日() != null && !business.get依頼書出力年月日().isEmpty()) {
            row.getIkenshoIraiIraishoHakkoDay().setValue(new RDate(business.get依頼書出力年月日().toString()));
        }
        if (business.get意見書出力年月日() != null && !business.get意見書出力年月日().isEmpty()) {
            row.getIkenshoIraiIkenshoShutsuryokuDay().setValue(new RDate(business.get意見書出力年月日().toString()));
        }
        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getIkenshoIraiKigen().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
        if (business.get主治医意見書作成督促年月日() != null && !business.get主治医意見書作成督促年月日().isEmpty()) {
            row.getIkenshoTokusokuHakkoDay().setValue(new RDate(business.get主治医意見書作成督促年月日().toString()));
        }
        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getIkenshoTokusokuLimit().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
    }

    private void 調査入手モード(List<CyoSaNyuSyuBusiness> 調査入手List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_9).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_16).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_17).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_23).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_24).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_41).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_42).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_43).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_44).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_45).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (CyoSaNyuSyuBusiness business : 調査入手List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
                completeCount++;
                row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
            }
            row.setKonkaiChosaItakusaki(business.get調査委託先() == null ? RString.EMPTY : business.get調査委託先());
            row.setKonkaiChosain(business.get調査員氏名() == null ? RString.EMPTY : business.get調査員氏名());
            row.setChosaTokusokuHoho(business.get認定調査督促方法() == null ? RString.EMPTY
                    : new RString(NinteichosaTokusokuHoho.toValue(business.get認定調査督促方法()).name()));
            row.getChosaTokusokuCount().setValue(new Decimal(business.get認定調査督促回数()));
            row.setChosaTokusokuChiku(business.get地区コード() == null ? RString.EMPTY
                    : CodeMaster.getCodeMeisho(SubGyomuCode.DBE認定支援,
                            DBECodeShubetsu.調査地区コード.getコード(),
                            new Code(business.get地区コード()), new FlexibleDate(RDate.getNowDate().toDateString())));
            row.setNinteiChosaItakusakiCode(business.get認定調査委託先コード() == null
                    ? RString.EMPTY : business.get認定調査委託先コード().value());
            row.setNinteiChosainCode(business.get調査員コード() == null
                    ? RString.EMPTY : business.get調査員コード().value());
            row.setChikuCode(business.get地区コード() == null ? RString.EMPTY : business.get地区コード());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            調査入手モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(調査入手List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 調査入手モードの日付設定(dgNinteiTaskList_Row row, CyoSaNyuSyuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get認定調査実施年月日() != null && !business.get認定調査実施年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定調査実施年月日().toString()));
        }
        if (business.get認定調査完了年月日() != null && !business.get認定調査完了年月日().isEmpty()) {
            row.getChosahyoDataNyuryokuDay().setValue(new RDate(business.get認定調査完了年月日().toString()));
        }
        if (business.get認定調査督促年月日() != null && !business.get認定調査督促年月日().isEmpty()) {
            row.getChosaTokusokuHakkoDay().setValue(new RDate(business.get認定調査督促年月日().toString()));
        }
        if (business.get認定調査期限年月日() != null && !business.get認定調査期限年月日().isEmpty()) {
            row.getChosaTokusokuLiit().setValue(new RDate(business.get認定調査期限年月日().toString()));
        }
        row.setNinteichosaIraiRirekiNo(new RString(String.valueOf(business.get認定調査依頼履歴番号())));
    }

    private void 意見書入手モード(List<IkenSyoNyuSyuBusiness> 意見書入手List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_25).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_31).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_32).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_33).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_46).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_47).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_48).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_49).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_72).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (IkenSyoNyuSyuBusiness business : 意見書入手List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者名() == null ? RString.EMPTY : business.get保険者名());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get氏名() == null ? RString.EMPTY : business.get氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
            row.setIkenshoIraiShokai(business.get意見書作成回数区分() == null
                    ? RString.EMPTY : IkenshoSakuseiKaisuKubun.toValue(business.get意見書作成回数区分().getKey()).get名称());
            row.setIkenshoTokusokuHoho(business.get主治医意見書作成督促方法() == null ? RString.EMPTY : business.get主治医意見書作成督促方法());
            row.getIkenshoTokusokuCount().setValue(new Decimal(business.get主治医意見書作成督促回数()));
            意見書入手モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(意見書入手List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 意見書入手モードの日付設定(dgNinteiTaskList_Row row, IkenSyoNyuSyuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            row.getKeikaNissu().setValue(new Decimal(FlexibleDate.getNowDate().getBetweenDays(business.get認定申請年月日())));
        }
        if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
            row.getIkenshoIraiKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
        }
        if (business.get主治医意見書読取年月日() != null && !business.get主治医意見書読取年月日().isEmpty()) {
            row.getIkenshoNyushuTeikei().setValue(new RDate(business.get主治医意見書読取年月日().toString()));
        }
        if (business.get主治医意見書作成督促年月日() != null && !business.get主治医意見書作成督促年月日().isEmpty()) {
            row.getIkenshoTokusokuHakkoDay().setValue(new RDate(business.get主治医意見書作成督促年月日().toString()));
        }

        if (business.get主治医意見書作成期限年月日() != null && !business.get主治医意見書作成期限年月日().isEmpty()) {
            row.getIkenshoTokusokuLimit().setValue(new RDate(business.get主治医意見書作成期限年月日().toString()));
        }
        row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
        row.setIkenshoIraiRirekiNo(new RString(String.valueOf(business.get主治医意見書作成依頼履歴番号())));
    }

    private void 一次判定モード(List<IChiJiHanTeiBusiness> 一次判定List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_23).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_31).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_50).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_51).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_52).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_53).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_54).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (IChiJiHanTeiBusiness business : 一次判定List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
            row.setIchijiHanteiKekka(一次判定結果の名称を取得する(business.get厚労省IF識別コード(), business.get要介護認定一次判定結果コード()));
            row.setIchijiHanteiWarningCode(business.get要介護認定一次判定警告コード() == null
                    ? RString.EMPTY : IchijiHanteiKeikoku.toValue(business.get要介護認定一次判定警告コード()).get名称());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            一次判定モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(一次判定List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 一次判定モードの日付設定(dgNinteiTaskList_Row row, IChiJiHanTeiBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get要介護認定一次判定完了年月日() != null && !business.get要介護認定一次判定完了年月日().isEmpty()) {
            row.getIchijiHanteiKanryoDay().setValue(new RDate(business.get要介護認定一次判定完了年月日().toString()));
        }
        if (business.is仮一次判定区分()) {
            if (business.get要介護認定一次判定年月日() != null && !business.get要介護認定一次判定年月日().isEmpty()) {
                row.getIchijiHanteiKanri().setValue(new RDate(business.get要介護認定一次判定年月日().toString()));
            }
        } else {
            if (business.get要介護認定一次判定年月日() != null && !business.get要介護認定一次判定年月日().isEmpty()) {
                row.getIchijiHantei().setValue(new RDate(business.get要介護認定一次判定年月日().toString()));
            }
        }
    }

    private void マスキングモード(List<MaSuKinGuBusiness> マスキングList) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_9).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_23).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_25).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_31).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_55).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_82).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_83).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_84).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_85).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (MaSuKinGuBusiness business : マスキングList) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            if (get調査票(business.getイメージ共有ファイルID())) {

                row.setCyoSaHyo(new RString("○"));
            }
            if (get調査票特記(business.getイメージ共有ファイルID())) {

                row.setCyoSaHyoToKi(new RString("○"));
            }
            if (get主治医意見書(business.getイメージ共有ファイルID())) {

                row.setJyuJiIiKenJyo(new RString("○"));
            }
            if (getその他資料(business.getイメージ共有ファイルID())) {

                row.setSoNoTaShiRyo(new RString("○"));
            }

            マスキングモードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(マスキングList.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private boolean get調査票(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票イメージ));
    }

    private boolean get調査票特記(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4101))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4102))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4103))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4104))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4105))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 調査票特記イメージ_C4106));
    }

    private boolean get主治医意見書(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 主治医意見書イメージ_E0001))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, 主治医意見書イメージ_E0002));
    }

    private boolean getその他資料(RDateTime sharedFileId) {

        return RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401A01))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401B02))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401C03))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401D04))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401E05))
                || RString.isNullOrEmpty(共有ファイルを引き出す(sharedFileId, その他資料イメージ_F1401F06));
    }

    private RString getFilePath(RDateTime sharedFileId, RString sharedFileName) {
        RString imagePath = Path.combinePath(Path.getUserHomePath(), new RString("app/webapps/db#dbe/WEB-INF/image/"));
        ReadOnlySharedFileEntryDescriptor descriptor
                = new ReadOnlySharedFileEntryDescriptor(new FilesystemName(sharedFileName),
                        sharedFileId);
        try {
            SharedFile.copyToLocal(descriptor, new FilesystemPath(imagePath));
        } catch (Exception e) {
            return RString.EMPTY;
        }
        return Path.combinePath(new RString("/db/dbe/image/"), sharedFileName);
    }

    private RString 共有ファイルを引き出す(RDateTime イメージID, RString イメージ名) {
        RString imagePath = RString.EMPTY;
        if (イメージID != null) {
            imagePath = getFilePath(イメージID, イメージ名);
        }
        return imagePath;
    }

    private void マスキングモードの日付設定(dgNinteiTaskList_Row row, MaSuKinGuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get認定調査依頼完了年月日() != null && !business.get認定調査依頼完了年月日().isEmpty()) {
            row.getChosaIraiKanryoDay().setValue(new RDate(business.get認定調査依頼完了年月日().toString()));
        }
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.get主治医意見書作成依頼完了年月日() != null && !business.get主治医意見書作成依頼完了年月日().isEmpty()) {
            row.getIkenshoIraiKanryoDay().setValue(new RDate(business.get主治医意見書作成依頼完了年月日().toString()));
        }
        if (business.getマスキング完了年月日() != null && !business.getマスキング完了年月日().isEmpty()) {
            row.getMaskingKanryoDay().setValue(new RDate(business.getマスキング完了年月日().toString()));
        }
    }

    private void 審査会登録モード(List<ShinSaKaiToRoKuBusiness> 審査会登録List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_23).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_31).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_55).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_56).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_57).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_58).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_59).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_60).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_61).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_62).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (ShinSaKaiToRoKuBusiness business : 審査会登録List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            if (business.get主治医意見書登録完了年月日() != null && !business.get主治医意見書登録完了年月日().isEmpty()) {
                completeCount++;
                row.getIkenshoNyushuKanryoDay().setValue(new RDate(business.get主治医意見書登録完了年月日().toString()));
            }
            row.setYusenWaritsukesha(business.get介護認定審査会優先振分区分コード() == null ? RString.EMPTY
                    : ShinsakaiYusenWaritsukeKubunCode.toValue(business.get介護認定審査会優先振分区分コード().getKey()).get名称());
            row.setKaisaiNumber(business.get介護認定審査会開催番号() == null ? RString.EMPTY : business.get介護認定審査会開催番号());
            row.setGogitai(new RString(String.valueOf(business.get合議体番号())));
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            審査会登録モードの日付設定(row, business);
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(審査会登録List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 審査会登録モードの日付設定(dgNinteiTaskList_Row row, ShinSaKaiToRoKuBusiness business) {
        if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
            row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
        }
        if (business.getマスキング完了年月日() != null && !business.getマスキング完了年月日().isEmpty()) {
            row.getMaskingKanryoDay().setValue(new RDate(business.getマスキング完了年月日().toString()));
        }
        if (business.get認定審査会完了年月日() != null && !business.get認定審査会完了年月日().isEmpty()) {
            row.getShinsakaiKanryoDay().setValue(new RDate(business.get認定審査会完了年月日().toString()));
        }
        if (business.get認定審査会割当完了年月日() != null && !business.get認定審査会割当完了年月日().isEmpty()) {
            row.getShinsakaiwaritukeDay().setValue(new RDate(business.get認定審査会割当完了年月日().toString()));
        }
        if (business.get介護認定審査会開催予定年月日() != null && !business.get介護認定審査会開催予定年月日().isEmpty()) {
            row.getShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催予定年月日().toString()));
        }
        if (business.get介護認定審査会開始予定時刻() != null && !business.get介護認定審査会開始予定時刻().isEmpty()) {
            row.getShinsakaiKaisaiJikan().setValue(RTime.of(Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(0, 2).toString()),
                    Integer.valueOf(business.get介護認定審査会開始予定時刻().substring(2).toString())));
        }
        if (business.get認定調査完了年月日() != null && !business.get認定調査完了年月日().isEmpty()) {
            row.getChosahyoKanryoDay().setValue(new RDate(business.get認定調査完了年月日().toString()));
        }
    }

    private void 二次判定モード(List<NiJiHanTeiBusiness> 二次判定List) {
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_5).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_63).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_64).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_65).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_66).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_67).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_68).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_69).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (NiJiHanTeiBusiness business : 二次判定List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            row.setShinseiKubunHorei(business.get認定申請区分法令コード() == null
                    ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード().getKey()).get名称());
            if (business.get二次判定年月日() != null && !business.get二次判定年月日().isEmpty()) {
                completeCount++;
                row.getNijihanteiKanryoDay().setValue(new RDate(business.get二次判定年月日().toString()));
            }
            if (business.get二次判定結果入力年月日() != null && !business.get二次判定結果入力年月日().isEmpty()) {

                row.getNijihanteiKekkaToroku().setValue(new RDate(business.get二次判定結果入力年月日().toString()));
            }
            row.setNyuryokuHoho(business.get二次判定結果入力方法() == null ? RString.EMPTY
                    : NijiHanteiKekkaInputHoho.toValue(business.get二次判定結果入力方法().getKey()).get名称());
            row.setNijihanteiKekka(二次判定結果の名称を取得する(business.get厚労省IF識別コード(), business.get二次判定要介護状態区分コード()));
            row.setNijihanteiYukoKikan(new RString(String.valueOf(business.get二次判定認定有効期間())));
            if (business.get介護認定審査会開催年月日() != null && !business.get介護認定審査会開催年月日().isEmpty()) {
                row.getNijihanteiShinsakaiKaisaiDay().setValue(new RDate(business.get介護認定審査会開催年月日().toString()));
            }
            row.setNijihanteiKaisaiNumber(business.get介護認定審査会開催番号() == null ? RString.EMPTY : business.get介護認定審査会開催番号());
            row.setNijiHanteiYokaigoJotaiKubunCode(business.get二次判定要介護状態区分コード() == null
                    ? RString.EMPTY : business.get二次判定要介護状態区分コード().value());
            row.setKoroshoIfShikibetsuCode(business.get厚労省IF識別コード() == null ? RString.EMPTY : business.get厚労省IF識別コード().value());
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(二次判定List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 月例処理モード(List<GeTuReiSyoRiBusiness> 月例処理List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_5).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_70).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_71).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (GeTuReiSyoRiBusiness business : 月例処理List) {
            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分申請時コード().getKey()).get名称());
            row.setShinseiKubunHorei(business.get認定申請区分法令コード() == null
                    ? RString.EMPTY : NinteiShinseiHoreiCode.toValue(business.get認定申請区分法令コード().getKey()).get名称());
            if (business.getセンター送信年月日() != null && !business.getセンター送信年月日().isEmpty()) {
                row.getGetsureiShoriKanryoDay().setValue(new RDate(business.getセンター送信年月日().toString()));
            }
            if (business.getＩＦ送付年月日() != null && !business.getＩＦ送付年月日().isEmpty()) {
                row.getCenterSoshinDay().setValue(new RDate(business.getＩＦ送付年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(月例処理List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 審査受付モード(List<ShinSaKeTuKeBusiness> 審査受付List) {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(true);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_8).setVisible(true);
        List<dgNinteiTaskList_Row> rowList = new ArrayList<>();
        int completeCount = 0;
        for (ShinSaKeTuKeBusiness business : 審査受付List) {

            dgNinteiTaskList_Row row = new dgNinteiTaskList_Row();
            row.setHokensha(business.get保険者() == null ? RString.EMPTY : business.get保険者());
            if (business.get認定申請年月日() != null && !business.get認定申請年月日().isEmpty()) {
                row.getNinteiShinseiDay().setValue(new RDate(business.get認定申請年月日().toString()));
            }
            row.setHihoNumber(business.get被保険者番号() == null ? RString.EMPTY : business.get被保険者番号());
            row.setHihoShimei(business.get被保険者氏名() == null ? RString.EMPTY : business.get被保険者氏名().value());
            row.setShinseiKubunShinseiji(business.get認定申請区分_申請時コード() == null
                    ? RString.EMPTY : NinteiShinseiShinseijiKubunCode.toValue(business.get認定申請区分_申請時コード().getKey()).get名称());
            if (business.get認定申請情報登録完了年月日() != null && !business.get認定申請情報登録完了年月日().isEmpty()) {
                completeCount++;
                row.getShinseiUketsukeKanryoDay().setValue(new RDate(business.get認定申請情報登録完了年月日().toString()));
            }
            row.setShinseishoKanriNo(business.get申請書管理番号() == null ? RString.EMPTY : business.get申請書管理番号().value());
            rowList.add(row);
        }
        div.getTxtTotalCount().setValue(new RString(String.valueOf(審査受付List.size())));
        div.getTxtCompleteCount().setValue(new RString(String.valueOf(completeCount)));
        div.getDgNinteiTaskList().setDataSource(rowList);
    }

    private void 共通状態() {

        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_0).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_1).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_2).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_3).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_4).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_5).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_6).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_7).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_8).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_9).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_10).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_11).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_12).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_13).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_14).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_15).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_16).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_17).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_18).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_19).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_20).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_21).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_22).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_23).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_24).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_25).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_26).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_27).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_28).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_29).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_30).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_31).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_32).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_33).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_34).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_35).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_36).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_37).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_38).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_39).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_40).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_41).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_42).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_43).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_44).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_45).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_46).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_47).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_48).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_49).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_50).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_51).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_52).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_53).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_54).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_55).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_56).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_57).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_58).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_59).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_60).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_61).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_62).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_63).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_64).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_65).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_66).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_67).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_68).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_69).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_70).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_71).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_72).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_73).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_74).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_75).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_82).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_83).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_84).setVisible(false);
        div.getDgNinteiTaskList().getGridSetting().getColumns().get(インデックス_85).setVisible(false);
    }

    private RString 一次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 一次判定結果コード) {

        if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
            return IchijiHanteiKekkaCode99.toValue(一次判定結果コード == null ? RString.EMPTY : 一次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
            return IchijiHanteiKekkaCode02.toValue(一次判定結果コード == null ? RString.EMPTY : 一次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
            return IchijiHanteiKekkaCode06.toValue(一次判定結果コード == null ? RString.EMPTY : 一次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
            return IchijiHanteiKekkaCode09.toValue(一次判定結果コード == null ? RString.EMPTY : 一次判定結果コード.getKey()).get名称();
        }
        return RString.EMPTY;
    }

    private RString 二次判定結果の名称を取得する(Code 厚労省IF識別コード, Code 二次判定結果コード) {
        if (認定ｿﾌﾄ99.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun99.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2002.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun02.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2006.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun06.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        } else if (認定ｿﾌﾄ2009_A.equals(厚労省IF識別コード)
                || 認定ｿﾌﾄ2009_B.equals(厚労省IF識別コード)) {
            return YokaigoJotaiKubun09.toValue(二次判定結果コード == null ? RString.EMPTY : 二次判定結果コード.getKey()).get名称();
        }
        return RString.EMPTY;
    }

    /**
     * 一覧件数を取得します。
     *
     * @return 一覧件数
     */
    public RString 一覧件数() {

        return div.getTxtTotalCount().getValue();
    }

    /**
     * 一览に選択のデータを取得します。
     *
     * @return 選択のデータ
     */
    public List<dgNinteiTaskList_Row> getCheckbox() {

        return div.getDgNinteiTaskList().getSelectedItems();
    }

    /**
     * 一览にデータを取得します。
     *
     * @return 一览のデータ
     */
    public List<dgNinteiTaskList_Row> getDataSource() {
        return div.getDgNinteiTaskList().getDataSource();
    }
}
