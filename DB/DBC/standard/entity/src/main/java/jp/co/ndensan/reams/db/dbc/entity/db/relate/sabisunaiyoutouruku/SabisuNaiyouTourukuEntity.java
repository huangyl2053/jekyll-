/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.sabisunaiyoutouruku;

import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7131KaigoServiceNaiyouEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 画面設計_DBC4000011_サービス内容登録
 *
 * @reamsid_L DBC-3320-010 chenhui
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class SabisuNaiyouTourukuEntity {

    private DbT7131KaigoServiceNaiyouEntity 介護サービス内容;
    private RString サービス分類コード;
    private RString サービス小分類;

    /**
     * MyBatisで取得された場合に使用して下さい。<br/>
     * MyBatisで当クラス取得時は、新規追加(Added)となるため、変更無し(Unchanged)に設定します。<br/>
     */
    public void initializeMd5ToEntity() {
        this.介護サービス内容.initializeMd5();
    }
}
