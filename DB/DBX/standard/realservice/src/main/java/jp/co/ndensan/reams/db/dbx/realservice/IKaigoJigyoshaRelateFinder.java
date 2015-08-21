/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.realservice;

import jp.co.ndensan.reams.db.dbx.business.KaigoJigyosha;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;

/**
 * 介護事業者関連情報を取得するインタフェースです。
 *
 * @author N8187 久保田 英男
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public interface IKaigoJigyoshaRelateFinder {

    /**
     * 事業者番号に合致する最新の介護事業者関連情報を返します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @return KaigoJigyosha
     */
    KaigoJigyosha findLatestJigyosha(KaigoJigyoshaNo 事業者番号);
}
