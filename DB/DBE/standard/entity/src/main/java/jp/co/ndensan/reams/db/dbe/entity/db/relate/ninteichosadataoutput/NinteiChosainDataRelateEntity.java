/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * バッチ認定調査データ出力（モバイル）の調査員出力RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class NinteiChosainDataRelateEntity implements IDbAccessable {

    private RString 市町村コード;
    private RString 調査員コード;
    private RString 調査員氏名;
    private RString 調査員カナ氏名;
    private RString 調査委託先コード;
    private RString 事業者名称;
    private RString 性別;
    private RString 地区コード;
    private RString 調査員資格;
    private RString 調査可能人数;
    private RString 状況フラグ;
    private RString 郵便番号;
    private RString 住所;
    private RString 電話番号;
    private RString ＦＡＸ番号;
    private RString 所属機関名称;

}
