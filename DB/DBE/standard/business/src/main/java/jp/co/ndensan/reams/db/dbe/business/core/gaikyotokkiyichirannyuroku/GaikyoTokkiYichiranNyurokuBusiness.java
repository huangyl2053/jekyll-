/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.gaikyotokkiyichirannyuroku;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.gaikyotokkiyichirannyuroku.GaikyoTokkiYichiranNyurokuRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特記事項入力情報作成のクラスです。
 */
public class GaikyoTokkiYichiranNyurokuBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    private final GaikyoTokkiYichiranNyurokuRelateEntity gaikyoTokkiYichiranNyurokuRelateEntity;

    /**
     * コンストラクタです。<br/>
     *
     */
    public GaikyoTokkiYichiranNyurokuBusiness() {
        this.gaikyoTokkiYichiranNyurokuRelateEntity = new GaikyoTokkiYichiranNyurokuRelateEntity(
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    /**
     * コンストラクタです。<br/>
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
    public GaikyoTokkiYichiranNyurokuBusiness(
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
        this.gaikyoTokkiYichiranNyurokuRelateEntity = new GaikyoTokkiYichiranNyurokuRelateEntity(
                temp_レコードNO,
                temp_認定調査特記事項番号,
                temp_認定調査特記事項連番,
                temp_特記事項テキストイメージ区分,
                temp_原本マスク区分,
                temp_特記事項,
                temp_特記事項イメージ共有ファイルID,
                temp_特記事項名称,
                temp_新規区分,
                temp_編集区分);
    }

    /**
     * 特記事項入力情報作成のエンティティ返します。
     *
     * @return 特記事項入力情報作成ののエンティティ
     */
    public GaikyoTokkiYichiranNyurokuRelateEntity getGaikyoTokkiYichiranNyurokuRelateEntity() {
        return gaikyoTokkiYichiranNyurokuRelateEntity;
    }

    /**
     * temp_レコードNOを返します。
     *
     * @return temp_レコードNO
     */
    public RString getTemp_レコードNO() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_レコードNO();
    }

    /**
     * temp_認定調査特記事項番号を返します。
     *
     * @return temp_認定調査特記事項番号
     */
    public RString getTemp_認定調査特記事項番号() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_認定調査特記事項番号();
    }

    /**
     * temp_認定調査特記事項連番を返します。
     *
     * @return temp_認定調査特記事項連番
     */
    public RString getTemp_認定調査特記事項連番() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_認定調査特記事項連番();
    }

    /**
     * temp_特記事項テキストイメージ区分を返します。
     *
     * @return temp_特記事項テキストイメージ区分
     */
    public RString getTemp_特記事項テキストイメージ区分() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_特記事項テキストイメージ区分();
    }

    /**
     * temp_原本マスク区分を返します。
     *
     * @return temp_原本マスク区分
     */
    public RString getTemp_原本マスク区分() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_原本マスク区分();
    }

    /**
     * temp_特記事項を返します。
     *
     * @return temp_特記事項
     */
    public RString getTemp_特記事項() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_特記事項();
    }

    /**
     * temp_特記事項イメージ共有ファイルIDを返します。
     *
     * @return temp_特記事項イメージ共有ファイルID
     */
    public RString getTemp_特記事項イメージ共有ファイルID() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_特記事項イメージ共有ファイルID();
    }

    /**
     * temp_特記事項名称を返します。
     *
     * @return temp_特記事項名称
     */
    public RString getTemp_特記事項名称() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_特記事項名称();
    }

    /**
     * temp_新規区分を返します。
     *
     * @return temp_新規区分
     */
    public RString getTemp_新規区分() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_新規区分();
    }

    /**
     * temp_編集区分を返します。
     *
     * @return temp_編集区分
     */
    public RString getTemp_編集区分() {
        return gaikyoTokkiYichiranNyurokuRelateEntity.getTemp_編集区分();
    }
}
