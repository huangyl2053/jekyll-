/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.ninteienkitsuchishohakko;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.NinteiShinseiKubunShinsei;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定延期通知発行SQLパラメータクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiEnkiTsuchishoHakkoParameter implements IMyBatisParameter {

    private static final RString KEY0 = new RString("key0");
    private static final RString KEY1 = new RString("key1");
    private static final RString KEY2 = new RString("key2");
    private static final RString KEY3 = new RString("key3");

    private RString 認定申請年月日;
    private boolean is申請区分_全て選択チェックON;
    private RString 申請区分_新規申請;
    private boolean is申請区分_新規申請のみチェックON;
    private boolean is申請区分_新規申請かつ更新申請チェックON;
    private boolean is申請区分_新規申請かつ区分変更申請チェックON;
    private boolean is申請区分_更新申請かつ区分変更申請チェックON;
    private RString 申請区分_更新申請;
    private boolean is申請区分_更新申請のみチェックON;
    private RString 申請区分_区分変更申請;
    private boolean is申請区分_区分変更申請のみチェックON;
    private boolean is発行有無_全て選択チェックON;
    private boolean is発行有無_発行未チェックON;
    private boolean is発行有無_発行済チェックON;
    private boolean みなし２号等対象フラグ;
    private RString 処理見込み日From;
    private boolean is処理見込み日Fromが入力;
    private RString 処理見込み日To;
    private boolean is処理見込み日Toが入力;
    private RString 延期の理由;
    private boolean is延期の理由が選択;
    private RString 市町村コード;
    private boolean is保険者が選択;
    private boolean is認定調査_調査未チェックON;
    private boolean is認定調査_調査済チェックON;
    private boolean is意見書受領_受領未チェックON;
    private boolean is意見書受領_受領済チェックON;
    private boolean is一次判定_判定未チェックON;
    private boolean is一次判定_判定済チェックON;
    private boolean is審査会割付_割付未チェックON;
    private boolean is審査会割付_割付済チェックON;

    /**
     * コンストラクタです。
     *
     * @param 経過日数 経過日数
     * @param 申請区分KeyList 申請区分KeyList
     * @param 発行有無KeyList 発行有無KeyList
     * @param みなし２号Key みなし２号Key
     * @param 処理見込み日From 処理見込み日From
     * @param 処理見込み日To 処理見込み日To
     * @param 延期の理由 延期の理由
     * @param 認定調査KeyList 認定調査KeyList
     * @param 市町村コード 市町村コード
     * @param 意見書受領KeyList 意見書受領KeyList
     * @param 一次判定KeyList 一次判定KeyList
     * @param 審査会割付KeyList 審査会割付KeyList
     */
    public NinteiEnkiTsuchishoHakkoParameter(int 経過日数, List<RString> 申請区分KeyList, List<RString> 発行有無KeyList, RString みなし２号Key,
            RDate 処理見込み日From, RDate 処理見込み日To, RString 延期の理由, LasdecCode 市町村コード, List<RString> 認定調査KeyList,
            List<RString> 意見書受領KeyList, List<RString> 一次判定KeyList, List<RString> 審査会割付KeyList) {
        this.認定申請年月日 = RDate.getNowDate().minusDay(経過日数).toDateString();
        if (!申請区分KeyList.contains(KEY0)) {
            this.is申請区分_新規申請のみチェックON
                    = 申請区分KeyList.contains(KEY1) && !申請区分KeyList.contains(KEY2) && !申請区分KeyList.contains(KEY3);
            this.is申請区分_更新申請のみチェックON
                    = !申請区分KeyList.contains(KEY1) && 申請区分KeyList.contains(KEY2) && !申請区分KeyList.contains(KEY3);
            this.is申請区分_区分変更申請のみチェックON
                    = !申請区分KeyList.contains(KEY1) && !申請区分KeyList.contains(KEY2) && 申請区分KeyList.contains(KEY3);
            this.is申請区分_新規申請かつ更新申請チェックON
                    = 申請区分KeyList.contains(KEY1) && 申請区分KeyList.contains(KEY2) && !申請区分KeyList.contains(KEY3);
            this.is申請区分_新規申請かつ区分変更申請チェックON
                    = 申請区分KeyList.contains(KEY1) && !申請区分KeyList.contains(KEY2) && 申請区分KeyList.contains(KEY3);
            this.is申請区分_更新申請かつ区分変更申請チェックON
                    = !申請区分KeyList.contains(KEY1) && 申請区分KeyList.contains(KEY2) && 申請区分KeyList.contains(KEY3);
        }
        this.申請区分_新規申請 = new RString(NinteiShinseiKubunShinsei.新規申請.コード());
        this.申請区分_更新申請 = new RString(NinteiShinseiKubunShinsei.更新申請.コード());
        this.申請区分_区分変更申請 = new RString(NinteiShinseiKubunShinsei.区分変更申請.コード());
        if (!発行有無KeyList.contains(KEY0)) {
            this.is発行有無_発行未チェックON = 発行有無KeyList.contains(KEY1);
            this.is発行有無_発行済チェックON = 発行有無KeyList.contains(KEY2);
        }
        this.みなし２号等対象フラグ = KEY0.equals(みなし２号Key);
        if (処理見込み日From != null) {
            this.is処理見込み日Fromが入力 = true;
            this.処理見込み日From = 処理見込み日From.toDateString();
        }
        if (処理見込み日To != null) {
            this.is処理見込み日Toが入力 = true;
            this.処理見込み日To = 処理見込み日To.toDateString();
        }
        if (!延期の理由.isNullOrEmpty()) {
            this.延期の理由 = 延期の理由;
            this.is延期の理由が選択 = true;
        }
        edit検索条件(認定調査KeyList, 意見書受領KeyList, 一次判定KeyList, 審査会割付KeyList, 市町村コード);
    }

    private void edit検索条件(List<RString> 認定調査KeyList,
            List<RString> 意見書受領KeyList, List<RString> 一次判定KeyList, List<RString> 審査会割付KeyList, LasdecCode 市町村コード) {
        if (市町村コード != null && !市町村コード.isEmpty()) {
            this.市町村コード = 市町村コード.getColumnValue();
            this.is保険者が選択 = true;
        }
        if (!認定調査KeyList.contains(KEY0)) {
            this.is認定調査_調査未チェックON = 認定調査KeyList.contains(KEY1);
            this.is認定調査_調査済チェックON = 認定調査KeyList.contains(KEY2);
        }
        if (!意見書受領KeyList.contains(KEY0)) {
            this.is意見書受領_受領未チェックON = 意見書受領KeyList.contains(KEY1);
            this.is意見書受領_受領済チェックON = 意見書受領KeyList.contains(KEY2);
        }
        if (!一次判定KeyList.contains(KEY0)) {
            this.is一次判定_判定未チェックON = 一次判定KeyList.contains(KEY1);
            this.is一次判定_判定済チェックON = 一次判定KeyList.contains(KEY2);
        }
        if (!審査会割付KeyList.contains(KEY0)) {
            this.is審査会割付_割付未チェックON = 審査会割付KeyList.contains(KEY1);
            this.is審査会割付_割付済チェックON = 審査会割付KeyList.contains(KEY2);
        }
    }

}
