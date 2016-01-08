/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果情報RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
public class YouKaiGoNinTeiKekTesuChiRelateEntity {

    private RString 主治医医療機関コード;
    private RString 医療機関名称;
    private RString 郵便番号;
    private RString 電話番号;
    private RString 住所;
    private RString 主治医コード;
    private RString 主治医氏名;
    private int 対象件数;
    
    private RString 被保険者番号;
    private RString 被保険者氏名;
    private RString 性別	;
    private RString 生年月日;
    private RString 年齢;
    private RString 認定申請日;
    private RString 認定申請区分_申請時;
    private RString 認定申請区分_法令;
    private RString 二次判定要介護状態区分コード;
    private RString 二次判定認定有効期間;
    private RString 二次判定認定有効開始年月日;
    private RString 二次判定認定有効終了年月日;
    private RString 二次判定年月日;

}
