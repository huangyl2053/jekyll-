/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.controller;

import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.YamlLoader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画作成依頼届出情報登録の個人検索条件のコントロールです。
 *
 * @author N8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeSearch {

    private List<HashMap> getYaml() {
        return YamlLoader.FOR_DBC.loadAsList(new RString("dbc0100000/KyotakuKeikakuTodokedeSearch.yml"));
    }
}
