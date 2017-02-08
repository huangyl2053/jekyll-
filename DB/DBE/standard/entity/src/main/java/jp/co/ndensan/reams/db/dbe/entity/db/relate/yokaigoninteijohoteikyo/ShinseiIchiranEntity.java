/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.yokaigoninteijohoteikyo;

import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 申請一覧のRelateEntityクラスです。
 *
 * @author N3212 竹内 和紀
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinseiIchiranEntity {

    private RString 申請書管理番号;
    private RString 保険者名称;
    private RString 被保険者番号;
    private AtenaMeisho 被保険者氏名;
    private FlexibleDate 生年月日;
    private int 年齢;
    private RString 性別;
    private FlexibleDate 認定申請年月日;
    private RString 申請区分;
    private RString 二次判定結果;
    private FlexibleDate 開催予定日;
    private FlexibleDate 開催日;
    private boolean 被保険者の同意;
    private boolean 主治医の同意;
    private FlexibleDate 情報提供資料出力年月日;
    private FlexibleDate 認定審査会完了年月日;
}
