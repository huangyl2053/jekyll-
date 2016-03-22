/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.gemmengengaku;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.JigyoshaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.enumeratedtype.ShinseiTodokedeDaikoKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 減免減額申請情報エンティティです。
 */
@lombok.Getter
public class ShinseiJoho {

    private final ShinseiTodokedeDaikoKubunCode 申請届出代行区分;
    private final AtenaMeisho 申請届出者氏名;
    private final AtenaKanaMeisho 申請届出者氏名カナ;
    private final RString 申請届出者続柄;
    private final JigyoshaNo 申請届出代行事業者番号;
    private final JigyoshaKubun 事業者区分;
    private final YubinNo 申請届出者郵便番号;
    private final AtenaJusho 申請届出者住所;
    private final TelNo 申請届出者電話番号;

    /**
     * コンストラクタです。
     *
     * @param 申請届出代行区分 申請届出代行区分
     * @param 申請届出者氏名 申請届出者氏名
     * @param 申請届出者氏名カナ 申請届出者氏名カナ
     * @param 申請届出者続柄 申請届出者続柄
     * @param 申請届出代行事業者番号 申請届出代行事業者番号
     * @param 事業者区分 事業者区分
     * @param 申請届出者郵便番号 申請届出者郵便番号
     * @param 申請届出者住所 申請届出者住所
     * @param 申請届出者電話番号 申請届出者電話番号
     */
    public ShinseiJoho(ShinseiTodokedeDaikoKubunCode 申請届出代行区分, AtenaMeisho 申請届出者氏名,
            AtenaKanaMeisho 申請届出者氏名カナ, RString 申請届出者続柄,
            JigyoshaNo 申請届出代行事業者番号, JigyoshaKubun 事業者区分,
            YubinNo 申請届出者郵便番号, AtenaJusho 申請届出者住所,
            TelNo 申請届出者電話番号) {

        this.申請届出代行区分 = 申請届出代行区分;
        this.申請届出者氏名 = 申請届出者氏名;
        this.申請届出者氏名カナ = 申請届出者氏名カナ;
        this.申請届出者続柄 = 申請届出者続柄;
        this.申請届出代行事業者番号 = 申請届出代行事業者番号;
        this.事業者区分 = 事業者区分;
        this.申請届出者郵便番号 = 申請届出者郵便番号;
        this.申請届出者住所 = 申請届出者住所;
        this.申請届出者電話番号 = 申請届出者電話番号;

    }

}
