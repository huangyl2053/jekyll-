/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.shichoson;

import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 出力帳票entity ShichosonEntity
 *
 * @reamsid_L DBB-1690-040 sunhui
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShichosonEntity {

    private RString 市町村コード;
    private RString 市町村名称;
    private RString 処理状態;
    private FlexibleDate 処理日時;

    /**
     * コンストラクタです
     *
     * @param 市町村コード RString
     * @param 市町村名称 RString
     * @param 処理状態 RString
     * @param 処理日時 FlexibleDate
     */
    public ShichosonEntity(RString 市町村コード, RString 市町村名称, RString 処理状態, FlexibleDate 処理日時) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.処理状態 = 処理状態;
        this.処理日時 = 処理日時;
    }
}
