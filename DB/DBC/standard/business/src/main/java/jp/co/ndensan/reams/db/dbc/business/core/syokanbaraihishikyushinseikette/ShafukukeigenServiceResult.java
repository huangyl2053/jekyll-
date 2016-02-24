/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.core.syokanbaraihishikyushinseikette;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社福軽減額サービス種類一覧のオブジェクトクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShafukukeigenServiceResult {

    private ServiceShuruiCode serviceShuruiCode;
    private RString serviceShuruiMeisho;
    private int riyoshaFutangaku;

    /**
     * コンストラクタです。
     */
    public ShafukukeigenServiceResult() {
        this.serviceShuruiCode = null;
        this.serviceShuruiMeisho = null;
        this.riyoshaFutangaku = 0;
    }
}
