package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kaigoatenainfo;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/**
 * 介護宛名基本情報Divのインターフェースです。
 */
public interface IKaigoAtenaInfoDiv extends ICommonChildDivBaseProperties {

    /**
     * 検索キーを元にデータを取得し、Divに設定します。
     *
     * @param 識別コード 識別コード
     */
    void load(ShikibetsuCode 識別コード);

    /**
     * 介護宛名資格モードに設定します。
     */
    void set介護宛名資格モード();

    /**
     * 介護宛名賦課モードに設定します。
     */
    void set介護宛名賦課モード();
}
