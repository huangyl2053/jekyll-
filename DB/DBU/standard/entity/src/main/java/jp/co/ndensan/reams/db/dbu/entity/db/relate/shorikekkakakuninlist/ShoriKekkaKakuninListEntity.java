/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.entity.db.relate.shorikekkakakuninlist;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 処理確認リストのEntityです。
 *
 * @reamsid_L DBU-5590-040 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShoriKekkaKakuninListEntity {

    private RString 作成日時;
    private RString 頁数;
    private RString 保険者番号;
    private RString 保険者名;
    private RString 項目コード1;
    private RString 項目コード2;
    private RString 項目コード3;
    private RString 項目コード4;
    private RString 項目コード5;
    private RString プログラムID;
    private RString 項目値1;
    private RString 項目値2;
    private RString 項目値3;
    private RString 項目値4;
    private RString 項目値5;
    private RString 内容1;
    private RString 処理名称;
    private RString 内容2;
}
