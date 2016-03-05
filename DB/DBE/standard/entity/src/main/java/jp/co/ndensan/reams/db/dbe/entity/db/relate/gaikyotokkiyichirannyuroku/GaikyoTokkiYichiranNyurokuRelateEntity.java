/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiyichirannyuroku;

import java.io.Serializable;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項入力情報作成RelateEntityクラスです。
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class GaikyoTokkiYichiranNyurokuRelateEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private RString temp_レコードNO;
    private RString temp_認定調査特記事項番号;
    private RString temp_認定調査特記事項連番;
    private RString temp_特記事項テキストイメージ区分;
    private RString temp_原本マスク区分;
    private RString temp_特記事項;
    private RString temp_特記事項イメージ共有ファイルID;
    private RString temp_特記事項名称;
    private RString temp_新規区分;
    private RString temp_編集区分;

    /**
     * コンストラクタです。
     *
     * @param temp_レコードNO temp_レコードNO
     * @param temp_認定調査特記事項番号 temp_認定調査特記事項番号
     * @param temp_認定調査特記事項連番 temp_認定調査特記事項連番
     * @param temp_特記事項テキストイメージ区分 temp_特記事項テキストイメージ区分
     * @param temp_原本マスク区分 temp_原本マスク区分
     * @param temp_特記事項 temp_特記事項
     * @param temp_特記事項イメージ共有ファイルID temp_特記事項イメージ共有ファイルID
     * @param temp_特記事項名称 temp_特記事項名称
     * @param temp_新規区分 temp_新規区分
     * @param temp_編集区分 temp_編集区分
     */
    public GaikyoTokkiYichiranNyurokuRelateEntity(
            RString temp_レコードNO,
            RString temp_認定調査特記事項番号,
            RString temp_認定調査特記事項連番,
            RString temp_特記事項テキストイメージ区分,
            RString temp_原本マスク区分,
            RString temp_特記事項,
            RString temp_特記事項イメージ共有ファイルID,
            RString temp_特記事項名称,
            RString temp_新規区分,
            RString temp_編集区分) {
        this.temp_レコードNO = temp_レコードNO;
        this.temp_認定調査特記事項番号 = temp_認定調査特記事項番号;
        this.temp_認定調査特記事項連番 = temp_認定調査特記事項連番;
        this.temp_特記事項テキストイメージ区分 = temp_特記事項テキストイメージ区分;
        this.temp_原本マスク区分 = temp_原本マスク区分;
        this.temp_特記事項 = temp_特記事項;
        this.temp_特記事項イメージ共有ファイルID = temp_特記事項イメージ共有ファイルID;
        this.temp_特記事項名称 = temp_特記事項名称;
        this.temp_新規区分 = temp_新規区分;
        this.temp_編集区分 = temp_編集区分;
    }
}
