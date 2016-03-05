/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.kihonchosainput;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 認定調査基本情報Entityです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KihonChosaInputEntity {

    private Code 認知症高齢者自立度;
    private Code 障害高齢者自立度;
    private int 調査連番;
    private RString 調査項目;
    private Code 前回認知症高齢者自立度;
    private Code 前回障害高齢者自立度;
    private int 前回調査連番;
    private RString 前回調査項目;
    private RString 認定調査特記事項番号;
    private int 認定調査特記事項連番;
    private Code 原本マスク区分;
    private RString 特記事項;

}
