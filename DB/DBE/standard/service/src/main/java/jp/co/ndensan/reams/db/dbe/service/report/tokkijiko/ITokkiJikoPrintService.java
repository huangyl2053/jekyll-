/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.report.tokkijiko;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.NinteichosaRelate;
import jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteijohoteikyo.YokaigoNinteiJohoTeikyoBusiness;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項のPrinterのインターフェースです。
 *
 * @author N3212 竹内 和紀
 */
public interface ITokkiJikoPrintService {

    /**
     * 特記事項を印刷します。
     *
     * @param business YokaigoNinteiJohoTeikyoBusiness
     * @param 特記事項List 特記事項List
     * @param 特記事項マスキング区分 特記事項マスキング区分
     * @param イメージ共有ファイルID イメージ共有ファイルID
     */
    void print(YokaigoNinteiJohoTeikyoBusiness business, List<NinteichosaRelate> 特記事項List,
            RString 特記事項マスキング区分, RDateTime イメージ共有ファイルID);
}
