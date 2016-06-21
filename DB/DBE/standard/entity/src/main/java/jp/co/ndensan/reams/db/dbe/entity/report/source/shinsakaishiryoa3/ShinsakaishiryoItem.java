/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.report.source.shinsakaishiryoa3;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 事務局用介護認定審査対象者一覧表のEntityクラスです。
 *
 * @reamsid_L DBE-0150-020 lishengli
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaishiryoItem {

    private RString 申請書管理番号;
    private RString 審査会番号;
    private RString 審査会開催年月日;
    private RString 合議体番号;
    private RString 審査対象者数;
    private RString 審査員一覧;
    private int no;
    private RString 審査会審査順;
    private RString 保険者;
    private RString 被保険者;
    private RString 氏名;
    private RString 性別;
    private RString 年齢;
    private RString 前回二次;
    private RString 前回期間;
    private FlexibleDate 二時判定認定有効開始年月日;
    private FlexibleDate 二時判定認定有効終了年月日;
    private RString 一次判定;
    private RString 二次判定;
    private RString 警告;
    private RString 基準時間;
    private RString 審査結果;
    private RString 期間;

}
