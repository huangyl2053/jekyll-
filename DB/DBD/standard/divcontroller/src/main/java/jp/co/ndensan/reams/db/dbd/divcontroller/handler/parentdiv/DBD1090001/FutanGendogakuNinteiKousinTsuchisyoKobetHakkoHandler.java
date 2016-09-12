/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD1090001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.futangendogakunintei.FutanGendogakuNintei;
import jp.co.ndensan.reams.db.dbd.definition.mybatisprm.relate.futangendogakunintei.FutanGendogakuNinteiParameter;
import jp.co.ndensan.reams.db.dbd.service.core.futangendogakunintei.FutanGendogakuNinteiKanshoTsuchisho;
import jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.futangendogakunintei.FutanGendogakuNinteiManager;
import jp.co.ndensan.reams.db.dbx.definition.core.gemmengengaku.GemmenGengakuShurui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;

/**
 * 負担限度額認定更新のお知らせ通知書個別発行のHandlerクラスです。
 *
 * @reamsid_L DBD-3570-010 wangchao
 */
public class FutanGendogakuNinteiKousinTsuchisyoKobetHakkoHandler {

    /**
     * 業務概念「介護負担限度額認定の情報」を取得する
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @return 介護負担限度額認定の情報
     */
    public ArrayList<FutanGendogakuNintei> get介護負担限度額認定(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {

        // 業務概念「介護負担限度額認定の情報」を取得する
        FutanGendogakuNinteiManager futanGendogakuNinteiManager = FutanGendogakuNinteiManager.createInstance();
        FutanGendogakuNinteiParameter parameter
                = FutanGendogakuNinteiParameter.createSelectParam(GemmenGengakuShurui.負担限度額認定.getコード(), 被保険者番号);
        ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List = futanGendogakuNinteiManager.get負担限度額認定画面用リスト(parameter);
        compareTo(介護保険負担限度額認定List);
        return 介護保険負担限度額認定List;
    }

    /**
     * 介護保険負担限度額認定Listをsort
     *
     * @param 介護保険負担限度額認定List 介護保険負担限度額認定List
     */
    public static void compareTo(ArrayList<FutanGendogakuNintei> 介護保険負担限度額認定List) {
        Collections.sort(介護保険負担限度額認定List, new Comparator<FutanGendogakuNintei>() {
            @Override
            public int compare(FutanGendogakuNintei o1, FutanGendogakuNintei o2) {
                return o2.get履歴番号() - o1.get履歴番号();
            }
        });
    }

    /**
     * アクセスログの記録処理です。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     */
    public void setアクセスログ(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード) {
        FutanGendogakuNinteiKanshoTsuchisho tsuchisho = FutanGendogakuNinteiKanshoTsuchisho.createInstance();
        tsuchisho.setAccessLogger(被保険者番号, 識別コード);
    }

    /**
     * 介護保険負担限度額認定のenumクラスです。
     */
    public enum KgHoukenFutanGendogakuNintei {

        /**
         * リストキー
         */
        リストキー;
    }
}
