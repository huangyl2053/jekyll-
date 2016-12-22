/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;

/**
 * 一次判定処理結果により生成された{@link IchijiHanteiKekkaJoho}を保持します。
 * また、一次判定処理がエラーしている場合は、エラーしていることを示すフラグも保持します。
 *
 * @author n8178
 */
public class IchijiHanteiShoriKekka {

    private final ShinseishoKanriNo shinseishoKanriNo;
    private final IchijiHanteiKekkaJoho hanteiKekka;
    private final boolean isError;

    /**
     * コンストラクタ
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @param hanteiKekka 一次判定結果
     * @param isError エラーしたか否か。
     */
    public IchijiHanteiShoriKekka(ShinseishoKanriNo shinseishoKanriNo, IchijiHanteiKekkaJoho hanteiKekka, boolean isError) {
        this.shinseishoKanriNo = shinseishoKanriNo;
        this.hanteiKekka = hanteiKekka;
        this.isError = isError;
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return shinseishoKanriNo;
    }

    /**
     * 一次判定結果情報を返します。{@link isError()}の結果が{@code true}の場合、データが正しく設定されていないオブジェクトが返ります。
     *
     * @return 一次判定結果情報
     */
    public IchijiHanteiKekkaJoho getHanteiKekka() {
        return hanteiKekka;
    }

    /**
     * 一次判定結果がエラーだったか否かを返します。
     *
     * @return エラーしていたなら、{@code true}が返る。
     */
    public boolean isError() {
        return isError;
    }

}
