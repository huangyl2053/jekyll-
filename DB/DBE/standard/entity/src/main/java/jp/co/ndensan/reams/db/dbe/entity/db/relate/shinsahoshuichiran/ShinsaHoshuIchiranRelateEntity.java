/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsahoshuichiran;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬一覧表のクラスです。
 *
 * @reamsid_L DBE-1920-020 zhaoyao
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsaHoshuIchiranRelateEntity {

    private int 合議体番号;
    private RString 審査会開催年月;
    private RString 介護認定審査会委員コード;
    private RString 介護認定審査会委員氏名;
    private RString 出席状況_1日;
    private RString 出席状況_2日;
    private RString 出席状況_3日;
    private RString 出席状況_4日;
    private RString 出席状況_5日;
    private RString 出席状況_6日;
    private RString 出席状況_7日;
    private RString 出席状況_8日;
    private RString 出席状況_9日;
    private RString 出席状況_10日;
    private RString 出席状況_11日;
    private RString 出席状況_12日;
    private RString 出席状況_13日;
    private RString 出席状況_14日;
    private RString 出席状況_15日;
    private RString 出席状況_16日;
    private RString 出席状況_17日;
    private RString 出席状況_18日;
    private RString 出席状況_19日;
    private RString 出席状況_20日;
    private RString 出席状況_21日;
    private RString 出席状況_22日;
    private RString 出席状況_23日;
    private RString 出席状況_24日;
    private RString 出席状況_25日;
    private RString 出席状況_26日;
    private RString 出席状況_27日;
    private RString 出席状況_28日;
    private RString 出席状況_29日;
    private RString 出席状況_30日;
    private RString 出席状況_31日;
    private int 出席回数;
    private Decimal 報酬総額;
    private Decimal 税額控除;
    private Decimal 報酬合計;
    private Decimal 総合計_報酬総額;
    private Decimal 総合計_税控除額;
    private Decimal 総合計_報酬合計;
}
