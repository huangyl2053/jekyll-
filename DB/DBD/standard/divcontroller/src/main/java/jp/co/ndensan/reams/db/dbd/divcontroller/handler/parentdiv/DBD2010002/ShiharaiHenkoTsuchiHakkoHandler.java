/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD2010002;

import java.util.ArrayList;
import jp.co.ndensan.reams.db.dbd.business.core.shiharaihohohenko.ShiharaiHohoHenko;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenko.ShiharaiHohoHenkoService;
import jp.co.ndensan.reams.db.dbd.service.core.shiharaihohohenkotsuchishohakko.Shiharaihohohenkotsuchisho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 *
 * 支払方法変更管理各種通知書発行のHandlerクラスです。
 *
 * @reamsid_L DBD-3640-010 panxiaobo
 */
public class ShiharaiHenkoTsuchiHakkoHandler {

    public ArrayList<ShiharaiHohoHenko> get支払方法変更の情報(HihokenshaNo 被保険者番号) {
        ShiharaiHohoHenkoService service = ShiharaiHohoHenkoService.createIntance();
        ArrayList<ShiharaiHohoHenko> shiharaiHohoHenkoList = service.find支払方法変更(被保険者番号);
        return shiharaiHohoHenkoList;
    }

    /**
     * アクセスログの記録処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void setアクセスログ(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        Shiharaihohohenkotsuchisho tsuchisho = Shiharaihohohenkotsuchisho.createInstance();
        tsuchisho.setAccessLogger(被保険者番号, 識別コード);
    }

    /**
     * 支払方法変更管理各種通知書発行のenumクラスです。
     */
    public enum ShiharaiHenkoTsuchiHakkoEnum {

        /**
         * リストキー
         */
        リストキー;
    }
}
