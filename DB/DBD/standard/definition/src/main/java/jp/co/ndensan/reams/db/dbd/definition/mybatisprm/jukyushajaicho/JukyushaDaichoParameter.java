/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.definition.mybatisprm.jukyushajaicho;

import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定取消通知書のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBD-1440-010 liuyl
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaDaichoParameter {

    private final LasdecCode 市町村コード;
    private final RString 被保険者番号;
    private final RString 証記載保険者番号;

    /**
     * コンストラクタです。
     *
     * @param 市町村コード LasdecCode
     * @param 被保険者番号 RString
     * @param 証記載保険者番号 RString
     */
    public JukyushaDaichoParameter(LasdecCode 市町村コード, RString 被保険者番号, RString 証記載保険者番号) {
        this.市町村コード = 市町村コード;
        this.被保険者番号 = 被保険者番号;
        this.証記載保険者番号 = 証記載保険者番号;
    }
}
