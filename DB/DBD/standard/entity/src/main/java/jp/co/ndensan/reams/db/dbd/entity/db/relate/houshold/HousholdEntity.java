/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.houshold;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 非課税年金対象者情報Entityクラスです。
 *
 * @reamsid_L DBD-4930-040 wangjie2
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class HousholdEntity implements Serializable {

    private int count;
    private RString カナ氏名;
    private RString 漢字氏名;
    private RString 生年月日;
    private RString 性別;
    private RString 年金保険者;
    private RString 基礎年金番号;
    private RString 現基礎年金番号;
    private RString 年金コード;
    private RString 対象年;
    private RString 作成年月日;
    private RString 通知内容;
    private RString 登録区分;
    private RString 被保険者番号;
    private RString 住所カナ;
    private RString 住所漢字;
    private RString 金額;

}
