package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 施設情報共有子Divと使用者とのインタフェースです。
 *
 * @author N8187 久保田 英男
 */
public interface IShisetsuJohoDiv {

    /**
     * 利用機能を設定します。
     *
     * @param 利用機能 利用機能
     */
    void set利用機能(int 利用機能);

    /**
     * 台帳種別を設定します。
     *
     * @param 台帳種別キー 台帳種別キー
     */
    void set台帳種別(RString 台帳種別キー);

    /**
     * 施設種類を設定します。
     *
     * @param 施設種類キー 施設種類キー
     */
    void set施設種類(RString 施設種類キー);

    /**
     * 入所施設コードを設定します。
     *
     * @param 入所施設コード 入所施設コード
     */
    void set入所施設コード(RString 入所施設コード);

    /**
     * 施設名称を設定します。
     *
     * @param 施設名称 施設名称
     */
    void set施設名称(RString 施設名称);

    /**
     * 台帳種別を返します。
     *
     * @return 台帳種別
     */
    Optional<DaichoType> get台帳種別();

    /**
     * 施設種類を返します。
     *
     * @return 施設種類
     */
    ShisetsuType get施設種類();

    /**
     * 入所施設コードを返します。
     *
     * @return 入所施設コード
     */
    ShisetsuCode get入所施設コード();

    /**
     * 施設名称を返します。
     *
     * @return 施設名称
     */
    RString get施設名称();

    /**
     * 施設情報共有子Divを入力可の状態にします。
     */
    void set入力可();

    /**
     * 施設情報共有子Divを入力不可の状態にします。
     */
    void set入力不可();

    /**
     * 共有子Divの初期化を行います。<br />
     * 利用機能モードの設定を元に初期化します。
     */
    void initialize();

    /**
     * この共有子Divに設定されたデータをクリアします。
     */
    void clear();
}
