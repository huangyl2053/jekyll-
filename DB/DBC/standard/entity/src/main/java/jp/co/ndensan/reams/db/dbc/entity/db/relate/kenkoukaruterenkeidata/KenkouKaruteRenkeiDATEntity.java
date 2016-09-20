/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.kenkoukaruterenkeidata;

import jp.co.ndensan.reams.uz.uza.io.fld.FldField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 健康かるて連携データ作成のDATEntityです。
 *
 * @reamsid_L DBC-5020-030 wangxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KenkouKaruteRenkeiDATEntity {

    @FldField(order = 10, length = 12)
    private RString 個人番号;
    @FldField(order = 20, length = 70)
    private RString 漢字氏名_カナ氏名;
    @FldField(order = 30, length = 8)
    private RString 生年月日;
    @FldField(order = 40, length = 1)
    private RString 性別;
    @FldField(order = 50, length = 15)
    private RString 被保険者番号;
    @FldField(order = 60, length = 8)
    private RString 資格取得日;
    @FldField(order = 70, length = 8)
    private RString 資格喪失日;
    @FldField(order = 80, length = 2)
    private RString 要介護状態区分;
    @FldField(order = 90, length = 7)
    private RString 減額認定証受給者番号;
    @FldField(order = 100, length = 8)
    private RString 認定年月日;
    @FldField(order = 110, length = 8)
    private RString 認定有効期間開始日;
    @FldField(order = 120, length = 8)
    private RString 認定有効期間終了日;
    @FldField(order = 130, length = 33)
    private RString 終了日と作成日区切り文字;
    @FldField(order = 140, length = 8)
    private RString 作成日;

}
