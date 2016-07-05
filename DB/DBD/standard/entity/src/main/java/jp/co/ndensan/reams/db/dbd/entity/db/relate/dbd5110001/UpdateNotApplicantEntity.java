/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd5110001;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 更新未申請者把握リスト情報を取得するEntityクラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class UpdateNotApplicantEntity {

    private RString 申請書管理番号;
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 被保険者氏名カナ;
    private RString 郵便番号;
    private RString 住所;
    private FlexibleDate 生年月日;
    private int 年齢;
    private RString 識別コード;

}
