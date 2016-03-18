/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.kaigoninteishinsakai;

import java.io.Serializable;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 開催番号一覧のパラメータです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoNinteiShinsakaiParameter implements Serializable {

    private final List<RString> kaisaiNoList;

    /**
     * コンストラクタです。
     *
     * @param kaisaiNoList 開催番号List
     */
    public KaigoNinteiShinsakaiParameter(List<RString> kaisaiNoList) {
        this.kaisaiNoList = kaisaiNoList;
    }
}
