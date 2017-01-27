package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.IchijiHanteiKekkaJoho.IchijiHanteiKekkaJoho;

import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichijihanteikekkajoho.IchijiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.IDialogDiv;

/*
 * このコードはツールによって生成されました。
 */
public interface IIchijiHanteiKekkaJohoDiv extends ICommonChildDivBaseProperties, IDialogDiv {

    /**
     * 共通子DIVを初期化します。 ここでの初期化は、ダイアログではなく親画面に直接配置された場合を想定しています。
     *
     * @param shinseishoKanriNo 申請書管理番号
     */
    void initialize(ShinseishoKanriNo shinseishoKanriNo);

    /**
     * 一次判定結果をシリアライズした文字列を返します。判定前後の値を比較する等、判定前の情報を保持しておきたい場合に使用します。
     *
     * @return 一次判定結果をシリアライズした文字列
     */
    RString get一次判定結果文字列();

    /**
     * 一次判定結果を返します。一次判定結果が正しく取得できない場合はnullが返ります。
     *
     * @return 一次判定結果
     */
    IchijiHanteiKekkaJoho get一次判定結果();

    /**
     * 一次判定結果をリセットします。
     */
    void clear一次判定結果();
}
