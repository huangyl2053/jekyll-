/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiyichirannyuroku;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査項目と認定調査特記事項番号のマッピングEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ChosaKoumokuAndTokkiBangoMappingEntity {

    private RString 認定調査特記事項番号;
    private RString 画面表示用特記事項項番;
    private RString 認定調査項目;

    /**
     * コンストラクタです。
     *
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 画面表示用特記事項項番 画面表示用特記事項項番
     * @param 認定調査項目 認定調査項目
     */
    public ChosaKoumokuAndTokkiBangoMappingEntity(
            RString 認定調査特記事項番号,
            RString 画面表示用特記事項項番,
            RString 認定調査項目) {
        this.認定調査特記事項番号 = 認定調査特記事項番号;
        this.画面表示用特記事項項番 = 画面表示用特記事項項番;
        this.認定調査項目 = 認定調査項目;
    }
}
