/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.itakusakichosainichiran;

import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * 調査員一覧情報の取得のEntityクラスです。
 */
@Getter
@Setter
public class ItakusakiChosainIchiranRelateEntity {

    private RString dbT5910_NinteichosaItakusakiCode;
    private RString dbT5910_JigyoshaMeishoKana;
    private RString dbT5910_JigyoshaMeisho;
    private RString dbT5910_DaihyoshaNameKana;
    private RString dbT5910_DaihyoshaName;
    private YubinNo dbT5910_YubinNo;
    private TelNo dbT5910_TelNo;
    private RString dbT5910_Jusho;
    private boolean dbT5910_JokyoFlag;
    private RString dbT5913_NinteiChosainNo;
    private RString dbT5913_ChosainKanaShimei;
    private RString dbT5913_ChosainShimei;
    private RString dbT5913_ChosainShikaku;
    private RString dbT5913_Seibetsu;
    private RString dbT5913_ShozokuKikanName;
    private boolean dbT5913_JokyoFlag;
}
