/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.ninteienkitsuchishohakko;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定延期通知発行 発行対象者一覧情報Entityクラスです。
 *
 * @reamsid_L DBD-1410-010 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class NinteiEnkiTsuchishoHakkoEntity {

    private RString 申請書管理番号;
    private RString 被保番号;
    private FlexibleDate 認定申請年月日;
    private Code 申請区分_申請時_コード;
    private RString 氏名;
    private RString 氏名カナ;
    private FlexibleDate 延期決定日;
    private RString 延期理由;
    private FlexibleDate 通知書発行日;
    private int 延期回数;
    private FlexibleDate 延期見込み期間開始日;
    private FlexibleDate 延期見込み期間終了日;
    private FlexibleDate 調査実施日;
    private FlexibleDate 意見書受領日;
    private FlexibleDate 一次判定日;
    private FlexibleDate 審査会予定日;
    private RString 保険者名;

}
